package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.CameraInfo;

public interface CameraConfigProvider {
    public static final CameraConfigProvider EMPTY = c.f5556a;

    CameraConfig getConfig(CameraInfo cameraInfo, Context context);
}
