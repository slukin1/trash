package com.hbg.module.market.widget.bean;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.module.market.widget.viewhandler.MarketSearchResultViewHandler;
import java.io.Serializable;
import s9.a;

public class MarketSearchResultItem implements a, Serializable {
    public static final int RESULT_TYPE_CONTRACT = 1;
    public static final int RESULT_TYPE_CONTRACT_INDEX = 5;
    public static final int RESULT_TYPE_LINEAR_SWAP = 4;
    public static final int RESULT_TYPE_LINEAR_SWAP_INDEX = 6;
    public static final int RESULT_TYPE_OPTION = 3;
    public static final int RESULT_TYPE_PRO = 0;
    public static final int RESULT_TYPE_SWAP = 2;
    private ContractCurrencyInfo contractCurrencyInfo;
    private IndexCurrencyInfo indexCurrencyInfo;
    private boolean isCollected;
    private boolean isSelected;
    private int itemCurrencyType;
    private FutureContractInfo linearSwapContractInfo;
    private FutureContractInfo optionContractInfo;
    private String searchKeyWord;
    private SwapCurrencyInfo swapCurrencyInfo;
    private String symbol;

    public ContractCurrencyInfo getContractCurrencyInfo() {
        return this.contractCurrencyInfo;
    }

    public IndexCurrencyInfo getIndexCurrencyInfo() {
        return this.indexCurrencyInfo;
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

    public String getSearchKeyWord() {
        return this.searchKeyWord;
    }

    public SwapCurrencyInfo getSwapCurrencyInfo() {
        return this.swapCurrencyInfo;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getViewHandlerName() {
        return MarketSearchResultViewHandler.class.getName();
    }

    public boolean isCollected() {
        return this.isCollected;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setCollected(boolean z11) {
        this.isCollected = z11;
    }

    public void setContractCurrencyInfo(ContractCurrencyInfo contractCurrencyInfo2) {
        this.contractCurrencyInfo = contractCurrencyInfo2;
    }

    public void setIndexCurrencyInfo(IndexCurrencyInfo indexCurrencyInfo2) {
        this.indexCurrencyInfo = indexCurrencyInfo2;
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

    public void setSearchKeyWord(String str) {
        this.searchKeyWord = str;
    }

    public void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public void setSwapCurrencyInfo(SwapCurrencyInfo swapCurrencyInfo2) {
        this.swapCurrencyInfo = swapCurrencyInfo2;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }
}
