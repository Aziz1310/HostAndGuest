package com.hostandguest.sim.hostandguest.SignIn.providers;

import android.app.Activity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.hostandguest.sim.hostandguest.SignIn.entities.User;
import com.hostandguest.sim.hostandguest.SignIn.utilies.ConnectionSingleton;
import com.hostandguest.sim.hostandguest.SignIn.utilies.Urls;
import com.hostandguest.sim.hostandguest.SignIn.utilies.VolleyCallback;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class AccountManager {

    private  Activity activity;

    public AccountManager(Activity activity) {

        this.activity = activity;
    }


    public void signin(final String email, final String password, final VolleyCallback volleyCallback) {

        JSONObject jsonUser = new JSONObject();
        try {
            jsonUser.put("password", password);
            jsonUser.put("email", email);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String params="?email="+email+"&password="+password;


        final JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, Urls.userLogin+params,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                    volleyCallback.onSuccess(response);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallback.onError(error);

            }
        })
       ;


        ConnectionSingleton.getInstance(activity).addToRequestque(req);

    }
    public void register(final User user, final VolleyCallback volleyCallback) {

        String params="?email="+user.getEmail()+"&password="+user.getPassword()+"&nom="+user.getNom();


        final JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, Urls.userRegister+params,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                volleyCallback.onSuccess(response);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallback.onError(error);

            }
        })
                ;


        ConnectionSingleton.getInstance(activity).addToRequestque(req);

    }


}
