package com.example.andopgave.WebService;

import com.example.andopgave.model.CarData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostCarAPI {

    @GET ("vehicles/{nummerPlade}")
    Call<CarData[]> getCarDataFromPlate(@Path("nummerPlade") String nummerplade);
}
