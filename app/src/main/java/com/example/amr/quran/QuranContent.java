package com.example.amr.quran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QuranContent extends AppCompatActivity {
    RecyclerView recyclerView;
    QuranAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran_content);

        String fileName=getIntent().getStringExtra("filenames");
        ArrayList<QuranModel>models=readFile(fileName);
        recyclerView=(RecyclerView) findViewById(R.id.quran_recyclerView);
        adapter=new QuranAdapter(models);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(QuranContent.this,DividerItemDecoration.HORIZONTAL));
    }

    ArrayList<QuranModel> readFile (String fileName){
        ArrayList<QuranModel> models=new ArrayList<>();

        BufferedReader reader=null;
        try {
            reader=new BufferedReader(new InputStreamReader(getAssets().open(fileName)));
            String lines;
            int index=1;
            while ((lines=reader.readLine())!= null){
                models.add(new QuranModel(lines,index++));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return models;
    }

}
