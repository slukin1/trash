package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;

final class h extends StandardIntegrityManager.PrepareIntegrityTokenRequest {

    /* renamed from: a  reason: collision with root package name */
    private final long f66834a;

    public /* synthetic */ h(long j11, g gVar) {
        this.f66834a = j11;
    }

    public final long a() {
        return this.f66834a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof StandardIntegrityManager.PrepareIntegrityTokenRequest) && this.f66834a == ((StandardIntegrityManager.PrepareIntegrityTokenRequest) obj).a();
    }

    public final int hashCode() {
        long j11 = this.f66834a;
        return ((int) (j11 ^ (j11 >>> 32))) ^ 1000003;
    }

    public final String toString() {
        long j11 = this.f66834a;
        return "PrepareIntegrityTokenRequest{cloudProjectNumber=" + j11 + "}";
    }
}
