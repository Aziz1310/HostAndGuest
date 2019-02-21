package com.hostandguest.sim.hostandguest.SignIn.homeActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hostandguest.sim.hostandguest.R;

public class AddAnnonce4Activity extends AppCompatActivity {
    private Button btnNext4;
    private EditText titre_annonce, desc_annonce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_annonce4);

     //   titre_annonce = (EditText) findViewById(R.id.titre_annonce);
        desc_annonce = (EditText) findViewById(R.id.desc_annonce);


        btnNext4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddAnnonce4Activity.this, AddAnnonce5Activity.class);
                intent.putExtra("titre_annonce", titre_annonce.getText().toString());
                intent.putExtra("desc_annonce", desc_annonce.getText().toString());

                startActivity(intent);

            }
        });
        Intent in = getIntent();
        String s1Holder=in.getExtras().getString("s1");
        System.out.println("S1Holder: "+s1Holder);

    }
}
