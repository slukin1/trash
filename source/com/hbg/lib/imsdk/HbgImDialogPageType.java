package com.hbg.lib.imsdk;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.coupon.bean.CouponReturn;

public enum HbgImDialogPageType {
    INDEX("1"),
    MARKET("2"),
    EXCHANGE("3"),
    CONTRACT("8"),
    ASSET(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL),
    OTC(CouponReturn.TYPE_EXPERIENCE),
    ACCOUNT("9"),
    COPY_TRADING("51");
    
    private final String type;

    private HbgImDialogPageType(String str) {
        this.type = str;
    }

    public String getType() {
        return this.type;
    }
}
