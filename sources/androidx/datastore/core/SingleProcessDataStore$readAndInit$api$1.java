package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.sync.a;

@Metadata(bv = {}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J7\u0010\u0006\u001a\u00028\u00002\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"androidx/datastore/core/SingleProcessDataStore$readAndInit$api$1", "Landroidx/datastore/core/g;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "transform", "a", "(Ld10/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class SingleProcessDataStore$readAndInit$api$1 implements g<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f8942a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref$BooleanRef f8943b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<T> f8944c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f8945d;

    public SingleProcessDataStore$readAndInit$api$1(a aVar, Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef<T> ref$ObjectRef, SingleProcessDataStore<T> singleProcessDataStore) {
        this.f8942a = aVar;
        this.f8943b = ref$BooleanRef;
        this.f8944c = ref$ObjectRef;
        this.f8945d = singleProcessDataStore;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a A[Catch:{ all -> 0x00df }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ba A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d0 A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d7 A[SYNTHETIC, Splitter:B:47:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(d10.p<? super T, ? super kotlin.coroutines.c<? super T>, ? extends java.lang.Object> r11, kotlin.coroutines.c<? super T> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0076
            if (r2 == r5) goto L_0x005a
            if (r2 == r4) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            java.lang.Object r11 = r0.L$2
            java.lang.Object r1 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.a r0 = (kotlinx.coroutines.sync.a) r0
            kotlin.k.b(r12)     // Catch:{ all -> 0x003b }
            goto L_0x00cc
        L_0x003b:
            r11 = move-exception
            goto L_0x00e1
        L_0x003e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0046:
            java.lang.Object r11 = r0.L$2
            androidx.datastore.core.SingleProcessDataStore r11 = (androidx.datastore.core.SingleProcessDataStore) r11
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) r4
            kotlin.k.b(r12)     // Catch:{ all -> 0x0056 }
            goto L_0x00b2
        L_0x0056:
            r11 = move-exception
            r0 = r4
            goto L_0x00e1
        L_0x005a:
            java.lang.Object r11 = r0.L$4
            androidx.datastore.core.SingleProcessDataStore r11 = (androidx.datastore.core.SingleProcessDataStore) r11
            java.lang.Object r2 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
            java.lang.Object r5 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r5 = (kotlin.jvm.internal.Ref$BooleanRef) r5
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) r7
            java.lang.Object r8 = r0.L$0
            d10.p r8 = (d10.p) r8
            kotlin.k.b(r12)
            r12 = r7
            r9 = r8
            r8 = r11
            r11 = r9
            goto L_0x0096
        L_0x0076:
            kotlin.k.b(r12)
            kotlinx.coroutines.sync.a r12 = r10.f8942a
            kotlin.jvm.internal.Ref$BooleanRef r2 = r10.f8943b
            kotlin.jvm.internal.Ref$ObjectRef<T> r7 = r10.f8944c
            androidx.datastore.core.SingleProcessDataStore<T> r8 = r10.f8945d
            r0.L$0 = r11
            r0.L$1 = r12
            r0.L$2 = r2
            r0.L$3 = r7
            r0.L$4 = r8
            r0.label = r5
            java.lang.Object r5 = r12.d(r6, r0)
            if (r5 != r1) goto L_0x0094
            return r1
        L_0x0094:
            r5 = r2
            r2 = r7
        L_0x0096:
            boolean r5 = r5.element     // Catch:{ all -> 0x00df }
            if (r5 != 0) goto L_0x00d7
            T r5 = r2.element     // Catch:{ all -> 0x00df }
            r0.L$0 = r12     // Catch:{ all -> 0x00df }
            r0.L$1 = r2     // Catch:{ all -> 0x00df }
            r0.L$2 = r8     // Catch:{ all -> 0x00df }
            r0.L$3 = r6     // Catch:{ all -> 0x00df }
            r0.L$4 = r6     // Catch:{ all -> 0x00df }
            r0.label = r4     // Catch:{ all -> 0x00df }
            java.lang.Object r11 = r11.invoke(r5, r0)     // Catch:{ all -> 0x00df }
            if (r11 != r1) goto L_0x00af
            return r1
        L_0x00af:
            r4 = r12
            r12 = r11
            r11 = r8
        L_0x00b2:
            T r5 = r2.element     // Catch:{ all -> 0x0056 }
            boolean r5 = kotlin.jvm.internal.x.b(r12, r5)     // Catch:{ all -> 0x0056 }
            if (r5 != 0) goto L_0x00d0
            r0.L$0 = r4     // Catch:{ all -> 0x0056 }
            r0.L$1 = r2     // Catch:{ all -> 0x0056 }
            r0.L$2 = r12     // Catch:{ all -> 0x0056 }
            r0.label = r3     // Catch:{ all -> 0x0056 }
            java.lang.Object r11 = r11.z(r12, r0)     // Catch:{ all -> 0x0056 }
            if (r11 != r1) goto L_0x00c9
            return r1
        L_0x00c9:
            r11 = r12
            r1 = r2
            r0 = r4
        L_0x00cc:
            r1.element = r11     // Catch:{ all -> 0x003b }
            r2 = r1
            goto L_0x00d1
        L_0x00d0:
            r0 = r4
        L_0x00d1:
            T r11 = r2.element     // Catch:{ all -> 0x003b }
            r0.e(r6)
            return r11
        L_0x00d7:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00df }
            java.lang.String r0 = "InitializerApi.updateData should not be called after initialization is complete."
            r11.<init>(r0)     // Catch:{ all -> 0x00df }
            throw r11     // Catch:{ all -> 0x00df }
        L_0x00df:
            r11 = move-exception
            r0 = r12
        L_0x00e1:
            r0.e(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1.a(d10.p, kotlin.coroutines.c):java.lang.Object");
    }
}
