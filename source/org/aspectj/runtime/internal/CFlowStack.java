package org.aspectj.runtime.internal;

import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.ktx.BuildConfig;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl11;
import y10.b;
import y10.c;

public class CFlowStack {

    /* renamed from: b  reason: collision with root package name */
    public static c f58978b;

    /* renamed from: a  reason: collision with root package name */
    public b f58979a = f58978b.b();

    static {
        d();
    }

    public static String a(String str, String str2) {
        try {
            return System.getProperty(str, str2);
        } catch (SecurityException unused) {
            return str2;
        }
    }

    public static c b() {
        return new ThreadStackFactoryImpl();
    }

    public static c c() {
        return new ThreadStackFactoryImpl11();
    }

    public static void d() {
        String a11 = a("aspectj.runtime.cflowstack.usethreadlocal", BuildConfig.VERSION_NAME);
        boolean z11 = false;
        if (!a11.equals(BuildConfig.VERSION_NAME) ? a11.equals("yes") || a11.equals("true") : System.getProperty("java.class.version", IdManager.DEFAULT_VERSION_NAME).compareTo("46.0") >= 0) {
            z11 = true;
        }
        if (z11) {
            f58978b = b();
        } else {
            f58978b = c();
        }
    }
}
