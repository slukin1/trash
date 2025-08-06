package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.ExperimentalGetImage;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.e0;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Packet;
import androidx.core.util.h;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class RgbaImageProxy implements ImageProxy {
    private final Rect mCropRect;
    private final int mHeight;
    private final ImageInfo mImageInfo;
    private final Object mLock;
    public ImageProxy.PlaneProxy[] mPlaneProxy;
    private final int mWidth;

    public RgbaImageProxy(Packet<Bitmap> packet) {
        this(packet.getData(), packet.getCropRect(), packet.getRotationDegrees(), packet.getSensorToBufferTransform(), packet.getCameraCaptureResult().getTimestamp());
    }

    private void checkNotClosed() {
        synchronized (this.mLock) {
            h.j(this.mPlaneProxy != null, "The image is closed.");
        }
    }

    private static ImageInfo createImageInfo(final long j11, final int i11, final Matrix matrix) {
        return new ImageInfo() {
            public int getRotationDegrees() {
                return i11;
            }

            public Matrix getSensorToBufferTransformMatrix() {
                return new Matrix(matrix);
            }

            public TagBundle getTagBundle() {
                throw new UnsupportedOperationException("Custom ImageProxy does not contain TagBundle");
            }

            public long getTimestamp() {
                return j11;
            }

            public void populateExifData(ExifData.Builder builder) {
                throw new UnsupportedOperationException("Custom ImageProxy does not contain Exif data.");
            }
        };
    }

    private static ImageProxy.PlaneProxy createPlaneProxy(final ByteBuffer byteBuffer, final int i11, final int i12) {
        return new ImageProxy.PlaneProxy() {
            public ByteBuffer getBuffer() {
                return byteBuffer;
            }

            public int getPixelStride() {
                return i12;
            }

            public int getRowStride() {
                return i11;
            }
        };
    }

    public void close() {
        synchronized (this.mLock) {
            checkNotClosed();
            this.mPlaneProxy = null;
        }
    }

    public Bitmap createBitmap() {
        Bitmap createBitmapFromPlane;
        synchronized (this.mLock) {
            checkNotClosed();
            createBitmapFromPlane = ImageUtil.createBitmapFromPlane(getPlanes(), getWidth(), getHeight());
        }
        return createBitmapFromPlane;
    }

    public Rect getCropRect() {
        Rect rect;
        synchronized (this.mLock) {
            checkNotClosed();
            rect = this.mCropRect;
        }
        return rect;
    }

    public int getFormat() {
        synchronized (this.mLock) {
            checkNotClosed();
        }
        return 1;
    }

    public int getHeight() {
        int i11;
        synchronized (this.mLock) {
            checkNotClosed();
            i11 = this.mHeight;
        }
        return i11;
    }

    @ExperimentalGetImage
    public Image getImage() {
        synchronized (this.mLock) {
            checkNotClosed();
        }
        return null;
    }

    public ImageInfo getImageInfo() {
        ImageInfo imageInfo;
        synchronized (this.mLock) {
            checkNotClosed();
            imageInfo = this.mImageInfo;
        }
        return imageInfo;
    }

    public ImageProxy.PlaneProxy[] getPlanes() {
        ImageProxy.PlaneProxy[] planeProxyArr;
        synchronized (this.mLock) {
            checkNotClosed();
            ImageProxy.PlaneProxy[] planeProxyArr2 = this.mPlaneProxy;
            Objects.requireNonNull(planeProxyArr2);
            planeProxyArr = planeProxyArr2;
        }
        return planeProxyArr;
    }

    public int getWidth() {
        int i11;
        synchronized (this.mLock) {
            checkNotClosed();
            i11 = this.mWidth;
        }
        return i11;
    }

    public void setCropRect(Rect rect) {
        synchronized (this.mLock) {
            checkNotClosed();
            if (rect != null) {
                this.mCropRect.set(rect);
            }
        }
    }

    public /* synthetic */ Bitmap toBitmap() {
        return e0.a(this);
    }

    public RgbaImageProxy(Bitmap bitmap, Rect rect, int i11, Matrix matrix, long j11) {
        this(ImageUtil.createDirectByteBuffer(bitmap), 4, bitmap.getWidth(), bitmap.getHeight(), rect, i11, matrix, j11);
    }

    public RgbaImageProxy(ByteBuffer byteBuffer, int i11, int i12, int i13, Rect rect, int i14, Matrix matrix, long j11) {
        this.mLock = new Object();
        this.mWidth = i12;
        this.mHeight = i13;
        this.mCropRect = rect;
        this.mImageInfo = createImageInfo(j11, i14, matrix);
        byteBuffer.rewind();
        this.mPlaneProxy = new ImageProxy.PlaneProxy[]{createPlaneProxy(byteBuffer, i12 * i11, i11)};
    }
}
