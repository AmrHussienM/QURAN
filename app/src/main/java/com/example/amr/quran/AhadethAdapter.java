package com.example.amr.quran;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AhadethAdapter extends RecyclerView.Adapter<AhadethAdapter.ViewHolder> {
    List<AhadethModel> listOFAhadeth;

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public AhadethAdapter(List<AhadethModel> listOFAhadeth) {
        this.listOFAhadeth = listOFAhadeth;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.sour_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(listOFAhadeth.get(position).getTitle());
        if (onItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(position,listOFAhadeth.get(position));
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        if (listOFAhadeth==null){return 0;}
        return listOFAhadeth.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;
            name=(TextView) itemView.findViewById(R.id.titlesSour);
        }
    }
    public interface OnItemClickListener{
        void onClick(int position,AhadethModel model);
    }
}
