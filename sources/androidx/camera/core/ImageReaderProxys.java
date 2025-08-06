package androidx.camera.core;

import android.media.ImageReader;
import androidx.camera.core.impl.ImageReaderProxy;

public final class ImageReaderProxys {
    private ImageReaderProxys() {
    }

    public static ImageReaderProxy createIsolatedReader(int i11, int i12, int i13, int i14) {
        return new AndroidImageReaderProxy(ImageReader.newInstance(i11, i12, i13, i14));
    }
}
