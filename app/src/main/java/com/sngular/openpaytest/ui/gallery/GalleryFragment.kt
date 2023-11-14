package com.sngular.openpaytest.ui.gallery

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sngular.openpaytest.databinding.FragmentGalleryBinding
import com.sngular.openpaytest.ui.gallery.adapter.UserImagesAdapter
import dagger.hilt.android.AndroidEntryPoint
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.firebase.storage.StorageReference
import com.sngular.domain.model.UserImage
import com.sngular.domain.state.Result
import com.sngular.openpaytest.R
import com.sngular.openpaytest.ui.utils.viewBinding
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private val binding by viewBinding(FragmentGalleryBinding::bind)
    private val viewModel by viewModels<GalleryViewModel>()

    val adapter = UserImagesAdapter(
        onCancelClicked = { pos, item -> onRemoveImage(pos, item) }
    )


    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data
            if (resultCode == Activity.RESULT_OK) {
                val fileUri = data?.data!!
                adapter.pushItem(UserImage(""))
                viewModel.uploadMultipleFile(listOf(fileUri)) {}
            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                // binding.progressBar.hide()
            } else {
                //binding.progressBar.hide()
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        binding.images.layoutManager =
            GridLayoutManager(requireContext(), 3,  GridLayoutManager.VERTICAL, false)
        binding.images.adapter = adapter
        binding.images.itemAnimator = null
        binding.buttonAdd.setOnClickListener {
            ImagePicker.with(this)
                //.crop()
                .compress(1024)
                .createIntent { intent ->
                    startForProfileImageResult.launch(intent)
                }
        }
    }

    private fun setupObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uploadedImages.collect(::onCollected)
        }
    }

    private fun onCollected(result: Result<List<UserImage>>) {
        when (result) {
            is Result.Loading -> {

            }
            is Result.Success -> {
                result.data?.let {
                    adapter.updateList(it.toMutableList())
                }
            }
            is Result.Error -> {

            }
        }
    }

    private fun onRemoveImage(pos: Int, item: Uri) {
        adapter.removeItem(pos)
    }

}