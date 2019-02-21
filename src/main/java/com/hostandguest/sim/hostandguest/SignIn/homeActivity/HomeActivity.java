package com.hostandguest.sim.hostandguest.SignIn.homeActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.hostandguest.sim.hostandguest.R;
import com.hostandguest.sim.hostandguest.SignIn.AddingAnnonceActivity;
import com.hostandguest.sim.hostandguest.SignIn.adapter.AnnoncesAdapter;
import com.hostandguest.sim.hostandguest.SignIn.entities.Annonce;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class HomeActivity extends AppCompatActivity {
    private List<Annonce> annoceList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AnnoncesAdapter annocesAdapter;
    private FloatingActionButton btnAddAnnonce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_annonces);
        annocesAdapter= new AnnoncesAdapter(this,annoceList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(annocesAdapter);
        prepareAnnonceData();
        btnAddAnnonce= (FloatingActionButton) findViewById(R.id.addAnnonce);
        btnAddAnnonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this, AddingAnnonceActivity.class);
                startActivity(intent);

            }
        });

    }
    private void prepareAnnonceData() {

        Annonce annonce= new Annonce();
        annonce.setTitre("maison d'hote");
        annonce.setPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwQDo_9xXfhHI3ZZGiwk8ApsH_iMgjlMRzu8wzjc1jafh1REdf");
        annonce.setDescription("Description1..........");
        Annonce annonce1= new Annonce();
        annonce1.setTitre("maison d'hote1");
        annonce1.setPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHtQ26HP_csrf2KoiDiG58f_gHiOh4I_oHUQL0X3LVh6t2OiwZ");
        annonce1.setDescription("Description2..........");
        annoceList.add(annonce);
        annoceList.add(annonce1);
        annocesAdapter.notifyDataSetChanged();
    }
}
