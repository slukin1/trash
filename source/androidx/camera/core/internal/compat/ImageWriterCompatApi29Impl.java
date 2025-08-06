package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.view.Surface;

final class ImageWriterCompatApi29Impl {
    private ImageWriterCompatApi29Impl() {
    }

    public static ImageWriter newInstance(Surface surface, int i11, int i12) {
        return ImageWriter.newInstance(surface, i11, i12);
    }
}
