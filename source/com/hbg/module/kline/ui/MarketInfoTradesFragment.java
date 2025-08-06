package com.hbg.module.kline.ui;

import a7.e;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.bean.MarketInfoTradesItem;
import com.hbg.module.kline.presenter.MarketInfoTradesPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.k;
import u9.a;

public class MarketInfoTradesFragment extends BaseFragment<MarketInfoTradesPresenter, MarketInfoTradesPresenter.c> implements MarketInfoTradesPresenter.c {

    /* renamed from: l  reason: collision with root package name */
    public LinearLayout f24132l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f24133m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f24134n;

    /* renamed from: o  reason: collision with root package name */
    public LoadingLayout f24135o;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        ((MarketInfoTradesPresenter) yh()).B0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        this.f24135o.setOnRetryClickListener(new r4(this));
    }

    /* renamed from: Dh */
    public MarketInfoTradesPresenter xh() {
        return new MarketInfoTradesPresenter();
    }

    /* renamed from: Eh */
    public MarketInfoTradesPresenter.c zh() {
        return this;
    }

    public void Ue(String str) {
        TradeType p02 = ((MarketInfoTradesPresenter) yh()).p0();
        if (((MarketInfoTradesPresenter) yh()).s0() || ((MarketInfoTradesPresenter) yh()).v0() || ((MarketInfoTradesPresenter) yh()).u0()) {
            this.f24133m.setText(String.format(getString(R$string.n_market_info_top_price), new Object[]{"USD"}));
            boolean z11 = TradeType.isContract(p02) && e.E(TradeType.CONTRACT);
            boolean z12 = TradeType.isSwap(p02) && e.E(TradeType.SWAP);
            boolean z13 = TradeType.isOption(p02) && e.E(p02);
            if (z11) {
                this.f24134n.setText(String.format(getString(R$string.n_market_info_top_amount), new Object[]{getActivity().getIntent().getStringExtra("contract_currency_symble")}));
            } else if (z12) {
                this.f24134n.setText(String.format(getString(R$string.n_market_info_top_amount), new Object[]{getActivity().getIntent().getStringExtra("contract_currency_symble")}));
            } else if (z13) {
                this.f24134n.setText(String.format(getString(R$string.n_market_info_top_amount), new Object[]{getActivity().getIntent().getStringExtra("contract_currency_symble")}));
            } else {
                this.f24134n.setText(String.format(getString(R$string.n_market_info_top_amount), new Object[]{getString(R$string.contract_trade_unit_sheet)}));
            }
        } else if (((MarketInfoTradesPresenter) yh()).t0()) {
            this.f24133m.setText(String.format(getString(R$string.n_market_info_top_price), new Object[]{((MarketInfoTradesPresenter) yh()).n0()}));
            if (e.F(p02)) {
                this.f24134n.setText(String.format(getString(R$string.n_market_info_top_amount), new Object[]{getActivity().getIntent().getStringExtra("contract_currency_symble")}));
            } else {
                this.f24134n.setText(String.format(getString(R$string.n_market_info_top_amount), new Object[]{getString(R$string.contract_trade_unit_sheet)}));
            }
        } else {
            String p11 = a1.v().p(str);
            this.f24133m.setText(String.format(getString(R$string.n_market_info_top_price), new Object[]{a1.v().F(str)}));
            this.f24134n.setText(String.format(getString(R$string.n_market_info_top_amount), new Object[]{p11}));
        }
    }

    public void b6(a<MarketInfoTradesItem> aVar) {
        if (aVar == null || aVar.getCount() == 0) {
            this.f24135o.i();
            return;
        }
        this.f24135o.g();
        if (isCanBeSeen()) {
            if (aVar.getCount() != this.f24132l.getChildCount()) {
                this.f24132l.removeAllViews();
            }
            int i11 = 0;
            while (i11 < aVar.getCount()) {
                try {
                    if (this.f24132l.getChildCount() > i11) {
                        aVar.getView(i11, this.f24132l.getChildAt(i11), this.f24132l);
                    } else {
                        this.f24132l.addView(aVar.getView(i11, (View) null, this.f24132l));
                    }
                    i11++;
                } catch (Exception e11) {
                    k.k(e11);
                    return;
                }
            }
        }
    }

    public LoadingLayout f6() {
        if (this.f24135o == null) {
            this.f24135o = (LoadingLayout) this.f67460i.b(R$id.trades_loading_layout);
        }
        return this.f24135o;
    }

    public void initViews() {
        super.initViews();
        this.f24132l = (LinearLayout) this.f67460i.b(R$id.market_info_trades_ll);
        this.f24133m = (TextView) this.f67460i.b(R$id.trades_price_label_tv);
        this.f24134n = (TextView) this.f67460i.b(R$id.trades_amount_label_tv);
        this.f24135o = (LoadingLayout) this.f67460i.b(R$id.trades_loading_layout);
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_market_info_trades, viewGroup, false);
    }
}
