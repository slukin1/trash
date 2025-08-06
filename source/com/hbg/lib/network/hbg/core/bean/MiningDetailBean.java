package com.hbg.lib.network.hbg.core.bean;

import android.content.Context;
import android.content.res.Resources;
import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.hbg.R$string;
import java.io.Serializable;
import java.util.List;

public class MiningDetailBean implements Serializable {
    private static final long serialVersionUID = 4532151456532942074L;
    private int allowMiningStatus;
    private int allowRedemptionStatus;
    private String balanceAmount;
    private int balanceAutoStatus;
    private String balanceAutoTime;
    private int btnStatus;
    private String couponRate;
    private int couponStatus;
    private String currency;
    private long effectTime;
    private int fixedToActiveAutoStatus;
    private long incomeTime;
    private String interestToGet;
    private boolean isPeProject;
    @SerializedName("isRedeemOrder")
    private boolean isRedeem;
    private boolean isShowFix2Active;
    private boolean isStEth;
    private boolean isSupportYbb;
    private String miningAmount;
    private long miningEndTime;
    private long miningStartTime;
    private String miningYearRate;
    private String orderId;
    private int orderShowLabelType;
    private String preMiningAmount;
    private String proIncomeAmount;
    private String projectId;
    private String projectName;
    private int projectType;
    private String redeemAmount;
    private String redeemLimitEndTime;
    private String redeemLimitStartTime;
    private int shelfType;
    private int term;
    private List<TieredRate> tieredRate;
    private String totalAmount;
    private String totalIncomeAmount;
    private String yesterTotalRate;
    private String yesterdayIncome;

    public static class TieredRate {
        public String amountEnd;
        public String amountStart;
        public String rate;

        public boolean canEqual(Object obj) {
            return obj instanceof TieredRate;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TieredRate)) {
                return false;
            }
            TieredRate tieredRate = (TieredRate) obj;
            if (!tieredRate.canEqual(this)) {
                return false;
            }
            String amountStart2 = getAmountStart();
            String amountStart3 = tieredRate.getAmountStart();
            if (amountStart2 != null ? !amountStart2.equals(amountStart3) : amountStart3 != null) {
                return false;
            }
            String amountEnd2 = getAmountEnd();
            String amountEnd3 = tieredRate.getAmountEnd();
            if (amountEnd2 != null ? !amountEnd2.equals(amountEnd3) : amountEnd3 != null) {
                return false;
            }
            String rate2 = getRate();
            String rate3 = tieredRate.getRate();
            return rate2 != null ? rate2.equals(rate3) : rate3 == null;
        }

        public String getAmountEnd() {
            return this.amountEnd;
        }

        public String getAmountStart() {
            return this.amountStart;
        }

        public String getRate() {
            return this.rate;
        }

        public int hashCode() {
            String amountStart2 = getAmountStart();
            int i11 = 43;
            int hashCode = amountStart2 == null ? 43 : amountStart2.hashCode();
            String amountEnd2 = getAmountEnd();
            int hashCode2 = ((hashCode + 59) * 59) + (amountEnd2 == null ? 43 : amountEnd2.hashCode());
            String rate2 = getRate();
            int i12 = hashCode2 * 59;
            if (rate2 != null) {
                i11 = rate2.hashCode();
            }
            return i12 + i11;
        }

        public void setAmountEnd(String str) {
            this.amountEnd = str;
        }

        public void setAmountStart(String str) {
            this.amountStart = str;
        }

        public void setRate(String str) {
            this.rate = str;
        }

        public String toString() {
            return "MiningDetailBean.TieredRate(amountStart=" + getAmountStart() + ", amountEnd=" + getAmountEnd() + ", rate=" + getRate() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof MiningDetailBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MiningDetailBean)) {
            return false;
        }
        MiningDetailBean miningDetailBean = (MiningDetailBean) obj;
        if (!miningDetailBean.canEqual(this)) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = miningDetailBean.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        if (getAllowMiningStatus() != miningDetailBean.getAllowMiningStatus() || getAllowRedemptionStatus() != miningDetailBean.getAllowRedemptionStatus() || getBalanceAutoStatus() != miningDetailBean.getBalanceAutoStatus()) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = miningDetailBean.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        if (getFixedToActiveAutoStatus() != miningDetailBean.getFixedToActiveAutoStatus()) {
            return false;
        }
        String balanceAmount2 = getBalanceAmount();
        String balanceAmount3 = miningDetailBean.getBalanceAmount();
        if (balanceAmount2 != null ? !balanceAmount2.equals(balanceAmount3) : balanceAmount3 != null) {
            return false;
        }
        String miningAmount2 = getMiningAmount();
        String miningAmount3 = miningDetailBean.getMiningAmount();
        if (miningAmount2 != null ? !miningAmount2.equals(miningAmount3) : miningAmount3 != null) {
            return false;
        }
        if (getMiningEndTime() != miningDetailBean.getMiningEndTime() || getMiningStartTime() != miningDetailBean.getMiningStartTime()) {
            return false;
        }
        String preMiningAmount2 = getPreMiningAmount();
        String preMiningAmount3 = miningDetailBean.getPreMiningAmount();
        if (preMiningAmount2 != null ? !preMiningAmount2.equals(preMiningAmount3) : preMiningAmount3 != null) {
            return false;
        }
        String proIncomeAmount2 = getProIncomeAmount();
        String proIncomeAmount3 = miningDetailBean.getProIncomeAmount();
        if (proIncomeAmount2 != null ? !proIncomeAmount2.equals(proIncomeAmount3) : proIncomeAmount3 != null) {
            return false;
        }
        String projectId2 = getProjectId();
        String projectId3 = miningDetailBean.getProjectId();
        if (projectId2 != null ? !projectId2.equals(projectId3) : projectId3 != null) {
            return false;
        }
        String projectName2 = getProjectName();
        String projectName3 = miningDetailBean.getProjectName();
        if (projectName2 != null ? !projectName2.equals(projectName3) : projectName3 != null) {
            return false;
        }
        if (getProjectType() != miningDetailBean.getProjectType() || getShelfType() != miningDetailBean.getShelfType() || getTerm() != miningDetailBean.getTerm()) {
            return false;
        }
        String totalAmount2 = getTotalAmount();
        String totalAmount3 = miningDetailBean.getTotalAmount();
        if (totalAmount2 != null ? !totalAmount2.equals(totalAmount3) : totalAmount3 != null) {
            return false;
        }
        String totalIncomeAmount2 = getTotalIncomeAmount();
        String totalIncomeAmount3 = miningDetailBean.getTotalIncomeAmount();
        if (totalIncomeAmount2 != null ? !totalIncomeAmount2.equals(totalIncomeAmount3) : totalIncomeAmount3 != null) {
            return false;
        }
        String yesterTotalRate2 = getYesterTotalRate();
        String yesterTotalRate3 = miningDetailBean.getYesterTotalRate();
        if (yesterTotalRate2 != null ? !yesterTotalRate2.equals(yesterTotalRate3) : yesterTotalRate3 != null) {
            return false;
        }
        String redeemLimitEndTime2 = getRedeemLimitEndTime();
        String redeemLimitEndTime3 = miningDetailBean.getRedeemLimitEndTime();
        if (redeemLimitEndTime2 != null ? !redeemLimitEndTime2.equals(redeemLimitEndTime3) : redeemLimitEndTime3 != null) {
            return false;
        }
        String redeemLimitStartTime2 = getRedeemLimitStartTime();
        String redeemLimitStartTime3 = miningDetailBean.getRedeemLimitStartTime();
        if (redeemLimitStartTime2 != null ? !redeemLimitStartTime2.equals(redeemLimitStartTime3) : redeemLimitStartTime3 != null) {
            return false;
        }
        String balanceAutoTime2 = getBalanceAutoTime();
        String balanceAutoTime3 = miningDetailBean.getBalanceAutoTime();
        if (balanceAutoTime2 != null ? !balanceAutoTime2.equals(balanceAutoTime3) : balanceAutoTime3 != null) {
            return false;
        }
        String redeemAmount2 = getRedeemAmount();
        String redeemAmount3 = miningDetailBean.getRedeemAmount();
        if (redeemAmount2 != null ? !redeemAmount2.equals(redeemAmount3) : redeemAmount3 != null) {
            return false;
        }
        String miningYearRate2 = getMiningYearRate();
        String miningYearRate3 = miningDetailBean.getMiningYearRate();
        if (miningYearRate2 != null ? !miningYearRate2.equals(miningYearRate3) : miningYearRate3 != null) {
            return false;
        }
        String yesterdayIncome2 = getYesterdayIncome();
        String yesterdayIncome3 = miningDetailBean.getYesterdayIncome();
        if (yesterdayIncome2 != null ? !yesterdayIncome2.equals(yesterdayIncome3) : yesterdayIncome3 != null) {
            return false;
        }
        if (getCouponStatus() != miningDetailBean.getCouponStatus()) {
            return false;
        }
        String couponRate2 = getCouponRate();
        String couponRate3 = miningDetailBean.getCouponRate();
        if (couponRate2 != null ? !couponRate2.equals(couponRate3) : couponRate3 != null) {
            return false;
        }
        if (getEffectTime() != miningDetailBean.getEffectTime() || getIncomeTime() != miningDetailBean.getIncomeTime()) {
            return false;
        }
        List<TieredRate> tieredRate2 = getTieredRate();
        List<TieredRate> tieredRate3 = miningDetailBean.getTieredRate();
        if (tieredRate2 != null ? !tieredRate2.equals(tieredRate3) : tieredRate3 != null) {
            return false;
        }
        if (isStEth() != miningDetailBean.isStEth() || isRedeem() != miningDetailBean.isRedeem() || isSupportYbb() != miningDetailBean.isSupportYbb() || isPeProject() != miningDetailBean.isPeProject() || isShowFix2Active() != miningDetailBean.isShowFix2Active() || getOrderShowLabelType() != miningDetailBean.getOrderShowLabelType()) {
            return false;
        }
        String interestToGet2 = getInterestToGet();
        String interestToGet3 = miningDetailBean.getInterestToGet();
        if (interestToGet2 != null ? interestToGet2.equals(interestToGet3) : interestToGet3 == null) {
            return getBtnStatus() == miningDetailBean.getBtnStatus();
        }
        return false;
    }

    public int getAllowMiningStatus() {
        return this.allowMiningStatus;
    }

    public int getAllowRedemptionStatus() {
        return this.allowRedemptionStatus;
    }

    public String getBalanceAmount() {
        return this.balanceAmount;
    }

    public int getBalanceAutoStatus() {
        return this.balanceAutoStatus;
    }

    public String getBalanceAutoTime() {
        return this.balanceAutoTime;
    }

    public int getBtnStatus() {
        return this.btnStatus;
    }

    public String getCouponRate() {
        return this.couponRate;
    }

    public int getCouponStatus() {
        return this.couponStatus;
    }

    public String getCurrency() {
        return this.currency;
    }

    public long getEffectTime() {
        return this.effectTime;
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

    public int getFixedToActiveAutoStatus() {
        return this.fixedToActiveAutoStatus;
    }

    public long getIncomeTime() {
        return this.incomeTime;
    }

    public String getInterestToGet() {
        return this.interestToGet;
    }

    public String getMiningAmount() {
        return this.miningAmount;
    }

    public long getMiningEndTime() {
        return this.miningEndTime;
    }

    public long getMiningStartTime() {
        return this.miningStartTime;
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

    public String getProjectId() {
        return this.projectId;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public int getProjectType() {
        return this.projectType;
    }

    public String getRedeemAmount() {
        return this.redeemAmount;
    }

    public String getRedeemLimitEndTime() {
        return this.redeemLimitEndTime;
    }

    public String getRedeemLimitStartTime() {
        return this.redeemLimitStartTime;
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

    public List<TieredRate> getTieredRate() {
        return this.tieredRate;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public String getTotalIncomeAmount() {
        return this.totalIncomeAmount;
    }

    public String getYesterTotalRate() {
        return this.yesterTotalRate;
    }

    public String getYesterdayIncome() {
        return this.yesterdayIncome;
    }

    public int hashCode() {
        String orderId2 = getOrderId();
        int i11 = 43;
        int hashCode = (((((((orderId2 == null ? 43 : orderId2.hashCode()) + 59) * 59) + getAllowMiningStatus()) * 59) + getAllowRedemptionStatus()) * 59) + getBalanceAutoStatus();
        String currency2 = getCurrency();
        int hashCode2 = (((hashCode * 59) + (currency2 == null ? 43 : currency2.hashCode())) * 59) + getFixedToActiveAutoStatus();
        String balanceAmount2 = getBalanceAmount();
        int hashCode3 = (hashCode2 * 59) + (balanceAmount2 == null ? 43 : balanceAmount2.hashCode());
        String miningAmount2 = getMiningAmount();
        int hashCode4 = (hashCode3 * 59) + (miningAmount2 == null ? 43 : miningAmount2.hashCode());
        long miningEndTime2 = getMiningEndTime();
        int i12 = (hashCode4 * 59) + ((int) (miningEndTime2 ^ (miningEndTime2 >>> 32)));
        long miningStartTime2 = getMiningStartTime();
        int i13 = (i12 * 59) + ((int) (miningStartTime2 ^ (miningStartTime2 >>> 32)));
        String preMiningAmount2 = getPreMiningAmount();
        int hashCode5 = (i13 * 59) + (preMiningAmount2 == null ? 43 : preMiningAmount2.hashCode());
        String proIncomeAmount2 = getProIncomeAmount();
        int hashCode6 = (hashCode5 * 59) + (proIncomeAmount2 == null ? 43 : proIncomeAmount2.hashCode());
        String projectId2 = getProjectId();
        int hashCode7 = (hashCode6 * 59) + (projectId2 == null ? 43 : projectId2.hashCode());
        String projectName2 = getProjectName();
        int hashCode8 = (((((((hashCode7 * 59) + (projectName2 == null ? 43 : projectName2.hashCode())) * 59) + getProjectType()) * 59) + getShelfType()) * 59) + getTerm();
        String totalAmount2 = getTotalAmount();
        int hashCode9 = (hashCode8 * 59) + (totalAmount2 == null ? 43 : totalAmount2.hashCode());
        String totalIncomeAmount2 = getTotalIncomeAmount();
        int hashCode10 = (hashCode9 * 59) + (totalIncomeAmount2 == null ? 43 : totalIncomeAmount2.hashCode());
        String yesterTotalRate2 = getYesterTotalRate();
        int hashCode11 = (hashCode10 * 59) + (yesterTotalRate2 == null ? 43 : yesterTotalRate2.hashCode());
        String redeemLimitEndTime2 = getRedeemLimitEndTime();
        int hashCode12 = (hashCode11 * 59) + (redeemLimitEndTime2 == null ? 43 : redeemLimitEndTime2.hashCode());
        String redeemLimitStartTime2 = getRedeemLimitStartTime();
        int hashCode13 = (hashCode12 * 59) + (redeemLimitStartTime2 == null ? 43 : redeemLimitStartTime2.hashCode());
        String balanceAutoTime2 = getBalanceAutoTime();
        int hashCode14 = (hashCode13 * 59) + (balanceAutoTime2 == null ? 43 : balanceAutoTime2.hashCode());
        String redeemAmount2 = getRedeemAmount();
        int hashCode15 = (hashCode14 * 59) + (redeemAmount2 == null ? 43 : redeemAmount2.hashCode());
        String miningYearRate2 = getMiningYearRate();
        int hashCode16 = (hashCode15 * 59) + (miningYearRate2 == null ? 43 : miningYearRate2.hashCode());
        String yesterdayIncome2 = getYesterdayIncome();
        int hashCode17 = (((hashCode16 * 59) + (yesterdayIncome2 == null ? 43 : yesterdayIncome2.hashCode())) * 59) + getCouponStatus();
        String couponRate2 = getCouponRate();
        int hashCode18 = (hashCode17 * 59) + (couponRate2 == null ? 43 : couponRate2.hashCode());
        long effectTime2 = getEffectTime();
        int i14 = (hashCode18 * 59) + ((int) (effectTime2 ^ (effectTime2 >>> 32)));
        long incomeTime2 = getIncomeTime();
        int i15 = (i14 * 59) + ((int) (incomeTime2 ^ (incomeTime2 >>> 32)));
        List<TieredRate> tieredRate2 = getTieredRate();
        int i16 = 79;
        int hashCode19 = ((((((((((i15 * 59) + (tieredRate2 == null ? 43 : tieredRate2.hashCode())) * 59) + (isStEth() ? 79 : 97)) * 59) + (isRedeem() ? 79 : 97)) * 59) + (isSupportYbb() ? 79 : 97)) * 59) + (isPeProject() ? 79 : 97)) * 59;
        if (!isShowFix2Active()) {
            i16 = 97;
        }
        int orderShowLabelType2 = ((hashCode19 + i16) * 59) + getOrderShowLabelType();
        String interestToGet2 = getInterestToGet();
        int i17 = orderShowLabelType2 * 59;
        if (interestToGet2 != null) {
            i11 = interestToGet2.hashCode();
        }
        return ((i17 + i11) * 59) + getBtnStatus();
    }

    public boolean isBalanceAutoStatusOpen() {
        return this.balanceAutoStatus == 1;
    }

    public boolean isFixedToActiveAutoStatusOpen() {
        return this.fixedToActiveAutoStatus == 1;
    }

    public boolean isPeProject() {
        return this.isPeProject;
    }

    public boolean isRedeem() {
        return this.isRedeem;
    }

    public boolean isShowFix2Active() {
        return this.isShowFix2Active;
    }

    public boolean isStEth() {
        return this.isStEth;
    }

    public boolean isSupportYbb() {
        return this.isSupportYbb;
    }

    public void setAllowMiningStatus(int i11) {
        this.allowMiningStatus = i11;
    }

    public void setAllowRedemptionStatus(int i11) {
        this.allowRedemptionStatus = i11;
    }

    public void setBalanceAmount(String str) {
        this.balanceAmount = str;
    }

    public void setBalanceAutoStatus(int i11) {
        this.balanceAutoStatus = i11;
    }

    public void setBalanceAutoTime(String str) {
        this.balanceAutoTime = str;
    }

    public void setBtnStatus(int i11) {
        this.btnStatus = i11;
    }

    public void setCouponRate(String str) {
        this.couponRate = str;
    }

    public void setCouponStatus(int i11) {
        this.couponStatus = i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setEffectTime(long j11) {
        this.effectTime = j11;
    }

    public void setFixedToActiveAutoStatus(int i11) {
        this.fixedToActiveAutoStatus = i11;
    }

    public void setIncomeTime(long j11) {
        this.incomeTime = j11;
    }

    public void setInterestToGet(String str) {
        this.interestToGet = str;
    }

    public void setMiningAmount(String str) {
        this.miningAmount = str;
    }

    public void setMiningEndTime(long j11) {
        this.miningEndTime = j11;
    }

    public void setMiningStartTime(long j11) {
        this.miningStartTime = j11;
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

    public void setPeProject(boolean z11) {
        this.isPeProject = z11;
    }

    public void setPreMiningAmount(String str) {
        this.preMiningAmount = str;
    }

    public void setProIncomeAmount(String str) {
        this.proIncomeAmount = str;
    }

    public void setProjectId(String str) {
        this.projectId = str;
    }

    public void setProjectName(String str) {
        this.projectName = str;
    }

    public void setProjectType(int i11) {
        this.projectType = i11;
    }

    public void setRedeem(boolean z11) {
        this.isRedeem = z11;
    }

    public void setRedeemAmount(String str) {
        this.redeemAmount = str;
    }

    public void setRedeemLimitEndTime(String str) {
        this.redeemLimitEndTime = str;
    }

    public void setRedeemLimitStartTime(String str) {
        this.redeemLimitStartTime = str;
    }

    public void setShelfType(int i11) {
        this.shelfType = i11;
    }

    public void setShowFix2Active(boolean z11) {
        this.isShowFix2Active = z11;
    }

    public void setStEth(boolean z11) {
        this.isStEth = z11;
    }

    public void setSupportYbb(boolean z11) {
        this.isSupportYbb = z11;
    }

    public void setTerm(int i11) {
        this.term = i11;
    }

    public void setTieredRate(List<TieredRate> list) {
        this.tieredRate = list;
    }

    public void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    public void setTotalIncomeAmount(String str) {
        this.totalIncomeAmount = str;
    }

    public void setYesterTotalRate(String str) {
        this.yesterTotalRate = str;
    }

    public void setYesterdayIncome(String str) {
        this.yesterdayIncome = str;
    }

    public String toString() {
        return "MiningDetailBean(orderId=" + getOrderId() + ", allowMiningStatus=" + getAllowMiningStatus() + ", allowRedemptionStatus=" + getAllowRedemptionStatus() + ", balanceAutoStatus=" + getBalanceAutoStatus() + ", currency=" + getCurrency() + ", fixedToActiveAutoStatus=" + getFixedToActiveAutoStatus() + ", balanceAmount=" + getBalanceAmount() + ", miningAmount=" + getMiningAmount() + ", miningEndTime=" + getMiningEndTime() + ", miningStartTime=" + getMiningStartTime() + ", preMiningAmount=" + getPreMiningAmount() + ", proIncomeAmount=" + getProIncomeAmount() + ", projectId=" + getProjectId() + ", projectName=" + getProjectName() + ", projectType=" + getProjectType() + ", shelfType=" + getShelfType() + ", term=" + getTerm() + ", totalAmount=" + getTotalAmount() + ", totalIncomeAmount=" + getTotalIncomeAmount() + ", yesterTotalRate=" + getYesterTotalRate() + ", redeemLimitEndTime=" + getRedeemLimitEndTime() + ", redeemLimitStartTime=" + getRedeemLimitStartTime() + ", balanceAutoTime=" + getBalanceAutoTime() + ", redeemAmount=" + getRedeemAmount() + ", miningYearRate=" + getMiningYearRate() + ", yesterdayIncome=" + getYesterdayIncome() + ", couponStatus=" + getCouponStatus() + ", couponRate=" + getCouponRate() + ", effectTime=" + getEffectTime() + ", incomeTime=" + getIncomeTime() + ", tieredRate=" + getTieredRate() + ", isStEth=" + isStEth() + ", isRedeem=" + isRedeem() + ", isSupportYbb=" + isSupportYbb() + ", isPeProject=" + isPeProject() + ", isShowFix2Active=" + isShowFix2Active() + ", orderShowLabelType=" + getOrderShowLabelType() + ", interestToGet=" + getInterestToGet() + ", btnStatus=" + getBtnStatus() + ")";
    }
}
