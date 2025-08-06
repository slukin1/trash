package com.huobi.finance.bean;

import com.hbg.lib.network.hbg.core.bean.YbbUserAssetInfoData;
import com.huobi.finance.viewhandler.AssetTotalBalanceViewHandler;
import java.util.Map;

public class BalanceDataTotal extends BaseAssetTotal {
    private Map<String, Map<String, String>> detailAsset;
    private Map<String, BalanceDetailInfo> detailInfoMap;
    private YbbUserAssetInfoData ybbAsset;

    public boolean canEqual(Object obj) {
        return obj instanceof BalanceDataTotal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BalanceDataTotal)) {
            return false;
        }
        BalanceDataTotal balanceDataTotal = (BalanceDataTotal) obj;
        if (!balanceDataTotal.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        Map<String, Map<String, String>> detailAsset2 = getDetailAsset();
        Map<String, Map<String, String>> detailAsset3 = balanceDataTotal.getDetailAsset();
        if (detailAsset2 != null ? !detailAsset2.equals(detailAsset3) : detailAsset3 != null) {
            return false;
        }
        Map<String, BalanceDetailInfo> detailInfoMap2 = getDetailInfoMap();
        Map<String, BalanceDetailInfo> detailInfoMap3 = balanceDataTotal.getDetailInfoMap();
        if (detailInfoMap2 != null ? !detailInfoMap2.equals(detailInfoMap3) : detailInfoMap3 != null) {
            return false;
        }
        YbbUserAssetInfoData ybbAsset2 = getYbbAsset();
        YbbUserAssetInfoData ybbAsset3 = balanceDataTotal.getYbbAsset();
        return ybbAsset2 != null ? ybbAsset2.equals(ybbAsset3) : ybbAsset3 == null;
    }

    public Map<String, Map<String, String>> getDetailAsset() {
        return this.detailAsset;
    }

    public Map<String, BalanceDetailInfo> getDetailInfoMap() {
        return this.detailInfoMap;
    }

    public String getViewHandlerName() {
        return AssetTotalBalanceViewHandler.class.getName();
    }

    public YbbUserAssetInfoData getYbbAsset() {
        return this.ybbAsset;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        Map<String, Map<String, String>> detailAsset2 = getDetailAsset();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (detailAsset2 == null ? 43 : detailAsset2.hashCode());
        Map<String, BalanceDetailInfo> detailInfoMap2 = getDetailInfoMap();
        int hashCode3 = (hashCode2 * 59) + (detailInfoMap2 == null ? 43 : detailInfoMap2.hashCode());
        YbbUserAssetInfoData ybbAsset2 = getYbbAsset();
        int i12 = hashCode3 * 59;
        if (ybbAsset2 != null) {
            i11 = ybbAsset2.hashCode();
        }
        return i12 + i11;
    }

    public void setDetailAsset(Map<String, Map<String, String>> map) {
        this.detailAsset = map;
    }

    public void setDetailInfoMap(Map<String, BalanceDetailInfo> map) {
        this.detailInfoMap = map;
    }

    public void setYbbAsset(YbbUserAssetInfoData ybbUserAssetInfoData) {
        this.ybbAsset = ybbUserAssetInfoData;
    }

    public String toString() {
        return "BalanceDataTotal(detailAsset=" + getDetailAsset() + ", detailInfoMap=" + getDetailInfoMap() + ", ybbAsset=" + getYbbAsset() + ")";
    }
}
