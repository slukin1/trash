package o;

import android.hardware.camera2.CameraCharacteristics;
import o.y;

public class x implements y.a {

    /* renamed from: a  reason: collision with root package name */
    public final CameraCharacteristics f16215a;

    public x(CameraCharacteristics cameraCharacteristics) {
        this.f16215a = cameraCharacteristics;
    }

    public <T> T a(CameraCharacteristics.Key<T> key) {
        return this.f16215a.get(key);
    }
}
