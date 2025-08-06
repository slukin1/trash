package com.lauzy.freedom.lbehaviorlib.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import cx.a;
import cx.b;

public abstract class CommonBehavior extends CoordinatorLayout.Behavior<View> implements a {

    /* renamed from: a  reason: collision with root package name */
    public b f26814a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f26815b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26816c = true;

    /* renamed from: d  reason: collision with root package name */
    public int f26817d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26818e = true;

    /* renamed from: f  reason: collision with root package name */
    public int f26819f = 400;

    /* renamed from: g  reason: collision with root package name */
    public Interpolator f26820g = new LinearOutSlowInInterpolator();

    /* renamed from: h  reason: collision with root package name */
    public int f26821h = 5;

    /* renamed from: i  reason: collision with root package name */
    public int f26822i = 40;

    public CommonBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i11, int i12, int[] iArr, int i13) {
        super.onNestedPreScroll(coordinatorLayout, view, view2, i11, i12, iArr, 0);
        this.f26814a.a(this.f26819f);
        this.f26814a.b(this.f26820g);
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i11, int i12, int i13, int i14, int i15) {
        super.onNestedScroll(coordinatorLayout, view, view2, i11, i12, i13, i14, 0);
        if (this.f26816c) {
            this.f26817d += i12;
            if (Math.abs(i12) >= this.f26821h || Math.abs(this.f26817d) >= this.f26822i) {
                if (i12 < 0) {
                    if (this.f26815b) {
                        this.f26814a.show();
                        this.f26815b = false;
                    }
                } else if (i12 > 0 && !this.f26815b) {
                    this.f26814a.hide();
                    this.f26815b = true;
                }
                this.f26817d = 0;
            }
        }
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i11, int i12) {
        if (this.f26818e) {
            this.f26814a = a(coordinatorLayout, view);
            this.f26818e = false;
        }
        if ((i11 & 2) != 0) {
            return true;
        }
        return false;
    }
}
