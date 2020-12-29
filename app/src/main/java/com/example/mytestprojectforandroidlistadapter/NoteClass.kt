package com.example.mytestprojectforandroidlistadapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.note_fragment.view.*

class NoteClass : DialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.note_fragment, container, false)
        rootView.CancelButton.setOnClickListener{
            dismiss()
        }
        rootView.SubmitButton.setOnClickListener{
            (activity as MainActivity?)?.AddNote(rootView.NoteTextTitle.text.toString(), rootView.NoteTextDescription.text.toString())
            dismiss()
        }
        return rootView

    }

}