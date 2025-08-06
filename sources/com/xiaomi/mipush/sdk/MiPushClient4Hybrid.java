package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.bc;
import com.xiaomi.push.ee;
import com.xiaomi.push.g;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.gu;
import com.xiaomi.push.gw;
import com.xiaomi.push.hf;
import com.xiaomi.push.hg;
import com.xiaomi.push.hh;
import com.xiaomi.push.hm;
import com.xiaomi.push.hn;
import com.xiaomi.push.hq;
import com.xiaomi.push.i;
import com.xiaomi.push.j;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.au;
import com.xiaomi.push.service.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MiPushClient4Hybrid {
    private static Map<String, b.a> dataMap = new HashMap();
    private static MiPushCallback sCallback;
    private static Map<String, Long> sRegisterTimeMap = new HashMap();

    public static class MiPushCallback {
        public void onCommandResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveRegisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveUnregisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }
    }

    private static void addPullNotificationTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putLong("last_pull_notification_" + str, System.currentTimeMillis()).commit();
    }

    private static short getDeviceStatus(MiPushMessage miPushMessage, boolean z11) {
        String str = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
        int i11 = 0;
        if (!TextUtils.isEmpty(str)) {
            i11 = Integer.valueOf(str).intValue();
        }
        if (!z11) {
            i11 = (i11 & -4) + g.b.NOT_ALLOWED.a();
        }
        return (short) i11;
    }

    public static boolean isRegistered(Context context, String str) {
        return b.a(context).a(str) != null;
    }

    public static void onReceiveRegisterResult(Context context, hh hhVar) {
        b.a aVar;
        String c11 = hhVar.c();
        if (hhVar.a() == 0 && (aVar = dataMap.get(c11)) != null) {
            aVar.a(hhVar.f3137e, hhVar.f3138f);
            b.a(context).a(c11, aVar);
        }
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(hhVar.f3137e)) {
            arrayList = new ArrayList();
            arrayList.add(hhVar.f3137e);
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ee.COMMAND_REGISTER.f2769a, arrayList, hhVar.f3125a, hhVar.f3136d, (String) null, (List<String>) null);
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(c11, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, hn hnVar) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ee.COMMAND_UNREGISTER.f2769a, (List<String>) null, hnVar.f3203a, hnVar.f3211d, (String) null, (List<String>) null);
        String a11 = hnVar.a();
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(a11, generateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (b.a(context).a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            b.a a11 = b.a(context).a(str);
            if (a11 != null) {
                arrayList.add(a11.f51301c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ee.COMMAND_REGISTER.f2769a, arrayList, 0, (String) null, (String) null, (List<String>) null);
                MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                hf hfVar = new hf();
                hfVar.b(str2);
                hfVar.c(gq.PullOfflineMessage.f2942a);
                hfVar.a(aj.a());
                hfVar.a(false);
                u.a(context).a(hfVar, gg.Notification, false, true, (gt) null, false, str, str2);
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0)) < 5000) {
            com.xiaomi.channel.commonutils.logger.b.a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
        String a12 = bc.a(6);
        b.a aVar = new b.a(context);
        aVar.c(str2, str3, a12);
        dataMap.put(str, aVar);
        hg hgVar = new hg();
        hgVar.a(aj.a());
        hgVar.b(str2);
        hgVar.e(str3);
        hgVar.d(str);
        hgVar.f(a12);
        hgVar.c(g.a(context, context.getPackageName()));
        hgVar.b(g.a(context, context.getPackageName()));
        hgVar.h("6_0_1-C");
        hgVar.a(60001);
        hgVar.a(gu.Init);
        if (!j.d()) {
            String c11 = i.c(context);
            if (!TextUtils.isEmpty(c11)) {
                hgVar.i(bc.a(c11));
            }
        }
        int a13 = i.a();
        if (a13 >= 0) {
            hgVar.c(a13);
        }
        hf hfVar2 = new hf();
        hfVar2.c(gq.HybridRegister.f2942a);
        hfVar2.b(b.a(context).a());
        hfVar2.d(context.getPackageName());
        hfVar2.a(hq.a(hgVar));
        hfVar2.a(aj.a());
        u.a(context).a(hfVar2, gg.Notification, (gt) null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        t.a(context, str);
    }

    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z11) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            com.xiaomi.channel.commonutils.logger.b.a("do not ack message, message is null");
            return;
        }
        try {
            gw gwVar = new gw();
            gwVar.b(b.a(context).a());
            gwVar.a(miPushMessage.getMessageId());
            gwVar.a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            gwVar.a(getDeviceStatus(miPushMessage, z11));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                gwVar.c(miPushMessage.getTopic());
            }
            u.a(context).a(gwVar, gg.AckMessage, false, au.a(PushMessageHelper.generateMessage(miPushMessage)));
            com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
        } catch (Throwable th2) {
            miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS);
            miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
            throw th2;
        }
        miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS);
        miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void setCallback(MiPushCallback miPushCallback) {
        sCallback = miPushCallback;
    }

    private static boolean shouldPullNotification(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        if (Math.abs(System.currentTimeMillis() - sharedPreferences.getLong("last_pull_notification_" + str, -1)) > 300000) {
            return true;
        }
        return false;
    }

    public static void unregisterPush(Context context, String str) {
        sRegisterTimeMap.remove(str);
        b.a a11 = b.a(context).a(str);
        if (a11 != null) {
            hm hmVar = new hm();
            hmVar.a(aj.a());
            hmVar.d(str);
            hmVar.b(a11.f2458a);
            hmVar.c(a11.f51301c);
            hmVar.e(a11.f51300b);
            hf hfVar = new hf();
            hfVar.c(gq.HybridUnregister.f2942a);
            hfVar.b(b.a(context).a());
            hfVar.d(context.getPackageName());
            hfVar.a(hq.a(hmVar));
            hfVar.a(aj.a());
            u.a(context).a(hfVar, gg.Notification, (gt) null);
            b.a(context).b(str);
        }
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        x.a(context, linkedList);
    }
}
