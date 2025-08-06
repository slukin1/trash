package qy;

import com.ta.a.a.b;

public class a {
    public static b a(String str) {
        b bVar = new b();
        if (str == null || str.length() != 24) {
            bVar.a(false);
        } else {
            try {
                byte[] a11 = vy.b.a(str, 2);
                if (a11.length == 18) {
                    byte[] bArr = new byte[4];
                    System.arraycopy(a11, 0, bArr, 0, 4);
                    byte b11 = a11[8];
                    try {
                        bVar.a(true);
                        bVar.d(uy.b.a(bArr));
                        bVar.e(b11);
                        return bVar;
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                bVar.a(false);
                return bVar;
            }
        }
        return bVar;
    }
}
