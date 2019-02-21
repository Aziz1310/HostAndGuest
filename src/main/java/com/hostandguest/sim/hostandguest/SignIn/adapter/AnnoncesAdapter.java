package com.hostandguest.sim.hostandguest.SignIn.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hostandguest.sim.hostandguest.R;
import com.hostandguest.sim.hostandguest.SignIn.entities.Annonce;

import java.util.List;

/**
 * Created by Aziz on 20/11/2017.
 */

public class AnnoncesAdapter extends RecyclerView.Adapter<AnnoncesAdapter.MyViewHolder> {
    private List<Annonce> annoncesList;
    private Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView photo;
        public TextView desc;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title_annonce);
            desc = (TextView) view.findViewById(R.id.description);
            photo = (ImageView) view.findViewById(R.id.image_annonce);

        }
    }
    public AnnoncesAdapter(Context context, List<Annonce> annoncesList) {
        this.annoncesList=annoncesList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.annoce_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Annonce annonce = annoncesList.get(position);
        holder.title.setText(annonce.getTitre());
        Glide.with(context)
                .load(annonce.getPhoto())
                .into(holder.photo);


    }

    @Override
    public int getItemCount() {
        return annoncesList.size();
    }


}

