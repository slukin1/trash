package com.huobi.utils;

import android.content.Context;
import android.graphics.Typeface;

public final class c0 {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c0 f83719b;

    /* renamed from: a  reason: collision with root package name */
    public Typeface f83720a;

    public static c0 a() {
        if (f83719b == null) {
            synchronized (c0.class) {
                if (f83719b == null) {
                    f83719b = new c0();
                }
            }
        }
        return f83719b;
    }

    public Typeface b(Context context) {
        if (this.f83720a == null && context != null) {
            c(context);
        }
        return this.f83720a;
    }

    public void c(Context context) {
        this.f83720a = Typeface.createFromAsset(context.getAssets(), "font/iconfont.ttf");
    }
}
