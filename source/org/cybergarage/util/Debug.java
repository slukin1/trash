package org.cybergarage.util;

import java.io.PrintStream;

public final class Debug {

    /* renamed from: b  reason: collision with root package name */
    public static Debug f59921b = new Debug();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f59922c = false;

    /* renamed from: a  reason: collision with root package name */
    public PrintStream f59923a = System.out;

    public static boolean b() {
        return f59922c;
    }

    public static final void c(String str) {
        if (f59922c) {
            PrintStream a11 = f59921b.a();
            a11.println("CyberGarage message : " + str);
        }
    }

    public static final void d(Exception exc) {
        e(exc.getMessage());
        exc.printStackTrace(f59921b.a());
    }

    public static final void e(String str) {
        PrintStream a11 = f59921b.a();
        a11.println("CyberGarage warning : " + str);
    }

    public static final void f(String str, Exception exc) {
        if (exc.getMessage() == null) {
            PrintStream a11 = f59921b.a();
            a11.println("CyberGarage warning : " + str + " START");
            exc.printStackTrace(f59921b.a());
            PrintStream a12 = f59921b.a();
            a12.println("CyberGarage warning : " + str + " END");
            return;
        }
        PrintStream a13 = f59921b.a();
        a13.println("CyberGarage warning : " + str + " (" + exc.getMessage() + ")");
        exc.printStackTrace(f59921b.a());
    }

    public synchronized PrintStream a() {
        return this.f59923a;
    }
}
