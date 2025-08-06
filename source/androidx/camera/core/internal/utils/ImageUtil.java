package androidx.camera.core.internal.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifOutputStream;
import androidx.core.util.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ImageUtil {
    public static final int DEFAULT_RGBA_PIXEL_STRIDE = 4;
    private static final String TAG = "ImageUtil";

    private ImageUtil() {
    }

    public static Rect computeCropRectFromAspectRatio(Size size, Rational rational) {
        int i11;
        if (!isAspectRatioValid(rational)) {
            Logger.w(TAG, "Invalid view ratio.");
            return null;
        }
        int width = size.getWidth();
        int height = size.getHeight();
        float f11 = (float) width;
        float f12 = (float) height;
        int numerator = rational.getNumerator();
        int denominator = rational.getDenominator();
        int i12 = 0;
        if (rational.floatValue() > f11 / f12) {
            int round = Math.round((f11 / ((float) numerator)) * ((float) denominator));
            int i13 = round;
            i11 = (height - round) / 2;
            height = i13;
        } else {
            int round2 = Math.round((f12 / ((float) denominator)) * ((float) numerator));
            int i14 = (width - round2) / 2;
            width = round2;
            i11 = 0;
            i12 = i14;
        }
        return new Rect(i12, i11, width + i12, height + i11);
    }

    public static Rect computeCropRectFromDispatchInfo(Rect rect, int i11, Size size, int i12) {
        Matrix matrix = new Matrix();
        matrix.setRotate((float) (i12 - i11));
        float[] sizeToVertexes = sizeToVertexes(size);
        matrix.mapPoints(sizeToVertexes);
        matrix.postTranslate(-min(sizeToVertexes[0], sizeToVertexes[2], sizeToVertexes[4], sizeToVertexes[6]), -min(sizeToVertexes[1], sizeToVertexes[3], sizeToVertexes[5], sizeToVertexes[7]));
        matrix.invert(matrix);
        RectF rectF = new RectF();
        matrix.mapRect(rectF, new RectF(rect));
        rectF.sort();
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    public static Bitmap createBitmapFromImageProxy(ImageProxy imageProxy) {
        int format = imageProxy.getFormat();
        if (format == 1) {
            return createBitmapFromRgbaImage(imageProxy);
        }
        if (format == 35) {
            return ImageProcessingUtil.convertYUVToBitmap(imageProxy);
        }
        if (format == 256) {
            return createBitmapFromJpegImage(imageProxy);
        }
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + imageProxy.getFormat() + ", only ImageFormat.YUV_420_888 and PixelFormat.RGBA_8888 are supported");
    }

    private static Bitmap createBitmapFromJpegImage(ImageProxy imageProxy) {
        byte[] jpegImageToJpegByteArray = jpegImageToJpegByteArray(imageProxy);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(jpegImageToJpegByteArray, 0, jpegImageToJpegByteArray.length, (BitmapFactory.Options) null);
        if (decodeByteArray != null) {
            return decodeByteArray;
        }
        throw new UnsupportedOperationException("Decode jpeg byte array failed");
    }

    public static Bitmap createBitmapFromPlane(ImageProxy.PlaneProxy[] planeProxyArr, int i11, int i12) {
        boolean z11 = true;
        h.b(planeProxyArr.length == 1, "Expect a single plane");
        h.b(planeProxyArr[0].getPixelStride() == 4, "Expect pixelStride=4");
        if (planeProxyArr[0].getRowStride() != i11 * 4) {
            z11 = false;
        }
        h.b(z11, "Expect rowStride=width*4");
        Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
        planeProxyArr[0].getBuffer().rewind();
        ImageProcessingUtil.copyByteBufferToBitmap(createBitmap, planeProxyArr[0].getBuffer(), planeProxyArr[0].getRowStride());
        return createBitmap;
    }

    private static Bitmap createBitmapFromRgbaImage(ImageProxy imageProxy) {
        Bitmap createBitmap = Bitmap.createBitmap(imageProxy.getWidth(), imageProxy.getHeight(), Bitmap.Config.ARGB_8888);
        imageProxy.getPlanes()[0].getBuffer().rewind();
        ImageProcessingUtil.copyByteBufferToBitmap(createBitmap, imageProxy.getPlanes()[0].getBuffer(), imageProxy.getPlanes()[0].getRowStride());
        return createBitmap;
    }

    public static ByteBuffer createDirectByteBuffer(Bitmap bitmap) {
        h.b(bitmap.getConfig() == Bitmap.Config.ARGB_8888, "Only accept Bitmap with ARGB_8888 format for now.");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bitmap.getAllocationByteCount());
        ImageProcessingUtil.copyBitmapToByteBuffer(bitmap, allocateDirect, bitmap.getRowBytes());
        allocateDirect.rewind();
        return allocateDirect;
    }

    private static byte[] cropJpegByteArray(byte[] bArr, Rect rect, int i11) throws CodecFailedException {
        try {
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false);
            Bitmap decodeRegion = newInstance.decodeRegion(rect, new BitmapFactory.Options());
            newInstance.recycle();
            if (decodeRegion != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (decodeRegion.compress(Bitmap.CompressFormat.JPEG, i11, byteArrayOutputStream)) {
                    decodeRegion.recycle();
                    return byteArrayOutputStream.toByteArray();
                }
                throw new CodecFailedException("Encode bitmap failed.", CodecFailedException.FailureType.ENCODE_FAILED);
            }
            throw new CodecFailedException("Decode byte array failed.", CodecFailedException.FailureType.DECODE_FAILED);
        } catch (IllegalArgumentException e11) {
            throw new CodecFailedException("Decode byte array failed with illegal argument." + e11, CodecFailedException.FailureType.DECODE_FAILED);
        } catch (IOException unused) {
            throw new CodecFailedException("Decode byte array failed.", CodecFailedException.FailureType.DECODE_FAILED);
        }
    }

    public static Rational getRotatedAspectRatio(int i11, Rational rational) {
        if (i11 == 90 || i11 == 270) {
            return inverseRational(rational);
        }
        return new Rational(rational.getNumerator(), rational.getDenominator());
    }

    private static Rational inverseRational(Rational rational) {
        if (rational == null) {
            return rational;
        }
        return new Rational(rational.getDenominator(), rational.getNumerator());
    }

    public static boolean isAspectRatioValid(Rational rational) {
        return rational != null && rational.floatValue() > 0.0f && !rational.isNaN();
    }

    private static boolean isCropAspectRatioHasEffect(Size size, Rational rational) {
        int width = size.getWidth();
        int height = size.getHeight();
        float numerator = (float) rational.getNumerator();
        float denominator = (float) rational.getDenominator();
        return (height == Math.round((((float) width) / numerator) * denominator) && width == Math.round((((float) height) / denominator) * numerator)) ? false : true;
    }

    public static byte[] jpegImageToJpegByteArray(ImageProxy imageProxy) {
        if (imageProxy.getFormat() == 256) {
            ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
            byte[] bArr = new byte[buffer.capacity()];
            buffer.rewind();
            buffer.get(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + imageProxy.getFormat());
    }

    public static float min(float f11, float f12, float f13, float f14) {
        return Math.min(Math.min(f11, f12), Math.min(f13, f14));
    }

    public static boolean shouldCropImage(int i11, int i12, int i13, int i14) {
        return (i11 == i13 && i12 == i14) ? false : true;
    }

    public static boolean shouldCropImage(ImageProxy imageProxy) {
        return shouldCropImage(imageProxy.getWidth(), imageProxy.getHeight(), imageProxy.getCropRect().width(), imageProxy.getCropRect().height());
    }

    public static float[] sizeToVertexes(Size size) {
        return new float[]{0.0f, 0.0f, (float) size.getWidth(), 0.0f, (float) size.getWidth(), (float) size.getHeight(), 0.0f, (float) size.getHeight()};
    }

    public static byte[] yuvImageToJpegByteArray(ImageProxy imageProxy, Rect rect, int i11, int i12) throws CodecFailedException {
        if (imageProxy.getFormat() == 35) {
            YuvImage yuvImage = new YuvImage(yuv_420_888toNv21(imageProxy), 17, imageProxy.getWidth(), imageProxy.getHeight(), (int[]) null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ExifOutputStream exifOutputStream = new ExifOutputStream(byteArrayOutputStream, ExifData.create(imageProxy, i12));
            if (rect == null) {
                rect = new Rect(0, 0, imageProxy.getWidth(), imageProxy.getHeight());
            }
            if (yuvImage.compressToJpeg(rect, i11, exifOutputStream)) {
                return byteArrayOutputStream.toByteArray();
            }
            throw new CodecFailedException("YuvImage failed to encode jpeg.", CodecFailedException.FailureType.ENCODE_FAILED);
        }
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + imageProxy.getFormat());
    }

    public static byte[] yuv_420_888toNv21(ImageProxy imageProxy) {
        ImageProxy.PlaneProxy planeProxy = imageProxy.getPlanes()[0];
        ImageProxy.PlaneProxy planeProxy2 = imageProxy.getPlanes()[1];
        ImageProxy.PlaneProxy planeProxy3 = imageProxy.getPlanes()[2];
        ByteBuffer buffer = planeProxy.getBuffer();
        ByteBuffer buffer2 = planeProxy2.getBuffer();
        ByteBuffer buffer3 = planeProxy3.getBuffer();
        buffer.rewind();
        buffer2.rewind();
        buffer3.rewind();
        int remaining = buffer.remaining();
        byte[] bArr = new byte[(((imageProxy.getWidth() * imageProxy.getHeight()) / 2) + remaining)];
        int i11 = 0;
        for (int i12 = 0; i12 < imageProxy.getHeight(); i12++) {
            buffer.get(bArr, i11, imageProxy.getWidth());
            i11 += imageProxy.getWidth();
            buffer.position(Math.min(remaining, (buffer.position() - imageProxy.getWidth()) + planeProxy.getRowStride()));
        }
        int height = imageProxy.getHeight() / 2;
        int width = imageProxy.getWidth() / 2;
        int rowStride = planeProxy3.getRowStride();
        int rowStride2 = planeProxy2.getRowStride();
        int pixelStride = planeProxy3.getPixelStride();
        int pixelStride2 = planeProxy2.getPixelStride();
        byte[] bArr2 = new byte[rowStride];
        byte[] bArr3 = new byte[rowStride2];
        for (int i13 = 0; i13 < height; i13++) {
            buffer3.get(bArr2, 0, Math.min(rowStride, buffer3.remaining()));
            buffer2.get(bArr3, 0, Math.min(rowStride2, buffer2.remaining()));
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < width; i16++) {
                int i17 = i11 + 1;
                bArr[i11] = bArr2[i14];
                i11 = i17 + 1;
                bArr[i17] = bArr3[i15];
                i14 += pixelStride;
                i15 += pixelStride2;
            }
        }
        return bArr;
    }

    public static final class CodecFailedException extends Exception {
        private final FailureType mFailureType;

        public enum FailureType {
            ENCODE_FAILED,
            DECODE_FAILED,
            UNKNOWN
        }

        public CodecFailedException(String str) {
            super(str);
            this.mFailureType = FailureType.UNKNOWN;
        }

        public FailureType getFailureType() {
            return this.mFailureType;
        }

        public CodecFailedException(String str, FailureType failureType) {
            super(str);
            this.mFailureType = failureType;
        }
    }

    public static boolean isAspectRatioValid(Size size, Rational rational) {
        return rational != null && rational.floatValue() > 0.0f && isCropAspectRatioHasEffect(size, rational) && !rational.isNaN();
    }

    public static byte[] jpegImageToJpegByteArray(ImageProxy imageProxy, Rect rect, int i11) throws CodecFailedException {
        if (imageProxy.getFormat() == 256) {
            return cropJpegByteArray(jpegImageToJpegByteArray(imageProxy), rect, i11);
        }
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + imageProxy.getFormat());
    }
}
