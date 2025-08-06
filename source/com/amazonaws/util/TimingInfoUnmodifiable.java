package com.amazonaws.util;

final class TimingInfoUnmodifiable extends TimingInfo {
    public TimingInfoUnmodifiable(Long l11, long j11, Long l12) {
        super(l11, j11, l12);
    }

    public TimingInfo c() {
        throw new UnsupportedOperationException();
    }
}
