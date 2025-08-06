package kotlinx.coroutines.flow;

import d10.a;
import d10.p;
import d10.q;
import d10.s;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.InlineMarker;
import kotlin.k;
import kotlinx.coroutines.flow.internal.CombineKt;

@d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3", f = "Zip.kt", l = {273}, m = "invokeSuspend")
public final class FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3 extends SuspendLambda implements p<e<? super R>, c<? super Unit>, Object> {
    public final /* synthetic */ d[] $flows;
    public final /* synthetic */ s $transform$inlined;
    private /* synthetic */ Object L$0;
    public int label;

    @d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3$1", f = "Zip.kt", l = {333}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements q<e<? super R>, Object[], c<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public /* synthetic */ Object L$1;
        public int label;

        public final Object invoke(e<? super R> eVar, Object[] objArr, c<? super Unit> cVar) {
            AnonymousClass1 r02 = new AnonymousClass1(cVar, sVar);
            r02.L$0 = eVar;
            r02.L$1 = objArr;
            return r02.invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.label;
            if (i11 == 0) {
                k.b(obj);
                Object[] objArr = (Object[]) this.L$1;
                s sVar = sVar;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                this.label = 1;
                InlineMarker.c(6);
                Object invoke = sVar.invoke((e) this.L$0, obj2, obj3, obj4, this);
                InlineMarker.c(7);
                if (invoke == d11) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3(d[] dVarArr, c cVar, s sVar) {
        super(2, cVar);
        this.$flows = dVarArr;
        this.$transform$inlined = sVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3 flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3 = new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3(this.$flows, cVar, this.$transform$inlined);
        flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3.L$0 = obj;
        return flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3;
    }

    public final Object invoke(e<? super R> eVar, c<? super Unit> cVar) {
        return ((FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            d[] dVarArr = this.$flows;
            a a11 = FlowKt__ZipKt.h();
            final s sVar = this.$transform$inlined;
            AnonymousClass1 r42 = new AnonymousClass1((c) null);
            this.label = 1;
            if (CombineKt.a((e) this.L$0, dVarArr, a11, r42, this) == d11) {
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
