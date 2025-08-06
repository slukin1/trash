package com.google.android.play.core.integrity;

import android.app.PendingIntent;
import com.google.android.play.integrity.internal.q;
import java.util.Objects;

final class b extends ba {

    /* renamed from: a  reason: collision with root package name */
    private String f66818a;

    /* renamed from: b  reason: collision with root package name */
    private q f66819b;

    /* renamed from: c  reason: collision with root package name */
    private PendingIntent f66820c;

    public final ba a(PendingIntent pendingIntent) {
        this.f66820c = pendingIntent;
        return this;
    }

    public final ba b(q qVar) {
        Objects.requireNonNull(qVar, "Null logger");
        this.f66819b = qVar;
        return this;
    }

    public final ba c(String str) {
        Objects.requireNonNull(str, "Null token");
        this.f66818a = str;
        return this;
    }

    public final bb d() {
        q qVar;
        String str = this.f66818a;
        if (str != null && (qVar = this.f66819b) != null) {
            return new bb(str, qVar, this.f66820c);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f66818a == null) {
            sb2.append(" token");
        }
        if (this.f66819b == null) {
            sb2.append(" logger");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
    }
}
