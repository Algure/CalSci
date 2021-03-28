package com.example.ajirigunn.calsci.Equations_activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajirigunn.calsci.Calculator;
import com.example.ajirigunn.calsci.Converter;
import com.example.ajirigunn.calsci.Equations;
import com.example.ajirigunn.calsci.R;
import com.example.ajirigunn.calsci.homeclasses.gunnermain;
import com.example.ajirigunn.calsci.personal_classes.Personal;

public class simul1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.eqmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
if(item.getItemId()==R.id.savevals){
    EditText A1 = (EditText) findViewById(R.id.a1);
    EditText B1 = (EditText) findViewById(R.id.editText9);
    EditText C1 = (EditText) findViewById(R.id.editText11);
    EditText A2 = (EditText) findViewById(R.id.a2);
    EditText B2 = (EditText) findViewById(R.id.editText10);
    EditText C2 = (EditText) findViewById(R.id.a3);
    double a1 = Double.parseDouble(A1.getText().toString());
    double b1 = Double.parseDouble(B1.getText().toString());
    double c1 = Double.parseDouble(C1.getText().toString());
    double a2 = Double.parseDouble(A2.getText().toString());
    double b2 = Double.parseDouble(B2.getText().toString());
    double c2 = Double.parseDouble(C2.getText().toString());
    TextView an = (TextView) findViewById(R.id.textView5);
    editor.putString("a1",String.valueOf(a1));
    editor.putString("b1",String.valueOf(b1));
    editor.putString("c1",String.valueOf(c1));
    editor.putString("c2",String.valueOf(c2));
    editor.putString("a2",String.valueOf(a2));
    editor.putString("b2",String.valueOf(b2));
    editor.commit();
    Toast.makeText(this,getString(R.string.saved),Toast.LENGTH_SHORT).show();
}else if(item.getItemId()==R.id.restore){
    try {
        EditText A1 = (EditText) findViewById(R.id.a1);
        EditText B1 = (EditText) findViewById(R.id.editText9);
        EditText C1 = (EditText) findViewById(R.id.editText11);
        EditText A2 = (EditText) findViewById(R.id.a2);
        EditText B2 = (EditText) findViewById(R.id.editText10);
        EditText C2 = (EditText) findViewById(R.id.a3);
        A1.setText(sp.getString("a1", ""));
        B1.setText(sp.getString("b1", ""));
        C1.setText(sp.getString("c1", ""));
        A2.setText(sp.getString("a2", ""));
        B2.setText(sp.getString("b2", ""));
        C2.setText(sp.getString("c2", ""));
    }catch (Exception e){
        Toast.makeText(this,getString(R.string.novals),Toast.LENGTH_SHORT).show();

    }
    }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {

        super.onStop();

    }

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simul1);

sp= getSharedPreferences("ssp",MODE_MULTI_PROCESS);
editor=sp.edit();
        Toolbar cb=(Toolbar)findViewById(R.id.cb);
        cb.setTitleTextColor(Color.WHITE);
        setSupportActionBar(cb);
        ActionBar ab=getSupportActionBar();
        ab.setTitle(getResources().getString(R.string.Equationsol));
ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.backicon);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nview);
        navigationView.setNavigationItemSelectedListener(this);
    }
    public void solution (View view){
        try {
            EditText A1 = (EditText) findViewById(R.id.a1);
            EditText B1 = (EditText) findViewById(R.id.editText9);
            EditText C1 = (EditText) findViewById(R.id.editText11);
            EditText A2 = (EditText) findViewById(R.id.a2);
            EditText B2 = (EditText) findViewById(R.id.editText10);
            EditText C2 = (EditText) findViewById(R.id.a3);
            double a1 = Double.parseDouble(A1.getText().toString());
            double b1 = Double.parseDouble(B1.getText().toString());
            double c1 = Double.parseDouble(C1.getText().toString());
            double a2 = Double.parseDouble(A2.getText().toString());
            double b2 = Double.parseDouble(B2.getText().toString());
            double c2 = Double.parseDouble(C2.getText().toString());
            TextView an = (TextView) findViewById(R.id.textView5);

            String ans = "";
            ans = sim1(a1, b1, c1, a2, b2, c2);
            if (ans.contains("NaN") || ans.contains("Infinity")) {
                ans = getResources().getString(R.string.error);
            }
            an.setText(ans);
        }catch (Exception e){
            TextView an = (TextView) findViewById(R.id.textView5);
            an.setText(getResources().getString(R.string.error));
        }
    }
    public String sim1(double a1,double b1,double c1,double a2,double b2,double c2){


        double x=((c1*b2)-(c2*b1))/((a1*b2)-(a2*b1));
        double y = ((a1 * c2) - (a2 * c1)) / ((a1 * b2) - (a2 * b1));

        String an;
        an="x\u2081="+String.valueOf(x)+"   x\u2082="+String.valueOf(y);
        return an;
    }

    public void reset(View view){

        EditText A1=(EditText)findViewById(R.id.a1);
        EditText B1=(EditText)findViewById(R.id.editText9);
        EditText C1=(EditText)findViewById(R.id.editText11);
        EditText A2=(EditText)findViewById(R.id.a2);
        EditText B2=(EditText)findViewById(R.id.editText10);
        EditText C2=(EditText)findViewById(R.id.a3);

        TextView an=(TextView)findViewById(R.id.textView5);

        A1.setText("");
        B1.setText("");
        C1.setText("");
        A2.setText("");
        B2.setText("");
        C2.setText("");

        an.setText(getResources().getString(R.string.answer));
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
