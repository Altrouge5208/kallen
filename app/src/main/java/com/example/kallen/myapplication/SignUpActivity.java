package com.example.kallen.myapplication;

/**
 * Created by Kallen on 11/25/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.Vector;

public class SignUpActivity extends Activity {
    EditText userName;
    EditText password;
    DBAdapter sql_entry;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        userName = (EditText) findViewById(R.id.userNameSignUp);
        password = (EditText) findViewById(R.id.passwordSignUp);
        sql_entry = new DBAdapter(this);
    }

    public void signUp(View v) {
        if (userName.getText().toString().equals("") || password.getText().toString().equals("")) {
            return;
        }
        Vector<String[]> updateAttributes = new Vector<String[]>();
        updateAttributes.add(new String[]{"_name", userName.getText().toString()});
        updateAttributes.add(new String[]{"_password", password.getText().toString()});
        long l = sql_entry.addNewEntry(updateAttributes);
        userName.setText(String.valueOf(l));
//        clear(v);
    }

    public void clear(View v) {
        userName.setText("");
        password.setText("");
    }
}
