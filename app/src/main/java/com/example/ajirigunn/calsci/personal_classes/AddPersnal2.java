package com.example.ajirigunn.calsci.personal_classes;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ajirigunn.calsci.R;

import java.util.ArrayList;
import java.util.List;

public class AddPersnal2 extends AppCompatActivity {

    private List<String> m2=new ArrayList<String>();
    public String input = "";
    public String anss="0";
    public String[] aray={"","","","","","","",""};
    public int count=0;
    public String rep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_persnal2);
        Bundle objdata=getIntent().getExtras();


        rep=(objdata.getString("replace")!=null?objdata.getString("replace"):"no");
        //String[] valss=toArr bay(String.class,objdata.getSerializable("variables"));
        //    SimpleAdapter gd=new SimpleAdapter(this,android.R.layout.simple_list_item_1,);

        Intent incoming=getIntent();
        if (objdata!=null){
            m2=(ArrayList<String>)incoming.getSerializableExtra("newobject");

        }




        final Button b1=(Button)findViewById(R.id.b1);
        final Button b2=(Button)findViewById(R.id.b2);

        final Button b3=(Button)findViewById(R.id.b3);
        final Button b4=(Button)findViewById(R.id.b4);
        final Button b5=(Button)findViewById(R.id.b5);
        final Button b6=(Button)findViewById(R.id.b6);
        final Button b7=(Button)findViewById(R.id.b7);
        final Button b8=(Button)findViewById(R.id.b8);

        final TextView mi=(TextView)findViewById(R.id.inputi);
        mi.setText(m2.get(1)+"=");

        final TextView min=(TextView)findViewById(R.id.inputa);
        input+=min.getText().toString();
        if (m2.get(2).toString().length()>0){
            b1.setText(m2.get(2));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                b1.setBackground(getResources().getDrawable(R.drawable.varbutton));
            }else{
                b1.setBackgroundColor(Color.GRAY);
            }
            aray[0]=m2.get(2).toString();
            count++;
        }if (!m2.get(3).toString().matches("")){
            b2.setText(m2.get(3).toString());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                b2.setBackground(getResources().getDrawable(R.drawable.varbutton));
            }else{
                b2.setBackgroundColor(Color.GRAY);
            }
            aray[1]=m2.get(3).toString();
            count++;
        }if (!m2.get(4).toString().matches("")){
            b3.setText(m2.get(4).toString());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                b3.setBackground(getResources().getDrawable(R.drawable.varbutton));
            }else{
                b3.setBackgroundColor(Color.GRAY);
            }
            aray[2]=m2.get(4).toString();
            count++;
        }if (!m2.get(5).toString().matches("")){
            b4.setText(m2.get(5).toString());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                b4.setBackground(getResources().getDrawable(R.drawable.varbutton));
            }else{
                b4.setBackgroundColor(Color.GRAY);
            }
            aray[3]=m2.get(5).toString();
            count++;
        }if (!m2.get(6).toString().matches("")){
            b5.setText(m2.get(6));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                b5.setBackground(getResources().getDrawable(R.drawable.varbutton));
            }else{
                b5.setBackgroundColor(Color.GRAY);
            }
            aray[4]=m2.get(6).toString();
            count++;
        }if (!m2.get(7).toString().matches("")){
            b6.setText(m2.get(7));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                b6.setBackground(getResources().getDrawable(R.drawable.varbutton));
            }else{
                b6.setBackgroundColor(Color.GRAY);
            }
            aray[5]=m2.get(7).toString();
            count++;
        }if (!m2.get(8).toString().matches("")){
            b7.setText(m2.get(8));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                b7.setBackground(getResources().getDrawable(R.drawable.varbutton));
            }else{
                b7.setBackgroundColor(Color.GRAY);
            }
            aray[6]=m2.get(8).toString();
            count++;
        }/*if (!m2.get(9).toString().matches("")){
            b8.setText(m2.get(9));
            b8.setBackgroundColor(Color.GRAY);
            aray[7]=m2.get(9).toString();
            count++;
        }*/
        b1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        if (b1.getText().toString().trim().length()>0) {
                            input += b1.getText().toString();
                            min.setText(input);
                        }
                    }


                });
        b2.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        if (b2.getText().toString().trim().length()>0) {
                            input += b2.getText().toString();
                            min.setText(input);
                        }
                    }


                });
        b3.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        if (b3.getText().toString().trim().length()>0) {
                            input += b3.getText().toString();
                            min.setText(input);
                        }
                    }


                });
        b4.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        if (b4.getText().toString().trim().length()>0) {
                            input += b4.getText().toString();
                            min.setText(input);
                        }
                    }


                });
        b5.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        if (b5.getText().toString().trim().length()>0) {
                            input += b5.getText().toString();
                            min.setText(input);
                        }
                    }


                });
        b6.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        if (b6.getText().toString().trim().length()>0) {
                            input += b6.getText().toString();
                            min.setText(input);
                        }
                    }


                });
        b7.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        if (b7.getText().toString().trim().length()>0) {
                            input += b7.getText().toString();
                            min.setText(input);
                        }
                    }


                });
        b8.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        if (b8.getText().toString().trim().length()>0) {
                            input += b8.getText().toString();
                            min.setText(input);
                        }
                    }


                });


    }

    public void done(View view){

        myfunctionsdatabase db=new myfunctionsdatabase(this,null,null,1);
        TextView inp=(TextView)findViewById(R.id.inputa);
        TextView ip=(TextView)findViewById(R.id.inputi);
        myfunctions realfun=new myfunctions(m2.get(0).toString());
        realfun.setEquation(ip.getText().toString()+inp.getText().toString());
        realfun.setResult(m2.get(1).toString());
        realfun.setVariables(aray  );
        realfun.setVarcount(count);
        if (rep.matches("no")) {
            db.addfun(realfun);
        }else if(rep.matches("yes")){
            int i=db.deletefun(realfun.getName());
            db.addfun(realfun);
        }
        //Intent b=new Intent(AddPersnal2.this,Personal.class);

        startActivity(new Intent(AddPersnal2.this,Personal.class));
        finish();
    }
    public void adde1(View view) {
        input += "1";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void add2(View view) {
        input += "2";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void add3(View view) {
        input += "3";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void add4(View view) {
        input += "4";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void add5(View view) {
        input += "5";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void add6(View view) {
        input += "6";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void add7(View view) {
        input += "7";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void add8(View view) {
        input += "8";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void add9(View view) {
        input += "9";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void add0(View view) {
        input += "0";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void plus(View view) {


        if (input==""&&anss!="0"){
            input+="ans+";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }else {
            input += "+";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }
    }
    public void inverse(View view){
        if (input==""&&anss!="0"){
            input+="ans\u207B\u00B9";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }else {
            input += "\u207B\u00B9";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }
    }
    public void sq(View view){
        if (input==""&&anss!="0"){
            input+="ans\u00B2";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }else {
            input += "\u00B2";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }
    }

    public void cu(View view){
        if (input==""&&anss!="0"){
            input+="ans\u00B3";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }else {
            input += "\u00B3";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }
    }
    public void minus(View view) {

        if (input==""&&anss!="0"){
            input+="ans-";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }else {
            input += "-";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }

    }

    public void multiply(View view) {

        if (input==""&&anss!="0"){
            input+="ans*";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }else {
            input += "*";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }

    }

    public void divide(View view) {

        if (input==""&&anss!="0"){
            input+="ans/";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }else {
            input += "/";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }

    }

    public void open(View view) {
        input += "(";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void close(View view) {
        input += ")";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void power(View view) {

        if (input==""&&anss!="0"){
            input+="ans^";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }else {
            input += "^";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }

    }

    public void factorial(View view) {
        if (input==""&&anss!="0"){
            input+="ans!";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }else {
            input += "!";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }
    }

    public void sin(View view) {
        input += "sin";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void cos(View view) {
        input += "cos";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void tan(View view) {
        input += "tan";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void log(View view) {
        input += "log";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void asin(View view) {
        input += "Asin";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void acos(View view) {
        input += "Acos";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void atan(View view) {
        input += "Atan";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void alog(View view) {
        input += "Alog";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void exp(View view) {
        input += "e";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void ln(View view) {
        input += "ln";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void pi(View view) {
        input += "\u03C0";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void ans(View view) {
        input += "ans";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }

    public void E(View view) {
        if (input==""&&anss!="0"){
            input+="ansE";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }else {
            input += "E";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }
    }
    public void clicked(View view){
        TextView in=(TextView)findViewById(R.id.inputa);
        input=in.getText().toString();

    }

    public void cls(View view) {
        input = "";
        anss="0";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);

    }

    public void backspace(View view) {

        String temp = "";
        TextView Input = (TextView) findViewById(R.id.inputa);


        if (input.length()==1){
            input="";
            Input.setText("");
        }

        if (input.length() > 0) {


            if ((input.length() >= 2) && (input.charAt((input.length() - 1)) == '\u00B9')) {//TO DELETE INVERSE
                temp = input.substring(0, (input.length() - 1));
                input = temp;
                Input.setText(input);
            }

            if ((input.length() >= 2) && (input.charAt((input.length() - 2)) == 'l')) {
                temp = input.substring(0, (input.length() - 2));
                input = temp;
                Input.setText(input);
            } else if ((input.length() >= 4) && ((input.charAt(input.length() - 4)) == 'A')) {
                temp = input.substring(0, (input.length() - 4));
                input = temp;
                Input.setText(input);
            } else if ((input.length() >= 3) && ((input.charAt(input.length() - 2) == 'i' ||input.charAt(input.length() - 1) == 'g' || (input.charAt(input.length() - 1)) == 's' || (input.charAt(input.length() - 3)) == 'c' || (input.charAt(input.length() - 3)) == 't')))
            {
                temp = input.substring(0, (input.length() - 3));
                input = temp;
                Input.setText(input);
            } else {
                temp = input.substring(0, (input.length() - 1));
                input = temp;
                //TextView Input=(TextView)findViewById(R.id.input);
                Input.setText(input);

            }
        } else {
            String temper = "";
            Input.setText(temper);
        }

    }


    public void cbrt(View view){

        if (input==""&&anss!="0"){
            input+="\u221Bans";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }else {
            input += "\u221B";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }
    }

    public void sqrt(View view){

        if (input==""&&anss!="0"){
            input+="\u221Aans";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }else {
            input += "\u221A";
            TextView Input = (TextView) findViewById(R.id.inputa);
            Input.setText(input);
        }
    }


    public void decimal(View view) {
        input += ".";
        TextView Input = (TextView) findViewById(R.id.inputa);
        Input.setText(input);
    }
    public void backback(View view){
        input="";
        TextView Input=(TextView) findViewById(R.id.inputa);
        Input.setText("");
    }
}
