package com.example.mc_quran_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class juzzAdapter extends RecyclerView.Adapter<juzzAdapter.JuzzClass>{
    List<Parah> parahList;
    JuzzListner RL;
    public juzzAdapter(List<Parah> parahList, JuzzListner RL) {
        this.parahList = parahList;
        this.RL=RL;
    }
    @NonNull
    @Override
    public juzzAdapter.JuzzClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.juzz_list, parent, false);
        return new juzzAdapter.JuzzClass(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull juzzAdapter.JuzzClass holder, int position) {
        holder.data=parahList.get(position);
        holder.Name.setText(holder.data.name+"");
        if(position%2==0)
        {
            holder.cl.setBackgroundResource(R.color.bgcolor);
        }
        else
        {
            holder.cl.setBackgroundResource(R.color.white);
        }
        holder.cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RL.onitemClicked(holder.data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return parahList.size();
    }

    public class JuzzClass extends RecyclerView.ViewHolder {
        TextView Name;
        Parah data;
        ConstraintLayout cl;
        public JuzzClass(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.Juzzname);
            cl=itemView.findViewById(R.id.juzzlayout);
        }
    }
}
