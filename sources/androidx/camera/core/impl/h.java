package androidx.camera.core.impl;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.e;
import java.util.List;

public final /* synthetic */ class h implements CameraFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CameraInfoInternal f5567a;

    public /* synthetic */ h(CameraInfoInternal cameraInfoInternal) {
        this.f5567a = cameraInfoInternal;
    }

    public final List filter(List list) {
        return i.c(this.f5567a, list);
    }

    public /* synthetic */ Identifier getIdentifier() {
        return e.a(this);
    }
}
