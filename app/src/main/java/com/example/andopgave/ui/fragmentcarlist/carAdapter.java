package com.example.andopgave.ui.fragmentcarlist;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andopgave.MainActivity;
import com.example.andopgave.R;
import com.example.andopgave.model.Data.CarData;
import com.example.andopgave.ui.login.Login;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class carAdapter extends RecyclerView.Adapter<carAdapter.ViewHolder> {
    private List<CarData> carDataList;
    private String CurrentPlate = "";



    public carAdapter(List<CarData> itemList){
        this.carDataList = itemList;
    }

    @NonNull
    @Override
    public carAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.private_car_holder, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull carAdapter.ViewHolder holder, int position) {
        CarData item = carDataList.get(position);
        CurrentPlate = item.getRegistration_number();
        holder.productName.setText(item.getMake());
        holder.category.setText(item.model);
        holder.price.setText(String.valueOf(item.price));
        holder.info.setText(item.getRegistration_number());
    }

    @Override
    public int getItemCount() {
        return carDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView info, category, productName,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            info = itemView.findViewById(R.id.tvCarCardInfo);
            category = itemView.findViewById(R.id.tvCardCategory);
            productName = itemView.findViewById(R.id.tvCardProductName);
            price = itemView.findViewById(R.id.tvCardPrice);


            //TODO: OnClickListeneren burde ligge i "FragmentCarlist".. Men kan simpelthen ikke få det til at virke
            itemView.findViewById(R.id.btndelete).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deleteCar(CurrentPlate);
                    System.out.println(CurrentPlate);
                    Navigation.findNavController(view).navigate(R.id.nav_dashBoard);
                }
            });
        }
    }

    //Todo: Burde ogs ligge i fragmentCarlist
    private void deleteCar(String nummerplade){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("AllCars").child(nummerplade);
        databaseReference.removeValue();

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        DatabaseReference databaseReference2 = FirebaseDatabase.getInstance().getReference(mAuth.getCurrentUser().getUid()).child(nummerplade);
        databaseReference2.removeValue();

        System.out.printf("DeleteCar Metode ");
        Log.e("Delete Car", "deleteCar: ");
    }

}


