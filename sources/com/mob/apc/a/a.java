package com.mob.apc.a;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.mob.MobACService;
import com.mob.apc.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private MobACService f26853a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f26854b = false;

    /* renamed from: c  reason: collision with root package name */
    private final d f26855c;

    public a(MobACService mobACService) {
        this.f26853a = mobACService;
        this.f26855c = new d() {
            public e a(e eVar) throws RemoteException {
                com.mob.apc.a aVar;
                f a11 = f.a();
                a11.b("APC msg received. msg: " + eVar, new Object[0]);
                if (a.this.f26854b) {
                    f a12 = f.a();
                    a12.b("inited: " + b.f26884a, new Object[0]);
                    if (!b.f26884a) {
                        boolean unused = a.this.f26854b = false;
                        if (!(eVar == null || (aVar = eVar.f26878a) == null)) {
                            Bundle bundle = new Bundle();
                            int i11 = aVar.f26847a;
                            if (i11 == 1001) {
                                bundle.putInt("acsActType", 1);
                            } else if (i11 == 9004) {
                                bundle.putInt("acsActType", 2);
                            }
                            bundle.putString("pkg", eVar.f26880c);
                            c.a().a(bundle);
                        }
                    }
                }
                return c.a().a(eVar);
            }
        };
    }

    public void b() {
        this.f26854b = false;
    }

    public boolean b(Intent intent) {
        return this.f26853a.a(intent);
    }

    public void a() {
        try {
            this.f26854b = true;
            b.a(this.f26853a.getApplicationContext());
        } catch (Throwable th2) {
            f.a().a(th2);
        }
    }

    public int a(Intent intent, int i11, int i12) {
        return this.f26853a.a(intent, i11, i12);
    }

    public IBinder a(Intent intent) {
        return this.f26855c;
    }
}
