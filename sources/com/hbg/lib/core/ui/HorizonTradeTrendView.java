package com.hbg.lib.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.R$dimen;
import i6.t;
import java.util.List;
import k6.c;

public class HorizonTradeTrendView extends TradeTrendView {

    /* renamed from: v  reason: collision with root package name */
    public int f68533v;

    /* renamed from: w  reason: collision with root package name */
    public LinearLayout f68534w;

    /* renamed from: x  reason: collision with root package name */
    public LinearLayout f68535x;

    /* renamed from: y  reason: collision with root package name */
    public int f68536y;

    /* renamed from: z  reason: collision with root package name */
    public int f68537z;

    public HorizonTradeTrendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void c(int i11) {
        k();
    }

    public void e(Context context) {
        setOrientation(0);
        this.f68629l = new t(this);
        setVisibleMinCount(5);
    }

    public void g() {
        for (int i11 = 0; i11 < this.f68534w.getChildCount(); i11++) {
            View childAt = this.f68534w.getChildAt(i11);
            if (childAt instanceof NewestPriceItemView) {
                ((NewestPriceItemView) childAt).f();
            } else if (childAt instanceof TradeTrendItemView) {
                ((TradeTrendItemView) childAt).i();
            }
        }
        for (int i12 = 0; i12 < this.f68535x.getChildCount(); i12++) {
            View childAt2 = this.f68535x.getChildAt(i12);
            if (childAt2 instanceof NewestPriceItemView) {
                ((NewestPriceItemView) childAt2).f();
            } else if (childAt2 instanceof TradeTrendItemView) {
                ((TradeTrendItemView) childAt2).i();
            }
        }
    }

    public String getFirstAskPrice() {
        List<c> list = this.f68620c;
        return (list == null || list.size() <= 0 || this.f68620c.get(0) == null || this.f68620c.get(0).c() == null) ? "--" : this.f68620c.get(0).c().b();
    }

    public String getFirstBldPrice() {
        List<c> list = this.f68624g;
        return (list == null || list.size() <= 0 || this.f68624g.get(0) == null || this.f68624g.get(0).c() == null) ? "--" : this.f68624g.get(0).c().b();
    }

    public void k() {
        removeAllViews();
        this.f68534w = new LinearLayout(getContext());
        this.f68535x = new LinearLayout(getContext());
        this.f68534w.setOrientation(1);
        this.f68535x.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
        this.f68534w.setLayoutParams(layoutParams);
        this.f68535x.setLayoutParams(layoutParams);
        addView(this.f68534w);
        if (this.f68537z > 0) {
            View view = new View(getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(PixelUtils.a((float) this.f68537z), -1));
            addView(view);
        }
        addView(this.f68535x);
        if (this.f68533v <= 0) {
            this.f68533v = 5;
        }
        int i11 = this.f68533v;
        if (i11 > this.f68620c.size()) {
            i11 = this.f68620c.size();
        }
        if (this.f68536y == 0) {
            this.f68536y = getResources().getDimensionPixelOffset(R$dimen.dimen_21);
        }
        for (int i12 = 0; i12 < i11; i12++) {
            TradeTrendItemView tradeTrendItemView = new TradeTrendItemView(getContext());
            tradeTrendItemView.setDrawIndex(true);
            tradeTrendItemView.setAlignment(0);
            int i13 = this.f68634q;
            if (i13 != 0) {
                tradeTrendItemView.setIndexColor(i13);
            }
            int i14 = this.f68633p;
            if (i14 != 0) {
                tradeTrendItemView.setAmountColor(i14);
            }
            tradeTrendItemView.j(this.f68620c.get(i12));
            this.f68535x.addView(tradeTrendItemView, new LinearLayout.LayoutParams(-1, this.f68536y));
        }
        int i15 = this.f68533v;
        if (i15 > this.f68624g.size()) {
            i15 = this.f68624g.size();
        }
        for (int i16 = 0; i16 < i15; i16++) {
            TradeTrendItemView tradeTrendItemView2 = new TradeTrendItemView(getContext());
            tradeTrendItemView2.setDrawIndex(true);
            tradeTrendItemView2.setAlignment(1);
            int i17 = this.f68634q;
            if (i17 != 0) {
                tradeTrendItemView2.setIndexColor(i17);
            }
            int i18 = this.f68633p;
            if (i18 != 0) {
                tradeTrendItemView2.setAmountColor(i18);
            }
            tradeTrendItemView2.j(this.f68624g.get(i16));
            this.f68534w.addView(tradeTrendItemView2, new LinearLayout.LayoutParams(-1, this.f68536y));
        }
    }

    public void onDraw(Canvas canvas) {
        if (this.f68534w != null) {
            for (int i11 = 0; i11 < this.f68534w.getChildCount(); i11++) {
                View childAt = this.f68534w.getChildAt(i11);
                if (childAt instanceof TradeTrendItemView) {
                    TradeTrendItemView tradeTrendItemView = (TradeTrendItemView) childAt;
                    tradeTrendItemView.setDrawIndex(true);
                    tradeTrendItemView.setAlignment(1);
                }
            }
        }
        if (this.f68535x != null) {
            for (int i12 = 0; i12 < this.f68535x.getChildCount(); i12++) {
                View childAt2 = this.f68535x.getChildAt(i12);
                if (childAt2 instanceof TradeTrendItemView) {
                    TradeTrendItemView tradeTrendItemView2 = (TradeTrendItemView) childAt2;
                    tradeTrendItemView2.setDrawIndex(true);
                    tradeTrendItemView2.setAlignment(0);
                }
            }
        }
        super.onDraw(canvas);
    }

    public void setDimensionPixelOffset(int i11) {
        this.f68536y = i11;
        k();
    }

    public void setMiddleMargin(int i11) {
        this.f68537z = i11;
    }

    public void setSellList(List<? extends c.a> list) {
        if (list != null) {
            for (int i11 = 0; i11 < this.f68620c.size(); i11++) {
                c cVar = this.f68620c.get(i11);
                if (i11 < list.size()) {
                    cVar.e((c.a) list.get(i11));
                }
            }
        }
    }

    public void setVisibleMinCount(int i11) {
        if (this.f68533v != i11) {
            this.f68533v = i11;
            l(i11, i11);
        }
    }

    public HorizonTradeTrendView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f68536y = getResources().getDimensionPixelOffset(R$dimen.dimen_21);
    }
}
