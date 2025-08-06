package com.huobi.asset2.index.component;

import al.p;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
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
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.widgets.AutoSizeNumberAnimView;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.asset.widget.BottomLineTextView;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscriber;
import uh.b;
import xh.d;
import xh.e;
import xh.f;
import xh.g;
import xh.i;
import xh.j;

public class AssetSummaryView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public AutoSizeNumberAnimView f42620b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f42621c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f42622d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f42623e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42624f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f42625g;

    /* renamed from: h  reason: collision with root package name */
    public View f42626h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f42627i;

    /* renamed from: j  reason: collision with root package name */
    public BottomLineTextView f42628j;

    /* renamed from: k  reason: collision with root package name */
    public View f42629k;

    /* renamed from: l  reason: collision with root package name */
    public final LinearLayout f42630l;

    /* renamed from: m  reason: collision with root package name */
    public String f42631m;

    /* renamed from: n  reason: collision with root package name */
    public String f42632n;

    /* renamed from: o  reason: collision with root package name */
    public View f42633o;

    /* renamed from: p  reason: collision with root package name */
    public LinearLayout f42634p;

    /* renamed from: q  reason: collision with root package name */
    public BalanceProfitLossData f42635q;

    /* renamed from: r  reason: collision with root package name */
    public Double f42636r;

    public class a implements MotionLayout.k {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f42637b;

        public a(ImageView imageView) {
            this.f42637b = imageView;
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
            this.f42637b.setImageResource(i12);
            if (z11) {
                gi.a.y();
            }
        }

        public void onTransitionStarted(MotionLayout motionLayout, int i11, int i12) {
        }

        public void onTransitionTrigger(MotionLayout motionLayout, int i11, boolean z11, float f11) {
        }
    }

    public AssetSummaryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ AssetAccountListItemView q(List list, BalanceProfitLossData.AccountBalance accountBalance) {
        AssetAccountListItemView assetAccountListItemView = new AssetAccountListItemView(getContext());
        assetAccountListItemView.setData(accountBalance);
        if (this.f42630l.getChildCount() == list.size() - 1) {
            assetAccountListItemView.d(true);
        }
        return assetAccountListItemView;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(Void voidR) {
        AssetModuleConfig.a().N(getContext());
        gi.a.k();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(Void voidR) {
        b.b(this.f42628j, getResources().getString(R$string.n_asset_add_total_tips), PixelUtils.a(300.0f));
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void t(View view) {
        Log.i("AutoSizeNumberAnimView", "onClick: 眼睛");
        p.v();
        boolean u11 = p.u();
        EventBus.d().k(new gh.b(u11));
        if (!u11) {
            gi.a.j();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u(Void voidR) {
        if (this.f42626h.getVisibility() == 0) {
            AssetModuleConfig.a().N(getContext());
            gi.a.u();
            l();
        }
    }

    public final void g(List<BalanceProfitLossData.AccountBalance> list) {
        if (list != null && !list.isEmpty()) {
            this.f42630l.removeAllViews();
            Observable<R> map = Observable.from(list).filter(j.f61610b).map(new i(this, list));
            LinearLayout linearLayout = this.f42630l;
            Objects.requireNonNull(linearLayout);
            map.subscribe((Subscriber<? super R>) EasySubscriber.create(new e(linearLayout)));
        }
    }

    public final void h(BalanceProfitLossData balanceProfitLossData) {
        String str;
        int i11;
        Boolean F = AssetModuleConfig.a().F();
        if (!Boolean.valueOf(F != null && F.booleanValue()).booleanValue()) {
            this.f42624f.setText("--");
            this.f42622d.setText("--");
            this.f42627i.setText("--");
        } else if (p.u()) {
            String todayProfitRate = balanceProfitLossData.getTodayProfitRate();
            if (TextUtils.isEmpty(todayProfitRate)) {
                i11 = getResources().getColor(w.e());
                str = "--";
            } else {
                String Q = m.Q(todayProfitRate, 2, 1);
                String replace = Q.replace("%", "").replace("+", "");
                if (m.a(replace).compareTo(BigDecimal.ZERO) > 0) {
                    Q = "+" + Q;
                }
                int color = getResources().getColor(w.a(replace));
                str = Q;
                i11 = color;
            }
            this.f42624f.setTextColor(i11);
            this.f42624f.setText(str);
            String todayProfit = balanceProfitLossData.getTodayProfit();
            this.f42631m = todayProfit;
            this.f42631m = p.j(todayProfit, "btc");
            this.f42622d.setTextColor(i11);
            if (TextUtils.isEmpty(this.f42631m)) {
                this.f42622d.setText("--");
            } else {
                this.f42622d.setText(j(this.f42631m, "btcusdt", TradeType.PRO));
            }
            if (TextUtils.isEmpty(balanceProfitLossData.getTotalAccumulateProfit())) {
                this.f42627i.setText("--");
                this.f42627i.setTextColor(getResources().getColor(w.e()));
                return;
            }
            this.f42627i.setTextColor(getResources().getColor(w.a(balanceProfitLossData.getTotalAccumulateProfit())));
            this.f42627i.setText(j(balanceProfitLossData.getTotalAccumulateProfit(), "btcusdt", TradeType.PRO));
        } else {
            int color2 = getContext().getResources().getColor(w.e());
            this.f42624f.setTextColor(color2);
            this.f42622d.setTextColor(color2);
            this.f42627i.setTextColor(color2);
            this.f42624f.setText(this.f42632n);
            this.f42622d.setText(this.f42632n);
            this.f42627i.setText(this.f42632n);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void hideAmountChange(gh.b bVar) {
        setData(this.f42635q);
    }

    public final void i(BalanceProfitLossData balanceProfitLossData) {
        if (p.u()) {
            String j11 = p.j(balanceProfitLossData.getTotalBalance(), "btc");
            String d11 = LegalCurrencyConfigUtil.d();
            if ("btc".equals(d11)) {
                this.f42620b.setTextValue(j11);
                this.f42620b.g();
            } else if ("usdt".equals(d11)) {
                this.f42620b.setTextValue(p.h(m.u0(LegalCurrencyConfigUtil.U(j11, false, "btcusdt", TradeType.PRO), 12, 2)));
                this.f42620b.g();
            } else {
                this.f42620b.setTextValue(LegalCurrencyConfigUtil.D(j11, "btcusdt", TradeType.PRO));
                this.f42620b.g();
            }
        } else {
            this.f42620b.setText(this.f42632n);
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
        return k(p.h(str));
    }

    public final String k(String str) {
        if (!m.a0(str)) {
            return str;
        }
        boolean z11 = m.a(str).compareTo(BigDecimal.ZERO) > 0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z11 ? "+" : "");
        sb2.append(str);
        return sb2.toString();
    }

    public final void l() {
        this.f42626h.setVisibility(8);
    }

    public final void m() {
        ((MotionLayout) findViewById(R$id.motion_layout)).N(new a((ImageView) findViewById(R$id.iv_fold_icon)));
    }

    public final void n() {
        View findViewById = findViewById(R$id.ll_profit_analysis);
        this.f42633o = findViewById;
        Observable<Void> a11 = dw.a.a(findViewById);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new g(this));
        this.f42621c = (TextView) findViewById(R$id.today_pl_currency_title);
        this.f42623e = (TextView) findViewById(R$id.today_pl_currency_rate_title);
        this.f42628j = (BottomLineTextView) findViewById(R$id.today_position_pl_currency_title);
        this.f42629k = findViewById(R$id.today_position_pl_currency_layout);
        this.f42625g = (RelativeLayout) findViewById(R$id.layout_currency_rate);
        this.f42626h = findViewById(R$id.v_asset_count_dot);
        w();
        this.f42622d = (TextView) findViewById(R$id.today_pl_currency);
        this.f42624f = (TextView) findViewById(R$id.today_pl_currency_rate);
        this.f42627i = (TextView) findViewById(R$id.today_position_pl_currency);
        this.f42634p = (LinearLayout) findViewById(R$id.ll_open_profit);
        this.f42623e.setText(String.format(getResources().getString(R$string.n_balance_today_profit), new Object[]{getResources().getString(R$string.n_balance_asset_ratio)}));
        dw.a.a(this.f42629k).throttleFirst(300, timeUnit).subscribe(new xh.h(this));
    }

    public final void o() {
        AutoSizeNumberAnimView autoSizeNumberAnimView = (AutoSizeNumberAnimView) findViewById(R$id.tv_total_asset);
        this.f42620b = autoSizeNumberAnimView;
        autoSizeNumberAnimView.setTextColor(getResources().getColor(R$color.baseColorPrimaryText));
        this.f42620b.setDefaultTextSize(getResources().getDimensionPixelOffset(R$dimen.global_text_size_24));
        this.f42620b.setMaxTextLength(getResources().getDimensionPixelOffset(R$dimen.dimen_170));
        this.f42620b.setOnClickListener(d.f61603b);
    }

    public void setData(BalanceProfitLossData balanceProfitLossData) {
        if (balanceProfitLossData != null) {
            this.f42635q = balanceProfitLossData;
            i(balanceProfitLossData);
            h(balanceProfitLossData);
            g(al.a.e(getContext(), balanceProfitLossData));
        }
    }

    public void setOpenProfitClickListener(View.OnClickListener onClickListener) {
        this.f42634p.setOnClickListener(onClickListener);
    }

    public void setProfitOpen(boolean z11) {
        ViewUtil.m(this.f42633o, z11);
        ViewUtil.m(this.f42634p, !z11);
        if (!z11) {
            this.f42624f.setText("--");
            this.f42622d.setText("--");
            this.f42627i.setText("--");
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    public void showProfitRateDot(Double d11) {
        if (d11 != null) {
            if (this.f42636r == null) {
                this.f42636r = d11;
            } else if (m.a(String.valueOf(Math.abs(d11.doubleValue() - this.f42636r.doubleValue()))).compareTo(m.a("0.05")) >= 0) {
                this.f42636r = d11;
                this.f42626h.setVisibility(0);
            }
        }
    }

    public void v() {
        setData(this.f42635q);
    }

    public final void w() {
        dw.a.a(this.f42625g).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new f(this));
    }

    public void x() {
        this.f42620b.setOpenEyes(p.u());
    }

    public void y(String str) {
        this.f42621c.setText(String.format(getResources().getString(R$string.n_balance_today_profit), new Object[]{str}));
        BottomLineTextView bottomLineTextView = this.f42628j;
        bottomLineTextView.setBottomLineText(getResources().getString(R$string.n_mining_total_profit) + String.format(getResources().getString(R$string.n_asset_borrow_brackets), new Object[]{str}));
    }

    public AssetSummaryView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f42632n = "*****";
        EventBus.d().p(this);
        LayoutInflater.from(context).inflate(R$layout.asset_summary_layout, this);
        o();
        n();
        m();
        this.f42630l = (LinearLayout) findViewById(R$id.summary_list);
    }
}
