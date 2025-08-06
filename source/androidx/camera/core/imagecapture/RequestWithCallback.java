package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.core.impl.utils.Threads;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

class RequestWithCallback implements TakePictureCallback {
    private CallbackToFutureAdapter.a<Void> mCaptureCompleter;
    private final ListenableFuture<Void> mCaptureFuture;
    private ListenableFuture<Void> mCaptureRequestFuture;
    private CallbackToFutureAdapter.a<Void> mCompleteCompleter;
    private final ListenableFuture<Void> mCompleteFuture;
    private boolean mIsAborted = false;
    private final TakePictureRequest.RetryControl mRetryControl;
    private final TakePictureRequest mTakePictureRequest;

    public RequestWithCallback(TakePictureRequest takePictureRequest, TakePictureRequest.RetryControl retryControl) {
        this.mTakePictureRequest = takePictureRequest;
        this.mRetryControl = retryControl;
        this.mCaptureFuture = CallbackToFutureAdapter.a(new l(this));
        this.mCompleteFuture = CallbackToFutureAdapter.a(new k(this));
    }

    private void abort(ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        this.mIsAborted = true;
        ListenableFuture<Void> listenableFuture = this.mCaptureRequestFuture;
        Objects.requireNonNull(listenableFuture);
        listenableFuture.cancel(true);
        this.mCaptureCompleter.f(imageCaptureException);
        this.mCompleteCompleter.c(null);
    }

    private void checkOnImageCaptured() {
        h.j(this.mCaptureFuture.isDone(), "onImageCaptured() must be called before onFinalResult()");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.a aVar) throws Exception {
        this.mCaptureCompleter = aVar;
        return "CaptureCompleteFuture";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$1(CallbackToFutureAdapter.a aVar) throws Exception {
        this.mCompleteCompleter = aVar;
        return "RequestCompleteFuture";
    }

    private void markComplete() {
        h.j(!this.mCompleteFuture.isDone(), "The callback can only complete once.");
        this.mCompleteCompleter.c(null);
    }

    private void onFailure(ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        this.mTakePictureRequest.onError(imageCaptureException);
    }

    public void abortAndSendErrorToApp(ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        if (!this.mCompleteFuture.isDone()) {
            abort(imageCaptureException);
            onFailure(imageCaptureException);
        }
    }

    public void abortSilentlyAndRetry() {
        Threads.checkMainThread();
        if (!this.mCompleteFuture.isDone()) {
            abort(new ImageCaptureException(3, "The request is aborted silently and retried.", (Throwable) null));
            this.mRetryControl.retryRequest(this.mTakePictureRequest);
        }
    }

    public ListenableFuture<Void> getCaptureFuture() {
        Threads.checkMainThread();
        return this.mCaptureFuture;
    }

    public ListenableFuture<Void> getCompleteFuture() {
        Threads.checkMainThread();
        return this.mCompleteFuture;
    }

    public boolean isAborted() {
        return this.mIsAborted;
    }

    public void onCaptureFailure(ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        if (!this.mIsAborted) {
            boolean decrementRetryCounter = this.mTakePictureRequest.decrementRetryCounter();
            if (!decrementRetryCounter) {
                onFailure(imageCaptureException);
            }
            markComplete();
            this.mCaptureCompleter.f(imageCaptureException);
            if (decrementRetryCounter) {
                this.mRetryControl.retryRequest(this.mTakePictureRequest);
            }
        }
    }

    public void onFinalResult(ImageCapture.OutputFileResults outputFileResults) {
        Threads.checkMainThread();
        if (!this.mIsAborted) {
            checkOnImageCaptured();
            markComplete();
            this.mTakePictureRequest.onResult(outputFileResults);
        }
    }

    public void onImageCaptured() {
        Threads.checkMainThread();
        if (!this.mIsAborted) {
            this.mCaptureCompleter.c(null);
        }
    }

    public void onProcessFailure(ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        if (!this.mIsAborted) {
            checkOnImageCaptured();
            markComplete();
            onFailure(imageCaptureException);
        }
    }

    public void setCaptureRequestFuture(ListenableFuture<Void> listenableFuture) {
        Threads.checkMainThread();
        h.j(this.mCaptureRequestFuture == null, "CaptureRequestFuture can only be set once.");
        this.mCaptureRequestFuture = listenableFuture;
    }

    public void onFinalResult(ImageProxy imageProxy) {
        Threads.checkMainThread();
        if (!this.mIsAborted) {
            checkOnImageCaptured();
            markComplete();
            this.mTakePictureRequest.onResult(imageProxy);
        }
    }
}
