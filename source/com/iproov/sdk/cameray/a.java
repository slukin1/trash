package com.iproov.sdk.cameray;

import android.hardware.Camera;

public final /* synthetic */ class a implements Camera.PictureCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Cdo f38734a;

    public /* synthetic */ a(Cdo doVar) {
        this.f38734a = doVar;
    }

    public final void onPictureTaken(byte[] bArr, Camera camera) {
        this.f38734a.m101do(bArr, camera);
    }
}
