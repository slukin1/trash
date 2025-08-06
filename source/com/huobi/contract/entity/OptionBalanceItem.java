package com.huobi.contract.entity;

import com.hbg.lib.network.option.core.bean.OptionAccountInfo;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.viewhandler.OptionItemViewAdapter;

public class OptionBalanceItem extends BaseAssetInfo {
    private OptionAccountInfo mAccountInfo;

    public OptionBalanceItem(OptionAccountInfo optionAccountInfo) {
        this.mAccountInfo = optionAccountInfo;
        if (optionAccountInfo != null) {
            setCurrency(optionAccountInfo.getSymbol());
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OptionBalanceItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionBalanceItem)) {
            return false;
        }
        OptionBalanceItem optionBalanceItem = (OptionBalanceItem) obj;
        if (!optionBalanceItem.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        OptionAccountInfo mAccountInfo2 = getMAccountInfo();
        OptionAccountInfo mAccountInfo3 = optionBalanceItem.getMAccountInfo();
        return mAccountInfo2 != null ? mAccountInfo2.equals(mAccountInfo3) : mAccountInfo3 == null;
    }

    public String getDelegateKey() {
        OptionAccountInfo optionAccountInfo = this.mAccountInfo;
        if (optionAccountInfo != null) {
            return optionAccountInfo.getSymbol();
        }
        return null;
    }

    public OptionAccountInfo getMAccountInfo() {
        return this.mAccountInfo;
    }

    public String getTitle() {
        OptionAccountInfo optionAccountInfo = this.mAccountInfo;
        if (optionAccountInfo != null) {
            return optionAccountInfo.getSymbol();
        }
        return null;
    }

    public String getViewHandlerName() {
        return OptionItemViewAdapter.class.getName();
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        OptionAccountInfo mAccountInfo2 = getMAccountInfo();
        return (hashCode * 59) + (mAccountInfo2 == null ? 43 : mAccountInfo2.hashCode());
    }

    public void setMAccountInfo(OptionAccountInfo optionAccountInfo) {
        this.mAccountInfo = optionAccountInfo;
    }

    public String toString() {
        return "OptionBalanceItem(mAccountInfo=" + getMAccountInfo() + ")";
    }
}
