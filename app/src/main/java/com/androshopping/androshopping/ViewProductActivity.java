package com.androshopping.androshopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.res.TypedArray;

public class ViewProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.android_os_mini);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_viewproduct);

        Intent myIntent = getIntent();
        int itemID = myIntent.getIntExtra("itemID", -1);

        String [] names = getResources().getStringArray(R.array.productNames);
        String [] descriptions = getResources().getStringArray(R.array.productDescriptions);
        int [] prices = getResources().getIntArray(R.array.productPrices);
        TypedArray imgs = getResources().obtainTypedArray(R.array.productImages);

        TextView productNameText = (TextView) findViewById(R.id.productName);
        productNameText.setText(names[itemID]);

        TextView productDescriptionText = (TextView) findViewById(R.id.productDescription);
        productDescriptionText.setText(descriptions[itemID]);

        ImageView productImgView = (ImageView) findViewById(R.id.productImage);
        productImgView.setImageResource(imgs.getResourceId(itemID,0));
        imgs.recycle();

        TextView productPriceText = (TextView) findViewById(R.id.productPrice);
        productPriceText.setText(getResources().getString(R.string.textPrice) + prices[itemID] + getResources().getString(R.string.euro));

    }
}
