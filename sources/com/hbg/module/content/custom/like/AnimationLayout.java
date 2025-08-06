package com.hbg.module.content.custom.like;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.hbg.module.content.custom.like.evaluator.CurveEvaluatorRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AnimationLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public final Random f18135b = new Random();

    /* renamed from: c  reason: collision with root package name */
    public int f18136c;

    /* renamed from: d  reason: collision with root package name */
    public int f18137d;

    /* renamed from: e  reason: collision with root package name */
    public float f18138e;

    /* renamed from: f  reason: collision with root package name */
    public float f18139f;

    /* renamed from: g  reason: collision with root package name */
    public List<AnimatorSet> f18140g;

    /* renamed from: h  reason: collision with root package name */
    public CurveEvaluatorRecord f18141h;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public View f18142b;

        /* renamed from: c  reason: collision with root package name */
        public final AnimatorSet f18143c;

        public a(View view, AnimatorSet animatorSet) {
            this.f18142b = view;
            this.f18143c = animatorSet;
            AnimationLayout.this.f18140g.add(animatorSet);
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            AnimationLayout.this.removeView(this.f18142b);
            AnimationLayout.this.f18140g.remove(this.f18143c);
            this.f18142b = null;
        }
    }

    public static class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final View f18145b;

        public b(View view) {
            this.f18145b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PointF pointF = (PointF) valueAnimator.getAnimatedValue();
            this.f18145b.setX(pointF.x);
            this.f18145b.setY(pointF.y);
            this.f18145b.setAlpha(1.0f - valueAnimator.getAnimatedFraction());
        }
    }

    public AnimationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a() {
        removeAllViews();
        List<AnimatorSet> list = this.f18140g;
        if (list != null) {
            for (AnimatorSet next : list) {
                next.getListeners().clear();
                next.cancel();
            }
            this.f18140g.clear();
            this.f18140g = null;
        }
        CurveEvaluatorRecord curveEvaluatorRecord = this.f18141h;
        if (curveEvaluatorRecord != null) {
            curveEvaluatorRecord.b();
            this.f18141h = null;
        }
    }

    public void b(int i11) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getContext().getResources(), i11, options);
        this.f18138e = (float) options.outWidth;
        this.f18139f = (float) options.outHeight;
    }

    public void c() {
        if (this.f18140g == null) {
            this.f18140g = new ArrayList();
        }
        if (this.f18141h == null) {
            this.f18141h = new CurveEvaluatorRecord();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.f18136c = getMeasuredWidth();
        this.f18137d = getMeasuredHeight();
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f18136c = getMeasuredWidth();
        this.f18137d = getMeasuredHeight();
    }
}
