package androidx.camera.core.imagecapture;

import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.camera.core.streamsharing.VirtualCameraCaptureResult;
import androidx.core.util.h;
import java.util.concurrent.Executor;

public class NoMetadataImageReader implements ImageReaderProxy {
    private ProcessingRequest mPendingRequest;
    private final ImageReaderProxy mWrappedImageReader;

    public NoMetadataImageReader(ImageReaderProxy imageReaderProxy) {
        this.mWrappedImageReader = imageReaderProxy;
    }

    private ImageProxy createImageProxyWithEmptyMetadata(ImageProxy imageProxy) {
        if (imageProxy == null) {
            return null;
        }
        h.j(this.mPendingRequest != null, "Pending request should not be null");
        TagBundle create = TagBundle.create(new Pair(this.mPendingRequest.getTagBundleKey(), this.mPendingRequest.getStageIds().get(0)));
        this.mPendingRequest = null;
        return new SettableImageProxy(imageProxy, new Size(imageProxy.getWidth(), imageProxy.getHeight()), new CameraCaptureResultImageInfo(new VirtualCameraCaptureResult(create, imageProxy.getImageInfo().getTimestamp())));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnImageAvailableListener$0(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, ImageReaderProxy imageReaderProxy) {
        onImageAvailableListener.onImageAvailable(this);
    }

    public void acceptProcessingRequest(ProcessingRequest processingRequest) {
        h.j(this.mPendingRequest == null, "Pending request should be null");
        this.mPendingRequest = processingRequest;
    }

    public ImageProxy acquireLatestImage() {
        return createImageProxyWithEmptyMetadata(this.mWrappedImageReader.acquireLatestImage());
    }

    public ImageProxy acquireNextImage() {
        return createImageProxyWithEmptyMetadata(this.mWrappedImageReader.acquireNextImage());
    }

    public void clearOnImageAvailableListener() {
        this.mWrappedImageReader.clearOnImageAvailableListener();
    }

    public void close() {
        this.mWrappedImageReader.close();
    }

    public int getHeight() {
        return this.mWrappedImageReader.getHeight();
    }

    public int getImageFormat() {
        return this.mWrappedImageReader.getImageFormat();
    }

    public int getMaxImages() {
        return this.mWrappedImageReader.getMaxImages();
    }

    public Surface getSurface() {
        return this.mWrappedImageReader.getSurface();
    }

    public int getWidth() {
        return this.mWrappedImageReader.getWidth();
    }

    public void setOnImageAvailableListener(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, Executor executor) {
        this.mWrappedImageReader.setOnImageAvailableListener(new e(this, onImageAvailableListener), executor);
    }
}
