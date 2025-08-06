package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import java.util.ArrayList;
import java.util.List;

public final class s1 {

    public static final class a extends CameraDevice.StateCallback {

        /* renamed from: a  reason: collision with root package name */
        public final List<CameraDevice.StateCallback> f5311a = new ArrayList();

        public a(List<CameraDevice.StateCallback> list) {
            for (CameraDevice.StateCallback next : list) {
                if (!(next instanceof b)) {
                    this.f5311a.add(next);
                }
            }
        }

        public void onClosed(CameraDevice cameraDevice) {
            for (CameraDevice.StateCallback onClosed : this.f5311a) {
                onClosed.onClosed(cameraDevice);
            }
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            for (CameraDevice.StateCallback onDisconnected : this.f5311a) {
                onDisconnected.onDisconnected(cameraDevice);
            }
        }

        public void onError(CameraDevice cameraDevice, int i11) {
            for (CameraDevice.StateCallback onError : this.f5311a) {
                onError.onError(cameraDevice, i11);
            }
        }

        public void onOpened(CameraDevice cameraDevice) {
            for (CameraDevice.StateCallback onOpened : this.f5311a) {
                onOpened.onOpened(cameraDevice);
            }
        }
    }

    public static final class b extends CameraDevice.StateCallback {
        public void onClosed(CameraDevice cameraDevice) {
        }

        public void onDisconnected(CameraDevice cameraDevice) {
        }

        public void onError(CameraDevice cameraDevice, int i11) {
        }

        public void onOpened(CameraDevice cameraDevice) {
        }
    }

    public static CameraDevice.StateCallback a(List<CameraDevice.StateCallback> list) {
        if (list.isEmpty()) {
            return b();
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return new a(list);
    }

    public static CameraDevice.StateCallback b() {
        return new b();
    }
}
