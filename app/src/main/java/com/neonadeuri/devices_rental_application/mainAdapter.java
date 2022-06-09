package com.neonadeuri.devices_rental_application;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        if(User.isContain(item.getId())){
            holder.interestBtn.setSelected(true);
        }
        holder.interestBtn.setContentDescription(item.getName()+" 찜버튼");
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

    public int getItemPosById(String id){
        for(int i=0;i<getItemCount();i++){
            if(getItem(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public void setItem(int position, Device item){
        items.set(position,item);
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView cnt;
        ImageButton interestBtn;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.deviceImg);
            name = itemView.findViewById(R.id.deviceName);
            cnt = itemView.findViewById(R.id.deviceCnt);
            interestBtn = itemView.findViewById(R.id.heart);

            GradientDrawable drawable=    (GradientDrawable) mContext.getDrawable(R.drawable.image_background);
            img.setBackground(drawable);
            img.setClipToOutline(true);



            //set the click listener
            interestBtn.setOnClickListener(new View.OnClickListener() {

                public void onClick(View button) {
                    int pos = getAdapterPosition();
                    Device item=items.get(pos);
                    //Set the button's appearance
                    button.setSelected(!button.isSelected());

                    if (button.isSelected()) {
                        User.addDib(item);
                    } else {
                        User.removeDib(item);
                    }

                }

            });




            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos!= RecyclerView.NO_POSITION){
                        Device item = items.get(pos);
                        Intent intent =new Intent(mContext.getApplicationContext(),device_detail.class);
                        intent.putExtra("id",item.getId());
                        mContext.startActivity(intent);
                    }
                }
            });
        }

        void setItem(Device item){
            img.setImageResource(item.getResourceId());
            name.setText(item.getName());
            cnt.setText("남은수량: "+item.getCurrentCnt());
        }
    }
}