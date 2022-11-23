package com.cashback.test.daos;

import androidx.room.Dao;
import androidx.room.Query;

import com.cashback.test.models.OfferModel;

import java.util.List;

@Dao
public interface OnDatabaseAction {

    @Query("SELECT * FROM offers")
    List<OfferModel> getAllOffers();
}
