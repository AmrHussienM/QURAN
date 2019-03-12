package com.example.amr.quran;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RadioAdapter extends RecyclerView.Adapter<RadioAdapter.ViewHolder> {
    List<Radio> data;

    public RadioAdapter(List<Radio> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.channel_item,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());

    }

    @Override
    public int getItemCount() {
        if (data==null){return 0;}
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);

            this.itemView=itemView;
            name=itemView.findViewById(R.id.nameChannel);
        }
    }
}
