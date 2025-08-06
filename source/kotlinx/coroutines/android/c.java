package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import kotlin.Result;
import kotlin.jvm.internal.r;
import kotlin.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final b f56987a;
    private static volatile Choreographer choreographer;

    static {
        Object obj;
        b bVar = null;
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m3072constructorimpl(new HandlerContext(a(Looper.getMainLooper(), true), (String) null, 2, (r) null));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m3072constructorimpl(k.a(th2));
        }
        if (!Result.m3078isFailureimpl(obj)) {
            bVar = obj;
        }
        f56987a = bVar;
    }

    public static final Handler a(Looper looper, boolean z11) {
        int i11;
        if (!z11 || (i11 = Build.VERSION.SDK_INT) < 16) {
            return new Handler(looper);
        }
        if (i11 >= 28) {
            return (Handler) Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke((Object) null, new Object[]{looper});
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
