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
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.AyaatClass> {
    List<Ayaat_Model> ayahhList;
    int choice;
    public CustomAdapter(List<Ayaat_Model> ayahList, int c) {
        this.ayahhList = ayahList;
        this.choice=c;
    }
    @NonNull
    @Override
    public AyaatClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_custom_ayaat, parent, false);
        return new CustomAdapter.AyaatClass(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AyaatClass holder, int position) {
        holder.data=ayahhList.get(position);
        holder.Arabic.setText(holder.data.getArabicText()+"");
        holder.Urdu.setText(holder.data.getFateh_Muhammad_Jalandhri()+"");
        holder.Urdu1.setText(holder.data.getMehmood_ul_Hassan()+"");
        holder.English.setText(holder.data.getDr_Mohsin_Khan()+"");
        holder.English1.setText(holder.data.getMufti_Taqi_Usmani()+"");
        if(position%2==0)
        {
            holder.cl.setBackgroundResource(R.color.bgcolor);
        }
        else
        {
            holder.cl.setBackgroundResource(R.color.white);
        }
        if(choice==0){
            holder.Urdu.setVisibility(View.GONE);
            holder.Urdu1.setVisibility(View.GONE);
            holder.English.setVisibility(View.GONE);
            holder.English1.setVisibility(View.GONE);
        }
        if(choice==1){
            holder.Urdu.setVisibility(View.VISIBLE);
            holder.Urdu1.setVisibility(View.GONE);
            holder.English.setVisibility(View.GONE);
            holder.English1.setVisibility(View.GONE);
        }
        if(choice==2){
            holder.Urdu.setVisibility(View.GONE);
            holder.Urdu1.setVisibility(View.VISIBLE);
            holder.English.setVisibility(View.GONE);
            holder.English1.setVisibility(View.GONE);
        }
        if(choice==3){
            holder.Urdu.setVisibility(View.GONE);
            holder.Urdu1.setVisibility(View.GONE);
            holder.English.setVisibility(View.VISIBLE);
            holder.English1.setVisibility(View.GONE);
        }
        if(choice==4){
            holder.Urdu.setVisibility(View.GONE);
            holder.Urdu1.setVisibility(View.GONE);
            holder.English.setVisibility(View.GONE);
            holder.English1.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return ayahhList.size();
    }

    public class AyaatClass extends RecyclerView.ViewHolder{
        TextView Arabic;
        TextView Urdu;
        TextView Urdu1;
        TextView English;
        TextView English1;
        Ayaat_Model data;
        ConstraintLayout cl;
        public AyaatClass(@NonNull View itemView) {
            super(itemView);
            Arabic=itemView.findViewById(R.id.ayaat_arabic);
            Urdu=itemView.findViewById(R.id.ayat_urdu);
            Urdu1=itemView.findViewById(R.id.ayat_urdu1);
            English=itemView.findViewById(R.id.ayat_english);
            English1=itemView.findViewById(R.id.ayat_english1);
            cl=itemView.findViewById(R.id.ayatbg);

        }
    }
}
