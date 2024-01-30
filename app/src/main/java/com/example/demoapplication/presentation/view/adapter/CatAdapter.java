package com.example.demoapplication.presentation.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.demoapplication.R;
import com.example.demoapplication.presentation.uimodel.CatModel;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {

    private List<CatModel> catList = new ArrayList<>();

    public void setCatList(List<CatModel> catList) {
        this.catList = catList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cat, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        CatModel cat = catList.get(position);
        Glide.with(holder.imageView.getContext())
                .load(cat.getImageUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    static class CatViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}

