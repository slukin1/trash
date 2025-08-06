package androidx.camera.core.imagecapture;

import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.r4;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.Logger;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.Node;
import androidx.core.util.h;
import com.google.auto.value.AutoValue;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class CaptureNode implements Node<In, Out> {
    public static final int MAX_IMAGES = 4;
    private static final String TAG = "CaptureNode";
    public ProcessingRequest mCurrentRequest = null;
    private In mInputEdge;
    private Out mOutputEdge;
    private final Set<Integer> mPendingStageIds = new HashSet();
    public SafeCloseImageReaderProxy mSafeCloseImageReaderProxy;

    @AutoValue
    public static abstract class In {
        private CameraCaptureCallback mCameraCaptureCallback = new CameraCaptureCallback() {
        };
        private DeferrableSurface mSurface;

        public static In of(Size size, int i11, int i12, boolean z11, ImageReaderProxyProvider imageReaderProxyProvider) {
            return new AutoValue_CaptureNode_In(size, i11, i12, z11, imageReaderProxyProvider, new Edge(), new Edge());
        }

        public CameraCaptureCallback getCameraCaptureCallback() {
            return this.mCameraCaptureCallback;
        }

        public abstract Edge<ImageCaptureException> getErrorEdge();

        public abstract ImageReaderProxyProvider getImageReaderProxyProvider();

        public abstract int getInputFormat();

        public abstract int getOutputFormat();

        public abstract Edge<ProcessingRequest> getRequestEdge();

        public abstract Size getSize();

        public DeferrableSurface getSurface() {
            DeferrableSurface deferrableSurface = this.mSurface;
            Objects.requireNonNull(deferrableSurface);
            return deferrableSurface;
        }

        public abstract boolean isVirtualCamera();

        public void setCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
            this.mCameraCaptureCallback = cameraCaptureCallback;
        }

        public void setSurface(Surface surface) {
            h.j(this.mSurface == null, "The surface is already set.");
            this.mSurface = new ImmediateSurface(surface, getSize(), getInputFormat());
        }
    }

    @AutoValue
    public static abstract class Out {
        public static Out of(int i11, int i12) {
            return new AutoValue_CaptureNode_Out(new Edge(), new Edge(), i11, i12);
        }

        public abstract Edge<ImageProxy> getImageEdge();

        public abstract int getInputFormat();

        public abstract int getOutputFormat();

        public abstract Edge<ProcessingRequest> getRequestEdge();
    }

    private static ImageReaderProxy createImageReaderProxy(ImageReaderProxyProvider imageReaderProxyProvider, int i11, int i12, int i13) {
        if (imageReaderProxyProvider != null) {
            return imageReaderProxyProvider.newInstance(i11, i12, i13, 4, 0);
        }
        return ImageReaderProxys.createIsolatedReader(i11, i12, i13, 4);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$transform$0(NoMetadataImageReader noMetadataImageReader, ProcessingRequest processingRequest) {
        onRequestAvailable(processingRequest);
        noMetadataImageReader.acceptProcessingRequest(processingRequest);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$transform$1(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (acquireLatestImage != null) {
                onImageProxyAvailable(acquireLatestImage);
            } else {
                sendCaptureError(new ImageCaptureException(2, "Failed to acquire latest image", (Throwable) null));
            }
        } catch (IllegalStateException e11) {
            sendCaptureError(new ImageCaptureException(2, "Failed to acquire latest image", e11));
        }
    }

    private void matchAndPropagateImage(ImageProxy imageProxy) {
        Object tag = imageProxy.getImageInfo().getTagBundle().getTag(this.mCurrentRequest.getTagBundleKey());
        Objects.requireNonNull(tag);
        int intValue = ((Integer) tag).intValue();
        boolean contains = this.mPendingStageIds.contains(Integer.valueOf(intValue));
        h.j(contains, "Received an unexpected stage id" + intValue);
        this.mPendingStageIds.remove(Integer.valueOf(intValue));
        Out out = this.mOutputEdge;
        Objects.requireNonNull(out);
        out.getImageEdge().accept(imageProxy);
        if (this.mPendingStageIds.isEmpty()) {
            ProcessingRequest processingRequest = this.mCurrentRequest;
            this.mCurrentRequest = null;
            processingRequest.onImageCaptured();
        }
    }

    private void releaseInputResources(In in2, SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        in2.getSurface().close();
        ListenableFuture<Void> terminationFuture = in2.getSurface().getTerminationFuture();
        Objects.requireNonNull(safeCloseImageReaderProxy);
        terminationFuture.addListener(new r4(safeCloseImageReaderProxy), CameraXExecutors.mainThreadExecutor());
    }

    public int getCapacity() {
        Threads.checkMainThread();
        h.j(this.mSafeCloseImageReaderProxy != null, "The ImageReader is not initialized.");
        return this.mSafeCloseImageReaderProxy.getCapacity();
    }

    public In getInputEdge() {
        In in2 = this.mInputEdge;
        Objects.requireNonNull(in2);
        return in2;
    }

    public SafeCloseImageReaderProxy getSafeCloseImageReaderProxy() {
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mSafeCloseImageReaderProxy;
        Objects.requireNonNull(safeCloseImageReaderProxy);
        return safeCloseImageReaderProxy;
    }

    public void onImageProxyAvailable(ImageProxy imageProxy) {
        Threads.checkMainThread();
        if (this.mCurrentRequest == null) {
            Logger.d(TAG, "Discarding ImageProxy which was inadvertently acquired: " + imageProxy);
            imageProxy.close();
            return;
        }
        matchAndPropagateImage(imageProxy);
    }

    public void onRequestAvailable(final ProcessingRequest processingRequest) {
        Threads.checkMainThread();
        boolean z11 = true;
        h.j(getCapacity() > 0, "Too many acquire images. Close image to be able to process next.");
        if (this.mCurrentRequest != null && !this.mPendingStageIds.isEmpty()) {
            z11 = false;
        }
        h.j(z11, "The previous request is not complete");
        this.mCurrentRequest = processingRequest;
        this.mPendingStageIds.addAll(processingRequest.getStageIds());
        Out out = this.mOutputEdge;
        Objects.requireNonNull(out);
        out.getRequestEdge().accept(processingRequest);
        Futures.addCallback(processingRequest.getCaptureFuture(), new FutureCallback<Void>() {
            public void onFailure(Throwable th2) {
                Threads.checkMainThread();
                ProcessingRequest processingRequest = processingRequest;
                CaptureNode captureNode = CaptureNode.this;
                if (processingRequest == captureNode.mCurrentRequest) {
                    captureNode.mCurrentRequest = null;
                }
            }

            public void onSuccess(Void voidR) {
            }
        }, CameraXExecutors.directExecutor());
    }

    public void release() {
        Threads.checkMainThread();
        In in2 = this.mInputEdge;
        Objects.requireNonNull(in2);
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mSafeCloseImageReaderProxy;
        Objects.requireNonNull(safeCloseImageReaderProxy);
        releaseInputResources(in2, safeCloseImageReaderProxy);
    }

    public void sendCaptureError(ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        ProcessingRequest processingRequest = this.mCurrentRequest;
        if (processingRequest != null) {
            processingRequest.onCaptureFailure(imageCaptureException);
        }
    }

    public void setOnImageCloseListener(ForwardingImageProxy.OnImageCloseListener onImageCloseListener) {
        Threads.checkMainThread();
        h.j(this.mSafeCloseImageReaderProxy != null, "The ImageReader is not initialized.");
        this.mSafeCloseImageReaderProxy.setOnImageCloseListener(onImageCloseListener);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.camera.core.imagecapture.NoMetadataImageReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: androidx.camera.core.MetadataImageReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: androidx.camera.core.imagecapture.NoMetadataImageReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.camera.core.imagecapture.NoMetadataImageReader} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.imagecapture.CaptureNode.Out transform(androidx.camera.core.imagecapture.CaptureNode.In r6) {
        /*
            r5 = this;
            androidx.camera.core.imagecapture.CaptureNode$In r0 = r5.mInputEdge
            r1 = 1
            if (r0 != 0) goto L_0x000b
            androidx.camera.core.SafeCloseImageReaderProxy r0 = r5.mSafeCloseImageReaderProxy
            if (r0 != 0) goto L_0x000b
            r0 = r1
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            java.lang.String r2 = "CaptureNode does not support recreation yet."
            androidx.core.util.h.j(r0, r2)
            r5.mInputEdge = r6
            android.util.Size r0 = r6.getSize()
            int r2 = r6.getInputFormat()
            boolean r3 = r6.isVirtualCamera()
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x0043
            androidx.camera.core.ImageReaderProxyProvider r1 = r6.getImageReaderProxyProvider()
            if (r1 != 0) goto L_0x0043
            androidx.camera.core.MetadataImageReader r1 = new androidx.camera.core.MetadataImageReader
            int r3 = r0.getWidth()
            int r0 = r0.getHeight()
            r4 = 4
            r1.<init>(r3, r0, r2, r4)
            androidx.camera.core.impl.CameraCaptureCallback r0 = r1.getCameraCaptureCallback()
            r6.setCameraCaptureCallback(r0)
            androidx.camera.core.imagecapture.c r0 = new androidx.camera.core.imagecapture.c
            r0.<init>(r5)
            goto L_0x005d
        L_0x0043:
            androidx.camera.core.imagecapture.NoMetadataImageReader r1 = new androidx.camera.core.imagecapture.NoMetadataImageReader
            androidx.camera.core.ImageReaderProxyProvider r3 = r6.getImageReaderProxyProvider()
            int r4 = r0.getWidth()
            int r0 = r0.getHeight()
            androidx.camera.core.impl.ImageReaderProxy r0 = createImageReaderProxy(r3, r4, r0, r2)
            r1.<init>(r0)
            androidx.camera.core.imagecapture.d r0 = new androidx.camera.core.imagecapture.d
            r0.<init>(r5, r1)
        L_0x005d:
            android.view.Surface r2 = r1.getSurface()
            java.util.Objects.requireNonNull(r2)
            r6.setSurface(r2)
            androidx.camera.core.SafeCloseImageReaderProxy r2 = new androidx.camera.core.SafeCloseImageReaderProxy
            r2.<init>(r1)
            r5.mSafeCloseImageReaderProxy = r2
            androidx.camera.core.imagecapture.a r2 = new androidx.camera.core.imagecapture.a
            r2.<init>(r5)
            java.util.concurrent.ScheduledExecutorService r3 = androidx.camera.core.impl.utils.executor.CameraXExecutors.mainThreadExecutor()
            r1.setOnImageAvailableListener(r2, r3)
            androidx.camera.core.processing.Edge r1 = r6.getRequestEdge()
            r1.setListener(r0)
            androidx.camera.core.processing.Edge r0 = r6.getErrorEdge()
            androidx.camera.core.imagecapture.b r1 = new androidx.camera.core.imagecapture.b
            r1.<init>(r5)
            r0.setListener(r1)
            int r0 = r6.getInputFormat()
            int r6 = r6.getOutputFormat()
            androidx.camera.core.imagecapture.CaptureNode$Out r6 = androidx.camera.core.imagecapture.CaptureNode.Out.of(r0, r6)
            r5.mOutputEdge = r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.imagecapture.CaptureNode.transform(androidx.camera.core.imagecapture.CaptureNode$In):androidx.camera.core.imagecapture.CaptureNode$Out");
    }
}
