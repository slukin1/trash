package com.google.android.play.core.integrity;

import android.app.PendingIntent;
import com.google.android.play.core.integrity.StandardIntegrityManager;
import com.google.android.play.integrity.internal.q;

final class bb extends StandardIntegrityManager.StandardIntegrityToken {

    /* renamed from: a  reason: collision with root package name */
    private final String f66821a;

    /* renamed from: b  reason: collision with root package name */
    private final u f66822b;

    public bb(String str, q qVar, PendingIntent pendingIntent) {
        this.f66821a = str;
        this.f66822b = new u(qVar, pendingIntent);
    }

    public final String token() {
        return this.f66821a;
    }
}
