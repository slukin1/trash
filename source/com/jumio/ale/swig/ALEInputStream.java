package com.jumio.ale.swig;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ALEInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public final ALERequest f38895a = null;

    /* renamed from: b  reason: collision with root package name */
    public final InputStream f38896b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f38897c = new byte[512];

    /* renamed from: d  reason: collision with root package name */
    public boolean f38898d = false;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f38899e;

    /* renamed from: f  reason: collision with root package name */
    public int f38900f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f38901g = 0;

    public ALEInputStream(InputStream inputStream, ALERequest aLERequest) {
        super(inputStream);
        this.f38896b = inputStream;
        this.f38895a = aLERequest;
        aLERequest.initResponse();
    }

    public int available() throws IOException {
        return this.f38901g - this.f38900f;
    }

    public void close() throws IOException {
        this.f38896b.close();
        try {
            if (!this.f38898d) {
                this.f38895a.finishResponse();
            }
            this.f38900f = 0;
            this.f38901g = 0;
        } catch (Exception e11) {
            throw new IOException(e11);
        }
    }

    public boolean markSupported() {
        return false;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public long skip(long j11) throws IOException {
        int i11 = this.f38901g;
        int i12 = this.f38900f;
        long j12 = (long) (i11 - i12);
        if (j11 > j12) {
            j11 = j12;
        }
        if (j11 < 0) {
            return 0;
        }
        this.f38900f = (int) (((long) i12) + j11);
        return j11;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        if (this.f38900f >= this.f38901g) {
            int i14 = 0;
            while (i14 == 0) {
                if (this.f38898d) {
                    i14 = -1;
                } else {
                    i14 = this.f38896b.read(this.f38897c);
                    if (i14 == -1) {
                        this.f38898d = true;
                        try {
                            this.f38895a.finishResponse();
                        } catch (Exception e11) {
                            throw new IOException(e11);
                        }
                    } else {
                        try {
                            byte[] bArr2 = this.f38897c;
                            if (i14 != bArr2.length) {
                                byte[] bArr3 = new byte[i14];
                                System.arraycopy(bArr2, 0, bArr3, 0, i14);
                                byte[] bArr4 = new byte[(i14 + 32)];
                                this.f38899e = bArr4;
                                i13 = this.f38895a.updateResponse(bArr3, bArr4);
                            } else {
                                byte[] bArr5 = new byte[(bArr2.length + 32)];
                                this.f38899e = bArr5;
                                i13 = this.f38895a.updateResponse(bArr2, bArr5);
                            }
                            this.f38900f = 0;
                            if (this.f38899e == null) {
                                this.f38901g = 0;
                            } else {
                                this.f38901g = i13;
                            }
                            i14 = this.f38901g;
                        } catch (Exception e12) {
                            this.f38899e = null;
                            throw new IOException(e12);
                        }
                    }
                }
            }
            if (i14 == -1) {
                return -1;
            }
        }
        if (i12 <= 0) {
            return 0;
        }
        int i15 = this.f38901g;
        int i16 = this.f38900f;
        int i17 = i15 - i16;
        if (i12 >= i17) {
            i12 = i17;
        }
        if (bArr != null) {
            System.arraycopy(this.f38899e, i16, bArr, i11, i12);
        }
        this.f38900f += i12;
        return i12;
    }
}
