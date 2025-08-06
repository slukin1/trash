package com.amazonaws.metrics;

public class SimpleServiceMetricType extends SimpleMetricType implements ServiceMetricType {

    /* renamed from: b  reason: collision with root package name */
    public final String f14950b;

    /* renamed from: c  reason: collision with root package name */
    public final String f14951c;

    public SimpleServiceMetricType(String str, String str2) {
        this.f14950b = str;
        this.f14951c = str2;
    }

    public String name() {
        return this.f14950b;
    }
}
