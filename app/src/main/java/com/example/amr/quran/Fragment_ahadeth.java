package com.example.amr.quran;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Fragment_ahadeth extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    com.example.amr.quran.AhadethAdapter adapter;
    List<com.example.amr.quran.AhadethModel> listOfAhadeth;

    View v;
    public Fragment_ahadeth() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.ahadeth_fragment,container,false);
        recyclerView=v.findViewById(R.id.ahadeth_recyclerview);
        listOfAhadeth=ReadAhadethFile();
        adapter=new com.example.amr.quran.AhadethAdapter(listOfAhadeth);
        adapter.setOnItemClickListener(new com.example.amr.quran.AhadethAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, com.example.amr.quran.AhadethModel model) {
                HadethDialogFragment dialogFragment=new HadethDialogFragment();
                dialogFragment.setAhadethModel(model);
                dialogFragment.show(getChildFragmentManager(),"hadethDialog");
            }
        });
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        return v;
    }


    ArrayList<com.example.amr.quran.AhadethModel> ReadAhadethFile(){

        ArrayList<com.example.amr.quran.AhadethModel> models = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getActivity().getAssets().open("ahadith_arabic.txt")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                com.example.amr.quran.AhadethModel hadeth= new com.example.amr.quran.AhadethModel();
                hadeth.setTitle(mLine);
                while ((mLine = reader.readLine()) != null){
                    if(mLine.equals("#"))break;
                    hadeth.setContent(hadeth.getContent()+"\n"+mLine);
                }
                models.add(hadeth);

            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        return models;
    }

}
