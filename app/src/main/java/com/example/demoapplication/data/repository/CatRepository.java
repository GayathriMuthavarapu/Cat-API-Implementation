package com.example.demoapplication.data.repository;


import com.example.demoapplication.data.model.CatEntity;
import com.example.demoapplication.data.repository.remote.api.retrofit.CatApiService;
import com.example.demoapplication.domain.repository.ICatsRepository;

import java.util.List;
import io.reactivex.Single;


public class CatRepository implements ICatsRepository {

    private final CatApiService catApiService;

    public CatRepository(CatApiService catApiService) {
        this.catApiService = catApiService;
    }

    public Single<List<CatEntity>> getCatList(int limit) {
        return catApiService.getCatList(limit)
                .map(response -> response.body());
    }


}
