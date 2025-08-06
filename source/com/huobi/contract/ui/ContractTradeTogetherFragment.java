package com.huobi.contract.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.presenter.ContractTradeTogetherPresenter;
import gs.g;
import java.util.HashMap;
import pro.huobi.R;

public class ContractTradeTogetherFragment extends ContractTradeBaseFragment<ContractTradeTogetherPresenter, ContractTradeTogetherPresenter.a> implements ContractTradeTogetherPresenter.a {

    /* renamed from: e0  reason: collision with root package name */
    public ContractTradeTogetherView f43406e0;

    /* renamed from: cj */
    public ContractTradeTogetherPresenter xh() {
        return new ContractTradeTogetherPresenter();
    }

    /* renamed from: dj */
    public ContractTradeTogetherPresenter.a zh() {
        return this;
    }

    /* renamed from: ej */
    public void ce(ContractAccountInfo contractAccountInfo) {
        ContractTradeTogetherView contractTradeTogetherView;
        if (contractAccountInfo != null && (contractTradeTogetherView = this.f43406e0) != null) {
            contractTradeTogetherView.s2(contractAccountInfo);
        }
    }

    public void initViews() {
        ContractTradeTogetherView contractTradeTogetherView = (ContractTradeTogetherView) this.f67460i.b(R.id.trade_layout);
        this.f43406e0 = contractTradeTogetherView;
        contractTradeTogetherView.setFragmentManager(getChildFragmentManager());
        this.f43406e0.setOnEditTextFocusChangeListener(this);
        this.f43369v = this.f43406e0;
        super.initViews();
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_contract_trade_together, viewGroup, false);
    }

    public void ri(boolean z11) {
        super.ri(z11);
        ContractTradeTogetherView contractTradeTogetherView = this.f43406e0;
        if (contractTradeTogetherView != null) {
            contractTradeTogetherView.setHasTrade(z11);
        }
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            HashMap hashMap = new HashMap();
            hashMap.put("service_line", "currency_contract");
            hashMap.put("is_profitor_or_loss", Boolean.valueOf(this.f43369v.getTpSlSwitchCheck()));
            g.i("contract_same_screen_view", hashMap);
        }
    }
}
