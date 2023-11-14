package com.sngular.openpaytest.ui.progress

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.sngular.openpaytest.R
import com.sngular.openpaytest.databinding.FragmentProgressDialogBinding
import com.sngular.openpaytest.ui.utils.viewBinding

class ProgressDialogFragment : DialogFragment(R.layout.fragment_progress_dialog) {

    private val viewModel by viewModels<ProgressDialogViewModel>()
    private val binding by viewBinding(FragmentProgressDialogBinding::bind)


}