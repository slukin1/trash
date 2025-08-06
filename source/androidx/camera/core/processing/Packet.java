package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.core.util.h;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Packet<T> {
    public static Packet<Bitmap> of(Bitmap bitmap, Exif exif, Rect rect, int i11, Matrix matrix, CameraCaptureResult cameraCaptureResult) {
        return new AutoValue_Packet(bitmap, exif, 42, new Size(bitmap.getWidth(), bitmap.getHeight()), rect, i11, matrix, cameraCaptureResult);
    }

    public abstract CameraCaptureResult getCameraCaptureResult();

    public abstract Rect getCropRect();

    public abstract T getData();

    public abstract Exif getExif();

    public abstract int getFormat();

    public abstract int getRotationDegrees();

    public abstract Matrix getSensorToBufferTransform();

    public abstract Size getSize();

    public boolean hasCropping() {
        return TransformUtils.hasCropping(getCropRect(), getSize());
    }

    public static Packet<ImageProxy> of(ImageProxy imageProxy, Exif exif, Rect rect, int i11, Matrix matrix, CameraCaptureResult cameraCaptureResult) {
        return of(imageProxy, exif, new Size(imageProxy.getWidth(), imageProxy.getHeight()), rect, i11, matrix, cameraCaptureResult);
    }

    public static Packet<ImageProxy> of(ImageProxy imageProxy, Exif exif, Size size, Rect rect, int i11, Matrix matrix, CameraCaptureResult cameraCaptureResult) {
        if (imageProxy.getFormat() == 256) {
            Exif exif2 = exif;
            h.h(exif, "JPEG image must have Exif.");
        } else {
            Exif exif3 = exif;
        }
        return new AutoValue_Packet(imageProxy, exif, imageProxy.getFormat(), size, rect, i11, matrix, cameraCaptureResult);
    }

    public static Packet<byte[]> of(byte[] bArr, Exif exif, int i11, Size size, Rect rect, int i12, Matrix matrix, CameraCaptureResult cameraCaptureResult) {
        return new AutoValue_Packet(bArr, exif, i11, size, rect, i12, matrix, cameraCaptureResult);
    }
}
