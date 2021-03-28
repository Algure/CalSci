package com.example.ajirigunn.calsci;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajirigunn.calsci.homeclasses.gunnermain;
import com.example.ajirigunn.calsci.personal_classes.Personal;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class Calculator extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,DrawerLayout.DrawerListener{

        HorizontalScrollView hsview;
    TextView ttview;
int scrollspan;
    public String input = "";
    public String anss="0";
    public void Calculator(View v){
        startActivity( new Intent(this,Calculator.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
notleft=true;


       // TextView c=(TextView)findViewById(R.id.input);


        //hsview.fullScroll(View.FOCUS_RIGHT);

        setContentView(R.layout.activity_calculator);
        TextView tv=(TextView)findViewById(R.id.input);
        //tv.setMovementMethod(new ScrollingMovementMethod());

        changed=false;
       tv.setHorizontallyScrolling(true);
        tv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                scrol();
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });
        try {
           Toolbar cb = (Toolbar) findViewById(R.id.cb);
           cb.setTitleTextColor(Color.WHITE);
           setSupportActionBar(cb);
           ActionBar ab = getSupportActionBar();
           ab.setTitle("Calculator");
           ab.setDisplayHomeAsUpEnabled(true);
            ab.setHomeAsUpIndicator(R.drawable.backicon);
       }catch (Exception e){}
       // ab.setHideOnContentScrollEnabled(true);
       NavigationView navigationView = (NavigationView) findViewById(R.id.nview);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    Handler scrolhandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            hsview.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
        }
    };
    public void scrol(View v){
        HorizontalScrollView hsview= (HorizontalScrollView) findViewById(R.id.hsview);
        hsview.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
        //scrol(v);
    }
    public void scrol(){
        HorizontalScrollView hsview= (HorizontalScrollView) findViewById(R.id.hsview);
        hsview.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
        //scrol(v);
    }

    boolean notleft;
boolean changed;

    static String txvt="";
    static  String txvt2="";
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.undo){
            TextView inpt=(TextView)findViewById(R.id.input);
            inpt.setText(txvt);
            input=txvt;
            txvt=txvt2;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View v) {

        v. bringToFront();
        v.requestLayout();
    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // String mystring=savedInstanceState.getString("MyString");
        // String instring=savedInstanceState.getString("instring");

        TextView output=(TextView)findViewById(R.id.textView2);
        TextView inpt=(TextView)findViewById(R.id.input);

        //output.setText(mystring);
        //   input.setText(instring);

        if (inpt.getText().toString()!=""){
            input=inpt.getText().toString();
        }
        if (output.getText().toString()!=""){
            anss=output.getText().toString();
        }
    }
TextView Input;
    public void add1(View view) {
        scrol(view);
        input += "1";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
scrol(view);

    }

    public void add2(View view) {
        scrol(view);
        input += "2";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);
            }

    public void add3(View view) {
        scrol(view);
        input += "3";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);

    }

    public void add4(View view) {
        input += "4";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);

        //hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void add5(View view) {
        input += "5";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);

        //hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void add6(View view) {
        input += "6";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);

        scrol(view);
        //hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void add7(View view) {
        input += "7";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);

       // hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void add8(View view) {
        input += "8";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);

        scrol(view);
       // hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void add9(View view) {
        input += "9";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);

        scrol(view);
       // hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void add0(View view) {
        input += "0";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);

        //hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void plus(View view) {


        if (input==""&&anss!="0"){
            input+="ans+";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }else {
            input += "+";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        } changed=true;
        scrol(view);
    }
    public void inverse(View view){
        if (input==""&&anss!="0"){
            input+="ans\u207B\u00B9";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }else {
            input += "\u207B\u00B9";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }scrol(view);
       // hsview.fullScroll(View.FOCUS_RIGHT);
    }
    public void sq(View view){
        if (input==""&&anss!="0"){
            input+="ans\u00B2";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }else {
            input += "\u00B2";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }
        scrol(view);
    }

    public void cu(View view){
.0
        if (input==""&&anss!="0"){
            input+="ans\u00B3";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }else {
            input += "\u00B3";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }
        scrol(view);
    }
    public void minus(View view) {

        if (input==""&&anss!="0"){
            input+="ans-";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }else {
            input += "-";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }
        scrol(view);
    }

    public void multiply(View view) {

        if (input==""&&anss!="0"){
            input+="ans*";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }else {
            input += "*";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }
        scrol(view);
        //hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void divide(View view) {

        if (input==""&&anss!="0"){
            input+="ans/";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }else {
            input += "/";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }
        scrol(view);
        //hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void open(View view) {
        input += "(";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);
    }

    public void close(View view) {
        input += ")";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);


    }

    public void power(View view) {

        if (input==""&&anss!="0"){
            input+="ans^";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }else {
            input += "^";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }
        scrol(view);
       // hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void factorial(View view) {
        if (input==""&&anss!="0"){
            input+="ans!";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }else {
            input += "!";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }scrol(view);
      //  hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void sin(View view) {
        input += "sin";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);
        //hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void cos(View view) {
        input += "cos";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);
       // hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void tan(View view) {
        input += "tan";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);
       // hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void log(View view) {
        input += "log";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);
      //  hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void asin(View view) {
        input += "Asin";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);
      //  hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void acos(View view) {
        input += "Acos";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);
       // hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void atan(View view) {
        input += "Atan";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);
    }

    public void alog(View view) {
        input += "Alog";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);
       // hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void exp(View view) {
        input += "e";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);
        //hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void ln(View view) {
        input += "ln";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);
       // hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void pi(View view) {
        input += "\u03C0";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);
       // hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void ans(View view) {
        input += "ans";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
        scrol(view);
        //hsview.fullScroll(View.FOCUS_RIGHT);
    }

    public void E(View view) {
        if (input==""&&anss!="0"){
            input+="ansE";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }else {
            input += "E";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }
        scrol(view);
       // hsview.fullScroll(View.FOCUS_RIGHT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.gunnermenu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void clicked(View view){
        TextView in=(TextView)findViewById(R.id.input);
        input=in.getText().toString();

        in.setHorizontallyScrolling(true);
    }

    public void cls(View view) {
        input = "";
        anss="0";
        TextView Input = (TextView) findViewById(R.id.input);
        txvt2=txvt;
        txvt=Input.getText().toString();
        Input.setText(input);
        TextView text2 = (TextView) findViewById(R.id.textView2);
        text2.setText(input);
    }

    public void backspace(View view) {

        String temp = "";
        TextView Input = (TextView) findViewById(R.id.input);

        txvt2=txvt;
        txvt=Input.getText().toString();

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
          TextView t2=(TextView)findViewById(R.id.textView2);
          t2.setText("");
        }

    }


    public void cbrt(View view){

        if (input==""&&anss!="0"){
            input+="\u221Bans";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }else {
            input += "\u221B";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }
    }

    public void sqrt(View view){

        if (input==""&&anss!="0"){
            input+="\u221Aans";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }else {
            input += "\u221A";
            TextView Input = (TextView) findViewById(R.id.input);
            Input.setText(input);
        }
    }


    public void decimal(View view) {
        input += ".";
        TextView Input = (TextView) findViewById(R.id.input);
        Input.setText(input);
    }
    public void backback(View view){
        input="";
        TextView Input=(TextView) findViewById(R.id.input);
        Input.setText("");
    }
    //MY PRIDE recursive function to compute brackets and replace as number
    public  String brackets(String bracketinput,int i){//to be used in a loop
        String anstring="";
        String answer="";
        String ans="";
        String temp="";
        int k=i+1;
        int bend=0;
        temp=simplificationb(bracketinput);
        bracketinput=temp;
        temp="";
        while ((k<bracketinput.length())&&(bracketinput.charAt(k)!=')')){

            if(bracketinput.charAt(k)=='('){//recursion
                ans=brackets(bracketinput,k);
                bend=bracketendex(bracketinput,k);
                //bracketinput.replaceFirst(bracketinput.substring(k,bend), ans);
                //temp=bracketinput.substring((i+1),k)+ans+bracketinput.substring(bend+1);
                anstring+=ans;
                k=bend+1;
                continue;
            }

            anstring+=bracketinput.charAt(k);
            k++;

        }
        input=anstring;
        anstring = simplification1(input);
        answer = EP(anstring);
        anstring = simplification1(answer);
        answer = simplification1(anstring);
        anstring = transtrigcomputation(answer);
        answer = simplification1(anstring);
        anstring = exponent(answer);
        answer = simplification1(anstring);
        anstring = squareroot(answer);
        answer = simplification1(anstring);
        anstring = of(answer);
        answer = simplification1(anstring);

        anstring = division(answer);
        answer = simplification1(anstring);

        anstring = multiplication(answer);
        answer = simplification1(anstring);

        anstring = addition(answer);
        answer = simplification1(anstring);

        anstring = subtraction(answer);
        answer = simplification1(anstring);

        anstring=answer;

        if (anstring.startsWith("+"))
            return anstring.substring(1);
        else
            return anstring;
    }
    //registers all number characters
    public  Boolean numcon(char i){

        Boolean numcond=(i=='3'||i=='1'||i=='2'||i=='4'||i=='5'||i=='6'||i=='7'||i=='8'||i=='9'||i=='0'||i=='.');
        return(numcond);

    }
    //places "*" symbol if number or bracket comes before a bracket
    public  String simplificationb(String bracketinput){
        int k=0,count=0;
        String temp="";
        temp=bracketinput.replaceAll("\\)\\^", "\\)x");
        bracketinput


                =temp;
        while ((k<bracketinput.length())&&((k+1)<bracketinput.length())){
            if (numcondition(bracketinput.charAt(k))&&(bracketinput.charAt(k+1)=='(')){
                temp=bracketinput.substring(0,(k+1))+"o"+bracketinput.substring(k+1);
                count++;
            }else if(bracketinput.charAt(k)==')'&&numcon(bracketinput.charAt(k+1))){
                temp=bracketinput.substring(0,(k+1))+"o"+bracketinput.substring(k+1);
                count++;
            }else if(bracketinput.charAt(k)==')'&&(!operators(bracketinput.charAt(k+1)))){
                temp=bracketinput.substring(0,(k+1))+"o"+bracketinput.substring(k+1);
                count++;
            }else if((!operators(bracketinput.charAt(k))&&(bracketinput.charAt(k)!='\u221A'&&bracketinput.charAt(k)!='\u221B'))&&(bracketinput.charAt(k+1)=='(')){
                temp=bracketinput.substring(0,(k+1))+"o"+bracketinput.substring(k+1);
                count++;
            }else if((bracketinput.charAt(k)==')')&&(bracketinput.charAt(k+1)=='(')){
                temp=bracketinput.substring(0,(k+1))+"o"+bracketinput.substring(k+1);
                count++;
            }
            if((count>0)&&(bracketinput!=temp)){
                bracketinput=simplificationtotal(temp);
            }
            k++;
        }
        return bracketinput;
    }
    //gets the index of the relevant end bracket
    public  int bracketendex(String bracketinput,int i){//to be used in a loop
        String anstring="";
        String answer="";
        int k=i+1;
        int countb=1;
        while (true){

            if (bracketinput.charAt(k)=='(')
                countb++;
            if(bracketinput.charAt(k)==')')
                countb--;
            if (countb==0)
                break;
            k++;

        }

        /*while (k<bracketinput.length()){
            if (bracketinput.charAt(k)==')')
                countb--;
            if (countb==0)
                break;
            k++;
        }*/
        return k;
    }
    //registers absolutely all operators
    public  boolean operators(char i){
        boolean b=(i=='o'||i=='x'||i=='!'||i=='*'||i=='/'||i=='+'||i=='-'||i=='S'||i=='C'||i=='T'||i=='s'||i=='c'||i=='t'||i=='n'||i=='a'||i=='l'||i=='e'||i=='('||i==')'||i=='^');
        return b;
    }
    //computes all divisions in input string
    public String division(String input){
        double num1=0,num2=0,ans=0;
        int b=0,t1=0,t2=0;
        String anstring="";
        String temp="";
        int count=0;

        while (b<input.length()){
            if (input.charAt(b)=='/'){
                num1=getbacknumber(input,(b-1));
                num2=getfrontnumber(input,(b+1));
                ans=num1/num2;
                t1=getendex(input,(b-1));
                t2=getfrontex(input,(b+1));

                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,t1)+anstring+input.substring(t2+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,t1)+anstring+input.substring(t2+1);
                }
                b=1;
                count++;
            }
            if((count>0)&&(input!=temp)){
                input=simplification1(temp);
            }
            b++;
        }
        return input;
    }

    //computes all transcedental and trigonometric functions
    public  String transtrigcomputation(String input){
        double num2=0;
        double ans=0;
        double answer=0;
        int k=0,t1=0,t2=0;
        String anstring="",temp="";
        int i=0;
        int count=0;
        temp=transtrigcorrection(input);
        input=temp;
        temp="";
        while (i<input.length()){


            if (input.charAt(i)=='S'){
                count++;
                num2=getfrontnumber(input,(i+1));
                ans=Math.sin(num2*Math.PI/180);
                k=getfrontex(input,(i+1));

                if(answer>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);

                }else{
                    anstring=String.valueOf(answer);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);
                }
            }

            if (input.charAt(i)=='C'){
                count++;
                num2=getfrontnumber(input,(i+1));
                ans=Math.cos(num2*Math.PI/180);
                k=getfrontex(input,(i+1));

                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);
                }
            }
            if (input.charAt(i)=='T'){
                count++;
                num2=getfrontnumber(input,(i+1));
                ans=Math.tan(Math.toRadians(num2));
                k=getfrontex(input,(i+1));
                anstring=String.valueOf(ans);
                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);
                }
            }
            if (input.charAt(i)=='e'){
                count++;
                num2=getfrontnumber(input,(i+1));
                ans=Math.exp(num2);
                k=getfrontex(input,(i+1));
                anstring=String.valueOf(Math.abs(ans));
                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);
                }
            }
            if (input.charAt(i)=='t'){
                count++;
                num2=getfrontnumber(input,(i+1));
                ans=Math.atan(num2)*180/Math.PI;
                k=getfrontex(input,(i+1));
                anstring=String.valueOf(Math.abs(ans));
                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);
                }
            }
            if (input.charAt(i)=='s'){
                count++;
                num2=getfrontnumber(input,(i+1));
                ans=Math.asin(num2)*180/Math.PI;
                k=getfrontex(input,(i+1));
                anstring=String.valueOf(Math.abs(ans));
                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);
                }
            }
            if (input.charAt(i)=='c'){
                count++;
                num2=getfrontnumber(input,(i+1));
                ans=Math.toDegrees(Math.acos(num2));
                k=getfrontex(input,(i+1));
                anstring=String.valueOf(Math.abs(ans));
                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);
                }
            }
            if (input.charAt(i)=='n'){
                count++;
                num2=getfrontnumber(input,(i+1));
                ans=Math.log(num2);
                k=getfrontex(input,(i+1));
                anstring=String.valueOf(Math.abs(ans));
                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);
                }
            }
            if (input.charAt(i)=='l'){
                count++;
                num2=getfrontnumber(input,(i+1));
                ans=Math.log10(num2);
                k=getfrontex(input,(i+1));
                anstring=String.valueOf(Math.abs(ans));
                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);
                }
            }

            if(input.charAt(i)=='a'){
                count++;
                num2=getfrontnumber(input,(i+1));
                ans=Math.pow(10,num2);
                k=getfrontex(input,(i+1));
                anstring=String.valueOf(ans);
                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);
                }
            }

            if((count>0)&&(input!=temp)){
                input=simplification1(temp);
                //temp="";
            }

            i++;
        }

        return input;
    }
    public String multiplication(String input){
        double num1=0,num2=0,ans=0;
        int b=0,t1=0,t2=0;
        String anstring="";
        String temp="";
        int count=0;
        while (b<input.length()){
            if (input.charAt(b)=='*'){
                num1=getbacknumber(input,(b-1));
                num2=getfrontnumber(input,(b+1));
                ans=num1*num2;
                t1=getendex(input,(b-1));
                t2=getfrontex(input,(b+1));

                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,t1)+anstring+input.substring(t2+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,t1)+anstring+input.substring(t2+1);
                }
                count++;
                b=1;
            }
            if((count>0)&&(input!=temp)){
                input=simplification1(temp);
            }
            b++;
        }
        return input;
    }
    public String of(String input){
        double num1=0,num2=0,ans=0;
        int b=0,t1=0,t2=0;
        String anstring="";
        String temp="";
        int count=0;
        while (b<input.length()){
            if (input.charAt(b)=='o'){
                num1=getbacknumber(input,(b-1));
                num2=getfrontnumber(input,(b+1));
                ans=num1*num2;
                t1=getendex(input,(b-1));
                t2=getfrontex(input,(b+1));

                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,t1)+anstring+input.substring(t2+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,t1)+anstring+input.substring(t2+1);
                }
                count++;
                b=1;
            }
            if((count>0)&&(input!=temp)){
                input=simplification1(temp);
            }
            b++;
        }
        return input;
    }
    //computes all raised to power operators"^"
    public  String exponent(String input){
        double num1=0,num2=0,ans=0,root=0,invp=0;
        int b=0,t1=0,t2=0;
        String anstring="";
        String temp="";
        int count=0,x=0;

        while (b<input.length()){//this block occurs in case the negative sign before the number has to be accounted for i.e (-2)^2
            if (input.charAt(b)=='x'){
                num1=getbacknumber(input,(b-1));
                num2=getfrontnumber(input,(b+1));
                if((num1<0)&&(num2<1)){//this computes the roots of numbers unaccounted for by Math.pow
                    invp=1/num2;
                    root=0;
                    x=1;
                    while (Math.pow(root,invp)!=num1){
                        if(Math.pow(root,invp)<num1){
                            root+=x;
                            x/=10;

                        }else{
                            root-=x;
                        }
                    }
                    ans=root;
                }else{//normal Math.pow
                    ans=Math.pow(num1,num2);
                }

                t1=getendex(input,(b-1));
                t2=getfrontex(input,(b+1));

                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,t1)+anstring+input.substring(t2+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,t1)+anstring+input.substring(t2+1);
                }
                count++;
            }else if(input.charAt(b)=='^'){//normal power computation
                num1=getbacknum(input,(b-1));
                num2=getfrontnumber(input,(b+1));
                if((num1<0)&&(num2<1)){
                    invp=1/num2;
                    root=0;
                    x=1;
                    while (Math.pow(root,invp)!=num1){
                        if(Math.pow(root,invp)<num1){
                            root+=x;
                            x/=10;

                        }else{
                            root-=x;
                        }
                    }
                    ans=root;
                }else{
                    ans=Math.pow(num1,num2);
                }

                t1=getend(input,(b-1));
                t2=getfrontex(input,(b+1));

                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,t1)+anstring+input.substring(t2+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,t1)+anstring+input.substring(t2+1);
                }
                count++;
            }
            if((count>0)&&(input!=temp)){
                input=simplification1(temp);
            }
            b++;
        }
        return input;
    }
    //computes all subtractions in input string also had to be called twice in gunnercal
    public  String addition(String input){
        double num1=0,num2=0,ans=0;
        int b=0,t1=0,t2=0;
        String anstring="";
        String temp="";
        int count=0;
        while (b<input.length()){
            if ((input.charAt(b)=='+')&&(b>0)){
                num1=getbacknumber(input,(b-1));
                num2=getfrontnumber(input,(b+1));
                ans=num1+num2;
                t1=getendex(input,(b-1));
                t2=getfrontex(input,(b+1));

                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,t1)+anstring+input.substring(t2+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,t1)+anstring+input.substring(t2+1);
                }
                count++;
                b=1;
            }
            if((count>0)&&(input!=temp)){
                input=simplification1(temp);
            }
            b++;
        }
        return input;
    }

    //computes all subtractions in input string: had to be called twice in gunnercal
    public String subtraction(String input){
        double num1=0,num2=0,ans=0;
        int b=0,t1=0,t2=0;
        String anstring="";
        String temp="";
        int count=0;
        while (b<input.length()){
            if ((input.charAt(b)=='-')&&((b>0)&&(input.charAt(b-1)!='E'))){
                num1=getbacknumber(input,(b-1));
                num2=getfrontnumber(input,(b+1));
                ans=num1-num2;
                t1=getendex(input,(b-1));
                t2=getfrontex(input,(b+1));

                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,t1)+anstring+input.substring(t2+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,t1)+anstring+input.substring(t2+1);
                }
                count++;
                b=1;
            }
            if((count>0)&&(input!=temp)){
                input=simplification1(temp);
                // b=1;
            }
            b++;
        }
        return input;
    }

    //gets the index of the last number after an operator
    public int getfrontex(String input,int i){

        input+=" ";
        int k=i,end=0;
        while((numcondition(input.charAt(k))||input.charAt(k)=='-')&&(k<(input.length()))){

            if(input.charAt(k)=='E'){

                if(input.charAt(k+1)=='+'){
                    k=getfrontex(input,k+2)+1;
                }else{

                    k=getfrontex(input,k+1)+1;
                }
                break;
            }
            if((input.charAt(k+1)=='-')||(input.charAt(k+1)=='+')){
                k++;
                break;

            }
            k++;
        }
        k--;

        return(k);
    }
    // computes and replaces all n factorial in input string used in simplification1
    public  String factorial(String input){
        int m=0,count=0;
        String facts="",anstring="";
        while(m<input.length()){//factorial
            Double num,factorial;
            factorial=1.0;
            int endex;

            if (input.charAt(m)=='!'){

                endex=getend(input,(m-1));
                num=getbacknum(input,(m-1));
                if(num%1>0) {

                    input = "Error";
                    break;
                }
                for(int t=1;t<=num;t++){

                    factorial*=t;
                }
                anstring=input.replaceFirst(input.substring(endex,(m+1)),String.valueOf(factorial));
                facts=anstring;
                count++;
            }
            m++;
            if ((count>0)&&(input!=anstring))
                input=anstring;
        }
        return input;
    }
    //primary simplification: replaces all words with symbols and reduces all multiple signs to a single operator
    public   String simplification1(String input){
        int i=0;

        String answer="",anstring="";
        //REPLACE trig and transcedental operations



answer=input;

        anstring=answer.replaceAll("\\+\\+\\+", "\\+");
        answer=anstring.replaceAll("\\+\\+\\-", "\\-");
        anstring=answer.replaceAll("\\+\\-\\+", "\\-");
        answer=anstring.replaceAll("\\-\\+\\+", "\\-");
        anstring=answer.replaceAll("\\-\\-\\+", "\\+");
        answer=anstring.replaceAll("\\-\\+\\-", "\\+");
        anstring=answer.replaceAll("\\+\\-\\-", "\\+");
        answer=anstring.replaceAll("\\-\\-\\-", "\\-");
        anstring=answer.replaceAll("\\+\\+", "\\+");
        answer=anstring.replaceAll("\\+\\-", "\\-");
        anstring=answer.replaceAll("\\-\\+", "\\-");
        answer=anstring.replaceAll("\\-\\-", "\\+");
        anstring=answer.replaceAll("o\\+", "o");
        answer=anstring.replaceAll("\\*\\+","\\*");
        anstring=answer.replaceAll("\\/\\+", "\\/");

        answer=anstring.replaceAll("\u221A\\+","\u221A");
        anstring=answer.replaceAll("\u221B\\+","\u221B");


        answer=anstring.replaceAll("E+", "E");

        return answer;
    }
    //impliments transtrig registers to modify transcedental and trig parts of input in case number comes before them without "*" sign
    public  String transtrigcorrection(String input){
        int i=0,k=1;
        String temp="";
        int count=0;
        while (i<input.length()){
            if (i==(input.length()-1))
                k=i;
            if(numcondition(input.charAt(i))&&transtrigsymbolcond(input.charAt(k))){

                temp=input.substring(0,(i+1))+"o"+input.substring(i+1);
                count++;

            }
            if((count>0)&&(temp!=input))
                input=simplification1(temp);

            i++;
            k++;

        }
        return input;
    }
    //registers all transtrig symbols
    public  Boolean transtrigsymbolcond(char i){
        boolean conditon=(i=='s'||i=='c'||i=='t'||i=='S'||i=='C'||i=='T'||i=='a'||i=='e'||i=='n'||i=='l'||i=='\u221A'||i=='\u03C0');
        return conditon;
    }
    //gets number at the back of operator when negetive number is not relevant
    public  double getbacknum(String input,int i){

        input=" "+input;
        String rnumstring="";
        String numstring="";
        int k,count=0;
        k=i+1;
        while((numcondition(input.charAt(k)))&&(k>=0)){

            rnumstring+=input.charAt(k);
            k--;
            count++;
            if ((input.charAt(k)=='-'||input.charAt(k)=='+')&&(input.charAt(k-1)=='E')){

                if (input.charAt(k)=='-'){
                    rnumstring+="-"+input.charAt(k-1);
                }else if(input.charAt(k)=='+'){

                    rnumstring+="+"+input.charAt(k-1);
                }
                k-=2;
                count+=2;
            }
        }
        count-=1;
        while (count>=0){
            numstring+=rnumstring.charAt(count);
            count--;
        }
        return(Double.parseDouble(numstring));
    }
    //to get number at the back of operator
    public  double getbacknumber(String input,int i){

        input=" "+input;
        String rnumstring="";
        String numstring="";
        double ans=0;
        int k=i+1,count=0;
        while(numcondition(input.charAt(k))){

            rnumstring+=input.charAt(k);
            k--;
            count++;
            if ((input.charAt(k)=='-'||input.charAt(k)=='+')&&(input.charAt(k-1)=='E')){

                if (input.charAt(k)=='-'){
                    rnumstring+="-"+input.charAt(k-1);
                }else if(input.charAt(k)=='+'){

                    rnumstring+="+"+input.charAt(k-1);
                }
                k-=2;
                count+=2;
            }

        }

        count-=1;
        while (count>=0){
            numstring+=rnumstring.charAt(count);
            count--;
        }
        if (input.charAt(k)=='-'){
            ans=((Double.parseDouble(numstring)));
            ans*=(-1);
        }else{
            ans=(Double.parseDouble(numstring));

        }
        return ans;

    }
    //gets number in front of operator
    public Double getfrontnumber(String input,int i){
        input=input+" ";
        String numstring="";
        int k=i;
        while((numcondition(input.charAt(k))||input.charAt(k)=='-')&&(k<(input.length()))){

            numstring+=input.charAt(k);
            if(input.charAt(k)=='E'){

                if(input.charAt(k+1)=='+'){
                    numstring+=String.valueOf(getfrontnumber(input,(k+2)).intValue());
                }else{

                    numstring+=String.valueOf(getfrontnumber(input,(k+1)).intValue());
                }
                break;
            }
            if ((input.charAt(k+1)=='-')||(input.charAt(k+1)=='+'))
                break;
            k++;
        }

        /*if (numstring.startsWith("-")){
            return((Double.parseDouble(numstring.substring(1)))*(-1));
        }else
            return (Double.parseDouble(numstring));*/

        return Double.parseDouble(numstring);
    }
    //gets index of number before operator if negetive numbers are not relevant
    public static int getend(String input,int i){

        input=" "+input;
        String rnumstring="";
        int end;
        int k=i+1;
        while(numcondition(input.charAt(k))){

            rnumstring+=input.charAt(k);
            k--;
            if ((input.charAt(k)=='-'||input.charAt(k)=='+')&&(input.charAt(k-1)=='E')){


                k-=2;

            }

        }
        end=k;


        return(end);
    }
    //gets back index of numbers before operators if negetive numbers are relevant
    public static int getendex(String input,int i){

        input=" "+input;
        String rnumstring="";
        int end;
        int k=i+1;
        while(numcondition(input.charAt(k))){

            rnumstring+=input.substring(k, k);
            k--;

            if ((input.charAt(k)=='-'||input.charAt(k)=='+')&&(input.charAt(k-1)=='E')){


                k-=2;

            }

        }
        end=k;

        if (input.charAt(k)=='-')
            return(end-1);
        else
            return(end);
    }
    /**
     *
     * @param i
     * @return
     */



    //this function registers all simplified operator symbols
    public static Boolean numcondition(char i){

        Boolean numcond=(i=='3'||i=='1'||i=='2'||i=='4'||i=='5'||i=='6'||i=='7'||i=='8'||i=='9'||i=='0'||i=='.'||i=='E');
        return(numcond);

    }

    //supposed to replace all E with 10^num2 not sure if i used it though
    public  String EP(String input){
        double num1=0,num2=0,ans=0;
        int b=0,t1=0,t2=0;
        String anstring="";
        String temp="";
        int count=0;
        while (b<input.length()){
            if ((input.charAt(b)=='E')&&(b>0)){
                num1=getbacknumber(input,(b-1));
                num2=getfrontnumber(input,(b+1));
                ans=num1*(Math.pow(10,num2));
                t1=getendex(input,(b-1));
                t2=getfrontex(input,(b+1));

                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,t1)+anstring+input.substring(t2+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,t1)+anstring+input.substring(t2+1);
                }
                count++;
            }
            if((count>0)&&(input!=temp)){
                input=simplification1(temp);
            }
            b++;
        }
        return input;
    }

    //replaces all index symbols with proper math statements
    public static String simplificationp(String input){
        String answer="",temp="";
        answer=input.replaceAll("\u00B2","^2");
        temp=answer.replaceAll("\u00B3","^3");
        input=temp.replaceAll("\u207B\u00B9","^-1");

        return input;
    }

    //computes square and cube roots if rlevant unicodes appear
    public String squareroot(String input){
        String temp="",anstring="";
        int i=0,count=0,k=0;
        double num2=0,ans;
        temp=simplificationsroot(input);
        input=temp;
        temp="";
        while (i<input.length()){
            if (input.charAt(i)=='\u221A'){
                count++;
                num2=getfrontnumber(input,(i+1));
                ans=Math.sqrt(num2);
                k=getfrontex(input,(i+1));
                anstring=String.valueOf(ans);
                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);
                }

            }else if (input.charAt(i)=='\u221B'){
                count++;
                num2=getfrontnumber(input,(i+1));
                ans=Math.cbrt(num2);
                k=getfrontex(input,(i+1));
                anstring=String.valueOf(ans);
                if(ans>=0){
                    anstring="+"+String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);

                }else{
                    anstring=String.valueOf(ans);
                    temp=input.substring(0,i)+anstring+input.substring(k+1);
                }

            }
            if ((count>0)&&(input!=temp))
                input=simplification1(temp);
            i++;
        }
        return input;
    }
    //this ensures that other simplification functions do not put multiplication symbol in front of the roots
    public  String simplificationsroot(String input){

        int i=0,count=0;
        String temp="";
        while ((i+1)<input.length()){

            if (numcondition(input.charAt(i))&&(input.charAt(i+1)=='\u221A'||input.charAt(i+1)=='\u221B')){
                temp=input.substring(0,(i+1))+"o"+input.substring(i+1);
                count++;
            }
            if ((count>0)&&(input!=temp)){
                input=simplificationtotal(temp);
            }
            i++;
        }
        return input;
    }
    //the ultimate function that computes input in BODMAS order and renders all symbols in mathematically acceptable form
    public  String simplificationtotal(String input){
        int i=0;
        String answer="",anstring="";
        //REPLACE trig and ranscedental operations

        anstring=input.replaceAll("Asin", "s");
        answer=anstring.replaceAll("Acos", "c");
        anstring=answer.replaceAll("Atan", "t");
        answer=anstring.replaceAll("sin", "S");
        anstring=answer.replaceAll("cos", "C");
        answer=anstring.replaceAll("tan", "T");

        anstring=answer.replaceAll("Alog", "a");
        answer=anstring.replaceAll("exp", "e");
        anstring=answer.replaceAll("ln", "n");
        answer=anstring.replaceAll("log", "l");

        anstring=answer.replaceAll("\\+\\+\\+", "\\+");
        answer=anstring.replaceAll("\\+\\+\\-", "\\-");
        anstring=answer.replaceAll("\\+\\-\\+", "\\-");
        answer=anstring.replaceAll("\\-\\+\\+", "\\-");
        anstring=answer.replaceAll("\\-\\-\\+", "\\+");
        answer=anstring.replaceAll("\\-\\+\\-", "\\+");
        anstring=answer.replaceAll("\\+\\-\\-", "\\+");
        answer=anstring.replaceAll("\\-\\-\\-", "\\-");
        anstring=answer.replaceAll("\\+\\+", "\\+");
        answer=anstring.replaceAll("\\+\\-", "\\-");
        anstring=answer.replaceAll("\\-\\+", "\\-");
        answer=anstring.replaceAll("\\-\\-", "\\+");
        anstring=answer.replaceAll("\\*\\+","\\*");
        answer=anstring.replaceAll("\\/\\+", "\\/");
        anstring=factorial(answer);

        input=anstring;
        return input;
    }
    public  String gunnercal(String input){

        int t=0,countb=0,endb=0;
        String answer="",anstring="",temp="";
        answer=input.replaceAll("ans",('('+anss+')'));
        input=simplificationp(answer);
        temp=simplificationtotal(replacepi((input)));
        input=temp;
        temp=simplificationb(input);
        input=temp;
        temp="";

        for (int i=0;i<1;i++) {
            while (t < input.length()) {
                if (input.charAt(t) == '(') {
                    temp = brackets(input, t);
                    endb = bracketendex(input, t);
                    //input.replaceFirst(input.substring(t,endb), answer);
                    anstring += temp;
                    t = endb + 1;
                    continue;
                }
                anstring += input.charAt(t);
                t++;
            }
            input = simplificationtotal(anstring);
            anstring = simplification1(input);
            answer = EP(anstring);
            anstring = transtrigcomputation(answer);
            answer = exponent(anstring);
            anstring = squareroot(answer);
            answer = of(anstring);

            anstring = division(answer);

            answer = multiplication(anstring);
            anstring = addition(answer);
            answer = subtraction(anstring);

            input=answer;
        }
        return answer;
    }
    public   String replacepi(String input){//this function puts multiplication symbol before or after pi symbol if user didn't e.g 2pi=2*pi
        String temp="",anstring="",ans="";
        int i=0,count=0;
        while((i+2)<input.length()){//front and back conditions
            if (operators(input.charAt(i))&&input.charAt(i+1)=='\u03C0'&&operators(input.charAt(i+2))){
                temp=input.substring(0,(i+1))+String.valueOf(Math.PI)+input.substring(i+2);
                count++;
            }else if(operators(input.charAt(i))&&input.charAt(i+1)=='\u03C0'&&numcondition(input.charAt(i+2))){
                temp=input.substring(0,(i+1))+String.valueOf(Math.PI)+'o'+input.substring(i+2);
                count++;
            }else if(numcondition(input.charAt((i)))&&input.charAt(i+1)=='\u03C0'&&operators(input.charAt(i+2))){
                temp=input.substring(0,(i+1))+"o"+String.valueOf(Math.PI)+input.substring(i+2);
                count++;
            }else if(numcondition(input.charAt(i))&&input.charAt(i+1)=='\u03C0'&&numcondition(input.charAt(i+2))){
                temp=input.substring(0,(i+1))+"o"+String.valueOf(Math.PI)+"o"+input.substring(i+2);
                count++;
            }else if(input.matches("\\u03C0")){
                temp=String.valueOf(Math.PI);
            }
            if (count>0&&input!=temp){
                input=temp;
            }
            i++;
        }
        i=0;
        count=0;

        while((i+1)<input.length()){//front conditions
            if (operators(input.charAt(i))&&input.charAt(i+1)=='\u03C0'){
                temp=input.substring(0,(i+1))+String.valueOf(Math.PI);
                count++;
            }else if(input.charAt(i)=='\u03C0'&&numcondition(input.charAt(i+1))){
                temp=input.substring(0,(i))+String.valueOf(Math.PI)+'o'+input.substring(i+1);
                count++;
            }else if(input.charAt(i)=='\u03C0'&&operators(input.charAt(i+1))){
                temp=input.substring(0,(i))+String.valueOf(Math.PI)+input.substring(i+1);
                count++;
            }else if(numcondition(input.charAt(i))&&input.charAt(i+1)=='\u03C0'){
                temp=input.substring(0,(i+1))+"o"+String.valueOf(Math.PI);
                count++;
            }
            if (count>0&&input!=temp){
                input=temp;
            }
            i++;
        }
        return input;
    }

    public void equals(View view){
        final String[] temp = {""};
        final String[] out = { "" };
        final TextView text2 = (TextView) findViewById(R.id.textView2);

        boolean test=false;
        TextView in=(TextView)findViewById(R.id.input);
        input=in.getText().toString();//in case user presses equals button more than once this assigns text in input txtfield to input




            temp[0] = (input);
            input = temp[0];

Runnable r=new Runnable() {
    @Override
    public void run() {
        try {
            temp[0] = gunnercal(input);
            input = temp[0];
            if (temp[0].contains("NaN")){//tests if error occured in input
                display="ERROR";
                anss="0";
            }else {

                anss = temp[0];//this assigns the result of calculation to the variable anss or answer


                //the following block eliminates the positive sign at the beginning of the answer
                if (temp[0].startsWith("+")) {
                    out[0] =(temp[0].substring(1));
                } else
                    out[0] =(temp[0]);

                display=(out[0].endsWith(".0")? out[0].substring(0,(out[0].length()-2)): out[0]);

            }
            input="";
            handler.sendEmptyMessage(0);
        }catch (Exception e){
            display="ERROR";
            anss="0";
            input="";
            handler.sendEmptyMessage(0);
        }

    }
};
        try {
            Thread thread=new Thread(r);
            thread.start();

        }catch(Exception e){//incase user wants to crash the app
            text2.setText("ERROR");
            input="";
            anss="0";
        }





    }
    public String display="";
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {

            final TextView text2 = (TextView) findViewById(R.id.textView2);
            TextView in=(TextView)findViewById(R.id.input);
            text2.setText(display);
        }
    };
    public String notfinished(String input) {

        String output="",temp="";
        boolean test=false;
        for (int k=1;k<input.length();k++){
            if (!numcondition(input.charAt(k))){
                test=true;
            }
        }
        while (test) {
            if (input.contains("/")) {
                temp = division(input);
                input = temp;
            }  if (input.contains("*")) {
                temp = multiplication(input);
                input = temp;
            }  if (input.contains("+")) {
                temp = multiplication(input);
                input = temp;
            }  if (input.contains("-")) {
                temp = multiplication(input);
                input = temp;
            }
            test=false;

            //output=(input.startsWith("+")?input.substring(1):input);
            // input=output;
            for (int k=1;k<input.length();k++){
                if (!numcondition(input.charAt(k))){
                    test=true;
                }
            }

        }
        return input;
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
