package com.hbg.lib.network.hbg.core.util;

import com.hbg.lib.network.hbg.core.bean.C2CLoanOrderBean;

public enum C2COrderState {
    FILLED(TtmlNode.TEXT_EMPHASIS_MARK_FILLED),
    SUBMITTED("submitted"),
    PREPARE(C2CLoanOrderBean.LOAN_ORDER_STATE_PREPARE),
    CANCELED("canceled"),
    PARTICAL_CANCELED("partial-canceled"),
    PARTICAL_FILLED(C2CLoanOrderBean.LOAN_ORDER_STATE_PARTIAL_FILLED),
    STAY_BACK("stay-back"),
    FINISHED("finished");
    
    public final String state;

    private C2COrderState(String str) {
        this.state = str;
    }
}
