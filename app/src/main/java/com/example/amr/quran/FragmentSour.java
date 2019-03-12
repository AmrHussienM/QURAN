package com.example.amr.quran;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentSour extends Fragment {
    RecyclerView recyclerView;
    List<SourModel> listOfSour;
    SourAdapter adapter;
    LinearLayoutManager layoutManager;

    View v;
    public FragmentSour() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.sour_fragment,container,false);
        recyclerView=(RecyclerView) v.findViewById(R.id.sour_recyclerView);
        layoutManager=new LinearLayoutManager(getActivity());
        listOfSour=new ArrayList<>();
        for(int i=0;i<dataHold.Soura.length;i++) {
            listOfSour.add(new SourModel(dataHold.Soura[i]));
        }
        adapter=new SourAdapter(listOfSour);

        adapter.setOnItemClickListener(new SourAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, SourModel sourModel) {
                Intent intent=new Intent(getActivity(),QuranContent.class);
                intent.putExtra("filenames",(position+1)+".txt");
                startActivity(intent);
            }
        });



        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        return v;
    }


}
