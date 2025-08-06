package com.huobi.account.entity;

import com.hbg.lib.network.hbg.core.bean.RankScreenBean;

public enum AccountType {
    spot(RankScreenBean.SCREEN_VALUE_SPOT),
    margin("margin"),
    supermargin("super-margin"),
    investment("investment"),
    borrow("borrow"),
    mine_pool("minepool"),
    otc("otc"),
    point("point"),
    savings("deposit-earning"),
    otc_options("otc-options");
    
    private String value;

    private AccountType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return this.value;
    }
}
