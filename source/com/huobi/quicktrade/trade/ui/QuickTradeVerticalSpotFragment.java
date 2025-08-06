package com.huobi.quicktrade.trade.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.quicktrade.trade.presenter.QuickTradeVerticalSpotPresenter;
import com.huobi.utils.SymbolUtil;
import com.huobi.view.TradeAmountEditext;
import d7.a1;
import gs.g;
import i6.k;
import i6.m;
import java.util.HashMap;
import nq.a;
import pro.huobi.R;
import sq.u;

public class QuickTradeVerticalSpotFragment extends QuickTradeVerticalBaseFragment<QuickTradeVerticalSpotPresenter, u> implements u {
    public static QuickTradeVerticalSpotFragment Ki(String str, boolean z11, int i11) {
        QuickTradeVerticalSpotFragment quickTradeVerticalSpotFragment = new QuickTradeVerticalSpotFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tradingview_symbol", str);
        bundle.putBoolean("arg_buy", z11);
        bundle.putInt("trade_dialog_type", i11);
        quickTradeVerticalSpotFragment.setArguments(bundle);
        return quickTradeVerticalSpotFragment;
    }

    /* renamed from: Hi */
    public QuickTradeVerticalSpotPresenter xh() {
        return new QuickTradeVerticalSpotPresenter();
    }

    /* renamed from: Ii */
    public u zh() {
        return this;
    }

    public final void Ji() {
        this.Z = (LinearLayout) this.f67460i.b(R.id.stop_trade_ll);
        this.f80650a0 = (ImageView) this.f67460i.b(R.id.trade_mask_iv);
        this.f80651b0 = (TextView) this.f67460i.b(R.id.trade_mask_title_tv);
        this.f80652c0 = (TextView) this.f67460i.b(R.id.trade_suspend_instruction_tv);
    }

    public void K8(String str, String str2) {
    }

    public void O1(String str, TradeType tradeType) {
        super.O1(str, tradeType);
        if (!((QuickTradeVerticalSpotPresenter) yh()).B0() || !((QuickTradeVerticalSpotPresenter) yh()).z0()) {
            this.Q.setText(R.string.trade_asset_available);
        } else {
            this.Q.setText(getResources().getString(R.string.n_trade_observation_available_limit));
        }
    }

    public void R2(String str, String str2) {
        String str3;
        String str4;
        if (((QuickTradeVerticalSpotPresenter) yh()).z0()) {
            str3 = a1.v().E(str, ((QuickTradeVerticalSpotPresenter) yh()).u0());
        } else {
            str3 = a1.v().o(str, ((QuickTradeVerticalSpotPresenter) yh()).u0());
        }
        int a11 = PrecisionUtil.a(((QuickTradeVerticalSpotPresenter) yh()).u0(), str3);
        if (!((QuickTradeVerticalSpotPresenter) yh()).B0() || !((QuickTradeVerticalSpotPresenter) yh()).z0()) {
            this.Q.setText(R.string.trade_asset_available);
            str4 = m.m(str2, a11);
        } else {
            this.Q.setText(getResources().getString(R.string.n_trade_observation_available_limit));
            str4 = "--";
        }
        this.C.setText(str4);
        this.B.setText(SymbolUtil.c(str, !((QuickTradeVerticalSpotPresenter) yh()).z0()));
    }

    public boolean U7() {
        return !((QuickTradeVerticalSpotPresenter) yh()).z0();
    }

    public void Yd(int i11, String str, int i12) {
    }

    public void d(boolean z11) {
        super.d(z11);
        if (!z11) {
            this.C.setText("--");
        }
    }

    public void id() {
    }

    public void initViews() {
        super.initViews();
        TradeAmountEditext tradeAmountEditext = this.G;
        TradeType tradeType = TradeType.PRO;
        tradeAmountEditext.setTradeType(tradeType, true);
        this.J.setTradeType(tradeType, true);
        this.E.setTradeType(tradeType, true);
        if (getArguments() != null) {
            this.f80621o.setType(getArguments().getInt("trade_dialog_type"));
        }
        Ji();
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ((QuickTradeVerticalSpotPresenter) yh()).J0(getArguments().getBoolean("arg_buy"));
        return layoutInflater.inflate(R.layout.fragment_vertical_quick_trade_spot, viewGroup, false);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("order_class_name", a.a());
                g.i("App_quickcomponent_trade_spot_view", hashMap);
            } catch (Exception e11) {
                k.j("SensorsData", e11);
            }
        }
    }
}
