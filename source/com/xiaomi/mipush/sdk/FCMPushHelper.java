package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gg;
import com.xiaomi.push.hc;
import com.xiaomi.push.hj;
import com.xiaomi.push.hq;
import com.xiaomi.push.j;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.l;
import com.xiaomi.push.service.u;
import com.xiaomi.push.service.x;
import java.util.HashMap;
import java.util.Map;

public class FCMPushHelper {
    private static void a(Context context, hc hcVar) {
        try {
            MiPushMessage generateMessage = PushMessageHelper.generateMessage((hj) r.a(context, hcVar), hcVar.a(), false);
            PushMessageReceiver a11 = f.a(context);
            if (a11 != null) {
                a11.onNotificationMessageArrived(context, generateMessage);
            }
        } catch (Throwable th2) {
            b.a("fcm broadcast notification come error ", th2);
        }
    }

    private static boolean b(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getBoolean("is_xmsf_sup_decrypt", false);
    }

    public static void clearToken(Context context) {
        f.a(context, d.ASSEMBLE_PUSH_FCM);
    }

    public static void convertMessage(Intent intent) {
        f.a(intent);
    }

    public static boolean isFCMSwitchOpen(Context context) {
        return f.a(context, d.ASSEMBLE_PUSH_FCM) && MiPushClient.getOpenFCMPush(context);
    }

    public static void notifyFCMNotificationCome(Context context, Map<String, String> map) {
        PushMessageReceiver a11;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (a11 = f.a(context)) != null) {
            a11.onNotificationMessageArrived(context, f.a(str));
        }
    }

    public static Map<String, String> notifyFCMPassThoughMessageCome(Context context, Map<String, String> map) {
        PushMessageReceiver a11;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (a11 = f.a(context)) != null) {
            a11.onReceivePassThroughMessage(context, f.a(str));
        }
        String str2 = map.get("mipushContainer");
        if (TextUtils.isEmpty(str2)) {
            return new HashMap();
        }
        try {
            byte[] decode = Base64.decode(str2, 2);
            a(context, u.a(decode));
            a(context, decode);
        } catch (Throwable th2) {
            b.a("fcm notify notification error ", th2);
        }
        return a(context);
    }

    public static void persistIfXmsfSupDecrypt(Context context) {
        boolean z11 = false;
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        if (((long) j.b(context)) >= 50002000) {
            z11 = true;
        }
        edit.putBoolean("is_xmsf_sup_decrypt", z11).apply();
    }

    public static void reportFCMMessageDelete() {
        MiTinyDataClient.upload(f.c(d.ASSEMBLE_PUSH_FCM), "fcm", 1, "some fcm messages was deleted ");
    }

    public static void uploadToken(Context context, String str) {
        f.a(context, d.ASSEMBLE_PUSH_FCM, str);
    }

    private static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("actionType", String.valueOf(gg.AckMessage.a()));
        hashMap.put("deviceStatus", String.valueOf(hq.a(context, context.getPackageName())));
        hashMap.put("mat", Long.toString(System.currentTimeMillis()));
        return hashMap;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [boolean] */
    private static void a(Context context, byte[] bArr) {
        boolean a11 = u.a(context).a();
        boolean z11 = true;
        boolean z12 = !"com.xiaomi.xmsf".equals(context.getPackageName());
        ? a12 = a(context);
        boolean z13 = false;
        if (!a11 || !z12 || a12 == 0) {
            b.a(String.format("xmsf can not receive fcm msg - shouldUseMIUIPush=%s;isNotXmsf=%s;xmsfSupport=%s", new Object[]{Boolean.valueOf(a11), Boolean.valueOf(z12), Boolean.valueOf(a12)}));
        } else {
            bArr = l.a(bArr, b.a(context).d());
            if (bArr == null) {
                b.a("fcm message encrypt failed");
            } else {
                String encodeToString = Base64.encodeToString(bArr, 2);
                if (TextUtils.isEmpty(encodeToString)) {
                    b.a("fcm message buf base64 encode failed");
                    z11 = false;
                } else {
                    Intent intent = new Intent(an.f52497n);
                    intent.setPackage("com.xiaomi.xmsf");
                    intent.setClassName("com.xiaomi.xmsf", "com.xiaomi.push.service.XMPushService");
                    intent.putExtra("ext_fcm_container_buffer", encodeToString);
                    intent.putExtra("mipush_app_package", context.getPackageName());
                    context.startService(intent);
                    b.a("fcm message reroute to xmsf");
                }
                z13 = z11;
            }
        }
        if (!z13) {
            b.b("fcm message post local");
            x.a(context, u.a(bArr), bArr);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m2327a(Context context) {
        return ((long) j.b(context)) >= 50002000 && b(context);
    }
}
