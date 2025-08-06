package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class SpotContractEntryBean implements Serializable {
    public static final int SHOW_TYPE_CONTRACT = 1;
    public static final int SHOW_TYPE_MARGIN_LEVEL = 2;
    public static final int SHOW_TYPE_NONE = 0;
    private String contractCode;
    private int contractMaxLevel;
    private int leverMaxLevel;
    private int positionType;
    private int showType;

    public String getContractCode() {
        return this.contractCode;
    }

    public int getContractMaxLevel() {
        return this.contractMaxLevel;
    }

    public int getLeverMaxLevel() {
        return this.leverMaxLevel;
    }

    public int getPositionType() {
        return this.positionType;
    }

    public int getShowType() {
        return this.showType;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractMaxLevel(int i11) {
        this.contractMaxLevel = i11;
    }

    public void setLeverMaxLevel(int i11) {
        this.leverMaxLevel = i11;
    }

    public void setPositionType(int i11) {
        this.positionType = i11;
    }

    public void setShowType(int i11) {
        this.showType = i11;
    }
}
