package org.joda.time.chrono;

import org.joda.time.DateTimeZone;
import org.joda.time.Instant;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public final DateTimeZone f23088a;

    /* renamed from: b  reason: collision with root package name */
    public final Instant f23089b;

    /* renamed from: c  reason: collision with root package name */
    public final int f23090c;

    public h(DateTimeZone dateTimeZone, Instant instant, int i11) {
        this.f23088a = dateTimeZone;
        this.f23089b = instant;
        this.f23090c = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        Instant instant = this.f23089b;
        if (instant == null) {
            if (hVar.f23089b != null) {
                return false;
            }
        } else if (!instant.equals(hVar.f23089b)) {
            return false;
        }
        if (this.f23090c != hVar.f23090c) {
            return false;
        }
        DateTimeZone dateTimeZone = this.f23088a;
        if (dateTimeZone == null) {
            if (hVar.f23088a != null) {
                return false;
            }
        } else if (!dateTimeZone.equals(hVar.f23088a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Instant instant = this.f23089b;
        int i11 = 0;
        int hashCode = ((((instant == null ? 0 : instant.hashCode()) + 31) * 31) + this.f23090c) * 31;
        DateTimeZone dateTimeZone = this.f23088a;
        if (dateTimeZone != null) {
            i11 = dateTimeZone.hashCode();
        }
        return hashCode + i11;
    }
}
