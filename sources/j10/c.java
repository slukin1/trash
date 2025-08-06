package j10;

import com.google.common.base.Ascii;
import net.lingala.zip4j.crypto.engine.ZipCryptoEngine;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public FileHeader f55871a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f55872b = new byte[4];

    /* renamed from: c  reason: collision with root package name */
    public ZipCryptoEngine f55873c;

    public c(FileHeader fileHeader, byte[] bArr) throws ZipException {
        if (fileHeader != null) {
            this.f55871a = fileHeader;
            this.f55873c = new ZipCryptoEngine();
            b(bArr);
            return;
        }
        throw new ZipException("one of more of the input parameters were null in StandardDecryptor");
    }

    public int a(byte[] bArr, int i11, int i12) throws ZipException {
        if (i11 < 0 || i12 < 0) {
            throw new ZipException("one of the input parameters were null in standard decrpyt data");
        }
        int i13 = i11;
        while (i13 < i11 + i12) {
            try {
                byte b11 = (byte) (((bArr[i13] & 255) ^ this.f55873c.b()) & 255);
                this.f55873c.d(b11);
                bArr[i13] = b11;
                i13++;
            } catch (Exception e11) {
                throw new ZipException((Throwable) e11);
            }
        }
        return i12;
    }

    public void b(byte[] bArr) throws ZipException {
        byte[] e11 = this.f55871a.e();
        byte[] bArr2 = this.f55872b;
        bArr2[3] = (byte) (e11[3] & 255);
        bArr2[2] = (byte) ((e11[3] >> 8) & 255);
        bArr2[1] = (byte) ((e11[3] >> 16) & 255);
        int i11 = 0;
        bArr2[0] = (byte) ((e11[3] >> Ascii.CAN) & 255);
        if (bArr2[2] > 0 || bArr2[1] > 0 || bArr2[0] > 0) {
            throw new IllegalStateException("Invalid CRC in File Header");
        } else if (this.f55871a.n() == null || this.f55871a.n().length <= 0) {
            throw new ZipException("Wrong password!", 5);
        } else {
            this.f55873c.c(this.f55871a.n());
            try {
                byte b11 = bArr[0];
                while (i11 < 12) {
                    ZipCryptoEngine zipCryptoEngine = this.f55873c;
                    zipCryptoEngine.d((byte) (zipCryptoEngine.b() ^ b11));
                    i11++;
                    if (i11 != 12) {
                        b11 = bArr[i11];
                    }
                }
            } catch (Exception e12) {
                throw new ZipException((Throwable) e12);
            }
        }
    }
}
