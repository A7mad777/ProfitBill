package com.example.future.currentselling.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.future.currentselling.Activities.HomeActivity;
import com.example.future.currentselling.Adapters.MonthlyAdapter;
import com.example.future.currentselling.Data.Item;
import com.example.future.currentselling.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonthlyProfit extends Fragment {
    List<Item> itemList;
    RecyclerView recyclerView;
    TextView month;
    private Context context;
    TextView textView22;
    public MonthlyProfit() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_monthly_profit, container, false);
        recyclerView = view.findViewById(R.id.month);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        List<Item> items = HomeActivity.myApplicationDataBase.itemDao().getItems();
        MonthlyAdapter adapter = new MonthlyAdapter(getActivity(), items);

        Date current = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        String currentDate = sdf.format(current);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String storeDate = preferences.getString("date", null);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        String tommrrowDate = sdf.format(tomorrow);
        Date mydate = new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String yestr = dateFormat.format(mydate);
        String total = preferences.getString("total", null);
        String date = preferences.getString("date", null);


        if (storeDate != null && storeDate.compareTo(currentDate) < 0) {
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(adapter);
        } else if (storeDate != null && storeDate.compareTo(tommrrowDate) == 0) {
            recyclerView.setLayoutManager(manager);
        }
        return view;
    }
}
