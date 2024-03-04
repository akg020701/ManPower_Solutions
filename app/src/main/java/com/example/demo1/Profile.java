package com.example.demo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.demo1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.profile);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()==R.id.jobs){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;
                }
                else if(item.getItemId()==R.id.profile){
                    return true;
                }
                else if(item.getItemId()==R.id.random){
                    startActivity(new Intent(getApplicationContext(),Random.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;
                }
                return false;
//                switch(item.getItemId())
//                {
//                    case R.id.random:
//                        startActivity(new Intent(getApplicationContext(),Random.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.profile:
//                        return true;
//                    case R.id.jobs:
//                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                }
//                return false;
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0,100);
    }
}
