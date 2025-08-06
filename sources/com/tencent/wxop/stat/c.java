package com.tencent.wxop.stat;

import android.content.Context;
import com.google.android.exoplayer2.audio.AacUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.jumio.core.cdn.CDNDownload;
import com.tencent.a.a.a.a.g;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.q;
import com.tencent.wxop.stat.b.r;
import java.net.URI;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static String M = "__MTA_KILL__";
    private static b N = l.av();
    public static ah O = new ah(2);
    public static ah P = new ah(1);
    private static d Q = d.APP_LAUNCH;
    private static boolean R = false;
    private static boolean S = true;
    private static int T = CDNDownload.DEFAULT_TIMEOUT;
    private static int U = AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND;
    private static int V = 30;
    public static String W = "__HIBERNATE__TIME";
    private static String X = null;
    private static String Y;
    private static String Z;
    public static int aA = 512;

    /* renamed from: aa  reason: collision with root package name */
    private static String f51031aa = "mta_channel";

    /* renamed from: ab  reason: collision with root package name */
    public static String f51032ab = "";

    /* renamed from: ac  reason: collision with root package name */
    private static int f51033ac = 180;

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f51034ad = false;

    /* renamed from: ae  reason: collision with root package name */
    public static int f51035ae = 100;

    /* renamed from: af  reason: collision with root package name */
    public static long f51036af = 10000;

    /* renamed from: ag  reason: collision with root package name */
    private static int f51037ag = 1024;

    /* renamed from: ah  reason: collision with root package name */
    public static boolean f51038ah = true;

    /* renamed from: ai  reason: collision with root package name */
    private static long f51039ai = 0;

    /* renamed from: aj  reason: collision with root package name */
    private static long f51040aj = 300000;

    /* renamed from: ak  reason: collision with root package name */
    public static boolean f51041ak = true;

    /* renamed from: al  reason: collision with root package name */
    public static volatile String f51042al = "pingma.qq.com:80";

    /* renamed from: am  reason: collision with root package name */
    private static volatile String f51043am = "http://pingma.qq.com:80/mstat/report";

    /* renamed from: an  reason: collision with root package name */
    private static int f51044an = 0;

    /* renamed from: ao  reason: collision with root package name */
    private static volatile int f51045ao = 0;

    /* renamed from: ap  reason: collision with root package name */
    private static int f51046ap = 20;

    /* renamed from: aq  reason: collision with root package name */
    private static int f51047aq = 0;

    /* renamed from: ar  reason: collision with root package name */
    private static boolean f51048ar = false;

    /* renamed from: as  reason: collision with root package name */
    private static int f51049as = 4096;

    /* renamed from: at  reason: collision with root package name */
    private static boolean f51050at = false;

    /* renamed from: au  reason: collision with root package name */
    private static String f51051au = null;

    /* renamed from: av  reason: collision with root package name */
    private static boolean f51052av = false;

    /* renamed from: aw  reason: collision with root package name */
    private static ai f51053aw = null;

    /* renamed from: ax  reason: collision with root package name */
    public static boolean f51054ax = true;

    /* renamed from: ay  reason: collision with root package name */
    public static int f51055ay = 0;

    /* renamed from: az  reason: collision with root package name */
    public static long f51056az = 10000;

    /* renamed from: c  reason: collision with root package name */
    public static String f51057c = "__HIBERNATE__";

    /* renamed from: w  reason: collision with root package name */
    private static int f51058w = 10;

    /* renamed from: x  reason: collision with root package name */
    private static int f51059x = 100;

    /* renamed from: y  reason: collision with root package name */
    private static int f51060y = 30;

    /* renamed from: z  reason: collision with root package name */
    private static int f51061z = 1;

    public static int A() {
        return f51046ap;
    }

    public static void B() {
        f51047aq++;
    }

    public static void C() {
        f51047aq = 0;
    }

    public static int D() {
        return f51047aq;
    }

    public static boolean E() {
        return f51050at;
    }

    public static ai F() {
        return f51053aw;
    }

    public static void a(Context context, ah ahVar) {
        int i11 = ahVar.aI;
        if (i11 == P.aI) {
            P = ahVar;
            a(ahVar.f50967df);
            if (!P.f50967df.isNull("iplist")) {
                g.r(context).b(P.f50967df.getString("iplist"));
            }
        } else if (i11 == O.aI) {
            O = ahVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0220, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        N.b((java.lang.Throwable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        N.e("__HIBERNATE__ not found.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0263, code lost:
        r11 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:90:0x0258 */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bc A[Catch:{ Exception -> 0x0220, all -> 0x0263 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0263 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0008] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r11, com.tencent.wxop.stat.ah r12, org.json.JSONObject r13) {
        /*
            java.lang.String r0 = "sm"
            java.lang.String r1 = "m"
            java.lang.String r2 = "c"
            java.lang.String r3 = "2.0.3"
            java.util.Iterator r4 = r13.keys()     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            r5 = 0
            r6 = r5
        L_0x000e:
            boolean r7 = r4.hasNext()     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            r8 = 1
            if (r7 == 0) goto L_0x0054
            java.lang.Object r7 = r4.next()     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            java.lang.String r9 = "v"
            boolean r9 = r7.equalsIgnoreCase(r9)     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            if (r9 == 0) goto L_0x002f
            int r7 = r13.getInt(r7)     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            int r9 = r12.L     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            if (r9 == r7) goto L_0x002c
            r6 = r8
        L_0x002c:
            r12.L = r7     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            goto L_0x000e
        L_0x002f:
            boolean r8 = r7.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            if (r8 == 0) goto L_0x0047
            java.lang.String r7 = r13.getString(r2)     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            int r8 = r7.length()     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            if (r8 <= 0) goto L_0x000e
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            r8.<init>(r7)     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            r12.f50967df = r8     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            goto L_0x000e
        L_0x0047:
            boolean r7 = r7.equalsIgnoreCase(r1)     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            if (r7 == 0) goto L_0x000e
            java.lang.String r7 = r13.getString(r1)     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            r12.f50966c = r7     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            goto L_0x000e
        L_0x0054:
            if (r6 != r8) goto L_0x025f
            android.content.Context r13 = com.tencent.wxop.stat.ak.aB()     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            com.tencent.wxop.stat.t r13 = com.tencent.wxop.stat.t.s(r13)     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            if (r13 == 0) goto L_0x0063
            r13.b((com.tencent.wxop.stat.ah) r12)     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
        L_0x0063:
            int r13 = r12.aI     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            com.tencent.wxop.stat.ah r1 = P     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            int r1 = r1.aI     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            if (r13 != r1) goto L_0x025f
            org.json.JSONObject r13 = r12.f50967df     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            a((org.json.JSONObject) r13)     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            org.json.JSONObject r13 = r12.f50967df     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            if (r13 == 0) goto L_0x025f
            int r1 = r13.length()     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            if (r1 != 0) goto L_0x007c
            goto L_0x025f
        L_0x007c:
            android.content.Context r1 = com.tencent.wxop.stat.ak.aB()     // Catch:{ JSONException -> 0x0258, all -> 0x0263 }
            java.lang.String r2 = M     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r2 = r13.optString(r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            boolean r4 = com.tencent.wxop.stat.b.l.e(r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            if (r4 == 0) goto L_0x0226
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            int r2 = r4.length()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            if (r2 != 0) goto L_0x0099
            goto L_0x0226
        L_0x0099:
            boolean r2 = r4.isNull(r0)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            if (r2 != 0) goto L_0x00f1
            java.lang.Object r0 = r4.get(r0)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            boolean r2 = r0 instanceof java.lang.Integer     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            if (r2 == 0) goto L_0x00ae
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
        L_0x00a9:
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            goto L_0x00ba
        L_0x00ae:
            boolean r2 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            if (r2 == 0) goto L_0x00b9
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            goto L_0x00a9
        L_0x00b9:
            r0 = r5
        L_0x00ba:
            if (r0 <= 0) goto L_0x00f1
            boolean r2 = R     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            if (r2 == 0) goto L_0x00d8
            com.tencent.wxop.stat.b.b r2 = N     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r7 = "match sleepTime:"
            r6.<init>(r7)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r6.append(r0)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r7 = " minutes"
            r6.append(r7)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r2.b((java.lang.Object) r6)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
        L_0x00d8:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            int r0 = r0 * 60
            int r0 = r0 * 1000
            long r9 = (long) r0     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            long r6 = r6 + r9
            java.lang.String r0 = W     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            com.tencent.wxop.stat.b.q.a((android.content.Context) r1, (java.lang.String) r0, (long) r6)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            a((boolean) r5)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            com.tencent.wxop.stat.b.b r0 = N     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r2 = "MTA is disable for current SDK version"
            r0.warn(r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
        L_0x00f1:
            java.lang.String r0 = "sv"
            boolean r0 = b(r4, r0, r3)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            if (r0 == 0) goto L_0x0101
            com.tencent.wxop.stat.b.b r0 = N     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r2 = "match sdk version:2.0.3"
            r0.b((java.lang.Object) r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r5 = r8
        L_0x0101:
            java.lang.String r0 = "md"
            java.lang.String r2 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            boolean r0 = b(r4, r0, r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            if (r0 == 0) goto L_0x011f
            com.tencent.wxop.stat.b.b r0 = N     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r6 = "match MODEL:"
            r5.<init>(r6)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r5.append(r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r0.b((java.lang.Object) r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r5 = r8
        L_0x011f:
            java.lang.String r0 = "av"
            java.lang.String r2 = com.tencent.wxop.stat.b.l.D(r1)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            boolean r0 = b(r4, r0, r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            if (r0 == 0) goto L_0x0143
            com.tencent.wxop.stat.b.b r0 = N     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r5 = "match app version:"
            r2.<init>(r5)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r5 = com.tencent.wxop.stat.b.l.D(r1)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r2.append(r5)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r0.b((java.lang.Object) r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r5 = r8
        L_0x0143:
            java.lang.String r0 = "mf"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r2.<init>()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r6 = android.os.Build.MANUFACTURER     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r2.append(r6)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            boolean r0 = b(r4, r0, r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            if (r0 == 0) goto L_0x016d
            com.tencent.wxop.stat.b.b r0 = N     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r5 = "match MANUFACTURER:"
            r2.<init>(r5)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r2.append(r6)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r0.b((java.lang.Object) r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r5 = r8
        L_0x016d:
            java.lang.String r0 = "osv"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r2.<init>()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r2.append(r6)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            boolean r0 = b(r4, r0, r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r2 = "match android SDK version:"
            if (r0 == 0) goto L_0x0197
            com.tencent.wxop.stat.b.b r0 = N     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r5.append(r6)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r0.b((java.lang.Object) r5)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r5 = r8
        L_0x0197:
            java.lang.String r0 = "ov"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r7.<init>()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r7.append(r6)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            boolean r0 = b(r4, r0, r7)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            if (r0 == 0) goto L_0x01bd
            com.tencent.wxop.stat.b.b r0 = N     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r5.append(r6)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r0.b((java.lang.Object) r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r5 = r8
        L_0x01bd:
            java.lang.String r0 = "ui"
            com.tencent.wxop.stat.t r2 = com.tencent.wxop.stat.t.s(r1)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            com.tencent.wxop.stat.b.c r2 = r2.t(r1)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r2 = r2.b()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            boolean r0 = b(r4, r0, r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            if (r0 == 0) goto L_0x01f1
            com.tencent.wxop.stat.b.b r0 = N     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r5 = "match imei:"
            r2.<init>(r5)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            com.tencent.wxop.stat.t r5 = com.tencent.wxop.stat.t.s(r1)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            com.tencent.wxop.stat.b.c r5 = r5.t(r1)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r5 = r5.b()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r2.append(r5)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r0.b((java.lang.Object) r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r5 = r8
        L_0x01f1:
            java.lang.String r0 = "mid"
            java.lang.String r2 = h(r1)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            boolean r0 = b(r4, r0, r2)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            if (r0 == 0) goto L_0x0215
            com.tencent.wxop.stat.b.b r0 = N     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r4 = "match mid:"
            r2.<init>(r4)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r1 = h(r1)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r2.append(r1)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            r0.b((java.lang.Object) r1)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            goto L_0x0216
        L_0x0215:
            r8 = r5
        L_0x0216:
            if (r8 == 0) goto L_0x0226
            long r0 = com.tencent.wxop.stat.b.l.u(r3)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            b(r0)     // Catch:{ Exception -> 0x0220, all -> 0x0263 }
            goto L_0x0226
        L_0x0220:
            r0 = move-exception
            com.tencent.wxop.stat.b.b r1 = N     // Catch:{ JSONException -> 0x0258, all -> 0x0263 }
            r1.b((java.lang.Throwable) r0)     // Catch:{ JSONException -> 0x0258, all -> 0x0263 }
        L_0x0226:
            java.lang.String r0 = f51057c     // Catch:{ JSONException -> 0x0258, all -> 0x0263 }
            java.lang.String r13 = r13.getString(r0)     // Catch:{ JSONException -> 0x0258, all -> 0x0263 }
            boolean r0 = R     // Catch:{ JSONException -> 0x0258, all -> 0x0263 }
            if (r0 == 0) goto L_0x0248
            com.tencent.wxop.stat.b.b r0 = N     // Catch:{ JSONException -> 0x0258, all -> 0x0263 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0258, all -> 0x0263 }
            java.lang.String r2 = "hibernateVer:"
            r1.<init>(r2)     // Catch:{ JSONException -> 0x0258, all -> 0x0263 }
            r1.append(r13)     // Catch:{ JSONException -> 0x0258, all -> 0x0263 }
            java.lang.String r2 = ", current version:2.0.3"
            r1.append(r2)     // Catch:{ JSONException -> 0x0258, all -> 0x0263 }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0258, all -> 0x0263 }
            r0.e(r1)     // Catch:{ JSONException -> 0x0258, all -> 0x0263 }
        L_0x0248:
            long r0 = com.tencent.wxop.stat.b.l.u(r13)     // Catch:{ JSONException -> 0x0258, all -> 0x0263 }
            long r2 = com.tencent.wxop.stat.b.l.u(r3)     // Catch:{ JSONException -> 0x0258, all -> 0x0263 }
            int r13 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r13 > 0) goto L_0x025f
            b(r0)     // Catch:{ JSONException -> 0x0258, all -> 0x0263 }
            goto L_0x025f
        L_0x0258:
            com.tencent.wxop.stat.b.b r13 = N     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            java.lang.String r0 = "__HIBERNATE__ not found."
            r13.e(r0)     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
        L_0x025f:
            a((android.content.Context) r11, (com.tencent.wxop.stat.ah) r12)     // Catch:{ JSONException -> 0x026a, all -> 0x0263 }
            return
        L_0x0263:
            r11 = move-exception
        L_0x0264:
            com.tencent.wxop.stat.b.b r12 = N
            r12.b((java.lang.Throwable) r11)
            return
        L_0x026a:
            r11 = move-exception
            goto L_0x0264
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.c.a(android.content.Context, com.tencent.wxop.stat.ah, org.json.JSONObject):void");
    }

    public static void a(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2;
        ah ahVar;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase(Integer.toString(P.aI))) {
                    jSONObject2 = jSONObject.getJSONObject(next);
                    ahVar = P;
                } else if (next.equalsIgnoreCase(Integer.toString(O.aI))) {
                    jSONObject2 = jSONObject.getJSONObject(next);
                    ahVar = O;
                } else if (next.equalsIgnoreCase("rs")) {
                    d a11 = d.a(jSONObject.getInt(next));
                    if (a11 != null) {
                        Q = a11;
                        if (R) {
                            b bVar = N;
                            bVar.e("Change to ReportStrategy:" + a11.name());
                        }
                    }
                } else {
                    return;
                }
                a(context, ahVar, jSONObject2);
            }
        } catch (JSONException e11) {
            N.b((Throwable) e11);
        }
    }

    public static void a(d dVar) {
        Q = dVar;
        if (dVar != d.PERIOD) {
            e.aZ = 0;
        }
        if (R) {
            b bVar = N;
            bVar.e("Change to statSendStrategy: " + dVar);
        }
    }

    private static void a(JSONObject jSONObject) {
        try {
            d a11 = d.a(jSONObject.getInt("rs"));
            if (a11 != null) {
                a(a11);
            }
        } catch (JSONException unused) {
            if (R) {
                N.b((Object) "rs not found.");
            }
        }
    }

    public static void a(boolean z11) {
        S = z11;
        if (!z11) {
            N.warn("!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    private static void b(long j11) {
        q.a(ak.aB(), f51057c, j11);
        a(false);
        N.warn("MTA is disable for current SDK version");
    }

    public static void b(Context context, String str) {
        b bVar;
        String str2;
        String str3;
        if (context == null) {
            bVar = N;
            str2 = "ctx in StatConfig.setAppKey() is null";
        } else if (str == null || str.length() > 256) {
            bVar = N;
            str2 = "appkey in StatConfig.setAppKey() is null or exceed 256 bytes";
        } else {
            if (Y == null) {
                Y = r.t(q.b(context, "_mta_ky_tag_", (String) null));
            }
            if ((m(str) || m(l.z(context))) && (str3 = Y) != null) {
                q.c(context, "_mta_ky_tag_", r.q(str3));
                return;
            }
            return;
        }
        bVar.error(str2);
    }

    private static boolean b(JSONObject jSONObject, String str, String str2) {
        if (jSONObject.isNull(str)) {
            return false;
        }
        String optString = jSONObject.optString(str);
        return l.e(str2) && l.e(optString) && str2.equalsIgnoreCase(optString);
    }

    public static void c(Context context, String str) {
        if (str.length() > 128) {
            N.error("the length of installChannel can not exceed the range of 128 bytes.");
            return;
        }
        Z = str;
        q.c(context, f51031aa, str);
    }

    public static synchronized String d(Context context) {
        synchronized (c.class) {
            String str = Y;
            if (str != null) {
                return str;
            }
            if (context != null && str == null) {
                Y = l.z(context);
            }
            String str2 = Y;
            if (str2 == null || str2.trim().length() == 0) {
                N.error("AppKey can not be null or empty, please read Developer's Guide first!");
            }
            String str3 = Y;
            return str3;
        }
    }

    public static synchronized String e(Context context) {
        synchronized (c.class) {
            String str = Z;
            if (str != null) {
                return str;
            }
            String b11 = q.b(context, f51031aa, "");
            Z = b11;
            if (b11 == null || b11.trim().length() == 0) {
                Z = l.A(context);
            }
            String str2 = Z;
            if (str2 == null || str2.trim().length() == 0) {
                N.c("installChannel can not be null or empty, please read Developer's Guide first!");
            }
            String str3 = Z;
            return str3;
        }
    }

    public static String f(Context context) {
        return q.b(context, "mta.acc.qq", f51032ab);
    }

    public static String g(Context context) {
        if (context == null) {
            N.error("Context for getCustomUid is null.");
            return null;
        }
        if (f51051au == null) {
            f51051au = q.b(context, "MTA_CUSTOM_UID", "");
        }
        return f51051au;
    }

    public static String h(Context context) {
        return context != null ? g.a(context).f().c() : "0";
    }

    public static d j() {
        return Q;
    }

    public static boolean k() {
        return R;
    }

    public static String l(String str) {
        try {
            String string = P.f50967df.getString(str);
            if (string != null) {
                return string;
            }
            return null;
        } catch (Throwable unused) {
            b bVar = N;
            bVar.c("can't find custom key:" + str);
            return null;
        }
    }

    public static boolean l() {
        return S;
    }

    public static int m() {
        return T;
    }

    private static boolean m(String str) {
        if (str == null) {
            return false;
        }
        String str2 = Y;
        if (str2 == null) {
            Y = str;
            return true;
        } else if (str2.contains(str)) {
            return false;
        } else {
            Y += HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str;
            return true;
        }
    }

    public static int n() {
        return f51059x;
    }

    public static void n(String str) {
        if (str.length() > 128) {
            N.error("the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            Z = str;
        }
    }

    public static int o() {
        return f51060y;
    }

    public static void o(String str) {
        if (str == null || str.length() == 0) {
            N.error("statReportUrl cannot be null or empty.");
            return;
        }
        f51043am = str;
        try {
            f51042al = new URI(f51043am).getHost();
        } catch (Exception e11) {
            N.c(e11);
        }
        if (R) {
            b bVar = N;
            bVar.b((Object) "url:" + f51043am + ", domain:" + f51042al);
        }
    }

    public static int p() {
        return f51058w;
    }

    public static int q() {
        return f51061z;
    }

    public static int r() {
        return V;
    }

    public static int s() {
        return U;
    }

    public static void t() {
        f51033ac = 60;
    }

    public static int u() {
        return f51033ac;
    }

    public static int v() {
        return f51037ag;
    }

    public static void w() {
        f51038ah = true;
    }

    public static boolean x() {
        return f51041ak;
    }

    public static String y() {
        return f51043am;
    }

    public static synchronized void z() {
        synchronized (c.class) {
            f51045ao = 0;
        }
    }
}
