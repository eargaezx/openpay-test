package com.sngular.openpaytest.ui.dialogs

import androidx.fragment.app.FragmentManager
import com.sngular.openpaytest.ui.dialogs.exception.ExceptionDialogFragment
import com.sngular.openpaytest.ui.dialogs.progress.ProgressDialogFragment

class DialogNavigator(private val fragmentManager: FragmentManager) {
    companion object{
        private const val EXCEPTION_DIALOG_TAG = "EXCEPTION_DIALOG_TAG"
    }
    fun showLoading(tag: String) {
        if (fragmentManager.isFragmentNotExist(tag)) {
            ProgressDialogFragment().show(fragmentManager, tag)
        }
    }

    fun hideLoading(tag: String) {
        val fragment = fragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            fragmentManager.beginTransaction().remove(fragment).commit()
        }
    }


    fun showException(message: String) {
        if (fragmentManager.isFragmentNotExist(EXCEPTION_DIALOG_TAG)) {
            ExceptionDialogFragment.newInstance(message).show(fragmentManager, EXCEPTION_DIALOG_TAG)
        }
    }

    fun hideException(tag: String) {
        val fragment = fragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            fragmentManager.beginTransaction().remove(fragment).commit()
        }
    }

    private fun FragmentManager.isFragmentNotExist(tag: String) = findFragmentByTag(tag) == null
}