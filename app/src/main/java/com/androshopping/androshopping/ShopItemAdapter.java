package com.androshopping.androshopping;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;

/**
 * Created by karlo on 22/03/2018.
 */

public class ShopItemAdapter extends ArrayAdapter<ShopItem> {
    /* ATRIBUTOS */
    private List<ShopItem> elements;

    /* CONSTRUCTOR */
    public ShopItemAdapter(Context context, String[] names, int[] prices) {
        super(context, android.R.layout.simple_list_item_1);
        this.elements = new ArrayList<ShopItem>();
        populateList(names, prices);
    }

    private void populateList(String[] names, int[] prices) {
        this.elements.clear();
        for (int i = 0; i < names.length; i++) {
            this.elements.add(new ShopItem(names[i], prices[i]));
        }
    }

    //Devuelve el número de elementos
    public int getCount() {
        return this.elements.size();
    }

    //Devuelve el elemento en sí.
    public ShopItem getItem(int index) {
        return this.elements.get(index);
    }

    /*public void addItem(ShopItem s){
        this.elements.add(s);
    }*/

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            //Log.d("DEBUG", "Starting Row Inflation ... ");
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_view_row, parent, false);
            row.setClickable(true);
            row.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    //aqui puedes poner si quieres que haga algo cuando clicas la linea, no los botones.
                }
            });
            //Log.d("DEBUG", "Successfully completed Row Inflation!");
        }
        // Get item
        String name = getItem(position).name;
        int price = getItem(position).price;
        row.setTag(position);

        //Set text
        TextView productName = (TextView) row.findViewById(R.id.productName);
        productName.setText(name);
        TextView productPrice = (TextView) row.findViewById(R.id.productPrice);
        //context = getContext();
        productPrice.setText(getContext().getString(R.string.totalPrice) + price + getContext().getString(R.string.euro));

        //Set button tags
        Button buyButton = (Button) row.findViewById(R.id.addChart);
        buyButton.setTag(position);
        Button viewButton = (Button) row.findViewById(R.id.viewProduct);
        viewButton.setTag(position);
        return row;
    }
}