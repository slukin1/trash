package com.hbg.module.content.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationCoinTags;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.module.content.R$attr;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.interfaces.NoDoubleClickListener;
import com.hbg.module.content.utls.g;
import com.hbg.module.libkt.base.ext.b;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import lc.a0;
import nc.c;
import sl.f0;

public final class CoinTagView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public boolean f17953b;

    /* renamed from: c  reason: collision with root package name */
    public a0 f17954c;

    public static final class a extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17955b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17956c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewFlashInformationCoinTags f17957d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17958e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f17959f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f17960g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d10.a<Unit> f17961h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CoinTagView f17962i;

        public a(String str, String str2, NewFlashInformationCoinTags newFlashInformationCoinTags, String str3, int i11, String str4, d10.a<Unit> aVar, CoinTagView coinTagView) {
            this.f17955b = str;
            this.f17956c = str2;
            this.f17957d = newFlashInformationCoinTags;
            this.f17958e = str3;
            this.f17959f = i11;
            this.f17960g = str4;
            this.f17961h = aVar;
            this.f17962i = coinTagView;
        }

        public void onViewClick(View view) {
            HashMap hashMap = new HashMap();
            hashMap.put("contentid", this.f17955b);
            hashMap.put("title", this.f17956c);
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, this.f17957d.getCoin());
            hashMap.put("style_type", "News");
            String str = this.f17958e;
            if (str != null) {
                hashMap.put("category", str);
            }
            hashMap.put("translate", Integer.valueOf(this.f17959f));
            String str2 = this.f17960g;
            switch (str2.hashCode()) {
                case 53:
                    if (str2.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC)) {
                        hashMap.put("currency_tag_state", "app_huobiNews_details");
                        break;
                    }
                    break;
                case 54:
                    if (str2.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL)) {
                        hashMap.put("currency_tag_state", "app_favorites_news");
                        break;
                    }
                    break;
                case 55:
                    if (str2.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP)) {
                        hashMap.put("currency_tag_state", "app_news_news");
                        break;
                    }
                    break;
                case 56:
                    if (str2.equals("8")) {
                        hashMap.put("currency_tag_state", "app_kline_news");
                        break;
                    }
                    break;
            }
            c.a("app_currency_tag_click", hashMap);
            d10.a<Unit> aVar = this.f17961h;
            if (aVar != null) {
                aVar.invoke();
            }
            g.f18913a.a(this.f17962i.getContext(), this.f17957d.getSymbol(), false, TradeType.PRO, this.f17960g);
        }
    }

    public CoinTagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, false, 12, (r) null);
    }

    public CoinTagView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, false, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CoinTagView(Context context, AttributeSet attributeSet, int i11, boolean z11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? false : z11);
    }

    public final void a(NewFlashInformationCoinTags newFlashInformationCoinTags, String str, String str2, String str3, int i11, String str4, d10.a<Unit> aVar, String str5, int i12, boolean z11) {
        NewFlashInformationCoinTags newFlashInformationCoinTags2;
        String str6;
        int i13;
        int i14;
        SymbolPrice h11 = f0.g().h(newFlashInformationCoinTags.getSymbol());
        Double d11 = null;
        Double close = h11 != null ? h11.getClose() : null;
        double doubleValue = close == null ? 0.0d : close.doubleValue();
        if (h11 != null) {
            d11 = h11.getOpen();
        }
        double doubleValue2 = d11 == null ? 0.0d : d11.doubleValue();
        double d12 = doubleValue - doubleValue2;
        boolean z12 = true;
        if (str5.length() > 0) {
            this.f17954c.B.setVisibility(0);
            b.C(this.f17954c.B, str5, i12);
        } else {
            this.f17954c.B.setVisibility(8);
        }
        int i15 = (doubleValue2 > 0.0d ? 1 : (doubleValue2 == 0.0d ? 0 : -1));
        if (i15 == 0) {
            newFlashInformationCoinTags2 = newFlashInformationCoinTags;
            str6 = "0.00%";
        } else {
            str6 = m.S(d12 / doubleValue2, PrecisionUtil.v(""));
            newFlashInformationCoinTags2 = newFlashInformationCoinTags;
        }
        newFlashInformationCoinTags2.setPercent(str6);
        this.f17954c.E.setText(newFlashInformationCoinTags.getPercent());
        this.f17954c.D.setText(newFlashInformationCoinTags.getCoin());
        if (StringsKt__StringsKt.g0(newFlashInformationCoinTags.getPercent(), "--", 0, false, 6, (Object) null) == 0 || newFlashInformationCoinTags.getPercent().equals("0.00%")) {
            i13 = R$color.baseColorDefaultPlaceholder;
        } else if (StringsKt__StringsKt.g0(newFlashInformationCoinTags.getPercent(), Constants.ACCEPT_TIME_SEPARATOR_SERVER, 0, false, 6, (Object) null) == 0) {
            if (w.l()) {
                i13 = R$color.base_up_color;
            } else {
                i13 = R$color.base_down_color;
            }
        } else if (w.l()) {
            i13 = R$color.base_down_color;
        } else {
            i13 = R$color.base_up_color;
        }
        if (this.f17953b) {
            LinearLayout linearLayout = this.f17954c.C;
            if (StringsKt__StringsKt.g0(newFlashInformationCoinTags.getPercent(), "--", 0, false, 6, (Object) null) == 0) {
                i14 = R$drawable.bg_newer_coin_gray;
            } else if (StringsKt__StringsKt.g0(newFlashInformationCoinTags.getPercent(), Constants.ACCEPT_TIME_SEPARATOR_SERVER, 0, false, 6, (Object) null) == 0) {
                if (w.l()) {
                    i14 = R$drawable.bg_newer_coin;
                } else {
                    i14 = R$drawable.bg_newer_market_down;
                }
            } else if (w.l()) {
                i14 = R$drawable.bg_newer_market_down;
            } else {
                i14 = R$drawable.bg_newer_coin;
            }
            linearLayout.setBackgroundResource(i14);
        }
        this.f17954c.E.setTextColor(getResources().getColor(i13));
        if (z11) {
            this.f17954c.C.setBackgroundDrawable(b.p(getContext(), R$attr.coin_tag_bg));
            this.f17954c.C.setPadding(com.hbg.module.libkt.base.ext.c.a(5.0f), 0, com.hbg.module.libkt.base.ext.c.a(5.0f), 0);
            if (i15 != 0) {
                z12 = false;
            }
            if (z12) {
                this.f17954c.E.setTextColor(getResources().getColor(R$color.color_8C9FAD));
            }
        } else {
            this.f17954c.D.setTextColor(getResources().getColor(i13));
        }
        this.f17954c.C.setOnClickListener(new a(str2, str3, newFlashInformationCoinTags, str4, i11, str, aVar, this));
    }

    public final boolean getNeedBg() {
        return this.f17953b;
    }

    public final void setNeedBg(boolean z11) {
        this.f17953b = z11;
    }

    public CoinTagView(Context context, AttributeSet attributeSet, int i11, boolean z11) {
        super(context, attributeSet, i11);
        this.f17953b = z11;
        a0 K = a0.K(LayoutInflater.from(context));
        this.f17954c = K;
        if (this.f17953b) {
            try {
                ViewGroup.LayoutParams layoutParams = K.C.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(-2, com.hbg.module.libkt.base.ext.c.d(Float.valueOf(24.0f)));
                } else {
                    layoutParams.height = com.hbg.module.libkt.base.ext.c.d(Float.valueOf(24.0f));
                }
                this.f17954c.C.setLayoutParams(layoutParams);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            this.f17954c.C.setPadding(com.hbg.module.libkt.base.ext.c.a(5.0f), 0, com.hbg.module.libkt.base.ext.c.a(5.0f), 0);
        }
        addView(this.f17954c.getRoot());
    }
}
