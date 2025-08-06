package com.hbg.lib.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import cx.a;
import cx.b;

public class HuobiBottomBehavior extends CoordinatorLayout.Behavior<View> implements a {

    /* renamed from: a  reason: collision with root package name */
    public b f68543a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68544b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f68545c = true;

    /* renamed from: d  reason: collision with root package name */
    public int f68546d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68547e = true;

    /* renamed from: f  reason: collision with root package name */
    public int f68548f = 400;

    /* renamed from: g  reason: collision with root package name */
    public Interpolator f68549g = new LinearOutSlowInInterpolator();

    /* renamed from: h  reason: collision with root package name */
    public int f68550h = 5;

    /* renamed from: i  reason: collision with root package name */
    public int f68551i = 40;

    public HuobiBottomBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public b a(CoordinatorLayout coordinatorLayout, View view) {
        return new dx.a(view);
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i11, int i12, int[] iArr, int i13) {
        super.onNestedPreScroll(coordinatorLayout, view, view2, i11, i12, iArr, 0);
        this.f68543a.a(this.f68548f);
        this.f68543a.b(this.f68549g);
        if (this.f68545c) {
            this.f68546d += i12;
            if (Math.abs(i12) >= this.f68550h || Math.abs(this.f68546d) >= this.f68551i) {
                if (i12 < 0) {
                    if (this.f68544b) {
                        this.f68543a.show();
                        this.f68544b = false;
                    }
                } else if (i12 > 0 && !this.f68544b) {
                    this.f68543a.hide();
                    this.f68544b = true;
                }
                this.f68546d = 0;
            }
        }
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i11, int i12) {
        if (this.f68547e) {
            this.f68543a = a(coordinatorLayout, view);
            this.f68547e = false;
        }
        if ((i11 & 2) != 0) {
            return true;
        }
        return false;
    }
}
