package com.olgunyilmaz.cryptocurrencyproject.service;

import android.database.Observable;

import com.olgunyilmaz.cryptocurrencyproject.model.CryptoModel;
import com.olgunyilmaz.cryptocurrencyproject.model.ExchangeRateResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CryptoAPI {

    @GET("v1/exchangerate/USD")
    Call<ExchangeRateResponse> getData(
            @Query("apikey") String apiKey,
            @Query("output_format") String outputFormat
    );

}
