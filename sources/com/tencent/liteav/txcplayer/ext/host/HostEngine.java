package com.tencent.liteav.txcplayer.ext.host;

import android.content.Context;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.Map;

public class HostEngine {
    public static final String TAG = "HostEngine";
    private static HostEngine mInstance;
    private Context mAppContext;
    private boolean mIsInit = false;

    private HostEngine() {
    }

    public static HostEngine getInstance() {
        if (mInstance == null) {
            synchronized (HostEngine.class) {
                if (mInstance == null) {
                    mInstance = new HostEngine();
                }
            }
        }
        return mInstance;
    }

    public boolean checkAndLoadPlugin(int i11) {
        LiteavLog.i(TAG, "[checkAndLoadPlugin], pluginId=".concat(String.valueOf(i11)));
        return PluginManager.getInstance().checkAndLoadPlugin(i11);
    }

    public Context getAppContext() {
        return this.mAppContext;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        if (r6 == r0.value) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleSyncRequestHandleByHost(int r6, java.util.Map<java.lang.String, java.lang.Object> r7, java.util.Map<java.lang.String, java.lang.Object> r8) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "[handleSyncRequestHandleByHost], functionId="
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r1 = " ,inParams="
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = " ,outParams="
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "HostEngine"
            com.tencent.liteav.base.util.LiteavLog.w(r1, r0)
            r0 = 1
            java.lang.String r2 = "KEY_RET_PARAM1"
            if (r6 == r0) goto L_0x009a
            r0 = 2
            if (r6 == r0) goto L_0x0099
            r0 = 3
            if (r6 == r0) goto L_0x0030
            goto L_0x0099
        L_0x0030:
            if (r7 == 0) goto L_0x0099
            if (r8 != 0) goto L_0x0035
            goto L_0x0099
        L_0x0035:
            r6 = 0
            java.lang.String r0 = "KEY_PARAM1"
            java.lang.Object r7 = r7.get(r0)
            if (r7 == 0) goto L_0x0048
            boolean r0 = r7 instanceof java.lang.Integer
            if (r0 == 0) goto L_0x0048
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r6 = r7.intValue()
        L_0x0048:
            r7 = 0
            com.tencent.liteav.sdk.common.LicenseChecker$a r0 = com.tencent.liteav.sdk.common.LicenseChecker.a.PLAYER_STANDARD
            int r3 = r0.value
            if (r6 != r3) goto L_0x0051
        L_0x004f:
            r7 = r0
            goto L_0x006d
        L_0x0051:
            com.tencent.liteav.sdk.common.LicenseChecker$a r0 = com.tencent.liteav.sdk.common.LicenseChecker.a.PLAYER_MONET
            int r3 = r0.value
            if (r6 != r3) goto L_0x0058
            goto L_0x004f
        L_0x0058:
            com.tencent.liteav.sdk.common.LicenseChecker$a r0 = com.tencent.liteav.sdk.common.LicenseChecker.a.PLAYER_PREMIUM
            int r3 = r0.value
            if (r6 != r3) goto L_0x005f
            goto L_0x004f
        L_0x005f:
            com.tencent.liteav.sdk.common.LicenseChecker$a r0 = com.tencent.liteav.sdk.common.LicenseChecker.a.PLAYER_ENTERPRISE
            int r3 = r0.value
            if (r6 != r3) goto L_0x0066
            goto L_0x004f
        L_0x0066:
            com.tencent.liteav.sdk.common.LicenseChecker$a r0 = com.tencent.liteav.sdk.common.LicenseChecker.a.PLAYER_PROJECTION
            int r3 = r0.value
            if (r6 != r3) goto L_0x006d
            goto L_0x004f
        L_0x006d:
            boolean r0 = com.tencent.liteav.txcplayer.common.c.a(r7)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "[CHECK_FEATURE_AUTH], feature="
            r3.<init>(r4)
            r3.append(r6)
            java.lang.String r6 = " ,functionType="
            r3.append(r6)
            r3.append(r7)
            java.lang.String r6 = " ,result="
            r3.append(r6)
            r3.append(r0)
            java.lang.String r6 = r3.toString()
            com.tencent.liteav.base.util.LiteavLog.i(r1, r6)
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r0)
            r8.put(r2, r6)
        L_0x0099:
            return
        L_0x009a:
            com.tencent.liteav.txcplayer.ext.service.RenderProcessService r6 = com.tencent.liteav.txcplayer.ext.service.RenderProcessService.getInstance()
            int r6 = r6.getVodLicenseFeature()
            if (r8 == 0) goto L_0x00ab
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r8.put(r2, r6)
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcplayer.ext.host.HostEngine.handleSyncRequestHandleByHost(int, java.util.Map, java.util.Map):void");
    }

    public synchronized void init(Context context) {
        LiteavLog.d(TAG, "[init], appContext=" + context + " ,mIsInit=" + this.mIsInit);
        if (!this.mIsInit) {
            this.mAppContext = context;
            onCreate();
            this.mIsInit = true;
        }
    }

    public void onCreate() {
        LiteavLog.d(TAG, "[onCreate]");
        PluginManager.getInstance().loadPlugin();
    }

    public void onDestroy() {
        LiteavLog.d(TAG, "[onDestroy]");
        PluginManager.getInstance().unLoadPlugin();
    }

    public void sendAsyncRequestToPlugin(int i11, int i12, Map<String, Object> map, PluginCallback pluginCallback) {
        IPluginBase pluginInstance = PluginManager.getInstance().getPluginInstance(i11);
        if (pluginInstance != null) {
            pluginInstance.handleAsyncRequest(i11, i12, map, pluginCallback);
            return;
        }
        LiteavLog.w(TAG, "[sendAsyncRequestToPlugin], destPluginId=" + i11 + " is not loaded");
    }

    public void sendSyncRequestHandleByHost(int i11, Map<String, Object> map, Map<String, Object> map2) {
        handleSyncRequestHandleByHost(i11, map, map2);
    }

    public void sendSyncRequestToPlugin(int i11, int i12, Map<String, Object> map, Map<String, Object> map2) {
        IPluginBase pluginInstance = PluginManager.getInstance().getPluginInstance(i11);
        if (pluginInstance != null) {
            pluginInstance.handleSyncRequest(i11, i12, map, map2);
            return;
        }
        LiteavLog.w(TAG, "[sendSyncRequestToPlugin], destPluginId=" + i11 + " is not loaded");
    }
}
