package com.neonadeuri.devices_rental_application;



import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class historyAdapter extends RecyclerView.Adapter<historyAdapter.ViewHolder> {

    private ArrayList<DeviceHistory> items = new ArrayList<>();
    private Context mContext;

    // 뷰홀더가 새로 만들어질 때 호출
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.history_item,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DeviceHistory item = items.get(position);
        holder.setItem(item);
    }


    public int getItemCount(){
        return items.size();
    }

    public void addItem(DeviceHistory item){
        items.add(item);
    }

    public void setItems(ArrayList<DeviceHistory> item){
        this.items = item;
    }

    public DeviceHistory getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, DeviceHistory item){
        items.set(position,item);
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView date;
        TextView state;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.deviceImg);
            name = itemView.findViewById(R.id.deviceName);
            date = itemView.findViewById(R.id.historyDate);
            state = itemView.findViewById(R.id.deviceState);

            GradientDrawable drawable=    (GradientDrawable) mContext.getDrawable(R.drawable.image_background);
            img.setBackground(drawable);
            img.setClipToOutline(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos!= RecyclerView.NO_POSITION){
                        //클릭 이벤트 처리 부분
                        Intent intent =new Intent(mContext.getApplicationContext(),application_status.class);
                        intent.putExtra("pos",pos);
                        mContext.startActivity(intent);
                    }
                }
            });
        }

        void setItem(DeviceHistory item){
            img.setImageResource(item.getResourceId());
            name.setText(item.getDeviceName());
            date.setText(item.getDate());
            state.setText(item.getState());
        }
    }
}
