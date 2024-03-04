package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Language_Choose extends AppCompatActivity {

    CardView option1,option2,option3,option0, current;
    Button button;
    SharedPreferences mPreferences;
    Locale myLocale;
    String currentLanguage="en",currentLang,currentLangua="en";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_choose);
        findViewByID();
        Locale l=new Locale("en");
        currentLanguage = getIntent().getStringExtra(currentLang);
        mPreferences = getSharedPreferences("User_data", MODE_PRIVATE);
        current=option0;
        option0.setBackgroundResource(R.drawable.on_item_select);
        option2.setEnabled(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                setLocale(currentLangua);
                startActivity(new Intent(Language_Choose.this, JobsCategory_Choose.class));
//                startActivity(new Intent(Language_Choose.this, PhoneAuthentication.class));
//                overridePendingTransition(0,0);
            }
        });
        getSupportActionBar().hide();
        option0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current!=option0){
                    option0.setBackgroundResource(R.drawable.on_item_select);
                    current.setBackgroundResource(R.drawable.item_background);
                    current=option0;
                    currentLangua="en";
                }
            }
        });
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current!=option1){
                    option1.setBackgroundResource(R.drawable.on_item_select);
                    current.setBackgroundResource(R.drawable.item_background);
                    current=option1;
                    currentLangua="hi";
//                    setLocale("hi");
                }
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current!=option2){
                    option2.setBackgroundResource(R.drawable.on_item_select);
                    current.setBackgroundResource(R.drawable.item_background);
                    current=option2;
                    currentLangua="ur";
//                    setLocale("ur");
                }
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current!=option3){
                    option3.setBackgroundResource(R.drawable.on_item_select);
                    current.setBackgroundResource(R.drawable.item_background);
                    current=option3;
                    currentLangua="bn";
//                    setLocale("bn");
                }
            }
        });
    }
    public void setLocale(String localeName) {
        if (!localeName.equals(currentLanguage)) {
            myLocale = new Locale(localeName);
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(this, PhoneAuthentication.class);
            refresh.putExtra(currentLang, localeName);
            startActivity(refresh);
            overridePendingTransition(0,0);

        }
    }

//    public void onBackPressed() {
//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        intent.addCategory(Intent.CATEGORY_HOME);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);
//        finish();
//        System.exit(0);
//    }
    public void findViewByID(){
        option1=findViewById(R.id.card1);
        option2=findViewById(R.id.card3);
        option3=findViewById(R.id.card2);
        button=findViewById(R.id.button);
        option0=findViewById(R.id.card4);
    }
}