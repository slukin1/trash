package com.opensource.svgaplayer.utils;

import android.widget.ImageView;
import kotlin.Metadata;
import zx.e;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\u000b\u001a\u00020\tH\u0002R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\"\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010 \u001a\u0004\b\f\u0010!\"\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/opensource/svgaplayer/utils/SVGAScaleInfo;", "", "", "canvasWidth", "canvasHeight", "videoWidth", "videoHeight", "Landroid/widget/ImageView$ScaleType;", "scaleType", "", "f", "g", "a", "F", "d", "()F", "setTranFx", "(F)V", "tranFx", "b", "e", "setTranFy", "tranFy", "c", "setScaleFx", "scaleFx", "setScaleFy", "scaleFy", "getRatio", "setRatio", "ratio", "", "Z", "()Z", "setRatioX", "(Z)V", "ratioX", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class SVGAScaleInfo {

    /* renamed from: a  reason: collision with root package name */
    public float f28688a;

    /* renamed from: b  reason: collision with root package name */
    public float f28689b;

    /* renamed from: c  reason: collision with root package name */
    public float f28690c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f28691d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f28692e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28693f;

    public final boolean a() {
        return this.f28693f;
    }

    public final float b() {
        return this.f28690c;
    }

    public final float c() {
        return this.f28691d;
    }

    public final float d() {
        return this.f28688a;
    }

    public final float e() {
        return this.f28689b;
    }

    public final void f(float f11, float f12, float f13, float f14, ImageView.ScaleType scaleType) {
        if (f11 != 0.0f && f12 != 0.0f && f13 != 0.0f && f14 != 0.0f) {
            g();
            float f15 = (f11 - f13) / 2.0f;
            float f16 = (f12 - f14) / 2.0f;
            float f17 = f13 / f14;
            float f18 = f11 / f12;
            float f19 = f12 / f14;
            float f21 = f11 / f13;
            boolean z11 = false;
            switch (e.f29443a[scaleType.ordinal()]) {
                case 1:
                    this.f28688a = f15;
                    this.f28689b = f16;
                    return;
                case 2:
                    if (f17 > f18) {
                        this.f28692e = f19;
                        this.f28693f = false;
                        this.f28690c = f19;
                        this.f28691d = f19;
                        this.f28688a = (f11 - (f13 * f19)) / 2.0f;
                        return;
                    }
                    this.f28692e = f21;
                    this.f28693f = true;
                    this.f28690c = f21;
                    this.f28691d = f21;
                    this.f28689b = (f12 - (f14 * f21)) / 2.0f;
                    return;
                case 3:
                    if (f13 < f11 && f14 < f12) {
                        this.f28688a = f15;
                        this.f28689b = f16;
                        return;
                    } else if (f17 > f18) {
                        this.f28692e = f21;
                        this.f28693f = true;
                        this.f28690c = f21;
                        this.f28691d = f21;
                        this.f28689b = (f12 - (f14 * f21)) / 2.0f;
                        return;
                    } else {
                        this.f28692e = f19;
                        this.f28693f = false;
                        this.f28690c = f19;
                        this.f28691d = f19;
                        this.f28688a = (f11 - (f13 * f19)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f17 > f18) {
                        this.f28692e = f21;
                        this.f28693f = true;
                        this.f28690c = f21;
                        this.f28691d = f21;
                        this.f28689b = (f12 - (f14 * f21)) / 2.0f;
                        return;
                    }
                    this.f28692e = f19;
                    this.f28693f = false;
                    this.f28690c = f19;
                    this.f28691d = f19;
                    this.f28688a = (f11 - (f13 * f19)) / 2.0f;
                    return;
                case 5:
                    if (f17 > f18) {
                        this.f28692e = f21;
                        this.f28693f = true;
                        this.f28690c = f21;
                        this.f28691d = f21;
                        return;
                    }
                    this.f28692e = f19;
                    this.f28693f = false;
                    this.f28690c = f19;
                    this.f28691d = f19;
                    return;
                case 6:
                    if (f17 > f18) {
                        this.f28692e = f21;
                        this.f28693f = true;
                        this.f28690c = f21;
                        this.f28691d = f21;
                        this.f28689b = f12 - (f14 * f21);
                        return;
                    }
                    this.f28692e = f19;
                    this.f28693f = false;
                    this.f28690c = f19;
                    this.f28691d = f19;
                    this.f28688a = f11 - (f13 * f19);
                    return;
                case 7:
                    this.f28692e = Math.max(f21, f19);
                    if (f21 > f19) {
                        z11 = true;
                    }
                    this.f28693f = z11;
                    this.f28690c = f21;
                    this.f28691d = f19;
                    return;
                default:
                    this.f28692e = f21;
                    this.f28693f = true;
                    this.f28690c = f21;
                    this.f28691d = f21;
                    return;
            }
        }
    }

    public final void g() {
        this.f28688a = 0.0f;
        this.f28689b = 0.0f;
        this.f28690c = 1.0f;
        this.f28691d = 1.0f;
        this.f28692e = 1.0f;
        this.f28693f = false;
    }
}
