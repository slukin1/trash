package com.sumsub.sns.internal.core.common;

import com.sumsub.log.logger.a;
import com.sumsub.sns.internal.log.c;

public final class p0 {
    public final o0 a() {
        try {
            Class.forName("com.google.mlkit.vision.face.FaceDetection");
            a.a(com.sumsub.sns.internal.log.a.f34862a, c.a(this), "Using MLKit Face rotation detector", (Throwable) null, 4, (Object) null);
            return new d0();
        } catch (Exception unused) {
            a.a(com.sumsub.sns.internal.log.a.f34862a, c.a(this), "Disable rotation detector", (Throwable) null, 4, (Object) null);
            return new n();
        }
    }
}
