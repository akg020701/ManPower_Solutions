package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Registration extends AppCompatActivity {

    EditText nameET, cprET, ageET, phoneET;
    Button submit;
    CardView male, female,trans,currentGender,card7,card8,card9,card10,card11, temp;
    ImageView IVPreviewImage, iv;
    ImageButton gallery;
    String name, age, phone, cpr;
    TextView err_msg;

    // constant to compare
    // the activity result code
    int SELECT_PICTURE = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        findViewByID();
        getSupportActionBar().hide();
        currentGender=male;
        name=nameET.getText().toString();
        age=ageET.getText().toString();
        phone=phoneET.getText().toString();
        cpr=cprET.getText().toString();
        male.setBackgroundResource(R.drawable.on_item_select);
//        card7.setBackgroundResource(R.drawable.on_item_select);
//        card8.setBackgroundResource(R.drawable.on_item_select);
//        card9.setBackgroundResource(R.drawable.on_item_select);
//        card10.setBackgroundResource(R.drawable.on_item_select);
//        card11.setBackgroundResource(R.drawable.on_item_select);
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentGender!=male){
                    male.setBackgroundResource(R.drawable.on_item_select);
                    currentGender.setBackgroundResource(R.drawable.item_background);
                    currentGender=male;}
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentGender!=female){
                    female.setBackgroundResource(R.drawable.on_item_select);
                    currentGender.setBackgroundResource(R.drawable.item_background);
                    currentGender=female;}
            }
        });
        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentGender!=trans){
                    trans.setBackgroundResource(R.drawable.on_item_select);
                    currentGender.setBackgroundResource(R.drawable.item_background);
                    currentGender=trans;}
            }
        });
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });
        IVPreviewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(nameET.getText().toString().equals("")||ageET.getText().toString().equals("")||cprET.getText().toString().equals("")||phoneET.getText().toString().equals(""))
                {
                    if(err_msg.getVisibility()!=View.VISIBLE)
                        err_msg.setVisibility(View.VISIBLE);
                    err_msg.startAnimation(shakeError());
                    return;
                }
                startActivity(new Intent(Registration.this, MainActivity.class));
                overridePendingTransition(0,100);
            }
        });
    }
    public TranslateAnimation shakeError() {
        Log.d("nandu","in shake reg");
        TranslateAnimation shake = new TranslateAnimation(0, 10, 0, 0);
        shake.setDuration(500);
        shake.setInterpolator(new CycleInterpolator(5));
        return shake;
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0,100);
    }

    void imageChooser() {
        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    IVPreviewImage.setImageURI(selectedImageUri);
                }
            }
        }
    }
    public void findViewByID(){
        male=findViewById(R.id.m_card);
        female=findViewById(R.id.f_card);
        trans=findViewById(R.id.trans_card);
        card7=findViewById(R.id.card7);
        card8=findViewById(R.id.card8);
        card9=findViewById(R.id.card9);
        card10=findViewById(R.id.card10);
        card11=findViewById(R.id.card11);
        gallery=findViewById(R.id.image_bt);
        IVPreviewImage=findViewById(R.id.imageView5);
        submit=findViewById(R.id.register_bt);
        nameET=findViewById(R.id.name_et);
        ageET=findViewById(R.id.age_et);
        cprET=findViewById(R.id.cpr_et);
        phoneET=findViewById(R.id.phone2_et);
        err_msg=findViewById(R.id.errMsg_r);

    }
}