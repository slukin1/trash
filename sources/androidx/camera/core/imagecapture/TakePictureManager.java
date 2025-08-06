package androidx.camera.core.imagecapture;

import android.util.Log;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.c;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class TakePictureManager implements ForwardingImageProxy.OnImageCloseListener, TakePictureRequest.RetryControl {
    private static final String TAG = "TakePictureManager";
    private RequestWithCallback mCapturingRequest;
    public final ImageCaptureControl mImageCaptureControl;
    public ImagePipeline mImagePipeline;
    private final List<RequestWithCallback> mIncompleteRequests;
    public final Deque<TakePictureRequest> mNewRequests = new ArrayDeque();
    public boolean mPaused = false;

    public TakePictureManager(ImageCaptureControl imageCaptureControl) {
        Threads.checkMainThread();
        this.mImageCaptureControl = imageCaptureControl;
        this.mIncompleteRequests = new ArrayList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$trackCurrentRequests$0() {
        this.mCapturingRequest = null;
        issueNextRequest();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$trackCurrentRequests$1(RequestWithCallback requestWithCallback) {
        this.mIncompleteRequests.remove(requestWithCallback);
    }

    private ListenableFuture<Void> submitCameraRequest(final CameraRequest cameraRequest) {
        Threads.checkMainThread();
        this.mImageCaptureControl.lockFlashMode();
        ListenableFuture<Void> submitStillCaptureRequests = this.mImageCaptureControl.submitStillCaptureRequests(cameraRequest.getCaptureConfigs());
        Futures.addCallback(submitStillCaptureRequests, new FutureCallback<Void>() {
            public void onFailure(Throwable th2) {
                if (!cameraRequest.isAborted()) {
                    if (th2 instanceof ImageCaptureException) {
                        TakePictureManager.this.mImagePipeline.notifyCaptureError((ImageCaptureException) th2);
                    } else {
                        TakePictureManager.this.mImagePipeline.notifyCaptureError(new ImageCaptureException(2, "Failed to submit capture request", th2));
                    }
                    TakePictureManager.this.mImageCaptureControl.unlockFlashMode();
                }
            }

            public void onSuccess(Void voidR) {
                TakePictureManager.this.mImageCaptureControl.unlockFlashMode();
            }
        }, CameraXExecutors.mainThreadExecutor());
        return submitStillCaptureRequests;
    }

    private void trackCurrentRequests(RequestWithCallback requestWithCallback) {
        h.i(!hasCapturingRequest());
        this.mCapturingRequest = requestWithCallback;
        requestWithCallback.getCaptureFuture().addListener(new p(this), CameraXExecutors.directExecutor());
        this.mIncompleteRequests.add(requestWithCallback);
        requestWithCallback.getCompleteFuture().addListener(new q(this, requestWithCallback), CameraXExecutors.directExecutor());
    }

    public void abortRequests() {
        Threads.checkMainThread();
        ImageCaptureException imageCaptureException = new ImageCaptureException(3, "Camera is closed.", (Throwable) null);
        for (TakePictureRequest onError : this.mNewRequests) {
            onError.onError(imageCaptureException);
        }
        this.mNewRequests.clear();
        for (RequestWithCallback abortAndSendErrorToApp : new ArrayList(this.mIncompleteRequests)) {
            abortAndSendErrorToApp.abortAndSendErrorToApp(imageCaptureException);
        }
    }

    public ImagePipeline getImagePipeline() {
        return this.mImagePipeline;
    }

    public List<RequestWithCallback> getIncompleteRequests() {
        return this.mIncompleteRequests;
    }

    public boolean hasCapturingRequest() {
        return this.mCapturingRequest != null;
    }

    public void issueNextRequest() {
        Threads.checkMainThread();
        Log.d(TAG, "Issue the next TakePictureRequest.");
        if (hasCapturingRequest()) {
            Log.d(TAG, "There is already a request in-flight.");
        } else if (this.mPaused) {
            Log.d(TAG, "The class is paused.");
        } else if (this.mImagePipeline.getCapacity() == 0) {
            Log.d(TAG, "Too many acquire images. Close image to be able to process next.");
        } else {
            TakePictureRequest poll = this.mNewRequests.poll();
            if (poll == null) {
                Log.d(TAG, "No new request.");
                return;
            }
            RequestWithCallback requestWithCallback = new RequestWithCallback(poll, this);
            trackCurrentRequests(requestWithCallback);
            c<CameraRequest, ProcessingRequest> createRequests = this.mImagePipeline.createRequests(poll, requestWithCallback, requestWithCallback.getCaptureFuture());
            CameraRequest cameraRequest = (CameraRequest) createRequests.f8468a;
            Objects.requireNonNull(cameraRequest);
            ProcessingRequest processingRequest = (ProcessingRequest) createRequests.f8469b;
            Objects.requireNonNull(processingRequest);
            this.mImagePipeline.submitProcessingRequest(processingRequest);
            requestWithCallback.setCaptureRequestFuture(submitCameraRequest(cameraRequest));
        }
    }

    public void offerRequest(TakePictureRequest takePictureRequest) {
        Threads.checkMainThread();
        this.mNewRequests.offer(takePictureRequest);
        issueNextRequest();
    }

    public void onImageClose(ImageProxy imageProxy) {
        CameraXExecutors.mainThreadExecutor().execute(new o(this));
    }

    public void pause() {
        Threads.checkMainThread();
        this.mPaused = true;
        RequestWithCallback requestWithCallback = this.mCapturingRequest;
        if (requestWithCallback != null) {
            requestWithCallback.abortSilentlyAndRetry();
        }
    }

    public void resume() {
        Threads.checkMainThread();
        this.mPaused = false;
        issueNextRequest();
    }

    public void retryRequest(TakePictureRequest takePictureRequest) {
        Threads.checkMainThread();
        Logger.d(TAG, "Add a new request for retrying.");
        this.mNewRequests.addFirst(takePictureRequest);
        issueNextRequest();
    }

    public void setImagePipeline(ImagePipeline imagePipeline) {
        Threads.checkMainThread();
        this.mImagePipeline = imagePipeline;
        imagePipeline.setOnImageCloseListener(this);
    }
}
