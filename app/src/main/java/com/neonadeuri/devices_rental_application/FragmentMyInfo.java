package com.neonadeuri.devices_rental_application;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentMyInfo extends Fragment {

    static String externName = "홍길동";
    static String externStdnum = "1234";
    static String externMajor = "소프트";
    static String externPlace = "행복주택";
    static String externDisabled = "시각장애 1급";
    static Bitmap externBitmap;
    static Button btnEditMyInfo;
    static Uri externImageUri;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mypage, container, false);



        Log.d(TAG, "마이페이지 진입 ");

        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        Button btnEditMyInfo = (Button)view.findViewById(R.id.editMyInfoButton);

        ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {


                        TextView textViewName = (TextView) view.findViewById(R.id.userName);
                        TextView textViewMajor = (TextView) view.findViewById(R.id.userMajor);
                        TextView textViewDisabled = (TextView) view.findViewById(R.id.userDisabled);
                        ImageView imageView = (ImageView) view.findViewById(R.id.myPhoto);



                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent receivedIntent = result.getData();
                            textViewName.setText(receivedIntent.getStringExtra("userName"));
                            externName = (receivedIntent.getStringExtra("userName"));
                            Log.d(TAG, "received Extern Data" + externName + "   end.");
                            textViewMajor.setText(receivedIntent.getStringExtra("userMajor"));
                            externMajor = (receivedIntent.getStringExtra("userMajor"));
                            textViewDisabled.setText(receivedIntent.getStringExtra("userDisabled"));
                            externPlace = (receivedIntent.getStringExtra("userPlace"));
                            externStdnum = (receivedIntent.getStringExtra("userStdnum"));
                            externDisabled = (receivedIntent.getStringExtra("userDisabled"));
                            externBitmap = (receivedIntent.getParcelableExtra("bitmap"));
                            imageView.setImageBitmap(externBitmap);
                            Log.d(TAG, "MainActivity로 돌아왔다. ");
                        }
                    }
                });


        btnEditMyInfo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "edit 버튼 클릭. ");
                Intent intentEditInfo = new Intent(getActivity(), myPageEditActivity.class);
                intentEditInfo.putExtra("externName", externName);
                intentEditInfo.putExtra("externMajor", externMajor);
                intentEditInfo.putExtra("externStdnum", externStdnum);
                intentEditInfo.putExtra("externDisabled", externDisabled);
                intentEditInfo.putExtra("externPlace", externPlace);
                startActivityResult.launch(intentEditInfo);
            }
        });




        return view;
    }



}
