package com.huobi.finance.bean;

import android.text.TextUtils;
import android.util.Base64;
import com.huobi.finance.ui.x2;
import com.huobi.finance.viewhandler.AssetTotalViewHandler;
import i6.m;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import s9.a;

public class BaseAssetTotal implements a, Serializable {
    private static final long serialVersionUID = 6361154256339381705L;
    private List<? extends BaseAssetInfo> detailInfos;
    public boolean isShow;
    public String netAsset;
    public String netAssetToBtc;
    public x2.a showCallback;
    public String title;
    public String totalAsset;
    public String totalAssetToBtc;

    public static String encodeLog(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return Base64.encodeToString(str.getBytes(), 0);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return str;
        }
    }

    public static boolean isZeroAsset(BaseAssetTotal baseAssetTotal) {
        return baseAssetTotal == null || m.a(baseAssetTotal.getNetAsset()).compareTo(BigDecimal.ZERO) == 0;
    }

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
        String totalAssetToBtc2 = getTotalAssetToBtc();
        String totalAssetToBtc3 = baseAssetTotal.getTotalAssetToBtc();
        if (totalAssetToBtc2 != null ? !totalAssetToBtc2.equals(totalAssetToBtc3) : totalAssetToBtc3 != null) {
            return false;
        }
        String totalAsset2 = getTotalAsset();
        String totalAsset3 = baseAssetTotal.getTotalAsset();
        if (totalAsset2 != null ? !totalAsset2.equals(totalAsset3) : totalAsset3 != null) {
            return false;
        }
        String netAssetToBtc2 = getNetAssetToBtc();
        String netAssetToBtc3 = baseAssetTotal.getNetAssetToBtc();
        if (netAssetToBtc2 != null ? !netAssetToBtc2.equals(netAssetToBtc3) : netAssetToBtc3 != null) {
            return false;
        }
        String netAsset2 = getNetAsset();
        String netAsset3 = baseAssetTotal.getNetAsset();
        if (netAsset2 != null ? !netAsset2.equals(netAsset3) : netAsset3 != null) {
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
        if (detailInfos2 != null ? !detailInfos2.equals(detailInfos3) : detailInfos3 != null) {
            return false;
        }
        x2.a showCallback2 = getShowCallback();
        x2.a showCallback3 = baseAssetTotal.getShowCallback();
        return showCallback2 != null ? showCallback2.equals(showCallback3) : showCallback3 == null;
    }

    public List<? extends BaseAssetInfo> getDetailInfos() {
        return this.detailInfos;
    }

    public String getNetAsset() {
        return this.netAsset;
    }

    public String getNetAssetToBtc() {
        return this.netAssetToBtc;
    }

    public x2.a getShowCallback() {
        return this.showCallback;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTotalAsset() {
        return this.totalAsset;
    }

    public String getTotalAssetToBtc() {
        return this.totalAssetToBtc;
    }

    public String getViewHandlerName() {
        return AssetTotalViewHandler.class.getName();
    }

    public int hashCode() {
        String totalAssetToBtc2 = getTotalAssetToBtc();
        int i11 = 43;
        int hashCode = totalAssetToBtc2 == null ? 43 : totalAssetToBtc2.hashCode();
        String totalAsset2 = getTotalAsset();
        int hashCode2 = ((hashCode + 59) * 59) + (totalAsset2 == null ? 43 : totalAsset2.hashCode());
        String netAssetToBtc2 = getNetAssetToBtc();
        int hashCode3 = (hashCode2 * 59) + (netAssetToBtc2 == null ? 43 : netAssetToBtc2.hashCode());
        String netAsset2 = getNetAsset();
        int hashCode4 = (((hashCode3 * 59) + (netAsset2 == null ? 43 : netAsset2.hashCode())) * 59) + (isShow() ? 79 : 97);
        String title2 = getTitle();
        int hashCode5 = (hashCode4 * 59) + (title2 == null ? 43 : title2.hashCode());
        List<? extends BaseAssetInfo> detailInfos2 = getDetailInfos();
        int hashCode6 = (hashCode5 * 59) + (detailInfos2 == null ? 43 : detailInfos2.hashCode());
        x2.a showCallback2 = getShowCallback();
        int i12 = hashCode6 * 59;
        if (showCallback2 != null) {
            i11 = showCallback2.hashCode();
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

    public void setNetAsset(String str) {
        this.netAsset = str;
    }

    public void setNetAssetToBtc(String str) {
        this.netAssetToBtc = str;
    }

    public void setShow(boolean z11) {
        this.isShow = z11;
    }

    public void setShowCallback(x2.a aVar) {
        this.showCallback = aVar;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTotalAsset(String str) {
        this.totalAsset = str;
    }

    public void setTotalAssetToBtc(String str) {
        this.totalAssetToBtc = str;
    }

    public String toString() {
        return "BaseAssetTotal{totalAssetToBtc='" + this.totalAssetToBtc + '\'' + ", totalAsset='" + this.totalAsset + '\'' + ", netAssetToBtc='" + this.netAssetToBtc + '\'' + ", netAsset='" + this.netAsset + '\'' + ", isShow=" + this.isShow + ", title='" + this.title + '\'' + '}';
    }

    public String toTotalString() {
        return encodeLog("BaseAssetTotal{totalAssetToBtc='" + this.totalAssetToBtc + '\'' + ", totalAsset='" + this.totalAsset + '\'' + ", netAssetToBtc='" + this.netAssetToBtc + '\'' + ", netAsset='" + this.netAsset + '\'' + ", isShow=" + this.isShow + ", title='" + this.title + '\'' + '}');
    }
}
