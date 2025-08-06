package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.imagecapture.JpegBytes2Disk;
import androidx.camera.core.processing.Packet;
import java.util.Objects;

final class AutoValue_JpegBytes2Disk_In extends JpegBytes2Disk.In {
    private final ImageCapture.OutputFileOptions outputFileOptions;
    private final Packet<byte[]> packet;

    public AutoValue_JpegBytes2Disk_In(Packet<byte[]> packet2, ImageCapture.OutputFileOptions outputFileOptions2) {
        Objects.requireNonNull(packet2, "Null packet");
        this.packet = packet2;
        Objects.requireNonNull(outputFileOptions2, "Null outputFileOptions");
        this.outputFileOptions = outputFileOptions2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JpegBytes2Disk.In)) {
            return false;
        }
        JpegBytes2Disk.In in2 = (JpegBytes2Disk.In) obj;
        if (!this.packet.equals(in2.getPacket()) || !this.outputFileOptions.equals(in2.getOutputFileOptions())) {
            return false;
        }
        return true;
    }

    public ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.outputFileOptions;
    }

    public Packet<byte[]> getPacket() {
        return this.packet;
    }

    public int hashCode() {
        return ((this.packet.hashCode() ^ 1000003) * 1000003) ^ this.outputFileOptions.hashCode();
    }

    public String toString() {
        return "In{packet=" + this.packet + ", outputFileOptions=" + this.outputFileOptions + "}";
    }
}
