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

        for(int i=1;i<=10;i++){
            if(i%2==0)
                adapter3.addItem(new Device(R.drawable.orcam,i+"번째 사람",i));
            else
                adapter3.addItem(new Device(R.drawable.tackplus,i+"번째 사람",i));

        }
        recyclerView3.setAdapter(adapter3);

        return view;
    }
}
