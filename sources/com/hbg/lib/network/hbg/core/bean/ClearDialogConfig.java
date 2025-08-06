package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class ClearDialogConfig implements Serializable {
    public static final int DIALOG_SWITCH_AFTER = 2;
    public static final int DIALOG_SWITCH_CLOSE = 0;
    public static final int DIALOG_SWITCH_FRONT = 1;
    public static final int IN_BLACK_LIST = 1;
    public static final int OUT_BLACK_LIST = 0;
    private static final long serialVersionUID = 4211092752933892215L;
    private int dialogSwitch;
    private int hitBlacklist;
    private long interval;
    private String rulesUrl;
    private String tips;

    public boolean canEqual(Object obj) {
        return obj instanceof ClearDialogConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClearDialogConfig)) {
            return false;
        }
        ClearDialogConfig clearDialogConfig = (ClearDialogConfig) obj;
        if (!clearDialogConfig.canEqual(this) || getDialogSwitch() != clearDialogConfig.getDialogSwitch() || getInterval() != clearDialogConfig.getInterval() || getHitBlacklist() != clearDialogConfig.getHitBlacklist()) {
            return false;
        }
        String tips2 = getTips();
        String tips3 = clearDialogConfig.getTips();
        if (tips2 != null ? !tips2.equals(tips3) : tips3 != null) {
            return false;
        }
        String rulesUrl2 = getRulesUrl();
        String rulesUrl3 = clearDialogConfig.getRulesUrl();
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
        return "ClearDialogConfig(dialogSwitch=" + getDialogSwitch() + ", interval=" + getInterval() + ", hitBlacklist=" + getHitBlacklist() + ", tips=" + getTips() + ", rulesUrl=" + getRulesUrl() + ")";
    }
}
