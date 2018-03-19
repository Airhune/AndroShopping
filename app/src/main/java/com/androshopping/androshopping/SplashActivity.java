package com.androshopping.androshopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("msg","Prueba de merge nurieta");
        setContentView(R.layout.activity_splash);
    }
}
