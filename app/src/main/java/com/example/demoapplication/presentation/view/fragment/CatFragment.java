package com.example.demoapplication.presentation.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.R;

import com.example.demoapplication.presentation.view.ViewModelFactory;
import com.example.demoapplication.presentation.view.adapter.CatAdapter;
import com.example.demoapplication.presentation.viewmodel.CatViewModel;


public class CatFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "CatFragment";

    private Button buttonFirst;
    private CatViewModel catViewModel;
    private CatAdapter catAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");

        View rootView = inflater.inflate(R.layout.fragment_cat, container, false);
        ViewModelFactory factory = new ViewModelFactory();
        catViewModel = new ViewModelProvider(this, factory).get(CatViewModel.class);
        observeViewModel();
        buttonFirst = (Button) rootView.findViewById(R.id.button_first);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        catAdapter = new CatAdapter();
        recyclerView.setAdapter(catAdapter);
        catViewModel.loadCatList(10);
        return rootView;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CatFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }


    private void observeViewModel() {
        catViewModel.getCatListLiveData().observe(this, catList -> {
            if (catList != null && !catList.isEmpty()) {
                catAdapter.setCatList(catList);
            }
        });

        catViewModel.getErrorLiveData().observe(this, error -> {
            // Handle error
            Toast.makeText(getContext(), "Error fetching cat images", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View v) {

    }
}