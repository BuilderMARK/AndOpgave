//package com.example.andopgave.ui.allCars;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.ListFragment;
//import androidx.lifecycle.ViewModelProvider;
//
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.andopgave.R;
//import com.example.andopgave.model.CarData;
//import com.example.andopgave.model.RecylcerView.carAdapter;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AllCarList extends ListFragment {
//    RecyclerView carRecyclerView;
//    DatabaseReference databaseReference;
//
//    private AllCarListViewModelImpl mViewModel;
//
//    public static AllCarList newInstance() {
//        return new AllCarList();
//    }
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.all_car_list_fragment, container, false);
//
//        return view;
//
//        carRecyclerView.hasFixedSize();
//        databaseReference = FirebaseDatabase.getInstance().getReference("SaleOffers");
//        carRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        List<CarData> itemPost = new ArrayList<>();
//        carAdapter adapter = new carAdapter(itemPost);
//        carRecyclerView.setAdapter(adapter);
//
//
//    }
//
//
//}