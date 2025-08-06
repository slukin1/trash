package com.huobi.finance.bean;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.huobi.finance.viewhandler.LinearSwapAssetTotalViewHandler;
import java.util.List;

public class LinearSwapDataTotal extends BaseAssetTotal {
    private List<LinearSwapAccountInfo> accountInfoList;
    public String netAssetToUsdt;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapDataTotal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapDataTotal)) {
            return false;
        }
        LinearSwapDataTotal linearSwapDataTotal = (LinearSwapDataTotal) obj;
        if (!linearSwapDataTotal.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        List<LinearSwapAccountInfo> accountInfoList2 = getAccountInfoList();
        List<LinearSwapAccountInfo> accountInfoList3 = linearSwapDataTotal.getAccountInfoList();
        if (accountInfoList2 != null ? !accountInfoList2.equals(accountInfoList3) : accountInfoList3 != null) {
            return false;
        }
        String netAssetToUsdt2 = getNetAssetToUsdt();
        String netAssetToUsdt3 = linearSwapDataTotal.getNetAssetToUsdt();
        return netAssetToUsdt2 != null ? netAssetToUsdt2.equals(netAssetToUsdt3) : netAssetToUsdt3 == null;
    }

    public List<LinearSwapAccountInfo> getAccountInfoList() {
        return this.accountInfoList;
    }

    public String getNetAssetToUsdt() {
        return this.netAssetToUsdt;
    }

    public String getViewHandlerName() {
        return LinearSwapAssetTotalViewHandler.class.getName();
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        List<LinearSwapAccountInfo> accountInfoList2 = getAccountInfoList();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (accountInfoList2 == null ? 43 : accountInfoList2.hashCode());
        String netAssetToUsdt2 = getNetAssetToUsdt();
        int i12 = hashCode2 * 59;
        if (netAssetToUsdt2 != null) {
            i11 = netAssetToUsdt2.hashCode();
        }
        return i12 + i11;
    }

    public void setAccountInfoList(List<LinearSwapAccountInfo> list) {
        this.accountInfoList = list;
    }

    public void setNetAssetToUsdt(String str) {
        this.netAssetToUsdt = str;
    }

    public String toString() {
        return "LinearSwapDataTotal(accountInfoList=" + getAccountInfoList() + ", netAssetToUsdt=" + getNetAssetToUsdt() + ")";
    }
}
