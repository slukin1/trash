package kotlinx.coroutines.flow;

import d10.q;

public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 implements d<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f57136b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ q f57137c;

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(d dVar, q qVar) {
        this.f57136b = dVar;
        this.f57137c = qVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0086 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(kotlinx.coroutines.flow.e<? super T> r9, kotlin.coroutines.c<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0054
            if (r2 == r5) goto L_0x0046
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.flow.internal.SafeCollector r9 = (kotlinx.coroutines.flow.internal.SafeCollector) r9
            kotlin.k.b(r10)     // Catch:{ all -> 0x0034 }
            goto L_0x0088
        L_0x0034:
            r10 = move-exception
            goto L_0x0092
        L_0x0036:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003e:
            java.lang.Object r9 = r0.L$0
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            kotlin.k.b(r10)
            goto L_0x00ac
        L_0x0046:
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.flow.e r9 = (kotlinx.coroutines.flow.e) r9
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r2 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r2
            kotlin.k.b(r10)     // Catch:{ all -> 0x0052 }
            goto L_0x0067
        L_0x0052:
            r9 = move-exception
            goto L_0x0098
        L_0x0054:
            kotlin.k.b(r10)
            kotlinx.coroutines.flow.d r10 = r8.f57136b     // Catch:{ all -> 0x0096 }
            r0.L$0 = r8     // Catch:{ all -> 0x0096 }
            r0.L$1 = r9     // Catch:{ all -> 0x0096 }
            r0.label = r5     // Catch:{ all -> 0x0096 }
            java.lang.Object r10 = r10.collect(r9, r0)     // Catch:{ all -> 0x0096 }
            if (r10 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r2 = r8
        L_0x0067:
            kotlinx.coroutines.flow.internal.SafeCollector r10 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.CoroutineContext r4 = r0.getContext()
            r10.<init>(r9, r4)
            d10.q r9 = r2.f57137c     // Catch:{ all -> 0x008e }
            r0.L$0 = r10     // Catch:{ all -> 0x008e }
            r0.L$1 = r6     // Catch:{ all -> 0x008e }
            r0.label = r3     // Catch:{ all -> 0x008e }
            r2 = 6
            kotlin.jvm.internal.InlineMarker.c(r2)     // Catch:{ all -> 0x008e }
            java.lang.Object r9 = r9.invoke(r10, r6, r0)     // Catch:{ all -> 0x008e }
            r0 = 7
            kotlin.jvm.internal.InlineMarker.c(r0)     // Catch:{ all -> 0x008e }
            if (r9 != r1) goto L_0x0087
            return r1
        L_0x0087:
            r9 = r10
        L_0x0088:
            r9.releaseIntercepted()
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        L_0x008e:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0092:
            r9.releaseIntercepted()
            throw r10
        L_0x0096:
            r9 = move-exception
            r2 = r8
        L_0x0098:
            kotlinx.coroutines.flow.l1 r10 = new kotlinx.coroutines.flow.l1
            r10.<init>(r9)
            d10.q r2 = r2.f57137c
            r0.L$0 = r9
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt__EmittersKt.c(r10, r2, r9, r0)
            if (r10 != r1) goto L_0x00ac
            return r1
        L_0x00ac:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.e, kotlin.coroutines.c):java.lang.Object");
    }
}
