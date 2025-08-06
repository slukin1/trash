package kotlinx.coroutines.flow;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.k;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.p1;
import kotlinx.coroutines.t;

@d(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", l = {340}, m = "invokeSuspend")
public final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ t<j1<T>> $result;
    public final /* synthetic */ d<T> $upstream;
    private /* synthetic */ Object L$0;
    public int label;

    public static final class a<T> implements e {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<b1<T>> f57170b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h0 f57171c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ t<j1<T>> f57172d;

        public a(Ref$ObjectRef<b1<T>> ref$ObjectRef, h0 h0Var, t<j1<T>> tVar) {
            this.f57170b = ref$ObjectRef;
            this.f57171c = h0Var;
            this.f57172d = tVar;
        }

        public final Object emit(T t11, c<? super Unit> cVar) {
            Unit unit;
            b1 b1Var = (b1) this.f57170b.element;
            if (b1Var != null) {
                b1Var.setValue(t11);
                unit = Unit.f56620a;
            } else {
                unit = null;
            }
            if (unit == null) {
                h0 h0Var = this.f57171c;
                Ref$ObjectRef<b1<T>> ref$ObjectRef = this.f57170b;
                t<j1<T>> tVar = this.f57172d;
                T a11 = k1.a(t11);
                tVar.p(new d1(a11, p1.k(h0Var.getCoroutineContext())));
                ref$ObjectRef.element = a11;
            }
            return Unit.f56620a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ShareKt$launchSharingDeferred$1(d<? extends T> dVar, t<j1<T>> tVar, c<? super FlowKt__ShareKt$launchSharingDeferred$1> cVar) {
        super(2, cVar);
        this.$upstream = dVar;
        this.$result = tVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, this.$result, cVar);
        flowKt__ShareKt$launchSharingDeferred$1.L$0 = obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            h0 h0Var = (h0) this.L$0;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            d<T> dVar = this.$upstream;
            a aVar = new a(ref$ObjectRef, h0Var, this.$result);
            this.label = 1;
            if (dVar.collect(aVar, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            try {
                k.b(obj);
            } catch (Throwable th2) {
                this.$result.o(th2);
                throw th2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
