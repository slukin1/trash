package com.hbg.module.libkt.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.hbg.module.libkt.R$styleable;

public final class RingViewAttr {

    /* renamed from: a  reason: collision with root package name */
    public final int f24725a;

    /* renamed from: b  reason: collision with root package name */
    public final int f24726b;

    /* renamed from: c  reason: collision with root package name */
    public final int f24727c;

    /* renamed from: d  reason: collision with root package name */
    public final int f24728d;

    /* renamed from: e  reason: collision with root package name */
    public final int f24729e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f24730f;

    /* renamed from: g  reason: collision with root package name */
    public final int f24731g;

    public RingViewAttr(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleProgress);
        this.f24725a = obtainStyledAttributes.getColor(R$styleable.CircleProgress_circleBgColor, -1);
        this.f24726b = obtainStyledAttributes.getColor(R$styleable.CircleProgress_ringColor, -65536);
        this.f24727c = obtainStyledAttributes.getColor(R$styleable.CircleProgress_ringBgColor, -1);
        this.f24728d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CircleProgress_ringDiameter, 40);
        this.f24729e = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CircleProgress_ringWidth, 10);
        this.f24730f = obtainStyledAttributes.getBoolean(R$styleable.CircleProgress_isShowAnim, false);
        this.f24731g = obtainStyledAttributes.getInt(R$styleable.CircleProgress_speed, 100);
        obtainStyledAttributes.recycle();
    }

    public final int a() {
        return this.f24725a;
    }

    public final int b() {
        return this.f24727c;
    }

    public final int c() {
        return this.f24726b;
    }

    public final int d() {
        return this.f24728d;
    }

    public final int e() {
        return this.f24729e;
    }
}
