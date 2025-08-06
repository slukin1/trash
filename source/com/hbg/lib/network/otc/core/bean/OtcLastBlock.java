package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcLastBlock implements Serializable {
    private int blockType;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcLastBlock;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcLastBlock)) {
            return false;
        }
        OtcLastBlock otcLastBlock = (OtcLastBlock) obj;
        return otcLastBlock.canEqual(this) && getBlockType() == otcLastBlock.getBlockType();
    }

    public int getBlockType() {
        return this.blockType;
    }

    public int hashCode() {
        return 59 + getBlockType();
    }

    public boolean isFastTrade() {
        return this.blockType == 4;
    }

    public void setBlockType(int i11) {
        this.blockType = i11;
    }

    public String toString() {
        return "OtcLastBlock(blockType=" + getBlockType() + ")";
    }
}
