package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import java.util.List;

public class LittlePieChartAnimView extends View {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f71483b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f71484c;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f71485d;

    /* renamed from: e  reason: collision with root package name */
    public final List<b> f71486e;

    /* renamed from: f  reason: collision with root package name */
    public final RectF f71487f;

    /* renamed from: g  reason: collision with root package name */
    public final Path f71488g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f71489h;

    /* renamed from: i  reason: collision with root package name */
    public float f71490i;

    /* renamed from: j  reason: collision with root package name */
    public float f71491j;

    /* renamed from: k  reason: collision with root package name */
    public int f71492k;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: com.hbg.lib.widgets.LittlePieChartAnimView$a$a  reason: collision with other inner class name */
        public class C0786a extends AnimatorListenerAdapter {

            /* renamed from: com.hbg.lib.widgets.LittlePieChartAnimView$a$a$a  reason: collision with other inner class name */
            public class C0787a extends AnimatorListenerAdapter {
                public C0787a() {
                }

                public void onAnimationEnd(Animator animator) {
                    LittlePieChartAnimView.this.n();
                    if (LittlePieChartAnimView.this.f71492k > 0) {
                        LittlePieChartAnimView.this.i();
                    }
                }
            }

            public C0786a() {
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void b(ValueAnimator valueAnimator) {
                float unused = ((b) LittlePieChartAnimView.this.f71486e.get(0)).f71498c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }

            public void onAnimationEnd(Animator animator) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.875f, 1.0f});
                ofFloat.addUpdateListener(new b1(this));
                ofFloat.setInterpolator(new AccelerateInterpolator());
                ofFloat.addListener(new C0787a());
                ofFloat.setDuration(175);
                ofFloat.start();
            }
        }

        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(ValueAnimator valueAnimator) {
            float unused = LittlePieChartAnimView.this.f71490i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(ValueAnimator valueAnimator) {
            float unused = LittlePieChartAnimView.this.f71491j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        }

        public void onAnimationEnd(Animator animator) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
            ofFloat.addUpdateListener(new a1(this));
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(560);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
            ofFloat2.addUpdateListener(new z0(this));
            ofFloat2.setInterpolator(new DecelerateInterpolator());
            ofFloat2.setStartDelay(280);
            ofFloat2.setDuration(560);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.addListener(new C0786a());
            animatorSet.start();
        }

        public void onAnimationStart(Animator animator) {
            boolean unused = LittlePieChartAnimView.this.f71489h = true;
            LittlePieChartAnimView.this.invalidate();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public float f71496a;

        /* renamed from: b  reason: collision with root package name */
        public int f71497b;

        /* renamed from: c  reason: collision with root package name */
        public float f71498c;

        /* renamed from: d  reason: collision with root package name */
        public float f71499d;

        public b(float f11, int i11, float f12) {
            this.f71496a = f11;
            this.f71497b = i11;
            this.f71499d = f12;
            this.f71498c = f12;
        }

        public void e() {
            this.f71498c = this.f71499d;
        }
    }

    public LittlePieChartAnimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int getCurrentBgColor() {
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            return ((ColorDrawable) background).getColor();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(ValueAnimator valueAnimator) {
        float unused = this.f71486e.get(0).f71498c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(int i11, ValueAnimator valueAnimator) {
        float unused = this.f71486e.get(i11).f71498c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    public final void i() {
        this.f71492k--;
        this.f71490i = 0.0f;
        this.f71491j = 0.0f;
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.875f});
        ofFloat.addUpdateListener(new x0(this));
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.setDuration(175);
        arrayList.add(ofFloat);
        for (int i11 = 1; i11 < this.f71486e.size(); i11++) {
            arrayList.add(j(i11));
        }
        animatorSet.playSequentially(arrayList);
        animatorSet.addListener(new a());
        animatorSet.start();
    }

    public final ValueAnimator j(int i11) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.875f, 1.0f, 0.875f});
        ofFloat.addUpdateListener(new y0(this, i11));
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(350);
        return ofFloat;
    }

    public final void k() {
        this.f71483b.setAntiAlias(true);
        this.f71483b.setStyle(Paint.Style.FILL);
        int currentBgColor = getCurrentBgColor();
        this.f71484c.setAntiAlias(true);
        this.f71484c.setColor(currentBgColor);
        this.f71485d.setAntiAlias(true);
        this.f71485d.setColor(currentBgColor);
        this.f71486e.add(new b(0.25f, -15170860, 1.0f));
        this.f71486e.add(new b(0.17f, -87492, 0.875f));
        this.f71486e.add(new b(0.58f, -16721742, 0.875f));
    }

    public void n() {
        this.f71489h = false;
        for (b e11 : this.f71486e) {
            e11.e();
        }
        this.f71490i = 0.0f;
        this.f71491j = 0.0f;
        invalidate();
    }

    public void o(int i11) {
        if (i11 > 0) {
            this.f71492k = i11;
            if (!this.f71489h) {
                i();
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        this.f71488g.reset();
        this.f71488g.addCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (((float) getWidth()) * 0.417f) / 2.0f, Path.Direction.CCW);
        canvas.clipPath(this.f71488g, Region.Op.DIFFERENCE);
        float size = 360.0f - ((float) this.f71486e.size());
        this.f71484c.setStrokeWidth(((float) getWidth()) * 0.07f);
        int i11 = 0;
        float f11 = 0.0f;
        while (i11 < this.f71486e.size()) {
            b bVar = this.f71486e.get(i11);
            float width2 = (((float) getWidth()) * (1.0f - bVar.f71498c)) / 2.0f;
            this.f71487f.set(width2, width2, ((float) getWidth()) - width2, ((float) getHeight()) - width2);
            this.f71483b.setColor(bVar.f71497b);
            float d11 = bVar.f71496a * size;
            if (i11 == this.f71486e.size() - 1 && f11 + d11 < 360.0f) {
                d11 = 360.0f - f11;
            }
            float f12 = d11;
            canvas.drawArc(this.f71487f, f11 - 0.049804688f, f12, true, this.f71483b);
            i11++;
            f11 += f12;
        }
        int i12 = 0;
        float f13 = 0.0f;
        while (i12 < this.f71486e.size()) {
            float width3 = (((float) getWidth()) * 1.0f) / 2.0f;
            float d12 = this.f71486e.get(i12).f71496a * size;
            if (i12 == this.f71486e.size() - 1 && f13 + d12 < 360.0f) {
                d12 = 360.0f - f13;
            }
            float f14 = f13 + d12;
            double d13 = (double) width3;
            double d14 = (((double) (f14 - 0.049804688f)) * 3.141592653589793d) / 180.0d;
            canvas.drawLine(width, height, (float) (((double) width) + (Math.cos(d14) * d13)), (float) (((double) height) + (d13 * Math.sin(d14))), this.f71484c);
            i12++;
            Canvas canvas2 = canvas;
            f13 = f14;
        }
        if (this.f71490i != this.f71491j) {
            this.f71487f.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            float f15 = this.f71491j;
            canvas.drawArc(this.f71487f, f15 - 0.049804688f, this.f71490i - f15, true, this.f71485d);
        }
        if (this.f71489h) {
            invalidate();
        }
    }

    public void setItemList(List<b> list) {
        if (list != null) {
            n();
            this.f71486e.clear();
            this.f71486e.addAll(list);
            invalidate();
        }
    }

    public void setLineColor(int i11) {
        this.f71484c.setColor(i11);
        this.f71485d.setColor(i11);
        invalidate();
    }

    public LittlePieChartAnimView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71483b = new Paint();
        this.f71484c = new Paint();
        this.f71485d = new Paint();
        this.f71486e = new ArrayList();
        this.f71487f = new RectF();
        this.f71488g = new Path();
        this.f71490i = 0.0f;
        this.f71491j = 0.0f;
        k();
    }
}
