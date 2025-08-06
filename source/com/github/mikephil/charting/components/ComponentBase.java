package com.github.mikephil.charting.components;

import android.graphics.Typeface;
import com.github.mikephil.charting.utils.Utils;
import com.huobi.view.roundimg.RoundedDrawable;

public abstract class ComponentBase {

    /* renamed from: a  reason: collision with root package name */
    public boolean f65412a = true;

    /* renamed from: b  reason: collision with root package name */
    public float f65413b = 5.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f65414c = 5.0f;

    /* renamed from: d  reason: collision with root package name */
    public Typeface f65415d = null;

    /* renamed from: e  reason: collision with root package name */
    public float f65416e = Utils.e(10.0f);

    /* renamed from: f  reason: collision with root package name */
    public int f65417f = RoundedDrawable.DEFAULT_BORDER_COLOR;

    public int a() {
        return this.f65417f;
    }

    public float b() {
        return this.f65416e;
    }

    public Typeface c() {
        return this.f65415d;
    }

    public float d() {
        return this.f65413b;
    }

    public float e() {
        return this.f65414c;
    }

    public boolean f() {
        return this.f65412a;
    }

    public void g(boolean z11) {
        this.f65412a = z11;
    }

    public void h(int i11) {
        this.f65417f = i11;
    }

    public void i(float f11) {
        if (f11 > 24.0f) {
            f11 = 24.0f;
        }
        if (f11 < 6.0f) {
            f11 = 6.0f;
        }
        this.f65416e = Utils.e(f11);
    }
}
