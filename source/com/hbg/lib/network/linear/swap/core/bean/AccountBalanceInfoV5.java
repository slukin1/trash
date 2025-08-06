package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class AccountBalanceInfoV5 implements Serializable {
    @SerializedName("available_margin")
    private String availableMargin;
    @SerializedName("created_time")
    private long createdTime;
    private List<AccountInfoV5Item> details;
    private String equity;
    @SerializedName("initial_margin")
    private String initialMargin;
    @SerializedName("isolated_equity")
    private String isolatedEquity;
    @SerializedName("maintenance_margin")
    private String maintenanceMargin;
    @SerializedName("maintenance_margin_rate")
    private String maintenanceMarginRate;
    @SerializedName("profit_unreal")
    private String profitUnreal;
    private String state;
    private int type;
    private int version;
    @SerializedName("voucher_value")
    private String voucher;
    @SerializedName("withdraw_available")
    private String withdrawAvailable;

    public boolean canEqual(Object obj) {
        return obj instanceof AccountBalanceInfoV5;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountBalanceInfoV5)) {
            return false;
        }
        AccountBalanceInfoV5 accountBalanceInfoV5 = (AccountBalanceInfoV5) obj;
        if (!accountBalanceInfoV5.canEqual(this)) {
            return false;
        }
        String state2 = getState();
        String state3 = accountBalanceInfoV5.getState();
        if (state2 != null ? !state2.equals(state3) : state3 != null) {
            return false;
        }
        if (getType() != accountBalanceInfoV5.getType()) {
            return false;
        }
        String equity2 = getEquity();
        String equity3 = accountBalanceInfoV5.getEquity();
        if (equity2 != null ? !equity2.equals(equity3) : equity3 != null) {
            return false;
        }
        String isolatedEquity2 = getIsolatedEquity();
        String isolatedEquity3 = accountBalanceInfoV5.getIsolatedEquity();
        if (isolatedEquity2 != null ? !isolatedEquity2.equals(isolatedEquity3) : isolatedEquity3 != null) {
            return false;
        }
        String initialMargin2 = getInitialMargin();
        String initialMargin3 = accountBalanceInfoV5.getInitialMargin();
        if (initialMargin2 != null ? !initialMargin2.equals(initialMargin3) : initialMargin3 != null) {
            return false;
        }
        String maintenanceMargin2 = getMaintenanceMargin();
        String maintenanceMargin3 = accountBalanceInfoV5.getMaintenanceMargin();
        if (maintenanceMargin2 != null ? !maintenanceMargin2.equals(maintenanceMargin3) : maintenanceMargin3 != null) {
            return false;
        }
        String maintenanceMarginRate2 = getMaintenanceMarginRate();
        String maintenanceMarginRate3 = accountBalanceInfoV5.getMaintenanceMarginRate();
        if (maintenanceMarginRate2 != null ? !maintenanceMarginRate2.equals(maintenanceMarginRate3) : maintenanceMarginRate3 != null) {
            return false;
        }
        String profitUnreal2 = getProfitUnreal();
        String profitUnreal3 = accountBalanceInfoV5.getProfitUnreal();
        if (profitUnreal2 != null ? !profitUnreal2.equals(profitUnreal3) : profitUnreal3 != null) {
            return false;
        }
        String availableMargin2 = getAvailableMargin();
        String availableMargin3 = accountBalanceInfoV5.getAvailableMargin();
        if (availableMargin2 != null ? !availableMargin2.equals(availableMargin3) : availableMargin3 != null) {
            return false;
        }
        if (getVersion() != accountBalanceInfoV5.getVersion() || getCreatedTime() != accountBalanceInfoV5.getCreatedTime()) {
            return false;
        }
        String withdrawAvailable2 = getWithdrawAvailable();
        String withdrawAvailable3 = accountBalanceInfoV5.getWithdrawAvailable();
        if (withdrawAvailable2 != null ? !withdrawAvailable2.equals(withdrawAvailable3) : withdrawAvailable3 != null) {
            return false;
        }
        String voucher2 = getVoucher();
        String voucher3 = accountBalanceInfoV5.getVoucher();
        if (voucher2 != null ? !voucher2.equals(voucher3) : voucher3 != null) {
            return false;
        }
        List<AccountInfoV5Item> details2 = getDetails();
        List<AccountInfoV5Item> details3 = accountBalanceInfoV5.getDetails();
        return details2 != null ? details2.equals(details3) : details3 == null;
    }

    public String getAvailableMargin() {
        return this.availableMargin;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public List<AccountInfoV5Item> getDetails() {
        return this.details;
    }

    public String getEquity() {
        return this.equity;
    }

    public String getInitialMargin() {
        return this.initialMargin;
    }

    public String getIsolatedEquity() {
        return this.isolatedEquity;
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

    public String getState() {
        return this.state;
    }

    public int getType() {
        return this.type;
    }

    public int getVersion() {
        return this.version;
    }

    public String getVoucher() {
        return this.voucher;
    }

    public String getWithdrawAvailable() {
        return this.withdrawAvailable;
    }

    public int hashCode() {
        String state2 = getState();
        int i11 = 43;
        int hashCode = (((state2 == null ? 43 : state2.hashCode()) + 59) * 59) + getType();
        String equity2 = getEquity();
        int hashCode2 = (hashCode * 59) + (equity2 == null ? 43 : equity2.hashCode());
        String isolatedEquity2 = getIsolatedEquity();
        int hashCode3 = (hashCode2 * 59) + (isolatedEquity2 == null ? 43 : isolatedEquity2.hashCode());
        String initialMargin2 = getInitialMargin();
        int hashCode4 = (hashCode3 * 59) + (initialMargin2 == null ? 43 : initialMargin2.hashCode());
        String maintenanceMargin2 = getMaintenanceMargin();
        int hashCode5 = (hashCode4 * 59) + (maintenanceMargin2 == null ? 43 : maintenanceMargin2.hashCode());
        String maintenanceMarginRate2 = getMaintenanceMarginRate();
        int hashCode6 = (hashCode5 * 59) + (maintenanceMarginRate2 == null ? 43 : maintenanceMarginRate2.hashCode());
        String profitUnreal2 = getProfitUnreal();
        int hashCode7 = (hashCode6 * 59) + (profitUnreal2 == null ? 43 : profitUnreal2.hashCode());
        String availableMargin2 = getAvailableMargin();
        int hashCode8 = (((hashCode7 * 59) + (availableMargin2 == null ? 43 : availableMargin2.hashCode())) * 59) + getVersion();
        long createdTime2 = getCreatedTime();
        int i12 = (hashCode8 * 59) + ((int) (createdTime2 ^ (createdTime2 >>> 32)));
        String withdrawAvailable2 = getWithdrawAvailable();
        int hashCode9 = (i12 * 59) + (withdrawAvailable2 == null ? 43 : withdrawAvailable2.hashCode());
        String voucher2 = getVoucher();
        int hashCode10 = (hashCode9 * 59) + (voucher2 == null ? 43 : voucher2.hashCode());
        List<AccountInfoV5Item> details2 = getDetails();
        int i13 = hashCode10 * 59;
        if (details2 != null) {
            i11 = details2.hashCode();
        }
        return i13 + i11;
    }

    public void setAvailableMargin(String str) {
        this.availableMargin = str;
    }

    public void setCreatedTime(long j11) {
        this.createdTime = j11;
    }

    public void setDetails(List<AccountInfoV5Item> list) {
        this.details = list;
    }

    public void setEquity(String str) {
        this.equity = str;
    }

    public void setInitialMargin(String str) {
        this.initialMargin = str;
    }

    public void setIsolatedEquity(String str) {
        this.isolatedEquity = str;
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

    public void setState(String str) {
        this.state = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setVersion(int i11) {
        this.version = i11;
    }

    public void setVoucher(String str) {
        this.voucher = str;
    }

    public void setWithdrawAvailable(String str) {
        this.withdrawAvailable = str;
    }

    public String toString() {
        return "AccountBalanceInfoV5(state=" + getState() + ", type=" + getType() + ", equity=" + getEquity() + ", isolatedEquity=" + getIsolatedEquity() + ", initialMargin=" + getInitialMargin() + ", maintenanceMargin=" + getMaintenanceMargin() + ", maintenanceMarginRate=" + getMaintenanceMarginRate() + ", profitUnreal=" + getProfitUnreal() + ", availableMargin=" + getAvailableMargin() + ", version=" + getVersion() + ", createdTime=" + getCreatedTime() + ", withdrawAvailable=" + getWithdrawAvailable() + ", voucher=" + getVoucher() + ", details=" + getDetails() + ")";
    }
}
