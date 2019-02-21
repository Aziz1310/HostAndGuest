package com.hostandguest.sim.hostandguest.SignIn.homeActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hostandguest.sim.hostandguest.R;

import java.util.HashMap;
import java.util.Map;

public class AddAnnonce5Activity extends AppCompatActivity {
     private EditText sejour_min, sejour_max, prix, titre_annonce, desc_annonce;
     private Button btn_publier_annonce;
    // Create string variable to hold the EditText Value.
    private String sejour_minHolder, sejour_maxHolder, prixHolder, titreHolder,descHolder ;
    private String s1Holder,s2Holder,s3Holder,s4Holder,s5Holder,s6Holder;

    // Creating Progress dialog.
    private ProgressDialog progressDialog;
    // Creating Volley RequestQueue.
    private RequestQueue requestQueue;
    // Storing server url into String variable.
    String HttpUrl = "http://azizgh13.alwaysdata.net/insert_annonce.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_annonce5);
        // Assigning ID's to EditText.
        sejour_min = (EditText) findViewById(R.id.sejour_minim);
        sejour_max = (EditText) findViewById(R.id.sejour_max);
        prix = (EditText) findViewById(R.id.prix);
     //   titre_annonce = (EditText) findViewById(R.id.titre_annonce);
        desc_annonce = (EditText) findViewById(R.id.desc_annonce);
        btn_publier_annonce= (Button) findViewById(R.id.publier_annonce);

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(AddAnnonce5Activity.this);

        progressDialog = new ProgressDialog(AddAnnonce5Activity.this);
        btn_publier_annonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Showing progress dialog at user registration time.
                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();

                // Calling method to get value from EditText.
                GetValueFromEditText();

                // Creating string request with post method.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing response message coming from server.
                                Toast.makeText(AddAnnonce5Activity.this, ServerResponse, Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing error message if something goes wrong.
                                Toast.makeText(AddAnnonce5Activity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {

                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.
                        params.put("sejour_min", sejour_minHolder);
                        params.put("sejour_max", sejour_maxHolder);
                        params.put("prix", prixHolder);
                        params.put("desc", descHolder);
                        params.put("titre", titreHolder);
                        params.put("produit", s1Holder);
                        params.put("internet", s2Holder);
                        params.put("television", s3Holder);
                        params.put("chaufage", s4Holder);
                        params.put("climatisation", s5Holder);
                        params.put("bureau", s6Holder);

                        return params;
                    }

                };
                // Creating RequestQueue.
                RequestQueue requestQueue = Volley.newRequestQueue(AddAnnonce5Activity.this);

                // Adding the StringRequest object into requestQueue.
                requestQueue.add(stringRequest);


            }
        });







    }
    public void GetValueFromEditText(){

        sejour_minHolder = sejour_min.getText().toString().trim();
        sejour_maxHolder = sejour_max.getText().toString().trim();
        prixHolder = prix.getText().toString().trim();
        Intent in = getIntent();
        titreHolder= in.getExtras().getString("titre_annonce");
        descHolder=in.getExtras().getString("desc_annonce");
        //s1Holder=in.getExtras().getString("s1");
        //s2Holder=in.getExtras().getString("s2");
        //s3Holder=in.getExtras().getString("s3");
        //s4Holder=in.getExtras().getString("s4");
        //s5Holder=in.getExtras().getString("s5");
        s6Holder=in.getExtras().getString("s6");
        System.out.println("S1Holder"+s1Holder);


    }


}
