package com.hostandguest.sim.hostandguest.SignIn.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.hostandguest.sim.hostandguest.SignIn.fragments.LoginFragment;
import com.hostandguest.sim.hostandguest.SignIn.fragments.RegisterFragment;

/**
 * Created by Syrine on 03/04/2017.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private static int NUM_ITEMS = 2;
    private static Fragment fg;
    Context ctx = null;
    private FragmentManager mFragmentManager;

    public ViewPagerAdapter(Context ctx, FragmentManager fragmentManager) {
        super(fragmentManager);
        mFragmentManager = fragmentManager;
        this.ctx = ctx;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return LoginFragment.newInstance();
            case 1:
                return RegisterFragment.newInstance("gg", "Register");

            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Sign in";
            case 1:
                return "Sign up";

        }
        return "default";
    }

}