package com.example.rest2.service;




import com.example.rest2.model.Model;
import com.example.rest2.model.ModelService2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("getAll")
        // API's endpoints
    Call<List<ModelService2>> getList();

    /*@GET("/get/{id}")
        // API's endpoints
    Call<Model> getimage();*/

// Model is POJO class to get the data from API, we use List<Model> in callback because the data in our API is starting from JSONArray
}
