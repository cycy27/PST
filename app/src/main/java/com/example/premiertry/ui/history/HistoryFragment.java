package com.example.premiertry.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;


import com.example.premiertry.databinding.FragmentHistoryBinding;


public class HistoryFragment extends Fragment {

   private FragmentHistoryBinding binding;

   public View onCreateView(@NonNull LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState) {
      HistoryViewModel historyViewModel =
              new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HistoryViewModel.class);

      binding = FragmentHistoryBinding.inflate(inflater, container, false);
      View root = binding.getRoot();

      final TextView textView = binding.textNotifications;
      historyViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
      return root;
   }

   @Override
   public void onDestroyView() {
      super.onDestroyView();
      binding = null;
   }
}