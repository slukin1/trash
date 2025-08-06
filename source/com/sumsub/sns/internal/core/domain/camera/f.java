package com.sumsub.sns.internal.core.domain.camera;

import androidx.camera.view.PreviewView;
import androidx.lifecycle.z;

public final /* synthetic */ class f implements z {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraX f33570b;

    public /* synthetic */ f(CameraX cameraX) {
        this.f33570b = cameraX;
    }

    public final void onChanged(Object obj) {
        CameraX.a(this.f33570b, (PreviewView.StreamState) obj);
    }
}
