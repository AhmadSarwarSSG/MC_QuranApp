package com.example.mc_quran_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class search_surah extends AppCompatActivity {
    ListView surah_search;
    EditText search_text;
    Button seach_btn;
    ArrayList<SurahModel> Al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_surah);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        surah_search=findViewById(R.id.search_surah_list);
        search_text=findViewById(R.id.search_in);
        seach_btn=findViewById(R.id.search_btn_s);
        DBHelper db=new DBHelper(search_surah.this);
        seach_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Al = db.readSurah(search_text.getText()+"");
                Search_Surah_Adapter SSA=new Search_Surah_Adapter(search_surah.this, Al);
                surah_search.setAdapter(SSA);
            }
        });
        surah_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent2=new Intent(search_surah.this, Surah.class);
                intent2.putExtra("position", Al.get(position).getSurahID());
                intent2.putExtra("type", "Surah");
                startActivity(intent2);
            }
        });
    }
}