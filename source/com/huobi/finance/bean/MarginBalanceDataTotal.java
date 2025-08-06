package com.huobi.finance.bean;

import java.util.Map;

public class MarginBalanceDataTotal extends BaseAssetTotal {
    private Map<String, Map<String, Map<String, String>>> detailAsset;
    public String netLiabilitiesAsset;
    private String netLiabilitiesToBtc;

    public boolean canEqual(Object obj) {
        return obj instanceof MarginBalanceDataTotal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarginBalanceDataTotal)) {
            return false;
        }
        MarginBalanceDataTotal marginBalanceDataTotal = (MarginBalanceDataTotal) obj;
        if (!marginBalanceDataTotal.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        Map<String, Map<String, Map<String, String>>> detailAsset2 = getDetailAsset();
        Map<String, Map<String, Map<String, String>>> detailAsset3 = marginBalanceDataTotal.getDetailAsset();
        if (detailAsset2 != null ? !detailAsset2.equals(detailAsset3) : detailAsset3 != null) {
            return false;
        }
        String netLiabilitiesToBtc2 = getNetLiabilitiesToBtc();
        String netLiabilitiesToBtc3 = marginBalanceDataTotal.getNetLiabilitiesToBtc();
        if (netLiabilitiesToBtc2 != null ? !netLiabilitiesToBtc2.equals(netLiabilitiesToBtc3) : netLiabilitiesToBtc3 != null) {
            return false;
        }
        String netLiabilitiesAsset2 = getNetLiabilitiesAsset();
        String netLiabilitiesAsset3 = marginBalanceDataTotal.getNetLiabilitiesAsset();
        return netLiabilitiesAsset2 != null ? netLiabilitiesAsset2.equals(netLiabilitiesAsset3) : netLiabilitiesAsset3 == null;
    }

    public Map<String, Map<String, Map<String, String>>> getDetailAsset() {
        return this.detailAsset;
    }

    public String getNetLiabilitiesAsset() {
        return this.netLiabilitiesAsset;
    }

    public String getNetLiabilitiesToBtc() {
        return this.netLiabilitiesToBtc;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        Map<String, Map<String, Map<String, String>>> detailAsset2 = getDetailAsset();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (detailAsset2 == null ? 43 : detailAsset2.hashCode());
        String netLiabilitiesToBtc2 = getNetLiabilitiesToBtc();
        int hashCode3 = (hashCode2 * 59) + (netLiabilitiesToBtc2 == null ? 43 : netLiabilitiesToBtc2.hashCode());
        String netLiabilitiesAsset2 = getNetLiabilitiesAsset();
        int i12 = hashCode3 * 59;
        if (netLiabilitiesAsset2 != null) {
            i11 = netLiabilitiesAsset2.hashCode();
        }
        return i12 + i11;
    }

    public void setDetailAsset(Map<String, Map<String, Map<String, String>>> map) {
        this.detailAsset = map;
    }

    public void setNetLiabilitiesAsset(String str) {
        this.netLiabilitiesAsset = str;
    }

    public void setNetLiabilitiesToBtc(String str) {
        this.netLiabilitiesToBtc = str;
    }

    public String toString() {
        return "MarginBalanceDataTotal(detailAsset=" + getDetailAsset() + ", netLiabilitiesToBtc=" + getNetLiabilitiesToBtc() + ", netLiabilitiesAsset=" + getNetLiabilitiesAsset() + ")";
    }
}
