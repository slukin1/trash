package com.mob.tools.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GnssStatus;
import android.os.Build;
import android.os.Handler;
import com.mob.MobSDK;
import com.mob.commons.CSCenter;
import com.mob.commons.d;
import com.mob.commons.l;
import com.mob.tools.MobLog;
import com.mob.tools.b.e;
import com.mob.tools.b.h;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ReflectHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"MissingPermission"})
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f28173a;

    /* renamed from: b  reason: collision with root package name */
    private volatile List f28174b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public volatile List f28175c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile Object f28176d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Object f28177e = f();

    /* renamed from: f  reason: collision with root package name */
    private volatile Class<?> f28178f;

    /* renamed from: g  reason: collision with root package name */
    private long f28179g;

    /* renamed from: h  reason: collision with root package name */
    private a f28180h;

    /* renamed from: i  reason: collision with root package name */
    private volatile Object f28181i;

    public interface a {
        void a();
    }

    private f() {
    }

    private Object f() {
        HashMap hashMap = new HashMap();
        final int identityHashCode = System.identityHashCode(hashMap);
        try {
            hashMap.put(l.a("0178fm^g5hgfm'efkCfkfm$gLgfXjfg]glLh?fe"), new ReflectHelper.a<Object[], Object>() {
                /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public java.lang.Object a(java.lang.Object[] r5) {
                    /*
                        r4 = this;
                        if (r5 == 0) goto L_0x0041
                        int r0 = r5.length     // Catch:{ all -> 0x0051 }
                        if (r0 <= 0) goto L_0x0041
                        com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0051 }
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
                        r1.<init>()     // Catch:{ all -> 0x0051 }
                        java.lang.String r2 = "[212] oncge"
                        r1.append(r2)     // Catch:{ all -> 0x0051 }
                        r2 = 0
                        r3 = r5[r2]     // Catch:{ all -> 0x0051 }
                        r1.append(r3)     // Catch:{ all -> 0x0051 }
                        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0051 }
                        java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0051 }
                        r0.d(r1, r3)     // Catch:{ all -> 0x0051 }
                        r0 = r5[r2]     // Catch:{ all -> 0x0051 }
                        boolean r0 = r0 instanceof java.util.List     // Catch:{ all -> 0x0051 }
                        if (r0 == 0) goto L_0x0036
                        r5 = r5[r2]     // Catch:{ all -> 0x0051 }
                        java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x0051 }
                        com.mob.tools.utils.f r0 = com.mob.tools.utils.f.this     // Catch:{ all -> 0x0051 }
                        java.util.List r0 = r0.f28175c     // Catch:{ all -> 0x0051 }
                        r0.addAll(r5)     // Catch:{ all -> 0x0051 }
                        goto L_0x0041
                    L_0x0036:
                        com.mob.tools.utils.f r0 = com.mob.tools.utils.f.this     // Catch:{ all -> 0x0051 }
                        java.util.List r0 = r0.f28175c     // Catch:{ all -> 0x0051 }
                        r5 = r5[r2]     // Catch:{ all -> 0x0051 }
                        r0.add(r5)     // Catch:{ all -> 0x0051 }
                    L_0x0041:
                        com.mob.tools.utils.f r5 = com.mob.tools.utils.f.this     // Catch:{ all -> 0x0051 }
                        r5.i()     // Catch:{ all -> 0x0051 }
                        com.mob.tools.utils.f r5 = com.mob.tools.utils.f.this
                        monitor-enter(r5)
                        r4.notifyAll()     // Catch:{ all -> 0x004e }
                        monitor-exit(r5)     // Catch:{ all -> 0x004e }
                        goto L_0x0060
                    L_0x004e:
                        r0 = move-exception
                        monitor-exit(r5)     // Catch:{ all -> 0x004e }
                        throw r0
                    L_0x0051:
                        r5 = move-exception
                        com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0065 }
                        r0.d(r5)     // Catch:{ all -> 0x0065 }
                        com.mob.tools.utils.f r5 = com.mob.tools.utils.f.this
                        monitor-enter(r5)
                        r4.notifyAll()     // Catch:{ all -> 0x0062 }
                        monitor-exit(r5)     // Catch:{ all -> 0x0062 }
                    L_0x0060:
                        r5 = 0
                        return r5
                    L_0x0062:
                        r0 = move-exception
                        monitor-exit(r5)     // Catch:{ all -> 0x0062 }
                        throw r0
                    L_0x0065:
                        r5 = move-exception
                        com.mob.tools.utils.f r0 = com.mob.tools.utils.f.this
                        monitor-enter(r0)
                        r4.notifyAll()     // Catch:{ all -> 0x006e }
                        monitor-exit(r0)     // Catch:{ all -> 0x006e }
                        throw r5
                    L_0x006e:
                        r5 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x006e }
                        throw r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.f.AnonymousClass5.a(java.lang.Object[]):java.lang.Object");
                }
            });
            hashMap.put("equals", new ReflectHelper.a<Object[], Object>() {
                public Object a(Object[] objArr) {
                    NLog instance = MobLog.getInstance();
                    boolean z11 = false;
                    instance.d("equals " + objArr, new Object[0]);
                    if (objArr == null || objArr[0] == null) {
                        return Boolean.FALSE;
                    }
                    if (objArr[0].hashCode() == identityHashCode) {
                        z11 = true;
                    }
                    return Boolean.valueOf(z11);
                }
            });
            hashMap.put(l.a("008jf*hk(jEgffmfeCh"), new ReflectHelper.a<Object[], Object>() {
                public Object a(Object[] objArr) {
                    MobLog.getInstance().d(l.a("008jfRhk%jFgffmfe,h"), new Object[0]);
                    return Integer.valueOf(identityHashCode);
                }
            });
            return ReflectHelper.createProxy((Map<String, ReflectHelper.a<Object[], Object>>) hashMap, (Class<?>[]) new Class[]{j()});
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    private GnssStatus.Callback g() {
        if (Build.VERSION.SDK_INT >= 31) {
            return new GnssStatus.Callback() {
                public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
                    super.onSatelliteStatusChanged(gnssStatus);
                    f.this.h();
                }
            };
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void h() {
        try {
            a aVar = this.f28180h;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2, "%s", "[cl]");
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        if (this.f28177e != null) {
            ReflectHelper.invokeInstanceMethod(this.f28176d, l.a("013]fl2hHfhfmff6hDgmIl3feUfkh(hk"), new Object[]{this.f28177e}, new Class[]{j()}, null);
        }
    }

    private Class<?> j() {
        if (this.f28178f == null) {
            try {
                this.f28178f = Class.forName(l.a("033fg feflfmfkfefn1i:fm3efk^fkfm'gUfnhgfmQefk$fkfm gKhgfkhk5khgh6fl"));
            } catch (Throwable unused) {
            }
        }
        return this.f28178f;
    }

    public static f a() {
        if (f28173a == null) {
            synchronized (f.class) {
                if (f28173a == null) {
                    f28173a = new f();
                }
            }
        }
        return f28173a;
    }

    private Object b(String str) {
        if (Build.VERSION.SDK_INT <= 25) {
            return e.a(MobSDK.getContext()).b(str);
        }
        try {
            return h.a(MobSDK.getContext(), str);
        } catch (Throwable unused) {
            return e.a(MobSDK.getContext()).b(str);
        }
    }

    private void d() {
        if (d.g()) {
            try {
                if (DH.SyncMtd.checkPermission(l.a("039fgGfeflfmfkfefnUlhPflfhfkhkhkfkfmNgOfnhfgfgfikgngnfjiegggiikfjhgijgfhfheggijgi"))) {
                    if (this.f28176d == null) {
                        this.f28176d = DH.SyncMtd.getSystemServiceSafe(l.a("008iVfmLefkEfkfmTg"));
                    }
                    if (this.f28176d != null) {
                        int i11 = Build.VERSION.SDK_INT;
                        if (i11 < 31 && MobSDK.getContext().getApplicationInfo().targetSdkVersion < 31) {
                            com.mob.commons.a.l.a().b().post(new Runnable() {
                                public void run() {
                                    try {
                                        Object a11 = f.this.f28176d;
                                        String a12 = l.a("020f-fefekfUlJhkgnDkfk;fihkhgfkhk_khghAfl");
                                        Object[] objArr = {f.this.e()};
                                        ReflectHelper.invokeInstanceMethod(a11, a12, objArr, new Class[]{Class.forName(l.a("026fgIfeflfmfkfefnPi(fmPefkWfkfm.g%fnkfJl4hkgn2kfk;fihk") + "$" + l.a("008[hgfkhk9khgh[fl"))});
                                        MobLog.getInstance().d("[212] rg < 31", new Object[0]);
                                    } catch (Throwable th2) {
                                        MobLog.getInstance().d(th2, "%s", "[cl]");
                                    }
                                }
                            });
                        } else if (i11 >= 31) {
                            ReflectHelper.invokeInstanceMethod(this.f28176d, l.a("0262flPh.glfkhk%kh flkf^g2hkhkgnHkfk@fihkgfRfii,hhKfeEgj"), new Object[]{g(), com.mob.commons.a.l.a().b()}, new Class[]{GnssStatus.Callback.class, Handler.class});
                            MobLog.getInstance().d("[212] rg >= 31", new Object[0]);
                        }
                    }
                }
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2, "%s", "[212]");
            }
        }
    }

    /* access modifiers changed from: private */
    public Object e() throws Throwable {
        HashMap hashMap = new HashMap();
        final int identityHashCode = System.identityHashCode(hashMap);
        hashMap.put(l.a("018QfmBg(kf>l hkgnWkfkLfihkgf$jfgOgl3h2fe"), new ReflectHelper.a<Object[], Object>() {
            public Object a(Object[] objArr) {
                if (objArr == null || objArr[0].intValue() != 4) {
                    return null;
                }
                f.this.h();
                return null;
            }
        });
        hashMap.put("equals", new ReflectHelper.a<Object[], Object>() {
            public Object a(Object[] objArr) {
                if (objArr != null) {
                    boolean z11 = false;
                    if (objArr[0] != null) {
                        if (objArr[0].hashCode() == identityHashCode) {
                            z11 = true;
                        }
                        return Boolean.valueOf(z11);
                    }
                }
                return Boolean.FALSE;
            }
        });
        hashMap.put(l.a("008jf+hkEj_gffmfeRh"), new ReflectHelper.a<Object[], Object>() {
            public Object a(Object[] objArr) {
                return Integer.valueOf(identityHashCode);
            }
        });
        return ReflectHelper.createProxy((Map<String, ReflectHelper.a<Object[], Object>>) hashMap, (Class<?>[]) new Class[]{Class.forName(l.a("026fg8feflfmfkfefnWi^fm5efkLfkfm)g1fnkfDlBhkgn_kfk*fihk") + "$" + l.a("008^hgfkhk'khghMfl"))});
    }

    public Object c() {
        return b(l.a("003WglSlPhk"));
    }

    private void b(Context context, String str, long j11) {
        if (d.e()) {
            try {
                e.a(context).a(str, 1000, 0.0f, this.f28177e);
                wait(j11);
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
            i();
        }
    }

    public void a(a aVar) {
        this.f28180h = aVar;
        d();
    }

    public List a(Context context, int i11, int i12, boolean z11, boolean z12) {
        ArrayList arrayList = new ArrayList();
        if (CSCenter.getInstance().isLocationDataEnable()) {
            arrayList.addAll(a(z12));
            if (arrayList.isEmpty()) {
                synchronized (f.class) {
                    arrayList.addAll(a(z12));
                    if (arrayList.isEmpty()) {
                        arrayList.addAll(a(context, i11, i12, z11));
                    }
                }
            }
        } else {
            arrayList.add(CSCenter.getInstance().getLocation());
        }
        return arrayList;
    }

    public Object b() {
        return this.f28181i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025 A[Catch:{ all -> 0x005e, all -> 0x0121 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009b A[Catch:{ all -> 0x005e, all -> 0x0121 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d6 A[Catch:{ all -> 0x005e, all -> 0x0121 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List a(android.content.Context r7, int r8, int r9, boolean r10) {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = "039fgAfeflfmfkfefn-lh_flfhfkhkhkfkfm_g)fnhfgfgfikgngnfjiegggiikfjhgijgfhfheggijgi"
            java.lang.String r1 = com.mob.commons.l.a((java.lang.String) r1)     // Catch:{ all -> 0x0121 }
            boolean r1 = com.mob.tools.utils.DH.SyncMtd.checkPermission(r1)     // Catch:{ all -> 0x0121 }
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0022
            java.lang.String r1 = "041fgLfeflfmfkfefn,lh*flfhfkhkhkfkfmDgNfnhfgfgfikgngnfjgfijhfilgnikfjhgijgfhfheggijgi"
            java.lang.String r1 = com.mob.commons.l.a((java.lang.String) r1)     // Catch:{ all -> 0x0121 }
            boolean r1 = com.mob.tools.utils.DH.SyncMtd.checkPermission(r1)     // Catch:{ all -> 0x0121 }
            if (r1 == 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r1 = r2
            goto L_0x0023
        L_0x0022:
            r1 = r3
        L_0x0023:
            if (r1 == 0) goto L_0x0085
            java.lang.Object r1 = r6.f28176d     // Catch:{ all -> 0x0121 }
            if (r1 != 0) goto L_0x0035
            java.lang.String r1 = "008i-fm%efkOfkfmEg"
            java.lang.String r1 = com.mob.commons.l.a((java.lang.String) r1)     // Catch:{ all -> 0x0121 }
            java.lang.Object r1 = com.mob.tools.utils.DH.SyncMtd.getSystemServiceSafe(r1)     // Catch:{ all -> 0x0121 }
            r6.f28176d = r1     // Catch:{ all -> 0x0121 }
        L_0x0035:
            java.lang.Object r1 = r6.f28176d     // Catch:{ all -> 0x0121 }
            if (r1 != 0) goto L_0x003b
            r7 = 0
            return r7
        L_0x003b:
            monitor-enter(r6)     // Catch:{ all -> 0x0121 }
            if (r8 == 0) goto L_0x0040
            r1 = r3
            goto L_0x0041
        L_0x0040:
            r1 = r2
        L_0x0041:
            if (r1 == 0) goto L_0x0060
            java.lang.Object r1 = r6.f28176d     // Catch:{ all -> 0x005e }
            java.lang.String r4 = "003Hgl6lQhk"
            java.lang.String r4 = com.mob.commons.l.a((java.lang.String) r4)     // Catch:{ all -> 0x005e }
            boolean r1 = r6.a(r1, r4)     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0060
            java.lang.String r1 = "003=gl;l$hk"
            java.lang.String r1 = com.mob.commons.l.a((java.lang.String) r1)     // Catch:{ all -> 0x005e }
            int r8 = r8 * 1000
            long r4 = (long) r8     // Catch:{ all -> 0x005e }
            r6.a(r7, r1, r4)     // Catch:{ all -> 0x005e }
            goto L_0x0060
        L_0x005e:
            r7 = move-exception
            goto L_0x0083
        L_0x0060:
            if (r9 == 0) goto L_0x0064
            r8 = r3
            goto L_0x0065
        L_0x0064:
            r8 = r2
        L_0x0065:
            if (r8 == 0) goto L_0x0081
            java.lang.Object r8 = r6.f28176d     // Catch:{ all -> 0x005e }
            java.lang.String r1 = "007ghkYhifmflgj"
            java.lang.String r1 = com.mob.commons.l.a((java.lang.String) r1)     // Catch:{ all -> 0x005e }
            boolean r8 = r6.a(r8, r1)     // Catch:{ all -> 0x005e }
            if (r8 == 0) goto L_0x0081
            java.lang.String r8 = "007ghk(hifmflgj"
            java.lang.String r8 = com.mob.commons.l.a((java.lang.String) r8)     // Catch:{ all -> 0x005e }
            int r9 = r9 * 1000
            long r4 = (long) r9     // Catch:{ all -> 0x005e }
            r6.a(r7, r8, r4)     // Catch:{ all -> 0x005e }
        L_0x0081:
            monitor-exit(r6)     // Catch:{ all -> 0x005e }
            goto L_0x0085
        L_0x0083:
            monitor-exit(r6)     // Catch:{ all -> 0x005e }
            throw r7     // Catch:{ all -> 0x0121 }
        L_0x0085:
            java.util.List r7 = r6.f28175c     // Catch:{ all -> 0x0121 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0121 }
            if (r7 == 0) goto L_0x00ce
            if (r10 == 0) goto L_0x00ce
            java.lang.String r7 = "003)gl2l+hk"
            java.lang.String r7 = com.mob.commons.l.a((java.lang.String) r7)     // Catch:{ all -> 0x0121 }
            java.lang.Object r7 = r6.b((java.lang.String) r7)     // Catch:{ all -> 0x0121 }
            if (r7 == 0) goto L_0x00a0
            java.util.List r8 = r6.f28175c     // Catch:{ all -> 0x0121 }
            r8.add(r7)     // Catch:{ all -> 0x0121 }
        L_0x00a0:
            java.util.List r7 = r6.f28175c     // Catch:{ all -> 0x0121 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0121 }
            if (r7 == 0) goto L_0x00b9
            java.lang.String r7 = "007ghkLhifmflgj"
            java.lang.String r7 = com.mob.commons.l.a((java.lang.String) r7)     // Catch:{ all -> 0x0121 }
            java.lang.Object r7 = r6.b((java.lang.String) r7)     // Catch:{ all -> 0x0121 }
            if (r7 == 0) goto L_0x00b9
            java.util.List r8 = r6.f28175c     // Catch:{ all -> 0x0121 }
            r8.add(r7)     // Catch:{ all -> 0x0121 }
        L_0x00b9:
            java.util.List r7 = r6.f28175c     // Catch:{ all -> 0x0121 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0121 }
            if (r7 == 0) goto L_0x00ce
            java.lang.String r7 = "passive"
            java.lang.Object r7 = r6.b((java.lang.String) r7)     // Catch:{ all -> 0x0121 }
            if (r7 == 0) goto L_0x00ce
            java.util.List r8 = r6.f28175c     // Catch:{ all -> 0x0121 }
            r8.add(r7)     // Catch:{ all -> 0x0121 }
        L_0x00ce:
            java.util.List r7 = r6.f28175c     // Catch:{ all -> 0x0121 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0121 }
            if (r7 != 0) goto L_0x0129
            java.util.List r7 = r6.f28175c     // Catch:{ all -> 0x0121 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0121 }
        L_0x00dc:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x0121 }
            if (r8 == 0) goto L_0x0115
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x0121 }
            if (r8 == 0) goto L_0x00dc
            java.util.List r9 = r6.f28174b     // Catch:{ all -> 0x0121 }
            java.lang.String r10 = "025fg1feflfmfkfefn'iTfm*efkZfkfm,g]fnhgfm,efk0fkfmCg"
            java.lang.String r10 = com.mob.commons.l.a((java.lang.String) r10)     // Catch:{ all -> 0x0121 }
            java.lang.String r10 = com.mob.tools.utils.ReflectHelper.importClass(r10)     // Catch:{ all -> 0x0121 }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x0121 }
            r1[r2] = r8     // Catch:{ all -> 0x0121 }
            java.lang.Object r10 = com.mob.tools.utils.ReflectHelper.newInstance(r10, r1)     // Catch:{ all -> 0x0121 }
            r9.add(r10)     // Catch:{ all -> 0x0121 }
            java.lang.String r9 = "025fgWfeflfmfkfefnWi fm+efk_fkfm?g<fnhgfm@efkPfkfm<g"
            java.lang.String r9 = com.mob.commons.l.a((java.lang.String) r9)     // Catch:{ all -> 0x0121 }
            java.lang.String r9 = com.mob.tools.utils.ReflectHelper.importClass(r9)     // Catch:{ all -> 0x0121 }
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ all -> 0x0121 }
            r10[r2] = r8     // Catch:{ all -> 0x0121 }
            java.lang.Object r8 = com.mob.tools.utils.ReflectHelper.newInstance(r9, r10)     // Catch:{ all -> 0x0121 }
            r0.add(r8)     // Catch:{ all -> 0x0121 }
            goto L_0x00dc
        L_0x0115:
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0121 }
            r6.f28179g = r7     // Catch:{ all -> 0x0121 }
            java.util.List r7 = r6.f28175c     // Catch:{ all -> 0x0121 }
            r7.clear()     // Catch:{ all -> 0x0121 }
            goto L_0x0129
        L_0x0121:
            r7 = move-exception
            com.mob.tools.log.NLog r8 = com.mob.tools.MobLog.getInstance()
            r8.d(r7)
        L_0x0129:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.f.a(android.content.Context, int, int, boolean):java.util.List");
    }

    private void a(Context context, String str, long j11) {
        if (Build.VERSION.SDK_INT <= 25) {
            b(context, str, j11);
            return;
        }
        try {
            Object a11 = h.a(context, str, j11);
            if (a11 != null) {
                this.f28175c.add(a11);
            }
        } catch (Throwable th2) {
            NLog instance = MobLog.getInstance();
            instance.d("[212] cur err " + th2, new Object[0]);
            b(context, str, j11);
        }
    }

    private boolean a(Object obj, String str) {
        if (d.e()) {
            if (((Boolean) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("017<fkhkinflfmfffkfeIhKflik6gf3hhLihKfe"), Boolean.FALSE, str)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private List a(boolean z11) {
        ArrayList arrayList = new ArrayList();
        if (!z11) {
            try {
                if (!this.f28174b.isEmpty() && System.currentTimeMillis() - this.f28179g <= 180000) {
                    for (Object next : this.f28174b) {
                        if (next != null) {
                            arrayList.add(ReflectHelper.newInstance(ReflectHelper.importClass(l.a("025fg)feflfmfkfefn8iBfmUefkTfkfmBg*fnhgfm;efk]fkfm!g")), next));
                        }
                    }
                    return arrayList;
                }
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        this.f28174b.clear();
        return arrayList;
    }

    public void a(Object obj) {
        if (obj != null) {
            this.f28181i = obj;
        }
    }

    public boolean a(String str) {
        return (l.a("003SglMl>hk").equalsIgnoreCase(str) && DH.SyncMtd.checkPermission(l.a("039fg*feflfmfkfefnTlh+flfhfkhkhkfkfm=gDfnhfgfgfikgngnfjiegggiikfjhgijgfhfheggijgi"))) || (l.a("007ghkVhifmflgj").equalsIgnoreCase(str) && DH.SyncMtd.checkPermission(l.a("039fgQfeflfmfkfefnZlhBflfhfkhkhkfkfm gWfnhfgfgfikgngnfjiegggiikfjhgijgfhfheggijgi"))) || ((l.a("007ghk(hifmflgj").equalsIgnoreCase(str) && DH.SyncMtd.checkPermission(l.a("041fgDfeflfmfkfefnSlhSflfhfkhkhkfkfm_gIfnhfgfgfikgngnfjgfijhfilgnikfjhgijgfhfheggijgi"))) || (("passive".equalsIgnoreCase(str) && DH.SyncMtd.checkPermission(l.a("039fgEfeflfmfkfefn:lhHflfhfkhkhkfkfmSg:fnhfgfgfikgngnfjiegggiikfjhgijgfhfheggijgi"))) || ("passive".equalsIgnoreCase(str) && DH.SyncMtd.checkPermission(l.a("041fg'feflfmfkfefnWlhXflfhfkhkhkfkfm8gFfnhfgfgfikgngnfjgfijhfilgnikfjhgijgfhfheggijgi")))));
    }
}
