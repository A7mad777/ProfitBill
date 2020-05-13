package com.example.future.currentselling.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.future.currentselling.Activities.HomeActivity;
import com.example.future.currentselling.Data.Item;
import com.example.future.currentselling.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private List<Item>list;
    private Context context;
    public RecyclerViewAdapter(Context context,List<Item>list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.current_row,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Item item = list.get(position);
        holder.textView6.setText(item.getProductName());
        holder.textView7.setText(item.getOriginalPrice() +"");
        holder.textView8.setText(item.getSellPrice()+"");
//        holder.textView14.setText(item.getProfit() + "");
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView14;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView6 = itemView.findViewById(R.id.textView6);
            textView7 = itemView.findViewById(R.id.textView7);
            textView8 = itemView.findViewById(R.id.textView8);
            //textView14 = itemView.findViewById(R.id.textView14);
        }
    }
}
