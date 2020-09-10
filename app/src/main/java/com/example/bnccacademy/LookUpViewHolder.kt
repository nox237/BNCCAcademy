package com.example.bnccacademy

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_look_up.view.*

class LookUpViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(data: LookUpData) {
        itemView.tvLookUpProvinceName.text = data.provinceName
        itemView.tvLookUpConfirmedCase.text = "${data.numberOfPositiveCases}"
        itemView.tvLookUpRecoveredCase.text = "${data.numberOfRecoveredCases}"
        itemView.tvLookUpDeathCase.text = "${data.numberOfDeathCases}"
    }
}