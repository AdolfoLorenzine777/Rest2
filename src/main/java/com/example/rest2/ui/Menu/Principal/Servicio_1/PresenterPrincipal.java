package com.example.rest2.ui.Menu.Principal.Servicio_1;

import android.util.Log;

import com.example.rest2.model.Model;
import com.example.rest2.service.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterPrincipal {

    String url, estado;
    List<String> list;

    /*private void ListData() {
        try {
            (Api.getClient().getimage()).enqueue(new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {
                    Log.d("responseGET", response.body().getMessage());
                    url = response.body().getMessage();
                    estado = response.body().getStatus();
                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {

                }
            });
        }catch (Exception e){
             Log.d("ERROR===========", ""+e);
        }
    }*/

    public List<String> getdata(){
       // ListData();
        list.add(url);
        list.add(estado);
        return list;
    }

}
