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

public class FragmentSearch extends Fragment {


    static RecyclerView recyclerView2;
    static historyAdapter adapter2;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_serach_page, container, false);

        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }

        });

//
        recyclerView2 = view.findViewById(R.id.historyRV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView2.setLayoutManager(linearLayoutManager);
        adapter2 = new historyAdapter();

        for(int i=1;i<=10;i++){
            if(i%2==0)
                adapter2.addItem(new DeviceHistory(R.drawable.orcam,i+"상태",i+"이름","날짜","받는사람"));
            else
                adapter2.addItem(new DeviceHistory(R.drawable.tackplus,i+"상태",i+"이름","날짜","받는사람"));

        }
        recyclerView2.setAdapter(adapter2);

        return view;




    }
}
