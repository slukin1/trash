package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.MainCoroutineDispatcher;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f57347a = true;

    public static final v a(Throwable th2, String str) {
        if (f57347a) {
            return new v(th2, str);
        }
        if (th2 != null) {
            throw th2;
        }
        d();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ v b(Throwable th2, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            th2 = null;
        }
        if ((i11 & 2) != 0) {
            str = null;
        }
        return a(th2, str);
    }

    public static final boolean c(MainCoroutineDispatcher mainCoroutineDispatcher) {
        return mainCoroutineDispatcher.G() instanceof v;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final MainCoroutineDispatcher e(s sVar, List<? extends s> list) {
        try {
            return sVar.c(list);
        } catch (Throwable th2) {
            return a(th2, sVar.b());
        }
    }
}
