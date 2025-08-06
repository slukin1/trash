package androidx.camera.core.impl;

import androidx.camera.core.impl.UseCaseAttachState;

public final /* synthetic */ class l0 implements UseCaseAttachState.AttachStateFilter {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ l0 f5572a = new l0();

    public final boolean filter(UseCaseAttachState.UseCaseAttachInfo useCaseAttachInfo) {
        return useCaseAttachInfo.getAttached();
    }
}
