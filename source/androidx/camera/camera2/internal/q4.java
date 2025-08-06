package androidx.camera.camera2.internal;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.internal.utils.RingBuffer;

public final /* synthetic */ class q4 implements RingBuffer.OnRemoveCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ q4 f5284a = new q4();

    public final void onRemove(Object obj) {
        ((ImageProxy) obj).close();
    }
}
