package com.pallaw.tmassignment.Data;

import com.pallaw.tmassignment.Data.Models.TMResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Pallaw Pathak on 2019-06-14. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
public interface ApiServices {
    String BASE_URL = "https://app.deltaapp.in/api/v2/";

    @GET("meta/data")
    Observable<TMResponse> getTMResponse();
}
