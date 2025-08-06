package androidx.camera.core;

public class ImageCaptureException extends Exception {
    private final int mImageCaptureError;

    public ImageCaptureException(int i11, String str, Throwable th2) {
        super(str, th2);
        this.mImageCaptureError = i11;
    }

    public int getImageCaptureError() {
        return this.mImageCaptureError;
    }
}
