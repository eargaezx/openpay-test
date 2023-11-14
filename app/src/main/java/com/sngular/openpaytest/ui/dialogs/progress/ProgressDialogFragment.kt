package com.sngular.openpaytest.ui.dialogs.progress

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.sngular.openpaytest.R
import com.sngular.openpaytest.databinding.FragmentDialogProgressBinding
import com.sngular.openpaytest.ui.utils.viewBinding

class ProgressDialogFragment : DialogFragment(R.layout.fragment_dialog_progress) {

    private val viewModel by viewModels<ProgressDialogViewModel>()
    private val binding by viewBinding(FragmentDialogProgressBinding::bind)


}