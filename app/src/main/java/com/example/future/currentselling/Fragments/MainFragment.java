package com.example.future.currentselling.Fragments;


import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.future.currentselling.Activities.AddActivity;
import com.example.future.currentselling.Activities.HomeActivity;
import com.example.future.currentselling.Data.Item;
import com.example.future.currentselling.Data.ItemDao;
import com.example.future.currentselling.Data.MyApplicationDataBase;
import com.example.future.currentselling.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    EditText productNameText;
    EditText PriceText;
    EditText sellPriceText;
    Button Add;
    Button profit;
    MyApplicationDataBase myApplicationDataBase;
    EditText profitText;
    List<Item>itemList;
    public Item item;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_fragment, container, false);
        Add = view.findViewById(R.id.button4);
        Add.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        productNameText = getActivity().findViewById(R.id.editText6);
        PriceText = getActivity().findViewById(R.id.editText7);
        sellPriceText = getActivity().findViewById(R.id.editText8);
        String productName = productNameText.getText().toString();
        Double price = Double.parseDouble(PriceText.getText().toString());
        Double sellPrice = Double.parseDouble(sellPriceText.getText().toString());
        Double profittype = price - sellPrice;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String total = preferences.getString("total",null);
        Item item = new Item();
        item.setProductName(productName);
        item.setOriginalPrice(price);
        item.setSellPrice(sellPrice);
        item.setProfit(profittype);
        Date c = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);
        item.setDate(formattedDate);
        item.setTotal(total);
        HomeActivity.myApplicationDataBase.itemDao().insert(item);
        Toast.makeText(getActivity(), "item added Successfuly", Toast.LENGTH_SHORT).show();
        productNameText.setText("");
        PriceText.setText("");
        sellPriceText.setText("");

    }
}