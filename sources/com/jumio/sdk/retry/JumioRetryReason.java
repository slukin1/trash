package com.jumio.sdk.retry;

import java.io.Serializable;

public final class JumioRetryReason implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final int f25012a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25013b;

    public JumioRetryReason(int i11, String str) {
        this.f25012a = i11;
        this.f25013b = str;
    }

    public final int getCode() {
        return this.f25012a;
    }

    public final String getMessage() {
        return this.f25013b;
    }
}
