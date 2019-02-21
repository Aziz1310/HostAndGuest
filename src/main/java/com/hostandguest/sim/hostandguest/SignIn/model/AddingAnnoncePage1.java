package com.hostandguest.sim.hostandguest.SignIn.model;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.hostandguest.sim.hostandguest.SignIn.ui.AddingAnnonceFragment1;
import com.hostandguest.sim.hostandguest.SignIn.ui.AddingAnnonceFragment2;
import com.hostandguest.sim.hostandguest.SignIn.ui.CustomerInfoFragment;
import com.hostandguest.sim.hostandguest.SignIn.utilies.App;

import java.util.ArrayList;

/**
 * Created by Aziz on 03/12/2017.
 */

public class AddingAnnoncePage1 extends Page {
    App app ;
Context context;
    public static final String ACCESS_DATA_KEY = "type d'accés";
    public static final String PROPRTIES_DATA_KEY = "type de propriété";

    public AddingAnnoncePage1(ModelCallbacks callbacks, String title,Context context) {
        super(callbacks, title);
        this.context  = context;
    }

    @Override
    public Fragment createFragment()
    {
        return AddingAnnonceFragment1.create(getKey());
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        app = (App) context.getApplicationContext();

        app.annonce.setType_logement(mData.getString(ACCESS_DATA_KEY));
        app.annonce.setType_location(mData.getString(PROPRTIES_DATA_KEY));

        dest.add(new ReviewItem("type d'accées", mData.getString(ACCESS_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("type de propriété", mData.getString(PROPRTIES_DATA_KEY), getKey(), -1));
    }

    @Override
    public boolean isCompleted() {
        return !TextUtils.isEmpty(mData.getString(ACCESS_DATA_KEY)) && !TextUtils.isEmpty(mData.getString(PROPRTIES_DATA_KEY));
    }
}