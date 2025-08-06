package com.sensorsdata.analytics.android.sdk.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation;
import com.sensorsdata.analytics.android.sdk.core.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils;
import com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager;
import com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug;
import com.sumsub.sns.internal.fingerprint.signalproviders.f;

public class SASchemeHelper {
    private static final String TAG = "SA.SASchemeUtil";

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r4 = android.net.Uri.parse(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean checkProjectIsValid(java.lang.String r4) {
        /*
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()
            java.lang.String r0 = r0.getServerUrl()
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r2 = "project"
            r3 = 0
            if (r1 != 0) goto L_0x001c
            android.net.Uri r4 = android.net.Uri.parse(r4)
            if (r4 == 0) goto L_0x001c
            java.lang.String r4 = r4.getQueryParameter(r2)
            goto L_0x001d
        L_0x001c:
            r4 = r3
        L_0x001d:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x002d
            android.net.Uri r0 = android.net.Uri.parse(r0)
            if (r0 == 0) goto L_0x002d
            java.lang.String r3 = r0.getQueryParameter(r2)
        L_0x002d:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x0041
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x0041
            boolean r4 = android.text.TextUtils.equals(r4, r3)
            if (r4 == 0) goto L_0x0041
            r4 = 1
            goto L_0x0042
        L_0x0041:
            r4 = 0
        L_0x0042:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.SASchemeHelper.checkProjectIsValid(java.lang.String):boolean");
    }

    public static void handleSchemeUrl(Activity activity, Intent intent) {
        Uri uri;
        String str;
        if (AbstractSensorsDataAPI.isSDKDisabled()) {
            SALog.i(TAG, "SDK is disabled,scan code function has been turned off");
        } else if (SensorsDataAPI.sharedInstance() instanceof SensorsDataAPIEmptyImplementation) {
            SALog.i(TAG, "SDK is not init");
        } else {
            if (activity == null || intent == null) {
                uri = null;
            } else {
                try {
                    uri = intent.getData();
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                    return;
                }
            }
            if (uri != null) {
                SensorsDataAPI sharedInstance = SensorsDataAPI.sharedInstance();
                String host = uri.getHost();
                if (SAModuleManager.getInstance().handlerScanUri(activity, uri)) {
                    intent.setData((Uri) null);
                } else if ("heatmap".equals(host)) {
                    String queryParameter = uri.getQueryParameter("feature_code");
                    String queryParameter2 = uri.getQueryParameter("url");
                    if (checkProjectIsValid(queryParameter2)) {
                        SensorsDataDialogUtils.showOpenHeatMapDialog(activity, queryParameter, queryParameter2);
                    } else {
                        SensorsDataDialogUtils.showDialog(activity, "App 集成的项目与电脑浏览器打开的项目不同，无法进行点击分析");
                    }
                    intent.setData((Uri) null);
                } else if ("debugmode".equals(host)) {
                    SensorsDataDialogUtils.showDebugModeSelectDialog(activity, uri.getQueryParameter("info_id"), uri.getQueryParameter("sf_push_distinct_id"), uri.getQueryParameter("project"));
                    intent.setData((Uri) null);
                } else if ("visualized".equals(host)) {
                    String queryParameter3 = uri.getQueryParameter("feature_code");
                    String queryParameter4 = uri.getQueryParameter("url");
                    if (checkProjectIsValid(queryParameter4)) {
                        SensorsDataDialogUtils.showOpenVisualizedAutoTrackDialog(activity, queryParameter3, queryParameter4);
                    } else {
                        SensorsDataDialogUtils.showDialog(activity, "App 集成的项目与电脑浏览器打开的项目不同，无法进行可视化全埋点。");
                    }
                    intent.setData((Uri) null);
                } else if ("popupwindow".equals(host)) {
                    SensorsDataDialogUtils.showPopupWindowDialog(activity, uri);
                    intent.setData((Uri) null);
                } else if ("encrypt".equals(host)) {
                    String queryParameter5 = uri.getQueryParameter(f.f34662a);
                    String decode = Uri.decode(uri.getQueryParameter("key"));
                    String decode2 = Uri.decode(uri.getQueryParameter("symmetricEncryptType"));
                    String decode3 = Uri.decode(uri.getQueryParameter("asymmetricEncryptType"));
                    SALog.d(TAG, "Encrypt, version = " + queryParameter5 + ", key = " + decode + ", symmetricEncryptType = " + decode2 + ", asymmetricEncryptType = " + decode3);
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        if (!TextUtils.isEmpty(decode)) {
                            str = sharedInstance.getSensorsDataEncrypt() != null ? sharedInstance.getSensorsDataEncrypt().checkPublicSecretKey(queryParameter5, decode, decode2, decode3) : "当前 App 未开启加密，请开启加密后再试";
                            ToastUtil.showLong(activity, str);
                            SensorsDataDialogUtils.startLaunchActivity(activity);
                            intent.setData((Uri) null);
                        }
                    }
                    str = "密钥验证不通过，所选密钥无效";
                    ToastUtil.showLong(activity, str);
                    SensorsDataDialogUtils.startLaunchActivity(activity);
                    intent.setData((Uri) null);
                } else if ("abtest".equals(host)) {
                    try {
                        ReflectUtil.callStaticMethod(Class.forName("com.sensorsdata.abtest.core.SensorsABTestSchemeHandler"), "handleSchemeUrl", uri.toString());
                    } catch (Exception e12) {
                        SALog.printStackTrace(e12);
                    }
                    SensorsDataDialogUtils.startLaunchActivity(activity);
                    intent.setData((Uri) null);
                } else if ("sensorsdataremoteconfig".equals(host)) {
                    SensorsDataAPI.sharedInstance().enableLog(true);
                    BaseSensorsDataSDKRemoteManager remoteManager = sharedInstance.getRemoteManager();
                    if (remoteManager != null) {
                        remoteManager.resetPullSDKConfigTimer();
                    }
                    SensorsDataRemoteManagerDebug sensorsDataRemoteManagerDebug = new SensorsDataRemoteManagerDebug(sharedInstance);
                    sharedInstance.setRemoteManager(sensorsDataRemoteManagerDebug);
                    SALog.i(TAG, "Start debugging remote config");
                    sensorsDataRemoteManagerDebug.checkRemoteConfig(uri, activity);
                    intent.setData((Uri) null);
                } else if ("assistant".equals(host)) {
                    SAConfigOptions configOptions = AbstractSensorsDataAPI.getConfigOptions();
                    if ((configOptions == null || !configOptions.mDisableDebugAssistant) && "pairingCode".equals(uri.getQueryParameter("service"))) {
                        SensorsDataDialogUtils.showPairingCodeInputDialog(activity);
                    }
                } else {
                    SensorsDataDialogUtils.startLaunchActivity(activity);
                }
            }
        }
    }
}
