package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkInputStream;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class RepeatableFileInputStream extends SdkInputStream {

    /* renamed from: f  reason: collision with root package name */
    public static final Log f15173f = LogFactory.c("RepeatableFIS");

    /* renamed from: b  reason: collision with root package name */
    public final File f15174b;

    /* renamed from: c  reason: collision with root package name */
    public FileInputStream f15175c = null;

    /* renamed from: d  reason: collision with root package name */
    public long f15176d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f15177e = 0;

    public RepeatableFileInputStream(File file) throws FileNotFoundException {
        if (file != null) {
            this.f15175c = new FileInputStream(file);
            this.f15174b = file;
            return;
        }
        throw new IllegalArgumentException("File cannot be null");
    }

    public int available() throws IOException {
        e();
        return this.f15175c.available();
    }

    public void close() throws IOException {
        this.f15175c.close();
        e();
    }

    public InputStream f() {
        return this.f15175c;
    }

    public void mark(int i11) {
        e();
        this.f15177e += this.f15176d;
        this.f15176d = 0;
        Log log = f15173f;
        if (log.i()) {
            log.h("Input stream marked at " + this.f15177e + " bytes");
        }
    }

    public boolean markSupported() {
        return true;
    }

    public int read() throws IOException {
        e();
        int read = this.f15175c.read();
        if (read == -1) {
            return -1;
        }
        this.f15176d++;
        return read;
    }

    public void reset() throws IOException {
        this.f15175c.close();
        e();
        this.f15175c = new FileInputStream(this.f15174b);
        long j11 = this.f15177e;
        while (j11 > 0) {
            j11 -= this.f15175c.skip(j11);
        }
        Log log = f15173f;
        if (log.i()) {
            log.h("Reset to mark point " + this.f15177e + " after returning " + this.f15176d + " bytes");
        }
        this.f15176d = 0;
    }

    public long skip(long j11) throws IOException {
        e();
        long skip = this.f15175c.skip(j11);
        this.f15176d += skip;
        return skip;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        e();
        int read = this.f15175c.read(bArr, i11, i12);
        this.f15176d += (long) read;
        return read;
    }
}
