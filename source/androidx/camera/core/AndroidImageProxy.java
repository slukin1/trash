package androidx.camera.core;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.TagBundle;
import java.nio.ByteBuffer;

final class AndroidImageProxy implements ImageProxy {
    private final Image mImage;
    private final ImageInfo mImageInfo;
    private final PlaneProxy[] mPlanes;

    public static final class PlaneProxy implements ImageProxy.PlaneProxy {
        private final Image.Plane mPlane;

        public PlaneProxy(Image.Plane plane) {
            this.mPlane = plane;
        }

        public ByteBuffer getBuffer() {
            return this.mPlane.getBuffer();
        }

        public int getPixelStride() {
            return this.mPlane.getPixelStride();
        }

        public int getRowStride() {
            return this.mPlane.getRowStride();
        }
    }

    public AndroidImageProxy(Image image) {
        this.mImage = image;
        Image.Plane[] planes = image.getPlanes();
        if (planes != null) {
            this.mPlanes = new PlaneProxy[planes.length];
            for (int i11 = 0; i11 < planes.length; i11++) {
                this.mPlanes[i11] = new PlaneProxy(planes[i11]);
            }
        } else {
            this.mPlanes = new PlaneProxy[0];
        }
        this.mImageInfo = ImmutableImageInfo.create(TagBundle.emptyBundle(), image.getTimestamp(), 0, new Matrix());
    }

    public void close() {
        this.mImage.close();
    }

    public Rect getCropRect() {
        return this.mImage.getCropRect();
    }

    public int getFormat() {
        return this.mImage.getFormat();
    }

    public int getHeight() {
        return this.mImage.getHeight();
    }

    @ExperimentalGetImage
    public Image getImage() {
        return this.mImage;
    }

    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    public ImageProxy.PlaneProxy[] getPlanes() {
        return this.mPlanes;
    }

    public int getWidth() {
        return this.mImage.getWidth();
    }

    public void setCropRect(Rect rect) {
        this.mImage.setCropRect(rect);
    }

    public /* synthetic */ Bitmap toBitmap() {
        return e0.a(this);
    }
}
