package com.sensorsdata.analytics.android.sdk.internal.rpc;

import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI;

public class SensorsDataContentObserver extends ContentObserver {
    public static boolean isDisableFromObserver = false;
    public static boolean isEnableFromObserver = false;
    public static boolean isLoginFromObserver = false;
    private final UserIdentityAPI mUserIdentity;

    public SensorsDataContentObserver(UserIdentityAPI userIdentityAPI) {
        super(new Handler(Looper.getMainLooper()));
        this.mUserIdentity = userIdentityAPI;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0073 A[Catch:{ Exception -> 0x00d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b A[Catch:{ Exception -> 0x00d9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onChange(boolean r4, android.net.Uri r5) {
        /*
            r3 = this;
            com.sensorsdata.analytics.android.sdk.data.adapter.DbParams r4 = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance()     // Catch:{ Exception -> 0x00d9 }
            android.net.Uri r4 = r4.getDataCollectUri()     // Catch:{ Exception -> 0x00d9 }
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x00d9 }
            if (r4 == 0) goto L_0x0017
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r4 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x00d9 }
            r4.enableDataCollect()     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00dd
        L_0x0017:
            com.sensorsdata.analytics.android.sdk.data.adapter.DbParams r4 = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance()     // Catch:{ Exception -> 0x00d9 }
            android.net.Uri r4 = r4.getSessionTimeUri()     // Catch:{ Exception -> 0x00d9 }
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x00d9 }
            if (r4 == 0) goto L_0x0036
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r4 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x00d9 }
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r5 = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance()     // Catch:{ Exception -> 0x00d9 }
            int r5 = r5.getSessionIntervalTime()     // Catch:{ Exception -> 0x00d9 }
            r4.setSessionIntervalTime(r5)     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00dd
        L_0x0036:
            com.sensorsdata.analytics.android.sdk.data.adapter.DbParams r4 = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance()     // Catch:{ Exception -> 0x00d9 }
            android.net.Uri r4 = r4.getLoginIdUri()     // Catch:{ Exception -> 0x00d9 }
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x00d9 }
            r0 = 1
            if (r4 == 0) goto L_0x0085
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r4 = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance()     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r4 = r4.getLoginIdKey()     // Catch:{ Exception -> 0x00d9 }
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r5 = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance()     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r5 = r5.getLoginId()     // Catch:{ Exception -> 0x00d9 }
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x00d9 }
            r2 = 0
            if (r1 != 0) goto L_0x0067
            java.lang.String r1 = "$identity_login_id"
            boolean r1 = r4.equals(r1)     // Catch:{ Exception -> 0x00d9 }
            if (r1 == 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r1 = r2
            goto L_0x0068
        L_0x0067:
            r1 = r0
        L_0x0068:
            if (r1 == 0) goto L_0x0071
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x00d9 }
            if (r1 == 0) goto L_0x0071
            r2 = r0
        L_0x0071:
            if (r2 == 0) goto L_0x007b
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r4 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x00d9 }
            r4.logout()     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00dd
        L_0x007b:
            isLoginFromObserver = r0     // Catch:{ Exception -> 0x00d9 }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x00d9 }
            r0.loginWithKey(r4, r5)     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00dd
        L_0x0085:
            com.sensorsdata.analytics.android.sdk.data.adapter.DbParams r4 = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance()     // Catch:{ Exception -> 0x00d9 }
            android.net.Uri r4 = r4.getDisableSDKUri()     // Catch:{ Exception -> 0x00d9 }
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x00d9 }
            if (r4 == 0) goto L_0x00a3
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r4 = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions()     // Catch:{ Exception -> 0x00d9 }
            boolean r4 = r4.isDisableSDK()     // Catch:{ Exception -> 0x00d9 }
            if (r4 != 0) goto L_0x00dd
            isDisableFromObserver = r0     // Catch:{ Exception -> 0x00d9 }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.disableSDK()     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00dd
        L_0x00a3:
            com.sensorsdata.analytics.android.sdk.data.adapter.DbParams r4 = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance()     // Catch:{ Exception -> 0x00d9 }
            android.net.Uri r4 = r4.getEnableSDKUri()     // Catch:{ Exception -> 0x00d9 }
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x00d9 }
            if (r4 == 0) goto L_0x00c1
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r4 = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions()     // Catch:{ Exception -> 0x00d9 }
            boolean r4 = r4.isDisableSDK()     // Catch:{ Exception -> 0x00d9 }
            if (r4 == 0) goto L_0x00dd
            isEnableFromObserver = r0     // Catch:{ Exception -> 0x00d9 }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.enableSDK()     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00dd
        L_0x00c1:
            com.sensorsdata.analytics.android.sdk.data.adapter.DbParams r4 = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance()     // Catch:{ Exception -> 0x00d9 }
            android.net.Uri r4 = r4.getUserIdentities()     // Catch:{ Exception -> 0x00d9 }
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x00d9 }
            if (r4 == 0) goto L_0x00dd
            com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI r4 = r3.mUserIdentity     // Catch:{ Exception -> 0x00d9 }
            com.sensorsdata.analytics.android.sdk.useridentity.Identities r4 = r4.getIdentitiesInstance()     // Catch:{ Exception -> 0x00d9 }
            r4.updateIdentities()     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00dd
        L_0x00d9:
            r4 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)
        L_0x00dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.internal.rpc.SensorsDataContentObserver.onChange(boolean, android.net.Uri):void");
    }
}
