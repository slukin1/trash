package retrofit2;

import d10.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "", "it", "", "invoke", "retrofit2/KotlinExtensions$await$4$1"}, k = 3, mv = {1, 1, 15})
public final class KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ Call $this_await$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(Call call) {
        super(1);
        this.$this_await$inlined = call;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        this.$this_await$inlined.cancel();
    }
}
