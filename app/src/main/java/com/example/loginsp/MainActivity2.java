package com.example.loginsp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button logout;

//    private SharedPreferences mSharedPref;
//    private final String sharedPrefFile = "com.example.sharedpreferenceapp";
//    private final String LOGIN_STATUS = "LOGIN_STATUS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        logout = findViewById(R.id.btn_logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
                MainActivity.setLogout();
                finish();
            }
        });
    };

}
//        mSharedPref = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
//        setLogot = mSharedPref.getBoolean(LOGIN_STATUS, false);
//        final Intent intent = new Intent(this, MainActivity.class);
//        if (setLogout){
//            startActivity(intent);
//            finish();
//        }
