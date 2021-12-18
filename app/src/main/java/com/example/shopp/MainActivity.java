package com.example.shopp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.simple.parser.JSONParser;

public class MainActivity extends AppCompatActivity {

    JSONParser jsonParser = new JSONParser();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}