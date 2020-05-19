package com.example.sharecab;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class pageadapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    static public int posi;

    public int[] lst_images =
            {R.drawable.page1,
                    R.drawable.page2,
                    R.drawable.page3,
            };


    public String[] lst_title = {
            "Traveling?",
            "Find a group",
            "Pre share",
    }   ;


    public String[] lst_description = {
            "Travelling to airport or returning from there.",
            "Find other people having   same destination.",
            "Pre share your cab and save money."
    };


    public pageadapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (LinearLayout)o);
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //inflater
        posi = position;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.tabs,container,false);
        //basic initialisation and assignment

        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView titletxt = (TextView) view.findViewById(R.id.title);
        TextView descptxt = (TextView) view.findViewById(R.id.content);
        imageView.setImageResource(lst_images[position]);
        titletxt.setText(lst_title[position]);
        descptxt.setText(lst_description[position]);





        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
