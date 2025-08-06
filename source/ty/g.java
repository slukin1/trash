package ty;

import android.content.Context;
import android.text.TextUtils;
import com.ta.a.d.a;
import com.ta.a.e.h;
import sy.b;
import uy.f;

public class g implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f40591c = false;

    /* renamed from: b  reason: collision with root package name */
    public Context f40592b = null;

    public g(Context context) {
        this.f40592b = context;
    }

    public final void a() {
        h.i();
        if (f.a(this.f40592b) && !f40591c) {
            f40591c = true;
            try {
                c();
            } catch (Throwable unused) {
            }
            f40591c = false;
        }
    }

    public final boolean b(String str) {
        a a11 = a.a("https://mpush-api.aliyun.com/v2.0/a/audid/req/", str, true);
        if (a11 == null) {
            return false;
        }
        return com.ta.utdid2.device.f.a(a11);
    }

    public final void c() {
        h.i();
        String d11 = d();
        if (TextUtils.isEmpty(d11)) {
            h.e("postData is empty", new Object[0]);
        } else if (b(d11)) {
            h.e("", "upload success");
        } else {
            h.e("", "upload fail");
        }
    }

    public final String d() {
        String r11 = com.ta.utdid2.device.a.a().r();
        if (TextUtils.isEmpty(r11)) {
            return null;
        }
        String a11 = sy.a.a(r11);
        if (h.h()) {
            h.g("", a11);
        }
        return b.a(a11);
    }

    public void run() {
        try {
            a();
        } catch (Throwable th2) {
            h.d("", th2, new Object[0]);
        }
    }
}
