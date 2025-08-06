package com.amazonaws.metrics;

public class SimpleThroughputMetricType extends SimpleServiceMetricType implements ThroughputMetricType {

    /* renamed from: d  reason: collision with root package name */
    public final ServiceMetricType f14952d;

    public SimpleThroughputMetricType(String str, String str2, String str3) {
        super(str, str2);
        this.f14952d = new SimpleServiceMetricType(str3, str2);
    }
}
