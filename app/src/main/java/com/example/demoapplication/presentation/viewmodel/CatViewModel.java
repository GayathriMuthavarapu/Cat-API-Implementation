package com.example.demoapplication.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.demoapplication.domain.usecase.CatUseCase;
import com.example.demoapplication.presentation.uimodel.CatModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CatViewModel extends ViewModel {


    private final CatUseCase catUseCase;
    private final MutableLiveData<List<CatModel>> catListLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();


    public CatViewModel(CatUseCase catUseCase) {
        this.catUseCase = catUseCase;
    }

    public LiveData<List<CatModel>> getCatListLiveData() {
        return catListLiveData;
    }

    public void loadCatList(int limit) {
        catUseCase.getCatList(limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(catListLiveData::setValue, throwable -> {
                    // Handle error
                });
    }

    public LiveData<String> getErrorLiveData() {
        return errorLiveData;
    }
}
