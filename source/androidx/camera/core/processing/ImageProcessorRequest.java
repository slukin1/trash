package androidx.camera.core.processing;

import androidx.camera.core.ImageProcessor;
import androidx.camera.core.ImageProxy;

public class ImageProcessorRequest implements ImageProcessor.Request {
    private final ImageProxy mImageProxy;
    private final int mOutputFormat;

    public ImageProcessorRequest(ImageProxy imageProxy, int i11) {
        this.mImageProxy = imageProxy;
        this.mOutputFormat = i11;
    }

    public ImageProxy getInputImage() {
        return this.mImageProxy;
    }

    public int getOutputFormat() {
        return this.mOutputFormat;
    }
}
