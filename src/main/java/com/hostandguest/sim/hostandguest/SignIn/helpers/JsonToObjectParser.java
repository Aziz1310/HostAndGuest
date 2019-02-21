package com.hostandguest.sim.hostandguest.SignIn.helpers;


import com.hostandguest.sim.hostandguest.SignIn.entities.User;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class JsonToObjectParser {


    public User parseUser(JSONObject jsonuser) {
        User n = new User();

        try {
            n.setEmail(jsonuser.getString("email"));
            n.setNom(jsonuser.getString("nom"));
            n.setPassword(jsonuser.getString("password"));
            n.setImage(jsonuser.getString("image"));
            n.setPrenom(jsonuser.getString("prenom"));
            n.setType(jsonuser.getString("roles"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return n;

    }


}
