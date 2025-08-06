package com.sumsub.sns.internal.core.domain.camera;

import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f33571b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraX f33572c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f33573d;

    public /* synthetic */ g(ListenableFuture listenableFuture, CameraX cameraX, LifecycleOwner lifecycleOwner) {
        this.f33571b = listenableFuture;
        this.f33572c = cameraX;
        this.f33573d = lifecycleOwner;
    }

    public final void run() {
        CameraX.a(this.f33571b, this.f33572c, this.f33573d);
    }
}
