package androidx.camera.core.processing;

import androidx.camera.core.CameraEffect;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProcessor;
import androidx.camera.core.ProcessingException;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.h;
import java.util.Objects;
import java.util.concurrent.Executor;

public class InternalImageProcessor {
    private final Consumer<Throwable> mErrorListener;
    private final Executor mExecutor;
    private final ImageProcessor mImageProcessor;

    public InternalImageProcessor(CameraEffect cameraEffect) {
        h.a(cameraEffect.getTargets() == 4);
        this.mExecutor = cameraEffect.getExecutor();
        ImageProcessor imageProcessor = cameraEffect.getImageProcessor();
        Objects.requireNonNull(imageProcessor);
        this.mImageProcessor = imageProcessor;
        this.mErrorListener = cameraEffect.getErrorListener();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$safeProcess$0(ImageProcessor.Request request, CallbackToFutureAdapter.a aVar) {
        try {
            aVar.c(this.mImageProcessor.process(request));
        } catch (ProcessingException e11) {
            this.mErrorListener.accept(e11);
            aVar.f(e11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$safeProcess$1(ImageProcessor.Request request, CallbackToFutureAdapter.a aVar) throws Exception {
        this.mExecutor.execute(new q(this, request, aVar));
        return "InternalImageProcessor#process " + request.hashCode();
    }

    public ImageProcessor.Response safeProcess(ImageProcessor.Request request) throws ImageCaptureException {
        try {
            return (ImageProcessor.Response) CallbackToFutureAdapter.a(new p(this, request)).get();
        } catch (Exception e11) {
            Throwable cause = e11.getCause();
            Throwable th2 = e11;
            if (cause != null) {
                th2 = e11.getCause();
            }
            throw new ImageCaptureException(0, "Failed to invoke ImageProcessor.", th2);
        }
    }
}
