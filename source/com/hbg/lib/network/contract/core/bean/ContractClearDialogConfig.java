package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractClearDialogConfig implements Serializable {
    public static final int DIALOG_SWITCH_AFTER = 2;
    public static final int DIALOG_SWITCH_CLOSE = 0;
    public static final int DIALOG_SWITCH_FRONT = 1;
    public static final int IN_BLACK_LIST = 1;
    public static final int OUT_BLACK_LIST = 0;
    private static final long serialVersionUID = 4211092752933892215L;
    @SerializedName("dialog_switch")
    private int dialogSwitch;
    @SerializedName("hit_black_list")
    private int hitBlacklist;
    private long interval;
    @SerializedName("rules_url")
    private String rulesUrl;
    private String tips;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractClearDialogConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractClearDialogConfig)) {
            return false;
        }
        ContractClearDialogConfig contractClearDialogConfig = (ContractClearDialogConfig) obj;
        if (!contractClearDialogConfig.canEqual(this) || getDialogSwitch() != contractClearDialogConfig.getDialogSwitch() || getInterval() != contractClearDialogConfig.getInterval() || getHitBlacklist() != contractClearDialogConfig.getHitBlacklist()) {
            return false;
        }
        String tips2 = getTips();
        String tips3 = contractClearDialogConfig.getTips();
        if (tips2 != null ? !tips2.equals(tips3) : tips3 != null) {
            return false;
        }
        String rulesUrl2 = getRulesUrl();
        String rulesUrl3 = contractClearDialogConfig.getRulesUrl();
        return rulesUrl2 != null ? rulesUrl2.equals(rulesUrl3) : rulesUrl3 == null;
    }

    public int getDialogSwitch() {
        return this.dialogSwitch;
    }

    public int getHitBlacklist() {
        return this.hitBlacklist;
    }

    public long getInterval() {
        return this.interval;
    }

    public String getRulesUrl() {
        return this.rulesUrl;
    }

    public String getTips() {
        return this.tips;
    }

    public int hashCode() {
        long interval2 = getInterval();
        int dialogSwitch2 = ((((getDialogSwitch() + 59) * 59) + ((int) (interval2 ^ (interval2 >>> 32)))) * 59) + getHitBlacklist();
        String tips2 = getTips();
        int i11 = 43;
        int hashCode = (dialogSwitch2 * 59) + (tips2 == null ? 43 : tips2.hashCode());
        String rulesUrl2 = getRulesUrl();
        int i12 = hashCode * 59;
        if (rulesUrl2 != null) {
            i11 = rulesUrl2.hashCode();
        }
        return i12 + i11;
    }

    public void setDialogSwitch(int i11) {
        this.dialogSwitch = i11;
    }

    public void setHitBlacklist(int i11) {
        this.hitBlacklist = i11;
    }

    public void setInterval(long j11) {
        this.interval = j11;
    }

    public void setRulesUrl(String str) {
        this.rulesUrl = str;
    }

    public void setTips(String str) {
        this.tips = str;
    }

    public String toString() {
        return "ContractClearDialogConfig(dialogSwitch=" + getDialogSwitch() + ", interval=" + getInterval() + ", hitBlacklist=" + getHitBlacklist() + ", tips=" + getTips() + ", rulesUrl=" + getRulesUrl() + ")";
    }
}
