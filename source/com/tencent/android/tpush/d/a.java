package com.tencent.android.tpush.d;

import android.content.Context;
import com.huawei.hms.aaid.HmsInstanceId;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import java.lang.reflect.InvocationTargetException;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f68934a = {"com.tencent.android.tpush.otherpush.mipush.impl.OtherPushImpl", "com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl"};

    /* renamed from: b  reason: collision with root package name */
    private static int f68935b = -2;

    /* renamed from: c  reason: collision with root package name */
    private static String f68936c = null;

    /* renamed from: d  reason: collision with root package name */
    private static int f68937d = -1;

    public static boolean a(Context context) {
        if (f68935b == -2) {
            int i11 = 0;
            while (true) {
                String[] strArr = f68934a;
                if (i11 >= strArr.length) {
                    f68935b = -1;
                    break;
                }
                try {
                    Class.forName(strArr[i11]);
                    if (a(context, strArr[i11])) {
                        f68935b = i11;
                        f68936c = strArr[i11];
                        return true;
                    }
                    i11++;
                } catch (ClassNotFoundException unused) {
                }
            }
        }
        if (f68935b > -1) {
            return true;
        }
        return false;
    }

    public static void b(Context context, String str) {
        a(context, str, "com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
    }

    public static boolean a(Context context, String str) {
        try {
            TLogger.ii("OtherPush", "checkDevice pushClassName" + str);
            Class<?> cls = Class.forName(str);
            return ((Boolean) cls.getMethod("checkDevice", new Class[]{Context.class}).invoke(cls, new Object[]{context})).booleanValue();
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            TLogger.ee("OtherPush", "checkDevice Error for InvocationTargetException: " + cause.getMessage());
            cause.printStackTrace();
            return false;
        } catch (Throwable th2) {
            TLogger.ee("OtherPush", "checkDevice Error, are you import otherpush package? " + th2);
            return false;
        }
    }

    private static void a(Context context, String str, String str2) {
        try {
            Class<?> cls = Class.forName(str2);
            cls.getMethod("setAppid", new Class[]{Context.class, String.class}).invoke(cls, new Object[]{context, str});
        } catch (Throwable th2) {
            TLogger.ww("OtherPush", "setAppid Error, are you import otherpush package? " + th2);
        }
    }

    public static int a() {
        if (f68937d == -1) {
            if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor()) {
                try {
                    String str = HmsInstanceId.TAG;
                    f68937d = 4;
                } catch (Throwable unused) {
                    f68937d = 0;
                }
            } else {
                f68937d = 0;
            }
        }
        return f68937d;
    }
}
