package com.example.kallen.myapplication;

/**
 * Created by Kallen on 11/25/2015.
 */
import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import java.util.Formatter;

public class ProfileActivity extends Activity{
    EditText name;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = (EditText) findViewById(R.id.heroName);
        Formatter formatter = new Formatter(new StringBuilder());
        formatter.format("%s %s", "Kallen", "Lelouch");
        name.setText(formatter.toString());
        formatter.close();
    }
}
