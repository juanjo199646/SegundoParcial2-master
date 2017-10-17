package com.jonmid.segundoparcial.Parser;

import com.jonmid.segundoparcial.Model.TeamModelJuanFajardo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JUANJO FAJARDO on 17/10/2017.
 */

public class TeamJsonJuanFajardo {



    // crear un metodo que se encargue del procesado de informacion

    public static List<TeamModelJuanFajardo> getData(String content) throws JSONException {
        JSONObject jsonObject = new JSONObject(content);
        JSONArray jsonArray = jsonObject.getJSONArray("teams");
        List<TeamModelJuanFajardo> teamlist = new ArrayList<>();
        for (int i = 0 ; i <jsonArray.length(); i++){
            JSONObject item = jsonArray.getJSONObject(i);

            TeamModelJuanFajardo teamModelJuanFajardo = new TeamModelJuanFajardo();

            teamModelJuanFajardo.setName(item.getString("name"));
            teamModelJuanFajardo.setCode(item.getString("code"));




            teamlist.add(teamModelJuanFajardo);
        }
        // que dede retornar
        return  teamlist;

    }


}



