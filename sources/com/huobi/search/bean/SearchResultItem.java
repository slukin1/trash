package com.huobi.search.bean;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.module.market.MarketModuleConfig;
import java.io.Serializable;
import s9.a;

public class SearchResultItem implements a, Serializable {
    public static final int RESULT_TYPE_CONTRACT = 1;
    public static final int RESULT_TYPE_LINEAR_SWAP = 4;
    public static final int RESULT_TYPE_OPTION = 3;
    public static final int RESULT_TYPE_PRO = 0;
    public static final int RESULT_TYPE_SWAP = 2;
    private static final long serialVersionUID = -6469498602776212001L;
    private ContractCurrencyInfo contractCurrencyInfo;
    private boolean isCollected;
    private int itemCurrencyType;
    private FutureContractInfo linearSwapContractInfo;
    private FutureContractInfo optionContractInfo;
    private SwapCurrencyInfo swapCurrencyInfo;
    private String symbol;

    public ContractCurrencyInfo getContractCurrencyInfo() {
        return this.contractCurrencyInfo;
    }

    public int getItemCurrencyType() {
        return this.itemCurrencyType;
    }

    public FutureContractInfo getLinearSwapContractInfo() {
        return this.linearSwapContractInfo;
    }

    public FutureContractInfo getOptionContractInfo() {
        return this.optionContractInfo;
    }

    public SwapCurrencyInfo getSwapCurrencyInfo() {
        return this.swapCurrencyInfo;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getViewHandlerName() {
        return MarketModuleConfig.a().M();
    }

    public boolean isCollected() {
        return this.isCollected;
    }

    public void setCollected(boolean z11) {
        this.isCollected = z11;
    }

    public void setContractCurrencyInfo(ContractCurrencyInfo contractCurrencyInfo2) {
        this.contractCurrencyInfo = contractCurrencyInfo2;
    }

    public void setItemCurrencyType(int i11) {
        this.itemCurrencyType = i11;
    }

    public void setLinearSwapContractInfo(FutureContractInfo futureContractInfo) {
        this.linearSwapContractInfo = futureContractInfo;
    }

    public void setOptionContractInfo(FutureContractInfo futureContractInfo) {
        this.optionContractInfo = futureContractInfo;
    }

    public void setSwapCurrencyInfo(SwapCurrencyInfo swapCurrencyInfo2) {
        this.swapCurrencyInfo = swapCurrencyInfo2;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }
}
