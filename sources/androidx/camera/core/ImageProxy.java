package androidx.camera.core;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.Image;
import java.nio.ByteBuffer;

public interface ImageProxy extends AutoCloseable {

    public interface PlaneProxy {
        ByteBuffer getBuffer();

        int getPixelStride();

        int getRowStride();
    }

    void close();

    Rect getCropRect();

    int getFormat();

    int getHeight();

    @ExperimentalGetImage
    Image getImage();

    ImageInfo getImageInfo();

    @SuppressLint({"ArrayReturn"})
    PlaneProxy[] getPlanes();

    int getWidth();

    void setCropRect(Rect rect);

    Bitmap toBitmap();
}
