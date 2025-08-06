package com.amazonaws.services.s3.metrics;

import com.amazonaws.metrics.ServiceMetricType;
import com.amazonaws.metrics.SimpleMetricType;
import com.amazonaws.metrics.ThroughputMetricType;

public class S3ServiceMetric extends SimpleMetricType implements ServiceMetricType {

    /* renamed from: c  reason: collision with root package name */
    public static final S3ThroughputMetric f15198c;

    /* renamed from: d  reason: collision with root package name */
    public static final S3ServiceMetric f15199d;

    /* renamed from: e  reason: collision with root package name */
    public static final S3ThroughputMetric f15200e;

    /* renamed from: f  reason: collision with root package name */
    public static final S3ServiceMetric f15201f;

    /* renamed from: g  reason: collision with root package name */
    public static final S3ServiceMetric[] f15202g;

    /* renamed from: b  reason: collision with root package name */
    public final String f15203b;

    public static abstract class S3ThroughputMetric extends S3ServiceMetric implements ThroughputMetricType {
        public S3ThroughputMetric(String str) {
            super(str);
        }
    }

    static {
        AnonymousClass1 r02 = new S3ThroughputMetric(a("DownloadThroughput")) {
        };
        f15198c = r02;
        S3ServiceMetric s3ServiceMetric = new S3ServiceMetric(a("DownloadByteCount"));
        f15199d = s3ServiceMetric;
        AnonymousClass2 r22 = new S3ThroughputMetric(a("UploadThroughput")) {
        };
        f15200e = r22;
        S3ServiceMetric s3ServiceMetric2 = new S3ServiceMetric(a("UploadByteCount"));
        f15201f = s3ServiceMetric2;
        f15202g = new S3ServiceMetric[]{r02, s3ServiceMetric, r22, s3ServiceMetric2};
    }

    public static final String a(String str) {
        return "S3" + str;
    }

    public static S3ServiceMetric[] b() {
        return (S3ServiceMetric[]) f15202g.clone();
    }

    public String name() {
        return this.f15203b;
    }

    public S3ServiceMetric(String str) {
        this.f15203b = str;
    }
}
