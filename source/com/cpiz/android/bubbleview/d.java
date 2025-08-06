package com.cpiz.android.bubbleview;

import com.cpiz.android.bubbleview.BubbleStyle;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f64812a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f64813b = 0;

    public d(int i11, int i12) {
        this.f64812a = i11;
        this.f64813b = i12;
    }

    public BubbleStyle.ArrowDirection a() {
        if (d() && !e()) {
            int i11 = this.f64812a;
            if (i11 == 2) {
                return BubbleStyle.ArrowDirection.Left;
            }
            if (i11 == 1) {
                return BubbleStyle.ArrowDirection.Right;
            }
        }
        if (!d() && e()) {
            int i12 = this.f64813b;
            if (i12 == 2) {
                return BubbleStyle.ArrowDirection.Up;
            }
            if (i12 == 1) {
                return BubbleStyle.ArrowDirection.Down;
            }
        }
        return BubbleStyle.ArrowDirection.None;
    }

    public int b() {
        return this.f64812a;
    }

    public int c() {
        return this.f64813b;
    }

    public final boolean d() {
        int i11 = this.f64812a;
        return i11 == 1 || i11 == 2;
    }

    public final boolean e() {
        int i11 = this.f64813b;
        return i11 == 1 || i11 == 2;
    }
}
