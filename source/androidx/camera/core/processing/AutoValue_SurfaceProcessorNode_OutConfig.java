package androidx.camera.core.processing;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.processing.SurfaceProcessorNode;
import java.util.Objects;
import java.util.UUID;

final class AutoValue_SurfaceProcessorNode_OutConfig extends SurfaceProcessorNode.OutConfig {
    private final Rect cropRect;
    private final int format;
    private final boolean mirroring;
    private final int rotationDegrees;
    private final Size size;
    private final int targets;
    private final UUID uuid;

    public AutoValue_SurfaceProcessorNode_OutConfig(UUID uuid2, int i11, int i12, Rect rect, Size size2, int i13, boolean z11) {
        Objects.requireNonNull(uuid2, "Null uuid");
        this.uuid = uuid2;
        this.targets = i11;
        this.format = i12;
        Objects.requireNonNull(rect, "Null cropRect");
        this.cropRect = rect;
        Objects.requireNonNull(size2, "Null size");
        this.size = size2;
        this.rotationDegrees = i13;
        this.mirroring = z11;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceProcessorNode.OutConfig)) {
            return false;
        }
        SurfaceProcessorNode.OutConfig outConfig = (SurfaceProcessorNode.OutConfig) obj;
        if (this.uuid.equals(outConfig.getUuid()) && this.targets == outConfig.getTargets() && this.format == outConfig.getFormat() && this.cropRect.equals(outConfig.getCropRect()) && this.size.equals(outConfig.getSize()) && this.rotationDegrees == outConfig.getRotationDegrees() && this.mirroring == outConfig.getMirroring()) {
            return true;
        }
        return false;
    }

    public Rect getCropRect() {
        return this.cropRect;
    }

    public int getFormat() {
        return this.format;
    }

    public boolean getMirroring() {
        return this.mirroring;
    }

    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public Size getSize() {
        return this.size;
    }

    public int getTargets() {
        return this.targets;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return ((((((((((((this.uuid.hashCode() ^ 1000003) * 1000003) ^ this.targets) * 1000003) ^ this.format) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.size.hashCode()) * 1000003) ^ this.rotationDegrees) * 1000003) ^ (this.mirroring ? 1231 : 1237);
    }

    public String toString() {
        return "OutConfig{uuid=" + this.uuid + ", targets=" + this.targets + ", format=" + this.format + ", cropRect=" + this.cropRect + ", size=" + this.size + ", rotationDegrees=" + this.rotationDegrees + ", mirroring=" + this.mirroring + "}";
    }
}
