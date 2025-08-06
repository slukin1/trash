package com.huobi.contract.entity;

import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import java.io.Serializable;

public class ContractChangeEvent implements Serializable {
    private static final long serialVersionUID = 2630663472834462999L;
    private ContractCurrencyInfo info;

    public ContractCurrencyInfo getInfo() {
        return this.info;
    }

    public void setInfo(ContractCurrencyInfo contractCurrencyInfo) {
        this.info = contractCurrencyInfo;
    }
}
