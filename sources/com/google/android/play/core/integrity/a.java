package com.google.android.play.core.integrity;

import android.app.PendingIntent;
import com.google.android.play.integrity.internal.q;
import java.util.Objects;

final class a extends ag {

    /* renamed from: a  reason: collision with root package name */
    private String f66767a;

    /* renamed from: b  reason: collision with root package name */
    private q f66768b;

    /* renamed from: c  reason: collision with root package name */
    private PendingIntent f66769c;

    public final ag a(PendingIntent pendingIntent) {
        this.f66769c = pendingIntent;
        return this;
    }

    public final ag b(q qVar) {
        Objects.requireNonNull(qVar, "Null logger");
        this.f66768b = qVar;
        return this;
    }

    public final ag c(String str) {
        this.f66767a = str;
        return this;
    }

    public final ah d() {
        q qVar;
        String str = this.f66767a;
        if (str != null && (qVar = this.f66768b) != null) {
            return new ah(str, qVar, this.f66769c);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f66767a == null) {
            sb2.append(" token");
        }
        if (this.f66768b == null) {
            sb2.append(" logger");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
    }
}
