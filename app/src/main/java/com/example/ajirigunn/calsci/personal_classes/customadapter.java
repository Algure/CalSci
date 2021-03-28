package com.example.ajirigunn.calsci.personal_classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ajirigunn.calsci.R;

/**
 * Created by AJIRI GUNN on 10/1/2017.
 */
 class customadapter extends ArrayAdapter {

    public customadapter(Context context, String[] foods) {
        super(context, R.layout.custom_personal ,foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater myinflater=LayoutInflater.from(getContext());

        String singlefooditem= (String) getItem(position);
        ViewGroup customView= (ViewGroup) myinflater.inflate(R.layout.custom_personal,parent,false);
        TextView mytext=(TextView) customView.findViewById(R.id.mytext);

        mytext.setText(singlefooditem);
        return customView;

    }
}
