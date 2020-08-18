package com.example.rest2.service;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AbhiAndroid
 */
public class Api {
    private static Retrofit retrofit = null;

    private static String accessToken = "1";
    private static String BASE_URL = "http://10.0.2.2:8080/api/";

    public static ApiInterface getClient() {
        OkHttpClient defaultHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        //getAccessToken is your own accessToken(retrieve it by saving in shared preference or any other option )

                        Request authorisedRequest = chain.request().newBuilder()
                                .addHeader("Authorization", accessToken).build();
                        return chain.proceed(authorisedRequest);
                    }}).build();
        // change your base URL
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(defaultHttpClient)
                    .build();
        }
        //Creating object for our interface
        ApiInterface api = retrofit.create(ApiInterface.class);

        return api; // return the APIInterface object
    }

}
