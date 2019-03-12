package com.example.amr.quran;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class QuranAdapter extends RecyclerView.Adapter<QuranAdapter.ViewHolder> {
    List<QuranModel> listOfQuran;

    public QuranAdapter(List<QuranModel> listOfQuran) {
        this.listOfQuran = listOfQuran;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.quran_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.quranitem.setText(listOfQuran.get(position).getQuranItem()+"{"+(position+1)+"}");


    }

    @Override
    public int getItemCount() {
        if (listOfQuran==null){return 0;}
        return listOfQuran.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView quranitem;
        View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;
            quranitem=(TextView) itemView.findViewById(R.id.quranItem);
        }
    }
}
