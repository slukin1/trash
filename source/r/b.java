package r;

import androidx.camera.camera2.internal.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailWithAutoFlashQuirk;
import androidx.camera.core.impl.Quirks;
import q.d;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f16417a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f16418b;

    public b(Quirks quirks) {
        this.f16417a = quirks.contains(ImageCaptureFailWithAutoFlashQuirk.class);
        this.f16418b = d.a(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class) != null;
    }

    public int a(int i11) {
        if ((this.f16417a || this.f16418b) && i11 == 2) {
            return 1;
        }
        return i11;
    }
}
