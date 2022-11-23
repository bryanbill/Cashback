package com.cashback.test.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.cashback.test.daos.OnDatabaseAction;
import com.cashback.test.models.OfferModel;

@androidx.room.
Database(entities = {OfferModel.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
  public abstract OnDatabaseAction dataBaseAction();
  private static volatile Database INSTANCE;

  @NonNull
  @Override
  protected SupportSQLiteOpenHelper
  createOpenHelper(DatabaseConfiguration config) {
    return null;
  }

  @NonNull
  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return null;
  }

  @Override
  public void clearAllTables() {}
}
