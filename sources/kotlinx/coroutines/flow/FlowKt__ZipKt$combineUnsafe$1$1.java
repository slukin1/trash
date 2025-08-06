package kotlinx.coroutines.flow;

import d10.p;
import d10.q;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.x;

@d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineUnsafe$1$1", f = "Zip.kt", l = {262, 262}, m = "invokeSuspend")
public final class FlowKt__ZipKt$combineUnsafe$1$1 extends SuspendLambda implements q<e<Object>, Object[], c<? super Unit>, Object> {
    public final /* synthetic */ p<Object[], c<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineUnsafe$1$1(p<? super Object[], ? super c<Object>, ? extends Object> pVar, c<? super FlowKt__ZipKt$combineUnsafe$1$1> cVar) {
        super(3, cVar);
        this.$transform = pVar;
    }

    public final Object invoke(e<Object> eVar, Object[] objArr, c<? super Unit> cVar) {
        x.e();
        FlowKt__ZipKt$combineUnsafe$1$1 flowKt__ZipKt$combineUnsafe$1$1 = new FlowKt__ZipKt$combineUnsafe$1$1(this.$transform, cVar);
        flowKt__ZipKt$combineUnsafe$1$1.L$0 = eVar;
        flowKt__ZipKt$combineUnsafe$1$1.L$1 = objArr;
        return flowKt__ZipKt$combineUnsafe$1$1.invokeSuspend(Unit.f56620a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.e} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.k.b(r6)
            goto L_0x0047
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            java.lang.Object r1 = r5.L$0
            kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
            kotlin.k.b(r6)
            goto L_0x003b
        L_0x0022:
            kotlin.k.b(r6)
            java.lang.Object r6 = r5.L$0
            r1 = r6
            kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
            java.lang.Object r6 = r5.L$1
            java.lang.Object[] r6 = (java.lang.Object[]) r6
            d10.p<java.lang.Object[], kotlin.coroutines.c<java.lang.Object>, java.lang.Object> r4 = r5.$transform
            r5.L$0 = r1
            r5.label = r3
            java.lang.Object r6 = r4.invoke(r6, r5)
            if (r6 != r0) goto L_0x003b
            return r0
        L_0x003b:
            r3 = 0
            r5.L$0 = r3
            r5.label = r2
            java.lang.Object r6 = r1.emit(r6, r5)
            if (r6 != r0) goto L_0x0047
            return r0
        L_0x0047:
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combineUnsafe$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        Object invoke = this.$transform.invoke((Object[]) this.L$1, this);
        InlineMarker.c(0);
        ((e) this.L$0).emit(invoke, this);
        InlineMarker.c(1);
        return Unit.f56620a;
    }
}
