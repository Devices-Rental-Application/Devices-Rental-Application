package com.neonadeuri.devices_rental_application;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class mainAdapter extends RecyclerView.Adapter<mainAdapter.ViewHolder> {

    private ArrayList<Device> items = new ArrayList<>();
    private Context mContext;

    // 뷰홀더가 새로 만들어질 때 호출
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.main_item,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Device item = items.get(position);
        holder.setItem(item);
    }


    public int getItemCount(){
        return items.size();
    }

    public void addItem(Device item){
        items.add(item);
    }

    public void setItems(ArrayList<Device> item){
        this.items = item;
    }

    public Device getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, Device item){
        items.set(position,item);
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView cnt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.deviceImg);
            name = itemView.findViewById(R.id.deviceName);
            cnt = itemView.findViewById(R.id.deviceCnt);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int pos = getAdapterPosition();
//                    if(pos!= RecyclerView.NO_POSITION){
//                        Intent intent = new Intent(mContext,device_detail.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        intent.putExtra("id","1");
//                        startActivities(intent);
//                    }
//
//                }
//            });
        }

        void setItem(Device item){
            img.setImageResource(item.getResourceId());
            name.setText(item.getName());
            cnt.setText(""+item.getCurrentCnt());
        }
    }
}