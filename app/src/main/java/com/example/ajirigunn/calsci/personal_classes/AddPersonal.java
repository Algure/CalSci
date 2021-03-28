package com.example.ajirigunn.calsci.personal_classes;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajirigunn.calsci.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddPersonal extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public int tracker=0;
    public List<String> m1=new ArrayList<String>();
    public String ttle;


    public void reset (View view){
        startActivity(new Intent(AddPersonal.this,AddPersonal.class));
        finish();
    }//registers all number characters
    public  Boolean numcon(char i){

        Boolean numcond=(i=='3'||i=='1'||i=='2'||i=='4'||i=='5'||i=='6'||i=='7'||i=='8'||i=='9'||i=='0'||i=='.');
        return(numcond);

    }
    public void addvariable(View view){

        try{


            myfunctionsdatabase db=new myfunctionsdatabase(this,null,null,1);
            if(!ttle.matches("")){
                int i=db.deletefun(ttle);

            }

            Button entry=(Button)findViewById(R.id.add);
            //EditText nov=(EditText)findViewById(R.id.nov);
            TextView vars=(TextView)findViewById(R.id.Vars);
            EditText userinput=(EditText)findViewById(R.id.entervar);
            String varstring=vars.getText().toString();
            String input=userinput.getText().toString();
            myfunctionsdatabase mydb=new myfunctionsdatabase(this,null,null,1);
            ArrayList<String> option=new ArrayList<String>();

            Cursor c=mydb.getallrows();
            while(c.moveToNext()){
                option.add(c.getString(0));
            }
            ActionBar ab=getSupportActionBar();
            String abname=ab.getTitle().toString();
            int t= konstant;
            EditText nam=(EditText)findViewById(R.id.nax);
            EditText var=(EditText)findViewById(R.id.var);
           // Toast.makeText(this,String.valueOf(konstant),Toast.LENGTH_LONG).show();
            if(nam.getText().toString().replaceAll(" ","").matches("")||userinput.getText().toString().replaceAll(" ","").matches("")
                    ||var.getText().toString().replaceAll(" ","").matches("")){
                Toast.makeText(AddPersonal.this, getResources().getString(R.string.fields), Toast.LENGTH_LONG).show();
            }else if (option.contains(nam.getText().toString())&&(!abname.matches("Edit_Function"))){
                Toast.makeText(this,getResources().getString(R.string.unique),Toast.LENGTH_LONG).show();
            }else if(numcon(userinput.getText().toString().charAt(0)))
            {

                Toast.makeText(this,getResources().getString(R.string.notallowed),Toast.LENGTH_LONG).show();
            }            else if (t>1){
                if(tracker==0){


                    m1.add(nam.getText().toString());

                    m1.add(var.getText().toString());
                }
                if(true&&tracker<t){
                    varstring+=input+"\n";
                    vars.setText(varstring);
                    userinput.setText("");
                    userinput.setHint((getResources().getString(R.string.enternextvar)));
                    m1.add(input.matches("a")?input:input.toUpperCase());
                    tracker++;
                }


                Intent n=new Intent(AddPersonal.this,AddPersnal2.class);
                n.putExtra("variables", (Serializable) m1);

                if(entry.getText().toString().matches("DONE")){
                    m1.add("");
                    m1.add("");
                    m1.add("");
                    m1.add("");
                    m1.add("");
                    m1.add("");
                    m1.add("");
                    m1.add("");


                    n.putExtra("newobject", (Serializable) m1);

                    startActivity(n);
                    finish();
                }
                if(tracker==(t-1)){
                    entry.setText("DONE");
                    userinput.setText("");
                    //userinput.setHint("DONE");
                }}
            else if (t==1){
                if(tracker==0){

                    m1.add(nam.getText().toString());

                    m1.add(var.getText().toString());
                }if(true&&tracker<t){
                    varstring+=input+"\n";
                    vars.setText(varstring);
                    userinput.setText("");
                    userinput.setHint((getResources().getString(R.string.enternextvar)));
                    m1.add(input.matches("a")?input:input.toUpperCase());
                    tracker++;
                }
                Intent n=new Intent(AddPersonal.this,AddPersnal2.class);
                n.putExtra("variables", (Serializable) m1);

                if(tracker==1){
                    m1.add("");
                    m1.add("");
                    m1.add("");
                    m1.add("");
                    m1.add("");
                    m1.add("");
                    m1.add("");
                    m1.add("");


                    n.putExtra("newobject", (Serializable) m1);

                    startActivity(n);
                    finish();
                }
            }}catch (Exception e){
            Log.i("gbvgvg",e.toString());

        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_personal);
        Bundle newb=getIntent().getExtras();
        myfunctionsdatabase myfun=new myfunctionsdatabase(this,null,null,1);
        ttle=(newb!=null?newb.getString("title"):(getResources().getString(R.string.function)+String.valueOf(myfun.countallrows()+1)));
        EditText title=(EditText)findViewById(R.id.nax);
        title.setText(ttle);
        Toolbar cb=(Toolbar)findViewById(R.id.cb);
        cb.setTitleTextColor(Color.WHITE);
        setSupportActionBar(cb);
      ActionBar ab=getSupportActionBar();
       // ab.setHomeAsUpIndicator(R.drawable.backicon);
        ab.setTitle(newb.getString("tbartitle"));
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
        Spinner spinner =(Spinner)findViewById(R.id.nov);

        String[] n={"1","2","3","4","5","6"};
        ArrayAdapter<CharSequence> adapter= new pickeradapter(this,n);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        //Toast.makeText(this,String.valueOf(myfun.countallrows()),Toast.LENGTH_LONG).show();
    }

    int konstant=1;
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String item= (String) adapterView.getItemAtPosition(i);

        if (item.matches("1")){
            konstant=1;
        }else if(item.matches("2")){
            konstant=2;
        }else if(item.matches("3")){
            konstant=3;
        }else if(item.matches("4")){
            konstant=4;
        }else if(item.matches("5")){
            konstant=5;
        }else if(item.matches("6")){
            konstant=6;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
