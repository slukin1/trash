package com.amazonaws.util;

import com.amazonaws.metrics.MetricType;

@Deprecated
public class AWSRequestMetrics {

    /* renamed from: a  reason: collision with root package name */
    public final TimingInfo f15533a;

    public enum Field implements MetricType {
        AWSErrorCode,
        AWSRequestID,
        BytesProcessed,
        ClientExecuteTime,
        CredentialsRequestTime,
        Exception,
        HttpRequestTime,
        RedirectLocation,
        RequestMarshallTime,
        RequestSigningTime,
        ResponseProcessingTime,
        RequestCount,
        RetryCount,
        HttpClientRetryCount,
        HttpClientSendRequestTime,
        HttpClientReceiveResponseTime,
        RetryPauseTime,
        ServiceEndpoint,
        ServiceName,
        StatusCode
    }

    public AWSRequestMetrics() {
        this.f15533a = TimingInfo.m();
    }

    public void a(MetricType metricType, Object obj) {
    }

    public void b(MetricType metricType) {
    }

    public final TimingInfo c() {
        return this.f15533a;
    }

    public void d(MetricType metricType) {
    }

    public void e() {
    }

    public void f(MetricType metricType, long j11) {
    }

    public void g(MetricType metricType) {
    }

    public AWSRequestMetrics(TimingInfo timingInfo) {
        this.f15533a = timingInfo;
    }
}
