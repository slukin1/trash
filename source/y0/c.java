package y0;

import android.util.Base64;
import androidx.core.util.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f16793a;

    /* renamed from: b  reason: collision with root package name */
    public final String f16794b;

    /* renamed from: c  reason: collision with root package name */
    public final String f16795c;

    /* renamed from: d  reason: collision with root package name */
    public final List<List<byte[]>> f16796d;

    /* renamed from: e  reason: collision with root package name */
    public final int f16797e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final String f16798f;

    public c(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f16793a = (String) h.g(str);
        this.f16794b = (String) h.g(str2);
        this.f16795c = (String) h.g(str3);
        this.f16796d = (List) h.g(list);
        this.f16798f = a(str, str2, str3);
    }

    public final String a(String str, String str2, String str3) {
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3;
    }

    public List<List<byte[]>> b() {
        return this.f16796d;
    }

    public int c() {
        return this.f16797e;
    }

    public String d() {
        return this.f16798f;
    }

    public String e() {
        return this.f16793a;
    }

    public String f() {
        return this.f16794b;
    }

    public String g() {
        return this.f16795c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f16793a + ", mProviderPackage: " + this.f16794b + ", mQuery: " + this.f16795c + ", mCertificates:");
        for (int i11 = 0; i11 < this.f16796d.size(); i11++) {
            sb2.append(" [");
            List list = this.f16796d.get(i11);
            for (int i12 = 0; i12 < list.size(); i12++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString((byte[]) list.get(i12), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
        }
        sb2.append("}");
        sb2.append("mCertificatesArray: " + this.f16797e);
        return sb2.toString();
    }
}
