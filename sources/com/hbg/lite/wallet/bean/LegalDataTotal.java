package com.hbg.lite.wallet.bean;

import java.util.Map;

public class LegalDataTotal extends BaseAssetTotal {
    private Map<Integer, Map<Integer, String>> detailAsset;
    private String totalBurrow;

    public boolean canEqual(Object obj) {
        return obj instanceof LegalDataTotal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LegalDataTotal)) {
            return false;
        }
        LegalDataTotal legalDataTotal = (LegalDataTotal) obj;
        if (!legalDataTotal.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String totalBurrow2 = getTotalBurrow();
        String totalBurrow3 = legalDataTotal.getTotalBurrow();
        if (totalBurrow2 != null ? !totalBurrow2.equals(totalBurrow3) : totalBurrow3 != null) {
            return false;
        }
        Map<Integer, Map<Integer, String>> detailAsset2 = getDetailAsset();
        Map<Integer, Map<Integer, String>> detailAsset3 = legalDataTotal.getDetailAsset();
        return detailAsset2 != null ? detailAsset2.equals(detailAsset3) : detailAsset3 == null;
    }

    public Map<Integer, Map<Integer, String>> getDetailAsset() {
        return this.detailAsset;
    }

    public String getTotalBurrow() {
        return this.totalBurrow;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String totalBurrow2 = getTotalBurrow();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (totalBurrow2 == null ? 43 : totalBurrow2.hashCode());
        Map<Integer, Map<Integer, String>> detailAsset2 = getDetailAsset();
        int i12 = hashCode2 * 59;
        if (detailAsset2 != null) {
            i11 = detailAsset2.hashCode();
        }
        return i12 + i11;
    }

    public void setDetailAsset(Map<Integer, Map<Integer, String>> map) {
        this.detailAsset = map;
    }

    public void setTotalBurrow(String str) {
        this.totalBurrow = str;
    }

    public String toString() {
        return "LegalDataTotal(totalBurrow=" + getTotalBurrow() + ", detailAsset=" + getDetailAsset() + ")";
    }
}
