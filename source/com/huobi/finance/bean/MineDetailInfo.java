package com.huobi.finance.bean;

import android.text.TextUtils;
import com.huobi.finance.viewhandler.MineBalanceViewAdapter;

public class MineDetailInfo extends BalanceDetailInfo {
    private String bank;
    private boolean isTransferable;
    private String lock;

    public boolean canEqual(Object obj) {
        return obj instanceof MineDetailInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MineDetailInfo)) {
            return false;
        }
        MineDetailInfo mineDetailInfo = (MineDetailInfo) obj;
        if (!mineDetailInfo.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String lock2 = getLock();
        String lock3 = mineDetailInfo.getLock();
        if (lock2 != null ? !lock2.equals(lock3) : lock3 != null) {
            return false;
        }
        String bank2 = getBank();
        String bank3 = mineDetailInfo.getBank();
        if (bank2 != null ? bank2.equals(bank3) : bank3 == null) {
            return isTransferable() == mineDetailInfo.isTransferable();
        }
        return false;
    }

    public void fillEmptyValues() {
        if (getLock() == null) {
            setLock("0");
        }
        if (getBank() == null) {
            setBank("0");
        }
        if (getOnOrders() == null) {
            setOnOrders("0");
        }
        if (getAvaialAble() == null) {
            setAvaialAble("0");
        }
        if (getEstimateAmount() == null) {
            setEstimateAmount("0");
        }
        if (getEstimateAmountToBtc() == null) {
            setEstimateAmountToBtc("0");
        }
    }

    public String getAvaialAble() {
        String avaialAble = super.getAvaialAble();
        return TextUtils.isEmpty(avaialAble) ? "0.00" : avaialAble;
    }

    public String getBank() {
        return this.bank;
    }

    public String getLock() {
        return this.lock;
    }

    public String getTitle() {
        return getCurrency();
    }

    public String getViewHandlerName() {
        return MineBalanceViewAdapter.class.getName();
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String lock2 = getLock();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (lock2 == null ? 43 : lock2.hashCode());
        String bank2 = getBank();
        int i12 = hashCode2 * 59;
        if (bank2 != null) {
            i11 = bank2.hashCode();
        }
        return ((i12 + i11) * 59) + (isTransferable() ? 79 : 97);
    }

    public boolean isTransferable() {
        return this.isTransferable;
    }

    public void setBank(String str) {
        this.bank = str;
    }

    public void setLock(String str) {
        this.lock = str;
    }

    public void setTransferable(boolean z11) {
        this.isTransferable = z11;
    }

    public String toString() {
        return "MineDetailInfo(lock=" + getLock() + ", bank=" + getBank() + ", isTransferable=" + isTransferable() + ")";
    }
}
