package com.uzdev.grocery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.uzdev.grocery.R;
import com.uzdev.grocery.models.PlateModel;

import java.util.List;

public class PlateAdapter extends RecyclerView.Adapter<PlateAdapter.PlateViewHolder> {
    public PlateAdapter(List<PlateModel> plateModelList, Context context) {
        this.plateModelList = plateModelList;
        this.context = context;
    }

    private List<PlateModel> plateModelList;
    private Context context;

    @NonNull
    @Override
    public PlateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plates, parent, false);


        return new PlateViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlateViewHolder holder, int position) {
        Glide.with(context).load(plateModelList.get(position).getImg()).into(holder.plateIMg);

    }

    @Override
    public int getItemCount() {
        return plateModelList.size();
    }


    class PlateViewHolder extends RecyclerView.ViewHolder {
        private ImageView plateIMg;

        public PlateViewHolder(@NonNull View itemView) {
            super(itemView);
            plateIMg = itemView.findViewById(R.id.imageView2);
        }
    }
}
