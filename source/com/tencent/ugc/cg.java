package com.tencent.ugc;

import android.graphics.Bitmap;
import com.tencent.ugc.TXVideoInfoReader;

final /* synthetic */ class cg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoInfoReader.OnSampleProgrocess f50279a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50280b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f50281c;

    public cg(TXVideoInfoReader.OnSampleProgrocess onSampleProgrocess, int i11, Bitmap bitmap) {
        this.f50279a = onSampleProgrocess;
        this.f50280b = i11;
        this.f50281c = bitmap;
    }

    public final void run() {
        this.f50279a.sampleProcess(this.f50280b, this.f50281c);
    }
}
