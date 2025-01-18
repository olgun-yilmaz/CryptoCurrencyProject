package com.olgunyilmaz.cryptocurrencyproject.model;

import com.google.gson.annotations.SerializedName;

public class CryptoModel {
    @SerializedName("currency") // must be same name with data in json
    public String currency;
    @SerializedName("price")
    public String price;
}
