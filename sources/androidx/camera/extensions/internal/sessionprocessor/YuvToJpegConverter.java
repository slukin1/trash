package androidx.camera.extensions.internal.sessionprocessor;

import android.view.Surface;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.core.util.h;

public class YuvToJpegConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Surface f5768a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f5769b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f5770c = 0;

    public static class ConversionFailedException extends Exception {
        public ConversionFailedException(String str) {
            super(str);
        }

        public ConversionFailedException(String str, Throwable th2) {
            super(str, th2);
        }
    }

    public YuvToJpegConverter(int i11, Surface surface) {
        this.f5769b = i11;
        this.f5768a = surface;
    }

    public void a(int i11) {
        this.f5769b = i11;
    }

    public void b(int i11) {
        this.f5770c = i11;
    }

    public void c(ImageProxy imageProxy) throws ConversionFailedException {
        h.j(imageProxy.getFormat() == 35, "Input image is not expected YUV_420_888 image format");
        try {
            if (ImageProcessingUtil.convertYuvToJpegBytesIntoSurface(imageProxy, this.f5769b, this.f5770c, this.f5768a)) {
                imageProxy.close();
                return;
            }
            throw new ConversionFailedException("Failed to process YUV -> JPEG");
        } catch (Exception e11) {
            Logger.e("YuvToJpegConverter", "Failed to process YUV -> JPEG", e11);
            throw new ConversionFailedException("Failed to process YUV -> JPEG", e11);
        } catch (Throwable th2) {
            imageProxy.close();
            throw th2;
        }
    }
}
