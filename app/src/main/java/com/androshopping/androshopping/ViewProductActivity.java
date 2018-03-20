package com.androshopping.androshopping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class ViewProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("msg","Prueba de merge nurieta");
        setContentView(R.layout.activity_viewproduct);
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
