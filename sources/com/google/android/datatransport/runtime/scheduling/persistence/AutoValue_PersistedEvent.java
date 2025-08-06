package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Objects;

final class AutoValue_PersistedEvent extends PersistedEvent {
    private final EventInternal event;

    /* renamed from: id  reason: collision with root package name */
    private final long f65625id;
    private final TransportContext transportContext;

    public AutoValue_PersistedEvent(long j11, TransportContext transportContext2, EventInternal eventInternal) {
        this.f65625id = j11;
        Objects.requireNonNull(transportContext2, "Null transportContext");
        this.transportContext = transportContext2;
        Objects.requireNonNull(eventInternal, "Null event");
        this.event = eventInternal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedEvent)) {
            return false;
        }
        PersistedEvent persistedEvent = (PersistedEvent) obj;
        if (this.f65625id != persistedEvent.getId() || !this.transportContext.equals(persistedEvent.getTransportContext()) || !this.event.equals(persistedEvent.getEvent())) {
            return false;
        }
        return true;
    }

    public EventInternal getEvent() {
        return this.event;
    }

    public long getId() {
        return this.f65625id;
    }

    public TransportContext getTransportContext() {
        return this.transportContext;
    }

    public int hashCode() {
        long j11 = this.f65625id;
        return ((((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ this.transportContext.hashCode()) * 1000003) ^ this.event.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f65625id + ", transportContext=" + this.transportContext + ", event=" + this.event + "}";
    }
}
