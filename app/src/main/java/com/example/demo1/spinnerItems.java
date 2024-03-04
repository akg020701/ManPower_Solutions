package com.example.demo1;

import android.graphics.drawable.Drawable;

public class spinnerItems {
    Drawable flag;
    String code;
    public spinnerItems(Drawable flag, String code){
        this.flag=flag;
        this.code=code;
    }

    public Drawable getFlag() {
        return flag;
    }

    public String getCode() {
        return code;
    }
}
