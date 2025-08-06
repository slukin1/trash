package com.jumio.core.api.calls;

import kotlin.jvm.internal.x;

public final class DigitalIdentityWebContentResult {

    /* renamed from: a  reason: collision with root package name */
    public final String f39060a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39061b;

    public DigitalIdentityWebContentResult(String str, String str2) {
        this.f39060a = str;
        this.f39061b = str2;
    }

    public static /* synthetic */ DigitalIdentityWebContentResult copy$default(DigitalIdentityWebContentResult digitalIdentityWebContentResult, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = digitalIdentityWebContentResult.f39060a;
        }
        if ((i11 & 2) != 0) {
            str2 = digitalIdentityWebContentResult.f39061b;
        }
        return digitalIdentityWebContentResult.copy(str, str2);
    }

    public final String component1() {
        return this.f39060a;
    }

    public final String component2() {
        return this.f39061b;
    }

    public final DigitalIdentityWebContentResult copy(String str, String str2) {
        return new DigitalIdentityWebContentResult(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DigitalIdentityWebContentResult)) {
            return false;
        }
        DigitalIdentityWebContentResult digitalIdentityWebContentResult = (DigitalIdentityWebContentResult) obj;
        return x.b(this.f39060a, digitalIdentityWebContentResult.f39060a) && x.b(this.f39061b, digitalIdentityWebContentResult.f39061b);
    }

    public final String getHtml() {
        return this.f39061b;
    }

    public final String getRequestUrl() {
        return this.f39060a;
    }

    public int hashCode() {
        return this.f39061b.hashCode() + (this.f39060a.hashCode() * 31);
    }

    public String toString() {
        String str = this.f39060a;
        String str2 = this.f39061b;
        return "DigitalIdentityWebContentResult(requestUrl=" + str + ", html=" + str2 + ")";
    }
}
