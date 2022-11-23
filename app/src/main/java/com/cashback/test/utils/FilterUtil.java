package com.cashback.test.utils;

import android.os.Build;
import android.util.Log;

import com.cashback.test.models.OfferModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FilterUtil {
    public static List<OfferModel> filterByDateAsc(List<OfferModel> offers) {
        // Remove offers whose getOfferEndDate is after today
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            List<OfferModel> filteredOffers = offers.stream()
                    .filter(offer -> {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date today = new Date();
                        Date offerEndDate = null;
                        try {
                            offerEndDate = sdf.parse(offer.getOfferEndDate());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        return offerEndDate != null && offerEndDate.after(today);
                    })
                    .collect(Collectors.toList());

            // Sort the filtered offers by promotionDetailsRanking
            filteredOffers.sort((o1, o2) -> {
                if (o1.getPromotionDetailsRanking() == null || o2.getPromotionDetailsRanking() == null) {
                    return 0;
                }
                return o1.getPromotionDetailsRanking().compareTo(o2.getPromotionDetailsRanking());
            });
            return filteredOffers;
        }
        return offers;
    }
}
