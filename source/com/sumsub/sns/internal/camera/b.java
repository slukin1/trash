package com.sumsub.sns.internal.camera;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.m0;
import com.sumsub.sns.internal.camera.c;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.n;
import com.sumsub.sns.internal.core.data.model.o;
import com.sumsub.sns.internal.log.LoggerType;
import d10.p;
import java.io.File;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.k1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v1;

public abstract class b extends c {

    /* renamed from: x  reason: collision with root package name */
    public final boolean f31326x;

    /* renamed from: y  reason: collision with root package name */
    public final b1<a> f31327y;

    /* renamed from: z  reason: collision with root package name */
    public final j1<a> f31328z;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f31329a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f31330b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f31331c;

        public a() {
            this((CharSequence) null, (CharSequence) null, (CharSequence) null, 7, (r) null);
        }

        public final CharSequence a() {
            return this.f31329a;
        }

        public final CharSequence b() {
            return this.f31330b;
        }

        public final CharSequence c() {
            return this.f31331c;
        }

        public final CharSequence d() {
            return this.f31331c;
        }

        public final CharSequence e() {
            return this.f31330b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f31329a, aVar.f31329a) && x.b(this.f31330b, aVar.f31330b) && x.b(this.f31331c, aVar.f31331c);
        }

        public final CharSequence f() {
            return this.f31329a;
        }

        public int hashCode() {
            CharSequence charSequence = this.f31329a;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f31330b;
            int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f31331c;
            if (charSequence3 != null) {
                i11 = charSequence3.hashCode();
            }
            return hashCode2 + i11;
        }

        public String toString() {
            return "ViewState(permissionsTitle=" + this.f31329a + ", permissionsPositive=" + this.f31330b + ", permissionNegative=" + this.f31331c + ')';
        }

        public a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
            this.f31329a = charSequence;
            this.f31330b = charSequence2;
            this.f31331c = charSequence3;
        }

        public final a a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
            return new a(charSequence, charSequence2, charSequence3);
        }

        public static /* synthetic */ a a(a aVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = aVar.f31329a;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = aVar.f31330b;
            }
            if ((i11 & 4) != 0) {
                charSequence3 = aVar.f31331c;
            }
            return aVar.a(charSequence, charSequence2, charSequence3);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : charSequence, (i11 & 2) != 0 ? null : charSequence2, (i11 & 4) != 0 ? null : charSequence3);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.SNSCameraPhotoViewModel$onGalleryImagePicked$1", f = "SNSCameraPhotoViewModel.kt", l = {64}, m = "invokeSuspend")
    /* renamed from: com.sumsub.sns.internal.camera.b$b  reason: collision with other inner class name */
    public static final class C0301b extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31332a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31333b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f31334c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f31335d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Uri f31336e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f31337f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0301b(Context context, String str, Uri uri, b bVar, kotlin.coroutines.c<? super C0301b> cVar) {
            super(2, cVar);
            this.f31334c = context;
            this.f31335d = str;
            this.f31336e = uri;
            this.f31337f = bVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((C0301b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            C0301b bVar = new C0301b(this.f31334c, this.f31335d, this.f31336e, this.f31337f, cVar);
            bVar.f31333b = obj;
            return bVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            h0 h0Var;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31332a;
            boolean z11 = true;
            if (i11 == 0) {
                k.b(obj);
                h0Var = (h0) this.f31333b;
                Context context = this.f31334c;
                String str = this.f31335d;
                Uri uri = this.f31336e;
                this.f31333b = h0Var;
                this.f31332a = 1;
                obj2 = i.a(context, str, uri, (kotlin.coroutines.c<? super Uri>) this);
                if (obj2 == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
                obj2 = obj;
                h0Var = (h0) this.f31333b;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Uri uri2 = (Uri) obj2;
            com.sumsub.log.logger.a.b(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(h0Var), "onGalleryImagePicked: temp file uri - " + uri2, (Throwable) null, 4, (Object) null);
            if (uri2 == null) {
                return Unit.f56620a;
            }
            String path = uri2.getPath();
            if (!(path == null || path.length() == 0)) {
                String scheme = uri2.getScheme();
                if (scheme == null || !StringsKt__StringsJVMKt.M(scheme, "file", false, 2, (Object) null)) {
                    z11 = false;
                }
                if (z11) {
                    try {
                        File file = new File(StringsKt__StringsJVMKt.G(uri2.toString(), "file://", "", false, 4, (Object) null));
                        com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this.f31337f, (q) null, (Object) new n(file, file, (String) null, (String) null, this.f31337f.q(), false, (com.sumsub.sns.internal.ml.badphotos.models.b) null, (n.b) null, true, 172, (r) null), (Long) null, 5, (Object) null);
                    } catch (Exception e11) {
                        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                        String a11 = com.sumsub.sns.internal.log.c.a(h0Var);
                        String message = e11.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        aVar.e(a11, message, e11);
                        this.f31337f.a("Can't copy gallery file", e11);
                    }
                    return Unit.f56620a;
                }
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.SNSCameraPhotoViewModel$onPictureTaken$1", f = "SNSCameraPhotoViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<c.b, kotlin.coroutines.c<? super c.b>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31338a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31339b;

        public c(kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(c.b bVar, kotlin.coroutines.c<? super c.b> cVar) {
            return ((c) create(bVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            c cVar2 = new c(cVar);
            cVar2.f31339b = obj;
            return cVar2;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f31338a == 0) {
                k.b(obj);
                return c.b.a((c.b) this.f31339b, false, false, false, false, false, (com.sumsub.sns.internal.core.presentation.helper.camera.b) null, 61, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.SNSCameraPhotoViewModel", f = "SNSCameraPhotoViewModel.kt", l = {40}, m = "onPrepare$suspendImpl")
    public static final class d extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31340a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31341b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f31342c;

        /* renamed from: d  reason: collision with root package name */
        public int f31343d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(b bVar, kotlin.coroutines.c<? super d> cVar) {
            super(cVar);
            this.f31342c = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31341b = obj;
            this.f31343d |= Integer.MIN_VALUE;
            return b.a(this.f31342c, (kotlin.coroutines.c) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.SNSCameraPhotoViewModel$onPrepare$2", f = "SNSCameraPhotoViewModel.kt", l = {43, 44, 45}, m = "invokeSuspend")
    public static final class e extends SuspendLambda implements p<a, kotlin.coroutines.c<? super a>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f31344a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31345b;

        /* renamed from: c  reason: collision with root package name */
        public int f31346c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f31347d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f31348e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(b bVar, kotlin.coroutines.c<? super e> cVar) {
            super(2, cVar);
            this.f31348e = bVar;
        }

        /* renamed from: a */
        public final Object invoke(a aVar, kotlin.coroutines.c<? super a> cVar) {
            return ((e) create(aVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            e eVar = new e(this.f31348e, cVar);
            eVar.f31347d = obj;
            return eVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.sumsub.sns.internal.camera.b$a} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x007f A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0080  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r6.f31346c
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x003d
                if (r1 == r4) goto L_0x0035
                if (r1 == r3) goto L_0x0029
                if (r1 != r2) goto L_0x0021
                java.lang.Object r0 = r6.f31345b
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.Object r1 = r6.f31344a
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r6.f31347d
                com.sumsub.sns.internal.camera.b$a r2 = (com.sumsub.sns.internal.camera.b.a) r2
                kotlin.k.b(r7)
                goto L_0x0083
            L_0x0021:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x0029:
                java.lang.Object r1 = r6.f31344a
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r3 = r6.f31347d
                com.sumsub.sns.internal.camera.b$a r3 = (com.sumsub.sns.internal.camera.b.a) r3
                kotlin.k.b(r7)
                goto L_0x006b
            L_0x0035:
                java.lang.Object r1 = r6.f31347d
                com.sumsub.sns.internal.camera.b$a r1 = (com.sumsub.sns.internal.camera.b.a) r1
                kotlin.k.b(r7)
                goto L_0x0054
            L_0x003d:
                kotlin.k.b(r7)
                java.lang.Object r7 = r6.f31347d
                r1 = r7
                com.sumsub.sns.internal.camera.b$a r1 = (com.sumsub.sns.internal.camera.b.a) r1
                com.sumsub.sns.internal.camera.b r7 = r6.f31348e
                r6.f31347d = r1
                r6.f31346c = r4
                java.lang.String r4 = "sns_alert_lackOfPhotoLibraryPermissions"
                java.lang.Object r7 = r7.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r6)
                if (r7 != r0) goto L_0x0054
                return r0
            L_0x0054:
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                com.sumsub.sns.internal.camera.b r4 = r6.f31348e
                r6.f31347d = r1
                r6.f31344a = r7
                r6.f31346c = r3
                java.lang.String r3 = "sns_alert_action_ok"
                java.lang.Object r3 = r4.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r6)
                if (r3 != r0) goto L_0x0067
                return r0
            L_0x0067:
                r5 = r1
                r1 = r7
                r7 = r3
                r3 = r5
            L_0x006b:
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                com.sumsub.sns.internal.camera.b r4 = r6.f31348e
                r6.f31347d = r3
                r6.f31344a = r1
                r6.f31345b = r7
                r6.f31346c = r2
                java.lang.String r2 = "sns_alert_action_settings"
                java.lang.Object r2 = r4.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r6)
                if (r2 != r0) goto L_0x0080
                return r0
            L_0x0080:
                r0 = r7
                r7 = r2
                r2 = r3
            L_0x0083:
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                com.sumsub.sns.internal.camera.b$a r7 = r2.a(r1, r0, r7)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.b.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.SNSCameraPhotoViewModel$sendLog$1", f = "SNSCameraPhotoViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31349a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31350b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f31351c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Exception f31352d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str, Exception exc, kotlin.coroutines.c<? super f> cVar) {
            super(2, cVar);
            this.f31351c = str;
            this.f31352d = exc;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((f) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            f fVar = new f(this.f31351c, this.f31352d, cVar);
            fVar.f31350b = obj;
            return fVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f31349a == 0) {
                k.b(obj);
                com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA).e(com.sumsub.sns.internal.log.c.a((h0) this.f31350b), this.f31351c, this.f31352d);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(DocumentType documentType, String str, boolean z11, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar, int i11, r rVar) {
        this(documentType, (i11 & 2) != 0 ? null : str, z11, aVar, bVar);
    }

    public final j1<a> A() {
        return this.f31328z;
    }

    public final void B() {
        if (e0.f32018a.isDebug()) {
            a((o) new o.c(new Exception("Picker NOT found!!!"), (Object) null, (o.a) null, 6, (r) null), f());
        }
    }

    public Object d(kotlin.coroutines.c<? super Unit> cVar) {
        return a(this, (kotlin.coroutines.c) cVar);
    }

    public final boolean z() {
        return this.f31326x;
    }

    public b(DocumentType documentType, String str, boolean z11, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        super(documentType, str, aVar, bVar);
        this.f31326x = z11;
        b1<a> a11 = k1.a(new a((CharSequence) null, (CharSequence) null, (CharSequence) null, 7, (r) null));
        this.f31327y = a11;
        this.f31328z = kotlinx.coroutines.flow.f.b(a11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object a(com.sumsub.sns.internal.camera.b r4, kotlin.coroutines.c r5) {
        /*
            boolean r0 = r5 instanceof com.sumsub.sns.internal.camera.b.d
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.sumsub.sns.internal.camera.b$d r0 = (com.sumsub.sns.internal.camera.b.d) r0
            int r1 = r0.f31343d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31343d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.camera.b$d r0 = new com.sumsub.sns.internal.camera.b$d
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f31341b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31343d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.f31340a
            com.sumsub.sns.internal.camera.b r4 = (com.sumsub.sns.internal.camera.b) r4
            kotlin.k.b(r5)
            goto L_0x0043
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.k.b(r5)
            r0.f31340a = r4
            r0.f31343d = r3
            java.lang.Object r5 = super.d(r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            kotlinx.coroutines.flow.b1<com.sumsub.sns.internal.camera.b$a> r5 = r4.f31327y
            kotlinx.coroutines.h0 r0 = androidx.lifecycle.m0.a(r4)
            com.sumsub.sns.internal.camera.b$e r1 = new com.sumsub.sns.internal.camera.b$e
            r2 = 0
            r1.<init>(r4, r2)
            com.sumsub.sns.internal.core.common.b0.a(r5, (kotlinx.coroutines.h0) r0, r1)
            kotlin.Unit r4 = kotlin.Unit.f56620a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.b.a(com.sumsub.sns.internal.camera.b, kotlin.coroutines.c):java.lang.Object");
    }

    public void a(File file) {
        com.sumsub.log.logger.a.c(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "Picture is taken", (Throwable) null, 4, (Object) null);
        b(true);
        com.sumsub.sns.core.presentation.base.a.a(this, false, new c((kotlin.coroutines.c<? super c>) null), 1, (Object) null);
        com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (q) null, (Object) new n(file, file, (String) null, (String) null, q(), false, (com.sumsub.sns.internal.ml.badphotos.models.b) null, (n.b) null, false, 428, (r) null), (Long) null, 5, (Object) null);
    }

    public void a(Context context, String str, Uri uri) {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new C0301b(context, str, uri, this, (kotlin.coroutines.c<? super C0301b>) null), 3, (Object) null);
    }

    public final void a(String str, Exception exc) {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), v1.f57574b, (CoroutineStart) null, new f(str, exc, (kotlin.coroutines.c<? super f>) null), 2, (Object) null);
    }
}
