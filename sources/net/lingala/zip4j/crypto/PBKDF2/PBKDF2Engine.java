package net.lingala.zip4j.crypto.PBKDF2;

import java.util.Objects;
import k10.a;
import k10.b;
import net.lingala.zip4j.util.Raw;

public class PBKDF2Engine {

    /* renamed from: a  reason: collision with root package name */
    public PBKDF2Parameters f58322a;

    /* renamed from: b  reason: collision with root package name */
    public b f58323b;

    public PBKDF2Engine() {
        this.f58322a = null;
        this.f58323b = null;
    }

    public void a(byte[] bArr, int i11, int i12) {
        bArr[i11 + 0] = (byte) (i12 / 16777216);
        bArr[i11 + 1] = (byte) (i12 / 65536);
        bArr[i11 + 2] = (byte) (i12 / 256);
        bArr[i11 + 3] = (byte) i12;
    }

    public byte[] b(b bVar, byte[] bArr, int i11, int i12) {
        int i13 = i12;
        byte[] bArr2 = bArr == null ? new byte[0] : bArr;
        int a11 = bVar.a();
        int e11 = e(i13, a11);
        int i14 = i13 - ((e11 - 1) * a11);
        byte[] bArr3 = new byte[(e11 * a11)];
        int i15 = 0;
        for (int i16 = 1; i16 <= e11; i16++) {
            c(bArr3, i15, bVar, bArr2, i11, i16);
            i15 += a11;
        }
        if (i14 >= a11) {
            return bArr3;
        }
        byte[] bArr4 = new byte[i13];
        System.arraycopy(bArr3, 0, bArr4, 0, i13);
        return bArr4;
    }

    public void c(byte[] bArr, int i11, b bVar, byte[] bArr2, int i12, int i13) {
        int a11 = bVar.a();
        byte[] bArr3 = new byte[a11];
        byte[] bArr4 = new byte[(bArr2.length + 4)];
        System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
        a(bArr4, bArr2.length, i13);
        for (int i14 = 0; i14 < i12; i14++) {
            bArr4 = bVar.b(bArr4);
            g(bArr3, bArr4);
        }
        System.arraycopy(bArr3, 0, bArr, i11, a11);
    }

    public void d(byte[] bArr) {
        if (this.f58323b == null) {
            this.f58323b = new a(this.f58322a.a());
        }
        this.f58323b.init(bArr);
    }

    public int e(int i11, int i12) {
        return (i11 / i12) + (i11 % i12 > 0 ? 1 : 0);
    }

    public byte[] f(char[] cArr, int i11) {
        Objects.requireNonNull(cArr);
        d(Raw.a(cArr));
        if (i11 == 0) {
            i11 = this.f58323b.a();
        }
        return b(this.f58323b, this.f58322a.c(), this.f58322a.b(), i11);
    }

    public void g(byte[] bArr, byte[] bArr2) {
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
        }
    }

    public PBKDF2Engine(PBKDF2Parameters pBKDF2Parameters) {
        this.f58322a = pBKDF2Parameters;
        this.f58323b = null;
    }
}
