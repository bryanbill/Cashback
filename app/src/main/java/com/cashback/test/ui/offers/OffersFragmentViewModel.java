package com.cashback.test.ui.offers;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cashback.test.models.OfferModel;
import com.cashback.test.repositories.OffersRepository;
import java.util.List;

public class OffersFragmentViewModel extends ViewModel {
  private OffersRepository offersRepository;
  private LiveData<List<OfferModel>> offers;
  private Context context;

  public OffersFragmentViewModel() {}

  public void setContext(Context context) { this.context = context; }

  public void init() {
    try {
      offersRepository = new OffersRepository(context);
      offersRepository.getOffers();
      offers = offersRepository.listOffers();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void getOffers() {
    try {
      offersRepository.getOffers();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public LiveData<List<OfferModel>> listOffers() { return offers; }
}