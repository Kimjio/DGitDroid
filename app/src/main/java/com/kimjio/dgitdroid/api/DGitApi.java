package com.kimjio.dgitdroid.api;

import androidx.lifecycle.LiveData;

import com.kimjio.dgitdroid.model.Response;
import com.kimjio.dgitdroid.model.TotalRank;

import retrofit2.http.GET;

public interface DGitApi {
    String DGIT = "http://34.64.133.160:8080";

    @GET("contribution/total-rank")
    LiveData<Response<TotalRank>> totalRank();
}
