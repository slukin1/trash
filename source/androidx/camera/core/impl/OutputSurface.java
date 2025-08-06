package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class OutputSurface {
    public static OutputSurface create(Surface surface, Size size, int i11) {
        return new AutoValue_OutputSurface(surface, size, i11);
    }

    public abstract int getImageFormat();

    public abstract Size getSize();

    public abstract Surface getSurface();
}
