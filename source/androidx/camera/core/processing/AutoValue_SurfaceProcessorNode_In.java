package androidx.camera.core.processing;

import androidx.camera.core.processing.SurfaceProcessorNode;
import java.util.List;
import java.util.Objects;

final class AutoValue_SurfaceProcessorNode_In extends SurfaceProcessorNode.In {
    private final List<SurfaceProcessorNode.OutConfig> outConfigs;
    private final SurfaceEdge surfaceEdge;

    public AutoValue_SurfaceProcessorNode_In(SurfaceEdge surfaceEdge2, List<SurfaceProcessorNode.OutConfig> list) {
        Objects.requireNonNull(surfaceEdge2, "Null surfaceEdge");
        this.surfaceEdge = surfaceEdge2;
        Objects.requireNonNull(list, "Null outConfigs");
        this.outConfigs = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceProcessorNode.In)) {
            return false;
        }
        SurfaceProcessorNode.In in2 = (SurfaceProcessorNode.In) obj;
        if (!this.surfaceEdge.equals(in2.getSurfaceEdge()) || !this.outConfigs.equals(in2.getOutConfigs())) {
            return false;
        }
        return true;
    }

    public List<SurfaceProcessorNode.OutConfig> getOutConfigs() {
        return this.outConfigs;
    }

    public SurfaceEdge getSurfaceEdge() {
        return this.surfaceEdge;
    }

    public int hashCode() {
        return ((this.surfaceEdge.hashCode() ^ 1000003) * 1000003) ^ this.outConfigs.hashCode();
    }

    public String toString() {
        return "In{surfaceEdge=" + this.surfaceEdge + ", outConfigs=" + this.outConfigs + "}";
    }
}
