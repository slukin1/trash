package androidx.camera.core.imagecapture;

import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.processing.Edge;
import java.util.Objects;

final class AutoValue_ProcessingNode_In extends ProcessingNode.In {
    private final Edge<ProcessingNode.InputPacket> edge;
    private final int inputFormat;
    private final int outputFormat;

    public AutoValue_ProcessingNode_In(Edge<ProcessingNode.InputPacket> edge2, int i11, int i12) {
        Objects.requireNonNull(edge2, "Null edge");
        this.edge = edge2;
        this.inputFormat = i11;
        this.outputFormat = i12;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProcessingNode.In)) {
            return false;
        }
        ProcessingNode.In in2 = (ProcessingNode.In) obj;
        if (this.edge.equals(in2.getEdge()) && this.inputFormat == in2.getInputFormat() && this.outputFormat == in2.getOutputFormat()) {
            return true;
        }
        return false;
    }

    public Edge<ProcessingNode.InputPacket> getEdge() {
        return this.edge;
    }

    public int getInputFormat() {
        return this.inputFormat;
    }

    public int getOutputFormat() {
        return this.outputFormat;
    }

    public int hashCode() {
        return ((((this.edge.hashCode() ^ 1000003) * 1000003) ^ this.inputFormat) * 1000003) ^ this.outputFormat;
    }

    public String toString() {
        return "In{edge=" + this.edge + ", inputFormat=" + this.inputFormat + ", outputFormat=" + this.outputFormat + "}";
    }
}
