package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AccountInfoV5Item implements Serializable {
    private String available;
    @SerializedName("created_time")
    private String createdTime;
    private String currency;
    private String equity;
    @SerializedName("initial_margin")
    private String initialMargin;
    @SerializedName("initial_margin_rate")
    private String initialMarginRate;
    @SerializedName("isolated_available")
    private String isolatedAvailable;
    @SerializedName("isolated_equity")
    private String isolatedEquity;
    @SerializedName("isolated_hold")
    private String isolatedHold;
    @SerializedName("isolated_profit_unreal")
    private String isolatedProfitUnreal;
    @SerializedName("maintenance_margin")
    private String maintenanceMargin;
    @SerializedName("maintenance_margin_rate")
    private String maintenanceMarginRate;
    @SerializedName("profit_unreal")
    private String profitUnreal;
    @SerializedName("voucher_value")
    private String voucher;
    @SerializedName("withdraw_available")
    private String withdrawAvailable;

    public boolean canEqual(Object obj) {
        return obj instanceof AccountInfoV5Item;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountInfoV5Item)) {
            return false;
        }
        AccountInfoV5Item accountInfoV5Item = (AccountInfoV5Item) obj;
        if (!accountInfoV5Item.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = accountInfoV5Item.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String equity2 = getEquity();
        String equity3 = accountInfoV5Item.getEquity();
        if (equity2 != null ? !equity2.equals(equity3) : equity3 != null) {
            return false;
        }
        String available2 = getAvailable();
        String available3 = accountInfoV5Item.getAvailable();
        if (available2 != null ? !available2.equals(available3) : available3 != null) {
            return false;
        }
        String isolatedEquity2 = getIsolatedEquity();
        String isolatedEquity3 = accountInfoV5Item.getIsolatedEquity();
        if (isolatedEquity2 != null ? !isolatedEquity2.equals(isolatedEquity3) : isolatedEquity3 != null) {
            return false;
        }
        String profitUnreal2 = getProfitUnreal();
        String profitUnreal3 = accountInfoV5Item.getProfitUnreal();
        if (profitUnreal2 != null ? !profitUnreal2.equals(profitUnreal3) : profitUnreal3 != null) {
            return false;
        }
        String isolatedAvailable2 = getIsolatedAvailable();
        String isolatedAvailable3 = accountInfoV5Item.getIsolatedAvailable();
        if (isolatedAvailable2 != null ? !isolatedAvailable2.equals(isolatedAvailable3) : isolatedAvailable3 != null) {
            return false;
        }
        String withdrawAvailable2 = getWithdrawAvailable();
        String withdrawAvailable3 = accountInfoV5Item.getWithdrawAvailable();
        if (withdrawAvailable2 != null ? !withdrawAvailable2.equals(withdrawAvailable3) : withdrawAvailable3 != null) {
            return false;
        }
        String isolatedHold2 = getIsolatedHold();
        String isolatedHold3 = accountInfoV5Item.getIsolatedHold();
        if (isolatedHold2 != null ? !isolatedHold2.equals(isolatedHold3) : isolatedHold3 != null) {
            return false;
        }
        String isolatedProfitUnreal2 = getIsolatedProfitUnreal();
        String isolatedProfitUnreal3 = accountInfoV5Item.getIsolatedProfitUnreal();
        if (isolatedProfitUnreal2 != null ? !isolatedProfitUnreal2.equals(isolatedProfitUnreal3) : isolatedProfitUnreal3 != null) {
            return false;
        }
        String initialMargin2 = getInitialMargin();
        String initialMargin3 = accountInfoV5Item.getInitialMargin();
        if (initialMargin2 != null ? !initialMargin2.equals(initialMargin3) : initialMargin3 != null) {
            return false;
        }
        String maintenanceMargin2 = getMaintenanceMargin();
        String maintenanceMargin3 = accountInfoV5Item.getMaintenanceMargin();
        if (maintenanceMargin2 != null ? !maintenanceMargin2.equals(maintenanceMargin3) : maintenanceMargin3 != null) {
            return false;
        }
        String maintenanceMarginRate2 = getMaintenanceMarginRate();
        String maintenanceMarginRate3 = accountInfoV5Item.getMaintenanceMarginRate();
        if (maintenanceMarginRate2 != null ? !maintenanceMarginRate2.equals(maintenanceMarginRate3) : maintenanceMarginRate3 != null) {
            return false;
        }
        String initialMarginRate2 = getInitialMarginRate();
        String initialMarginRate3 = accountInfoV5Item.getInitialMarginRate();
        if (initialMarginRate2 != null ? !initialMarginRate2.equals(initialMarginRate3) : initialMarginRate3 != null) {
            return false;
        }
        String createdTime2 = getCreatedTime();
        String createdTime3 = accountInfoV5Item.getCreatedTime();
        if (createdTime2 != null ? !createdTime2.equals(createdTime3) : createdTime3 != null) {
            return false;
        }
        String voucher2 = getVoucher();
        String voucher3 = accountInfoV5Item.getVoucher();
        return voucher2 != null ? voucher2.equals(voucher3) : voucher3 == null;
    }

    public String getAvailable() {
        return this.available;
    }

    public String getCreatedTime() {
        return this.createdTime;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getEquity() {
        return this.equity;
    }

    public String getInitialMargin() {
        return this.initialMargin;
    }

    public String getInitialMarginRate() {
        return this.initialMarginRate;
    }

    public String getIsolatedAvailable() {
        return this.isolatedAvailable;
    }

    public String getIsolatedEquity() {
        return this.isolatedEquity;
    }

    public String getIsolatedHold() {
        return this.isolatedHold;
    }

    public String getIsolatedProfitUnreal() {
        return this.isolatedProfitUnreal;
    }

    public String getMaintenanceMargin() {
        return this.maintenanceMargin;
    }

    public String getMaintenanceMarginRate() {
        return this.maintenanceMarginRate;
    }

    public String getProfitUnreal() {
        return this.profitUnreal;
    }

    public String getVoucher() {
        return this.voucher;
    }

    public String getWithdrawAvailable() {
        return this.withdrawAvailable;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String equity2 = getEquity();
        int hashCode2 = ((hashCode + 59) * 59) + (equity2 == null ? 43 : equity2.hashCode());
        String available2 = getAvailable();
        int hashCode3 = (hashCode2 * 59) + (available2 == null ? 43 : available2.hashCode());
        String isolatedEquity2 = getIsolatedEquity();
        int hashCode4 = (hashCode3 * 59) + (isolatedEquity2 == null ? 43 : isolatedEquity2.hashCode());
        String profitUnreal2 = getProfitUnreal();
        int hashCode5 = (hashCode4 * 59) + (profitUnreal2 == null ? 43 : profitUnreal2.hashCode());
        String isolatedAvailable2 = getIsolatedAvailable();
        int hashCode6 = (hashCode5 * 59) + (isolatedAvailable2 == null ? 43 : isolatedAvailable2.hashCode());
        String withdrawAvailable2 = getWithdrawAvailable();
        int hashCode7 = (hashCode6 * 59) + (withdrawAvailable2 == null ? 43 : withdrawAvailable2.hashCode());
        String isolatedHold2 = getIsolatedHold();
        int hashCode8 = (hashCode7 * 59) + (isolatedHold2 == null ? 43 : isolatedHold2.hashCode());
        String isolatedProfitUnreal2 = getIsolatedProfitUnreal();
        int hashCode9 = (hashCode8 * 59) + (isolatedProfitUnreal2 == null ? 43 : isolatedProfitUnreal2.hashCode());
        String initialMargin2 = getInitialMargin();
        int hashCode10 = (hashCode9 * 59) + (initialMargin2 == null ? 43 : initialMargin2.hashCode());
        String maintenanceMargin2 = getMaintenanceMargin();
        int hashCode11 = (hashCode10 * 59) + (maintenanceMargin2 == null ? 43 : maintenanceMargin2.hashCode());
        String maintenanceMarginRate2 = getMaintenanceMarginRate();
        int hashCode12 = (hashCode11 * 59) + (maintenanceMarginRate2 == null ? 43 : maintenanceMarginRate2.hashCode());
        String initialMarginRate2 = getInitialMarginRate();
        int hashCode13 = (hashCode12 * 59) + (initialMarginRate2 == null ? 43 : initialMarginRate2.hashCode());
        String createdTime2 = getCreatedTime();
        int hashCode14 = (hashCode13 * 59) + (createdTime2 == null ? 43 : createdTime2.hashCode());
        String voucher2 = getVoucher();
        int i12 = hashCode14 * 59;
        if (voucher2 != null) {
            i11 = voucher2.hashCode();
        }
        return i12 + i11;
    }

    public void setAvailable(String str) {
        this.available = str;
    }

    public void setCreatedTime(String str) {
        this.createdTime = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setEquity(String str) {
        this.equity = str;
    }

    public void setInitialMargin(String str) {
        this.initialMargin = str;
    }

    public void setInitialMarginRate(String str) {
        this.initialMarginRate = str;
    }

    public void setIsolatedAvailable(String str) {
        this.isolatedAvailable = str;
    }

    public void setIsolatedEquity(String str) {
        this.isolatedEquity = str;
    }

    public void setIsolatedHold(String str) {
        this.isolatedHold = str;
    }

    public void setIsolatedProfitUnreal(String str) {
        this.isolatedProfitUnreal = str;
    }

    public void setMaintenanceMargin(String str) {
        this.maintenanceMargin = str;
    }

    public void setMaintenanceMarginRate(String str) {
        this.maintenanceMarginRate = str;
    }

    public void setProfitUnreal(String str) {
        this.profitUnreal = str;
    }

    public void setVoucher(String str) {
        this.voucher = str;
    }

    public void setWithdrawAvailable(String str) {
        this.withdrawAvailable = str;
    }

    public String toString() {
        return "AccountInfoV5Item(currency=" + getCurrency() + ", equity=" + getEquity() + ", available=" + getAvailable() + ", isolatedEquity=" + getIsolatedEquity() + ", profitUnreal=" + getProfitUnreal() + ", isolatedAvailable=" + getIsolatedAvailable() + ", withdrawAvailable=" + getWithdrawAvailable() + ", isolatedHold=" + getIsolatedHold() + ", isolatedProfitUnreal=" + getIsolatedProfitUnreal() + ", initialMargin=" + getInitialMargin() + ", maintenanceMargin=" + getMaintenanceMargin() + ", maintenanceMarginRate=" + getMaintenanceMarginRate() + ", initialMarginRate=" + getInitialMarginRate() + ", createdTime=" + getCreatedTime() + ", voucher=" + getVoucher() + ")";
    }
}
