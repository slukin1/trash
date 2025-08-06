package com.huobi.finance.bean;

import com.hbg.lib.network.pro.core.bean.DefiBoxAsset;
import com.hbg.lib.network.pro.core.bean.UserAddrInfo;
import java.util.List;

public class OnChainDataTotal extends BaseAssetTotal {
    private DefiBoxAsset defiBoxAsset;
    private UserAddrInfo selectedAddr;
    private List<UserAddrInfo> userAddrInfoList;

    public boolean canEqual(Object obj) {
        return obj instanceof OnChainDataTotal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OnChainDataTotal)) {
            return false;
        }
        OnChainDataTotal onChainDataTotal = (OnChainDataTotal) obj;
        if (!onChainDataTotal.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        List<UserAddrInfo> userAddrInfoList2 = getUserAddrInfoList();
        List<UserAddrInfo> userAddrInfoList3 = onChainDataTotal.getUserAddrInfoList();
        if (userAddrInfoList2 != null ? !userAddrInfoList2.equals(userAddrInfoList3) : userAddrInfoList3 != null) {
            return false;
        }
        UserAddrInfo selectedAddr2 = getSelectedAddr();
        UserAddrInfo selectedAddr3 = onChainDataTotal.getSelectedAddr();
        if (selectedAddr2 != null ? !selectedAddr2.equals(selectedAddr3) : selectedAddr3 != null) {
            return false;
        }
        DefiBoxAsset defiBoxAsset2 = getDefiBoxAsset();
        DefiBoxAsset defiBoxAsset3 = onChainDataTotal.getDefiBoxAsset();
        return defiBoxAsset2 != null ? defiBoxAsset2.equals(defiBoxAsset3) : defiBoxAsset3 == null;
    }

    public DefiBoxAsset getDefiBoxAsset() {
        return this.defiBoxAsset;
    }

    public UserAddrInfo getSelectedAddr() {
        return this.selectedAddr;
    }

    public List<UserAddrInfo> getUserAddrInfoList() {
        return this.userAddrInfoList;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        List<UserAddrInfo> userAddrInfoList2 = getUserAddrInfoList();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (userAddrInfoList2 == null ? 43 : userAddrInfoList2.hashCode());
        UserAddrInfo selectedAddr2 = getSelectedAddr();
        int hashCode3 = (hashCode2 * 59) + (selectedAddr2 == null ? 43 : selectedAddr2.hashCode());
        DefiBoxAsset defiBoxAsset2 = getDefiBoxAsset();
        int i12 = hashCode3 * 59;
        if (defiBoxAsset2 != null) {
            i11 = defiBoxAsset2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isAvailable() {
        UserAddrInfo userAddrInfo = this.selectedAddr;
        boolean z11 = userAddrInfo == null && this.defiBoxAsset == null;
        boolean z12 = (userAddrInfo == null || this.defiBoxAsset == null) ? false : true;
        if (z11 || z12) {
            return true;
        }
        return false;
    }

    public void setDefiBoxAsset(DefiBoxAsset defiBoxAsset2) {
        this.defiBoxAsset = defiBoxAsset2;
    }

    public void setSelectedAddr(UserAddrInfo userAddrInfo) {
        this.selectedAddr = userAddrInfo;
    }

    public void setUserAddrInfoList(List<UserAddrInfo> list) {
        this.userAddrInfoList = list;
    }

    public String toString() {
        return "OnChainDataTotal(userAddrInfoList=" + getUserAddrInfoList() + ", selectedAddr=" + getSelectedAddr() + ", defiBoxAsset=" + getDefiBoxAsset() + ")";
    }
}
