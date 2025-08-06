package androidx.camera.core;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.h;
import java.nio.ByteBuffer;
import java.util.Locale;

public final class ImageProcessingUtil {
    private static final String TAG = "ImageProcessingUtil";
    private static int sImageCount;

    public enum Result {
        UNKNOWN,
        SUCCESS,
        ERROR_CONVERSION
    }

    static {
        System.loadLibrary("image_processing_util_jni");
    }

    private ImageProcessingUtil() {
    }

    public static boolean applyPixelShiftForYUV(ImageProxy imageProxy) {
        if (!isSupportedYUVFormat(imageProxy)) {
            Logger.e(TAG, "Unsupported format for YUV to RGB");
            return false;
        } else if (applyPixelShiftInternal(imageProxy) != Result.ERROR_CONVERSION) {
            return true;
        } else {
            Logger.e(TAG, "One pixel shift for YUV failure");
            return false;
        }
    }

    private static Result applyPixelShiftInternal(ImageProxy imageProxy) {
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        int rowStride = imageProxy.getPlanes()[0].getRowStride();
        int rowStride2 = imageProxy.getPlanes()[1].getRowStride();
        int rowStride3 = imageProxy.getPlanes()[2].getRowStride();
        int pixelStride = imageProxy.getPlanes()[0].getPixelStride();
        int pixelStride2 = imageProxy.getPlanes()[1].getPixelStride();
        if (nativeShiftPixel(imageProxy.getPlanes()[0].getBuffer(), rowStride, imageProxy.getPlanes()[1].getBuffer(), rowStride2, imageProxy.getPlanes()[2].getBuffer(), rowStride3, pixelStride, pixelStride2, width, height, pixelStride, pixelStride2, pixelStride2) != 0) {
            return Result.ERROR_CONVERSION;
        }
        return Result.SUCCESS;
    }

    public static ImageProxy convertJpegBytesToImage(ImageReaderProxy imageReaderProxy, byte[] bArr) {
        h.a(imageReaderProxy.getImageFormat() == 256);
        h.g(bArr);
        Surface surface = imageReaderProxy.getSurface();
        h.g(surface);
        if (nativeWriteJpegToSurface(bArr, surface) != 0) {
            Logger.e(TAG, "Failed to enqueue JPEG image.");
            return null;
        }
        ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
        if (acquireLatestImage == null) {
            Logger.e(TAG, "Failed to get acquire JPEG image.");
        }
        return acquireLatestImage;
    }

    public static Bitmap convertYUVToBitmap(ImageProxy imageProxy) {
        if (imageProxy.getFormat() == 35) {
            int width = imageProxy.getWidth();
            int height = imageProxy.getHeight();
            int rowStride = imageProxy.getPlanes()[0].getRowStride();
            int rowStride2 = imageProxy.getPlanes()[1].getRowStride();
            int rowStride3 = imageProxy.getPlanes()[2].getRowStride();
            int pixelStride = imageProxy.getPlanes()[0].getPixelStride();
            int pixelStride2 = imageProxy.getPlanes()[1].getPixelStride();
            Bitmap createBitmap = Bitmap.createBitmap(imageProxy.getWidth(), imageProxy.getHeight(), Bitmap.Config.ARGB_8888);
            int rowBytes = createBitmap.getRowBytes();
            if (nativeConvertAndroid420ToBitmap(imageProxy.getPlanes()[0].getBuffer(), rowStride, imageProxy.getPlanes()[1].getBuffer(), rowStride2, imageProxy.getPlanes()[2].getBuffer(), rowStride3, pixelStride, pixelStride2, createBitmap, rowBytes, width, height) == 0) {
                return createBitmap;
            }
            throw new UnsupportedOperationException("YUV to RGB conversion failed");
        }
        throw new IllegalArgumentException("Input image format must be YUV_420_888");
    }

    public static ImageProxy convertYUVToRGB(ImageProxy imageProxy, ImageReaderProxy imageReaderProxy, ByteBuffer byteBuffer, int i11, boolean z11) {
        if (!isSupportedYUVFormat(imageProxy)) {
            Logger.e(TAG, "Unsupported format for YUV to RGB");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!isSupportedRotationDegrees(i11)) {
            Logger.e(TAG, "Unsupported rotation degrees for rotate RGB");
            return null;
        } else if (convertYUVToRGBInternal(imageProxy, imageReaderProxy.getSurface(), byteBuffer, i11, z11) == Result.ERROR_CONVERSION) {
            Logger.e(TAG, "YUV to RGB conversion failure");
            return null;
        } else {
            if (Log.isLoggable("MH", 3)) {
                Logger.d(TAG, String.format(Locale.US, "Image processing performance profiling, duration: [%d], image count: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(sImageCount)}));
                sImageCount++;
            }
            ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (acquireLatestImage == null) {
                Logger.e(TAG, "YUV to RGB acquireLatestImage failure");
                return null;
            }
            SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy(acquireLatestImage);
            singleCloseImageProxy.addOnImageCloseListener(new d0(acquireLatestImage, imageProxy));
            return singleCloseImageProxy;
        }
    }

    private static Result convertYUVToRGBInternal(ImageProxy imageProxy, Surface surface, ByteBuffer byteBuffer, int i11, boolean z11) {
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        int rowStride = imageProxy.getPlanes()[0].getRowStride();
        int rowStride2 = imageProxy.getPlanes()[1].getRowStride();
        int rowStride3 = imageProxy.getPlanes()[2].getRowStride();
        int pixelStride = imageProxy.getPlanes()[0].getPixelStride();
        int pixelStride2 = imageProxy.getPlanes()[1].getPixelStride();
        if (nativeConvertAndroid420ToABGR(imageProxy.getPlanes()[0].getBuffer(), rowStride, imageProxy.getPlanes()[1].getBuffer(), rowStride2, imageProxy.getPlanes()[2].getBuffer(), rowStride3, pixelStride, pixelStride2, surface, byteBuffer, width, height, z11 ? pixelStride : 0, z11 ? pixelStride2 : 0, z11 ? pixelStride2 : 0, i11) != 0) {
            return Result.ERROR_CONVERSION;
        }
        return Result.SUCCESS;
    }

    public static boolean convertYuvToJpegBytesIntoSurface(ImageProxy imageProxy, int i11, int i12, Surface surface) {
        try {
            return writeJpegBytesToSurface(surface, ImageUtil.yuvImageToJpegByteArray(imageProxy, (Rect) null, i11, i12));
        } catch (ImageUtil.CodecFailedException e11) {
            Logger.e(TAG, "Failed to encode YUV to JPEG", e11);
            return false;
        }
    }

    public static void copyBitmapToByteBuffer(Bitmap bitmap, ByteBuffer byteBuffer, int i11) {
        nativeCopyBetweenByteBufferAndBitmap(bitmap, byteBuffer, bitmap.getRowBytes(), i11, bitmap.getWidth(), bitmap.getHeight(), false);
    }

    public static void copyByteBufferToBitmap(Bitmap bitmap, ByteBuffer byteBuffer, int i11) {
        nativeCopyBetweenByteBufferAndBitmap(bitmap, byteBuffer, i11, bitmap.getRowBytes(), bitmap.getWidth(), bitmap.getHeight(), true);
    }

    private static boolean isSupportedRotationDegrees(int i11) {
        return i11 == 0 || i11 == 90 || i11 == 180 || i11 == 270;
    }

    private static boolean isSupportedYUVFormat(ImageProxy imageProxy) {
        return imageProxy.getFormat() == 35 && imageProxy.getPlanes().length == 3;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$convertYUVToRGB$0(ImageProxy imageProxy, ImageProxy imageProxy2, ImageProxy imageProxy3) {
        if (imageProxy != null && imageProxy2 != null) {
            imageProxy2.close();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$rotateYUV$1(ImageProxy imageProxy, ImageProxy imageProxy2, ImageProxy imageProxy3) {
        if (imageProxy != null && imageProxy2 != null) {
            imageProxy2.close();
        }
    }

    private static native int nativeConvertAndroid420ToABGR(ByteBuffer byteBuffer, int i11, ByteBuffer byteBuffer2, int i12, ByteBuffer byteBuffer3, int i13, int i14, int i15, Surface surface, ByteBuffer byteBuffer4, int i16, int i17, int i18, int i19, int i21, int i22);

    private static native int nativeConvertAndroid420ToBitmap(ByteBuffer byteBuffer, int i11, ByteBuffer byteBuffer2, int i12, ByteBuffer byteBuffer3, int i13, int i14, int i15, Bitmap bitmap, int i16, int i17, int i18);

    private static native int nativeCopyBetweenByteBufferAndBitmap(Bitmap bitmap, ByteBuffer byteBuffer, int i11, int i12, int i13, int i14, boolean z11);

    private static native int nativeRotateYUV(ByteBuffer byteBuffer, int i11, ByteBuffer byteBuffer2, int i12, ByteBuffer byteBuffer3, int i13, int i14, ByteBuffer byteBuffer4, int i15, int i16, ByteBuffer byteBuffer5, int i17, int i18, ByteBuffer byteBuffer6, int i19, int i21, ByteBuffer byteBuffer7, ByteBuffer byteBuffer8, ByteBuffer byteBuffer9, int i22, int i23, int i24);

    private static native int nativeShiftPixel(ByteBuffer byteBuffer, int i11, ByteBuffer byteBuffer2, int i12, ByteBuffer byteBuffer3, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21);

    private static native int nativeWriteJpegToSurface(byte[] bArr, Surface surface);

    public static ImageProxy rotateYUV(ImageProxy imageProxy, ImageReaderProxy imageReaderProxy, ImageWriter imageWriter, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i11) {
        if (!isSupportedYUVFormat(imageProxy)) {
            Logger.e(TAG, "Unsupported format for rotate YUV");
            return null;
        } else if (!isSupportedRotationDegrees(i11)) {
            Logger.e(TAG, "Unsupported rotation degrees for rotate YUV");
            return null;
        } else {
            Result result = Result.ERROR_CONVERSION;
            if (((Build.VERSION.SDK_INT < 23 || i11 <= 0) ? result : rotateYUVInternal(imageProxy, imageWriter, byteBuffer, byteBuffer2, byteBuffer3, i11)) == result) {
                Logger.e(TAG, "rotate YUV failure");
                return null;
            }
            ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (acquireLatestImage == null) {
                Logger.e(TAG, "YUV rotation acquireLatestImage failure");
                return null;
            }
            SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy(acquireLatestImage);
            singleCloseImageProxy.addOnImageCloseListener(new c0(acquireLatestImage, imageProxy));
            return singleCloseImageProxy;
        }
    }

    private static Result rotateYUVInternal(ImageProxy imageProxy, ImageWriter imageWriter, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i11) {
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        int rowStride = imageProxy.getPlanes()[0].getRowStride();
        int rowStride2 = imageProxy.getPlanes()[1].getRowStride();
        int rowStride3 = imageProxy.getPlanes()[2].getRowStride();
        int pixelStride = imageProxy.getPlanes()[1].getPixelStride();
        Image dequeueInputImage = ImageWriterCompat.dequeueInputImage(imageWriter);
        if (dequeueInputImage == null) {
            return Result.ERROR_CONVERSION;
        }
        Image image = dequeueInputImage;
        Image image2 = image;
        if (nativeRotateYUV(imageProxy.getPlanes()[0].getBuffer(), rowStride, imageProxy.getPlanes()[1].getBuffer(), rowStride2, imageProxy.getPlanes()[2].getBuffer(), rowStride3, pixelStride, dequeueInputImage.getPlanes()[0].getBuffer(), dequeueInputImage.getPlanes()[0].getRowStride(), dequeueInputImage.getPlanes()[0].getPixelStride(), dequeueInputImage.getPlanes()[1].getBuffer(), dequeueInputImage.getPlanes()[1].getRowStride(), dequeueInputImage.getPlanes()[1].getPixelStride(), dequeueInputImage.getPlanes()[2].getBuffer(), dequeueInputImage.getPlanes()[2].getRowStride(), image.getPlanes()[2].getPixelStride(), byteBuffer, byteBuffer2, byteBuffer3, width, height, i11) != 0) {
            return Result.ERROR_CONVERSION;
        }
        ImageWriterCompat.queueInputImage(imageWriter, image2);
        return Result.SUCCESS;
    }

    public static boolean writeJpegBytesToSurface(Surface surface, byte[] bArr) {
        h.g(bArr);
        h.g(surface);
        if (nativeWriteJpegToSurface(bArr, surface) == 0) {
            return true;
        }
        Logger.e(TAG, "Failed to enqueue JPEG image.");
        return false;
    }
}
