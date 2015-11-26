package com.example.kallen.myapplication;

/**
 * Created by Kallen on 11/25/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SummaryActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
    }

    public void launchProfile(View v){
        startActivity(new Intent("com.example.kallen.myapplication.profileActivity"));
    }

    public void launchEquipments(View v){
        startActivity(new Intent("com.example.kallen.myapplication.equipmentsActivity"));
    }

    public void launchKnapsack(View v){
        startActivity(new Intent("com.example.kallen.myapplication.knapsackActivity"));
    }

    public void launchShop(View v){
        startActivity(new Intent("com.example.kallen.myapplication.shopActivity"));
    }

    public void launchBettle(View v){
        startActivity(new Intent("com.example.kallen.myapplication.battleActivity"));
    }

    public void backToLogin(View v){
        startActivity(new Intent("com.example.kallen.myapplication.loginActivity"));
    }
}
