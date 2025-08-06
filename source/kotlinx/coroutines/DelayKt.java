package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.time.b;

public final class DelayKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(kotlin.coroutines.c<?> r4) {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.DelayKt$awaitCancellation$1
            if (r0 == 0) goto L_0x0013
            r0 = r4
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = (kotlinx.coroutines.DelayKt$awaitCancellation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = new kotlinx.coroutines.DelayKt$awaitCancellation$1
            r0.<init>(r4)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 == r3) goto L_0x002d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L_0x002d:
            kotlin.k.b(r4)
            goto L_0x0052
        L_0x0031:
            kotlin.k.b(r4)
            r0.label = r3
            kotlinx.coroutines.l r4 = new kotlinx.coroutines.l
            kotlin.coroutines.c r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.c(r0)
            r4.<init>(r2, r3)
            r4.A()
            java.lang.Object r4 = r4.v()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            if (r4 != r2) goto L_0x004f
            kotlin.coroutines.jvm.internal.f.c(r0)
        L_0x004f:
            if (r4 != r1) goto L_0x0052
            return r1
        L_0x0052:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DelayKt.a(kotlin.coroutines.c):java.lang.Object");
    }

    public static final Object b(long j11, c<? super Unit> cVar) {
        if (j11 <= 0) {
            return Unit.f56620a;
        }
        l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.A();
        if (j11 < Long.MAX_VALUE) {
            c(lVar.getContext()).t(j11, lVar);
        }
        Object v11 = lVar.v();
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            return v11;
        }
        return Unit.f56620a;
    }

    public static final p0 c(CoroutineContext coroutineContext) {
        CoroutineContext.a aVar = coroutineContext.get(d.f56672p0);
        p0 p0Var = aVar instanceof p0 ? (p0) aVar : null;
        return p0Var == null ? m0.a() : p0Var;
    }

    public static final long d(long j11) {
        if (b.h(j11, b.f56931c.b()) > 0) {
            return RangesKt___RangesKt.e(b.o(j11), 1);
        }
        return 0;
    }
}
