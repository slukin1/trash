package com.hbg.lib.tencent.push;

import android.content.Context;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;

public class TencentPushManager {
    public static String a(Context context) {
        return XGPushConfig.getToken(context.getApplicationContext());
    }

    public static void b(Context context, XGIOperateCallback xGIOperateCallback, boolean z11, String[] strArr, String[] strArr2) {
        XGPushConfig.enableDebug(context.getApplicationContext(), z11);
        XGPushConfig.setMiPushAppId(context.getApplicationContext(), strArr[0]);
        XGPushConfig.setMiPushAppKey(context.getApplicationContext(), strArr2[0]);
        XGPushConfig.enableOtherPush(context.getApplicationContext(), true);
        c(context, xGIOperateCallback);
    }

    public static void c(Context context, XGIOperateCallback xGIOperateCallback) {
        XGPushManager.registerPush(context.getApplicationContext(), xGIOperateCallback);
    }
}
