package com.kimjio.dgitdroid.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kimjio.dgitdroid.R;
import com.kimjio.dgitdroid.model.User;

import java.util.List;

public class RankAdapter extends RecyclerView.Adapter<RankViewHolder> {

    private List<User> list;

    public RankAdapter(List<User> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rank_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RankViewHolder holder, int position) {
        holder.binding.setUser(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
