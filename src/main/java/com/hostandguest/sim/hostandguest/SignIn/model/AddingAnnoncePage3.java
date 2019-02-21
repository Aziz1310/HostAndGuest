package com.hostandguest.sim.hostandguest.SignIn.model;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.hostandguest.sim.hostandguest.SignIn.ui.AddingAnnonceFragment3;
import com.hostandguest.sim.hostandguest.SignIn.ui.CustomerInfoFragment;
import com.hostandguest.sim.hostandguest.SignIn.utilies.App;

import java.util.ArrayList;

/**
 * Created by Aziz on 03/12/2017.
 */

public class AddingAnnoncePage3 extends Page  {
    App app;
    Context context;


    public static final String S1_DATA_KEY = "S1";
    public static final String S2_DATA_KEY = "S2";
    public static final String S3_DATA_KEY = "S3";
    public static final String S4_DATA_KEY = "S4";
    public static final String S5_DATA_KEY = "S5";
    public static final String S6_DATA_KEY = "S6";

    public AddingAnnoncePage3(ModelCallbacks callbacks, String title ,Context context) {
        super(callbacks, title);
        this.context=context;
    }

    @Override
    public Fragment createFragment() {
        return AddingAnnonceFragment3.create(getKey());
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        app = (App) context.getApplicationContext();
        app.annonce.setProduit(mData.getString(S1_DATA_KEY));
        app.annonce.setInternet(mData.getString(S2_DATA_KEY));
        app.annonce.setTelevision(mData.getString(S3_DATA_KEY));
        app.annonce.setChaufage(mData.getString(S4_DATA_KEY));
        app.annonce.setClimatisation(mData.getString(S5_DATA_KEY));
        app.annonce.setBureau(mData.getString(S5_DATA_KEY));
        dest.add(new ReviewItem("S1", mData.getString(S1_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("S2", mData.getString(S2_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("S3", mData.getString(S3_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("S4", mData.getString(S4_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("S5", mData.getString(S5_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("S6", mData.getString(S6_DATA_KEY), getKey(), -1));
    }

    @Override
    public boolean isCompleted() {
        return
                !TextUtils.isEmpty(mData.getString(S1_DATA_KEY)) && !TextUtils.isEmpty(mData.getString(S2_DATA_KEY));
    }
}
