package com.myapp.hanfu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HanfuAdapter extends RecyclerView.Adapter<HanfuAdapter.ViewHolder> {
    private List<com_item_Hanfu> mHanfuList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView hanfuImage;
        TextView hanfuName;

        public ViewHolder(View view){
            super(view);
            hanfuImage = (ImageView) view.findViewById(R.id.com_item_image);
            hanfuName = (TextView) view.findViewById(R.id.com_item_name);
        }
    }

    public HanfuAdapter(List<com_item_Hanfu> hanfuList){
        mHanfuList=hanfuList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.community_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        com_item_Hanfu hanfu = mHanfuList.get(position);
        holder.hanfuImage.setImageResource(hanfu.getImageID());
        holder.hanfuName.setText(hanfu.getName());
    }

    @Override
    public int getItemCount() {
        return mHanfuList.size();
    }
}
