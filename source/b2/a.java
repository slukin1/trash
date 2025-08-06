package b2;

import android.app.Application;
import android.content.Context;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.template.ILogger;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f12288a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f12289b = false;

    /* renamed from: c  reason: collision with root package name */
    public static ILogger f12290c;

    @Deprecated
    public static boolean b() {
        return b.h();
    }

    public static boolean c() {
        return b.i();
    }

    public static a d() {
        if (f12289b) {
            if (f12288a == null) {
                synchronized (a.class) {
                    if (f12288a == null) {
                        f12288a = new a();
                    }
                }
            }
            return f12288a;
        }
        throw new InitException("ARouter::Init::Invoke init(context) first!");
    }

    public static void e(Application application) {
        if (!f12289b) {
            ILogger iLogger = b.f12291a;
            f12290c = iLogger;
            iLogger.info(ILogger.defaultTag, "ARouter init start.");
            f12289b = b.l(application);
            if (f12289b) {
                b.e();
            }
            b.f12291a.info(ILogger.defaultTag, "ARouter init over.");
        }
    }

    public Postcard a(String str) {
        return b.k().f(str);
    }

    public void f(Object obj) {
        b.m(obj);
    }

    public Object g(Context context, Postcard postcard, int i11, NavigationCallback navigationCallback) {
        return b.k().n(context, postcard, i11, navigationCallback);
    }

    public <T> T h(Class<? extends T> cls) {
        return b.k().o(cls);
    }
}
