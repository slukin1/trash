package com.sumsub.sns.internal.core.domain;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.Size;
import com.sumsub.sns.internal.core.domain.o;
import com.sumsub.sns.internal.ml.core.e;
import com.sumsub.sns.internal.ml.facedetector.models.d;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlinx.coroutines.h;
import kotlinx.coroutines.h0;

public final class q implements o {

    /* renamed from: d  reason: collision with root package name */
    public static final a f33665d = new a((r) null);

    /* renamed from: e  reason: collision with root package name */
    public static final String f33666e = "TensorflowFaceDetector";

    /* renamed from: f  reason: collision with root package name */
    public static final float f33667f = 0.3f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f33668g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f33669h = false;

    /* renamed from: a  reason: collision with root package name */
    public final Context f33670a;

    /* renamed from: b  reason: collision with root package name */
    public com.sumsub.sns.internal.ml.facedetector.a f33671b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33672c = "TensorFlow";

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    @d(c = "com.sumsub.sns.internal.core.domain.TensorflowFaceDetector$processImage$detectResult$1", f = "TensorflowFaceDetector.kt", l = {54}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super e.a<com.sumsub.sns.internal.ml.facedetector.models.e>>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33673a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f33674b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bitmap f33675c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(q qVar, Bitmap bitmap, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f33674b = qVar;
            this.f33675c = bitmap;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super e.a<com.sumsub.sns.internal.ml.facedetector.models.e>> cVar) {
            return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b(this.f33674b, this.f33675c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33673a;
            if (i11 == 0) {
                k.b(obj);
                com.sumsub.sns.internal.ml.facedetector.a a11 = this.f33674b.f33671b;
                if (a11 == null) {
                    return null;
                }
                Bitmap bitmap = this.f33675c;
                this.f33673a = 1;
                obj = a11.a(bitmap, this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return (e.a) obj;
        }
    }

    @d(c = "com.sumsub.sns.internal.core.domain.TensorflowFaceDetector$stop$1", f = "TensorflowFaceDetector.kt", l = {40}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33676a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f33677b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(q qVar, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f33677b = qVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c(this.f33677b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33676a;
            if (i11 == 0) {
                k.b(obj);
                com.sumsub.sns.internal.ml.facedetector.a a11 = this.f33677b.f33671b;
                if (a11 == null) {
                    return null;
                }
                this.f33676a = 1;
                if (a11.a((kotlin.coroutines.c<? super Unit>) this) == d11) {
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

    public q(Context context) {
        this.f33670a = context;
    }

    public String getName() {
        return this.f33672c;
    }

    public void start() {
        com.sumsub.sns.internal.ml.facedetector.c cVar = com.sumsub.sns.internal.ml.facedetector.c.f35080a;
        com.sumsub.sns.internal.ml.facedetector.c.a(cVar, f33666e, "TensorflowFaceDetector@start()", (Throwable) null, 4, (Object) null);
        this.f33671b = new com.sumsub.sns.internal.ml.facedetector.a(this.f33670a, new d.a().a(1).a(0.4f).a());
        com.sumsub.sns.internal.ml.facedetector.c.a(cVar, f33666e, "TensorflowFaceDetector@start(), detector created", (Throwable) null, 4, (Object) null);
    }

    public void stop() {
        com.sumsub.sns.internal.ml.facedetector.c cVar = com.sumsub.sns.internal.ml.facedetector.c.f35080a;
        com.sumsub.sns.internal.ml.facedetector.c.a(cVar, f33666e, "TensorflowFaceDetector@stop()", (Throwable) null, 4, (Object) null);
        Object unused = h.b((CoroutineContext) null, new c(this, (kotlin.coroutines.c<? super c>) null), 1, (Object) null);
        this.f33671b = null;
        com.sumsub.sns.internal.ml.facedetector.c.a(cVar, f33666e, "TensorflowFaceDetector@stop(), detector destroyed", (Throwable) null, 4, (Object) null);
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [com.sumsub.sns.internal.ml.core.e$a] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.graphics.Bitmap r18, android.graphics.RectF r19, d10.l<? super com.sumsub.sns.internal.core.domain.o.a, kotlin.Unit> r20) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r3 = r20
            java.lang.String r4 = "TensorflowFaceDetector"
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0139 }
            com.sumsub.sns.internal.core.domain.q$b r0 = new com.sumsub.sns.internal.core.domain.q$b     // Catch:{ Exception -> 0x0139 }
            r7 = 0
            r0.<init>(r1, r2, r7)     // Catch:{ Exception -> 0x0139 }
            r8 = 1
            java.lang.Object r0 = kotlinx.coroutines.h.b(r7, r0, r8, r7)     // Catch:{ Exception -> 0x0139 }
            com.sumsub.sns.internal.ml.core.e$a r0 = (com.sumsub.sns.internal.ml.core.e.a) r0     // Catch:{ Exception -> 0x0139 }
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0139 }
            long r9 = r9 - r5
            boolean r5 = r0 instanceof com.sumsub.sns.internal.ml.core.e.a.d     // Catch:{ Exception -> 0x0139 }
            r6 = 0
            if (r5 == 0) goto L_0x006b
            r5 = r0
            com.sumsub.sns.internal.ml.core.e$a$d r5 = (com.sumsub.sns.internal.ml.core.e.a.d) r5     // Catch:{ Exception -> 0x0139 }
            java.lang.Object r5 = r5.c()     // Catch:{ Exception -> 0x0139 }
            com.sumsub.sns.internal.ml.facedetector.models.e r5 = (com.sumsub.sns.internal.ml.facedetector.models.e) r5     // Catch:{ Exception -> 0x0139 }
            java.util.List r5 = r5.b()     // Catch:{ Exception -> 0x0139 }
            int r5 = r5.size()     // Catch:{ Exception -> 0x0139 }
            if (r5 == 0) goto L_0x0065
            if (r5 == r8) goto L_0x003e
            com.sumsub.sns.internal.core.domain.o$a$g r5 = new com.sumsub.sns.internal.core.domain.o$a$g     // Catch:{ Exception -> 0x0139 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0139 }
            goto L_0x00a3
        L_0x003e:
            r5 = r0
            com.sumsub.sns.internal.ml.core.e$a$d r5 = (com.sumsub.sns.internal.ml.core.e.a.d) r5     // Catch:{ Exception -> 0x0139 }
            java.lang.Object r5 = r5.c()     // Catch:{ Exception -> 0x0139 }
            com.sumsub.sns.internal.ml.facedetector.models.e r5 = (com.sumsub.sns.internal.ml.facedetector.models.e) r5     // Catch:{ Exception -> 0x0139 }
            java.util.List r5 = r5.b()     // Catch:{ Exception -> 0x0139 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ Exception -> 0x0139 }
            com.sumsub.sns.internal.ml.facedetector.models.c r5 = (com.sumsub.sns.internal.ml.facedetector.models.c) r5     // Catch:{ Exception -> 0x0139 }
            android.util.Size r8 = new android.util.Size     // Catch:{ Exception -> 0x0139 }
            int r11 = r18.getWidth()     // Catch:{ Exception -> 0x0139 }
            int r12 = r18.getHeight()     // Catch:{ Exception -> 0x0139 }
            r8.<init>(r11, r12)     // Catch:{ Exception -> 0x0139 }
            r11 = r19
            com.sumsub.sns.internal.core.domain.o$a r5 = r1.a(r11, r5, r2, r8)     // Catch:{ Exception -> 0x0139 }
            goto L_0x00a3
        L_0x0065:
            com.sumsub.sns.internal.core.domain.o$a$e r5 = new com.sumsub.sns.internal.core.domain.o$a$e     // Catch:{ Exception -> 0x0139 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0139 }
            goto L_0x00a3
        L_0x006b:
            boolean r5 = r0 instanceof com.sumsub.sns.internal.ml.core.e.a.b     // Catch:{ Exception -> 0x0139 }
            if (r5 == 0) goto L_0x008a
            com.sumsub.sns.internal.ml.facedetector.c r5 = com.sumsub.sns.internal.ml.facedetector.c.f35080a     // Catch:{ Exception -> 0x0139 }
            java.lang.String r8 = "TensorflowFaceDetector@processImage(), result error"
            r11 = r0
            com.sumsub.sns.internal.ml.core.e$a$b r11 = (com.sumsub.sns.internal.ml.core.e.a.b) r11     // Catch:{ Exception -> 0x0139 }
            java.lang.Throwable r11 = r11.c()     // Catch:{ Exception -> 0x0139 }
            r5.a(r4, r8, r11)     // Catch:{ Exception -> 0x0139 }
            com.sumsub.sns.internal.core.domain.o$a$a r5 = new com.sumsub.sns.internal.core.domain.o$a$a     // Catch:{ Exception -> 0x0139 }
            r8 = r0
            com.sumsub.sns.internal.ml.core.e$a$b r8 = (com.sumsub.sns.internal.ml.core.e.a.b) r8     // Catch:{ Exception -> 0x0139 }
            java.lang.Throwable r8 = r8.c()     // Catch:{ Exception -> 0x0139 }
            r5.<init>(r2, r8)     // Catch:{ Exception -> 0x0139 }
            goto L_0x00a3
        L_0x008a:
            boolean r5 = r0 instanceof com.sumsub.sns.internal.ml.core.e.a.c     // Catch:{ Exception -> 0x0139 }
            if (r5 == 0) goto L_0x0094
            com.sumsub.sns.internal.core.domain.o$a$e r5 = new com.sumsub.sns.internal.core.domain.o$a$e     // Catch:{ Exception -> 0x0139 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0139 }
            goto L_0x00a3
        L_0x0094:
            boolean r5 = r0 instanceof com.sumsub.sns.internal.ml.core.e.a.C0411e     // Catch:{ Exception -> 0x0139 }
            if (r5 == 0) goto L_0x009e
            com.sumsub.sns.internal.core.domain.o$a$e r5 = new com.sumsub.sns.internal.core.domain.o$a$e     // Catch:{ Exception -> 0x0139 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0139 }
            goto L_0x00a3
        L_0x009e:
            com.sumsub.sns.internal.core.domain.o$a$e r5 = new com.sumsub.sns.internal.core.domain.o$a$e     // Catch:{ Exception -> 0x0139 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0139 }
        L_0x00a3:
            boolean r8 = r0 instanceof com.sumsub.sns.internal.ml.core.e.a.d     // Catch:{ Exception -> 0x0139 }
            if (r8 == 0) goto L_0x00ab
            r8 = r0
            com.sumsub.sns.internal.ml.core.e$a$d r8 = (com.sumsub.sns.internal.ml.core.e.a.d) r8     // Catch:{ Exception -> 0x0139 }
            goto L_0x00ac
        L_0x00ab:
            r8 = r7
        L_0x00ac:
            if (r8 == 0) goto L_0x00c0
            java.lang.Object r8 = r8.c()     // Catch:{ Exception -> 0x0139 }
            com.sumsub.sns.internal.ml.facedetector.models.e r8 = (com.sumsub.sns.internal.ml.facedetector.models.e) r8     // Catch:{ Exception -> 0x0139 }
            if (r8 == 0) goto L_0x00c0
            java.util.List r8 = r8.b()     // Catch:{ Exception -> 0x0139 }
            if (r8 == 0) goto L_0x00c0
            int r6 = r8.size()     // Catch:{ Exception -> 0x0139 }
        L_0x00c0:
            boolean r8 = r0 instanceof com.sumsub.sns.internal.ml.core.e.a.d     // Catch:{ Exception -> 0x0139 }
            if (r8 == 0) goto L_0x00c7
            r7 = r0
            com.sumsub.sns.internal.ml.core.e$a$d r7 = (com.sumsub.sns.internal.ml.core.e.a.d) r7     // Catch:{ Exception -> 0x0139 }
        L_0x00c7:
            if (r7 == 0) goto L_0x00e4
            java.lang.Object r0 = r7.c()     // Catch:{ Exception -> 0x0139 }
            com.sumsub.sns.internal.ml.facedetector.models.e r0 = (com.sumsub.sns.internal.ml.facedetector.models.e) r0     // Catch:{ Exception -> 0x0139 }
            if (r0 == 0) goto L_0x00e4
            java.util.List r0 = r0.b()     // Catch:{ Exception -> 0x0139 }
            if (r0 == 0) goto L_0x00e4
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r0)     // Catch:{ Exception -> 0x0139 }
            com.sumsub.sns.internal.ml.facedetector.models.c r0 = (com.sumsub.sns.internal.ml.facedetector.models.c) r0     // Catch:{ Exception -> 0x0139 }
            if (r0 == 0) goto L_0x00e4
            float r0 = r0.c()     // Catch:{ Exception -> 0x0139 }
            goto L_0x00e5
        L_0x00e4:
            r0 = 0
        L_0x00e5:
            com.sumsub.sns.internal.ml.facedetector.c r11 = com.sumsub.sns.internal.ml.facedetector.c.f35080a     // Catch:{ Exception -> 0x0139 }
            java.lang.String r12 = "TensorflowFaceDetector"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0139 }
            r7.<init>()     // Catch:{ Exception -> 0x0139 }
            java.lang.String r8 = "processImage(), frame="
            r7.append(r8)     // Catch:{ Exception -> 0x0139 }
            int r8 = r18.getWidth()     // Catch:{ Exception -> 0x0139 }
            r7.append(r8)     // Catch:{ Exception -> 0x0139 }
            r8 = 120(0x78, float:1.68E-43)
            r7.append(r8)     // Catch:{ Exception -> 0x0139 }
            int r8 = r18.getHeight()     // Catch:{ Exception -> 0x0139 }
            r7.append(r8)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r8 = ", time="
            r7.append(r8)     // Catch:{ Exception -> 0x0139 }
            r7.append(r9)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r8 = " ms, faces="
            r7.append(r8)     // Catch:{ Exception -> 0x0139 }
            r7.append(r6)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r6 = ", faceScore="
            r7.append(r6)     // Catch:{ Exception -> 0x0139 }
            r7.append(r0)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r0 = ", result="
            r7.append(r0)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r0 = com.sumsub.sns.internal.core.common.i.a((java.lang.Object) r5)     // Catch:{ Exception -> 0x0139 }
            r7.append(r0)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r13 = r7.toString()     // Catch:{ Exception -> 0x0139 }
            r14 = 0
            r15 = 4
            r16 = 0
            com.sumsub.sns.internal.ml.facedetector.c.a(r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x0139 }
            r3.invoke(r5)     // Catch:{ Exception -> 0x0139 }
            goto L_0x0149
        L_0x0139:
            r0 = move-exception
            com.sumsub.sns.internal.ml.facedetector.c r5 = com.sumsub.sns.internal.ml.facedetector.c.f35080a
            java.lang.String r6 = "TensorflowFaceDetector@processImage(), error"
            r5.a(r4, r6, r0)
            com.sumsub.sns.internal.core.domain.o$a$a r4 = new com.sumsub.sns.internal.core.domain.o$a$a
            r4.<init>(r2, r0)
            r3.invoke(r4)
        L_0x0149:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.domain.q.a(android.graphics.Bitmap, android.graphics.RectF, d10.l):void");
    }

    public final o.a a(RectF rectF, com.sumsub.sns.internal.ml.facedetector.models.c cVar, Bitmap bitmap, Size size) {
        if (cVar.c() < 0.3f) {
            return new o.a.e(bitmap);
        }
        if (rectF.contains(cVar.a())) {
            return new o.a.d(bitmap, size, cVar.a());
        }
        return new o.a.f(bitmap, cVar.a());
    }
}
