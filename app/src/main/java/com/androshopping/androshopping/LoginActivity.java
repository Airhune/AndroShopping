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

import java.util.Arrays;

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

        if(emailFormatIsCorrect(email)){
            if(passwordFormatIsCorrect(pw)){
                if(validUser(email,pw)){
                    return true;
                }
                else{
                    showToastMessage("Email and Password do not match.");
                }
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

    public boolean emailFormatIsCorrect(String email){
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public boolean passwordFormatIsCorrect(String pw){
        return (pw.length() >= 6);
    }

    public boolean validUser(String email, String pw){
        String [] usersName = getResources().getStringArray(R.array.usersEmail);
        //Check if the user is registered
        if(Arrays.asList(usersName).contains(email)){
            //if it is registered, check users index position on users array
            int passwordIndex = Arrays.asList(usersName).indexOf(email);

            //Compare password position with password introduced
            String [] usersPassword = getResources().getStringArray(R.array.usersPassword);
            return(usersPassword[passwordIndex].equals(pw));
        }
        return false;
    }

    public void showToastMessage(String message){
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
