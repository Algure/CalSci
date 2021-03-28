package com.example.ajirigunn.calsci;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.ajirigunn.calsci.Equations_activities.Cubic;
import com.example.ajirigunn.calsci.Equations_activities.Quadratic;
import com.example.ajirigunn.calsci.Equations_activities.simul1;
import com.example.ajirigunn.calsci.Equations_activities.simul2;
import com.example.ajirigunn.calsci.homeclasses.gunnermain;
import com.example.ajirigunn.calsci.personal_classes.Personal;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Equations extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public void quadratic(View view){
        startActivity(new Intent(Equations.this, Quadratic.class));
    }
    public void cubic(View view){
        startActivity(new Intent(Equations.this, Cubic.class));
    }
    public void simul1(View view){
        startActivity(new Intent(Equations.this, simul1.class));
    }
    public void simul2(View view){
        startActivity(new Intent(Equations.this, simul2.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equations);
        Toolbar cb=(Toolbar)findViewById(R.id.cb);
        cb.setTitleTextColor(Color.WHITE);
        setSupportActionBar(cb);
        ActionBar ab=getSupportActionBar();
        ab.setTitle(getResources().getString(R.string.Equationsol));
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.backicon);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nview);
        navigationView.setNavigationItemSelectedListener(this);

        AdView ad=(AdView)findViewById(R.id.ad2);
        AdRequest adRequest=new AdRequest.Builder().build();
        ad.loadAd(adRequest);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.Home){
            startActivity(new Intent(this, gunnermain.class));
        }
        else if (id==R.id.title){
            startActivity(new Intent(this,Calculator.class));

        }else if (id==R.id.conv){
            startActivity(new Intent(this,Converter.class));

        }else if (id==R.id.personal){
            startActivity(new Intent(this,Personal.class));

        }else if(id==R.id.Equations){

            startActivity(new Intent(this,Equations.class));
        }
        return true;
    }
}
