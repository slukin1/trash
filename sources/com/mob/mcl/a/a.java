package com.mob.mcl.a;

import android.content.Context;
import android.os.Bundle;
import com.mob.MobSDK;
import com.mob.apc.b;
import com.mob.mcl.MobMCL;
import com.mob.mcl.c.h;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.StringPart;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f27399a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public volatile Set<String> f27400b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f27401c;

    private a() {
    }

    public boolean b() {
        return this.f27400b != null && this.f27400b.size() > 0;
    }

    public static a a() {
        if (f27399a == null) {
            synchronized (a.class) {
                if (f27399a == null) {
                    f27399a = new a();
                }
            }
        }
        return f27399a;
    }

    public void b(String str, com.mob.apc.a aVar) {
        if (str != null) {
            Bundle bundle = new Bundle();
            bundle.putString("data", str);
            aVar.f26851e = bundle;
        }
    }

    public void a(Context context, b.C0237b bVar) {
        this.f27401c = MobMCL.SDK_TAG;
        b.a(context);
        boolean isInMainProcess = DH.SyncMtd.isInMainProcess();
        com.mob.mcl.d.b a11 = com.mob.mcl.d.b.a();
        a11.b("init apc, main p: " + isInMainProcess);
        if (isInMainProcess) {
            b.a(this.f27401c, bVar);
        }
    }

    public void a(final e<Void> eVar) {
        if (h.b().f27476j) {
            final ArrayList arrayList = new ArrayList();
            boolean isInMainProcess = DH.SyncMtd.isInMainProcess();
            com.mob.mcl.d.b a11 = com.mob.mcl.d.b.a();
            a11.b("qy tp svc, main p: " + isInMainProcess);
            if (!isInMainProcess) {
                arrayList.add(MobSDK.getContext().getPackageName());
            }
            b.a((e<List<String>>) new e<List<String>>() {
                public void a(List<String> list) {
                    Bundle bundle;
                    arrayList.addAll(list);
                    com.mob.mcl.d.b a11 = com.mob.mcl.d.b.a();
                    a11.b("qy : " + arrayList.toString());
                    Set unused = a.this.f27400b = new LinkedHashSet();
                    for (String str : arrayList) {
                        com.mob.apc.a aVar = new com.mob.apc.a();
                        aVar.f26847a = 1;
                        try {
                            com.mob.mcl.d.b a12 = com.mob.mcl.d.b.a();
                            a12.b("sd apc mg : " + aVar.toString() + " to ->" + str);
                            com.mob.apc.a a13 = b.a(1, str, a.this.f27401c, aVar, 5000);
                            if (a13 != null && (bundle = a13.f26851e) != null && a13.f26847a == 1 && bundle.getBoolean("isTcpAvailable")) {
                                a.this.f27400b.add(str);
                            }
                        } catch (Throwable th2) {
                            com.mob.mcl.d.b a14 = com.mob.mcl.d.b.a();
                            a14.b("query tcp exp : " + th2.getMessage());
                        }
                    }
                    com.mob.mcl.d.b a15 = com.mob.mcl.d.b.a();
                    a15.b("apc available pg : " + a.this.f27400b.toString());
                    e eVar = eVar;
                    if (eVar != null) {
                        eVar.a(null);
                    }
                }
            });
        } else if (eVar != null) {
            eVar.a(null);
        }
    }

    public com.mob.apc.a a(int i11, Bundle bundle, String str, int i12) {
        try {
            com.mob.apc.a aVar = new com.mob.apc.a();
            aVar.f26847a = i11;
            aVar.f26851e = bundle;
            com.mob.mcl.d.b a11 = com.mob.mcl.d.b.a();
            a11.b("apc fw mg : " + i11 + " " + aVar.toString() + " to ->" + str);
            return b.a(1, str, this.f27401c, aVar, (long) i12);
        } catch (Throwable th2) {
            com.mob.mcl.d.b.a().a(th2);
            return null;
        }
    }

    public String a(String str, String str2, HashMap<String, String> hashMap, StringPart stringPart, int i11, NetworkHelper.NetworkTimeOut networkTimeOut) throws Throwable {
        Bundle bundle;
        if (b()) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(this.f27400b);
            for (String str3 : arrayList) {
                com.mob.apc.a aVar = new com.mob.apc.a();
                aVar.f26847a = 2;
                aVar.f26851e = b.a(str, str2, hashMap, stringPart, i11, networkTimeOut);
                try {
                    com.mob.mcl.d.b a11 = com.mob.mcl.d.b.a();
                    a11.b("apc sd mg : " + aVar.toString() + " to ->" + str3);
                    com.mob.apc.a a12 = b.a(1, str3, this.f27401c, aVar, (long) networkTimeOut.readTimout);
                    if (a12 == null || a12.f26847a != 2 || (bundle = a12.f26851e) == null) {
                        com.mob.mcl.d.b a13 = com.mob.mcl.d.b.a();
                        a13.b("apc receive rp : " + a12);
                    } else {
                        com.mob.mcl.d.b a14 = com.mob.mcl.d.b.a();
                        a14.b("apc receive rp mg : " + bundle.getString("data"));
                        return bundle.getString("data");
                    }
                } catch (Throwable th2) {
                    com.mob.mcl.d.b.a().a(th2);
                }
            }
            return null;
        }
        com.mob.mcl.d.b.a().a("apc list is null");
        return null;
    }

    public com.mob.apc.a a(String str, com.mob.apc.a aVar) {
        com.mob.mcl.d.b a11 = com.mob.mcl.d.b.a();
        a11.a("apc received mg " + aVar + " from -> " + str);
        if (aVar == null) {
            return null;
        }
        com.mob.apc.a aVar2 = new com.mob.apc.a();
        aVar2.f26847a = aVar.f26847a;
        int i11 = aVar.f26847a;
        if (i11 == 1) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isTcpAvailable", h.b().e());
            aVar2.f26851e = bundle;
            return aVar2;
        } else if (i11 == 2) {
            aVar2.f26850d = b.a(aVar.f26851e);
            return aVar2;
        } else if (i11 == 9004) {
            return aVar2;
        } else {
            return null;
        }
    }
}
