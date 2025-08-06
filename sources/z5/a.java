package z5;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.io.IOException;

public class a extends d {

    /* renamed from: c  reason: collision with root package name */
    public static ThreadLocal<byte[]> f66730c = new ThreadLocal<>();

    public a(y5.a aVar) {
        super(aVar);
    }

    public static byte[] c() {
        byte[] bArr = f66730c.get();
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[4];
        f66730c.set(bArr2);
        return bArr2;
    }

    public boolean d(String str) throws IOException {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return false;
        }
        int e11 = e();
        for (int i11 = 0; i11 < 4; i11++) {
            if (((e11 >> (i11 * 8)) & 255) != str.charAt(i11)) {
                return false;
            }
        }
        return true;
    }

    public int e() throws IOException {
        byte[] c11 = c();
        read(c11, 0, 4);
        return ((c11[3] & 255) << Ascii.CAN) | (c11[0] & 255) | ((c11[1] & 255) << 8) | ((c11[2] & 255) << 16);
    }

    public int f() throws IOException {
        byte[] c11 = c();
        read(c11, 0, 4);
        return ((c11[0] & 255) << Ascii.CAN) | (c11[3] & 255) | ((c11[2] & 255) << 8) | ((c11[1] & 255) << 16);
    }

    public short g() throws IOException {
        byte[] c11 = c();
        read(c11, 0, 2);
        return (short) (((c11[0] & 255) << 8) | (c11[1] & 255));
    }
}
