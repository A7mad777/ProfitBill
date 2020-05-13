package com.example.future.currentselling.Activities;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.future.currentselling.Data.Item;
import com.example.future.currentselling.R;

import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity {

  //  public Item itemList = new Item();
    TextView productName;
    TextView SellPrice;
    ImageButton Add;
    ImageButton subtract;
    TextView Count;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        productName = (TextView) findViewById(R.id.textView15);
        Add = (ImageButton) findViewById(R.id.imageButton);
        subtract = (ImageButton) findViewById(R.id.imageButton2);
        SellPrice = (TextView) findViewById(R.id.textView17);
        Count = (TextView) findViewById(R.id.textView18);
        String pName = sharedPreferences.getString("name",null);
        String sPrice = sharedPreferences.getString("sellPrice",null);
        productName.setText(pName);
        SellPrice.setText(sPrice);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer count = 0;
                if (!Count.getText().toString().equals("")){
                    count = Integer.parseInt(Count.getText().toString());
                }
                count = count + 1;
                Count.setText(String.valueOf(count));
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                if (!Count.getText().toString().equals("")){
                    count = Integer.valueOf(Count.getText().toString()+"");

                }
                if (count != 0) {
                    count = count - 1;
                    Count.setText(String.valueOf(count));
                }
            }
        });
    }
}
