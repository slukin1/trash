package com.sumsub.sns.internal.core.presentation.screen.imageviewer;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.lifecycle.m0;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.log.LoggerType;
import d10.p;
import d10.q;
import java.io.File;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v1;

public final class a extends com.sumsub.sns.core.presentation.base.a<b> {

    /* renamed from: t  reason: collision with root package name */
    public static final C0381a f33884t = new C0381a((r) null);

    /* renamed from: u  reason: collision with root package name */
    public static final int f33885u = 1920;

    /* renamed from: v  reason: collision with root package name */
    public static final String f33886v = "arg_iddocsettype";

    /* renamed from: w  reason: collision with root package name */
    public static final String f33887w = "file";

    /* renamed from: x  reason: collision with root package name */
    public static final String f33888x = "rotation";

    /* renamed from: q  reason: collision with root package name */
    public final Bundle f33889q;

    /* renamed from: r  reason: collision with root package name */
    public final File f33890r;

    /* renamed from: s  reason: collision with root package name */
    public final j1<b> f33891s;

    /* renamed from: com.sumsub.sns.internal.core.presentation.screen.imageviewer.a$a  reason: collision with other inner class name */
    public static final class C0381a {
        public /* synthetic */ C0381a(r rVar) {
            this();
        }

        public C0381a() {
        }
    }

    public static final class b implements a.l {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f33892a;

        /* renamed from: b  reason: collision with root package name */
        public final File f33893b;

        /* renamed from: c  reason: collision with root package name */
        public final int f33894c;

        public b() {
            this((Bitmap) null, (File) null, 0, 7, (r) null);
        }

        public final Bitmap a() {
            return this.f33892a;
        }

        public final File b() {
            return this.f33893b;
        }

        public final int c() {
            return this.f33894c;
        }

        public final Bitmap d() {
            return this.f33892a;
        }

        public final File e() {
            return this.f33893b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return x.b(this.f33892a, bVar.f33892a) && x.b(this.f33893b, bVar.f33893b) && this.f33894c == bVar.f33894c;
        }

        public final int f() {
            return this.f33894c;
        }

        public int hashCode() {
            Bitmap bitmap = this.f33892a;
            int i11 = 0;
            int hashCode = (bitmap == null ? 0 : bitmap.hashCode()) * 31;
            File file = this.f33893b;
            if (file != null) {
                i11 = file.hashCode();
            }
            return ((hashCode + i11) * 31) + this.f33894c;
        }

        public String toString() {
            return "ViewState(bitmap=" + this.f33892a + ", bitmapFile=" + this.f33893b + ", rotation=" + this.f33894c + ')';
        }

        public b(Bitmap bitmap, File file, int i11) {
            this.f33892a = bitmap;
            this.f33893b = file;
            this.f33894c = i11;
        }

        public final b a(Bitmap bitmap, File file, int i11) {
            return new b(bitmap, file, i11);
        }

        public static /* synthetic */ b a(b bVar, Bitmap bitmap, File file, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                bitmap = bVar.f33892a;
            }
            if ((i12 & 2) != 0) {
                file = bVar.f33893b;
            }
            if ((i12 & 4) != 0) {
                i11 = bVar.f33894c;
            }
            return bVar.a(bitmap, file, i11);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(Bitmap bitmap, File file, int i11, int i12, r rVar) {
            this((i12 & 1) != 0 ? null : bitmap, (i12 & 2) != 0 ? null : file, (i12 & 4) != 0 ? 0 : i11);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.presentation.screen.imageviewer.SNSImageViewerViewModel$viewState$1", f = "SNSImageViewerViewModel.kt", l = {50, 56, 62}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<e<? super b>, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33895a;

        /* renamed from: b  reason: collision with root package name */
        public int f33896b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f33897c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f33898d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f33898d = aVar;
        }

        /* renamed from: a */
        public final Object invoke(e<? super b> eVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            c cVar2 = new c(this.f33898d, cVar);
            cVar2.f33897c = obj;
            return cVar2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:36:0x00cc A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r14.f33896b
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L_0x0034
                if (r1 == r5) goto L_0x002a
                if (r1 == r4) goto L_0x001f
                if (r1 != r3) goto L_0x0017
                kotlin.k.b(r15)
                goto L_0x00cd
            L_0x0017:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x001f:
                int r1 = r14.f33895a
                java.lang.Object r4 = r14.f33897c
                kotlinx.coroutines.flow.e r4 = (kotlinx.coroutines.flow.e) r4
                kotlin.k.b(r15)
                goto L_0x00b4
            L_0x002a:
                int r1 = r14.f33895a
                java.lang.Object r4 = r14.f33897c
                kotlinx.coroutines.flow.e r4 = (kotlinx.coroutines.flow.e) r4
                kotlin.k.b(r15)
                goto L_0x008e
            L_0x0034:
                kotlin.k.b(r15)
                java.lang.Object r15 = r14.f33897c
                kotlinx.coroutines.flow.e r15 = (kotlinx.coroutines.flow.e) r15
                com.sumsub.sns.internal.core.presentation.screen.imageviewer.a r1 = r14.f33898d
                java.io.File r1 = r1.p()
                if (r1 == 0) goto L_0x0048
                java.lang.String r1 = com.sumsub.sns.internal.core.common.m0.a(r1)
                goto L_0x0049
            L_0x0048:
                r1 = r2
            L_0x0049:
                com.sumsub.sns.internal.core.presentation.screen.imageviewer.a r6 = r14.f33898d
                android.os.Bundle r6 = r6.f33889q
                r7 = 0
                if (r6 == 0) goto L_0x0059
                java.lang.String r8 = "rotation"
                int r6 = r6.getInt(r8, r7)
                goto L_0x005a
            L_0x0059:
                r6 = r7
            L_0x005a:
                com.sumsub.sns.internal.core.presentation.screen.imageviewer.a r7 = r14.f33898d
                java.io.File r7 = r7.p()
                if (r7 != 0) goto L_0x006e
                com.sumsub.sns.internal.core.presentation.screen.imageviewer.a$b r1 = new com.sumsub.sns.internal.core.presentation.screen.imageviewer.a$b
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 7
                r13 = 0
                r8 = r1
                r8.<init>(r9, r10, r11, r12, r13)
                goto L_0x00c2
            L_0x006e:
                java.lang.String r7 = "application/pdf"
                boolean r1 = kotlin.jvm.internal.x.b(r1, r7)
                r7 = 1920(0x780, float:2.69E-42)
                if (r1 == 0) goto L_0x009e
                com.sumsub.sns.internal.core.presentation.screen.imageviewer.a r1 = r14.f33898d
                java.io.File r1 = r1.p()
                r14.f33897c = r15
                r14.f33895a = r6
                r14.f33896b = r5
                java.lang.Object r1 = com.sumsub.sns.internal.core.common.m0.b((java.io.File) r1, (int) r7, (kotlin.coroutines.c<? super android.graphics.Bitmap>) r14)
                if (r1 != r0) goto L_0x008b
                return r0
            L_0x008b:
                r4 = r15
                r15 = r1
                r1 = r6
            L_0x008e:
                android.graphics.Bitmap r15 = (android.graphics.Bitmap) r15
                com.sumsub.sns.internal.core.presentation.screen.imageviewer.a r5 = r14.f33898d
                java.io.File r5 = r5.p()
                com.sumsub.sns.internal.core.presentation.screen.imageviewer.a$b r6 = new com.sumsub.sns.internal.core.presentation.screen.imageviewer.a$b
                r6.<init>(r15, r5, r1)
            L_0x009b:
                r15 = r4
                r1 = r6
                goto L_0x00c2
            L_0x009e:
                com.sumsub.sns.internal.core.presentation.screen.imageviewer.a r1 = r14.f33898d
                java.io.File r1 = r1.p()
                r14.f33897c = r15
                r14.f33895a = r6
                r14.f33896b = r4
                java.lang.Object r1 = com.sumsub.sns.internal.core.common.m0.a((java.io.File) r1, (int) r7, (kotlin.coroutines.c<? super android.graphics.Bitmap>) r14)
                if (r1 != r0) goto L_0x00b1
                return r0
            L_0x00b1:
                r4 = r15
                r15 = r1
                r1 = r6
            L_0x00b4:
                android.graphics.Bitmap r15 = (android.graphics.Bitmap) r15
                com.sumsub.sns.internal.core.presentation.screen.imageviewer.a r5 = r14.f33898d
                java.io.File r5 = r5.p()
                com.sumsub.sns.internal.core.presentation.screen.imageviewer.a$b r6 = new com.sumsub.sns.internal.core.presentation.screen.imageviewer.a$b
                r6.<init>(r15, r5, r1)
                goto L_0x009b
            L_0x00c2:
                r14.f33897c = r2
                r14.f33896b = r3
                java.lang.Object r15 = r15.emit(r1, r14)
                if (r15 != r0) goto L_0x00cd
                return r0
            L_0x00cd:
                kotlin.Unit r15 = kotlin.Unit.f56620a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.screen.imageviewer.a.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.presentation.screen.imageviewer.SNSImageViewerViewModel$viewState$2", f = "SNSImageViewerViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements q<e<? super b>, Throwable, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33899a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33900b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f33901c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f33902d;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.presentation.screen.imageviewer.SNSImageViewerViewModel$viewState$2$1", f = "SNSImageViewerViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.internal.core.presentation.screen.imageviewer.a$d$a  reason: collision with other inner class name */
        public static final class C0382a extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f33903a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f33904b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Throwable f33905c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0382a(Throwable th2, kotlin.coroutines.c<? super C0382a> cVar) {
                super(2, cVar);
                this.f33905c = th2;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((C0382a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                C0382a aVar = new C0382a(this.f33905c, cVar);
                aVar.f33904b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f33903a == 0) {
                    k.b(obj);
                    com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA).e(com.sumsub.sns.internal.log.c.a((h0) this.f33904b), "Can't decode file", this.f33905c);
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, kotlin.coroutines.c<? super d> cVar) {
            super(3, cVar);
            this.f33902d = aVar;
        }

        /* renamed from: a */
        public final Object invoke(e<? super b> eVar, Throwable th2, kotlin.coroutines.c<? super Unit> cVar) {
            d dVar = new d(this.f33902d, cVar);
            dVar.f33900b = eVar;
            dVar.f33901c = th2;
            return dVar.invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f33899a == 0) {
                k.b(obj);
                Throwable th2 = (Throwable) this.f33901c;
                a aVar = this.f33902d;
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) aVar, th2, aVar.r(), (Object) null, 4, (Object) null);
                com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
                String a11 = com.sumsub.sns.internal.log.c.a((e) this.f33900b);
                String message = th2.getMessage();
                if (message == null) {
                    message = "";
                }
                aVar2.e(a11, message, th2);
                n1 unused2 = i.d(m0.a(this.f33902d), v1.f57574b, (CoroutineStart) null, new C0382a(th2, (kotlin.coroutines.c<? super C0382a>) null), 2, (Object) null);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public a(Bundle bundle, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        super(aVar, bVar);
        this.f33889q = bundle;
        Serializable serializable = bundle != null ? bundle.getSerializable("file") : null;
        this.f33890r = serializable instanceof File ? (File) serializable : null;
        this.f33891s = f.a0(f.f(f.F(new c(this, (kotlin.coroutines.c<? super c>) null)), new d(this, (kotlin.coroutines.c<? super d>) null)), m0.a(this), i1.a.b(i1.f57228a, 0, 0, 3, (Object) null), new b((Bitmap) null, (File) null, 0, 7, (r) null));
    }

    public static /* synthetic */ void q() {
    }

    public final File p() {
        return this.f33890r;
    }

    public final String r() {
        Bundle bundle = this.f33889q;
        String string = bundle != null ? bundle.getString("arg_iddocsettype") : null;
        return string == null ? DocumentType.f32355j : string;
    }

    public final int s() {
        Bundle bundle = this.f33889q;
        if (bundle != null) {
            return bundle.getInt("rotation");
        }
        return 0;
    }

    /* renamed from: t */
    public j1<b> j() {
        return this.f33891s;
    }
}
