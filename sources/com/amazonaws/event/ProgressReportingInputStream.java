package com.amazonaws.event;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProgressReportingInputStream extends SdkFilterInputStream {

    /* renamed from: b  reason: collision with root package name */
    public int f14867b = 8192;

    /* renamed from: c  reason: collision with root package name */
    public final ProgressListenerCallbackExecutor f14868c;

    /* renamed from: d  reason: collision with root package name */
    public int f14869d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14870e;

    public ProgressReportingInputStream(InputStream inputStream, ProgressListenerCallbackExecutor progressListenerCallbackExecutor) {
        super(inputStream);
        this.f14868c = progressListenerCallbackExecutor;
    }

    public void close() throws IOException {
        int i11 = this.f14869d;
        if (i11 > 0) {
            this.f14868c.c(new ProgressEvent((long) i11));
            this.f14869d = 0;
        }
        super.close();
    }

    public final void f(int i11) {
        int i12 = this.f14869d + i11;
        this.f14869d = i12;
        if (i12 >= this.f14867b) {
            this.f14868c.c(new ProgressEvent((long) i12));
            this.f14869d = 0;
        }
    }

    public final void g() {
        if (this.f14870e) {
            ProgressEvent progressEvent = new ProgressEvent((long) this.f14869d);
            progressEvent.c(4);
            this.f14869d = 0;
            this.f14868c.c(progressEvent);
        }
    }

    public void j(boolean z11) {
        this.f14870e = z11;
    }

    public void k(int i11) {
        this.f14867b = i11 * 1024;
    }

    public int read() throws IOException {
        int read = super.read();
        if (read == -1) {
            g();
        } else {
            f(1);
        }
        return read;
    }

    public void reset() throws IOException {
        super.reset();
        ProgressEvent progressEvent = new ProgressEvent((long) this.f14869d);
        progressEvent.c(32);
        this.f14868c.c(progressEvent);
        this.f14869d = 0;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int read = super.read(bArr, i11, i12);
        if (read == -1) {
            g();
        }
        if (read != -1) {
            f(read);
        }
        return read;
    }
}
