package kotlinx.coroutines.flow;

import d10.q;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", l = {178, 180, 182, 183, 185}, m = "invokeSuspend")
public final class StartedWhileSubscribed$command$1 extends SuspendLambda implements q<e<? super SharingCommand>, Integer, c<? super Unit>, Object> {
    public /* synthetic */ int I$0;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ StartedWhileSubscribed this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StartedWhileSubscribed$command$1(StartedWhileSubscribed startedWhileSubscribed, c<? super StartedWhileSubscribed$command$1> cVar) {
        super(3, cVar);
        this.this$0 = startedWhileSubscribed;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((e<? super SharingCommand>) (e) obj, ((Number) obj2).intValue(), (c<? super Unit>) (c) obj3);
    }

    public final Object invoke(e<? super SharingCommand> eVar, int i11, c<? super Unit> cVar) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.this$0, cVar);
        startedWhileSubscribed$command$1.L$0 = eVar;
        startedWhileSubscribed$command$1.I$0 = i11;
        return startedWhileSubscribed$command$1.invokeSuspend(Unit.f56620a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.flow.e} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r9.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L_0x003c
            if (r1 == r6) goto L_0x0038
            if (r1 == r5) goto L_0x0030
            if (r1 == r4) goto L_0x0028
            if (r1 == r3) goto L_0x0020
            if (r1 != r2) goto L_0x0018
            goto L_0x0038
        L_0x0018:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0020:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
            kotlin.k.b(r10)
            goto L_0x008e
        L_0x0028:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
            kotlin.k.b(r10)
            goto L_0x007d
        L_0x0030:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
            kotlin.k.b(r10)
            goto L_0x0064
        L_0x0038:
            kotlin.k.b(r10)
            goto L_0x009c
        L_0x003c:
            kotlin.k.b(r10)
            java.lang.Object r10 = r9.L$0
            r1 = r10
            kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
            int r10 = r9.I$0
            if (r10 <= 0) goto L_0x0053
            kotlinx.coroutines.flow.SharingCommand r10 = kotlinx.coroutines.flow.SharingCommand.START
            r9.label = r6
            java.lang.Object r10 = r1.emit(r10, r9)
            if (r10 != r0) goto L_0x009c
            return r0
        L_0x0053:
            kotlinx.coroutines.flow.StartedWhileSubscribed r10 = r9.this$0
            long r6 = r10.f57205b
            r9.L$0 = r1
            r9.label = r5
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r6, r9)
            if (r10 != r0) goto L_0x0064
            return r0
        L_0x0064:
            kotlinx.coroutines.flow.StartedWhileSubscribed r10 = r9.this$0
            long r5 = r10.f57206c
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 <= 0) goto L_0x008e
            kotlinx.coroutines.flow.SharingCommand r10 = kotlinx.coroutines.flow.SharingCommand.STOP
            r9.L$0 = r1
            r9.label = r4
            java.lang.Object r10 = r1.emit(r10, r9)
            if (r10 != r0) goto L_0x007d
            return r0
        L_0x007d:
            kotlinx.coroutines.flow.StartedWhileSubscribed r10 = r9.this$0
            long r4 = r10.f57206c
            r9.L$0 = r1
            r9.label = r3
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r4, r9)
            if (r10 != r0) goto L_0x008e
            return r0
        L_0x008e:
            kotlinx.coroutines.flow.SharingCommand r10 = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE
            r3 = 0
            r9.L$0 = r3
            r9.label = r2
            java.lang.Object r10 = r1.emit(r10, r9)
            if (r10 != r0) goto L_0x009c
            return r0
        L_0x009c:
            kotlin.Unit r10 = kotlin.Unit.f56620a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
