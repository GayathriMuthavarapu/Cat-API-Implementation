package com.example.demoapplication.domain.usecase;


import com.example.demoapplication.presentation.uimodel.CatModel;


import java.util.List;

import io.reactivex.Single;

public interface ICatsUseCase {

    Single<List<CatModel>> getCatList(int imageLimit);

}
