package com.mob.apc.a;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.apc.APCException;
import com.mob.apc.a;
import com.mob.apc.b;
import com.mob.commons.j;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f26865a = new c();

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f26866i = {"com.mob.service.action.MOB_AC_SERVICE"};

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, b.C0237b> f26867b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private b f26868c = new b();

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, e> f26869d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private byte[] f26870e = new byte[0];

    /* renamed from: f  reason: collision with root package name */
    private b.c f26871f;

    /* renamed from: g  reason: collision with root package name */
    private Bundle f26872g;

    /* renamed from: h  reason: collision with root package name */
    private b.a f26873h;

    private c() {
    }

    public static c a() {
        return f26865a;
    }

    public b.a b() {
        return this.f26873h;
    }

    public void a(String str, b.C0237b bVar) {
        f.a().b("[addMobIpcMsgListener] %s", str);
        this.f26867b.put(str, bVar);
        synchronized (this.f26870e) {
            if (this.f26869d.containsKey(str)) {
                f.a().b("[addMobIpcMsgListener] %s", "buf msg found, callback right now");
                e remove = this.f26869d.remove(str);
                bVar.a(remove.f26880c, remove.f26878a, remove.f26882e);
            }
        }
    }

    public a a(int i11, String str, String str2, a aVar, long j11) throws Throwable {
        int i12 = i11;
        boolean b11 = j.a().b();
        f a11 = f.a();
        a11.a("[EC] isClear snd mg: " + b11, new Object[0]);
        if (!b11) {
            throw new APCException("ec is not clear");
        } else if (TextUtils.isEmpty(str)) {
            f.a().b("[sendMessage] pkg not allowed null.", new Object[0]);
            throw new APCException("pkg not allowed null.");
        } else if (aVar == null) {
            f.a().b("[sendMessage] param not allowed null.", new Object[0]);
            throw new APCException("param not allowed null.");
        } else if (i12 == 1) {
            return this.f26868c.a(str, str2, aVar, j11);
        } else {
            f a12 = f.a();
            a12.b("type " + i11 + " not support.", new Object[0]);
            throw new APCException("type " + i11 + " not support.");
        }
    }

    public void a(final e<List<String>> eVar) {
        final ArrayList arrayList = new ArrayList();
        try {
            boolean b11 = j.a().b();
            f a11 = f.a();
            a11.a("[EC] isClear apcsvcl: " + b11, new Object[0]);
            if (b11) {
                ReflectHelper.importClass("android.content.Intent");
                Object[] objArr = {f26866i[0]};
                DH.requester(MobSDK.getContext()).queryIntentServices((Intent) ReflectHelper.newInstance("Intent", objArr), 0).request(new DH.DHResponder() {
                    public void onResponse(DH.DHResponse dHResponse) {
                        List<ResolveInfo> queryIntentServices = dHResponse.queryIntentServices(new int[0]);
                        if (queryIntentServices != null) {
                            for (ResolveInfo next : queryIntentServices) {
                                ServiceInfo serviceInfo = next.serviceInfo;
                                String str = serviceInfo.packageName;
                                if (serviceInfo.exported && !b.a().getPackageName().equals(str)) {
                                    arrayList.add(next.serviceInfo.packageName);
                                }
                            }
                        }
                        f.a().b("[getMAPCServiceList] list: %s", arrayList);
                        e eVar = eVar;
                        if (eVar != null) {
                            eVar.a(arrayList);
                        }
                    }
                });
            } else if (eVar != null) {
                eVar.a(arrayList);
            }
        } catch (Throwable th2) {
            f.a().a(th2);
            if (eVar != null) {
                eVar.a(arrayList);
            }
        }
    }

    public e a(e eVar) {
        try {
            b.C0237b bVar = this.f26867b.get(eVar.f26879b);
            f.a().b("[onAIDLMessageReceive] innerMessage: %s, listener: %s", eVar, bVar);
            if (bVar != null) {
                a a11 = bVar.a(eVar.f26880c, eVar.f26878a, eVar.f26882e);
                f.a().b("[onAIDLMessageReceive] listener apcMessage: %s", a11);
                return new e(a11, eVar.f26879b, eVar.f26882e);
            }
            f.a().b("[onAIDLMessageReceive] No listener detected, buffer this msg", new Object[0]);
            this.f26869d.put(eVar.f26879b, eVar);
            return null;
        } catch (Throwable th2) {
            f.a().b("[onAIDLMessageReceive] exception %s", th2.getMessage());
            f.a().a(th2);
            return null;
        }
    }

    public void a(b.c cVar) {
        f.a().b("[addOnACServiceListener] %s", "done");
        this.f26871f = cVar;
        if (this.f26872g != null) {
            f.a().b("[addOnACServiceListener] %s", "bufBundle detected, callback");
            this.f26871f.a(new Bundle(this.f26872g));
            this.f26871f = null;
            return;
        }
        f.a().b("[addOnACServiceListener] %s", "no bufBundle, nothing to do");
    }

    public void a(b.a aVar) {
        f.a().b("[addMgsRequestListener] %s", "done");
        this.f26873h = aVar;
    }

    public void a(Bundle bundle) {
        if (this.f26871f != null) {
            f.a().b("[onACServiceAct] %s", "listener detected, callback");
            this.f26871f.a(bundle);
            return;
        }
        f.a().b("[onACServiceAct] %s", "no listener detected, cache");
        this.f26872g = new Bundle(bundle);
    }
}
