package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.v0;

@d(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {84}, m = "invokeSuspend")
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ p<h0, c<? super Unit>, Object> $block;
    public final /* synthetic */ Lifecycle.State $state;
    public final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    public int label;

    @d(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {166}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public Object L$5;
        public int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(lifecycle, state, h0Var, pVar, cVar);
        }

        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                r16 = this;
                r1 = r16
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r1.label
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L_0x0038
                if (r2 != r4) goto L_0x0030
                java.lang.Object r0 = r1.L$5
                d10.p r0 = (d10.p) r0
                java.lang.Object r0 = r1.L$4
                kotlinx.coroutines.h0 r0 = (kotlinx.coroutines.h0) r0
                java.lang.Object r0 = r1.L$3
                androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
                java.lang.Object r0 = r1.L$2
                androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
                java.lang.Object r0 = r1.L$1
                r2 = r0
                kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
                java.lang.Object r0 = r1.L$0
                r5 = r0
                kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref$ObjectRef) r5
                kotlin.k.b(r17)     // Catch:{ all -> 0x002d }
                goto L_0x00a7
            L_0x002d:
                r0 = move-exception
                goto L_0x00c2
            L_0x0030:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0038:
                kotlin.k.b(r17)
                androidx.lifecycle.Lifecycle r2 = r4
                androidx.lifecycle.Lifecycle$State r2 = r2.b()
                androidx.lifecycle.Lifecycle$State r5 = androidx.lifecycle.Lifecycle.State.DESTROYED
                if (r2 != r5) goto L_0x0048
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            L_0x0048:
                kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
                r2.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r13 = new kotlin.jvm.internal.Ref$ObjectRef
                r13.<init>()
                androidx.lifecycle.Lifecycle$State r5 = r5     // Catch:{ all -> 0x00bf }
                androidx.lifecycle.Lifecycle r14 = r4     // Catch:{ all -> 0x00bf }
                kotlinx.coroutines.h0 r8 = r6     // Catch:{ all -> 0x00bf }
                d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super kotlin.Unit>, java.lang.Object> r12 = r7     // Catch:{ all -> 0x00bf }
                r1.L$0 = r2     // Catch:{ all -> 0x00bf }
                r1.L$1 = r13     // Catch:{ all -> 0x00bf }
                r1.L$2 = r5     // Catch:{ all -> 0x00bf }
                r1.L$3 = r14     // Catch:{ all -> 0x00bf }
                r1.L$4 = r8     // Catch:{ all -> 0x00bf }
                r1.L$5 = r12     // Catch:{ all -> 0x00bf }
                r1.label = r4     // Catch:{ all -> 0x00bf }
                kotlinx.coroutines.l r15 = new kotlinx.coroutines.l     // Catch:{ all -> 0x00bf }
                kotlin.coroutines.c r6 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.c(r16)     // Catch:{ all -> 0x00bf }
                r15.<init>(r6, r4)     // Catch:{ all -> 0x00bf }
                r15.A()     // Catch:{ all -> 0x00bf }
                androidx.lifecycle.Lifecycle$Event$a r6 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch:{ all -> 0x00bf }
                androidx.lifecycle.Lifecycle$Event r7 = r6.d(r5)     // Catch:{ all -> 0x00bf }
                androidx.lifecycle.Lifecycle$Event r9 = r6.a(r5)     // Catch:{ all -> 0x00bf }
                r5 = 0
                kotlinx.coroutines.sync.a r11 = kotlinx.coroutines.sync.MutexKt.b(r5, r4, r3)     // Catch:{ all -> 0x00bf }
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r10 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch:{ all -> 0x00bf }
                r5 = r10
                r6 = r7
                r7 = r2
                r3 = r10
                r10 = r15
                r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00bf }
                r13.element = r3     // Catch:{ all -> 0x00bf }
                r10 = r3
                androidx.lifecycle.r r10 = (androidx.lifecycle.r) r10     // Catch:{ all -> 0x00bf }
                r14.a(r10)     // Catch:{ all -> 0x00bf }
                java.lang.Object r3 = r15.v()     // Catch:{ all -> 0x00bf }
                java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()     // Catch:{ all -> 0x00bf }
                if (r3 != r5) goto L_0x00a2
                kotlin.coroutines.jvm.internal.f.c(r16)     // Catch:{ all -> 0x00bf }
            L_0x00a2:
                if (r3 != r0) goto L_0x00a5
                return r0
            L_0x00a5:
                r5 = r2
                r2 = r13
            L_0x00a7:
                T r0 = r5.element
                kotlinx.coroutines.n1 r0 = (kotlinx.coroutines.n1) r0
                if (r0 == 0) goto L_0x00b1
                r3 = 0
                kotlinx.coroutines.n1.a.a(r0, r3, r4, r3)
            L_0x00b1:
                T r0 = r2.element
                androidx.lifecycle.r r0 = (androidx.lifecycle.r) r0
                if (r0 == 0) goto L_0x00bc
                androidx.lifecycle.Lifecycle r2 = r4
                r2.d(r0)
            L_0x00bc:
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            L_0x00bf:
                r0 = move-exception
                r5 = r2
                r2 = r13
            L_0x00c2:
                T r3 = r5.element
                kotlinx.coroutines.n1 r3 = (kotlinx.coroutines.n1) r3
                if (r3 == 0) goto L_0x00cc
                r5 = 0
                kotlinx.coroutines.n1.a.a(r3, r5, r4, r5)
            L_0x00cc:
                T r2 = r2.element
                androidx.lifecycle.r r2 = (androidx.lifecycle.r) r2
                if (r2 == 0) goto L_0x00d7
                androidx.lifecycle.Lifecycle r3 = r4
                r3.d(r2)
            L_0x00d7:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, p<? super h0, ? super c<? super Unit>, ? extends Object> pVar, c<? super RepeatOnLifecycleKt$repeatOnLifecycle$3> cVar) {
        super(2, cVar);
        this.$this_repeatOnLifecycle = lifecycle;
        this.$state = state;
        this.$block = pVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, cVar);
        repeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            final h0 h0Var = (h0) this.L$0;
            MainCoroutineDispatcher G = v0.c().G();
            final Lifecycle lifecycle = this.$this_repeatOnLifecycle;
            final Lifecycle.State state = this.$state;
            final p<h0, c<? super Unit>, Object> pVar = this.$block;
            AnonymousClass1 r32 = new AnonymousClass1((c<? super AnonymousClass1>) null);
            this.label = 1;
            if (g.g(G, r32, this) == d11) {
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
