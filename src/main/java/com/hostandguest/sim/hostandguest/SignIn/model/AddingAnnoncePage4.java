package com.hostandguest.sim.hostandguest.SignIn.model;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.hostandguest.sim.hostandguest.SignIn.ui.AddingAnnonceFragment4;
import com.hostandguest.sim.hostandguest.SignIn.ui.CustomerInfoFragment;
import com.hostandguest.sim.hostandguest.SignIn.utilies.App;

import java.util.ArrayList;

/**
 * Created by Aziz on 03/12/2017.
 */

public class AddingAnnoncePage4 extends Page {
    App app;
    Context context;

    public static final String IMAGE_DATA_KEY = "image";
    public static final String DESC_DATA_KEY = "desc";
    public static final String TITLE_DATA_KEY = "title";


    public AddingAnnoncePage4(ModelCallbacks callbacks, String title,Context context) {
        super(callbacks, title);
        this.context=context;
    }

    @Override
    public Fragment createFragment()
    {
        return AddingAnnonceFragment4.create(getKey());
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        app = (App) context.getApplicationContext();
        app.annonce.setDescription(mData.getString(DESC_DATA_KEY));
        app.annonce.setTitre(mData.getString(TITLE_DATA_KEY));
        //dest.add(new ReviewItem("image", mData.getString(IMAGE_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("desc", mData.getString(DESC_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("title", mData.getString(TITLE_DATA_KEY), getKey(), -1));

    }

    @Override
    public boolean isCompleted() {
        return  !TextUtils.isEmpty(mData.getString(DESC_DATA_KEY))&&!TextUtils.isEmpty(mData.getString(TITLE_DATA_KEY));
    }
}
