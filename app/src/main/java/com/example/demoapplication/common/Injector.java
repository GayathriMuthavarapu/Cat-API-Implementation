package com.example.demoapplication.common;


import com.example.demoapplication.data.repository.CatRepository;
import com.example.demoapplication.data.repository.remote.api.retrofit.CatApiService;
import com.example.demoapplication.domain.usecase.CatUseCase;
import com.example.demoapplication.presentation.mapper.CatEntityToModelMapper;
import com.example.demoapplication.presentation.viewmodel.CatViewModel;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


// Injector.java
public class Injector {

    private static CatApiService catApiService;
    private static CatRepository catRepository;
    private static CatEntityToModelMapper mapper;

    private static CatUseCase getCatsUseCase;
    private static CatViewModel catViewModel;
    private static AndroidApplication application;

        private static Injector instance;


        private Injector(AndroidApplication app) {
            application = app;
            // Initialize Retrofit, CatApiService, Mapper, Repository, and UseCase
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.thecatapi.com/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            CatApiService catApiService = retrofit.create(CatApiService.class);
            CatEntityToModelMapper mapper = new CatEntityToModelMapper();
            CatRepository catRepository = new CatRepository(catApiService);
            getCatsUseCase = new CatUseCase(catRepository, mapper);
        }

        public static Injector getInstance() {
            if (instance == null) {
                instance = new Injector(application);
            }
            return instance;
        }

        public CatUseCase provideGetCatsUseCase() {
            return getCatsUseCase;
        }



    private static CatViewModel createCatViewModel() {
        if (application == null || application.getAppViewModelProvider() == null) {
            // Handle the case where application or ViewModelProvider is null
            return null;
        }

        return application.getAppViewModelProvider().get(CatViewModel.class);
    }
}
