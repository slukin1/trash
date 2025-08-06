package com.mob.commons;

import android.os.Build;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.a;
import com.mob.commons.a.l;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class y {

    /* renamed from: e  reason: collision with root package name */
    private static volatile y f27362e;

    /* renamed from: a  reason: collision with root package name */
    private volatile String f27363a = null;

    /* renamed from: b  reason: collision with root package name */
    private volatile String f27364b = null;

    /* renamed from: c  reason: collision with root package name */
    private volatile String f27365c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile String f27366d = null;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, Integer> f27367f;

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f27368g = new byte[0];

    /* renamed from: h  reason: collision with root package name */
    private final byte[] f27369h = new byte[0];

    private y() {
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                HashMap hashMap = (HashMap) ab.a().a("key_drds");
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                if (hashMap.containsKey(str)) {
                    int intValue = ((Integer) hashMap.get(str)).intValue();
                    if (intValue < 100000) {
                        hashMap.put(str, Integer.valueOf(intValue + 1));
                    }
                } else {
                    hashMap.put(str, 1);
                }
                ArrayList<Map.Entry> arrayList = new ArrayList<>(hashMap.entrySet());
                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() {
                    /* renamed from: a */
                    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                        return entry2.getValue().compareTo(entry.getValue());
                    }
                });
                for (int size = arrayList.size(); size > 7; size--) {
                    arrayList.remove(size - 1);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : arrayList) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
                ab.a().a("key_drds", (Object) linkedHashMap);
                this.f27367f = new LinkedHashMap();
                int min = Math.min(3, arrayList.size());
                for (int i11 = 0; i11 < min; i11++) {
                    Map.Entry entry2 = (Map.Entry) arrayList.get(i11);
                    this.f27367f.put(entry2.getKey(), entry2.getValue());
                }
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }

    private String j() {
        if (!TextUtils.isEmpty(h())) {
            return "12" + c(h());
        } else if (!TextUtils.isEmpty(g())) {
            return "22" + c(g());
        } else if (!TextUtils.isEmpty(l())) {
            return "32" + c(this.f27366d);
        } else {
            return "42" + c(UUID.randomUUID().toString());
        }
    }

    private String k() {
        if (!TextUtils.isEmpty(h())) {
            return "12" + c(h());
        }
        return "42" + c(UUID.randomUUID().toString());
    }

    private String l() {
        DH.requester(MobSDK.getContext()).getOD().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                String od2 = dHResponse.getOD();
                List<String> asList = Arrays.asList(new String[]{"00000000-0000-0000-0000-000000000000", "00000000000000000000000000000000"});
                a.c i11 = ab.a().i();
                if (!(i11 == null || i11.d() == null)) {
                    asList = i11.d();
                }
                if (!TextUtils.isEmpty(od2) && !asList.contains(od2)) {
                    String unused = y.this.f27366d = od2;
                }
            }
        });
        return this.f27366d;
    }

    private String m() throws Throwable {
        if (Build.VERSION.SDK_INT < 18) {
            return null;
        }
        final String[] strArr = {null};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        z.f27384c.execute(new i() {
            /* JADX WARNING: Removed duplicated region for block: B:18:0x00b5 A[Catch:{ all -> 0x00c1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x00bb A[Catch:{ all -> 0x00c1 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a() {
                /*
                    r15 = this;
                    long r0 = java.lang.System.currentTimeMillis()
                    java.lang.String r2 = "061h)fjkgeeiigiiiEg)fgjlik4gdRemeeThCiigj?dgKfgedimemejfkejggjliikgjlieem0j3fkfj2dRfjijggKdWggemelgjfkijedifigif-d%iiigigjljl?d'iggi"
                    java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)
                    java.util.UUID r3 = new java.util.UUID
                    r4 = -1301668207276963122(0xedef8ba979d64ace, double:-3.563403477674908E221)
                    r6 = -6645017420763422227(0xa3c827dcd51d21ed, double:-2.5964014370906125E-136)
                    r3.<init>(r4, r6)
                    r4 = 28
                    r5 = 0
                    android.media.MediaDrm r13 = new android.media.MediaDrm     // Catch:{ all -> 0x00a4 }
                    r13.<init>(r3)     // Catch:{ all -> 0x00a4 }
                    android.content.Context r5 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x00a1 }
                    com.mob.tools.a.d r6 = com.mob.tools.a.d.a((android.content.Context) r5)     // Catch:{ all -> 0x00a1 }
                    java.lang.Class r7 = r13.getClass()     // Catch:{ all -> 0x00a1 }
                    java.lang.String r5 = "012fej]ejeeFgVeigj8gj:ehFk"
                    java.lang.String r9 = com.mob.commons.a.l.a((java.lang.String) r5)     // Catch:{ all -> 0x00a1 }
                    r5 = 3
                    java.lang.Class[] r10 = new java.lang.Class[r5]     // Catch:{ all -> 0x00a1 }
                    java.lang.Class<java.lang.Object> r8 = java.lang.Object.class
                    r14 = 0
                    r10[r14] = r8     // Catch:{ all -> 0x00a1 }
                    java.lang.Class<byte[]> r8 = byte[].class
                    r11 = 1
                    r10[r11] = r8     // Catch:{ all -> 0x00a1 }
                    java.lang.Class<java.lang.String> r8 = java.lang.String.class
                    r12 = 2
                    r10[r12] = r8     // Catch:{ all -> 0x00a1 }
                    java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00a1 }
                    java.lang.ref.WeakReference r8 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x00a1 }
                    r8.<init>(r13)     // Catch:{ all -> 0x00a1 }
                    r5[r14] = r8     // Catch:{ all -> 0x00a1 }
                    com.mob.commons.y r8 = com.mob.commons.y.this     // Catch:{ all -> 0x00a1 }
                    byte[] r3 = r8.a((java.util.UUID) r3)     // Catch:{ all -> 0x00a1 }
                    r5[r11] = r3     // Catch:{ all -> 0x00a1 }
                    r5[r12] = r2     // Catch:{ all -> 0x00a1 }
                    r12 = 0
                    r8 = r13
                    r11 = r5
                    r6.a((java.lang.Class) r7, (java.lang.Object) r8, (java.lang.String) r9, (java.lang.Class[]) r10, (java.lang.Object[]) r11, r12)     // Catch:{ all -> 0x00a1 }
                    java.lang.String r2 = "014EedPgHeeejYdg5fl=f;ejefehTg$ffed"
                    java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)     // Catch:{ all -> 0x00a1 }
                    byte[] r2 = r13.getPropertyByteArray(r2)     // Catch:{ all -> 0x00a1 }
                    java.lang.String[] r3 = r0     // Catch:{ all -> 0x00a1 }
                    int r5 = r2.length     // Catch:{ all -> 0x00a1 }
                    java.lang.String r2 = com.mob.tools.utils.Data.byteToHex(r2, r14, r5)     // Catch:{ all -> 0x00a1 }
                    r3[r14] = r2     // Catch:{ all -> 0x00a1 }
                    com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x00a1 }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a1 }
                    r3.<init>()     // Catch:{ all -> 0x00a1 }
                    java.lang.String r5 = "rddd wv c "
                    r3.append(r5)     // Catch:{ all -> 0x00a1 }
                    long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00a1 }
                    long r5 = r5 - r0
                    r3.append(r5)     // Catch:{ all -> 0x00a1 }
                    java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00a1 }
                    java.lang.Object[] r1 = new java.lang.Object[r14]     // Catch:{ all -> 0x00a1 }
                    r2.d(r0, r1)     // Catch:{ all -> 0x00a1 }
                    java.util.concurrent.CountDownLatch r0 = r1     // Catch:{ all -> 0x00c1 }
                    r0.countDown()     // Catch:{ all -> 0x00c1 }
                    int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00c1 }
                    if (r0 < r4) goto L_0x009d
                    r13.close()     // Catch:{ all -> 0x00c1 }
                    goto L_0x00c9
                L_0x009d:
                    r13.release()     // Catch:{ all -> 0x00c1 }
                    goto L_0x00c9
                L_0x00a1:
                    r0 = move-exception
                    r5 = r13
                    goto L_0x00a5
                L_0x00a4:
                    r0 = move-exception
                L_0x00a5:
                    com.mob.tools.log.NLog r1 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x00ca }
                    r1.d(r0)     // Catch:{ all -> 0x00ca }
                    java.util.concurrent.CountDownLatch r0 = r1     // Catch:{ all -> 0x00c1 }
                    r0.countDown()     // Catch:{ all -> 0x00c1 }
                    int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00c1 }
                    if (r0 < r4) goto L_0x00bb
                    if (r5 == 0) goto L_0x00c9
                    r5.close()     // Catch:{ all -> 0x00c1 }
                    goto L_0x00c9
                L_0x00bb:
                    if (r5 == 0) goto L_0x00c9
                    r5.release()     // Catch:{ all -> 0x00c1 }
                    goto L_0x00c9
                L_0x00c1:
                    r0 = move-exception
                    com.mob.tools.log.NLog r1 = com.mob.tools.MobLog.getInstance()
                    r1.d(r0)
                L_0x00c9:
                    return
                L_0x00ca:
                    r0 = move-exception
                    java.util.concurrent.CountDownLatch r1 = r1     // Catch:{ all -> 0x00e0 }
                    r1.countDown()     // Catch:{ all -> 0x00e0 }
                    int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00e0 }
                    if (r1 < r4) goto L_0x00da
                    if (r5 == 0) goto L_0x00e8
                    r5.close()     // Catch:{ all -> 0x00e0 }
                    goto L_0x00e8
                L_0x00da:
                    if (r5 == 0) goto L_0x00e8
                    r5.release()     // Catch:{ all -> 0x00e0 }
                    goto L_0x00e8
                L_0x00e0:
                    r1 = move-exception
                    com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
                    r2.d(r1)
                L_0x00e8:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.y.AnonymousClass3.a():void");
            }
        });
        countDownLatch.await(3, TimeUnit.SECONDS);
        return strArr[0];
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:5|6|7|8|9|10|11|(2:13|14)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0050 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0059 A[Catch:{ all -> 0x00d6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String n() {
        /*
            r13 = this;
            r0 = 1
            java.lang.String[] r7 = new java.lang.String[r0]
            java.lang.String r1 = "003ehh"
            java.lang.String r1 = com.mob.commons.a.l.a((java.lang.String) r1)
            boolean r1 = com.mob.commons.b.a((java.lang.String) r1)
            r8 = 0
            if (r1 == 0) goto L_0x00de
            com.mob.commons.ab r1 = com.mob.commons.ab.a()     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = "key_pddt"
            r3 = 0
            java.lang.String r1 = r1.b((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00d6 }
            r7[r8] = r1     // Catch:{ all -> 0x00d6 }
            r1 = r7[r8]     // Catch:{ all -> 0x00d6 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00d6 }
            r9 = 1000(0x3e8, double:4.94E-321)
            if (r1 != 0) goto L_0x0067
            com.mob.commons.ab r1 = com.mob.commons.ab.a()     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = "key_lgpdt"
            r4 = 0
            long r1 = r1.b((java.lang.String) r2, (long) r4)     // Catch:{ all -> 0x00d6 }
            r4 = 604800000(0x240c8400, double:2.988109026E-315)
            java.lang.String r6 = "006IgjfdgjfkBek"
            java.lang.String r6 = com.mob.commons.a.l.a((java.lang.String) r6)     // Catch:{ all -> 0x0050 }
            r11 = 604800(0x93a80, float:8.47505E-40)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0050 }
            java.lang.Object r6 = com.mob.commons.b.a((java.lang.String) r6, r11)     // Catch:{ all -> 0x0050 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0050 }
            long r4 = java.lang.Long.parseLong(r6)     // Catch:{ all -> 0x0050 }
            long r4 = r4 * r9
        L_0x0050:
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d6 }
            long r11 = r11 - r1
            int r1 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x0067
            com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x00d6 }
            java.lang.String r1 = "rddd che p useable"
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ all -> 0x00d6 }
            r0.d(r1, r2)     // Catch:{ all -> 0x00d6 }
            r0 = r7[r8]     // Catch:{ all -> 0x00d6 }
            return r0
        L_0x0067:
            java.lang.String r1 = "004Geeejeeel"
            java.lang.String r1 = com.mob.commons.a.l.a((java.lang.String) r1)     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = com.mob.tools.utils.DH.SyncMtd.getManufacturer()     // Catch:{ all -> 0x00d6 }
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ all -> 0x00d6 }
            if (r1 == 0) goto L_0x007d
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00d6 }
            r2 = 25
            if (r1 <= r2) goto L_0x0093
        L_0x007d:
            java.lang.String r1 = "006iRehOePghYgUej"
            java.lang.String r1 = com.mob.commons.a.l.a((java.lang.String) r1)     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = com.mob.tools.utils.DH.SyncMtd.getManufacturer()     // Catch:{ all -> 0x00d6 }
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ all -> 0x00d6 }
            if (r1 == 0) goto L_0x0094
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00d6 }
            r2 = 22
            if (r1 > r2) goto L_0x0094
        L_0x0093:
            return r3
        L_0x0094:
            java.util.List r3 = r13.o()     // Catch:{ all -> 0x00d6 }
            boolean r1 = r3.isEmpty()     // Catch:{ all -> 0x00d6 }
            if (r1 != 0) goto L_0x00de
            java.util.concurrent.CountDownLatch r11 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x00d6 }
            r11.<init>(r0)     // Catch:{ all -> 0x00d6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d6 }
            r4.<init>()     // Catch:{ all -> 0x00d6 }
            android.content.Context r1 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x00d6 }
            com.mob.tools.utils.DH$RequestBuilder r12 = com.mob.tools.utils.DH.requester(r1)     // Catch:{ all -> 0x00d6 }
            java.util.Iterator r1 = r3.iterator()     // Catch:{ all -> 0x00d6 }
        L_0x00b4:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00d6 }
            if (r2 == 0) goto L_0x00c4
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00d6 }
            r12.getAInfoForPkg(r2, r0)     // Catch:{ all -> 0x00d6 }
            goto L_0x00b4
        L_0x00c4:
            com.mob.commons.y$4 r0 = new com.mob.commons.y$4     // Catch:{ all -> 0x00d6 }
            r1 = r0
            r2 = r13
            r5 = r7
            r6 = r11
            r1.<init>(r3, r4, r5, r6)     // Catch:{ all -> 0x00d6 }
            r12.request(r0)     // Catch:{ all -> 0x00d6 }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00de }
            r11.await(r9, r0)     // Catch:{ all -> 0x00de }
            goto L_0x00de
        L_0x00d6:
            r0 = move-exception
            com.mob.tools.log.NLog r1 = com.mob.tools.MobLog.getInstance()
            r1.d(r0)
        L_0x00de:
            r0 = r7[r8]
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.y.n():java.lang.String");
    }

    private List<String> o() {
        final ArrayList arrayList = new ArrayList();
        DH.requester(MobSDK.getContext()).getSA().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                if (dHResponse.getSA() != null && !dHResponse.getSA().isEmpty()) {
                    Iterator<HashMap<String, String>> it2 = dHResponse.getSA().iterator();
                    while (it2.hasNext()) {
                        String str = (String) it2.next().get(l.a("003kKfifk"));
                        if (str != null && !str.contains("com.google.android") && !str.contains("com.miui.packageinstaller")) {
                            arrayList.add(str);
                        }
                    }
                    Collections.sort(arrayList);
                }
            }
        });
        return arrayList;
    }

    public String b() {
        return "2";
    }

    public String c() {
        if (TextUtils.isEmpty(this.f27364b)) {
            String b11 = ab.a().b("key_rdt2", (String) null);
            if (!TextUtils.isEmpty(b11)) {
                this.f27364b = b11;
            }
        }
        return this.f27364b;
    }

    public boolean d() {
        if (!TextUtils.isEmpty(this.f27364b)) {
            return false;
        }
        synchronized (this) {
            if (!TextUtils.isEmpty(this.f27364b)) {
                return false;
            }
            boolean isEmpty = TextUtils.isEmpty(ab.a().b("key_rdt2", (String) null));
            return isEmpty;
        }
    }

    public synchronized String e() {
        String c11;
        c11 = c();
        if (TextUtils.isEmpty(c11)) {
            c11 = j();
            this.f27364b = c11;
            if (!TextUtils.isEmpty(c11)) {
                ab.a().a("key_rdt2", c11);
            }
        }
        return c11;
    }

    public String f() {
        String c11 = c();
        if (TextUtils.isEmpty(c11)) {
            c11 = k();
            this.f27364b = c11;
            if (!TextUtils.isEmpty(c11)) {
                ab.a().a("key_rdt2", c11);
            }
        }
        return c11;
    }

    public String g() {
        if (TextUtils.isEmpty(this.f27365c)) {
            synchronized (this.f27369h) {
                if (TextUtils.isEmpty(this.f27365c)) {
                    this.f27365c = n();
                }
            }
        }
        return this.f27365c;
    }

    public String h() {
        if (TextUtils.isEmpty(this.f27363a)) {
            synchronized (this.f27368g) {
                if (TextUtils.isEmpty(this.f27363a)) {
                    try {
                        this.f27363a = m();
                        b(this.f27363a);
                    } catch (Throwable th2) {
                        MobLog.getInstance().d(th2);
                    }
                }
            }
        }
        return this.f27363a;
    }

    public HashMap<String, Integer> i() {
        return this.f27367f;
    }

    public static y a() {
        if (f27362e == null) {
            synchronized (y.class) {
                if (f27362e == null) {
                    f27362e = new y();
                }
            }
        }
        return f27362e;
    }

    private String c(String str) {
        StringBuilder sb2 = new StringBuilder(str);
        String manufacturer = DH.SyncMtd.getManufacturer();
        String model = DH.SyncMtd.getModel();
        if (!TextUtils.isEmpty(manufacturer)) {
            sb2.append(manufacturer.trim().toUpperCase());
        }
        if (!TextUtils.isEmpty(model)) {
            sb2.append(model.trim().toUpperCase());
        }
        return Data.MD5(sb2.toString());
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, this.f27364b)) {
            NLog instance = MobLog.getInstance();
            instance.d("rddd saveRD pre is " + this.f27364b + " cur is " + str, new Object[0]);
            ab.a().a("key_rdt2", str);
        }
    }

    /* access modifiers changed from: private */
    public byte[] a(UUID uuid) {
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        byte[] bArr = new byte[16];
        for (int i11 = 0; i11 < 8; i11++) {
            int i12 = (7 - i11) * 8;
            bArr[i11] = (byte) ((int) (mostSignificantBits >>> i12));
            bArr[i11 + 8] = (byte) ((int) (leastSignificantBits >>> i12));
        }
        return bArr;
    }
}
