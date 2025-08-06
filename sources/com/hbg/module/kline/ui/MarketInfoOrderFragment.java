package com.hbg.module.kline.ui;

import a7.e;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.ui.HorizonTradeTrendView;
import com.hbg.lib.core.util.o;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.kline.R$dimen;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.presenter.MarketInfoOrderPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import java.util.List;
import k6.c;

public class MarketInfoOrderFragment extends BaseFragment<MarketInfoOrderPresenter, MarketInfoOrderPresenter.d> implements MarketInfoOrderPresenter.d {

    /* renamed from: l  reason: collision with root package name */
    public HorizonTradeTrendView f24126l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f24127m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f24128n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f24129o;

    /* renamed from: p  reason: collision with root package name */
    public String f24130p;

    /* renamed from: q  reason: collision with root package name */
    public LoadingLayout f24131q;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        ((MarketInfoOrderPresenter) yh()).u0(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        this.f24131q.setOnRetryClickListener(new q4(this));
    }

    /* renamed from: Dh */
    public MarketInfoOrderPresenter xh() {
        return new MarketInfoOrderPresenter();
    }

    /* renamed from: Eh */
    public MarketInfoOrderPresenter.d zh() {
        return this;
    }

    public void I4(List<? extends c.a> list) {
        if (isCanBeSeen()) {
            this.f24126l.setSellList(list);
        }
    }

    public void I7() {
        HorizonTradeTrendView horizonTradeTrendView;
        if (isCanBeSeen() && (horizonTradeTrendView = this.f24126l) != null) {
            horizonTradeTrendView.i();
        }
    }

    public void Re(String str) {
        String str2;
        String str3;
        String string;
        if (TradeType.isLinearSwap(this.f24130p)) {
            if (e.F(TradeType.valueOf(this.f24130p))) {
                str2 = ((MarketInfoOrderPresenter) yh()).l0();
            } else {
                str2 = getString(R$string.contract_trade_unit_sheet);
            }
            str3 = ((MarketInfoOrderPresenter) yh()).m0();
        } else if (TradeType.isContract(this.f24130p) || TradeType.isSwap(this.f24130p) || TradeType.isOption(this.f24130p)) {
            if (TradeType.isContract(this.f24130p) && e.E(TradeType.CONTRACT)) {
                string = ((MarketInfoOrderPresenter) yh()).l0();
            } else if (TradeType.isSwap(this.f24130p) && e.E(TradeType.SWAP)) {
                string = ((MarketInfoOrderPresenter) yh()).l0();
            } else if (!TradeType.isOption(this.f24130p) || !e.E(TradeType.valueOf(this.f24130p))) {
                string = getString(R$string.contract_trade_unit_sheet);
            } else {
                string = ((MarketInfoOrderPresenter) yh()).l0();
            }
            str3 = "USD";
        } else {
            String p11 = a1.v().p(str);
            str3 = a1.v().F(str);
            str2 = p11;
        }
        String format = String.format(getString(R$string.n_market_info_top_amount), new Object[]{str2});
        this.f24128n.setText(format);
        this.f24129o.setText(format);
        this.f24127m.setText(String.format(getString(R$string.n_market_info_top_price), new Object[]{str3}));
    }

    public LoadingLayout f6() {
        return this.f24131q;
    }

    public void g4(List<? extends c.a> list) {
        if (isCanBeSeen()) {
            this.f24126l.setBuyList(list);
        }
    }

    public void initViews() {
        super.initViews();
        this.f24130p = getActivity().getIntent().getStringExtra("market_trade_type");
        HorizonTradeTrendView horizonTradeTrendView = (HorizonTradeTrendView) this.f67460i.b(R$id.market_list_root_ll);
        this.f24126l = horizonTradeTrendView;
        horizonTradeTrendView.setVisibleMinCount(o.c());
        this.f24126l.setDimensionPixelOffset(getResources().getDimensionPixelOffset(R$dimen.dimen_34));
        this.f24127m = (TextView) this.f67460i.b(R$id.market_info_price_tv);
        this.f24128n = (TextView) this.f67460i.b(R$id.market_info_buy_amount_tv);
        this.f24129o = (TextView) this.f67460i.b(R$id.market_info_sell_amount_tv);
        this.f24131q = (LoadingLayout) this.f67460i.b(R$id.order_loading_layout);
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_market_info_order, viewGroup, false);
    }
}
