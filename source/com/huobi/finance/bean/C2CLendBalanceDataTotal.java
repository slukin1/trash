package com.huobi.finance.bean;

import java.util.List;
import java.util.Map;

public class C2CLendBalanceDataTotal extends BaseAssetTotal {
    private Map<String, Map<String, Map<String, String>>> detailAsset;
    private List<C2CLendBalanceDetailInfo> detailInfoList;

    public boolean canEqual(Object obj) {
        return obj instanceof C2CLendBalanceDataTotal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2CLendBalanceDataTotal)) {
            return false;
        }
        C2CLendBalanceDataTotal c2CLendBalanceDataTotal = (C2CLendBalanceDataTotal) obj;
        if (!c2CLendBalanceDataTotal.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        Map<String, Map<String, Map<String, String>>> detailAsset2 = getDetailAsset();
        Map<String, Map<String, Map<String, String>>> detailAsset3 = c2CLendBalanceDataTotal.getDetailAsset();
        if (detailAsset2 != null ? !detailAsset2.equals(detailAsset3) : detailAsset3 != null) {
            return false;
        }
        List<C2CLendBalanceDetailInfo> detailInfoList2 = getDetailInfoList();
        List<C2CLendBalanceDetailInfo> detailInfoList3 = c2CLendBalanceDataTotal.getDetailInfoList();
        return detailInfoList2 != null ? detailInfoList2.equals(detailInfoList3) : detailInfoList3 == null;
    }

    public Map<String, Map<String, Map<String, String>>> getDetailAsset() {
        return this.detailAsset;
    }

    public List<C2CLendBalanceDetailInfo> getDetailInfoList() {
        return this.detailInfoList;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        Map<String, Map<String, Map<String, String>>> detailAsset2 = getDetailAsset();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (detailAsset2 == null ? 43 : detailAsset2.hashCode());
        List<C2CLendBalanceDetailInfo> detailInfoList2 = getDetailInfoList();
        int i12 = hashCode2 * 59;
        if (detailInfoList2 != null) {
            i11 = detailInfoList2.hashCode();
        }
        return i12 + i11;
    }

    public void setDetailAsset(Map<String, Map<String, Map<String, String>>> map) {
        this.detailAsset = map;
    }

    public void setDetailInfoList(List<C2CLendBalanceDetailInfo> list) {
        this.detailInfoList = list;
    }

    public String toString() {
        return "C2CLendBalanceDataTotal(detailAsset=" + getDetailAsset() + ", detailInfoList=" + getDetailInfoList() + ")";
    }
}
