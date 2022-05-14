package com.example.main_page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// TODO : DeviceAdapter -> mainAdapter
public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.ViewHolder> {
    private ArrayList<AssistiveDevice> mAssistiveDevices = null;

    public DeviceAdapter(ArrayList<AssistiveDevice> mAssistiveDevices) {
        this.mAssistiveDevices = mAssistiveDevices;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView deviceImg;
        TextView name;
        TextView cnt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            deviceImg = (ImageView)itemView.findViewById(R.id.deviceImg);
            name = (TextView)itemView.findViewById(R.id.deviceName);
            cnt = (TextView)itemView.findViewById(R.id.deviceCnt);

            System.out.println("ViewHolder : " + itemView);
        }

        void onBind(AssistiveDevice item) {
            deviceImg.setImageResource(getResId(item.getImgName(), R.drawable.class));
            name.setText(item.getName());
            cnt.setText(item.getRemainCnt());

            System.out.println("onBind : " + item);
        }
    }

    @NonNull
    @Override
    public DeviceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.main_item,parent,false);
        DeviceAdapter.ViewHolder vh = new DeviceAdapter.ViewHolder(view);

        System.out.println("onCreateViewHolder : " + viewType);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceAdapter.ViewHolder holder, int position) {
        System.out.println("onBindViewHolder : " + position);
        holder.onBind(mAssistiveDevices.get(position));
    }

    @Override
    public int getItemCount() {
        System.out.println("getItemCount : " + mAssistiveDevices.size());
        return mAssistiveDevices.size();
    }

    public int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    };
//    public DeviceAdapter(Context context, int source, List<AssistiveDevice> deviceList) {
//        super(context, source, deviceList);
//    }
}