package com.example.kallen.myapplication;

/**
 * Created by Kallen on 11/25/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity {
    EditText userName;
    EditText password;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
    }

    public void verify(View v) {
        if (userName.getText().toString().equals("kallen5208")) {
            startActivity(new Intent("com.example.kallen.myapplication.summaryActivity"));
        }
    }

    public void backToHome(View v) {
        startActivity(new Intent("android.intent.action.MAIN"));
    }
}
