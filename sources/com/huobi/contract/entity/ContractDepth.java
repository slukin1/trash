package com.huobi.contract.entity;

import java.io.Serializable;

public class ContractDepth implements Serializable {
    private String depth;
    private String priceTick;
    private String step;

    public ContractDepth(String str, String str2) {
        this.priceTick = str2;
        this.step = str;
    }

    public String getDepth() {
        return this.depth;
    }

    public String getPriceTick() {
        return this.priceTick;
    }

    public String getStep() {
        return this.step;
    }

    public void setDepth(String str) {
        this.depth = str;
    }

    public void setPriceTick(String str) {
        this.priceTick = str;
    }

    public void setStep(String str) {
        this.step = str;
    }
}
