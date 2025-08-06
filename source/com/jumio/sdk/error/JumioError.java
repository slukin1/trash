package com.jumio.sdk.error;

import java.io.Serializable;

public final class JumioError implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f24976a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24977b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24978c;

    /* renamed from: d  reason: collision with root package name */
    public final String f24979d;

    public JumioError(boolean z11, String str, String str2, String str3) {
        this.f24976a = z11;
        this.f24977b = str;
        this.f24978c = str2;
        this.f24979d = str3;
    }

    public final String getCode() {
        return this.f24978c;
    }

    public final String getDomain() {
        return this.f24977b;
    }

    public final String getMessage() {
        return this.f24979d;
    }

    public final boolean isRetryable() {
        return this.f24976a;
    }
}
