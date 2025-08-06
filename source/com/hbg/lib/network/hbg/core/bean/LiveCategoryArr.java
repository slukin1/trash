package com.hbg.lib.network.hbg.core.bean;

import java.util.ArrayList;

public class LiveCategoryArr extends LiveSquareBaseData {
    private ArrayList<LiveCategoryData> categories;

    public ArrayList<LiveCategoryData> getCategories() {
        return this.categories;
    }

    public void setCategories(ArrayList<LiveCategoryData> arrayList) {
        this.categories = arrayList;
    }
}
