package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ax;
import com.xiaomi.push.j;
import com.xiaomi.push.s;
import com.xiaomi.push.service.ag;
import com.xiaomi.push.t;
import java.util.ArrayList;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray<ag.a<String, String, String>> f52552a = new SparseArray<ag.a<String, String, String>>(5) {
        {
            put(1, ag.f52446b);
            put(2, ag.f52447c);
            put(4, ag.f52448d);
            put(8, ag.f52450f);
            put(16, ag.f52449e);
        }
    };

    /* renamed from: a  reason: collision with other field name */
    private static final int[] f3387a = {1, 2, 4, 8, 16};

    /* renamed from: b  reason: collision with root package name */
    private static final SparseArray<Integer> f52553b = new SparseArray<Integer>(5) {
        {
            put(1, 32);
            put(2, 16);
            put(4, 8);
            put(8, 4);
            put(16, 2);
        }
    };

    public static int a(String str, String str2) {
        int i11 = 8;
        if (!a(str, str2, 8)) {
            i11 = 0;
        }
        if (a(str, str2, 16)) {
            i11 |= 16;
        }
        if (a(str, str2, 1)) {
            i11 |= 1;
        }
        if (a(str, str2, 2)) {
            i11 |= 2;
        }
        return a(str, str2, 4) ? i11 | 4 : i11;
    }

    private static boolean a(int i11, int i12) {
        return i11 >= 4 || (i12 & 2) > 0 || (i12 & 1) > 0 || (i12 & 8) > 0 || (i12 & 16) > 0;
    }

    public static void a(Context context, String str, String str2, int i11, String str3, boolean z11, int i12) {
        Class<f> cls = f.class;
        if (j.a(context) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            int a11 = t.a(str3, 0);
            boolean a12 = a(i11, a11);
            if (z11) {
                a(str, str2, a11, i12);
                if (a12) {
                    synchronized (cls) {
                        a(a(context), a11, str2);
                    }
                    return;
                }
                return;
            }
            synchronized (cls) {
                SharedPreferences a13 = a(context);
                if (a12 || a13.contains(str2)) {
                    a(a13, a11, str, str2, i12);
                    if (a12) {
                        a(a13, a11, str2);
                    } else {
                        a(a13, str2);
                    }
                }
            }
        } else if (j.a(context)) {
            b.a("ChannelPC: can`t setup permission with permissionCode:" + String.valueOf(str3) + " channelId:" + String.valueOf(str2) + " targetPkg:" + str);
        }
    }

    public static void a(Context context, String str) {
        List<NotificationChannel> a11;
        if (j.a(context) && !TextUtils.isEmpty(str) && (a11 = af.a(context, str).a()) != null) {
            synchronized (f.class) {
                SharedPreferences a12 = a(context);
                ArrayList arrayList = new ArrayList();
                for (NotificationChannel a13 : a11) {
                    String str2 = (String) ax.a((Object) a13, "mId");
                    if (!TextUtils.isEmpty(str2) && a12.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
                if (arrayList.size() > 0) {
                    a(a12, (List<String>) arrayList);
                }
            }
        }
    }

    public static void a(String str, String str2, int i11, int i12) {
        for (int i13 : f3387a) {
            if ((f52553b.get(i13).intValue() & i12) == 0) {
                a(str, str2, i13, (i11 & i13) > 0);
            } else {
                b.a("ChannelPermissions.grantPermission:" + str + ":" + str2 + ": <" + i13 + "> :stoped by userLock");
            }
        }
    }

    private static void a(String str, String str2, int i11, boolean z11) {
        boolean a11 = ag.a(s.a(), str, str2, f52552a.get(i11), z11);
        b.a("ChannelPermissions.grantPermission:" + str + ":" + str2 + ": <" + i11 + ContainerUtils.KEY_VALUE_DELIMITER + z11 + "> :" + a11);
    }

    public static int a(String str, String str2, int i11) {
        return ag.a(s.a(), str, str2, f52552a.get(i11));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Bundle m3012a(String str, String str2) {
        return ag.a(s.a(), str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m3013a(String str, String str2, int i11) {
        boolean z11 = true;
        if (ag.a(s.a(), str, str2, f52552a.get(i11)) != 1) {
            z11 = false;
        }
        b.a("ChannelPermissions.checkPermission:" + str + ":" + str2 + ": <" + i11 + ContainerUtils.KEY_VALUE_DELIMITER + z11 + ">");
        return z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007c, code lost:
        if (r1 == 0) goto L_0x007e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r5, java.lang.String r6, android.app.NotificationChannel r7) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 26
            if (r0 < r2) goto L_0x00aa
            if (r5 == 0) goto L_0x00aa
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto L_0x00aa
            if (r7 == 0) goto L_0x00aa
            int r5 = r7.getImportance()
            r0 = 1
            if (r5 == 0) goto L_0x001a
            r5 = r0
            goto L_0x001b
        L_0x001a:
            r5 = 2
        L_0x001b:
            r5 = r5 | r1
            boolean r1 = com.xiaomi.push.service.ag.a()
            r2 = 16
            r3 = 4
            r4 = 8
            if (r1 == 0) goto L_0x0069
            java.lang.String r0 = r7.getId()
            android.os.Bundle r6 = a((java.lang.String) r6, (java.lang.String) r0)
            com.xiaomi.push.service.ag$a<java.lang.String, java.lang.String, java.lang.String> r0 = com.xiaomi.push.service.ag.f52450f
            T r1 = r0.f52455c
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r6.containsKey(r1)
            if (r1 == 0) goto L_0x004e
            T r0 = r0.f52455c
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r6.getBoolean(r0)
            if (r0 == 0) goto L_0x004c
            int r0 = r7.getImportance()
            if (r0 < r3) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r3 = r4
        L_0x004d:
            r5 = r5 | r3
        L_0x004e:
            com.xiaomi.push.service.ag$a<java.lang.String, java.lang.String, java.lang.String> r0 = com.xiaomi.push.service.ag.f52449e
            T r1 = r0.f52455c
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r6.containsKey(r1)
            if (r1 == 0) goto L_0x0091
            T r0 = r0.f52455c
            java.lang.String r0 = (java.lang.String) r0
            boolean r6 = r6.getBoolean(r0)
            if (r6 == 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r2 = 32
        L_0x0067:
            r5 = r5 | r2
            goto L_0x0091
        L_0x0069:
            java.lang.String r1 = r7.getId()
            int r1 = a((java.lang.String) r6, (java.lang.String) r1, (int) r4)
            if (r1 != r0) goto L_0x007c
            int r1 = r7.getImportance()
            if (r1 < r3) goto L_0x007e
            r5 = r5 | 4
            goto L_0x0080
        L_0x007c:
            if (r1 != 0) goto L_0x0080
        L_0x007e:
            r5 = r5 | 8
        L_0x0080:
            java.lang.String r1 = r7.getId()
            int r6 = a((java.lang.String) r6, (java.lang.String) r1, (int) r2)
            if (r6 != r0) goto L_0x008d
            r5 = r5 | 16
            goto L_0x0091
        L_0x008d:
            if (r6 != 0) goto L_0x0091
            r5 = r5 | 32
        L_0x0091:
            android.net.Uri r6 = r7.getSound()
            if (r6 == 0) goto L_0x009a
            r5 = r5 | 64
            goto L_0x009c
        L_0x009a:
            r5 = r5 | 128(0x80, float:1.794E-43)
        L_0x009c:
            boolean r6 = r7.shouldVibrate()
            if (r6 == 0) goto L_0x00a5
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x00a7
        L_0x00a5:
            r6 = 512(0x200, float:7.175E-43)
        L_0x00a7:
            r1 = r5 | r6
            goto L_0x00af
        L_0x00aa:
            java.lang.String r5 = "context|packageName|channel must not be null "
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r5)
        L_0x00af:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.f.a(android.content.Context, java.lang.String, android.app.NotificationChannel):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r1 == 0) goto L_0x0042;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 26
            if (r0 < r2) goto L_0x0067
            if (r3 == 0) goto L_0x0067
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x0067
            com.xiaomi.push.service.af r3 = com.xiaomi.push.service.af.a((android.content.Context) r3, (java.lang.String) r4)
            if (r3 == 0) goto L_0x0061
            java.lang.String r5 = r3.a((java.lang.String) r5)
            android.app.NotificationChannel r3 = r3.a((java.lang.String) r5)
            if (r3 == 0) goto L_0x005b
            int r5 = r3.getImportance()
            r0 = 1
            if (r5 == 0) goto L_0x0028
            r5 = r0
            goto L_0x0029
        L_0x0028:
            r5 = 2
        L_0x0029:
            r5 = r5 | r1
            java.lang.String r1 = r3.getId()
            r2 = 8
            int r1 = a((java.lang.String) r4, (java.lang.String) r1, (int) r2)
            if (r1 != r0) goto L_0x0040
            int r1 = r3.getImportance()
            r2 = 4
            if (r1 < r2) goto L_0x0042
            r5 = r5 | 4
            goto L_0x0044
        L_0x0040:
            if (r1 != 0) goto L_0x0044
        L_0x0042:
            r5 = r5 | 8
        L_0x0044:
            java.lang.String r3 = r3.getId()
            r1 = 16
            int r3 = a((java.lang.String) r4, (java.lang.String) r3, (int) r1)
            if (r3 != r0) goto L_0x0054
            r3 = r5 | 16
        L_0x0052:
            r1 = r3
            goto L_0x006c
        L_0x0054:
            if (r3 != 0) goto L_0x0059
            r3 = r5 | 32
            goto L_0x0052
        L_0x0059:
            r1 = r5
            goto L_0x006c
        L_0x005b:
            java.lang.String r3 = "Channel must not be null"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r3)
            goto L_0x006c
        L_0x0061:
            java.lang.String r3 = "create NMHelper error"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r3)
            goto L_0x006c
        L_0x0067:
            java.lang.String r3 = "Must greater than or equal android O and context|packageName not be null"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r3)
        L_0x006c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.f.a(android.content.Context, java.lang.String, java.lang.String):int");
    }

    private static void a(SharedPreferences sharedPreferences, int i11, String str, String str2, int i12) {
        if (sharedPreferences.getInt(str2, 0) != i11) {
            a(str, str2, i11, i12);
        }
    }

    private static void a(SharedPreferences sharedPreferences, int i11, String str) {
        sharedPreferences.edit().putInt(str, i11).commit();
    }

    private static void a(SharedPreferences sharedPreferences, String str) {
        a(sharedPreferences, (List<String>) new ArrayList<String>(str) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f52554a;

            {
                this.f52554a = r1;
                add(r1);
            }
        });
    }

    private static void a(SharedPreferences sharedPreferences, List<String> list) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String remove : list) {
            edit.remove(remove);
        }
        edit.commit();
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("ch_permission_cache_file", 0);
    }
}
