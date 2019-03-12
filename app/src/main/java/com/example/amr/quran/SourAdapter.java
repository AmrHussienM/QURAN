package com.example.amr.quran;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

public class SourAdapter extends RecyclerView.Adapter<SourAdapter.ViewHolder> {
    List<SourModel> listOfSour;
    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public SourAdapter(List<SourModel> listOfSour) {
        this.listOfSour = listOfSour;
    }

    @NonNull
    @Override


    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.sour_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.titles.setText(listOfSour.get(position).getTitle());
        if (onItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(position,listOfSour.get(position));
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        if (listOfSour==null){return 0;}
        return listOfSour.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView titles;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;
            titles=(TextView) itemView.findViewById(R.id.titlesSour);
        }
    }
    public interface OnItemClickListener{
        void onClick(int position,SourModel sourModel);

    }
}
