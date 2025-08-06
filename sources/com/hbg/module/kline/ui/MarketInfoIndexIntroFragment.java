package com.hbg.module.kline.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.presenter.MarketInfoIndexIntroPresenter;

public class MarketInfoIndexIntroFragment extends BaseFragment<MarketInfoIndexIntroPresenter, MarketInfoIndexIntroPresenter.a> implements MarketInfoIndexIntroPresenter.a {
    /* renamed from: Ch */
    public MarketInfoIndexIntroPresenter xh() {
        return new MarketInfoIndexIntroPresenter();
    }

    /* renamed from: Dh */
    public MarketInfoIndexIntroPresenter.a zh() {
        return this;
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_market_info_index_intro, viewGroup, false);
    }
}
