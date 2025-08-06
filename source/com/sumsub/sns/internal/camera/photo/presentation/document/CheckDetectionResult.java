package com.sumsub.sns.internal.camera.photo.presentation.document;

import kotlin.Metadata;
import kotlin.jvm.internal.r;

public final class CheckDetectionResult {

    /* renamed from: d  reason: collision with root package name */
    public static final a f31486d = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f31487a;

    /* renamed from: b  reason: collision with root package name */
    public final SizeCheckResult f31488b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f31489c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/internal/camera/photo/presentation/document/CheckDetectionResult$SizeCheckResult;", "", "(Ljava/lang/String;I)V", "SMALL", "OK", "BIG", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum SizeCheckResult {
        SMALL,
        OK,
        BIG
    }

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final CheckDetectionResult a() {
            return new CheckDetectionResult(false, SizeCheckResult.SMALL, false);
        }

        public a() {
        }
    }

    public CheckDetectionResult(boolean z11, SizeCheckResult sizeCheckResult, boolean z12) {
        this.f31487a = z11;
        this.f31488b = sizeCheckResult;
        this.f31489c = z12;
    }

    public final boolean a() {
        return this.f31487a;
    }

    public final SizeCheckResult b() {
        return this.f31488b;
    }

    public final boolean c() {
        return this.f31489c;
    }

    public final boolean d() {
        return this.f31489c;
    }

    public final boolean e() {
        return this.f31487a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckDetectionResult)) {
            return false;
        }
        CheckDetectionResult checkDetectionResult = (CheckDetectionResult) obj;
        return this.f31487a == checkDetectionResult.f31487a && this.f31488b == checkDetectionResult.f31488b && this.f31489c == checkDetectionResult.f31489c;
    }

    public final SizeCheckResult f() {
        return this.f31488b;
    }

    public int hashCode() {
        boolean z11 = this.f31487a;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int hashCode = (((z11 ? 1 : 0) * true) + this.f31488b.hashCode()) * 31;
        boolean z13 = this.f31489c;
        if (!z13) {
            z12 = z13;
        }
        return hashCode + (z12 ? 1 : 0);
    }

    public String toString() {
        return "CheckDetectionResult(frameHit=" + this.f31487a + ", sizeCheck=" + this.f31488b + ", aspectRatio=" + this.f31489c + ')';
    }

    public final CheckDetectionResult a(boolean z11, SizeCheckResult sizeCheckResult, boolean z12) {
        return new CheckDetectionResult(z11, sizeCheckResult, z12);
    }

    public static /* synthetic */ CheckDetectionResult a(CheckDetectionResult checkDetectionResult, boolean z11, SizeCheckResult sizeCheckResult, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = checkDetectionResult.f31487a;
        }
        if ((i11 & 2) != 0) {
            sizeCheckResult = checkDetectionResult.f31488b;
        }
        if ((i11 & 4) != 0) {
            z12 = checkDetectionResult.f31489c;
        }
        return checkDetectionResult.a(z11, sizeCheckResult, z12);
    }
}
