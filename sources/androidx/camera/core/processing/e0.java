package androidx.camera.core.processing;

import androidx.camera.core.SurfaceRequest;
import java.util.Map;

public final /* synthetic */ class e0 implements SurfaceRequest.TransformationInfoListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f5652a;

    public /* synthetic */ e0(Map map) {
        this.f5652a = map;
    }

    public final void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
        SurfaceProcessorNode.lambda$setUpRotationUpdates$1(this.f5652a, transformationInfo);
    }
}
