package com.example.andopgave.WebService;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.andopgave.model.CarData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class PostCarRepository {
        private static PostCarRepository instance;
        private final MutableLiveData<CarData> searchedCar;
        private final PostCarAPI carAPI;

        private PostCarRepository() {
            searchedCar = new MutableLiveData<>();

            carAPI = PostCarServiceGenerator.getCarAPI();
        }


    public static synchronized PostCarRepository getInstance() {
            if (instance == null) {
                instance = new PostCarRepository();
            }
            return instance;
        }

        public LiveData<CarData> getSearchedInPlateWeb() {
            return searchedCar;
        }


        public void searchForCarWithPlateInWeb(String Plate) {
            Call<CarResponse> call = carAPI.getCarDataFromPlate(Plate);
            call.enqueue(new Callback<CarResponse>() {
                @EverythingIsNonNull
                @Override
                public void onResponse(Call<CarResponse> call, Response<CarResponse> response) {
                    if (response.isSuccessful()) {
                        searchedCar.setValue(response.body().getCars());
                        Log.e("In IF ",response.body().getCars().getRegistration_number());
                    }
                }

                @EverythingIsNonNull
                @Override
                public void onFailure(Call<CarResponse> call, Throwable t) {
                    Log.e("Retrofit", "Something went wrong :(\n" + t.getMessage());
                }
            });


        }
}
