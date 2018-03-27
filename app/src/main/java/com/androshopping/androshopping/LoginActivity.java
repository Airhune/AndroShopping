package com.androshopping.androshopping;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button validateButton = (Button)findViewById(R.id.validateLogin);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loginIsCorrect()){
                    Intent i = new Intent(getApplicationContext(), ListProductActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public boolean loginIsCorrect(){

        EditText user_field = (EditText) findViewById(R.id.user_field);
        String email = user_field.getText().toString();

        EditText pw_field = (EditText) findViewById(R.id.pw_field);
        String pw = pw_field.getText().toString();

        if(emailIsCorrect(email)){
            if(passwordIsCorrect(pw)){
                return true;
            }
            else{
                showToastMessage("Password needs 6 digits at least.");
            }
        }
        else{
            showToastMessage("Invalid format email.");
        }
        return false;
    }

    public boolean emailIsCorrect(String email){
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public boolean passwordIsCorrect(String pw){
        return (pw.length() >= 6);
    }

    public void showToastMessage(String message){
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
