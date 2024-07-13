package com.example.myapplication;

public class DataClass2 {
    private String dataTitle2;
    private int dataDesc2;
    private String dataLang2;
    private int dataImage2;
    public String getDataTitle() {
        return dataTitle2;
    }
    public int getDataDesc() {
        return dataDesc2;
    }
    public String getDataLang() {
        return dataLang2;
    }
    public int getDataImage() {
        return dataImage2;
    }
    public DataClass2(String dataTitle2, int dataDesc2, String dataLang2, int dataImage2) {
        this.dataTitle2 = dataTitle2;
        this.dataDesc2 = dataDesc2;
        this.dataLang2 = dataLang2;
        this.dataImage2 = dataImage2;
    }
}