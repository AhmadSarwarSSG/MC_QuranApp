package com.example.mc_quran_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {

    Button surah;
    Button parah;
    Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        surah=findViewById(R.id.Surah_list_M);
        parah=findViewById(R.id.Parah_list_M);
        search=findViewById(R.id.Search_M);
        surah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainPage.this, MainActivity.class);
                startActivity(intent1);
            }
        });
        parah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainPage.this, Para_List.class);
                startActivity(intent2);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(MainPage.this, search_surah.class);
                startActivity(intent3);
            }
        });
    }
}