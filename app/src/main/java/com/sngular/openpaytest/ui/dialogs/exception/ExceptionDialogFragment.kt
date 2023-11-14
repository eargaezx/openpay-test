package com.sngular.openpaytest.ui.dialogs.exception

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.sngular.openpaytest.R
import com.sngular.openpaytest.databinding.FragmentDialogExceptionBinding
import com.sngular.openpaytest.ui.utils.viewBinding

class ExceptionDialogFragment : DialogFragment(R.layout.fragment_dialog_exception) {

    private val viewModel by viewModels<ExceptionDialogViewModel>()
    private val binding by viewBinding(FragmentDialogExceptionBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            val message = it.getString(MESSAGE_PARAM)
            binding.tvException.text= message
            binding.buttonDone.setOnClickListener {
                dismissAllowingStateLoss()
            }
        }
    }

    companion object{
        private const val MESSAGE_PARAM = "MESSAGE_PARAM"

        @JvmStatic fun newInstance(message: String) =
            ExceptionDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(MESSAGE_PARAM, message)
                }
            }
    }
}