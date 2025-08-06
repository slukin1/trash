package com.jumio.analytics;

import android.os.SystemClock;
import java.io.Serializable;
import java.util.UUID;
import jumio.core.x1;
import kotlin.jvm.internal.x;

public final class AnalyticsEvent implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final long f38917a = SystemClock.elapsedRealtime();

    /* renamed from: b  reason: collision with root package name */
    public final int f38918b;

    /* renamed from: c  reason: collision with root package name */
    public final x1<?> f38919c;

    /* renamed from: d  reason: collision with root package name */
    public UUID f38920d;

    public AnalyticsEvent(int i11, MetaInfo metaInfo) {
        this.f38918b = i11;
        this.f38919c = new x1<>(metaInfo, (MetaInfo) null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AnalyticsEvent)) {
            return false;
        }
        AnalyticsEvent analyticsEvent = (AnalyticsEvent) obj;
        if (analyticsEvent.f38917a == this.f38917a && x.b(analyticsEvent.f38920d, this.f38920d) && analyticsEvent.f38918b == this.f38918b) {
            return true;
        }
        return false;
    }

    public final long getEventElapsedMillis() {
        return this.f38917a;
    }

    public final int getEventType() {
        return this.f38918b;
    }

    public final x1<?> getPayload() {
        return this.f38919c;
    }

    public final UUID getSessionId() {
        return this.f38920d;
    }

    public int hashCode() {
        long j11 = this.f38917a;
        int i11 = (((int) (j11 ^ (j11 >>> 32))) + 31) * 31;
        UUID uuid = this.f38920d;
        return ((i11 + (uuid == null ? 0 : uuid.hashCode())) * 31) + this.f38918b;
    }

    public final void setSessionId(UUID uuid) {
        this.f38920d = uuid;
    }

    public String toString() {
        String str;
        int i11 = this.f38918b;
        long j11 = this.f38917a;
        Object b11 = this.f38919c.b();
        if (this.f38919c.a() != null) {
            str = " | " + this.f38919c.a();
        } else {
            str = "";
        }
        return "AnalyticsEvent " + i11 + " | " + j11 + " // " + b11 + str;
    }

    public AnalyticsEvent(int i11, String str, MetaInfo metaInfo) {
        this.f38918b = i11;
        this.f38919c = new x1<>(str, metaInfo);
    }
}
