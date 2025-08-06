package androidx.camera.core.internal.compat.workaround;

import androidx.camera.core.impl.SessionConfig;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceSorter f5602b;

    public /* synthetic */ a(SurfaceSorter surfaceSorter) {
        this.f5602b = surfaceSorter;
    }

    public final int compare(Object obj, Object obj2) {
        return this.f5602b.lambda$sort$0((SessionConfig.OutputConfig) obj, (SessionConfig.OutputConfig) obj2);
    }
}
