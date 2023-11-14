package com.sngular.openpaytest.ui.locations

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sngular.domain.model.UserLocation
import com.sngular.domain.state.Result
import com.sngular.openpaytest.R
import com.sngular.openpaytest.databinding.FragmentLocationsBinding
import com.sngular.openpaytest.ui.dialogs.DialogNavigator
import com.sngular.openpaytest.ui.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PeopleLocationFragment : Fragment(R.layout.fragment_locations), OnMapReadyCallback {
    private val dialogNavigator: DialogNavigator by lazy { DialogNavigator(childFragmentManager) }

    private val binding by viewBinding(FragmentLocationsBinding::bind)
    private val viewModel by viewModels<PeopleLocationsViewModel>()

    private lateinit var googleMap: GoogleMap


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI(){
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun setupObserver(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.locations.collect(::onCollected)
        }
    }

    private fun onCollected(result: Result<List<UserLocation>>){
        when(result){
            is Result.Loading -> {
                //empty loading
            }
            is Result.Success -> {
                result.data?.map { location ->
                    googleMap.addMarker(MarkerOptions()
                        .position(LatLng(location.latitude, location.longitude))
                        .title(location.createdAt.toDate().toString()))

                }
                result.data?.last()?.let {
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                        LatLng(it.latitude, it.longitude), 13F
                    ))
                }
            }
            is Result.Error -> {
                dialogNavigator.hideLoading(tag!!)
                dialogNavigator.showException(result.message!!)
            }
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        setupObserver()
    }
}