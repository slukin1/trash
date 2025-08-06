package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class LiveRecommendInfo implements Serializable {
    public long avgHoldTime;
    public int copyNum;
    public double copyTotalProfit;
    public int copyUserNum;
    public long firstSignUp;
    public int fullUserNum;

    /* renamed from: id  reason: collision with root package name */
    public int f70255id;
    public String imgUrl;
    public String nickname;
    public String reason;
    public String symbolPref;
    public double thirtyYield;
    public String totalProfit;

    /* renamed from: ts  reason: collision with root package name */
    public long f70256ts;
    public String userSign;
    public CommonPkData voteInfo;
    public int winNum;
    public double winRate;

    public String getThirtyYieldStr() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.thirtyYield > 0.0d ? "+" : "");
        sb2.append(String.format("%.2f", new Object[]{Double.valueOf(this.thirtyYield * 100.0d)}));
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
