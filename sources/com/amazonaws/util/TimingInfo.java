package com.amazonaws.util;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TimingInfo {

    /* renamed from: a  reason: collision with root package name */
    public final Long f15561a;

    /* renamed from: b  reason: collision with root package name */
    public final long f15562b;

    /* renamed from: c  reason: collision with root package name */
    public Long f15563c;

    public TimingInfo(Long l11, long j11, Long l12) {
        this.f15561a = l11;
        this.f15562b = j11;
        this.f15563c = l12;
    }

    public static double b(long j11, long j12) {
        return ((double) TimeUnit.NANOSECONDS.toMicros(j12 - j11)) / 1000.0d;
    }

    public static TimingInfo m() {
        return new TimingInfo(Long.valueOf(System.currentTimeMillis()), System.nanoTime(), (Long) null);
    }

    public static TimingInfo n() {
        return new TimingInfoFullSupport(Long.valueOf(System.currentTimeMillis()), System.nanoTime(), (Long) null);
    }

    public static TimingInfo o(long j11) {
        return new TimingInfoFullSupport((Long) null, j11, (Long) null);
    }

    public static TimingInfo p(long j11, Long l11) {
        return new TimingInfoUnmodifiable((Long) null, j11, l11);
    }

    public void a(String str, TimingInfo timingInfo) {
    }

    public TimingInfo c() {
        this.f15563c = Long.valueOf(System.nanoTime());
        return this;
    }

    public Map<String, Number> d() {
        return Collections.emptyMap();
    }

    public final long e() {
        Long l11 = this.f15563c;
        if (l11 == null) {
            return -1;
        }
        return l11.longValue();
    }

    public final long f() {
        return this.f15562b;
    }

    public Map<String, List<TimingInfo>> g() {
        return Collections.emptyMap();
    }

    @Deprecated
    public final double h() {
        Double i11 = i();
        if (i11 == null) {
            return -1.0d;
        }
        return i11.doubleValue();
    }

    public final Double i() {
        if (k()) {
            return Double.valueOf(b(this.f15562b, this.f15563c.longValue()));
        }
        return null;
    }

    public void j(String str) {
    }

    public final boolean k() {
        return this.f15563c != null;
    }

    public void l(String str, long j11) {
    }

    public final String toString() {
        return String.valueOf(h());
    }
}
