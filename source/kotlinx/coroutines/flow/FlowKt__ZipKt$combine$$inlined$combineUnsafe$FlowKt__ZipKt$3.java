package kotlinx.coroutines.flow;

import d10.a;
import d10.q;
import d10.t;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.flow.internal.CombineKt;

public final class FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3 implements d<R> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d[] f57183b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t f57184c;

    @d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2", f = "Zip.kt", l = {333, 262}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements q<e<? super R>, Object[], c<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public /* synthetic */ Object L$1;
        public int label;

        public final Object invoke(e<? super R> eVar, Object[] objArr, c<? super Unit> cVar) {
            AnonymousClass2 r02 = new AnonymousClass2(cVar, tVar);
            r02.L$0 = eVar;
            r02.L$1 = objArr;
            return r02.invokeSuspend(Unit.f56620a);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.e} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r11.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0022
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                kotlin.k.b(r12)
                goto L_0x005d
            L_0x0012:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x001a:
                java.lang.Object r1 = r11.L$0
                kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
                kotlin.k.b(r12)
                goto L_0x0051
            L_0x0022:
                kotlin.k.b(r12)
                java.lang.Object r12 = r11.L$0
                r1 = r12
                kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
                java.lang.Object r12 = r11.L$1
                java.lang.Object[] r12 = (java.lang.Object[]) r12
                d10.t r4 = r3
                r5 = 0
                r5 = r12[r5]
                r6 = r12[r3]
                r7 = r12[r2]
                r8 = 3
                r8 = r12[r8]
                r9 = 4
                r9 = r12[r9]
                r11.L$0 = r1
                r11.label = r3
                r12 = 6
                kotlin.jvm.internal.InlineMarker.c(r12)
                r10 = r11
                java.lang.Object r12 = r4.invoke(r5, r6, r7, r8, r9, r10)
                r3 = 7
                kotlin.jvm.internal.InlineMarker.c(r3)
                if (r12 != r0) goto L_0x0051
                return r0
            L_0x0051:
                r3 = 0
                r11.L$0 = r3
                r11.label = r2
                java.lang.Object r12 = r1.emit(r12, r11)
                if (r12 != r0) goto L_0x005d
                return r0
            L_0x005d:
                kotlin.Unit r12 = kotlin.Unit.f56620a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3(d[] dVarArr, t tVar) {
        this.f57183b = dVarArr;
        this.f57184c = tVar;
    }

    public Object collect(e eVar, c cVar) {
        d[] dVarArr = this.f57183b;
        a a11 = FlowKt__ZipKt.h();
        final t tVar = this.f57184c;
        Object a12 = CombineKt.a(eVar, dVarArr, a11, new AnonymousClass2((c) null), cVar);
        if (a12 == IntrinsicsKt__IntrinsicsKt.d()) {
            return a12;
        }
        return Unit.f56620a;
    }
}
