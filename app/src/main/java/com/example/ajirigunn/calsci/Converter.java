package com.example.ajirigunn.calsci;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ajirigunn.calsci.converter_fragments.area_con;
import com.example.ajirigunn.calsci.converter_fragments.energy_con;
import com.example.ajirigunn.calsci.converter_fragments.lengthcon;
import com.example.ajirigunn.calsci.converter_fragments.mass_converter;
import com.example.ajirigunn.calsci.converter_fragments.pressure_con;
import com.example.ajirigunn.calsci.converter_fragments.speed_con;
import com.example.ajirigunn.calsci.converter_fragments.temp_con;
import com.example.ajirigunn.calsci.converter_fragments.volume_con;
import com.example.ajirigunn.calsci.homeclasses.gunnermain;
import com.example.ajirigunn.calsci.personal_classes.Personal;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Converter extends AppCompatActivity implements area_con.OnFragmentInteractionListener,energy_con.OnFragmentInteractionListener,
lengthcon.OnFragmentInteractionListener,mass_converter.OnFragmentInteractionListener,pressure_con.OnFragmentInteractionListener,
speed_con.OnFragmentInteractionListener,temp_con.OnFragmentInteractionListener,volume_con.OnFragmentInteractionListener,NavigationView.OnNavigationItemSelectedListener{
ActionBar abar;
    FragmentManager manager;
    public void length(View view) {

        lengthcon lc = new lengthcon();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        ft.add(R.id.group, lc, "length");
        ft.commit();

        //startActivity(new Intent(Converter.this,length_converter.class));
    }
    public void closelength(View view){
        lengthcon lc = (lengthcon) manager.findFragmentByTag("length");
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.fade_out);
        ft.remove(lc);
        ft.commit();
    }

    public void speed(View view) {
        speed_con sc = new speed_con();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        ft.add(R.id.group, sc, "speed");
        ft.commit();
        // startActivity(new Intent(Converter.this, speed.class));
    }
    public void closespeed(View view){
        speed_con sc = (speed_con) manager.findFragmentByTag("speed");
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.fade_out);
        ft.remove(sc);
        ft.commit();
    }

    public void pressure(View view) {
        pressure_con pc = new pressure_con();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        ft.add(R.id.group, pc, "pressure");
        ft.commit();
        //startActivity(new Intent(Converter.this, pressure.class));
    }
    public void closepressure(View view){
        pressure_con pc = (pressure_con) manager.findFragmentByTag("pressure");
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
        ft.remove(pc);
        ft.commit();
    }


    public void mass(View view) {
        mass_converter mc = new mass_converter();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.fade_out);
        ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
        ft.add(R.id.group, mc, "mass");
        ft.commit();
        //startActivity(new Intent(Converter.this, mass.class));
    }
    public  void closemass(View view){
        mass_converter tc = (mass_converter) manager.findFragmentByTag("mass");
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
        ft.remove(tc);
        ft.commit();
    }

    public void temperature(View view) {

        temp_con tc = new temp_con();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

        ft.add(R.id.group, tc, "temp");
        ft.commit();

        //startActivity(new Intent(Converter.this, temperature.class));
    }

    public void closetemp(View view){
        temp_con tc = (temp_con) manager.findFragmentByTag("temp");
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
        ft.hide(tc);
        ft.commit();
    }

    public void closevolume(View view){
        volume_con vc = (volume_con) manager.findFragmentByTag("volume");
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
        ft.remove(vc);
        ft.commit();
    }

    public void volume(View view) {
        volume_con vc = new volume_con();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        ft.add(R.id.group, vc, "volume");
        ft.commit();
    }

    public void energy(View view) {
        energy_con ec = new energy_con();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        ft.add(R.id.group, ec, "energy");
        ft.commit();
    }
    public void closenergy(View view){
        energy_con ec = (energy_con) manager.findFragmentByTag("energy");
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
        ft.remove(ec);
        ft.commit();
    }
    public void area(View view) {
        area_con ac = new area_con();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        ft.add(R.id.group, ac, "area");
        ft.commit();

    }
    public void closearea(View view){
        area_con ac = (area_con) manager.findFragmentByTag("area");
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
        ft.remove(ac);
        ft.commit();
    }
Button mass,area,energy,length,pressure,speed,temp,volume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        manager=this.getSupportFragmentManager();
        Toolbar cb=(Toolbar)findViewById(R.id.cb);
        cb.setTitleTextColor(Color.WHITE);
        setSupportActionBar(cb);
        ActionBar ab=getSupportActionBar();
        ab.setTitle(getResources().getString(R.string.converter));
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.backicon);
        abar=ab;
        NavigationView navigationView = (NavigationView) findViewById(R.id.nview);
        navigationView.setNavigationItemSelectedListener(this);

        MobileAds.initialize(this, "ca-app-pub-1220923402157861~7408314447");
        AdView ad=(AdView)findViewById(R.id.ad3);
        AdRequest adRequest=new AdRequest.Builder().build();
//        AdRequest.Builder.addTestDevice("299F444BCA1E6A2F159F36A5250A99A5")
        ad.loadAd(adRequest);

        area= (Button) findViewById(R.id.AREA);
        energy= (Button) findViewById(R.id.ENERGY);
        length= (Button) findViewById(R.id.LENGTH);
        mass= (Button) findViewById(R.id.MASS);
        pressure= (Button) findViewById(R.id.PRESSURE);
        speed= (Button) findViewById(R.id.SPEED);
        temp= (Button) findViewById(R.id.TEMPERATURE);
        volume= (Button) findViewById(R.id.VOLUME);

        area.setBackgroundResource(R.drawable.areanim);
        energy.setBackgroundResource(R.drawable.energyanim);
        length.setBackgroundResource(R.drawable.lengthanim);
        mass.setBackgroundResource(R.drawable.massanim);
        pressure.setBackgroundResource(R.drawable.pressureanim);
        speed.setBackgroundResource(R.drawable.speedanim);
        temp.setBackgroundResource(R.drawable.tempanim);
        volume.setBackgroundResource(R.drawable.volanim);

        aanim= (AnimationDrawable) area.getBackground();
        eanim= (AnimationDrawable) energy.getBackground();
        lanim= (AnimationDrawable) length.getBackground();
        manim= (AnimationDrawable) mass.getBackground();
        panim= (AnimationDrawable) pressure.getBackground();
        sanim= (AnimationDrawable) speed.getBackground();
        tanim= (AnimationDrawable) temp.getBackground();
        vanim= (AnimationDrawable) volume.getBackground();
    }
    AnimationDrawable aanim;
    AnimationDrawable eanim;
    AnimationDrawable lanim;
    AnimationDrawable manim;
    AnimationDrawable panim,sanim,tanim,vanim;

    @Override
    protected void onStart() {
        super.onStart();
        aanim.start();
        eanim.start();
        lanim.start();
        manim.start();
        panim.start();
        sanim.start();
        tanim.start();
        vanim.start();
    }

    public void inchcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.in);
            EditText cm = (EditText) findViewById(R.id.incm);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 2.54;
                cm.setText(String.valueOf(cc) + " cm");
                in.setText(i + " in");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 2.54;
                in.setText(String.valueOf(ii) + " in");
                cm.setText(c + " cm");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.in);
            EditText cm = (EditText) findViewById(R.id.incm);
            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }


    public void reset(View view) {
        EditText in = (EditText) findViewById(R.id.in);
        EditText cm = (EditText) findViewById(R.id.incm);

        in.setText("");
        cm.setText("");
    }

    public void ftcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.ft);
            EditText cm = (EditText) findViewById(R.id.ftm);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 0.305;
                cm.setText(String.valueOf(cc) + " m");
                in.setText(i + " ft");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 0.305;
                in.setText(String.valueOf(ii) + " ft");
                cm.setText(c + " m");
            } else {
                in.setText("ERROR");
                cm.setText("ERROR");
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.ft);
            EditText cm = (EditText) findViewById(R.id.ftm);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset1(View view) {
        EditText in = (EditText) findViewById(R.id.ft);
        EditText cm = (EditText) findViewById(R.id.ftm);

        in.setText("");
        cm.setText("");
    }

    public void ydcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.yd);
            EditText cm = (EditText) findViewById(R.id.ydm);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 0.9144;
                cm.setText(String.valueOf(cc) + " m");
                in.setText(i + " yd");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 0.9144;
                in.setText(String.valueOf(ii) + " yd");
                cm.setText(c + " m");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.yd);
            EditText cm = (EditText) findViewById(R.id.ydm);
            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset2(View view) {
        EditText in = (EditText) findViewById(R.id.yd);
        EditText cm = (EditText) findViewById(R.id.ydm);

        in.setText("");
        cm.setText("");
    }

    public void milecon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.mile);
            EditText cm = (EditText) findViewById(R.id.milekm);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 1.60934;
                cm.setText(String.valueOf(cc) + " km");
                in.setText(i + "miles");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 1.60934;
                in.setText(String.valueOf(ii) + "miles");
                cm.setText(c + " km");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.mile);
            EditText cm = (EditText) findViewById(R.id.milekm);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset3(View view) {
        EditText in = (EditText) findViewById(R.id.mile);
        EditText cm = (EditText) findViewById(R.id.milekm);

        in.setText("");
        cm.setText("");
    }

    public void nmilecon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.n_mile);
            EditText cm = (EditText) findViewById(R.id.n_milem);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 1852.0;
                cm.setText(String.valueOf(cc) + " m");
                in.setText(i+" n-mile");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 1852.0;
                in.setText(String.valueOf(ii)+" n-mile");
                cm.setText(c + " m");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.n_mile);
            EditText cm = (EditText) findViewById(R.id.n_milem);
            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset4(View view) {
        EditText in = (EditText) findViewById(R.id.n_mile);
        EditText cm = (EditText) findViewById(R.id.n_milem);

        in.setText("");
        cm.setText("");
    }

    public void pccon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.pc);
            EditText cm = (EditText) findViewById(R.id.pckm);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 3.086e13;
                cm.setText(String.valueOf(cc) + " km");
                in.setText(i + " pc");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 3.086e13;
                in.setText(String.valueOf(ii) + " pc");
                cm.setText(c + " km");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.pc);
            EditText cm = (EditText) findViewById(R.id.pckm);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset5(View view) {
        EditText in = (EditText) findViewById(R.id.pc);
        EditText cm = (EditText) findViewById(R.id.pckm);

        in.setText("");
        cm.setText("");
    }

    public void ozcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.oz);
            EditText cm = (EditText) findViewById(R.id.ozg);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 23.3495;
                cm.setText(String.valueOf(cc) + " g");
                in.setText(i + " oz");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 23.3495;
                in.setText(String.valueOf(ii) + " oz");
                cm.setText(c + " g");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.oz);
            EditText cm = (EditText) findViewById(R.id.ozg);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset6(View view) {
        EditText in = (EditText) findViewById(R.id.oz);
        EditText cm = (EditText) findViewById(R.id.ozg);

        in.setText("");
        cm.setText("");
    }

    public void lbcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.lb);
            EditText cm = (EditText) findViewById(R.id.lbkg);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 0.453592;
                cm.setText(String.valueOf(cc) + " kg");
                in.setText(i + " lb");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 0.453592;
                in.setText(String.valueOf(ii) + " lb");
                cm.setText(c + " kg");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.lb);
            EditText cm = (EditText) findViewById(R.id.lbkg);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset7(View view) {
        EditText in = (EditText) findViewById(R.id.lb);
        EditText cm = (EditText) findViewById(R.id.lbkg);

        in.setText("");
        cm.setText("");
    }

    public void tcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.t);
            EditText cm = (EditText) findViewById(R.id.tkg);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 1000;
                cm.setText(String.valueOf(cc) + " kg");
                in.setText(i + " t");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 1000;
                in.setText(String.valueOf(ii) + " t");
                cm.setText(c + " kg");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.t);
            EditText cm = (EditText) findViewById(R.id.tkg);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset8(View view) {
        EditText in = (EditText) findViewById(R.id.t);
        EditText cm = (EditText) findViewById(R.id.tkg);

        in.setText("");
        cm.setText("");
    }

    public void acon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.a);
            EditText cm = (EditText) findViewById(R.id.am);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 4046.86;
                cm.setText(String.valueOf(cc) + " m\u00B2");
                in.setText(i+" acre");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 4046.86;
                in.setText(String.valueOf(ii)+" acre");
                cm.setText(c + " m\u00B2");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.a);
            EditText cm = (EditText) findViewById(R.id.am);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset9(View view) {
        EditText in = (EditText) findViewById(R.id.a);
        EditText cm = (EditText) findViewById(R.id.am);

        in.setText("");
        cm.setText("");
    }

    public void hcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.h);
            EditText cm = (EditText) findViewById(R.id.hm);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 10000;
                cm.setText(String.valueOf(cc) + " m\u00B2");
                in.setText(i+" hc");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 10000;
                in.setText(String.valueOf(ii)+" hc");
                cm.setText(c + " m\u00B2");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.h);
            EditText cm = (EditText) findViewById(R.id.hm);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset10(View view) {
        EditText in = (EditText) findViewById(R.id.h);
        EditText cm = (EditText) findViewById(R.id.hm);

        in.setText("");
        cm.setText("");
    }

    public void fcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.f);
            EditText cm = (EditText) findViewById(R.id.fm);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 0.092903;
                cm.setText(String.valueOf(cc) + " m\u00B2");
                in.setText(i + " ft\u00B2");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 0.092903;
                in.setText(String.valueOf(ii) + " ft\u00B2");
                cm.setText(c + " m\u00B2");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.f);
            EditText cm = (EditText) findViewById(R.id.fm);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset11(View view) {
        EditText in = (EditText) findViewById(R.id.f);
        EditText cm = (EditText) findViewById(R.id.fm);

        in.setText("");
        cm.setText("");
    }

    public void ycon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.y);
            EditText cm = (EditText) findViewById(R.id.ym);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 0.836127;
                cm.setText(String.valueOf(cc) + " m\u00B2");
                in.setText(i + " yd\u00B2");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 0.836127;
                in.setText(String.valueOf(ii) + " yd\u00B2");
                cm.setText(c + " m\u00B2");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.y);
            EditText cm = (EditText) findViewById(R.id.ym);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset12(View view) {
        EditText in = (EditText) findViewById(R.id.y);
        EditText cm = (EditText) findViewById(R.id.ym);

        in.setText("");
        cm.setText("");
    }

    public void mcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.m);
            EditText cm = (EditText) findViewById(R.id.mm);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 2.59e6;
                cm.setText(String.valueOf(cc) + " m\u00B2");
                in.setText(i+" mile\u00B2");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 2.59e6;
                in.setText(String.valueOf(ii)+" mile\u00B2");
                cm.setText(c + " m\u00B2");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.m);
            EditText cm = (EditText) findViewById(R.id.mm);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset13(View view) {
        EditText in = (EditText) findViewById(R.id.m);
        EditText cm = (EditText) findViewById(R.id.mm);

        in.setText("");
        cm.setText("");
    }

    public void icon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.i);
            EditText cm = (EditText) findViewById(R.id.im);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 0.00064516;
                cm.setText(String.valueOf(cc) + " m\u00B2");
                in.setText(i + " in\u00B2");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 0.00064516;
                in.setText(String.valueOf(ii) + " in\u00B2");
                cm.setText(c + " m\u00B2");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.i);
            EditText cm = (EditText) findViewById(R.id.im);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset14(View view) {
        EditText in = (EditText) findViewById(R.id.i);
        EditText cm = (EditText) findViewById(R.id.im);

        in.setText("");
        cm.setText("");
    }

    public void kcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.k);
            EditText cm = (EditText) findViewById(R.id.km);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 1e6;
                cm.setText(String.valueOf(cc) + " m\u00B2");
                in.setText(i + " km\u00B2");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 1e6;
                in.setText(String.valueOf(ii) + " km\u00B2");
                cm.setText(c + " m\u00B2");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.k);
            EditText cm = (EditText) findViewById(R.id.km);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset15(View view) {
        EditText in = (EditText) findViewById(R.id.k);
        EditText cm = (EditText) findViewById(R.id.km);

        in.setText("");
        cm.setText("");
    }

    public void f3con(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.f3);
            EditText cm = (EditText) findViewById(R.id.fm3);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 0.0283168;
                cm.setText(String.valueOf(cc) + " m\u00B3");
                in.setText(i + " ft\u00B3");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 0.0283168;
                in.setText(String.valueOf(ii) + " ft\u00B3");
                cm.setText(c + " m\u00B3");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.f3);
            EditText cm = (EditText) findViewById(R.id.fm3);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset16(View view) {
        EditText in = (EditText) findViewById(R.id.f3);
        EditText cm = (EditText) findViewById(R.id.fm3);

        in.setText("");
        cm.setText("");
    }

    public void i3con(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.i3);
            EditText cm = (EditText) findViewById(R.id.im3);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 1.6387e-5;
                cm.setText(String.valueOf(cc) + " m\u00B3");
                in.setText(i + " in\u00B3");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 1.6387e-5;
                in.setText(String.valueOf(ii) + " in\u00B3");
                cm.setText(c + " m\u00B3");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.i3);
            EditText cm = (EditText) findViewById(R.id.im3);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset17(View view) {
        EditText in = (EditText) findViewById(R.id.i3);
        EditText cm = (EditText) findViewById(R.id.im3);

        in.setText("");
        cm.setText("");
    }

    public void l3con(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.l);
            EditText cm = (EditText) findViewById(R.id.lm3);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 0.001;
                cm.setText(String.valueOf(cc) + " m\u00B3");
                in.setText(i + " L");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 0.001;
                in.setText(String.valueOf(ii) + " L");
                cm.setText(c + " m\u00B3");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.l);
            EditText cm = (EditText) findViewById(R.id.lm3);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset18(View view) {
        EditText in = (EditText) findViewById(R.id.l);
        EditText cm = (EditText) findViewById(R.id.lm3);

        in.setText("");
        cm.setText("");
    }

    public void mlcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.ml);
            EditText cm = (EditText) findViewById(R.id.mlm);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 1.0e-6;
                cm.setText(String.valueOf(cc) + " m\u00B3");
                in.setText(i + " ml");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 1.0e-6;
                in.setText(String.valueOf(ii) + " ml");
                cm.setText(c + " m\u00B3");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.ml);
            EditText cm = (EditText) findViewById(R.id.mlm);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset19(View view) {
        EditText in = (EditText) findViewById(R.id.ml);
        EditText cm = (EditText) findViewById(R.id.mlm);

        in.setText("");
        cm.setText("");
    }

    public void kmcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.kh);
            EditText cm = (EditText) findViewById(R.id.khfs);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 0.2778;
                cm.setText(String.valueOf(cc) + " m/s");
                in.setText(i + " km/h");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 0.2778;
                in.setText(String.valueOf(ii) + " km/h");
                cm.setText(c + " m/s");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.kh);
            EditText cm = (EditText) findViewById(R.id.khfs);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset20(View view) {
        EditText in = (EditText) findViewById(R.id.kh);
        EditText cm = (EditText) findViewById(R.id.khfs);

        in.setText("");
        cm.setText("");
    }

    public void mhcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.mh);
            EditText cm = (EditText) findViewById(R.id.mhkh);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 1.60934;
                cm.setText(String.valueOf(cc) + " km/h");
                in.setText(i + " mph");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 1.60934;
                in.setText(String.valueOf(ii) + " mph");
                cm.setText(c + " km/h");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.mh);
            EditText cm = (EditText) findViewById(R.id.mhkh);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset21(View view) {
        EditText in = (EditText) findViewById(R.id.mh);
        EditText cm = (EditText) findViewById(R.id.mhkh);

        in.setText("");
        cm.setText("");
    }

    public void fscon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.fs);
            EditText cm = (EditText) findViewById(R.id.fsms);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 0.3048;
                cm.setText(String.valueOf(cc) + " m/s");
                in.setText(i + " ft/s");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 0.3048;
                in.setText(String.valueOf(ii) + " ft/s");
                cm.setText(c + " m/s");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.fs);
            EditText cm = (EditText) findViewById(R.id.fsms);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset22(View view) {
        EditText in = (EditText) findViewById(R.id.fs);
        EditText cm = (EditText) findViewById(R.id.fsms);

        in.setText("");
        cm.setText("");
    }

    public void ktcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.kt);
            EditText cm = (EditText) findViewById(R.id.kms);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 0.5144;
                cm.setText(String.valueOf(cc) + " m/s");
                in.setText(i+" knot");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 0.5144;
                in.setText(String.valueOf(ii)+" knot");
                cm.setText(c + " m/s");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.kt);
            EditText cm = (EditText) findViewById(R.id.kms);
            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset23(View view) {
        EditText in = (EditText) findViewById(R.id.kt);
        EditText cm = (EditText) findViewById(R.id.kms);

        in.setText("");
        cm.setText("");
    }

    public void picon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.pi);
            EditText cm = (EditText) findViewById(R.id.pipa);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 6894.76;
                cm.setText(String.valueOf(cc)+" Pa");
                in.setText(i+" lb/in\u00B2");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 6894.76;
                in.setText(String.valueOf(ii)+" lb/in\u00B2");
                cm.setText(c+" Pa");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.pi);
            EditText cm = (EditText) findViewById(R.id.pipa);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset24(View view) {
        EditText in = (EditText) findViewById(R.id.pi);
        EditText cm = (EditText) findViewById(R.id.pipa);

        in.setText("");
        cm.setText("");
    }

    public void bcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.b);
            EditText cm = (EditText) findViewById(R.id.bp);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 100000.0;
                cm.setText(String.valueOf(cc)+" Pa");
                in.setText(i+" bar");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 100000.0;
                in.setText(String.valueOf(ii)+" bar");
                cm.setText(c+" Pa");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.b);
            EditText cm = (EditText) findViewById(R.id.bp);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset25(View view) {
        EditText in = (EditText) findViewById(R.id.b);
        EditText cm = (EditText) findViewById(R.id.bp);

        in.setText("");
        cm.setText("");
    }

    public void trcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.tr);
            EditText cm = (EditText) findViewById(R.id.tp);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 133.322;
                cm.setText(String.valueOf(cc)+ " Pa");
                in.setText(i+" torr");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 133.322;
                in.setText(String.valueOf(ii)+" torr");
                cm.setText(c+" Pa");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.tr);
            EditText cm = (EditText) findViewById(R.id.tp);
            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset26(View view) {
        EditText in = (EditText) findViewById(R.id.tr);
        EditText cm = (EditText) findViewById(R.id.tp);

        in.setText("");
        cm.setText("");
    }

    public void apcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.atm);
            EditText cm = (EditText) findViewById(R.id.ap);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 101325.0;
                cm.setText(String.valueOf(cc)+" Pa");
                in.setText(i+" atm");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 101325.0;
                in.setText(String.valueOf(ii)+" atm");
                cm.setText(c+" Pa");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.atm);
            EditText cm = (EditText) findViewById(R.id.ap);
            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset27(View view) {
        EditText in = (EditText) findViewById(R.id.atm);
        EditText cm = (EditText) findViewById(R.id.ap);

        in.setText("");
        cm.setText("");
    }

    public void calcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.cal);
            EditText cm = (EditText) findViewById(R.id.calj);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 4.184;
                cm.setText(String.valueOf(cc)+" J");
                in.setText(i+" cal");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 4.184;
                in.setText(String.valueOf(ii)+" cal");
                cm.setText(c+" J");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.cal);
            EditText cm = (EditText) findViewById(R.id.calj);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset28(View view) {
        EditText in = (EditText) findViewById(R.id.cal);
        EditText cm = (EditText) findViewById(R.id.calj);

        in.setText("");
        cm.setText("");
    }

    public void kjcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.kj);
            EditText cm = (EditText) findViewById(R.id.kjj);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 4184.0;
                cm.setText(String.valueOf(cc)+" J");
                in.setText(i+" kcal");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 4184.0;
                in.setText(String.valueOf(ii)+" kcal");
                cm.setText(c+" J");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.kj);
            EditText cm = (EditText) findViewById(R.id.kjj);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset29(View view) {
        EditText in = (EditText) findViewById(R.id.kj);
        EditText cm = (EditText) findViewById(R.id.kjj);

        in.setText("");
        cm.setText("");
    }

    public void flcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.fl);
            EditText cm = (EditText) findViewById(R.id.flj);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 1.3558;
                cm.setText(String.valueOf(cc)+" J");
                in.setText(i+" ft-lb");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 1.3558;
                in.setText(String.valueOf(ii)+" ft-lb");
                cm.setText(c+" J");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.fl);
            EditText cm = (EditText) findViewById(R.id.flj);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset30(View view) {
        EditText in = (EditText) findViewById(R.id.fl);
        EditText cm = (EditText) findViewById(R.id.flj);

        in.setText("");
        cm.setText("");
    }

    public void econ(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.e);
            EditText cm = (EditText) findViewById(R.id.ej);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 1.602e-19;
                cm.setText(String.valueOf(cc)+" J");
                in.setText(i+" eV");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 1.602e-19;
                in.setText(String.valueOf(ii)+" eV");
                cm.setText(c+" J");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.e);
            EditText cm = (EditText) findViewById(R.id.ej);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset31(View view) {
        EditText in = (EditText) findViewById(R.id.e);
        EditText cm = (EditText) findViewById(R.id.ej);

        in.setText("");
        cm.setText("");
    }

    public void wcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.w);
            EditText cm = (EditText) findViewById(R.id.wj);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii * 3.6e6;
                cm.setText(String.valueOf(cc)+" J");
                in.setText(i+" kWh");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc / 3.6e6;
                in.setText(String.valueOf(ii)+" kWh");
                cm.setText(c+" J");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.w);
            EditText cm = (EditText) findViewById(R.id.wj);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset32(View view) {
        EditText in = (EditText) findViewById(R.id.w);
        EditText cm = (EditText) findViewById(R.id.wj);

        in.setText("");
        cm.setText("");
    }

    public void fkcon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.fk);
            EditText cm = (EditText) findViewById(R.id.kf);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = (ii + 459.67) / 1.8;
                cm.setText(String.valueOf(cc) + " K");
                in.setText(i + " \u00B0F");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = (cc * 1.8) - 459.67;
                in.setText(String.valueOf(ii) + " \u00B0F");
                cm.setText(c + " K");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.fk);
            EditText cm = (EditText) findViewById(R.id.kf);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset33(View view) {
        EditText in = (EditText) findViewById(R.id.fk);
        EditText cm = (EditText) findViewById(R.id.kf);

        in.setText("");
        cm.setText("");
    }

    public void fccon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.fc);
            EditText cm = (EditText) findViewById(R.id.c);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = (ii - 32.0) / 1.8;
                cm.setText(String.valueOf(cc) + " \u00B0C");
                in.setText(i + " \u00B0F");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = (cc * 1.8) + 32.0;
                in.setText(String.valueOf(ii) + " \u00B0F");
                cm.setText(c + " \u00B0C");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.fc);
            EditText cm = (EditText) findViewById(R.id.c);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset34(View view) {
        EditText in = (EditText) findViewById(R.id.fc);
        EditText cm = (EditText) findViewById(R.id.c);

        in.setText("");
        cm.setText("");
    }

    public void kccon(View view) {
        try {
            EditText in = (EditText) findViewById(R.id.kc);
            EditText cm = (EditText) findViewById(R.id.ck);

            String i, c;
            i = in.getText().toString();
            c = cm.getText().toString();

            Double ii, cc;


            if ((!i.matches("")) && (c.matches(""))) {
                ii = Double.parseDouble(i);
                cc = ii - 273.15;
                cm.setText(String.valueOf(cc) + " \u00B0C");
                in.setText(i + " K");
            } else if ((i.matches("")) && (!c.matches(""))) {
                cc = Double.parseDouble(c);
                ii = cc + 273.15;
                in.setText(String.valueOf(ii) + " K");
                cm.setText(c + " \u00B0C");
            } else {
                in.setText(getResources().getString(R.string.error));
                cm.setText(getResources().getString(R.string.error));
            }
        } catch (Exception e) {

            EditText in = (EditText) findViewById(R.id.kc);
            EditText cm = (EditText) findViewById(R.id.ck);

            in.setText(getResources().getString(R.string.error));
            cm.setText(getResources().getString(R.string.error));

        }


    }

    public void reset35(View view) {
        EditText in = (EditText) findViewById(R.id.kc);
        EditText cm = (EditText) findViewById(R.id.ck);

        in.setText("");
        cm.setText("");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

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

