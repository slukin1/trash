package kotlinx.coroutines.internal;

import d10.l;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import kotlin.k;

public final class ExceptionsConstructorKt$safeCtor$1 extends Lambda implements l<Throwable, Throwable> {
    public final /* synthetic */ l<Throwable, Throwable> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExceptionsConstructorKt$safeCtor$1(l<? super Throwable, ? extends Throwable> lVar) {
        super(1);
        this.$block = lVar;
    }

    public final Throwable invoke(Throwable th2) {
        Object obj;
        l<Throwable, Throwable> lVar = this.$block;
        Throwable th3 = null;
        try {
            Result.a aVar = Result.Companion;
            Throwable invoke = lVar.invoke(th2);
            if (!x.b(th2.getMessage(), invoke.getMessage()) && !x.b(invoke.getMessage(), th2.toString())) {
                invoke = null;
            }
            obj = Result.m3072constructorimpl(invoke);
        } catch (Throwable th4) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m3072constructorimpl(k.a(th4));
        }
        if (!Result.m3078isFailureimpl(obj)) {
            th3 = obj;
        }
        return th3;
    }
}
