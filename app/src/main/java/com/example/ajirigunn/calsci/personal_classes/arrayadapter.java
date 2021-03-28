package com.example.ajirigunn.calsci.personal_classes;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by AJIRI GUNN on 9/29/2017.
 */
public class arrayadapter extends ArrayAdapter<myfunctions> {

    public arrayadapter(Context context, ArrayList<myfunctions>users){
        super(context,0,users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        myfunctions myfun=getItem(position);

        if (convertView==null){}

        return super.getView(position, convertView, parent);
    }
}
