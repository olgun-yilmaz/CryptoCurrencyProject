package com.olgunyilmaz.cryptocurrencyproject;

import com.google.gson.annotations.SerializedName;

public class CryptoModel {
    @SerializedName("currency") // must be same name with data in json
    String currency;
    @SerializedName("price")
    String price;
}
