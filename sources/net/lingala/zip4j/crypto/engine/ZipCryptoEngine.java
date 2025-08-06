package net.lingala.zip4j.crypto.engine;

public class ZipCryptoEngine {

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f58329b = new int[256];

    /* renamed from: a  reason: collision with root package name */
    public final int[] f58330a = new int[3];

    static {
        for (int i11 = 0; i11 < 256; i11++) {
            int i12 = i11;
            for (int i13 = 0; i13 < 8; i13++) {
                i12 = (i12 & 1) == 1 ? (i12 >>> 1) ^ -306674912 : i12 >>> 1;
            }
            f58329b[i11] = i12;
        }
    }

    public final int a(int i11, byte b11) {
        return f58329b[(i11 ^ b11) & 255] ^ (i11 >>> 8);
    }

    public byte b() {
        int i11 = this.f58330a[2] | 2;
        return (byte) ((i11 * (i11 ^ 1)) >>> 8);
    }

    public void c(char[] cArr) {
        int[] iArr = this.f58330a;
        iArr[0] = 305419896;
        iArr[1] = 591751049;
        iArr[2] = 878082192;
        for (char c11 : cArr) {
            d((byte) (c11 & 255));
        }
    }

    public void d(byte b11) {
        int[] iArr = this.f58330a;
        iArr[0] = a(iArr[0], b11);
        int[] iArr2 = this.f58330a;
        iArr2[1] = iArr2[1] + (iArr2[0] & 255);
        iArr2[1] = (iArr2[1] * 134775813) + 1;
        iArr2[2] = a(iArr2[2], (byte) (iArr2[1] >> 24));
    }
}
