package com.mob.mcl.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.apc.b;
import com.mob.commons.ab;
import com.mob.mcl.BusinessMessageListener;
import com.mob.mcl.MobMCL;
import com.mob.mcl.TcpStatus;
import com.mob.mcl.c.h;
import com.mob.mgs.OnIdChangeListener;
import com.mob.tools.MobLog;
import com.mob.tools.network.HTTPPart;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.StringPart;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.UIHandler;
import com.mob.tools.utils.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f27412a = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static AtomicBoolean f27413b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private static NetworkHelper f27414c = new NetworkHelper();

    /* renamed from: d  reason: collision with root package name */
    private static CopyOnWriteArraySet<String> f27415d = new CopyOnWriteArraySet<>();

    /* renamed from: com.mob.mcl.b.a$a  reason: collision with other inner class name */
    public static class C0240a implements b.C0237b {
        private C0240a() {
        }

        public com.mob.apc.a a(String str, com.mob.apc.a aVar, long j11) {
            com.mob.apc.a aVar2 = aVar;
            com.mob.apc.a a11 = com.mob.mcl.a.a.a().a(str, aVar2);
            if (a11 != null) {
                try {
                    Object obj = a11.f26850d;
                    if (obj != null && (obj instanceof com.mob.mcl.a.b)) {
                        com.mob.mcl.a.b bVar = (com.mob.mcl.a.b) obj;
                        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                        networkTimeOut.readTimout = bVar.f27410f;
                        networkTimeOut.connectionTimeout = bVar.f27411g;
                        if ("POST".equals(bVar.f27405a)) {
                            a11.f26850d = null;
                            a.a(true, bVar.f27406b, com.mob.mcl.a.b.a(bVar.f27407c), new StringPart().append(bVar.f27408d), bVar.f27409e, com.mob.mcl.a.a(bVar.f27406b, a11), networkTimeOut);
                        } else if ("GET".equals(bVar.f27405a)) {
                            com.mob.mcl.a.a.a().b(a.a(true, bVar.f27406b, (HashMap<String, Object>) null, com.mob.mcl.a.b.a(bVar.f27407c), networkTimeOut), a11);
                        }
                    } else if (a11.f26847a == 9004) {
                        String string = aVar2.f26851e.getString("data");
                        long j12 = aVar2.f26851e.getLong("uniqueId");
                        if (!TextUtils.isEmpty(string)) {
                            HashMap fromJson = HashonHelper.fromJson(h.b().a(h.b().h(), string));
                            String str2 = (String) fromJson.get("workId");
                            int a12 = h.a((HashMap<String, Object>) fromJson, "expire", 0);
                            boolean z11 = h.a((HashMap<String, Object>) fromJson, "needRepeat", 0) == 1;
                            int a13 = h.a((HashMap<String, Object>) fromJson, "type", 0);
                            String str3 = (String) fromJson.get("data");
                            if (a13 == 1 || a13 == 2) {
                                Bundle bundle = new Bundle();
                                bundle.putString("data", str3);
                                bundle.putString("workId", str2);
                                bundle.putLong("uniqueId", aVar2.f26851e.getLong("uniqueId"));
                                bundle.putInt("expire", a12);
                                bundle.putInt("msgType", a13);
                                int a14 = h.b().a(bundle);
                                Bundle bundle2 = new Bundle();
                                bundle2.putBoolean("needRepeat", z11);
                                bundle2.putInt("repeat", a14);
                                a11.f26851e = bundle2;
                            } else {
                                boolean a15 = h.b().a(j12, str2, a12, a13, str3);
                                Bundle bundle3 = new Bundle();
                                bundle3.putBoolean("needRepeat", z11);
                                bundle3.putInt("repeat", a15 ? 1 : 0);
                                a11.f26851e = bundle3;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    com.mob.mcl.d.b.a().a(th2);
                }
            }
            return a11;
        }
    }

    /* access modifiers changed from: private */
    public static void d(final int i11) {
        if (i11 < 6) {
            boolean isInMainProcess = DH.SyncMtd.isInMainProcess();
            com.mob.mcl.d.b a11 = com.mob.mcl.d.b.a();
            a11.b("tp rgs, main p: " + isInMainProcess);
            final boolean z11 = !isInMainProcess && com.mob.mcl.a.a.a().b();
            a(5000, (e<Boolean>) new e<Boolean>() {
                public void a(Boolean bool) {
                    if (bool.booleanValue()) {
                        h.b().b(TcpStatus.obtain(10));
                    } else if (z11 || h.b().a()) {
                        h.b().b(TcpStatus.obtain(22));
                    } else {
                        int i11 = i11;
                        if (i11 == 0) {
                            a.b(i11 + 1, 10);
                        } else if (i11 == 1) {
                            a.b(i11 + 1, 30);
                        } else if (i11 == 2) {
                            a.b(i11 + 1, 60);
                        } else if (i11 == 3) {
                            a.b(i11 + 1, 180);
                        } else if (i11 == 4) {
                            a.b(i11 + 1, 300);
                        } else {
                            h.b().b(TcpStatus.obtain(20));
                        }
                    }
                }
            });
        }
    }

    public static void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            f27415d.remove(str);
        }
    }

    /* access modifiers changed from: private */
    public static Runnable c(final int i11) {
        return new Runnable() {
            public void run() {
                try {
                    a.d(i11);
                } catch (Throwable th2) {
                    com.mob.mcl.d.b.a().a(th2);
                }
            }
        };
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            f27415d.add(str);
        }
    }

    /* access modifiers changed from: private */
    public static void b(final int i11, int i12) {
        com.mob.mcl.d.b a11 = com.mob.mcl.d.b.a();
        a11.b("sched: count: " + i11 + ", delay: " + i12);
        UIHandler.sendEmptyMessageDelayed(0, (long) (i12 * 1000), new Handler.Callback() {
            public boolean handleMessage(Message message) {
                try {
                    if (h.b().c()) {
                        return false;
                    }
                    a.f27412a.execute(a.c(i11));
                    return false;
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                    return false;
                }
            }
        });
    }

    private static void d() {
        try {
            if (!f27413b.getAndSet(true)) {
                boolean isInMainProcess = DH.SyncMtd.isInMainProcess();
                com.mob.mcl.d.b a11 = com.mob.mcl.d.b.a();
                a11.b("rgs tp, main p: " + isInMainProcess);
                if (isInMainProcess) {
                    if (!h.b().f27473g) {
                        f27413b.set(false);
                    } else if (h.b().d()) {
                        h.b().a(3000, (e<Boolean>) new e<Boolean>() {
                            public void a(Boolean bool) {
                                if (bool.booleanValue()) {
                                    com.mob.mcl.c.b.a();
                                    a.f27413b.set(false);
                                    return;
                                }
                                com.mob.mcl.d.b.a().a("tp reg failed");
                            }
                        });
                    } else {
                        f27412a.execute(new Runnable() {
                            public void run() {
                                try {
                                    if (!h.b().c()) {
                                        if (!h.b().d()) {
                                            h.b().f();
                                        }
                                        h.b().a((e<Boolean>) new e<Boolean>() {
                                            public void a(Boolean bool) {
                                                if (!h.b().f27475i) {
                                                    a.b((e<Void>) new e<Void>() {
                                                        public void a(Void voidR) {
                                                        }
                                                    });
                                                }
                                            }
                                        });
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        });
                    }
                }
                f27413b.set(false);
                return;
            }
            f27413b.set(false);
        } catch (Throwable th2) {
            f27413b.set(false);
            throw th2;
        }
    }

    public static void a(Context context, String str, String str2) {
        Context context2;
        com.mob.mcl.d.b.a().a("mcl ini");
        if (context == null) {
            context2 = MobSDK.getContext();
        } else {
            context2 = context.getApplicationContext();
        }
        h.b().a(context2, str, str2);
        com.mob.mcl.a.a.a().a(context2, (b.C0237b) new C0240a());
        ab.a().a("use_config", false);
        b(0, 0);
    }

    /* access modifiers changed from: private */
    public static void b(final e<Void> eVar) {
        if (!com.mob.mcl.a.a.a().b()) {
            com.mob.mcl.a.a.a().a((e<Void>) new e<Void>() {
                public void a(Void voidR) {
                    e eVar = e.this;
                    if (eVar != null) {
                        eVar.a(null);
                    }
                }
            });
        } else if (eVar != null) {
            eVar.a(null);
        }
    }

    public static long b() {
        h.b().g();
        return h.b().f27478l;
    }

    private static void a(int i11, final e<Boolean> eVar) {
        if (!f27413b.getAndSet(true)) {
            try {
                boolean isInMainProcess = DH.SyncMtd.isInMainProcess();
                com.mob.mcl.d.b a11 = com.mob.mcl.d.b.a();
                a11.b("init tp, main p: " + isInMainProcess);
                if (isInMainProcess) {
                    h.b().f();
                    if (!h.b().f27473g) {
                        f27413b.set(false);
                        h.b().a(TcpStatus.obtain(21).setDetailedMsg("global: " + h.b().f27473g));
                        if (eVar != null) {
                            eVar.a(Boolean.FALSE);
                        }
                    } else if (h.b().d()) {
                        h.b().a(i11, (e<Boolean>) new e<Boolean>() {
                            public void a(Boolean bool) {
                                if (bool.booleanValue()) {
                                    com.mob.mcl.c.b.a();
                                    if (!h.b().f27475i) {
                                        a.b((e<Void>) new e<Void>() {
                                            public void a(Void voidR) {
                                                a.f27413b.set(false);
                                                e eVar = e.this;
                                                if (eVar != null) {
                                                    eVar.a(Boolean.TRUE);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                    a.f27413b.set(false);
                                    e eVar = e.this;
                                    if (eVar != null) {
                                        eVar.a(Boolean.TRUE);
                                        return;
                                    }
                                    return;
                                }
                                com.mob.mcl.d.b.a().a("tp reg failed");
                                a.b((e<Void>) new e<Void>() {
                                    public void a(Void voidR) {
                                        a.f27413b.set(false);
                                        e eVar = e.this;
                                        if (eVar != null) {
                                            eVar.a(Boolean.FALSE);
                                        }
                                    }
                                });
                            }
                        });
                    } else {
                        h.b().a(TcpStatus.obtain(21).setDetailedMsg("unavailable(global: " + h.b().f27473g + ", connect: " + h.b().f27474h + ")"));
                        com.mob.mcl.d.b.a().a("tp reg avail false");
                    }
                    f27413b.set(false);
                    return;
                }
                h.b().a(TcpStatus.obtain(21).setDetailedMsg("sub process"));
                b((e<Void>) new e<Void>() {
                    public void a(Void voidR) {
                        a.f27413b.set(false);
                        e eVar = e.this;
                        if (eVar != null) {
                            eVar.a(Boolean.FALSE);
                        }
                    }
                });
            } catch (Throwable th2) {
                f27413b.set(false);
                throw th2;
            }
            f27413b.set(false);
        } else if (eVar != null) {
            eVar.a(Boolean.FALSE);
        }
    }

    public static String a(boolean z11, String str, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2, NetworkHelper.NetworkTimeOut networkTimeOut) throws Throwable {
        CopyOnWriteArraySet<String> copyOnWriteArraySet;
        if (!z11 && (copyOnWriteArraySet = f27415d) != null) {
            Iterator<String> it2 = copyOnWriteArraySet.iterator();
            while (it2.hasNext()) {
                if (str.equals(it2.next())) {
                    String httpGetNew = f27414c.httpGetNew(str, hashMap, hashMap2, networkTimeOut);
                    com.mob.mcl.d.b.a().a("mcl htp");
                    return httpGetNew;
                }
            }
        }
        if (hashMap != null) {
            String a11 = a(hashMap);
            if (a11.length() > 0) {
                str = str + "?" + a11;
            }
            hashMap = null;
        }
        if (h.b().e()) {
            if (!h.b().c()) {
                d();
            }
            if (h.b().c()) {
                HashMap<String, Object> a12 = h.b().a(1004, networkTimeOut.readTimout, a("GET", str, hashMap2, (StringPart) null));
                if (a12 != null) {
                    com.mob.mcl.d.b.a().a("mcl tp");
                    return HashonHelper.fromHashMap(a12);
                } else if (!z11) {
                    String httpGetNew2 = f27414c.httpGetNew(str, hashMap, hashMap2, networkTimeOut);
                    com.mob.mcl.d.b.a().a("mcl htp");
                    return httpGetNew2;
                }
            }
        }
        if (z11) {
            return null;
        }
        if (!h.b().e()) {
            return f27414c.httpGetNew(str, (HashMap<String, Object>) null, hashMap2, networkTimeOut);
        }
        if (!com.mob.mcl.a.a.a().b()) {
            b(5, 0);
        }
        return a(str, hashMap2, networkTimeOut);
    }

    public static void a(boolean z11, String str, HashMap<String, String> hashMap, StringPart stringPart, int i11, HttpResponseCallback httpResponseCallback, NetworkHelper.NetworkTimeOut networkTimeOut) throws Throwable {
        CopyOnWriteArraySet<String> copyOnWriteArraySet;
        if (!z11 && (copyOnWriteArraySet = f27415d) != null && !copyOnWriteArraySet.isEmpty()) {
            Iterator<String> it2 = f27415d.iterator();
            while (it2.hasNext()) {
                if (str.equals(it2.next())) {
                    f27414c.rawPost(str, hashMap, (HTTPPart) stringPart, i11, httpResponseCallback, networkTimeOut);
                    return;
                }
            }
        }
        if (h.b().e()) {
            if (!h.b().c()) {
                d();
            }
            if (h.b().c()) {
                HashMap<String, Object> a11 = h.b().a(1004, networkTimeOut.readTimout, a("POST", str, hashMap, stringPart));
                if (a11 != null) {
                    httpResponseCallback.onResponse(com.mob.mcl.a.a(new b(a11)));
                    return;
                } else if (!z11) {
                    f27414c.rawPost(str, hashMap, (HTTPPart) stringPart, i11, httpResponseCallback, networkTimeOut);
                    return;
                }
            }
        }
        if (z11) {
            httpResponseCallback.onResponse((HttpConnection) null);
        } else if (h.b().e()) {
            if (!com.mob.mcl.a.a.a().b()) {
                b(5, 0);
            }
            a(str, hashMap, stringPart, i11, httpResponseCallback, networkTimeOut);
        } else {
            f27414c.rawPost(str, hashMap, (HTTPPart) stringPart, i11, httpResponseCallback, networkTimeOut);
        }
    }

    public static void a(boolean z11, String str, HashMap<String, String> hashMap, byte[] bArr, int i11, HttpResponseCallback httpResponseCallback, NetworkHelper.NetworkTimeOut networkTimeOut) throws Throwable {
        CopyOnWriteArraySet<String> copyOnWriteArraySet;
        if (!z11 && (copyOnWriteArraySet = f27415d) != null && !copyOnWriteArraySet.isEmpty()) {
            Iterator<String> it2 = f27415d.iterator();
            while (it2.hasNext()) {
                if (str.equals(it2.next())) {
                    a(str, hashMap, bArr, i11, httpResponseCallback, networkTimeOut);
                    return;
                }
            }
        }
        if (h.b().e()) {
            if (!h.b().c()) {
                d();
            }
            if (h.b().c()) {
                HashMap<String, Object> a11 = h.b().a(1004, networkTimeOut.readTimout, a("POST", str, hashMap, new StringPart().append(Base64.encodeToString(bArr, 2))));
                if (a11 != null) {
                    httpResponseCallback.onResponse(com.mob.mcl.a.a(new b(a11)));
                    return;
                } else if (!z11) {
                    a(str, hashMap, bArr, i11, httpResponseCallback, networkTimeOut);
                    return;
                }
            }
        }
        if (z11) {
            httpResponseCallback.onResponse((HttpConnection) null);
        } else if (h.b().e()) {
            if (!com.mob.mcl.a.a.a().b()) {
                b(5, 0);
            }
            String a12 = com.mob.mcl.a.a.a().a("POST", str, hashMap, new StringPart().append(Base64.encodeToString(bArr, 2)), i11, networkTimeOut);
            if (!TextUtils.isEmpty(a12)) {
                httpResponseCallback.onResponse(com.mob.mcl.a.a(new b(HashonHelper.fromJson(a12), true)));
            } else {
                a(str, hashMap, bArr, i11, httpResponseCallback, networkTimeOut);
            }
        } else {
            a(str, hashMap, bArr, i11, httpResponseCallback, networkTimeOut);
        }
    }

    private static void a(String str, HashMap<String, String> hashMap, byte[] bArr, int i11, HttpResponseCallback httpResponseCallback, NetworkHelper.NetworkTimeOut networkTimeOut) throws Throwable {
        if (hashMap != null) {
            hashMap.remove("Content-Length");
            hashMap.remove("sign");
        }
        f27414c.httpPostWithBytes(str, bArr, hashMap, i11, httpResponseCallback, networkTimeOut);
    }

    private static String a(String str, String str2, HashMap<String, String> hashMap, StringPart stringPart) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("type", str);
        hashMap2.put("url", str2);
        HashMap hashMap3 = new HashMap();
        if (hashMap != null) {
            hashMap3.putAll(hashMap);
        }
        hashMap2.put("headers", hashMap3);
        if (stringPart != null) {
            hashMap2.put(TtmlNode.TAG_BODY, stringPart.toString());
        }
        return HashonHelper.fromHashMap(hashMap2);
    }

    private static String a(String str, HashMap<String, String> hashMap, NetworkHelper.NetworkTimeOut networkTimeOut) throws Throwable {
        String a11 = com.mob.mcl.a.a.a().a("GET", str, hashMap, (StringPart) null, 0, networkTimeOut);
        if (!TextUtils.isEmpty(a11)) {
            com.mob.mcl.d.b.a().a("mcl apc");
            return a11;
        }
        String httpGetNew = f27414c.httpGetNew(str, (HashMap<String, Object>) null, hashMap, networkTimeOut);
        com.mob.mcl.d.b.a().a("mcl htp");
        return httpGetNew;
    }

    private static void a(String str, HashMap<String, String> hashMap, StringPart stringPart, int i11, HttpResponseCallback httpResponseCallback, NetworkHelper.NetworkTimeOut networkTimeOut) throws Throwable {
        String a11 = com.mob.mcl.a.a.a().a("POST", str, hashMap, stringPart, i11, networkTimeOut);
        if (!TextUtils.isEmpty(a11)) {
            httpResponseCallback.onResponse(com.mob.mcl.a.a(new b(HashonHelper.fromJson(a11), true)));
        } else {
            f27414c.rawPost(str, hashMap, (HTTPPart) stringPart, i11, httpResponseCallback, networkTimeOut);
        }
    }

    private static String a(HashMap<String, Object> hashMap) throws Throwable {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry next : hashMap.entrySet()) {
            String urlEncode = Data.urlEncode((String) next.getKey(), "utf-8");
            String urlEncode2 = next.getValue() == null ? "" : Data.urlEncode(String.valueOf(next.getValue()), "utf-8");
            if (sb2.length() > 0) {
                sb2.append('&');
            }
            sb2.append(urlEncode);
            sb2.append('=');
            sb2.append(urlEncode2);
        }
        return sb2.toString();
    }

    public static String a() {
        h.b().g();
        return h.b().f27477k;
    }

    public static void a(OnIdChangeListener onIdChangeListener) {
        h.b().a(onIdChangeListener);
        h.b().g();
    }

    public static void a(String str, long j11, final e<Boolean> eVar) {
        h.b().a(str, j11);
        try {
            if (h.b().d()) {
                if (!h.b().c()) {
                    a(3000, (e<Boolean>) new e<Boolean>() {
                        public void a(Boolean bool) {
                            h.b().b((e<Boolean>) new e<Boolean>() {
                                public void a(Boolean bool) {
                                    e eVar = e.this;
                                    if (eVar != null) {
                                        eVar.a(bool);
                                    }
                                }
                            });
                        }
                    });
                } else {
                    h.b().b((e<Boolean>) new e<Boolean>() {
                        public void a(Boolean bool) {
                            e eVar = e.this;
                            if (eVar != null) {
                                eVar.a(bool);
                            }
                        }
                    });
                }
            } else if (eVar != null) {
                eVar.a(Boolean.FALSE);
            }
        } catch (Throwable th2) {
            com.mob.mcl.d.b.a().a(th2);
            if (eVar != null) {
                eVar.a(Boolean.FALSE);
            }
        }
    }

    public static void a(MobMCL.ELPMessageListener eLPMessageListener) {
        h.b().a(eLPMessageListener);
    }

    public static void a(int i11, BusinessMessageListener businessMessageListener) {
        h.b().a(i11, businessMessageListener);
    }
}
