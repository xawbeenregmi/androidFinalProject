package com.example.androidfinalproject;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ImagesActivity extends AppCompatActivity {
    // defining the required variables
    ImageView ivFull;
    TextView tv_title,tv_price;
    EditText et_visitor;
    int price = 0;
    int totalPrice = 0;
    int visitor = 0;
    Button btn_evaluate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        // setting title in action bar
        getSupportActionBar().setTitle("Android Final Exam : "+CountriesActivity.title);
        ivFull = findViewById(R.id.ivFull);
        tv_title=findViewById(R.id.tv_title);
        tv_price = findViewById(R.id.tv_price);
        et_visitor = findViewById(R.id.et_visitor);
        btn_evaluate = findViewById(R.id.btn_evaluate);

        price = CountriesActivity.price;
        tv_price.setText("$" + String.valueOf(price));


        btn_evaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_visitor.getText().toString().length() != 0)
                    visitor = Integer.parseInt(et_visitor.getText().toString());

                if(visitor == 0){
                    totalPrice=price;
                }else if(visitor < 16){
                    totalPrice = price*visitor;
                }else if(visitor > 15){
                    // adding discount logic if visitor is more than 15
                    totalPrice = (int) ((price*visitor) - ((price*visitor)*0.05));
                }
                tv_price.setText("$"+String.valueOf(totalPrice));
            }
        });


        if(CountriesActivity.title.equalsIgnoreCase("Niagara falls")){
            ivFull.setImageResource(R.drawable.niagara);}
        if(CountriesActivity.title.equalsIgnoreCase("CN Tower")){
            ivFull.setImageResource( R.drawable.cn);}
        if(CountriesActivity.title.equalsIgnoreCase("The Butchart Gardens")){
            ivFull.setImageResource(R.drawable.butchart);}
        if(CountriesActivity.title.equalsIgnoreCase("Notre-Dame Basilica")){
            ivFull.setImageResource( R.drawable.notre);}
        if(CountriesActivity.title.equalsIgnoreCase("The Statue of Liberty")){
            ivFull.setImageResource(R.drawable.liberty);}
        if(CountriesActivity.title.equalsIgnoreCase("The White House")){
            ivFull.setImageResource(R.drawable.whitehouse);}
        if(CountriesActivity.title.equalsIgnoreCase("Times Square")){
            ivFull.setImageResource(R.drawable.times);}
        if(CountriesActivity.title.equalsIgnoreCase("Big Ben")){
            ivFull.setImageResource( R.drawable.bigben);}
        if(CountriesActivity.title.equalsIgnoreCase("Westminster Abbey")){
            ivFull.setImageResource( R.drawable.abbey);}
        if(CountriesActivity.title.equalsIgnoreCase("Hyde Park")){
            ivFull.setImageResource( R.drawable.park);}

        tv_title.setText(CountriesActivity.title);

    }

}