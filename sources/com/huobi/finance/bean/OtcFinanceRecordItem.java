package com.huobi.finance.bean;

import com.huobi.finance.viewhandler.OtcCurrencyRecordViewHandler;
import java.io.Serializable;
import s9.a;

public class OtcFinanceRecordItem implements a, Serializable {
    public static final int MAIN_COINNAME = 1;
    public static final int MAIN_STATUS = 0;
    public static final int RECORD_BUY = 3;
    public static final int RECORD_DEPOSIT = 7;
    public static final int RECORD_FEE_MAKER = 46;
    public static final int RECORD_FEE_TAKER = 45;
    public static final int RECORD_IN = 5;
    public static final int RECORD_LEGAL = 43;
    public static final int RECORD_OUT = 6;
    public static final int RECORD_SELL = 2;
    private String cashFreeFlow;
    private int coinId;
    private long gmtCreate;
    private int layoutType;
    private int type;
    private String uid;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcFinanceRecordItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcFinanceRecordItem)) {
            return false;
        }
        OtcFinanceRecordItem otcFinanceRecordItem = (OtcFinanceRecordItem) obj;
        if (!otcFinanceRecordItem.canEqual(this)) {
            return false;
        }
        String cashFreeFlow2 = getCashFreeFlow();
        String cashFreeFlow3 = otcFinanceRecordItem.getCashFreeFlow();
        if (cashFreeFlow2 != null ? !cashFreeFlow2.equals(cashFreeFlow3) : cashFreeFlow3 != null) {
            return false;
        }
        if (getCoinId() != otcFinanceRecordItem.getCoinId() || getGmtCreate() != otcFinanceRecordItem.getGmtCreate() || getType() != otcFinanceRecordItem.getType()) {
            return false;
        }
        String uid2 = getUid();
        String uid3 = otcFinanceRecordItem.getUid();
        if (uid2 != null ? uid2.equals(uid3) : uid3 == null) {
            return getLayoutType() == otcFinanceRecordItem.getLayoutType();
        }
        return false;
    }

    public String getCashFreeFlow() {
        return this.cashFreeFlow;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public long getGmtCreate() {
        return this.gmtCreate;
    }

    public int getLayoutType() {
        return this.layoutType;
    }

    public int getType() {
        return this.type;
    }

    public String getUid() {
        return this.uid;
    }

    public String getViewHandlerName() {
        return OtcCurrencyRecordViewHandler.class.getName();
    }

    public int hashCode() {
        String cashFreeFlow2 = getCashFreeFlow();
        int i11 = 43;
        int hashCode = (((cashFreeFlow2 == null ? 43 : cashFreeFlow2.hashCode()) + 59) * 59) + getCoinId();
        long gmtCreate2 = getGmtCreate();
        int type2 = (((hashCode * 59) + ((int) (gmtCreate2 ^ (gmtCreate2 >>> 32)))) * 59) + getType();
        String uid2 = getUid();
        int i12 = type2 * 59;
        if (uid2 != null) {
            i11 = uid2.hashCode();
        }
        return ((i12 + i11) * 59) + getLayoutType();
    }

    public void setCashFreeFlow(String str) {
        this.cashFreeFlow = str;
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setGmtCreate(long j11) {
        this.gmtCreate = j11;
    }

    public void setLayoutType(int i11) {
        this.layoutType = i11;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        return "OtcFinanceRecordItem(cashFreeFlow=" + getCashFreeFlow() + ", coinId=" + getCoinId() + ", gmtCreate=" + getGmtCreate() + ", type=" + getType() + ", uid=" + getUid() + ", layoutType=" + getLayoutType() + ")";
    }
}
