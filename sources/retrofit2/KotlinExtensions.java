package retrofit2;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.l;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0000*\u00020\u0004*\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a+\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0000*\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a)\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0007\u001a\u001b\u0010\u000e\u001a\u00020\r*\u00060\u000bj\u0002`\fH@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"T", "Lretrofit2/Retrofit;", "create", "(Lretrofit2/Retrofit;)Ljava/lang/Object;", "", "Lretrofit2/Call;", "await", "(Lretrofit2/Call;Lkotlin/coroutines/c;)Ljava/lang/Object;", "awaitNullable", "Lretrofit2/Response;", "awaitResponse", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "suspendAndThrow", "(Ljava/lang/Exception;Lkotlin/coroutines/c;)Ljava/lang/Object;", "retrofit"}, k = 2, mv = {1, 4, 0})
public final class KotlinExtensions {
    public static final <T> Object await(Call<T> call, c<? super T> cVar) {
        l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.x(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new KotlinExtensions$await$2$2(lVar));
        Object v11 = lVar.v();
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        return v11;
    }

    public static final <T> Object awaitNullable(Call<T> call, c<? super T> cVar) {
        l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.x(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(call));
        call.enqueue(new KotlinExtensions$await$4$2(lVar));
        Object v11 = lVar.v();
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        return v11;
    }

    public static final <T> Object awaitResponse(Call<T> call, c<? super Response<T>> cVar) {
        l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.x(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new KotlinExtensions$awaitResponse$2$2(lVar));
        Object v11 = lVar.v();
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        return v11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object suspendAndThrow(java.lang.Exception r4, kotlin.coroutines.c<?> r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            kotlin.k.b(r5)
            goto L_0x005c
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.k.b(r5)
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.v0.a()
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
            r3.<init>(r0, r4)
            r5.w(r2, r3)
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            if (r4 != r5) goto L_0x0059
            kotlin.coroutines.jvm.internal.f.c(r0)
        L_0x0059:
            if (r4 != r1) goto L_0x005c
            return r1
        L_0x005c:
            kotlin.Unit r4 = kotlin.Unit.f56620a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.suspendAndThrow(java.lang.Exception, kotlin.coroutines.c):java.lang.Object");
    }
}
