package com.huobi.finance.bean;

import java.util.Map;

public class OtcOptionDataTotal extends BaseAssetTotal {
    private Map<String, Map<String, String>> originAssetData;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcOptionDataTotal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcOptionDataTotal)) {
            return false;
        }
        OtcOptionDataTotal otcOptionDataTotal = (OtcOptionDataTotal) obj;
        if (!otcOptionDataTotal.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        Map<String, Map<String, String>> originAssetData2 = getOriginAssetData();
        Map<String, Map<String, String>> originAssetData3 = otcOptionDataTotal.getOriginAssetData();
        return originAssetData2 != null ? originAssetData2.equals(originAssetData3) : originAssetData3 == null;
    }

    public Map<String, Map<String, String>> getOriginAssetData() {
        return this.originAssetData;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        Map<String, Map<String, String>> originAssetData2 = getOriginAssetData();
        return (hashCode * 59) + (originAssetData2 == null ? 43 : originAssetData2.hashCode());
    }

    public void setOriginAssetData(Map<String, Map<String, String>> map) {
        this.originAssetData = map;
    }

    public String toString() {
        return "OtcOptionDataTotal(originAssetData=" + getOriginAssetData() + ")";
    }
}
