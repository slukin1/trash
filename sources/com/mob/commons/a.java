package com.mob.commons;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.iproov.sdk.bridge.OptionsBridge;
import com.jumio.core.cdn.CDNDownload;
import com.jumio.sdk.reject.JumioRejectReason;
import com.mob.MobSDK;
import com.mob.commons.b.d;
import com.mob.tools.MobLog;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.e;
import com.sumsub.sns.internal.fingerprint.signalproviders.f;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f26892a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f26893b = new byte[0];

    /* access modifiers changed from: private */
    public boolean f() {
        ab a11 = ab.a();
        String str = ab.f26987a;
        long b11 = a11.b(str, -1);
        if (b11 == -1) {
            ab.a().a(str, System.currentTimeMillis());
            return false;
        }
        if (System.currentTimeMillis() >= b11 + (((Long) b.a(m.a("005%babgchKbh"), 2592000L)).longValue() * 1000)) {
            return true;
        }
        return false;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final List<String> f26906a = Arrays.asList(new String[]{"4c5f81a0-4728-476f-a57f-b46fa44f07d3", "f6af99e2-2b64-4eb6-aba6-4d44fb935939", "00000000-0000-0000-0000-000000000000"});

        /* renamed from: b  reason: collision with root package name */
        private List<String> f26907b;

        private b() {
        }

        private void c() {
            c cVar;
            if (MobSDK.SDK_VERSION_CODE + 30 >= d()) {
                cVar = ab.a().i();
            } else {
                cVar = e();
            }
            if (!(cVar == null || cVar.c() == null)) {
                this.f26907b = cVar.c();
            }
            if (this.f26907b == null) {
                this.f26907b = f26906a;
            }
        }

        private int d() {
            return Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        }

        private c e() {
            try {
                NetworkHelper networkHelper = new NetworkHelper();
                NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                networkTimeOut.connectionTimeout = 2000;
                networkTimeOut.readTimout = 5000;
                String httpPostNew = networkHelper.httpPostNew(i.a().a("dg") + "/getDuidBlacklist", (HashMap<String, Object>) null, (HashMap<String, String>) null, networkTimeOut);
                HashMap fromJson = HashonHelper.fromJson(httpPostNew);
                if (fromJson != null && !fromJson.isEmpty()) {
                    if (JumioRejectReason.NOT_READABLE.equals(String.valueOf(fromJson.get(m.a("006.dgGgbg-bedg"))))) {
                        String valueOf = String.valueOf(fromJson.get(m.a("0041baObgb")));
                        if (!TextUtils.isEmpty(valueOf)) {
                            c a11 = c.a(Data.AES128Decode(f(), Base64.decode(valueOf, 0)));
                            ab.a().a(a11);
                            return a11;
                        }
                    } else {
                        throw new Throwable("RS is illegal: " + httpPostNew);
                    }
                }
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
            return null;
        }

        private String f() {
            String[] strArr = {"QvxJJ", "FYsAX", "cvWe", "MqlWJL"};
            return strArr[1] + strArr[3] + new String[]{"akuRE", "wbMqR", "uBs", "CDpnc"}[3];
        }

        public C0238a a() {
            c();
            return b();
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x00a0 A[Catch:{ all -> 0x0095, all -> 0x00d0 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.mob.commons.a.C0238a b() {
            /*
                r10 = this;
                java.lang.String r0 = ":"
                java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch
                r2 = 1
                r1.<init>(r2)
                java.lang.String[] r3 = new java.lang.String[r2]
                android.content.Context r4 = com.mob.MobSDK.getContext()
                com.mob.tools.utils.DH$RequestBuilder r4 = com.mob.tools.utils.DH.requester(r4)
                com.mob.tools.utils.DH$RequestBuilder r4 = r4.getAdvertisingID()
                com.mob.commons.a$b$1 r5 = new com.mob.commons.a$b$1
                r5.<init>(r3, r1)
                r4.request(r5)
                r4 = 500(0x1f4, double:2.47E-321)
                java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0025 }
                r1.await(r4, r6)     // Catch:{ all -> 0x0025 }
            L_0x0025:
                r1 = 0
                java.lang.String r4 = com.mob.tools.utils.DH.SyncMtd.getModel()     // Catch:{ all -> 0x00d0 }
                if (r4 != 0) goto L_0x002e
                r4 = r1
                goto L_0x0032
            L_0x002e:
                java.lang.String r4 = r4.trim()     // Catch:{ all -> 0x00d0 }
            L_0x0032:
                com.mob.commons.y r5 = com.mob.commons.y.a()     // Catch:{ all -> 0x00d0 }
                java.lang.String r5 = r5.h()     // Catch:{ all -> 0x00d0 }
                boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00d0 }
                r7 = 0
                if (r6 != 0) goto L_0x0042
                goto L_0x0058
            L_0x0042:
                r5 = r3[r7]     // Catch:{ all -> 0x00d0 }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00d0 }
                if (r5 != 0) goto L_0x0057
                java.util.List<java.lang.String> r5 = r10.f26907b     // Catch:{ all -> 0x00d0 }
                r6 = r3[r7]     // Catch:{ all -> 0x00d0 }
                boolean r5 = r5.contains(r6)     // Catch:{ all -> 0x00d0 }
                if (r5 != 0) goto L_0x0057
                r5 = r3[r7]     // Catch:{ all -> 0x00d0 }
                goto L_0x0058
            L_0x0057:
                r5 = r1
            L_0x0058:
                boolean r3 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00d0 }
                if (r3 == 0) goto L_0x0067
                long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00d0 }
                java.lang.String r5 = r10.a(r5)     // Catch:{ all -> 0x00d0 }
                goto L_0x0068
            L_0x0067:
                r2 = r7
            L_0x0068:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
                r3.<init>()     // Catch:{ all -> 0x00d0 }
                r3.append(r4)     // Catch:{ all -> 0x00d0 }
                r3.append(r0)     // Catch:{ all -> 0x00d0 }
                r3.append(r5)     // Catch:{ all -> 0x00d0 }
                r3.append(r0)     // Catch:{ all -> 0x00d0 }
                r3.append(r1)     // Catch:{ all -> 0x00d0 }
                r3.append(r0)     // Catch:{ all -> 0x00d0 }
                r3.append(r1)     // Catch:{ all -> 0x00d0 }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00d0 }
                boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0095 }
                if (r3 != 0) goto L_0x009d
                byte[] r3 = com.mob.tools.utils.Data.SHA1((java.lang.String) r0)     // Catch:{ all -> 0x0095 }
                java.lang.String r3 = com.mob.tools.utils.Data.byteToHex(r3)     // Catch:{ all -> 0x0095 }
                goto L_0x009e
            L_0x0095:
                r3 = move-exception
                com.mob.tools.log.NLog r4 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x00d0 }
                r4.d(r3)     // Catch:{ all -> 0x00d0 }
            L_0x009d:
                r3 = r1
            L_0x009e:
                if (r2 == 0) goto L_0x00b1
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
                r2.<init>()     // Catch:{ all -> 0x00d0 }
                java.lang.String r4 = "s_"
                r2.append(r4)     // Catch:{ all -> 0x00d0 }
                r2.append(r3)     // Catch:{ all -> 0x00d0 }
                java.lang.String r3 = r2.toString()     // Catch:{ all -> 0x00d0 }
            L_0x00b1:
                byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x00d0 }
                r2 = 2
                java.lang.String r9 = android.util.Base64.encodeToString(r0, r2)     // Catch:{ all -> 0x00d0 }
                com.mob.commons.a$a r0 = new com.mob.commons.a$a     // Catch:{ all -> 0x00d0 }
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d0 }
                java.lang.String r6 = "client"
                r7 = 0
                r2 = r0
                r2.<init>(r3, r4, r6, r7, r9)     // Catch:{ all -> 0x00d0 }
                com.mob.commons.ab r2 = com.mob.commons.ab.a()     // Catch:{ all -> 0x00d0 }
                r2.a((com.mob.commons.a.C0238a) r0)     // Catch:{ all -> 0x00d0 }
                return r0
            L_0x00d0:
                r0 = move-exception
                com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
                r2.d(r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.a.b.b():com.mob.commons.a$a");
        }

        private String a(long j11) {
            String uuid = UUID.randomUUID().toString();
            return TextUtils.isEmpty(uuid) ? b(j11) : uuid;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.io.ByteArrayOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.io.ByteArrayOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.io.ByteArrayOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.io.ByteArrayOutputStream} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String b(long r9) {
            /*
                r8 = this;
                r0 = 1
                r1 = 0
                r2 = 2
                r3 = 0
                java.security.SecureRandom r4 = new java.security.SecureRandom     // Catch:{ all -> 0x0039 }
                r4.<init>()     // Catch:{ all -> 0x0039 }
                long r4 = r4.nextLong()     // Catch:{ all -> 0x0039 }
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0039 }
                long r9 = r9 + r6
                java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0039 }
                r6.<init>()     // Catch:{ all -> 0x0039 }
                java.io.DataOutputStream r7 = new java.io.DataOutputStream     // Catch:{ all -> 0x0036 }
                r7.<init>(r6)     // Catch:{ all -> 0x0036 }
                r7.writeLong(r4)     // Catch:{ all -> 0x0034 }
                r7.writeLong(r9)     // Catch:{ all -> 0x0034 }
                byte[] r9 = r6.toByteArray()     // Catch:{ all -> 0x0034 }
                java.lang.String r3 = com.mob.tools.utils.Data.byteToHex(r9)     // Catch:{ all -> 0x0034 }
                java.io.Closeable[] r9 = new java.io.Closeable[r2]
                r9[r1] = r7
                r9[r0] = r6
                com.mob.commons.v.a((java.io.Closeable[]) r9)
                goto L_0x004c
            L_0x0034:
                r9 = move-exception
                goto L_0x003c
            L_0x0036:
                r9 = move-exception
                r7 = r3
                goto L_0x003c
            L_0x0039:
                r9 = move-exception
                r6 = r3
                r7 = r6
            L_0x003c:
                com.mob.tools.log.NLog r10 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x004d }
                r10.d(r9)     // Catch:{ all -> 0x004d }
                java.io.Closeable[] r9 = new java.io.Closeable[r2]
                r9[r1] = r7
                r9[r0] = r6
                com.mob.commons.v.a((java.io.Closeable[]) r9)
            L_0x004c:
                return r3
            L_0x004d:
                r9 = move-exception
                java.io.Closeable[] r10 = new java.io.Closeable[r2]
                r10[r1] = r7
                r10[r0] = r6
                com.mob.commons.v.a((java.io.Closeable[]) r10)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.a.b.b(long):java.lang.String");
        }
    }

    private String c() {
        return m.a("0160dgbacfbjXaZbibdbdbi4cbh-bjdgbacf");
    }

    /* access modifiers changed from: private */
    public File d() {
        return ResHelper.getDataCacheFile(MobSDK.getContext(), m.f27279b, true);
    }

    /* access modifiers changed from: private */
    public HashMap<String, Object> e() {
        try {
            return a(DH.SyncMtd.getModel(), ResHelper.readFromFileNoCompress(d()));
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return new HashMap<>();
        }
    }

    public synchronized String b() {
        String str;
        Throwable th2;
        try {
            str = a();
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.equals(OptionsBridge.NULL_VALUE, str)) {
                    return str;
                }
                C0238a a11 = new b().a();
                if (a11 != null) {
                    str = a11.c();
                }
            } catch (Throwable th3) {
                th2 = th3;
                MobLog.getInstance().d(th2);
                return str;
            }
        } catch (Throwable th4) {
            Throwable th5 = th4;
            str = null;
            th2 = th5;
            MobLog.getInstance().d(th2);
            return str;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private List<String> f26913a;

        /* renamed from: b  reason: collision with root package name */
        private List<String> f26914b;

        public c(List<String> list, List<String> list2) {
            this.f26913a = list;
            this.f26914b = list2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A[Catch:{ all -> 0x0047 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.mob.commons.a.c a(java.lang.String r3) {
            /*
                boolean r0 = android.text.TextUtils.isEmpty(r3)
                r1 = 0
                if (r0 != 0) goto L_0x004f
                java.util.HashMap r3 = com.mob.tools.utils.HashonHelper.fromJson(r3)     // Catch:{ all -> 0x0047 }
                java.lang.String r0 = "idfas"
                java.lang.Object r0 = r3.get(r0)     // Catch:{ all -> 0x0047 }
                if (r0 == 0) goto L_0x0025
                boolean r2 = r0 instanceof java.lang.String     // Catch:{ all -> 0x0047 }
                if (r2 == 0) goto L_0x001e
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0047 }
                java.util.List r0 = b(r0)     // Catch:{ all -> 0x0047 }
                goto L_0x0026
            L_0x001e:
                boolean r2 = r0 instanceof java.util.List     // Catch:{ all -> 0x0047 }
                if (r2 == 0) goto L_0x0025
                java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0047 }
                goto L_0x0026
            L_0x0025:
                r0 = r1
            L_0x0026:
                java.lang.String r2 = "oiid"
                java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x0047 }
                if (r3 == 0) goto L_0x0040
                boolean r2 = r3 instanceof java.lang.String     // Catch:{ all -> 0x0047 }
                if (r2 == 0) goto L_0x0039
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0047 }
                java.util.List r3 = b(r3)     // Catch:{ all -> 0x0047 }
                goto L_0x0041
            L_0x0039:
                boolean r2 = r3 instanceof java.util.List     // Catch:{ all -> 0x0047 }
                if (r2 == 0) goto L_0x0040
                java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0047 }
                goto L_0x0041
            L_0x0040:
                r3 = r1
            L_0x0041:
                com.mob.commons.a$c r2 = new com.mob.commons.a$c     // Catch:{ all -> 0x0047 }
                r2.<init>(r0, r3)     // Catch:{ all -> 0x0047 }
                return r2
            L_0x0047:
                r3 = move-exception
                com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()
                r0.d(r3)
            L_0x004f:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.a.c.a(java.lang.String):com.mob.commons.a$c");
        }

        public HashMap<String, Object> b() {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("idfas", this.f26913a);
            hashMap.put("oiid", this.f26914b);
            return hashMap;
        }

        public List<String> c() {
            return this.f26913a;
        }

        public List<String> d() {
            return this.f26914b;
        }

        private static List<String> b(String str) {
            String[] split;
            if (TextUtils.isEmpty(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length <= 0) {
                return new ArrayList();
            }
            return new ArrayList(Arrays.asList(split));
        }

        public String a() {
            return HashonHelper.fromHashMap(b());
        }
    }

    public synchronized String a() {
        C0238a j11 = ab.a().j();
        if (j11 == null || TextUtils.isEmpty(j11.c())) {
            return null;
        }
        return j11.c();
    }

    /* access modifiers changed from: private */
    public static byte[] b(String str, HashMap<String, Object> hashMap) {
        String fromHashMap = HashonHelper.fromHashMap(hashMap);
        try {
            return Data.AES128Encode(str, fromHashMap);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return fromHashMap.getBytes();
        }
    }

    public void a(final MobProduct mobProduct, final e<Void> eVar) {
        MobLog.getInstance().d("di init", new Object[0]);
        DH.RequestBuilder grammaticalGender = DH.requester(MobSDK.getContext()).getAdvertisingID().getCarrier().getMemoryInfo().getSizeInfo().cx().isRooted().getDeviceType().checkPad().getScreenSize().getDetailNetworkTypeForStatic().getODH().getOD().getAppLastUpdateTime().getMIUIVersion().getInnerAppLanguage().getGrammaticalGender();
        if (((Integer) b.a("ndi", 0)).intValue() == 1) {
            grammaticalGender.getLATime(m.a("028j7ba-bgbj*dgcadg>gd=bd!jebKdgDgLfi6fdbCba6dKbhbj!g-cg(g")).getLATime(m.a("035j@baQbgbj_dgcadg,gdGbd'j^deKbgafeKbgdgAg7bfdg:dgg,bg<cOchdgbjcgbdYe")).getLATime(m.a("028jVba@bgbjOdgcadgNgd6bdYje8bi%a6cfdg0dgg.bg(cSchdgbjbadd")).getLATime(m.a("005j+baYbgb")).getLATime(m.a("012jZba,bgbjDdgcadg*gdKbd")).getLATime(m.a("018j,ba>bgbj[dgcadgIgdMbdMj9bedgCd0bhdg")).getLATime(m.a("045jMba;bgbj'dgcadg8gd:bdHjWbedgMd3bhdg?j*dfOj(dg6dggGbg:cAchdgbfcdbgWcEchOd bh.hQbhbg2cgUbjcgbdPe"));
        }
        grammaticalGender.request(new DH.DHResponder() {
            /* JADX WARNING: Removed duplicated region for block: B:13:0x008c A[Catch:{ all -> 0x00ac }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(com.mob.tools.utils.DH.DHResponse r13) {
                /*
                    r12 = this;
                    r0 = 0
                    com.mob.commons.a r1 = com.mob.commons.a.this     // Catch:{ all -> 0x00ac }
                    byte[] r1 = r1.f26893b     // Catch:{ all -> 0x00ac }
                    monitor-enter(r1)     // Catch:{ all -> 0x00ac }
                    com.mob.commons.a r2 = com.mob.commons.a.this     // Catch:{ all -> 0x00a9 }
                    java.lang.String r3 = com.mob.commons.e.f27200a     // Catch:{ all -> 0x00a9 }
                    java.lang.String r2 = r2.a((java.lang.String) r3, (com.mob.tools.utils.DH.DHResponse) r13)     // Catch:{ all -> 0x00a9 }
                    com.mob.commons.a r3 = com.mob.commons.a.this     // Catch:{ all -> 0x00a9 }
                    java.util.HashMap r3 = r3.e()     // Catch:{ all -> 0x00a9 }
                    com.mob.commons.a r4 = com.mob.commons.a.this     // Catch:{ all -> 0x00a9 }
                    boolean r4 = r4.a((java.util.HashMap<java.lang.String, java.lang.Object>) r3, (com.mob.tools.utils.DH.DHResponse) r13)     // Catch:{ all -> 0x00a9 }
                    com.mob.commons.a r5 = com.mob.commons.a.this     // Catch:{ all -> 0x00a9 }
                    boolean r5 = r5.f()     // Catch:{ all -> 0x00a9 }
                    com.mob.commons.a r6 = com.mob.commons.a.this     // Catch:{ all -> 0x00a9 }
                    r7 = 0
                    r8 = 1
                    if (r4 != 0) goto L_0x002d
                    if (r5 == 0) goto L_0x002b
                    goto L_0x002d
                L_0x002b:
                    r9 = r7
                    goto L_0x002e
                L_0x002d:
                    r9 = r8
                L_0x002e:
                    boolean unused = r6.f26892a = r9     // Catch:{ all -> 0x00a9 }
                    com.mob.commons.a r6 = com.mob.commons.a.this     // Catch:{ all -> 0x00a9 }
                    com.mob.commons.MobProduct r9 = r5     // Catch:{ all -> 0x00a9 }
                    boolean r6 = r6.a((java.util.HashMap<java.lang.String, java.lang.Object>) r3, (com.mob.commons.MobProduct) r9, (com.mob.tools.utils.DH.DHResponse) r13)     // Catch:{ all -> 0x00a9 }
                    com.mob.tools.log.NLog r9 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x00a9 }
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
                    r10.<init>()     // Catch:{ all -> 0x00a9 }
                    java.lang.String r11 = "map: "
                    r10.append(r11)     // Catch:{ all -> 0x00a9 }
                    r10.append(r3)     // Catch:{ all -> 0x00a9 }
                    java.lang.String r11 = "\nisCh: "
                    r10.append(r11)     // Catch:{ all -> 0x00a9 }
                    r10.append(r4)     // Catch:{ all -> 0x00a9 }
                    java.lang.String r11 = ", isG: "
                    r10.append(r11)     // Catch:{ all -> 0x00a9 }
                    r10.append(r5)     // Catch:{ all -> 0x00a9 }
                    java.lang.String r5 = ", isReg: "
                    r10.append(r5)     // Catch:{ all -> 0x00a9 }
                    r10.append(r6)     // Catch:{ all -> 0x00a9 }
                    java.lang.String r5 = r10.toString()     // Catch:{ all -> 0x00a9 }
                    java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x00a9 }
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
                    r10.<init>()     // Catch:{ all -> 0x00a9 }
                    java.lang.String r11 = ", udif:"
                    r10.append(r11)     // Catch:{ all -> 0x00a9 }
                    com.mob.commons.a r11 = com.mob.commons.a.this     // Catch:{ all -> 0x00a9 }
                    boolean r11 = r11.f26892a     // Catch:{ all -> 0x00a9 }
                    r10.append(r11)     // Catch:{ all -> 0x00a9 }
                    java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00a9 }
                    r8[r7] = r10     // Catch:{ all -> 0x00a9 }
                    r9.d(r5, r8)     // Catch:{ all -> 0x00a9 }
                    com.mob.commons.a r5 = com.mob.commons.a.this     // Catch:{ all -> 0x00a9 }
                    boolean r5 = r5.f26892a     // Catch:{ all -> 0x00a9 }
                    if (r5 == 0) goto L_0x0099
                    boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00a9 }
                    if (r5 == 0) goto L_0x0094
                    java.lang.String r2 = com.mob.commons.e.f27200a     // Catch:{ all -> 0x00a9 }
                L_0x0094:
                    com.mob.commons.a r5 = com.mob.commons.a.this     // Catch:{ all -> 0x00a9 }
                    r5.a((java.util.HashMap<java.lang.String, java.lang.Object>) r3, (java.lang.String) r2, (com.mob.tools.utils.DH.DHResponse) r13)     // Catch:{ all -> 0x00a9 }
                L_0x0099:
                    if (r4 != 0) goto L_0x009d
                    if (r6 == 0) goto L_0x00a2
                L_0x009d:
                    com.mob.commons.a r13 = com.mob.commons.a.this     // Catch:{ all -> 0x00a9 }
                    r13.a((java.util.HashMap<java.lang.String, java.lang.Object>) r3)     // Catch:{ all -> 0x00a9 }
                L_0x00a2:
                    monitor-exit(r1)     // Catch:{ all -> 0x00a9 }
                    com.mob.tools.utils.e r13 = r6
                    r13.a(r0)
                    return
                L_0x00a9:
                    r13 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x00a9 }
                    throw r13     // Catch:{ all -> 0x00ac }
                L_0x00ac:
                    r13 = move-exception
                    com.mob.tools.utils.e r1 = r6
                    r1.a(r0)
                    throw r13
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.a.AnonymousClass1.onResponse(com.mob.tools.utils.DH$DHResponse):void");
            }
        });
    }

    /* renamed from: com.mob.commons.a$a  reason: collision with other inner class name */
    public static class C0238a {

        /* renamed from: a  reason: collision with root package name */
        private String f26899a;

        /* renamed from: b  reason: collision with root package name */
        private long f26900b;

        /* renamed from: c  reason: collision with root package name */
        private String f26901c;

        /* renamed from: d  reason: collision with root package name */
        private long f26902d;

        /* renamed from: e  reason: collision with root package name */
        private String f26903e;

        public C0238a(String str, long j11, String str2, long j12, String str3) {
            this.f26899a = str;
            this.f26900b = j11;
            this.f26901c = str2;
            this.f26902d = j12;
            this.f26903e = str3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x003b A[Catch:{ all -> 0x00a6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x003d A[Catch:{ all -> 0x00a6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0056 A[Catch:{ all -> 0x00a6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0058 A[Catch:{ all -> 0x00a6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0063 A[Catch:{ all -> 0x00a6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0083 A[Catch:{ all -> 0x00a6 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.mob.commons.a.C0238a a(java.lang.String r12) {
            /*
                boolean r0 = android.text.TextUtils.isEmpty(r12)
                r1 = 0
                if (r0 != 0) goto L_0x00ae
                java.util.HashMap r12 = com.mob.tools.utils.HashonHelper.fromJson(r12)     // Catch:{ all -> 0x00a6 }
                java.lang.String r0 = "004Pbabebgba"
                java.lang.String r0 = com.mob.commons.m.a(r0)     // Catch:{ all -> 0x00a6 }
                java.lang.Object r0 = r12.get(r0)     // Catch:{ all -> 0x00a6 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00a6 }
                boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00a6 }
                java.lang.String r3 = "null"
                if (r2 != 0) goto L_0x0026
                boolean r2 = android.text.TextUtils.equals(r3, r0)     // Catch:{ all -> 0x00a6 }
                if (r2 != 0) goto L_0x0026
                goto L_0x0027
            L_0x0026:
                r0 = r1
            L_0x0027:
                java.lang.String r2 = "genType"
                java.lang.Object r2 = r12.get(r2)     // Catch:{ all -> 0x00a6 }
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00a6 }
                boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00a6 }
                if (r4 != 0) goto L_0x003d
                boolean r4 = android.text.TextUtils.equals(r3, r2)     // Catch:{ all -> 0x00a6 }
                if (r4 != 0) goto L_0x003d
                r6 = r2
                goto L_0x003e
            L_0x003d:
                r6 = r1
            L_0x003e:
                java.lang.String r2 = "002.chIh"
                java.lang.String r2 = com.mob.commons.m.a(r2)     // Catch:{ all -> 0x00a6 }
                java.lang.Object r2 = r12.get(r2)     // Catch:{ all -> 0x00a6 }
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00a6 }
                boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00a6 }
                if (r4 != 0) goto L_0x0058
                boolean r3 = android.text.TextUtils.equals(r3, r2)     // Catch:{ all -> 0x00a6 }
                if (r3 != 0) goto L_0x0058
                r9 = r2
                goto L_0x0059
            L_0x0058:
                r9 = r1
            L_0x0059:
                java.lang.String r2 = "gt"
                java.lang.Object r2 = r12.get(r2)     // Catch:{ all -> 0x00a6 }
                r3 = 0
                if (r2 == 0) goto L_0x007a
                boolean r5 = r2 instanceof java.lang.Long     // Catch:{ all -> 0x00a6 }
                if (r5 == 0) goto L_0x006e
                java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x00a6 }
                long r7 = r2.longValue()     // Catch:{ all -> 0x00a6 }
                goto L_0x007b
            L_0x006e:
                boolean r5 = r2 instanceof java.lang.Integer     // Catch:{ all -> 0x00a6 }
                if (r5 == 0) goto L_0x007a
                java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x00a6 }
                int r2 = r2.intValue()     // Catch:{ all -> 0x00a6 }
                long r7 = (long) r2     // Catch:{ all -> 0x00a6 }
                goto L_0x007b
            L_0x007a:
                r7 = r3
            L_0x007b:
                java.lang.String r2 = "expTime"
                java.lang.Object r12 = r12.get(r2)     // Catch:{ all -> 0x00a6 }
                if (r12 == 0) goto L_0x009b
                boolean r2 = r12 instanceof java.lang.Long     // Catch:{ all -> 0x00a6 }
                if (r2 == 0) goto L_0x008f
                java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x00a6 }
                long r2 = r12.longValue()     // Catch:{ all -> 0x00a6 }
            L_0x008d:
                r10 = r2
                goto L_0x009c
            L_0x008f:
                boolean r2 = r12 instanceof java.lang.Integer     // Catch:{ all -> 0x00a6 }
                if (r2 == 0) goto L_0x009b
                java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ all -> 0x00a6 }
                int r12 = r12.intValue()     // Catch:{ all -> 0x00a6 }
                long r2 = (long) r12     // Catch:{ all -> 0x00a6 }
                goto L_0x008d
            L_0x009b:
                r10 = r3
            L_0x009c:
                com.mob.commons.a$a r12 = new com.mob.commons.a$a     // Catch:{ all -> 0x00a6 }
                r2 = r12
                r3 = r0
                r4 = r7
                r7 = r10
                r2.<init>(r3, r4, r6, r7, r9)     // Catch:{ all -> 0x00a6 }
                return r12
            L_0x00a6:
                r12 = move-exception
                com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()
                r0.d(r12)
            L_0x00ae:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.a.C0238a.a(java.lang.String):com.mob.commons.a$a");
        }

        public HashMap<String, Object> b() {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(m.a("004+babebgba"), this.f26899a);
            hashMap.put("gt", Long.valueOf(this.f26900b));
            hashMap.put("genType", this.f26901c);
            hashMap.put("expTime", Long.valueOf(this.f26902d));
            hashMap.put(m.a("0026chPh"), this.f26903e);
            return hashMap;
        }

        public String c() {
            return this.f26899a;
        }

        public long d() {
            return this.f26900b;
        }

        public String e() {
            return this.f26901c;
        }

        public long f() {
            return this.f26902d;
        }

        public String g() {
            return this.f26903e;
        }

        public String a() {
            return HashonHelper.fromHashMap(b());
        }

        public boolean a(long j11) {
            long j12 = this.f26902d;
            return j12 == 0 || j11 + (j12 * 1000) <= System.currentTimeMillis();
        }
    }

    /* access modifiers changed from: private */
    public String a(String str, DH.DHResponse dHResponse) {
        try {
            if (!b.c()) {
                return null;
            }
            C0238a j11 = ab.a().j();
            if (j11 != null) {
                if (!j11.a(ab.a().b("key_request_duid_time", 0)) && !y.a().d()) {
                    return null;
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put(m.a("004hebg"), 1);
            hashMap.put(m.a("005(bdbiba!de"), DH.SyncMtd.getModel());
            hashMap.put(m.a("007IcdEbag=bibhca"), DH.SyncMtd.getManufacturer());
            hashMap.put("admt", dHResponse.getAdvertisingID());
            hashMap.put("oamt", com.mob.tools.b.c.a(MobSDK.getContext()).d().ah());
            hashMap.put("btt", Long.valueOf(SystemClock.elapsedRealtime()));
            hashMap.put(m.a("004Hbhbabgba"), y.a().e());
            hashMap.put(f.f34662a, y.a().b());
            hashMap.put(m.a("004hGbebgba"), y.a().g());
            hashMap.put(m.a("005Qbabhbdbgba"), y.a().h());
            hashMap.put(m.a("008g)bi8h[bfbabhbddg"), y.a().i());
            if (j11 == null) {
                hashMap.put(m.a("004Xbabebgba"), str);
                hashMap.put("genType", "common");
            } else {
                hashMap.put(m.a("004@babebgba"), j11.c());
                hashMap.put("gt", Long.valueOf(j11.d()));
                hashMap.put("genType", j11.e());
                hashMap.put("expTime", Long.valueOf(j11.f()));
                hashMap.put(m.a("002%ch!h"), j11.g());
            }
            NetCommunicator netCommunicator = new NetCommunicator(1024, "ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", "191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd");
            HashMap hashMap2 = (HashMap) netCommunicator.requestWithoutEncode(true, (HashMap<String, String>) null, hashMap, i.a().a("dg") + "/v4/dgen", true);
            if (hashMap2 != null) {
                ab.a().a("key_request_duid_time", System.currentTimeMillis());
                String str2 = (String) hashMap2.get(m.a("0040bhbabgba"));
                if (!TextUtils.isEmpty(str2)) {
                    y.a().a(str2);
                }
                C0238a a11 = C0238a.a(HashonHelper.fromHashMap(hashMap2));
                if (a11 != null) {
                    ab.a().a(a11);
                    return a11.c();
                }
            }
            return null;
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.util.HashMap<java.lang.String, java.lang.Object> r6, com.mob.commons.MobProduct r7, com.mob.tools.utils.DH.DHResponse r8) {
        /*
            r5 = this;
            if (r7 != 0) goto L_0x0007
            com.mob.commons.Authorizer$2 r7 = new com.mob.commons.Authorizer$2
            r7.<init>(r5)
        L_0x0007:
            r0 = 0
            java.lang.String r1 = "007bhhJccEc!cdbi"
            java.lang.String r1 = com.mob.commons.m.a(r1)     // Catch:{ all -> 0x0051 }
            java.lang.Object r1 = r6.get(r1)     // Catch:{ all -> 0x0051 }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ all -> 0x0051 }
            r2 = 1
            if (r1 != 0) goto L_0x0026
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0051 }
            r1.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r3 = "007bhhEccDc]cdbi"
            java.lang.String r3 = com.mob.commons.m.a(r3)     // Catch:{ all -> 0x0051 }
            r6.put(r3, r1)     // Catch:{ all -> 0x0051 }
            r0 = r2
        L_0x0026:
            r3 = 0
            java.lang.String r4 = com.mob.tools.utils.DH.SyncMtd.getPackageName()     // Catch:{ all -> 0x0051 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0051 }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x003e
            java.lang.String r3 = r7.getProductTag()     // Catch:{ all -> 0x0051 }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x0051 }
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0051 }
        L_0x003e:
            java.lang.String r1 = com.mob.commons.u.a()     // Catch:{ all -> 0x0051 }
            if (r3 == 0) goto L_0x004a
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x0051 }
            if (r1 != 0) goto L_0x0059
        L_0x004a:
            boolean r6 = r5.a((com.mob.commons.MobProduct) r7, (java.util.HashMap<java.lang.String, java.lang.Object>) r6, (com.mob.tools.utils.DH.DHResponse) r8)     // Catch:{ all -> 0x0051 }
            if (r6 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0051:
            r6 = move-exception
            com.mob.tools.log.NLog r7 = com.mob.tools.MobLog.getInstance()
            r7.d(r6)
        L_0x0059:
            r2 = r0
        L_0x005a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.a.a(java.util.HashMap, com.mob.commons.MobProduct, com.mob.tools.utils.DH$DHResponse):boolean");
    }

    private boolean a(MobProduct mobProduct, HashMap<String, Object> hashMap, DH.DHResponse dHResponse) throws Throwable {
        if (!b.c()) {
            return false;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(m.a("007hPbhbibabeXag"), mobProduct.getProductTag());
        String str = null;
        C0238a j11 = ab.a().j();
        if (j11 != null) {
            str = j11.c();
        }
        String valueOf = String.valueOf(DH.SyncMtd.getPackageName());
        hashMap2.put(m.a("006bhh7cf8d_ca"), u.a());
        hashMap2.put(m.a("004+babebgba"), str);
        hashMap2.put(m.a("006bhhhJcfch"), valueOf);
        hashMap2.put(m.a("006bhh@bb0dKbh"), String.valueOf(DH.SyncMtd.getAppVersion()));
        hashMap2.put(m.a("006'dgbacfbbSdPbh"), String.valueOf(mobProduct.getSdkver()));
        hashMap2.put(m.a("007cdgCdebibhcf"), String.valueOf(dHResponse.getDetailNetworkTypeForStatic()));
        HashMap hashMap3 = new HashMap();
        hashMap3.put(m.a("013^cidg8d^bhficcba>dcgXbg;gEca"), aa.c());
        hashMap3.put(m.a("004<bdbibgba"), dHResponse.getODH());
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 10000;
        networkTimeOut.connectionTimeout = 10000;
        HashMap fromJson = HashonHelper.fromJson(new NetworkHelper().httpPostNew(i.a().a("dg") + m.a("006j+badgbgchAc"), hashMap2, hashMap3, networkTimeOut));
        if (m.a("004g!bhbeHd").equals(String.valueOf(fromJson.get(m.a("004^bh'dAbe>h"))))) {
            this.f26892a = true;
        }
        if (!JumioRejectReason.NOT_READABLE.equals(String.valueOf(fromJson.get(m.a("006Xdg%gbgZbedg"))))) {
            return false;
        }
        HashMap hashMap4 = (HashMap) hashMap.get(m.a("007bhh.cc1c cdbi"));
        HashMap hashMap5 = (HashMap) hashMap4.get(valueOf);
        if (hashMap5 == null) {
            hashMap5 = new HashMap();
        }
        hashMap5.put(mobProduct.getProductTag(), u.a());
        hashMap4.put(valueOf, hashMap5);
        hashMap.put(m.a("007bhhYccBcDcdbi"), hashMap4);
        return true;
    }

    /* access modifiers changed from: private */
    public void a(HashMap<String, Object> hashMap, String str, DH.DHResponse dHResponse) {
        try {
            if (b.c()) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(m.a("005gFbicf2dc"), ac.a().b());
                for (Map.Entry entry : ((HashMap) hashMap.get(m.a("010Eba^dNbbbg.ad@ccAc<cdbi"))).entrySet()) {
                    hashMap2.put(entry.getKey(), entry.getValue());
                }
                try {
                    hashMap2.put(m.a("007ab4bhbhbgPd3bh"), Integer.valueOf(Integer.parseInt(String.valueOf(hashMap2.get(m.a("007ab?bhbhbgLdKbh"))))));
                } catch (Throwable unused) {
                }
                hashMap2.put(m.a("004Rbabebgba"), str);
                HashMap<String, Long> memoryInfo = dHResponse.getMemoryInfo();
                HashMap<String, HashMap<String, Long>> sizeInfo = dHResponse.getSizeInfo();
                if (memoryInfo != null) {
                    hashMap2.put(m.a("003%bh?bKbd"), memoryInfo.get(m.a("005g9bi5gbe")));
                }
                if (sizeInfo != null) {
                    HashMap hashMap3 = sizeInfo.get(m.a("006Qdgba4ab+bhba"));
                    if (hashMap3 != null) {
                        hashMap2.put(m.a("013;dgbaUab)bhbacj6gRbibhNb>ch?d"), hashMap3.get(m.a("005gAbiKgbe")));
                    }
                    HashMap hashMap4 = sizeInfo.get(m.a("004UbaVbgb"));
                    if (hashMap4 != null) {
                        hashMap2.put(m.a("011Eba7bgb:cjTgUbibh3b7chSd"), hashMap4.get(m.a("005gPbiXgbe")));
                    }
                }
                try {
                    String str2 = (String) hashMap2.get("fsuud");
                    if (!TextUtils.isEmpty(str2)) {
                        hashMap2.put("fsuud", HashonHelper.fromJson(str2));
                    }
                } catch (Throwable unused2) {
                }
                hashMap2.put(m.a("0060bhbibdccbdch"), dHResponse.getMIUIVersion());
                String encodeToString = Base64.encodeToString(Data.AES128Encode(c(), HashonHelper.fromHashMap(hashMap2)), 2);
                HashMap hashMap5 = new HashMap();
                hashMap5.put("m", encodeToString);
                NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                networkTimeOut.readTimout = CDNDownload.DEFAULT_TIMEOUT;
                networkTimeOut.connectionTimeout = CDNDownload.DEFAULT_TIMEOUT;
                NetworkHelper networkHelper = new NetworkHelper();
                String str3 = i.a().a("dg") + m.a("006j7babgOcEcdbi");
                HashMap hashMap6 = new HashMap();
                hashMap6.put(m.a("0136cidgBd*bhficcbaJdcg.bg3g;ca"), aa.c());
                hashMap6.put(m.a("004Bbdbibgba"), com.mob.tools.b.c.a(MobSDK.getContext()).d().ai());
                if (JumioRejectReason.NOT_READABLE.equals(String.valueOf(HashonHelper.fromJson(networkHelper.httpPostNew(str3, hashMap5, hashMap6, networkTimeOut)).get(m.a("0069dg9gbg;bedg"))))) {
                    ab.a().a(ab.f26987a, System.currentTimeMillis());
                }
            }
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
    }

    /* access modifiers changed from: private */
    public void a(final HashMap<String, Object> hashMap) {
        p.a(p.a(p.f27290c), new o() {
            public boolean a(FileLocker fileLocker) {
                ResHelper.writeToFileNoCompress(a.this.d(), a.b(DH.SyncMtd.getModel(), hashMap));
                return false;
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean a(HashMap<String, Object> hashMap, DH.DHResponse dHResponse) {
        boolean z11;
        boolean z12;
        int i11;
        HashMap<String, Object> a11;
        boolean z13 = true;
        if (hashMap == null) {
            hashMap = new HashMap<>();
            z11 = true;
        } else {
            z11 = false;
        }
        HashMap hashMap2 = (HashMap) hashMap.get(m.a("010RbaCd]bbbgMad6ccRc[cdbi"));
        if (hashMap2 == null) {
            hashMap2 = new HashMap();
            hashMap.put(m.a("0105baEd1bbbg1ad'ccKcVcdbi"), hashMap2);
            z11 = true;
        }
        Object obj = hashMap2.get("admt");
        String advertisingID = dHResponse.getAdvertisingID();
        if (advertisingID == null || advertisingID.equals(obj)) {
            z12 = false;
        } else {
            hashMap2.put("admt", advertisingID);
            z12 = true;
        }
        Object obj2 = hashMap2.get(m.a("004(biEbVbgba"));
        String ah2 = com.mob.tools.b.c.a(MobSDK.getContext()).d().ah();
        if ((obj2 != null || TextUtils.isEmpty(ah2)) && (obj2 == null || String.valueOf(obj2).equals(ah2))) {
            i11 = 0;
        } else {
            hashMap2.put(m.a("004'bi)bNbgba"), ah2);
            z12 = true;
            i11 = 1;
        }
        Object obj3 = hashMap2.get(m.a("004 bhbabgba"));
        String c11 = y.a().c();
        if ((obj3 == null && !TextUtils.isEmpty(c11)) || (obj3 != null && !String.valueOf(obj3).equals(c11))) {
            hashMap2.put(m.a("004$bhbabgba"), c11);
            i11 |= 2;
            z12 = true;
        }
        Object obj4 = hashMap2.get(m.a("005Ibabhbdbgba"));
        String h11 = y.a().h();
        if ((obj4 == null && !TextUtils.isEmpty(h11)) || (obj4 != null && !String.valueOf(obj4).equals(h11))) {
            hashMap2.put(m.a("005Hbabhbdbgba"), h11);
            i11 |= 4;
            z12 = true;
        }
        Object obj5 = hashMap2.get(m.a("004h)bebgba"));
        String g11 = y.a().g();
        if ((obj5 == null && !TextUtils.isEmpty(g11)) || (obj5 != null && !String.valueOf(obj5).equals(g11))) {
            hashMap2.put(m.a("004hZbebgba"), g11);
            i11 |= 8;
            z12 = true;
        }
        Object obj6 = hashMap2.get(f.f34662a);
        String b11 = y.a().b();
        if ((obj6 == null && !TextUtils.isEmpty(b11)) || (obj6 != null && !String.valueOf(obj6).equals(b11))) {
            hashMap2.put(f.f34662a, b11);
            z12 = true;
        }
        hashMap2.put("cid_modify", Integer.valueOf(i11));
        if (z12) {
            z11 = true;
        }
        Object obj7 = hashMap2.get(m.a("005Tbdbiba0de"));
        String model = DH.SyncMtd.getModel();
        if (model != null && !model.equals(obj7)) {
            hashMap2.put(m.a("005Rbdbiba)de"), model);
            z11 = true;
        }
        Object obj8 = hashMap2.get(m.a("007=cd8bag2bibhca"));
        String manufacturer = DH.SyncMtd.getManufacturer();
        if (manufacturer != null && !manufacturer.equals(obj8)) {
            hashMap2.put(m.a("007Rcd1bag3bibhca"), manufacturer);
            z11 = true;
        }
        Object obj9 = hashMap2.get(m.a("007ab[bhbhbg*dKbh"));
        String carrier = dHResponse.getCarrier();
        if (carrier != null && !carrier.equals(obj9)) {
            hashMap2.put(m.a("007ab%bhbhbg0d<bh"), carrier);
            z11 = true;
        }
        Object obj10 = hashMap2.get(m.a("006>dgcadgbbQdEbh"));
        String oSVersionName = DH.SyncMtd.getOSVersionName();
        if (oSVersionName != null && !oSVersionName.equals(obj10)) {
            hashMap2.put(m.a("006 dgcadgbb,d-bh"), oSVersionName);
            z11 = true;
        }
        Object obj11 = hashMap2.get(m.a("002TcgHh"));
        boolean cx2 = dHResponse.cx();
        if (obj11 == null || !String.valueOf(cx2).equals(String.valueOf(obj11))) {
            hashMap2.put(m.a("0023cgZh"), Integer.valueOf(cx2 ? 1 : 0));
            z11 = true;
        }
        Object obj12 = hashMap2.get(m.a("007GddbhJdb'cfJdEba"));
        boolean isRooted = dHResponse.isRooted();
        hashMap2.put(m.a("007?ddbh@dbUcf@dGba"), Boolean.valueOf(isRooted));
        if ((obj12 == null && isRooted) || (obj12 != null && !String.valueOf(obj12).equals(String.valueOf(isRooted)))) {
            z11 = true;
        }
        String valueOf = String.valueOf(hashMap2.get("prelangmt"));
        String valueOf2 = String.valueOf(dHResponse.getInnerAppLanguage());
        if (!TextUtils.equals(valueOf, valueOf2)) {
            hashMap2.put("prelangmt", valueOf2);
            z11 = true;
        }
        Object obj13 = hashMap2.get("gramgendt");
        int grammaticalGender = dHResponse.getGrammaticalGender();
        if (obj13 == null || !TextUtils.equals(String.valueOf(obj13), String.valueOf(grammaticalGender))) {
            hashMap2.put("gramgendt", Integer.valueOf(grammaticalGender));
            z11 = true;
        }
        if (((Integer) b.a("ndi", 0)).intValue() == 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("fbt", Long.valueOf(dHResponse.getLATime(0)));
            linkedHashMap.put("fwt", Long.valueOf(dHResponse.getLATime(1)));
            linkedHashMap.put("fls", Long.valueOf(dHResponse.getLATime(2)));
            linkedHashMap.put("fda", Long.valueOf(dHResponse.getLATime(3)));
            linkedHashMap.put("fsm", Long.valueOf(dHResponse.getLATime(4)));
            linkedHashMap.put("fus", Long.valueOf(dHResponse.getLATime(5)));
            linkedHashMap.put("fsf", Long.valueOf(dHResponse.getLATime(6)));
            String fromHashMap = HashonHelper.fromHashMap(linkedHashMap);
            if (!TextUtils.equals((String) hashMap2.get("fsuud"), fromHashMap)) {
                hashMap2.put("fsuud", fromHashMap);
                hashMap2.put(m.a("004hebg"), Integer.valueOf(DH.SyncMtd.getPlatformCode()));
                hashMap2.put(m.a("010_baRd^bbbgCad7dacaWhd"), dHResponse.getDeviceType());
                hashMap2.put(m.a("003hbHba"), Integer.valueOf(dHResponse.checkPad() ? 1 : 0));
                hashMap2.put(m.a("010Mdg$aBbhZddc4dgbgebWd"), dHResponse.getScreenSize());
                a11 = d.a(MobSDK.getContext());
                if (a11 != null && a11.size() > 0) {
                    hashMap2.putAll(a11);
                }
                return z13;
            }
        }
        z13 = z11;
        hashMap2.put(m.a("004hebg"), Integer.valueOf(DH.SyncMtd.getPlatformCode()));
        hashMap2.put(m.a("010_baRd^bbbgCad7dacaWhd"), dHResponse.getDeviceType());
        hashMap2.put(m.a("003hbHba"), Integer.valueOf(dHResponse.checkPad() ? 1 : 0));
        hashMap2.put(m.a("010Mdg$aBbhZddc4dgbgebWd"), dHResponse.getScreenSize());
        a11 = d.a(MobSDK.getContext());
        hashMap2.putAll(a11);
        return z13;
    }

    private static HashMap<String, Object> a(String str, byte[] bArr) throws Throwable {
        return HashonHelper.fromJson(Data.AES128Decode(str, bArr));
    }
}
