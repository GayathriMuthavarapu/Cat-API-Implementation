package com.example.demoapplication.domain.repository;

import com.example.demoapplication.data.model.CatEntity;


import java.util.List;

import io.reactivex.Single;

public interface ICatsRepository {

    Single<List<CatEntity>> getCatList(int limit);

}
