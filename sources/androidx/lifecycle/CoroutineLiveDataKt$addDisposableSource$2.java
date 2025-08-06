package androidx.lifecycle;

import d10.l;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
final class CoroutineLiveDataKt$addDisposableSource$2 extends SuspendLambda implements p<h0, c<? super EmittedSource>, Object> {
    public final /* synthetic */ LiveData<Object> $source;
    public final /* synthetic */ MediatorLiveData<Object> $this_addDisposableSource;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineLiveDataKt$addDisposableSource$2(MediatorLiveData<Object> mediatorLiveData, LiveData<Object> liveData, c<? super CoroutineLiveDataKt$addDisposableSource$2> cVar) {
        super(2, cVar);
        this.$this_addDisposableSource = mediatorLiveData;
        this.$source = liveData;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new CoroutineLiveDataKt$addDisposableSource$2(this.$this_addDisposableSource, this.$source, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super EmittedSource> cVar) {
        return ((CoroutineLiveDataKt$addDisposableSource$2) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            final MediatorLiveData<Object> mediatorLiveData = this.$this_addDisposableSource;
            mediatorLiveData.b(this.$source, new i(new l<Object, Unit>() {
                public final void invoke(Object obj) {
                    mediatorLiveData.setValue(obj);
                }
            }));
            return new EmittedSource(this.$source, this.$this_addDisposableSource);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
