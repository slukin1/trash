package com.huobi.finance.bean;

import com.huobi.finance.viewhandler.OtcOptionsBalanceViewAdapter;

public class OtcOptionsDetailInfo extends BaseAssetInfo {
    public boolean canEqual(Object obj) {
        return obj instanceof OtcOptionsDetailInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof OtcOptionsDetailInfo) && ((OtcOptionsDetailInfo) obj).canEqual(this) && super.equals(obj);
    }

    public String getTitle() {
        return getDisplayName();
    }

    public String getViewHandlerName() {
        return OtcOptionsBalanceViewAdapter.class.getName();
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "OtcOptionsDetailInfo()";
    }
}
