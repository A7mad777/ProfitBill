package com.example.future.currentselling.Fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.future.currentselling.Activities.BasketActivity;
import com.example.future.currentselling.Adapters.DailyProfitAdapter;
import com.example.future.currentselling.Activities.HomeActivity;
import com.example.future.currentselling.Data.Item;
import com.example.future.currentselling.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyProfit extends Fragment {
    RecyclerView recyclerView;
    TextView Total;
    List<Item>itemList = new ArrayList<>();
    FloatingActionButton fab;
    TextView textView12;
    TextView Date;


    public DailyProfit() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daily_profit, container, false);
        recyclerView = view.findViewById(R.id.DailyRv);
        Total = view.findViewById(R.id.textView13);
        Date = view.findViewById(R.id.textView12);
        Item item = new Item();
        SharedPreferences preferences  = PreferenceManager.getDefaultSharedPreferences(getActivity());
        List<Item>items = HomeActivity.myApplicationDataBase.itemDao().getItems();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        DailyProfitAdapter adapter = new DailyProfitAdapter(getActivity(),items);
        recyclerView.setAdapter(adapter);
        itemList = items;
        Double totalPrice = 0.00;
        for (int i = 0 ; i < itemList.size();i++){
                totalPrice = totalPrice + itemList.get(i).getProfit();
                Total.setText(totalPrice+"");
                preferences.edit().putString("total",String.valueOf(totalPrice)).commit();
        }
        return view;
    }
}
