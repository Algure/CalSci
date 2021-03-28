package com.example.ajirigunn.calsci.Equations_activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
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

public class Quadratic extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.eqmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    SharedPreferences sp;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        SharedPreferences.Editor editor=sp.edit();
        if(item.getItemId()==R.id.savevals){

            TextView ans=(TextView)findViewById(R.id.textView3);
            EditText ax=(EditText) findViewById(R.id.a);
            EditText bx=(EditText) findViewById(R.id.editText2);
            EditText cx=(EditText) findViewById(R.id.editText3);
            String as = (ax.getText().toString());
            String bs =(bx.getText().toString());
            String cs =(cx.getText().toString());
            String ds = (ans.getText().toString());

            editor.putString("a",as);
            editor.putString("b",bs);
            editor.putString("c",cs);
            editor.putString("d",ds);
            editor.commit();

            Toast.makeText(this,getString(R.string.saved),Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.restore){
            try {
                TextView d0 = (TextView) findViewById(R.id.textView3);
                EditText a0 = (EditText) findViewById(R.id.a);
                EditText b0 = (EditText) findViewById(R.id.editText2);
                EditText c0 = (EditText) findViewById(R.id.editText3);
                a0.setText(sp.getString("a", ""));
                b0.setText(sp.getString("b", ""));
                c0.setText(sp.getString("c", ""));
                d0.setText(sp.getString("d", ""));
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp=getSharedPreferences("qp",MODE_MULTI_PROCESS);
        setContentView(R.layout.activity_quadratic);
        Toolbar cb=(Toolbar)findViewById(R.id.cb);
        cb.setTitleTextColor(Color.WHITE);
        setSupportActionBar(cb);
        ActionBar ab=getSupportActionBar();
        ab.setTitle(getResources().getString(R.string.Equationsol));
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.backicon);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nview);
        navigationView.setNavigationItemSelectedListener(this);

        EditText t3=(EditText)findViewById(R.id.editText3);
        t3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction()==KeyEvent.KEYCODE_DPAD_CENTER){
                    solution(view);
                    return true;
               }else{
                return false;
            }}
        });
    }
    public Double getnumin(String input){
        return Double.parseDouble(input);
    }
    public void solution(View view){
        try {
            TextView ans=(TextView)findViewById(R.id.textView3);
            EditText ax=(EditText) findViewById(R.id.a);
            EditText bx=(EditText) findViewById(R.id.editText2);
            EditText cx=(EditText) findViewById(R.id.editText3);
            double a = 0, b = 0, c = 0, x1 = 0, x2 = 0;
            String answer;
            a = getnumin(ax.getText().toString());
            b = getnumin(bx.getText().toString());
            c = getnumin(cx.getText().toString());

            x1 = (-b + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
            x2 = (-b - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);

            if ((String.valueOf(x1) !="NaN") && (String.valueOf(x2)!=  "NaN")) {
                answer = "x1=" + String.valueOf(x1) + ",   x2=" + String.valueOf(x2);
            } else
                answer = getResources().getString(R.string.error);
            ans.setText(answer);
        }catch(Exception e){
            TextView ans=(TextView)findViewById(R.id.textView3);
            ans.setText(getResources().getString(R.string.error));
        }
    }
    public void reset(View view){
        TextView ans=(TextView)findViewById(R.id.textView3);
        EditText ax=(EditText) findViewById(R.id.a);
        EditText bx=(EditText) findViewById(R.id.editText2);
        EditText cx=(EditText) findViewById(R.id.editText3);
        ans.setText(     getResources().getString(R.string.answer));
        ax.setText("");
        bx.setText("");
        cx.setText("");

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
