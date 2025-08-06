package ou;

import android.content.Context;
import com.alibaba.verificationsdk.BuildConfig;
import com.huobi.vulcan.utils.RootUtil;
import com.huobi.vulcan.utils.riskinfo.AntiDebug;
import com.huobi.vulcan.utils.riskinfo.AntiEmulator;
import com.huobi.vulcan.utils.riskinfo.AntiHook;
import com.huobi.vulcan.utils.riskinfo.AntiVirtualApk;
import com.huobi.vulcan.utils.riskinfo.CertUtils;
import com.huobi.vulcan.utils.riskinfo.DeviceInfoUtils;
import com.huobi.vulcan.utils.riskinfo.NetWorkUtils;
import com.huobi.vulcan.utils.riskinfo.PMUtils;
import com.huobi.vulcan.utils.riskinfo.RCUtils;
import com.huobi.vulcan.utils.riskinfo.SignUtils;
import com.sumsub.sentry.android.c;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public volatile JSONObject f23270a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f23271a = new a();
    }

    public static a d() {
        return b.f23271a;
    }

    public String a(Context context) {
        return SignUtils.b(context);
    }

    public String b(Context context) {
        return CertUtils.a();
    }

    public String c(Context context) {
        return DeviceInfoUtils.f().toString();
    }

    public String e(Context context) {
        return NetWorkUtils.d(context);
    }

    public String f() {
        if (iu.a.f().c() == null) {
            return "";
        }
        try {
            if (this.f23270a == null) {
                this.f23270a = new JSONObject();
                this.f23270a.put("virtual", n(iu.a.f().c()));
                this.f23270a.put("root", m(iu.a.f().c()));
                this.f23270a.put(c.f30264k, k(iu.a.f().c()));
                this.f23270a.put("riskapp", p(iu.a.f().c()));
                this.f23270a.put("sign", a(iu.a.f().c()));
                this.f23270a.put("cert", b(iu.a.f().c()));
            }
            this.f23270a.put(BuildConfig.BUILD_TYPE, i(iu.a.f().c()));
            this.f23270a.put("hook", l(iu.a.f().c()));
            this.f23270a.put("vpn", o(iu.a.f().c()));
            this.f23270a.put("proxy", q(iu.a.f().c()));
            this.f23270a.put("networktype", e(iu.a.f().c()));
            this.f23270a.put("adb", h(iu.a.f().c()));
            this.f23270a.put("development", j(iu.a.f().c()));
            this.f23270a.put("accessibility", g(iu.a.f().c()));
            this.f23270a.put("chinfo", c(iu.a.f().c()));
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return this.f23270a.toString();
    }

    public int g(Context context) {
        return RCUtils.c(context) ? 1 : 0;
    }

    public int h(Context context) {
        return RCUtils.d(context) ? 1 : 0;
    }

    public int i(Context context) {
        return AntiDebug.g(context) ? 1 : 0;
    }

    public int j(Context context) {
        return RCUtils.b(context) ? 1 : 0;
    }

    public int k(Context context) {
        return AntiEmulator.m(context) ? 1 : 0;
    }

    public int l(Context context) {
        return AntiHook.m(context) ? 1 : 0;
    }

    public int m(Context context) {
        return RootUtil.d() ? 1 : 0;
    }

    public int n(Context context) {
        return AntiVirtualApk.c(context) ? 1 : 0;
    }

    public int o(Context context) {
        return NetWorkUtils.e(context) ? 1 : 0;
    }

    public String p(Context context) {
        return PMUtils.c(context, (List<String>) null);
    }

    public String q(Context context) {
        return NetWorkUtils.f(context);
    }

    public a() {
    }
}
