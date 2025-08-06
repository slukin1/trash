package com.hbg.lite.wallet.bean;

import java.io.Serializable;
import java.util.List;

public class BaseAssetTotal implements Serializable {
    private static final long serialVersionUID = 6361154256339381705L;
    private List<? extends BaseAssetInfo> detailInfos;
    public boolean isShow = true;
    public String netAssetLegal;
    public String netAssetToBtc;
    public String netAssetToUsdt;
    public String title;

    public boolean canEqual(Object obj) {
        return obj instanceof BaseAssetTotal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseAssetTotal)) {
            return false;
        }
        BaseAssetTotal baseAssetTotal = (BaseAssetTotal) obj;
        if (!baseAssetTotal.canEqual(this)) {
            return false;
        }
        String netAssetToBtc2 = getNetAssetToBtc();
        String netAssetToBtc3 = baseAssetTotal.getNetAssetToBtc();
        if (netAssetToBtc2 != null ? !netAssetToBtc2.equals(netAssetToBtc3) : netAssetToBtc3 != null) {
            return false;
        }
        String netAssetToUsdt2 = getNetAssetToUsdt();
        String netAssetToUsdt3 = baseAssetTotal.getNetAssetToUsdt();
        if (netAssetToUsdt2 != null ? !netAssetToUsdt2.equals(netAssetToUsdt3) : netAssetToUsdt3 != null) {
            return false;
        }
        String netAssetLegal2 = getNetAssetLegal();
        String netAssetLegal3 = baseAssetTotal.getNetAssetLegal();
        if (netAssetLegal2 != null ? !netAssetLegal2.equals(netAssetLegal3) : netAssetLegal3 != null) {
            return false;
        }
        if (isShow() != baseAssetTotal.isShow()) {
            return false;
        }
        String title2 = getTitle();
        String title3 = baseAssetTotal.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        List<? extends BaseAssetInfo> detailInfos2 = getDetailInfos();
        List<? extends BaseAssetInfo> detailInfos3 = baseAssetTotal.getDetailInfos();
        return detailInfos2 != null ? detailInfos2.equals(detailInfos3) : detailInfos3 == null;
    }

    public List<? extends BaseAssetInfo> getDetailInfos() {
        return this.detailInfos;
    }

    public String getNetAssetLegal() {
        return this.netAssetLegal;
    }

    public String getNetAssetToBtc() {
        return this.netAssetToBtc;
    }

    public String getNetAssetToUsdt() {
        return this.netAssetToUsdt;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String netAssetToBtc2 = getNetAssetToBtc();
        int i11 = 43;
        int hashCode = netAssetToBtc2 == null ? 43 : netAssetToBtc2.hashCode();
        String netAssetToUsdt2 = getNetAssetToUsdt();
        int hashCode2 = ((hashCode + 59) * 59) + (netAssetToUsdt2 == null ? 43 : netAssetToUsdt2.hashCode());
        String netAssetLegal2 = getNetAssetLegal();
        int hashCode3 = (((hashCode2 * 59) + (netAssetLegal2 == null ? 43 : netAssetLegal2.hashCode())) * 59) + (isShow() ? 79 : 97);
        String title2 = getTitle();
        int hashCode4 = (hashCode3 * 59) + (title2 == null ? 43 : title2.hashCode());
        List<? extends BaseAssetInfo> detailInfos2 = getDetailInfos();
        int i12 = hashCode4 * 59;
        if (detailInfos2 != null) {
            i11 = detailInfos2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isShow() {
        return this.isShow;
    }

    public boolean isValid() {
        return this.detailInfos != null;
    }

    public void setDetailInfos(List<? extends BaseAssetInfo> list) {
        this.detailInfos = list;
    }

    public void setNetAssetLegal(String str) {
        this.netAssetLegal = str;
    }

    public void setNetAssetToBtc(String str) {
        this.netAssetToBtc = str;
    }

    public void setNetAssetToUsdt(String str) {
        this.netAssetToUsdt = str;
    }

    public void setShow(boolean z11) {
        this.isShow = z11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "BaseAssetTotal(netAssetToBtc=" + getNetAssetToBtc() + ", netAssetToUsdt=" + getNetAssetToUsdt() + ", netAssetLegal=" + getNetAssetLegal() + ", isShow=" + isShow() + ", title=" + getTitle() + ", detailInfos=" + getDetailInfos() + ")";
    }
}
