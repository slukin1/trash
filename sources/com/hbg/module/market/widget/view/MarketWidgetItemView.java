package com.hbg.module.market.widget.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.widget.bean.MarketWidgetInfo;
import i6.i;
import java.util.List;
import of.b;

public class MarketWidgetItemView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f26771b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26772c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26773d;

    /* renamed from: e  reason: collision with root package name */
    public List<MarketWidgetInfo> f26774e;

    /* renamed from: f  reason: collision with root package name */
    public int f26775f;

    /* renamed from: g  reason: collision with root package name */
    public i6.a f26776g;

    /* renamed from: h  reason: collision with root package name */
    public DecelerateInterpolator f26777h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f26778i;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public TextView f26779b;

        /* renamed from: c  reason: collision with root package name */
        public String f26780c;

        public a(TextView textView, String str) {
            this.f26779b = textView;
            this.f26780c = str;
        }

        public void onAnimationEnd(Animator animator) {
            TextView textView = this.f26779b;
            if (textView != null) {
                textView.setText(this.f26780c);
                ViewPropertyAnimator animate = this.f26779b.animate();
                animate.setDuration(150);
                animate.setInterpolator(MarketWidgetItemView.this.f26777h);
                animate.alpha(1.0f);
            }
        }
    }

    public MarketWidgetItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(Message message) {
        int i11 = this.f26775f + 1;
        this.f26775f = i11;
        List<MarketWidgetInfo> list = this.f26774e;
        if (list != null && i11 >= list.size()) {
            this.f26775f = 0;
        }
        j();
        f();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        MarketWidgetInfo marketWidgetInfo;
        List<MarketWidgetInfo> list = this.f26774e;
        if (list != null) {
            if (this.f26775f >= list.size()) {
                this.f26775f = 0;
            }
            int i11 = this.f26775f;
            if (i11 >= 0 && i11 < this.f26774e.size() && (marketWidgetInfo = this.f26774e.get(this.f26775f)) != null) {
                k(marketWidgetInfo);
            }
        }
    }

    public final void f() {
        this.f26776g.removeMessages(0);
        this.f26776g.sendEmptyMessageDelayed(0, 3000);
    }

    public final void g(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "--";
        }
        if (!str.contentEquals(textView.getText())) {
            ViewPropertyAnimator animate = textView.animate();
            animate.setDuration(200);
            animate.setListener(new a(textView, str));
            animate.setInterpolator(this.f26777h);
            animate.alpha(0.5f);
            return;
        }
        textView.setText(str);
    }

    public MarketWidgetInfo getCurrentMarketWidgetInfo() {
        int i11;
        List<MarketWidgetInfo> list = this.f26774e;
        if (list == null || (i11 = this.f26775f) < 0 || i11 >= list.size()) {
            return null;
        }
        return this.f26774e.get(this.f26775f);
    }

    public int getCurrentPosition() {
        return this.f26775f;
    }

    public void h() {
        f();
    }

    public void i() {
        this.f26776g.removeMessages(0);
    }

    public final void j() {
        i.b().d(this.f26778i);
    }

    public void k(MarketWidgetInfo marketWidgetInfo) {
        int color = marketWidgetInfo.getColor();
        if (color == 0) {
            color = getResources().getColor(R$color.color_flat);
        }
        this.f26771b.setTextColor(color);
        this.f26772c.setTextColor(color);
        g(this.f26771b, marketWidgetInfo.getPrice());
        g(this.f26772c, marketWidgetInfo.getPercent());
        g(this.f26773d, marketWidgetInfo.getName());
    }

    public void setDataList(List<MarketWidgetInfo> list) {
        this.f26774e = list;
        j();
    }

    public MarketWidgetItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MarketWidgetItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f26776g = new i6.a("MarketWidgetSingleLayout", new of.a(this));
        this.f26777h = new DecelerateInterpolator();
        this.f26778i = new b(this);
        FrameLayout.inflate(context, R$layout.layout_market_widget_item, this);
        this.f26771b = (TextView) findViewById(R$id.id_market_widget_item_price);
        this.f26772c = (TextView) findViewById(R$id.id_market_widget_item_percent);
        this.f26773d = (TextView) findViewById(R$id.id_market_widget_item_name);
    }
}
