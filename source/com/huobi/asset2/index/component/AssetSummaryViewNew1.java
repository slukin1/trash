package com.huobi.asset2.index.component;

import al.p;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.widgets.NumAnimTextView;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.asset.widget.BottomLineTextView;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import gi.a;
import i6.m;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import uh.b;
import xh.q;
import xh.r;

public class AssetSummaryViewNew1 extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public NumAnimTextView f42658b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f42659c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f42660d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f42661e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42662f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f42663g;

    /* renamed from: h  reason: collision with root package name */
    public BottomLineTextView f42664h;

    /* renamed from: i  reason: collision with root package name */
    public View f42665i;

    /* renamed from: j  reason: collision with root package name */
    public String f42666j;

    /* renamed from: k  reason: collision with root package name */
    public String f42667k;

    /* renamed from: l  reason: collision with root package name */
    public View f42668l;

    /* renamed from: m  reason: collision with root package name */
    public LinearLayout f42669m;

    /* renamed from: n  reason: collision with root package name */
    public BalanceProfitLossData f42670n;

    public AssetSummaryViewNew1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(Void voidR) {
        AssetModuleConfig.a().N(getContext());
        a.k();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(Void voidR) {
        b.b(this.f42664h, getResources().getString(R$string.n_asset_add_total_tips), PixelUtils.a(300.0f));
    }

    public final void c(BalanceProfitLossData balanceProfitLossData) {
        String str;
        Boolean F = AssetModuleConfig.a().F();
        if (!Boolean.valueOf(F != null && F.booleanValue()).booleanValue()) {
            this.f42662f.setText("--");
            this.f42660d.setText("--");
            this.f42663g.setText("--");
        } else if (p.u()) {
            String todayProfitRate = balanceProfitLossData.getTodayProfitRate();
            if (TextUtils.isEmpty(todayProfitRate)) {
                str = "--";
            } else {
                str = m.Q(todayProfitRate, 2, 1);
                if (m.a(str.replace("%", "").replace("+", "")).compareTo(BigDecimal.ZERO) > 0) {
                    str = "+" + str;
                }
            }
            this.f42662f.setText(str);
            String todayProfit = balanceProfitLossData.getTodayProfit();
            this.f42666j = todayProfit;
            String j11 = p.j(todayProfit, "btc");
            this.f42666j = j11;
            if (TextUtils.isEmpty(j11)) {
                this.f42660d.setText("--");
            } else {
                this.f42660d.setText(e(this.f42666j, "btcusdt", TradeType.PRO));
            }
            if (TextUtils.isEmpty(balanceProfitLossData.getTotalAccumulateProfit())) {
                this.f42663g.setText("--");
            } else {
                this.f42663g.setText(e(p.j(balanceProfitLossData.getTotalAccumulateProfit(), "btc"), "btcusdt", TradeType.PRO));
            }
        } else {
            this.f42662f.setText(this.f42667k);
            this.f42660d.setText(this.f42667k);
            this.f42663g.setText(this.f42667k);
        }
    }

    public final void d(BalanceProfitLossData balanceProfitLossData) {
        if (p.u()) {
            String j11 = p.j(balanceProfitLossData.getTotalBalance(), "btc");
            String d11 = LegalCurrencyConfigUtil.d();
            if ("btc".equals(d11)) {
                this.f42658b.setNumber(j11);
                this.f42658b.j();
            } else if ("usdt".equals(d11)) {
                this.f42658b.setNumber(p.h(m.u0(LegalCurrencyConfigUtil.U(j11, false, "btcusdt", TradeType.PRO), 12, 2)));
                this.f42658b.j();
            } else {
                this.f42658b.setNumber(LegalCurrencyConfigUtil.D(j11, "btcusdt", TradeType.PRO));
                this.f42658b.j();
            }
        } else {
            this.f42658b.setText(this.f42667k);
        }
    }

    public final String e(String str, String str2, TradeType tradeType) {
        String d11 = LegalCurrencyConfigUtil.d();
        if (!"btc".equals(d11)) {
            if ("usdt".equals(d11)) {
                str = LegalCurrencyConfigUtil.M(m.a(LegalCurrencyConfigUtil.U(str, false, str2, tradeType)), "usd");
            } else {
                str = LegalCurrencyConfigUtil.D(str, str2, tradeType);
            }
        }
        return f(p.h(str));
    }

    public final String f(String str) {
        if (!m.a0(str)) {
            return str;
        }
        boolean z11 = m.a(str).compareTo(BigDecimal.ZERO) > 0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z11 ? "+" : "");
        sb2.append(str);
        return sb2.toString();
    }

    public final void g() {
        View findViewById = findViewById(R$id.ll_profit_analysis);
        this.f42668l = findViewById;
        Observable<Void> a11 = dw.a.a(findViewById);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new q(this));
        this.f42659c = (TextView) findViewById(R$id.today_pl_currency_title);
        this.f42661e = (TextView) findViewById(R$id.today_pl_currency_rate_title);
        this.f42664h = (BottomLineTextView) findViewById(R$id.today_position_pl_currency_title);
        this.f42665i = findViewById(R$id.today_position_pl_currency_layout);
        this.f42660d = (TextView) findViewById(R$id.today_pl_currency);
        this.f42662f = (TextView) findViewById(R$id.today_pl_currency_rate);
        this.f42663g = (TextView) findViewById(R$id.today_position_pl_currency);
        this.f42669m = (LinearLayout) findViewById(R$id.ll_open_profit);
        this.f42661e.setText(String.format(getResources().getString(R$string.n_balance_today_profit), new Object[]{getResources().getString(R$string.n_balance_asset_ratio)}));
        dw.a.a(this.f42665i).throttleFirst(300, timeUnit).subscribe(new r(this));
    }

    public final void h() {
        this.f42658b = (NumAnimTextView) findViewById(R$id.tv_total_asset);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void hideAmountChange(gh.b bVar) {
        setData(this.f42670n);
    }

    public void setData(BalanceProfitLossData balanceProfitLossData) {
        if (balanceProfitLossData != null) {
            this.f42670n = balanceProfitLossData;
            d(balanceProfitLossData);
            c(balanceProfitLossData);
        }
    }

    public void setOpenProfitClickListener(View.OnClickListener onClickListener) {
        this.f42669m.setOnClickListener(onClickListener);
    }

    public void setProfitOpen(boolean z11) {
        ViewUtil.m(this.f42668l, z11);
        ViewUtil.m(this.f42669m, !z11);
        if (!z11) {
            this.f42662f.setText("--");
            this.f42660d.setText("--");
            this.f42663g.setText("--");
        }
    }

    public AssetSummaryViewNew1(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f42667k = "*****";
        EventBus.d().p(this);
        LayoutInflater.from(context).inflate(R$layout.asset_summary_layout_new_1, this);
        h();
        g();
    }
}
