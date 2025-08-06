package androidx.camera.video;

import android.util.Size;
import java.util.Comparator;

public final /* synthetic */ class w implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f6381b;

    public /* synthetic */ w(int i11) {
        this.f6381b = i11;
    }

    public final int compare(Object obj, Object obj2) {
        return x.h(this.f6381b, (Size) obj, (Size) obj2);
    }
}
