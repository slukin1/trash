package com.huobi.contract.entity;

import aj.d;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.module.asset.R$string;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.viewhandler.LinearSwapItemViewAdapter;

public class LinearSwapBalanceItem extends BaseAssetInfo implements d {
    private String estimateAmountToUsdt;
    private LinearSwapAccountInfo mLinearSwapAccountInfo;

    public LinearSwapBalanceItem(LinearSwapAccountInfo linearSwapAccountInfo) {
        this.mLinearSwapAccountInfo = linearSwapAccountInfo;
        if (linearSwapAccountInfo != null) {
            setCurrency(linearSwapAccountInfo.getSymbol());
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapBalanceItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapBalanceItem)) {
            return false;
        }
        LinearSwapBalanceItem linearSwapBalanceItem = (LinearSwapBalanceItem) obj;
        if (!linearSwapBalanceItem.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        LinearSwapAccountInfo mLinearSwapAccountInfo2 = getMLinearSwapAccountInfo();
        LinearSwapAccountInfo mLinearSwapAccountInfo3 = linearSwapBalanceItem.getMLinearSwapAccountInfo();
        if (mLinearSwapAccountInfo2 != null ? !mLinearSwapAccountInfo2.equals(mLinearSwapAccountInfo3) : mLinearSwapAccountInfo3 != null) {
            return false;
        }
        String estimateAmountToUsdt2 = getEstimateAmountToUsdt();
        String estimateAmountToUsdt3 = linearSwapBalanceItem.getEstimateAmountToUsdt();
        return estimateAmountToUsdt2 != null ? estimateAmountToUsdt2.equals(estimateAmountToUsdt3) : estimateAmountToUsdt3 == null;
    }

    public String getDelegateKey() {
        if (this.mLinearSwapAccountInfo == null) {
            return null;
        }
        return StringUtils.i(this.mLinearSwapAccountInfo.getSymbol() + "usdt");
    }

    public String getEstimateAmountToUsdt() {
        return this.estimateAmountToUsdt;
    }

    public int getFixedTitleRes() {
        if (this.mLinearSwapAccountInfo.isCross()) {
            return R$string.n_linear_swap_cross_account;
        }
        return 0;
    }

    public LinearSwapAccountInfo getMLinearSwapAccountInfo() {
        return this.mLinearSwapAccountInfo;
    }

    public String getTitle() {
        LinearSwapAccountInfo linearSwapAccountInfo = this.mLinearSwapAccountInfo;
        if (linearSwapAccountInfo == null) {
            return null;
        }
        if (linearSwapAccountInfo.getTradePartition() == null || !this.mLinearSwapAccountInfo.getTradePartition().equalsIgnoreCase("husd")) {
            return StringUtils.i(this.mLinearSwapAccountInfo.getSymbol() + "/" + "usdt");
        }
        return StringUtils.i(this.mLinearSwapAccountInfo.getSymbol() + "/" + "husd");
    }

    public String getViewHandlerName() {
        return LinearSwapItemViewAdapter.class.getName();
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        LinearSwapAccountInfo mLinearSwapAccountInfo2 = getMLinearSwapAccountInfo();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (mLinearSwapAccountInfo2 == null ? 43 : mLinearSwapAccountInfo2.hashCode());
        String estimateAmountToUsdt2 = getEstimateAmountToUsdt();
        int i12 = hashCode2 * 59;
        if (estimateAmountToUsdt2 != null) {
            i11 = estimateAmountToUsdt2.hashCode();
        }
        return i12 + i11;
    }

    public void setEstimateAmountToUsdt(String str) {
        this.estimateAmountToUsdt = str;
    }

    public void setMLinearSwapAccountInfo(LinearSwapAccountInfo linearSwapAccountInfo) {
        this.mLinearSwapAccountInfo = linearSwapAccountInfo;
    }

    public String toString() {
        return "LinearSwapBalanceItem(mLinearSwapAccountInfo=" + getMLinearSwapAccountInfo() + ", estimateAmountToUsdt=" + getEstimateAmountToUsdt() + ")";
    }
}
