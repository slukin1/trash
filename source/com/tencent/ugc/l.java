package com.tencent.ugc;

import android.graphics.Bitmap;
import com.tencent.ugc.TXVideoEditConstants;

final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50643a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoEditConstants.TXRect f50644b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f50645c;

    private l(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXRect tXRect, Bitmap bitmap) {
        this.f50643a = tXVideoEditer;
        this.f50644b = tXRect;
        this.f50645c = bitmap;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXRect tXRect, Bitmap bitmap) {
        return new l(tXVideoEditer, tXRect, bitmap);
    }

    public final void run() {
        TXVideoEditer.lambda$setWaterMark$17(this.f50643a, this.f50644b, this.f50645c);
    }
}
