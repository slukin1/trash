package com.hbg.lib.network.hbg.core.bean;

import android.content.Context;
import android.content.res.Resources;
import com.hbg.lib.network.hbg.R$string;
import java.io.Serializable;

public class MiningItem implements Serializable {
    public static final int PROJECT_TYPE_ACTIVE = 0;
    public static final int PROJECT_TYPE_FIXED = 1;
    public static final int PROJECT_TYPE_HIGH = 3;
    public static final int SHELF_TYPE_ACTIVE_NEW_PLAYER = 3;
    public static final int SHELF_TYPE_FIXED_NEW_PLAYER = 4;
    public static final int SHELF_TYPE_LIMIT = 2;
    private String confirmedFixedTotalInterest;
    private String couponMaxAmount;
    private String couponRate;
    private int couponStatus;
    private String couponValidDaysCount;
    private String currency;
    private long effectTime;
    private String estFixedTodayInterest;
    private long incomeTime;
    private Boolean isCouponFullAmount;
    private Boolean isCouponFullTime;
    private String miningAmount;
    private String miningYearRate;
    private String orderId;
    private int orderShowLabelType;
    private String preMiningAmount;
    private String proIncomeAmount;
    private int projectType;
    private int shelfType;
    private int term;
    private String totalIncomeAmount;
    private String yesterdayIncome;

    public boolean canEqual(Object obj) {
        return obj instanceof MiningItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MiningItem)) {
            return false;
        }
        MiningItem miningItem = (MiningItem) obj;
        if (!miningItem.canEqual(this)) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = miningItem.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        if (getProjectType() != miningItem.getProjectType()) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = miningItem.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        if (getShelfType() != miningItem.getShelfType()) {
            return false;
        }
        String miningAmount2 = getMiningAmount();
        String miningAmount3 = miningItem.getMiningAmount();
        if (miningAmount2 != null ? !miningAmount2.equals(miningAmount3) : miningAmount3 != null) {
            return false;
        }
        String preMiningAmount2 = getPreMiningAmount();
        String preMiningAmount3 = miningItem.getPreMiningAmount();
        if (preMiningAmount2 != null ? !preMiningAmount2.equals(preMiningAmount3) : preMiningAmount3 != null) {
            return false;
        }
        String proIncomeAmount2 = getProIncomeAmount();
        String proIncomeAmount3 = miningItem.getProIncomeAmount();
        if (proIncomeAmount2 != null ? !proIncomeAmount2.equals(proIncomeAmount3) : proIncomeAmount3 != null) {
            return false;
        }
        String totalIncomeAmount2 = getTotalIncomeAmount();
        String totalIncomeAmount3 = miningItem.getTotalIncomeAmount();
        if (totalIncomeAmount2 != null ? !totalIncomeAmount2.equals(totalIncomeAmount3) : totalIncomeAmount3 != null) {
            return false;
        }
        if (getTerm() != miningItem.getTerm()) {
            return false;
        }
        String miningYearRate2 = getMiningYearRate();
        String miningYearRate3 = miningItem.getMiningYearRate();
        if (miningYearRate2 != null ? !miningYearRate2.equals(miningYearRate3) : miningYearRate3 != null) {
            return false;
        }
        String yesterdayIncome2 = getYesterdayIncome();
        String yesterdayIncome3 = miningItem.getYesterdayIncome();
        if (yesterdayIncome2 != null ? !yesterdayIncome2.equals(yesterdayIncome3) : yesterdayIncome3 != null) {
            return false;
        }
        if (getCouponStatus() != miningItem.getCouponStatus()) {
            return false;
        }
        String couponRate2 = getCouponRate();
        String couponRate3 = miningItem.getCouponRate();
        if (couponRate2 != null ? !couponRate2.equals(couponRate3) : couponRate3 != null) {
            return false;
        }
        if (getEffectTime() != miningItem.getEffectTime() || getIncomeTime() != miningItem.getIncomeTime()) {
            return false;
        }
        Boolean isCouponFullAmount2 = getIsCouponFullAmount();
        Boolean isCouponFullAmount3 = miningItem.getIsCouponFullAmount();
        if (isCouponFullAmount2 != null ? !isCouponFullAmount2.equals(isCouponFullAmount3) : isCouponFullAmount3 != null) {
            return false;
        }
        String couponMaxAmount2 = getCouponMaxAmount();
        String couponMaxAmount3 = miningItem.getCouponMaxAmount();
        if (couponMaxAmount2 != null ? !couponMaxAmount2.equals(couponMaxAmount3) : couponMaxAmount3 != null) {
            return false;
        }
        Boolean isCouponFullTime2 = getIsCouponFullTime();
        Boolean isCouponFullTime3 = miningItem.getIsCouponFullTime();
        if (isCouponFullTime2 != null ? !isCouponFullTime2.equals(isCouponFullTime3) : isCouponFullTime3 != null) {
            return false;
        }
        String couponValidDaysCount2 = getCouponValidDaysCount();
        String couponValidDaysCount3 = miningItem.getCouponValidDaysCount();
        if (couponValidDaysCount2 != null ? !couponValidDaysCount2.equals(couponValidDaysCount3) : couponValidDaysCount3 != null) {
            return false;
        }
        String estFixedTodayInterest2 = getEstFixedTodayInterest();
        String estFixedTodayInterest3 = miningItem.getEstFixedTodayInterest();
        if (estFixedTodayInterest2 != null ? !estFixedTodayInterest2.equals(estFixedTodayInterest3) : estFixedTodayInterest3 != null) {
            return false;
        }
        String confirmedFixedTotalInterest2 = getConfirmedFixedTotalInterest();
        String confirmedFixedTotalInterest3 = miningItem.getConfirmedFixedTotalInterest();
        if (confirmedFixedTotalInterest2 != null ? confirmedFixedTotalInterest2.equals(confirmedFixedTotalInterest3) : confirmedFixedTotalInterest3 == null) {
            return getOrderShowLabelType() == miningItem.getOrderShowLabelType();
        }
        return false;
    }

    public String getConfirmedFixedTotalInterest() {
        return this.confirmedFixedTotalInterest;
    }

    public String getCouponMaxAmount() {
        return this.couponMaxAmount;
    }

    public String getCouponRate() {
        return this.couponRate;
    }

    public int getCouponStatus() {
        return this.couponStatus;
    }

    public String getCouponValidDaysCount() {
        return this.couponValidDaysCount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public long getEffectTime() {
        return this.effectTime;
    }

    public String getEstFixedTodayInterest() {
        return this.estFixedTodayInterest;
    }

    public String getFixedTag(Context context) {
        Resources resources = context.getResources();
        int i11 = this.orderShowLabelType;
        if (i11 == 0) {
            return "PrimeEarn";
        }
        if (i11 == 1) {
            return resources.getString(R$string.n_asset_earn_new_coin);
        }
        if (i11 == 2) {
            return resources.getString(R$string.n_earn_fixed);
        }
        if (i11 == 3) {
            return "Staking";
        }
        if (i11 == 4) {
            return resources.getString(R$string.n_mining_new_player_enjoy);
        }
        if (i11 != 5) {
            return null;
        }
        return resources.getString(R$string.n_asset_ybb_text);
    }

    public long getIncomeTime() {
        return this.incomeTime;
    }

    public Boolean getIsCouponFullAmount() {
        return this.isCouponFullAmount;
    }

    public Boolean getIsCouponFullTime() {
        return this.isCouponFullTime;
    }

    public String getMiningAmount() {
        return this.miningAmount;
    }

    public String getMiningYearRate() {
        return this.miningYearRate;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public int getOrderShowLabelType() {
        return this.orderShowLabelType;
    }

    public String getPreMiningAmount() {
        return this.preMiningAmount;
    }

    public String getProIncomeAmount() {
        return this.proIncomeAmount;
    }

    public int getProjectType() {
        return this.projectType;
    }

    public int getShelfType() {
        return this.shelfType;
    }

    public String getTag(Context context) {
        Resources resources = context.getResources();
        int i11 = this.shelfType;
        if (i11 == 2) {
            return resources.getString(R$string.n_asset_earn_new_coin);
        }
        if (i11 == 3 || i11 == 4) {
            return resources.getString(R$string.n_mining_new_player_enjoy);
        }
        return null;
    }

    public int getTerm() {
        return this.term;
    }

    public String getTotalIncomeAmount() {
        return this.totalIncomeAmount;
    }

    public String getYesterdayIncome() {
        return this.yesterdayIncome;
    }

    public int hashCode() {
        String orderId2 = getOrderId();
        int i11 = 43;
        int hashCode = (((orderId2 == null ? 43 : orderId2.hashCode()) + 59) * 59) + getProjectType();
        String currency2 = getCurrency();
        int hashCode2 = (((hashCode * 59) + (currency2 == null ? 43 : currency2.hashCode())) * 59) + getShelfType();
        String miningAmount2 = getMiningAmount();
        int hashCode3 = (hashCode2 * 59) + (miningAmount2 == null ? 43 : miningAmount2.hashCode());
        String preMiningAmount2 = getPreMiningAmount();
        int hashCode4 = (hashCode3 * 59) + (preMiningAmount2 == null ? 43 : preMiningAmount2.hashCode());
        String proIncomeAmount2 = getProIncomeAmount();
        int hashCode5 = (hashCode4 * 59) + (proIncomeAmount2 == null ? 43 : proIncomeAmount2.hashCode());
        String totalIncomeAmount2 = getTotalIncomeAmount();
        int hashCode6 = (((hashCode5 * 59) + (totalIncomeAmount2 == null ? 43 : totalIncomeAmount2.hashCode())) * 59) + getTerm();
        String miningYearRate2 = getMiningYearRate();
        int hashCode7 = (hashCode6 * 59) + (miningYearRate2 == null ? 43 : miningYearRate2.hashCode());
        String yesterdayIncome2 = getYesterdayIncome();
        int hashCode8 = (((hashCode7 * 59) + (yesterdayIncome2 == null ? 43 : yesterdayIncome2.hashCode())) * 59) + getCouponStatus();
        String couponRate2 = getCouponRate();
        int hashCode9 = (hashCode8 * 59) + (couponRate2 == null ? 43 : couponRate2.hashCode());
        long effectTime2 = getEffectTime();
        int i12 = (hashCode9 * 59) + ((int) (effectTime2 ^ (effectTime2 >>> 32)));
        long incomeTime2 = getIncomeTime();
        int i13 = (i12 * 59) + ((int) (incomeTime2 ^ (incomeTime2 >>> 32)));
        Boolean isCouponFullAmount2 = getIsCouponFullAmount();
        int hashCode10 = (i13 * 59) + (isCouponFullAmount2 == null ? 43 : isCouponFullAmount2.hashCode());
        String couponMaxAmount2 = getCouponMaxAmount();
        int hashCode11 = (hashCode10 * 59) + (couponMaxAmount2 == null ? 43 : couponMaxAmount2.hashCode());
        Boolean isCouponFullTime2 = getIsCouponFullTime();
        int hashCode12 = (hashCode11 * 59) + (isCouponFullTime2 == null ? 43 : isCouponFullTime2.hashCode());
        String couponValidDaysCount2 = getCouponValidDaysCount();
        int hashCode13 = (hashCode12 * 59) + (couponValidDaysCount2 == null ? 43 : couponValidDaysCount2.hashCode());
        String estFixedTodayInterest2 = getEstFixedTodayInterest();
        int hashCode14 = (hashCode13 * 59) + (estFixedTodayInterest2 == null ? 43 : estFixedTodayInterest2.hashCode());
        String confirmedFixedTotalInterest2 = getConfirmedFixedTotalInterest();
        int i14 = hashCode14 * 59;
        if (confirmedFixedTotalInterest2 != null) {
            i11 = confirmedFixedTotalInterest2.hashCode();
        }
        return ((i14 + i11) * 59) + getOrderShowLabelType();
    }

    public void setConfirmedFixedTotalInterest(String str) {
        this.confirmedFixedTotalInterest = str;
    }

    public void setCouponMaxAmount(String str) {
        this.couponMaxAmount = str;
    }

    public void setCouponRate(String str) {
        this.couponRate = str;
    }

    public void setCouponStatus(int i11) {
        this.couponStatus = i11;
    }

    public void setCouponValidDaysCount(String str) {
        this.couponValidDaysCount = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setEffectTime(long j11) {
        this.effectTime = j11;
    }

    public void setEstFixedTodayInterest(String str) {
        this.estFixedTodayInterest = str;
    }

    public void setIncomeTime(long j11) {
        this.incomeTime = j11;
    }

    public void setIsCouponFullAmount(Boolean bool) {
        this.isCouponFullAmount = bool;
    }

    public void setIsCouponFullTime(Boolean bool) {
        this.isCouponFullTime = bool;
    }

    public void setMiningAmount(String str) {
        this.miningAmount = str;
    }

    public void setMiningYearRate(String str) {
        this.miningYearRate = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOrderShowLabelType(int i11) {
        this.orderShowLabelType = i11;
    }

    public void setPreMiningAmount(String str) {
        this.preMiningAmount = str;
    }

    public void setProIncomeAmount(String str) {
        this.proIncomeAmount = str;
    }

    public void setProjectType(int i11) {
        this.projectType = i11;
    }

    public void setShelfType(int i11) {
        this.shelfType = i11;
    }

    public void setTerm(int i11) {
        this.term = i11;
    }

    public void setTotalIncomeAmount(String str) {
        this.totalIncomeAmount = str;
    }

    public void setYesterdayIncome(String str) {
        this.yesterdayIncome = str;
    }

    public String toString() {
        return "MiningItem(orderId=" + getOrderId() + ", projectType=" + getProjectType() + ", currency=" + getCurrency() + ", shelfType=" + getShelfType() + ", miningAmount=" + getMiningAmount() + ", preMiningAmount=" + getPreMiningAmount() + ", proIncomeAmount=" + getProIncomeAmount() + ", totalIncomeAmount=" + getTotalIncomeAmount() + ", term=" + getTerm() + ", miningYearRate=" + getMiningYearRate() + ", yesterdayIncome=" + getYesterdayIncome() + ", couponStatus=" + getCouponStatus() + ", couponRate=" + getCouponRate() + ", effectTime=" + getEffectTime() + ", incomeTime=" + getIncomeTime() + ", isCouponFullAmount=" + getIsCouponFullAmount() + ", couponMaxAmount=" + getCouponMaxAmount() + ", isCouponFullTime=" + getIsCouponFullTime() + ", couponValidDaysCount=" + getCouponValidDaysCount() + ", estFixedTodayInterest=" + getEstFixedTodayInterest() + ", confirmedFixedTotalInterest=" + getConfirmedFixedTotalInterest() + ", orderShowLabelType=" + getOrderShowLabelType() + ")";
    }
}
