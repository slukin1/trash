package com.hbg.module.kline.ui;

import a7.e;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.util.ContractDepthType;
import com.hbg.lib.network.linear.swap.core.util.LinearSwapDepthType;
import com.hbg.lib.network.option.core.util.OptionDepthType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.core.util.DepthType;
import com.hbg.lib.network.pro.socket.bean.TradeBuySellData;
import com.hbg.lib.network.pro.socket.listener.MarketDepthPercentListener;
import com.hbg.lib.network.pro.socket.response.MarketDepthResponse;
import com.hbg.lib.network.swap.core.util.SwapDepthType;
import com.hbg.module.kline.KLineHelper;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$dimen;
import com.hbg.module.kline.R$drawable;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.R$styleable;
import com.hbg.module.kline.bean.MarketDepthPercentItem;
import com.hbg.module.kline.view.DrawDepthChart;
import com.huobi.utils.d0;
import com.huobi.view.drawable.BgColorDrawable;
import com.iproov.sdk.bridge.OptionsBridge;
import d7.a1;
import g9.a;
import i6.m;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import v5.q;

public class KLineDepthLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public DrawDepthChart f23861b;

    /* renamed from: c  reason: collision with root package name */
    public c f23862c;

    /* renamed from: d  reason: collision with root package name */
    public String f23863d;

    /* renamed from: e  reason: collision with root package name */
    public int f23864e;

    /* renamed from: f  reason: collision with root package name */
    public final List<MarketDepthPercentItem> f23865f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final List<MarketDepthPercentItem> f23866g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public boolean f23867h;

    /* renamed from: i  reason: collision with root package name */
    public long f23868i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f23869j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f23870k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f23871l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f23872m = false;

    /* renamed from: n  reason: collision with root package name */
    public Handler f23873n = new Handler(Looper.getMainLooper());

    /* renamed from: o  reason: collision with root package name */
    public Runnable f23874o = new a();

    /* renamed from: p  reason: collision with root package name */
    public a.d f23875p = new g0(this);

    /* renamed from: q  reason: collision with root package name */
    public d f23876q = new d(this, (a) null);

    /* renamed from: r  reason: collision with root package name */
    public MarketDepthPercentListener f23877r = new b();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            KLineDepthLayout.this.t();
            long unused = KLineDepthLayout.this.f23868i = DateTimeUtils.v();
        }
    }

    public class b extends MarketDepthPercentListener {
        public b() {
        }

        /* renamed from: j */
        public void f(MarketDepthResponse marketDepthResponse) {
            if (marketDepthResponse != null && marketDepthResponse.getSymbol().equals(KLineDepthLayout.this.getSymbolId())) {
                boolean z11 = DateTimeUtils.v() - KLineDepthLayout.this.f23868i > 400;
                KLineDepthLayout.this.f23873n.removeCallbacks(KLineDepthLayout.this.f23874o);
                if (z11) {
                    KLineDepthLayout.this.f23874o.run();
                } else {
                    KLineDepthLayout.this.f23873n.postDelayed(KLineDepthLayout.this.f23874o, 200);
                }
            }
        }

        /* renamed from: k */
        public MarketDepthResponse g(MarketDepthResponse marketDepthResponse) {
            if (marketDepthResponse != null && marketDepthResponse.getSymbol().equals(KLineDepthLayout.this.getSymbolId())) {
                TradeBuySellData tick = marketDepthResponse.getTick();
                List<Double[]> asks = tick.getAsks();
                List<Double[]> bids = tick.getBids();
                if (TradeType.isContract(KLineDepthLayout.this.getTradeType()) && e.E(TradeType.CONTRACT)) {
                    KLineDepthLayout.this.w(asks);
                    KLineDepthLayout.this.w(bids);
                } else if (TradeType.isSwap(KLineDepthLayout.this.getTradeType()) && e.E(TradeType.SWAP)) {
                    KLineDepthLayout.this.w(asks);
                    KLineDepthLayout.this.w(bids);
                } else if (TradeType.isOption(KLineDepthLayout.this.getTradeType()) && e.E(KLineDepthLayout.this.getTradeType())) {
                    KLineDepthLayout.this.w(asks);
                    KLineDepthLayout.this.w(bids);
                } else if (TradeType.isLinearSwap(KLineDepthLayout.this.getTradeType()) && e.F(KLineDepthLayout.this.getTradeType())) {
                    KLineDepthLayout.this.w(asks);
                    KLineDepthLayout.this.w(bids);
                }
                List r11 = KLineDepthLayout.this.u(bids);
                List r12 = KLineDepthLayout.this.u(asks);
                i6.d.b("api-->KLineDepthLayout-->onSuccessAsync--> tradeType:" + KLineDepthLayout.this.getTradeType() + " buyAmountList:" + r11.size() + " sellAmountList:" + r12.size());
                KLineDepthLayout.C(KLineDepthLayout.this.getSymbolId(), KLineDepthLayout.this.f23865f, bids, r11, 0);
                KLineDepthLayout.C(KLineDepthLayout.this.getSymbolId(), KLineDepthLayout.this.f23866g, asks, r12, 1);
            }
            return marketDepthResponse;
        }
    }

    public interface c {
        TradeType D0();

        String E0();

        String F0();

        String G0();

        String H0();

        int I0();

        String J0();

        String k1();
    }

    public KLineDepthLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        x(context, attributeSet);
    }

    public static void C(String str, List<MarketDepthPercentItem> list, List<Double[]> list2, List<Double> list3, int i11) {
        int size = list2 != null ? list2.size() : 0;
        list.clear();
        for (int i12 = 0; i12 < size; i12++) {
            MarketDepthPercentItem marketDepthPercentItem = new MarketDepthPercentItem();
            marketDepthPercentItem.e(str);
            if (list2.get(i12)[0] != null) {
                marketDepthPercentItem.d(list2.get(i12)[0].doubleValue());
            } else {
                marketDepthPercentItem.d(0.0d);
            }
            marketDepthPercentItem.c(list3.get(i12).doubleValue());
            list.add(marketDepthPercentItem);
        }
        if (i11 == 0) {
            Collections.reverse(list);
        }
    }

    /* access modifiers changed from: private */
    public String getSymbolId() {
        c cVar = this.f23862c;
        if (cVar != null) {
            return cVar.k1();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public TradeType getTradeType() {
        c cVar = this.f23862c;
        if (cVar != null) {
            return cVar.D0();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z() {
        B(true);
    }

    public void A() {
        if (TradeType.isContract(getTradeType())) {
            q7.a.a().c(this.f23875p);
        } else if (TradeType.isSwap(getTradeType())) {
            l9.a.a().c(this.f23875p);
        } else if (TradeType.isOption(getTradeType())) {
            p8.a.a().c(this.f23875p);
        } else if (TradeType.isLinearSwap(getTradeType())) {
            h8.a.a().c(this.f23875p);
        } else {
            x8.a.a().c(this.f23875p);
        }
    }

    public void B(boolean z11) {
        this.f23873n.removeCallbacks(this.f23876q);
        d dVar = this.f23876q;
        dVar.f23880b = z11;
        this.f23873n.postDelayed(dVar, 500);
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        this.f23869j = i11 == 0;
        i6.d.b("KLineDepthLayout-->onVisibilityChanged-->" + this.f23869j);
        if (i11 == 0) {
            B(true);
            s();
            return;
        }
        B(false);
        A();
    }

    public void s() {
        if (TradeType.isContract(getTradeType())) {
            q7.a.a().d(this.f23875p);
        } else if (TradeType.isSwap(getTradeType())) {
            l9.a.a().d(this.f23875p);
        } else if (TradeType.isOption(getTradeType())) {
            p8.a.a().d(this.f23875p);
        } else if (TradeType.isLinearSwap(getTradeType())) {
            h8.a.a().d(this.f23875p);
        } else {
            x8.a.a().d(this.f23875p);
        }
    }

    public void setCallback(c cVar) {
        this.f23862c = cVar;
    }

    public void setVisibility(int i11) {
        super.setVisibility(i11);
        if (8 == i11) {
            this.f23861b.onSingleTapUp((MotionEvent) null);
        }
    }

    public final void t() {
        if (this.f23862c != null) {
            i6.d.b("api-->KLineDepthLayout-->doOnSuccess--> tradeType:" + getTradeType() + " percentBuyList:" + this.f23865f.size() + " percentBuyList:" + this.f23865f.size());
            if (TradeType.isContract(getTradeType()) || TradeType.isSwap(getTradeType())) {
                this.f23861b.setConstractSymbol(this.f23862c.H0());
                this.f23861b.setContractCode(this.f23862c.E0());
            } else if (TradeType.isOption(getTradeType())) {
                this.f23861b.setConstractSymbol(this.f23862c.H0());
                this.f23861b.setContractCode(this.f23862c.G0());
                this.f23861b.setOptionCode(this.f23862c.G0());
                this.f23861b.setContractShortType(this.f23862c.E0());
            } else if (TradeType.isLinearSwap(getTradeType())) {
                this.f23861b.setConstractSymbol(this.f23862c.H0());
                this.f23861b.setContractCode(this.f23862c.E0());
                this.f23861b.setContractShortType(this.f23862c.J0());
            }
            this.f23861b.setBuyDataListValue(this.f23865f);
            this.f23861b.setSellDataListValue(this.f23866g);
            this.f23861b.setSymbol(getSymbolId());
            this.f23861b.setTradeType(getTradeType());
            this.f23861b.c();
            this.f23861b.postInvalidate();
            if (getContext() instanceof MarketInfoActivity) {
                BaseModuleConfig.a().z("huobiapp_market_deep_end", "huobiapp_market_deep_end", OptionsBridge.NETWORK_KEY, true);
            }
        }
    }

    public final List<Double> u(List<Double[]> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        int size = list.size();
        double d11 = 0.0d;
        for (int i11 = 0; i11 < size; i11++) {
            if (list.get(i11).length >= 2) {
                if (list.get(i11)[1] != null) {
                    d11 += list.get(i11)[1].doubleValue();
                }
                arrayList.add(Double.valueOf(d11));
            }
        }
        return arrayList;
    }

    public final String v(String str, String str2) {
        if (this.f23862c == null) {
            return str;
        }
        if (TradeType.isOption(getTradeType()) || TradeType.isLinearSwap(getTradeType())) {
            return FutureUnitUtil.c(str, str2, this.f23863d, getTradeType(), e.F(getTradeType()));
        }
        BigDecimal a11 = m.a(str);
        BigDecimal a12 = m.a(str2);
        return (a11.compareTo(BigDecimal.ZERO) == 0 || a12.compareTo(BigDecimal.ZERO) == 0) ? str : m.m(a11.multiply(new BigDecimal(this.f23863d)).divide(a12, 32, RoundingMode.DOWN).toString(), this.f23864e);
    }

    public final void w(List<Double[]> list) {
        c cVar;
        if (list != null) {
            if (this.f23863d == null && (cVar = this.f23862c) != null) {
                this.f23863d = cVar.F0();
                this.f23864e = this.f23862c.I0();
            }
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (list.get(i11).length >= 2) {
                    double d11 = 0.0d;
                    double doubleValue = list.get(i11)[1] != null ? list.get(i11)[1].doubleValue() : 0.0d;
                    if (list.get(i11)[0] != null) {
                        d11 = list.get(i11)[0].doubleValue();
                    }
                    list.get(i11)[1] = Double.valueOf(m.h0(v(String.valueOf(doubleValue), String.valueOf(d11))));
                }
            }
        }
    }

    public final void x(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.KLineDepthLayout);
        int i11 = R$styleable.KLineDepthLayout_depth_label_text_color;
        y(context, obtainStyledAttributes.getColor(i11, Color.parseColor("#5E5E61")));
        DrawDepthChart drawDepthChart = new DrawDepthChart(context);
        this.f23861b = drawDepthChart;
        drawDepthChart.n(obtainStyledAttributes.getColor(R$styleable.KLineDepthLayout_depth_left_fill_color, ContextCompat.getColor(getContext(), w.c())), obtainStyledAttributes.getColor(R$styleable.KLineDepthLayout_depth_right_fill_color, ContextCompat.getColor(getContext(), w.b())), obtainStyledAttributes.getColor(i11, Color.parseColor("#5E5E61")), obtainStyledAttributes.getColor(R$styleable.KLineDepthLayout_depth_touch_label_background_color, Color.parseColor("#E5E6E6E6")), obtainStyledAttributes.getColor(R$styleable.KLineDepthLayout_depth_touch_pointer_bg_color, Color.parseColor("#33081724")), KLineHelper.b(0.6f, obtainStyledAttributes.getColor(R$styleable.KLineDepthLayout_depth_grid_color, Color.parseColor("#333333"))));
        this.f23861b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f23861b);
        obtainStyledAttributes.recycle();
        ImageView imageView = new ImageView(context);
        if (!d0.b(context) || d0.c(context)) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R$attr.kline_water_remark, typedValue, true);
            imageView.setImageResource(typedValue.resourceId);
        } else {
            imageView.setImageResource(R$drawable.kline_water_logo_zh_cn);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = q.f68368d0;
        layoutParams.bottomMargin = (int) (((float) q.f68369e0) + this.f23861b.getBrokenLineBottom());
        layoutParams.gravity = 80;
        addView(imageView, layoutParams);
        this.f23873n.removeCallbacksAndMessages((Object) null);
    }

    public final void y(Context context, int i11) {
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R$dimen.dimen_7);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        this.f23870k = new TextView(context);
        this.f23870k.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f23870k.setText(getResources().getString(R$string.market_info_trade_depth_buy));
        TextView textView = this.f23870k;
        Resources resources = getResources();
        int i12 = R$dimen.dimen_3;
        textView.setCompoundDrawablePadding(resources.getDimensionPixelOffset(i12));
        TextView textView2 = this.f23870k;
        Resources resources2 = getResources();
        int i13 = R$dimen.global_text_size_10;
        textView2.setTextSize(0, (float) resources2.getDimensionPixelOffset(i13));
        linearLayout.addView(this.f23870k);
        this.f23871l = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = getResources().getDimensionPixelOffset(R$dimen.dimen_10);
        this.f23871l.setLayoutParams(layoutParams2);
        this.f23871l.setText(getResources().getString(R$string.market_info_trade_depth_sell));
        this.f23871l.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(i12));
        this.f23871l.setTextSize(0, (float) getResources().getDimensionPixelOffset(i13));
        linearLayout.addView(this.f23871l);
        this.f23870k.setTextColor(i11);
        this.f23871l.setTextColor(i11);
        int color = getResources().getColor(w.h());
        Resources resources3 = getResources();
        int i14 = R$dimen.dimen_2;
        BgColorDrawable bgColorDrawable = new BgColorDrawable(color, resources3.getDimension(i14));
        BgColorDrawable bgColorDrawable2 = new BgColorDrawable(getResources().getColor(w.d()), getResources().getDimension(i14));
        bgColorDrawable.setBounds(0, 0, PixelUtils.a(8.0f), PixelUtils.a(8.0f));
        bgColorDrawable2.setBounds(0, 0, PixelUtils.a(8.0f), PixelUtils.a(8.0f));
        this.f23870k.setCompoundDrawables(bgColorDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f23871l.setCompoundDrawables(bgColorDrawable2, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public boolean f23880b;

        public d() {
            this.f23880b = false;
        }

        public void run() {
            if (!KLineDepthLayout.this.f23872m || !this.f23880b) {
                boolean unused = KLineDepthLayout.this.f23872m = this.f23880b;
                boolean unused2 = KLineDepthLayout.this.f23867h = false;
                SymbolBean J = a1.v().J(KLineDepthLayout.this.getSymbolId(), KLineDepthLayout.this.getTradeType());
                if (J == null || !SymbolBean.PRE_ONLINE.equals(J.getState())) {
                    boolean unused3 = KLineDepthLayout.this.f23867h = true;
                } else if (J.isWhiteEnabled()) {
                    boolean unused4 = KLineDepthLayout.this.f23867h = true;
                }
                if (!KLineDepthLayout.this.f23867h) {
                    return;
                }
                if (TradeType.isContract(KLineDepthLayout.this.getTradeType())) {
                    q7.a.a().C(this.f23880b, KLineDepthLayout.this.getSymbolId(), ContractDepthType.PERCENT10, KLineDepthLayout.this.f23877r);
                } else if (TradeType.isSwap(KLineDepthLayout.this.getTradeType())) {
                    l9.a.a().I(this.f23880b, KLineDepthLayout.this.getSymbolId(), SwapDepthType.PERCENT10, KLineDepthLayout.this.f23877r);
                } else if (TradeType.isOption(KLineDepthLayout.this.getTradeType())) {
                    p8.a.a().l(this.f23880b, KLineDepthLayout.this.getSymbolId(), OptionDepthType.PERCENT10, KLineDepthLayout.this.f23877r);
                } else if (TradeType.isLinearSwap(KLineDepthLayout.this.getTradeType())) {
                    h8.a.a().A0(this.f23880b, KLineDepthLayout.this.getSymbolId(), LinearSwapDepthType.PERCENT10, KLineDepthLayout.this.f23877r);
                } else {
                    x8.a.a().v(this.f23880b, KLineDepthLayout.this.getSymbolId(), DepthType.PERCENT10, KLineDepthLayout.this.f23877r);
                }
            }
        }

        public /* synthetic */ d(KLineDepthLayout kLineDepthLayout, a aVar) {
            this();
        }
    }

    public KLineDepthLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        x(context, attributeSet);
    }
}
