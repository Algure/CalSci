package com.example.ajirigunn.calsci.personal_classes;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ajirigunn.calsci.Calculator;
import com.example.ajirigunn.calsci.Converter;
import com.example.ajirigunn.calsci.Equations;
import com.example.ajirigunn.calsci.R;
import com.example.ajirigunn.calsci.homeclasses.gunnermain;

import java.util.ArrayList;

public class Personal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    myfunctionsdatabase mydb=new myfunctionsdatabase(this,null,null,1);

    public void delete(View view){
        TextView it=(TextView)findViewById(R.id.mytext);
        String obj=it.getText().toString();
        int i=0;
        i=mydb.deletefun(obj);
        ArrayList<String> option=new ArrayList<String>();
        Cursor c=mydb.getallrows();
        while(c.moveToNext()){
            option.add(c.getString(0));
        }
        ListView lv=(ListView)findViewById(R.id.dblistview);
        String[] f=option.toArray(new String[option.size()]);
        ListAdapter gunnsadapter=new customadapter(this,f);
        lv.setAdapter(gunnsadapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal2);
        TextView prompt=(TextView)findViewById(R.id.addprompt);
        myfunctionsdatabase myfun=new myfunctionsdatabase(this,null,null,1);
        if (myfun.countallrows()!=-1){
            prompt.setTextColor(Color.WHITE);
        }
        Toolbar cb=(Toolbar)findViewById(R.id.cb) ;
        cb.setTitleTextColor(Color.WHITE);
        setSupportActionBar(cb);
        ActionBar ab=getSupportActionBar();
        ab.setTitle(getResources().getString(R.string.myfunctions));
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.backicon);
        NavigationView nv=(NavigationView)findViewById(R.id.nview);
        nv.setNavigationItemSelectedListener(this);
        //TabLayout tb=(TabLayout)findViewById(R.id.tl);

    }
    public void addequation(View view){
        myfunctionsdatabase myfun=new myfunctionsdatabase(this,null,null,1);
        Intent i=new Intent(this,AddPersonal.class);
        i.putExtra("tbartitle", getResources().getString(R.string.addfun));
        i.putExtra("title",(getResources().getString(R.string.function)+String.valueOf(myfun.countallrows()+1)));
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ArrayList<String> option=new ArrayList<String>();
        try {
            Cursor c = mydb.getallrows();
            while (c.moveToNext()) {
                option.add(c.getString(0));
            }
            ListView lv = (ListView) findViewById(R.id.dblistview);
            String[] f = option.toArray(new String[option.size()]);
            ListAdapter gunnsadapter = new customadapter(this, f);
            lv.setAdapter(gunnsadapter);
        }catch (Exception e){
            Log.i("error",e.toString());
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        ListView lv=(ListView)findViewById(R.id.dblistview);
        String[] output={"yo","bestie"};
        int rowcount=0;
        ArrayList<String> option=new ArrayList<String>();

        Cursor c=mydb.getallrows();
        while(c.moveToNext()){
            option.add(c.getString(0));
        }

        String[] f=option.toArray(new String[option.size()]);
        ListAdapter gunnsadapter=new customadapter(this,f);
        lv.setAdapter(gunnsadapter);
        // Toast.makeText(Personal.this,option.get(option.size()-1).toString(),Toast.LENGTH_LONG).show();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item=adapterView.getItemAtPosition(i).toString();
                Cursor c=mydb.getdata(item);

                c.moveToLast();
                String m=c.getString(0).toString();
                String vars=c.getString(1).toString();

                String[] variables=vars.split(",");
                variables[0]=variables[0].replace("[","");
                variables[variables.length-1]=variables[variables.length-1].replace("]","");

                Intent mine=new Intent(Personal.this,Central_personal.class);
                mine.putExtra("function_name",item);
                mine.putExtra("function_position",m);
                mine.putExtra("variables",variables);

                startActivity(mine);
                finish();
            }
        });
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
