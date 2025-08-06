package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.android.tpush.common.MessageKey;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ax;
import com.xiaomi.push.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class ag {

    /* renamed from: a  reason: collision with root package name */
    public static final a<String, String, String> f52445a = new a<>("getNotificationSettings", "getNotificationSettings", "getNotificationSettings");

    /* renamed from: a  reason: collision with other field name */
    public static Boolean f3327a;

    /* renamed from: a  reason: collision with other field name */
    private static String f3328a = null;

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f3329a = {"com.mi.globalbrowser", "com.android.browser"};

    /* renamed from: b  reason: collision with root package name */
    public static final a<String, String, String> f52446b = new a<>("setSound", "canSound", "canSound");

    /* renamed from: c  reason: collision with root package name */
    public static final a<String, String, String> f52447c = new a<>("setVibrate", "canVibrate", "canVibrate");

    /* renamed from: d  reason: collision with root package name */
    public static final a<String, String, String> f52448d = new a<>("setLights", "canLights", "canLights");

    /* renamed from: e  reason: collision with root package name */
    public static final a<String, String, String> f52449e = new a<>("setShowOnKeyguard", "canShowOnKeyguard", "canShowOnKeyguard");

    /* renamed from: f  reason: collision with root package name */
    public static final a<String, String, String> f52450f = new a<>("setFloat", "canFloat", "canShowFloat");

    /* renamed from: g  reason: collision with root package name */
    public static final a<String, String, String> f52451g = new a<>("setShowBadge", "canShowBadge", "canShowBadge");

    /* renamed from: h  reason: collision with root package name */
    public static final a<String, String, String> f52452h = new a<>("setShowOngoing", "canShowOngoing", "canShowOngoing");

    public static class a<F, S, T> {

        /* renamed from: a  reason: collision with root package name */
        public F f52453a;

        /* renamed from: b  reason: collision with root package name */
        public S f52454b;

        /* renamed from: c  reason: collision with root package name */
        public T f52455c;

        private a(F f11, S s11, T t11) {
            this.f52453a = f11;
            this.f52454b = s11;
            this.f52455c = t11;
        }
    }

    public static boolean a() {
        if (f3327a == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                Bundle a11 = f.a("com.xiaomi.xmsf", (String) null);
                if (a11 == null || a11.isEmpty()) {
                    f3327a = Boolean.FALSE;
                } else {
                    f3327a = Boolean.TRUE;
                }
            } else {
                f3327a = Boolean.FALSE;
            }
        }
        return f3327a.booleanValue();
    }

    public static String b(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence("android.text");
            if (TextUtils.isEmpty(charSequence) && Build.VERSION.SDK_INT >= 21) {
                charSequence = notification.extras.getCharSequence("android.bigText");
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customContent");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        r3 = com.xiaomi.push.ax.a((java.lang.Object) r3, "extraNotification");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(android.app.Notification r3) {
        /*
            r0 = 0
            android.os.Bundle r1 = r3.extras     // Catch:{ Exception -> 0x0025 }
            if (r1 == 0) goto L_0x000b
            java.lang.String r2 = "target_package"
            java.lang.String r0 = r1.getString(r2)     // Catch:{ Exception -> 0x0025 }
        L_0x000b:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0025 }
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = "extraNotification"
            java.lang.Object r3 = com.xiaomi.push.ax.a((java.lang.Object) r3, (java.lang.String) r1)     // Catch:{ Exception -> 0x0025 }
            if (r3 == 0) goto L_0x0025
            java.lang.String r1 = "getTargetPkg"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0025 }
            java.lang.Object r3 = com.xiaomi.push.ax.a((java.lang.Object) r3, (java.lang.String) r1, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0025 }
            r0 = r3
        L_0x0025:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.c(android.app.Notification):java.lang.String");
    }

    public static void b(Notification notification, boolean z11) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putBoolean("miui.enableKeyguard", z11);
            }
            Object a11 = ax.a((Object) notification, "extraNotification");
            if (a11 != null) {
                ax.a(a11, "setEnableKeyguard", Boolean.valueOf(z11));
            }
        } catch (Exception unused) {
        }
    }

    public static String a(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence("android.title");
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("android.title.big");
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customTitle");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Notification.Action[] m2986a(Notification notification) {
        Parcelable[] parcelableArray;
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr;
        }
        Bundle bundle = notification.extras;
        if (bundle == null || (parcelableArray = bundle.getParcelableArray("mipush.customActions")) == null) {
            return null;
        }
        return (Notification.Action[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Notification.Action[].class);
    }

    public static <T> T a(Notification notification, String str) {
        Bundle bundle = notification.extras;
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Map<String, String> map, Bundle bundle, String str) {
        if (map == null || bundle == null || TextUtils.isEmpty(str)) {
            b.a("cp map to b fail:" + str);
        } else if (TextUtils.isEmpty(map.get(str))) {
            bundle.remove(str);
        } else {
            bundle.putString(str, map.get(str));
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.util.Map<java.lang.String, java.lang.String> r1, android.os.Bundle r2, java.lang.String r3, java.lang.String r4, boolean r5) {
        /*
            if (r1 == 0) goto L_0x002e
            if (r2 == 0) goto L_0x002e
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x000b
            goto L_0x002e
        L_0x000b:
            if (r5 == 0) goto L_0x0012
            java.lang.Object r1 = r1.remove(r3)
            goto L_0x0016
        L_0x0012:
            java.lang.Object r1 = r1.get(r3)
        L_0x0016:
            java.lang.String r1 = (java.lang.String) r1
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 == 0) goto L_0x0022
            r2.remove(r3)
            goto L_0x002d
        L_0x0022:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r3 = r4
        L_0x002a:
            r2.putString(r3, r1)
        L_0x002d:
            return
        L_0x002e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cp map to b fail:"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.a(java.util.Map, android.os.Bundle, java.lang.String, java.lang.String, boolean):void");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m2984a(Notification notification, String str) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, str);
            }
            Object a11 = ax.a((Object) notification, "extraNotification");
            if (a11 != null) {
                ax.a(a11, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Notification notification, boolean z11) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putBoolean("miui.enableFloat", z11);
            }
            Object a11 = ax.a((Object) notification, "extraNotification");
            if (a11 != null) {
                ax.a(a11, "setEnableFloat", Boolean.valueOf(z11));
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Notification notification, int i11) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putInt("miui.messageCount", i11);
            }
            Object a11 = ax.a((Object) notification, "extraNotification");
            if (a11 != null) {
                ax.a(a11, "setMessageCount", Integer.valueOf(i11));
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Notification notification, int i11, int i12) {
        if (notification != null) {
            if (notification.extras == null) {
                notification.extras = new Bundle();
            }
            notification.extras.putInt("is_priority", i11);
            notification.extras.putInt("mipush_class", i12);
        }
    }

    public static String a(Object obj) {
        return (String) a(obj, "msg_busi_type", "");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T a(java.lang.Object r2, java.lang.String r3, T r4) {
        /*
            r0 = 0
            boolean r1 = r2 instanceof android.app.Notification     // Catch:{ Exception -> 0x0038 }
            if (r1 == 0) goto L_0x000d
            android.app.Notification r2 = (android.app.Notification) r2     // Catch:{ Exception -> 0x0038 }
            java.lang.Object r2 = a((android.app.Notification) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0038 }
        L_0x000b:
            r0 = r2
            goto L_0x004d
        L_0x000d:
            boolean r1 = r2 instanceof java.util.Map     // Catch:{ Exception -> 0x0038 }
            if (r1 == 0) goto L_0x0018
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x0038 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x0038 }
            goto L_0x000b
        L_0x0018:
            boolean r1 = r2 instanceof android.os.Bundle     // Catch:{ Exception -> 0x0038 }
            if (r1 == 0) goto L_0x0023
            android.os.Bundle r2 = (android.os.Bundle) r2     // Catch:{ Exception -> 0x0038 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x0038 }
            goto L_0x000b
        L_0x0023:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0038 }
            r3.<init>()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r1 = "not support get value from classType:"
            r3.append(r1)     // Catch:{ Exception -> 0x0038 }
            r3.append(r2)     // Catch:{ Exception -> 0x0038 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0038 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0038 }
            goto L_0x004d
        L_0x0038:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = "get value error "
            r3.append(r1)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r2)
        L_0x004d:
            if (r0 != 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r4 = r0
        L_0x0051:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.a(java.lang.Object, java.lang.String, java.lang.Object):java.lang.Object");
    }

    public static int a(Context context, String str) {
        return g.b(context, str);
    }

    public static void a(Context context, String str, Intent intent) {
        if (intent != null) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
            arrayList.addAll(Arrays.asList(f3329a));
            int size = arrayList.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    break;
                }
                String str2 = (String) arrayList.get(i11);
                if (!TextUtils.isEmpty(str2)) {
                    Intent intent2 = new Intent(intent);
                    intent2.setPackage(str2);
                    try {
                        if (context.getPackageManager().resolveActivity(intent2, 65536) != null) {
                            intent.setPackage(str2);
                            break;
                        }
                    } catch (Exception e11) {
                        b.a("can't match url intent. " + e11);
                    }
                }
                i11++;
            }
            intent.setPackage(intent.getPackage());
        }
    }

    public static int a(ContentResolver contentResolver) {
        try {
            return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
        } catch (Exception e11) {
            b.a("get user aggregate failed, " + e11);
            return 0;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2985a(ContentResolver contentResolver) {
        int a11 = a(contentResolver);
        return a11 == 1 || a11 == 2;
    }

    public static boolean a(Map<String, String> map) {
        return Boolean.parseBoolean((String) a((Object) map, "not_suppress", "true"));
    }

    public static boolean a(Notification.Builder builder, boolean z11) {
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setGroupAlertBehavior(z11 ? 2 : 1);
            return true;
        }
        b.b("not support setGroupAlertBehavior");
        return false;
    }

    public static int a(Context context, String str, String str2, a<String, String, String> aVar) {
        if (aVar == null) {
            return -1;
        }
        try {
            Bundle a11 = a(context, (String) aVar.f52454b, str, str2, (Bundle) null);
            if (a11 == null || !a11.containsKey((String) aVar.f52455c)) {
                return -1;
            }
            return a11.getBoolean((String) aVar.f52455c) ? 1 : 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static Bundle a(Context context, String str, String str2) {
        try {
            return a(context, (String) f52445a.f52454b, str, str2, (Bundle) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean a(Context context, String str, String str2, a<String, String, String> aVar, boolean z11) {
        if (aVar != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean((String) aVar.f52455c, z11);
                a(context, (String) aVar.f52453a, str, str2, bundle);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static Bundle a(Context context, String str, String str2, String str3, Bundle bundle) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("call notification provider failed!");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("package", str2);
        if (!TextUtils.isEmpty(str3)) {
            bundle2.putString(MessageKey.MSG_CHANNEL_ID, str3);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        return context.getContentResolver().call(Uri.parse("content://statusbar.notification"), str, (String) null, bundle2);
    }
}
