package com.example.andopgave.ui.dashBoard;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andopgave.R;
import com.example.andopgave.model.Data.CarData;

import java.util.List;

public class allCarAdapter extends RecyclerView.Adapter<allCarAdapter.ViewHolder> {
    private List<CarData> carDataList;

    public allCarAdapter(List<CarData> itemList){
        this.carDataList = itemList;
    }
    @NonNull
    @Override
    public allCarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowitem1, parent,false);
        allCarAdapter.ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull allCarAdapter.ViewHolder holder, int position) {
        CarData item = carDataList.get(position);
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
        }
    }
}