package com.example.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 26/04/2024
 */
abstract class BaseFragment<B:ViewBinding>(val bindingFactory :(LayoutInflater,ViewGroup?, Boolean)->B ): Fragment() {


    lateinit var binding : B
    lateinit var mInflater: LayoutInflater

    open fun enableBackPress():Boolean =true

    abstract  fun onViewCreate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBackPress()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mInflater = inflater
        binding =  bindingFactory(inflater,container,false)

        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreate()
    }

   protected open  fun registerBackPress(){
        val callBack:OnBackPressedCallback = object : OnBackPressedCallback(enableBackPress()){
            override fun handleOnBackPressed() {
                backPress()
            }
        }
       requireActivity().onBackPressedDispatcher.addCallback(this,callBack)
    }

    open  fun backPress(){
        findNavController().popBackStack()
    }

    fun <T> LiveData<T>.observer(onChanged: (T)->Unit){
        observe(this@BaseFragment,onChanged)
    }

}