package com.example.mc_quran_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class Search_Surah_Adapter extends ArrayAdapter<SurahModel> {
    public Search_Surah_Adapter(@NonNull Context context, List<SurahModel> surahModels) {
        super(context, 0, surahModels);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        SurahModel surahModel=getItem(position);
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.juzz_list, parent, false);
        TextView Name=convertView.findViewById(R.id.Juzzname);
        ConstraintLayout cl=convertView.findViewById(R.id.juzzlayout);
        Name.setText(surahModel.getSurahNameU()+"");
        if(position%2==0)
        {
            cl.setBackgroundResource(R.color.bgcolor);
        }
        else
        {
            cl.setBackgroundResource(R.color.white);
        }
        return convertView;
    }

}
