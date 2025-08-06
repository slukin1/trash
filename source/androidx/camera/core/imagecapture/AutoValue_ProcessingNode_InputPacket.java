package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.ProcessingNode;
import java.util.Objects;

final class AutoValue_ProcessingNode_InputPacket extends ProcessingNode.InputPacket {
    private final ImageProxy imageProxy;
    private final ProcessingRequest processingRequest;

    public AutoValue_ProcessingNode_InputPacket(ProcessingRequest processingRequest2, ImageProxy imageProxy2) {
        Objects.requireNonNull(processingRequest2, "Null processingRequest");
        this.processingRequest = processingRequest2;
        Objects.requireNonNull(imageProxy2, "Null imageProxy");
        this.imageProxy = imageProxy2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProcessingNode.InputPacket)) {
            return false;
        }
        ProcessingNode.InputPacket inputPacket = (ProcessingNode.InputPacket) obj;
        if (!this.processingRequest.equals(inputPacket.getProcessingRequest()) || !this.imageProxy.equals(inputPacket.getImageProxy())) {
            return false;
        }
        return true;
    }

    public ImageProxy getImageProxy() {
        return this.imageProxy;
    }

    public ProcessingRequest getProcessingRequest() {
        return this.processingRequest;
    }

    public int hashCode() {
        return ((this.processingRequest.hashCode() ^ 1000003) * 1000003) ^ this.imageProxy.hashCode();
    }

    public String toString() {
        return "InputPacket{processingRequest=" + this.processingRequest + ", imageProxy=" + this.imageProxy + "}";
    }
}
