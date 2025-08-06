package com.mob.commons.a;

import android.os.Handler;
import com.mob.MobSDK;
import com.mob.commons.MobProduct;
import com.mob.commons.aa;
import com.mob.commons.b;
import com.mob.commons.f;
import com.mob.commons.j;
import com.mob.commons.u;
import com.mob.commons.v;
import com.mob.commons.z;
import com.mob.tools.MDP;
import com.mob.tools.MobLog;
import com.mob.tools.b.h;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import com.mob.tools.utils.e;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

public abstract class c implements Runnable {

    /* renamed from: k  reason: collision with root package name */
    private static final WeakHashMap<String, Object> f26915k = new WeakHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public int f26916a;

    /* renamed from: b  reason: collision with root package name */
    public Object f26917b;

    /* renamed from: c  reason: collision with root package name */
    private final String f26918c;

    /* renamed from: d  reason: collision with root package name */
    private final String f26919d;

    /* renamed from: e  reason: collision with root package name */
    private final long f26920e;

    /* renamed from: f  reason: collision with root package name */
    private final long f26921f;

    /* renamed from: g  reason: collision with root package name */
    private volatile long f26922g;

    /* renamed from: h  reason: collision with root package name */
    private final int f26923h;

    /* renamed from: i  reason: collision with root package name */
    private int f26924i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f26925j;

    /* renamed from: l  reason: collision with root package name */
    private long f26926l;

    public c(String str, String str2, long j11) {
        this(str, 0, str2, 0, j11);
    }

    private void m() {
        int i11;
        if (!this.f26925j && (i11 = this.f26916a) >= 0) {
            this.f26916a = i11 + 1;
        }
    }

    public c a(boolean z11) {
        this.f26925j = z11;
        if (z11) {
            this.f26926l = 0;
        }
        return this;
    }

    public abstract void a() throws Throwable;

    public c b(boolean z11) {
        this.f26916a = z11 ? 0 : -1;
        return this;
    }

    public void c() {
    }

    public String d() {
        return this.f26918c;
    }

    public boolean e() {
        return ((Long) b.a(this.f26918c, Long.valueOf(this.f26920e))).longValue() != 0 && f();
    }

    public final boolean f() {
        if ("bs,l,ol,wi,wl,ext,aa,".contains(this.f26918c + Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            return j.a().b();
        }
        return true;
    }

    public boolean g() {
        return this.f26916a == 0;
    }

    public boolean h() {
        if (!e()) {
            return false;
        }
        z.f27384c.execute(this);
        return true;
    }

    public boolean i() {
        boolean a11 = b.a();
        boolean b11 = b.b();
        if (!a11 || !b11) {
            NLog instance = MobLog.getInstance();
            instance.d("slt: " + d() + ", to: " + a11 + ", conn: " + b11, new Object[0]);
            return false;
        }
        boolean e11 = e();
        NLog instance2 = MobLog.getInstance();
        instance2.d("slt : " + getClass().getSimpleName() + ", to: " + a11 + ", conn: " + b11 + ", " + this.f26918c + l.f34627b + e11 + ", key: " + a(this.f26918c, 0) + ", gp: " + l() + " , oce " + this.f26925j + " , tt " + this.f26916a, new Object[0]);
        return e11;
    }

    public long j() {
        return this.f26922g;
    }

    public int k() {
        return this.f26923h;
    }

    public long l() {
        try {
            String str = this.f26919d;
            if (str != null) {
                return Long.parseLong(String.valueOf(b.a(str, Long.valueOf(this.f26921f))));
            }
            return 0;
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return 0;
        }
    }

    public void run() {
        if (this.f26926l > 0) {
            l.a().a(this.f26926l, this, this.f26924i);
            this.f26926l = 0;
            return;
        }
        try {
            if (g()) {
                c();
            }
            if (i()) {
                a();
            }
        } catch (Throwable th2) {
            b();
            m();
            throw th2;
        }
        b();
        m();
    }

    public c(String str, long j11, String str2, long j12, long j13) {
        this.f26916a = 0;
        this.f26924i = 0;
        this.f26925j = false;
        this.f26918c = str;
        this.f26919d = str2;
        this.f26920e = j11;
        this.f26921f = j12;
        this.f26923h = getClass().hashCode();
        this.f26926l = j13;
        this.f26922g = System.currentTimeMillis();
    }

    public void b() {
        long l11 = l();
        if (l11 > 0) {
            a(l11);
        } else {
            this.f26925j = true;
        }
    }

    public c a(Object obj) {
        this.f26917b = obj;
        return this;
    }

    public void a(int i11) {
        this.f26924i = i11;
    }

    public <T> T a(String str, T t11) {
        return b.a(str, t11);
    }

    public TreeMap<String, Object> b(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            TreeMap<String, Object> treeMap = new TreeMap<>();
            h.a aVar = new h.a(obj);
            treeMap.put("ltdmt", Double.valueOf(aVar.b()));
            treeMap.put("lndmt", Double.valueOf(aVar.c()));
            return treeMap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public c a(long j11) {
        if (j11 > 0) {
            this.f26922g = System.currentTimeMillis() + (j11 * 1000);
        } else {
            this.f26922g = -1;
        }
        return this;
    }

    public void a(final e<HashMap<String, Object>> eVar) {
        if (((Integer) a(com.mob.commons.l.a("002XfmVi"), 0)).intValue() == 1) {
            DH.requester(MobSDK.getContext()).getPosCommForce(0, 0, true, false).request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) {
                    List<HashMap<String, Object>> a11 = c.this.a(dHResponse.getPosCommForce(new int[0]));
                    if (a11 == null || a11.isEmpty()) {
                        eVar.a(null);
                    } else {
                        eVar.a(a11.get(a11.size() - 1));
                    }
                }
            });
        } else {
            eVar.a(null);
        }
    }

    public void a(long j11, String str, Object obj) {
        a(j11, str, obj, false);
    }

    public void a(long j11, String str, Object obj, boolean z11) {
        a(j11, str, obj, (HashMap<String, Object>) null, z11);
    }

    public void a(long j11, String str, Object obj, HashMap<String, Object> hashMap, boolean z11) {
        long currentTimeMillis = System.currentTimeMillis();
        final long j12 = j11 > 0 ? (j11 * 1000) + currentTimeMillis : currentTimeMillis;
        final HashMap hashMap2 = new HashMap();
        hashMap2.put(com.mob.commons.l.a("004kGgeNlh"), str);
        hashMap2.put(com.mob.commons.l.a("004i4fkhkLk"), obj);
        hashMap2.put(com.mob.commons.l.a("008]fe<fkhkRfkfhZh"), Long.valueOf(currentTimeMillis));
        if (hashMap != null && !hashMap.isEmpty()) {
            hashMap2.putAll(hashMap);
        }
        if (z11) {
            a((e<HashMap<String, Object>>) new e<HashMap<String, Object>>() {
                public void a(HashMap<String, Object> hashMap) {
                    hashMap2.put(com.mob.commons.l.a("002ei"), hashMap);
                    c.this.a(hashMap, (HashMap<String, Object>) hashMap2);
                    com.mob.commons.c.a().a(j12, (HashMap<String, Object>) hashMap2);
                }
            });
        } else {
            com.mob.commons.c.a().a(j12, (HashMap<String, Object>) hashMap2);
        }
    }

    public void a(HashMap<String, Object> hashMap, final HashMap<String, Object> hashMap2) {
        if (hashMap != null && !v.a(((Long) ResHelper.forceCast(hashMap.get(f.f27213a), Long.valueOf(System.currentTimeMillis()))).longValue(), System.currentTimeMillis())) {
            DH.requester(MobSDK.getContext()).getPosCommForce(0, 15, false, true).request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) throws Throwable {
                    if (dHResponse.getPosCommForce(new int[0]) != null && !dHResponse.getPosCommForce(new int[0]).isEmpty()) {
                        List<HashMap<String, Object>> a11 = c.this.a(dHResponse.getPosCommForce(new int[0]));
                        HashMap hashMap = a11.get(a11.size() - 1);
                        hashMap.put("pt", 2);
                        hashMap2.put("nl", hashMap);
                    }
                }
            });
        }
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        a(str, hashMap, false);
    }

    public void a(String str, HashMap<String, Object> hashMap, boolean z11) {
        final long currentTimeMillis = System.currentTimeMillis();
        final HashMap hashMap2 = new HashMap();
        hashMap2.put(com.mob.commons.l.a("004k0ge[lh"), str);
        if (hashMap != null) {
            hashMap2.put(com.mob.commons.l.a("004VfeIfkf"), hashMap);
        }
        hashMap2.put(com.mob.commons.l.a("008Ffe=fkhk=fkfh$h"), Long.valueOf(currentTimeMillis));
        if (z11) {
            a((e<HashMap<String, Object>>) new e<HashMap<String, Object>>() {
                public void a(HashMap<String, Object> hashMap) {
                    hashMap2.put(com.mob.commons.l.a("002ei"), hashMap);
                    c.this.a(hashMap, (HashMap<String, Object>) hashMap2);
                    com.mob.commons.c.a().a(currentTimeMillis, (HashMap<String, Object>) hashMap2);
                }
            });
        } else {
            com.mob.commons.c.a().a(currentTimeMillis, (HashMap<String, Object>) hashMap2);
        }
    }

    public List<HashMap<String, Object>> a(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object aVar : list) {
            h.a aVar2 = new h.a(aVar);
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("accmt", Float.valueOf(aVar2.a()));
                if (aVar2.i()) {
                    hashMap.put("vacmt", Float.valueOf(aVar2.j()));
                }
                hashMap.put("ltdmt", Double.valueOf(aVar2.b()));
                hashMap.put("lndmt", Double.valueOf(aVar2.c()));
                hashMap.put(f.f27213a, Long.valueOf(aVar2.d()));
                hashMap.put("prvmt", aVar2.e());
                hashMap.put("atdmt", Double.valueOf(aVar2.f()));
                hashMap.put("brmt", Float.valueOf(aVar2.g()));
                hashMap.put("spmt", Float.valueOf(aVar2.h()));
                arrayList.add(hashMap);
            } catch (Throwable th2) {
                NLog instance = MobLog.getInstance();
                instance.d("[cl] glfe " + th2, new Object[0]);
            }
        }
        return arrayList;
    }

    public static void a(String str, File file, String str2, String str3) throws Throwable {
        Object obj;
        Object invokeInstanceMethod = ReflectHelper.invokeInstanceMethod(MobSDK.getContext(), com.mob.commons.l.a("014 glXhk9gf)if=hkhkhgfmSf;fe@hQfl"), new Object[0]);
        ReflectHelper.importClass(com.mob.commons.l.a("028Afe$fi'fffkgjfnhkgehk,kh]fhfnhn1hBgkgf5if[hkhkhgfm+f@feGh)fl"), com.mob.commons.l.a("028Afe$fi'fffkgjfnhkgehk,kh]fhfnhn1hBgkgf5if[hkhkhgfm+f@feGh)fl"));
        file.setReadOnly();
        File parentFile = file.getParentFile();
        WeakHashMap<String, Object> weakHashMap = f26915k;
        synchronized (weakHashMap) {
            obj = weakHashMap.get(str);
            if (obj == null) {
                obj = ReflectHelper.newInstance(com.mob.commons.l.a("028%fe@fiGfffkgjfnhkgehkUkhYfhfnhnJh8gkgfUifRhkhkhgfmAf>fe.h'fl"), file.getAbsolutePath(), parentFile.getAbsolutePath(), parentFile.getAbsolutePath(), invokeInstanceMethod);
                weakHashMap.put(str, obj);
            }
        }
        ResHelper.deleteFileAndFolder(parentFile);
        String a11 = com.mob.commons.e.a((MobProduct) null);
        final Object invokeInstanceMethod2 = ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeInstanceMethod(obj, com.mob.commons.l.a("009i:fm:fUfegf$ifDhkhk"), str2), com.mob.commons.l.a("009Ggl4hk?je^hkj@fmfe"), str3, String.class);
        HashMap hashMap = new HashMap();
        hashMap.put(com.mob.commons.l.a("004%fefifkfe"), a11);
        hashMap.put(com.mob.commons.l.a("004(fhfmfkfe"), com.mob.tools.b.c.a(MobSDK.getContext()).d().ah());
        hashMap.put(com.mob.commons.l.a("010Hhkfegjim0h%flhkfkfmVg"), Integer.valueOf(MobSDK.SDK_VERSION_CODE));
        hashMap.put(com.mob.commons.l.a("006fll,ke0h%ge"), u.a());
        hashMap.put(com.mob.commons.l.a("009fll0gnNheGfl$hk"), MobSDK.getAppSecret());
        hashMap.put(com.mob.commons.l.a("006?fefmfh%fFfkMg"), MobSDK.getDomain().getDomain());
        hashMap.put(com.mob.commons.l.a("010=ghfmflNeh9hm9kkl.hk"), Boolean.valueOf(MobSDK.checkForceHttps()));
        hashMap.put(com.mob.commons.l.a("009CghfmflPehSggWlLffjj"), Boolean.valueOf(MobSDK.checkV6()));
        hashMap.put(com.mob.commons.l.a("004hehRgk"), Long.valueOf(((Long) b.a(com.mob.commons.l.a("004heh0gk"), 5L)).longValue()));
        hashMap.put(com.mob.commons.l.a("002e<fe"), (String) b.a(com.mob.commons.l.a("002e%fe"), com.mob.commons.l.a("006Mjgjgjhjhjhjh")));
        hashMap.put("usridt", aa.d());
        hashMap.put("mdp", MDP.class.getName());
        final String fromHashMap = HashonHelper.fromHashMap(hashMap);
        ReflectHelper.invokeInstanceMethod(invokeInstanceMethod2, com.mob.commons.l.a("013.hkHhkMhfPeehGhkhkfkhhKih"), Boolean.TRUE);
        com.mob.commons.h.a().a(15);
        UIHandler.sendEmptyMessage(0, new Handler.Callback() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object[]} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean handleMessage(android.os.Message r7) {
                /*
                    r6 = this;
                    r7 = 0
                    com.mob.commons.h r0 = com.mob.commons.h.a()     // Catch:{ all -> 0x002e }
                    r1 = 16
                    r0.a((int) r1)     // Catch:{ all -> 0x002e }
                    java.lang.Object r0 = r9     // Catch:{ all -> 0x002e }
                    java.lang.String r1 = "006'fk<g0fffmgjDh"
                    java.lang.String r1 = com.mob.commons.l.a((java.lang.String) r1)     // Catch:{ all -> 0x002e }
                    r2 = 2
                    java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x002e }
                    r3 = 0
                    r2[r7] = r3     // Catch:{ all -> 0x002e }
                    r3 = 1
                    java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x002e }
                    java.lang.String r5 = r8     // Catch:{ all -> 0x002e }
                    r4[r7] = r5     // Catch:{ all -> 0x002e }
                    r2[r3] = r4     // Catch:{ all -> 0x002e }
                    com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r0, r1, r2)     // Catch:{ all -> 0x002e }
                    com.mob.commons.h r0 = com.mob.commons.h.a()     // Catch:{ all -> 0x002e }
                    r1 = 17
                    r0.a((int) r1)     // Catch:{ all -> 0x002e }
                    goto L_0x0037
                L_0x002e:
                    r0 = move-exception
                    com.mob.commons.h r1 = com.mob.commons.h.a()
                    r2 = 7
                    r1.a((int) r2, (java.lang.Throwable) r0)
                L_0x0037:
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.a.c.AnonymousClass5.handleMessage(android.os.Message):boolean");
            }
        });
    }

    public static long a(String str, Long l11) {
        Map map = (Map) b.a(com.mob.commons.l.a("005EhkOiNfk]k>hk"), null);
        if (map == null) {
            return 0;
        }
        return ((Long) ResHelper.forceCast(map.get(str), l11)).longValue();
    }
}
