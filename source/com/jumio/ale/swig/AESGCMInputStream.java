package com.jumio.ale.swig;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class AESGCMInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f38889a;

    /* renamed from: b  reason: collision with root package name */
    public final AESGCM f38890b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f38891c = new byte[0];

    /* renamed from: d  reason: collision with root package name */
    public boolean f38892d;

    public AESGCMInputStream(InputStream inputStream, byte[] bArr, byte[] bArr2) {
        super(inputStream);
        this.f38889a = inputStream;
        AESGCM aesgcm = new AESGCM();
        this.f38890b = aesgcm;
        aesgcm.setKey(bArr);
        aesgcm.setIV(bArr2);
        aesgcm.setMode(0);
        aesgcm.init();
    }

    public int available() throws IOException {
        return this.f38889a.available();
    }

    public void close() throws IOException {
        this.f38889a.close();
    }

    public boolean markSupported() {
        return false;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public long skip(long j11) throws IOException {
        return this.f38889a.skip(j11);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = i12 - i11;
        if (this.f38891c.length < i13) {
            this.f38891c = new byte[i13];
        }
        int read = this.f38889a.read(this.f38891c, 0, i13);
        if (read != -1) {
            return this.f38890b.update(this.f38891c, read, bArr, i11);
        }
        if (this.f38892d) {
            return -1;
        }
        this.f38892d = true;
        return this.f38890b.finish(bArr, i11);
    }
}
