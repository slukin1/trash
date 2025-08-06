package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.io.IOException;
import java.util.Objects;

final class JpegBytes2CroppedBitmap implements Operation<Packet<byte[]>, Packet<Bitmap>> {
    private Bitmap createCroppedBitmap(byte[] bArr, Rect rect) throws ImageCaptureException {
        try {
            return BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false).decodeRegion(rect, new BitmapFactory.Options());
        } catch (IOException e11) {
            throw new ImageCaptureException(1, "Failed to decode JPEG.", e11);
        }
    }

    public Packet<Bitmap> apply(Packet<byte[]> packet) throws ImageCaptureException {
        Rect cropRect = packet.getCropRect();
        Bitmap createCroppedBitmap = createCroppedBitmap(packet.getData(), cropRect);
        Exif exif = packet.getExif();
        Objects.requireNonNull(exif);
        return Packet.of(createCroppedBitmap, exif, new Rect(0, 0, createCroppedBitmap.getWidth(), createCroppedBitmap.getHeight()), packet.getRotationDegrees(), TransformUtils.updateSensorToBufferTransform(packet.getSensorToBufferTransform(), cropRect), packet.getCameraCaptureResult());
    }
}
