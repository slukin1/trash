package com.huobi.quicktrade.order.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huobi.quicktrade.order.presenter.QuickTradeOrderVerticalSpotPresenter;
import pq.e;
import pro.huobi.R;

public class QuickTradeOrderFragment extends QuickTradeOrderBaseFragment<QuickTradeOrderVerticalSpotPresenter, e> {
    public static QuickTradeOrderFragment Oh(String str) {
        QuickTradeOrderFragment quickTradeOrderFragment = new QuickTradeOrderFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tradingview_symbol", str);
        quickTradeOrderFragment.setArguments(bundle);
        return quickTradeOrderFragment;
    }

    public void Hh() {
        this.f80542v.add(getString(R.string.n_trade_tab_assets));
        this.f80543w.put(0, 0);
        this.f80542v.add(getString(R.string.n_trade_open_order));
        this.f80543w.put(1, 1);
    }

    /* renamed from: Mh */
    public QuickTradeOrderVerticalSpotPresenter xh() {
        return new QuickTradeOrderVerticalSpotPresenter();
    }

    /* renamed from: Nh */
    public e zh() {
        return this;
    }

    public void initViews() {
        super.initViews();
        this.f80538r.setVisibility(0);
        this.f80535o.setVisibility(0);
        this.f80537q.setVisibility(0);
        this.f80541u.setVisibility(0);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Kh(1);
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_vertical_quick_trade_order, viewGroup, false);
    }
}
