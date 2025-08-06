package com.amazonaws.metrics;

public abstract class ByteThroughputProvider {

    /* renamed from: a  reason: collision with root package name */
    public long f14943a;

    /* renamed from: b  reason: collision with root package name */
    public int f14944b;

    /* renamed from: c  reason: collision with root package name */
    public final ThroughputMetricType f14945c;

    public ByteThroughputProvider(ThroughputMetricType throughputMetricType) {
        this.f14945c = throughputMetricType;
    }

    public int a() {
        return this.f14944b;
    }

    public long b() {
        return this.f14943a;
    }

    public String c() {
        return super.toString();
    }

    public void d(int i11, long j11) {
        this.f14944b += i11;
        this.f14943a += System.nanoTime() - j11;
    }

    public void e() {
        this.f14944b = 0;
        this.f14943a = 0;
    }

    public String toString() {
        return String.format("providerId=%s, throughputType=%s, byteCount=%d, duration=%d", new Object[]{c(), this.f14945c, Integer.valueOf(this.f14944b), Long.valueOf(this.f14943a)});
    }
}
