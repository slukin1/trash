package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class LiteMarketDetail implements Serializable {
    private int coinId;
    private int currencyId;
    private List<Detail> detail;

    public static class Detail implements Serializable {
        private String price;
        private long time;

        public boolean canEqual(Object obj) {
            return obj instanceof Detail;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Detail)) {
                return false;
            }
            Detail detail = (Detail) obj;
            if (!detail.canEqual(this)) {
                return false;
            }
            String price2 = getPrice();
            String price3 = detail.getPrice();
            if (price2 != null ? price2.equals(price3) : price3 == null) {
                return getTime() == detail.getTime();
            }
            return false;
        }

        public String getPrice() {
            return this.price;
        }

        public long getTime() {
            return this.time;
        }

        public int hashCode() {
            String price2 = getPrice();
            int hashCode = price2 == null ? 43 : price2.hashCode();
            long time2 = getTime();
            return ((hashCode + 59) * 59) + ((int) ((time2 >>> 32) ^ time2));
        }

        public void setPrice(String str) {
            this.price = str;
        }

        public void setTime(long j11) {
            this.time = j11;
        }

        public String toString() {
            return "LiteMarketDetail.Detail(price=" + getPrice() + ", time=" + getTime() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof LiteMarketDetail;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiteMarketDetail)) {
            return false;
        }
        LiteMarketDetail liteMarketDetail = (LiteMarketDetail) obj;
        if (!liteMarketDetail.canEqual(this) || getCoinId() != liteMarketDetail.getCoinId() || getCurrencyId() != liteMarketDetail.getCurrencyId()) {
            return false;
        }
        List<Detail> detail2 = getDetail();
        List<Detail> detail3 = liteMarketDetail.getDetail();
        return detail2 != null ? detail2.equals(detail3) : detail3 == null;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public int getCurrencyId() {
        return this.currencyId;
    }

    public List<Detail> getDetail() {
        return this.detail;
    }

    public int hashCode() {
        int coinId2 = ((getCoinId() + 59) * 59) + getCurrencyId();
        List<Detail> detail2 = getDetail();
        return (coinId2 * 59) + (detail2 == null ? 43 : detail2.hashCode());
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setCurrencyId(int i11) {
        this.currencyId = i11;
    }

    public void setDetail(List<Detail> list) {
        this.detail = list;
    }

    public String toString() {
        return "LiteMarketDetail(coinId=" + getCoinId() + ", currencyId=" + getCurrencyId() + ", detail=" + getDetail() + ")";
    }
}
