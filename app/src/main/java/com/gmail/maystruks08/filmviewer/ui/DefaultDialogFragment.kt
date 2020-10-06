package com.gmail.maystruks08.filmviewer.ui

import android.app.Dialog
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.gmail.maystruks08.filmviewer.R
import com.gmail.maystruks08.filmviewer.core.base.BaseDialogFragment
import com.gmail.maystruks08.filmviewer.core.ext.argument
import kotlinx.android.synthetic.main.dialog_success.*


class DefaultDialogFragment : BaseDialogFragment() {

    private var message: String by argument()

    override val viewResource: Int = R.layout.dialog_success
    override val dialogWidth: Int = R.dimen.dialog_width
    override val dialogHeight: Int = R.dimen.dialog_height

    override fun injectDependencies(): Unit? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(), R.color.fui_transparent))
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        return dialog
    }

    override fun initViews() {
        tvAlertText.text = message
        buttonOk.setOnClickListener { dismiss() }
        view?.postDelayed({ dismiss() }, 3000L)
    }

    companion object {

        fun getInstance(message: String) = DefaultDialogFragment().apply {
            this.message = message
        }
    }
}