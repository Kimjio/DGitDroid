package com.kimjio.dgitdroid.recycler;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kimjio.dgitdroid.databinding.RankItemBinding;

public class RankViewHolder extends RecyclerView.ViewHolder {
    public RankItemBinding binding;

    public RankViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }
}
