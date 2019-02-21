package com.hostandguest.sim.hostandguest.SignIn;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hostandguest.sim.hostandguest.R;
import com.hostandguest.sim.hostandguest.SignIn.adapter.ViewPagerAdapter;
import com.hostandguest.sim.hostandguest.SignIn.fragments.RegisterFragment;

public class RegisterActivity extends AppCompatActivity implements RegisterFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ViewPager pager = (ViewPager) findViewById(R.id.VpPager);
        pager.setAdapter(buildAdapter());
        TabLayout tabLayout = (TabLayout) findViewById(R.id.event_sliding_tabs);
        tabLayout.setupWithViewPager(pager);

    }

    private PagerAdapter buildAdapter() {
        return (new ViewPagerAdapter(this, getSupportFragmentManager()));
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
