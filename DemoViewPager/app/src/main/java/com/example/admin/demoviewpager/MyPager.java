package com.example.admin.demoviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by admin on 7/5/2016.
 */
public class MyPager extends PagerAdapter {
    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public MyPager( Context mContext, ArrayList<Integer> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
        mInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mInflater.inflate(R.layout.item,null);
        ImageView img = (ImageView) itemView.findViewById(R.id.imageView);
        img.setImageResource(arrayList.get(position));
        container.addView(itemView);
        return itemView;

    }
}
