package com.cashback.test.ui.offers;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cashback.test.R;
import com.cashback.test.adapters.OffersAdapter;
import com.cashback.test.databinding.FragmentOffersBinding;
import com.cashback.test.models.OfferModel;

import java.util.List;

public class OffersFragment extends Fragment {

    private FragmentOffersBinding binding;
    private OffersAdapter offersAdapter;

    private OffersFragmentViewModel offersFragmentViewModel;

    @Override
    public  void  onCreate ( Bundle  savedInstanceState ) {
        super.onCreate ( savedInstanceState );

        offersAdapter = new  OffersAdapter(getContext());
        offersFragmentViewModel = new  ViewModelProvider(this).get(OffersFragmentViewModel.class);
        offersFragmentViewModel.setContext(getContext());
        offersFragmentViewModel.init();


        offersFragmentViewModel.listOffers().observe(this, new Observer<List<OfferModel>>() {
            @Override
            public void onChanged(List<OfferModel> offerModels) {
                if (offerModels != null) {
                    offersAdapter.setResults(offerModels);
                }
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentOffersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.offersRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.offersRecyclerView.setAdapter(offersAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}