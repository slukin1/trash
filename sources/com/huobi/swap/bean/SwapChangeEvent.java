package com.huobi.swap.bean;

import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import java.io.Serializable;

public class SwapChangeEvent implements Serializable {
    private static final long serialVersionUID = 2630663472834462999L;
    private SwapCurrencyInfo info;

    public SwapCurrencyInfo getInfo() {
        return this.info;
    }

    public void setInfo(SwapCurrencyInfo swapCurrencyInfo) {
        this.info = swapCurrencyInfo;
    }
}
