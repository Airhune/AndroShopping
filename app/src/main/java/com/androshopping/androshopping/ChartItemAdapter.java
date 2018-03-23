package com.androshopping.androshopping;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karlo on 23/03/2018.
 */

public class ChartItemAdapter extends ArrayAdapter<ChartItem> {
    /* ATRIBUTOS */
    private List<ChartItem> elements;

    /* CONSTRUCTOR */
    public ChartItemAdapter(Context context) {
        super(context, android.R.layout.simple_list_item_1);
        this.elements = new ArrayList<ChartItem>();
        this.elements.isEmpty();
    }

    //Devuelve el número de elementos
    public int getCount() {
        return this.elements.size();
    }

    //reinicia el chart
    public void clearList(){
        this.elements.clear();
    }

    //Devuelve el elemento en sí.
    public ChartItem getItem(int index) {
        return this.elements.get(index);
    }

    public void addItem(ChartItem s){
        this.elements.add(s);
    }

    public boolean searchItem(String n){
        boolean found = false;
        for (int i = 0; i<getCount(); i++){
            if (this.elements.get(i).name.equals(n)){
                found = true;
                this.elements.get(i).quantity++;
            }
        }
        return found;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            Log.d("DEBUG", "Starting Row Inflation ... ");
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.chart_view_row, parent, false);
            row.setClickable(true);
            row.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //aqui puedes poner si quieres que haga algo cuando clicas la linea, no los botones.
                }
            });
            Log.d("DEBUG", "Successfully completed Row Inflation!");
        }
        // Get item
        String name = getItem(position).name;
        int price = getItem(position).price;
        int quantity = getItem(position).quantity;
        int src = getItem(position).imgSrc;
        row.setTag(position);

        //Sets the texts
        TextView productName = (TextView) row.findViewById(R.id.productName);
        productName.setText(name);
        TextView productPrice = (TextView) row.findViewById(R.id.productPrice);
        productPrice.setText(price + " €");
        TextView quantityText = (TextView) row.findViewById(R.id.productQuantity);
        quantityText.setText("  Q: " + quantity);
        TextView totalPrice = (TextView) row.findViewById(R.id.totalPrice);
        int aux = quantity * price;
        totalPrice.setText(aux + " €");

        //Set image
        ImageView chartImage = (ImageView) row.findViewById(R.id.chartImage);
        chartImage.setImageResource(src);
        return row;
    }
    public int getTotalPrice (){
        int price = 0;
        for (int i = 0; i<getCount(); i++){
            price = price + this.elements.get(i).price * this.elements.get(i).quantity;
        }
        return price;
    }
}