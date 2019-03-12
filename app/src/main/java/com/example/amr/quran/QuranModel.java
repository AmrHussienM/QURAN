package com.example.amr.quran;

public class QuranModel {
    String quranItem;
    int position;

    public QuranModel(String quranItem, int position) {
        this.quranItem = quranItem;
        this.position = position;
    }

    public String getQuranItem() {
        return quranItem;
    }

    public void setQuranItem(String quranItem) {
        this.quranItem = quranItem;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
