package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class TraderRank implements Serializable {
    public CurrentUser currentUser;
    public List<TraderInfo> itemList;
    public int totalNum;

    public static class CurrentUser implements Serializable {
        public String followedUserSign;
        public String userSign;
    }

    public static class TraderInfo implements Serializable {
        public double apy;
        public String copyProfit;
        public int copyStatus;
        public int copyUserNum;
        public int full;
        public int fullUserNum;
        public String imgUrl;
        public long lastTradeTime;
        public String nickName;

        /* renamed from: no  reason: collision with root package name */
        public int f70270no;
        public String profit;
        public List<Float> profitList;
        public long registerTime;
        public String tagMappings;
        public String tags;
        public String userSign;
        public double winRate;

        public String getApyStr() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.apy > 0.0d ? "+" : "");
            sb2.append(String.format("%.2f", new Object[]{Double.valueOf(this.apy * 100.0d)}));
            sb2.append("%");
            return sb2.toString();
        }

        public String getWinRateStr() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.winRate > 0.0d ? "+" : "");
            sb2.append(String.format("%.2f", new Object[]{Double.valueOf(this.winRate * 100.0d)}));
            sb2.append("%");
            return sb2.toString();
        }
    }
}
