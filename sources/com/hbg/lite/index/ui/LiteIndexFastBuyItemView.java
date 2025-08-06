package com.hbg.lite.index.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.network.otc.core.bean.MarketMergedInfo;
import com.hbg.lib.network.otc.core.bean.OtcMarketCoinInfo;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lite.R$color;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$raw;
import com.hbg.lite.R$string;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import java.util.HashMap;
import java.util.Locale;
import ra.c;
import va.b;

public class LiteIndexFastBuyItemView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f77125b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f77126c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f77127d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f77128e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f77129f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f77130g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f77131h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f77132i;

    /* renamed from: j  reason: collision with root package name */
    public MarketMergedInfo f77133j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f77134k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f77135l;

    /* renamed from: m  reason: collision with root package name */
    public a f77136m;

    /* renamed from: n  reason: collision with root package name */
    public LinearLayout f77137n;

    /* renamed from: o  reason: collision with root package name */
    public ConstraintLayout f77138o;

    /* renamed from: p  reason: collision with root package name */
    public SafeLottieView f77139p;

    /* renamed from: q  reason: collision with root package name */
    public FrameLayout f77140q;

    /* renamed from: r  reason: collision with root package name */
    public ConstraintLayout f77141r;

    public interface a {
        void W4(String str);

        void j8(int i11, int i12);
    }

    public LiteIndexFastBuyItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void e(View view) {
        MarketMergedInfo marketMergedInfo;
        a aVar = this.f77136m;
        if (!(aVar == null || (marketMergedInfo = this.f77133j) == null)) {
            aVar.j8(marketMergedInfo.getCoinId(), this.f77133j.getCurrencyId());
        }
        try {
            HashMap hashMap = new HashMap(1);
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, b.g(this.f77133j.getCoinId()).toLowerCase(Locale.US));
            hashMap.put("marketcard", 1);
            c.c().l("179", hashMap);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f(View view) {
        a aVar = this.f77136m;
        if (aVar != null) {
            aVar.W4(sa.a.c());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void c() {
        this.f77140q.setVisibility(8);
        this.f77141r.setVisibility(0);
        this.f77139p.cancelAnimation();
    }

    public final void d(Context context) {
        View inflate = FrameLayout.inflate(context, R$layout.lite_index_btc_fast_buy_item, this);
        this.f77125b = (ImageView) inflate.findViewById(R$id.coin_icon_iv);
        this.f77126c = (TextView) inflate.findViewById(R$id.coin_full_name_tv);
        this.f77127d = (TextView) inflate.findViewById(R$id.coin_name_tv);
        this.f77128e = (TextView) inflate.findViewById(R$id.coin_price_tv);
        this.f77129f = (FrameLayout) inflate.findViewById(R$id.fast_buy_fl);
        this.f77130g = (TextView) inflate.findViewById(R$id.fast_buy_hint_tv);
        this.f77132i = (TextView) inflate.findViewById(R$id.coin_percent_tv);
        this.f77131h = (LinearLayout) inflate.findViewById(R$id.payment_container_ll);
        this.f77134k = (TextView) inflate.findViewById(R$id.otc_fast_current_currency_tv);
        this.f77135l = (ImageView) inflate.findViewById(R$id.otc_fast_expand_iv);
        this.f77137n = (LinearLayout) inflate.findViewById(R$id.currency_title_ll);
        this.f77138o = (ConstraintLayout) inflate.findViewById(R$id.lite_index_fast_buy_card_cl);
        this.f77140q = (FrameLayout) inflate.findViewById(R$id.lite_fast_buy_skeleton_fl);
        this.f77141r = (ConstraintLayout) inflate.findViewById(R$id.content_root_cl);
        this.f77139p = new SafeLottieView(getContext());
        if (NightHelper.e().g()) {
            this.f77139p.setImageAssetsFolder("images_night/");
            this.f77139p.setAnimation(R$raw.skeleton_lite_home_a_night);
        } else {
            this.f77139p.setImageAssetsFolder("images/");
            this.f77139p.setAnimation(R$raw.skeleton_lite_home_a);
        }
        this.f77139p.setRepeatCount(-1);
        this.f77140q.addView(this.f77139p, xa.a.b(getContext()), (xa.a.b(getContext()) * 477) / 1125);
        this.f77134k.setText(b.l(sa.a.c()));
        this.f77138o.setOnClickListener(new bb.a(this));
        this.f77137n.setOnClickListener(new bb.b(this));
    }

    public void g(String str, int i11) {
        String str2;
        String c11 = sa.a.c();
        if (!TextUtils.equals(c11, "1") || !p.h(getContext())) {
            str2 = b.l(c11);
        } else {
            str2 = "元";
        }
        String str3 = "";
        if (!TextUtils.isEmpty(str)) {
            Locale locale = Locale.US;
            String string = getContext().getString(R$string.n_otc_fast_trade_cny_buy_hint_by_amount);
            Object[] objArr = new Object[2];
            if (i11 < 0) {
                i11 = 2;
            }
            objArr[0] = nb.c.c(str, i11);
            objArr[1] = str2;
            String format = String.format(locale, string, objArr);
            str3 = (!p.h(getContext()) || !format.contains(" ")) ? format : format.replace(" ", str3);
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = getResources().getString(R$string.otc_fast_buy);
        }
        this.f77130g.setText(str3);
    }

    public void h(MarketMergedInfo marketMergedInfo) {
        if (marketMergedInfo != null) {
            c();
            this.f77133j = marketMergedInfo;
            OtcMarketCoinInfo.CoinInfo s11 = b.s(marketMergedInfo.getCoinId());
            if (s11 != null && !TextUtils.isEmpty(s11.getFullName())) {
                this.f77126c.setText(s11.getFullName());
            }
            this.f77127d.setText(b.g(marketMergedInfo.getCoinId()));
            this.f77128e.setText(String.format("%s %s", new Object[]{b.m(marketMergedInfo.getCurrencyId()), marketMergedInfo.getPrice()}));
            double h02 = m.h0(marketMergedInfo.getChange());
            String change = (TextUtils.isEmpty(marketMergedInfo.getChange()) || OptionsBridge.NULL_VALUE.equalsIgnoreCase(marketMergedInfo.getChange())) ? "--" : marketMergedInfo.getChange();
            if (h02 > 0.0d) {
                this.f77132i.setTextColor(ContextCompat.getColor(getContext(), R$color.base_up_color));
                if (!change.startsWith("+")) {
                    change = "+" + change;
                }
            } else if (h02 < 0.0d) {
                this.f77132i.setTextColor(ContextCompat.getColor(getContext(), R$color.base_down_color));
                if (!change.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    change = Constants.ACCEPT_TIME_SEPARATOR_SERVER + change;
                }
            } else {
                this.f77132i.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorDefaultPlaceholder));
            }
            this.f77132i.setText(change + "%");
            this.f77134k.setText(b.k(marketMergedInfo.getCurrencyId()));
        }
    }

    public void i() {
        this.f77140q.setVisibility(0);
        this.f77141r.setVisibility(4);
        this.f77139p.playAnimation();
    }

    public void setCallback(a aVar) {
        this.f77136m = aVar;
    }

    public void setRotation(int i11) {
        this.f77135l.setRotation((float) i11);
    }

    public LiteIndexFastBuyItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        d(context);
    }
}
