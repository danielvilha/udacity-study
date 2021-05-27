package com.danielvilha.devbytes.ui.adapter

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.danielvilha.devbytes.R
import com.danielvilha.devbytes.databinding.ItemDevbyteBinding

/**
 * Created by danielvilha on 26/05/21
 * https://github.com/danielvilha
 *
 * ViewHolder for DevByte items. All work is done by data binding.
 */
class DevByteViewHolder(val viewDataBinding: ItemDevbyteBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.item_devbyte
    }
}