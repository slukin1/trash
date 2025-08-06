package com.iproov.sdk.p005class;

import android.media.MediaCodec;
import com.iproov.sdk.p005class.Cdo;

/* renamed from: com.iproov.sdk.class.b  reason: invalid package */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Cdo.Cif f38752b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ byte[] f38753c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaCodec.BufferInfo f38754d;

    public /* synthetic */ b(Cdo.Cif ifVar, byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
        this.f38752b = ifVar;
        this.f38753c = bArr;
        this.f38754d = bufferInfo;
    }

    public final void run() {
        this.f38752b.m268do(new Ctry(this.f38753c, this.f38754d.flags));
    }
}
