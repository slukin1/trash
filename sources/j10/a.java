package j10;

import java.util.Arrays;
import net.lingala.zip4j.crypto.PBKDF2.PBKDF2Engine;
import net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.util.Raw;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public LocalFileHeader f55856a;

    /* renamed from: b  reason: collision with root package name */
    public l10.a f55857b;

    /* renamed from: c  reason: collision with root package name */
    public k10.a f55858c;

    /* renamed from: d  reason: collision with root package name */
    public final int f55859d = 2;

    /* renamed from: e  reason: collision with root package name */
    public int f55860e;

    /* renamed from: f  reason: collision with root package name */
    public int f55861f;

    /* renamed from: g  reason: collision with root package name */
    public int f55862g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f55863h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f55864i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f55865j;

    /* renamed from: k  reason: collision with root package name */
    public byte[] f55866k;

    /* renamed from: l  reason: collision with root package name */
    public int f55867l = 1;

    /* renamed from: m  reason: collision with root package name */
    public byte[] f55868m;

    /* renamed from: n  reason: collision with root package name */
    public byte[] f55869n;

    /* renamed from: o  reason: collision with root package name */
    public int f55870o = 0;

    public a(LocalFileHeader localFileHeader, byte[] bArr, byte[] bArr2) throws ZipException {
        if (localFileHeader != null) {
            this.f55856a = localFileHeader;
            this.f55866k = null;
            this.f55868m = new byte[16];
            this.f55869n = new byte[16];
            g(bArr, bArr2);
            return;
        }
        throw new ZipException("one of the input parameters is null in AESDecryptor Constructor");
    }

    public int a(byte[] bArr, int i11, int i12) throws ZipException {
        if (this.f55857b != null) {
            int i13 = i11;
            while (true) {
                int i14 = i11 + i12;
                if (i13 >= i14) {
                    return i12;
                }
                int i15 = i13 + 16;
                int i16 = i15 <= i14 ? 16 : i14 - i13;
                try {
                    this.f55870o = i16;
                    this.f55858c.d(bArr, i13, i16);
                    Raw.b(this.f55868m, this.f55867l, 16);
                    this.f55857b.e(this.f55868m, this.f55869n);
                    for (int i17 = 0; i17 < this.f55870o; i17++) {
                        int i18 = i13 + i17;
                        bArr[i18] = (byte) (bArr[i18] ^ this.f55869n[i17]);
                    }
                    this.f55867l++;
                    i13 = i15;
                } catch (ZipException e11) {
                    throw e11;
                } catch (Exception e12) {
                    throw new ZipException((Throwable) e12);
                }
            }
        } else {
            throw new ZipException("AES not initialized properly");
        }
    }

    public final byte[] b(byte[] bArr, char[] cArr) throws ZipException {
        try {
            return new PBKDF2Engine(new PBKDF2Parameters("HmacSHA1", "ISO-8859-1", bArr, 1000)).f(cArr, this.f55860e + this.f55861f + 2);
        } catch (Exception e11) {
            throw new ZipException((Throwable) e11);
        }
    }

    public byte[] c() {
        return this.f55858c.c();
    }

    public int d() {
        return 2;
    }

    public int e() {
        return this.f55862g;
    }

    public byte[] f() {
        return this.f55866k;
    }

    public final void g(byte[] bArr, byte[] bArr2) throws ZipException {
        LocalFileHeader localFileHeader = this.f55856a;
        if (localFileHeader != null) {
            AESExtraDataRecord a11 = localFileHeader.a();
            if (a11 != null) {
                int a12 = a11.a();
                if (a12 == 1) {
                    this.f55860e = 16;
                    this.f55861f = 16;
                    this.f55862g = 8;
                } else if (a12 == 2) {
                    this.f55860e = 24;
                    this.f55861f = 24;
                    this.f55862g = 12;
                } else if (a12 == 3) {
                    this.f55860e = 32;
                    this.f55861f = 32;
                    this.f55862g = 16;
                } else {
                    throw new ZipException("invalid aes key strength for file: " + this.f55856a.h());
                }
                if (this.f55856a.j() == null || this.f55856a.j().length <= 0) {
                    throw new ZipException("empty or null password provided for AES Decryptor");
                }
                byte[] b11 = b(bArr, this.f55856a.j());
                if (b11 != null) {
                    int length = b11.length;
                    int i11 = this.f55860e;
                    int i12 = this.f55861f;
                    if (length == i11 + i12 + 2) {
                        byte[] bArr3 = new byte[i11];
                        this.f55863h = bArr3;
                        this.f55864i = new byte[i12];
                        this.f55865j = new byte[2];
                        System.arraycopy(b11, 0, bArr3, 0, i11);
                        System.arraycopy(b11, this.f55860e, this.f55864i, 0, this.f55861f);
                        System.arraycopy(b11, this.f55860e + this.f55861f, this.f55865j, 0, 2);
                        byte[] bArr4 = this.f55865j;
                        if (bArr4 == null) {
                            throw new ZipException("invalid derived password verifier for AES");
                        } else if (Arrays.equals(bArr2, bArr4)) {
                            this.f55857b = new l10.a(this.f55863h);
                            k10.a aVar = new k10.a("HmacSHA1");
                            this.f55858c = aVar;
                            aVar.init(this.f55864i);
                            return;
                        } else {
                            throw new ZipException("Wrong Password for file: " + this.f55856a.h(), 5);
                        }
                    }
                }
                throw new ZipException("invalid derived key");
            }
            throw new ZipException("invalid aes extra data record - in init method of AESDecryptor");
        }
        throw new ZipException("invalid file header in init method of AESDecryptor");
    }

    public void h(byte[] bArr) {
        this.f55866k = bArr;
    }
}
