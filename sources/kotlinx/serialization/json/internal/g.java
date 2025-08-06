package kotlinx.serialization.json.internal;

import kotlin.Result;
import kotlin.k;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final int f57902a;

    static {
        Object obj;
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m3072constructorimpl(StringsKt__StringNumberConversionsKt.m(System.getProperty("kotlinx.serialization.json.pool.size")));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m3072constructorimpl(k.a(th2));
        }
        if (Result.m3078isFailureimpl(obj)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        f57902a = num != null ? num.intValue() : 2097152;
    }
}
