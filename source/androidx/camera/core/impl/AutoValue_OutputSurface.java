package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import java.util.Objects;

final class AutoValue_OutputSurface extends OutputSurface {
    private final int imageFormat;
    private final Size size;
    private final Surface surface;

    public AutoValue_OutputSurface(Surface surface2, Size size2, int i11) {
        Objects.requireNonNull(surface2, "Null surface");
        this.surface = surface2;
        Objects.requireNonNull(size2, "Null size");
        this.size = size2;
        this.imageFormat = i11;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OutputSurface)) {
            return false;
        }
        OutputSurface outputSurface = (OutputSurface) obj;
        if (!this.surface.equals(outputSurface.getSurface()) || !this.size.equals(outputSurface.getSize()) || this.imageFormat != outputSurface.getImageFormat()) {
            return false;
        }
        return true;
    }

    public int getImageFormat() {
        return this.imageFormat;
    }

    public Size getSize() {
        return this.size;
    }

    public Surface getSurface() {
        return this.surface;
    }

    public int hashCode() {
        return ((((this.surface.hashCode() ^ 1000003) * 1000003) ^ this.size.hashCode()) * 1000003) ^ this.imageFormat;
    }

    public String toString() {
        return "OutputSurface{surface=" + this.surface + ", size=" + this.size + ", imageFormat=" + this.imageFormat + "}";
    }
}
