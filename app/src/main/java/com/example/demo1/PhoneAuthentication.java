package com.example.demo1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.skydoves.powerspinner.OnSpinnerItemSelectedListener;
import com.skydoves.powerspinner.PowerSpinnerView;

import java.util.ArrayList;

public class PhoneAuthentication extends AppCompatActivity {

    Button auth;
    EditText phoneET, otpET;
    CardView card;
    ArrayList<String> codeList;
    PowerSpinnerView spinner;
    TextView err_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_authentication);
        getSupportActionBar().hide();
        findViewByID();
        setSpinnerItemsArrayList();
        spinner.setItems(codeList);
        spinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<String>(){
            @Override
            public void onItemSelected(int i, @Nullable String s, int i1, String selected) {

            }
        });
        auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.setText("Verify OTP");
//                if OTP verified redirect to next actitvity;
                if(phoneET.getText().toString().equals("") || otpET.getText().toString().equals(""))
                {
                    if(err_msg.getVisibility()!=View.VISIBLE)
                        err_msg.setVisibility(View.VISIBLE);
                    err_msg.startAnimation(shakeError());
                    return;
                }
                startActivity(new Intent(PhoneAuthentication.this, Registration.class));
                overridePendingTransition(0,2);
            }
        });
    }
    public TranslateAnimation shakeError() {
        Log.d("nandu","inShake Error ");
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
    public void findViewByID()
    {
        spinner = findViewById(R.id.code_spinner);
        auth=findViewById(R.id.auth_button);
        phoneET=findViewById(R.id.cpr_et);
        otpET=findViewById(R.id.otp_et);
        card=findViewById(R.id.card4);
        err_msg=findViewById(R.id.errMsg_pa);
    }
    public void setSpinnerItemsArrayList()
    {
        codeList=new ArrayList<>();
        codeList.add("  +91");
        codeList.add("  +92");
        codeList.add(" +973");
    }
}