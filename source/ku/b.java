package ku;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huobi.vulcan.core.WorkHandler;
import com.huobi.vulcan.utils.ExceptionLogUtil;
import com.huobi.vulcan.utils.HexUtil;
import com.huobi.vulcan.utils.MD5Util;
import com.huobi.vulcan.utils.StringUtils;
import com.huobi.vulcan.utils.SystemUtils;
import java.util.UUID;
import java.util.regex.Pattern;

public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final String f22854g = "b";

    /* renamed from: a  reason: collision with root package name */
    public String f22855a;

    /* renamed from: b  reason: collision with root package name */
    public String f22856b;

    /* renamed from: c  reason: collision with root package name */
    public String f22857c;

    /* renamed from: d  reason: collision with root package name */
    public String f22858d;

    /* renamed from: e  reason: collision with root package name */
    public String f22859e;

    /* renamed from: f  reason: collision with root package name */
    public nu.a f22860f;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            c.q().x(0);
        }
    }

    /* renamed from: ku.b$b  reason: collision with other inner class name */
    public static class C0194b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f22862a = new b((a) null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b e() {
        return C0194b.f22862a;
    }

    public void a() {
        nu.a aVar = this.f22860f;
        aVar.f("key_error_log_err_uuid", "err_" + UUID.randomUUID().toString());
    }

    public void b(Context context) {
        if (context == null) {
            lu.a.c(f22854g, "getVToken context is null.");
            return;
        }
        if (TextUtils.isEmpty(c())) {
            a();
        }
        String d11 = this.f22860f.d("hb_vtoken", "");
        if (!StringUtils.d(d11)) {
            k(d11);
        }
        String l11 = SystemUtils.l(context);
        this.f22859e = l11;
        if (j(l11, this.f22855a)) {
            String b11 = SystemUtils.b(context);
            this.f22859e = b11;
            if (j(b11, this.f22856b)) {
                String p11 = SystemUtils.p();
                this.f22859e = p11;
                if (j(p11, this.f22857c)) {
                    String d12 = this.f22860f.d("hb_key_seed_uuid", "");
                    this.f22859e = d12;
                    if (TextUtils.isEmpty(d12)) {
                        String uuid = UUID.randomUUID().toString();
                        this.f22859e = uuid;
                        this.f22860f.f("hb_key_seed_uuid", uuid);
                    }
                    if (StringUtils.d(this.f22859e)) {
                        lu.a.c(f22854g, "The seed cannot be determined.");
                        ExceptionLogUtil.a("10002", "获取VToken失败");
                        return;
                    }
                }
            }
        }
        String str = Build.BRAND;
        this.f22858d = HexUtil.b(MD5Util.b(HexUtil.b(MD5Util.b(this.f22859e)) + HexUtil.b(MD5Util.b(str))));
        String str2 = f22854g;
        lu.a.b(str2, "genVToken(seed=" + this.f22859e + ", salt=" + str + ") =>" + this.f22858d);
        if (!StringUtils.d(this.f22858d)) {
            this.f22860f.f("hb_vtoken_EXT", this.f22858d + "||" + System.currentTimeMillis() + "||" + "1.3.1");
        }
        if (TextUtils.isEmpty(d11) || d11.equalsIgnoreCase(this.f22858d)) {
            this.f22860f.f("hb_vtoken", this.f22858d);
        } else {
            WorkHandler.d().f(new a());
        }
    }

    public String c() {
        return this.f22860f.d("key_error_log_err_uuid", "");
    }

    public String d() {
        return this.f22858d;
    }

    public String f() {
        return this.f22860f.d("hb_relate_vtoken", "");
    }

    public String g() {
        return this.f22860f.d("hb_key_seed_uuid", "");
    }

    public String h(Context context) {
        return this.f22860f.d("hb_vtoken", "");
    }

    public String i() {
        return this.f22860f.d("hb_vtenc", "");
    }

    public boolean j(String str, String str2) {
        if (StringUtils.d(str)) {
            return true;
        }
        if (StringUtils.d(str2)) {
            return false;
        }
        return Pattern.compile(str2, 2).matcher(str).matches();
    }

    public void k(String str) {
        this.f22860f.f("hb_relate_vtoken", str);
    }

    public void l(String str) {
        this.f22860f.f("hb_vtenc", str);
    }

    public void m(String str) {
        this.f22856b = str;
    }

    public void n(String str) {
        this.f22855a = str;
    }

    public void o(String str) {
        this.f22857c = str;
    }

    public void p(boolean z11) {
        if (z11) {
            this.f22860f.f("hb_vtoken", this.f22858d);
        } else {
            this.f22858d = this.f22860f.d("hb_vtoken", "");
        }
    }

    public b() {
        this.f22855a = "02:00:00:00:00:00|00:90:4C:11:22:33|\\w[26AE](:\\w\\w){5}";
        this.f22856b = "9774d56d682e549c|0000000000000000";
        this.f22857c = "";
        this.f22860f = nu.a.b(a.b(), "huobi_vulcan_security_store");
    }
}
