package com.amazonaws.metrics.internal;

import com.amazonaws.Request;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.SimpleThroughputMetricType;
import com.amazonaws.metrics.ThroughputMetricType;

public enum ServiceMetricTypeGuesser {
    ;

    public static ThroughputMetricType guessThroughputMetricType(Request<?> request, String str, String str2) {
        if (!AwsSdkMetrics.isMetricsEnabled() || !request.q().getClass().getName().startsWith("com.amazonaws.services.s3")) {
            return null;
        }
        return new SimpleThroughputMetricType("S3" + str, request.n(), "S3" + str2);
    }
}
