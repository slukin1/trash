package com.tencent.android.tpush.b;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.PushMessageManager;
import java.lang.reflect.Method;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f68106a = "InMsgManagerInstance";

    /* renamed from: b  reason: collision with root package name */
    private static String f68107b = "com.tencent.android.tpush.inapp.InMsgManager";

    /* renamed from: c  reason: collision with root package name */
    private static String f68108c = "show";

    /* renamed from: d  reason: collision with root package name */
    private static String f68109d = "dismiss";

    /* renamed from: e  reason: collision with root package name */
    private static Class<?> f68110e;

    /* renamed from: f  reason: collision with root package name */
    private static Method f68111f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f68112g;

    public static void a() {
        try {
            if (!f68112g) {
                if (f68110e == null) {
                    f68110e = Class.forName(f68107b);
                }
                if (f68111f == null) {
                    f68111f = f68110e.getDeclaredMethod(f68108c, new Class[]{Context.class, PushMessageManager.class});
                }
                f68112g = true;
            }
        } catch (Throwable th2) {
            String str = f68106a;
            TLogger.w(str, "invoke method show() error: " + th2.toString());
        }
    }

    public static void a(Context context, PushMessageManager pushMessageManager) {
        try {
            a();
            f68111f.invoke(f68110e, new Object[]{context, pushMessageManager});
        } catch (Throwable th2) {
            String str = f68106a;
            TLogger.w(str, "invoke method show() error: " + th2.toString());
        }
    }
}
