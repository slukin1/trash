package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

class DecodedStreamBuffer {

    /* renamed from: f  reason: collision with root package name */
    public static final Log f14845f = LogFactory.b(DecodedStreamBuffer.class);

    /* renamed from: a  reason: collision with root package name */
    public byte[] f14846a;

    /* renamed from: b  reason: collision with root package name */
    public int f14847b;

    /* renamed from: c  reason: collision with root package name */
    public int f14848c;

    /* renamed from: d  reason: collision with root package name */
    public int f14849d = -1;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14850e;

    public DecodedStreamBuffer(int i11) {
        this.f14846a = new byte[i11];
        this.f14847b = i11;
    }

    public void a(byte[] bArr, int i11, int i12) {
        this.f14849d = -1;
        int i13 = this.f14848c;
        if (i13 + i12 > this.f14847b) {
            Log log = f14845f;
            if (log.i()) {
                log.h("Buffer size " + this.f14847b + " has been exceeded and the input stream will not be repeatable. Freeing buffer memory");
            }
            this.f14850e = true;
            return;
        }
        System.arraycopy(bArr, i11, this.f14846a, i13, i12);
        this.f14848c += i12;
    }

    public boolean b() {
        int i11 = this.f14849d;
        return i11 != -1 && i11 < this.f14848c;
    }

    public byte c() {
        byte[] bArr = this.f14846a;
        int i11 = this.f14849d;
        this.f14849d = i11 + 1;
        return bArr[i11];
    }

    public void d() {
        if (!this.f14850e) {
            this.f14849d = 0;
            return;
        }
        throw new AmazonClientException("The input stream is not repeatable since the buffer size " + this.f14847b + " has been exceeded.");
    }
}
