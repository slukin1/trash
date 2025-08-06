package com.huobi.otc.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.h0;
import androidx.customview.widget.ViewDragHelper;
import com.hbg.module.otc.R$id;
import vp.m;

public class FAQGestureFrameLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public int f79788b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f79789c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f79790d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f79791e;

    /* renamed from: f  reason: collision with root package name */
    public float f79792f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f79793g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public ViewDragHelper f79794h;

    /* renamed from: i  reason: collision with root package name */
    public View f79795i;

    /* renamed from: j  reason: collision with root package name */
    public View f79796j;

    /* renamed from: k  reason: collision with root package name */
    public int f79797k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f79798l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f79799m;

    /* renamed from: n  reason: collision with root package name */
    public ValueAnimator f79800n;

    /* renamed from: o  reason: collision with root package name */
    public Runnable f79801o;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f79802b;

        public a(Runnable runnable) {
            this.f79802b = runnable;
        }

        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            FAQGestureFrameLayout.this.j(this.f79802b);
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            FAQGestureFrameLayout.this.j(this.f79802b);
        }
    }

    public class b extends ViewDragHelper.Callback {
        public b() {
        }

        public int clampViewPositionVertical(View view, int i11, int i12) {
            return Math.max(FAQGestureFrameLayout.this.getHeight() - FAQGestureFrameLayout.this.f79795i.getHeight(), i11);
        }

        public int getViewVerticalDragRange(View view) {
            return FAQGestureFrameLayout.this.getHeight();
        }

        public void onViewPositionChanged(View view, int i11, int i12, int i13, int i14) {
            super.onViewPositionChanged(view, i11, i12, i13, i14);
            int unused = FAQGestureFrameLayout.this.f79797k = i12;
            FAQGestureFrameLayout.this.invalidate();
            if (i12 >= FAQGestureFrameLayout.this.getHeight() && FAQGestureFrameLayout.this.f79801o != null) {
                FAQGestureFrameLayout.this.f79801o.run();
            }
        }

        public void onViewReleased(View view, float f11, float f12) {
            super.onViewReleased(view, f11, f12);
            if (f12 > ((float) FAQGestureFrameLayout.this.f79791e) || (f12 >= 0.0f && FAQGestureFrameLayout.this.f79797k > FAQGestureFrameLayout.this.getHeight() / 2)) {
                FAQGestureFrameLayout.this.f79794h.Q(0, FAQGestureFrameLayout.this.getHeight());
            } else {
                FAQGestureFrameLayout.this.f79794h.Q(0, FAQGestureFrameLayout.this.getHeight() - FAQGestureFrameLayout.this.f79795i.getHeight());
            }
            FAQGestureFrameLayout.this.invalidate();
        }

        public boolean tryCaptureView(View view, int i11) {
            return view == FAQGestureFrameLayout.this.f79795i;
        }

        public /* synthetic */ b(FAQGestureFrameLayout fAQGestureFrameLayout, a aVar) {
            this();
        }
    }

    public FAQGestureFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f79795i;
        view.setTranslationY(((float) view.getHeight()) * (1.0f - floatValue));
    }

    public void computeScroll() {
        if (this.f79794h.n(true)) {
            invalidate();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f79798l = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void j(Runnable runnable) {
        this.f79799m = false;
        removeCallbacks(runnable);
        postDelayed(runnable, 10);
    }

    public void k(Runnable runnable) {
        if (!this.f79799m) {
            this.f79799m = true;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            this.f79800n = ofFloat;
            ofFloat.setDuration(250);
            this.f79800n.addUpdateListener(new m(this));
            this.f79800n.addListener(new a(runnable));
            this.f79800n.setInterpolator(getTranslationY() == 0.0f ? new AccelerateDecelerateInterpolator() : new LinearInterpolator());
            this.f79800n.start();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f79795i = findViewById(R$id.cl_dialog_root);
        this.f79796j = findViewById(R$id.rl_top);
        this.f79794h = ViewDragHelper.p(this, new b(this, (a) null));
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f79788b = viewConfiguration.getScaledTouchSlop();
        this.f79791e = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z11 = true;
        if (motionEvent.getAction() == 2 && this.f79789c) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f79789c = false;
            this.f79790d = false;
            this.f79792f = motionEvent.getRawX();
            this.f79793g = motionEvent.getRawY();
            boolean z12 = motionEvent.getY() > ((float) this.f79796j.getHeight());
            this.f79798l = z12;
            if (z12) {
                return false;
            }
        } else if (action == 2) {
            if (this.f79790d) {
                return false;
            }
            float rawX = motionEvent.getRawX() - this.f79792f;
            float rawY = motionEvent.getRawY() - this.f79793g;
            if (rawY < 0.0f || (Math.abs(rawX) > ((float) this.f79788b) && Math.abs(rawX) > Math.abs(rawY))) {
                this.f79790d = true;
                return false;
            }
        }
        if (this.f79798l || !this.f79794h.R(motionEvent)) {
            z11 = false;
        }
        this.f79789c = z11;
        return z11;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        h0.h0(this.f79795i, this.f79797k);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f79789c) {
            this.f79794h.H(motionEvent);
        }
        return this.f79789c;
    }

    public void setEndRunnable(Runnable runnable) {
        this.f79801o = runnable;
    }

    public FAQGestureFrameLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
