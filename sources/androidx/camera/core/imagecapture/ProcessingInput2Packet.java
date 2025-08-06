package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import androidx.core.util.h;
import java.io.IOException;

final class ProcessingInput2Packet implements Operation<ProcessingNode.InputPacket, Packet<ImageProxy>> {
    private static Packet<ImageProxy> createPacket(ProcessingRequest processingRequest, Exif exif, ImageProxy imageProxy) {
        return Packet.of(imageProxy, exif, processingRequest.getCropRect(), processingRequest.getRotationDegrees(), processingRequest.getSensorToBufferTransform(), getCameraCaptureResult(imageProxy));
    }

    private static Packet<ImageProxy> createPacketWithHalRotation(ProcessingRequest processingRequest, Exif exif, ImageProxy imageProxy) {
        Size size = new Size(imageProxy.getWidth(), imageProxy.getHeight());
        int rotationDegrees = processingRequest.getRotationDegrees() - exif.getRotation();
        Size rotatedSize = getRotatedSize(rotationDegrees, size);
        Matrix rectToRect = TransformUtils.getRectToRect(new RectF(0.0f, 0.0f, (float) size.getWidth(), (float) size.getHeight()), new RectF(0.0f, 0.0f, (float) rotatedSize.getWidth(), (float) rotatedSize.getHeight()), rotationDegrees);
        return Packet.of(imageProxy, exif, rotatedSize, getUpdatedCropRect(processingRequest.getCropRect(), rectToRect), exif.getRotation(), getUpdatedTransform(processingRequest.getSensorToBufferTransform(), rectToRect), getCameraCaptureResult(imageProxy));
    }

    private static CameraCaptureResult getCameraCaptureResult(ImageProxy imageProxy) {
        return ((CameraCaptureResultImageInfo) imageProxy.getImageInfo()).getCameraCaptureResult();
    }

    private static Size getRotatedSize(int i11, Size size) {
        return TransformUtils.is90or270(TransformUtils.within360(i11)) ? new Size(size.getHeight(), size.getWidth()) : size;
    }

    private static Rect getUpdatedCropRect(Rect rect, Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        rectF.sort();
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    private static Matrix getUpdatedTransform(Matrix matrix, Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.postConcat(matrix2);
        return matrix3;
    }

    public Packet<ImageProxy> apply(ProcessingNode.InputPacket inputPacket) throws ImageCaptureException {
        Exif exif;
        ImageProxy imageProxy = inputPacket.getImageProxy();
        ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        if (imageProxy.getFormat() == 256) {
            try {
                exif = Exif.createFromImageProxy(imageProxy);
                imageProxy.getPlanes()[0].getBuffer().rewind();
            } catch (IOException e11) {
                throw new ImageCaptureException(1, "Failed to extract EXIF data.", e11);
            }
        } else {
            exif = null;
        }
        if (!ImagePipeline.EXIF_ROTATION_AVAILABILITY.shouldUseExifOrientation(imageProxy)) {
            return createPacket(processingRequest, exif, imageProxy);
        }
        h.h(exif, "JPEG image must have exif.");
        return createPacketWithHalRotation(processingRequest, exif, imageProxy);
    }
}
