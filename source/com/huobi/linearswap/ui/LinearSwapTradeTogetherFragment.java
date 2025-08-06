package com.huobi.linearswap.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.huobi.feature.ui.FutureTradeTogetherView;
import com.huobi.linearswap.presenter.LinearSwapTradeTogetherPresenter;
import gs.g;
import java.util.HashMap;
import pro.huobi.R;

public class LinearSwapTradeTogetherFragment extends LinearSwapTradeBaseFragment<LinearSwapTradeTogetherPresenter, LinearSwapTradeTogetherPresenter.a> implements LinearSwapTradeTogetherPresenter.a {

    /* renamed from: t0  reason: collision with root package name */
    public FutureTradeTogetherView f75350t0;

    public void Qi(boolean z11) {
        super.Qi(z11);
        FutureTradeTogetherView futureTradeTogetherView = this.f75350t0;
        if (futureTradeTogetherView != null) {
            futureTradeTogetherView.setHasTrade(z11);
        }
    }

    public void Rj(AccountBalanceInfoV5 accountBalanceInfoV5) {
        FutureTradeTogetherView futureTradeTogetherView = this.f75350t0;
        if (futureTradeTogetherView != null) {
            futureTradeTogetherView.K2(accountBalanceInfoV5);
        }
    }

    /* renamed from: Yj */
    public LinearSwapTradeTogetherPresenter xh() {
        return new LinearSwapTradeTogetherPresenter();
    }

    /* renamed from: Zj */
    public LinearSwapTradeTogetherPresenter.a zh() {
        return this;
    }

    /* renamed from: ak */
    public void ce(LinearSwapAccountInfo linearSwapAccountInfo) {
        FutureTradeTogetherView futureTradeTogetherView;
        if (linearSwapAccountInfo != null && (futureTradeTogetherView = this.f75350t0) != null) {
            futureTradeTogetherView.J2(linearSwapAccountInfo);
        }
    }

    public void initViews() {
        FutureTradeTogetherView futureTradeTogetherView = (FutureTradeTogetherView) this.f67460i.b(R.id.trade_layout);
        this.f75350t0 = futureTradeTogetherView;
        futureTradeTogetherView.setFragmentManager(getChildFragmentManager());
        this.f75350t0.setOnEditTextFocusChangeListener(this);
        this.f75329w = this.f75350t0;
        super.initViews();
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_linear_swap_trade_together, viewGroup, false);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            HashMap hashMap = new HashMap();
            hashMap.put("service_line", "usdt_contract");
            hashMap.put("is_profitor_or_loss", Boolean.valueOf(this.f75329w.getTpSlSwitchCheck()));
            hashMap.put("margin_type", g.d());
            g.i("contract_same_screen_view", hashMap);
        }
    }
}
