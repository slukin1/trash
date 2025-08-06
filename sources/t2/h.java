package t2;

import com.alibaba.sdk.android.httpdns.HttpDnsSettings;
import com.alibaba.sdk.android.httpdns.log.HttpDnsLog;
import t2.f;

public class h implements f.a {

    /* renamed from: e  reason: collision with root package name */
    public static int f16554e;

    /* renamed from: a  reason: collision with root package name */
    public String[] f16555a;

    /* renamed from: b  reason: collision with root package name */
    public String f16556b;

    /* renamed from: c  reason: collision with root package name */
    public String f16557c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f16558d = false;

    public h(String[] strArr) {
        this.f16555a = strArr;
    }

    public void a(c cVar, Throwable th2) {
        d(cVar, false);
    }

    public void b(c cVar) {
        String[] strArr;
        HttpDnsSettings.a a11 = HttpDnsSettings.a();
        if (a11 != null && a11.a() && (strArr = this.f16555a) != null && strArr.length > 0) {
            this.f16556b = cVar.d();
            this.f16558d = true;
            String[] strArr2 = this.f16555a;
            String str = strArr2[f16554e % strArr2.length];
            if (HttpDnsLog.f()) {
                HttpDnsLog.b("origin ip is " + this.f16556b + " change to " + str);
            }
            cVar.f("[" + str + "]");
            this.f16557c = str;
        }
    }

    public void c(c cVar, Object obj) {
        d(cVar, true);
    }

    public final void d(c cVar, boolean z11) {
        if (this.f16558d) {
            cVar.f(this.f16556b);
            this.f16558d = false;
            if (!z11) {
                String str = this.f16557c;
                String[] strArr = this.f16555a;
                if (str.equals(strArr[f16554e % strArr.length])) {
                    f16554e = (f16554e + 1) % this.f16555a.length;
                }
            }
        }
    }
}
