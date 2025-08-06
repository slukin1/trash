package androidx.camera.core.impl;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.core.util.h;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final /* synthetic */ class i {
    public static CameraSelector a(CameraInfoInternal cameraInfoInternal) {
        return new CameraSelector.Builder().addCameraFilter(new h(cameraInfoInternal)).addCameraFilter(new LensFacingCameraFilter(cameraInfoInternal.getLensFacing())).build();
    }

    public static CameraInfoInternal b(CameraInfoInternal cameraInfoInternal) {
        return cameraInfoInternal;
    }

    public static /* synthetic */ List c(CameraInfoInternal cameraInfoInternal, List list) {
        String cameraId = cameraInfoInternal.getCameraId();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            CameraInfo cameraInfo = (CameraInfo) it2.next();
            h.a(cameraInfo instanceof CameraInfoInternal);
            if (((CameraInfoInternal) cameraInfo).getCameraId().equals(cameraId)) {
                return Collections.singletonList(cameraInfo);
            }
        }
        throw new IllegalStateException("Unable to find camera with id " + cameraId + " from list of available cameras.");
    }
}
