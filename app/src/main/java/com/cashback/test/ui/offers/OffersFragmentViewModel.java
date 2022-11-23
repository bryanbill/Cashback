package com.cashback.test.ui.offers;

import android.app.Application;

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


    public OffersFragmentViewModel() {
    }

    public void init() {
        offersRepository = new OffersRepository();
        offersRepository.getOffers();
        offers = offersRepository.listOffers();
    }

    public void getOffers() {
        offersRepository.getOffers();
    }

    public LiveData<List<OfferModel>> listOffers() {
        return offers;
    }
}