package com.hostandguest.sim.hostandguest.SignIn.utilies;

import android.app.Application;

import com.hostandguest.sim.hostandguest.SignIn.entities.Annonce;

/**
 * Created by Aziz on 03/12/2017.
 */

public class App  extends Application{

    public Annonce annonce;

    @Override
    public void onCreate() {
        super.onCreate();
        annonce = new Annonce() ;
    }
}
