package com.tencent.ugc.videoprocessor;

import android.graphics.Bitmap;
import com.tencent.ugc.TXVideoEditConstants;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final WatermarkProcessor f50900a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f50901b;

    /* renamed from: c  reason: collision with root package name */
    private final TXVideoEditConstants.TXRect f50902c;

    /* renamed from: d  reason: collision with root package name */
    private final long f50903d;

    /* renamed from: e  reason: collision with root package name */
    private final int f50904e;

    private b(WatermarkProcessor watermarkProcessor, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect, long j11, int i11) {
        this.f50900a = watermarkProcessor;
        this.f50901b = bitmap;
        this.f50902c = tXRect;
        this.f50903d = j11;
        this.f50904e = i11;
    }

    public static Runnable a(WatermarkProcessor watermarkProcessor, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect, long j11, int i11) {
        return new b(watermarkProcessor, bitmap, tXRect, j11, i11);
    }

    public final void run() {
        this.f50900a.setTailWaterMarkInternal(this.f50901b, this.f50902c, this.f50903d, this.f50904e);
    }
}
