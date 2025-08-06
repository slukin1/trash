package retrofit2;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.k;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "retrofit2/KotlinExtensions$suspendAndThrow$2$1"}, k = 3, mv = {1, 1, 15})
public final class KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 implements Runnable {
    public final /* synthetic */ c $continuation;
    public final /* synthetic */ Exception $this_suspendAndThrow$inlined;

    public KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1(c cVar, Exception exc) {
        this.$continuation = cVar;
        this.$this_suspendAndThrow$inlined = exc;
    }

    public final void run() {
        c c11 = IntrinsicsKt__IntrinsicsJvmKt.c(this.$continuation);
        Exception exc = this.$this_suspendAndThrow$inlined;
        Result.a aVar = Result.Companion;
        c11.resumeWith(Result.m3072constructorimpl(k.a(exc)));
    }
}
