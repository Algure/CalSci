package com.example.ajirigunn.calsci.homeclasses;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.ajirigunn.calsci.Calculator;
import com.example.ajirigunn.calsci.Converter;
import com.example.ajirigunn.calsci.Equations;
import com.example.ajirigunn.calsci.R;
import com.example.ajirigunn.calsci.etails;
import com.example.ajirigunn.calsci.personal_classes.Personal;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteInvitation;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.ShortDynamicLink;

import java.util.concurrent.TimeUnit;

public class gunnermain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,homepicback.OnFragmentInteractionListener,
homepic2.OnFragmentInteractionListener,homepic3.OnFragmentInteractionListener,homepic4.OnFragmentInteractionListener,homepic5.OnFragmentInteractionListener,homepic6.OnFragmentInteractionListener,
homepic7.OnFragmentInteractionListener,GoogleApiClient.OnConnectionFailedListener {

    private static final String TAG ="" ;
    public DynamicLink dynamicLink;

    public void Calculator(View v) {
        calanaim.start();
        startActivity(new Intent(gunnermain.this, Calculator.class));
    }

    public void converter(View v) {
        scaleanim.start();
        startActivity(new Intent(gunnermain.this, Converter.class));
    }

    public void personal(View view) {
        personanim.start();
        startActivity(new Intent(gunnermain.this, Personal.class));
    }

    public void equations(View view) {
        eqanim.start();
        startActivity(new Intent(gunnermain.this, Equations.class));
    }

    public  boolean test=true;
    @Override
    protected void onPause() {
        super.onPause();
        test=false;
    }
    Button cal;
    Button personal;
    Button conv;
    Button eq;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.homemenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.invite){
            Intent share=new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.sharetitle));
                share.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.sharemessage)+"http://play.google.com/store/apps/details?id=com.algure.calsci");
                startActivity(Intent.createChooser(share, "Share link!"));

        }else if(item.getItemId()==R.id.det){
            startActivity(new Intent(gunnermain.this,etails.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
test=true;
    }
SharedPreferences sp;
GoogleApiClient mgcl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        sp=getPreferences(0);
        setContentView(R.layout.activity_gunnermain);
        NavigationView nview = (NavigationView) findViewById(R.id.nview);
        Menu menu = nview.getMenu();
        Toolbar cb = (Toolbar) findViewById(R.id.cb);

        cb.setTitleTextColor(Color.WHITE);
        setSupportActionBar(cb);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, cb, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
final SharedPreferences.Editor editor=sp.edit();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nview);
        navigationView.setNavigationItemSelectedListener(this);

        MobileAds.initialize(this, "ca-app-pub-1220923402157861~7408314447");
        AdView ad=(AdView)findViewById(R.id.adview);
        AdRequest adRequest= null;
            adRequest = new AdRequest.Builder().build();

//        AdRequest.Builder.addTestDevice("299F444BCA1E6A2F159F36A5250A99A5")
        ad.loadAd(adRequest);


        RelativeLayout rl=(RelativeLayout)findViewById(R.id.pics);
        rl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(tracker==0) {
                    //TransitionManager.beginDelayedTransition(R.id.pics,android.R.anim.decelerate_interpolator);
                    homepicback h1 = new homepicback();
                    FragmentManager ft = getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction f = ft.beginTransaction();
                    f.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    f.replace(R.id.pics, h1);
                    f.commit();
                }

                if(tracker==1) {
                    homepic2 h2 = new homepic2();
                    FragmentManager ft2 = getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction f2 = ft2.beginTransaction();
                    f2.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    f2.replace(R.id.pics, h2);
                    f2.commit();
                }
                if(tracker==2) {
                    homepic3 h3 = new homepic3();
                    FragmentManager ft3 = getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction f3 = ft3.beginTransaction();
                    f3.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    //(android.R.anim.decelerate_interpolator);
                    f3.replace(R.id.pics, h3);
                    f3.commit();
                } if(tracker==3) {
                    homepic2 h4 = new homepic2();
                    FragmentManager ft4 = getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction f4 = ft4.beginTransaction();
                    f4.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    f4.replace(R.id.pics, h4);
                    f4.commit();
                }if(tracker==4) {
                    homepic5 h5 = new homepic5();
                    FragmentManager ft5 = getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction f5 = ft5.beginTransaction();
                    f5.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    f5.replace(R.id.pics, h5);
                    f5.commit();
                }
                if(tracker==5) {
                    homepic6 h6 = new homepic6();
                    FragmentManager ft6 = getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction f6 = ft6.beginTransaction();
                    f6.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    f6.replace(R.id.pics, h6);
                    f6.commit();
                }if(tracker==6){
                    homepic7 h7 = new homepic7();
                    FragmentManager ft7 = getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction f7 = ft7.beginTransaction();
                    f7.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    f7.replace(R.id.pics, h7);
                    f7.commit();
                }
                if (tracker>=6){
                    tracker=0;
                }else{
                    tracker++;
                }
                return true;
            }
        });
        try {
        drawables[0] = R.drawable.backg;
        drawables[1] = R.drawable.calcpic;

        drawables[2] = R.drawable.converter;
        drawables[3] = R.drawable.converterb;
        drawables[4] = R.drawable.mondragoequations;
         // RelativeLayout r=(RelativeLayout)findViewById(R.id.pics);

            cal= (Button) findViewById(R.id.CALCULATOR);
            conv= (Button) findViewById(R.id.button2);
            personal= (Button) findViewById(R.id.button3);
            eq= (Button) findViewById(R.id.button);


            cal.setBackgroundResource(R.drawable.calanim);
            eq.setBackgroundResource(R.drawable.eqanim);
            personal.setBackgroundResource(R.drawable.personanim);
            conv.setBackgroundResource(R.drawable.scaleanim);

scaleanim= (AnimationDrawable) conv.getBackground();
            calanaim= (AnimationDrawable) cal.getBackground();
            eqanim= (AnimationDrawable) eq.getBackground();
            personanim= (AnimationDrawable) personal.getBackground();
        }catch (Exception e){
    Log.i("rrror",e.toString());
}
}
AnimationDrawable calanaim;
    AnimationDrawable eqanim;
            AnimationDrawable personanim;
    AnimationDrawable scaleanim;
    @Override
    protected void onStart() {
        super.onStart();
        calanaim.start();
        scaleanim.start();
        personanim.start();
        eqanim.start();

        test=true;

        if (test) {
            Runnable t = new Runnable() {
                @Override
                public void run() {
                    // RelativeLayout r=(RelativeLayout)findViewById(R.id.pics);

                    while (test) {

                        tracker = 0;
                        hd.sendEmptyMessage(0);
                        for (int i = 1; i < 7; i++) {
                            //r.setBackgroundResource(drawables[i]);

                            try {
                                Thread.sleep(2200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (test) {
                                tracker = i;
                                hd.sendEmptyMessage(0);
                            }
                        }

                    }

                }
            };
            Thread thread = new Thread(t);
            try {
                thread.start();
            }catch(Exception e){}
        }
    }

    final int[] drawables = new int[5];
    int tracker = 0;
    Handler hd = new Handler() {
     //  @TargetApi(Build.VERSION_CODES.KITKAT)

        @Override
        public void handleMessage(Message msg) {
            //switch (tracker) {
              //  case 0:
            if(tracker==0) {
                //TransitionManager.beginDelayedTransition(R.id.pics,android.R.anim.decelerate_interpolator);
                homepicback h1 = new homepicback();
                FragmentManager ft = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction f = ft.beginTransaction();
                f.setCustomAnimations(R.anim.myfadein, R.anim.myfadeout);
                f.replace(R.id.pics, h1);
                f.commit();
            }

                if(tracker==1) {
                homepic2 h2 = new homepic2();
                FragmentManager ft2 = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction f2 = ft2.beginTransaction();
                    f2.setCustomAnimations(R.anim.myfadein, R.anim.myfadeout);
                f2.replace(R.id.pics, h2);
                f2.commit();
            }
                if(tracker==2) {
                homepic3 h3 = new homepic3();
                FragmentManager ft3 = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction f3 = ft3.beginTransaction();
                f3.setCustomAnimations(R.anim.myfadein, R.anim.myfadeout);
                //(android.R.anim.decelerate_interpolator);
                f3.replace(R.id.pics, h3);
                f3.commit();
            } if(tracker==3) {
                homepic2 h4 = new homepic2();
                FragmentManager ft4 = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction f4 = ft4.beginTransaction();
                f4.setCustomAnimations(R.anim.myfadein, R.anim.myfadeout);
                f4.replace(R.id.pics, h4);
                f4.commit();
            }if(tracker==4) {
                homepic5 h5 = new homepic5();
                FragmentManager ft5 = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction f5 = ft5.beginTransaction();
                f5.setCustomAnimations(R.anim.myfadein, R.anim.myfadeout);
                f5.replace(R.id.pics, h5);
                f5.commit();
            }
              if(tracker==5) {
                homepic6 h6 = new homepic6();
                FragmentManager ft6 = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction f6 = ft6.beginTransaction();
                f6.setCustomAnimations(R.anim.myfadein, R.anim.myfadeout);
                f6.replace(R.id.pics, h6);
                f6.commit();
            }if(tracker==6){
                    homepic7 h7 = new homepic7();
                    FragmentManager ft7 = getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction f7 = ft7.beginTransaction();
                    f7.setCustomAnimations(R.anim.myfadein, R.anim.myfadeout);
                    f7.replace(R.id.pics, h7);
                    f7.commit();
            }

        }
    }
        ;

        public void swap1( View view
        ) {
            RelativeLayout r = (RelativeLayout) findViewById(R.id.pics);
            homepicback h1 = new homepicback();
            FragmentManager ft = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction f = ft.beginTransaction();
            f.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            f.add(R.id.pics, h1);
            f.commit();
        }

        public void swap2() {
            RelativeLayout r = (RelativeLayout) findViewById(R.id.pics);
            homepic2 h1 = new homepic2();
            FragmentManager ft = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction f = ft.beginTransaction();
            f.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            f.add(R.id.pics, h1);
        }

        public void swap3() {
            RelativeLayout r = (RelativeLayout) findViewById(R.id.pics);
            homepic3 h1 = new homepic3();
            FragmentManager ft = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction f = ft.beginTransaction();
            f.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            f.add(R.id.pics, h1);
        }

        public void swap4() {
            RelativeLayout r = (RelativeLayout) findViewById(R.id.pics);
            homepic4 h1 = new homepic4();
            FragmentManager ft = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction f = ft.beginTransaction();
            f.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            f.add(R.id.pics, h1);
        }

        public void swap5() {
            RelativeLayout r = (RelativeLayout) findViewById(R.id.pics);
            homepic5 h1 = new homepic5();
            FragmentManager ft = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction f = ft.beginTransaction();
            f.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            f.add(R.id.pics, h1);
        }

        public void swap6() {
            RelativeLayout r = (RelativeLayout) findViewById(R.id.pics);
            homepic6 h1 = new homepic6();
            FragmentManager ft = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction f = ft.beginTransaction();
            f.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            f.add(R.id.pics, h1);
        }

        public void swap7() {
            RelativeLayout r = (RelativeLayout) findViewById(R.id.pics);
            homepic7 h1 = new homepic7();
            FragmentManager ft = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction f = ft.beginTransaction();
            f.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            f.add(R.id.pics, h1);
        }

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            int id = item.getItemId();

            if(id==R.id.Home){
                startActivity(new Intent(this, gunnermain.class));
            }
            else if (id == R.id.title) {
                startActivity(new Intent(gunnermain.this, Calculator.class));

            } else if (id == R.id.conv) {
                startActivity(new Intent(this, Converter.class));

            } else if (id == R.id.personal) {
                startActivity(new Intent(this, Personal.class));

            } else if (id == R.id.Equations) {
                startActivity(new Intent(this, Equations.class));

            }
            return true;
        }


        @Override
        public void onFragmentInteraction(Uri uri) {

        }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
