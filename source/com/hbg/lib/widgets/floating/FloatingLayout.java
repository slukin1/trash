package com.hbg.lib.widgets.floating;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.h0;
import ga.a;
import i6.d;

public class FloatingLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    public View f72035a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f72036b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup.LayoutParams f72037c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f72038d;

    public FrameLayout a() {
        return this.f72036b;
    }

    public a d(View view) {
        this.f72035a = view;
        this.f72037c = view.getLayoutParams();
        return this;
    }

    public View e() {
        return this.f72035a;
    }

    /* renamed from: f */
    public FloatingLayout c(Activity activity) {
        this.f72038d = activity;
        g(j(activity));
        return this;
    }

    public final FloatingLayout g(FrameLayout frameLayout) {
        View view;
        if (frameLayout == null || (view = this.f72035a) == null) {
            this.f72036b = frameLayout;
            return this;
        } else if (view.getParent() == frameLayout) {
            return this;
        } else {
            if (this.f72035a.getParent() != null) {
                ((ViewGroup) this.f72035a.getParent()).removeView(this.f72035a);
            }
            this.f72036b = frameLayout;
            d.b("显示在新的视图中 " + this.f72035a.toString());
            frameLayout.addView(this.f72035a, this.f72037c);
            return this;
        }
    }

    /* renamed from: h */
    public FloatingLayout b(Activity activity) {
        if (this.f72038d != activity) {
            return this;
        }
        i(j(activity));
        return this;
    }

    public final FloatingLayout i(FrameLayout frameLayout) {
        View view = this.f72035a;
        if (!(view == null || frameLayout == null || !h0.Z(view))) {
            d.b("在老的视图中删除");
            frameLayout.removeView(this.f72035a);
        }
        if (this.f72036b == frameLayout) {
            this.f72036b = null;
        }
        return this;
    }

    public final FrameLayout j(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            return (FrameLayout) activity.getWindow().getDecorView().findViewById(16908290);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public void reset() {
    }
}
