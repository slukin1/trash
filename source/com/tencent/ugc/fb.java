package com.tencent.ugc;

final /* synthetic */ class fb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCRotateScaleFilter f50505a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50506b;

    private fb(UGCRotateScaleFilter uGCRotateScaleFilter, float f11) {
        this.f50505a = uGCRotateScaleFilter;
        this.f50506b = f11;
    }

    public static Runnable a(UGCRotateScaleFilter uGCRotateScaleFilter, float f11) {
        return new fb(uGCRotateScaleFilter, f11);
    }

    public final void run() {
        this.f50505a.setRotateInternal((float[]) null, this.f50506b);
    }
}
