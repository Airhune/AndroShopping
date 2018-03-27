package com.androshopping.androshopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_viewproduct);

        Intent myIntent = getIntent();
        int productPrice = myIntent.getIntExtra("productPrice", 0);
        String productName = myIntent.getStringExtra("productName");
        String productDescription = myIntent.getStringExtra("productDescription");
        int productImg = myIntent.getIntExtra("productImg", 0);

        TextView productNameText = (TextView) findViewById(R.id.productName);
        productNameText.setText(productName);

        TextView productDescriptionText = (TextView) findViewById(R.id.productDescription);
        productDescriptionText.setText(productDescription);

        ImageView productImgView = (ImageView) findViewById(R.id.productImage);
        productImgView.setImageResource(productImg);

        TextView productPriceText = (TextView) findViewById(R.id.productPrice);
        productPriceText.setText("Price: "+productPrice+"€");

    }
}
