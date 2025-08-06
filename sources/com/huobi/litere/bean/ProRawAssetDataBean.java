package com.huobi.litere.bean;

import com.huobi.account.entity.BalanceQueryData;
import java.io.Serializable;

public class ProRawAssetDataBean implements Serializable {
    private BalanceQueryData data;
    private String status;

    public boolean canEqual(Object obj) {
        return obj instanceof ProRawAssetDataBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProRawAssetDataBean)) {
            return false;
        }
        ProRawAssetDataBean proRawAssetDataBean = (ProRawAssetDataBean) obj;
        if (!proRawAssetDataBean.canEqual(this)) {
            return false;
        }
        String status2 = getStatus();
        String status3 = proRawAssetDataBean.getStatus();
        if (status2 != null ? !status2.equals(status3) : status3 != null) {
            return false;
        }
        BalanceQueryData data2 = getData();
        BalanceQueryData data3 = proRawAssetDataBean.getData();
        return data2 != null ? data2.equals(data3) : data3 == null;
    }

    public BalanceQueryData getData() {
        return this.data;
    }

    public String getStatus() {
        return this.status;
    }

    public int hashCode() {
        String status2 = getStatus();
        int i11 = 43;
        int hashCode = status2 == null ? 43 : status2.hashCode();
        BalanceQueryData data2 = getData();
        int i12 = (hashCode + 59) * 59;
        if (data2 != null) {
            i11 = data2.hashCode();
        }
        return i12 + i11;
    }

    public void setData(BalanceQueryData balanceQueryData) {
        this.data = balanceQueryData;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        return "ProRawAssetDataBean(status=" + getStatus() + ", data=" + getData() + ")";
    }
}
