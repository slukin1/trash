package com.amazonaws.metrics;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MetricFilterInputStream extends SdkFilterInputStream {

    /* renamed from: b  reason: collision with root package name */
    public final ByteThroughputHelper f14947b;

    public MetricFilterInputStream(ThroughputMetricType throughputMetricType, InputStream inputStream) {
        super(inputStream);
        this.f14947b = new ByteThroughputHelper(throughputMetricType);
    }

    public final boolean a() {
        return true;
    }

    public void close() throws IOException {
        this.f14947b.f();
        this.in.close();
        e();
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        e();
        long g11 = this.f14947b.g();
        int read = this.in.read(bArr, i11, i12);
        if (read > 0) {
            this.f14947b.d(read, g11);
        }
        return read;
    }
}
