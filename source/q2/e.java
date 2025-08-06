package q2;

import com.xiaomi.mipush.sdk.Constants;
import e7.s;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import w2.a;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f16414a;

    /* renamed from: b  reason: collision with root package name */
    public long f16415b = 0;

    public e(String str) {
        this.f16414a = str;
    }

    public HashMap<String, String> a(String str) {
        if (this.f16414a == null) {
            return null;
        }
        String l11 = Long.toString((System.currentTimeMillis() / 1000) + 600 + this.f16415b);
        try {
            String p11 = a.p(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f16414a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + l11);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("t", l11);
            hashMap.put(s.f70071a, p11);
            return hashMap;
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public void b(String str) {
        this.f16414a = str;
    }
}
