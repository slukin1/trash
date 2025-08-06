package com.iproov.sdk.cameray;

import android.hardware.Camera;
import com.iproov.sdk.cameray.Ctry;

public final /* synthetic */ class b implements Camera.PreviewCallback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Cdo f38735b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ctry.Cdo f38736c;

    public /* synthetic */ b(Cdo doVar, Ctry.Cdo doVar2) {
        this.f38735b = doVar;
        this.f38736c = doVar2;
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        this.f38735b.m100do(this.f38736c, bArr, camera);
    }
}
