package com.huobi.newtrade.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huobi.newtrade.presenter.NewTradeSpotPresenter;
import pro.huobi.R;
import ro.b;

public class NewTradeSpotFragment extends NewTradeBaseFragment<NewTradeSpotPresenter, b> implements b {
    /* renamed from: Dh */
    public NewTradeSpotPresenter xh() {
        return new NewTradeSpotPresenter();
    }

    /* renamed from: Eh */
    public b zh() {
        return this;
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_new_trade_spot, viewGroup, false);
    }
}
