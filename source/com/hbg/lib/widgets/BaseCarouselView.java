package com.hbg.lib.widgets;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import i6.d;
import i6.t;
import java.util.List;

public abstract class BaseCarouselView<T> extends FrameLayout implements t.a {

    /* renamed from: b  reason: collision with root package name */
    public final long f71025b;

    /* renamed from: c  reason: collision with root package name */
    public final Interpolator f71026c;

    /* renamed from: d  reason: collision with root package name */
    public final int f71027d;

    /* renamed from: e  reason: collision with root package name */
    public final int f71028e;

    /* renamed from: f  reason: collision with root package name */
    public View f71029f;

    /* renamed from: g  reason: collision with root package name */
    public View f71030g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f71031h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f71032i;

    /* renamed from: j  reason: collision with root package name */
    public int f71033j;

    /* renamed from: k  reason: collision with root package name */
    public List<T> f71034k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f71035l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f71036m;

    public BaseCarouselView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        d.b("TopScrollSymbolItemView-->continueAnim-->-->-->滑出去了");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, FrameLayout.TRANSLATION_Y, new float[]{0.0f, (float) (-getHeight())});
        ofFloat.setInterpolator(this.f71026c);
        ofFloat.setDuration(500);
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, FrameLayout.TRANSLATION_Y, new float[]{(float) getHeight(), 0.0f});
        ofFloat.setInterpolator(this.f71026c);
        ofFloat.setDuration(500);
        ofFloat.start();
    }

    public void c(View view) {
        post(new c(this, view));
    }

    public final T d(int i11) {
        List<T> list = this.f71034k;
        if (list == null || list.isEmpty() || i11 >= this.f71034k.size()) {
            return null;
        }
        return this.f71034k.get(i11);
    }

    public final void e(Context context, AttributeSet attributeSet) {
        this.f71031h = new t(this);
        this.f71036m = true;
        f(context);
    }

    public abstract void f(Context context);

    public View getItemViewBehind() {
        return this.f71030g;
    }

    public View getItemViewFront() {
        return this.f71029f;
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            if (d(this.f71033j) != null) {
                this.f71033j++;
            }
            List<T> list = this.f71034k;
            if (list == null || this.f71033j >= list.size()) {
                this.f71033j = 0;
            }
            l();
        }
    }

    public abstract void i(T t11, View view);

    public void j(View view) {
        i(d(this.f71033j), view);
        post(new d(this, view));
    }

    public void k() {
        this.f71036m = false;
        Handler handler = this.f71031h;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public final void l() {
        if (this.f71032i) {
            j(this.f71029f);
            c(this.f71030g);
        } else {
            j(this.f71030g);
            c(this.f71029f);
        }
        this.f71032i = !this.f71032i;
        if (this.f71036m) {
            this.f71031h.sendEmptyMessageDelayed(1, 5000);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
    }

    public void setDatas(List<T> list) {
        this.f71034k = list;
        if (!this.f71035l) {
            this.f71035l = true;
            this.f71033j = 0;
            this.f71032i = true;
            l();
        }
    }

    public BaseCarouselView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71025b = 500;
        this.f71026c = new DecelerateInterpolator();
        this.f71027d = 1;
        this.f71028e = 5000;
        this.f71032i = true;
        e(context, attributeSet);
    }
}
