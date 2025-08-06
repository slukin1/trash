package kotlinx.coroutines;

import java.util.Collection;
import java.util.List;
import kotlin.coroutines.c;

public final class AwaitKt {
    public static final <T> Object a(Collection<? extends n0<? extends T>> collection, c<? super List<? extends T>> cVar) {
        if (collection.isEmpty()) {
            return CollectionsKt__CollectionsKt.k();
        }
        return new d((n0[]) collection.toArray(new n0[0])).c(cVar);
    }

    public static final <T> Object b(n0<? extends T>[] n0VarArr, c<? super List<? extends T>> cVar) {
        return n0VarArr.length == 0 ? CollectionsKt__CollectionsKt.k() : new d(n0VarArr).c(cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(java.util.Collection<? extends kotlinx.coroutines.n1> r4, kotlin.coroutines.c<? super kotlin.Unit> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.AwaitKt$joinAll$3
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.AwaitKt$joinAll$3 r0 = (kotlinx.coroutines.AwaitKt$joinAll$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.AwaitKt$joinAll$3 r0 = new kotlinx.coroutines.AwaitKt$joinAll$3
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            java.util.Iterator r4 = (java.util.Iterator) r4
            kotlin.k.b(r5)
            goto L_0x003c
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.k.b(r5)
            java.util.Iterator r4 = r4.iterator()
        L_0x003c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0053
            java.lang.Object r5 = r4.next()
            kotlinx.coroutines.n1 r5 = (kotlinx.coroutines.n1) r5
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.F(r0)
            if (r5 != r1) goto L_0x003c
            return r1
        L_0x0053:
            kotlin.Unit r4 = kotlin.Unit.f56620a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.c(java.util.Collection, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object d(kotlinx.coroutines.n1[] r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.AwaitKt$joinAll$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.AwaitKt$joinAll$1 r0 = (kotlinx.coroutines.AwaitKt$joinAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.AwaitKt$joinAll$1 r0 = new kotlinx.coroutines.AwaitKt$joinAll$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            int r6 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.n1[] r4 = (kotlinx.coroutines.n1[]) r4
            kotlin.k.b(r7)
            r7 = r4
            goto L_0x0056
        L_0x0032:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003a:
            kotlin.k.b(r7)
            r7 = 0
            int r2 = r6.length
            r5 = r7
            r7 = r6
            r6 = r2
            r2 = r5
        L_0x0043:
            if (r2 >= r6) goto L_0x0058
            r4 = r7[r2]
            r0.L$0 = r7
            r0.I$0 = r2
            r0.I$1 = r6
            r0.label = r3
            java.lang.Object r4 = r4.F(r0)
            if (r4 != r1) goto L_0x0056
            return r1
        L_0x0056:
            int r2 = r2 + r3
            goto L_0x0043
        L_0x0058:
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.d(kotlinx.coroutines.n1[], kotlin.coroutines.c):java.lang.Object");
    }
}
