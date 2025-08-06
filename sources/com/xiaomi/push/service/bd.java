package com.xiaomi.push.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.af;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.hf;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.t;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bd implements XMPushService.n {

    /* renamed from: a  reason: collision with root package name */
    private static Context f52547a;

    /* renamed from: a  reason: collision with other field name */
    private static final Map<Integer, Map<String, List<String>>> f3381a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private static final boolean f3382a = Log.isLoggable("UNDatas", 3);

    public bd(Context context) {
        f52547a = context;
    }

    private static void b() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(f3381a);
        if (hashMap.size() > 0) {
            for (Integer num : hashMap.keySet()) {
                Map map = (Map) hashMap.get(num);
                if (map != null && map.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : map.keySet()) {
                        sb2.append(str);
                        sb2.append(":");
                        List list = (List) map.get(str);
                        if (!t.a(list)) {
                            for (int i11 = 0; i11 < list.size(); i11++) {
                                if (i11 != 0) {
                                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                }
                                sb2.append((String) list.get(i11));
                            }
                        }
                        sb2.append(";");
                    }
                    hf a11 = a((String) null, aj.a(), gq.NotificationRemoved.f2942a, (String) null);
                    a11.a("removed_reason", String.valueOf(num));
                    a11.a("all_delete_msgId_appId", sb2.toString());
                    b.b("UNDatas upload all removed messages reason: " + num + " allIds: " + sb2.toString());
                    a(f52547a, a11);
                }
                f3381a.remove(num);
            }
        }
    }

    public void a() {
        Map<Integer, Map<String, List<String>>> map = f3381a;
        if (map.size() > 0) {
            synchronized (map) {
                b();
            }
        }
    }

    private static void a(Context context, final hf hfVar) {
        if (f3382a) {
            b.b("UNDatas upload message notification:" + hfVar);
        }
        af.a(context).a((Runnable) new Runnable() {
            public void run() {
                byte[] a11 = hq.a(w.a(hfVar.d(), hfVar.b(), hfVar, gg.Notification));
                if (bd.a() instanceof XMPushService) {
                    ((XMPushService) bd.a()).a(hfVar.d(), a11, true);
                } else {
                    b.a("UNDatas UploadNotificationDatas failed because not xmsf");
                }
            }
        });
    }

    private static hf a(String str, String str2, String str3, String str4) {
        hf hfVar = new hf();
        if (str3 != null) {
            hfVar.c(str3);
        }
        if (str != null) {
            hfVar.b(str);
        }
        if (str2 != null) {
            hfVar.a(str2);
        }
        if (str4 != null) {
            hfVar.d(str4);
        }
        hfVar.a(false);
        return hfVar;
    }
}
