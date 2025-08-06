package com.alibaba.fastjson.asm;

public class ByteVector {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f14148a;

    /* renamed from: b  reason: collision with root package name */
    public int f14149b;

    public ByteVector() {
        this.f14148a = new byte[64];
    }

    public final void a(int i11) {
        byte[] bArr = this.f14148a;
        int length = bArr.length * 2;
        int i12 = this.f14149b;
        int i13 = i11 + i12;
        if (length <= i13) {
            length = i13;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i12);
        this.f14148a = bArr2;
    }

    public ByteVector b(int i11, int i12) {
        int i13 = this.f14149b;
        if (i13 + 2 > this.f14148a.length) {
            a(2);
        }
        byte[] bArr = this.f14148a;
        int i14 = i13 + 1;
        bArr[i13] = (byte) i11;
        bArr[i14] = (byte) i12;
        this.f14149b = i14 + 1;
        return this;
    }

    public ByteVector c(int i11, int i12) {
        int i13 = this.f14149b;
        if (i13 + 3 > this.f14148a.length) {
            a(3);
        }
        byte[] bArr = this.f14148a;
        int i14 = i13 + 1;
        bArr[i13] = (byte) i11;
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i12 >>> 8);
        bArr[i15] = (byte) i12;
        this.f14149b = i15 + 1;
        return this;
    }

    public ByteVector d(int i11) {
        int i12 = this.f14149b;
        int i13 = i12 + 1;
        if (i13 > this.f14148a.length) {
            a(1);
        }
        this.f14148a[i12] = (byte) i11;
        this.f14149b = i13;
        return this;
    }

    public ByteVector e(byte[] bArr, int i11, int i12) {
        if (this.f14149b + i12 > this.f14148a.length) {
            a(i12);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i11, this.f14148a, this.f14149b, i12);
        }
        this.f14149b += i12;
        return this;
    }

    public ByteVector f(int i11) {
        int i12 = this.f14149b;
        if (i12 + 4 > this.f14148a.length) {
            a(4);
        }
        byte[] bArr = this.f14148a;
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i11 >>> 24);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (i11 >>> 16);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i11 >>> 8);
        bArr[i15] = (byte) i11;
        this.f14149b = i15 + 1;
        return this;
    }

    public ByteVector g(int i11) {
        int i12 = this.f14149b;
        if (i12 + 2 > this.f14148a.length) {
            a(2);
        }
        byte[] bArr = this.f14148a;
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i11 >>> 8);
        bArr[i13] = (byte) i11;
        this.f14149b = i13 + 1;
        return this;
    }

    public ByteVector h(String str) {
        int length = str.length();
        int i11 = this.f14149b;
        if (i11 + 2 + length > this.f14148a.length) {
            a(length + 2);
        }
        byte[] bArr = this.f14148a;
        int i12 = i11 + 1;
        bArr[i11] = (byte) (length >>> 8);
        int i13 = i12 + 1;
        bArr[i12] = (byte) length;
        int i14 = 0;
        while (i14 < length) {
            char charAt = str.charAt(i14);
            if (charAt < 1 || charAt > 127) {
                throw new UnsupportedOperationException();
            }
            bArr[i13] = (byte) charAt;
            i14++;
            i13++;
        }
        this.f14149b = i13;
        return this;
    }

    public ByteVector(int i11) {
        this.f14148a = new byte[i11];
    }
}
