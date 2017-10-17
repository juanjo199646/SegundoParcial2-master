package com.jonmid.segundoparcial.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonmid.segundoparcial.Array.Images;
import com.jonmid.segundoparcial.Model.TeamModelJuanFajardo;
import com.jonmid.segundoparcial.R;
import com.jonmid.segundoparcial.Views.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JUANJO FAJARDO on 17/10/2017.
 */

public class TeamAdapterJuanFajardo  extends  RecyclerView.Adapter<TeamAdapterJuanFajardo.ViewHolder>{

    List<TeamModelJuanFajardo> teamModelJuanFajardoList = new ArrayList<>();
    Context context;


    public TeamAdapterJuanFajardo(List<TeamModelJuanFajardo> teamModelJuanFajardoList, Context context) {
        this.teamModelJuanFajardoList = teamModelJuanFajardoList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // configura el viewholder
        // obtener el archivo item.xml
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team,parent, false);

        // pasar los componentes del archivo item.xml para hacer referencia de ellos
        ViewHolder viewHolder =  new ViewHolder(item);

        // retornar el viewhorlder
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // encargado de trabajar los componentes del item

        holder.textViewName.setText(teamModelJuanFajardoList.get(position).getName());
        holder.textViewCode.setText(teamModelJuanFajardoList.get(position).getCode());
        Picasso.with(context).load(Images.imageRandom()).into(holder.imageView);





    }


    // el tamaño de los datos que llegan
    @Override
    public int getItemCount() {

        return teamModelJuanFajardoList.size();
    }

    // es una clase que hace referencia a los componenetes (item.xml)

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName;
        TextView textViewCode;
        ImageView imageView;




        public ViewHolder(View item) {
            super(item);

            item.setOnClickListener(this);


            textViewName = (TextView) item.findViewById(R.id.id_tv_name_team);
            textViewCode = (TextView) item.findViewById(R.id.id_tv_cod_team);
            imageView = (ImageView) item.findViewById(R.id.id_img_team);


        }

        @Override
        public void onClick(View view) {
            Context contextItem = view.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("name", teamModelJuanFajardoList.get(getLayoutPosition()).getName());
            contextItem.startActivity(intent);
        }

    }

}



