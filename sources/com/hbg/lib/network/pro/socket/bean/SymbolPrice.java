package com.hbg.lib.network.pro.socket.bean;

import java.io.Serializable;

public class SymbolPrice implements Serializable {
    private static final long serialVersionUID = -4736319750345888630L;
    private Double amount;
    private Double close;
    private Integer count;
    private Double high;
    private Double low;
    private Double open;
    private Double rise;
    private String symbol;
    private Double vol;

    public boolean canEqual(Object obj) {
        return obj instanceof SymbolPrice;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SymbolPrice)) {
            return false;
        }
        SymbolPrice symbolPrice = (SymbolPrice) obj;
        if (!symbolPrice.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = symbolPrice.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        Double open2 = getOpen();
        Double open3 = symbolPrice.getOpen();
        if (open2 != null ? !open2.equals(open3) : open3 != null) {
            return false;
        }
        Double close2 = getClose();
        Double close3 = symbolPrice.getClose();
        if (close2 != null ? !close2.equals(close3) : close3 != null) {
            return false;
        }
        Double low2 = getLow();
        Double low3 = symbolPrice.getLow();
        if (low2 != null ? !low2.equals(low3) : low3 != null) {
            return false;
        }
        Double high2 = getHigh();
        Double high3 = symbolPrice.getHigh();
        if (high2 != null ? !high2.equals(high3) : high3 != null) {
            return false;
        }
        Double amount2 = getAmount();
        Double amount3 = symbolPrice.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        Integer count2 = getCount();
        Integer count3 = symbolPrice.getCount();
        if (count2 != null ? !count2.equals(count3) : count3 != null) {
            return false;
        }
        Double vol2 = getVol();
        Double vol3 = symbolPrice.getVol();
        if (vol2 != null ? !vol2.equals(vol3) : vol3 != null) {
            return false;
        }
        Double rise2 = getRise();
        Double rise3 = symbolPrice.getRise();
        return rise2 != null ? rise2.equals(rise3) : rise3 == null;
    }

    public Double getAmount() {
        return this.amount;
    }

    public Double getClose() {
        return this.close;
    }

    public Integer getCount() {
        return this.count;
    }

    public Double getHigh() {
        return this.high;
    }

    public Double getLow() {
        return this.low;
    }

    public Double getOpen() {
        return this.open;
    }

    public Double getRise() {
        return this.rise;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public Double getVol() {
        return this.vol;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        Double open2 = getOpen();
        int hashCode2 = ((hashCode + 59) * 59) + (open2 == null ? 43 : open2.hashCode());
        Double close2 = getClose();
        int hashCode3 = (hashCode2 * 59) + (close2 == null ? 43 : close2.hashCode());
        Double low2 = getLow();
        int hashCode4 = (hashCode3 * 59) + (low2 == null ? 43 : low2.hashCode());
        Double high2 = getHigh();
        int hashCode5 = (hashCode4 * 59) + (high2 == null ? 43 : high2.hashCode());
        Double amount2 = getAmount();
        int hashCode6 = (hashCode5 * 59) + (amount2 == null ? 43 : amount2.hashCode());
        Integer count2 = getCount();
        int hashCode7 = (hashCode6 * 59) + (count2 == null ? 43 : count2.hashCode());
        Double vol2 = getVol();
        int hashCode8 = (hashCode7 * 59) + (vol2 == null ? 43 : vol2.hashCode());
        Double rise2 = getRise();
        int i12 = hashCode8 * 59;
        if (rise2 != null) {
            i11 = rise2.hashCode();
        }
        return i12 + i11;
    }

    public void setAmount(Double d11) {
        this.amount = d11;
    }

    public void setClose(Double d11) {
        this.close = d11;
    }

    public void setCount(Integer num) {
        this.count = num;
    }

    public void setHigh(Double d11) {
        this.high = d11;
    }

    public void setLow(Double d11) {
        this.low = d11;
    }

    public void setOpen(Double d11) {
        this.open = d11;
    }

    public void setRise(Double d11) {
        this.rise = d11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setVol(Double d11) {
        this.vol = d11;
    }

    public String toString() {
        return "SymbolPrice(symbol=" + getSymbol() + ", open=" + getOpen() + ", close=" + getClose() + ", low=" + getLow() + ", high=" + getHigh() + ", amount=" + getAmount() + ", count=" + getCount() + ", vol=" + getVol() + ", rise=" + getRise() + ")";
    }

    public void updateSymbolPrice(SymbolPrice symbolPrice) {
        this.open = symbolPrice.getOpen();
        this.close = symbolPrice.getClose();
        this.low = symbolPrice.getLow();
        this.high = symbolPrice.getHigh();
        this.amount = symbolPrice.getAmount();
        this.count = symbolPrice.getCount();
        this.vol = symbolPrice.getVol();
        this.symbol = symbolPrice.getSymbol();
        this.rise = symbolPrice.getRise();
    }
}
