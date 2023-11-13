package com.sngular.openpaytest.ui.locations

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PeopleLocationFragment : Fragment(), OnMapReadyCallback {

    private var _binding: FragmentLocationsBinding? = null
    private val binding get() = _binding!!
    private var viewModel: PeopleLocationsViewModel? = null


    private lateinit var googleMap: GoogleMap
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =  ViewModelProvider(this).get(PeopleLocationsViewModel::class.java)
        _binding = FragmentLocationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }


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
            viewModel?.locations?.collect(::onCollected)
        }
    }

    private fun onCollected(result: Result<List<UserLocation>>){
        when(result){
            is Result.Loading -> {

            }
            is Result.Success -> {
                result.data?.map { location ->
                    googleMap.addMarker(MarkerOptions()
                        .position(LatLng(location.latitude, location.longitude))
                        .title(location.createdAt.toDate().toString()))

                }
                result.data?.last {
                    return googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                        LatLng(it.latitude, it.longitude), 13F
                    ))
                }
            }
            is Result.Error -> {

            }
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map


        setupObserver()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}