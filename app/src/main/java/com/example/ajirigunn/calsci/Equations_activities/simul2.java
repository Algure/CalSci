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

public class simul2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.eqmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.savevals){
            EditText a1 = (EditText) findViewById(R.id.a1);
            EditText b1 = (EditText) findViewById(R.id.b1);
            EditText c1 = (EditText) findViewById(R.id.c1);
            EditText a2 = (EditText) findViewById(R.id.a2);
            EditText b2 = (EditText) findViewById(R.id.b2);
            EditText c2 = (EditText) findViewById(R.id.c2);
            EditText a3 = (EditText) findViewById(R.id.a3);
            EditText b3 = (EditText) findViewById(R.id.b3);
            EditText c3 = (EditText) findViewById(R.id.c3);
            EditText d1 = (EditText) findViewById(R.id.d1);
            EditText d2 = (EditText) findViewById(R.id.d2);
            EditText d3 = (EditText) findViewById(R.id.d3);

            editor.putString("a1",a1.getText().toString());
            editor.putString("b1",b1.getText().toString());
            editor.putString("c1",c1.getText().toString());
            editor.putString("c2",c2.getText().toString());
            editor.putString("a2",a2.getText().toString());
            editor.putString("b2",b2.getText().toString());
            editor.putString("c3",c3.getText().toString());
            editor.putString("a3",a3.getText().toString());
            editor.putString("b3",b3.getText().toString());
            editor.putString("d1",d1.getText().toString());
            editor.putString("d2",d2.getText().toString());
            editor.putString("d3",d3.getText().toString());

            editor.commit();

            Toast.makeText(this,getString(R.string.saved),Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.restore){
try {
    EditText a1 = (EditText) findViewById(R.id.a1);
    EditText b1 = (EditText) findViewById(R.id.b1);
    EditText c1 = (EditText) findViewById(R.id.c1);
    EditText a2 = (EditText) findViewById(R.id.a2);
    EditText b2 = (EditText) findViewById(R.id.b2);
    EditText c2 = (EditText) findViewById(R.id.c2);
    EditText a3 = (EditText) findViewById(R.id.a3);
    EditText b3 = (EditText) findViewById(R.id.b3);
    EditText c3 = (EditText) findViewById(R.id.c3);
    EditText d1 = (EditText) findViewById(R.id.d1);
    EditText d2 = (EditText) findViewById(R.id.d2);
    EditText d3 = (EditText) findViewById(R.id.d3);

    TextView an = (TextView) findViewById(R.id.textView5);

    a1.setText(sp.getString("a1", ""));
    a2.setText(sp.getString("a2", ""));
    a3.setText(sp.getString("a3", ""));
    b1.setText(sp.getString("b1", ""));
    b2.setText(sp.getString("b2", ""));
    b3.setText(sp.getString("b3", ""));
    c1.setText(sp.getString("c1", ""));
    c2.setText(sp.getString("c2", ""));
    c3.setText(sp.getString("c3", ""));
    d1.setText(sp.getString("d1", ""));
    d2.setText(sp.getString("d2", ""));
    d3.setText(sp.getString("d3", ""))
    ;
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
        sp= getSharedPreferences("sssp",MODE_MULTI_PROCESS);
        editor=sp.edit();
        setContentView(R.layout.activity_simul2);
        Toolbar cb=(Toolbar)findViewById(R.id.cb);
        cb.setTitleTextColor(Color.WHITE);
        setSupportActionBar(cb);
        ActionBar ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.backicon);
        ab.setTitle(getResources().getString(R.string.Equationsol));
        NavigationView navigationView = (NavigationView) findViewById(R.id.nview);
        navigationView.setNavigationItemSelectedListener(this);
    }
    public void sol2(View view){
        try {
            EditText a1 = (EditText) findViewById(R.id.a1);
            EditText b1 = (EditText) findViewById(R.id.b1);
            EditText c1 = (EditText) findViewById(R.id.c1);
            EditText a2 = (EditText) findViewById(R.id.a2);
            EditText b2 = (EditText) findViewById(R.id.b2);
            EditText c2 = (EditText) findViewById(R.id.c2);
            EditText a3 = (EditText) findViewById(R.id.a3);
            EditText b3 = (EditText) findViewById(R.id.b3);
            EditText c3 = (EditText) findViewById(R.id.c3);
            EditText d1 = (EditText) findViewById(R.id.d1);
            EditText d2 = (EditText) findViewById(R.id.d2);
            EditText d3 = (EditText) findViewById(R.id.d3);
            String ans = "";
            //double A1,B1,C1,D1,A2,B2,C2,D2,A3,B3,C3,D3;
            //A1=a1.getText().toString()==""?0.0:Double.parseDouble(a1.getText().toString());
            ans = sim2(Double.parseDouble(a1.getText().toString()), Double.parseDouble(a2.getText().toString()), Double.parseDouble(a3.getText().toString()), Double.parseDouble(b1.getText().toString()), Double.parseDouble(b2.getText().toString()), Double.parseDouble(b3.getText().toString()), Double.parseDouble(c1.getText().toString()), Double.parseDouble(c2.getText().toString()), Double.parseDouble(c3.getText().toString()), Double.parseDouble(d1.getText().toString()), Double.parseDouble(d2.getText().toString()), Double.parseDouble(d3.getText().toString()));

            TextView an = (TextView) findViewById(R.id.textView5);


            if (ans.contains("NaN") || ans.contains("Infinity")) {
                ans = getResources().getString(R.string.error);
            }
            an.setText(ans);
        }catch (Exception e){
            TextView AN=(TextView)findViewById(R.id.textView5);
            AN.setText(getResources().getString(R.string.error));
        }
    }
    public  String sim2(double a1,double a2,double a3,double b1,double b2,double b3,double c1,double c2,double c3,double d1,double d2, double d3){

        double t1=0,t2=0,t3=0,t0=0,x1=0,y=0,z=0;
        String an;
        t0=(a1*((b2*c3)-(c2*b3)))-(b1*((a2*c3)-(a3*c2)))+(c1*((a2*b3)-(a3*b2)));
        t1=(d1*((b2*c3)-(c2*b3)))-(b1*((d2*c3)-(d3*c2)))+(c1*((d2*b3)-(d3*b2)));
        t2=(a1*((d2*c3)-(c2*d3)))-(d1*((a2*c3)-(a3*c2)))+(c1*((a2*d3)-(a3*d2)));
        t3=(a1*((b2*d3)-(d2*b3)))-(b1*((a2*d3)-(a3*d2)))+(d1*((a2*b3)-(a3*b2)));

        x1=t1/t0;
        y=t2/t0;
        z=t3/t0;

        an="x\u2081="+String.valueOf(x1)+"  x\u2082="+String.valueOf(y)+"   x\u2083="+String.valueOf(z);

        return an;
    }
    public void reset(View view){

        EditText a1 = (EditText) findViewById(R.id.a1);
        EditText b1 = (EditText) findViewById(R.id.b1);
        EditText c1 = (EditText) findViewById(R.id.c1);
        EditText a2 = (EditText) findViewById(R.id.a2);
        EditText b2 = (EditText) findViewById(R.id.b2);
        EditText c2 = (EditText) findViewById(R.id.c2);
        EditText a3 = (EditText) findViewById(R.id.a3);
        EditText b3 = (EditText) findViewById(R.id.b3);
        EditText c3 = (EditText) findViewById(R.id.c3);
        EditText d1 = (EditText) findViewById(R.id.d1);
        EditText d2 = (EditText) findViewById(R.id.d2);
        EditText d3 = (EditText) findViewById(R.id.d3);

        TextView an=(TextView)findViewById(R.id.textView5);

        a1.setText("");
        a2.setText("");
        a3.setText("");
        b1.setText("");
        b2.setText("");
        b3.setText("");
        c1.setText("");
        c2.setText("");
        c3.setText("");
        d1.setText("");
        d2.setText("");
        d3.setText("");

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
