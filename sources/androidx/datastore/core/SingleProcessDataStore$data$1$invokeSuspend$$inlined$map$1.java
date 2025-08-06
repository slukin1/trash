package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.e;

@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/d;", "Lkotlinx/coroutines/flow/e;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/e;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/q0"}, k = 1, mv = {1, 5, 1})
public final class SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1 implements d<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f8934b;

    public SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1(d dVar) {
        this.f8934b = dVar;
    }

    public Object collect(final e eVar, c cVar) {
        Object collect = this.f8934b.collect(new e<j<T>>() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.c r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = (androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = new androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.k.b(r6)
                    goto L_0x0053
                L_0x0029:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0031:
                    kotlin.k.b(r6)
                    kotlinx.coroutines.flow.e r6 = r3
                    androidx.datastore.core.j r5 = (androidx.datastore.core.j) r5
                    boolean r2 = r5 instanceof androidx.datastore.core.h
                    if (r2 != 0) goto L_0x0073
                    boolean r2 = r5 instanceof androidx.datastore.core.f
                    if (r2 != 0) goto L_0x006c
                    boolean r2 = r5 instanceof androidx.datastore.core.b
                    if (r2 == 0) goto L_0x0056
                    androidx.datastore.core.b r5 = (androidx.datastore.core.b) r5
                    java.lang.Object r5 = r5.b()
                    r0.label = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L_0x0053
                    return r1
                L_0x0053:
                    kotlin.Unit r5 = kotlin.Unit.f56620a
                    return r5
                L_0x0056:
                    boolean r5 = r5 instanceof androidx.datastore.core.k
                    if (r5 == 0) goto L_0x0066
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
                    java.lang.String r6 = r6.toString()
                    r5.<init>(r6)
                    throw r5
                L_0x0066:
                    kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                    r5.<init>()
                    throw r5
                L_0x006c:
                    androidx.datastore.core.f r5 = (androidx.datastore.core.f) r5
                    java.lang.Throwable r5 = r5.a()
                    throw r5
                L_0x0073:
                    androidx.datastore.core.h r5 = (androidx.datastore.core.h) r5
                    java.lang.Throwable r5 = r5.a()
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }, cVar);
        if (collect == IntrinsicsKt__IntrinsicsKt.d()) {
            return collect;
        }
        return Unit.f56620a;
    }
}
