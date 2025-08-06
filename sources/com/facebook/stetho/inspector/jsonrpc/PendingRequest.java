package com.facebook.stetho.inspector.jsonrpc;

public class PendingRequest {
    public final PendingRequestCallback callback;
    public final long requestId;

    public PendingRequest(long j11, PendingRequestCallback pendingRequestCallback) {
        this.requestId = j11;
        this.callback = pendingRequestCallback;
    }
}
