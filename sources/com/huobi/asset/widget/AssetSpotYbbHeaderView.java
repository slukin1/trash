package com.huobi.asset.widget;

import al.p;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.YbbUserAssetInfoData;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.ui.g7;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import dw.a;
import i6.m;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import u6.g;
import vh.a0;
import vh.b0;
import vh.c0;
import vh.d0;
import vh.e0;
import vh.f0;
import vh.g0;

public class AssetSpotYbbHeaderView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f42461b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f42462c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f42463d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f42464e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42465f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f42466g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f42467h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f42468i;

    /* renamed from: j  reason: collision with root package name */
    public View f42469j;

    /* renamed from: k  reason: collision with root package name */
    public View f42470k;

    /* renamed from: l  reason: collision with root package name */
    public View f42471l;

    /* renamed from: m  reason: collision with root package name */
    public View f42472m;

    /* renamed from: n  reason: collision with root package name */
    public View f42473n;

    /* renamed from: o  reason: collision with root package name */
    public String f42474o;

    public AssetSpotYbbHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void o(View view) {
        HBBaseWebActivity.showWebView(view.getContext(), BaseModuleConfig.a().W() + "financial/earn/h5/saveings", (String) null, (String) null, true);
        AssetModuleConfig.a().track("app_spot_auto_transfer_switch_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p() {
        AssetModuleConfig.a().E0(Boolean.TRUE);
        this.f42471l.setVisibility(8);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q(View view) {
        new g7(getContext(), (g) null, new d0(this)).f();
        AssetModuleConfig.a().track("app_spot_income_analysis_open_button_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(Void voidR) {
        Context context = getContext();
        if (context instanceof Activity) {
            BaseModuleConfig.a().S((Activity) context, AssetAccountType.HUOBI_EARN.toString());
        }
        AssetModuleConfig.a().track("app_spot_flexible_entrance_click", (HashMap) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(Void voidR) {
        v(getContext(), getContext().getString(R$string.income_today_tips));
        AssetModuleConfig.a().track("app_spot_income_illstrate_icon_click", (HashMap) null);
    }

    @SuppressLint({"SetTextI18n"})
    private void setYbbData(YbbUserAssetInfoData ybbUserAssetInfoData) {
        if (ybbUserAssetInfoData == null) {
            this.f42468i.setText("");
            this.f42462c.setText(this.f42474o);
            this.f42464e.setText(this.f42474o);
            return;
        }
        String d11 = LegalCurrencyConfigUtil.d();
        Locale locale = Locale.US;
        String upperCase = d11.toUpperCase(locale);
        int p11 = k.C().p("btc");
        String digitalAssetTotalAmountByConvertCurrency = ybbUserAssetInfoData.getDigitalAssetTotalAmountByConvertCurrency();
        String D = LegalCurrencyConfigUtil.D(digitalAssetTotalAmountByConvertCurrency, "btcusdt", TradeType.PRO);
        String i11 = p.i(m.a(digitalAssetTotalAmountByConvertCurrency).toPlainString(), p11);
        String plainString = m.a(D).toPlainString();
        this.f42468i.setText(" BTC");
        this.f42462c.setText(i11);
        if ("btc".toUpperCase(locale).equals(upperCase)) {
            TextView textView = this.f42464e;
            textView.setText(i11 + " " + upperCase);
            return;
        }
        TextView textView2 = this.f42464e;
        textView2.setText(p.h(plainString) + " " + upperCase);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(Void voidR) {
        AssetModuleConfig.a().d1(getContext());
        AssetModuleConfig.a().track("app_spot_income_analysis_entrance_click", (HashMap) null);
    }

    public final void h() {
        this.f42470k.setOnClickListener(b0.f61022b);
        this.f42471l.setOnClickListener(new a0(this));
        Observable<Void> a11 = a.a(this.f42473n);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new e0(this));
        a.a(this.f42472m).throttleFirst(1, timeUnit).subscribe(new g0(this));
        a.a(this.f42469j).throttleFirst(1, timeUnit).subscribe(new f0(this));
    }

    public final void i(boolean z11) {
        Boolean F = AssetModuleConfig.a().F();
        Boolean valueOf = Boolean.valueOf(F != null && F.booleanValue());
        ViewUtil.m(this.f42471l, true ^ valueOf.booleanValue());
        ViewUtil.m(this.f42469j, valueOf.booleanValue());
        ViewUtil.n(this.f42470k, z11);
        if (z11) {
            AssetModuleConfig.a().track("app_spot_auto_transfer_switch_exposure", (HashMap) null);
        }
    }

    public final String j(String str) {
        if (!m.a0(str)) {
            return str;
        }
        String str2 = m.a(str).compareTo(BigDecimal.ZERO) > 0 ? "+" : "";
        return str2 + str;
    }

    public final String k(String str) {
        if (!m.a0(str)) {
            return str;
        }
        String str2 = m.a(str).compareTo(BigDecimal.ZERO) > 0 ? "+" : "";
        String str3 = "%";
        if (m.a(str).compareTo(m.a("10000")) > 0) {
            str3 = "⁺" + str3;
            str = "10000";
        }
        if (m.a(str).compareTo(m.a("-100")) < 0) {
            str = "-100";
        }
        return str2 + str + str3;
    }

    public void l(boolean z11) {
        String string = getContext().getResources().getString(R$string.balance_hide_star);
        this.f42461b.setText(string);
        this.f42463d.setText(string);
        this.f42465f.setText(string);
        this.f42466g.setText(string);
        this.f42462c.setText(string);
        this.f42464e.setText(string);
        i(z11);
    }

    public final void m() {
        this.f42461b.setText(this.f42474o);
        this.f42463d.setText(this.f42474o);
        this.f42465f.setText(this.f42474o);
        this.f42466g.setText(this.f42474o);
        this.f42462c.setText(this.f42474o);
        this.f42464e.setText(this.f42474o);
        this.f42467h.setText("");
        this.f42468i.setText("");
    }

    public final void n(Context context) {
        LayoutInflater.from(context).inflate(R$layout.include_asset_spot_ybb_header, this);
        this.f42461b = (TextView) findViewById(R$id.asset_header_spot_balance);
        this.f42463d = (TextView) findViewById(R$id.asset_header_spot_balance_equivalent);
        this.f42465f = (TextView) findViewById(R$id.asset_header_spot_earnings);
        this.f42466g = (TextView) findViewById(R$id.asset_header_spot_earnings_yield);
        this.f42469j = findViewById(R$id.asset_header_spot_earnings_layout);
        this.f42471l = findViewById(R$id.asset_header_spot_open_pl_analysis);
        this.f42472m = findViewById(R$id.asset_header_spot_earnings_font_hint);
        this.f42467h = (TextView) findViewById(R$id.asset_header_spot_spot_btc);
        this.f42462c = (TextView) findViewById(R$id.asset_header_spot_ybb);
        this.f42464e = (TextView) findViewById(R$id.asset_header_spot_ybb_equivalent);
        this.f42470k = findViewById(R$id.asset_header_spot_ybb_transferred_to);
        this.f42473n = findViewById(R$id.asset_header_spot_ybb_title_layout);
        this.f42468i = (TextView) findViewById(R$id.asset_header_spot_ybb_btc);
        this.f42474o = context.getResources().getString(R$string.global_crossbar);
        m();
    }

    public final void v(Context context, String str) {
        String string = context.getString(R$string.n_introduction);
        FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
        new DialogUtils.b.d(fragmentActivity).c1(string).i1(5).R0(str).P0(context.getString(R$string.contract_trade_i_know)).T0(true).x0(false).q0(false).Q0(c0.f61025a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
    }

    @SuppressLint({"SetTextI18n"})
    public void w(String str, String str2, String str3, String str4, YbbUserAssetInfoData ybbUserAssetInfoData, boolean z11) {
        String d11 = LegalCurrencyConfigUtil.d();
        String i11 = p.i(m.a(str).toPlainString(), k.C().p("btc"));
        String plainString = m.a(str2).toPlainString();
        this.f42461b.setText(i11);
        if ("btc".equals(d11)) {
            TextView textView = this.f42463d;
            textView.setText(i11 + " " + d11.toUpperCase(Locale.US));
        } else if ("usdt".equals(d11)) {
            String u02 = m.u0(LegalCurrencyConfigUtil.U(i11, false, "btcusdt", TradeType.PRO), 12, 2);
            TextView textView2 = this.f42463d;
            textView2.setText(u02 + " " + d11.toUpperCase(Locale.US));
        } else {
            TextView textView3 = this.f42463d;
            textView3.setText(plainString + " " + d11.toUpperCase(Locale.US));
        }
        TextView textView4 = this.f42465f;
        textView4.setText(j(p.h(str3)) + " " + d11.toUpperCase(Locale.US));
        this.f42466g.setText(k(p.h(str4)));
        this.f42467h.setText(" BTC");
        setYbbData(ybbUserAssetInfoData);
        i(z11);
    }

    public AssetSpotYbbHeaderView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        n(context);
        h();
    }
}
