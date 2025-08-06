package kotlinx.coroutines.flow;

import d10.p;

public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 implements d<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f57138b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f57139c;

    public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(p pVar, d dVar) {
        this.f57138b = pVar;
        this.f57139c = dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0082 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(kotlinx.coroutines.flow.e<? super T> r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.k.b(r8)
            goto L_0x0083
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0034:
            java.lang.Object r7 = r0.L$2
            kotlinx.coroutines.flow.internal.SafeCollector r7 = (kotlinx.coroutines.flow.internal.SafeCollector) r7
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r4 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1) r4
            kotlin.k.b(r8)     // Catch:{ all -> 0x0044 }
            goto L_0x006e
        L_0x0044:
            r8 = move-exception
            goto L_0x008a
        L_0x0046:
            kotlin.k.b(r8)
            kotlinx.coroutines.flow.internal.SafeCollector r8 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            r8.<init>(r7, r2)
            d10.p r2 = r6.f57138b     // Catch:{ all -> 0x0086 }
            r0.L$0 = r6     // Catch:{ all -> 0x0086 }
            r0.L$1 = r7     // Catch:{ all -> 0x0086 }
            r0.L$2 = r8     // Catch:{ all -> 0x0086 }
            r0.label = r4     // Catch:{ all -> 0x0086 }
            r4 = 6
            kotlin.jvm.internal.InlineMarker.c(r4)     // Catch:{ all -> 0x0086 }
            java.lang.Object r2 = r2.invoke(r8, r0)     // Catch:{ all -> 0x0086 }
            r4 = 7
            kotlin.jvm.internal.InlineMarker.c(r4)     // Catch:{ all -> 0x0086 }
            if (r2 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r4 = r6
            r2 = r7
            r7 = r8
        L_0x006e:
            r7.releaseIntercepted()
            kotlinx.coroutines.flow.d r7 = r4.f57139c
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r7 = r7.collect(r2, r0)
            if (r7 != r1) goto L_0x0083
            return r1
        L_0x0083:
            kotlin.Unit r7 = kotlin.Unit.f56620a
            return r7
        L_0x0086:
            r7 = move-exception
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x008a:
            r7.releaseIntercepted()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.e, kotlin.coroutines.c):java.lang.Object");
    }
}
