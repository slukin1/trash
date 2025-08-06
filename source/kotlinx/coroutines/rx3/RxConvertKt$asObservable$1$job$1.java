package kotlinx.coroutines.rx3;

import d10.p;
import h00.i;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.h0;

@d(c = "kotlinx.coroutines.rx3.RxConvertKt$asObservable$1$job$1", f = "RxConvert.kt", l = {114}, m = "invokeSuspend")
final class RxConvertKt$asObservable$1$job$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ i<Object> $emitter;
    public final /* synthetic */ kotlinx.coroutines.flow.d<Object> $this_asObservable;
    private /* synthetic */ Object L$0;
    public int label;

    public static final class a<T> implements e {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i<T> f57443b;

        public a(i<T> iVar) {
            this.f57443b = iVar;
        }

        public final Object emit(T t11, c<? super Unit> cVar) {
            this.f57443b.onNext(t11);
            return Unit.f56620a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxConvertKt$asObservable$1$job$1(kotlinx.coroutines.flow.d<Object> dVar, i<Object> iVar, c<? super RxConvertKt$asObservable$1$job$1> cVar) {
        super(2, cVar);
        this.$this_asObservable = dVar;
        this.$emitter = iVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        RxConvertKt$asObservable$1$job$1 rxConvertKt$asObservable$1$job$1 = new RxConvertKt$asObservable$1$job$1(this.$this_asObservable, this.$emitter, cVar);
        rxConvertKt$asObservable$1$job$1.L$0 = obj;
        return rxConvertKt$asObservable$1$job$1;
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((RxConvertKt$asObservable$1$job$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Throwable th2;
        h0 h0Var;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            h0 h0Var2 = (h0) this.L$0;
            try {
                kotlinx.coroutines.flow.d<Object> dVar = this.$this_asObservable;
                a aVar = new a(this.$emitter);
                this.L$0 = h0Var2;
                this.label = 1;
                if (dVar.collect(aVar, this) == d11) {
                    return d11;
                }
                h0Var = h0Var2;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                h0Var = h0Var2;
                th2 = th4;
                if (th2 instanceof CancellationException) {
                    this.$emitter.onComplete();
                } else if (!this.$emitter.tryOnError(th2)) {
                    b.a(th2, h0Var.getCoroutineContext());
                }
                return Unit.f56620a;
            }
        } else if (i11 == 1) {
            h0Var = (h0) this.L$0;
            try {
                k.b(obj);
            } catch (Throwable th5) {
                th2 = th5;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$emitter.onComplete();
        return Unit.f56620a;
    }
}
