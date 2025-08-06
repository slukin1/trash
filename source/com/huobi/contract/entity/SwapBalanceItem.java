package com.huobi.contract.entity;

import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.viewhandler.SwapItemViewAdapter;

public class SwapBalanceItem extends BaseAssetInfo {
    private SwapAccountInfo mSwapAccountInfo;

    public SwapBalanceItem(SwapAccountInfo swapAccountInfo) {
        this.mSwapAccountInfo = swapAccountInfo;
        if (swapAccountInfo != null) {
            setCurrency(swapAccountInfo.getSymbol());
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof SwapBalanceItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapBalanceItem)) {
            return false;
        }
        SwapBalanceItem swapBalanceItem = (SwapBalanceItem) obj;
        if (!swapBalanceItem.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        SwapAccountInfo mSwapAccountInfo2 = getMSwapAccountInfo();
        SwapAccountInfo mSwapAccountInfo3 = swapBalanceItem.getMSwapAccountInfo();
        return mSwapAccountInfo2 != null ? mSwapAccountInfo2.equals(mSwapAccountInfo3) : mSwapAccountInfo3 == null;
    }

    public String getDelegateKey() {
        SwapAccountInfo swapAccountInfo = this.mSwapAccountInfo;
        if (swapAccountInfo != null) {
            return swapAccountInfo.getSymbol();
        }
        return null;
    }

    public SwapAccountInfo getMSwapAccountInfo() {
        return this.mSwapAccountInfo;
    }

    public String getTitle() {
        SwapAccountInfo swapAccountInfo = this.mSwapAccountInfo;
        if (swapAccountInfo != null) {
            return swapAccountInfo.getSymbol();
        }
        return null;
    }

    public String getViewHandlerName() {
        return SwapItemViewAdapter.class.getName();
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        SwapAccountInfo mSwapAccountInfo2 = getMSwapAccountInfo();
        return (hashCode * 59) + (mSwapAccountInfo2 == null ? 43 : mSwapAccountInfo2.hashCode());
    }

    public void setMSwapAccountInfo(SwapAccountInfo swapAccountInfo) {
        this.mSwapAccountInfo = swapAccountInfo;
    }

    public String toString() {
        return "SwapBalanceItem(mSwapAccountInfo=" + getMSwapAccountInfo() + ")";
    }
}
