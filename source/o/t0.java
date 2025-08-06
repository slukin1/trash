package o;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import o.r0;

public class t0 implements r0.a {

    /* renamed from: a  reason: collision with root package name */
    public final StreamConfigurationMap f16211a;

    public static class a {
        public static Size[] a(StreamConfigurationMap streamConfigurationMap, int i11) {
            return streamConfigurationMap.getHighResolutionOutputSizes(i11);
        }
    }

    public t0(StreamConfigurationMap streamConfigurationMap) {
        this.f16211a = streamConfigurationMap;
    }

    public StreamConfigurationMap a() {
        return this.f16211a;
    }

    public Size[] b(int i11) {
        if (i11 == 34) {
            return this.f16211a.getOutputSizes(SurfaceTexture.class);
        }
        return this.f16211a.getOutputSizes(i11);
    }

    public Size[] c(int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.a(this.f16211a, i11);
        }
        return null;
    }
}
