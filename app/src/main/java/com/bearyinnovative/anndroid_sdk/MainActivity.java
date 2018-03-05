package com.bearyinnovative.anndroid_sdk;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bearyinnovative.horcrux.ui.chat.conversation.BearyConversationView;
import com.bearyinnovative.horcrux.ui.view.BottomNavigationViewEx;

import javax.annotation.meta.When;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottom_bar);
        bottomNavigationViewEx.enableAnimation(false);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return EmptyFragment.newInstance();
                    case 1:
                        return EmptyFragment.newInstance();
                    case 2:
                        return ChatFragment.newInstance();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        bottomNavigationViewEx.setupWithViewPager(viewPager);
    }
}
