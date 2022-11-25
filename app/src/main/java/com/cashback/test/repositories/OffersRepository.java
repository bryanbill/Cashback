package com.cashback.test.repositories;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.cashback.test.database.DatabaseClient;
import com.cashback.test.interfaces.IOffers;
import com.cashback.test.models.OfferModel;
import com.cashback.test.utils.FilterUtil;
import java.util.List;
import java.util.concurrent.ExecutionException;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;

public class OffersRepository {
  private static final String API =
      "https://cashbacktest.s3.eu-west-2.amazonaws.com/";

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

  public void getOffers() throws ExecutionException, InterruptedException {
    // Retrieve local data
    class GetOffers extends AsyncTask<Void, Void, List<OfferModel>> {

      @Override
      protected List<OfferModel> doInBackground(Void... voids) {
        List<OfferModel> offers = DatabaseClient.getInstance(context)
                                      .getAppDatabase()
                                      .dataBaseAction()
                                      .getAllOffers();
        return offers;
      }

      @Override
      protected void onPostExecute(List<OfferModel> offers) {
        super.onPostExecute(offers);
        offersResponseLiveData.setValue(FilterUtil.filterByDateAsc(offers));
      }
    }

    GetOffers getOffers = new GetOffers();
    List<OfferModel> offers = getOffers.execute().get();

    if (offers == null || offers.size() == 0) {
      iOffers.getOffers().enqueue(new Callback<List<OfferModel>>() {
        @Override
        public void onResponse(Call<List<OfferModel>> call,
                               retrofit2.Response<List<OfferModel>> response) {
          if (response.body() != null) {
            List<OfferModel> offers = response.body();
            offersResponseLiveData.postValue(
                FilterUtil.filterByDateAsc(offers));

            class SaveOffers extends AsyncTask<Void, Void, Void> {
              @Override
              protected Void doInBackground(Void... voids) {
                // Persist data to database
                for (OfferModel offer : offers) {
                  DatabaseClient.getInstance(context)
                      .getAppDatabase()
                      .dataBaseAction()
                      .insertOffer(offer);
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
  }

  public LiveData<List<OfferModel>> listOffers() {
    return offersResponseLiveData;
  }
}
