package com.cashback.test.utils;

import android.os.Build;

import com.cashback.test.models.OfferModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FilterUtil {
    public static List<OfferModel> filterByDateAsc(List<OfferModel> offers) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return new ArrayList<>(offers.stream().collect(Collectors.toMap(a -> a, a -> {
                try {
                    return new SimpleDateFormat("yyyy-MM-dd").parse(a.getOfferEndDate());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            }))
                    .entrySet().stream()
                    .sorted((a, b) -> a.getValue().compareTo(b.getValue()))
                    .map(a -> a.getKey()).collect(Collectors.toList()));
        }
        return offers;
    }
}
