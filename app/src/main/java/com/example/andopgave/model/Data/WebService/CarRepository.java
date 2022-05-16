package com.example.andopgave.model.Data.WebService;

import androidx.lifecycle.LiveData;

import com.example.andopgave.model.Data.CarData;

public interface CarRepository {
    LiveData<CarData> getSearchedInPlateWeb();
    void searchForCarWithPlateInWeb(String Plate);
}
