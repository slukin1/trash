package com.huobi.swap.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.huobi.swap.presenter.SwapTradeTogetherPresenter;
import gs.g;
import java.util.HashMap;
import pro.huobi.R;

public class SwapTradeTogetherFragment extends SwapTradeBaseFragment<SwapTradeTogetherPresenter, SwapTradeTogetherPresenter.a> implements SwapTradeTogetherPresenter.a {

    /* renamed from: d0  reason: collision with root package name */
    public SwapTradeTogetherView f81745d0;

    /* renamed from: aj */
    public SwapTradeTogetherPresenter xh() {
        return new SwapTradeTogetherPresenter();
    }

    /* renamed from: bj */
    public SwapTradeTogetherPresenter.a zh() {
        return this;
    }

    /* renamed from: cj */
    public void ce(SwapAccountInfo swapAccountInfo) {
        SwapTradeTogetherView swapTradeTogetherView;
        if (swapAccountInfo != null && (swapTradeTogetherView = this.f81745d0) != null) {
            swapTradeTogetherView.E2(swapAccountInfo);
        }
    }

    public void initViews() {
        SwapTradeTogetherView swapTradeTogetherView = (SwapTradeTogetherView) this.f67460i.b(R.id.trade_layout);
        this.f81745d0 = swapTradeTogetherView;
        swapTradeTogetherView.setFragmentManager(getChildFragmentManager());
        this.f81745d0.setOnEditTextFocusChangeListener(this);
        this.f81728w = this.f81745d0;
        super.initViews();
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_swap_trade_together, viewGroup, false);
    }

    public void ri(boolean z11) {
        super.ri(z11);
        SwapTradeTogetherView swapTradeTogetherView = this.f81745d0;
        if (swapTradeTogetherView != null) {
            swapTradeTogetherView.setHasTrade(z11);
        }
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            HashMap hashMap = new HashMap();
            hashMap.put("service_line", "currency_contract");
            hashMap.put("is_profitor_or_loss", Boolean.valueOf(this.f81728w.getTpSlSwitchCheck()));
            hashMap.put("margin_type", g.d());
            g.i("contract_same_screen_view", hashMap);
        }
    }
}
