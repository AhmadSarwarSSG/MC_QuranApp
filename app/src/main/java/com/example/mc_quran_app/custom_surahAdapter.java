package com.example.mc_quran_app;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class custom_surahAdapter extends RecyclerView.Adapter<custom_surahAdapter.SurahClass> {
    List<SurahModel> surahList;
    RecycleListner RL;
    public custom_surahAdapter(List<SurahModel> surahList, RecycleListner RL) {
        this.surahList = surahList;
        this.RL=RL;
    }
    @NonNull
    @Override
    public custom_surahAdapter.SurahClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_surahlist, parent, false);
        return new SurahClass(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull custom_surahAdapter.SurahClass holder, int position) {
        holder.data=surahList.get(position);
        holder.surah_arabic.setText(holder.data.getSurahNameU()+"");
        holder.surah_english.setText(holder.data.getSurahNameE()+"");
        if(holder.data.getNazool().equals("Mecca"))
        {
            holder.nazool.setImageResource(R.drawable.mecca);
        }
        if(holder.data.getNazool().equals("Madina"))
        {
            holder.nazool.setImageResource(R.drawable.medina);
        }
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
        return surahList.size();
    }

    public class SurahClass extends RecyclerView.ViewHolder {
        ImageView nazool;
        TextView surah_arabic;
        TextView surah_english;
        SurahModel data;
        ConstraintLayout cl;
        public SurahClass(@NonNull View itemView) {
            super(itemView);
            nazool=itemView.findViewById(R.id.nazool);
            surah_arabic=itemView.findViewById(R.id.surahnameA);
            surah_english=itemView.findViewById(R.id.surahnameE);
            cl=itemView.findViewById(R.id.surahbg);
        }
    }
}
