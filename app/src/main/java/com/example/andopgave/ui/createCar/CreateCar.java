package com.example.andopgave.ui.createCar;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.andopgave.databinding.FragmentCreateCarBinding;
import com.example.andopgave.model.Data.CarData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

import javax.xml.transform.Result;

public class CreateCar extends Fragment  {

    private Button btn_Search, btn_Create, btn_Upload, btn_Picture;
    private EditText et_seacrhReg, et_price, et_regNumber, et_make, et_model, et_modelYear;
    private FragmentCreateCarBinding binding;
    private CreateCarViewModelImpl mViewModel;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    private ImageView imageView;
    private Uri filePath;
    private final int PICK_IMAGE_REQUEST = 1;

    private FirebaseStorage storage;
    private StorageReference storageReference;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(CreateCarViewModelImpl.class);
        binding = FragmentCreateCarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        bindings();
        observer();
        onClickListeners();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();






        return root;
    }

    private void observer() {
        mViewModel.getCarDataFromPlate().observe(getViewLifecycleOwner(), carData -> {
            et_regNumber.setText(carData.getRegistration_number());
            et_make.setText(carData.getMake());
            et_model.setText(carData.getModel());
            et_modelYear.setText(String.valueOf(carData.getModel_year()));
        });
    }


    private void bindings() {
        //TextView
        et_regNumber = binding.regNumber;
        et_make = binding.make;
        et_model = binding.model;
        et_modelYear = binding.modelYear;
        //ImageView
        imageView = binding.imageView;
        //EditText
        et_seacrhReg = binding.editTextTextRegNub;
        et_price = binding.editPrice;
        //Knapper
        btn_Search = binding.BtnSearchCar;
        btn_Create = binding.BtnCreateCar;
        btn_Picture = binding.btnFindpicture;
       btn_Upload = binding.btnUploadPicture;
        // TODO: Hjælp mark (:

    }

    private void onClickListeners() {
        btn_Search.setOnClickListener(view -> {
            mViewModel.SearchForCarWithPlate(et_seacrhReg.getText().toString());
            Log.i("OnclickCar", "onClickListeners: " + et_seacrhReg.toString() + mAuth.getCurrentUser().getUid());

        });
        btn_Create.setOnClickListener(view -> {
            CarData carData = new CarData();
            carData.registration_number = et_regNumber.getText().toString();
            carData.model = et_model.getText().toString();
            carData.make = et_make.getText().toString();
            carData.model_year = Integer.parseInt(et_modelYear.getText().toString());
            carData.price = Integer.parseInt(et_price.getText().toString());
            //Pushing to firebase
            mDatabase.child(mAuth.getCurrentUser().getUid()).child(carData.getRegistration_number()).setValue(carData);
            Log.e("Database", "Uploaded til database " + carData.getRegistration_number() + " " + carData.make + " " + carData.model);
            mDatabase.child("AllCars").child(carData.getRegistration_number()).setValue(carData);
        });
        btn_Upload.setOnClickListener(view -> {

        });

        btn_Picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
                System.out.println("Filepath er :" + filePath + "\n"+"Pick Image Request er : "+ PICK_IMAGE_REQUEST
                );
            }
        });

    }






    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null){
            filePath = data.getData();
            imageView.setImageURI(filePath);
            uploadpic();
        }
    }

    private void uploadpic() {
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


    }

}
