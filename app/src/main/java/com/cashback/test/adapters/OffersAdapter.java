package com.cashback.test.adapters;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.cashback.test.R;
import com.cashback.test.models.OfferModel;
import com.cashback.test.utils.DateUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.OffersResultHolder> {
    private Context context;
    private List<OfferModel> results = new ArrayList<>();

    public OffersAdapter(Context context) {
        this.context = context;
    }

    private static final DecimalFormat df = new DecimalFormat("0.0");

    @NonNull
    @Override
    public OffersResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);

        return new OffersResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OffersResultHolder holder, int position) {
        try {
            OfferModel offer = results.get(position);

            holder.productNameTextView.setText(offer.getProductName());
            holder.productDate.setText(DateUtil.getFormattedDate(offer.getOfferEndDate()));
            holder.productSize.setText(offer.getProductSize());
            holder.productCashback.setText(offer.getProductCashBack().toString());
            holder.productCommission.setText(df.format( (offer.getProductCashBack() * offer.getPromotionDetailsRetailerCommission())));
            Glide.with(context)
                    .load(offer.getProductImage())
//                    .listener(new RequestListener<Drawable>() {
//                        @Override
//                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                            holder.productImageView.setImageResource(R.drawable.ic_launcher_background);
//                            return false;
//                        }
//
//                        @Override
//                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                            return false;
//                        }
//                    })
                    .transition(withCrossFade())
                    .centerCrop()
                    .into(holder.productImageView);


        } catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<OfferModel> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    public class OffersResultHolder extends RecyclerView.ViewHolder {
        private TextView productNameTextView, productDate, productSize, productCashback, productCommission;
        private ImageView productImageView;

        public OffersResultHolder(@NonNull View itemView) {
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.product_name);
            productImageView = itemView.findViewById(R.id.product_image);
            productCashback = itemView.findViewById(R.id.cash_back);
            productCommission = itemView.findViewById(R.id.commission);
            productDate = itemView.findViewById(R.id.product_date);
            productSize = itemView.findViewById(R.id.product_size);

        }
    }
}