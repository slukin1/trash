package com.mob.mgs.impl;

import android.text.TextUtils;
import com.mob.commons.MobProduct;
import com.mob.commons.e;
import com.mob.tools.network.NetCommunicator;
import java.util.HashMap;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f27618a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f27619b = false;

    /* renamed from: c  reason: collision with root package name */
    private volatile String f27620c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f27621d = new byte[0];

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f27622e;

    /* renamed from: f  reason: collision with root package name */
    private volatile String f27623f;

    private f() {
    }

    public void b() {
        if (!this.f27619b) {
            new h() {
                public void a() throws Throwable {
                    e.a().a("MgsGlobal init: start");
                    f.this.f();
                    boolean unused = f.this.f27619b = true;
                    e.a().a("MgsGlobal init: done");
                }
            }.start();
        } else {
            e.a().a("MgsGlobal already initialized");
        }
    }

    public String c() {
        if (TextUtils.isEmpty(this.f27620c)) {
            e.a().b("WARNING: getDuidQuick got null!");
        }
        return this.f27620c;
    }

    public boolean d() {
        return this.f27622e;
    }

    public String e() {
        return this.f27623f;
    }

    public String f() {
        HashMap<String, Object> b11;
        if (TextUtils.isEmpty(this.f27620c)) {
            synchronized (this.f27621d) {
                if (TextUtils.isEmpty(this.f27620c) && (b11 = e.b((MobProduct) null)) != null) {
                    this.f27620c = (String) b11.get(NetCommunicator.KEY_DUID);
                    this.f27622e = ((Boolean) b11.get(NetCommunicator.KEY_IS_MODIFIED)).booleanValue();
                    this.f27623f = (String) b11.get(NetCommunicator.KEY_DUID_PREVIOUS);
                    e a11 = e.a();
                    a11.a("MC Global -> duid: " + this.f27620c + ", duidPre: " + this.f27623f + ", isModified: " + this.f27622e);
                }
            }
        }
        return this.f27620c;
    }

    public static f a() {
        if (f27618a == null) {
            synchronized (f.class) {
                if (f27618a == null) {
                    f27618a = new f();
                }
            }
        }
        return f27618a;
    }
}
