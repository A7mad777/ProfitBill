package com.example.future.currentselling.Activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.future.currentselling.Adapters.RecyclerViewAdapter;
import com.example.future.currentselling.Data.Item;
import com.example.future.currentselling.Data.ItemDao;
import com.example.future.currentselling.R;

import java.util.List;

public class AddActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private RecyclerViewAdapter adapter;
    public static final String TAG = "DataBbase";
    private List<Item> itemList;
    ItemDao itemDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
}
