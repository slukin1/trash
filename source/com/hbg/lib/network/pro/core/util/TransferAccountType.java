package com.hbg.lib.network.pro.core.util;

import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.tencent.qcloud.tuicore.TUIConstants;

public enum TransferAccountType {
    SWAP("swap"),
    LINEAR_SWAP("linear-swap"),
    OPTION(TUIConstants.TUIPoll.PLUGIN_POLL_OPTION_CONTENT),
    OTC_OPTION("otc_option"),
    OTC("otc"),
    SPOT(RankScreenBean.SCREEN_VALUE_SPOT);
    
    public final String type;

    private TransferAccountType(String str) {
        this.type = str;
    }
}
