package com.neonadeuri.devices_rental_application;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.MotionEvent;
        import android.view.View;
        import android.view.ViewGroup;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.HashMap;


public class FragmentDibs extends Fragment {

    static RecyclerView recyclerView3;
    static mainAdapter adapter3;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dibs_page, container, false);

        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });


        recyclerView3 = view.findViewById(R.id.interestRV);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView3.setLayoutManager(linearLayoutManager);
        adapter3 = new mainAdapter();

        HashMap<String,Device> dibs=User.getDibs();

        for(Device dib:dibs.values()){
            adapter3.addItem(dib);

        }
        recyclerView3.setAdapter(adapter3);

        return view;
    }
}
