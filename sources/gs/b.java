package gs;

import android.content.Context;
import bh.j;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerLib;
import java.util.HashMap;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f84181a;

    /* renamed from: gs.b$b  reason: collision with other inner class name */
    public static final class C0865b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f84182a = new b();
    }

    public static b a() {
        return C0865b.f84182a;
    }

    public static void d(Context context, String str, Map<String, Object> map) {
        AppsFlyerLib.getInstance().logEvent(context, str, map);
    }

    public static void e(Context context, String str) {
        g(context, str);
        d(j.c(), AFInAppEventType.COMPLETE_REGISTRATION, new HashMap());
    }

    public static void f(Context context, String str) {
        g(context, str);
        d(j.c(), AFInAppEventType.LOGIN, new HashMap());
    }

    public static void g(Context context, String str) {
        if (str == null) {
            str = "";
        }
        if (a().b()) {
            AppsFlyerLib.getInstance().setCustomerIdAndLogSession(str, context);
            a().c(false);
            return;
        }
        AppsFlyerLib.getInstance().setCustomerUserId(str);
    }

    public boolean b() {
        return this.f84181a;
    }

    public void c(boolean z11) {
        this.f84181a = z11;
    }

    public b() {
        this.f84181a = false;
    }
}
