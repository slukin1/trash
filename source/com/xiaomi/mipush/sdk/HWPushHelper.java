package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import org.json.JSONArray;
import org.json.JSONObject;

public class HWPushHelper {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f51279a = false;

    public static void convertMessage(Intent intent) {
        f.a(intent);
    }

    public static boolean hasNetwork(Context context) {
        return f.a(context);
    }

    public static boolean isHmsTokenSynced(Context context) {
        String a11 = f.a(context, d.ASSEMBLE_PUSH_HUAWEI, false);
        String a12 = p.a(context).a(v.UPLOAD_HUAWEI_TOKEN);
        if (TextUtils.isEmpty(a11) || TextUtils.isEmpty(a12) || !"synced".equals(a12)) {
            return false;
        }
        return true;
    }

    public static boolean isUserOpenHmsPush(Context context) {
        return MiPushClient.getOpenHmsPush(context);
    }

    public static boolean needConnect() {
        return f51279a;
    }

    public static void notifyHmsNotificationMessageClicked(Context context, String str) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject = jSONArray.getJSONObject(i11);
                        if (jSONObject.has("pushMsg")) {
                            str2 = jSONObject.getString("pushMsg");
                            break;
                        }
                        i11++;
                    }
                }
            } catch (Exception e11) {
                b.d(e11.toString());
            }
        }
        PushMessageReceiver a11 = f.a(context);
        if (a11 != null) {
            MiPushMessage a12 = f.a(str2);
            if (!a12.getExtra().containsKey("notify_effect")) {
                a11.onNotificationMessageClicked(context, a12);
            }
        }
    }

    public static void notifyHmsPassThoughMessageArrived(Context context, String str) {
        String str2 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("content")) {
                    str2 = jSONObject.getString("content");
                }
            }
        } catch (Exception e11) {
            b.d(e11.toString());
        }
        PushMessageReceiver a11 = f.a(context);
        if (a11 != null) {
            a11.onReceivePassThroughMessage(context, f.a(str2));
        }
    }

    public static void registerHuaWeiAssemblePush(Context context) {
        AbstractPushManager a11 = e.a(context).a(d.ASSEMBLE_PUSH_HUAWEI);
        if (a11 != null) {
            a11.register();
        }
    }

    public static void reportError(String str, int i11) {
        f.a(str, i11);
    }

    public static synchronized void setConnectTime(Context context) {
        synchronized (HWPushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
        }
    }

    public static synchronized void setGetTokenTime(Context context) {
        synchronized (HWPushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_get_token_time", System.currentTimeMillis()).commit();
        }
    }

    public static void setNeedConnect(boolean z11) {
        f51279a = z11;
    }

    public static synchronized boolean shouldGetToken(Context context) {
        boolean z11;
        synchronized (HWPushHelper.class) {
            z11 = false;
            if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_get_token_time", -1)) > 172800000) {
                z11 = true;
            }
        }
        return z11;
    }

    public static synchronized boolean shouldTryConnect(Context context) {
        boolean z11;
        synchronized (HWPushHelper.class) {
            z11 = false;
            if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1)) > 5000) {
                z11 = true;
            }
        }
        return z11;
    }

    public static void uploadToken(Context context, String str) {
        f.a(context, d.ASSEMBLE_PUSH_HUAWEI, str);
    }
}
