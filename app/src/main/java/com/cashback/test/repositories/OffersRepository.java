package com.cashback.test.repositories;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.cashback.test.database.DatabaseClient;
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
    private Context context;

    public OffersRepository(Context ctx) {
        offersResponseLiveData = new MutableLiveData<>();
        this.context = ctx;

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
                        if (response.body() != null) {
                            List<OfferModel> offers = response.body();
                            offersResponseLiveData.postValue(offers);

                            class SaveOffers extends AsyncTask<Void, Void, Void> {
                                @Override
                                protected Void doInBackground(Void... voids) {
                                    // Persist data to database
                                    for (OfferModel offer : offers) {
                                        DatabaseClient.getInstance(context).getAppDatabase().dataBaseAction().insertOffer(offer);
                                    }
                                    return null;
                                }
                            }
                            SaveOffers saveOffers = new SaveOffers();
                            saveOffers.execute();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<OfferModel>> call, Throwable t) {
                        offersResponseLiveData.postValue(null);
                    }
                });
    }

    public LiveData<List<OfferModel>> listOffers() {
        return offersResponseLiveData;
    }

}
