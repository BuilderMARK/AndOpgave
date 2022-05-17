package com.example.andopgave.ui.createCar;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.andopgave.model.Data.WebService.PostCarRepository;
import com.example.andopgave.model.Data.CarData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class CreateCarViewModelImpl extends ViewModel implements CreateCarViewModel {
    PostCarRepository postCarRepository;
     DatabaseReference mDatabase;
     FirebaseAuth mAuth;
     FirebaseStorage storage;
     StorageReference storageReference;
    public CreateCarViewModelImpl() {
        postCarRepository = PostCarRepository.getInstance();
    }


    @Override
    public LiveData<CarData> getCarDataFromPlate() {
        return postCarRepository.getSearchedInPlateWeb();
    }

    @Override
    public void SearchForCarWithPlate(String Plate) {
        postCarRepository.searchForCarWithPlateInWeb(Plate);
    }

   /* private void uploadpic() {
        final String randomkey = UUID.randomUUID().toString();
        StorageReference storageReference1 = storageReference.child("images/");
        storageReference1.putFile(filePath).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                System.out.println("succes");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                System.out.println("not a succes");
            }
        });


    }*/



}