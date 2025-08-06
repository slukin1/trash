package com.mob.apc;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.mob.apc.a.f;
import com.mob.tools.utils.e;
import java.util.HashMap;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f26884a = false;

    /* renamed from: b  reason: collision with root package name */
    private static Context f26885b;

    public interface a {
        HashMap<String, Object> a(int i11, String str);

        boolean a(String str);
    }

    /* renamed from: com.mob.apc.b$b  reason: collision with other inner class name */
    public interface C0237b {
        a a(String str, a aVar, long j11);
    }

    public interface c {
        void a(Bundle bundle);
    }

    static {
        f.a().b("APC : 2021.11.07", new Object[0]);
    }

    public static void a(Context context) {
        f26885b = context.getApplicationContext();
    }

    public static Context a() {
        return f26885b;
    }

    public static void a(String str, C0237b bVar) {
        f26884a = true;
        com.mob.apc.a.c.a().a(str, bVar);
    }

    public static a a(int i11, String str, String str2, a aVar, long j11) throws Throwable {
        if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
            return com.mob.apc.a.c.a().a(i11, str, str2, aVar, j11);
        }
        f.a().b("[sendMessage] not allow main thread to invoke", new Object[0]);
        throw new APCException("not allow main thread to invoke");
    }

    public static void a(e<List<String>> eVar) {
        com.mob.apc.a.c.a().a(eVar);
    }

    public static void a(c cVar) {
        com.mob.apc.a.c.a().a(cVar);
    }

    public static void a(a aVar) {
        com.mob.apc.a.c.a().a(aVar);
    }
}
