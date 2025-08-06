package com.mob.commons.a;

import com.mob.MobSDK;
import com.mob.commons.CSCenter;
import com.mob.commons.ab;
import com.mob.commons.b;
import com.mob.commons.i;
import com.mob.tools.MobLog;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.utils.DH;
import java.util.HashMap;

public class m extends c {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final String f26968c = com.mob.commons.m.a("016:dcdbcjdabfciejdcefdbdjbfdaccfaeg");

    /* renamed from: d  reason: collision with root package name */
    private static final String f26969d = com.mob.commons.m.a("0168dcdbcjdabfeadbccdcegdjbfdjdbdadb");

    public m() {
        super(com.mob.commons.m.a("002he"), 0, com.mob.commons.m.a("005heVchRbh"), 86400, c.a(com.mob.commons.m.a("002he"), (Long) 0L));
    }

    /* access modifiers changed from: private */
    public Object b(HashMap<String, Object> hashMap) {
        try {
            hashMap.put(com.mob.commons.m.a("005ahe^dbFg"), Long.valueOf(System.currentTimeMillis()));
            return b(hashMap, i.a().a("gclg") + com.mob.commons.m.a("004jahe"));
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }

    private void n() {
        DH.requester(MobSDK.getContext()).getDetailNetworkTypeForStatic().request(new DH.DHResponder() {
            /* JADX WARNING: Code restructure failed: missing block: B:4:0x00ce, code lost:
                r1 = (java.util.List) r1.get(com.mob.commons.m.a("004hWcfchdg"));
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(com.mob.tools.utils.DH.DHResponse r9) throws java.lang.Throwable {
                /*
                    r8 = this;
                    java.util.HashMap r0 = new java.util.HashMap
                    r0.<init>()
                    java.lang.String r1 = com.mob.commons.u.a()
                    r2 = 0
                    java.lang.String r2 = com.mob.commons.e.a((com.mob.commons.MobProduct) r2)
                    java.lang.String r3 = "006bhh)cfGd3ca"
                    java.lang.String r3 = com.mob.commons.m.a(r3)
                    r0.put(r3, r1)
                    java.lang.String r3 = "006bhhhCcfch"
                    java.lang.String r3 = com.mob.commons.m.a(r3)
                    java.lang.String r4 = com.mob.tools.utils.DH.SyncMtd.getPackageName()
                    r0.put(r3, r4)
                    java.lang.String r3 = "006bhh9bb;dZbh"
                    java.lang.String r3 = com.mob.commons.m.a(r3)
                    int r4 = com.mob.tools.utils.DH.SyncMtd.getAppVersion()
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                    r0.put(r3, r4)
                    java.lang.String r3 = "004.babebgba"
                    java.lang.String r3 = com.mob.commons.m.a(r3)
                    r0.put(r3, r2)
                    java.lang.String r3 = "004hebg"
                    java.lang.String r3 = com.mob.commons.m.a(r3)
                    int r4 = com.mob.tools.utils.DH.SyncMtd.getPlatformCode()
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                    r0.put(r3, r4)
                    java.lang.String r3 = "011cdg,debibhcfOgBcaYhd"
                    java.lang.String r3 = com.mob.commons.m.a(r3)
                    java.lang.String r9 = r9.getDetailNetworkTypeForStatic()
                    r0.put(r3, r9)
                    java.lang.String r9 = "009ebZdg;g!ei[he'db8g"
                    java.lang.String r9 = com.mob.commons.m.a(r9)
                    com.mob.commons.ab r3 = com.mob.commons.ab.a()
                    java.lang.String r4 = com.mob.commons.a.m.f26968c
                    r5 = 0
                    long r3 = r3.b((java.lang.String) r4, (long) r5)
                    java.lang.Long r3 = java.lang.Long.valueOf(r3)
                    r0.put(r9, r3)
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder
                    r9.<init>()
                    r9.append(r1)
                    java.lang.String r1 = ":"
                    r9.append(r1)
                    r9.append(r2)
                    java.lang.String r9 = r9.toString()
                    java.lang.String r1 = "utf-8"
                    byte[] r9 = r9.getBytes(r1)
                    r1 = 2
                    java.lang.String r9 = android.util.Base64.encodeToString(r9, r1)
                    java.lang.String r1 = "009eb(dgPgWeiHhe!ccba"
                    java.lang.String r1 = com.mob.commons.m.a(r1)
                    r0.put(r1, r9)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    com.mob.commons.i r2 = com.mob.commons.i.a()
                    java.lang.String r3 = "gclg"
                    java.lang.String r2 = r2.a((java.lang.String) r3)
                    r1.append(r2)
                    java.lang.String r2 = "004jTbb!he"
                    java.lang.String r2 = com.mob.commons.m.a(r2)
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    java.lang.Object r1 = com.mob.commons.a.m.b(r0, r1)
                    java.util.HashMap r1 = (java.util.HashMap) r1
                    if (r1 == 0) goto L_0x0189
                    int r2 = r1.size()
                    if (r2 != 0) goto L_0x00ce
                    goto L_0x0189
                L_0x00ce:
                    java.lang.String r2 = "004hWcfchdg"
                    java.lang.String r2 = com.mob.commons.m.a(r2)
                    java.lang.Object r1 = r1.get(r2)
                    java.util.List r1 = (java.util.List) r1
                    if (r1 == 0) goto L_0x0189
                    int r2 = r1.size()
                    if (r2 <= 0) goto L_0x0189
                    com.mob.commons.ab r2 = com.mob.commons.ab.a()
                    java.lang.String r3 = com.mob.commons.a.m.f26968c
                    long r4 = java.lang.System.currentTimeMillis()
                    r2.a((java.lang.String) r3, (long) r4)
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    com.mob.tools.log.NLog r3 = com.mob.tools.MobLog.getInstance()
                    r4 = 0
                    java.lang.Object[] r5 = new java.lang.Object[r4]
                    java.lang.String r6 = "[dhss] vpl"
                    r3.d(r6, r5)
                    android.content.Context r3 = com.mob.MobSDK.getContext()
                    com.mob.tools.utils.DH$RequestBuilder r3 = com.mob.tools.utils.DH.requester(r3)
                    java.util.Iterator r5 = r1.iterator()
                L_0x010e:
                    boolean r6 = r5.hasNext()
                    if (r6 == 0) goto L_0x0121
                    java.lang.Object r6 = r5.next()
                    java.lang.String r6 = (java.lang.String) r6
                    r7 = 180000(0x2bf20, float:2.52234E-40)
                    r3.getMpfos(r7, r6, r4)
                    goto L_0x010e
                L_0x0121:
                    com.mob.commons.a.m$1$1 r4 = new com.mob.commons.a.m$1$1
                    r4.<init>(r1, r2)
                    r3.request(r4)
                    java.lang.String r1 = "011cdg7debibhcf*g;ca:hd"
                    java.lang.String r1 = com.mob.commons.m.a(r1)
                    r0.remove(r1)
                    java.lang.String r1 = "009eb1dg'gYeiJhe1dbXg"
                    java.lang.String r1 = com.mob.commons.m.a(r1)
                    r0.remove(r1)
                    java.lang.String r1 = "009eb1dg<g*eiYhe!ccba"
                    java.lang.String r1 = com.mob.commons.m.a(r1)
                    r0.remove(r1)
                    java.lang.String r1 = "005;bdbibaQde"
                    java.lang.String r1 = com.mob.commons.m.a(r1)
                    java.lang.String r3 = com.mob.tools.utils.DH.SyncMtd.getModel()
                    r0.put(r1, r3)
                    java.lang.String r1 = "008<baNbgdg-bgbd@d"
                    java.lang.String r1 = com.mob.commons.m.a(r1)
                    long r3 = java.lang.System.currentTimeMillis()
                    java.lang.Long r3 = java.lang.Long.valueOf(r3)
                    r0.put(r1, r3)
                    java.lang.String r1 = "002Ebgba"
                    java.lang.String r1 = com.mob.commons.m.a(r1)
                    r0.put(r1, r9)
                    java.lang.String r9 = "004h_cfchdg"
                    java.lang.String r9 = com.mob.commons.m.a(r9)
                    r0.put(r9, r2)
                    com.mob.commons.a.m r9 = com.mob.commons.a.m.this
                    java.lang.Object r9 = r9.b(r0)
                    if (r9 != 0) goto L_0x0182
                    com.mob.commons.a.m r9 = com.mob.commons.a.m.this
                    java.lang.Object r9 = r9.b(r0)
                L_0x0182:
                    if (r9 != 0) goto L_0x0189
                    com.mob.commons.a.m r9 = com.mob.commons.a.m.this
                    r9.a(r0)
                L_0x0189:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.a.m.AnonymousClass1.onResponse(com.mob.tools.utils.DH$DHResponse):void");
            }
        });
    }

    public void a() {
        if (CSCenter.getInstance().isAppListDataEnable()) {
            try {
                Thread.sleep(((Long) a(d(), 0L)).longValue() * 1000);
                HashMap hashMap = (HashMap) ab.a().c(f26969d, (Object) null);
                if (!(hashMap == null || hashMap.isEmpty() || b(hashMap) == null)) {
                    a((HashMap<String, Object>) null);
                }
            } catch (Throwable unused) {
            }
            n();
        }
    }

    /* access modifiers changed from: private */
    public static Object b(HashMap<String, Object> hashMap, String str) throws Throwable {
        if (!b.c()) {
            return null;
        }
        return new NetCommunicator(1024, "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b67" + com.mob.commons.m.a("023VfdUb@fbHab%fgbagifb$dYcd4d.ba!d4fjfb)dXfcfhfd0b0hdcd"), "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1").requestSynchronized(hashMap, str, false);
    }

    public synchronized void a(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            ab.a().b(f26969d);
        } else {
            ab.a().b(f26969d, (Object) hashMap);
        }
    }
}
