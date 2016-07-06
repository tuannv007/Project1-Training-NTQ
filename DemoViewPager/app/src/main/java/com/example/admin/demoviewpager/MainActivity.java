package com.example.admin.demoviewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Integer> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager = (ViewPager) this.findViewById(R.id.pg);
        arrayList.add(R.drawable.image);
        arrayList.add(R.drawable.username);
        MyPager myPager = new MyPager(this,arrayList);
        pager.setAdapter(myPager);
    }
}
