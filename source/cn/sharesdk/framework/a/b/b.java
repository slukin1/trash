package cn.sharesdk.framework.a.b;

import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.utils.Data;

public class b extends c {

    /* renamed from: m  reason: collision with root package name */
    private static int f13332m;

    /* renamed from: n  reason: collision with root package name */
    private static long f13333n;

    /* renamed from: a  reason: collision with root package name */
    public int f13334a;

    /* renamed from: b  reason: collision with root package name */
    public String f13335b;

    /* renamed from: c  reason: collision with root package name */
    public String f13336c;

    /* renamed from: d  reason: collision with root package name */
    public String f13337d;

    public String a() {
        return "[AUT]";
    }

    public void a(long j11) {
        f13333n = j11;
    }

    public int b() {
        return 5000;
    }

    public int c() {
        return 5;
    }

    public long d() {
        return (long) f13332m;
    }

    public long e() {
        return f13333n;
    }

    public void f() {
        f13332m++;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(super.toString());
        sb2.append('|');
        sb2.append(this.f13334a);
        sb2.append('|');
        sb2.append(this.f13335b);
        sb2.append('|');
        if (!TextUtils.isEmpty(this.f13337d)) {
            try {
                String encodeToString = Base64.encodeToString(Data.AES128Encode(this.f13339f.substring(0, 16), this.f13337d), 0);
                if (!TextUtils.isEmpty(encodeToString) && encodeToString.contains("\n")) {
                    encodeToString = encodeToString.replace("\n", "");
                }
                sb2.append(encodeToString);
            } catch (Throwable th2) {
                SSDKLog.b().a(th2);
            }
        }
        sb2.append('|');
        if (!TextUtils.isEmpty(this.f13345l)) {
            sb2.append(this.f13345l);
        }
        sb2.append('|');
        if (!TextUtils.isEmpty(this.f13336c)) {
            sb2.append(this.f13336c);
        }
        return sb2.toString();
    }
}
