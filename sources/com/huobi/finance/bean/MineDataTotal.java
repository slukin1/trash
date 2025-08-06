package com.huobi.finance.bean;

import java.util.Map;

public class MineDataTotal extends BaseAssetTotal {
    private Map<String, Map<String, String>> detailAsset;

    public boolean canEqual(Object obj) {
        return obj instanceof MineDataTotal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MineDataTotal)) {
            return false;
        }
        MineDataTotal mineDataTotal = (MineDataTotal) obj;
        if (!mineDataTotal.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        Map<String, Map<String, String>> detailAsset2 = getDetailAsset();
        Map<String, Map<String, String>> detailAsset3 = mineDataTotal.getDetailAsset();
        return detailAsset2 != null ? detailAsset2.equals(detailAsset3) : detailAsset3 == null;
    }

    public Map<String, Map<String, String>> getDetailAsset() {
        return this.detailAsset;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        Map<String, Map<String, String>> detailAsset2 = getDetailAsset();
        return (hashCode * 59) + (detailAsset2 == null ? 43 : detailAsset2.hashCode());
    }

    public void setDetailAsset(Map<String, Map<String, String>> map) {
        this.detailAsset = map;
    }

    public String toString() {
        return "MineDataTotal(detailAsset=" + getDetailAsset() + ")";
    }
}
