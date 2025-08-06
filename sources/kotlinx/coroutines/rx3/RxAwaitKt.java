package kotlinx.coroutines.rx3;

import h00.f;
import h00.g;
import h00.j;
import h00.m;
import h00.o;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlinx.coroutines.k;
import kotlinx.coroutines.l;

public final class RxAwaitKt {

    public static final class a implements m<T> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k<T> f57432b;

        public a(k<? super T> kVar) {
            this.f57432b = kVar;
        }

        public void onError(Throwable th2) {
            k<T> kVar = this.f57432b;
            Result.a aVar = Result.Companion;
            kVar.resumeWith(Result.m3072constructorimpl(kotlin.k.a(th2)));
        }

        public void onSubscribe(io.reactivex.rxjava3.disposables.b bVar) {
            RxAwaitKt.h(this.f57432b, bVar);
        }

        public void onSuccess(T t11) {
            k<T> kVar = this.f57432b;
            Result.a aVar = Result.Companion;
            kVar.resumeWith(Result.m3072constructorimpl(t11));
        }
    }

    public static final class b implements f<T> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k<T> f57440b;

        public b(k<? super T> kVar) {
            this.f57440b = kVar;
        }

        public void onComplete() {
            k<T> kVar = this.f57440b;
            Result.a aVar = Result.Companion;
            kVar.resumeWith(Result.m3072constructorimpl((Object) null));
        }

        public void onError(Throwable th2) {
            k<T> kVar = this.f57440b;
            Result.a aVar = Result.Companion;
            kVar.resumeWith(Result.m3072constructorimpl(kotlin.k.a(th2)));
        }

        public void onSubscribe(io.reactivex.rxjava3.disposables.b bVar) {
            RxAwaitKt.h(this.f57440b, bVar);
        }

        public void onSuccess(T t11) {
            k<T> kVar = this.f57440b;
            Result.a aVar = Result.Companion;
            kVar.resumeWith(Result.m3072constructorimpl(t11));
        }
    }

    public static final <T> Object a(o<T> oVar, c<? super T> cVar) {
        l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.A();
        oVar.a(new a(lVar));
        Object v11 = lVar.v();
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        return v11;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: d10.a<? extends T>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object b(h00.j<T> r7, d10.a<? extends T> r8, kotlin.coroutines.c<? super T> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.rx3.RxAwaitKt$awaitFirstOrElse$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            kotlinx.coroutines.rx3.RxAwaitKt$awaitFirstOrElse$1 r0 = (kotlinx.coroutines.rx3.RxAwaitKt$awaitFirstOrElse$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx3.RxAwaitKt$awaitFirstOrElse$1 r0 = new kotlinx.coroutines.rx3.RxAwaitKt$awaitFirstOrElse$1
            r0.<init>(r9)
        L_0x0018:
            r4 = r0
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            java.lang.Object r7 = r4.L$0
            r8 = r7
            d10.a r8 = (d10.a) r8
            kotlin.k.b(r9)
            goto L_0x004c
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0037:
            kotlin.k.b(r9)
            kotlinx.coroutines.rx3.Mode r9 = kotlinx.coroutines.rx3.Mode.FIRST_OR_DEFAULT
            r3 = 0
            r5 = 2
            r6 = 0
            r4.L$0 = r8
            r4.label = r2
            r1 = r7
            r2 = r9
            java.lang.Object r9 = d(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L_0x004c
            return r0
        L_0x004c:
            if (r9 != 0) goto L_0x0052
            java.lang.Object r9 = r8.invoke()
        L_0x0052:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxAwaitKt.b(h00.j, d10.a, kotlin.coroutines.c):java.lang.Object");
    }

    public static final <T> Object c(j<T> jVar, Mode mode, T t11, c<? super T> cVar) {
        l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.A();
        jVar.subscribe(new RxAwaitKt$awaitOne$2$1(lVar, mode, t11));
        Object v11 = lVar.v();
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        return v11;
    }

    public static /* synthetic */ Object d(j jVar, Mode mode, Object obj, c cVar, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            obj = null;
        }
        return c(jVar, mode, obj, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object e(h00.g r4, java.lang.Object r5, kotlin.coroutines.c r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.rx3.RxAwaitKt$awaitOrDefault$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.rx3.RxAwaitKt$awaitOrDefault$1 r0 = (kotlinx.coroutines.rx3.RxAwaitKt$awaitOrDefault$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx3.RxAwaitKt$awaitOrDefault$1 r0 = new kotlinx.coroutines.rx3.RxAwaitKt$awaitOrDefault$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            java.lang.Object r5 = r0.L$0
            kotlin.k.b(r6)
            goto L_0x0041
        L_0x002b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0033:
            kotlin.k.b(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = g(r4, r0)
            if (r6 != r1) goto L_0x0041
            return r1
        L_0x0041:
            if (r6 != 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r5 = r6
        L_0x0045:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxAwaitKt.e(h00.g, java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object f(h00.g<T> r4, kotlin.coroutines.c<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.rx3.RxAwaitKt$awaitSingle$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.rx3.RxAwaitKt$awaitSingle$1 r0 = (kotlinx.coroutines.rx3.RxAwaitKt$awaitSingle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx3.RxAwaitKt$awaitSingle$1 r0 = new kotlinx.coroutines.rx3.RxAwaitKt$awaitSingle$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r5)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.k.b(r5)
            r0.label = r3
            java.lang.Object r5 = g(r4, r0)
            if (r5 != r1) goto L_0x003d
            return r1
        L_0x003d:
            if (r5 == 0) goto L_0x0040
            return r5
        L_0x0040:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxAwaitKt.f(h00.g, kotlin.coroutines.c):java.lang.Object");
    }

    public static final <T> Object g(g<T> gVar, c<? super T> cVar) {
        l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.A();
        gVar.a(new b(lVar));
        Object v11 = lVar.v();
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        return v11;
    }

    public static final void h(k<?> kVar, io.reactivex.rxjava3.disposables.b bVar) {
        kVar.x(new RxAwaitKt$disposeOnCancellation$1(bVar));
    }
}
