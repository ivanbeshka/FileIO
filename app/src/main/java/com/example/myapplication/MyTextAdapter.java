package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyTextAdapter extends RecyclerView.Adapter<MyTextAdapter.MyViewHolder> {

    private static final String TAG = "MyTextAdapter";

    private String[] mData;
    private OnItemClickListener onItemClickListener;

    public MyTextAdapter(String[] data, OnItemClickListener onItemClickListener) {
        mData = data;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_paragraph, parent, false);

        return new MyViewHolder(itemView, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvParText.setText(mData[position]);
        holder.tvPar.setText("Paragraph" + " " + (position + 1));
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvParText;
        TextView tvPar;
        Button btnMore;

        OnItemClickListener onItemClickListener;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            tvParText = itemView.findViewById(R.id.tv_par_text);
            tvPar = itemView.findViewById(R.id.tv_par);
            btnMore = itemView.findViewById(R.id.btn_more);

            this.onItemClickListener = onItemClickListener;

            btnMore.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
                onItemClickListener.onItemClick(getAdapterPosition(), mData[getAdapterPosition()]);
        }
    }
}

interface OnItemClickListener {
    void onItemClick(int position, String data);
}