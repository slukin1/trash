package com.hbg.lib.common.utils;

import c6.a;
import i6.q;

public class AppUtil {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f67479a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f67480b;

    /* renamed from: c  reason: collision with root package name */
    public static q f67481c;

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal<StringBuilder> f67482d = new ThreadLocal<>();

    public static void a(a aVar) {
        q qVar = f67481c;
        if (qVar != null) {
            qVar.h(aVar);
        }
    }

    public static String b(Object... objArr) {
        if (!(objArr == null || objArr.length == 0)) {
            try {
                StringBuilder c11 = c();
                c11.setLength(0);
                for (Object append : objArr) {
                    c11.append(append);
                }
                String sb2 = c11.toString();
                c11.setLength(0);
                return sb2;
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return "";
    }

    public static StringBuilder c() {
        ThreadLocal<StringBuilder> threadLocal = f67482d;
        StringBuilder sb2 = threadLocal.get();
        if (sb2 == null) {
            sb2 = new StringBuilder();
            threadLocal.set(sb2);
        }
        sb2.setLength(0);
        return sb2;
    }

    public static void d() {
        if (f67481c == null) {
            q qVar = new q("HBTimeThread");
            f67481c = qVar;
            qVar.start();
        }
    }

    public static boolean e() {
        return f67480b;
    }

    public static void f() {
        if (!f67479a) {
            f67479a = true;
            boolean l11 = SP.l("SP_KEY_APP_FIRST_INIT", true);
            f67480b = l11;
            if (l11) {
                SP.y("SP_KEY_APP_FIRST_INIT", false);
            }
        }
    }
}
