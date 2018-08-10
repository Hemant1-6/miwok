package com.example.hemant.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hemant on 7/10/2017.
 */

public class WordAdapter extends ArrayAdapter {
    private int mColorResourceId;
    private static final String LOG_TAG =WordAdapter.class.getSimpleName();

    public WordAdapter(Activity context, ArrayList<Word> word,int ColorResourceId) {
        super(context,0, (List) word);
        mColorResourceId = ColorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View vv = LayoutInflater.from(getContext()).inflate(R.layout.my_list,parent,false);
        Word currentobject = (Word) getItem(position);
        TextView tv1 = (TextView) vv.findViewById(R.id.tveng);
        TextView tv2 = (TextView) vv.findViewById(R.id.tvmiwo);
        ImageView iv = (ImageView) vv.findViewById(R.id.imag);
        View laylist =  vv.findViewById(R.id.layoutlist);
        LinearLayout play = vv.findViewById(R.id.play);
        tv1.setText(currentobject.getDefaultTransltion());
        tv2.setText(currentobject.getMiwokTranslation());
        iv.setImageResource(currentobject.getmImageresource());
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        laylist.setBackgroundColor(color);
        play.setBackgroundColor(color);
        return vv;
    }
}
