package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.aa;
import com.xiaomi.push.af;
import com.xiaomi.push.ao;
import com.xiaomi.push.bc;
import com.xiaomi.push.g;
import com.xiaomi.push.gg;
import com.xiaomi.push.gl;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.hf;
import com.xiaomi.push.i;
import com.xiaomi.push.j;
import com.xiaomi.push.l;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.aj;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class w {
    /* access modifiers changed from: private */
    public static String c(List<String> list) {
        String a11 = bc.a(d(list));
        return (TextUtils.isEmpty(a11) || a11.length() <= 4) ? "" : a11.substring(0, 4).toLowerCase();
    }

    /* access modifiers changed from: private */
    public static String d(List<String> list) {
        String str = "";
        if (aa.a(list)) {
            return str;
        }
        ArrayList<String> arrayList = new ArrayList<>(list);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                str = str + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
            str = str + str2;
        }
        return str;
    }

    public static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j11 = sharedPreferences.getLong("last_sync_info", -1);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long a11 = (long) ah.a(context).a(gl.SyncInfoFrequency.a(), 1209600);
        if (j11 == -1) {
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        } else if (Math.abs(currentTimeMillis - j11) > a11) {
            a(context, true);
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        }
    }

    public static void a(final Context context, final boolean z11) {
        af.a(context).a((Runnable) new Runnable() {
            public void run() {
                b.a("do sync info");
                hf hfVar = new hf(aj.a(), false);
                b a11 = b.a(context);
                hfVar.c(gq.SyncInfo.f2942a);
                hfVar.b(a11.a());
                hfVar.d(context.getPackageName());
                HashMap hashMap = new HashMap();
                hfVar.f3081a = hashMap;
                Context context = context;
                l.a((Map<String, String>) hashMap, Constants.EXTRA_KEY_APP_VERSION, g.a(context, context.getPackageName()));
                Map<String, String> map = hfVar.f3081a;
                Context context2 = context;
                l.a(map, "app_version_code", Integer.toString(g.a(context2, context2.getPackageName())));
                l.a(hfVar.f3081a, "push_sdk_vn", "6_0_1-C");
                l.a(hfVar.f3081a, "push_sdk_vc", Integer.toString(60001));
                l.a(hfVar.f3081a, "token", a11.b());
                if (!j.d()) {
                    String a12 = bc.a(i.b(context));
                    String d11 = i.d(context);
                    if (!TextUtils.isEmpty(d11)) {
                        a12 = a12 + Constants.ACCEPT_TIME_SEPARATOR_SP + d11;
                    }
                    if (!TextUtils.isEmpty(a12)) {
                        l.a(hfVar.f3081a, Constants.EXTRA_KEY_IMEI_MD5, a12);
                    }
                }
                ao.a(context).a(hfVar.f3081a);
                l.a(hfVar.f3081a, Constants.EXTRA_KEY_REG_ID, a11.c());
                l.a(hfVar.f3081a, Constants.EXTRA_KEY_REG_SECRET, a11.d());
                l.a(hfVar.f3081a, "accept_time", MiPushClient.getAcceptTime(context).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
                if (z11) {
                    l.a(hfVar.f3081a, Constants.EXTRA_KEY_ALIASES_MD5, w.c(MiPushClient.getAllAlias(context)));
                    l.a(hfVar.f3081a, Constants.EXTRA_KEY_TOPICS_MD5, w.c(MiPushClient.getAllTopic(context)));
                    l.a(hfVar.f3081a, Constants.EXTRA_KEY_ACCOUNTS_MD5, w.c(MiPushClient.getAllUserAccount(context)));
                } else {
                    l.a(hfVar.f3081a, Constants.EXTRA_KEY_ALIASES, w.d(MiPushClient.getAllAlias(context)));
                    l.a(hfVar.f3081a, Constants.EXTRA_KEY_TOPICS, w.d(MiPushClient.getAllTopic(context)));
                    l.a(hfVar.f3081a, Constants.EXTRA_KEY_ACCOUNTS, w.d(MiPushClient.getAllUserAccount(context)));
                }
                u.a(context).a(hfVar, gg.Notification, false, (gt) null);
            }
        });
    }

    public static void a(Context context, hf hfVar) {
        b.a("need to update local info with: " + hfVar.a());
        String str = (String) hfVar.a().get("accept_time");
        if (str != null) {
            MiPushClient.removeAcceptTime(context);
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length == 2) {
                MiPushClient.addAcceptTime(context, split[0], split[1]);
                if (!"00:00".equals(split[0]) || !"00:00".equals(split[1])) {
                    b.a(context).a(false);
                } else {
                    b.a(context).a(true);
                }
            }
        }
        String str2 = (String) hfVar.a().get(Constants.EXTRA_KEY_ALIASES);
        if (str2 != null) {
            MiPushClient.removeAllAliases(context);
            if (!"".equals(str2)) {
                for (String addAlias : str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    MiPushClient.addAlias(context, addAlias);
                }
            }
        }
        String str3 = (String) hfVar.a().get(Constants.EXTRA_KEY_TOPICS);
        if (str3 != null) {
            MiPushClient.removeAllTopics(context);
            if (!"".equals(str3)) {
                for (String addTopic : str3.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    MiPushClient.addTopic(context, addTopic);
                }
            }
        }
        String str4 = (String) hfVar.a().get(Constants.EXTRA_KEY_ACCOUNTS);
        if (str4 != null) {
            MiPushClient.removeAllAccounts(context);
            if (!"".equals(str4)) {
                for (String addAccount : str4.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    MiPushClient.addAccount(context, addAccount);
                }
            }
        }
    }
}
