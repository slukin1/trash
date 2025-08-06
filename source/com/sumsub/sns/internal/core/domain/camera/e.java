package com.sumsub.sns.internal.core.domain.camera;

import androidx.camera.video.v1;
import androidx.core.util.Consumer;
import java.io.File;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraX f33568b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f33569c;

    public /* synthetic */ e(CameraX cameraX, File file) {
        this.f33568b = cameraX;
        this.f33569c = file;
    }

    public final void accept(Object obj) {
        CameraX.a(this.f33568b, this.f33569c, (v1) obj);
    }
}
