package com.example.demoapplication.presentation.view;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.demoapplication.common.Injector;
import com.example.demoapplication.domain.usecase.CatUseCase;
import com.example.demoapplication.presentation.viewmodel.CatViewModel;


// ViewModelFactory.java
public class ViewModelFactory implements ViewModelProvider.Factory {
    private final CatUseCase getCatsUseCase;

    public ViewModelFactory() {
        // Obtain GetCatsUseCase from Injector
        this.getCatsUseCase = Injector.getInstance().provideGetCatsUseCase();
    }



    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CatViewModel.class)) {
            return (T) new CatViewModel(getCatsUseCase);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
