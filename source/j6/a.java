package j6;

import com.hbg.lib.common.utils.crypt.rsa.Base64Utils;
import com.hbg.lib.common.utils.crypt.rsa.RSAProvider;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f68200c;

    /* renamed from: a  reason: collision with root package name */
    public String f68201a;

    /* renamed from: b  reason: collision with root package name */
    public String f68202b;

    public static a b() {
        if (f68200c == null) {
            f68200c = new a();
        }
        return f68200c;
    }

    public byte[] a(byte[] bArr) throws Exception {
        String str = this.f68202b;
        if (str != null && !str.isEmpty()) {
            return RSAProvider.b(bArr, this.f68202b);
        }
        throw new IllegalArgumentException("PrivateKey is empty, you should invoke setRSAKey or generateKey");
    }

    public void c(String str, String str2, boolean z11) throws Exception {
        if (z11) {
            this.f68201a = str;
            this.f68202b = str2;
            return;
        }
        this.f68201a = Base64Utils.b(str.getBytes());
        this.f68202b = Base64Utils.b(str2.getBytes());
    }
}
