package kotlin.io.path;

import d10.p;
import java.nio.file.Path;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.sequences.SequenceScope;

@d(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", l = {184, 190}, m = "invokeSuspend")
public final class PathTreeWalk$bfsIterator$1 extends RestrictedSuspendLambda implements p<SequenceScope<? super Path>, c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public int label;
    public final /* synthetic */ PathTreeWalk this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PathTreeWalk$bfsIterator$1(PathTreeWalk pathTreeWalk, c<? super PathTreeWalk$bfsIterator$1> cVar) {
        super(2, cVar);
        this.this$0 = pathTreeWalk;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        PathTreeWalk$bfsIterator$1 pathTreeWalk$bfsIterator$1 = new PathTreeWalk$bfsIterator$1(this.this$0, cVar);
        pathTreeWalk$bfsIterator$1.L$0 = obj;
        return pathTreeWalk$bfsIterator$1;
    }

    public final Object invoke(SequenceScope<? super Path> sequenceScope, c<? super Unit> cVar) {
        return ((PathTreeWalk$bfsIterator$1) create(sequenceScope, cVar)).invokeSuspend(Unit.f56620a);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x012e A[SYNTHETIC] */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r14.label
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0046
            if (r1 == r4) goto L_0x0028
            if (r1 != r2) goto L_0x0020
            java.lang.Object r1 = r14.L$2
            kotlin.io.path.c r1 = (kotlin.io.path.c) r1
            java.lang.Object r5 = r14.L$1
            kotlin.collections.ArrayDeque r5 = (kotlin.collections.ArrayDeque) r5
            java.lang.Object r6 = r14.L$0
            kotlin.sequences.SequenceScope r6 = (kotlin.sequences.SequenceScope) r6
            kotlin.k.b(r15)
            r15 = r14
            goto L_0x0080
        L_0x0020:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0028:
            java.lang.Object r1 = r14.L$5
            java.nio.file.Path r1 = (java.nio.file.Path) r1
            java.lang.Object r5 = r14.L$4
            kotlin.io.path.PathTreeWalk r5 = (kotlin.io.path.PathTreeWalk) r5
            java.lang.Object r6 = r14.L$3
            kotlin.io.path.f r6 = (kotlin.io.path.f) r6
            java.lang.Object r7 = r14.L$2
            kotlin.io.path.c r7 = (kotlin.io.path.c) r7
            java.lang.Object r8 = r14.L$1
            kotlin.collections.ArrayDeque r8 = (kotlin.collections.ArrayDeque) r8
            java.lang.Object r9 = r14.L$0
            kotlin.sequences.SequenceScope r9 = (kotlin.sequences.SequenceScope) r9
            kotlin.k.b(r15)
            r15 = r14
            goto L_0x00d4
        L_0x0046:
            kotlin.k.b(r15)
            java.lang.Object r15 = r14.L$0
            kotlin.sequences.SequenceScope r15 = (kotlin.sequences.SequenceScope) r15
            kotlin.collections.ArrayDeque r1 = new kotlin.collections.ArrayDeque
            r1.<init>()
            kotlin.io.path.c r5 = new kotlin.io.path.c
            kotlin.io.path.PathTreeWalk r6 = r14.this$0
            boolean r6 = r6.h()
            r5.<init>(r6)
            kotlin.io.path.f r6 = new kotlin.io.path.f
            kotlin.io.path.PathTreeWalk r7 = r14.this$0
            java.nio.file.Path r7 = r7.f56734a
            kotlin.io.path.PathTreeWalk r8 = r14.this$0
            java.nio.file.Path r8 = r8.f56734a
            kotlin.io.path.PathTreeWalk r9 = r14.this$0
            java.nio.file.LinkOption[] r9 = r9.j()
            java.lang.Object r8 = kotlin.io.path.h.b(r8, r9)
            r6.<init>(r7, r8, r3)
            r1.addLast(r6)
            r6 = r15
            r15 = r14
            r12 = r5
            r5 = r1
            r1 = r12
        L_0x0080:
            boolean r7 = r5.isEmpty()
            r7 = r7 ^ r4
            if (r7 == 0) goto L_0x012e
            java.lang.Object r7 = r5.removeFirst()
            kotlin.io.path.f r7 = (kotlin.io.path.f) r7
            kotlin.io.path.PathTreeWalk r8 = r15.this$0
            java.nio.file.Path r9 = r7.d()
            java.nio.file.LinkOption[] r10 = r8.j()
            int r11 = r10.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r11)
            java.nio.file.LinkOption[] r10 = (java.nio.file.LinkOption[]) r10
            int r11 = r10.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r11)
            java.nio.file.LinkOption[] r10 = (java.nio.file.LinkOption[]) r10
            boolean r10 = java.nio.file.Files.isDirectory(r9, r10)
            if (r10 == 0) goto L_0x0106
            boolean r10 = kotlin.io.path.h.a(r7)
            if (r10 != 0) goto L_0x00fc
            boolean r10 = r8.i()
            if (r10 == 0) goto L_0x00dc
            r15.L$0 = r6
            r15.L$1 = r5
            r15.L$2 = r1
            r15.L$3 = r7
            r15.L$4 = r8
            r15.L$5 = r9
            r15.label = r4
            java.lang.Object r10 = r6.b(r9, r15)
            if (r10 != r0) goto L_0x00cc
            return r0
        L_0x00cc:
            r12 = r7
            r7 = r1
            r1 = r9
            r9 = r6
            r6 = r12
            r13 = r8
            r8 = r5
            r5 = r13
        L_0x00d4:
            r12 = r9
            r9 = r1
            r1 = r7
            r7 = r6
            r6 = r12
            r13 = r8
            r8 = r5
            r5 = r13
        L_0x00dc:
            java.nio.file.LinkOption[] r8 = r8.j()
            int r10 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r10)
            java.nio.file.LinkOption[] r8 = (java.nio.file.LinkOption[]) r8
            int r10 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r10)
            java.nio.file.LinkOption[] r8 = (java.nio.file.LinkOption[]) r8
            boolean r8 = java.nio.file.Files.isDirectory(r9, r8)
            if (r8 == 0) goto L_0x0080
            java.util.List r7 = r1.b(r7)
            r5.addAll(r7)
            goto L_0x0080
        L_0x00fc:
            java.nio.file.FileSystemLoopException r15 = new java.nio.file.FileSystemLoopException
            java.lang.String r0 = r9.toString()
            r15.<init>(r0)
            throw r15
        L_0x0106:
            java.nio.file.LinkOption[] r7 = new java.nio.file.LinkOption[r4]
            r8 = 0
            java.nio.file.LinkOption r10 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            r7[r8] = r10
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r4)
            java.nio.file.LinkOption[] r7 = (java.nio.file.LinkOption[]) r7
            boolean r7 = java.nio.file.Files.exists(r9, r7)
            if (r7 == 0) goto L_0x0080
            r15.L$0 = r6
            r15.L$1 = r5
            r15.L$2 = r1
            r15.L$3 = r3
            r15.L$4 = r3
            r15.L$5 = r3
            r15.label = r2
            java.lang.Object r7 = r6.b(r9, r15)
            if (r7 != r0) goto L_0x0080
            return r0
        L_0x012e:
            kotlin.Unit r15 = kotlin.Unit.f56620a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$bfsIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
