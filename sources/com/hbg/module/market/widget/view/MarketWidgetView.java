package com.hbg.module.market.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.module.content.utls.g;
import com.hbg.module.market.R$dimen;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.widget.bean.MarketWidgetInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gf.a;
import hf.b;
import i6.d;
import java.util.ArrayList;
import java.util.List;
import of.c;
import of.e;
import of.f;

public class MarketWidgetView extends FrameLayout implements b.h {

    /* renamed from: o  reason: collision with root package name */
    public static int f26782o;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f26783b;

    /* renamed from: c  reason: collision with root package name */
    public MarketWidgetItemView f26784c;

    /* renamed from: d  reason: collision with root package name */
    public View f26785d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26786e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f26787f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f26788g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f26789h;

    /* renamed from: i  reason: collision with root package name */
    public View f26790i;

    /* renamed from: j  reason: collision with root package name */
    public View f26791j;

    /* renamed from: k  reason: collision with root package name */
    public final List<MarketWidgetInfo> f26792k;

    /* renamed from: l  reason: collision with root package name */
    public int f26793l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f26794m;

    /* renamed from: n  reason: collision with root package name */
    public int f26795n;

    public MarketWidgetView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f(View view) {
        int i11 = f26782o;
        if (i11 > 0) {
            f26782o = i11 - 1;
            a(this.f26792k);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g(View view) {
        int i11 = f26782o;
        if (i11 < this.f26793l - 1) {
            f26782o = i11 + 1;
            a(this.f26792k);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(List list) {
        MarketWidgetItemView marketWidgetItemView;
        int r11 = b.r();
        List<MarketWidgetInfo> list2 = this.f26792k;
        if (list2 != list) {
            list2.clear();
            if (list != null) {
                this.f26792k.addAll(list);
            }
        }
        if (list != null) {
            this.f26793l = (list.size() / r11) + (list.size() % r11 > 0 ? 1 : 0);
        } else {
            this.f26793l = 0;
        }
        if (this.f26793l <= f26782o) {
            f26782o = 0;
        }
        if (!this.f26794m || list == null || list.size() <= r11) {
            ViewUtil.m(this.f26785d, false);
        } else {
            ViewUtil.m(this.f26785d, true);
            this.f26786e.setText((f26782o + 1) + "/" + this.f26793l);
        }
        int i11 = f26782o;
        int i12 = i11 * r11;
        float f11 = 0.4f;
        this.f26787f.setAlpha(i11 == 0 ? 0.4f : 1.0f);
        ImageView imageView = this.f26788g;
        if (f26782o < this.f26793l - 1) {
            f11 = 1.0f;
        }
        imageView.setAlpha(f11);
        if (this.f26792k.isEmpty()) {
            ViewUtil.m(this.f26791j, false);
            ViewUtil.m(this.f26789h, false);
            this.f26789h.animate().setDuration(270).setInterpolator(new FastOutSlowInInterpolator()).rotation(0.0f);
            this.f26784c.setDataList(this.f26792k);
            this.f26784c.i();
            ViewUtil.m(this.f26783b, false);
            ViewUtil.m(this.f26784c, false);
            ViewUtil.m(this, false);
            return;
        }
        ViewUtil.m(this, true);
        if (this.f26792k.size() == 1) {
            this.f26791j.setVisibility(8);
            this.f26789h.setVisibility(8);
        } else {
            this.f26791j.setVisibility(0);
            this.f26789h.setVisibility(0);
        }
        if (this.f26794m) {
            ViewUtil.m(this.f26783b, true);
            ViewUtil.m(this.f26784c, false);
            if (r11 < this.f26783b.getChildCount()) {
                for (int i13 = r11; i13 < this.f26783b.getChildCount(); i13++) {
                    ViewUtil.m(this.f26783b.getChildAt(i13), false);
                }
            }
            for (int i14 = 0; i14 < r11; i14++) {
                if (i14 >= this.f26783b.getChildCount()) {
                    marketWidgetItemView = new MarketWidgetItemView(getContext());
                    marketWidgetItemView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    this.f26783b.addView(marketWidgetItemView);
                } else {
                    marketWidgetItemView = (MarketWidgetItemView) this.f26783b.getChildAt(i14);
                }
                n(marketWidgetItemView, i12 + i14, list, i14);
            }
            return;
        }
        ViewUtil.m(this.f26784c, true);
        ViewUtil.m(this.f26783b, false);
        this.f26784c.setDataList(this.f26792k);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i() {
        if (this.f26794m) {
            this.f26784c.i();
        } else {
            this.f26784c.h();
        }
    }

    public static void setCurrentPage(int i11) {
        f26782o = i11;
    }

    public void a(List<MarketWidgetInfo> list) {
        post(new f(this, list));
    }

    public final void j() {
        this.f26794m = !this.f26794m;
        o();
    }

    public void k() {
        b.E(this);
        a(this.f26792k);
    }

    public void l() {
        b.n();
    }

    public void m(float f11, float f12) {
        int r11;
        if (f12 > ((float) this.f26795n) || this.f26792k.size() <= 1) {
            MarketWidgetInfo marketWidgetInfo = null;
            if (this.f26794m) {
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    if (i11 >= this.f26783b.getChildCount()) {
                        i11 = -1;
                        break;
                    }
                    i12 += this.f26783b.getChildAt(i11).getHeight();
                    if (f12 <= ((float) (this.f26795n + i12))) {
                        break;
                    }
                    i11++;
                }
                if (i11 >= 0 && !this.f26792k.isEmpty() && (r11 = (f26782o * b.r()) + i11) >= 0 && r11 < this.f26792k.size()) {
                    marketWidgetInfo = this.f26792k.get(r11);
                }
            } else if (f12 <= ((float) (this.f26795n + this.f26784c.getHeight()))) {
                marketWidgetInfo = this.f26784c.getCurrentMarketWidgetInfo();
            }
            d.b("MarketWidgetView-->onUserClick-->" + marketWidgetInfo);
            if (marketWidgetInfo != null) {
                g.f18913a.a(getContext(), marketWidgetInfo.getSymbol(), false, marketWidgetInfo.getTradeType(), "");
                return;
            }
            return;
        }
        j();
    }

    public final void n(MarketWidgetItemView marketWidgetItemView, int i11, List<MarketWidgetInfo> list, int i12) {
        if (i11 < 0 || i11 >= list.size()) {
            ViewUtil.m(marketWidgetItemView, false);
            return;
        }
        marketWidgetItemView.k(list.get(i11));
        ViewUtil.m(marketWidgetItemView, true);
    }

    public final void o() {
        if (this.f26794m) {
            this.f26789h.animate().setDuration(270).setInterpolator(new FastOutSlowInInterpolator()).rotation(180.0f);
        } else {
            this.f26789h.animate().setDuration(270).setInterpolator(new FastOutSlowInInterpolator()).rotation(0.0f);
        }
        a(this.f26792k);
        post(new e(this));
    }

    public void setBgAlpha(float f11) {
        this.f26790i.setAlpha(f11);
    }

    public MarketWidgetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MarketWidgetView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f26792k = new ArrayList();
        this.f26795n = getResources().getDimensionPixelOffset(R$dimen.dimen_16);
        FrameLayout.inflate(context, R$layout.layout_market_widget_view, this);
        this.f26790i = findViewById(R$id.id_market_widget_view_bg);
        this.f26783b = (LinearLayout) findViewById(R$id.id_market_widget_view_item_layout);
        this.f26785d = findViewById(R$id.id_market_widget_view_page_layout);
        this.f26786e = (TextView) findViewById(R$id.id_market_widget_view_page_tv);
        this.f26787f = (ImageView) findViewById(R$id.id_market_widget_view_page_pre);
        this.f26788g = (ImageView) findViewById(R$id.id_market_widget_view_page_next);
        this.f26789h = (ImageView) findViewById(R$id.id_market_widget_view_switch);
        this.f26784c = (MarketWidgetItemView) findViewById(R$id.id_market_widget_view_item_single);
        this.f26791j = findViewById(R$id.id_market_widget_top_divide);
        this.f26787f.setOnClickListener(new of.d(this));
        this.f26788g.setOnClickListener(new c(this));
        o();
        setBgAlpha(a.b());
    }
}
