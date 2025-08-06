package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest;

class RequestProgress {
    private final Handler callbackHandler;
    private long lastReportedProgress;
    private long maxProgress;
    private long progress;
    private final GraphRequest request;
    private final long threshold = FacebookSdk.getOnProgressThreshold();

    public RequestProgress(Handler handler, GraphRequest graphRequest) {
        this.request = graphRequest;
        this.callbackHandler = handler;
    }

    public void addProgress(long j11) {
        long j12 = this.progress + j11;
        this.progress = j12;
        if (j12 >= this.lastReportedProgress + this.threshold || j12 >= this.maxProgress) {
            reportProgress();
        }
    }

    public void addToMax(long j11) {
        this.maxProgress += j11;
    }

    public long getMaxProgress() {
        return this.maxProgress;
    }

    public long getProgress() {
        return this.progress;
    }

    public void reportProgress() {
        if (this.progress > this.lastReportedProgress) {
            GraphRequest.Callback callback = this.request.getCallback();
            final long j11 = this.maxProgress;
            if (j11 > 0 && (callback instanceof GraphRequest.OnProgressCallback)) {
                final long j12 = this.progress;
                final GraphRequest.OnProgressCallback onProgressCallback = (GraphRequest.OnProgressCallback) callback;
                Handler handler = this.callbackHandler;
                if (handler == null) {
                    onProgressCallback.onProgress(j12, j11);
                } else {
                    handler.post(new Runnable() {
                        public void run() {
                            onProgressCallback.onProgress(j12, j11);
                        }
                    });
                }
                this.lastReportedProgress = this.progress;
            }
        }
    }
}
