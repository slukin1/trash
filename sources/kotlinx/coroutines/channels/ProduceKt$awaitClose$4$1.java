package kotlinx.coroutines.channels;

import d10.l;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.k;

public final class ProduceKt$awaitClose$4$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ k<Unit> $cont;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProduceKt$awaitClose$4$1(k<? super Unit> kVar) {
        super(1);
        this.$cont = kVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        k<Unit> kVar = this.$cont;
        Result.a aVar = Result.Companion;
        kVar.resumeWith(Result.m3072constructorimpl(Unit.f56620a));
    }
}
