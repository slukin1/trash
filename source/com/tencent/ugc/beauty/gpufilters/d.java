package com.tencent.ugc.beauty.gpufilters;

import android.graphics.Bitmap;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPULookupFilterGroup f50202a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50203b;

    /* renamed from: c  reason: collision with root package name */
    private final float f50204c;

    /* renamed from: d  reason: collision with root package name */
    private final float f50205d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap f50206e;

    /* renamed from: f  reason: collision with root package name */
    private final Bitmap f50207f;

    private d(TXCGPULookupFilterGroup tXCGPULookupFilterGroup, float f11, float f12, float f13, Bitmap bitmap, Bitmap bitmap2) {
        this.f50202a = tXCGPULookupFilterGroup;
        this.f50203b = f11;
        this.f50204c = f12;
        this.f50205d = f13;
        this.f50206e = bitmap;
        this.f50207f = bitmap2;
    }

    public static Runnable a(TXCGPULookupFilterGroup tXCGPULookupFilterGroup, float f11, float f12, float f13, Bitmap bitmap, Bitmap bitmap2) {
        return new d(tXCGPULookupFilterGroup, f11, f12, f13, bitmap, bitmap2);
    }

    public final void run() {
        TXCGPULookupFilterGroup.lambda$setBitmap$0(this.f50202a, this.f50203b, this.f50204c, this.f50205d, this.f50206e, this.f50207f);
    }
}
