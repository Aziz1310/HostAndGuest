package com.hostandguest.sim.hostandguest.SignIn.model;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.hostandguest.sim.hostandguest.SignIn.ui.AddingAnnonceFragment4;
import com.hostandguest.sim.hostandguest.SignIn.ui.AddingAnnonceFragment5;
import com.hostandguest.sim.hostandguest.SignIn.ui.CustomerInfoFragment;
import com.hostandguest.sim.hostandguest.SignIn.utilies.App;

import java.util.ArrayList;

/**
 * Created by Aziz on 03/12/2017.
 */

public class AddingAnnoncePage5 extends Page  {
    App app;
    Context context;

    public static final String SEJOUR_MIN_DATA_KEY = "sejour min";
    public static final String SEJOUR_MAX_DATA_KEY = "sjour max";
    public static final String PRIX_DATA_KEY = "prix";


    public AddingAnnoncePage5(ModelCallbacks callbacks, String title, Context context)
    {
        super(callbacks, title);
        this.context=context;
    }

    @Override
    public Fragment createFragment() {
        return AddingAnnonceFragment5.create(getKey());
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        app = (App) context.getApplicationContext();
        app.annonce.setSejour_min(mData.getString(SEJOUR_MIN_DATA_KEY));
        app.annonce.setSejour_max(mData.getString(SEJOUR_MAX_DATA_KEY));
        app.annonce.setPrix(mData.getString(PRIX_DATA_KEY));
        dest.add(new ReviewItem("sejour min", mData.getString(SEJOUR_MIN_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("sejour max", mData.getString(SEJOUR_MAX_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("prix", mData.getString(PRIX_DATA_KEY), getKey(), -1));

    }

    @Override
    public boolean isCompleted() {
        return !TextUtils.isEmpty(mData.getString(SEJOUR_MIN_DATA_KEY)) && !TextUtils.isEmpty(mData.getString(SEJOUR_MAX_DATA_KEY))&&!TextUtils.isEmpty(mData.getString(PRIX_DATA_KEY));
    }
}
