package com.jumio.commons.camera;

import com.jumio.commons.enums.ScreenAngle;
import com.jumio.commons.log.Log;
import com.jumio.core.util.FileData;
import org.json.JSONObject;

public class ImageData extends FileData {
    private CameraPosition cameraPosition;
    private Size imageSize = new Size(0, 0);
    private boolean isFlashMode;
    private ScreenAngle orientationMode;
    private Size size = new Size(0, 0);

    public enum CameraPosition {
        FRONT,
        BACK
    }

    public static /* synthetic */ JSONObject getUploadMetadata$default(ImageData imageData, Integer num, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                num = null;
            }
            return imageData.getUploadMetadata(num);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUploadMetadata");
    }

    public void clear() {
        try {
            super.clear();
            this.size.setWidth(0);
            this.size.setHeight(0);
        } catch (Exception e11) {
            Log.printStackTrace(e11);
        }
    }

    public final CameraPosition getCameraPosition() {
        return this.cameraPosition;
    }

    public final Size getImageSize() {
        return this.imageSize;
    }

    public final ScreenAngle getOrientationMode() {
        return this.orientationMode;
    }

    public final Size getSize() {
        return this.size;
    }

    public JSONObject getUploadMetadata(Integer num) {
        return null;
    }

    public final boolean isFlashMode() {
        return this.isFlashMode;
    }

    public final void setCameraPosition(CameraPosition cameraPosition2) {
        this.cameraPosition = cameraPosition2;
    }

    public final void setFlashMode(boolean z11) {
        this.isFlashMode = z11;
    }

    public final void setOrientationMode(ScreenAngle screenAngle) {
        this.orientationMode = screenAngle;
    }
}
