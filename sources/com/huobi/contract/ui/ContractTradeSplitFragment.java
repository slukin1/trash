package com.huobi.contract.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.presenter.ContractTradeSplitPresenter;
import gs.g;
import is.a;
import java.util.HashMap;
import pro.huobi.R;

public class ContractTradeSplitFragment extends ContractTradeBaseFragment<ContractTradeSplitPresenter, ContractTradeSplitPresenter.a> implements ContractTradeSplitPresenter.a {

    /* renamed from: e0  reason: collision with root package name */
    public ContractTradeView f43405e0;

    /* renamed from: cj */
    public ContractTradeSplitPresenter xh() {
        return new ContractTradeSplitPresenter();
    }

    /* renamed from: dj */
    public ContractTradeSplitPresenter.a zh() {
        return this;
    }

    /* renamed from: ej */
    public void ce(ContractAccountInfo contractAccountInfo) {
        ContractTradeView contractTradeView;
        if (contractAccountInfo != null && (contractTradeView = this.f43405e0) != null) {
            contractTradeView.F2(contractAccountInfo);
        }
    }

    public void initViews() {
        ContractTradeView contractTradeView = (ContractTradeView) this.f67460i.b(R.id.trade_layout);
        this.f43405e0 = contractTradeView;
        contractTradeView.setFragmentManager(getChildFragmentManager());
        this.f43405e0.setOnEditTextFocusChangeListener(this);
        this.f43369v = this.f43405e0;
        super.initViews();
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_contract_trade, viewGroup, false);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (!z11) {
            a.m("1005011");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("service_line", "currency_contract");
        hashMap.put("is_profitor_or_loss", Boolean.valueOf(this.f43369v.getTpSlSwitchCheck()));
        g.i("contract_split_screen_view", hashMap);
    }
}
