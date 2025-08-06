package kotlinx.coroutines.flow;

import d10.l;
import d10.q;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;

@d(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2", f = "Migration.kt", l = {306}, m = "invokeSuspend")
final class FlowKt__MigrationKt$onErrorReturn$2 extends SuspendLambda implements q<e<Object>, Throwable, c<? super Unit>, Object> {
    public final /* synthetic */ Object $fallback;
    public final /* synthetic */ l<Throwable, Boolean> $predicate;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__MigrationKt$onErrorReturn$2(l<? super Throwable, Boolean> lVar, Object obj, c<? super FlowKt__MigrationKt$onErrorReturn$2> cVar) {
        super(3, cVar);
        this.$predicate = lVar;
        this.$fallback = obj;
    }

    public final Object invoke(e<Object> eVar, Throwable th2, c<? super Unit> cVar) {
        FlowKt__MigrationKt$onErrorReturn$2 flowKt__MigrationKt$onErrorReturn$2 = new FlowKt__MigrationKt$onErrorReturn$2(this.$predicate, this.$fallback, cVar);
        flowKt__MigrationKt$onErrorReturn$2.L$0 = eVar;
        flowKt__MigrationKt$onErrorReturn$2.L$1 = th2;
        return flowKt__MigrationKt$onErrorReturn$2.invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            e eVar = (e) this.L$0;
            Throwable th2 = (Throwable) this.L$1;
            if (this.$predicate.invoke(th2).booleanValue()) {
                Object obj2 = this.$fallback;
                this.L$0 = null;
                this.label = 1;
                if (eVar.emit(obj2, this) == d11) {
                    return d11;
                }
            } else {
                throw th2;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
