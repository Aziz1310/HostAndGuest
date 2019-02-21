package com.hostandguest.sim.hostandguest.SignIn.homeActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.hostandguest.sim.hostandguest.R;

public class AddAnnonce3Activity extends AppCompatActivity {
    private Button btnNext3;
    private Switch switch1,switch2,switch3,switch4,switch5,switch6;
    private String s1,s2,s3,s4,s5,s6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_annonce3);
        btnNext3= (Button) findViewById(R.id.btn_next3);
        switch1= (Switch) findViewById(R.id.switch1);
        switch2= (Switch) findViewById(R.id.switch2);
        switch3= (Switch) findViewById(R.id.switch3);
        switch4= (Switch) findViewById(R.id.switch4);
        switch5= (Switch) findViewById(R.id.switch5);
        switch6= (Switch) findViewById(R.id.switch6);
        if(switch1.isChecked())
            s1="1";
        else
            s1="0";
        if(switch2.isChecked())
            s2="1";
        else
            s2="0";
        if(switch3.isChecked())
            s3="1";
        else
            s3="0";
        if(switch4.isChecked())
            s4="1";
        else
            s4="0";
        if(switch5.isChecked())
            s5="1";
        else
            s5="0";
        if(switch6.isChecked())
            s6="1";
        else
            s6="0";



        btnNext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddAnnonce3Activity.this, AddAnnonce4Activity.class);
                startActivity(intent);


            }
        });
        Intent intent1=new Intent(AddAnnonce3Activity.this, AddAnnonce5Activity.class);
        intent1.putExtra("s1", s1.toString());
        intent1.putExtra("s2", s2.toString());
        intent1.putExtra("s3", s3.toString());
        intent1.putExtra("s4", s4.toString());
        intent1.putExtra("s5", s5.toString());
        intent1.putExtra("s6", s6.toString());
        startActivity(intent1);


    }
}
