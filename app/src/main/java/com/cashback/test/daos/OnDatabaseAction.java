package com.cashback.test.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.cashback.test.models.OfferModel;

import java.util.List;

@Dao
public interface OnDatabaseAction {

    @Query("SELECT * FROM offers")
    List<OfferModel> getAllOffers();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertOffer(OfferModel offerModel);
}
