package androidx.camera.camera2.internal;

import android.util.Size;
import java.util.Comparator;

public final /* synthetic */ class d3 implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ d3 f5079b = new d3();

    public final int compare(Object obj, Object obj2) {
        return Long.signum((((long) ((Size) obj).getWidth()) * ((long) ((Size) obj).getHeight())) - (((long) ((Size) obj2).getWidth()) * ((long) ((Size) obj2).getHeight())));
    }
}
