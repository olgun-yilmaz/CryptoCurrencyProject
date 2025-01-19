package com.olgunyilmaz.cryptocurrencyproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.olgunyilmaz.cryptocurrencyproject.R;
import com.olgunyilmaz.cryptocurrencyproject.adapter.RecyclerViewAdapter;
import com.olgunyilmaz.cryptocurrencyproject.model.CryptoModel;
import com.olgunyilmaz.cryptocurrencyproject.model.ExchangeRateResponse;
import com.olgunyilmaz.cryptocurrencyproject.service.CryptoAPI;

import java.util.ArrayList;


import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private String BASE_URL = "https://rest.coinapi.io/";
    Retrofit retrofit;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    CompositeDisposable compositeDisposable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Retrofit & JSON

        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        loadData();

    }

    private void loadData(){

        final CryptoAPI cryptoAPI = retrofit.create(CryptoAPI.class);
        /*

        String apiKey = BuildConfig.API_KEY;
        System.out.println("API Key: " + apiKey);

        Log.d("API_KEY", BuildConfig.API_KEY);*/
        


        Call<ExchangeRateResponse> call = cryptoAPI.getData("apiKey","json");

        call.enqueue(new Callback<ExchangeRateResponse>() {
            @Override
            public void onResponse(Call<ExchangeRateResponse> call, Response<ExchangeRateResponse> response) {
                if (response.isSuccessful()) {
                    ExchangeRateResponse exchangeRateResponse = response.body();
                    ArrayList<CryptoModel> cryptoModels = exchangeRateResponse.rates;

                    //RecyclerView
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerViewAdapter = new RecyclerViewAdapter(cryptoModels);
                    recyclerView.setAdapter(recyclerViewAdapter);
                }
            }

            @Override
            public void onFailure(Call<ExchangeRateResponse> call, Throwable t) {
                System.out.println("faiulre "+t.getMessage());
            }
        });
    }
    


    @Override
    protected void onDestroy() {
        super.onDestroy();

        compositeDisposable.clear();
    }
}