package com.example.future.currentselling.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.future.currentselling.Activities.BasketActivity;
import com.example.future.currentselling.Data.Common;
import com.example.future.currentselling.Data.Item;
import com.example.future.currentselling.R;

import java.io.Serializable;
import java.util.List;

public class DailyProfitAdapter extends RecyclerView.Adapter<DailyProfitAdapter.DailyViewHolder> {
    private Context context;
    List<Item>list;
    ItemClickListener itemClickListener;
    int row_index = -1;

    public DailyProfitAdapter(Context context, List<Item> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public DailyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.profit_row,parent,false);
        return new DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyViewHolder holder, int position) {
        Item item = list.get(position);
        holder.textView6.setText(item.getProductName());
        holder.textView7.setText(item.getProfit()+"");
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().putString("name",item.getProductName()).commit();
        preferences.edit().putString("sellPrice",item.getSellPrice()+"").commit();
        holder.setOnItemSelectedListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                row_index = position;
            }
        });
        holder.Date.setText(item.getDate());
        SharedPreferences date = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().putString("date",item.getDate()).commit();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class DailyViewHolder extends RecyclerView.ViewHolder {
        TextView textView6;
        TextView textView7;
        ItemClickListener itemClickListener;
        TextView Date;

        public void setOnItemSelectedListener(ItemClickListener itemSelectedListener){
            this.itemClickListener = itemSelectedListener;
        }
        public DailyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView6 = itemView.findViewById(R.id.textView6);
            textView7 = itemView.findViewById(R.id.textView7);
            Date = itemView.findViewById(R.id.textView19);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context,BasketActivity.class));
                }
            });
        }
    }

}
