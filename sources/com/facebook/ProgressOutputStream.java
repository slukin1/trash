package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequestBatch;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

class ProgressOutputStream extends FilterOutputStream implements RequestOutputStream {
    /* access modifiers changed from: private */
    public long batchProgress;
    private RequestProgress currentRequestProgress;
    private long lastReportedProgress;
    /* access modifiers changed from: private */
    public long maxProgress;
    private final Map<GraphRequest, RequestProgress> progressMap;
    /* access modifiers changed from: private */
    public final GraphRequestBatch requests;
    private final long threshold = FacebookSdk.getOnProgressThreshold();

    public ProgressOutputStream(OutputStream outputStream, GraphRequestBatch graphRequestBatch, Map<GraphRequest, RequestProgress> map, long j11) {
        super(outputStream);
        this.requests = graphRequestBatch;
        this.progressMap = map;
        this.maxProgress = j11;
    }

    private void addProgress(long j11) {
        RequestProgress requestProgress = this.currentRequestProgress;
        if (requestProgress != null) {
            requestProgress.addProgress(j11);
        }
        long j12 = this.batchProgress + j11;
        this.batchProgress = j12;
        if (j12 >= this.lastReportedProgress + this.threshold || j12 >= this.maxProgress) {
            reportBatchProgress();
        }
    }

    private void reportBatchProgress() {
        if (this.batchProgress > this.lastReportedProgress) {
            for (GraphRequestBatch.Callback next : this.requests.getCallbacks()) {
                if (next instanceof GraphRequestBatch.OnProgressCallback) {
                    Handler callbackHandler = this.requests.getCallbackHandler();
                    final GraphRequestBatch.OnProgressCallback onProgressCallback = (GraphRequestBatch.OnProgressCallback) next;
                    if (callbackHandler == null) {
                        onProgressCallback.onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
                    } else {
                        callbackHandler.post(new Runnable() {
                            public void run() {
                                onProgressCallback.onBatchProgress(ProgressOutputStream.this.requests, ProgressOutputStream.this.batchProgress, ProgressOutputStream.this.maxProgress);
                            }
                        });
                    }
                }
            }
            this.lastReportedProgress = this.batchProgress;
        }
    }

    public void close() throws IOException {
        super.close();
        for (RequestProgress reportProgress : this.progressMap.values()) {
            reportProgress.reportProgress();
        }
        reportBatchProgress();
    }

    public long getBatchProgress() {
        return this.batchProgress;
    }

    public long getMaxProgress() {
        return this.maxProgress;
    }

    public void setCurrentRequest(GraphRequest graphRequest) {
        this.currentRequestProgress = graphRequest != null ? this.progressMap.get(graphRequest) : null;
    }

    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        addProgress((long) bArr.length);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.out.write(bArr, i11, i12);
        addProgress((long) i12);
    }

    public void write(int i11) throws IOException {
        this.out.write(i11);
        addProgress(1);
    }
}
