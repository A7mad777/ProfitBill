package com.example.future.currentselling.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.future.currentselling.Activities.AddActivity;
import com.example.future.currentselling.Activities.HomeActivity;
import com.example.future.currentselling.Adapters.RecyclerViewAdapter;
import com.example.future.currentselling.Data.Item;
import com.example.future.currentselling.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SellProduct extends Fragment {
RecyclerView recyclerView;

    public SellProduct() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sell_product, container, false);
        List<Item> items = HomeActivity.myApplicationDataBase.itemDao().getItems();
        recyclerView = view.findViewById(R.id.Rv);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(),items);
        recyclerView.setAdapter(adapter);
        return view;
    }

}
