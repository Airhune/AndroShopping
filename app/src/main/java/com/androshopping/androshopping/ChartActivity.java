package com.androshopping.androshopping;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.android_os_mini);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        setContentView(R.layout.activity_chart);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(((AndroShopping) this.getApplication()).chartList);

        TextView total = (TextView)findViewById(R.id.totalChart);
        int aux = ((AndroShopping) this.getApplication()).chartList.getTotalPrice();
        total.setText(getResources().getString(R.string.totalPrice) + aux + getResources().getString(R.string.euro));

        Button finishButton = (Button)findViewById(R.id.finishChart);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, R.string.compraCompleta, Toast.LENGTH_SHORT);
                toast.show();
                eraseList();

                Intent i = new Intent(getApplicationContext(), ListProductActivity.class);
                startActivity(i);
                finish();

            }
        });
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
    public void eraseList(){
        ((AndroShopping) this.getApplication()).chartList.clearList();
    }
}
