package r;

import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.impl.Quirks;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Range<Integer> f16416a;

    public a(Quirks quirks) {
        q.a aVar = (q.a) quirks.get(q.a.class);
        if (aVar == null) {
            this.f16416a = null;
        } else {
            this.f16416a = aVar.d();
        }
    }

    public void a(Camera2ImplConfig.Builder builder) {
        Range<Integer> range = this.f16416a;
        if (range != null) {
            builder.c(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
        }
    }
}
