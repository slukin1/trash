package com.nostra13.universalimageloader.core.assist;

public class FailReason {

    /* renamed from: a  reason: collision with root package name */
    public final FailType f28363a;

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f28364b;

    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public FailReason(FailType failType, Throwable th2) {
        this.f28363a = failType;
        this.f28364b = th2;
    }
}
