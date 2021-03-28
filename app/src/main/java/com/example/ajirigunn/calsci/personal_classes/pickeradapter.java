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
 class pickeradapter extends ArrayAdapter {

    public pickeradapter(Context context, String[] foods) {
        super(context, R.layout.pickerlayout,foods);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater myinflater=LayoutInflater.from(getContext());

        String singlefooditem= (String) getItem(position);
        ViewGroup customView= (ViewGroup) myinflater.inflate(R.layout.pickerlayout,parent,false);
        TextView mytext=(TextView) customView.findViewById(R.id.nov);

        mytext.setText(singlefooditem);
        return customView;

    }
}
