package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class HomePageRecommendRegionData implements Serializable {
    public List<BannerAdv> actBanners;
    public List<BannerAdv> banners;
    public HotCurrency hotCurrency;
    public Novice novice;

    public static class BannerAdv implements Serializable {
        public long advId;
        public String advName;
        public String imageUrl;
        public String jumpTo;
        public String nightImageUrl;
    }

    public static class HotCurrency implements Serializable {
        public String baseCurrency;
        public String desc;
        public float heat;
        public JumpObj jumpObj;
        public float price;
        public float upAndDown;
    }

    public static class JumpObj implements Serializable {
        public int jumpType;
        public String jumpUrl;
    }

    public static class Novice implements Serializable {
        public String button;
        public String img;
        public String jumpUrl;
        public String subTitle;
        public String title;
        public int type;
    }
}
