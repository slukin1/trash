package com.huobi.contract.entity;

import aj.c;
import android.content.Context;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.pro.socket.response.ContractPositionWsData;
import com.huobi.contract.viewhandler.ContractPositionViewHandler;
import com.huobi.feature.ui.LeverSelectDialogFragment;

public class ContractPosition extends ContractPositionWsData implements s9.a {
    private static final long serialVersionUID = 7519437576766416282L;
    @Expose(serialize = false)
    public transient a clickListener;
    public transient ContractCurrencyInfo contractCurrencyInfo;
    public String marginMode;
    @SerializedName("order_source")
    public String orderSource;
    public String quoteCurrency;

    public interface a {
        String a();

        void b(c cVar, Context context);

        void c(ContractPosition contractPosition);

        void d(ContractPosition contractPosition);

        LeverSelectDialogFragment.h e(ContractPosition contractPosition);

        void f(ContractPosition contractPosition);

        void g(ContractPosition contractPosition);

        void h(int i11, ContractPosition contractPosition, int i12, Context context);
    }

    public a getClickListener() {
        return this.clickListener;
    }

    public ContractCurrencyInfo getContractCurrencyInfo() {
        return this.contractCurrencyInfo;
    }

    public String getMarginMode() {
        return this.marginMode;
    }

    public String getOrderSource() {
        return this.orderSource;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getViewHandlerName() {
        return ContractPositionViewHandler.class.getName();
    }

    public void setClickListener(a aVar) {
        this.clickListener = aVar;
    }

    public void setContractCurrencyInfo(ContractCurrencyInfo contractCurrencyInfo2) {
        this.contractCurrencyInfo = contractCurrencyInfo2;
    }

    public void setMarginMode(String str) {
        this.marginMode = str;
    }

    public void setOrderSource(String str) {
        this.orderSource = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }
}
