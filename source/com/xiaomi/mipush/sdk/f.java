package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.google.firebase.messaging.FirebaseMessaging;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.af;
import com.xiaomi.push.av;
import com.xiaomi.push.ax;
import com.xiaomi.push.bb;
import com.xiaomi.push.hc;
import com.xiaomi.push.p;
import com.xiaomi.push.service.ah;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class f {

    /* renamed from: com.xiaomi.mipush.sdk.f$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51314a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.xiaomi.mipush.sdk.d[] r0 = com.xiaomi.mipush.sdk.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f51314a = r0
                com.xiaomi.mipush.sdk.d r1 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_HUAWEI     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f51314a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xiaomi.mipush.sdk.d r1 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_FCM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f51314a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xiaomi.mipush.sdk.d r1 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_COS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f51314a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xiaomi.mipush.sdk.d r1 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_FTOS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.f.AnonymousClass2.<clinit>():void");
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m2356a(Context context, d dVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            int a11 = a(context, dVar, str);
            if (a11 != 0) {
                b.a("ASSEMBLE_PUSH : send token upload, check:" + a11);
                a(context, str);
                v a12 = g.a(dVar);
                if (a12 != null) {
                    u.a(context).a((String) null, a12, dVar, "upload");
                    return;
                }
                return;
            }
            b.a("ASSEMBLE_PUSH : do not need to send token");
        }
    }

    public static void b(final Context context, final d dVar, final String str) {
        af.a(context).a((Runnable) new Runnable() {
            public void run() {
                String str;
                if (!TextUtils.isEmpty(str)) {
                    String[] split = str.split(Constants.WAVE_SEPARATOR);
                    int length = split.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            str = "";
                            break;
                        }
                        String str2 = split[i11];
                        if (!TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                            str = str2.substring(str2.indexOf(":") + 1);
                            break;
                        }
                        i11++;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        b.a("ASSEMBLE_PUSH : receive correct token");
                        f.d(context, dVar, str);
                        f.a(context);
                        return;
                    }
                    b.a("ASSEMBLE_PUSH : receive incorrect token");
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static synchronized void d(Context context, d dVar, String str) {
        synchronized (f.class) {
            String a11 = a(dVar);
            if (TextUtils.isEmpty(a11)) {
                b.a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(a11, str).putString("last_check_token", b.a(context).c());
            if (a(dVar)) {
                edit.putInt(b(dVar), a());
            }
            edit.putString("syncingToken", "");
            p.a(edit);
            b.a("ASSEMBLE_PUSH : update sp file success!  " + str);
        }
    }

    public static void b(Context context) {
        e.a(context).register();
    }

    public static void c(Context context) {
        e.a(context).unregister();
    }

    public static String b(d dVar) {
        return a(dVar) + "_version";
    }

    public static String c(d dVar) {
        int i11 = AnonymousClass2.f51314a[dVar.ordinal()];
        if (i11 == 1) {
            return "hms_push_error";
        }
        if (i11 == 2) {
            return "fcm_push_error";
        }
        if (i11 == 3) {
            return "cos_push_error";
        }
        if (i11 != 4) {
            return null;
        }
        return "ftos_push_error";
    }

    private static int a(Context context, d dVar, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a11 = a(dVar);
        String string = sharedPreferences.getString(a11, "");
        String c11 = b.a(context).c();
        String string2 = sharedPreferences.getString("last_check_token", "");
        if (TextUtils.isEmpty(a11)) {
            b.a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return 0;
        } else if (TextUtils.isEmpty(string)) {
            return 1;
        } else {
            if (!string.equals(str)) {
                return 2;
            }
            if (!TextUtils.equals(c11, string2)) {
                return 3;
            }
            if (!a(dVar) || a() == sharedPreferences.getInt(b(dVar), 0)) {
                return 0;
            }
            return 4;
        }
    }

    public static String a(Context context, d dVar) {
        return a(context, dVar, false);
    }

    public static boolean a(hc hcVar, d dVar) {
        if (hcVar == null || hcVar.a() == null || hcVar.a().a() == null) {
            return false;
        }
        return (dVar == d.ASSEMBLE_PUSH_FCM ? FirebaseMessaging.INSTANCE_ID_SCOPE : "").equalsIgnoreCase((String) hcVar.a().a().get("assemble_push_type"));
    }

    public static byte[] a(Context context, hc hcVar, d dVar) {
        if (a(hcVar, dVar)) {
            return bb.a(a(context, dVar));
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m2354a(Context context) {
        boolean z11 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a11 = a(d.ASSEMBLE_PUSH_HUAWEI);
        String a12 = a(d.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(a11, "")) && TextUtils.isEmpty(sharedPreferences.getString(a12, ""))) {
            z11 = true;
        }
        if (z11) {
            u.a(context).a(2, a11);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m2355a(Context context, d dVar) {
        String a11 = a(dVar);
        if (!TextUtils.isEmpty(a11)) {
            p.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a11, ""));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2358a(Context context, d dVar) {
        if (g.a(dVar) != null) {
            return ah.a(context).a(g.a(dVar).a(), true);
        }
        return false;
    }

    public static void a(String str, int i11) {
        MiTinyDataClient.upload("hms_push_error", str, 1, "error code = " + i11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2357a(Context context) {
        if (context == null) {
            return false;
        }
        return av.a(context);
    }

    private static synchronized void a(Context context, String str) {
        synchronized (f.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString("syncingToken", str);
            edit.apply();
        }
    }

    public static synchronized String a(Context context, d dVar, boolean z11) {
        synchronized (f.class) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            if (z11) {
                String string = sharedPreferences.getString("syncingToken", "");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
            }
            String a11 = a(dVar);
            if (TextUtils.isEmpty(a11)) {
                return "";
            }
            String string2 = sharedPreferences.getString(a11, "");
            return string2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f A[Catch:{ Exception -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.xiaomi.mipush.sdk.PushMessageReceiver a(android.content.Context r5) {
        /*
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.xiaomi.mipush.RECEIVE_MESSAGE"
            r0.<init>(r1)
            java.lang.String r1 = r5.getPackageName()
            r0.setPackage(r1)
            android.content.pm.PackageManager r1 = r5.getPackageManager()
            r2 = 32
            r3 = 0
            java.util.List r0 = r1.queryBroadcastReceivers(r0, r2)     // Catch:{ Exception -> 0x004f }
            if (r0 == 0) goto L_0x003c
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x004f }
        L_0x001f:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x004f }
            if (r1 == 0) goto L_0x003c
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x004f }
            android.content.pm.ResolveInfo r1 = (android.content.pm.ResolveInfo) r1     // Catch:{ Exception -> 0x004f }
            android.content.pm.ActivityInfo r2 = r1.activityInfo     // Catch:{ Exception -> 0x004f }
            if (r2 == 0) goto L_0x001f
            java.lang.String r2 = r2.packageName     // Catch:{ Exception -> 0x004f }
            java.lang.String r4 = r5.getPackageName()     // Catch:{ Exception -> 0x004f }
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x004f }
            if (r2 == 0) goto L_0x001f
            goto L_0x003d
        L_0x003c:
            r1 = r3
        L_0x003d:
            if (r1 == 0) goto L_0x004e
            android.content.pm.ActivityInfo r0 = r1.activityInfo     // Catch:{ Exception -> 0x004f }
            java.lang.String r0 = r0.name     // Catch:{ Exception -> 0x004f }
            java.lang.Class r5 = com.xiaomi.push.s.a(r5, r0)     // Catch:{ Exception -> 0x004f }
            java.lang.Object r5 = r5.newInstance()     // Catch:{ Exception -> 0x004f }
            com.xiaomi.mipush.sdk.PushMessageReceiver r5 = (com.xiaomi.mipush.sdk.PushMessageReceiver) r5     // Catch:{ Exception -> 0x004f }
            return r5
        L_0x004e:
            return r3
        L_0x004f:
            r5 = move-exception
            java.lang.String r5 = r5.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.f.a(android.content.Context):com.xiaomi.mipush.sdk.PushMessageReceiver");
    }

    public static void a(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null && extras.containsKey("pushMsg")) {
            intent.putExtra(PushMessageHelper.KEY_MESSAGE, a(extras.getString("pushMsg")));
        }
    }

    public static MiPushMessage a(String str) {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                String str2 = "extra";
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("messageId")) {
                    miPushMessage.setMessageId(jSONObject.getString("messageId"));
                }
                if (jSONObject.has("description")) {
                    miPushMessage.setDescription(jSONObject.getString("description"));
                }
                if (jSONObject.has("title")) {
                    miPushMessage.setTitle(jSONObject.getString("title"));
                }
                if (jSONObject.has("content")) {
                    miPushMessage.setContent(jSONObject.getString("content"));
                }
                if (jSONObject.has("passThrough")) {
                    miPushMessage.setPassThrough(jSONObject.getInt("passThrough"));
                }
                if (jSONObject.has("notifyType")) {
                    miPushMessage.setNotifyType(jSONObject.getInt("notifyType"));
                }
                if (jSONObject.has("messageType")) {
                    miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                }
                if (jSONObject.has(MTPushConstants.Operation.KEY_ALIAS)) {
                    miPushMessage.setAlias(jSONObject.getString(MTPushConstants.Operation.KEY_ALIAS));
                }
                if (jSONObject.has("topic")) {
                    miPushMessage.setTopic(jSONObject.getString("topic"));
                }
                if (jSONObject.has("user_account")) {
                    miPushMessage.setUserAccount(jSONObject.getString("user_account"));
                }
                if (jSONObject.has(RemoteMessageConst.Notification.NOTIFY_ID)) {
                    miPushMessage.setNotifyId(jSONObject.getInt(RemoteMessageConst.Notification.NOTIFY_ID));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has("isNotified")) {
                    miPushMessage.setNotified(jSONObject.getBoolean("isNotified"));
                }
                String str3 = str2;
                if (jSONObject.has(str3)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str3);
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                    if (hashMap.size() > 0) {
                        miPushMessage.setExtra(hashMap);
                    }
                }
            } catch (Exception e11) {
                b.d(e11.toString());
            }
        }
        return miPushMessage;
    }

    /* JADX WARNING: type inference failed for: r2v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v12, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v15, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v18, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.String, java.lang.String> m2353a(android.content.Context r11, com.xiaomi.mipush.sdk.d r12) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            int[] r1 = com.xiaomi.mipush.sdk.f.AnonymousClass2.f51314a
            int r2 = r12.ordinal()
            r1 = r1[r2]
            r2 = 0
            java.lang.String r3 = "package_name"
            java.lang.String r4 = "token"
            java.lang.String r5 = "brand"
            java.lang.String r6 = "~"
            java.lang.String r7 = ":"
            r8 = 1
            if (r1 == r8) goto L_0x00bc
            r9 = 2
            java.lang.String r10 = "version"
            if (r1 == r9) goto L_0x007f
            r9 = 3
            if (r1 == r9) goto L_0x005a
            r9 = 4
            if (r1 == r9) goto L_0x0028
            goto L_0x010b
        L_0x0028:
            com.xiaomi.push.t$a r1 = new com.xiaomi.push.t$a
            r1.<init>(r7, r6)
            com.xiaomi.mipush.sdk.q r2 = com.xiaomi.mipush.sdk.q.VIVO
            java.lang.String r2 = r2.name()
            com.xiaomi.push.t$a r1 = r1.a(r5, r2)
            java.lang.String r12 = a((android.content.Context) r11, (com.xiaomi.mipush.sdk.d) r12, (boolean) r8)
            com.xiaomi.push.t$a r12 = r1.a(r4, r12)
            java.lang.String r11 = r11.getPackageName()
            com.xiaomi.push.t$a r11 = r12.a(r3, r11)
            int r12 = a()
            if (r12 == 0) goto L_0x0054
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r11.a(r10, r12)
        L_0x0054:
            java.lang.String r2 = r11.toString()
            goto L_0x010b
        L_0x005a:
            com.xiaomi.push.t$a r1 = new com.xiaomi.push.t$a
            r1.<init>(r7, r6)
            com.xiaomi.mipush.sdk.q r2 = com.xiaomi.mipush.sdk.q.OPPO
            java.lang.String r2 = r2.name()
            com.xiaomi.push.t$a r1 = r1.a(r5, r2)
            java.lang.String r12 = a((android.content.Context) r11, (com.xiaomi.mipush.sdk.d) r12, (boolean) r8)
            com.xiaomi.push.t$a r12 = r1.a(r4, r12)
            java.lang.String r11 = r11.getPackageName()
            com.xiaomi.push.t$a r11 = r12.a(r3, r11)
            java.lang.String r2 = r11.toString()
            goto L_0x010b
        L_0x007f:
            com.xiaomi.push.t$a r1 = new com.xiaomi.push.t$a
            r1.<init>(r7, r6)
            com.xiaomi.mipush.sdk.q r2 = com.xiaomi.mipush.sdk.q.FCM
            java.lang.String r2 = r2.name()
            com.xiaomi.push.t$a r1 = r1.a(r5, r2)
            r2 = 0
            java.lang.String r12 = a((android.content.Context) r11, (com.xiaomi.mipush.sdk.d) r12, (boolean) r2)
            com.xiaomi.push.t$a r12 = r1.a(r4, r12)
            java.lang.String r11 = r11.getPackageName()
            com.xiaomi.push.t$a r11 = r12.a(r3, r11)
            int r12 = a()
            if (r12 == 0) goto L_0x00ad
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r11.a(r10, r12)
            goto L_0x00b7
        L_0x00ad:
            r12 = 60001(0xea61, float:8.408E-41)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r11.a(r10, r12)
        L_0x00b7:
            java.lang.String r2 = r11.toString()
            goto L_0x010b
        L_0x00bc:
            android.content.pm.PackageManager r1 = r11.getPackageManager()     // Catch:{ Exception -> 0x00cb }
            java.lang.String r9 = r11.getPackageName()     // Catch:{ Exception -> 0x00cb }
            r10 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r2 = r1.getApplicationInfo(r9, r10)     // Catch:{ Exception -> 0x00cb }
            goto L_0x00d3
        L_0x00cb:
            r1 = move-exception
            java.lang.String r1 = r1.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r1)
        L_0x00d3:
            r1 = -1
            if (r2 == 0) goto L_0x00de
            android.os.Bundle r1 = r2.metaData
            java.lang.String r2 = "com.huawei.hms.client.appid"
            int r1 = r1.getInt(r2)
        L_0x00de:
            com.xiaomi.push.t$a r2 = new com.xiaomi.push.t$a
            r2.<init>(r7, r6)
            com.xiaomi.mipush.sdk.q r6 = com.xiaomi.mipush.sdk.q.HUAWEI
            java.lang.String r6 = r6.name()
            com.xiaomi.push.t$a r2 = r2.a(r5, r6)
            java.lang.String r12 = a((android.content.Context) r11, (com.xiaomi.mipush.sdk.d) r12, (boolean) r8)
            com.xiaomi.push.t$a r12 = r2.a(r4, r12)
            java.lang.String r11 = r11.getPackageName()
            com.xiaomi.push.t$a r11 = r12.a(r3, r11)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
            java.lang.String r1 = "app_id"
            com.xiaomi.push.t$a r11 = r11.a(r1, r12)
            java.lang.String r2 = r11.toString()
        L_0x010b:
            java.lang.String r11 = "RegInfo"
            r0.put(r11, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.f.m2353a(android.content.Context, com.xiaomi.mipush.sdk.d):java.util.HashMap");
    }

    public static int a() {
        Integer num = (Integer) ax.a("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2359a(d dVar) {
        return dVar == d.ASSEMBLE_PUSH_FTOS || dVar == d.ASSEMBLE_PUSH_FCM;
    }

    public static String a(d dVar) {
        int i11 = AnonymousClass2.f51314a[dVar.ordinal()];
        if (i11 == 1) {
            return "hms_push_token";
        }
        if (i11 == 2) {
            return "fcm_push_token_v2";
        }
        if (i11 == 3) {
            return "cos_push_token";
        }
        if (i11 != 4) {
            return null;
        }
        return "ftos_push_token";
    }
}
