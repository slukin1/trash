package com.mob.mcl.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.google.android.gms.stats.CodePackage;
import com.hbg.lib.network.pro.core.util.Period;
import com.jumio.sdk.reject.JumioRejectReason;
import com.mob.MobSDK;
import com.mob.commons.MobProduct;
import com.mob.commons.aa;
import com.mob.commons.ab;
import com.mob.commons.i;
import com.mob.commons.s;
import com.mob.commons.u;
import com.mob.commons.z;
import com.mob.mcl.BusinessCallBack;
import com.mob.mcl.BusinessMessageCallback;
import com.mob.mcl.BusinessMessageListener;
import com.mob.mcl.MobMCL;
import com.mob.mcl.TcpStatus;
import com.mob.mcl.TcpStatusListener;
import com.mob.mcl.a;
import com.mob.mcl.b.a;
import com.mob.mcl.d.b;
import com.mob.mcl.d.c;
import com.mob.mgs.OnIdChangeListener;
import com.mob.mgs.impl.f;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.ActivityTracker;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.UIHandler;
import com.mob.tools.utils.e;
import com.xiaomi.mipush.sdk.Constants;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class h implements d {

    /* renamed from: n  reason: collision with root package name */
    private static volatile h f27466n;
    private AtomicBoolean A = new AtomicBoolean(false);
    private TcpStatusListener B;
    private TcpStatus C;

    /* renamed from: a  reason: collision with root package name */
    public long f27467a;

    /* renamed from: b  reason: collision with root package name */
    public String f27468b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicLong f27469c = new AtomicLong(0);

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f27470d;

    /* renamed from: e  reason: collision with root package name */
    public int f27471e = 270;

    /* renamed from: f  reason: collision with root package name */
    public int f27472f = 500;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27473g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27474h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27475i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f27476j;

    /* renamed from: k  reason: collision with root package name */
    public String f27477k;

    /* renamed from: l  reason: collision with root package name */
    public long f27478l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f27479m;

    /* renamed from: o  reason: collision with root package name */
    private NetworkHelper f27480o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public HashonHelper f27481p;

    /* renamed from: q  reason: collision with root package name */
    private f f27482q;

    /* renamed from: r  reason: collision with root package name */
    private String f27483r;

    /* renamed from: s  reason: collision with root package name */
    private String f27484s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public Context f27485t;

    /* renamed from: u  reason: collision with root package name */
    private MobMCL.ELPMessageListener f27486u;

    /* renamed from: v  reason: collision with root package name */
    private HashMap<Integer, HashSet<BusinessMessageListener>> f27487v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f27488w;

    /* renamed from: x  reason: collision with root package name */
    private c f27489x;

    /* renamed from: y  reason: collision with root package name */
    private OnIdChangeListener f27490y;

    /* renamed from: z  reason: collision with root package name */
    private int f27491z = 1;

    private h() {
        b.a().b("TP tpHelper init");
        this.f27482q = new f(this);
        this.f27480o = new NetworkHelper();
        this.f27481p = new HashonHelper();
        this.f27487v = new HashMap<>();
        this.f27489x = new c(MobSDK.getContext());
        this.f27485t = MobSDK.getContext();
    }

    private String i() {
        return this.f27484s + this.f27485t.getPackageName();
    }

    private String j() {
        ArrayList<MobProduct> b11 = aa.b();
        HashMap<String, Object> b12 = s.a().b();
        StringBuilder sb2 = new StringBuilder("COMMON;" + MobSDK.SDK_VERSION_CODE);
        int size = b11.size();
        for (int i11 = 0; i11 < size; i11++) {
            try {
                MobProduct mobProduct = b11.get(i11);
                if (!TextUtils.equals(CodePackage.COMMON, mobProduct.getProductTag())) {
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    sb2.append(mobProduct.getProductTag());
                    sb2.append(";");
                    sb2.append(mobProduct.getSdkver());
                    sb2.append(";");
                    sb2.append(b12.get(mobProduct.getProductTag()));
                }
            } catch (Throwable unused) {
            }
        }
        return sb2.toString();
    }

    /* access modifiers changed from: private */
    public void k() {
        if (!c()) {
            l();
        }
    }

    private void l() {
        a.f27412a.execute(new Runnable() {
            public void run() {
                try {
                    if (!h.this.c()) {
                        if (!h.this.d()) {
                            h.this.f();
                        }
                        h.this.a((e<Boolean>) new e<Boolean>() {
                            public void a(Boolean bool) {
                            }
                        });
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void m() {
        if (f.a().d() && this.A.compareAndSet(false, true)) {
            b().b(f.a().c(), f.a().e());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
        r0 = r1.f27470d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r1 = this;
            boolean r0 = r1.f27473g
            if (r0 == 0) goto L_0x0020
            boolean r0 = r1.f27474h
            if (r0 == 0) goto L_0x0020
            boolean r0 = r1.f27488w
            if (r0 != 0) goto L_0x0020
            java.util.ArrayList<java.lang.String> r0 = r1.f27470d
            if (r0 == 0) goto L_0x0020
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0020
            java.lang.String r0 = r1.f27468b
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0020
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.mcl.c.h.d():boolean");
    }

    public boolean e() {
        return d() && this.f27475i;
    }

    public void f() {
        HashMap hashMap;
        boolean isInMainProcess = DH.SyncMtd.isInMainProcess();
        b.a().b("TP cf, main p: " + isInMainProcess);
        if (isInMainProcess) {
            if (TextUtils.isEmpty(this.f27484s) || this.f27485t == null) {
                b.a().b("TP mcl has not been initialized");
                return;
            }
            try {
                String b11 = ab.a().b("tcp_config", (String) null);
                if (!TextUtils.isEmpty(b11)) {
                    HashMap fromJson = HashonHelper.fromJson(b11);
                    if (fromJson.containsKey("requestTimes")) {
                        long j11 = 0;
                        Object obj = fromJson.get("requestTimes");
                        if (obj != null && (obj instanceof Long)) {
                            j11 = ((Long) obj).longValue();
                        } else if (obj != null && (obj instanceof Integer)) {
                            j11 = (long) ((Integer) obj).intValue();
                        }
                        if (j11 + Period.DAY_MILLS > System.currentTimeMillis() && b().a((HashMap<String, Object>) fromJson) && ab.a().b("use_config", true)) {
                            b.a().b("TP cf cc : " + b11);
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                b.a().b(th2.getMessage());
            }
            try {
                HashMap hashMap2 = (HashMap) com.mob.commons.b.a("sti", null);
                if (hashMap2 == null || hashMap2.isEmpty()) {
                    NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                    networkTimeOut.readTimout = 10000;
                    networkTimeOut.connectionTimeout = 5000;
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("appkey", this.f27483r);
                    hashMap3.put("pushId", i());
                    hashMap3.put("products", j());
                    String str = i.a().a("tcig") + "/tcp/config/init";
                    String httpPostNew = this.f27480o.httpPostNew(str, hashMap3, (HashMap<String, String>) null, networkTimeOut);
                    b.a().b("TP cf url : " + str + " -> rp : " + httpPostNew);
                    hashMap = HashonHelper.fromJson(httpPostNew);
                } else {
                    hashMap = new HashMap();
                    hashMap.put("code", 200);
                    hashMap.put("data", hashMap2);
                }
                hashMap.put("requestTimes", Long.valueOf(System.currentTimeMillis()));
                if (b().a((HashMap<String, Object>) hashMap)) {
                    ab.a().a("use_config", true);
                    ab.a().a("tcp_config", HashonHelper.fromHashMap(hashMap));
                }
            } catch (Throwable th3) {
                b.a().b(th3.getMessage());
            }
        }
    }

    public void g() {
        if (TextUtils.isEmpty(this.f27477k) || this.f27478l <= 0) {
            String b11 = ab.a().b("suid", "");
            long b12 = ab.a().b("create_suid_time", 0);
            if (TextUtils.isEmpty(b11)) {
                b11 = UUID.randomUUID().toString();
            }
            if (b12 <= 0) {
                b12 = System.currentTimeMillis();
            }
            a(b11, b12);
        }
    }

    public String h() {
        return String.format("%16s", new Object[]{Integer.valueOf(Math.abs(Arrays.hashCode(new Object[]{this.f27483r, i()})))}).replaceAll(" ", "0").substring(0, 16);
    }

    public static h b() {
        if (f27466n == null) {
            synchronized (h.class) {
                if (f27466n == null) {
                    f27466n = new h();
                }
            }
        }
        return f27466n;
    }

    public boolean c() {
        f fVar = this.f27482q;
        if (fVar == null || !fVar.b() || this.f27469c.get() == 0) {
            return false;
        }
        return true;
    }

    private void c(final e<String> eVar) {
        final HashMap hashMap = new HashMap();
        hashMap.put("appkey", this.f27483r);
        hashMap.put("apppkg", this.f27485t.getPackageName());
        hashMap.put("plat", 1);
        hashMap.put("pushId", i());
        hashMap.put("guardId", this.f27477k);
        try {
            DH.requester(this.f27485t).getMpfo(this.f27485t.getPackageName(), 128).request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) {
                    ApplicationInfo a11;
                    Bundle bundle;
                    Object obj;
                    Object mpfo = dHResponse.getMpfo(new int[0]);
                    if (!(mpfo == null || (a11 = com.mob.tools.c.a(mpfo, h.this.f27485t.getPackageName())) == null || (bundle = a11.metaData) == null || bundle.isEmpty() || (obj = bundle.get("mob_id_ver")) == null)) {
                        hashMap.put("version", String.valueOf(obj));
                    }
                    HashonHelper unused = h.this.f27481p;
                    String fromHashMap = HashonHelper.fromHashMap(hashMap);
                    e eVar = eVar;
                    if (eVar != null) {
                        eVar.a(fromHashMap);
                    }
                }
            });
        } catch (Throwable th2) {
            b.a().a(th2);
            String fromHashMap = HashonHelper.fromHashMap(hashMap);
            if (eVar != null) {
                eVar.a(fromHashMap);
            }
        }
    }

    public boolean a() {
        return !this.f27473g || !this.f27474h || this.f27488w;
    }

    public void a(OnIdChangeListener onIdChangeListener) {
        this.f27490y = onIdChangeListener;
    }

    public void a(String str) {
        this.f27489x.b(str);
    }

    public void a(MobMCL.ELPMessageListener eLPMessageListener) {
        this.f27486u = eLPMessageListener;
    }

    private void b(long j11, boolean z11) {
        if (this.f27482q != null) {
            try {
                String b11 = b(this.f27469c.get());
                HashMap hashMap = new HashMap();
                hashMap.put("repeat", Boolean.valueOf(z11));
                String fromHashMap = HashonHelper.fromHashMap(hashMap);
                e eVar = new e(1007, c(b11, fromHashMap));
                eVar.f27459c = j11;
                this.f27482q.a(eVar);
                b a11 = b.a();
                a11.b("TP sd ty = " + eVar.f27458b + " , u = " + j11 + " bo : " + fromHashMap);
            } catch (Throwable th2) {
                b.a().a(th2);
            }
        }
    }

    public void a(int i11, BusinessMessageListener businessMessageListener) {
        HashSet hashSet;
        BusinessMessageListener businessMessageListener2 = businessMessageListener;
        try {
            b a11 = b.a();
            a11.b("TP tpHelper addBMListener: bisType = " + i11 + ", listener = " + businessMessageListener2);
            Integer valueOf = Integer.valueOf(i11);
            if (businessMessageListener2 == null) {
                b a12 = b.a();
                a12.b("TP tpHelper addBMListener: remove key = " + valueOf);
                this.f27487v.remove(valueOf);
                return;
            }
            if (this.f27487v.containsKey(valueOf)) {
                hashSet = this.f27487v.get(valueOf);
            } else {
                hashSet = new HashSet();
                this.f27487v.put(valueOf, hashSet);
            }
            HashSet hashSet2 = hashSet;
            hashSet2.add(businessMessageListener2);
            if (g.a().b()) {
                b.a().b("TP tpHelper addBMListener: has cached msg");
                List<Map<String, Object>> c11 = g.a().c();
                ArrayList<Map> arrayList = new ArrayList<>();
                for (Map next : c11) {
                    Object obj = next.get("bisType");
                    int intValue = obj != null ? ((Integer) obj).intValue() : 0;
                    String str = (String) next.get("workId");
                    String str2 = (String) next.get(MTPushConstants.Analysis.KEY_JSON);
                    b a13 = b.a();
                    a13.b("TP tpHelper addBMListener: cachedBisType = " + intValue + ", target bisType = " + valueOf);
                    if (intValue == valueOf.intValue()) {
                        Iterator it2 = hashSet2.iterator();
                        while (it2.hasNext()) {
                            final BusinessMessageListener businessMessageListener3 = (BusinessMessageListener) it2.next();
                            final int i12 = intValue;
                            final String str3 = str;
                            AnonymousClass1 r12 = r1;
                            final String str4 = str2;
                            AnonymousClass1 r13 = new Handler.Callback() {
                                public boolean handleMessage(Message message) {
                                    if (businessMessageListener3 == null) {
                                        return false;
                                    }
                                    b a11 = b.a();
                                    a11.b("TP tpHelper addBMListener: callback to messageReceived. bisType: " + i12 + ", workId: " + str3 + ", msg: " + str4);
                                    businessMessageListener3.messageReceived(i12, str3, str4);
                                    return false;
                                }
                            };
                            UIHandler.sendEmptyMessage(0, r12);
                        }
                        b a14 = b.a();
                        a14.b("TP tpHelper addBMListener: mark msg to rm. msg = " + next);
                        arrayList.add(next);
                    }
                }
                if (!arrayList.isEmpty()) {
                    for (Map map : arrayList) {
                        b a15 = b.a();
                        a15.b("TP tpHelper addBMListener: rm msg = " + map);
                        g.a().b(map);
                    }
                    return;
                }
                return;
            }
            b.a().b("TP tpHelper addBMListener: no cached msg");
        } catch (Throwable th2) {
            b.a().b("TP tpHelper addBMListener: error");
            b.a().a(th2);
        }
    }

    private String c(String str, String str2) throws Throwable {
        return Base64.encodeToString(Data.AES128Encode(str, str2), 2);
    }

    public void b(final BusinessCallBack<Boolean> businessCallBack) {
        final boolean c11 = c();
        UIHandler.sendEmptyMessage(0, new Handler.Callback() {
            public boolean handleMessage(Message message) {
                BusinessCallBack businessCallBack = businessCallBack;
                if (businessCallBack == null) {
                    return false;
                }
                businessCallBack.callback(Boolean.valueOf(c11));
                return false;
            }
        });
    }

    public void b(final e<Boolean> eVar) {
        c((e<String>) new e<String>() {
            public void a(String str) {
                if (h.this.a(1003, str) != null) {
                    e eVar = eVar;
                    if (eVar != null) {
                        eVar.a(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                e eVar2 = eVar;
                if (eVar2 != null) {
                    eVar2.a(Boolean.FALSE);
                }
            }
        });
    }

    private String b(long j11) {
        return String.format("%16s", new Object[]{Integer.valueOf(Math.abs(Arrays.hashCode(new long[]{j11})))}).replaceAll(" ", "0").substring(0, 16);
    }

    private HashMap<String, Object> b(HashMap<String, Object> hashMap) {
        return (a(hashMap, "code", 0) != 200 || !hashMap.containsKey("data")) ? new HashMap<>() : (HashMap) hashMap.get("data");
    }

    private HashMap<String, Object> b(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("{")) {
                b.a().b(str);
                return b((HashMap<String, Object>) HashonHelper.fromJson(str));
            }
        } catch (Throwable th2) {
            b.a().a(th2);
        }
        return hashMap;
    }

    public void b(String str, String str2) {
        try {
            NetworkHelper networkHelper = new NetworkHelper();
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.connectionTimeout = 2000;
            networkTimeOut.readTimout = 5000;
            HashMap hashMap = new HashMap();
            hashMap.put("appkey", u.a());
            hashMap.put("pkg", DH.SyncMtd.getPackageName());
            hashMap.put("duidOld", str2);
            hashMap.put("duidNew", str);
            hashMap.put("appVer", DH.SyncMtd.getAppVersionName());
            hashMap.put("plat", Integer.valueOf(DH.SyncMtd.getPlatformCode()));
            String str3 = i.a().a("tcig") + "/tcp/push/pbsd";
            b.a().b("[Request]TP url = " + str3 + "\nheaders = " + null + "\nvalues = " + hashMap);
            String httpPostNew = networkHelper.httpPostNew(str3, hashMap, (HashMap<String, String>) null, networkTimeOut);
            b.a().b("[Response]TP url = " + str3 + "\nresp = " + httpPostNew);
            HashMap fromJson = HashonHelper.fromJson(httpPostNew);
            if (fromJson != null && !fromJson.isEmpty()) {
                if (!JumioRejectReason.NOT_READABLE.equals(String.valueOf(fromJson.get("code")))) {
                    throw new Throwable("Req failed: " + httpPostNew);
                }
            }
            this.f27491z = 1;
        } catch (Throwable th2) {
            b.a().a(th2);
            int i11 = this.f27491z;
            if (i11 < 3) {
                try {
                    Thread.sleep((long) (i11 * 1000));
                } catch (InterruptedException unused) {
                    b.a().a(th2);
                }
                this.f27491z++;
                b(str, str2);
                return;
            }
            this.f27491z = 1;
        }
    }

    public void a(Context context, String str, String str2) {
        this.f27485t = context;
        this.f27483r = str;
        if (!TextUtils.isEmpty(str2)) {
            this.f27484s = str2;
        }
        g();
        ActivityTracker.getInstance(context).addTracker(com.mob.mcl.a.a((a.C0239a) new a.C0239a() {
            public void a() {
                h.this.k();
            }

            public void b() {
                h.this.k();
            }
        }));
        this.f27489x.a();
    }

    public HashMap<String, Object> a(String str, String str2, int i11) throws Throwable {
        if (this.f27482q == null) {
            return null;
        }
        b a11 = b.a();
        a11.b("TP rg main = " + str + " , bo = " + str2 + " , out = " + i11);
        String[] split = str.split(":");
        this.f27482q.a(new InetSocketAddress(split[0], Integer.parseInt(split[1])), true, true, 5000);
        this.f27469c.set(0);
        e eVar = new e(1001, c(this.f27468b, str2));
        eVar.f27459c = this.f27467a;
        e a12 = this.f27482q.a(eVar).get((long) i11, TimeUnit.MILLISECONDS);
        if (a12 == null || a12.f27458b != 1000) {
            b a13 = b.a();
            a13.b("TP rp : " + a12);
            return null;
        }
        String a14 = a(this.f27468b, a12.f27460d);
        a12.f27460d = a14;
        return b(a14);
    }

    public HashMap<String, Object> a(int i11, String str) {
        return a(i11, 10000, str);
    }

    public void b(TcpStatusListener tcpStatusListener) {
        if (this.B == tcpStatusListener) {
            this.B = null;
        }
    }

    public HashMap<String, Object> a(int i11, int i12, String str) {
        e eVar;
        if (this.f27482q == null) {
            return null;
        }
        try {
            String b11 = b(this.f27469c.get());
            b a11 = b.a();
            a11.b("TP sd ty = " + i11 + " , bo = " + str + " , out = " + i12);
            if (TextUtils.isEmpty(str)) {
                eVar = new e(i11);
            } else {
                eVar = new e(i11, c(b11, str));
            }
            c a12 = this.f27482q.a(eVar);
            if (a12 != null) {
                e a13 = a12.get((long) i12, TimeUnit.MILLISECONDS);
                if (a13 == null || a13.f27458b != 1000) {
                    b a14 = b.a();
                    a14.b("TP rp : " + a13);
                    return null;
                }
                String a15 = a(b11, a13.f27460d);
                a13.f27460d = a15;
                return b(a15);
            }
            b.a().b("TP rp : null");
            return null;
        } catch (Throwable th2) {
            b.a().a(th2);
            return null;
        }
    }

    public void b(TcpStatus tcpStatus) {
        TcpStatusListener tcpStatusListener = this.B;
        if (tcpStatusListener != null) {
            TcpStatus tcpStatus2 = this.C;
            if (tcpStatus2 != null) {
                tcpStatus = tcpStatus2;
            }
            tcpStatusListener.onStatus(tcpStatus);
            this.C = null;
        }
    }

    private void a(long j11, boolean z11) {
        if (this.f27482q != null) {
            try {
                String b11 = b(this.f27469c.get());
                HashMap hashMap = new HashMap();
                hashMap.put("state", Boolean.valueOf(z11));
                String fromHashMap = HashonHelper.fromHashMap(hashMap);
                e eVar = new e(1006, c(b11, fromHashMap));
                b a11 = b.a();
                a11.b("TP sd ty = " + eVar.f27458b + " , u = " + j11 + " bo : " + fromHashMap);
                eVar.f27459c = j11;
                this.f27482q.a(eVar);
            } catch (Throwable th2) {
                b.a().a(th2);
            }
        }
    }

    private c a(long j11) {
        if (this.f27482q == null) {
            return null;
        }
        try {
            e eVar = new e(1005);
            eVar.f27459c = j11;
            c a11 = this.f27482q.a(eVar);
            b a12 = b.a();
            a12.b("TP sd ty = " + eVar.f27458b + " , u = " + j11 + " bo : " + eVar.f27460d);
            return a11;
        } catch (Throwable th2) {
            b.a().a(th2);
            return null;
        }
    }

    public boolean a(int i11, int i12) {
        if (i12 >= 4) {
            return false;
        }
        if (a(1002, i11, (String) null) != null) {
            return true;
        }
        if (i12 == 0 || i12 == 1) {
            a(1000, i12 + 1);
            return false;
        }
        a(3000, i12 + 1);
        return false;
    }

    public void a(BusinessCallBack<Boolean> businessCallBack) {
        boolean c11 = c();
        if (businessCallBack != null) {
            businessCallBack.callback(Boolean.valueOf(c11));
        }
        if (!c11) {
            com.mob.mcl.b.a.f27412a.execute(new Runnable() {
                public void run() {
                    try {
                        if (!h.b().d()) {
                            h.b().f();
                        }
                        h.this.a((e<Boolean>) new e<Boolean>() {
                            public void a(Boolean bool) {
                            }
                        });
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private boolean a(HashMap<String, Object> hashMap) {
        try {
            this.f27479m = false;
            HashMap<String, Object> b11 = b(hashMap);
            if (b11.containsKey("domains") && b11.containsKey("uniqueId") && b11.containsKey("uniqueKey")) {
                this.f27470d = (ArrayList) b11.get("domains");
                this.f27467a = ((Long) b11.get("uniqueId")).longValue();
                this.f27468b = (String) b11.get("uniqueKey");
                this.f27471e = a(b11, "tick", this.f27471e);
                this.f27473g = a(b11, "globalSwitch", 0) == 1;
                this.f27474h = a(b11, "connectSwitch", 0) == 1;
                this.f27475i = a(b11, "forwardSwitch", 0) == 1;
                this.f27476j = a(b11, "bindRequestSwitch", 0) == 1;
                this.f27472f = a(b11, "wr", this.f27472f);
                if (b11.containsKey("determineDomain")) {
                    String str = (String) b11.get("determineDomain");
                    if (!TextUtils.isEmpty(str)) {
                        if (this.f27470d == null) {
                            this.f27470d = new ArrayList<>();
                        }
                        this.f27470d.remove(str);
                        this.f27470d.add(0, str);
                    }
                }
                ArrayList<String> arrayList = this.f27470d;
                if (arrayList == null || arrayList.size() <= 0 || TextUtils.isEmpty(this.f27468b)) {
                    return false;
                }
                return true;
            }
        } catch (Throwable th2) {
            b.a().a(th2);
        }
        return false;
    }

    public void a(e<Boolean> eVar) {
        a(5000, eVar);
    }

    public synchronized void a(final int i11, final e<Boolean> eVar) {
        if (d()) {
            c((e<String>) new e<String>() {
                public void a(String str) {
                    h hVar = h.this;
                    boolean a11 = hVar.a(hVar.f27479m, hVar.f27470d.get(0), 0, str, i11);
                    e eVar = eVar;
                    if (eVar != null) {
                        eVar.a(Boolean.valueOf(a11));
                    }
                }
            });
        } else {
            b().a(TcpStatus.obtain(21).setDetailedMsg("unavailable(global: " + this.f27473g + ", connect: " + this.f27474h + ", forceClose:" + this.f27488w + ")"));
            if (eVar != null) {
                eVar.a(Boolean.FALSE);
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized boolean a(boolean z11, String str, int i11, String str2, int i12) {
        String str3 = str;
        int i13 = i11;
        synchronized (this) {
            String str4 = null;
            try {
                if (i13 < this.f27470d.size() && i13 < 3) {
                    b a11 = b.a();
                    a11.b("TP rg domain : " + str3 + " count : " + i13);
                    HashMap<String, Object> a12 = a(str3, str2, i12);
                    if (a12 != null && a12.containsKey("type")) {
                        int intValue = ((Integer) a12.get("type")).intValue();
                        if (intValue != 1 || !a12.containsKey("token")) {
                            if (intValue == 2) {
                                if (a12.containsKey("domain")) {
                                    String str5 = (String) a12.get("domain");
                                    if (!TextUtils.isEmpty(str5)) {
                                        boolean a13 = a(true, str5, 2, str2, i12);
                                        return a13;
                                    }
                                }
                            }
                            if (intValue == 3) {
                                this.f27488w = true;
                                this.f27482q.a();
                                m();
                                b().a(TcpStatus.obtain(24).setDetailedMsg("Connection out of limit"));
                                return false;
                            }
                        } else {
                            this.f27469c.set(((Long) a12.get("token")).longValue());
                            b.a().b();
                            b.a().a("TP register success");
                            m();
                            b().a(TcpStatus.obtain(10));
                            return true;
                        }
                    }
                    int i14 = i13 + 1;
                    if (i14 < this.f27470d.size() && !z11) {
                        boolean a14 = a(false, this.f27470d.get(i14), i14, str2, i12);
                        return a14;
                    }
                }
            } catch (Throwable th2) {
                str4 = th2.getMessage();
                b.a().a(th2);
            }
            ab.a().a("tcp_config", (String) null);
            this.f27470d = null;
            m();
            h b11 = b();
            TcpStatus obtain = TcpStatus.obtain(24);
            b11.a(obtain.setDetailedMsg("Exception: " + str4));
            return false;
        }
    }

    public synchronized void a(String str, long j11) {
        if (this.f27490y != null && !String.valueOf(this.f27477k).equals(str)) {
            this.f27490y.onChanged(this.f27477k, str);
        }
        this.f27477k = str;
        this.f27478l = j11;
        ab.a().a("suid", this.f27477k);
        ab.a().a("create_suid_time", this.f27478l);
    }

    public void a(a aVar, e eVar) {
        e eVar2 = eVar;
        try {
            if (!TextUtils.isEmpty(eVar2.f27460d)) {
                if (this.f27469c.get() == 0) {
                    b.a().b("TP received push msg, but send token is 0");
                    return;
                }
                String a11 = a(b(this.f27469c.get()), eVar2.f27460d);
                eVar2.f27460d = a11;
                int i11 = eVar2.f27458b;
                boolean z11 = false;
                if (i11 == 9001) {
                    b.a().b("TP msg push msgType: " + eVar2.f27458b + " body = " + eVar2.f27460d);
                    c a12 = a(eVar2.f27459c);
                    HashMap<String, Object> b11 = b(eVar2.f27460d);
                    if (b11.containsKey("data")) {
                        int a13 = a(b11, "expire", 0);
                        String str = (String) b11.get("workId");
                        String str2 = (String) b11.get("data");
                        boolean z12 = a(b11, "needRepeat", 0) == 1;
                        int a14 = a(b11, "type", 0);
                        if (a14 != 1) {
                            if (a14 != 2) {
                                boolean a15 = a(eVar2.f27459c, str, a13, a14, str2, a12);
                                if (z12) {
                                    b(eVar2.f27459c, a15);
                                    return;
                                }
                                return;
                            }
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("data", str2);
                        bundle.putInt("expire", a13);
                        bundle.putString("workId", str);
                        bundle.putLong("uniqueId", eVar2.f27459c);
                        bundle.putInt("msgType", a14);
                        if (a(bundle) == 1) {
                            z11 = true;
                        }
                        if (z12) {
                            b(eVar2.f27459c, z11);
                        }
                    }
                } else if (i11 == 9002) {
                    final String str3 = (String) b(a11).get("domain");
                    if (!TextUtils.isEmpty(str3)) {
                        this.f27479m = true;
                        c((e<String>) new e<String>() {
                            public void a(String str) {
                                boolean unused = h.this.a(true, str3, 2, str, 5000);
                            }
                        });
                    }
                } else if (i11 == 9004) {
                    b.a().b("TP mg ty: " + eVar2.f27458b + " bo = " + eVar2.f27460d);
                    a(eVar2.f27459c);
                    HashMap<String, Object> b12 = b(eVar2.f27460d);
                    if (b12.containsKey("data") && b12.containsKey("targetPackage")) {
                        String str4 = (String) b12.get("targetPackage");
                        String str5 = (String) b12.get("data");
                        int a16 = a(b12, "logicTimeout", 1000);
                        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str4)) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("data", str5);
                            bundle2.putLong("uniqueId", eVar2.f27459c);
                            com.mob.apc.a a17 = com.mob.mcl.a.a.a().a(9004, bundle2, str4, a16);
                            if (a17 == null || a17.f26851e == null) {
                                b.a().b("TP apc fw rp mg is null");
                                a(eVar2.f27459c, false);
                                return;
                            }
                            a(eVar2.f27459c, true);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            b.a().a(th2);
        }
    }

    public int a(Bundle bundle) {
        if (this.f27486u == null) {
            return -1;
        }
        if (a(bundle.getString("workId"), bundle.getInt("expire"))) {
            return 1;
        }
        return this.f27486u.messageReceived(bundle) ? 1 : 0;
    }

    private synchronized boolean a(String str, int i11) {
        if (i11 != 0) {
            if (!TextUtils.isEmpty(str)) {
                if (System.currentTimeMillis() <= this.f27489x.a(str)) {
                    return true;
                }
                this.f27489x.a(str, System.currentTimeMillis() + ((long) (i11 * 1000)));
            }
        }
        return false;
    }

    public boolean a(long j11, String str, int i11, int i12, String str2) {
        try {
            if (a(str, i11)) {
                return true;
            }
            a(j11, str, i12, str2);
            return false;
        } catch (Throwable th2) {
            b.a().a(th2);
            return false;
        }
    }

    public boolean a(long j11, String str, int i11, int i12, String str2, c cVar) {
        String str3 = str;
        try {
            if (a(str, i11)) {
                return true;
            }
            final c cVar2 = cVar;
            final long j12 = j11;
            final String str4 = str;
            final int i13 = i12;
            final String str5 = str2;
            z.f27384c.execute(new com.mob.tools.utils.i() {
                public void a() throws Throwable {
                    int i11;
                    c cVar = cVar2;
                    if (cVar != null) {
                        e eVar = null;
                        try {
                            eVar = cVar.get((long) h.this.f27472f, TimeUnit.MILLISECONDS);
                        } catch (Throwable th2) {
                            b.a().a(th2);
                        }
                        if (eVar == null || eVar.f27458b != 1000) {
                            b a11 = b.a();
                            a11.b("TP rp : " + eVar);
                        } else {
                            i11 = 1;
                            b.a().b("TP rp acked: ");
                            h.this.a(j12, str4, i13, str5, i11);
                        }
                    }
                    i11 = 0;
                    h.this.a(j12, str4, i13, str5, i11);
                }
            });
            return false;
        } catch (Throwable th2) {
            b.a().a(th2);
            return false;
        }
    }

    private void a(long j11, String str, int i11, String str2) {
        a(j11, str, i11, str2, 0);
    }

    /* access modifiers changed from: private */
    public void a(long j11, String str, int i11, String str2, int i12) {
        try {
            HashMap fromJson = HashonHelper.fromJson(str2);
            fromJson.put("uniqueId", Long.valueOf(j11));
            String fromHashMap = HashonHelper.fromHashMap(fromJson);
            Integer valueOf = Integer.valueOf(i11);
            if (this.f27487v.containsKey(valueOf)) {
                b a11 = b.a();
                a11.b("[dealBusinessMsg]TP Biz msg listener detected, callback directly. bisType: " + valueOf);
                Iterator it2 = this.f27487v.get(valueOf).iterator();
                while (it2.hasNext()) {
                    final BusinessMessageListener businessMessageListener = (BusinessMessageListener) it2.next();
                    final Integer num = valueOf;
                    final String str3 = str;
                    final String str4 = fromHashMap;
                    final int i13 = i12;
                    UIHandler.sendEmptyMessage(0, new Handler.Callback() {
                        public boolean handleMessage(Message message) {
                            BusinessMessageListener businessMessageListener = businessMessageListener;
                            if (businessMessageListener == null) {
                                return false;
                            }
                            if (businessMessageListener instanceof BusinessMessageCallback) {
                                b a11 = b.a();
                                a11.b("[dealBusinessMsg]TP callback to messageReceived with st. bisType: " + num + ", workId: " + str3 + ", msg: " + str4);
                                ((BusinessMessageCallback) businessMessageListener).messageReceived(i13, num.intValue(), str3, str4);
                                return false;
                            }
                            b a12 = b.a();
                            a12.b("[dealBusinessMsg]TP callback to messageReceived. bisType: " + num + ", workId: " + str3 + ", msg: " + str4);
                            businessMessageListener.messageReceived(num.intValue(), str3, str4);
                            return false;
                        }
                    });
                }
                return;
            }
            b a12 = b.a();
            a12.b("[dealBusinessMsg]TP No biz msg listener detected, cache msg. bisType: " + valueOf);
            HashMap hashMap = new HashMap();
            hashMap.put("bisType", valueOf);
            hashMap.put("workId", str);
            hashMap.put(MTPushConstants.Analysis.KEY_JSON, fromHashMap);
            g.a().a(hashMap);
        } catch (Throwable th2) {
            b.a().a(th2);
        }
    }

    public void a(a aVar, Throwable th2) {
        b a11 = b.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TP exceptionCaught : ");
        sb2.append(th2 != null ? th2.getMessage() : "");
        a11.b(sb2.toString());
    }

    public void a(a aVar) {
        b.a().b("TP sessionOpened");
    }

    public void a(a aVar, boolean z11) {
        b a11 = b.a();
        a11.b("TP sessionClosed " + z11);
        b.a().c();
        if (z11) {
            l();
        }
    }

    public String a(String str, String str2) throws Throwable {
        return Data.AES128Decode(str, Base64.decode(str2, 2));
    }

    public static int a(HashMap<String, Object> hashMap, String str, int i11) {
        if (hashMap != null && hashMap.containsKey(str)) {
            Object obj = hashMap.get(str);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
        }
        return i11;
    }

    public void a(TcpStatusListener tcpStatusListener) {
        this.B = tcpStatusListener;
    }

    public void a(TcpStatus tcpStatus) {
        this.C = tcpStatus;
    }
}
