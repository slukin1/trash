package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.Bitmap2JpegBytes;
import androidx.camera.core.imagecapture.Image2JpegBytes;
import androidx.camera.core.imagecapture.JpegBytes2Disk;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.LowMemoryQuirk;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.camera.core.processing.Node;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import androidx.core.util.h;
import com.google.auto.value.AutoValue;
import java.util.Objects;
import java.util.concurrent.Executor;

public class ProcessingNode implements Node<In, Void> {
    private Operation<Bitmap2JpegBytes.In, Packet<byte[]>> mBitmap2JpegBytes;
    private Operation<Packet<Bitmap>, Packet<Bitmap>> mBitmapEffect;
    public final Executor mBlockingExecutor;
    private Operation<Image2JpegBytes.In, Packet<byte[]>> mImage2JpegBytes;
    public final InternalImageProcessor mImageProcessor;
    private Operation<InputPacket, Packet<ImageProxy>> mInput2Packet;
    private In mInputEdge;
    private Operation<Packet<byte[]>, Packet<Bitmap>> mJpegBytes2CroppedBitmap;
    private Operation<JpegBytes2Disk.In, ImageCapture.OutputFileResults> mJpegBytes2Disk;
    private Operation<Packet<byte[]>, Packet<ImageProxy>> mJpegBytes2Image;
    private Operation<Packet<ImageProxy>, ImageProxy> mJpegImage2Result;

    @AutoValue
    public static abstract class In {
        public static In of(int i11, int i12) {
            return new AutoValue_ProcessingNode_In(new Edge(), i11, i12);
        }

        public abstract Edge<InputPacket> getEdge();

        public abstract int getInputFormat();

        public abstract int getOutputFormat();
    }

    @AutoValue
    public static abstract class InputPacket {
        public static InputPacket of(ProcessingRequest processingRequest, ImageProxy imageProxy) {
            return new AutoValue_ProcessingNode_InputPacket(processingRequest, imageProxy);
        }

        public abstract ImageProxy getImageProxy();

        public abstract ProcessingRequest getProcessingRequest();
    }

    public ProcessingNode(Executor executor) {
        this(executor, (InternalImageProcessor) null);
    }

    private Packet<byte[]> cropAndMaybeApplyEffect(Packet<byte[]> packet, int i11) throws ImageCaptureException {
        h.i(packet.getFormat() == 256);
        Packet apply = this.mJpegBytes2CroppedBitmap.apply(packet);
        Operation<Packet<Bitmap>, Packet<Bitmap>> operation = this.mBitmapEffect;
        if (operation != null) {
            apply = operation.apply(apply);
        }
        return this.mBitmap2JpegBytes.apply(Bitmap2JpegBytes.In.of(apply, i11));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$transform$1(InputPacket inputPacket) {
        if (!inputPacket.getProcessingRequest().isAborted()) {
            this.mBlockingExecutor.execute(new g(this, inputPacket));
        }
    }

    private static void sendError(ProcessingRequest processingRequest, ImageCaptureException imageCaptureException) {
        CameraXExecutors.mainThreadExecutor().execute(new i(processingRequest, imageCaptureException));
    }

    public void injectProcessingInput2Packet(Operation<InputPacket, Packet<ImageProxy>> operation) {
        this.mInput2Packet = operation;
    }

    public ImageProxy processInMemoryCapture(InputPacket inputPacket) throws ImageCaptureException {
        ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        Packet apply = this.mInput2Packet.apply(inputPacket);
        if ((apply.getFormat() == 35 || this.mBitmapEffect != null) && this.mInputEdge.getOutputFormat() == 256) {
            Packet<byte[]> apply2 = this.mImage2JpegBytes.apply(Image2JpegBytes.In.of(apply, processingRequest.getJpegQuality()));
            if (this.mBitmapEffect != null) {
                apply2 = cropAndMaybeApplyEffect(apply2, processingRequest.getJpegQuality());
            }
            apply = this.mJpegBytes2Image.apply(apply2);
        }
        return this.mJpegImage2Result.apply(apply);
    }

    /* renamed from: processInputPacket */
    public void lambda$transform$0(InputPacket inputPacket) {
        ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        try {
            if (inputPacket.getProcessingRequest().isInMemoryCapture()) {
                CameraXExecutors.mainThreadExecutor().execute(new j(processingRequest, processInMemoryCapture(inputPacket)));
                return;
            }
            CameraXExecutors.mainThreadExecutor().execute(new h(processingRequest, processOnDiskCapture(inputPacket)));
        } catch (ImageCaptureException e11) {
            sendError(processingRequest, e11);
        } catch (OutOfMemoryError e12) {
            sendError(processingRequest, new ImageCaptureException(0, "Processing failed due to low memory.", e12));
        } catch (RuntimeException e13) {
            sendError(processingRequest, new ImageCaptureException(0, "Processing failed.", e13));
        }
    }

    public ImageCapture.OutputFileResults processOnDiskCapture(InputPacket inputPacket) throws ImageCaptureException {
        h.b(this.mInputEdge.getOutputFormat() == 256, String.format("On-disk capture only support JPEG output format. Output format: %s", new Object[]{Integer.valueOf(this.mInputEdge.getOutputFormat())}));
        ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        Packet<byte[]> apply = this.mImage2JpegBytes.apply(Image2JpegBytes.In.of(this.mInput2Packet.apply(inputPacket), processingRequest.getJpegQuality()));
        if (apply.hasCropping() || this.mBitmapEffect != null) {
            apply = cropAndMaybeApplyEffect(apply, processingRequest.getJpegQuality());
        }
        Operation<JpegBytes2Disk.In, ImageCapture.OutputFileResults> operation = this.mJpegBytes2Disk;
        ImageCapture.OutputFileOptions outputFileOptions = processingRequest.getOutputFileOptions();
        Objects.requireNonNull(outputFileOptions);
        return operation.apply(JpegBytes2Disk.In.of(apply, outputFileOptions));
    }

    public void release() {
    }

    public ProcessingNode(Executor executor, InternalImageProcessor internalImageProcessor) {
        if (DeviceQuirks.get(LowMemoryQuirk.class) != null) {
            this.mBlockingExecutor = CameraXExecutors.newSequentialExecutor(executor);
        } else {
            this.mBlockingExecutor = executor;
        }
        this.mImageProcessor = internalImageProcessor;
    }

    public Void transform(In in2) {
        this.mInputEdge = in2;
        in2.getEdge().setListener(new f(this));
        this.mInput2Packet = new ProcessingInput2Packet();
        this.mImage2JpegBytes = new Image2JpegBytes();
        this.mJpegBytes2CroppedBitmap = new JpegBytes2CroppedBitmap();
        this.mBitmap2JpegBytes = new Bitmap2JpegBytes();
        this.mJpegBytes2Disk = new JpegBytes2Disk();
        this.mJpegImage2Result = new JpegImage2Result();
        if (in2.getInputFormat() == 35 || this.mImageProcessor != null) {
            this.mJpegBytes2Image = new JpegBytes2Image();
        }
        InternalImageProcessor internalImageProcessor = this.mImageProcessor;
        if (internalImageProcessor == null) {
            return null;
        }
        this.mBitmapEffect = new BitmapEffect(internalImageProcessor);
        return null;
    }
}
