package com.example.ajirigunn.calsci.Equations_activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.example.ajirigunn.calsci.processing;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class Cubic extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnKeyListener,processing.OnFragmentInteractionListener {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.eqmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
SharedPreferences sp;

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        SharedPreferences.Editor editor=sp.edit();
        if(item.getItemId()==R.id.savevals){

            EditText a0 = (EditText) findViewById(R.id.a1);
            EditText b0 = (EditText) findViewById(R.id.a2);
            EditText c0 = (EditText) findViewById(R.id.a3);
            EditText d0 = (EditText) findViewById(R.id.b);
            String as = (a0.getText().toString());
            String bs =(b0.getText().toString());
            String cs =(c0.getText().toString());
            String ds = (d0.getText().toString());

            editor.putString("a",as);
            editor.putString("b",bs);
            editor.putString("c",cs);
            editor.putString("d",ds);
            editor.commit();

            Toast.makeText(this,getString(R.string.saved),Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.restore){
            try {
                EditText a0 = (EditText) findViewById(R.id.a1);
                EditText b0 = (EditText) findViewById(R.id.a2);
                EditText c0 = (EditText) findViewById(R.id.a3);
                EditText d0 = (EditText) findViewById(R.id.b);
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
        sp=getSharedPreferences("pp",MODE_MULTI_PROCESS);
        setContentView(R.layout.activity_cubic);
        Toolbar cb=(Toolbar)findViewById(R.id.cb);
        cb.setTitleTextColor(Color.WHITE);
        setSupportActionBar(cb);
        ActionBar ab=getSupportActionBar();
        ab.setTitle(getResources().getString(R.string.Equationsol));
        ab.setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nview);
        navigationView.setNavigationItemSelectedListener(this);
        EditText et=(EditText)findViewById(R.id.a1);
        et.setOnKeyListener(this);
        fm=this.getSupportFragmentManager();
        ab.setHomeAsUpIndicator(R.drawable.backicon);
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

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {


            return false;
    }
    public void reset(View v){
        EditText a0=(EditText)findViewById(R.id.a1);
        EditText b0=(EditText)findViewById(R.id.a2);
        EditText c0=(EditText)findViewById(R.id.a3);
        EditText d0 =(EditText)findViewById(R.id.b);
        TextView answer=(TextView)findViewById(R.id.textView5);
        a0.setText("");
        b0.setText("");
        c0.setText("");
        d0.setText("");
        answer.setText("");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public class cubesolve extends AsyncTask<String,Void,String>{
//        @Override
//        protected String doInBackground(double a,double b,double c,double d) {
//
//            String ans=cubesolve(a,b,c,d);
//        }

        @Override
        protected String doInBackground(String[] objects) {
            String ans=cubesolve(a,b,c,d);

            return ans;
        }

        @Override
        protected void onPostExecute(String o) {
            TextView answer=(TextView)findViewById(R.id.textView5);
            answer.setText(o);
        }
    }
    double a;
    double b;
    double c;
    double d;
    FragmentManager fm;
    String ans="";

    public void solve(View v){
        cond=true;
    try {
        processing pr = new processing();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.pr, pr, "pr");
        ft.commit();

        EditText a0 = (EditText) findViewById(R.id.a1);
        EditText b0 = (EditText) findViewById(R.id.a2);
        EditText c0 = (EditText) findViewById(R.id.a3);
        EditText d0 = (EditText) findViewById(R.id.b);
        a = Double.parseDouble(a0.getText().toString());
        b = Double.parseDouble(b0.getText().toString());

        c = Double.parseDouble(c0.getText().toString());
        d = Double.parseDouble(d0.getText().toString());

        Runnable s = new Runnable() {
            @Override
            public void run() {
                ans = cubesolve(a, b, c, d);
                handler.sendEmptyMessage(0);

            }
        };
        Thread td = new Thread(s);
        td.start();
    }catch (Exception e){
        TextView answer = (TextView) findViewById(R.id.textView5);
        answer.setText(getResources().getString(R.string.error));
    }
//        ft.remove(pr);
//        ft.commit();
    }
    public FragmentManager ft=this.getSupportFragmentManager();
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (!ans.matches("")&&cond) {
                TextView answer = (TextView) findViewById(R.id.textView5);
                answer.setText(ans);

                processing p= (processing) ft.findFragmentByTag("pr");
                FragmentTransaction f=ft.beginTransaction();
                f.remove(p);
                f.commit();
            }
        }
    };
    public void startt(){
        processing pr =new processing();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.pr,pr,"pr");
        ft.commit();
    }
    public boolean cond=true;
    public void stopp(View view){

        FragmentManager ft=this.getSupportFragmentManager();
        processing p= (processing) ft.findFragmentByTag("pr");
        FragmentTransaction f=ft.beginTransaction();
        f.remove(p);
        f.commit();
cond=false;
    }
    public static String cubesolve(double a,double b,double c,double d){

        double df=d/a;
        boolean found=false;
        double root=0.0,tester=0;
        double div=1;
        df=df/interval(df);
        double i=0;
        if (df<0){
            df=df-1;}
        else {
            df+=1;
        }
        while (!found){

            if (df>0){
                for (double u=0;u<Math.abs(df);u+=div){

                    //if (df>0){
                    i=u*-1;

                    tester=(a*i*i*i)+(b*i*i)+(c*i)+d;
                    if (Math.abs(tester)<=0.000001){
                        root=i;
                        found=true;
                        break;
                    }
                }}
            else if(df<0){
                for (double u=0;u>df;u-=div){

                    //if (df>0){
                    i=u*-1;

                    tester=(a*i*i*i)+(b*i*i)+(c*i)+d;
                    if (Math.abs(tester)<=0.000001){
                        root=i;
                        found=true;
                        break;
                    }
                }
            }
            div/=10;
        }
        String other2=quadsol(root,(b/a),(c/a));
        return "x\u2081="+String.valueOf(root)+",\n "+other2  ;
    }
    public static double interval(double a){
        String number=String.valueOf(a);
        int v=1,tracker=0;
        if(number.contains("E")){

            int k=number.indexOf("E");
            String t1,t2,t3;
            t1=number.substring(k);
            t2="1"+t1;
            return Double.parseDouble(t2);
        }
        else if (numcondition(number.charAt(0))){
            return 1;
        }else{

            for (int y=0;y<number.length();y++){

                if(number.charAt(y)=='0'){
                    //   v+=1;
                }else if(number.charAt(y)=='.'||numcondition(number.charAt(y))){
                    tracker=y;
                    break;
                }
            }
            v=1;
            if (!numcondition(number.charAt(tracker))){
                for (int y=tracker+1;y<number.length();y++){

                    if (number.charAt(y)=='0'){
                        v++;
                    }else if(numcondition(number.charAt(y))){
                        break;
                    }
                }
            }
            return (1/Math.pow(10,v));
        }
    }
    public static String quadsol(double q,double a,double  b){

        double x1,x2,D,a1,b1,c1;
        a1=1;
        b1=a+q;
        c1=b+(a*q)+(q*q);
        D=Math.sqrt(b1*b1-(4*a1*c1));
        x1=(-b1+D)/(2*a1);
        x2=(-b1-D)/(2*a1);
x2=Math.round(x2*1000000);
        x1=Math.round(x1*1000000);
        x2=x2/1000000;
        x1=x1/1000000;
        return "x\u2082="+String.valueOf(x2)+",\nx\u2083= "+String.valueOf(x1);
    }
    public static Boolean numcondition(char i){

        Boolean numcond=(i=='3'||i=='1'||i=='2'||i=='4'||i=='5'||i=='6'||i=='7'||i=='8'||i=='9');
        return(numcond);

    }
}
