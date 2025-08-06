package com.iproov.sdk;

import com.iproov.sdk.IProov;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.e;

@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/d;", "Lkotlinx/coroutines/flow/e;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/e;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/q0"}, k = 1, mv = {1, 5, 1})
public final class IProovFlowLauncher$special$$inlined$map$1 implements d<IProov.IProovSessionState> {
    public final /* synthetic */ d $this_unsafeTransform$inlined;
    public final /* synthetic */ IProovFlowLauncher this$0;

    public IProovFlowLauncher$special$$inlined$map$1(d dVar, IProovFlowLauncher iProovFlowLauncher) {
        this.$this_unsafeTransform$inlined = dVar;
        this.this$0 = iProovFlowLauncher;
    }

    public Object collect(final e eVar, c cVar) {
        d dVar = this.$this_unsafeTransform$inlined;
        final IProovFlowLauncher iProovFlowLauncher = this.this$0;
        Object collect = dVar.collect(new e<IProovSessionState>() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.c r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.iproov.sdk.IProovFlowLauncher$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    com.iproov.sdk.IProovFlowLauncher$special$$inlined$map$1$2$1 r0 = (com.iproov.sdk.IProovFlowLauncher$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    com.iproov.sdk.IProovFlowLauncher$special$$inlined$map$1$2$1 r0 = new com.iproov.sdk.IProovFlowLauncher$special$$inlined$map$1$2$1
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.k.b(r6)
                    goto L_0x004b
                L_0x0029:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0031:
                    kotlin.k.b(r6)
                    kotlinx.coroutines.flow.e r6 = r4
                    com.iproov.sdk.IProovSessionState r5 = (com.iproov.sdk.IProovSessionState) r5
                    if (r5 != 0) goto L_0x003c
                    r5 = 0
                    goto L_0x0042
                L_0x003c:
                    com.iproov.sdk.IProovFlowLauncher r2 = r2
                    com.iproov.sdk.IProov$IProovSessionState r5 = com.iproov.sdk.Cdo.m533do((com.iproov.sdk.IProovSessionState) r5, (kotlinx.coroutines.h0) r2)
                L_0x0042:
                    r0.label = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L_0x004b
                    return r1
                L_0x004b:
                    kotlin.Unit r5 = kotlin.Unit.f56620a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.IProovFlowLauncher$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }, cVar);
        if (collect == IntrinsicsKt__IntrinsicsKt.d()) {
            return collect;
        }
        return Unit.f56620a;
    }
}
