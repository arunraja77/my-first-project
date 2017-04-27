package com.example.myfirstproject.uil;
public class ItemData {


    private String title;
    private int imageUrl;

    public ItemData(String title,int imageUrl){

        this.title = title;
        this.imageUrl = imageUrl;
    }
    // getters & setters
    public String getTitle() {
        return title;
    }
    public void setId(String title) {
        this.title = title;
    }




    public int getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
