package com.hbg.module.content.custom.like;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.hbg.module.content.R$styleable;
import com.hbg.module.content.custom.like.AnimationLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KsgLikeView extends AnimationLayout {

    /* renamed from: i  reason: collision with root package name */
    public int f18146i;

    /* renamed from: j  reason: collision with root package name */
    public int f18147j;

    /* renamed from: k  reason: collision with root package name */
    public final List<Integer> f18148k = new ArrayList();

    public KsgLikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k(attributeSet);
    }

    public void d() {
        if (!this.f18148k.isEmpty()) {
            List<Integer> list = this.f18148k;
            int abs = Math.abs(list.get(this.f18135b.nextInt(list.size())).intValue());
            FrameLayout.LayoutParams g11 = g(abs);
            AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
            appCompatImageView.setImageResource(abs);
            l(appCompatImageView, g11);
            return;
        }
        throw new NullPointerException("Missing resource file！");
    }

    public void e(List<Integer> list) {
        this.f18148k.addAll(list);
    }

    public void f(Integer... numArr) {
        e(Arrays.asList(numArr));
    }

    public final FrameLayout.LayoutParams g(int i11) {
        b(i11);
        return new FrameLayout.LayoutParams((int) this.f18138e, (int) this.f18139f, 81);
    }

    public final ValueAnimator h(View view) {
        PointF pointF = new PointF((((float) this.f18136c) - this.f18138e) / 2.0f, ((float) this.f18137d) - this.f18139f);
        ValueAnimator ofObject = ValueAnimator.ofObject(this.f18141h.c(j(1), j(2)), new Object[]{pointF, new PointF((((float) this.f18136c) - this.f18138e) + ((float) ((this.f18135b.nextBoolean() ? 1 : -1) * this.f18135b.nextInt(100))), 0.0f)});
        ofObject.addUpdateListener(new AnimationLayout.b(view));
        ofObject.setInterpolator(new LinearInterpolator());
        return ofObject.setDuration((long) this.f18147j);
    }

    public final AnimatorSet i(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, FrameLayout.ALPHA, new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(view, FrameLayout.SCALE_X, new float[]{0.15f, 0.5f}), ObjectAnimator.ofFloat(view, FrameLayout.SCALE_Y, new float[]{0.15f, 0.5f})});
        animatorSet.setInterpolator(new LinearInterpolator());
        return animatorSet.setDuration((long) this.f18146i);
    }

    public final PointF j(int i11) {
        PointF pointF = new PointF();
        pointF.x = (float) this.f18135b.nextInt(this.f18136c - 100);
        pointF.y = ((float) this.f18135b.nextInt(this.f18137d - 100)) / ((float) i11);
        return pointF;
    }

    public final void k(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.KsgLikeView);
        this.f18146i = obtainStyledAttributes.getInteger(R$styleable.KsgLikeView_ksg_enter_duration, 1500);
        this.f18147j = obtainStyledAttributes.getInteger(R$styleable.KsgLikeView_ksg_curve_duration, 4500);
        obtainStyledAttributes.recycle();
    }

    public final void l(View view, FrameLayout.LayoutParams layoutParams) {
        AnimatorSet i11 = i(view);
        ValueAnimator h11 = h(view);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{h11, i11});
        animatorSet.addListener(new AnimationLayout.a(view, animatorSet));
        animatorSet.start();
        super.addView(view, layoutParams);
    }
}
