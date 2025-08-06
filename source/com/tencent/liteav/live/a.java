package com.tencent.liteav.live;

import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Method f21599a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f21600b;

    static {
        Class<TXCloudVideoView> cls = TXCloudVideoView.class;
        try {
            Method declaredMethod = cls.getDeclaredMethod("setShowLogCallback", new Class[]{WeakReference.class});
            f21599a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = cls.getDeclaredMethod("isShowLogEnabled", new Class[0]);
            f21600b = declaredMethod2;
            declaredMethod2.setAccessible(true);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static boolean a(TXCloudVideoView tXCloudVideoView) {
        if (tXCloudVideoView == null) {
            return false;
        }
        try {
            Object invoke = f21600b.invoke(tXCloudVideoView, new Object[0]);
            if (invoke == null || !(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static void a(TXCloudVideoView tXCloudVideoView, WeakReference<TXCloudVideoView.b> weakReference) {
        if (tXCloudVideoView != null) {
            try {
                f21599a.invoke(tXCloudVideoView, new Object[]{weakReference});
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }
}
