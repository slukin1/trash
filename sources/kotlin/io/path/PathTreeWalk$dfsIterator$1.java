package kotlin.io.path;

import d10.p;
import java.nio.file.Path;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.sequences.SequenceScope;

@d(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", l = {184, 190, 199, 205}, m = "invokeSuspend")
public final class PathTreeWalk$dfsIterator$1 extends RestrictedSuspendLambda implements p<SequenceScope<? super Path>, c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public int label;
    public final /* synthetic */ PathTreeWalk this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PathTreeWalk$dfsIterator$1(PathTreeWalk pathTreeWalk, c<? super PathTreeWalk$dfsIterator$1> cVar) {
        super(2, cVar);
        this.this$0 = pathTreeWalk;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        PathTreeWalk$dfsIterator$1 pathTreeWalk$dfsIterator$1 = new PathTreeWalk$dfsIterator$1(this.this$0, cVar);
        pathTreeWalk$dfsIterator$1.L$0 = obj;
        return pathTreeWalk$dfsIterator$1;
    }

    public final Object invoke(SequenceScope<? super Path> sequenceScope, c<? super Unit> cVar) {
        return ((PathTreeWalk$dfsIterator$1) create(sequenceScope, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: kotlin.sequences.SequenceScope} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0212 A[SYNTHETIC] */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = 1
            if (r2 == 0) goto L_0x006f
            if (r2 == r8) goto L_0x0052
            if (r2 == r6) goto L_0x0018
            if (r2 == r5) goto L_0x0031
            if (r2 != r4) goto L_0x0029
        L_0x0018:
            java.lang.Object r2 = r0.L$2
            kotlin.io.path.c r2 = (kotlin.io.path.c) r2
            java.lang.Object r6 = r0.L$1
            kotlin.collections.ArrayDeque r6 = (kotlin.collections.ArrayDeque) r6
            java.lang.Object r9 = r0.L$0
            kotlin.sequences.SequenceScope r9 = (kotlin.sequences.SequenceScope) r9
            kotlin.k.b(r19)
            goto L_0x013f
        L_0x0029:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0031:
            java.lang.Object r2 = r0.L$5
            java.nio.file.Path r2 = (java.nio.file.Path) r2
            java.lang.Object r6 = r0.L$4
            kotlin.io.path.PathTreeWalk r6 = (kotlin.io.path.PathTreeWalk) r6
            java.lang.Object r9 = r0.L$3
            kotlin.io.path.f r9 = (kotlin.io.path.f) r9
            java.lang.Object r10 = r0.L$2
            kotlin.io.path.c r10 = (kotlin.io.path.c) r10
            java.lang.Object r11 = r0.L$1
            kotlin.collections.ArrayDeque r11 = (kotlin.collections.ArrayDeque) r11
            java.lang.Object r12 = r0.L$0
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.k.b(r19)
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r0
            goto L_0x01a8
        L_0x0052:
            java.lang.Object r2 = r0.L$5
            java.nio.file.Path r2 = (java.nio.file.Path) r2
            java.lang.Object r6 = r0.L$4
            kotlin.io.path.PathTreeWalk r6 = (kotlin.io.path.PathTreeWalk) r6
            java.lang.Object r9 = r0.L$3
            kotlin.io.path.f r9 = (kotlin.io.path.f) r9
            java.lang.Object r10 = r0.L$2
            kotlin.io.path.c r10 = (kotlin.io.path.c) r10
            java.lang.Object r11 = r0.L$1
            kotlin.collections.ArrayDeque r11 = (kotlin.collections.ArrayDeque) r11
            java.lang.Object r12 = r0.L$0
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.k.b(r19)
            goto L_0x00e6
        L_0x006f:
            kotlin.k.b(r19)
            java.lang.Object r2 = r0.L$0
            r9 = r2
            kotlin.sequences.SequenceScope r9 = (kotlin.sequences.SequenceScope) r9
            kotlin.collections.ArrayDeque r2 = new kotlin.collections.ArrayDeque
            r2.<init>()
            kotlin.io.path.c r10 = new kotlin.io.path.c
            kotlin.io.path.PathTreeWalk r11 = r0.this$0
            boolean r11 = r11.h()
            r10.<init>(r11)
            kotlin.io.path.f r11 = new kotlin.io.path.f
            kotlin.io.path.PathTreeWalk r12 = r0.this$0
            java.nio.file.Path r12 = r12.f56734a
            kotlin.io.path.PathTreeWalk r13 = r0.this$0
            java.nio.file.Path r13 = r13.f56734a
            kotlin.io.path.PathTreeWalk r14 = r0.this$0
            java.nio.file.LinkOption[] r14 = r14.j()
            java.lang.Object r13 = kotlin.io.path.h.d(r13, r14)
            r11.<init>(r12, r13, r7)
            kotlin.io.path.PathTreeWalk r12 = r0.this$0
            java.nio.file.Path r13 = r11.d()
            java.nio.file.LinkOption[] r14 = r12.j()
            int r15 = r14.length
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r15)
            java.nio.file.LinkOption[] r14 = (java.nio.file.LinkOption[]) r14
            int r15 = r14.length
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r15)
            java.nio.file.LinkOption[] r14 = (java.nio.file.LinkOption[]) r14
            boolean r14 = java.nio.file.Files.isDirectory(r13, r14)
            if (r14 == 0) goto L_0x011c
            boolean r6 = kotlin.io.path.h.c(r11)
            if (r6 != 0) goto L_0x0112
            boolean r6 = r12.i()
            if (r6 == 0) goto L_0x00eb
            r0.L$0 = r9
            r0.L$1 = r2
            r0.L$2 = r10
            r0.L$3 = r11
            r0.L$4 = r12
            r0.L$5 = r13
            r0.label = r8
            java.lang.Object r6 = r9.b(r13, r0)
            if (r6 != r1) goto L_0x00e1
            return r1
        L_0x00e1:
            r6 = r12
            r12 = r9
            r9 = r11
            r11 = r2
            r2 = r13
        L_0x00e6:
            r13 = r2
            r2 = r11
            r11 = r9
            r9 = r12
            r12 = r6
        L_0x00eb:
            java.nio.file.LinkOption[] r6 = r12.j()
            int r12 = r6.length
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r12)
            java.nio.file.LinkOption[] r6 = (java.nio.file.LinkOption[]) r6
            int r12 = r6.length
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r12)
            java.nio.file.LinkOption[] r6 = (java.nio.file.LinkOption[]) r6
            boolean r6 = java.nio.file.Files.isDirectory(r13, r6)
            if (r6 == 0) goto L_0x013d
            java.util.List r6 = r10.b(r11)
            java.util.Iterator r6 = r6.iterator()
            r11.e(r6)
            r2.addLast(r11)
            goto L_0x013d
        L_0x0112:
            java.nio.file.FileSystemLoopException r1 = new java.nio.file.FileSystemLoopException
            java.lang.String r2 = r13.toString()
            r1.<init>(r2)
            throw r1
        L_0x011c:
            java.nio.file.LinkOption[] r11 = new java.nio.file.LinkOption[r8]
            java.nio.file.LinkOption r12 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            r11[r3] = r12
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r8)
            java.nio.file.LinkOption[] r11 = (java.nio.file.LinkOption[]) r11
            boolean r11 = java.nio.file.Files.exists(r13, r11)
            if (r11 == 0) goto L_0x013d
            r0.L$0 = r9
            r0.L$1 = r2
            r0.L$2 = r10
            r0.label = r6
            java.lang.Object r6 = r9.b(r13, r0)
            if (r6 != r1) goto L_0x013d
            return r1
        L_0x013d:
            r6 = r2
            r2 = r10
        L_0x013f:
            r10 = r0
        L_0x0140:
            boolean r11 = r6.isEmpty()
            r11 = r11 ^ r8
            if (r11 == 0) goto L_0x0212
            java.lang.Object r11 = r6.last()
            kotlin.io.path.f r11 = (kotlin.io.path.f) r11
            java.util.Iterator r11 = r11.a()
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x020d
            java.lang.Object r11 = r11.next()
            kotlin.io.path.f r11 = (kotlin.io.path.f) r11
            kotlin.io.path.PathTreeWalk r12 = r10.this$0
            java.nio.file.Path r13 = r11.d()
            java.nio.file.LinkOption[] r14 = r12.j()
            int r15 = r14.length
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r15)
            java.nio.file.LinkOption[] r14 = (java.nio.file.LinkOption[]) r14
            int r15 = r14.length
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r15)
            java.nio.file.LinkOption[] r14 = (java.nio.file.LinkOption[]) r14
            boolean r14 = java.nio.file.Files.isDirectory(r13, r14)
            if (r14 == 0) goto L_0x01e6
            boolean r14 = kotlin.io.path.h.c(r11)
            if (r14 != 0) goto L_0x01dc
            boolean r14 = r12.i()
            if (r14 == 0) goto L_0x01b4
            r10.L$0 = r9
            r10.L$1 = r6
            r10.L$2 = r2
            r10.L$3 = r11
            r10.L$4 = r12
            r10.L$5 = r13
            r10.label = r5
            java.lang.Object r14 = r9.b(r13, r10)
            if (r14 != r1) goto L_0x019c
            return r1
        L_0x019c:
            r16 = r11
            r11 = r2
            r2 = r13
            r13 = r9
            r9 = r16
            r17 = r12
            r12 = r6
            r6 = r17
        L_0x01a8:
            r16 = r13
            r13 = r2
            r2 = r11
            r11 = r9
            r9 = r16
            r17 = r12
            r12 = r6
            r6 = r17
        L_0x01b4:
            java.nio.file.LinkOption[] r12 = r12.j()
            int r14 = r12.length
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r14)
            java.nio.file.LinkOption[] r12 = (java.nio.file.LinkOption[]) r12
            int r14 = r12.length
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r14)
            java.nio.file.LinkOption[] r12 = (java.nio.file.LinkOption[]) r12
            boolean r12 = java.nio.file.Files.isDirectory(r13, r12)
            if (r12 == 0) goto L_0x0140
            java.util.List r12 = r2.b(r11)
            java.util.Iterator r12 = r12.iterator()
            r11.e(r12)
            r6.addLast(r11)
            goto L_0x0140
        L_0x01dc:
            java.nio.file.FileSystemLoopException r1 = new java.nio.file.FileSystemLoopException
            java.lang.String r2 = r13.toString()
            r1.<init>(r2)
            throw r1
        L_0x01e6:
            java.nio.file.LinkOption[] r11 = new java.nio.file.LinkOption[r8]
            java.nio.file.LinkOption r12 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            r11[r3] = r12
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r8)
            java.nio.file.LinkOption[] r11 = (java.nio.file.LinkOption[]) r11
            boolean r11 = java.nio.file.Files.exists(r13, r11)
            if (r11 == 0) goto L_0x0140
            r10.L$0 = r9
            r10.L$1 = r6
            r10.L$2 = r2
            r10.L$3 = r7
            r10.L$4 = r7
            r10.L$5 = r7
            r10.label = r4
            java.lang.Object r11 = r9.b(r13, r10)
            if (r11 != r1) goto L_0x0140
            return r1
        L_0x020d:
            r6.removeLast()
            goto L_0x0140
        L_0x0212:
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$dfsIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
