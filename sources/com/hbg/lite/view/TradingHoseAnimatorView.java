package com.hbg.lite.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.trade.DonutProgressBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import rb.c;
import rb.d;
import rb.e;
import rb.f;
import rb.g;
import rb.h;

public class TradingHoseAnimatorView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f77612b;

    /* renamed from: c  reason: collision with root package name */
    public DonutProgressBar f77613c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f77614d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f77615e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f77616f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f77617g;

    /* renamed from: h  reason: collision with root package name */
    public long f77618h = 1000;

    /* renamed from: i  reason: collision with root package name */
    public b f77619i;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
            TradingHoseAnimatorView.this.f77612b.setAlpha(1.0f);
            TradingHoseAnimatorView.this.f77617g.cancel();
            TradingHoseAnimatorView.this.f77617g.setStartDelay((long) (((double) TradingHoseAnimatorView.this.f77618h) * 0.8d));
            TradingHoseAnimatorView.this.f77617g.start();
        }

        public void onAnimationStart(Animator animator) {
            Log.e("onAnimationStart", "onAnimationStart");
            TradingHoseAnimatorView.this.f77612b.setAlpha(1.0f);
            TradingHoseAnimatorView.this.f77617g.setStartDelay((long) (((double) TradingHoseAnimatorView.this.f77618h) * 0.8d));
            TradingHoseAnimatorView.this.f77617g.start();
        }
    }

    public interface b {
        void a();

        void onComplete();
    }

    public TradingHoseAnimatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f77613c.setScaleX(floatValue);
        this.f77613c.setScaleY(floatValue);
        this.f77614d.setScaleX(floatValue);
        this.f77614d.setScaleY(floatValue);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f77612b.setScaleX(floatValue);
        this.f77612b.setScaleY(floatValue);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(ValueAnimator valueAnimator) {
        this.f77612b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o() {
        if (this.f77619i != null) {
            this.f77613c.g();
            this.f77619i.onComplete();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p() {
        if (this.f77619i != null) {
            this.f77613c.g();
            this.f77619i.a();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q(View view) {
        ValueAnimator valueAnimator = this.f77615e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f77613c.l();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void j() {
        ValueAnimator valueAnimator = this.f77615e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f77615e = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 1.05f, 1.0f});
        this.f77615e = ofFloat;
        ofFloat.setDuration(this.f77618h);
        this.f77615e.setRepeatMode(1);
        this.f77615e.setRepeatCount(-1);
        this.f77615e.setInterpolator(new LinearInterpolator());
        this.f77615e.addUpdateListener(new c(this));
        this.f77615e.addListener(new a());
        ValueAnimator valueAnimator2 = this.f77616f;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.f77616f = null;
        }
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 1.58f});
        this.f77616f = ofFloat2;
        ofFloat2.setDuration(this.f77618h);
        this.f77616f.setRepeatMode(1);
        this.f77616f.setRepeatCount(-1);
        this.f77616f.setInterpolator(new LinearInterpolator());
        this.f77616f.addUpdateListener(new e(this));
        ValueAnimator valueAnimator3 = this.f77617g;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.f77617g = null;
        }
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.f77617g = ofFloat3;
        ofFloat3.setDuration(200);
        this.f77617g.setRepeatMode(1);
        this.f77617g.setRepeatCount(-1);
        this.f77617g.setInterpolator(new LinearInterpolator());
        this.f77617g.addUpdateListener(new d(this));
        this.f77615e.start();
        this.f77616f.start();
    }

    public final void k() {
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.view_trading_hose_animatior_layout, this, false);
        this.f77612b = inflate.findViewById(R$id.breathe_bg_view);
        this.f77613c = (DonutProgressBar) inflate.findViewById(R$id.confirm_order_donut_progress);
        this.f77614d = (TextView) inflate.findViewById(R$id.vendor_confirm_tv);
        addView(inflate);
        this.f77613c.setOnResetCompleteListener(new g(this));
        this.f77613c.setOnCompleteListener(new h(this));
        this.f77614d.setOnClickListener(new f(this));
    }

    public void r() {
        j();
        this.f77613c.k();
    }

    public void s() {
        ValueAnimator valueAnimator = this.f77615e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f77615e = null;
        }
        ValueAnimator valueAnimator2 = this.f77616f;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.f77616f = null;
        }
        ValueAnimator valueAnimator3 = this.f77617g;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.f77617g = null;
        }
        DonutProgressBar donutProgressBar = this.f77613c;
        if (donutProgressBar != null) {
            donutProgressBar.g();
        }
    }

    public void setMaxTime(long j11) {
        this.f77613c.setMax(j11);
    }

    public void setTradingHoseAnimaViewCallback(b bVar) {
        this.f77619i = bVar;
    }

    public TradingHoseAnimatorView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        k();
    }
}
