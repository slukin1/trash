package com.facebook.stetho.inspector;

public class MismatchedResponseException extends MessageHandlingException {
    public long mRequestId;

    public MismatchedResponseException(long j11) {
        super("Response for request id " + j11 + ", but no such request is pending");
        this.mRequestId = j11;
    }

    public long getRequestId() {
        return this.mRequestId;
    }
}
