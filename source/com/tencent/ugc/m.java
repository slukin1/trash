package com.tencent.ugc;

import android.graphics.Bitmap;
import com.tencent.ugc.TXVideoEditConstants;

final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50646a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50647b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f50648c;

    /* renamed from: d  reason: collision with root package name */
    private final TXVideoEditConstants.TXRect f50649d;

    private m(TXVideoEditer tXVideoEditer, int i11, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        this.f50646a = tXVideoEditer;
        this.f50647b = i11;
        this.f50648c = bitmap;
        this.f50649d = tXRect;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        return new m(tXVideoEditer, i11, bitmap, tXRect);
    }

    public final void run() {
        TXVideoEditer.lambda$setTailWaterMark$18(this.f50646a, this.f50647b, this.f50648c, this.f50649d);
    }
}
