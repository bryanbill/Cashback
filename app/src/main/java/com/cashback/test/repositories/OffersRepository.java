package com.cashback.test.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.cashback.test.interfaces.IOffers;
import com.cashback.test.models.OfferModel;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class OffersRepository {
    private static final String API = "https://cashbacktest.s3.eu-west-2.amazonaws.com/";

    private IOffers iOffers;
    private MutableLiveData<List<OfferModel>> offersResponseLiveData;

    public OffersRepository() {
        offersResponseLiveData = new MutableLiveData<>();

        OkHttpClient client = new OkHttpClient.Builder().build();

        iOffers = new retrofit2.Retrofit.Builder()
                .baseUrl(API)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(IOffers.class);
    }

    public void getOffers() {
        iOffers.getOffers()
                .enqueue(new Callback<List<OfferModel>>() {
                    @Override
                    public void onResponse(Call<List<OfferModel>> call, retrofit2.Response<List<OfferModel>> response) {
                        Log.d("OffersRepository", "onResponse: " + response.body());
                        if (response.body() != null) {
                            Log.i("OffersRepository", "onResponse: " + response.body().size());
                            offersResponseLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<OfferModel>> call, Throwable t) {
                        Log.e("OffersRepository", "onFailure: " + t.getMessage());
                        offersResponseLiveData.postValue(null);
                    }
                });
    }

    public LiveData<List<OfferModel>> listOffers(){
        return  offersResponseLiveData;
    }
}
