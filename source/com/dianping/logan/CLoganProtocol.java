package com.dianping.logan;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class CLoganProtocol implements c {

    /* renamed from: e  reason: collision with root package name */
    public static CLoganProtocol f64816e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f64817f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f64818a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64819b;

    /* renamed from: c  reason: collision with root package name */
    public e f64820c;

    /* renamed from: d  reason: collision with root package name */
    public Set<Integer> f64821d = Collections.synchronizedSet(new HashSet());

    static {
        try {
            if (!Util.b("logan", CLoganProtocol.class)) {
                System.loadLibrary("logan");
            }
            f64817f = true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            f64817f = false;
        }
    }

    private native void clogan_debug(boolean z11);

    private native void clogan_flush();

    private native int clogan_init(String str, String str2, int i11, String str3, String str4);

    private native int clogan_open(String str);

    private native int clogan_write(int i11, String str, long j11, String str2, long j12, int i12);

    public static boolean g() {
        return f64817f;
    }

    public static CLoganProtocol i() {
        if (f64816e == null) {
            synchronized (CLoganProtocol.class) {
                if (f64816e == null) {
                    f64816e = new CLoganProtocol();
                }
            }
        }
        return f64816e;
    }

    public void a() {
        if (this.f64819b && f64817f) {
            try {
                clogan_flush();
            } catch (UnsatisfiedLinkError e11) {
                e11.printStackTrace();
            }
        }
    }

    public void b(String str, String str2, int i11, String str3, String str4) {
        if (!this.f64818a) {
            if (!f64817f) {
                h("logan_loadso", -5020);
                return;
            }
            try {
                int clogan_init = clogan_init(str, str2, i11, str3, str4);
                this.f64818a = true;
                h("clogan_init", clogan_init);
            } catch (UnsatisfiedLinkError e11) {
                e11.printStackTrace();
                h("clogan_init", -1060);
            }
        }
    }

    public void c(int i11, String str, long j11, String str2, long j12, boolean z11) {
        if (this.f64819b && f64817f) {
            try {
                int clogan_write = clogan_write(i11, str, j11, str2, j12, z11 ? 1 : 0);
                if (clogan_write != -4010 || Logan.f64824c) {
                    h("clogan_write", clogan_write);
                }
            } catch (UnsatisfiedLinkError e11) {
                e11.printStackTrace();
                h("clogan_write", -4060);
            }
        }
    }

    public void d(String str) {
        if (this.f64818a && f64817f) {
            try {
                int clogan_open = clogan_open(str);
                this.f64819b = true;
                h("clogan_open", clogan_open);
            } catch (UnsatisfiedLinkError e11) {
                e11.printStackTrace();
                h("clogan_open", -2070);
            }
        }
    }

    public void e(boolean z11) {
        if (this.f64818a && f64817f) {
            try {
                clogan_debug(z11);
            } catch (UnsatisfiedLinkError e11) {
                e11.printStackTrace();
            }
        }
    }

    public void f(e eVar) {
        this.f64820c = eVar;
    }

    public final void h(String str, int i11) {
        if (i11 < 0) {
            if ("clogan_write".endsWith(str) && i11 != -4060) {
                if (!this.f64821d.contains(Integer.valueOf(i11))) {
                    this.f64821d.add(Integer.valueOf(i11));
                } else {
                    return;
                }
            }
            e eVar = this.f64820c;
            if (eVar != null) {
                eVar.a(str, i11);
            }
        }
    }
}
