package androidx.camera.video;

import android.graphics.Rect;
import android.util.Size;
import java.util.Comparator;

public final /* synthetic */ class j1 implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Rect f6298b;

    public /* synthetic */ j1(Rect rect) {
        this.f6298b = rect;
    }

    public final int compare(Object obj, Object obj2) {
        return VideoCapture.G(this.f6298b, (Size) obj, (Size) obj2);
    }
}
