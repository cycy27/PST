package com.example.premiertry.ui.checkup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;

import com.example.premiertry.databinding.FragmentCheckupBinding;


public class CheckupFragment extends Fragment {

    private FragmentCheckupBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CheckupViewModel checkupViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(CheckupViewModel.class);

        binding = FragmentCheckupBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        checkupViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}