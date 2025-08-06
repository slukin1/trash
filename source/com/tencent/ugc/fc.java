package com.tencent.ugc;

final /* synthetic */ class fc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCRotateScaleFilter f50507a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50508b;

    /* renamed from: c  reason: collision with root package name */
    private final float f50509c;

    private fc(UGCRotateScaleFilter uGCRotateScaleFilter, float f11, float f12) {
        this.f50507a = uGCRotateScaleFilter;
        this.f50508b = f11;
        this.f50509c = f12;
    }

    public static Runnable a(UGCRotateScaleFilter uGCRotateScaleFilter, float f11, float f12) {
        return new fc(uGCRotateScaleFilter, f11, f12);
    }

    public final void run() {
        this.f50507a.setScaleInternal(this.f50507a.setRotateInternal((float[]) null, this.f50508b), this.f50509c);
    }
}
