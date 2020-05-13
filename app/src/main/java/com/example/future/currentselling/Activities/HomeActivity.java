package com.example.future.currentselling.Activities;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.future.currentselling.Data.MyApplicationDataBase;
import com.example.future.currentselling.Fragments.DailyProfit;
import com.example.future.currentselling.Fragments.MainFragment;
import com.example.future.currentselling.Fragments.MonthlyProfit;
import com.example.future.currentselling.Fragments.SellProduct;
import com.example.future.currentselling.R;

public class HomeActivity extends AppCompatActivity {
    private ActionBar toolbars;
    public static MyApplicationDataBase myApplicationDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        myApplicationDataBase = Room.databaseBuilder(getApplicationContext(),MyApplicationDataBase.class,"userDb").allowMainThreadQueries().build();
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);
        toolbars = getSupportActionBar();
        loadFragment(new MainFragment());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
       // toolbar.setTitle("Shop");
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_shop:
//                   toolbars.setTitle("Main");
                    fragment = new MainFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_gifts:
                    fragment = new SellProduct();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_cart:
                    fragment = new DailyProfit();
                    loadFragment(fragment);
                    return true;
                case R.id.navigationDollar:
                    fragment = new MonthlyProfit();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.containerFrame,fragment).commit();
    }
}
