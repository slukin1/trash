package com.google.android.datatransport.cct.internal;

final class AutoValue_LogResponse extends LogResponse {
    private final long nextRequestWaitMillis;

    public AutoValue_LogResponse(long j11) {
        this.nextRequestWaitMillis = j11;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogResponse)) {
            return false;
        }
        if (this.nextRequestWaitMillis == ((LogResponse) obj).getNextRequestWaitMillis()) {
            return true;
        }
        return false;
    }

    public long getNextRequestWaitMillis() {
        return this.nextRequestWaitMillis;
    }

    public int hashCode() {
        long j11 = this.nextRequestWaitMillis;
        return ((int) (j11 ^ (j11 >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.nextRequestWaitMillis + "}";
    }
}
