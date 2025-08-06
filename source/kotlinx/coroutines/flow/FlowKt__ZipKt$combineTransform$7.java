package kotlinx.coroutines.flow;

import d10.a;
import d10.p;
import d10.q;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.flow.internal.CombineKt;

@d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7", f = "Zip.kt", l = {308}, m = "invokeSuspend")
public final class FlowKt__ZipKt$combineTransform$7 extends SuspendLambda implements p<e<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ d<Object>[] $flowArray;
    public final /* synthetic */ q<e<Object>, Object[], c<? super Unit>, Object> $transform;
    private /* synthetic */ Object L$0;
    public int label;

    @d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2", f = "Zip.kt", l = {308}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements q<e<Object>, Object[], c<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public /* synthetic */ Object L$1;
        public int label;

        public final Object invoke(e<Object> eVar, Object[] objArr, c<? super Unit> cVar) {
            x.e();
            AnonymousClass2 r02 = new AnonymousClass2(r3, cVar);
            r02.L$0 = eVar;
            r02.L$1 = objArr;
            return r02.invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.label;
            if (i11 == 0) {
                k.b(obj);
                q<e<Object>, Object[], c<? super Unit>, Object> qVar = r3;
                this.L$0 = null;
                this.label = 1;
                if (qVar.invoke((e) this.L$0, (Object[]) this.L$1, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            r3.invoke((e) this.L$0, (Object[]) this.L$1, this);
            return Unit.f56620a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$7(d<Object>[] dVarArr, q<? super e<Object>, ? super Object[], ? super c<? super Unit>, ? extends Object> qVar, c<? super FlowKt__ZipKt$combineTransform$7> cVar) {
        super(2, cVar);
        this.$flowArray = dVarArr;
        this.$transform = qVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        FlowKt__ZipKt$combineTransform$7 flowKt__ZipKt$combineTransform$7 = new FlowKt__ZipKt$combineTransform$7(this.$flowArray, this.$transform, cVar);
        flowKt__ZipKt$combineTransform$7.L$0 = obj;
        return flowKt__ZipKt$combineTransform$7;
    }

    public final Object invoke(e<Object> eVar, c<? super Unit> cVar) {
        return ((FlowKt__ZipKt$combineTransform$7) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            d<Object>[] dVarArr = this.$flowArray;
            x.e();
            final d<Object>[] dVarArr2 = this.$flowArray;
            AnonymousClass1 r32 = new a<Object[]>() {
                public final Object[] invoke() {
                    int length = r2.length;
                    x.f(0, "T?");
                    return new Object[length];
                }
            };
            x.e();
            final q<e<Object>, Object[], c<? super Unit>, Object> qVar = this.$transform;
            AnonymousClass2 r42 = new AnonymousClass2((c<? super AnonymousClass2>) null);
            this.label = 1;
            if (CombineKt.a((e) this.L$0, dVarArr, r32, r42, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        d<Object>[] dVarArr = this.$flowArray;
        x.e();
        final d<Object>[] dVarArr2 = this.$flowArray;
        AnonymousClass1 r12 = new a<Object[]>() {
            public final Object[] invoke() {
                int length = dVarArr2.length;
                x.f(0, "T?");
                return new Object[length];
            }
        };
        x.e();
        final q<e<Object>, Object[], c<? super Unit>, Object> qVar = this.$transform;
        AnonymousClass2 r22 = new AnonymousClass2((c<? super AnonymousClass2>) null);
        InlineMarker.c(0);
        CombineKt.a((e) this.L$0, dVarArr, r12, r22, this);
        InlineMarker.c(1);
        return Unit.f56620a;
    }
}
