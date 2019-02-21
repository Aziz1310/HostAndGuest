package com.hostandguest.sim.hostandguest.SignIn.homeActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hostandguest.sim.hostandguest.R;


public class AddAnnonceActivity extends AppCompatActivity {
    private Button btn_continuer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_annonce);
        btn_continuer= (Button) findViewById(R.id.btn_continuer);
        btn_continuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddAnnonceActivity.this, AddAnnonce1Activity.class);
                startActivity(intent);

            }
        });




    }
}
