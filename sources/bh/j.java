package bh;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.huobi.app.HuobiApplicationUtil;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static Application f40754a;

    public static void a(Context context, Application application) {
        f40754a = application;
        HuobiApplicationUtil.C(context, application);
    }

    public static int b(int i11) {
        Context applicationContext;
        if (c() == null || (applicationContext = c().getApplicationContext()) == null) {
            return 0;
        }
        return ContextCompat.getColor(applicationContext, i11);
    }

    public static Application c() {
        return f40754a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = c().getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d(int r1) {
        /*
            android.app.Application r0 = c()
            if (r0 == 0) goto L_0x0015
            android.app.Application r0 = c()
            android.content.Context r0 = r0.getApplicationContext()
            if (r0 == 0) goto L_0x0015
            java.lang.String r1 = r0.getString(r1)
            return r1
        L_0x0015:
            java.lang.String r1 = ""
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bh.j.d(int):java.lang.String");
    }

    public static void e(Configuration configuration) {
        if (HuobiApplicationUtil.r("pro.huobi", f40754a)) {
            AppLanguageHelper.getInstance().changeAppLanguage(f40754a, AppLanguageHelper.getInstance().getCurAppLocale());
        }
    }

    public static void f() {
        HuobiApplicationUtil.D(f40754a);
    }
}
