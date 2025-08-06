package o;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;
import r.i;

public class y {

    /* renamed from: a  reason: collision with root package name */
    public final Map<CameraCharacteristics.Key<?>, Object> f16216a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final a f16217b;

    /* renamed from: c  reason: collision with root package name */
    public final String f16218c;

    /* renamed from: d  reason: collision with root package name */
    public r0 f16219d = null;

    public interface a {
        <T> T a(CameraCharacteristics.Key<T> key);
    }

    public y(CameraCharacteristics cameraCharacteristics, String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f16217b = new w(cameraCharacteristics);
        } else {
            this.f16217b = new x(cameraCharacteristics);
        }
        this.f16218c = str;
    }

    public static y d(CameraCharacteristics cameraCharacteristics, String str) {
        return new y(cameraCharacteristics, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T a(android.hardware.camera2.CameraCharacteristics.Key<T> r3) {
        /*
            r2 = this;
            boolean r0 = r2.c(r3)
            if (r0 == 0) goto L_0x000d
            o.y$a r0 = r2.f16217b
            java.lang.Object r3 = r0.a(r3)
            return r3
        L_0x000d:
            monitor-enter(r2)
            java.util.Map<android.hardware.camera2.CameraCharacteristics$Key<?>, java.lang.Object> r0 = r2.f16216a     // Catch:{ all -> 0x0027 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0018
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            return r0
        L_0x0018:
            o.y$a r0 = r2.f16217b     // Catch:{ all -> 0x0027 }
            java.lang.Object r0 = r0.a(r3)     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0025
            java.util.Map<android.hardware.camera2.CameraCharacteristics$Key<?>, java.lang.Object> r1 = r2.f16216a     // Catch:{ all -> 0x0027 }
            r1.put(r3, r0)     // Catch:{ all -> 0x0027 }
        L_0x0025:
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            return r0
        L_0x0027:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: o.y.a(android.hardware.camera2.CameraCharacteristics$Key):java.lang.Object");
    }

    public r0 b() {
        if (this.f16219d == null) {
            try {
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (streamConfigurationMap != null) {
                    this.f16219d = r0.d(streamConfigurationMap, new i(this.f16218c));
                } else {
                    throw new IllegalArgumentException("StreamConfigurationMap is null!");
                }
            } catch (AssertionError e11) {
                throw new IllegalArgumentException(e11.getMessage());
            }
        }
        return this.f16219d;
    }

    public final boolean c(CameraCharacteristics.Key<?> key) {
        return key.equals(CameraCharacteristics.SENSOR_ORIENTATION);
    }
}
