package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class ProfitAndLoss implements Serializable {
    private TodayProfit todayProfit;

    public static class TodayProfit implements Serializable {
        private String profitBtc;
        private String rate;

        public boolean canEqual(Object obj) {
            return obj instanceof TodayProfit;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TodayProfit)) {
                return false;
            }
            TodayProfit todayProfit = (TodayProfit) obj;
            if (!todayProfit.canEqual(this)) {
                return false;
            }
            String profitBtc2 = getProfitBtc();
            String profitBtc3 = todayProfit.getProfitBtc();
            if (profitBtc2 != null ? !profitBtc2.equals(profitBtc3) : profitBtc3 != null) {
                return false;
            }
            String rate2 = getRate();
            String rate3 = todayProfit.getRate();
            return rate2 != null ? rate2.equals(rate3) : rate3 == null;
        }

        public String getProfitBtc() {
            return this.profitBtc;
        }

        public String getRate() {
            return this.rate;
        }

        public int hashCode() {
            String profitBtc2 = getProfitBtc();
            int i11 = 43;
            int hashCode = profitBtc2 == null ? 43 : profitBtc2.hashCode();
            String rate2 = getRate();
            int i12 = (hashCode + 59) * 59;
            if (rate2 != null) {
                i11 = rate2.hashCode();
            }
            return i12 + i11;
        }

        public void setProfitBtc(String str) {
            this.profitBtc = str;
        }

        public void setRate(String str) {
            this.rate = str;
        }

        public String toString() {
            return "ProfitAndLoss.TodayProfit(profitBtc=" + getProfitBtc() + ", rate=" + getRate() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ProfitAndLoss;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProfitAndLoss)) {
            return false;
        }
        ProfitAndLoss profitAndLoss = (ProfitAndLoss) obj;
        if (!profitAndLoss.canEqual(this)) {
            return false;
        }
        TodayProfit todayProfit2 = getTodayProfit();
        TodayProfit todayProfit3 = profitAndLoss.getTodayProfit();
        return todayProfit2 != null ? todayProfit2.equals(todayProfit3) : todayProfit3 == null;
    }

    public TodayProfit getTodayProfit() {
        return this.todayProfit;
    }

    public int hashCode() {
        TodayProfit todayProfit2 = getTodayProfit();
        return 59 + (todayProfit2 == null ? 43 : todayProfit2.hashCode());
    }

    public void setTodayProfit(TodayProfit todayProfit2) {
        this.todayProfit = todayProfit2;
    }

    public String toString() {
        return "ProfitAndLoss(todayProfit=" + getTodayProfit() + ")";
    }
}
