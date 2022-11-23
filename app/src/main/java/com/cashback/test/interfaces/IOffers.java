package com.cashback.test.interfaces;

import com.cashback.test.models.OfferModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IOffers {

    @GET("/product_offers.json")
    Call<List<OfferModel>> getOffers();
}
