package com.example.DynamicApiUI.adapter.viewholder

import android.R
import android.content.Context
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.base.adapter.viewholder.BaseViewHolder
import com.example.base.utlisExtension.setFilledDrawable
import com.example.domain.models.UiQuestionData
import com.example.DynamicApiUI.databinding.LayoutTextviewAndSpinnerBinding

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 18/05/2024
 */

class GenericFromViewHolder(val binding: LayoutTextviewAndSpinnerBinding):BaseViewHolder<LayoutTextviewAndSpinnerBinding,UiQuestionData>(binding) {
    override fun bind(uiQuestionData: UiQuestionData, position: Int) {
       binding.questionText.text = uiQuestionData.questionText

        val optionsAdapter = ArrayAdapter<String>(
            itemView.context,
            R.layout.simple_spinner_item,
            uiQuestionData.options.map { it }
        )

        binding.followUpEditText.setFilledDrawable("white", "_8sdp")

        binding.answerSpinner.adapter = optionsAdapter
        if (position == 0) {
            binding.answerSpinner.visibility = View.VISIBLE
        }

        binding.itemQuestionText.text= uiQuestionData.questionTextSectionField

        binding.followUpEditText.hint= uiQuestionData.questionTextSectionField

       binding.answerSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedOption = uiQuestionData.options[position]
                binding.followUpEditText.visibility = if (selectedOption == "Yes") View.VISIBLE else View.GONE
                binding.itemQuestionText.visibility = if (selectedOption == "Yes") View.VISIBLE else View.GONE
                if (selectedOption!="Yes" && selectedOption!="Select Option"){
                    if (adapterPosition  < uiQuestionData.options.size+1) {

                        val nextQuestionHolder = (itemView.parent as RecyclerView)
                            .findViewHolderForAdapterPosition(adapterPosition + 1) as GenericFromViewHolder?
                        nextQuestionHolder?.binding?.answerSpinner?.visibility = View.VISIBLE

                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                binding.followUpEditText.visibility = View.GONE
            }
        }

      binding.followUpEditText.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (adapterPosition  < uiQuestionData.options.size+1) {
                    val nextQuestionHolder = (itemView.parent as RecyclerView)
                        .findViewHolderForAdapterPosition(adapterPosition + 1) as GenericFromViewHolder?
                    nextQuestionHolder?.binding?.answerSpinner?.visibility = View.VISIBLE
                }

                // Hide the keyboard
                val imm = itemView.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.followUpEditText.windowToken, 0)

                binding.followUpEditText.clearFocus()
                true
            } else {
                false
            }
        }
    }
}