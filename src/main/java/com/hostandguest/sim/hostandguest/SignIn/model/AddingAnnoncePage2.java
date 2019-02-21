package com.hostandguest.sim.hostandguest.SignIn.model;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.hostandguest.sim.hostandguest.SignIn.ui.AddingAnnonceFragment2;
import com.hostandguest.sim.hostandguest.SignIn.ui.CustomerInfoFragment;
import com.hostandguest.sim.hostandguest.SignIn.utilies.App;

import java.util.ArrayList;

/**
 * Created by Aziz on 03/12/2017.
 */

public class AddingAnnoncePage2 extends Page  {
    App app ;
    Context context;

    public static final String COUNTRY_DATA_KEY = "country";
    public static final String STREET_DATA_KEY = "street";
    public static final String CODEPOSTAL_DATA_KEY = "codepostal";
    public static final String VILLE_DATA_KEY = "ville";

    public AddingAnnoncePage2(ModelCallbacks callbacks, String title,Context context) {
        super(callbacks, title);
        this.context=context;
    }

    @Override
    public Fragment createFragment() {
        return AddingAnnonceFragment2.create(getKey());
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        app = (App) context.getApplicationContext();


        app.annonce.setPays(mData.getString(COUNTRY_DATA_KEY));
        app.annonce.setRue(mData.getString(STREET_DATA_KEY));
        app.annonce.setCodePostal(mData.getString(CODEPOSTAL_DATA_KEY));
        app.annonce.setVille(mData.getString(VILLE_DATA_KEY));
        dest.add(new ReviewItem("country", mData.getString(COUNTRY_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("street", mData.getString(STREET_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("codepostal", mData.getString(CODEPOSTAL_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("ville", mData.getString(VILLE_DATA_KEY), getKey(), -1));
    }

    @Override
    public boolean isCompleted() {
        return !TextUtils.isEmpty(mData.getString(COUNTRY_DATA_KEY)) && !TextUtils.isEmpty(mData.getString(STREET_DATA_KEY))&&!TextUtils.isEmpty(mData.getString(CODEPOSTAL_DATA_KEY))&&!TextUtils.isEmpty(mData.getString(VILLE_DATA_KEY));
    }
}
