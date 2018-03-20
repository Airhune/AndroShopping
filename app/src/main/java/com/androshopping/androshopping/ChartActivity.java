package com.androshopping.androshopping;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chart);

        Button finishButton = (Button)findViewById(R.id.finishChart);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Compra realizada correctamente", Toast.LENGTH_SHORT);
                toast.show();

                Intent i = new Intent(getApplicationContext(), ListProductActivity.class);
                startActivity(i);
                finish();

            }
        });
    }
}
