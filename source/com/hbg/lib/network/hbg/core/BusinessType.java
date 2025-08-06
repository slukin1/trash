package com.hbg.lib.network.hbg.core;

import com.hbg.lib.network.hbg.core.bean.RankScreenBean;

public enum BusinessType {
    PRO("trading"),
    MARGIN("margin"),
    SUPER_MARGIN("super-margin"),
    OTC("otc"),
    CONTRACT(RankScreenBean.SCREEN_VALUE_FUTURE);
    
    public String type;

    private BusinessType(String str) {
        this.type = str;
    }
}
