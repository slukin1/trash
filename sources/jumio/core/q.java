package jumio.core;

import com.jumio.commons.camera.Frame;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.camera.Size;
import com.jumio.core.views.CameraScanView;
import com.jumio.sdk.enums.JumioCameraFacing;

public interface q {
    void cameraAvailable();

    void cameraError(Throwable th2);

    void feedFrame(Frame frame);

    boolean getEnableExtraction();

    Size getPreviewSize();

    boolean getShowShutterButton();

    JumioCameraFacing[] getSupportedFacing();

    boolean isBrandingEnabled();

    void isPresented(boolean z11);

    void onPreviewAvailable(PreviewProperties previewProperties);

    void setEnableExtraction(boolean z11);

    void setScanView(CameraScanView cameraScanView);

    void takePicture();
}
