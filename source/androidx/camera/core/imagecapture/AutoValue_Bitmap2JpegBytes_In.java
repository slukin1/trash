package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.imagecapture.Bitmap2JpegBytes;
import androidx.camera.core.processing.Packet;
import java.util.Objects;

final class AutoValue_Bitmap2JpegBytes_In extends Bitmap2JpegBytes.In {
    private final int jpegQuality;
    private final Packet<Bitmap> packet;

    public AutoValue_Bitmap2JpegBytes_In(Packet<Bitmap> packet2, int i11) {
        Objects.requireNonNull(packet2, "Null packet");
        this.packet = packet2;
        this.jpegQuality = i11;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bitmap2JpegBytes.In)) {
            return false;
        }
        Bitmap2JpegBytes.In in2 = (Bitmap2JpegBytes.In) obj;
        if (!this.packet.equals(in2.getPacket()) || this.jpegQuality != in2.getJpegQuality()) {
            return false;
        }
        return true;
    }

    public int getJpegQuality() {
        return this.jpegQuality;
    }

    public Packet<Bitmap> getPacket() {
        return this.packet;
    }

    public int hashCode() {
        return ((this.packet.hashCode() ^ 1000003) * 1000003) ^ this.jpegQuality;
    }

    public String toString() {
        return "In{packet=" + this.packet + ", jpegQuality=" + this.jpegQuality + "}";
    }
}
