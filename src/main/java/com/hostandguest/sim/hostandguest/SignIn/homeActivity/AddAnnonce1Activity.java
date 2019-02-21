package com.hostandguest.sim.hostandguest.SignIn.homeActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hostandguest.sim.hostandguest.R;
import com.hostandguest.sim.hostandguest.SignIn.entities.User;
import com.hostandguest.sim.hostandguest.SignIn.helpers.JsonToObjectParser;
import com.hostandguest.sim.hostandguest.SignIn.utilies.VolleyCallback;

import org.json.JSONException;
import org.json.JSONObject;


public class AddAnnonce1Activity extends AppCompatActivity {
    private Button btnNext1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_annonce1);
        btnNext1= (Button) findViewById(R.id.btn_next1);


        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddAnnonce1Activity.this, AddAnnonce2Activity.class);
                startActivity(intent);

            }
        });




    }

}
