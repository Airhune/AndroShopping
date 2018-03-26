package com.androshopping.androshopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class ViewProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.android_os_mini);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        setContentView(R.layout.activity_viewproduct);

        Intent myIntent = getIntent();
        int productPrice = myIntent.getIntExtra("productPrice", 0);
        String productName = myIntent.getStringExtra("productName");
        String productDescription = myIntent.getStringExtra("productDescription");

        TextView productNameText = (TextView) findViewById(R.id.productName);
        productNameText.setText(productName);

        TextView productDescriptionText = (TextView) findViewById(R.id.productDescription);
        productDescriptionText.setText(productDescription);

        TextView productPriceText = (TextView) findViewById(R.id.productPrice);
        productPriceText.setText("Price: "+productPrice+"€");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon action bar is clicked; go to parent activity
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
