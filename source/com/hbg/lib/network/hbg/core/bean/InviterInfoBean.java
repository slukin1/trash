package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class InviterInfoBean implements Serializable {
    @SerializedName("fee_rate")
    private String feeRate;
    @SerializedName("fee_switch")
    private Integer feeSwitch;
    @SerializedName("ht_rate")
    private String htRate;
    @SerializedName("invalid_count")
    private Integer invalidCount;
    @SerializedName("point_rate")
    private String pointRate;
    @SerializedName("rate_limit")
    private Double rateLimit;
    @SerializedName("totalt")
    private Integer totalt;
    @SerializedName("usdt_rate")
    private String usdtRate;
    @SerializedName("valid_count")
    private Integer validCount;
    @SerializedName("valid_day")
    private Integer validDay;

    public boolean canEqual(Object obj) {
        return obj instanceof InviterInfoBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InviterInfoBean)) {
            return false;
        }
        InviterInfoBean inviterInfoBean = (InviterInfoBean) obj;
        if (!inviterInfoBean.canEqual(this)) {
            return false;
        }
        Integer totalt2 = getTotalt();
        Integer totalt3 = inviterInfoBean.getTotalt();
        if (totalt2 != null ? !totalt2.equals(totalt3) : totalt3 != null) {
            return false;
        }
        Integer validCount2 = getValidCount();
        Integer validCount3 = inviterInfoBean.getValidCount();
        if (validCount2 != null ? !validCount2.equals(validCount3) : validCount3 != null) {
            return false;
        }
        Double rateLimit2 = getRateLimit();
        Double rateLimit3 = inviterInfoBean.getRateLimit();
        if (rateLimit2 != null ? !rateLimit2.equals(rateLimit3) : rateLimit3 != null) {
            return false;
        }
        Integer invalidCount2 = getInvalidCount();
        Integer invalidCount3 = inviterInfoBean.getInvalidCount();
        if (invalidCount2 != null ? !invalidCount2.equals(invalidCount3) : invalidCount3 != null) {
            return false;
        }
        Integer validDay2 = getValidDay();
        Integer validDay3 = inviterInfoBean.getValidDay();
        if (validDay2 != null ? !validDay2.equals(validDay3) : validDay3 != null) {
            return false;
        }
        String usdtRate2 = getUsdtRate();
        String usdtRate3 = inviterInfoBean.getUsdtRate();
        if (usdtRate2 != null ? !usdtRate2.equals(usdtRate3) : usdtRate3 != null) {
            return false;
        }
        String feeRate2 = getFeeRate();
        String feeRate3 = inviterInfoBean.getFeeRate();
        if (feeRate2 != null ? !feeRate2.equals(feeRate3) : feeRate3 != null) {
            return false;
        }
        Integer feeSwitch2 = getFeeSwitch();
        Integer feeSwitch3 = inviterInfoBean.getFeeSwitch();
        if (feeSwitch2 != null ? !feeSwitch2.equals(feeSwitch3) : feeSwitch3 != null) {
            return false;
        }
        String pointRate2 = getPointRate();
        String pointRate3 = inviterInfoBean.getPointRate();
        if (pointRate2 != null ? !pointRate2.equals(pointRate3) : pointRate3 != null) {
            return false;
        }
        String htRate2 = getHtRate();
        String htRate3 = inviterInfoBean.getHtRate();
        return htRate2 != null ? htRate2.equals(htRate3) : htRate3 == null;
    }

    public String getFeeRate() {
        return this.feeRate;
    }

    public Integer getFeeSwitch() {
        return this.feeSwitch;
    }

    public String getHtRate() {
        return this.htRate;
    }

    public Integer getInvalidCount() {
        return this.invalidCount;
    }

    public String getPointRate() {
        return this.pointRate;
    }

    public Double getRateLimit() {
        return this.rateLimit;
    }

    public Integer getTotalt() {
        return this.totalt;
    }

    public String getUsdtRate() {
        return this.usdtRate;
    }

    public Integer getValidCount() {
        return this.validCount;
    }

    public Integer getValidDay() {
        return this.validDay;
    }

    public int hashCode() {
        Integer totalt2 = getTotalt();
        int i11 = 43;
        int hashCode = totalt2 == null ? 43 : totalt2.hashCode();
        Integer validCount2 = getValidCount();
        int hashCode2 = ((hashCode + 59) * 59) + (validCount2 == null ? 43 : validCount2.hashCode());
        Double rateLimit2 = getRateLimit();
        int hashCode3 = (hashCode2 * 59) + (rateLimit2 == null ? 43 : rateLimit2.hashCode());
        Integer invalidCount2 = getInvalidCount();
        int hashCode4 = (hashCode3 * 59) + (invalidCount2 == null ? 43 : invalidCount2.hashCode());
        Integer validDay2 = getValidDay();
        int hashCode5 = (hashCode4 * 59) + (validDay2 == null ? 43 : validDay2.hashCode());
        String usdtRate2 = getUsdtRate();
        int hashCode6 = (hashCode5 * 59) + (usdtRate2 == null ? 43 : usdtRate2.hashCode());
        String feeRate2 = getFeeRate();
        int hashCode7 = (hashCode6 * 59) + (feeRate2 == null ? 43 : feeRate2.hashCode());
        Integer feeSwitch2 = getFeeSwitch();
        int hashCode8 = (hashCode7 * 59) + (feeSwitch2 == null ? 43 : feeSwitch2.hashCode());
        String pointRate2 = getPointRate();
        int hashCode9 = (hashCode8 * 59) + (pointRate2 == null ? 43 : pointRate2.hashCode());
        String htRate2 = getHtRate();
        int i12 = hashCode9 * 59;
        if (htRate2 != null) {
            i11 = htRate2.hashCode();
        }
        return i12 + i11;
    }

    public void setFeeRate(String str) {
        this.feeRate = str;
    }

    public void setFeeSwitch(Integer num) {
        this.feeSwitch = num;
    }

    public void setHtRate(String str) {
        this.htRate = str;
    }

    public void setInvalidCount(Integer num) {
        this.invalidCount = num;
    }

    public void setPointRate(String str) {
        this.pointRate = str;
    }

    public void setRateLimit(Double d11) {
        this.rateLimit = d11;
    }

    public void setTotalt(Integer num) {
        this.totalt = num;
    }

    public void setUsdtRate(String str) {
        this.usdtRate = str;
    }

    public void setValidCount(Integer num) {
        this.validCount = num;
    }

    public void setValidDay(Integer num) {
        this.validDay = num;
    }

    public String toString() {
        return "InviterInfoBean(totalt=" + getTotalt() + ", validCount=" + getValidCount() + ", rateLimit=" + getRateLimit() + ", invalidCount=" + getInvalidCount() + ", validDay=" + getValidDay() + ", usdtRate=" + getUsdtRate() + ", feeRate=" + getFeeRate() + ", feeSwitch=" + getFeeSwitch() + ", pointRate=" + getPointRate() + ", htRate=" + getHtRate() + ")";
    }
}
