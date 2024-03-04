package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class JobsCategory_Choose extends AppCompatActivity {
    GridView jobs;
    public static View selected=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_category_choose);
        jobs = findViewById(R.id.jobs_gv);
//        setTitle("Choose Job Category");
//        this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.toolbar_job_category_choose);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.products_toolbar);
//
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Make toolbar show navigation button (i.e back button with arrow icon)

//        toolbar.setNavigationIcon(R.drawable.custom_icon);


        ArrayList<Jobs_Item> courseModelArrayList = new ArrayList<Jobs_Item>();
        courseModelArrayList.add(new Jobs_Item("Driver", R.drawable.driver, new JobsDesc_Item[]{new JobsDesc_Item("Bus Driver",false),new JobsDesc_Item("Car Driver",false),new JobsDesc_Item("Truck Driver",false),new JobsDesc_Item("Bike Driver",false),new JobsDesc_Item("Bicycle Driver",false),new JobsDesc_Item("Poclain Driver",false),new JobsDesc_Item("Crane Driver",false),new JobsDesc_Item("Aeroplane Driver",false),new JobsDesc_Item("Bus Driver",false),new JobsDesc_Item("Train Driver",false),new JobsDesc_Item("Ship Driver",false),new JobsDesc_Item("Bus Driver",false),new JobsDesc_Item("Boat Driver",false),new JobsDesc_Item("Tractor Driver",false),new JobsDesc_Item("For-lane Driver",false),new JobsDesc_Item("Bus Driver",false),new JobsDesc_Item("Bus Driver",false),new JobsDesc_Item("Bus Driver",false),new JobsDesc_Item("Bus Driver",false),new JobsDesc_Item("Bus Driver",false),new JobsDesc_Item("Bus Driver",false),new JobsDesc_Item("Bus Driver",false),new JobsDesc_Item("Bus Driver",false),new JobsDesc_Item("Bus Driver",false),new JobsDesc_Item("Bus Driver",false),new JobsDesc_Item("Bus Driver",false),new JobsDesc_Item("Bus Driver",false)}));
//        courseModelArrayList.add(new Jobs_Item("Carpenter", R.drawable.carpenter, new JobsDesc_Item[]{"Bus Driver", "Car Driver", "Truck Driver", "Pocklain", "Bus Driver", "Car Driver", "Truck Driver", "Pocklain"}));
//        courseModelArrayList.add(new Jobs_Item("Mason", R.drawable.mason));
//        courseModelArrayList.add(new Jobs_Item("Cook", R.drawable.cook));
//        courseModelArrayList.add(new Jobs_Item("Electrician", R.drawable.electrician));
//        courseModelArrayList.add(new Jobs_Item("Gardener", R.drawable.gardener));
//        courseModelArrayList.add(new Jobs_Item("Mason", R.drawable.mason));
//        courseModelArrayList.add(new Jobs_Item("Cook", R.drawable.cook));
//        courseModelArrayList.add(new Jobs_Item("Janitor", R.drawable.janitor));
//        courseModelArrayList.add(new Jobs_Item("Carpenter", R.drawable.carpenter));
//        courseModelArrayList.add(new Jobs_Item("Mason", R.drawable.driver));
//        courseModelArrayList.add(new Jobs_Item("Janitor", R.drawable.janitor));
//        courseModelArrayList.add(new Jobs_Item("Gardener", R.drawable.gardener));
//        courseModelArrayList.add(new Jobs_Item("Carpenter", R.drawable.carpenter));
//        courseModelArrayList.add(new Jobs_Item("Electrician", R.drawable.electrician));
//        courseModelArrayList.add(new Jobs_Item("Cook", R.drawable.cook));

        JobsGV_Adapter adapter = new JobsGV_Adapter(this, courseModelArrayList);
        jobs.setAdapter(adapter);
        findViewById(R.id.category_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}