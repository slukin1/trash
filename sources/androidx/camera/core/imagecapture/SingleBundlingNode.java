package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.h;
import java.util.Objects;

class SingleBundlingNode implements BundlingNode {
    private ProcessingNode.In mOutputEdge;
    public ProcessingRequest mPendingRequest;

    /* access modifiers changed from: private */
    public void matchImageWithRequest(ImageProxy imageProxy) {
        Threads.checkMainThread();
        boolean z11 = true;
        h.i(this.mPendingRequest != null);
        Object tag = imageProxy.getImageInfo().getTagBundle().getTag(this.mPendingRequest.getTagBundleKey());
        Objects.requireNonNull(tag);
        if (((Integer) tag).intValue() != this.mPendingRequest.getStageIds().get(0).intValue()) {
            z11 = false;
        }
        h.i(z11);
        this.mOutputEdge.getEdge().accept(ProcessingNode.InputPacket.of(this.mPendingRequest, imageProxy));
        this.mPendingRequest = null;
    }

    /* access modifiers changed from: private */
    public void trackIncomingRequest(final ProcessingRequest processingRequest) {
        Threads.checkMainThread();
        boolean z11 = false;
        h.j(processingRequest.getStageIds().size() == 1, "Cannot handle multi-image capture.");
        if (this.mPendingRequest == null) {
            z11 = true;
        }
        h.j(z11, "Already has an existing request.");
        this.mPendingRequest = processingRequest;
        Futures.addCallback(processingRequest.getCaptureFuture(), new FutureCallback<Void>() {
            public void onFailure(Throwable th2) {
                Threads.checkMainThread();
                ProcessingRequest processingRequest = processingRequest;
                SingleBundlingNode singleBundlingNode = SingleBundlingNode.this;
                if (processingRequest == singleBundlingNode.mPendingRequest) {
                    singleBundlingNode.mPendingRequest = null;
                }
            }

            public void onSuccess(Void voidR) {
            }
        }, CameraXExecutors.directExecutor());
    }

    public void release() {
    }

    public ProcessingNode.In transform(CaptureNode.Out out) {
        out.getImageEdge().setListener(new m(this));
        out.getRequestEdge().setListener(new n(this));
        ProcessingNode.In of2 = ProcessingNode.In.of(out.getInputFormat(), out.getOutputFormat());
        this.mOutputEdge = of2;
        return of2;
    }
}
