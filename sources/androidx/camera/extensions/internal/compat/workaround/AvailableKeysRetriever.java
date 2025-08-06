package androidx.camera.extensions.internal.compat.workaround;

import androidx.camera.extensions.internal.compat.quirk.GetAvailableKeysNeedsOnInit;
import v.a;

public class AvailableKeysRetriever {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5762a;

    public AvailableKeysRetriever() {
        this.f5762a = a.a(GetAvailableKeysNeedsOnInit.class) != null;
    }
}
