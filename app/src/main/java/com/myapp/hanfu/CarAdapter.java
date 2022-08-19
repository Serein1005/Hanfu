package com.myapp.hanfu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    public Context mContext;
    private List<Car.mCar> mCarList;
    //private List<Car.mCar> mCarList;

    public CarAdapter(Context context,List<Car.mCar> carList){
        mCarList=carList;
        mContext=context;
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView carImage;
        TextView carBrand;
        public ViewHolder(View view){
            super(view);
            carImage = (ImageView) view.findViewById(R.id.car_image);
            carBrand = (TextView) view.findViewById(R.id.car_name);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.carBrand.setText(mCarList.get(position).getBrand_name());
        Glide.with(mContext).load(mCarList.get(position).getBrand_logo()).into(holder.carImage);
    }

    @Override
    public int getItemCount() {
        return mCarList.size();
    }
}
