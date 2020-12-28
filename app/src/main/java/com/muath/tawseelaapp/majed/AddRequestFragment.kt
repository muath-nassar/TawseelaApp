package com.muath.tawseelaapp.majed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.muath.tawseelaapp.R


class AddRequestFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val root =inflater.inflate(R.layout.fragment_add_request, container, false)

        return root
    }

}