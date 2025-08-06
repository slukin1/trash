package com.huobi.swap.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.huobi.swap.presenter.SwapTradeSplitPresenter;
import gs.g;
import is.a;
import java.util.HashMap;
import pro.huobi.R;

public class SwapTradeSplitFragment extends SwapTradeBaseFragment<SwapTradeSplitPresenter, SwapTradeSplitPresenter.a> implements SwapTradeSplitPresenter.a {

    /* renamed from: d0  reason: collision with root package name */
    public SwapTradeView f81744d0;

    /* renamed from: aj */
    public SwapTradeSplitPresenter xh() {
        return new SwapTradeSplitPresenter();
    }

    /* renamed from: bj */
    public SwapTradeSplitPresenter.a zh() {
        return this;
    }

    /* renamed from: cj */
    public void ce(SwapAccountInfo swapAccountInfo) {
        SwapTradeView swapTradeView;
        if (swapAccountInfo != null && (swapTradeView = this.f81744d0) != null) {
            swapTradeView.C2(swapAccountInfo);
        }
    }

    public void initViews() {
        SwapTradeView swapTradeView = (SwapTradeView) this.f67460i.b(R.id.trade_layout);
        this.f81744d0 = swapTradeView;
        swapTradeView.setFragmentManager(getChildFragmentManager());
        this.f81744d0.setOnEditTextFocusChangeListener(this);
        this.f81728w = this.f81744d0;
        super.initViews();
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_swap_trade, viewGroup, false);
    }

    public void ri(boolean z11) {
        super.ri(z11);
        SwapTradeView swapTradeView = this.f81744d0;
        if (swapTradeView != null) {
            swapTradeView.setHasTrade(z11);
        }
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (!z11) {
            a.m("1005119");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("service_line", "currency_contract");
        hashMap.put("is_profitor_or_loss", Boolean.valueOf(this.f81728w.getTpSlSwitchCheck()));
        g.i("contract_split_screen_view", hashMap);
    }
}
