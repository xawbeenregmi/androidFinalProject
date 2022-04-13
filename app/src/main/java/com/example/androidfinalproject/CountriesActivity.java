package com.example.androidfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CountriesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    // defining required variables
    Spinner spinner_countries;
    ImageView imgv_flag;
    TextView tv_capital;
    ListView lv_poi;
    public static String title = "";
    public static Integer price = 1;
    List<String> placesList = new ArrayList<>();
    List<Integer> priceList = new ArrayList<>();
    String arr[] = {"Canada", "USA", "England"};
    AdapterForPlaces adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        // setting title
        getSupportActionBar().setTitle("Android Final Exam : Countries Screen");

        spinner_countries = findViewById(R.id.spinner_countries);
        lv_poi = findViewById(R.id.lv_poi);
        imgv_flag = findViewById(R.id.iv_flag);
        tv_capital = findViewById(R.id.tv_cap);

        // setting array adapter to the spinner
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_countries.setAdapter(spinnerArrayAdapter);
        spinner_countries.setOnItemSelectedListener(this);

        lv_poi.setOnItemClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        priceList.clear();
        if (position == 0) {
            imgv_flag.setImageResource(R.drawable.canada);
            tv_capital.setText("Ottawa");

            placesList.clear();
            placesList.add("Niagara falls");
            placesList.add("CN Tower");
            placesList.add("The Butchart Gardens");
            placesList.add("Notre-Dame Basilica");
            priceList.add(100);
            priceList.add(30);
            priceList.add(30);
            priceList.add(50);

            adapter = new AdapterForPlaces(this, placesList,priceList);
            lv_poi.setAdapter(adapter);
        }
        if (position == 1) {
            imgv_flag.setImageResource(R.drawable.usa);
            tv_capital.setText("Washington");
            placesList.clear();

            placesList.add("The Statue of Liberty ");
            placesList.add("The White House  ");
            placesList.add("Times Square");
            priceList.add(90);
            priceList.add(60);
            priceList.add(75);

            adapter = new AdapterForPlaces(this, placesList,priceList);
            lv_poi.setAdapter(adapter);
        }


        if (position == 2) {
            imgv_flag.setImageResource(R.drawable.england);
            tv_capital.setText("London");
            placesList.clear();
            placesList.add("Big Ben");
            placesList.add("Westminster Abbey");
            placesList.add("Hyde Park");
            priceList.add(30);
            priceList.add(25);
            priceList.add(15);
            adapter = new AdapterForPlaces(this, placesList,priceList);
            lv_poi.setAdapter(adapter);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent i = new Intent(CountriesActivity.this, ImagesActivity.class);

        title = placesList.get(position);
        price = priceList.get(position);

        startActivity(i);

    }
}