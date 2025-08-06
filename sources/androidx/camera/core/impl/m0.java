package androidx.camera.core.impl;

import androidx.camera.core.impl.UseCaseAttachState;

public final /* synthetic */ class m0 implements UseCaseAttachState.AttachStateFilter {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ m0 f5574a = new m0();

    public final boolean filter(UseCaseAttachState.UseCaseAttachInfo useCaseAttachInfo) {
        return useCaseAttachInfo.getAttached();
    }
}
