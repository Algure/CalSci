package com.example.ajirigunn.calsci;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AJIRI GUNN on 12/10/2017.
 */
public class customnav extends ArrayAdapter {
    public customnav(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public customnav(Context context, int resource) {
        super(context, resource);
    }

    public customnav(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    public customnav(Context context, int resource, Object[] objects) {
        super(context, resource, objects);
    }

    public customnav(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myinflater=LayoutInflater.from(getContext());

        String singlefooditem= (String) getItem(position);
        ViewGroup customView= (ViewGroup) myinflater.inflate(R.layout.customnav,parent,false);
        TextView mytext=(TextView)customView.findViewById(R.id.textView3);

        ImageView iview=(ImageView)customView.findViewById(R.id.iview);
        mytext.setText(singlefooditem);
        return customView;
    }

    public customnav(Context context, int resource, int textViewResourceId, Object[] objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
