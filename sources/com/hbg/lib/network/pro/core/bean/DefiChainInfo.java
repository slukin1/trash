package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;

public class DefiChainInfo implements Serializable {
    public static final String CHAIN_BSC = "BSC";
    public static final String CHAIN_ETH = "ETH";
    public static final String CHAIN_HECO = "HECO";
    public static final String CHAIN_OKT = "OKT";
    private String addressIcon;
    private String chain;
    private String desc;
    private String leftColor;
    private String rightColor;
    private String selectIcon;
    private String unSelectIcon;
    private String unSelectIconNight;

    public boolean canEqual(Object obj) {
        return obj instanceof DefiChainInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DefiChainInfo)) {
            return false;
        }
        DefiChainInfo defiChainInfo = (DefiChainInfo) obj;
        if (!defiChainInfo.canEqual(this)) {
            return false;
        }
        String chain2 = getChain();
        String chain3 = defiChainInfo.getChain();
        if (chain2 != null ? !chain2.equals(chain3) : chain3 != null) {
            return false;
        }
        String unSelectIcon2 = getUnSelectIcon();
        String unSelectIcon3 = defiChainInfo.getUnSelectIcon();
        if (unSelectIcon2 != null ? !unSelectIcon2.equals(unSelectIcon3) : unSelectIcon3 != null) {
            return false;
        }
        String unSelectIconNight2 = getUnSelectIconNight();
        String unSelectIconNight3 = defiChainInfo.getUnSelectIconNight();
        if (unSelectIconNight2 != null ? !unSelectIconNight2.equals(unSelectIconNight3) : unSelectIconNight3 != null) {
            return false;
        }
        String selectIcon2 = getSelectIcon();
        String selectIcon3 = defiChainInfo.getSelectIcon();
        if (selectIcon2 != null ? !selectIcon2.equals(selectIcon3) : selectIcon3 != null) {
            return false;
        }
        String leftColor2 = getLeftColor();
        String leftColor3 = defiChainInfo.getLeftColor();
        if (leftColor2 != null ? !leftColor2.equals(leftColor3) : leftColor3 != null) {
            return false;
        }
        String rightColor2 = getRightColor();
        String rightColor3 = defiChainInfo.getRightColor();
        if (rightColor2 != null ? !rightColor2.equals(rightColor3) : rightColor3 != null) {
            return false;
        }
        String addressIcon2 = getAddressIcon();
        String addressIcon3 = defiChainInfo.getAddressIcon();
        if (addressIcon2 != null ? !addressIcon2.equals(addressIcon3) : addressIcon3 != null) {
            return false;
        }
        String desc2 = getDesc();
        String desc3 = defiChainInfo.getDesc();
        return desc2 != null ? desc2.equals(desc3) : desc3 == null;
    }

    public String getAddressIcon() {
        return this.addressIcon;
    }

    public String getChain() {
        return this.chain;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getLeftColor() {
        return this.leftColor;
    }

    public String getRightColor() {
        return this.rightColor;
    }

    public String getSelectIcon() {
        return this.selectIcon;
    }

    public String getUnSelectIcon() {
        return this.unSelectIcon;
    }

    public String getUnSelectIconNight() {
        return this.unSelectIconNight;
    }

    public int hashCode() {
        String chain2 = getChain();
        int i11 = 43;
        int hashCode = chain2 == null ? 43 : chain2.hashCode();
        String unSelectIcon2 = getUnSelectIcon();
        int hashCode2 = ((hashCode + 59) * 59) + (unSelectIcon2 == null ? 43 : unSelectIcon2.hashCode());
        String unSelectIconNight2 = getUnSelectIconNight();
        int hashCode3 = (hashCode2 * 59) + (unSelectIconNight2 == null ? 43 : unSelectIconNight2.hashCode());
        String selectIcon2 = getSelectIcon();
        int hashCode4 = (hashCode3 * 59) + (selectIcon2 == null ? 43 : selectIcon2.hashCode());
        String leftColor2 = getLeftColor();
        int hashCode5 = (hashCode4 * 59) + (leftColor2 == null ? 43 : leftColor2.hashCode());
        String rightColor2 = getRightColor();
        int hashCode6 = (hashCode5 * 59) + (rightColor2 == null ? 43 : rightColor2.hashCode());
        String addressIcon2 = getAddressIcon();
        int hashCode7 = (hashCode6 * 59) + (addressIcon2 == null ? 43 : addressIcon2.hashCode());
        String desc2 = getDesc();
        int i12 = hashCode7 * 59;
        if (desc2 != null) {
            i11 = desc2.hashCode();
        }
        return i12 + i11;
    }

    public void setAddressIcon(String str) {
        this.addressIcon = str;
    }

    public void setChain(String str) {
        this.chain = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setLeftColor(String str) {
        this.leftColor = str;
    }

    public void setRightColor(String str) {
        this.rightColor = str;
    }

    public void setSelectIcon(String str) {
        this.selectIcon = str;
    }

    public void setUnSelectIcon(String str) {
        this.unSelectIcon = str;
    }

    public void setUnSelectIconNight(String str) {
        this.unSelectIconNight = str;
    }

    public String toString() {
        return "DefiChainInfo(chain=" + getChain() + ", unSelectIcon=" + getUnSelectIcon() + ", unSelectIconNight=" + getUnSelectIconNight() + ", selectIcon=" + getSelectIcon() + ", leftColor=" + getLeftColor() + ", rightColor=" + getRightColor() + ", addressIcon=" + getAddressIcon() + ", desc=" + getDesc() + ")";
    }
}
