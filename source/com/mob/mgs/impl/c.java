package com.mob.mgs.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.apc.b;
import com.mob.commons.j;
import com.mob.commons.u;
import com.mob.mcl.MobMCL;
import com.mob.mcl.a;
import com.mob.mgs.MobMGS;
import com.mob.tools.MobLog;
import com.mob.tools.utils.ActivityTracker;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class c implements b.a, b.C0237b, b.c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f27549a = {"com.mob.intent.MOB_GUARD_SERVICE", "com.mob.intent.MOB_ID_SERVICE"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f27550b = {"com.mob.guard.MobGuardPullUpService", "com.mob.id.MobIDService"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f27551c = {"com.mob.guard.MobTranPullUpActivity", "com.mob.id.MobIDActivity"};

    /* renamed from: d  reason: collision with root package name */
    private static c f27552d = new c();

    /* renamed from: e  reason: collision with root package name */
    private static AtomicBoolean f27553e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private ExecutorService f27554f = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f27555g = null;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f27556h = false;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f27557i = 0;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f27558j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public List<HashMap<String, Object>> f27559k = null;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public HashMap<String, Integer> f27560l = null;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f27561m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f27562n;

    /* renamed from: o  reason: collision with root package name */
    private Context f27563o = MobSDK.getContext();

    private c() {
        ActivityTracker.getInstance(MobSDK.getContext()).addTracker(a.a((a.C0239a) new a.C0239a() {
            public void a() {
                if (c.this.f27561m) {
                    c.this.a((String) null, true);
                }
            }
        }));
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f() {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = f27553e     // Catch:{ all -> 0x0070 }
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)     // Catch:{ all -> 0x0070 }
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            android.content.Context r0 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x0070 }
            com.mob.MobSDK.init(r0)     // Catch:{ all -> 0x0070 }
            android.content.Context r0 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x0070 }
            com.mob.apc.b.a((android.content.Context) r0)     // Catch:{ all -> 0x0070 }
            com.mob.mgs.impl.f r0 = com.mob.mgs.impl.f.a()     // Catch:{ all -> 0x0070 }
            java.lang.String r0 = r0.f()     // Catch:{ all -> 0x0070 }
            com.mob.elp.MobELP.init(r0)     // Catch:{ all -> 0x0025 }
            goto L_0x002e
        L_0x0025:
            com.mob.mgs.impl.e r1 = com.mob.mgs.impl.e.a()     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = "No [MobELP] module."
            r1.a((java.lang.String) r2)     // Catch:{ all -> 0x0070 }
        L_0x002e:
            java.lang.String r1 = "MOBGUARD"
            com.mob.apc.b.a(r1, r4)     // Catch:{ all -> 0x0070 }
            com.mob.apc.b.a((com.mob.apc.b.c) r4)     // Catch:{ all -> 0x0070 }
            com.mob.apc.b.a((com.mob.apc.b.a) r4)     // Catch:{ all -> 0x0070 }
            android.content.Context r1 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = com.mob.commons.u.a()     // Catch:{ all -> 0x0070 }
            com.mob.mcl.MobMCL.initMCLink(r1, r2, r0)     // Catch:{ all -> 0x0070 }
            com.mob.mcl.MobMCL.getSuid()     // Catch:{ all -> 0x0070 }
            com.mob.mgs.impl.e r0 = com.mob.mgs.impl.e.a()     // Catch:{ all -> 0x0070 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
            r1.<init>()     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = "[Guard] init guardId:"
            r1.append(r2)     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = com.mob.mcl.MobMCL.getSuid()     // Catch:{ all -> 0x0070 }
            r1.append(r2)     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = ", time: "
            r1.append(r2)     // Catch:{ all -> 0x0070 }
            long r2 = com.mob.mcl.MobMCL.getCreateSuidTime()     // Catch:{ all -> 0x0070 }
            r1.append(r2)     // Catch:{ all -> 0x0070 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0070 }
            r0.a((java.lang.String) r1)     // Catch:{ all -> 0x0070 }
            goto L_0x0078
        L_0x0070:
            r0 = move-exception
            com.mob.mgs.impl.e r1 = com.mob.mgs.impl.e.a()
            r1.b((java.lang.Throwable) r0)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.mgs.impl.c.f():void");
    }

    /* access modifiers changed from: private */
    public void g() {
        Bundle bundle;
        e a11 = e.a();
        a11.a("[Guard] syncId upPkgList: " + this.f27559k);
        List<HashMap<String, Object>> list = this.f27559k;
        if (list != null && list.size() != 0) {
            String suid = MobMCL.getSuid();
            long createSuidTime = MobMCL.getCreateSuidTime();
            String str = suid;
            for (HashMap<String, Object> hashMap : this.f27559k) {
                com.mob.apc.a aVar = null;
                String str2 = (String) ResHelper.forceCast(hashMap.get("pkg"), null);
                com.mob.apc.a aVar2 = new com.mob.apc.a();
                aVar2.f26847a = 1001;
                try {
                    aVar = b.a(1, str2, MobMGS.MGS_TAG, aVar2, 5000);
                } catch (Throwable th2) {
                    e.a().b(th2);
                }
                e a12 = e.a();
                a12.a("[Guard] syncId getClientIDs sendAPCMessage pkg: " + str2 + ", response:" + aVar);
                if (!(aVar == null || (bundle = aVar.f26851e) == null)) {
                    String string = bundle.getString("guardId");
                    long j11 = bundle.getLong("timestamp");
                    if (!TextUtils.isEmpty(string) && j11 > 0 && j11 < createSuidTime) {
                        str = string;
                        createSuidTime = j11;
                    }
                }
            }
            e a13 = e.a();
            a13.a("[Guard] syncId update guardId :" + str + ", oldId: " + suid);
            if (!str.equals(suid)) {
                final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
                MobMCL.syncSuid(str, createSuidTime, new e<Boolean>() {
                    public void a(Boolean bool) {
                        linkedBlockingQueue.offer(bool);
                    }
                });
                try {
                    ((Boolean) linkedBlockingQueue.poll(1000, TimeUnit.MILLISECONDS)).booleanValue();
                } catch (Throwable th3) {
                    MobLog.getInstance().d(th3);
                }
            }
            a(str, createSuidTime);
        }
    }

    /* access modifiers changed from: private */
    public boolean c(String str) {
        try {
            String string = Settings.Secure.getString(MobSDK.getContext().getContentResolver(), "app_lock_list");
            if (!TextUtils.isEmpty(string)) {
                for (String str2 : string.split(";")) {
                    if (str2 != null && str2.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public void d() {
        if (this.f27556h) {
            g();
        }
    }

    public void b() throws Throwable {
        f();
        if (!MobMGS.getDS()) {
            e.a().a("DS off");
        } else {
            DH.requester(MobSDK.getContext()).getAInfoForPkg(MobSDK.getContext().getPackageName(), 128).request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) {
                    Bundle bundle;
                    Object obj;
                    boolean z11 = false;
                    ApplicationInfo aInfoForPkg = dHResponse.getAInfoForPkg(new int[0]);
                    String str = null;
                    if (!(aInfoForPkg == null || (bundle = aInfoForPkg.metaData) == null || bundle.isEmpty() || (obj = bundle.get("disable_mob_a_guard")) == null)) {
                        str = String.valueOf(obj);
                    }
                    e.a().a("[Guard] run disable_mob_a_guard:" + str);
                    if (!"true".equals(str)) {
                        com.mob.commons.b.a("cd", "221111", 0);
                        boolean b11 = j.a().b();
                        e.a().a("[EC] isClear init: " + b11);
                        if (b11) {
                            if (((Integer) com.mob.commons.b.a(TtmlNode.COMBINE_ALL, 1, 0)).intValue() == 1) {
                                z11 = true;
                            }
                            e.a().a("als on: " + z11);
                            if (z11) {
                                c.this.b((e<Boolean>) new e<Boolean>() {
                                    public void a(Boolean bool) {
                                        try {
                                            e a11 = e.a();
                                            a11.a("[GD] checkAndInitGuardParams:" + bool);
                                            if (bool.booleanValue()) {
                                                if (c.this.c()) {
                                                    LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
                                                    e.a().a("[GD] registerServerSocket");
                                                    a.a().a((BlockingQueue<Boolean>) linkedBlockingQueue);
                                                    boolean booleanValue = ((Boolean) linkedBlockingQueue.take()).booleanValue();
                                                    e a12 = e.a();
                                                    a12.a("[GD] registerServerSocket: " + booleanValue);
                                                    if (booleanValue) {
                                                        c cVar = c.this;
                                                        cVar.a(cVar.f27556h, (String) null);
                                                        if (c.this.f27556h) {
                                                            Thread.sleep(500);
                                                            c.this.g();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                }
                                                e.a().a("[Guard] registerClientSocket");
                                                a.a().b();
                                            }
                                        } catch (Throwable th2) {
                                            MobLog.getInstance().d(th2);
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            });
        }
    }

    public boolean c() {
        return this.f27558j == 1;
    }

    public static c a() {
        return f27552d;
    }

    /* access modifiers changed from: private */
    public void a(e<List<HashMap<String, String>>> eVar) {
        ArrayList arrayList = new ArrayList();
        try {
            final String packageName = MobSDK.getContext().getPackageName();
            final HashSet hashSet = new HashSet();
            final ArrayList arrayList2 = new ArrayList();
            DH.RequestBuilder requestBuilder = null;
            int i11 = 0;
            while (true) {
                String[] strArr = f27549a;
                if (i11 >= strArr.length) {
                    break;
                }
                ReflectHelper.importClass("android.content.Intent");
                Intent intent = (Intent) ReflectHelper.newInstance("Intent", strArr[i11]);
                if (requestBuilder == null) {
                    requestBuilder = DH.requester(MobSDK.getContext());
                }
                requestBuilder = requestBuilder.queryIntentServices(intent, 0);
                i11++;
            }
            if (requestBuilder != null) {
                final ArrayList arrayList3 = arrayList;
                final e<List<HashMap<String, String>>> eVar2 = eVar;
                requestBuilder.request(new DH.DHResponder() {
                    public void onResponse(DH.DHResponse dHResponse) {
                        int i11 = 0;
                        while (i11 < c.f27549a.length) {
                            try {
                                List<ResolveInfo> queryIntentServices = dHResponse.queryIntentServices(i11);
                                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                                    arrayList2.addAll(queryIntentServices);
                                }
                                i11++;
                            } catch (Throwable th2) {
                                MobLog.getInstance().d(th2);
                                e eVar = eVar2;
                                if (eVar != null) {
                                    eVar.a(arrayList3);
                                    return;
                                }
                                return;
                            }
                        }
                        HashMap unused = c.this.f27560l = new HashMap();
                        if (arrayList2 == null || c.this.f27560l == null) {
                            e eVar2 = eVar2;
                            if (eVar2 != null) {
                                eVar2.a(arrayList3);
                                return;
                            }
                            return;
                        }
                        DH.RequestBuilder requestBuilder = null;
                        final ArrayList arrayList = new ArrayList();
                        for (ResolveInfo resolveInfo : arrayList2) {
                            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                            if (serviceInfo.exported && !packageName.equals(serviceInfo.packageName)) {
                                if (requestBuilder == null) {
                                    requestBuilder = DH.requester(MobSDK.getContext());
                                }
                                requestBuilder = requestBuilder.getMpfof(true, resolveInfo.serviceInfo.packageName, 128);
                                arrayList.add(resolveInfo.serviceInfo.packageName);
                            }
                        }
                        if (requestBuilder != null) {
                            requestBuilder.request(new DH.DHResponder() {
                                public void onResponse(DH.DHResponse dHResponse) {
                                    int i11 = 0;
                                    while (i11 < arrayList.size()) {
                                        try {
                                            Bundle bundle = null;
                                            int i12 = 1;
                                            ApplicationInfo a11 = com.mob.tools.c.a(dHResponse.getMpfof(i11), (String) arrayList.get(i11));
                                            if (a11 != null) {
                                                bundle = a11.metaData;
                                            }
                                            if (bundle != null && !bundle.isEmpty()) {
                                                Object obj = bundle.get("mob_id_ver");
                                                if (obj == null) {
                                                    obj = bundle.get("mob_guard_version");
                                                    i12 = 0;
                                                }
                                                if (obj != null) {
                                                    AnonymousClass10 r22 = AnonymousClass10.this;
                                                    if (!hashSet.contains(((ResolveInfo) arrayList2.get(i11)).serviceInfo.packageName)) {
                                                        AnonymousClass10 r23 = AnonymousClass10.this;
                                                        if (!c.this.c(((ResolveInfo) arrayList2.get(i11)).serviceInfo.packageName)) {
                                                            AnonymousClass10 r24 = AnonymousClass10.this;
                                                            hashSet.add(((ResolveInfo) arrayList2.get(i11)).serviceInfo.packageName);
                                                            String valueOf = String.valueOf(obj);
                                                            HashMap hashMap = new HashMap();
                                                            hashMap.put("appPackage", ((ResolveInfo) arrayList2.get(i11)).serviceInfo.packageName);
                                                            hashMap.put("targetVer", valueOf);
                                                            arrayList3.add(hashMap);
                                                            c.this.f27560l.put(((ResolveInfo) arrayList2.get(i11)).serviceInfo.packageName, Integer.valueOf(i12));
                                                        }
                                                    }
                                                }
                                            }
                                            i11++;
                                        } catch (Throwable th2) {
                                            MobLog.getInstance().d(th2);
                                            AnonymousClass10 r82 = AnonymousClass10.this;
                                            e eVar = eVar2;
                                            if (eVar != null) {
                                                eVar.a(arrayList3);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    AnonymousClass10 r83 = AnonymousClass10.this;
                                    e eVar2 = eVar2;
                                    if (eVar2 != null) {
                                        eVar2.a(arrayList3);
                                    }
                                }
                            });
                        }
                    }
                });
            } else if (eVar != null) {
                eVar.a(arrayList);
            }
        } catch (Throwable th2) {
            e.a().b(th2);
            if (eVar != null) {
                eVar.a(arrayList);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(final e<Boolean> eVar) {
        a((e<List<HashMap<String, String>>>) new e<List<HashMap<String, String>>>() {
            public void a(List<HashMap<String, String>> list) {
                e eVar;
                Boolean bool;
                try {
                    e a11 = e.a();
                    a11.a("[GD] avlb uplv tg: " + list);
                    HashMap hashMap = (HashMap) d.a(list, MobMCL.getSuid(), MobMGS.getDS());
                    e a12 = e.a();
                    a12.a("[GD] gd resp:" + hashMap);
                    boolean z11 = false;
                    if (hashMap != null && !hashMap.isEmpty()) {
                        String unused = c.this.f27555g = (String) ResHelper.forceCast(hashMap.get("workId"), null);
                        boolean unused2 = c.this.f27556h = ((Boolean) ResHelper.forceCast(hashMap.get("syncIdState"), Boolean.FALSE)).booleanValue();
                        int unused3 = c.this.f27558j = ((Integer) ResHelper.forceCast(hashMap.get("asMaster"), 0)).intValue();
                        int unused4 = c.this.f27557i = ((Integer) ResHelper.forceCast(hashMap.get("pollTotal"), 0)).intValue();
                        List unused5 = c.this.f27559k = (List) hashMap.get("pkgList");
                        z11 = true;
                    }
                    eVar = eVar;
                    if (eVar != null) {
                        bool = Boolean.valueOf(z11);
                        eVar.a(bool);
                    }
                } catch (Throwable th2) {
                    e eVar2 = eVar;
                    if (eVar2 != null) {
                        eVar2.a(Boolean.FALSE);
                    }
                    throw th2;
                }
            }
        });
    }

    public void b(String str) {
        e a11 = e.a();
        a11.a("[Guard] syncId newClientPkg : " + str + " syncIdFailed : " + this.f27562n);
        if (this.f27562n) {
            this.f27554f.execute(new Runnable() {
                public void run() {
                    if (c.this.f27562n) {
                        c.this.d();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(int i11, final String str, String str2, String str3, final e<HashMap<String, Object>> eVar) {
        final HashMap hashMap = new HashMap();
        try {
            ComponentName componentName = new ComponentName(str, f27551c[((Integer) ResHelper.forceCast(this.f27560l.get(str), 0)).intValue()]);
            Intent intent = new Intent();
            intent.addFlags(411041792);
            intent.setComponent(componentName);
            intent.putExtra("workId", str2);
            intent.putExtra("duid", str3);
            intent.putExtra("appkey", u.a());
            intent.putExtra("pkg", MobSDK.getContext().getPackageName());
            intent.putExtra("guardId", MobMCL.getSuid());
            intent.putExtra("busType", i11);
            long currentTimeMillis = System.currentTimeMillis();
            hashMap.put("startActivityTime", Long.valueOf(currentTimeMillis));
            MobSDK.getContext().startActivity(intent);
            hashMap.put("startActivityDuration", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            Thread.sleep(320);
            a(MobSDK.getContext(), str, (e<Boolean>) new e<Boolean>() {
                public void a(Boolean bool) {
                    e a11 = e.a();
                    a11.a("[GD] stAct rst. pkg: " + str + ", lv: " + bool);
                    if (bool.booleanValue()) {
                        hashMap.put("executeResult", "success");
                    } else {
                        hashMap.put("executeResult", "uncertain");
                    }
                    e eVar = eVar;
                    if (eVar != null) {
                        eVar.a(hashMap);
                    }
                }
            });
        } catch (Throwable th2) {
            e.a().a(th2);
            e a11 = e.a();
            a11.a("[GD] stAct rst.  pkg: " + str + ", exception: " + th2.getMessage());
            hashMap.put("executeResult", "fail");
            if (eVar != null) {
                eVar.a(hashMap);
            }
        }
    }

    public void a(final String str, final boolean z11) {
        this.f27554f.execute(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(200);
                    c.this.a(false, str);
                    if (z11) {
                        Thread.sleep(500);
                        c.this.d();
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0119, code lost:
        r1 = (java.lang.Boolean) r1.poll(2000, java.util.concurrent.TimeUnit.MILLISECONDS);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r23, java.lang.String r24) {
        /*
            r22 = this;
            r7 = r22
            r0 = r23
            java.lang.String r8 = "times"
            java.lang.String r9 = "pkg"
            java.lang.String r10 = ", alwup: "
            com.mob.commons.j r1 = com.mob.commons.j.a()     // Catch:{ all -> 0x0201 }
            boolean r1 = r1.b()     // Catch:{ all -> 0x0201 }
            com.mob.mgs.impl.e r2 = com.mob.mgs.impl.e.a()     // Catch:{ all -> 0x0201 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0201 }
            r3.<init>()     // Catch:{ all -> 0x0201 }
            java.lang.String r4 = "[EC] isClear upl: "
            r3.append(r4)     // Catch:{ all -> 0x0201 }
            r3.append(r1)     // Catch:{ all -> 0x0201 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0201 }
            r2.a((java.lang.String) r3)     // Catch:{ all -> 0x0201 }
            if (r1 != 0) goto L_0x002d
            return
        L_0x002d:
            r11 = 0
            r7.f27561m = r11     // Catch:{ all -> 0x0201 }
            int r1 = r7.f27557i     // Catch:{ all -> 0x0201 }
            if (r0 == 0) goto L_0x003a
            java.util.List<java.util.HashMap<java.lang.String, java.lang.Object>> r1 = r7.f27559k     // Catch:{ all -> 0x0201 }
            int r1 = r1.size()     // Catch:{ all -> 0x0201 }
        L_0x003a:
            com.mob.mgs.impl.e r2 = com.mob.mgs.impl.e.a()     // Catch:{ all -> 0x0201 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0201 }
            r3.<init>()     // Catch:{ all -> 0x0201 }
            java.lang.String r4 = "[GD] uplvapp whole: "
            r3.append(r4)     // Catch:{ all -> 0x0201 }
            r3.append(r0)     // Catch:{ all -> 0x0201 }
            r3.append(r10)     // Catch:{ all -> 0x0201 }
            r3.append(r1)     // Catch:{ all -> 0x0201 }
            java.lang.String r4 = ", frm: "
            r3.append(r4)     // Catch:{ all -> 0x0201 }
            java.util.List<java.util.HashMap<java.lang.String, java.lang.Object>> r4 = r7.f27559k     // Catch:{ all -> 0x0201 }
            r3.append(r4)     // Catch:{ all -> 0x0201 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0201 }
            r2.a((java.lang.String) r3)     // Catch:{ all -> 0x0201 }
            if (r1 != 0) goto L_0x0065
            return
        L_0x0065:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x0201 }
            r12.<init>()     // Catch:{ all -> 0x0201 }
            java.util.List<java.util.HashMap<java.lang.String, java.lang.Object>> r2 = r7.f27559k     // Catch:{ all -> 0x0201 }
            java.util.Iterator r13 = r2.iterator()     // Catch:{ all -> 0x0201 }
        L_0x0070:
            boolean r2 = r13.hasNext()     // Catch:{ all -> 0x0201 }
            if (r2 == 0) goto L_0x01d9
            java.lang.Object r2 = r13.next()     // Catch:{ all -> 0x0201 }
            r14 = r2
            java.util.HashMap r14 = (java.util.HashMap) r14     // Catch:{ all -> 0x0201 }
            java.lang.Object r2 = r14.get(r9)     // Catch:{ all -> 0x0201 }
            r15 = 0
            java.lang.Object r2 = com.mob.tools.utils.ResHelper.forceCast(r2, r15)     // Catch:{ all -> 0x0201 }
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0201 }
            java.lang.Object r2 = r14.get(r8)     // Catch:{ all -> 0x0201 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0201 }
            java.lang.Object r2 = com.mob.tools.utils.ResHelper.forceCast(r2, r4)     // Catch:{ all -> 0x0201 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x0201 }
            int r6 = r2.intValue()     // Catch:{ all -> 0x0201 }
            if (r3 != 0) goto L_0x009e
            goto L_0x0070
        L_0x009e:
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x0201 }
            r5.<init>()     // Catch:{ all -> 0x0201 }
            r5.put(r9, r3)     // Catch:{ all -> 0x0201 }
            java.lang.String r4 = "executeResult"
            if (r6 > 0) goto L_0x00b3
            java.lang.String r2 = "ooo"
            r5.put(r4, r2)     // Catch:{ all -> 0x0201 }
            r12.add(r5)     // Catch:{ all -> 0x0201 }
            goto L_0x0070
        L_0x00b3:
            if (r1 > 0) goto L_0x00b7
            goto L_0x01d9
        L_0x00b7:
            int r2 = r1 + -1
            java.util.concurrent.LinkedBlockingQueue r1 = new java.util.concurrent.LinkedBlockingQueue     // Catch:{ all -> 0x0201 }
            r1.<init>()     // Catch:{ all -> 0x0201 }
            com.mob.mgs.impl.a r11 = com.mob.mgs.impl.a.a()     // Catch:{ all -> 0x0201 }
            int r11 = r11.a((java.lang.String) r3, (java.util.concurrent.LinkedBlockingQueue) r1)     // Catch:{ all -> 0x0201 }
            com.mob.mgs.impl.e r15 = com.mob.mgs.impl.e.a()     // Catch:{ all -> 0x0201 }
            r16 = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0201 }
            r4.<init>()     // Catch:{ all -> 0x0201 }
            r17 = r5
            java.lang.String r5 = "[GD] sendAliveCheckMessage appStatus: "
            r4.append(r5)     // Catch:{ all -> 0x0201 }
            r4.append(r11)     // Catch:{ all -> 0x0201 }
            java.lang.String r5 = ", whole: "
            r4.append(r5)     // Catch:{ all -> 0x0201 }
            r4.append(r0)     // Catch:{ all -> 0x0201 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0201 }
            r15.a((java.lang.String) r4)     // Catch:{ all -> 0x0201 }
            r15 = 1
            if (r11 != 0) goto L_0x0117
            if (r0 != 0) goto L_0x0117
            r5 = r24
            boolean r4 = r3.equals(r5)     // Catch:{ all -> 0x0201 }
            if (r4 != 0) goto L_0x0117
            java.util.concurrent.LinkedBlockingQueue r1 = new java.util.concurrent.LinkedBlockingQueue     // Catch:{ all -> 0x0201 }
            r1.<init>()     // Catch:{ all -> 0x0201 }
            android.content.Context r4 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x0201 }
            com.mob.mgs.impl.c$13 r11 = new com.mob.mgs.impl.c$13     // Catch:{ all -> 0x0201 }
            r11.<init>(r1)     // Catch:{ all -> 0x0201 }
            a((android.content.Context) r4, (java.lang.String) r3, (com.mob.tools.utils.e<java.lang.Boolean>) r11)     // Catch:{ all -> 0x0201 }
            r4 = 1000(0x3e8, double:4.94E-321)
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0201 }
            java.lang.Object r1 = r1.poll(r4, r11)     // Catch:{ all -> 0x0201 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0201 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0201 }
            goto L_0x012b
        L_0x0117:
            if (r11 != r15) goto L_0x012a
            r4 = 2000(0x7d0, double:9.88E-321)
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0201 }
            java.lang.Object r1 = r1.poll(r4, r11)     // Catch:{ all -> 0x0201 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0201 }
            if (r1 == 0) goto L_0x012a
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0201 }
            goto L_0x012b
        L_0x012a:
            r1 = 0
        L_0x012b:
            com.mob.mgs.impl.e r4 = com.mob.mgs.impl.e.a()     // Catch:{ all -> 0x0201 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0201 }
            r5.<init>()     // Catch:{ all -> 0x0201 }
            java.lang.String r11 = "[GD] Proc gd. pkgName: "
            r5.append(r11)     // Catch:{ all -> 0x0201 }
            r5.append(r3)     // Catch:{ all -> 0x0201 }
            java.lang.String r11 = ", islv: "
            r5.append(r11)     // Catch:{ all -> 0x0201 }
            r5.append(r1)     // Catch:{ all -> 0x0201 }
            java.lang.String r11 = ", times: "
            r5.append(r11)     // Catch:{ all -> 0x0201 }
            r5.append(r6)     // Catch:{ all -> 0x0201 }
            r5.append(r10)     // Catch:{ all -> 0x0201 }
            r5.append(r2)     // Catch:{ all -> 0x0201 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0201 }
            r4.a((java.lang.String) r5)     // Catch:{ all -> 0x0201 }
            if (r1 != 0) goto L_0x01b9
            java.util.concurrent.LinkedBlockingQueue r11 = new java.util.concurrent.LinkedBlockingQueue     // Catch:{ all -> 0x0201 }
            r11.<init>()     // Catch:{ all -> 0x0201 }
            r4 = 2000(0x7d0, float:2.803E-42)
            java.lang.String r5 = r7.f27555g     // Catch:{ all -> 0x0201 }
            com.mob.mgs.impl.f r1 = com.mob.mgs.impl.f.a()     // Catch:{ all -> 0x0201 }
            java.lang.String r18 = r1.f()     // Catch:{ all -> 0x0201 }
            com.mob.mgs.impl.c$14 r1 = new com.mob.mgs.impl.c$14     // Catch:{ all -> 0x0201 }
            r1.<init>(r11)     // Catch:{ all -> 0x0201 }
            r19 = r1
            r1 = r22
            r20 = r2
            r2 = r4
            r15 = r16
            r4 = r5
            r21 = r17
            r5 = r18
            r16 = r6
            r6 = r19
            r1.a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0201 }
            r1 = 3000(0xbb8, double:1.482E-320)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0201 }
            java.lang.Object r1 = r11.poll(r1, r3)     // Catch:{ all -> 0x0201 }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ all -> 0x0201 }
            java.lang.Object r2 = r1.get(r15)     // Catch:{ all -> 0x0201 }
            if (r2 == 0) goto L_0x019e
            java.lang.Object r2 = r1.get(r15)     // Catch:{ all -> 0x0201 }
            r15 = r2
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x0201 }
            goto L_0x019f
        L_0x019e:
            r15 = 0
        L_0x019f:
            java.lang.String r2 = "uncertain"
            boolean r2 = r2.equals(r15)     // Catch:{ all -> 0x0201 }
            if (r2 == 0) goto L_0x01aa
            r2 = 1
            r7.f27561m = r2     // Catch:{ all -> 0x0201 }
        L_0x01aa:
            r2 = r21
            r2.putAll(r1)     // Catch:{ all -> 0x0201 }
            int r6 = r16 + -1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0201 }
            r14.put(r8, r1)     // Catch:{ all -> 0x0201 }
            goto L_0x01c8
        L_0x01b9:
            r20 = r2
            r15 = r16
            r2 = r17
            r16 = r6
            java.lang.String r1 = "alive"
            r2.put(r15, r1)     // Catch:{ all -> 0x0201 }
            r6 = r16
        L_0x01c8:
            java.lang.String r1 = "remainCount"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0201 }
            r2.put(r1, r3)     // Catch:{ all -> 0x0201 }
            r12.add(r2)     // Catch:{ all -> 0x0201 }
            r1 = r20
            r11 = 0
            goto L_0x0070
        L_0x01d9:
            com.mob.mgs.impl.e r0 = com.mob.mgs.impl.e.a()     // Catch:{ all -> 0x0201 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0201 }
            r1.<init>()     // Catch:{ all -> 0x0201 }
            java.lang.String r2 = "[GD] uplvapp result: "
            r1.append(r2)     // Catch:{ all -> 0x0201 }
            r1.append(r12)     // Catch:{ all -> 0x0201 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0201 }
            r0.a((java.lang.String) r1)     // Catch:{ all -> 0x0201 }
            int r0 = r12.size()     // Catch:{ all -> 0x0201 }
            if (r0 <= 0) goto L_0x0225
            java.lang.String r0 = com.mob.mcl.MobMCL.getSuid()     // Catch:{ all -> 0x0201 }
            java.lang.String r1 = r7.f27555g     // Catch:{ all -> 0x0201 }
            com.mob.mgs.impl.d.a((java.util.List<java.util.HashMap<java.lang.String, java.lang.Object>>) r12, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0201 }
            goto L_0x0225
        L_0x0201:
            r0 = move-exception
            com.mob.mgs.impl.e r1 = com.mob.mgs.impl.e.a()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[GD] uplvapp exception: "
            r2.append(r3)
            java.lang.String r3 = r0.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.a((java.lang.String) r2)
            com.mob.mgs.impl.e r1 = com.mob.mgs.impl.e.a()
            r1.a((java.lang.Throwable) r0)
        L_0x0225:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.mgs.impl.c.a(boolean, java.lang.String):void");
    }

    private void a(String str, long j11) {
        this.f27562n = false;
        for (HashMap<String, Object> hashMap : this.f27559k) {
            String str2 = (String) ResHelper.forceCast(hashMap.get("pkg"), null);
            try {
                com.mob.apc.a aVar = new com.mob.apc.a();
                aVar.f26847a = 1003;
                Bundle bundle = new Bundle();
                bundle.putString("guardId", str);
                bundle.putLong("timestamp", j11);
                bundle.putString("workId", this.f27555g);
                aVar.f26851e = bundle;
                com.mob.apc.a a11 = b.a(1, str2, MobMGS.MGS_TAG, aVar, 5000);
                e a12 = e.a();
                a12.a("[Guard] syncId updateClientIDs sendAPCMessage :" + str2 + ", response: " + a11);
            } catch (Throwable th2) {
                e.a().a(th2);
                this.f27562n = true;
            }
        }
    }

    public com.mob.apc.a a(String str, com.mob.apc.a aVar, long j11) {
        Bundle bundle;
        e a11 = e.a();
        a11.a("[Guard] onAPCMessageReceive APCMessage:" + aVar + ", pkg:" + str);
        com.mob.apc.a aVar2 = new com.mob.apc.a();
        String suid = MobMCL.getSuid();
        long createSuidTime = MobMCL.getCreateSuidTime();
        int i11 = aVar.f26847a;
        if (i11 == 1001) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("guardId", suid);
            bundle2.putLong("timestamp", createSuidTime);
            bundle2.putString("pkg", MobSDK.getContext().getPackageName());
            aVar2.f26851e = bundle2;
        } else if (i11 == 1003 && (bundle = aVar.f26851e) != null) {
            final String string = bundle.getString("guardId");
            final long j12 = bundle.getLong("timestamp");
            bundle.getString("workId");
            if (string != null && j12 > 0 && !suid.equals(string) && j12 < createSuidTime) {
                new h() {
                    public void a() throws Throwable {
                        MobMCL.syncSuid(string, j12, new e<Boolean>() {
                            public void a(Boolean bool) {
                            }
                        });
                    }
                }.start();
            }
        }
        return aVar2;
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            Intent intent = new Intent();
            intent.putExtra("workId", bundle.getString("workId"));
            intent.putExtra("appkey", bundle.getString("appkey"));
            intent.putExtra("duid", bundle.getString("duid"));
            intent.putExtra("guardId", bundle.getString("guardId"));
            intent.putExtra("pkg", bundle.getString("pkg"));
            intent.putExtra("acServiceType", bundle.getInt("acsActType"));
        }
    }

    public HashMap<String, Object> a(int i11, String str) {
        int i12 = i11 == 1 ? 2001 : i11 == 2 ? 2002 : -1;
        e a11 = e.a();
        a11.a("[requestInvokeGd]finalBusType: " + i12);
        if (i12 == -1) {
            return new HashMap<>();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            a(i12, str, (e<HashMap<String, Object>>) new e<HashMap<String, Object>>() {
                public void a(HashMap<String, Object> hashMap) {
                    linkedBlockingQueue.offer(hashMap);
                }
            });
            return (HashMap) linkedBlockingQueue.poll(2000, TimeUnit.MILLISECONDS);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return hashMap;
        }
    }

    public boolean a(String str) {
        try {
            final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            a(str, (e<Boolean>) new e<Boolean>() {
                public void a(Boolean bool) {
                    linkedBlockingQueue.offer(bool);
                }
            });
            return ((Boolean) linkedBlockingQueue.poll(1000, TimeUnit.MILLISECONDS)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void a(Context context, final String str, final e<Boolean> eVar) {
        DH.requester(context).getMpfof(true, str, 0).request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                boolean z11 = false;
                try {
                    Object mpfof = dHResponse.getMpfof(new int[0]);
                    if (mpfof != null) {
                        int i11 = com.mob.tools.c.a(mpfof, str).flags;
                        boolean z12 = (i11 & 1) == 0 && (i11 & 128) == 0;
                        if ((i11 & 2097152) == 0) {
                            z11 = true;
                        }
                        if (!z12 || !z11) {
                            e eVar = eVar;
                            if (eVar != null) {
                                eVar.a(Boolean.FALSE);
                                return;
                            }
                            return;
                        }
                        e eVar2 = eVar;
                        if (eVar2 != null) {
                            eVar2.a(Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                    e eVar3 = eVar;
                    if (eVar3 != null) {
                        eVar3.a(Boolean.FALSE);
                    }
                } catch (Throwable th2) {
                    e.a().b(th2);
                    e eVar4 = eVar;
                    if (eVar4 != null) {
                        eVar4.a(Boolean.FALSE);
                    }
                }
            }
        });
    }

    private void a(int i11, String str, String str2, String str3, e<HashMap<String, Object>> eVar) {
        e a11 = e.a();
        a11.a("[GD]busType: " + i11 + ", target: " + str + ", workId: " + str2 + ", duid: " + str3);
        final String str4 = str;
        final e<HashMap<String, Object>> eVar2 = eVar;
        final int i12 = i11;
        final String str5 = str2;
        final String str6 = str3;
        a(MobSDK.getContext(), str, (e<Boolean>) new e<Boolean>() {
            public void a(Boolean bool) {
                e a11 = e.a();
                a11.a("[GD]target: " + str4 + ", isLv: " + bool);
                if (bool.booleanValue()) {
                    e eVar = eVar2;
                    if (eVar != null) {
                        eVar.a(new HashMap());
                    }
                } else if (c.this.f27560l == null) {
                    c.this.a((e<List<HashMap<String, String>>>) new e<List<HashMap<String, String>>>() {
                        public void a(List<HashMap<String, String>> list) {
                            AnonymousClass6 r82 = AnonymousClass6.this;
                            if (eVar2 != null) {
                                c.this.b(i12, str4, str5, str6, new e<HashMap<String, Object>>() {
                                    public void a(HashMap<String, Object> hashMap) {
                                        eVar2.a(hashMap);
                                    }
                                });
                            }
                        }
                    });
                } else if (eVar2 != null) {
                    c.this.b(i12, str4, str5, str6, new e<HashMap<String, Object>>() {
                        public void a(HashMap<String, Object> hashMap) {
                            eVar2.a(hashMap);
                        }
                    });
                }
            }
        });
    }

    public void a(int i11, String str, e<HashMap<String, Object>> eVar) {
        a(i11, str, this.f27555g, f.a().f(), eVar);
    }

    private void a(String str, final e<Boolean> eVar) {
        StringBuilder sb2;
        e eVar2;
        boolean z11;
        final boolean[] zArr = {false};
        try {
            if (this.f27563o.equals(str) && eVar != null) {
                zArr[0] = true;
                eVar.a(Boolean.valueOf(zArr[0]));
            }
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            int a11 = a.a().a(str, linkedBlockingQueue);
            if (a11 == 0) {
                a(this.f27563o, str, (e<Boolean>) new e<Boolean>() {
                    public void a(Boolean bool) {
                        if (eVar != null) {
                            zArr[0] = bool.booleanValue();
                            eVar.a(Boolean.valueOf(zArr[0]));
                        }
                    }
                });
            } else if (a11 == 1) {
                Boolean bool = (Boolean) linkedBlockingQueue.poll(2000, TimeUnit.MILLISECONDS);
                if (bool != null) {
                    zArr[0] = bool.booleanValue();
                }
                if (eVar != null) {
                    eVar.a(Boolean.valueOf(zArr[0]));
                }
            }
            eVar2 = e.a();
            sb2 = new StringBuilder();
            sb2.append("checkAppLive appStatus: ");
            sb2.append(a11);
            sb2.append(", isLive: ");
            z11 = zArr[0];
        } catch (Throwable th2) {
            e a12 = e.a();
            a12.a("checkAppLive appStatus: " + -1 + ", isLive: " + zArr[0]);
            throw th2;
        }
        sb2.append(z11);
        eVar2.a(sb2.toString());
    }
}
