package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class BlockInfoBean implements Serializable {
    private String currency;

    public boolean canEqual(Object obj) {
        return obj instanceof BlockInfoBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BlockInfoBean)) {
            return false;
        }
        BlockInfoBean blockInfoBean = (BlockInfoBean) obj;
        if (!blockInfoBean.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = blockInfoBean.getCurrency();
        return currency2 != null ? currency2.equals(currency3) : currency3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        return 59 + (currency2 == null ? 43 : currency2.hashCode());
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String toString() {
        return "BlockInfoBean(currency=" + getCurrency() + ")";
    }
}
