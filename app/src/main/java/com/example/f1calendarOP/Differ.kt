package com.example.f1calendarOP

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil

    val diffCallback = object : DiffUtil.ItemCallback<Race>(){
        override fun areItemsTheSame(oldItem: Race, newItem: Race): Boolean {
            return oldItem.round == newItem.round
        }
        override fun areContentsTheSame(oldItem: Race, newItem: Race): Boolean {
            return oldItem == newItem
        }
    }

