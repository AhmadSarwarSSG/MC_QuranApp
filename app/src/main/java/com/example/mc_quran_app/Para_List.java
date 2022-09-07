package com.example.mc_quran_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Para_List extends AppCompatActivity implements JuzzListner{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_list);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        drawerLayout=findViewById(R.id.my_drawer_layout2);
        navigationView=findViewById(R.id.nav_menu2);
        recyclerView=findViewById(R.id.juazzListR);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(Para_List.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DBHelper helper=new DBHelper(Para_List.this);
        String[] Juzz={"آلم", "سَيَقُولُ", "تِلْكَ ٱلْرُّسُلُ", "لَنْ تَنَالُوْ الْبِرَّ", "وَٱلْمُحْصَنَاتُ", "لَا يُحِبُّ ٱللهُ", "وَإِذَا سَمِعُوا", "وَلَوْ أَنَّنَا", "قَالَ ٱلْمَلَأُ", "وَٱعْلَمُواْ",
                "يَعْتَذِرُونَ", "وَمَا مِنْ دَآبَّةٍ", "وَمَا أُبَرِّئُ", "رُبَمَا", "سُبْحَانَ ٱلَّذِى", "قَالَ أَلَمْ", "ٱقْتَرَبَ لِلْنَّاسِ", "قَدْ أَفْلَحَ", "وَقَالَ ٱلَّذِينَ", "أَمَّنْ خَلَقَ",
                "أُتْلُ مَاأُوْحِیَ	", "وَمَنْ يَّقْنُتْ", "وَمَآ لي", "فَمَنْ أَظْلَمُ", "إِلَيْهِ يُرَدُّ", "حم", "قَالَ فَمَا خَطْبُكُم", "قَدْ سَمِعَ ٱللهُ", "تَبَارَكَ ٱلَّذِى", "عَمَّ"};
        ArrayList<Parah> list=new ArrayList<>();
        for (int i=0; i<30; i++){
            list.add(new Parah(i, Juzz[i]));
        }
        adapter = new juzzAdapter(list, this);
        recyclerView.setAdapter(adapter);



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.sura_open)
                {
                    Intent intent1=new Intent(Para_List.this, MainActivity.class);
                    startActivity(intent1);
                    return true;
                }
                else if(item.getItemId()==R.id.search_para)
                {
                    Intent intent2=new Intent(Para_List.this, search_surah.class);
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //noinspection SimplifiableIfStatement

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onitemClicked(Parah parahModel) {
        Intent intent2=new Intent(Para_List.this, Surah.class);
        intent2.putExtra("position", parahModel.getId());
        intent2.putExtra("type", "parah");
        startActivity(intent2);
    }
}