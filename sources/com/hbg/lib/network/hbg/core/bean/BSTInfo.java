package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class BSTInfo implements Serializable {
    private int klineType;
    private List<BSTInfoBean> klines;
    private long startKline;
    private String symbol;

    public static class BSTInfoBean implements Serializable {
        private String bst;

        /* renamed from: id  reason: collision with root package name */
        private long f70224id;
        private List<Trade> trades;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            if (this.f70224id == ((BSTInfoBean) obj).f70224id) {
                return true;
            }
            return false;
        }

        public String getBst() {
            return this.bst;
        }

        public long getId() {
            return this.f70224id;
        }

        public List<Trade> getTrades() {
            return this.trades;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Long.valueOf(this.f70224id)});
        }

        public void setBst(String str) {
            this.bst = str;
        }

        public void setId(long j11) {
            this.f70224id = j11;
        }

        public void setTrades(List<Trade> list) {
            this.trades = list;
        }

        public String toString() {
            return String.valueOf(this.f70224id);
        }
    }

    public static class Trade implements Serializable {
        public long date;
        public int direct;
        public BigDecimal num;
        public int orderModel = 1;
        public int orderType;
        public double price;
        public String type;

        public long getDate() {
            return this.date;
        }

        public int getDirect() {
            return this.direct;
        }

        public BigDecimal getNum() {
            return this.num;
        }

        public int getOrderModel() {
            return this.orderModel;
        }

        public int getOrderType() {
            return this.orderType;
        }

        public double getPrice() {
            return this.price;
        }

        public String getType() {
            return this.type;
        }

        public void setDate(long j11) {
            this.date = j11;
        }

        public void setDirect(int i11) {
            this.direct = i11;
        }

        public void setNum(BigDecimal bigDecimal) {
            this.num = bigDecimal;
        }

        public void setOrderModel(int i11) {
            this.orderModel = i11;
        }

        public void setOrderType(int i11) {
            this.orderType = i11;
        }

        public void setPrice(double d11) {
            this.price = d11;
        }

        public void setType(String str) {
            this.type = str;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof BSTInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BSTInfo)) {
            return false;
        }
        BSTInfo bSTInfo = (BSTInfo) obj;
        if (!bSTInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = bSTInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        if (getKlineType() != bSTInfo.getKlineType() || getStartKline() != bSTInfo.getStartKline()) {
            return false;
        }
        List<BSTInfoBean> klines2 = getKlines();
        List<BSTInfoBean> klines3 = bSTInfo.getKlines();
        return klines2 != null ? klines2.equals(klines3) : klines3 == null;
    }

    public int getKlineType() {
        return this.klineType;
    }

    public List<BSTInfoBean> getKlines() {
        return this.klines;
    }

    public long getStartKline() {
        return this.startKline;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = (((symbol2 == null ? 43 : symbol2.hashCode()) + 59) * 59) + getKlineType();
        long startKline2 = getStartKline();
        int i12 = (hashCode * 59) + ((int) (startKline2 ^ (startKline2 >>> 32)));
        List<BSTInfoBean> klines2 = getKlines();
        int i13 = i12 * 59;
        if (klines2 != null) {
            i11 = klines2.hashCode();
        }
        return i13 + i11;
    }

    public void setKlineType(int i11) {
        this.klineType = i11;
    }

    public void setKlines(List<BSTInfoBean> list) {
        this.klines = list;
    }

    public void setStartKline(long j11) {
        this.startKline = j11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "BSTInfo(symbol=" + getSymbol() + ", klineType=" + getKlineType() + ", startKline=" + getStartKline() + ", klines=" + getKlines() + ")";
    }
}
