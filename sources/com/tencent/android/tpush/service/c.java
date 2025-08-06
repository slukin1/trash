package com.tencent.android.tpush.service;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.AppInfos;
import com.tencent.android.tpush.common.ReturnCode;
import com.tencent.android.tpush.common.g;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.c.a;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import com.tencent.android.tpush.service.protocol.b;
import com.tencent.android.tpush.service.protocol.f;
import com.tencent.android.tpush.service.protocol.i;
import com.tencent.android.tpush.service.protocol.l;
import com.tencent.android.tpush.service.protocol.o;
import com.tencent.android.tpush.service.protocol.p;
import com.tencent.android.tpush.service.protocol.q;
import com.tencent.android.tpush.service.protocol.r;
import com.tencent.android.tpush.service.protocol.s;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.tpns.baseapi.base.util.Md5;
import com.tencent.tpns.baseapi.base.util.TGlobalHelper;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f69621a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static JSONArray f69622b = new JSONArray();

    /* renamed from: c  reason: collision with root package name */
    private static final String f69623c = Md5.md5("com.tencent.tpush.last_wifi_ts");

    /* renamed from: d  reason: collision with root package name */
    private static int f69624d = -1;

    /* renamed from: e  reason: collision with root package name */
    private static f f69625e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f69626f = false;

    public static byte a(boolean z11) {
        return z11 ? (byte) 1 : 0;
    }

    public static c a() {
        return f69621a;
    }

    private static o b(Context context) {
        o oVar = new o();
        oVar.f69812a = DeviceInfos.getBootTime();
        oVar.f69813b = Locale.getDefault().getCountry();
        oVar.f69814c = DeviceInfos.getDeviceName(context);
        oVar.f69815d = DeviceInfos.getCarrierInfo(context);
        oVar.f69816e = String.valueOf(DeviceInfos.getTotalMemory());
        oVar.f69817f = String.valueOf(DeviceInfos.getTotalInternalMemorySize());
        oVar.f69818g = DeviceInfos.getSysFileTime();
        return oVar;
    }

    public static f a(Context context) {
        if (f69625e == null) {
            f69625e = new f();
        }
        if (TextUtils.isEmpty(f69625e.f69705c)) {
            f fVar = f69625e;
            fVar.f69711i = "" + AppInfos.getApiLevel();
            f69625e.f69703a = CustomDeviceInfos.getFacilityIdentity(context);
            if (DeviceInfos.checkSimulator(context)) {
                f fVar2 = f69625e;
                fVar2.f69710h = "SIMULATOR";
                fVar2.f69704b = DeviceInfos.getSimulatorModel(context);
            } else {
                f69625e.f69710h = Build.MANUFACTURER;
                f69625e.f69704b = TGlobalHelper.getDM(context);
            }
            f69625e.f69705c = "android";
            DisplayMetrics displayMetrics = DeviceInfos.getDisplayMetrics(context);
            f fVar3 = f69625e;
            fVar3.f69709g = displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            f fVar4 = f69625e;
            fVar4.f69711i = "" + Build.VERSION.SDK_INT;
            f69625e.f69707e = DeviceInfos.getExternalStorageInfo(context);
            f69625e.f69708f = CustomDeviceInfos.getSimOperator(context);
            f69625e.f69712j = Build.VERSION.RELEASE;
            f69625e.f69713k = (long) DeviceInfos.hasRootAccess(context);
            f69625e.f69716n = b();
            f69625e.f69718p = AppInfos.getLauncherPackageName(context);
            f69625e.f69724v = b(context);
            f69625e.f69720r = g.a();
            f69625e.f69721s = g.c();
        }
        f69625e.f69717o = TimeZone.getDefault().getID();
        f69625e.f69706d = DeviceInfos.getLinkedWay(context);
        f69625e.f69722t = com.tencent.android.tpush.service.util.c.b(context);
        f69625e.f69723u = com.tencent.android.tpush.service.util.c.c(context);
        return f69625e;
    }

    private static String b() {
        String languageTag;
        String language = Locale.getDefault().getLanguage();
        if (language != null && language.equals("zh") && Build.VERSION.SDK_INT >= 21 && (languageTag = Locale.getDefault().toLanguageTag()) != null) {
            String lowerCase = languageTag.toLowerCase();
            if (lowerCase.contains("zh") && lowerCase.contains("hk")) {
                language = "zh-Hant-HK";
            } else if (lowerCase.contains("zh") && lowerCase.contains("tw")) {
                language = "zh-Hant-TW";
            } else if (lowerCase.contains("zh") && lowerCase.contains("mo")) {
                language = "zh-Hant-MO";
            }
        }
        TLogger.i("PushServiceNetworkHandler", "language:" + language);
        return language;
    }

    public void b(long j11, String str, String str2, int i11, String str3, a aVar) {
        b bVar = new b();
        bVar.f69697a = j11;
        bVar.f69698b = str;
        bVar.f69700d = i11;
        bVar.f69699c = str3;
        bVar.f69701e = System.currentTimeMillis() / 1000;
        bVar.f69702f = "1.4.4.2";
        TLogger.d("PushServiceNetworkHandler", "Action -> sendAttributes to server (" + j11 + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + ")");
        if (Util.checkAccessId(bVar.f69697a) && Util.checkAccessKey(bVar.f69698b)) {
            com.tencent.android.tpush.service.c.b.a().a(b.e(), bVar, aVar);
        } else if (aVar != null) {
            ReturnCode returnCode = ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR;
            aVar.b(returnCode.getType(), ReturnCode.errCodeToMsg(returnCode.getType()), bVar);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:14|15|16|17|18|19|(2:21|(2:23|24))(2:25|26)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0042 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x004c */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c A[Catch:{ all -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072 A[Catch:{ all -> 0x00af }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r4, com.tencent.android.tpush.service.protocol.m r5, com.tencent.android.tpush.service.c.a r6) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0006
            android.content.Context r4 = com.tencent.android.tpush.service.b.e()     // Catch:{ all -> 0x00af }
        L_0x0006:
            if (r5 != 0) goto L_0x001c
            if (r6 == 0) goto L_0x001b
            com.tencent.android.tpush.common.ReturnCode r4 = com.tencent.android.tpush.common.ReturnCode.ERRORCODE_UNKNOWN     // Catch:{ all -> 0x00af }
            int r0 = r4.getType()     // Catch:{ all -> 0x00af }
            int r4 = r4.getType()     // Catch:{ all -> 0x00af }
            java.lang.String r4 = com.tencent.android.tpush.common.ReturnCode.errCodeToMsg(r4)     // Catch:{ all -> 0x00af }
            r6.b(r0, r4, r5)     // Catch:{ all -> 0x00af }
        L_0x001b:
            return
        L_0x001c:
            long r0 = r5.f69775a     // Catch:{ all -> 0x00af }
            boolean r0 = com.tencent.tpns.baseapi.base.util.Util.checkAccessId(r0)     // Catch:{ all -> 0x00af }
            if (r0 == 0) goto L_0x009c
            java.lang.String r0 = r5.f69776b     // Catch:{ all -> 0x00af }
            boolean r0 = com.tencent.tpns.baseapi.base.util.Util.checkAccessKey(r0)     // Catch:{ all -> 0x00af }
            if (r0 != 0) goto L_0x002d
            goto L_0x009c
        L_0x002d:
            boolean r0 = r5.L     // Catch:{ all -> 0x00af }
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x007c
            com.tencent.android.tpush.c.a r0 = com.tencent.android.tpush.c.a.a()     // Catch:{ all -> 0x0042 }
            com.tencent.android.tpush.c.a$a r0 = r0.f68881b     // Catch:{ all -> 0x0042 }
            com.tencent.android.tpush.service.c$1 r2 = new com.tencent.android.tpush.service.c$1     // Catch:{ all -> 0x0042 }
            r2.<init>()     // Catch:{ all -> 0x0042 }
            r0.e(r2)     // Catch:{ all -> 0x0042 }
            goto L_0x004c
        L_0x0042:
            com.tencent.android.tpush.c.a r0 = com.tencent.android.tpush.c.a.a()     // Catch:{ all -> 0x004c }
            com.tencent.android.tpush.c.a$a r0 = r0.f68881b     // Catch:{ all -> 0x004c }
            r2 = 0
            r0.a((com.tencent.tpns.mqttchannel.api.OnMqttCallback) r2)     // Catch:{ all -> 0x004c }
        L_0x004c:
            com.tencent.tpns.baseapi.base.util.CacheHelper$Key r0 = com.tencent.android.tpush.e.b.a.b()     // Catch:{ all -> 0x00af }
            java.lang.Object r0 = com.tencent.tpns.baseapi.base.util.CacheHelper.get(r4, r0)     // Catch:{ all -> 0x00af }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00af }
            boolean r0 = com.tencent.tpns.baseapi.base.util.Util.isNullOrEmptyString(r0)     // Catch:{ all -> 0x00af }
            if (r0 == 0) goto L_0x0072
            java.lang.String r0 = r5.f69796v     // Catch:{ all -> 0x00af }
            java.lang.String r0 = com.tencent.android.tpush.service.protocol.n.a(r4, r0)     // Catch:{ all -> 0x00af }
            boolean r2 = com.tencent.tpns.baseapi.base.util.Util.isNullOrEmptyString(r0)     // Catch:{ all -> 0x00af }
            if (r2 != 0) goto L_0x007c
            com.tencent.android.tpush.common.ReturnCode r4 = com.tencent.android.tpush.common.ReturnCode.CODE_SUCCESS     // Catch:{ all -> 0x00af }
            int r4 = r4.getType()     // Catch:{ all -> 0x00af }
            r6.a(r4, r0, r5)     // Catch:{ all -> 0x00af }
            return
        L_0x0072:
            com.tencent.android.tpush.common.ReturnCode r4 = com.tencent.android.tpush.common.ReturnCode.CODE_SUCCESS     // Catch:{ all -> 0x00af }
            int r4 = r4.getType()     // Catch:{ all -> 0x00af }
            r6.a(r4, r1, r5)     // Catch:{ all -> 0x00af }
            return
        L_0x007c:
            boolean r0 = r5.b(r4)     // Catch:{ all -> 0x00af }
            if (r0 != 0) goto L_0x0094
            boolean r0 = com.tencent.tpns.baseapi.XGApiConfig.isRegistered(r4)     // Catch:{ all -> 0x00af }
            if (r0 == 0) goto L_0x0094
            if (r6 == 0) goto L_0x0093
            com.tencent.android.tpush.common.ReturnCode r4 = com.tencent.android.tpush.common.ReturnCode.CODE_SUCCESS     // Catch:{ all -> 0x00af }
            int r4 = r4.getType()     // Catch:{ all -> 0x00af }
            r6.a(r4, r1, r5)     // Catch:{ all -> 0x00af }
        L_0x0093:
            return
        L_0x0094:
            com.tencent.android.tpush.service.c.b r0 = com.tencent.android.tpush.service.c.b.a()     // Catch:{ all -> 0x00af }
            r0.a(r4, r5, r6)     // Catch:{ all -> 0x00af }
            goto L_0x00af
        L_0x009c:
            if (r6 == 0) goto L_0x00af
            com.tencent.android.tpush.common.ReturnCode r4 = com.tencent.android.tpush.common.ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR     // Catch:{ all -> 0x00af }
            int r0 = r4.getType()     // Catch:{ all -> 0x00af }
            int r4 = r4.getType()     // Catch:{ all -> 0x00af }
            java.lang.String r4 = com.tencent.android.tpush.common.ReturnCode.errCodeToMsg(r4)     // Catch:{ all -> 0x00af }
            r6.b(r0, r4, r5)     // Catch:{ all -> 0x00af }
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.c.a(android.content.Context, com.tencent.android.tpush.service.protocol.m, com.tencent.android.tpush.service.c.a):void");
    }

    public void a(String str, String str2, long j11, String str3, String str4, a aVar) {
        String str5;
        r rVar = new r();
        try {
            str5 = TpnsSecurity.getEncryptAPKSignature(b.e().createPackageContext(str4, 0));
        } catch (Throwable th2) {
            TLogger.e("PushServiceNetworkHandler", ">> create context [for: " + str4 + "] fail.", th2);
            str5 = "";
        }
        rVar.f69828b = j11;
        rVar.f69829c = str3;
        rVar.f69830d = str5;
        rVar.f69831e = 0;
        rVar.f69832f = 0;
        rVar.f69833g = System.currentTimeMillis() / 1000;
        rVar.f69834h = "1.4.4.2";
        if (Util.checkAccessId(rVar.f69828b) && Util.checkAccessKey(rVar.f69829c)) {
            com.tencent.android.tpush.service.c.b.a().a(b.e(), rVar, aVar);
        } else if (aVar != null) {
            ReturnCode returnCode = ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR;
            aVar.b(returnCode.getType(), ReturnCode.errCodeToMsg(returnCode.getType()), rVar);
        }
    }

    public void a(long j11, String str, String str2, int i11, a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.android.tpush.service.protocol.a aVar2 = new com.tencent.android.tpush.service.protocol.a();
        aVar2.f69691a = j11;
        aVar2.f69692b = str;
        aVar2.f69693c = i11;
        aVar2.f69694d = currentTimeMillis / 1000;
        aVar2.f69695e = "1.4.4.2";
        if (!j.b(str2)) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                ArrayList<q> arrayList = new ArrayList<>();
                for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i12);
                    q qVar = new q();
                    qVar.a(jSONObject.getString(com.tencent.android.tpush.common.Constants.FLAG_ACCOUNT));
                    qVar.a(jSONObject.optInt("account_type", 0));
                    arrayList.add(qVar);
                }
                aVar2.f69696f = arrayList;
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        if (XGPushConfig.enableDebug) {
            TLogger.vv("PushServiceNetworkHandler", "setAccount(" + j11 + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + ")");
        }
        if (!Util.checkAccessId(aVar2.f69691a) || !Util.checkAccessKey(aVar2.f69692b)) {
            ReturnCode returnCode = ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR;
            aVar.b(returnCode.getType(), ReturnCode.errCodeToMsg(returnCode.getType()), aVar2);
            return;
        }
        com.tencent.android.tpush.service.c.b.a().a(b.e(), aVar2, aVar);
    }

    public void a(long j11, String str, String str2, int i11, String str3, a aVar) {
        p pVar = new p();
        pVar.f69819a = j11;
        pVar.f69820b = str;
        pVar.f69822d = i11;
        pVar.f69821c = str3;
        pVar.f69823e = System.currentTimeMillis() / 1000;
        pVar.f69824f = "1.4.4.2";
        if (XGPushConfig.enableDebug) {
            TLogger.d("PushServiceNetworkHandler", "Action -> sendTag to server (" + j11 + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + ")");
        }
        if (Util.checkAccessId(pVar.f69819a) && Util.checkAccessKey(pVar.f69820b)) {
            com.tencent.android.tpush.service.c.b.a().a(b.e(), pVar, aVar);
        } else if (aVar != null) {
            ReturnCode returnCode = ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR;
            aVar.b(returnCode.getType(), ReturnCode.errCodeToMsg(returnCode.getType()), pVar);
        }
    }

    public void a(long j11, String str, String str2, int i11, int i12, String str3, a aVar) {
        l lVar = new l();
        lVar.f69768a = j11;
        lVar.f69769b = str;
        lVar.f69771d = i12;
        lVar.f69770c = i11;
        lVar.f69774g = str3;
        lVar.f69772e = System.currentTimeMillis() / 1000;
        lVar.f69773f = "1.4.4.2";
        if (XGPushConfig.enableDebug) {
            TLogger.d("PushServiceNetworkHandler", "Action -> getTags from server (" + j11 + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + ")");
        }
        if (Util.checkAccessId(lVar.f69768a) && Util.checkAccessKey(lVar.f69769b)) {
            com.tencent.android.tpush.service.c.b.a().a(b.e(), lVar, aVar);
        } else if (aVar != null) {
            ReturnCode returnCode = ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR;
            aVar.b(returnCode.getType(), ReturnCode.errCodeToMsg(returnCode.getType()), lVar);
        }
    }

    public void a(long j11, String str, String str2, String str3, String str4, a aVar) {
        com.tencent.android.tpush.service.c.b.a().a(b.e(), new s(j11, str, str2, str3, str4, System.currentTimeMillis() / 1000, "1.4.4.2"), aVar);
    }

    public void a(Intent intent, a aVar) {
        i iVar = new i();
        iVar.f69732a = intent.getLongExtra("type", 0);
        try {
            iVar.f69733b = Long.parseLong(Rijndael.decrypt(intent.getStringExtra("accessId")));
        } catch (NumberFormatException unused) {
            TLogger.e("PushServiceNetworkHandler", "sendCommReportMessage NumberFormatException");
        }
        iVar.f69734c = intent.getLongExtra("msgId", 0);
        iVar.f69735d = intent.getLongExtra("broadcastId", 0);
        iVar.f69736e = intent.getLongExtra("msgTimestamp", 0);
        iVar.f69737f = intent.getLongExtra("clientTimestamp", 0);
        iVar.f69740i = intent.getStringExtra("pkgName");
        String decrypt = Rijndael.decrypt(intent.getStringExtra(RemoteMessageConst.MessageBody.MSG));
        if (decrypt != null) {
            iVar.f69738g = decrypt;
        }
        String decrypt2 = Rijndael.decrypt(intent.getStringExtra(TUIConstants.TUIOfflinePush.NOTIFICATION_EXT_KEY));
        if (decrypt2 != null) {
            iVar.f69739h = decrypt2;
        }
        if (Util.checkAccessId(iVar.f69733b)) {
            com.tencent.android.tpush.service.c.b.a().b(b.e(), iVar, aVar);
        } else if (aVar != null) {
            ReturnCode returnCode = ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR;
            aVar.b(returnCode.getType(), ReturnCode.errCodeToMsg(returnCode.getType()), iVar);
        }
    }
}
