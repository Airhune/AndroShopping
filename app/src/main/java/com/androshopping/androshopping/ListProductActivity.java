package com.androshopping.androshopping;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ListView;

public class ListProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.android_os_mini);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_listproduct);

        String [] names = getResources().getStringArray(R.array.productNames);
        String [] descriptions = getResources().getStringArray(R.array.productDescriptions);
        int [] prices = getResources().getIntArray(R.array.productPrices);

        ShopItemAdapter adapter = new ShopItemAdapter(this, names, prices);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(adapter);


        Button buyButton = (Button)findViewById(R.id.buyProducts);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initializeChart();
                Intent i = new Intent(getApplicationContext(), ChartActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent setIntent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(setIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon action bar is clicked; go to parent activity
//                this.finish();
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Inicializa la lista de la compra
    public void initializeChart(){
        if (((AndroShopping) this.getApplication()).chartList == null) {
            ((AndroShopping) this.getApplication()).chartList = new ChartItemAdapter(this);
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
