package com.cashback.test.ui.scanner;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cashback.test.R;
import com.cashback.test.databinding.FragmentScannerBinding;
import com.cashback.test.ui.profile.ProfileFragmentViewModel;

public class ScannerFragment extends Fragment {

    private FragmentScannerBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ScannerFragmentViewModel scannerFragmentViewModel =
                new ViewModelProvider(this).get(ScannerFragmentViewModel.class);

        binding = FragmentScannerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
//
//        final TextView textView = binding.;
//        scannerFragmentViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}