package com.example.demoapplication.presentation.mapper;

import com.example.demoapplication.data.model.CatEntity;
import com.example.demoapplication.presentation.uimodel.CatModel;

import java.util.ArrayList;
import java.util.List;

public class CatEntityToModelMapper {
    public List<CatModel> mapList(List<CatEntity> entities) {
        List<CatModel> models = new ArrayList<>();
        for (CatEntity entity : entities) {
            models.add(map(entity));
        }
        return models;
    }

    public CatModel map(CatEntity entity) {
        // Map fields from CatEntity to CatModel
        return new CatModel(entity.getId(), entity.getImageUrl());
    }
}
