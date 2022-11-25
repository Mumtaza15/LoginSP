package com.example.loginsp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editUsername, editPassword;
    Button login;
    private Boolean setLogin;

    public static SharedPreferences mSharedPref;
    private final String sharedPrefFile = "com.example.sharedpreferenceapp";
    public static final String LOGIN_STATUS = "LOGIN_STATUS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSharedPref = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        editUsername = findViewById(R.id.txt_username);
        editPassword = findViewById(R.id.txt_pw);
        setLogin = mSharedPref.getBoolean(LOGIN_STATUS, false);

        login = findViewById(R.id.btn_login);

        final Intent intent = new Intent(this, MainActivity2.class);
        if (setLogin){
            startActivity(intent);
            finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();

                if (TextUtils.isEmpty(editUsername.getText().toString())) {
                    Toast.makeText(MainActivity.this, "ISI USERNAME TERLEBIH DAHULU!",Toast.LENGTH_SHORT).show();
                }

                else if (TextUtils.isEmpty(editPassword.getText().toString())) {
                    Toast.makeText(MainActivity.this, "ISI PASSWORD TERLEBIH DAHULU!",Toast.LENGTH_SHORT).show();
                }
                else if (verifyLogin(username, password)) {
                    startActivity(intent);
                    saveLogin();
                    finish();
                }

            }
        });
    }

    private boolean verifyLogin(String username, String password){
        if (username.equals("taza") && password.equals("hehe")) {
            return true;
        } else {
            return false;
        }
    }

    private void saveLogin(){
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putBoolean(LOGIN_STATUS, true);
        editor.apply();
    }

    public static void setLogout(){
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putBoolean(LOGIN_STATUS, false);
        editor.apply();
    }
}
