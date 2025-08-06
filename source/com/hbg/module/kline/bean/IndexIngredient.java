package com.hbg.module.kline.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.module.kline.handler.MarketInfoIngredientHandler;
import java.io.Serializable;
import s9.a;

public class IndexIngredient implements a, Serializable {
    private static final long serialVersionUID = -1758391300612277456L;
    private double close;
    private String name;
    private double open;
    @SerializedName("rise_percent")
    private double risePercent;
    private String symbol;
    private double weight;

    public boolean canEqual(Object obj) {
        return obj instanceof IndexIngredient;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IndexIngredient)) {
            return false;
        }
        IndexIngredient indexIngredient = (IndexIngredient) obj;
        if (!indexIngredient.canEqual(this) || Double.compare(getClose(), indexIngredient.getClose()) != 0) {
            return false;
        }
        String name2 = getName();
        String name3 = indexIngredient.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        if (Double.compare(getOpen(), indexIngredient.getOpen()) != 0 || Double.compare(getRisePercent(), indexIngredient.getRisePercent()) != 0) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = indexIngredient.getSymbol();
        if (symbol2 != null ? symbol2.equals(symbol3) : symbol3 == null) {
            return Double.compare(getWeight(), indexIngredient.getWeight()) == 0;
        }
        return false;
    }

    public double getClose() {
        return this.close;
    }

    public String getName() {
        return this.name;
    }

    public double getOpen() {
        return this.open;
    }

    public double getRisePercent() {
        return this.risePercent;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getViewHandlerName() {
        return MarketInfoIngredientHandler.class.getName();
    }

    public double getWeight() {
        return this.weight;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(getClose());
        String name2 = getName();
        int i11 = (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 59) * 59;
        int i12 = 43;
        int hashCode = name2 == null ? 43 : name2.hashCode();
        long doubleToLongBits2 = Double.doubleToLongBits(getOpen());
        long doubleToLongBits3 = Double.doubleToLongBits(getRisePercent());
        int i13 = ((((i11 + hashCode) * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 59) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        String symbol2 = getSymbol();
        int i14 = i13 * 59;
        if (symbol2 != null) {
            i12 = symbol2.hashCode();
        }
        long doubleToLongBits4 = Double.doubleToLongBits(getWeight());
        return ((i14 + i12) * 59) + ((int) ((doubleToLongBits4 >>> 32) ^ doubleToLongBits4));
    }

    public void setClose(double d11) {
        this.close = d11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOpen(double d11) {
        this.open = d11;
    }

    public void setRisePercent(double d11) {
        this.risePercent = d11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setWeight(double d11) {
        this.weight = d11;
    }

    public String toString() {
        return "IndexIngredient(close=" + getClose() + ", name=" + getName() + ", open=" + getOpen() + ", risePercent=" + getRisePercent() + ", symbol=" + getSymbol() + ", weight=" + getWeight() + ")";
    }
}
