package androidx.activity.contextaware;

import b.a;
import b.b;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class ContextAwareKt$withContextAvailable$2$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ b $listener;
    public final /* synthetic */ a $this_withContextAvailable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextAwareKt$withContextAvailable$2$1(a aVar, b bVar) {
        super(1);
        this.$this_withContextAvailable = aVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        this.$this_withContextAvailable.removeOnContextAvailableListener(this.$listener);
    }
}
