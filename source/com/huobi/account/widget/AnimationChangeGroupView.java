package com.huobi.account.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import sn.f;
import wg.o;

public class AnimationChangeGroupView extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public int f41900b;

    /* renamed from: c  reason: collision with root package name */
    public int f41901c;

    /* renamed from: d  reason: collision with root package name */
    public int f41902d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41903e;

    /* renamed from: f  reason: collision with root package name */
    public long f41904f;

    /* renamed from: g  reason: collision with root package name */
    public long f41905g;

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f41906h;

    /* renamed from: i  reason: collision with root package name */
    public Animator.AnimatorListener f41907i;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
            boolean unused = AnimationChangeGroupView.this.f41903e = false;
        }

        public void onAnimationEnd(Animator animator) {
            boolean unused = AnimationChangeGroupView.this.f41903e = false;
        }

        public void onAnimationRepeat(Animator animator) {
            boolean unused = AnimationChangeGroupView.this.f41903e = true;
        }

        public void onAnimationStart(Animator animator) {
            boolean unused = AnimationChangeGroupView.this.f41903e = true;
        }
    }

    public AnimationChangeGroupView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = intValue;
        setLayoutParams(layoutParams);
        View childAt = getChildAt(this.f41902d);
        ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
        if (layoutParams2.height != intValue) {
            layoutParams2.height = intValue;
            childAt.setLayoutParams(layoutParams2);
        }
    }

    public void c() {
        int i11 = this.f41902d - 1;
        if (e(i11)) {
            View childAt = getChildAt(this.f41902d);
            View childAt2 = getChildAt(i11);
            if (childAt != null && childAt2 != null && f()) {
                d(childAt2, childAt);
                this.f41902d--;
            }
        }
    }

    public final void d(View view, View view2) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f}), PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 1.0f})});
        ofPropertyValuesHolder.setDuration(300);
        ofPropertyValuesHolder.start();
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view2, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f}), PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 0.0f})});
        ofPropertyValuesHolder2.setDuration(300);
        ofPropertyValuesHolder2.start();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{view2.getMeasuredHeight(), view.getMeasuredHeight()});
        ofInt.addUpdateListener(this.f41906h);
        ofInt.addListener(this.f41907i);
        ofInt.setDuration(300);
        ofInt.start();
    }

    public final boolean e(int i11) {
        return i11 < getChildCount() && i11 >= 0;
    }

    public final boolean f() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f41905g <= this.f41904f) {
            return false;
        }
        this.f41905g = currentTimeMillis;
        return true;
    }

    public void g(Activity activity) {
        activity.startActivity(f.e0(activity, (String) null));
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int childCount = getChildCount();
        if (childCount >= this.f41901c) {
            this.f41900b = getWidth();
            View childAt = getChildAt(this.f41902d);
            int i15 = childAt.getLayoutParams().height;
            if (i15 <= 0) {
                i15 = childAt.getMeasuredHeight();
            }
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt2 = getChildAt(i16);
                int i17 = this.f41900b * i16;
                childAt2.layout(i17, getMeasuredHeight() - i15, this.f41900b + i17, getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            measureChild(getChildAt(i13), i11, i12);
        }
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            int measuredHeight = getChildAt(i15).getMeasuredHeight();
            if (this.f41902d == i15) {
                i14 = measuredHeight;
            }
        }
        if (this.f41903e) {
            setMeasuredDimension(size, size2);
        } else {
            setMeasuredDimension(size, i14);
        }
    }

    public AnimationChangeGroupView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41900b = 0;
        this.f41901c = 2;
        this.f41902d = 0;
        this.f41903e = false;
        this.f41904f = 400;
        this.f41905g = 0;
        this.f41906h = new o(this);
        this.f41907i = new a();
    }
}
