package com.example.androidfinalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterForPlaces extends BaseAdapter {
    Context context;
    private static LayoutInflater inflater = null;

    // defining list for data and prices
    List<String> myData = new ArrayList<>();
    List<Integer> prices = new ArrayList<>();

    // initializing the constructor
    public AdapterForPlaces(CountriesActivity countryActivity, List<String> poIlist, List<Integer> priceList) {
        this.context = countryActivity;
        this.myData = poIlist;
        this.prices = priceList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        if (myData.size() <= 0)
            return 1;
        return myData.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    public static class ViewHolder {
        public TextView text, price;
        public ImageView img;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi = view;
        ViewHolder holder;
        if (view == null) {
            vi = inflater.inflate(R.layout.activity_layout, null);
            holder = new ViewHolder();
            holder.text = vi.findViewById(R.id.tv_poi);
            holder.price = vi.findViewById(R.id.tv_price);
            vi.setTag(holder);
        } else
            holder = (ViewHolder) vi.getTag();
        if (myData.size() <= 0) {
            holder.text.setText("No Data");
        } else {
            holder.text.setText(myData.get(i));
            holder.price.setText("$" + String.valueOf(prices.get(i)));
        }

        return vi;
    }
}
