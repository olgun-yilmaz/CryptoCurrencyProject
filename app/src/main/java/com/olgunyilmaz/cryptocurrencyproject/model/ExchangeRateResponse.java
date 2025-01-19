package com.olgunyilmaz.cryptocurrencyproject.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRateResponse {
    @SerializedName("asset_id_base")
    public String currency;

    @SerializedName("rates")
    public ArrayList<CryptoModel> rates;
}
