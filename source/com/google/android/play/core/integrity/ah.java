package com.google.android.play.core.integrity;

import android.app.PendingIntent;
import com.google.android.play.integrity.internal.q;

final class ah extends IntegrityTokenResponse {

    /* renamed from: a  reason: collision with root package name */
    private final String f66785a;

    /* renamed from: b  reason: collision with root package name */
    private final u f66786b;

    public ah(String str, q qVar, PendingIntent pendingIntent) {
        this.f66785a = str;
        this.f66786b = new u(qVar, pendingIntent);
    }

    public final String token() {
        return this.f66785a;
    }
}
