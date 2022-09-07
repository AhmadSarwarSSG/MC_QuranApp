package com.example.mc_quran_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Surah extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);
        drawerLayout=findViewById(R.id.my_drawer_layout3);
        navigationView=findViewById(R.id.nav_menu3);
        recyclerView=findViewById(R.id.ayahListR);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(Surah.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent=getIntent();
        DBHelper helper=new DBHelper(Surah.this);
        List<Ayaat_Model> ayaat_modelList;
        if(intent.getStringExtra("type").equals("Surah")) {
            ayaat_modelList=helper.readAyah_surah(intent.getIntExtra("position", 0));
        }
        else
        {
            ayaat_modelList=helper.readAyah_para(intent.getIntExtra("position", 0)+1);
        }
        adapter = new CustomAdapter(ayaat_modelList, -1);
        recyclerView.setAdapter(adapter);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.aya_juzz)
                {
                    Intent intent1=new Intent(Surah.this, Para_List.class);
                    startActivity(intent1);
                    return true;
                }
                else if (item.getItemId()==R.id.aya_surah)
                {
                    Intent intent2=new Intent(Surah.this, MainActivity.class);
                    startActivity(intent2);
                    return true;
                }
                else if (item.getItemId()==R.id.aya_search)
                {
                    Intent intent3=new Intent(Surah.this, search_surah.class);
                    startActivity(intent3);
                    return true;
                }
                else if (item.getItemId()==R.id.no_trans)
                {
                    adapter = new CustomAdapter(ayaat_modelList, 0);
                    recyclerView.setAdapter(adapter);
                    return true;
                }
                else if (item.getItemId()==R.id.jalandhri)
                {
                    adapter = new CustomAdapter(ayaat_modelList, 1);
                    recyclerView.setAdapter(adapter);
                    return true;
                }
                else if (item.getItemId()==R.id.mehmood)
                {
                    adapter = new CustomAdapter(ayaat_modelList, 2);
                    recyclerView.setAdapter(adapter);
                    return true;
                }
                else if (item.getItemId()==R.id.mohsin)
                {
                    adapter = new CustomAdapter(ayaat_modelList, 3);
                    recyclerView.setAdapter(adapter);
                    return true;
                }
                else if (item.getItemId()==R.id.taqi)
                {
                    adapter = new CustomAdapter(ayaat_modelList, 4);
                    recyclerView.setAdapter(adapter);
                    return true;
                }
                else{
                    return false;
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}