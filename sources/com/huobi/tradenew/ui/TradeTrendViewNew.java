package com.huobi.tradenew.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.VibrateManager;
import com.hbg.lib.core.ui.HorizonTradeTrendViewNew;
import com.hbg.lib.core.ui.NewestPriceHorizontalView;
import com.hbg.lib.core.ui.TradeTrendView;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.hbg.core.bean.EtpRebalInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.tradenew.presenter.TradeBasePresenter;
import com.huobi.view.PercentCompareView;
import d7.a1;
import gs.g;
import i6.m;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import k6.b;
import k6.c;
import pro.huobi.R;
import rt.i;
import x7.d;

public class TradeTrendViewNew extends RelativeLayout implements TradeTrendView.b {

    /* renamed from: b  reason: collision with root package name */
    public HorizonTradeTrendViewNew f83248b;

    /* renamed from: c  reason: collision with root package name */
    public i.d f83249c;

    /* renamed from: d  reason: collision with root package name */
    public TradeBasePresenter f83250d;

    /* renamed from: e  reason: collision with root package name */
    public z0 f83251e;

    /* renamed from: f  reason: collision with root package name */
    public FragmentActivity f83252f;

    /* renamed from: g  reason: collision with root package name */
    public NewestPriceHorizontalView f83253g;

    /* renamed from: h  reason: collision with root package name */
    public b f83254h;

    /* renamed from: i  reason: collision with root package name */
    public View f83255i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f83256j;

    /* renamed from: k  reason: collision with root package name */
    public PercentCompareView f83257k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f83258l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f83259m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f83260n;

    public class a implements b.C0742b {
        public a() {
        }

        public void a(b bVar) {
            TradeTrendViewNew.this.f83250d.F1();
            VibrateManager.a(TradeTrendViewNew.this.f83253g);
        }

        public void b(b bVar) {
            if (!a1.v().p0(TradeTrendViewNew.this.f83250d.o0())) {
                return;
            }
            if (bVar.c().e()) {
                EtpRebalInfo b11 = d.b(TradeTrendViewNew.this.f83250d.I0());
                if (b11 != null && !TextUtils.isEmpty(b11.getEquityDeviationRate())) {
                    String equityDeviationRate = b11.getEquityDeviationRate();
                    new DialogUtils.b.d(TradeTrendViewNew.this.f83252f).c1(TradeTrendViewNew.this.getContext().getString(R.string.n_trade_etp_nav)).C0(String.format(Locale.ENGLISH, TradeTrendViewNew.this.getContext().getString(R.string.n_trade_etp_deviation_hint), new Object[]{a1.v().p(TradeTrendViewNew.this.f83250d.o0()), m.a(equityDeviationRate).multiply(m.f68179a).toPlainString() + "%"})).q0(false).P0(TradeTrendViewNew.this.getContext().getString(R.string.n_known)).Q0(k2.f83435a).k0().show(TradeTrendViewNew.this.f83252f.getSupportFragmentManager(), "");
                    return;
                }
                return;
            }
            new DialogUtils.b.d(TradeTrendViewNew.this.f83252f).c1(TradeTrendViewNew.this.f83252f.getString(R.string.n_trade_etp_nav)).C0(String.format(Locale.ENGLISH, TradeTrendViewNew.this.getContext().getString(R.string.n_trade_etp_nav_instructions_new), new Object[]{a1.v().p(TradeTrendViewNew.this.f83250d.o0())})).q0(false).P0(TradeTrendViewNew.this.getContext().getString(R.string.n_known)).Q0(l2.f83475a).k0().show(TradeTrendViewNew.this.f83252f.getSupportFragmentManager(), "");
        }
    }

    public TradeTrendViewNew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(c.a aVar) {
        g.i("App_trade_Handicap_click", (HashMap) null);
        if (aVar != null) {
            getUI().u3(m.i(aVar.a(), PrecisionUtil.A(aVar.o0())));
            this.f83251e.I3(this.f83250d.e1());
        }
    }

    public void b(b.a aVar) {
        if (!a1.v().p0(this.f83250d.o0())) {
            return;
        }
        if (aVar.e()) {
            EtpRebalInfo b11 = d.b(this.f83250d.I0());
            if (b11 != null && !TextUtils.isEmpty(b11.getEquityDeviationRate())) {
                String Q = m.Q(b11.getEquityDeviationRate(), 2, 1);
                new DialogUtils.b.d(this.f83252f).c1(getContext().getString(R.string.n_trade_etp_nav)).C0(String.format(Locale.ENGLISH, getContext().getString(R.string.n_trade_etp_deviation_hint), new Object[]{a1.v().p(this.f83250d.o0()), Q})).q0(false).P0(getContext().getString(R.string.n_known)).Q0(j2.f83428a).k0().show(this.f83252f.getSupportFragmentManager(), "");
                return;
            }
            return;
        }
        new DialogUtils.b.d(this.f83252f).c1(getContext().getString(R.string.n_trade_etp_nav)).C0(String.format(Locale.ENGLISH, getContext().getString(R.string.n_trade_etp_nav_instructions_new), new Object[]{a1.v().p(this.f83250d.o0())})).q0(false).P0(getContext().getString(R.string.n_known)).Q0(i2.f83423a).k0().show(this.f83252f.getSupportFragmentManager(), "");
    }

    public void c(b.a aVar) {
        this.f83250d.F1();
    }

    public String getFirstAskPrice() {
        HorizonTradeTrendViewNew horizonTradeTrendViewNew = this.f83248b;
        return horizonTradeTrendViewNew != null ? horizonTradeTrendViewNew.getFirstAskPrice() : "--";
    }

    public String getFirstBldPrice() {
        HorizonTradeTrendViewNew horizonTradeTrendViewNew = this.f83248b;
        return horizonTradeTrendViewNew != null ? horizonTradeTrendViewNew.getFirstBldPrice() : "--";
    }

    public TextView getIndexPriceView() {
        return this.f83248b.getIndexPriceView();
    }

    public String getNewestPrice() {
        b bVar = this.f83254h;
        return (bVar == null || bVar.c() == null) ? "--" : this.f83254h.c().b();
    }

    public i.d getUI() {
        return this.f83249c;
    }

    public void i(int i11) {
        this.f83248b.c(i11);
    }

    public final void j() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_vertical_trade_trend_new, this, true);
        this.f83258l = (TextView) findViewById(R.id.tv_spot_buy);
        this.f83259m = (TextView) findViewById(R.id.tv_spot_sell);
        this.f83248b = (HorizonTradeTrendViewNew) findViewById(R.id.market_list_root_ll_new);
        NewestPriceHorizontalView newestPriceHorizontalView = (NewestPriceHorizontalView) findViewById(R.id.trade_newest_price_view_new);
        this.f83253g = newestPriceHorizontalView;
        newestPriceHorizontalView.setShowLegalPrice(this.f83260n);
        this.f83253g.i(false);
        this.f83253g.setShowLegalPrice(false);
        this.f83253g.setPriceTvSize(getResources().getDimensionPixelOffset(R.dimen.global_text_size_14));
        this.f83257k = (PercentCompareView) findViewById(R.id.percent_compare_view);
        this.f83255i = findViewById(R.id.depth_ll_new);
        this.f83256j = (TextView) findViewById(R.id.vertical_depth_tv_new);
        this.f83258l.setText(String.format("%s(%d)", new Object[]{getContext().getString(R.string.n_spot_order_buy), 5}));
        this.f83259m.setText(String.format("%s(%d)", new Object[]{getContext().getString(R.string.n_spot_order_sell), 5}));
        this.f83256j.setText("--");
        this.f83248b.setMiddleMargin(8);
        this.f83248b.setCallback(this);
        this.f83254h = new b(new a());
        this.f83253g.setShowLegalPrice(this.f83260n);
        this.f83253g.k(this.f83254h);
        k();
    }

    public final void k() {
        this.f83257k.setLeftTextColor(ContextCompat.getColor(getContext(), w.h()));
        this.f83257k.setRightTextColor(ContextCompat.getColor(getContext(), w.d()));
        this.f83257k.setLeftBgColor(ContextCompat.getColor(getContext(), w.h()));
        this.f83257k.setRightBgColor(ContextCompat.getColor(getContext(), w.d()));
        this.f83257k.setCenterVisibility(false);
    }

    public void n() {
        this.f83248b.i();
    }

    public void o(int i11, int i12) {
        this.f83248b.l(i11, i12);
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 == 0) {
            k();
        }
    }

    public void p(int i11) {
        this.f83248b.m(i11);
    }

    public void q(double d11, int i11, int i12) {
        if (this.f83257k.getVisibility() != 0) {
            this.f83257k.setVisibility(0);
        }
        if (d11 == 0.0d) {
            this.f83257k.setLeftTextWithProgress(1);
            this.f83257k.setRightTextWithProgress(1);
            this.f83257k.setTvLeftText("--");
            this.f83257k.setTvRightText("--");
            return;
        }
        this.f83257k.setLeftTextWithProgress(i12);
        PercentCompareView percentCompareView = this.f83257k;
        percentCompareView.setTvLeftText(i12 + "%");
        this.f83257k.setRightTextWithProgress(i11);
        PercentCompareView percentCompareView2 = this.f83257k;
        percentCompareView2.setTvRightText(i11 + "%");
    }

    public void setActivity(FragmentActivity fragmentActivity) {
        this.f83252f = fragmentActivity;
    }

    public void setBuyList(List<MarketBuySellItem> list) {
        for (MarketBuySellItem A : list) {
            A.A(true);
        }
        this.f83248b.setBuyList(list);
    }

    public void setDepthOnClickListener(View.OnClickListener onClickListener) {
        this.f83255i.setOnClickListener(onClickListener);
    }

    public void setDepthText(String str) {
        this.f83256j.setText(str);
    }

    public void setNewestPrice(b.a aVar) {
        this.f83254h.e(aVar);
        this.f83253g.h();
        this.f83253g.setShowLegalPrice(this.f83260n);
    }

    public void setPresenter(TradeBasePresenter tradeBasePresenter) {
        this.f83250d = tradeBasePresenter;
    }

    public void setSellList(List<MarketBuySellItem> list) {
        for (MarketBuySellItem A : list) {
            A.A(true);
        }
        this.f83248b.setSellList(list);
    }

    public void setShowLegalPrice(boolean z11) {
        this.f83260n = z11;
        NewestPriceHorizontalView newestPriceHorizontalView = this.f83253g;
        if (newestPriceHorizontalView != null) {
            newestPriceHorizontalView.setShowLegalPrice(z11);
        }
    }

    public void setTradeBaseUI(z0 z0Var) {
        this.f83251e = z0Var;
    }

    public void setUI(i.d dVar) {
        this.f83249c = dVar;
    }

    public TradeTrendViewNew(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f83260n = true;
        j();
    }
}
