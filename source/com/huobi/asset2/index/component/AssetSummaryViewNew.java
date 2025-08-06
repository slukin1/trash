package com.huobi.asset2.index.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.asset.widget.BottomLineTextView;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import i6.m;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import qh.p0;
import rx.Observable;
import rx.Subscriber;
import uh.b;
import xh.e;
import xh.k;
import xh.l;
import xh.n;
import xh.o;
import xh.p;

public class AssetSummaryViewNew extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public AssetBalanceView f42639b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f42640c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f42641d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f42642e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42643f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f42644g;

    /* renamed from: h  reason: collision with root package name */
    public View f42645h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f42646i;

    /* renamed from: j  reason: collision with root package name */
    public BottomLineTextView f42647j;

    /* renamed from: k  reason: collision with root package name */
    public View f42648k;

    /* renamed from: l  reason: collision with root package name */
    public String f42649l;

    /* renamed from: m  reason: collision with root package name */
    public String f42650m;

    /* renamed from: n  reason: collision with root package name */
    public final LinearLayout f42651n;

    /* renamed from: o  reason: collision with root package name */
    public View f42652o;

    /* renamed from: p  reason: collision with root package name */
    public LinearLayout f42653p;

    /* renamed from: q  reason: collision with root package name */
    public BalanceProfitLossData f42654q;

    /* renamed from: r  reason: collision with root package name */
    public Double f42655r;

    public class a implements MotionLayout.k {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f42656b;

        public a(ImageView imageView) {
            this.f42656b = imageView;
        }

        public void onTransitionChange(MotionLayout motionLayout, int i11, int i12, float f11) {
        }

        public void onTransitionCompleted(MotionLayout motionLayout, int i11) {
            int i12;
            boolean z11 = R$id.end == i11;
            if (z11) {
                i12 = R$drawable.ic_asset_account_arrow_up;
            } else {
                i12 = R$drawable.ic_asset_account_arrow_down;
            }
            this.f42656b.setImageResource(i12);
            if (z11) {
                gi.a.y();
            }
        }

        public void onTransitionStarted(MotionLayout motionLayout, int i11, int i12) {
        }

        public void onTransitionTrigger(MotionLayout motionLayout, int i11, boolean z11, float f11) {
        }
    }

    public AssetSummaryViewNew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ AssetAccountListItemView s(List list, BalanceProfitLossData.AccountBalance accountBalance) {
        AssetAccountListItemView assetAccountListItemView = new AssetAccountListItemView(getContext());
        assetAccountListItemView.setData(accountBalance);
        if (this.f42651n.getChildCount() == list.size() - 1) {
            assetAccountListItemView.d(true);
        }
        return assetAccountListItemView;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(Void voidR) {
        AssetModuleConfig.a().N(getContext());
        gi.a.k();
        if (p0.n().k().displayGuideDot()) {
            BaseModuleConfig.a().w("app_assets_PLDailyPaper_RedDot_click", (HashMap) null);
            p0.n().k().reset();
            EventBus.d().k(p0.n().k());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u(Void voidR) {
        b.b(this.f42647j, getResources().getString(R$string.n_asset_add_total_tips), PixelUtils.a(300.0f));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(Void voidR) {
        if (this.f42645h.getVisibility() == 0) {
            AssetModuleConfig.a().N(getContext());
            gi.a.u();
            l();
        }
    }

    public final void g(List<BalanceProfitLossData.AccountBalance> list) {
        if (list != null && !list.isEmpty()) {
            this.f42651n.removeAllViews();
            Observable<R> map = Observable.from(list).filter(o.f61616b).filter(p.f61617b).map(new n(this, list));
            LinearLayout linearLayout = this.f42651n;
            Objects.requireNonNull(linearLayout);
            map.subscribe((Subscriber<? super R>) EasySubscriber.create(new e(linearLayout)));
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void h(BalanceProfitLossData balanceProfitLossData) {
        String str;
        Boolean F = AssetModuleConfig.a().F();
        if (!Boolean.valueOf(F != null && F.booleanValue()).booleanValue()) {
            this.f42643f.setText("--");
            this.f42641d.setText("--");
            this.f42646i.setText("--");
        } else if (al.p.u()) {
            String todayProfitRate = balanceProfitLossData.getTodayProfitRate();
            if (TextUtils.isEmpty(todayProfitRate)) {
                str = "--";
            } else {
                str = m.Q(todayProfitRate, 2, 1);
                if (m.a(str.replace("%", "").replace("+", "")).compareTo(BigDecimal.ZERO) > 0) {
                    str = "+" + str;
                }
            }
            this.f42643f.setText(str);
            String todayProfit = balanceProfitLossData.getTodayProfit();
            this.f42649l = todayProfit;
            String j11 = al.p.j(todayProfit, "btc");
            this.f42649l = j11;
            if (TextUtils.isEmpty(j11)) {
                this.f42641d.setText("--");
            } else {
                this.f42641d.setText(j(this.f42649l, "btcusdt", TradeType.PRO));
            }
            if (TextUtils.isEmpty(balanceProfitLossData.getTotalAccumulateProfit())) {
                this.f42646i.setText("--");
            } else {
                this.f42646i.setText(j(al.p.j(balanceProfitLossData.getTotalAccumulateProfit(), "btc"), "btcusdt", TradeType.PRO));
            }
        } else {
            this.f42643f.setText(this.f42650m);
            this.f42641d.setText(this.f42650m);
            this.f42646i.setText(this.f42650m);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void hideAmountChange(gh.b bVar) {
        setData(this.f42654q);
    }

    public final void i(BalanceProfitLossData balanceProfitLossData) {
        if (al.p.u()) {
            String j11 = al.p.j(balanceProfitLossData.getTotalBalance(), "btc");
            String d11 = LegalCurrencyConfigUtil.d();
            if ("btc".equals(d11)) {
                this.f42639b.setTextNumber(j11);
            } else if ("usdt".equals(d11)) {
                this.f42639b.setTextNumber(al.p.h(m.u0(LegalCurrencyConfigUtil.U(j11, false, "btcusdt", TradeType.PRO), 12, 2)));
            } else {
                this.f42639b.setTextNumber(LegalCurrencyConfigUtil.D(j11, "btcusdt", TradeType.PRO));
            }
        } else {
            this.f42639b.setText(this.f42650m);
        }
    }

    public final String j(String str, String str2, TradeType tradeType) {
        String d11 = LegalCurrencyConfigUtil.d();
        if (!"btc".equals(d11)) {
            if ("usdt".equals(d11)) {
                str = LegalCurrencyConfigUtil.M(m.a(LegalCurrencyConfigUtil.U(str, false, str2, tradeType)), "usd");
            } else {
                str = LegalCurrencyConfigUtil.D(str, str2, tradeType);
            }
        }
        return k(al.p.h(str));
    }

    public final String k(String str) {
        return m.W(str, LegalCurrencyConfigUtil.x(), false);
    }

    public final void l() {
        this.f42645h.setVisibility(8);
    }

    public final void m() {
        ((MotionLayout) findViewById(R$id.motion_layout)).N(new a((ImageView) findViewById(R$id.iv_fold_icon)));
    }

    public final void n() {
        View findViewById = findViewById(R$id.ll_profit_analysis);
        this.f42652o = findViewById;
        Observable<Void> a11 = dw.a.a(findViewById);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new xh.m(this));
        this.f42640c = (TextView) findViewById(R$id.today_pl_currency_title);
        this.f42642e = (TextView) findViewById(R$id.today_pl_currency_rate_title);
        this.f42647j = (BottomLineTextView) findViewById(R$id.today_position_pl_currency_title);
        this.f42648k = findViewById(R$id.today_position_pl_currency_layout);
        this.f42644g = (RelativeLayout) findViewById(R$id.layout_currency_rate);
        this.f42645h = findViewById(R$id.v_asset_count_dot);
        x();
        this.f42641d = (TextView) findViewById(R$id.today_pl_currency);
        this.f42643f = (TextView) findViewById(R$id.today_pl_currency_rate);
        this.f42646i = (TextView) findViewById(R$id.today_position_pl_currency);
        this.f42653p = (LinearLayout) findViewById(R$id.ll_open_profit);
        this.f42642e.setText(String.format(getResources().getString(R$string.n_balance_today_profit), new Object[]{getResources().getString(R$string.n_balance_asset_ratio)}));
        dw.a.a(this.f42648k).throttleFirst(300, timeUnit).subscribe(new l(this));
    }

    public final void o() {
        this.f42639b = (AssetBalanceView) findViewById(R$id.tv_total_asset);
    }

    public boolean p() {
        return this.f42652o.getVisibility() == 0;
    }

    public void setData(BalanceProfitLossData balanceProfitLossData) {
        if (balanceProfitLossData != null) {
            this.f42654q = balanceProfitLossData;
            i(balanceProfitLossData);
            h(balanceProfitLossData);
            g(al.a.e(getContext(), balanceProfitLossData));
        }
    }

    public void setOpenProfitClickListener(View.OnClickListener onClickListener) {
        this.f42653p.setOnClickListener(onClickListener);
    }

    public void setProfitOpen(boolean z11) {
        ViewUtil.m(this.f42652o, z11);
        ViewUtil.m(this.f42653p, !z11);
        if (!z11) {
            this.f42643f.setText("--");
            this.f42641d.setText("--");
            this.f42646i.setText("--");
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    public void showProfitRateDot(Double d11) {
        if (d11 != null) {
            if (this.f42655r == null) {
                this.f42655r = d11;
            } else if (m.a(String.valueOf(Math.abs(d11.doubleValue() - this.f42655r.doubleValue()))).compareTo(m.a("0.05")) >= 0) {
                this.f42655r = d11;
                this.f42645h.setVisibility(0);
            }
        }
    }

    public void w() {
        setData(this.f42654q);
    }

    public final void x() {
        dw.a.a(this.f42644g).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new k(this));
    }

    public void y(String str) {
        this.f42640c.setText(getResources().getString(R$string.n_today_profit));
        this.f42647j.setBottomLineText(getResources().getString(R$string.n_mining_total_profit));
    }

    public AssetSummaryViewNew(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f42650m = "*****";
        EventBus.d().p(this);
        LayoutInflater.from(context).inflate(R$layout.asset_summary_layout_list_new, this);
        o();
        n();
        m();
        this.f42651n = (LinearLayout) findViewById(R$id.summary_list);
    }
}
