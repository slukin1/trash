package androidx.camera.core.imagecapture;

import android.util.Size;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.processing.Edge;
import java.util.Objects;

final class AutoValue_CaptureNode_In extends CaptureNode.In {
    private final Edge<ImageCaptureException> errorEdge;
    private final ImageReaderProxyProvider imageReaderProxyProvider;
    private final int inputFormat;
    private final int outputFormat;
    private final Edge<ProcessingRequest> requestEdge;
    private final Size size;
    private final boolean virtualCamera;

    public AutoValue_CaptureNode_In(Size size2, int i11, int i12, boolean z11, ImageReaderProxyProvider imageReaderProxyProvider2, Edge<ProcessingRequest> edge, Edge<ImageCaptureException> edge2) {
        Objects.requireNonNull(size2, "Null size");
        this.size = size2;
        this.inputFormat = i11;
        this.outputFormat = i12;
        this.virtualCamera = z11;
        this.imageReaderProxyProvider = imageReaderProxyProvider2;
        Objects.requireNonNull(edge, "Null requestEdge");
        this.requestEdge = edge;
        Objects.requireNonNull(edge2, "Null errorEdge");
        this.errorEdge = edge2;
    }

    public boolean equals(Object obj) {
        ImageReaderProxyProvider imageReaderProxyProvider2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CaptureNode.In)) {
            return false;
        }
        CaptureNode.In in2 = (CaptureNode.In) obj;
        if (!this.size.equals(in2.getSize()) || this.inputFormat != in2.getInputFormat() || this.outputFormat != in2.getOutputFormat() || this.virtualCamera != in2.isVirtualCamera() || ((imageReaderProxyProvider2 = this.imageReaderProxyProvider) != null ? !imageReaderProxyProvider2.equals(in2.getImageReaderProxyProvider()) : in2.getImageReaderProxyProvider() != null) || !this.requestEdge.equals(in2.getRequestEdge()) || !this.errorEdge.equals(in2.getErrorEdge())) {
            return false;
        }
        return true;
    }

    public Edge<ImageCaptureException> getErrorEdge() {
        return this.errorEdge;
    }

    public ImageReaderProxyProvider getImageReaderProxyProvider() {
        return this.imageReaderProxyProvider;
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

    public Size getSize() {
        return this.size;
    }

    public int hashCode() {
        int hashCode = (((((((this.size.hashCode() ^ 1000003) * 1000003) ^ this.inputFormat) * 1000003) ^ this.outputFormat) * 1000003) ^ (this.virtualCamera ? 1231 : 1237)) * 1000003;
        ImageReaderProxyProvider imageReaderProxyProvider2 = this.imageReaderProxyProvider;
        return ((((hashCode ^ (imageReaderProxyProvider2 == null ? 0 : imageReaderProxyProvider2.hashCode())) * 1000003) ^ this.requestEdge.hashCode()) * 1000003) ^ this.errorEdge.hashCode();
    }

    public boolean isVirtualCamera() {
        return this.virtualCamera;
    }

    public String toString() {
        return "In{size=" + this.size + ", inputFormat=" + this.inputFormat + ", outputFormat=" + this.outputFormat + ", virtualCamera=" + this.virtualCamera + ", imageReaderProxyProvider=" + this.imageReaderProxyProvider + ", requestEdge=" + this.requestEdge + ", errorEdge=" + this.errorEdge + "}";
    }
}
