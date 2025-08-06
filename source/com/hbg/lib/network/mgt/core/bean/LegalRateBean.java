package com.hbg.lib.network.mgt.core.bean;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.math.BigDecimal;

public class LegalRateBean implements Serializable {
    private static final transient String SPLIT_FLAG = "_";
    public transient String after;
    @SerializedName("dataTime")
    private long dataTime;
    private String name;
    public transient String pre;
    private BigDecimal rate;
    private long time;

    public long getDataTime() {
        return this.dataTime;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getRate() {
        return this.rate;
    }

    public long getTime() {
        return this.time;
    }

    public void initPreAndAfter() {
        try {
            if (!TextUtils.isEmpty(this.name) && this.name.contains(SPLIT_FLAG)) {
                String[] split = this.name.split(SPLIT_FLAG);
                this.pre = split[0];
                this.after = split[1];
            }
        } catch (Exception unused) {
        }
    }

    public boolean isCny() {
        return "cny".equals(this.after);
    }

    public boolean isEur() {
        return "eur".equals(this.after);
    }

    public boolean isGbp() {
        return "gbp".equals(this.after);
    }

    public boolean isJpy() {
        return "jpy".equals(this.after);
    }

    public boolean isKrw() {
        return "krw".equals(this.after);
    }

    public boolean isSur() {
        return "rub".equals(this.after);
    }

    public boolean isUsd() {
        return "usd".equals(this.after);
    }

    public boolean isUsdCny() {
        return "usd".equals(this.pre) && "cny".equals(this.after);
    }

    public boolean isUsdPre() {
        return "usd".equals(this.pre);
    }

    public boolean isUsdtCny() {
        return "usdt".equals(this.pre) && "cny".equals(this.after);
    }

    public boolean isVnd() {
        return "vnd".equals(this.after);
    }

    public void setDataTime(long j11) {
        this.dataTime = j11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRate(BigDecimal bigDecimal) {
        this.rate = bigDecimal;
    }

    public void setTime(long j11) {
        this.time = j11;
    }

    public String toString() {
        return "CurrencyRateBean{name='" + this.name + '\'' + ", rate=" + this.rate + ", time=" + this.time + ", dataTime=" + this.dataTime + ", pre='" + this.pre + '\'' + ", after='" + this.after + '\'' + '}';
    }
}
