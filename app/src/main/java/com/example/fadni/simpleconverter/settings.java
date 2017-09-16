package com.example.fadni.simpleconverter;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class settings extends AppCompatActivity {
    private SharedPreferences preferences;
    private Button selectLength;
    private Button selectMass;
    private Button selectTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        preferences = getSharedPreferences("category",MODE_PRIVATE);
    }

    public void onClick(View view){
        selectLength = (Button) findViewById(R.id.selectLength);
        selectTemp =  (Button) findViewById(R.id.selectTemp);
        selectMass = (Button) findViewById(R.id.selectMass);
        if (view == selectLength){
            preferences.edit().clear().putString("category","length").apply();
            finish();
        }
        if (view == selectTemp){
            preferences.edit().clear().putString("category","temp").apply();
            finish();
        }
        if (view == selectMass){
            preferences.edit().clear().putString("category","mass").apply();
            finish();
        }






    }
}
