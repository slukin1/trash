package com.huobi.linearswap.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.huobi.feature.ui.FutureTradeView;
import com.huobi.linearswap.presenter.LinearSwapTradeSplitPresenter;
import gs.g;
import is.a;
import java.util.HashMap;
import pro.huobi.R;

public class LinearSwapTradeSplitFragment extends LinearSwapTradeBaseFragment<LinearSwapTradeSplitPresenter, LinearSwapTradeSplitPresenter.a> implements LinearSwapTradeSplitPresenter.a {

    /* renamed from: t0  reason: collision with root package name */
    public FutureTradeView f75349t0;

    public void Qi(boolean z11) {
        super.Qi(z11);
        FutureTradeView futureTradeView = this.f75349t0;
        if (futureTradeView != null) {
            futureTradeView.setHasTrade(z11);
        }
    }

    public void Rj(AccountBalanceInfoV5 accountBalanceInfoV5) {
        FutureTradeView futureTradeView = this.f75349t0;
        if (futureTradeView != null) {
            futureTradeView.H2(accountBalanceInfoV5);
        }
    }

    /* renamed from: Yj */
    public LinearSwapTradeSplitPresenter xh() {
        return new LinearSwapTradeSplitPresenter();
    }

    /* renamed from: Zj */
    public LinearSwapTradeSplitPresenter.a zh() {
        return this;
    }

    /* renamed from: ak */
    public void ce(LinearSwapAccountInfo linearSwapAccountInfo) {
        FutureTradeView futureTradeView;
        if (linearSwapAccountInfo != null && (futureTradeView = this.f75349t0) != null) {
            futureTradeView.G2(linearSwapAccountInfo);
        }
    }

    public void initViews() {
        FutureTradeView futureTradeView = (FutureTradeView) this.f67460i.b(R.id.trade_layout);
        this.f75349t0 = futureTradeView;
        futureTradeView.setFragmentManager(getChildFragmentManager());
        this.f75349t0.setOnEditTextFocusChangeListener(this);
        this.f75329w = this.f75349t0;
        super.initViews();
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_linear_swap_trade, viewGroup, false);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (!z11) {
            a.m("1005231");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("service_line", "usdt_contract");
        hashMap.put("is_profitor_or_loss", Boolean.valueOf(this.f75329w.getTpSlSwitchCheck()));
        g.i("contract_split_screen_view", hashMap);
    }
}
