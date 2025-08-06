package com.tencent.ugc.videoprocessor;

import android.graphics.Bitmap;
import com.tencent.ugc.TXVideoEditConstants;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final WatermarkProcessor f50897a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f50898b;

    /* renamed from: c  reason: collision with root package name */
    private final TXVideoEditConstants.TXRect f50899c;

    private a(WatermarkProcessor watermarkProcessor, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        this.f50897a = watermarkProcessor;
        this.f50898b = bitmap;
        this.f50899c = tXRect;
    }

    public static Runnable a(WatermarkProcessor watermarkProcessor, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        return new a(watermarkProcessor, bitmap, tXRect);
    }

    public final void run() {
        WatermarkProcessor.lambda$setWaterMark$0(this.f50897a, this.f50898b, this.f50899c);
    }
}
