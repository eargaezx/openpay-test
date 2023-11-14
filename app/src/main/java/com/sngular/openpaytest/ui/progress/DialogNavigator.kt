package com.sngular.openpaytest.ui.progress

import androidx.fragment.app.FragmentManager

class DialogNavigator(private val fragmentManager: FragmentManager) {
    fun showDialog(tag: String) {
        if (fragmentManager.isFragmentNotExist(tag)) {
            ProgressDialogFragment().show(fragmentManager, tag)
        }
    }

    fun hideDialog(tag: String) {
        val fragment = fragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            fragmentManager.beginTransaction().remove(fragment).commit()
        }
    }

    private fun FragmentManager.isFragmentNotExist(tag: String) = findFragmentByTag(tag) == null
}