package com.olgunyilmaz.cryptocurrencyproject.service;

import android.database.Observable;

import com.olgunyilmaz.cryptocurrencyproject.model.CryptoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {
    //GET

    //URL BASE :https://raw.githubusercontent.com/
    // atilsamancioglu/K21-JSONDataSet/master/crypto.json -> key
    //GET -> price?key=xxx

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    Call<List<CryptoModel>> getData();

}
