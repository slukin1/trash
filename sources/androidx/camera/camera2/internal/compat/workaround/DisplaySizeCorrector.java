package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.SmallDisplaySizeQuirk;
import q.d;

public class DisplaySizeCorrector {

    /* renamed from: a  reason: collision with root package name */
    public final SmallDisplaySizeQuirk f5066a = ((SmallDisplaySizeQuirk) d.a(SmallDisplaySizeQuirk.class));

    public Size a() {
        SmallDisplaySizeQuirk smallDisplaySizeQuirk = this.f5066a;
        if (smallDisplaySizeQuirk != null) {
            return smallDisplaySizeQuirk.c();
        }
        return null;
    }
}
