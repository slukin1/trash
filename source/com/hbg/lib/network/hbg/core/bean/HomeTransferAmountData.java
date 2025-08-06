package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class HomeTransferAmountData implements Serializable {
    private String desc;
    private int isTransfer;
    private String title;

    public boolean canEqual(Object obj) {
        return obj instanceof HomeTransferAmountData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HomeTransferAmountData)) {
            return false;
        }
        HomeTransferAmountData homeTransferAmountData = (HomeTransferAmountData) obj;
        if (!homeTransferAmountData.canEqual(this) || getIsTransfer() != homeTransferAmountData.getIsTransfer()) {
            return false;
        }
        String title2 = getTitle();
        String title3 = homeTransferAmountData.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String desc2 = getDesc();
        String desc3 = homeTransferAmountData.getDesc();
        return desc2 != null ? desc2.equals(desc3) : desc3 == null;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIsTransfer() {
        return this.isTransfer;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String title2 = getTitle();
        int i11 = 43;
        int isTransfer2 = ((getIsTransfer() + 59) * 59) + (title2 == null ? 43 : title2.hashCode());
        String desc2 = getDesc();
        int i12 = isTransfer2 * 59;
        if (desc2 != null) {
            i11 = desc2.hashCode();
        }
        return i12 + i11;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIsTransfer(int i11) {
        this.isTransfer = i11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "HomeTransferAmountData{isTransfer=" + this.isTransfer + ", title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + '}';
    }
}
