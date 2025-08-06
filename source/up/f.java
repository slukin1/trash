package up;

import android.text.TextUtils;
import com.hbg.module.otc.OtcModuleConfig;
import com.huochat.community.network.domain.DomainTool;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f84911a;

    public static f b() {
        if (f84911a == null) {
            synchronized (f.class) {
                if (f84911a == null) {
                    f84911a = new f();
                }
            }
        }
        return f84911a;
    }

    public final String a() {
        String t11 = OtcModuleConfig.a().t();
        if (TextUtils.isEmpty(t11) || t11.startsWith("http")) {
            return t11;
        }
        return DomainTool.DOMAIN_PREFIX + t11;
    }

    public String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return String.format(a() + "/-/x/hb/p/api/contents/currency/icon_png/%s.png", new Object[]{str.toLowerCase()});
    }
}
