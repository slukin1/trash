package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;
import java.util.Objects;

final class AutoValue_BackendResponse extends BackendResponse {
    private final long nextRequestWaitMillis;
    private final BackendResponse.Status status;

    public AutoValue_BackendResponse(BackendResponse.Status status2, long j11) {
        Objects.requireNonNull(status2, "Null status");
        this.status = status2;
        this.nextRequestWaitMillis = j11;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        if (!this.status.equals(backendResponse.getStatus()) || this.nextRequestWaitMillis != backendResponse.getNextRequestWaitMillis()) {
            return false;
        }
        return true;
    }

    public long getNextRequestWaitMillis() {
        return this.nextRequestWaitMillis;
    }

    public BackendResponse.Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        long j11 = this.nextRequestWaitMillis;
        return ((this.status.hashCode() ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.status + ", nextRequestWaitMillis=" + this.nextRequestWaitMillis + "}";
    }
}
