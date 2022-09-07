package com.example.mc_quran_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecycleListner{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        navigationView=findViewById(R.id.nav_menu);
        drawerLayout=findViewById(R.id.my_drawer_layout);
        recyclerView=findViewById(R.id.surahListR);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DBHelper helper=new DBHelper(MainActivity.this);
        List<SurahModel> surahModels=helper.readSurah();
        surahModels.remove(surahModels.size()-1);
        adapter = new custom_surahAdapter(surahModels, this);
        recyclerView.setAdapter(adapter);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.para_open)
                {
                    Intent intent1=new Intent(MainActivity.this, Para_List.class);
                    startActivity(intent1);
                    return true;
                }
                else if(item.getItemId()==R.id.search){
                    Intent intent2=new Intent(MainActivity.this, search_surah.class);
                    startActivity(intent2);
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

    @Override
    public void onitemClicked(SurahModel surahModel) {
        Intent intent2=new Intent(MainActivity.this, Surah.class);
        intent2.putExtra("position", surahModel.getSurahID());
        intent2.putExtra("type", "Surah");
        startActivity(intent2);
    }
}