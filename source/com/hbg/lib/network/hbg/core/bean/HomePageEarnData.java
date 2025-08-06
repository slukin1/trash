package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class HomePageEarnData implements Serializable {
    public List<IndexAreaContentItemVo> contents;
    public IndexAreaContentJumpVo more;
    public int show;
    public String title;

    public static class IndexAreaContentCouponVo implements Serializable {
        public double addRate;
        public String couponId;
        public String type;
    }

    public static class IndexAreaContentItemVo implements Serializable {
        public IndexAreaContentCouponVo coupon;
        public String currency;
        public long currentTime;
        public long endTime;
        public String finishAmount;
        public String iconUrl;
        public int isShow;
        public String projectDesc;
        public int projectId;
        public String projectName;
        public int projectStatus;
        public double rate;
        public int shelfType;
        public long startTime;
        public int term;
        public String totalAmount;
        public IndexAreaContentJumpVo url;
    }

    public static class IndexAreaContentJumpVo implements Serializable {
        public int jumpMode;
        public String jumpUrl;
        public String title;
    }
}
