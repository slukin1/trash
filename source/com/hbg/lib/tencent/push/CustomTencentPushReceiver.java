package com.hbg.lib.tencent.push;

import android.content.Context;
import com.hbg.lib.common.utils.UtilGson;
import com.tencent.android.tpush.NotificationAction;
import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushClickedResult;
import com.tencent.android.tpush.XGPushRegisterResult;
import com.tencent.android.tpush.XGPushShowedResult;
import com.tencent.android.tpush.XGPushTextMessage;
import i6.d;
import i6.k;

public class CustomTencentPushReceiver extends XGPushBaseReceiver {
    public void onDeleteAccountResult(Context context, int i11, String str) {
        d.c("TPush", "CustomTencentPushReceiver-->onDeleteAccountResult-->");
    }

    public void onDeleteAttributeResult(Context context, int i11, String str) {
        d.c("TPush", "CustomTencentPushReceiver-->onDeleteAttributeResult-->");
    }

    public void onDeleteTagResult(Context context, int i11, String str) {
        d.c("TPush", "CustomTencentPushReceiver-->onDeleteTagResult-->");
    }

    public void onNotificationClickedResult(Context context, XGPushClickedResult xGPushClickedResult) {
        String str;
        if (xGPushClickedResult != null) {
            try {
                k.n("CustomTencentPushReceiver-->onNotificationClickedResult--> " + UtilGson.a(xGPushClickedResult));
            } catch (Throwable th2) {
                th2.printStackTrace();
                k.n("CustomTencentPushReceiver-->onNotificationClickedResult--> " + th2.getMessage());
            }
        } else {
            k.n("CustomTencentPushReceiver-->onNotificationClickedResult--> null");
        }
        if (context != null && xGPushClickedResult != null) {
            if (xGPushClickedResult.getActionType() == ((long) NotificationAction.clicked.getType())) {
                str = "通知被打开 :" + xGPushClickedResult;
                TencentPushModuleConfig.a().a(context, xGPushClickedResult.getTitle(), xGPushClickedResult.getContent(), xGPushClickedResult.getCustomContent());
            } else if (xGPushClickedResult.getActionType() == ((long) NotificationAction.delete.getType())) {
                str = "通知被清除 :" + xGPushClickedResult;
            } else {
                str = "";
            }
            k.n("CustomTencentPushReceiver-->onNotificationClickedResult--> " + str);
        }
    }

    public void onNotificationShowedResult(Context context, XGPushShowedResult xGPushShowedResult) {
        d.c("TPush", "CustomTencentPushReceiver-->onNotificationShowedResult-->");
        TencentPushModuleConfig.a().b(context, xGPushShowedResult.getTitle(), xGPushShowedResult.getContent(), xGPushShowedResult.getCustomContent());
    }

    public void onQueryTagsResult(Context context, int i11, String str, String str2) {
        d.c("TPush", "CustomTencentPushReceiver-->onQueryTagsResult-->");
    }

    public void onRegisterResult(Context context, int i11, XGPushRegisterResult xGPushRegisterResult) {
        d.c("TPush", "CustomTencentPushReceiver-->onRegisterResult-->");
    }

    public void onSetAccountResult(Context context, int i11, String str) {
        d.c("TPush", "CustomTencentPushReceiver-->onSetAccountResult-->");
    }

    public void onSetAttributeResult(Context context, int i11, String str) {
        d.c("TPush", "CustomTencentPushReceiver-->onSetAttributeResult-->");
    }

    public void onSetTagResult(Context context, int i11, String str) {
        d.c("TPush", "CustomTencentPushReceiver-->onSetTagResult-->");
    }

    public void onTextMessage(Context context, XGPushTextMessage xGPushTextMessage) {
        d.c("TPush", "CustomTencentPushReceiver-->onTextMessage-->" + xGPushTextMessage);
    }

    public void onUnregisterResult(Context context, int i11) {
        d.c("TPush", "CustomTencentPushReceiver-->onUnregisterResult-->");
    }
}
