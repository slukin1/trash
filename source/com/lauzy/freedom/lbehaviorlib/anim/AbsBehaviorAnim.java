package com.lauzy.freedom.lbehaviorlib.anim;

import android.view.animation.Interpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import cx.b;

public abstract class AbsBehaviorAnim implements b {

    /* renamed from: a  reason: collision with root package name */
    public Interpolator f26812a = new LinearOutSlowInInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public int f26813b = 400;

    public void a(int i11) {
        this.f26813b = i11;
    }

    public void b(Interpolator interpolator) {
        this.f26812a = interpolator;
    }

    public int c() {
        return this.f26813b;
    }

    public Interpolator d() {
        return this.f26812a;
    }
}
