package com.amazonaws.services.s3.model;

import com.amazonaws.internal.MetricAware;
import com.amazonaws.internal.SdkFilterInputStream;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.MetricFilterInputStream;
import com.amazonaws.services.s3.metrics.S3ServiceMetric;
import java.io.IOException;
import java.io.InputStream;

public class S3ObjectInputStream extends SdkFilterInputStream {

    /* renamed from: b  reason: collision with root package name */
    public boolean f15329b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public S3ObjectInputStream(InputStream inputStream) {
        super(g(inputStream) ? new MetricFilterInputStream(S3ServiceMetric.f15198c, inputStream) : inputStream);
    }

    public static boolean g(InputStream inputStream) {
        if (!AwsSdkMetrics.isMetricsEnabled()) {
            return false;
        }
        if (inputStream instanceof MetricAware) {
            return !((MetricAware) inputStream).a();
        }
        return true;
    }

    public int available() throws IOException {
        int available = super.available();
        if (available == 0) {
            return 1;
        }
        return available;
    }

    public void b() {
        f();
    }

    public final void f() {
        try {
            close();
        } catch (IOException e11) {
            LogFactory.b(getClass()).d("FYI", e11);
        }
    }

    public int read() throws IOException {
        int read = super.read();
        if (read == -1) {
            this.f15329b = true;
        }
        return read;
    }

    public void reset() throws IOException {
        super.reset();
        this.f15329b = false;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int read = super.read(bArr, i11, i12);
        if (read == -1) {
            this.f15329b = true;
        }
        return read;
    }
}
