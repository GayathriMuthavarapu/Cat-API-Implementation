package com.example.demoapplication.domain.usecase;


import com.example.demoapplication.data.repository.CatRepository;
import com.example.demoapplication.presentation.mapper.CatEntityToModelMapper;
import com.example.demoapplication.presentation.uimodel.CatModel;


import java.util.List;

import io.reactivex.Single;

public class CatUseCase implements ICatsUseCase {

    private static final String TAG = CatUseCase.class.getSimpleName();
    private final CatRepository catRepository;
    private final CatEntityToModelMapper mapper;

    public CatUseCase(CatRepository catRepository, CatEntityToModelMapper mapper) {
        this.catRepository = catRepository;
        this.mapper = mapper;
    }

    public Single<List<CatModel>> getCatList(int limit) {
        return catRepository.getCatList(limit)
                .map(mapper::mapList);
    }
}
