package com.huobi.litere.bean;

import com.huobi.litere.trade.callback.OtcBalanceDataItem;
import java.io.Serializable;
import java.util.List;

public class OtcRawAssetDataBean implements Serializable {
    private int code;
    private List<OtcBalanceDataItem> data;
    private String message;
    private boolean success;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcRawAssetDataBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcRawAssetDataBean)) {
            return false;
        }
        OtcRawAssetDataBean otcRawAssetDataBean = (OtcRawAssetDataBean) obj;
        if (!otcRawAssetDataBean.canEqual(this) || isSuccess() != otcRawAssetDataBean.isSuccess() || getCode() != otcRawAssetDataBean.getCode()) {
            return false;
        }
        String message2 = getMessage();
        String message3 = otcRawAssetDataBean.getMessage();
        if (message2 != null ? !message2.equals(message3) : message3 != null) {
            return false;
        }
        List<OtcBalanceDataItem> data2 = getData();
        List<OtcBalanceDataItem> data3 = otcRawAssetDataBean.getData();
        return data2 != null ? data2.equals(data3) : data3 == null;
    }

    public int getCode() {
        return this.code;
    }

    public List<OtcBalanceDataItem> getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int code2 = (((isSuccess() ? 79 : 97) + 59) * 59) + getCode();
        String message2 = getMessage();
        int i11 = 43;
        int hashCode = (code2 * 59) + (message2 == null ? 43 : message2.hashCode());
        List<OtcBalanceDataItem> data2 = getData();
        int i12 = hashCode * 59;
        if (data2 != null) {
            i11 = data2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setData(List<OtcBalanceDataItem> list) {
        this.data = list;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSuccess(boolean z11) {
        this.success = z11;
    }

    public String toString() {
        return "OtcRawAssetDataBean(success=" + isSuccess() + ", code=" + getCode() + ", message=" + getMessage() + ", data=" + getData() + ")";
    }
}
