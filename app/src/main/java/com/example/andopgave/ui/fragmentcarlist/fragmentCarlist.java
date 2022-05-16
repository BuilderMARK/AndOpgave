package com.example.andopgave.ui.fragmentcarlist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.andopgave.R;
import com.example.andopgave.model.Data.CarData;
import com.example.andopgave.model.Data.DAO;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class fragmentCarlist extends Fragment implements View.OnClickListener {

    private FragmentCarlistViewModel mViewModel;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    carAdapter myAdapter;
    RecyclerView recyclerView;
    ArrayList<CarData> carDataList;
    Button btn_Edit, btn_Delete;
    CarData carData;

    public static fragmentCarlist newInstance() {
        return new fragmentCarlist();
    }


    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carlist_fragment, container, false);
        mAuth = DAO.getmAuth();
        mAuth.getCurrentUser().getUid();
        databaseReference = DAO.getmDatabase().getReference(mAuth.getUid());


        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        btn_Delete = view.findViewById(R.id.btndelete);
        btn_Edit = view.findViewById(R.id.btnedit);

        Log.e("ListView", "onCreateView: " + mAuth.getUid());

        carDataList = new ArrayList<>();
        myAdapter = new carAdapter(carDataList);
        recyclerView.setAdapter(myAdapter);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    CarData item = dataSnapshot.getValue(CarData.class);
                    carDataList.add(item);
                    //TODO: Update View here

                }
                myAdapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }


        });
        return view;
    }





    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btndelete:
                //deleteCar();
                System.out.printf("Btn Delete");
            case R.id.btnedit:
                System.out.printf("edit Delete");
                break;
        }
    }
}