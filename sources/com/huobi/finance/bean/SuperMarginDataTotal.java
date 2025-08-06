package com.huobi.finance.bean;

import com.huobi.supermargin.bean.MarginOverview;
import java.util.Map;

public class SuperMarginDataTotal extends BaseAssetTotal {
    private Map<String, Map<String, String>> detailAsset;
    private Map<String, SuperMarginDetailInfo> detailMap;
    private MarginOverview marginOverview;

    public boolean canEqual(Object obj) {
        return obj instanceof SuperMarginDataTotal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SuperMarginDataTotal)) {
            return false;
        }
        SuperMarginDataTotal superMarginDataTotal = (SuperMarginDataTotal) obj;
        if (!superMarginDataTotal.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        Map<String, Map<String, String>> detailAsset2 = getDetailAsset();
        Map<String, Map<String, String>> detailAsset3 = superMarginDataTotal.getDetailAsset();
        if (detailAsset2 != null ? !detailAsset2.equals(detailAsset3) : detailAsset3 != null) {
            return false;
        }
        Map<String, SuperMarginDetailInfo> detailMap2 = getDetailMap();
        Map<String, SuperMarginDetailInfo> detailMap3 = superMarginDataTotal.getDetailMap();
        if (detailMap2 != null ? !detailMap2.equals(detailMap3) : detailMap3 != null) {
            return false;
        }
        MarginOverview marginOverview2 = getMarginOverview();
        MarginOverview marginOverview3 = superMarginDataTotal.getMarginOverview();
        return marginOverview2 != null ? marginOverview2.equals(marginOverview3) : marginOverview3 == null;
    }

    public Map<String, Map<String, String>> getDetailAsset() {
        return this.detailAsset;
    }

    public Map<String, SuperMarginDetailInfo> getDetailMap() {
        return this.detailMap;
    }

    public MarginOverview getMarginOverview() {
        return this.marginOverview;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        Map<String, Map<String, String>> detailAsset2 = getDetailAsset();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (detailAsset2 == null ? 43 : detailAsset2.hashCode());
        Map<String, SuperMarginDetailInfo> detailMap2 = getDetailMap();
        int hashCode3 = (hashCode2 * 59) + (detailMap2 == null ? 43 : detailMap2.hashCode());
        MarginOverview marginOverview2 = getMarginOverview();
        int i12 = hashCode3 * 59;
        if (marginOverview2 != null) {
            i11 = marginOverview2.hashCode();
        }
        return i12 + i11;
    }

    public void setDetailAsset(Map<String, Map<String, String>> map) {
        this.detailAsset = map;
    }

    public void setDetailMap(Map<String, SuperMarginDetailInfo> map) {
        this.detailMap = map;
    }

    public void setMarginOverview(MarginOverview marginOverview2) {
        this.marginOverview = marginOverview2;
    }

    public String toString() {
        return "SuperMarginDataTotal(detailAsset=" + getDetailAsset() + ", detailMap=" + getDetailMap() + ", marginOverview=" + getMarginOverview() + ")";
    }
}
