package com.example.myapplication.Model;

public class ItemList {
    private String foodtitle;
    private int imageId;

    public ItemList(String foodtitle, int imageId) {
        this.foodtitle = foodtitle;
        this.imageId = imageId;
    }

    public String getFoodtitle() {
        return foodtitle;
    }

    public void setFoodtitle(String foodtitle) {
      this.foodtitle = foodtitle;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
   }
}

