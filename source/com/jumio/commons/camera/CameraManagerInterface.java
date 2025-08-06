package com.jumio.commons.camera;

import android.content.Context;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.core.views.CameraScanView;
import com.jumio.jvision.jvcorejava.swig.ImageFormat;
import com.jumio.sdk.enums.JumioCameraFacing;

public interface CameraManagerInterface {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f38958a = Companion.f38959a;

    public static final class Companion {
        public static final int IMAGE_FORMAT = 17;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f38959a = new Companion();

        /* renamed from: b  reason: collision with root package name */
        public static final IllegalArgumentException f38960b = new IllegalArgumentException("Image format 17 is not implemented");

        public final IllegalArgumentException getIMAGE_FORMAT_EXCEPTION() {
            return f38960b;
        }

        public final ImageFormat getJVisionImageFormat() {
            return ImageFormat.YUVNV21;
        }
    }

    void changeCamera();

    void destroy();

    void fillImageData(ImageData imageData);

    boolean getFocusing();

    boolean getHasMultipleCameras();

    boolean isFlashOn();

    boolean isFlashSupported();

    boolean isFrontFacing();

    boolean isPausePreview();

    void reinitCamera();

    void setCameraFacing(JumioCameraFacing jumioCameraFacing);

    void setEnableFlashOnStart(boolean z11);

    void setFlash(boolean z11);

    void setRequestedSize(Size size);

    void setRotationManager(DeviceRotationManager deviceRotationManager);

    void setup(Context context, CameraScanView cameraScanView, CameraCallbackInterface cameraCallbackInterface);

    void startPreview();

    void stopPreview(boolean z11);
}
