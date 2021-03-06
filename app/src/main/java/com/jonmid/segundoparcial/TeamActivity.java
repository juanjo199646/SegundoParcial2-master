package com.jonmid.segundoparcial;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jonmid.segundoparcial.Adapter.TeamAdapterJuanFajardo;
import com.jonmid.segundoparcial.Connection.Connection;
import com.jonmid.segundoparcial.Model.TeamModelJuanFajardo;
import com.jonmid.segundoparcial.Parser.TeamJsonJuanFajardo;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class TeamActivity extends AppCompatActivity {

    ProgressBar progressBar;
    List<TeamModelJuanFajardo> teamModelJuanFajardoList;
    TeamAdapterJuanFajardo teamAdapterJuanFajardo;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);


        progressBar = (ProgressBar) findViewById(R.id.id_pb_progressbar);
        recyclerView = (RecyclerView) findViewById(R.id.id_rv_recyclerview);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        loadData();

    }

    public void processData() {
        teamAdapterJuanFajardo= new TeamAdapterJuanFajardo(teamModelJuanFajardoList, getApplicationContext());
        recyclerView.setAdapter(teamAdapterJuanFajardo);
    }


    public Boolean isOnLine() {
        // Hacer llamado al servicio de conectividad utilizando el ConnectivityManager
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        // Obtener el estado de la conexion a internet en el dispositivo
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        // Validar el estado obtenido de la conexion
        if (networkInfo != null) {
            return true;
        } else {
            return false;
        }
    }


    public void loadData() {
        if (isOnLine()) {
            TaskUsers taskUsers = new TaskUsers();
            taskUsers.execute("http://api.football-data.org/v1/competitions/445/teams");
        } else {
            Toast.makeText(this, "Sin conexion", Toast.LENGTH_SHORT).show();
        }
    }

    public class TaskUsers extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }


        @Override
        protected String doInBackground(String... strings) {

            String content = null;
            try {
                content = Connection.getData(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                teamModelJuanFajardoList = TeamJsonJuanFajardo.getData(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            processData();

            progressBar.setVisibility(View.GONE);
        }



    }




}
