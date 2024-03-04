package com.example.demo1;

public class Jobs_Item {
    String title;
    int img_id;
    JobsDesc_Item[] list;
    public Jobs_Item(String title, int img_id, JobsDesc_Item[] list)
    {
        this.title=title;
        this.img_id=img_id;
        this.list=list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public JobsDesc_Item[] getList() {
        return list;
    }

    public void setList(JobsDesc_Item[] list) {
        this.list = list;
    }
}
