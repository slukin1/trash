package kotlinx.coroutines.rx3;

import d10.p;
import h00.j;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.h;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.channels.m;

@d(c = "kotlinx.coroutines.rx3.RxConvertKt$asFlow$1", f = "RxConvert.kt", l = {95}, m = "invokeSuspend")
final class RxConvertKt$asFlow$1 extends SuspendLambda implements p<k<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ j<Object> $this_asFlow;
    private /* synthetic */ Object L$0;
    public int label;

    public static final class a implements h00.k<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k<Object> f57441b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AtomicReference<b> f57442c;

        public a(k<Object> kVar, AtomicReference<b> atomicReference) {
            this.f57441b = kVar;
            this.f57442c = atomicReference;
        }

        public void onComplete() {
            m.a.a(this.f57441b, (Throwable) null, 1, (Object) null);
        }

        public void onError(Throwable th2) {
            this.f57441b.K(th2);
        }

        public void onNext(Object obj) {
            try {
                h.w(this.f57441b, obj);
            } catch (InterruptedException unused) {
            }
        }

        public void onSubscribe(b bVar) {
            if (!this.f57442c.compareAndSet((Object) null, bVar)) {
                bVar.dispose();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxConvertKt$asFlow$1(j<Object> jVar, c<? super RxConvertKt$asFlow$1> cVar) {
        super(2, cVar);
        this.$this_asFlow = jVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        RxConvertKt$asFlow$1 rxConvertKt$asFlow$1 = new RxConvertKt$asFlow$1(this.$this_asFlow, cVar);
        rxConvertKt$asFlow$1.L$0 = obj;
        return rxConvertKt$asFlow$1;
    }

    public final Object invoke(k<Object> kVar, c<? super Unit> cVar) {
        return ((RxConvertKt$asFlow$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            kotlin.k.b(obj);
            k kVar = (k) this.L$0;
            final AtomicReference atomicReference = new AtomicReference();
            this.$this_asFlow.subscribe(new a(kVar, atomicReference));
            AnonymousClass1 r32 = new d10.a<Unit>() {
                public final void invoke() {
                    b andSet = atomicReference.getAndSet(io.reactivex.rxjava3.disposables.a.a());
                    if (andSet != null) {
                        andSet.dispose();
                    }
                }
            };
            this.label = 1;
            if (ProduceKt.a(kVar, r32, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            kotlin.k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
