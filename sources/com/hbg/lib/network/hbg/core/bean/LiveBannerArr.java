package com.hbg.lib.network.hbg.core.bean;

import java.util.ArrayList;

public class LiveBannerArr extends LiveSquareBaseData {
    private ArrayList<LiveBannerData> banners;

    public ArrayList<LiveBannerData> getBanners() {
        return this.banners;
    }

    public void setBanners(ArrayList<LiveBannerData> arrayList) {
        this.banners = arrayList;
    }
}
