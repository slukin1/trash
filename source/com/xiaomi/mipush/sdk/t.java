package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.pro.core.util.Period;
import com.sumsub.sns.internal.core.analytics.d;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.bc;
import com.xiaomi.push.bo;
import com.xiaomi.push.ct;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.ee;
import com.xiaomi.push.g;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.gs;
import com.xiaomi.push.gt;
import com.xiaomi.push.gu;
import com.xiaomi.push.gw;
import com.xiaomi.push.gx;
import com.xiaomi.push.hb;
import com.xiaomi.push.hc;
import com.xiaomi.push.hd;
import com.xiaomi.push.he;
import com.xiaomi.push.hf;
import com.xiaomi.push.hh;
import com.xiaomi.push.hj;
import com.xiaomi.push.hl;
import com.xiaomi.push.hn;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.hv;
import com.xiaomi.push.p;
import com.xiaomi.push.service.ag;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.ai;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.au;
import com.xiaomi.push.service.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

public class t {

    /* renamed from: a  reason: collision with root package name */
    private static t f51335a;

    /* renamed from: a  reason: collision with other field name */
    private static Object f2477a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Queue<String> f2478a;

    /* renamed from: a  reason: collision with other field name */
    private Context f2479a;

    /* renamed from: com.xiaomi.mipush.sdk.t$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51336a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.xiaomi.push.gg[] r0 = com.xiaomi.push.gg.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f51336a = r0
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.SendMessage     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f51336a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.Registration     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f51336a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.UnRegistration     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f51336a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.Subscription     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f51336a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.UnSubscription     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f51336a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.Command     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f51336a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.Notification     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.t.AnonymousClass1.<clinit>():void");
        }
    }

    private t(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f2479a = applicationContext;
        if (applicationContext == null) {
            this.f2479a = context;
        }
    }

    public static t a(Context context) {
        if (f51335a == null) {
            f51335a = new t(context);
        }
        return f51335a;
    }

    private void b(gx gxVar) {
        b.c("ASSEMBLE_PUSH : " + gxVar.toString());
        String a11 = gxVar.a();
        Map a12 = gxVar.a();
        if (a12 != null) {
            String str = (String) a12.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("brand:" + q.FCM.name())) {
                    b.a("ASSEMBLE_PUSH : receive fcm token sync ack");
                    Context context = this.f2479a;
                    d dVar = d.ASSEMBLE_PUSH_FCM;
                    f.b(context, dVar, str);
                    a(a11, gxVar.f3020a, dVar);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("brand:");
                q qVar = q.HUAWEI;
                sb2.append(qVar.name());
                if (!str.contains(sb2.toString())) {
                    if (!str.contains("channel:" + qVar.name())) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("brand:");
                        q qVar2 = q.OPPO;
                        sb3.append(qVar2.name());
                        if (!str.contains(sb3.toString())) {
                            if (!str.contains("channel:" + qVar2.name())) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("brand:");
                                q qVar3 = q.VIVO;
                                sb4.append(qVar3.name());
                                if (!str.contains(sb4.toString())) {
                                    if (!str.contains("channel:" + qVar3.name())) {
                                        return;
                                    }
                                }
                                b.a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                                Context context2 = this.f2479a;
                                d dVar2 = d.ASSEMBLE_PUSH_FTOS;
                                f.b(context2, dVar2, str);
                                a(a11, gxVar.f3020a, dVar2);
                                return;
                            }
                        }
                        b.a("ASSEMBLE_PUSH : receive COS token sync ack");
                        Context context3 = this.f2479a;
                        d dVar3 = d.ASSEMBLE_PUSH_COS;
                        f.b(context3, dVar3, str);
                        a(a11, gxVar.f3020a, dVar3);
                        return;
                    }
                }
                b.a("ASSEMBLE_PUSH : receive hw token sync ack");
                Context context4 = this.f2479a;
                d dVar4 = d.ASSEMBLE_PUSH_HUAWEI;
                f.b(context4, dVar4, str);
                a(a11, gxVar.f3020a, dVar4);
            }
        }
    }

    public PushMessageHandler.a a(Intent intent) {
        Intent intent2 = intent;
        String action = intent.getAction();
        b.a("receive an intent from server, action=" + action);
        String stringExtra = intent2.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent2.getStringExtra("messageId");
        int intExtra = intent2.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent2.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent2.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                b.d("receiving an empty message, drop");
                du.a(this.f2479a).a(this.f2479a.getPackageName(), intent2, "12");
                return null;
            }
            hc hcVar = new hc();
            try {
                hq.a(hcVar, byteArrayExtra);
                b a11 = b.a(this.f2479a);
                gt a12 = hcVar.a();
                gg a13 = hcVar.a();
                gg ggVar = gg.SendMessage;
                if (a13 == ggVar && a12 != null && !a11.e() && !booleanExtra) {
                    a12.a("mrt", stringExtra);
                    a12.a("mat", Long.toString(System.currentTimeMillis()));
                    if (!a(hcVar)) {
                        b(hcVar);
                    } else {
                        b.b("this is a mina's message, ack later");
                        a12.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(a12.a()));
                        a12.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf(hq.a(this.f2479a, hcVar)));
                    }
                }
                String str = "";
                if (hcVar.a() == ggVar) {
                    if (!hcVar.b()) {
                        if (x.a(hcVar)) {
                            Object[] objArr = new Object[2];
                            objArr[0] = hcVar.b();
                            if (a12 != null) {
                                str = a12.a();
                            }
                            objArr[1] = str;
                            b.a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                            du.a(this.f2479a).a(this.f2479a.getPackageName(), intent2, String.format("13: %1$s", new Object[]{hcVar.b()}));
                        } else {
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = hcVar.b();
                            if (a12 != null) {
                                str = a12.a();
                            }
                            objArr2[1] = str;
                            b.a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                            du.a(this.f2479a).a(this.f2479a.getPackageName(), intent2, String.format("14: %1$s", new Object[]{hcVar.b()}));
                        }
                        j.a(this.f2479a, hcVar, intent2, booleanExtra);
                        return null;
                    }
                }
                if (hcVar.a() == ggVar && hcVar.b() && x.a(hcVar)) {
                    if (!booleanExtra || a12 == null || a12.a() == null || !a12.a().containsKey("notify_effect")) {
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = hcVar.b();
                        if (a12 != null) {
                            str = a12.a();
                        }
                        objArr3[1] = str;
                        b.a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                        du.a(this.f2479a).a(this.f2479a.getPackageName(), intent2, String.format("25: %1$s", new Object[]{hcVar.b()}));
                        j.b(this.f2479a, hcVar, intent2, booleanExtra);
                        return null;
                    }
                }
                if (a11.c() || hcVar.f3062a == gg.Registration) {
                    if (!a11.c() || !a11.f()) {
                        return a(hcVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    }
                    if (hcVar.f3062a != gg.UnRegistration) {
                        j.f(this.f2479a, hcVar, intent2, booleanExtra);
                        MiPushClient.unregisterPush(this.f2479a);
                    } else if (hcVar.b()) {
                        a11.a();
                        MiPushClient.clearExtras(this.f2479a);
                        PushMessageHandler.a();
                    } else {
                        b.d("receiving an un-encrypt unregistration message");
                    }
                } else if (x.a(hcVar)) {
                    return a(hcVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                } else {
                    j.f(this.f2479a, hcVar, intent2, booleanExtra);
                    boolean d11 = a11.d();
                    b.d("receive message without registration. need re-register!registered?" + d11);
                    du.a(this.f2479a).a(this.f2479a.getPackageName(), intent2, "15");
                    if (d11) {
                        a();
                    }
                }
            } catch (hv e11) {
                du.a(this.f2479a).a(this.f2479a.getPackageName(), intent2, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_HUOBI_EARN);
                b.a((Throwable) e11);
            } catch (Exception e12) {
                du.a(this.f2479a).a(this.f2479a.getPackageName(), intent2, "17");
                b.a((Throwable) e12);
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            hc hcVar2 = new hc();
            try {
                byte[] byteArrayExtra2 = intent2.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    hq.a(hcVar2, byteArrayExtra2);
                }
            } catch (hv unused) {
            }
            miPushCommandMessage.setCommand(String.valueOf(hcVar2.a()));
            miPushCommandMessage.setResultCode((long) intent2.getIntExtra("mipush_error_code", 0));
            miPushCommandMessage.setReason(intent2.getStringExtra("mipush_error_msg"));
            b.d("receive a error message. code = " + intent2.getIntExtra("mipush_error_code", 0) + ", msg= " + intent2.getStringExtra("mipush_error_msg"));
            return miPushCommandMessage;
        } else if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
            byte[] byteArrayExtra3 = intent2.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra3 == null) {
                b.d("message arrived: receiving an empty message, drop");
                return null;
            }
            hc hcVar3 = new hc();
            try {
                hq.a(hcVar3, byteArrayExtra3);
                b a14 = b.a(this.f2479a);
                if (x.a(hcVar3)) {
                    b.d("message arrived: receive ignore reg message, ignore!");
                } else if (!a14.c()) {
                    b.d("message arrived: receive message without registration. need unregister or re-register!");
                } else if (!a14.c() || !a14.f()) {
                    return a(hcVar3, byteArrayExtra3);
                } else {
                    b.d("message arrived: app info is invalidated");
                }
            } catch (Exception e13) {
                b.d("fail to deal with arrived message. " + e13);
            }
        }
        return null;
    }

    private void b(hc hcVar) {
        gt a11 = hcVar.a();
        if (a11 != null) {
            a11 = au.a(a11.a());
        }
        gw gwVar = new gw();
        gwVar.b(hcVar.a());
        gwVar.a(a11.a());
        gwVar.a(a11.a());
        if (!TextUtils.isEmpty(a11.b())) {
            gwVar.c(a11.b());
        }
        gwVar.a(hq.a(this.f2479a, hcVar));
        u.a(this.f2479a).a(gwVar, gg.AckMessage, false, a11);
    }

    private void b(hf hfVar) {
        Map a11 = hfVar.a();
        if (a11 == null) {
            b.a("detect failed because null");
            return;
        }
        String str = (String) ag.a((Object) a11, "pkgList", null);
        if (TextUtils.isEmpty(str)) {
            b.a("detect failed because empty");
            return;
        }
        Map a12 = g.a(this.f2479a, str);
        if (a12 != null) {
            String str2 = (String) a12.get("alive");
            String str3 = (String) a12.get("notAlive");
            if (!TextUtils.isEmpty(str2)) {
                hf hfVar2 = new hf();
                hfVar2.a(hfVar.a());
                hfVar2.b(hfVar.b());
                hfVar2.d(hfVar.d());
                hfVar2.c(gq.DetectAppAliveResult.f2942a);
                HashMap hashMap = new HashMap();
                hfVar2.f3081a = hashMap;
                hashMap.put("alive", str2);
                if (Boolean.parseBoolean((String) ag.a((Object) a11, "reportNotAliveApp", d.f31895b)) && !TextUtils.isEmpty(str3)) {
                    hfVar2.f3081a.put("notAlive", str3);
                }
                u.a(this.f2479a).a(hfVar2, gg.Notification, false, (gt) null);
                return;
            }
            b.b("detect failed because no alive process");
            return;
        }
        b.a("detect failed because get status illegal");
    }

    private PushMessageHandler.a a(hc hcVar, byte[] bArr) {
        String str = null;
        try {
            hr a11 = r.a(this.f2479a, hcVar);
            if (a11 == null) {
                b.d("message arrived: receiving an un-recognized message. " + hcVar.f3062a);
                return null;
            }
            gg a12 = hcVar.a();
            b.a("message arrived: processing an arrived message, action=" + a12);
            if (AnonymousClass1.f51336a[a12.ordinal()] != 1) {
                return null;
            }
            if (!hcVar.b()) {
                b.d("message arrived: receiving an un-encrypt message(SendMessage).");
                return null;
            }
            hj hjVar = (hj) a11;
            gs a13 = hjVar.a();
            if (a13 == null) {
                b.d("message arrived: receive an empty message without push content, drop it");
                return null;
            }
            gt gtVar = hcVar.f3063a;
            if (!(gtVar == null || gtVar.a() == null)) {
                str = hcVar.f3063a.f2977a.get("jobkey");
            }
            MiPushMessage generateMessage = PushMessageHelper.generateMessage(hjVar, hcVar.a(), false);
            generateMessage.setArrivedMessage(true);
            b.a("message arrived: receive a message, msgid=" + a13.a() + ", jobkey=" + str);
            return generateMessage;
        } catch (l e11) {
            b.a((Throwable) e11);
            b.d("message arrived: receive a message but decrypt failed. report when click.");
            return null;
        } catch (hv e12) {
            b.a((Throwable) e12);
            b.d("message arrived: receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    private PushMessageHandler.a a(hc hcVar, boolean z11, byte[] bArr, String str, int i11, Intent intent) {
        String str2;
        String str3;
        MiPushMessage miPushMessage;
        boolean z12;
        boolean z13;
        gt gtVar;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        hc hcVar2 = hcVar;
        boolean z14 = z11;
        byte[] bArr2 = bArr;
        String str4 = str;
        int i12 = i11;
        Intent intent2 = intent;
        Class<p> cls = p.class;
        try {
            hr a11 = r.a(this.f2479a, hcVar2);
            if (a11 == null) {
                b.d("receiving an un-recognized message. " + hcVar2.f3062a);
                du.a(this.f2479a).b(this.f2479a.getPackageName(), dt.a(i11), str4, "18");
                j.c(this.f2479a, hcVar2, intent2, z14);
                return null;
            }
            gg a12 = hcVar.a();
            b.a("processing a message, action=", a12, ", hasNotified=", Boolean.valueOf(z11));
            switch (AnonymousClass1.f51336a[a12.ordinal()]) {
                case 1:
                    if (!hcVar.b()) {
                        b.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    } else if (!b.a(this.f2479a).e() || z14) {
                        hj hjVar = (hj) a11;
                        gs a13 = hjVar.a();
                        if (a13 == null) {
                            b.d("receive an empty message without push content, drop it");
                            du.a(this.f2479a).b(this.f2479a.getPackageName(), dt.a(i11), str4, "22");
                            j.d(this.f2479a, hcVar2, intent2, z14);
                            return null;
                        }
                        int intExtra = intent2.getIntExtra("notification_click_button", 0);
                        if (z14) {
                            if (x.a(hcVar)) {
                                MiPushClient.reportIgnoreRegMessageClicked(this.f2479a, a13.a(), hcVar.a(), hcVar2.f3069b, a13.b());
                            } else {
                                if (hcVar.a() != null) {
                                    gtVar = new gt(hcVar.a());
                                } else {
                                    gtVar = new gt();
                                }
                                if (gtVar.a() == null) {
                                    gtVar.a((Map<String, String>) new HashMap());
                                }
                                gtVar.a().put("notification_click_button", String.valueOf(intExtra));
                                MiPushClient.reportMessageClicked(this.f2479a, a13.a(), gtVar, a13.b());
                            }
                        }
                        if (!z14) {
                            if (!TextUtils.isEmpty(hjVar.d()) && MiPushClient.aliasSetTime(this.f2479a, hjVar.d()) < 0) {
                                MiPushClient.addAlias(this.f2479a, hjVar.d());
                            } else if (!TextUtils.isEmpty(hjVar.c()) && MiPushClient.topicSubscribedTime(this.f2479a, hjVar.c()) < 0) {
                                MiPushClient.addTopic(this.f2479a, hjVar.c());
                            }
                        }
                        gt gtVar2 = hcVar2.f3063a;
                        if (gtVar2 == null || gtVar2.a() == null) {
                            str3 = null;
                            str2 = null;
                        } else {
                            str3 = hcVar2.f3063a.f2977a.get("jobkey");
                            str2 = str3;
                        }
                        if (TextUtils.isEmpty(str3)) {
                            str3 = a13.a();
                        }
                        if (z14 || !a(this.f2479a, str3)) {
                            MiPushMessage generateMessage = PushMessageHelper.generateMessage(hjVar, hcVar.a(), z14);
                            if (generateMessage.getPassThrough() != 0 || z14 || !x.a(generateMessage.getExtra())) {
                                String a14 = x.a(generateMessage.getExtra(), intExtra);
                                b.a("receive a message, msgid=", a13.a(), ", jobkey=", str3, ", btn=", Integer.valueOf(intExtra), ", typeId=", a14, ", hasNotified=", Boolean.valueOf(z11));
                                if (!z14 || generateMessage.getExtra() == null || TextUtils.isEmpty(a14)) {
                                    miPushMessage = generateMessage;
                                } else {
                                    Map<String, String> extra = generateMessage.getExtra();
                                    if (!(intExtra == 0 || hcVar.a() == null)) {
                                        u.a(this.f2479a).a(hcVar.a().c(), intExtra);
                                    }
                                    if (x.a(hcVar)) {
                                        Intent a15 = a(this.f2479a, hcVar2.f3069b, extra, intExtra);
                                        if (a15 == null) {
                                            j.e(this.f2479a, hcVar2, intent2, true);
                                            b.a("Getting Intent fail from ignore reg message. ");
                                            du.a(this.f2479a).b(this.f2479a.getPackageName(), dt.a(i11), str4, "23");
                                            return null;
                                        }
                                        a15.putExtra("eventMessageType", i12);
                                        a15.putExtra("messageId", str4);
                                        a15.putExtra("jobkey", str2);
                                        Bundle extras = a15.getExtras();
                                        if (!a(extras, "pushTargetComponent")) {
                                            z13 = true;
                                            a15.putExtra("pushTargetComponent", true);
                                        } else {
                                            z13 = true;
                                        }
                                        if (!a(extras, "mipush_notified")) {
                                            a15.putExtra("mipush_notified", z13);
                                        }
                                        String c11 = a13.c();
                                        if (!TextUtils.isEmpty(c11)) {
                                            a15.putExtra("payload", c11);
                                        }
                                        long currentTimeMillis = System.currentTimeMillis();
                                        this.f2479a.startActivity(a15);
                                        j.a(this.f2479a, hcVar2, intent2, currentTimeMillis);
                                        du.a(this.f2479a).a(this.f2479a.getPackageName(), dt.a(i11), str, 3006, a14);
                                        b.a("PushMessageProcessor", "start business activity succ");
                                    } else {
                                        Context context = this.f2479a;
                                        Intent a16 = a(context, context.getPackageName(), extra, intExtra);
                                        if (a16 != null) {
                                            if (!a14.equals(an.f52486c)) {
                                                a16.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                                a16.putExtra("eventMessageType", i12);
                                                a16.putExtra("messageId", str4);
                                                a16.putExtra("jobkey", str2);
                                                Bundle extras2 = a16.getExtras();
                                                if (!a(extras2, "pushTargetComponent")) {
                                                    z12 = true;
                                                    a16.putExtra("pushTargetComponent", true);
                                                } else {
                                                    z12 = true;
                                                }
                                                if (!a(extras2, "mipush_notified")) {
                                                    a16.putExtra("mipush_notified", z12);
                                                }
                                            }
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            this.f2479a.startActivity(a16);
                                            j.a(this.f2479a, hcVar2, intent2, currentTimeMillis2);
                                            b.a("PushMessageProcessor", "start activity succ");
                                            du.a(this.f2479a).a(this.f2479a.getPackageName(), dt.a(i11), str, 1006, a14);
                                            if (a14.equals(an.f52486c)) {
                                                du.a(this.f2479a).a(this.f2479a.getPackageName(), dt.a(i11), str4, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT);
                                            }
                                        } else {
                                            j.e(this.f2479a, hcVar2, intent2, true);
                                            b.d("PushMessageProcessor", "missing target intent for message: " + a13.a() + ", typeId=" + a14);
                                        }
                                    }
                                    b.a("PushMessageProcessor", "pre-def msg process done.");
                                    return null;
                                }
                            } else {
                                x.a(this.f2479a, hcVar2, bArr2);
                                return null;
                            }
                        } else {
                            b.a("drop a duplicate message, key=" + str3);
                            du a17 = du.a(this.f2479a);
                            String packageName = this.f2479a.getPackageName();
                            String a18 = dt.a(i11);
                            a17.c(packageName, a18, str4, "2:" + str3);
                            miPushMessage = null;
                        }
                        if (hcVar.a() == null && !z14) {
                            a(hjVar, hcVar2);
                        }
                        return miPushMessage;
                    } else {
                        b.a("receive a message in pause state. drop it");
                        du.a(this.f2479a).a(this.f2479a.getPackageName(), dt.a(i11), str4, "12");
                        return null;
                    }
                case 2:
                    hh hhVar = (hh) a11;
                    String str5 = b.a(this.f2479a).f2455a;
                    if (TextUtils.isEmpty(str5) || !TextUtils.equals(str5, hhVar.a())) {
                        b.a("bad Registration result:");
                        du.a(this.f2479a).b(this.f2479a.getPackageName(), dt.a(i11), str4, "21");
                        return null;
                    }
                    long a19 = u.a(this.f2479a).a();
                    if (a19 <= 0 || SystemClock.elapsedRealtime() - a19 <= Period.MIN15_MILLS) {
                        b.a(this.f2479a).f2455a = null;
                        if (hhVar.f3125a == 0) {
                            b.a(this.f2479a).b(hhVar.f3137e, hhVar.f3138f, hhVar.f3144l);
                            FCMPushHelper.persistIfXmsfSupDecrypt(this.f2479a);
                            du.a(this.f2479a).a(this.f2479a.getPackageName(), dt.a(i11), str, 6006, "1");
                        } else {
                            du.a(this.f2479a).a(this.f2479a.getPackageName(), dt.a(i11), str, 6006, "2");
                        }
                        if (!TextUtils.isEmpty(hhVar.f3137e)) {
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(hhVar.f3137e);
                            arrayList = arrayList4;
                        } else {
                            arrayList = null;
                        }
                        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ee.COMMAND_REGISTER.f2769a, arrayList, hhVar.f3125a, hhVar.f3136d, (String) null, hhVar.a());
                        u.a(this.f2479a).d();
                        return generateCommandMessage;
                    }
                    b.a("The received registration result has expired.");
                    du.a(this.f2479a).b(this.f2479a.getPackageName(), dt.a(i11), str4, "26");
                    return null;
                case 3:
                    if (!hcVar.b()) {
                        b.d("receiving an un-encrypt message(UnRegistration).");
                        return null;
                    }
                    if (((hn) a11).f3203a == 0) {
                        b.a(this.f2479a).a();
                        MiPushClient.clearExtras(this.f2479a);
                    }
                    PushMessageHandler.a();
                    return null;
                case 4:
                    hl hlVar = (hl) a11;
                    if (hlVar.f3178a == 0) {
                        MiPushClient.addTopic(this.f2479a, hlVar.b());
                    }
                    if (!TextUtils.isEmpty(hlVar.b())) {
                        ArrayList arrayList5 = new ArrayList();
                        arrayList5.add(hlVar.b());
                        arrayList2 = arrayList5;
                    } else {
                        arrayList2 = null;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("resp-cmd:");
                    ee eeVar = ee.COMMAND_SUBSCRIBE_TOPIC;
                    sb2.append(eeVar);
                    sb2.append(", ");
                    sb2.append(hlVar.a());
                    b.e(sb2.toString());
                    return PushMessageHelper.generateCommandMessage(eeVar.f2769a, arrayList2, hlVar.f3178a, hlVar.f3184d, hlVar.c(), (List<String>) null);
                case 5:
                    hp hpVar = (hp) a11;
                    if (hpVar.f3223a == 0) {
                        MiPushClient.removeTopic(this.f2479a, hpVar.b());
                    }
                    if (!TextUtils.isEmpty(hpVar.b())) {
                        ArrayList arrayList6 = new ArrayList();
                        arrayList6.add(hpVar.b());
                        arrayList3 = arrayList6;
                    } else {
                        arrayList3 = null;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("resp-cmd:");
                    ee eeVar2 = ee.COMMAND_UNSUBSCRIBE_TOPIC;
                    sb3.append(eeVar2);
                    sb3.append(", ");
                    sb3.append(hpVar.a());
                    b.e(sb3.toString());
                    return PushMessageHelper.generateCommandMessage(eeVar2.f2769a, arrayList3, hpVar.f3223a, hpVar.f3229d, hpVar.c(), (List<String>) null);
                case 6:
                    ct.a(this.f2479a.getPackageName(), this.f2479a, a11, gg.Command, bArr2.length);
                    hb hbVar = (hb) a11;
                    String b11 = hbVar.b();
                    List<String> a21 = hbVar.a();
                    if (hbVar.f3050a == 0) {
                        if (TextUtils.equals(b11, ee.COMMAND_SET_ACCEPT_TIME.f2769a) && a21 != null && a21.size() > 1) {
                            MiPushClient.addAcceptTime(this.f2479a, a21.get(0), a21.get(1));
                            if (!"00:00".equals(a21.get(0)) || !"00:00".equals(a21.get(1))) {
                                b.a(this.f2479a).a(false);
                            } else {
                                b.a(this.f2479a).a(true);
                            }
                            a21 = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), a21);
                        } else if (TextUtils.equals(b11, ee.COMMAND_SET_ALIAS.f2769a) && a21 != null && a21.size() > 0) {
                            MiPushClient.addAlias(this.f2479a, a21.get(0));
                        } else if (TextUtils.equals(b11, ee.COMMAND_UNSET_ALIAS.f2769a) && a21 != null && a21.size() > 0) {
                            MiPushClient.removeAlias(this.f2479a, a21.get(0));
                        } else if (TextUtils.equals(b11, ee.COMMAND_SET_ACCOUNT.f2769a) && a21 != null && a21.size() > 0) {
                            MiPushClient.addAccount(this.f2479a, a21.get(0));
                        } else if (TextUtils.equals(b11, ee.COMMAND_UNSET_ACCOUNT.f2769a) && a21 != null && a21.size() > 0) {
                            MiPushClient.removeAccount(this.f2479a, a21.get(0));
                        } else if (TextUtils.equals(b11, ee.COMMAND_CHK_VDEVID.f2769a)) {
                            return null;
                        }
                    }
                    List<String> list = a21;
                    b.e("resp-cmd:" + b11 + ", " + hbVar.a());
                    long j11 = hbVar.f3050a;
                    return PushMessageHelper.generateCommandMessage(b11, list, j11, hbVar.f3058d, hbVar.c(), (List<String>) null);
                case 7:
                    ct.a(this.f2479a.getPackageName(), this.f2479a, a11, gg.Notification, bArr2.length);
                    if (a11 instanceof gx) {
                        gx gxVar = (gx) a11;
                        String a22 = gxVar.a();
                        b.e("resp-type:" + gxVar.b() + ", code:" + gxVar.f3020a + ", " + a22);
                        if (gq.DisablePushMessage.f2942a.equalsIgnoreCase(gxVar.f3027d)) {
                            if (gxVar.f3020a == 0) {
                                synchronized (cls) {
                                    if (p.a(this.f2479a).a(a22)) {
                                        p.a(this.f2479a).c(a22);
                                        p a23 = p.a(this.f2479a);
                                        v vVar = v.DISABLE_PUSH;
                                        if ("syncing".equals(a23.a(vVar))) {
                                            p.a(this.f2479a).a(vVar, "synced");
                                            MiPushClient.clearNotification(this.f2479a);
                                            MiPushClient.clearLocalNotificationType(this.f2479a);
                                            PushMessageHandler.a();
                                            u.a(this.f2479a).b();
                                        }
                                    }
                                }
                                return null;
                            } else if ("syncing".equals(p.a(this.f2479a).a(v.DISABLE_PUSH))) {
                                synchronized (cls) {
                                    if (p.a(this.f2479a).a(a22)) {
                                        if (p.a(this.f2479a).a(a22) < 10) {
                                            p.a(this.f2479a).b(a22);
                                            u.a(this.f2479a).a(true, a22);
                                        } else {
                                            p.a(this.f2479a).c(a22);
                                        }
                                    }
                                }
                                return null;
                            } else {
                                p.a(this.f2479a).c(a22);
                                return null;
                            }
                        } else if (gq.EnablePushMessage.f2942a.equalsIgnoreCase(gxVar.f3027d)) {
                            if (gxVar.f3020a == 0) {
                                synchronized (cls) {
                                    if (p.a(this.f2479a).a(a22)) {
                                        p.a(this.f2479a).c(a22);
                                        p a24 = p.a(this.f2479a);
                                        v vVar2 = v.ENABLE_PUSH;
                                        if ("syncing".equals(a24.a(vVar2))) {
                                            p.a(this.f2479a).a(vVar2, "synced");
                                        }
                                    }
                                }
                                return null;
                            } else if ("syncing".equals(p.a(this.f2479a).a(v.ENABLE_PUSH))) {
                                synchronized (cls) {
                                    if (p.a(this.f2479a).a(a22)) {
                                        if (p.a(this.f2479a).a(a22) < 10) {
                                            p.a(this.f2479a).b(a22);
                                            u.a(this.f2479a).a(false, a22);
                                        } else {
                                            p.a(this.f2479a).c(a22);
                                        }
                                    }
                                }
                                return null;
                            } else {
                                p.a(this.f2479a).c(a22);
                                return null;
                            }
                        } else if (gq.ThirdPartyRegUpdate.f2942a.equalsIgnoreCase(gxVar.f3027d)) {
                            b(gxVar);
                            return null;
                        } else if (!gq.UploadTinyData.f2942a.equalsIgnoreCase(gxVar.f3027d)) {
                            return null;
                        } else {
                            a(gxVar);
                            return null;
                        }
                    } else if (!(a11 instanceof hf)) {
                        return null;
                    } else {
                        hf hfVar = (hf) a11;
                        if ("registration id expired".equalsIgnoreCase(hfVar.f3086d)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f2479a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f2479a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f2479a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f2479a);
                            b.e("resp-type:" + hfVar.f3086d + ", " + hfVar.a());
                            MiPushClient.reInitialize(this.f2479a, gu.RegIdExpired);
                            for (String next : allAlias) {
                                MiPushClient.removeAlias(this.f2479a, next);
                                MiPushClient.setAlias(this.f2479a, next, (String) null);
                            }
                            for (String next2 : allTopic) {
                                MiPushClient.removeTopic(this.f2479a, next2);
                                MiPushClient.subscribe(this.f2479a, next2, (String) null);
                            }
                            for (String next3 : allUserAccount) {
                                MiPushClient.removeAccount(this.f2479a, next3);
                                MiPushClient.setUserAccount(this.f2479a, next3, (String) null);
                            }
                            String[] split = acceptTime.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            if (split.length != 2) {
                                return null;
                            }
                            MiPushClient.removeAcceptTime(this.f2479a);
                            MiPushClient.addAcceptTime(this.f2479a, split[0], split[1]);
                            return null;
                        } else if (gq.ClientInfoUpdateOk.f2942a.equalsIgnoreCase(hfVar.f3086d)) {
                            if (hfVar.a() == null || !hfVar.a().containsKey(Constants.EXTRA_KEY_APP_VERSION)) {
                                return null;
                            }
                            b.a(this.f2479a).a((String) hfVar.a().get(Constants.EXTRA_KEY_APP_VERSION));
                            return null;
                        } else if (gq.NormalClientConfigUpdate.f2942a.equalsIgnoreCase(hfVar.f3086d)) {
                            he heVar = new he();
                            try {
                                hq.a(heVar, hfVar.a());
                                ai.a(ah.a(this.f2479a), heVar);
                                return null;
                            } catch (hv unused) {
                                return null;
                            }
                        } else if (gq.CustomClientConfigUpdate.f2942a.equalsIgnoreCase(hfVar.f3086d)) {
                            hd hdVar = new hd();
                            hq.a(hdVar, hfVar.a());
                            ai.a(ah.a(this.f2479a), hdVar);
                            return null;
                        } else if (gq.SyncInfoResult.f2942a.equalsIgnoreCase(hfVar.f3086d)) {
                            w.a(this.f2479a, hfVar);
                            return null;
                        } else if (gq.ForceSync.f2942a.equalsIgnoreCase(hfVar.f3086d)) {
                            b.a("receive force sync notification");
                            w.a(this.f2479a, false);
                            return null;
                        } else if (gq.CancelPushMessage.f2942a.equals(hfVar.f3086d)) {
                            b.e("resp-type:" + hfVar.f3086d + ", " + hfVar.a());
                            if (hfVar.a() != null) {
                                int i13 = -2;
                                if (hfVar.a().containsKey(an.R)) {
                                    String str6 = (String) hfVar.a().get(an.R);
                                    if (!TextUtils.isEmpty(str6)) {
                                        try {
                                            i13 = Integer.parseInt(str6);
                                        } catch (NumberFormatException e11) {
                                            e11.printStackTrace();
                                        }
                                    }
                                }
                                if (i13 >= -1) {
                                    MiPushClient.clearNotification(this.f2479a, i13);
                                } else {
                                    String str7 = "";
                                    String str8 = "";
                                    if (hfVar.a().containsKey(an.P)) {
                                        str7 = (String) hfVar.a().get(an.P);
                                    }
                                    if (hfVar.a().containsKey(an.Q)) {
                                        str8 = (String) hfVar.a().get(an.Q);
                                    }
                                    MiPushClient.clearNotification(this.f2479a, str7, str8);
                                }
                            }
                            a(hfVar);
                            return null;
                        } else if (gq.HybridRegisterResult.f2942a.equals(hfVar.f3086d)) {
                            try {
                                hh hhVar2 = new hh();
                                hq.a(hhVar2, hfVar.a());
                                MiPushClient4Hybrid.onReceiveRegisterResult(this.f2479a, hhVar2);
                                return null;
                            } catch (hv e12) {
                                b.a((Throwable) e12);
                                return null;
                            }
                        } else if (gq.HybridUnregisterResult.f2942a.equals(hfVar.f3086d)) {
                            try {
                                hn hnVar = new hn();
                                hq.a(hnVar, hfVar.a());
                                MiPushClient4Hybrid.onReceiveUnregisterResult(this.f2479a, hnVar);
                                return null;
                            } catch (hv e13) {
                                b.a((Throwable) e13);
                                return null;
                            }
                        } else if (gq.PushLogUpload.f2942a.equals(hfVar.f3086d)) {
                            return null;
                        } else {
                            if (gq.DetectAppAlive.f2942a.equals(hfVar.f3086d)) {
                                b.b("receive detect msg");
                                b(hfVar);
                                return null;
                            } else if (!com.xiaomi.push.service.g.a(hfVar)) {
                                return null;
                            } else {
                                b.b("receive notification handle by cpra");
                                return null;
                            }
                        }
                    }
                default:
                    return null;
            }
        } catch (l e14) {
            b.a((Throwable) e14);
            a(hcVar);
            du.a(this.f2479a).b(this.f2479a.getPackageName(), dt.a(i11), str4, "19");
            j.c(this.f2479a, hcVar2, intent2, z14);
            return null;
        } catch (hv e15) {
            b.a((Throwable) e15);
            b.d("receive a message which action string is not valid. is the reg expired?");
            du.a(this.f2479a).b(this.f2479a.getPackageName(), dt.a(i11), str4, "20");
            j.c(this.f2479a, hcVar2, intent2, z14);
            return null;
        }
    }

    private boolean a(Bundle bundle, String str) {
        if (bundle == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return bundle.containsKey(str);
    }

    private void a(String str, long j11, d dVar) {
        Class<p> cls = p.class;
        v a11 = g.a(dVar);
        if (a11 != null) {
            if (j11 == 0) {
                synchronized (cls) {
                    if (p.a(this.f2479a).a(str)) {
                        p.a(this.f2479a).c(str);
                        if ("syncing".equals(p.a(this.f2479a).a(a11))) {
                            p.a(this.f2479a).a(a11, "synced");
                        }
                    }
                }
            } else if ("syncing".equals(p.a(this.f2479a).a(a11))) {
                synchronized (cls) {
                    if (p.a(this.f2479a).a(str)) {
                        if (p.a(this.f2479a).a(str) < 10) {
                            p.a(this.f2479a).b(str);
                            u.a(this.f2479a).a(str, a11, dVar, "retry");
                        } else {
                            p.a(this.f2479a).c(str);
                        }
                    }
                }
            } else {
                p.a(this.f2479a).c(str);
            }
        }
    }

    private void a(gx gxVar) {
        String a11 = gxVar.a();
        b.b("receive ack " + a11);
        Map a12 = gxVar.a();
        if (a12 != null) {
            String str = (String) a12.get("real_source");
            if (!TextUtils.isEmpty(str)) {
                b.b("receive ack : messageId = " + a11 + "  realSource = " + str);
                bo.a(this.f2479a).a(a11, str, Boolean.valueOf(gxVar.f3020a == 0));
            }
        }
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        List<String> list2 = list;
        if (timeZone.equals(timeZone2)) {
            return list2;
        }
        long rawOffset = (long) (((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60);
        long parseLong = Long.parseLong(list2.get(0).split(":")[0]);
        long parseLong2 = Long.parseLong(list2.get(0).split(":")[1]);
        long j11 = ((((parseLong * 60) + parseLong2) - rawOffset) + 1440) % 1440;
        long parseLong3 = ((((Long.parseLong(list2.get(1).split(":")[0]) * 60) + Long.parseLong(list2.get(1).split(":")[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(j11 / 60), Long.valueOf(j11 % 60)}));
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(parseLong3 / 60), Long.valueOf(parseLong3 % 60)}));
        return arrayList;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f2479a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0)) > Period.MIN30_MILLS) {
            MiPushClient.reInitialize(this.f2479a, gu.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    private void a(hc hcVar) {
        b.a("receive a message but decrypt failed. report now.");
        hf hfVar = new hf(hcVar.a().f2975a, false);
        hfVar.c(gq.DecryptMessageFail.f2942a);
        hfVar.b(hcVar.a());
        hfVar.d(hcVar.f3069b);
        HashMap hashMap = new HashMap();
        hfVar.f3081a = hashMap;
        hashMap.put("regid", MiPushClient.getRegId(this.f2479a));
        u.a(this.f2479a).a(hfVar, gg.Notification, false, (gt) null);
    }

    private void a(hj hjVar, hc hcVar) {
        gt a11 = hcVar.a();
        if (a11 != null) {
            a11 = au.a(a11.a());
        }
        gw gwVar = new gw();
        gwVar.b(hjVar.b());
        gwVar.a(hjVar.a());
        gwVar.a(hjVar.a().a());
        if (!TextUtils.isEmpty(hjVar.c())) {
            gwVar.c(hjVar.c());
        }
        if (!TextUtils.isEmpty(hjVar.d())) {
            gwVar.d(hjVar.d());
        }
        gwVar.a(hq.a(this.f2479a, hcVar));
        u.a(this.f2479a).a(gwVar, gg.AckMessage, a11);
    }

    private void a(hf hfVar) {
        gx gxVar = new gx();
        gxVar.c(gq.CancelPushMessageACK.f2942a);
        gxVar.a(hfVar.a());
        gxVar.a(hfVar.a());
        gxVar.b(hfVar.b());
        gxVar.e(hfVar.d());
        gxVar.a(0);
        gxVar.d("success clear push message.");
        u.a(this.f2479a).a(gxVar, gg.Notification, false, true, (gt) null, false, this.f2479a.getPackageName(), b.a(this.f2479a).a(), false);
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m2365a(Context context, String str) {
        synchronized (f2477a) {
            b.a(context);
            SharedPreferences a11 = b.a(context);
            if (f2478a == null) {
                String[] split = a11.getString("pref_msg_ids", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                f2478a = new LinkedList();
                for (String add : split) {
                    f2478a.add(add);
                }
            }
            if (f2478a.contains(str)) {
                return true;
            }
            f2478a.add(str);
            if (f2478a.size() > 25) {
                f2478a.poll();
            }
            String a12 = bc.a((Collection<?>) f2478a, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor edit = a11.edit();
            edit.putString("pref_msg_ids", a12);
            p.a(edit);
            return false;
        }
    }

    public static void a(Context context, String str) {
        synchronized (f2477a) {
            f2478a.remove(str);
            b.a(context);
            SharedPreferences a11 = b.a(context);
            String a12 = bc.a((Collection<?>) f2478a, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor edit = a11.edit();
            edit.putString("pref_msg_ids", a12);
            p.a(edit);
        }
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i11) {
        return x.a(context, str, map, i11);
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m2366a(hc hcVar) {
        Map a11 = hcVar.a() == null ? null : hcVar.a().a();
        if (a11 == null) {
            return false;
        }
        String str = (String) a11.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
        if (TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE)) {
            return true;
        }
        return false;
    }
}
