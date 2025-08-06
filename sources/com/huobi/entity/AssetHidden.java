package com.huobi.entity;

import java.io.Serializable;

public class AssetHidden implements Serializable {
    private int isHidden;

    public AssetHidden(int i11) {
        this.isHidden = i11;
    }

    public int isHidden() {
        return this.isHidden;
    }

    public void setHidden(int i11) {
        this.isHidden = i11;
    }
}
