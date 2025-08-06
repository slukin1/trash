package com.huobi.feature.bean;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import java.io.Serializable;

public class FutureChangeEvent implements Serializable {
    private static final long serialVersionUID = 2630663472834462999L;
    private FutureContractInfo info;

    public FutureContractInfo getInfo() {
        return this.info;
    }

    public void setInfo(FutureContractInfo futureContractInfo) {
        this.info = futureContractInfo;
    }
}
