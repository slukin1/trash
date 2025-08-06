package com.tencent.thumbplayer.tcmedia.c;

import android.content.Context;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerMgr;
import com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.tencent.thumbplayer.tcmedia.utils.f;
import com.tencent.thumbplayer.tcmedia.utils.i;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class i implements f.a, i.b {

    /* renamed from: a  reason: collision with root package name */
    private int f49102a;

    /* renamed from: b  reason: collision with root package name */
    private String f49103b;

    /* renamed from: c  reason: collision with root package name */
    private int f49104c;

    /* renamed from: d  reason: collision with root package name */
    private ConcurrentHashMap<Integer, b> f49105d;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static i f49107a = new i();
    }

    private i() {
        this.f49102a = 0;
        this.f49103b = "";
        this.f49104c = 0;
        if (this.f49105d == null) {
            this.f49105d = new ConcurrentHashMap<>();
        }
        f.a(this);
        com.tencent.thumbplayer.tcmedia.utils.i.a().a((i.b) this);
    }

    public static i a() {
        return a.f49107a;
    }

    private static TPDLProxyInitParam a(Context context) {
        return new TPDLProxyInitParam(TPPlayerConfig.getPlatform(), TPPlayerConfig.getAppVersionName(context), TPPlayerConfig.getGuid(), TPPlayerConfig.getProxyCacheDir(), TPPlayerConfig.getProxyDataDir(), TPPlayerConfig.getProxyConfigDir());
    }

    private void a(String str, int i11) {
        this.f49103b = str;
        this.f49104c = i11;
        for (b next : this.f49105d.values()) {
            next.a().setUserData(TPDownloadProxyEnum.USER_UPC, str);
            next.a().setUserData(TPDownloadProxyEnum.USER_UPC_STATE, Integer.valueOf(i11));
        }
    }

    private String b(boolean z11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("EnableReport", z11);
            return jSONObject.toString();
        } catch (JSONException e11) {
            TPLogUtil.e("TPProxyGlobalManager", (Throwable) e11);
            return "";
        }
    }

    private void b(int i11) {
        for (b a11 : this.f49105d.values()) {
            a11.a(i11);
        }
    }

    private String c(long j11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("MaxUseMemoryLevel1MB", j11);
            jSONObject.put("MaxUseMemoryLevel2MB", j11);
            jSONObject.put("MaxUseMemoryMB", j11);
            return jSONObject.toString();
        } catch (JSONException e11) {
            TPLogUtil.e("TPProxyGlobalManager", (Throwable) e11);
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b9 A[Catch:{ all -> 0x00dc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.thumbplayer.tcmedia.c.b a(int r9) {
        /*
            r8 = this;
            java.lang.String r0 = "proxy_config"
            java.lang.String r1 = "TPProxyGlobalManager"
            r2 = 0
            if (r9 >= 0) goto L_0x0008
            return r2
        L_0x0008:
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.tencent.thumbplayer.tcmedia.c.b> r3 = r8.f49105d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)
            boolean r3 = r3.containsKey(r4)
            if (r3 == 0) goto L_0x0021
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.tencent.thumbplayer.tcmedia.c.b> r0 = r8.f49105d
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.Object r9 = r0.get(r9)
            com.tencent.thumbplayer.tcmedia.c.b r9 = (com.tencent.thumbplayer.tcmedia.c.b) r9
            return r9
        L_0x0021:
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDownloadProxy r3 = com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyFactory.getTPDownloadProxy(r9)
            if (r3 == 0) goto L_0x00ea
            android.content.Context r4 = com.tencent.thumbplayer.tcmedia.api.TPPlayerMgr.getAppContext()     // Catch:{ all -> 0x00dc }
            android.content.Context r5 = com.tencent.thumbplayer.tcmedia.api.TPPlayerMgr.getAppContext()     // Catch:{ all -> 0x00dc }
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDLProxyInitParam r5 = a((android.content.Context) r5)     // Catch:{ all -> 0x00dc }
            int r4 = r3.init(r4, r5)     // Catch:{ all -> 0x00dc }
            if (r4 >= 0) goto L_0x0047
            java.lang.String r9 = "downloadProxy init failed with status:"
            java.lang.String r0 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x00dc }
            java.lang.String r9 = r9.concat(r0)     // Catch:{ all -> 0x00dc }
            com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.i(r1, r9)     // Catch:{ all -> 0x00dc }
            return r2
        L_0x0047:
            com.tencent.thumbplayer.tcmedia.c.i$1 r4 = new com.tencent.thumbplayer.tcmedia.c.i$1     // Catch:{ all -> 0x00dc }
            r4.<init>()     // Catch:{ all -> 0x00dc }
            r3.setLogListener(r4)     // Catch:{ all -> 0x00dc }
            int r4 = com.tencent.thumbplayer.tcmedia.utils.i.c()     // Catch:{ all -> 0x00dc }
            r5 = 10
            r6 = 1
            if (r4 != r6) goto L_0x005f
            r3.pushEvent(r6)     // Catch:{ all -> 0x00dc }
        L_0x005b:
            r3.pushEvent(r5)     // Catch:{ all -> 0x00dc }
            goto L_0x0072
        L_0x005f:
            r6 = 2
            if (r4 != r6) goto L_0x006b
            r3.pushEvent(r6)     // Catch:{ all -> 0x00dc }
            r4 = 9
            r3.pushEvent(r4)     // Catch:{ all -> 0x00dc }
            goto L_0x0072
        L_0x006b:
            r7 = 3
            if (r4 != r7) goto L_0x0072
            r3.pushEvent(r6)     // Catch:{ all -> 0x00dc }
            goto L_0x005b
        L_0x0072:
            int r4 = r8.f49102a     // Catch:{ all -> 0x00dc }
            r3.pushEvent(r4)     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = "carrier_pesudo_code"
            java.lang.String r5 = r8.f49103b     // Catch:{ all -> 0x00dc }
            r3.setUserData(r4, r5)     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = "carrier_pesudo_state"
            int r5 = r8.f49104c     // Catch:{ all -> 0x00dc }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x00dc }
            r3.setUserData(r4, r5)     // Catch:{ all -> 0x00dc }
            boolean r4 = com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig.isDataReportEnable()     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = r8.b((boolean) r4)     // Catch:{ all -> 0x00dc }
            r3.setUserData(r0, r4)     // Catch:{ all -> 0x00dc }
            long r4 = com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig.getProxyMaxUseMemoryMB()     // Catch:{ all -> 0x00dc }
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b1
            long r4 = com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig.getProxyMaxUseMemoryMB()     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = r8.c(r4)     // Catch:{ all -> 0x00dc }
            if (r4 == 0) goto L_0x00b1
            int r5 = r4.length()     // Catch:{ all -> 0x00dc }
            if (r5 <= 0) goto L_0x00b1
            r3.setUserData(r0, r4)     // Catch:{ all -> 0x00dc }
        L_0x00b1:
            long r4 = com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig.getProxyMaxStorageSizeMB()     // Catch:{ all -> 0x00dc }
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x00c0
            long r4 = com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig.getProxyMaxStorageSizeMB()     // Catch:{ all -> 0x00dc }
            r3.setMaxStorageSizeMB(r4)     // Catch:{ all -> 0x00dc }
        L_0x00c0:
            com.tencent.thumbplayer.tcmedia.c.j r0 = new com.tencent.thumbplayer.tcmedia.c.j     // Catch:{ all -> 0x00dc }
            r0.<init>(r3)     // Catch:{ all -> 0x00dc }
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.tencent.thumbplayer.tcmedia.c.b> r3 = r8.f49105d     // Catch:{ all -> 0x00dc }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x00dc }
            r3.put(r4, r0)     // Catch:{ all -> 0x00dc }
            java.lang.String r3 = "getPlayerProxy, init proxy succeeded, serviceType:"
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00dc }
            java.lang.String r9 = r3.concat(r9)     // Catch:{ all -> 0x00dc }
            com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.i(r1, r9)     // Catch:{ all -> 0x00dc }
            return r0
        L_0x00dc:
            r9 = move-exception
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r0 = "init proxy failed:"
            java.lang.String r9 = r0.concat(r9)
            com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.e((java.lang.String) r1, (java.lang.String) r9)
        L_0x00ea:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.c.i.a(int):com.tencent.thumbplayer.tcmedia.c.b");
    }

    public void a(int i11, int i12, int i13, int i14) {
        int i15 = 10;
        if (i12 == 1) {
            b(1);
        } else if (i12 == 2) {
            b(2);
            i15 = 9;
        } else if (i12 == 3) {
            b(2);
            b(10);
            return;
        } else {
            return;
        }
        b(i15);
    }

    public void a(int i11, int i12, int i13, Object obj) {
        int i14;
        TPLogUtil.i("TPProxyGlobalManager", "onEvent eventId: " + i11 + ", arg1: " + i12 + ", arg2: " + i13 + ", object" + obj);
        switch (i11) {
            case TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND:
                i14 = 13;
                break;
            case TPPlayerMgr.EVENT_ID_APP_ENTER_FOREGROUND:
                i14 = 14;
                break;
            case 100003:
                a((String) obj, i12);
                return;
            default:
                return;
        }
        this.f49102a = i14;
        b(i14);
    }

    public void a(long j11) {
        for (b a11 : this.f49105d.values()) {
            ITPDownloadProxy a12 = a11.a();
            if (a12 != null && j11 > 0) {
                a12.setMaxStorageSizeMB(j11);
            }
        }
    }

    public void a(boolean z11) {
        for (b a11 : this.f49105d.values()) {
            a11.a().setUserData(TPDownloadProxyEnum.USER_PROXY_CONFIG, b(z11));
        }
    }

    public void b(long j11) {
        for (b a11 : this.f49105d.values()) {
            a11.a().setUserData(TPDownloadProxyEnum.USER_PROXY_CONFIG, c(j11));
        }
    }
}
