package com.example.andopgave.model.RecylcerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andopgave.R;
import com.example.andopgave.model.CarData;

import java.util.List;

public class carAdapter extends RecyclerView.Adapter<carAdapter.ViewHolder> {
    private List<CarData> carDataList;


    public carAdapter(List<CarData> itemList){
        this.carDataList = itemList;
    }
    @NonNull
    @Override
    public carAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View infalt = inflater.inflate(R.layout.post_caritem,parent,false);
        View view = inflater.inflate(R.layout.post_caritem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull carAdapter.ViewHolder holder, int position) {
        holder.textView.setText(carDataList.get(position).getRegistration_number());
    }

    @Override
    public int getItemCount() {
        return carDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.post_holder);
        }
    }
}

