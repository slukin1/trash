package com.hbg.lib.network.pro.socket.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class FundSituationBean implements Serializable {
    @SerializedName("15min")
    private FundSituationItem fifteenMin;
    @SerializedName("4hour")
    private FundSituationItem fourHour;
    @SerializedName("1day")
    private FundSituationItem oneDay;
    @SerializedName("60min")
    private FundSituationItem oneHour;
    @SerializedName("30min")
    private FundSituationItem thirtyMin;
    @SerializedName("2hour")
    private FundSituationItem twoHour;

    public static class FundSituationItem implements Serializable {
        private double bigBuy;
        private double bigInflow;
        private double bigSell;
        private double middleBuy;
        private double middleInflow;
        private double middleSell;
        private double smallBuy;
        private double smallInflow;
        private double smallSell;
        private double totalBuy;
        private double totalInflow;
        private double totalSell;

        /* renamed from: ts  reason: collision with root package name */
        private long f70628ts;

        public boolean canEqual(Object obj) {
            return obj instanceof FundSituationItem;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FundSituationItem)) {
                return false;
            }
            FundSituationItem fundSituationItem = (FundSituationItem) obj;
            return fundSituationItem.canEqual(this) && getTs() == fundSituationItem.getTs() && Double.compare(getBigBuy(), fundSituationItem.getBigBuy()) == 0 && Double.compare(getBigSell(), fundSituationItem.getBigSell()) == 0 && Double.compare(getBigInflow(), fundSituationItem.getBigInflow()) == 0 && Double.compare(getMiddleBuy(), fundSituationItem.getMiddleBuy()) == 0 && Double.compare(getMiddleSell(), fundSituationItem.getMiddleSell()) == 0 && Double.compare(getMiddleInflow(), fundSituationItem.getMiddleInflow()) == 0 && Double.compare(getSmallBuy(), fundSituationItem.getSmallBuy()) == 0 && Double.compare(getSmallSell(), fundSituationItem.getSmallSell()) == 0 && Double.compare(getSmallInflow(), fundSituationItem.getSmallInflow()) == 0 && Double.compare(getTotalBuy(), fundSituationItem.getTotalBuy()) == 0 && Double.compare(getTotalSell(), fundSituationItem.getTotalSell()) == 0 && Double.compare(getTotalInflow(), fundSituationItem.getTotalInflow()) == 0;
        }

        public double getBigBuy() {
            return this.bigBuy;
        }

        public double getBigInflow() {
            return this.bigInflow;
        }

        public double getBigSell() {
            return this.bigSell;
        }

        public double getMiddleBuy() {
            return this.middleBuy;
        }

        public double getMiddleInflow() {
            return this.middleInflow;
        }

        public double getMiddleSell() {
            return this.middleSell;
        }

        public double getSmallBuy() {
            return this.smallBuy;
        }

        public double getSmallInflow() {
            return this.smallInflow;
        }

        public double getSmallSell() {
            return this.smallSell;
        }

        public double getTotalBuy() {
            return this.totalBuy;
        }

        public double getTotalInflow() {
            return this.totalInflow;
        }

        public double getTotalSell() {
            return this.totalSell;
        }

        public long getTs() {
            return this.f70628ts;
        }

        public int hashCode() {
            long ts2 = getTs();
            long doubleToLongBits = Double.doubleToLongBits(getBigBuy());
            int i11 = ((((int) (ts2 ^ (ts2 >>> 32))) + 59) * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
            long doubleToLongBits2 = Double.doubleToLongBits(getBigSell());
            int i12 = (i11 * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
            long doubleToLongBits3 = Double.doubleToLongBits(getBigInflow());
            int i13 = (i12 * 59) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
            long doubleToLongBits4 = Double.doubleToLongBits(getMiddleBuy());
            int i14 = (i13 * 59) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
            long doubleToLongBits5 = Double.doubleToLongBits(getMiddleSell());
            int i15 = (i14 * 59) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
            long doubleToLongBits6 = Double.doubleToLongBits(getMiddleInflow());
            int i16 = (i15 * 59) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)));
            long doubleToLongBits7 = Double.doubleToLongBits(getSmallBuy());
            int i17 = (i16 * 59) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)));
            long doubleToLongBits8 = Double.doubleToLongBits(getSmallSell());
            int i18 = (i17 * 59) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)));
            long doubleToLongBits9 = Double.doubleToLongBits(getSmallInflow());
            int i19 = (i18 * 59) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
            long doubleToLongBits10 = Double.doubleToLongBits(getTotalBuy());
            int i21 = (i19 * 59) + ((int) (doubleToLongBits10 ^ (doubleToLongBits10 >>> 32)));
            long doubleToLongBits11 = Double.doubleToLongBits(getTotalSell());
            int i22 = (i21 * 59) + ((int) (doubleToLongBits11 ^ (doubleToLongBits11 >>> 32)));
            long doubleToLongBits12 = Double.doubleToLongBits(getTotalInflow());
            return (i22 * 59) + ((int) ((doubleToLongBits12 >>> 32) ^ doubleToLongBits12));
        }

        public void setBigBuy(double d11) {
            this.bigBuy = d11;
        }

        public void setBigInflow(double d11) {
            this.bigInflow = d11;
        }

        public void setBigSell(double d11) {
            this.bigSell = d11;
        }

        public void setMiddleBuy(double d11) {
            this.middleBuy = d11;
        }

        public void setMiddleInflow(double d11) {
            this.middleInflow = d11;
        }

        public void setMiddleSell(double d11) {
            this.middleSell = d11;
        }

        public void setSmallBuy(double d11) {
            this.smallBuy = d11;
        }

        public void setSmallInflow(double d11) {
            this.smallInflow = d11;
        }

        public void setSmallSell(double d11) {
            this.smallSell = d11;
        }

        public void setTotalBuy(double d11) {
            this.totalBuy = d11;
        }

        public void setTotalInflow(double d11) {
            this.totalInflow = d11;
        }

        public void setTotalSell(double d11) {
            this.totalSell = d11;
        }

        public void setTs(long j11) {
            this.f70628ts = j11;
        }

        public String toString() {
            return "FundSituationBean.FundSituationItem(ts=" + getTs() + ", bigBuy=" + getBigBuy() + ", bigSell=" + getBigSell() + ", bigInflow=" + getBigInflow() + ", middleBuy=" + getMiddleBuy() + ", middleSell=" + getMiddleSell() + ", middleInflow=" + getMiddleInflow() + ", smallBuy=" + getSmallBuy() + ", smallSell=" + getSmallSell() + ", smallInflow=" + getSmallInflow() + ", totalBuy=" + getTotalBuy() + ", totalSell=" + getTotalSell() + ", totalInflow=" + getTotalInflow() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof FundSituationBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FundSituationBean)) {
            return false;
        }
        FundSituationBean fundSituationBean = (FundSituationBean) obj;
        if (!fundSituationBean.canEqual(this)) {
            return false;
        }
        FundSituationItem fifteenMin2 = getFifteenMin();
        FundSituationItem fifteenMin3 = fundSituationBean.getFifteenMin();
        if (fifteenMin2 != null ? !fifteenMin2.equals(fifteenMin3) : fifteenMin3 != null) {
            return false;
        }
        FundSituationItem thirtyMin2 = getThirtyMin();
        FundSituationItem thirtyMin3 = fundSituationBean.getThirtyMin();
        if (thirtyMin2 != null ? !thirtyMin2.equals(thirtyMin3) : thirtyMin3 != null) {
            return false;
        }
        FundSituationItem twoHour2 = getTwoHour();
        FundSituationItem twoHour3 = fundSituationBean.getTwoHour();
        if (twoHour2 != null ? !twoHour2.equals(twoHour3) : twoHour3 != null) {
            return false;
        }
        FundSituationItem fourHour2 = getFourHour();
        FundSituationItem fourHour3 = fundSituationBean.getFourHour();
        if (fourHour2 != null ? !fourHour2.equals(fourHour3) : fourHour3 != null) {
            return false;
        }
        FundSituationItem oneHour2 = getOneHour();
        FundSituationItem oneHour3 = fundSituationBean.getOneHour();
        if (oneHour2 != null ? !oneHour2.equals(oneHour3) : oneHour3 != null) {
            return false;
        }
        FundSituationItem oneDay2 = getOneDay();
        FundSituationItem oneDay3 = fundSituationBean.getOneDay();
        return oneDay2 != null ? oneDay2.equals(oneDay3) : oneDay3 == null;
    }

    public FundSituationItem getFifteenMin() {
        return this.fifteenMin;
    }

    public FundSituationItem getFourHour() {
        return this.fourHour;
    }

    public FundSituationItem getOneDay() {
        return this.oneDay;
    }

    public FundSituationItem getOneHour() {
        return this.oneHour;
    }

    public FundSituationItem getThirtyMin() {
        return this.thirtyMin;
    }

    public FundSituationItem getTwoHour() {
        return this.twoHour;
    }

    public int hashCode() {
        FundSituationItem fifteenMin2 = getFifteenMin();
        int i11 = 43;
        int hashCode = fifteenMin2 == null ? 43 : fifteenMin2.hashCode();
        FundSituationItem thirtyMin2 = getThirtyMin();
        int hashCode2 = ((hashCode + 59) * 59) + (thirtyMin2 == null ? 43 : thirtyMin2.hashCode());
        FundSituationItem twoHour2 = getTwoHour();
        int hashCode3 = (hashCode2 * 59) + (twoHour2 == null ? 43 : twoHour2.hashCode());
        FundSituationItem fourHour2 = getFourHour();
        int hashCode4 = (hashCode3 * 59) + (fourHour2 == null ? 43 : fourHour2.hashCode());
        FundSituationItem oneHour2 = getOneHour();
        int hashCode5 = (hashCode4 * 59) + (oneHour2 == null ? 43 : oneHour2.hashCode());
        FundSituationItem oneDay2 = getOneDay();
        int i12 = hashCode5 * 59;
        if (oneDay2 != null) {
            i11 = oneDay2.hashCode();
        }
        return i12 + i11;
    }

    public void setFifteenMin(FundSituationItem fundSituationItem) {
        this.fifteenMin = fundSituationItem;
    }

    public void setFourHour(FundSituationItem fundSituationItem) {
        this.fourHour = fundSituationItem;
    }

    public void setOneDay(FundSituationItem fundSituationItem) {
        this.oneDay = fundSituationItem;
    }

    public void setOneHour(FundSituationItem fundSituationItem) {
        this.oneHour = fundSituationItem;
    }

    public void setThirtyMin(FundSituationItem fundSituationItem) {
        this.thirtyMin = fundSituationItem;
    }

    public void setTwoHour(FundSituationItem fundSituationItem) {
        this.twoHour = fundSituationItem;
    }

    public String toString() {
        return "FundSituationBean(fifteenMin=" + getFifteenMin() + ", thirtyMin=" + getThirtyMin() + ", twoHour=" + getTwoHour() + ", fourHour=" + getFourHour() + ", oneHour=" + getOneHour() + ", oneDay=" + getOneDay() + ")";
    }
}
