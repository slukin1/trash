package com.mob.mgs.impl;

import com.mob.MobSDK;
import com.mob.commons.CSCenter;
import com.mob.mcl.b.a;
import com.mob.tools.utils.DH;

public class b {
    public static void a() {
        if (CSCenter.getInstance().isAppListDataEnable()) {
            new h() {
                public void a() throws Throwable {
                    boolean isInMainProcess = DH.SyncMtd.isInMainProcess();
                    e a11 = e.a();
                    a11.a("mgs init, main p: " + isInMainProcess);
                    if (isInMainProcess && !MobSDK.isForb()) {
                        f.a().b();
                        c.a().b();
                    }
                }
            }.start();
        }
    }

    public static boolean b() {
        Boolean c11 = c();
        if (c11 == null) {
            c11 = Boolean.TRUE;
        }
        return c11.booleanValue();
    }

    private static Boolean c() {
        Boolean a11 = i.a();
        Boolean b11 = i.b();
        if (a11 != null && (b11 == null || a11 != b11)) {
            a(a11.booleanValue(), false);
        }
        return a11;
    }

    public static void a(final boolean z11, final boolean z12) {
        new h() {
            public void a() throws Throwable {
                d.a(z11, z12);
                i.b(z11);
                String f11 = f.a().f();
                String a11 = a.a();
                e a12 = e.a();
                a12.a("[setDS] save buff DId: " + f11 + ", GId: " + a11);
                i.a(f11);
                i.b(a11);
            }
        }.start();
    }

    public static void a(final boolean z11) {
        new h() {
            public void a() throws Throwable {
                Boolean b11 = i.b();
                if (b11 == null) {
                    b.a(z11, false);
                    return;
                }
                String f11 = f.a().f();
                String c11 = i.c();
                String a11 = a.a();
                String d11 = i.d();
                e a12 = e.a();
                a12.a("[setDS] currDId: " + f11 + ", buffDId: " + c11);
                e a13 = e.a();
                a13.a("[setDS] currGId: " + a11 + ", buffGId: " + d11);
                if (!c11.equals(f11) || !d11.equals(a11)) {
                    b.a(z11, true);
                }
                if (z11 != b11.booleanValue()) {
                    b.a(z11, false);
                }
            }
        }.start();
        i.a(z11);
    }
}
