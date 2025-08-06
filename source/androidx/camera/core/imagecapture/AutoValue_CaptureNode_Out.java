package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.processing.Edge;
import java.util.Objects;

final class AutoValue_CaptureNode_Out extends CaptureNode.Out {
    private final Edge<ImageProxy> imageEdge;
    private final int inputFormat;
    private final int outputFormat;
    private final Edge<ProcessingRequest> requestEdge;

    public AutoValue_CaptureNode_Out(Edge<ImageProxy> edge, Edge<ProcessingRequest> edge2, int i11, int i12) {
        Objects.requireNonNull(edge, "Null imageEdge");
        this.imageEdge = edge;
        Objects.requireNonNull(edge2, "Null requestEdge");
        this.requestEdge = edge2;
        this.inputFormat = i11;
        this.outputFormat = i12;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CaptureNode.Out)) {
            return false;
        }
        CaptureNode.Out out = (CaptureNode.Out) obj;
        if (!this.imageEdge.equals(out.getImageEdge()) || !this.requestEdge.equals(out.getRequestEdge()) || this.inputFormat != out.getInputFormat() || this.outputFormat != out.getOutputFormat()) {
            return false;
        }
        return true;
    }

    public Edge<ImageProxy> getImageEdge() {
        return this.imageEdge;
    }

    public int getInputFormat() {
        return this.inputFormat;
    }

    public int getOutputFormat() {
        return this.outputFormat;
    }

    public Edge<ProcessingRequest> getRequestEdge() {
        return this.requestEdge;
    }

    public int hashCode() {
        return ((((((this.imageEdge.hashCode() ^ 1000003) * 1000003) ^ this.requestEdge.hashCode()) * 1000003) ^ this.inputFormat) * 1000003) ^ this.outputFormat;
    }

    public String toString() {
        return "Out{imageEdge=" + this.imageEdge + ", requestEdge=" + this.requestEdge + ", inputFormat=" + this.inputFormat + ", outputFormat=" + this.outputFormat + "}";
    }
}
