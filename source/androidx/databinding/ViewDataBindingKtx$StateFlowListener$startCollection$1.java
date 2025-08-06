package androidx.databinding;

import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.h0;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/h0;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@d(c = "androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1", f = "ViewDataBindingKtx.kt", l = {116}, m = "invokeSuspend")
final class ViewDataBindingKtx$StateFlowListener$startCollection$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ kotlinx.coroutines.flow.d $flow;
    public int label;
    public final /* synthetic */ g this$0;

    @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/r", "Lkotlinx/coroutines/flow/e;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
    public static final class a implements e<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewDataBindingKtx$StateFlowListener$startCollection$1 f8866b;

        public a(ViewDataBindingKtx$StateFlowListener$startCollection$1 viewDataBindingKtx$StateFlowListener$startCollection$1) {
            this.f8866b = viewDataBindingKtx$StateFlowListener$startCollection$1;
        }

        public Object emit(Object obj, c cVar) {
            Unit unit;
            f a11 = g.d(this.f8866b.this$0).a();
            if (a11 != null) {
                a11.q(g.d(this.f8866b.this$0).f8912b, g.d(this.f8866b.this$0).b(), 0);
                unit = Unit.f56620a;
            } else {
                unit = null;
            }
            if (unit == IntrinsicsKt__IntrinsicsKt.d()) {
                return unit;
            }
            return Unit.f56620a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewDataBindingKtx$StateFlowListener$startCollection$1(g gVar, kotlinx.coroutines.flow.d dVar, c cVar) {
        super(2, cVar);
        this.$flow = dVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ViewDataBindingKtx$StateFlowListener$startCollection$1(this.this$0, this.$flow, cVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ViewDataBindingKtx$StateFlowListener$startCollection$1) create(obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            kotlinx.coroutines.flow.d dVar = this.$flow;
            a aVar = new a(this);
            this.label = 1;
            if (dVar.collect(aVar, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
