package com.hbg.module.kline.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class IndexDetail implements Serializable {
    private static final long serialVersionUID = 6924813757320286888L;
    @SerializedName("data_time")
    private long dataTime;
    @SerializedName("max_val")
    private double maxVal;
    @SerializedName("min_val")
    private double minVal;
    @SerializedName("open_val")
    private double openVal;
    @SerializedName("rise_percent")
    private double risePercent;
    @SerializedName("rise_val")
    private double riseVal;
    private List<IndexIngredient> symbols;
    private double value;

    public boolean canEqual(Object obj) {
        return obj instanceof IndexDetail;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IndexDetail)) {
            return false;
        }
        IndexDetail indexDetail = (IndexDetail) obj;
        if (!indexDetail.canEqual(this) || getDataTime() != indexDetail.getDataTime() || Double.compare(getMaxVal(), indexDetail.getMaxVal()) != 0 || Double.compare(getMinVal(), indexDetail.getMinVal()) != 0 || Double.compare(getOpenVal(), indexDetail.getOpenVal()) != 0 || Double.compare(getRisePercent(), indexDetail.getRisePercent()) != 0 || Double.compare(getRiseVal(), indexDetail.getRiseVal()) != 0 || Double.compare(getValue(), indexDetail.getValue()) != 0) {
            return false;
        }
        List<IndexIngredient> symbols2 = getSymbols();
        List<IndexIngredient> symbols3 = indexDetail.getSymbols();
        return symbols2 != null ? symbols2.equals(symbols3) : symbols3 == null;
    }

    public long getDataTime() {
        return this.dataTime;
    }

    public double getMaxVal() {
        return this.maxVal;
    }

    public double getMinVal() {
        return this.minVal;
    }

    public double getOpenVal() {
        return this.openVal;
    }

    public double getRisePercent() {
        return this.risePercent;
    }

    public double getRiseVal() {
        return this.riseVal;
    }

    public List<IndexIngredient> getSymbols() {
        return this.symbols;
    }

    public double getValue() {
        return this.value;
    }

    public int hashCode() {
        long dataTime2 = getDataTime();
        long doubleToLongBits = Double.doubleToLongBits(getMaxVal());
        int i11 = ((((int) (dataTime2 ^ (dataTime2 >>> 32))) + 59) * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        long doubleToLongBits2 = Double.doubleToLongBits(getMinVal());
        int i12 = (i11 * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(getOpenVal());
        int i13 = (i12 * 59) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(getRisePercent());
        int i14 = (i13 * 59) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(getRiseVal());
        int i15 = (i14 * 59) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
        long doubleToLongBits6 = Double.doubleToLongBits(getValue());
        List<IndexIngredient> symbols2 = getSymbols();
        return (((i15 * 59) + ((int) ((doubleToLongBits6 >>> 32) ^ doubleToLongBits6))) * 59) + (symbols2 == null ? 43 : symbols2.hashCode());
    }

    public void setDataTime(long j11) {
        this.dataTime = j11;
    }

    public void setMaxVal(double d11) {
        this.maxVal = d11;
    }

    public void setMinVal(double d11) {
        this.minVal = d11;
    }

    public void setOpenVal(double d11) {
        this.openVal = d11;
    }

    public void setRisePercent(double d11) {
        this.risePercent = d11;
    }

    public void setRiseVal(double d11) {
        this.riseVal = d11;
    }

    public void setSymbols(List<IndexIngredient> list) {
        this.symbols = list;
    }

    public void setValue(double d11) {
        this.value = d11;
    }

    public String toString() {
        return "IndexDetail(dataTime=" + getDataTime() + ", maxVal=" + getMaxVal() + ", minVal=" + getMinVal() + ", openVal=" + getOpenVal() + ", risePercent=" + getRisePercent() + ", riseVal=" + getRiseVal() + ", value=" + getValue() + ", symbols=" + getSymbols() + ")";
    }
}
