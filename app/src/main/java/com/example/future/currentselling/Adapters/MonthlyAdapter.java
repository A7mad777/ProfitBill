package com.example.future.currentselling.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.future.currentselling.Data.Item;
import com.example.future.currentselling.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MonthlyAdapter extends RecyclerView.Adapter<MonthlyAdapter.MonthlyViewHolder> {
    private Context context;
    List<Item> itemList;

    public MonthlyAdapter(Context context, List<Item> items) {
        this.context = context;
        itemList = items;
    }

    @NonNull
    @Override
    public MonthlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.monthly_row, parent, false);
        return new MonthlyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonthlyViewHolder holder, int position) {
        Item item = itemList.get(position);
        Date current = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        String currentDate = sdf.format(current);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String storeDate = preferences.getString("date", null);
        Date mydate = new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String yestr = dateFormat.format(mydate);
        String total = preferences.getString("total", null);
        String date = preferences.getString("date", null);
        holder.Total.setText(item.getTotal());
        holder.DateText.setText(item.getDate());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
    public class MonthlyViewHolder extends RecyclerView.ViewHolder {
        TextView Total;
        TextView DateText;
        CardView cardView;
        public MonthlyViewHolder(@NonNull View itemView) {
            super(itemView);
            Total = itemView.findViewById(R.id.textView21);
            DateText = itemView.findViewById(R.id.date);
            cardView = itemView.findViewById(R.id.Cv);
        }
    }
}
