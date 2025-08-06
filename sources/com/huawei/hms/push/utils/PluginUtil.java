package com.huawei.hms.push.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.i;
import com.huawei.hms.push.l;
import com.huawei.hms.push.m;
import com.huawei.hms.push.r;
import com.huawei.hms.push.t;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.jumio.sdk.reject.JumioRejectReason;
import java.nio.charset.Charset;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginUtil {
    private PluginUtil() {
    }

    private static void a(Context context, String str, String str2, String str3) {
        HMSLog.i("PluginUtil", "onNotification");
        if (!i.a(context)) {
            HMSLog.i("PluginUtil", context.getPackageName() + " disable display notification.");
            l.a(context, str, (String) null, JumioRejectReason.COLOR_PHOTOCOPY);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
        Charset charset = m.f38400a;
        intent.putExtra("selfshow_info", str3.getBytes(charset));
        intent.putExtra("selfshow_token", str2.getBytes(charset));
        intent.setPackage(context.getPackageName());
        t.a(context, intent);
        HMSLog.i("PluginUtil", "invokeSelfShow done");
    }

    public static void onAppOpened(Context context, String str, String str2, Bundle bundle) {
        l.a(context, str, str2, "appHasOpenedId");
        l.a(context, bundle, "hmsStatistics");
    }

    public static boolean onDataMessage(Context context, String str, String str2, boolean z11) {
        HMSLog.i("PluginUtil", "onDataMessage");
        if (TextUtils.isEmpty(str2)) {
            HMSLog.i("PluginUtil", "Empty message received");
            return true;
        }
        if (z11) {
            a(context, str);
        }
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString(Constants.MessagePayloadKeys.MSGID_SERVER, str);
        bundle.putByteArray(RemoteMessageConst.MSGBODY, str2.getBytes(m.f38400a));
        bundle.putString("message_type", "received_message");
        return new r().a(context, bundle, intent);
    }

    public static boolean onDeletedMessages(Context context) {
        HMSLog.i("PluginUtil", "onDeletedMessages");
        if (context == null) {
            return false;
        }
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
        bundle.putString("message_type", "server_deleted_message");
        return new r().a(context, bundle, intent);
    }

    public static void onMessage(Context context, String[] strArr) {
        HMSLog.i("PluginUtil", "onMessage");
        if (context != null && strArr != null && strArr.length >= 5) {
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context.getApplicationContext());
            }
            if (a(context, strArr)) {
                a(context, strArr[0], strArr[3], strArr[4]);
            } else {
                onDataMessage(context, strArr[0], strArr[4], true);
            }
        }
    }

    public static boolean onNewToken(Context context, String str, String str2, ErrorEnum errorEnum) {
        HMSLog.i("PluginUtil", "onNewToken called.");
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putInt("error", errorEnum.getInternalCode());
        bundle.putString("message_type", "new_token");
        bundle.putString(RemoteMessageConst.DEVICE_TOKEN, str);
        if (TextUtils.equals(str2, context.getPackageName())) {
            bundle.putString("subjectId", (String) null);
        } else {
            bundle.putString("subjectId", str2);
        }
        bundle.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
        return new r().a(context, bundle, intent);
    }

    public static void onNotificationArrived(Context context, String str, String str2) {
        l.a(context, str, str2, "100");
    }

    public static void onNotificationClicked(Context context, String str, String str2) {
        l.a(context, str, str2, "1");
        onAppOpened(context, str, str2, (Bundle) null);
    }

    public static boolean onOldDataMessage(Context context, String str, String str2) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context.getApplicationContext());
        }
        return onDataMessage(context, str, a(str2), true);
    }

    public static void saveNotifySwitch(Context context, boolean z11) {
        new PushPreferences(context, "push_notify_flag").saveBoolean("notify_msg_enable", z11);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("data", str);
            jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
            return jSONObject2.toString();
        } catch (JSONException unused) {
            HMSLog.e("PluginUtil", "rebuild message failed");
            return null;
        }
    }

    private static boolean a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            HMSLog.w("PluginUtil", "get running app processes null!");
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.processName.equals(context.getPackageName())) {
                int i11 = next.importance;
                if (i11 == 100 || i11 == 200) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private static boolean a(Context context, String[] strArr) {
        if (!TextUtils.equals(strArr[1], "0")) {
            return false;
        }
        if (a(context) || TextUtils.equals(strArr[2], "1")) {
            return true;
        }
        return false;
    }

    private static void a(Context context, String str) {
        l.a(context, str, (String) null, JumioRejectReason.BLACK_WHITE_COPY);
    }
}
