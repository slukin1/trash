package com.huobi.finance.bean;

import com.hbg.lib.network.hbg.core.bean.PledgeBalance;
import com.huobi.asset.feature.account.mortgage.impl.MortgageType;
import com.huobi.finance.viewhandler.AssetMortgageItemViewHandler;

public class AssetMortgageItemInfo extends BaseAssetInfo {
    private PledgeBalance.CurrencyBalance itemBean;
    private String mCoinNumberTitle;
    private MortgageType mortgageType;

    public AssetMortgageItemInfo(PledgeBalance.CurrencyBalance currencyBalance, String str, MortgageType mortgageType2) {
        this.itemBean = currencyBalance;
        this.mCoinNumberTitle = str;
        this.mortgageType = mortgageType2;
    }

    public String getCoinNumberTitle() {
        return this.mCoinNumberTitle;
    }

    public PledgeBalance.CurrencyBalance getItemBean() {
        return this.itemBean;
    }

    public MortgageType getMortgageType() {
        return this.mortgageType;
    }

    public String getViewHandlerName() {
        return AssetMortgageItemViewHandler.class.getName();
    }

    public void setCoinNumberTitle(String str) {
        this.mCoinNumberTitle = str;
    }

    public void setItemBean(PledgeBalance.CurrencyBalance currencyBalance) {
        this.itemBean = currencyBalance;
    }

    public void setMortgageType(MortgageType mortgageType2) {
        this.mortgageType = mortgageType2;
    }
}
