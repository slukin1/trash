package androidx.camera.core.internal.compat;

import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;

public final class ImageWriterCompat {
    private ImageWriterCompat() {
    }

    public static void close(ImageWriter imageWriter) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            ImageWriterCompatApi23Impl.close(imageWriter);
            return;
        }
        throw new RuntimeException("Unable to call close() on API " + i11 + ". Version 23 or higher required.");
    }

    public static Image dequeueInputImage(ImageWriter imageWriter) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            return ImageWriterCompatApi23Impl.dequeueInputImage(imageWriter);
        }
        throw new RuntimeException("Unable to call dequeueInputImage() on API " + i11 + ". Version 23 or higher required.");
    }

    public static ImageWriter newInstance(Surface surface, int i11, int i12) {
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 29) {
            return ImageWriterCompatApi29Impl.newInstance(surface, i11, i12);
        }
        if (i13 >= 26) {
            return ImageWriterCompatApi26Impl.newInstance(surface, i11, i12);
        }
        throw new RuntimeException("Unable to call newInstance(Surface, int, int) on API " + i13 + ". Version 26 or higher required.");
    }

    public static void queueInputImage(ImageWriter imageWriter, Image image) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            ImageWriterCompatApi23Impl.queueInputImage(imageWriter, image);
            return;
        }
        throw new RuntimeException("Unable to call queueInputImage() on API " + i11 + ". Version 23 or higher required.");
    }

    public static ImageWriter newInstance(Surface surface, int i11) {
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 23) {
            return ImageWriterCompatApi23Impl.newInstance(surface, i11);
        }
        throw new RuntimeException("Unable to call newInstance(Surface, int) on API " + i12 + ". Version 23 or higher required.");
    }
}
