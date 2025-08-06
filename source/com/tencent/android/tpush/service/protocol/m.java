package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import com.huawei.hms.push.AttributionReporter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.e.b.a;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.c;
import com.tencent.tpns.baseapi.base.util.CacheHelper;
import com.tencent.tpns.baseapi.base.util.Md5;
import org.json.JSONObject;

public class m extends d {
    public String A = "";
    public String B = "";
    public String C = "";
    public String D = "";
    public int E = 0;
    public g F = null;
    public int G = 0;
    public long H = 0;
    public boolean I = true;
    public boolean J = false;
    public String K = null;
    public boolean L = false;
    public String M;
    public String N;

    /* renamed from: a  reason: collision with root package name */
    public long f69775a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f69776b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f69777c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f69778d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f69779e = "";

    /* renamed from: f  reason: collision with root package name */
    public short f69780f = 0;

    /* renamed from: g  reason: collision with root package name */
    public short f69781g = 0;

    /* renamed from: h  reason: collision with root package name */
    public f f69782h = null;

    /* renamed from: i  reason: collision with root package name */
    public short f69783i = 0;

    /* renamed from: j  reason: collision with root package name */
    public byte f69784j = 0;

    /* renamed from: k  reason: collision with root package name */
    public h f69785k = null;

    /* renamed from: l  reason: collision with root package name */
    public short f69786l = 0;

    /* renamed from: m  reason: collision with root package name */
    public String f69787m = "";

    /* renamed from: n  reason: collision with root package name */
    public String f69788n = "";

    /* renamed from: o  reason: collision with root package name */
    public String f69789o = "";

    /* renamed from: p  reason: collision with root package name */
    public long f69790p = 0;

    /* renamed from: q  reason: collision with root package name */
    public long f69791q = 0;

    /* renamed from: r  reason: collision with root package name */
    public long f69792r = 0;

    /* renamed from: s  reason: collision with root package name */
    public long f69793s = 0;

    /* renamed from: t  reason: collision with root package name */
    public long f69794t = 0;

    /* renamed from: u  reason: collision with root package name */
    public long f69795u = 0;

    /* renamed from: v  reason: collision with root package name */
    public String f69796v = "";

    /* renamed from: w  reason: collision with root package name */
    public long f69797w = 0;

    /* renamed from: x  reason: collision with root package name */
    public long f69798x = 0;

    /* renamed from: y  reason: collision with root package name */
    public String f69799y = "";

    /* renamed from: z  reason: collision with root package name */
    public String f69800z = "";

    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessId", this.f69775a);
        jSONObject.put("accessKey", this.f69776b);
        jSONObject.put(Constants.FLAG_DEVICE_ID, this.f69777c);
        jSONObject.put("appCert", this.f69778d);
        jSONObject.put(Constants.FLAG_TICKET, this.f69779e);
        jSONObject.put(Constants.FLAG_TICKET_TYPE, this.f69780f);
        jSONObject.put("deviceType", this.f69781g);
        f fVar = this.f69782h;
        if (fVar != null) {
            jSONObject.put("deviceInfo", fVar.a());
            f fVar2 = this.f69782h;
            this.N = c.a(fVar2.f69722t, fVar2.f69723u);
        }
        jSONObject.put("version", this.f69783i);
        jSONObject.put("keyEncrypted", this.f69784j);
        h hVar = this.f69785k;
        if (hVar != null) {
            jSONObject.put("mutableInfo", hVar.a());
        }
        jSONObject.put("updateAutoTag", this.f69786l);
        jSONObject.put(AttributionReporter.APP_VERSION, this.f69787m);
        jSONObject.put("clientid", this.f69789o);
        jSONObject.put("connVersion", this.f69792r);
        jSONObject.put(RemoteMessageConst.Notification.CHANNEL_ID, this.f69793s);
        jSONObject.put("otherPushTokenOpType", this.f69794t);
        jSONObject.put("otherPushTokenType", this.f69795u);
        jSONObject.put("otherPushToken", this.f69796v);
        jSONObject.put("otherPushTokenCrc32", this.f69797w);
        jSONObject.put("tokenCrc32", this.f69798x);
        jSONObject.put("otherPushData", this.f69799y);
        jSONObject.put("sdkVersion", this.f69800z);
        if (!j.b(this.A) && !j.b(this.B)) {
            jSONObject.put("channelToken", this.A);
            jSONObject.put("channelType", this.B);
            jSONObject.put("deviceRegion", this.C);
        }
        if (!j.b(this.D)) {
            jSONObject.put("appPkgName", this.D);
        }
        jSONObject.put("tAd", this.E);
        g gVar = this.F;
        if (gVar != null && gVar.a()) {
            jSONObject.put("freeVersionInfo", this.F.b());
        }
        jSONObject.put("hwSdk", this.G);
        jSONObject.put("cloudVersion", this.H);
        try {
            String jSONObject2 = jSONObject.toString();
            String str = (String) CacheHelper.get(context, a.a());
            String md5 = Md5.md5(jSONObject2.substring(0, jSONObject2.indexOf("bootTime")) + jSONObject2.substring(jSONObject2.indexOf("countryCode")));
            if (md5 == null || !md5.equals(str)) {
                this.I = true;
                CacheHelper.set(context, a.a().set(md5));
            } else {
                this.I = false;
            }
        } catch (Throwable unused) {
            this.I = true;
        }
        jSONObject.put("timestamp", this.f69791q);
        return jSONObject;
    }

    public boolean b(Context context) {
        try {
            a(context);
        } catch (Throwable th2) {
            TLogger.d("RegisterReq", "unexpected for:" + th2.getMessage());
        }
        return this.I;
    }

    public MessageType a() {
        return MessageType.REGISTER;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(24:7|8|9|10|11|12|13|(1:15)|16|17|18|19|(1:21)|22|(6:24|25|26|(1:28)|29|30)|31|(1:34)|35|36|37|38|39|44|45) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x00da */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00e6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x012c */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fc A[Catch:{ all -> 0x01ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x011b A[Catch:{ all -> 0x01ba }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.android.tpush.service.protocol.m a(android.content.Context r19, android.content.Intent r20, boolean r21) {
        /*
            r0 = r19
            r1 = r20
            java.lang.String r2 = "payload"
            java.lang.String r3 = "url"
            java.lang.String r4 = ","
            r5 = 0
            java.lang.String r6 = "RegReq"
            if (r1 != 0) goto L_0x0015
            java.lang.String r0 = "intent was null"
            com.tencent.tpns.baseapi.base.util.Logger.w(r6, r0)
            return r5
        L_0x0015:
            if (r0 != 0) goto L_0x001d
            java.lang.String r0 = "context was null"
            com.tencent.tpns.baseapi.base.util.Logger.w(r6, r0)
            return r5
        L_0x001d:
            com.tencent.android.tpush.service.protocol.m r7 = new com.tencent.android.tpush.service.protocol.m     // Catch:{ all -> 0x01be }
            r7.<init>()     // Catch:{ all -> 0x01be }
            java.lang.String r8 = "accId"
            java.lang.String r8 = r1.getStringExtra(r8)     // Catch:{ all -> 0x01be }
            java.lang.String r8 = com.tencent.android.tpush.encrypt.Rijndael.decrypt(r8)     // Catch:{ all -> 0x01be }
            long r8 = java.lang.Long.parseLong(r8)     // Catch:{ all -> 0x01be }
            r7.f69775a = r8     // Catch:{ all -> 0x01be }
            java.lang.String r8 = "accKey"
            java.lang.String r8 = r1.getStringExtra(r8)     // Catch:{ all -> 0x01be }
            java.lang.String r8 = com.tencent.android.tpush.encrypt.Rijndael.decrypt(r8)     // Catch:{ all -> 0x01be }
            r7.f69776b = r8     // Catch:{ all -> 0x01be }
            java.lang.String r8 = "packName"
            java.lang.String r8 = r1.getStringExtra(r8)     // Catch:{ all -> 0x01be }
            java.lang.String r8 = com.tencent.android.tpush.encrypt.Rijndael.decrypt(r8)     // Catch:{ all -> 0x01be }
            r7.K = r8     // Catch:{ all -> 0x01be }
            java.lang.String r8 = "ticket"
            java.lang.String r8 = r1.getStringExtra(r8)     // Catch:{ all -> 0x01be }
            java.lang.String r8 = com.tencent.android.tpush.encrypt.Rijndael.decrypt(r8)     // Catch:{ all -> 0x01be }
            r7.f69779e = r8     // Catch:{ all -> 0x01be }
            java.lang.String r8 = "ticketType"
            r9 = -1
            int r8 = r1.getIntExtra(r8, r9)     // Catch:{ all -> 0x01be }
            short r8 = (short) r8     // Catch:{ all -> 0x01be }
            r7.f69780f = r8     // Catch:{ all -> 0x01be }
            java.lang.String r8 = "qua"
            java.lang.String r8 = r1.getStringExtra(r8)     // Catch:{ all -> 0x01be }
            java.lang.String r8 = com.tencent.android.tpush.encrypt.Rijndael.decrypt(r8)     // Catch:{ all -> 0x01be }
            java.lang.String r9 = "appVer"
            java.lang.String r9 = r1.getStringExtra(r9)     // Catch:{ all -> 0x01be }
            r7.f69787m = r9     // Catch:{ all -> 0x01be }
            java.lang.String r9 = "reserved"
            java.lang.String r9 = r1.getStringExtra(r9)     // Catch:{ all -> 0x01be }
            java.lang.String r9 = com.tencent.android.tpush.encrypt.Rijndael.decrypt(r9)     // Catch:{ all -> 0x01be }
            r7.f69788n = r9     // Catch:{ all -> 0x01be }
            java.lang.String r9 = "accChannel"
            r10 = -1
            long r12 = r1.getLongExtra(r9, r10)     // Catch:{ all -> 0x01be }
            r7.f69793s = r12     // Catch:{ all -> 0x01be }
            java.lang.String r9 = r1.getStringExtra(r3)     // Catch:{ all -> 0x01be }
            java.lang.String r12 = "otherToken"
            java.lang.String r12 = r1.getStringExtra(r12)     // Catch:{ all -> 0x01be }
            r7.f69796v = r12     // Catch:{ all -> 0x01be }
            java.lang.String r12 = r1.getStringExtra(r2)     // Catch:{ all -> 0x01be }
            java.lang.String r13 = "otherPushType"
            long r13 = r1.getLongExtra(r13, r10)     // Catch:{ all -> 0x01be }
            r7.f69795u = r13     // Catch:{ all -> 0x01be }
            java.lang.String r13 = "otherPushTokenOpType"
            long r10 = r1.getLongExtra(r13, r10)     // Catch:{ all -> 0x01be }
            r7.f69794t = r10     // Catch:{ all -> 0x01be }
            java.lang.String r10 = "aidl"
            r11 = 0
            boolean r10 = r1.getBooleanExtra(r10, r11)     // Catch:{ all -> 0x01be }
            r7.J = r10     // Catch:{ all -> 0x01be }
            java.lang.String r10 = "channelToken"
            java.lang.String r10 = r1.getStringExtra(r10)     // Catch:{ all -> 0x01be }
            java.lang.String r13 = "channelType"
            java.lang.String r13 = r1.getStringExtra(r13)     // Catch:{ all -> 0x01be }
            java.lang.String r14 = "deviceRegion"
            java.lang.String r14 = r1.getStringExtra(r14)     // Catch:{ all -> 0x01be }
            com.tencent.tpns.baseapi.base.util.CloudManager r15 = com.tencent.tpns.baseapi.base.util.CloudManager.getInstance(r19)     // Catch:{ all -> 0x01be }
            r16 = r6
            long r5 = r15.getCloudVersion()     // Catch:{ all -> 0x01ba }
            r7.H = r5     // Catch:{ all -> 0x01ba }
            boolean r5 = com.tencent.android.tpush.common.j.b((java.lang.String) r8)     // Catch:{ all -> 0x00da }
            if (r5 != 0) goto L_0x00da
            long r5 = r7.f69775a     // Catch:{ all -> 0x00da }
            com.tencent.android.tpush.service.cache.CacheManager.setQua(r0, r5, r8)     // Catch:{ all -> 0x00da }
        L_0x00da:
            java.lang.String r5 = r7.K     // Catch:{ all -> 0x00e6 }
            android.content.Context r5 = r0.createPackageContext(r5, r11)     // Catch:{ all -> 0x00e6 }
            java.lang.String r5 = com.tencent.android.tpush.service.channel.security.TpnsSecurity.getEncryptAPKSignature(r5)     // Catch:{ all -> 0x00e6 }
            r7.f69778d = r5     // Catch:{ all -> 0x00e6 }
        L_0x00e6:
            java.lang.String r5 = com.tencent.android.tpush.service.util.a.a()     // Catch:{ all -> 0x01ba }
            r7.f69777c = r5     // Catch:{ all -> 0x01ba }
            java.lang.String r5 = "1.4.4.2"
            r7.f69800z = r5     // Catch:{ all -> 0x01ba }
            android.content.Context r5 = com.tencent.android.tpush.service.b.e()     // Catch:{ all -> 0x01ba }
            com.tencent.android.tpush.service.protocol.f r5 = com.tencent.android.tpush.service.c.a((android.content.Context) r5)     // Catch:{ all -> 0x01ba }
            r7.f69782h = r5     // Catch:{ all -> 0x01ba }
            if (r5 == 0) goto L_0x0104
            java.lang.String r5 = "lastNMd5str"
            java.lang.String r5 = r1.getStringExtra(r5)     // Catch:{ all -> 0x01ba }
            r7.N = r5     // Catch:{ all -> 0x01ba }
        L_0x0104:
            r5 = 4
            r7.f69783i = r5     // Catch:{ all -> 0x01ba }
            r5 = 0
            r7.f69792r = r5     // Catch:{ all -> 0x01ba }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01ba }
            r17 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r17
            r7.f69791q = r5     // Catch:{ all -> 0x01ba }
            boolean r5 = com.tencent.android.tpush.common.j.b((java.lang.String) r9)     // Catch:{ all -> 0x01ba }
            if (r5 != 0) goto L_0x0132
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x01ba }
            r5.<init>()     // Catch:{ all -> 0x01ba }
            r5.put(r3, r9)     // Catch:{ JSONException -> 0x012c }
            boolean r3 = com.tencent.android.tpush.common.j.b((java.lang.String) r12)     // Catch:{ JSONException -> 0x012c }
            if (r3 != 0) goto L_0x012c
            r5.put(r2, r12)     // Catch:{ JSONException -> 0x012c }
        L_0x012c:
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x01ba }
            r7.f69799y = r2     // Catch:{ all -> 0x01ba }
        L_0x0132:
            android.content.Context r2 = com.tencent.android.tpush.service.b.e()     // Catch:{ all -> 0x01ba }
            long r2 = com.tencent.android.tpush.service.cache.CacheManager.getGuid(r2)     // Catch:{ all -> 0x01ba }
            r7.f69790p = r2     // Catch:{ all -> 0x01ba }
            if (r10 == 0) goto L_0x0146
            if (r13 == 0) goto L_0x0146
            r7.A = r10     // Catch:{ all -> 0x01ba }
            r7.B = r13     // Catch:{ all -> 0x01ba }
            r7.C = r14     // Catch:{ all -> 0x01ba }
        L_0x0146:
            java.lang.String r0 = r19.getPackageName()     // Catch:{ all -> 0x01ba }
            r7.D = r0     // Catch:{ all -> 0x01ba }
            java.lang.String r0 = "com.qq.e.ads.ADActivity"
            java.lang.Class.forName(r0)     // Catch:{ all -> 0x0155 }
            r0 = 1
            r2 = r16
            goto L_0x015d
        L_0x0155:
            java.lang.String r0 = "Register get tAd error, tAd not found"
            r2 = r16
            com.tencent.android.tpush.logging.TLogger.d(r2, r0)     // Catch:{ all -> 0x01b8 }
            r0 = r11
        L_0x015d:
            r7.E = r0     // Catch:{ all -> 0x01b8 }
            int r0 = com.tencent.android.tpush.d.a.a()     // Catch:{ all -> 0x01b8 }
            r7.G = r0     // Catch:{ all -> 0x01b8 }
            java.lang.String r0 = "hasRegisted"
            boolean r0 = r1.getBooleanExtra(r0, r11)     // Catch:{ all -> 0x01b8 }
            r7.L = r0     // Catch:{ all -> 0x01b8 }
            java.lang.String r0 = "token"
            java.lang.String r0 = r1.getStringExtra(r0)     // Catch:{ all -> 0x01b8 }
            r7.M = r0     // Catch:{ all -> 0x01b8 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b8 }
            r0.<init>()     // Catch:{ all -> 0x01b8 }
            java.lang.String r1 = "Register("
            r0.append(r1)     // Catch:{ all -> 0x01b8 }
            long r5 = r7.f69775a     // Catch:{ all -> 0x01b8 }
            r0.append(r5)     // Catch:{ all -> 0x01b8 }
            r0.append(r4)     // Catch:{ all -> 0x01b8 }
            java.lang.String r1 = r7.f69777c     // Catch:{ all -> 0x01b8 }
            r0.append(r1)     // Catch:{ all -> 0x01b8 }
            r0.append(r4)     // Catch:{ all -> 0x01b8 }
            java.lang.String r1 = r7.f69779e     // Catch:{ all -> 0x01b8 }
            r0.append(r1)     // Catch:{ all -> 0x01b8 }
            r0.append(r4)     // Catch:{ all -> 0x01b8 }
            short r1 = r7.f69780f     // Catch:{ all -> 0x01b8 }
            r0.append(r1)     // Catch:{ all -> 0x01b8 }
            java.lang.String r1 = "),payload: "
            r0.append(r1)     // Catch:{ all -> 0x01b8 }
            java.lang.String r1 = r7.f69799y     // Catch:{ all -> 0x01b8 }
            r0.append(r1)     // Catch:{ all -> 0x01b8 }
            java.lang.String r1 = " channel id"
            r0.append(r1)     // Catch:{ all -> 0x01b8 }
            long r3 = r7.f69793s     // Catch:{ all -> 0x01b8 }
            r0.append(r3)     // Catch:{ all -> 0x01b8 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01b8 }
            com.tencent.android.tpush.logging.TLogger.vv(r2, r0)     // Catch:{ all -> 0x01b8 }
            return r7
        L_0x01b8:
            r0 = move-exception
            goto L_0x01c0
        L_0x01ba:
            r0 = move-exception
            r2 = r16
            goto L_0x01c0
        L_0x01be:
            r0 = move-exception
            r2 = r6
        L_0x01c0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = ">> register error "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.tencent.android.tpush.logging.TLogger.e(r2, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = ">> register error-> "
            r1.append(r3)
            java.lang.String r0 = com.tencent.android.tpush.logging.TLogger.getStackTraceString(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.tencent.android.tpush.logging.TLogger.e(r2, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.protocol.m.a(android.content.Context, android.content.Intent, boolean):com.tencent.android.tpush.service.protocol.m");
    }
}
