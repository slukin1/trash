package q2;

import android.content.Context;
import com.alibaba.sdk.android.httpdns.e.a;
import com.alibaba.sdk.android.httpdns.log.HttpDnsLog;
import java.util.HashMap;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public b f16397a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, m2.c> f16398b;

    /* renamed from: c  reason: collision with root package name */
    public a f16399c = new a();

    public c(b bVar) {
        this.f16397a = bVar;
        this.f16398b = new HashMap<>();
    }

    public m2.c a(Context context, String str, String str2) {
        String str3;
        if (context == null) {
            str3 = "init httpdns with null context!!";
        } else if (str == null || str.equals("")) {
            str3 = "init httpdns with emtpy account!!";
        } else {
            m2.c cVar = this.f16398b.get(str);
            if (cVar == null) {
                m2.c a11 = this.f16397a.a(context, str, str2);
                this.f16398b.put(str, a11);
                return a11;
            } else if (!(cVar instanceof d)) {
                return cVar;
            } else {
                ((d) cVar).n(str2);
                return cVar;
            }
        }
        HttpDnsLog.c(str3);
        return this.f16399c;
    }
}
