package com.example.andopgave.model.Data.WebService;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface PostCarAPI {
    @Headers("X-AUTH-TOKEN: 3enipvlz3yez9qvfnfrzzsuvt4sia34q")
    @GET ("vehicles/{Plate}")
    Call<CarResponse> getCarDataFromPlate(@Path("Plate") String registration_number);
}
