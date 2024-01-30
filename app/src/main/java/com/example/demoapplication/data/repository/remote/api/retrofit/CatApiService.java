package com.example.demoapplication.data.repository.remote.api.retrofit;

import com.example.demoapplication.data.model.CatEntity;


import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CatApiService {

    @GET("images/search")
    Single<Response<List<CatEntity>>> getCatList(@Query("limit") int limit);


}
