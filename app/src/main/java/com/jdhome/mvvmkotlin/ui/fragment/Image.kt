package com.jdhome.mvvmkotlin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jdhome.mvvmkotlin.R

class Image : Fragment() {

    companion object {
        fun newInstance() = Image()
    }

   // private lateinit var viewModel: ImageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.image_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       // viewModel = ViewModelProviders.of(this).get(ImageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
