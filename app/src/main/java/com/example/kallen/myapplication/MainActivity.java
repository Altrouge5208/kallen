package com.example.kallen.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchLogin(View v){
        startActivity(new Intent("com.example.kallen.myapplication.loginActivity"));
    }

    public void launchSignUp(View v){
        startActivity(new Intent("com.example.kallen.myapplication.signUpActivity"));
    }
}
