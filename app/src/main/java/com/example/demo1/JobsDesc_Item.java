package com.example.demo1;

public class JobsDesc_Item {
    String title;
    boolean check;
    public JobsDesc_Item(String title,boolean check){
        this.title=title;
        this.check=check;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
