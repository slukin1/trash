package com.huobi.finance.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.n;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.widgets.NumberAnimView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$font;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Map;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BalanceAndProfitView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public Context f46279b;

    /* renamed from: c  reason: collision with root package name */
    public NumberAnimView f46280c;

    /* renamed from: d  reason: collision with root package name */
    public NumberAnimView f46281d;

    /* renamed from: e  reason: collision with root package name */
    public String f46282e;

    /* renamed from: f  reason: collision with root package name */
    public String f46283f;

    /* renamed from: g  reason: collision with root package name */
    public String f46284g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f46285h;

    /* renamed from: i  reason: collision with root package name */
    public NumberAnimView f46286i;

    /* renamed from: j  reason: collision with root package name */
    public NumberAnimView f46287j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f46288k;

    /* renamed from: l  reason: collision with root package name */
    public View f46289l;

    /* renamed from: m  reason: collision with root package name */
    public c f46290m;

    /* renamed from: n  reason: collision with root package name */
    public String f46291n;

    /* renamed from: o  reason: collision with root package name */
    public String f46292o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f46293p;

    /* renamed from: q  reason: collision with root package name */
    public View f46294q;

    /* renamed from: r  reason: collision with root package name */
    public String f46295r;

    /* renamed from: s  reason: collision with root package name */
    public r7 f46296s;

    /* renamed from: t  reason: collision with root package name */
    public View f46297t;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            BaseModuleConfig.a().b("3128", (Map<String, Object>) null);
            AssetModuleConfig.a().N(BalanceAndProfitView.this.f46279b);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (BalanceAndProfitView.this.f46290m != null) {
                BalanceAndProfitView.this.f46290m.a();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface c {
        void a();
    }

    public static class d implements NumberAnimView.b {
        public d() {
        }

        public String a(String str) {
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

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public BalanceAndProfitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q(View view) {
        DialogUtils.X((FragmentActivity) oa.a.g().b(), this.f46279b.getString(R$string.n_option_delivery_tip), this.f46295r, (String) null, this.f46279b.getString(R$string.n_known), ad.b.f3517a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ String r(String str) {
        if (!m.a0(str)) {
            return str;
        }
        return "≈" + str + " " + LegalCurrencyConfigUtil.y().toUpperCase(Locale.US);
    }

    public static /* synthetic */ String s(String str) {
        if (!m.a0(str)) {
            return str;
        }
        String str2 = m.a(str).compareTo(BigDecimal.ZERO) > 0 ? "+" : "";
        return str2 + str;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void t(Context context, View view) {
        DialogUtils.X((FragmentActivity) oa.a.g().b(), getResources().getString(R$string.setting_quickly_withdraw_dialog_title), getResources().getString(R$string.income_today_tips), "", context.getString(R$string.otc_ppace_order_dialog_btn_know), ad.b.f3517a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ BalanceProfitLossData u(Map map, BalanceProfitLossData balanceProfitLossData) {
        return balanceProfitLossData;
    }

    public final void A() {
        String upperCase = LegalCurrencyConfigUtil.y().toUpperCase(Locale.US);
        this.f46293p.setText(getResources().getString(R$string.n_balance_today_profit, new Object[]{StringUtils.i(upperCase)}));
    }

    public void j() {
        y(this.f46286i, (String) null);
        y(this.f46287j, (String) null);
        y(this.f46280c, (String) null);
        y(this.f46281d, (String) null);
        ViewUtil.m(this.f46294q, false);
        this.f46283f = "";
        this.f46284g = "";
        this.f46291n = "";
        this.f46292o = "";
        this.f46295r = null;
    }

    public final void k(BalanceProfitLossData balanceProfitLossData) {
        String totalBalance = balanceProfitLossData.getTotalBalance();
        this.f46291n = totalBalance;
        String u02 = m.u0(totalBalance, 12, 8);
        this.f46291n = u02;
        this.f46292o = LegalCurrencyConfigUtil.D(u02, "btcusdt", TradeType.PRO);
        if (!balanceProfitLossData.isHideAssetAmount()) {
            y(this.f46286i, this.f46291n);
            y(this.f46287j, this.f46292o);
            if (this.f46296s == null) {
                this.f46296s = new r7(this.f46279b);
            }
            String a11 = this.f46296s.a(balanceProfitLossData.getProfitAccountBalanceList());
            this.f46295r = a11;
            ViewUtil.m(this.f46294q, !TextUtils.isEmpty(a11));
        }
    }

    public final void l(BalanceProfitLossData balanceProfitLossData) {
        n(balanceProfitLossData.isHideAssetAmount());
        k(balanceProfitLossData);
        m(balanceProfitLossData);
    }

    public final void m(BalanceProfitLossData balanceProfitLossData) {
        this.f46283f = LegalCurrencyConfigUtil.D(balanceProfitLossData.getTodayProfit(), "btcusdt", TradeType.PRO);
        String todayProfitRate = balanceProfitLossData.getTodayProfitRate();
        if (TextUtils.isEmpty(todayProfitRate)) {
            this.f46284g = "";
        } else {
            this.f46284g = m.Q(todayProfitRate, 2, 1).replace("%", "");
        }
        if (!balanceProfitLossData.isHideAssetAmount()) {
            y(this.f46280c, this.f46283f);
            y(this.f46281d, this.f46284g);
        }
    }

    public void n(boolean z11) {
        if (z11) {
            this.f46280c.setText(this.f46282e);
            this.f46281d.setText(this.f46282e);
            this.f46286i.setText(this.f46282e);
            this.f46287j.setText(this.f46282e);
            return;
        }
        z(this.f46280c, this.f46283f, false);
        z(this.f46281d, this.f46284g, false);
        z(this.f46286i, this.f46291n, false);
        z(this.f46287j, this.f46292o, false);
    }

    public final void o() {
        View findViewById = findViewById(R$id.iv_total_balance_tip);
        this.f46294q = findViewById;
        findViewById.setOnClickListener(new i1(this));
        this.f46285h = (LinearLayout) findViewById(R$id.total_balance_header_balance_parent);
        this.f46286i = (NumberAnimView) findViewById(R$id.total_balance_header_balance);
        this.f46287j = (NumberAnimView) findViewById(R$id.total_balance_header_cny);
        this.f46286i.setTextColor(getResources().getColor(R$color.balance_main_text_color));
        this.f46286i.setTextSize(getResources().getDimensionPixelOffset(R$dimen.global_text_size_28));
        this.f46287j.setTextColor(getResources().getColor(R$color.balance_margin_text_color));
        this.f46287j.setTextSize(getResources().getDimensionPixelOffset(R$dimen.global_text_size_12));
        this.f46287j.setCallback(k1.f47196a);
        this.f46293p = (TextView) findViewById(R$id.tv_title);
    }

    public final void p(Context context) {
        this.f46279b = context;
        LayoutInflater.from(context).inflate(R$layout.layout_profit_and_loss, this);
        this.f46282e = getResources().getString(R$string.balance_hide_star);
        View findViewById = findViewById(R$id.profit_and_loss);
        this.f46289l = findViewById;
        findViewById.setOnClickListener(new a());
        View findViewById2 = findViewById(R$id.ll_open_analysis);
        this.f46297t = findViewById2;
        findViewById2.setOnClickListener(new b());
        o();
        NumberAnimView numberAnimView = (NumberAnimView) findViewById(R$id.tv_amount);
        this.f46280c = numberAnimView;
        numberAnimView.setText("--");
        NumberAnimView numberAnimView2 = (NumberAnimView) findViewById(R$id.tv_ratio);
        this.f46281d = numberAnimView2;
        numberAnimView2.setText("--");
        this.f46280c.setTextSize(getResources().getDimensionPixelOffset(R$dimen.global_text_size_16));
        this.f46280c.setTextColor(ContextCompat.getColor(this.f46279b, R$color.balance_main_text_color));
        this.f46280c.getPaint().setTypeface(ResourcesCompat.h(context, R$font.roboto_medium));
        this.f46281d.setTextSize(getResources().getDimensionPixelOffset(R$dimen.global_text_size_14));
        this.f46281d.setTextColor(ContextCompat.getColor(this.f46279b, R$color.balance_margin_text_color));
        this.f46280c.setCallback(l1.f47216a);
        this.f46281d.setCallback(new d((a) null));
        findViewById(R$id.iv_tip).setOnClickListener(new j1(this, context));
    }

    public void setCallback(c cVar) {
        this.f46290m = cVar;
    }

    public final void w() {
        ViewUtil.m(this.f46297t, !this.f46288k);
        ViewUtil.m(this.f46289l, this.f46288k);
        if (this.f46288k) {
            n.o().D(this.f46289l);
        } else {
            n.o().D(this.f46297t);
        }
    }

    public void x(boolean z11) {
        this.f46288k = z11;
        w();
        A();
        Observable.zip(LegalCurrencyConfigUtil.f(false), v7.b.a().getBalanceProfitLoss().b(), o1.f47259b).doOnNext(n1.f47244b).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(EasySubscriber.create(new m1(this)));
    }

    public final void y(NumberAnimView numberAnimView, String str) {
        z(numberAnimView, str, true);
    }

    public final void z(NumberAnimView numberAnimView, String str, boolean z11) {
        if (TextUtils.isEmpty(str)) {
            numberAnimView.setText("--");
        } else if (z11) {
            numberAnimView.setNumber(m.a(str));
            numberAnimView.f();
        } else {
            numberAnimView.setText(str);
        }
    }

    public BalanceAndProfitView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f46283f = "";
        this.f46284g = "";
        p(context);
    }
}
