package com.olgunyilmaz.cryptocurrencyproject.model;

import com.google.gson.annotations.SerializedName;

public class CryptoModel {
    @SerializedName("asset_id_quote") // must be same name with data in json
    public String crypto;
    @SerializedName("rate")
    public double price;

}
