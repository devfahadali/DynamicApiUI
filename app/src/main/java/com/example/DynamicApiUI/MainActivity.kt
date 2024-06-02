package com.example.DynamicApiUI

import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.base.activity.BaseActivity
import com.example.base.utlisExtension.setFilledDrawable
import com.example.base.utlisExtension.visible
import com.example.DynamicApiUI.adapter.GenericFormAdapter
import com.example.DynamicApiUI.databinding.ActivityMainBinding
import com.example.DynamicApiUI.viewmodel.GenericViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val genericViewModel: GenericViewModel by viewModel()
    private lateinit var adapter: GenericFormAdapter
    override fun initView() {

        statusBarSet()
        backgrounds()
        addAdapter()

        //api call
        genericViewModel.getProductListM(48, 198, 1)

    }

    private fun statusBarSet() {
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.viewBackGround)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun backgrounds() {
        binding.userLayout.setFilledDrawable("white", "_8sdp")
    }

    private fun addAdapter() {
        binding.rvItem.layoutManager = LinearLayoutManager(this)
        adapter = GenericFormAdapter()
        binding.rvItem.adapter = adapter
        setupDataObserve()
    }


    private fun setupDataObserve() {

        genericViewModel.genericData.observer {
            if (it.isNotEmpty() && it[0].message.isEmpty()){
                binding.progressBar.visible(false)
                binding.backTitle.text= it[0].sectionTitle
                adapter.submitList(it)
            }else{
                binding.progressBar.visible(false)
                binding.txtErrorShow.visible(true)
                binding.txtErrorShow.text= it[0].message
                Toast.makeText(this, it[0].message, Toast.LENGTH_SHORT).show()
            }


        }
    }

}
