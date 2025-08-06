package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.k;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f57324a;

    static {
        Object obj;
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m3072constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m3072constructorimpl(k.a(th2));
        }
        f57324a = Result.m3079isSuccessimpl(obj);
    }

    public static final boolean a() {
        return f57324a;
    }
}
