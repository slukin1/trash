package com.amazonaws.event;

public class ProgressEvent {

    /* renamed from: a  reason: collision with root package name */
    public long f14861a;

    /* renamed from: b  reason: collision with root package name */
    public int f14862b;

    public ProgressEvent(long j11) {
        this.f14861a = j11;
    }

    public long a() {
        return this.f14861a;
    }

    public int b() {
        return this.f14862b;
    }

    public void c(int i11) {
        this.f14862b = i11;
    }

    public ProgressEvent(int i11, long j11) {
        this.f14862b = i11;
        this.f14861a = j11;
    }
}
