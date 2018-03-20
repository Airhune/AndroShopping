package com.androshopping.androshopping;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ListProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listproduct);

        Button viewButton = (Button)findViewById(R.id.viewProduct);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ViewProductActivity.class);
                startActivity(i);
            }
        });


        Button addButton = (Button)findViewById(R.id.addChart);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Has comprado tal", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        Button buyButton = (Button)findViewById(R.id.buyProducts);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
