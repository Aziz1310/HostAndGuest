package com.hostandguest.sim.hostandguest.SignIn.homeActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hostandguest.sim.hostandguest.R;

public class AddAnnonce2Activity extends AppCompatActivity {
    private Button btnNext2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_annonce2);
        btnNext2= (Button) findViewById(R.id.btn_next2);


        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddAnnonce2Activity.this, AddAnnonce3Activity.class);
                startActivity(intent);

            }
        });


    }
}
