package o;

import android.hardware.camera2.CameraManager;

public class e {
    public static void a(CameraManager.AvailabilityCallback availabilityCallback) {
        availabilityCallback.onCameraAccessPrioritiesChanged();
    }
}
