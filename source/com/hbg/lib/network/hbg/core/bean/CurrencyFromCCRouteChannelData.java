package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class CurrencyFromCCRouteChannelData implements Serializable {
    private static final long serialVersionUID = -1817698282201638982L;
    private boolean androidSupport;
    private String channel;
    private String depositDesc;
    private boolean depositEnable;
    private String depositSuspendDesc;
    private boolean depositVisibleEnable;
    private boolean iosSupport;
    private boolean largeTradePay;
    private boolean webSupport;
    private String withdrawDesc;
    private boolean withdrawEnable;
    private String withdrawSuspendDesc;
    private boolean withdrawVisibleEnable;

    public boolean canEqual(Object obj) {
        return obj instanceof CurrencyFromCCRouteChannelData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrencyFromCCRouteChannelData)) {
            return false;
        }
        CurrencyFromCCRouteChannelData currencyFromCCRouteChannelData = (CurrencyFromCCRouteChannelData) obj;
        if (!currencyFromCCRouteChannelData.canEqual(this)) {
            return false;
        }
        String channel2 = getChannel();
        String channel3 = currencyFromCCRouteChannelData.getChannel();
        if (channel2 != null ? !channel2.equals(channel3) : channel3 != null) {
            return false;
        }
        if (isDepositVisibleEnable() != currencyFromCCRouteChannelData.isDepositVisibleEnable() || isDepositEnable() != currencyFromCCRouteChannelData.isDepositEnable()) {
            return false;
        }
        String depositDesc2 = getDepositDesc();
        String depositDesc3 = currencyFromCCRouteChannelData.getDepositDesc();
        if (depositDesc2 != null ? !depositDesc2.equals(depositDesc3) : depositDesc3 != null) {
            return false;
        }
        String depositSuspendDesc2 = getDepositSuspendDesc();
        String depositSuspendDesc3 = currencyFromCCRouteChannelData.getDepositSuspendDesc();
        if (depositSuspendDesc2 != null ? !depositSuspendDesc2.equals(depositSuspendDesc3) : depositSuspendDesc3 != null) {
            return false;
        }
        if (isWithdrawVisibleEnable() != currencyFromCCRouteChannelData.isWithdrawVisibleEnable() || isWithdrawEnable() != currencyFromCCRouteChannelData.isWithdrawEnable()) {
            return false;
        }
        String withdrawDesc2 = getWithdrawDesc();
        String withdrawDesc3 = currencyFromCCRouteChannelData.getWithdrawDesc();
        if (withdrawDesc2 != null ? !withdrawDesc2.equals(withdrawDesc3) : withdrawDesc3 != null) {
            return false;
        }
        String withdrawSuspendDesc2 = getWithdrawSuspendDesc();
        String withdrawSuspendDesc3 = currencyFromCCRouteChannelData.getWithdrawSuspendDesc();
        if (withdrawSuspendDesc2 != null ? withdrawSuspendDesc2.equals(withdrawSuspendDesc3) : withdrawSuspendDesc3 == null) {
            return isAndroidSupport() == currencyFromCCRouteChannelData.isAndroidSupport() && isWebSupport() == currencyFromCCRouteChannelData.isWebSupport() && isIosSupport() == currencyFromCCRouteChannelData.isIosSupport() && isLargeTradePay() == currencyFromCCRouteChannelData.isLargeTradePay();
        }
        return false;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getDepositDesc() {
        return this.depositDesc;
    }

    public String getDepositSuspendDesc() {
        return this.depositSuspendDesc;
    }

    public String getWithdrawDesc() {
        return this.withdrawDesc;
    }

    public String getWithdrawSuspendDesc() {
        return this.withdrawSuspendDesc;
    }

    public int hashCode() {
        String channel2 = getChannel();
        int i11 = 43;
        int i12 = 79;
        int hashCode = (((((channel2 == null ? 43 : channel2.hashCode()) + 59) * 59) + (isDepositVisibleEnable() ? 79 : 97)) * 59) + (isDepositEnable() ? 79 : 97);
        String depositDesc2 = getDepositDesc();
        int hashCode2 = (hashCode * 59) + (depositDesc2 == null ? 43 : depositDesc2.hashCode());
        String depositSuspendDesc2 = getDepositSuspendDesc();
        int hashCode3 = (((((hashCode2 * 59) + (depositSuspendDesc2 == null ? 43 : depositSuspendDesc2.hashCode())) * 59) + (isWithdrawVisibleEnable() ? 79 : 97)) * 59) + (isWithdrawEnable() ? 79 : 97);
        String withdrawDesc2 = getWithdrawDesc();
        int hashCode4 = (hashCode3 * 59) + (withdrawDesc2 == null ? 43 : withdrawDesc2.hashCode());
        String withdrawSuspendDesc2 = getWithdrawSuspendDesc();
        int i13 = hashCode4 * 59;
        if (withdrawSuspendDesc2 != null) {
            i11 = withdrawSuspendDesc2.hashCode();
        }
        int i14 = (((((((i13 + i11) * 59) + (isAndroidSupport() ? 79 : 97)) * 59) + (isWebSupport() ? 79 : 97)) * 59) + (isIosSupport() ? 79 : 97)) * 59;
        if (!isLargeTradePay()) {
            i12 = 97;
        }
        return i14 + i12;
    }

    public boolean isAndroidSupport() {
        return this.androidSupport;
    }

    public boolean isDepositEnable() {
        return this.depositEnable;
    }

    public boolean isDepositVisibleEnable() {
        return this.depositVisibleEnable;
    }

    public boolean isIosSupport() {
        return this.iosSupport;
    }

    public boolean isLargeTradePay() {
        return this.largeTradePay;
    }

    public boolean isWebSupport() {
        return this.webSupport;
    }

    public boolean isWithdrawEnable() {
        return this.withdrawEnable;
    }

    public boolean isWithdrawVisibleEnable() {
        return this.withdrawVisibleEnable;
    }

    public void setAndroidSupport(boolean z11) {
        this.androidSupport = z11;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setDepositDesc(String str) {
        this.depositDesc = str;
    }

    public void setDepositEnable(boolean z11) {
        this.depositEnable = z11;
    }

    public void setDepositSuspendDesc(String str) {
        this.depositSuspendDesc = str;
    }

    public void setDepositVisibleEnable(boolean z11) {
        this.depositVisibleEnable = z11;
    }

    public void setIosSupport(boolean z11) {
        this.iosSupport = z11;
    }

    public void setLargeTradePay(boolean z11) {
        this.largeTradePay = z11;
    }

    public void setWebSupport(boolean z11) {
        this.webSupport = z11;
    }

    public void setWithdrawDesc(String str) {
        this.withdrawDesc = str;
    }

    public void setWithdrawEnable(boolean z11) {
        this.withdrawEnable = z11;
    }

    public void setWithdrawSuspendDesc(String str) {
        this.withdrawSuspendDesc = str;
    }

    public void setWithdrawVisibleEnable(boolean z11) {
        this.withdrawVisibleEnable = z11;
    }

    public String toString() {
        return "CurrencyFromCCRouteChannelData(channel=" + getChannel() + ", depositVisibleEnable=" + isDepositVisibleEnable() + ", depositEnable=" + isDepositEnable() + ", depositDesc=" + getDepositDesc() + ", depositSuspendDesc=" + getDepositSuspendDesc() + ", withdrawVisibleEnable=" + isWithdrawVisibleEnable() + ", withdrawEnable=" + isWithdrawEnable() + ", withdrawDesc=" + getWithdrawDesc() + ", withdrawSuspendDesc=" + getWithdrawSuspendDesc() + ", androidSupport=" + isAndroidSupport() + ", webSupport=" + isWebSupport() + ", iosSupport=" + isIosSupport() + ", largeTradePay=" + isLargeTradePay() + ")";
    }
}
