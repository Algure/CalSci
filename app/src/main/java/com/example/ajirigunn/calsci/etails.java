package com.example.ajirigunn.calsci;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class etails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etails);
        Toolbar tb= (Toolbar) findViewById(R.id.tlb);
        tb.setTitle("DETAILS");
        tb.setTitleTextColor(Color.WHITE);
        setSupportActionBar(tb);
        ActionBar a=getSupportActionBar();
    a.setDisplayHomeAsUpEnabled(true);
    }
}
