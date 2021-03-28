package com.example.ajirigunn.calsci.personal_classes;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajirigunn.calsci.Calculator;
import com.example.ajirigunn.calsci.Converter;
import com.example.ajirigunn.calsci.Equations;
import com.example.ajirigunn.calsci.R;
import com.example.ajirigunn.calsci.homeclasses.gunnermain;

public class Central_personal extends AppCompatActivity implements View.OnKeyListener,NavigationView.OnNavigationItemSelectedListener,DrawerLayout.DrawerListener
        {

    public int varcount=0;
    public static int indexer=0;
    public String arraystring="";


    public Bundle b;

boolean solved;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final myfunctionsdatabase myfun=new myfunctionsdatabase(this,null,null,1);
        TextView title=(TextView)findViewById(R.id.title);

        final String name=title.getText().toString();
        int id=item.getItemId();
        final int[] retun = {0};
        if (id==R.id.del){//IF DELETE FUNCTION IS SELECTED DELETE APP
            AlertDialog.Builder builder1=new AlertDialog.Builder(this);
            builder1.setMessage(getResources().getString(R.string.delmessage));
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            retun[0] =myfun.deletefun(name);
                            Intent intent=new Intent(Central_personal.this,Personal.class);

                            startActivity(intent);
                        }
                    }
            );
            builder1.setNegativeButton(getResources().getString(R.string.no),new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog,int id){
                    dialog.cancel();
                }
            });
            AlertDialog alert=builder1.create();
            alert.show();


        }else if(id==R.id.edit){//IF EDIT OPTION IS SELECTED OPEN ADDPERSONAL AND SEND FUNCTION NAME AS EXTRA
            Intent st=new Intent(Central_personal.this,AddPersonal.class);
            st.putExtra("title",name);
            st.putExtra("tbartitle",getResources().getString(R.string.editfun));
            startActivity(st);
        }else if (id==android.R.id.home){
            onBackPressed();
        }else if(id==R.id.reput){
            reput(getCurrentFocus());
        }
        return true;
    }



    @Override
    protected void onResume() {
        ActionBar ab=this.getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        super.onResume();

    }

    @Override
    protected void onStop() {//THIS IS TO RELOAD ACTIVITY AFTER STOPPING
        super.onStop();
        TextView result=(TextView)findViewById(R.id.out);
        result.setText("");
        Button entry=(Button) findViewById(R.id.enter);
        TextView tp=(TextView)findViewById(R.id.formula);//for setting formula
        String position=  b.get("function_position").toString();//to get formula from extras
        tp.setText(String.valueOf(position));//set formula to textview

        String name=b.get("function_name").toString();//to set function name
        String[] vars= (String[]) b.get("variables");//to receive variables array
        String varinput="";//to store user input
        for (int i=0;i<vars.length;i++){//this loop splits the received array of variables to lines with labels
            if(!vars[i].toString().matches(" ")) {
                varinput += vars[i] + ":\n";
            }
        }
        varinput=varinput.trim();//thisremoves all trailing whitespaces
        TextView vs=(TextView)findViewById(R.id.variables);//this is to set variables as lines to be inputed
        vs.setText(varinput.replaceAll(" ",""));//set command as explained above

        TextView tt=(TextView)findViewById(R.id.title);//this is to set name of operation
        tt.setText(name);//set command as explained above

        EditText in=(EditText)findViewById(R.id.in);//this is to set hint for the first variable to be input
        in.setHint(getResources().getString(R.string.enter)+" "+vars[0]);//set hint command
        int counter=varinput.split(":").length;
        varcount=counter;
        vcount=counter;
        entry.setText(getResources().getString(R.string.enter));
        replacement="";
        replacement+=vars[0]+",";
        allinput="";
        indexer=0;

    }

    public String fomula;
            public void reput(View v){
                TextView vv= (TextView) findViewById(R.id.variables);
                TextView rr= (TextView) findViewById(R.id.out);

                vv.setText(variablesstring);
                rr.setText(resultstring);
            }
    public void  reset(View view){

        TextView result=(TextView)findViewById(R.id.out);
        resultstring=result.getText().toString();
        result.setText("");
        Button entry=(Button) findViewById(R.id.enter);
        TextView tp=(TextView)findViewById(R.id.formula);//for setting formula
        String position=  b.get("function_position").toString();//to get formula from extras
        tp.setText(String.valueOf(position));//set formula to textview

        String name=b.get("function_name").toString();//to set function name
        String[] vars= (String[]) b.get("variables");//to receive variables array
        String varinput="";//to store user input
        for (int i=0;i<vars.length;i++){//this loop splits the received array of variables to lines with labels
            if(!vars[i].toString().matches(" ")) {
                varinput += vars[i] + ":\n";
            }
        }
        varinput=varinput.trim();//thisremoves all trailing whitespaces
        TextView vs=(TextView)findViewById(R.id.variables);//this is to set variables as lines to be inputed
        variablesstring=vs.getText().toString();
        vs.setText(varinput.replaceAll(" ",""));//set command as explained above

        TextView tt=(TextView)findViewById(R.id.title);//this is to set name of operation
        tt.setText(name);//set command as explained above

        EditText in=(EditText)findViewById(R.id.in);//this is to set hint for the first variable to be input
        in.setHint(getResources().getString(R.string.enter)+" "+vars[0]);//set hint command
        if (!solved){
        in.setText("");}
        int counter=varinput.split(":").length;
        varcount=counter;
        vcount=counter;
        allinput="";
        indexer=0;
        replacement="";
        entry.setText(getResources().getString(R.string.enter));

        replacement+=vars[0]+",";


    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.personalmenu,menu);

        return true;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,Personal.class));
        finish();
    }

    public String variablestring;

            @Override
            public void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
                super.onPrepareSupportNavigateUpTaskStack(builder);
            }

            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_personal);
        Bundle data=getIntent().getExtras();//receives intent extras bundle

                solved=false;
        b=data;

        Toolbar cb=(Toolbar)findViewById(R.id.cb);
        cb.setTitleTextColor(Color.WHITE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cb.setOverflowIcon(getDrawable(R.drawable.whiteoverflowicon));
        }
        setSupportActionBar(cb);
        ActionBar ab=this.getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.backicon);

        Button entry=(Button) findViewById(R.id.enter);
        TextView tp=(TextView)findViewById(R.id.formula);//for setting formula
        String position=  data.get("function_position").toString();//to get formula from extras
        fomula=position;
        tp.setText(String.valueOf(position));//set formula to textview

        String name=data.get("function_name").toString();//to set function name
        String[] vars= (String[]) data.get("variables");//to receive variables array
        String varinput="";//to store user input
        for (int i=0;i<vars.length;i++){//this loop splits the received array of variables to lines with labels
            if(!vars[i].toString().matches(" ")) {
                varinput += vars[i] + ":\n";
            }
        }
        varinput=varinput.trim();//thisremoves all trailing whitespaces
        variablestring=varinput;
        TextView vs=(TextView)findViewById(R.id.variables);//this is to set variables as lines to be inputed
        vs.setText(varinput.replaceAll(" ",""));//set command as explained above

        TextView tt=(TextView)findViewById(R.id.title);//this is to set name of operation
        tt.setText(name);//set command as explained above

        EditText in=(EditText)findViewById(R.id.in);//this is to set hint for the first variable to be input
        in.setHint(getResources().getString(R.string.enter)+" "+vars[0]);//set hint command
        int counter=varinput.split(":").length;
        varcount=counter;
        vcount=counter;
        entry.setText(getResources().getString(R.string.enter));
        replacement+=vars[0]+",";
        NavigationView navigationView = (NavigationView) findViewById(R.id.nview);
        navigationView.setNavigationItemSelectedListener(this);

        in.setOnKeyListener(this);
    }
    public String firstvar;
    public String yoursolution(String input){//this solves the equation of input with formula and replaced variables

        String answer="";
        answer=gunnercal(input);
        return answer;

    }
    public int vcount;
    public int varnote=-1;
    public String nextvar="";
    public String allinput="";
    public String replacement="";
    public void entry(View view){//this function operates when enter/solve button is clicked
        try{

            TextView vs=(TextView)findViewById(R.id.variables);
            TextView tt=(TextView)findViewById(R.id.title);
            EditText in=(EditText)findViewById(R.id.in);
            Button entry=(Button) findViewById(R.id.enter);

            TextView answer=(TextView)findViewById(R.id.out);
            TextView fom=(TextView)findViewById(R.id.formula);
            String inputvars=vs.getText().toString();
            String[] invars=inputvars.split(":");
            String userinput="";

            int count=0;
            String temp="";
            if (solved){
                reset(view);
                solved=false;
                entry(view);
            }

//the following "if" tests if all variables have beeen entered and if the entry is valid
            if(!(inputvars.endsWith("1")||inputvars.endsWith("2")||inputvars.endsWith("3")||inputvars.endsWith("4")||inputvars.endsWith("5")||inputvars.endsWith("6")
                    ||inputvars.endsWith("7")||inputvars.endsWith("8")||inputvars.endsWith("9")||inputvars.endsWith("0"))&&(in.getText().toString().contains("1")
                    ||in.getText().toString().contains("2")||in.getText().toString().contains("3")||in.getText().toString().contains("4")||in.getText().toString().contains("5")
                    ||in.getText().toString().contains("6")||in.getText().toString().contains("7")||in.getText().toString().contains("8")||in.getText().toString().contains("9")
                    ||in.getText().toString().contains("0")||in.getText().toString().contains("."))){
                userinput=in.getText().toString();//this gets initial input


                for (int r=indexer;r<inputvars.length();r++){
                    //this updates the global variable keeping record of the variables left to process
                    if(inputvars.charAt(r)==':'){
                        varcount--;
                        varnote++;
                    }
                    //the following block finds the position of the current entry and fixes the input in front of the entry
                    if ((r+1<inputvars.length())&&
                            (inputvars.charAt(r)==':'&&
                                    (!numcondition(inputvars.charAt(r+1))))){
                        for (int j=r+2;j<inputvars.length();j++){
                            if (inputvars.charAt(j)!=':'){
                                nextvar+=inputvars.charAt(j);

                            }else{
                                break;
                            }
                        }
                        allinput+=userinput+",";//this adds the entry to the global variable to be split to replacement's value array
                        temp=inputvars.substring(0,(r+1))+userinput+inputvars.substring((r+1));
                        inputvars=temp;
                        replacement+=nextvar+",";//this updates the variable to be split to replacement values

                        temp=nextvar;
                        nextvar="";
                        indexer=r+1;//indexer keeps track of the index of the last column to be used in the next run of the enclosing
                        //for loop
                        vs.setText(inputvars);//sets new input to rhe variables
                        in.setText("");//resets the input "EditText"
                        in.setHint(getResources().getString(R.string.enter)+" "+temp);//sets entry hint at the input "EditText of the next Variable
                        break;
                    }else if((r+1>=inputvars.length())){//this executes when one or the last variable is about to be inputed                    allinput+=userinput;//this
                        temp=inputvars+userinput;
                        allinput+=userinput;
                        inputvars=temp;
                        temp="";
                        indexer=r+1;
                        vs.setText(inputvars);
                        in.setText("");
                        entry.setText(getResources().getString(R.string.solve));
                        //entry.setBackgroundColor(Color.CYAN);
                        in.setHint("");
                        break;
                    }
                }//this tests if all variables have been entered and solves
                //Toast.makeText(this,"doesn't solve",Toast.LENGTH_LONG).show();
                if((inputvars.endsWith("1")||inputvars.endsWith("2")||inputvars.endsWith("3")||inputvars.endsWith("4")||inputvars.endsWith("5")||inputvars.endsWith("6")
                        ||inputvars.endsWith("7")||inputvars.endsWith("8")||inputvars.endsWith("9")||inputvars.endsWith("0"))){

                    String tem="";
                    int ex=0;

                    tem=replacement.substring(0,(replacement.length()-1));
                    replacement=tem.replaceAll(" ","");
                    // Toast.makeText(this,("i'm in"+allinput),Toast.LENGTH_LONG).show();

                    String[] rep= replacement.split(",");
                    String[] val=allinput.split(",");

                    String input=fom.getText().toString();
                    ex=input.indexOf("=");
                    tem=input.substring((ex+1));
                    input=tem;

                    tem=replacevariable(input,rep,val);

                    input=gunnercal(tem);

                    answer.setText(input.startsWith("+")?input.substring(1):input);

                    //this executes when all variables have been inputed
                }
                //varcount=counter;
                //vcount=counter;



            }}catch (Exception e){
            EditText et=(EditText)findViewById(R.id.in);
            et.setHint(getResources().getString(R.string.error));
        }
        //ho
        // usekeeping

    }
    public String replacevariable(String input,String[] variables,String[] values){
        solved=true;
        String vars=input,out="";
        int a=0;
        for (int k=0;k<variables.length;k++){
            out=vars.replaceAll(variables[k],("("+values[k]+")"));
            vars=out;

        }
        return out;
    }
String input;

            String variablesstring,resultstring;
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
                answer=simplificationp(input);
                temp=simplificationtotal(replacepi((answer)));
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

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_ENTER){
            Toast.makeText(this,"keys detected",Toast.LENGTH_LONG).show();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }


            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
               // Toast.makeText(this,"jsjk"+String.valueOf(i),Toast.LENGTH_SHORT).show();
                if (i==KeyEvent.FLAG_EDITOR_ACTION){
                    entry(view);
                    Toast.makeText(this,"jsjk"+String.valueOf(i),Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        }
