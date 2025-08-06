package com.sumsub.sns.internal.presentation.screen.error;

import androidx.lifecycle.m0;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.data.model.o;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

public final class a extends com.sumsub.sns.core.presentation.base.a<b> {

    /* renamed from: t  reason: collision with root package name */
    public static final C0421a f35245t = new C0421a((r) null);

    /* renamed from: u  reason: collision with root package name */
    public static final String f35246u = "arg_error";

    /* renamed from: v  reason: collision with root package name */
    public static final String f35247v = "arg_iddocsettype";

    /* renamed from: q  reason: collision with root package name */
    public final o f35248q;

    /* renamed from: r  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.extensions.a f35249r;

    /* renamed from: s  reason: collision with root package name */
    public final j1<b> f35250s = f.a0(f.F(new c(this, (kotlin.coroutines.c<? super c>) null)), m0.a(this), i1.a.b(i1.f57228a, 0, 0, 3, (Object) null), b.C0422a.f35251a);

    /* renamed from: com.sumsub.sns.internal.presentation.screen.error.a$a  reason: collision with other inner class name */
    public static final class C0421a {
        public /* synthetic */ C0421a(r rVar) {
            this();
        }

        public C0421a() {
        }
    }

    public static abstract class b implements a.l {

        /* renamed from: com.sumsub.sns.internal.presentation.screen.error.a$b$a  reason: collision with other inner class name */
        public static final class C0422a extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final C0422a f35251a = new C0422a();

            public C0422a() {
                super((r) null);
            }
        }

        /* renamed from: com.sumsub.sns.internal.presentation.screen.error.a$b$b  reason: collision with other inner class name */
        public static final class C0423b extends b {

            /* renamed from: a  reason: collision with root package name */
            public final CharSequence f35252a;

            /* renamed from: b  reason: collision with root package name */
            public final CharSequence f35253b;

            /* renamed from: c  reason: collision with root package name */
            public final CharSequence f35254c;

            public C0423b() {
                this((CharSequence) null, (CharSequence) null, (CharSequence) null, 7, (r) null);
            }

            public final CharSequence a() {
                return this.f35252a;
            }

            public final CharSequence b() {
                return this.f35253b;
            }

            public final CharSequence c() {
                return this.f35254c;
            }

            public final CharSequence d() {
                return this.f35254c;
            }

            public final CharSequence e() {
                return this.f35253b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0423b)) {
                    return false;
                }
                C0423b bVar = (C0423b) obj;
                return x.b(this.f35252a, bVar.f35252a) && x.b(this.f35253b, bVar.f35253b) && x.b(this.f35254c, bVar.f35254c);
            }

            public final CharSequence f() {
                return this.f35252a;
            }

            public int hashCode() {
                CharSequence charSequence = this.f35252a;
                int i11 = 0;
                int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
                CharSequence charSequence2 = this.f35253b;
                int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
                CharSequence charSequence3 = this.f35254c;
                if (charSequence3 != null) {
                    i11 = charSequence3.hashCode();
                }
                return hashCode2 + i11;
            }

            public String toString() {
                return "Normal(title=" + this.f35252a + ", subtitle=" + this.f35253b + ", button=" + this.f35254c + ')';
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ C0423b(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, r rVar) {
                this((i11 & 1) != 0 ? null : charSequence, (i11 & 2) != 0 ? null : charSequence2, (i11 & 4) != 0 ? null : charSequence3);
            }

            public final C0423b a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
                return new C0423b(charSequence, charSequence2, charSequence3);
            }

            public C0423b(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
                super((r) null);
                this.f35252a = charSequence;
                this.f35253b = charSequence2;
                this.f35254c = charSequence3;
            }

            public static /* synthetic */ C0423b a(C0423b bVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    charSequence = bVar.f35252a;
                }
                if ((i11 & 2) != 0) {
                    charSequence2 = bVar.f35253b;
                }
                if ((i11 & 4) != 0) {
                    charSequence3 = bVar.f35254c;
                }
                return bVar.a(charSequence, charSequence2, charSequence3);
            }
        }

        public static final class c extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final c f35255a = new c();

            public c() {
                super((r) null);
            }
        }

        public /* synthetic */ b(r rVar) {
            this();
        }

        public b() {
        }
    }

    @d(c = "com.sumsub.sns.internal.presentation.screen.error.SNSErrorViewModel$viewState$1", f = "SNSErrorViewModel.kt", l = {33, 34, 35, 38, 39, 40, 43, 44, 45, 63, 65}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<e<? super b>, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35256a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35257b;

        /* renamed from: c  reason: collision with root package name */
        public int f35258c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f35259d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f35260e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f35260e = aVar;
        }

        /* renamed from: a */
        public final Object invoke(e<? super b> eVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            c cVar2 = new c(this.f35260e, cVar);
            cVar2.f35259d = obj;
            return cVar2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v47, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: kotlinx.coroutines.flow.e} */
        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0226, code lost:
            r10 = com.sumsub.sns.internal.presentation.screen.error.a.a(r9.f35260e).a().d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0234, code lost:
            if (r2 == null) goto L_0x0250;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x0236, code lost:
            if (r1 == null) goto L_0x0250;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x0238, code lost:
            if (r10 == null) goto L_0x0250;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x023a, code lost:
            r4 = new com.sumsub.sns.internal.presentation.screen.error.a.b.C0423b(r2, r1, r10);
            r9.f35259d = null;
            r9.f35256a = null;
            r9.f35257b = null;
            r9.f35258c = 10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x024d, code lost:
            if (r3.emit(r4, r9) != r0) goto L_0x0263;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x024f, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0250, code lost:
            r10 = com.sumsub.sns.internal.presentation.screen.error.a.b.c.f35255a;
            r9.f35259d = null;
            r9.f35256a = null;
            r9.f35257b = null;
            r9.f35258c = 11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x0260, code lost:
            if (r3.emit(r10, r9) != r0) goto L_0x0263;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x0262, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x0265, code lost:
            return kotlin.Unit.f56620a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x00b8, code lost:
            r10 = (java.lang.CharSequence) r10;
            r2 = r9.f35260e;
            r9.f35259d = r1;
            r9.f35256a = r10;
            r9.f35258c = 2;
            r2 = com.sumsub.sns.internal.presentation.screen.error.a.a(r2, com.sumsub.sns.internal.core.common.n0.j.f32204d, r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c9, code lost:
            if (r2 != r0) goto L_0x00cc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00cb, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00cc, code lost:
            r8 = r2;
            r2 = r10;
            r10 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00cf, code lost:
            r10 = (java.lang.CharSequence) r10;
            r6 = r9.f35260e;
            r9.f35259d = r1;
            r9.f35256a = r2;
            r9.f35257b = r10;
            r9.f35258c = 3;
            r3 = com.sumsub.sns.internal.presentation.screen.error.a.a(r6, "sns_oops_action_retry", r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e0, code lost:
            if (r3 != r0) goto L_0x00e3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e2, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e3, code lost:
            r8 = r1;
            r1 = r10;
            r10 = r3;
            r3 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00e7, code lost:
            r10 = (java.lang.CharSequence) r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ff, code lost:
            r10 = (java.lang.String) r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0101, code lost:
            if (r10 == null) goto L_0x010e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0103, code lost:
            r10 = com.sumsub.sns.internal.presentation.screen.error.a.b(r9.f35260e).a(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x010e, code lost:
            r10 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x010f, code lost:
            r6 = r9.f35260e;
            r9.f35259d = r1;
            r9.f35256a = r10;
            r9.f35258c = 5;
            r2 = com.sumsub.sns.internal.presentation.screen.error.a.a(r6, "sns_oops_fatal_html", r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x011c, code lost:
            if (r2 != r0) goto L_0x011f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x011e, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x011f, code lost:
            r8 = r2;
            r2 = r10;
            r10 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0122, code lost:
            r10 = (java.lang.String) r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0124, code lost:
            if (r10 == null) goto L_0x0131;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0126, code lost:
            r10 = com.sumsub.sns.internal.presentation.screen.error.a.b(r9.f35260e).a(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0131, code lost:
            r10 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0132, code lost:
            r6 = r9.f35260e;
            r9.f35259d = r1;
            r9.f35256a = r2;
            r9.f35257b = r10;
            r9.f35258c = 6;
            r3 = com.sumsub.sns.internal.presentation.screen.error.a.a(r6, "sns_oops_action_retry", r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0141, code lost:
            if (r3 != r0) goto L_0x0144;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0143, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0144, code lost:
            r8 = r1;
            r1 = r10;
            r10 = r3;
            r3 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0148, code lost:
            r10 = (java.lang.CharSequence) r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x015e, code lost:
            r10 = (java.lang.String) r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0160, code lost:
            if (r10 == null) goto L_0x016d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0162, code lost:
            r10 = com.sumsub.sns.internal.presentation.screen.error.a.b(r9.f35260e).a(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x016d, code lost:
            r10 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x016e, code lost:
            r3 = r9.f35260e;
            r9.f35259d = r1;
            r9.f35256a = r10;
            r9.f35258c = 8;
            r2 = com.sumsub.sns.internal.presentation.screen.error.a.a(r3, "sns_oops_fatal_html", r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x017c, code lost:
            if (r2 != r0) goto L_0x017f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x017e, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x017f, code lost:
            r3 = r1;
            r8 = r2;
            r2 = r10;
            r10 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0183, code lost:
            r10 = (java.lang.String) r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0185, code lost:
            if (r10 == null) goto L_0x0193;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0187, code lost:
            r1 = com.sumsub.sns.internal.presentation.screen.error.a.b(r9.f35260e).a(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0193, code lost:
            r1 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0194, code lost:
            r10 = r9.f35260e;
            r9.f35259d = r3;
            r9.f35256a = r2;
            r9.f35257b = r1;
            r9.f35258c = 9;
            r10 = com.sumsub.sns.internal.presentation.screen.error.a.a(r10, "sns_oops_action_goBack", r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x01a6, code lost:
            if (r10 != r0) goto L_0x01a9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x01a8, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x01a9, code lost:
            r10 = (java.lang.CharSequence) r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x01b0, code lost:
            r6 = com.sumsub.sns.internal.presentation.screen.error.a.a(r9.f35260e).a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x01bb, code lost:
            if (r6 == null) goto L_0x01cc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x01bd, code lost:
            r6 = r6.f();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x01c1, code lost:
            if (r6 == null) goto L_0x01cc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x01c8, code lost:
            if ((!kotlin.text.StringsKt__StringsJVMKt.z(r6)) != true) goto L_0x01cc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x01ca, code lost:
            r6 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x01cc, code lost:
            r6 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x01cd, code lost:
            if (r6 == false) goto L_0x01dd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x01cf, code lost:
            r2 = com.sumsub.sns.internal.presentation.screen.error.a.a(r9.f35260e).a().f();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x01dd, code lost:
            r6 = com.sumsub.sns.internal.presentation.screen.error.a.a(r9.f35260e).a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x01e7, code lost:
            if (r6 == null) goto L_0x01f8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x01e9, code lost:
            r6 = r6.e();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x01ed, code lost:
            if (r6 == null) goto L_0x01f8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x01f4, code lost:
            if ((!kotlin.text.StringsKt__StringsJVMKt.z(r6)) != true) goto L_0x01f8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x01f6, code lost:
            r6 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x01f8, code lost:
            r6 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x01f9, code lost:
            if (r6 == false) goto L_0x0209;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x01fb, code lost:
            r1 = com.sumsub.sns.internal.presentation.screen.error.a.a(r9.f35260e).a().e();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0209, code lost:
            r6 = com.sumsub.sns.internal.presentation.screen.error.a.a(r9.f35260e).a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0213, code lost:
            if (r6 == null) goto L_0x0223;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x0215, code lost:
            r6 = r6.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x0219, code lost:
            if (r6 == null) goto L_0x0223;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0220, code lost:
            if ((!kotlin.text.StringsKt__StringsJVMKt.z(r6)) != true) goto L_0x0223;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x0223, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x0224, code lost:
            if (r4 == false) goto L_0x0234;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r9.f35258c
                java.lang.String r2 = "sns_oops_fatal_html"
                java.lang.String r3 = "sns_oops_action_retry"
                r4 = 1
                r5 = 0
                switch(r1) {
                    case 0: goto L_0x0097;
                    case 1: goto L_0x008f;
                    case 2: goto L_0x0080;
                    case 3: goto L_0x006f;
                    case 4: goto L_0x0066;
                    case 5: goto L_0x0056;
                    case 6: goto L_0x0045;
                    case 7: goto L_0x003c;
                    case 8: goto L_0x002d;
                    case 9: goto L_0x001c;
                    case 10: goto L_0x0017;
                    case 11: goto L_0x0017;
                    default: goto L_0x000f;
                }
            L_0x000f:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x0017:
                kotlin.k.b(r10)
                goto L_0x0263
            L_0x001c:
                java.lang.Object r1 = r9.f35257b
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r9.f35256a
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r9.f35259d
                kotlinx.coroutines.flow.e r3 = (kotlinx.coroutines.flow.e) r3
                kotlin.k.b(r10)
                goto L_0x01a9
            L_0x002d:
                java.lang.Object r1 = r9.f35256a
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r9.f35259d
                kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
                kotlin.k.b(r10)
                r3 = r2
                r2 = r1
                goto L_0x0183
            L_0x003c:
                java.lang.Object r1 = r9.f35259d
                kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
                kotlin.k.b(r10)
                goto L_0x015e
            L_0x0045:
                java.lang.Object r1 = r9.f35257b
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r9.f35256a
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r9.f35259d
                kotlinx.coroutines.flow.e r3 = (kotlinx.coroutines.flow.e) r3
                kotlin.k.b(r10)
                goto L_0x0148
            L_0x0056:
                java.lang.Object r1 = r9.f35256a
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r9.f35259d
                kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
                kotlin.k.b(r10)
                r8 = r2
                r2 = r1
                r1 = r8
                goto L_0x0122
            L_0x0066:
                java.lang.Object r1 = r9.f35259d
                kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
                kotlin.k.b(r10)
                goto L_0x00ff
            L_0x006f:
                java.lang.Object r1 = r9.f35257b
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r9.f35256a
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r9.f35259d
                kotlinx.coroutines.flow.e r3 = (kotlinx.coroutines.flow.e) r3
                kotlin.k.b(r10)
                goto L_0x00e7
            L_0x0080:
                java.lang.Object r1 = r9.f35256a
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r9.f35259d
                kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
                kotlin.k.b(r10)
                r8 = r2
                r2 = r1
                r1 = r8
                goto L_0x00cf
            L_0x008f:
                java.lang.Object r1 = r9.f35259d
                kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
                kotlin.k.b(r10)
                goto L_0x00b8
            L_0x0097:
                kotlin.k.b(r10)
                java.lang.Object r10 = r9.f35259d
                r1 = r10
                kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
                com.sumsub.sns.internal.presentation.screen.error.a r10 = r9.f35260e
                com.sumsub.sns.internal.core.data.model.o r10 = r10.f35248q
                boolean r6 = r10 instanceof com.sumsub.sns.internal.core.data.model.o.e
                if (r6 == 0) goto L_0x00eb
                com.sumsub.sns.internal.presentation.screen.error.a r10 = r9.f35260e
                r9.f35259d = r1
                r9.f35258c = r4
                java.lang.String r2 = "sns_oops_network_title"
                java.lang.Object r10 = r10.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r10 != r0) goto L_0x00b8
                return r0
            L_0x00b8:
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                com.sumsub.sns.internal.presentation.screen.error.a r2 = r9.f35260e
                r9.f35259d = r1
                r9.f35256a = r10
                r6 = 2
                r9.f35258c = r6
                java.lang.String r6 = "sns_oops_network_html"
                java.lang.Object r2 = r2.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r2 != r0) goto L_0x00cc
                return r0
            L_0x00cc:
                r8 = r2
                r2 = r10
                r10 = r8
            L_0x00cf:
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                com.sumsub.sns.internal.presentation.screen.error.a r6 = r9.f35260e
                r9.f35259d = r1
                r9.f35256a = r2
                r9.f35257b = r10
                r7 = 3
                r9.f35258c = r7
                java.lang.Object r3 = r6.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r3 != r0) goto L_0x00e3
                return r0
            L_0x00e3:
                r8 = r1
                r1 = r10
                r10 = r3
                r3 = r8
            L_0x00e7:
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                goto L_0x01b0
            L_0x00eb:
                boolean r6 = r10 instanceof com.sumsub.sns.internal.core.data.model.o.d
                java.lang.String r7 = "sns_oops_fatal_title"
                if (r6 == 0) goto L_0x014c
                com.sumsub.sns.internal.presentation.screen.error.a r10 = r9.f35260e
                r9.f35259d = r1
                r6 = 4
                r9.f35258c = r6
                java.lang.Object r10 = r10.a((java.lang.String) r7, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r10 != r0) goto L_0x00ff
                return r0
            L_0x00ff:
                java.lang.String r10 = (java.lang.String) r10
                if (r10 == 0) goto L_0x010e
                com.sumsub.sns.internal.presentation.screen.error.a r6 = r9.f35260e
                com.sumsub.sns.internal.core.data.source.extensions.a r6 = r6.f35249r
                android.text.Spanned r10 = r6.a(r10)
                goto L_0x010f
            L_0x010e:
                r10 = r5
            L_0x010f:
                com.sumsub.sns.internal.presentation.screen.error.a r6 = r9.f35260e
                r9.f35259d = r1
                r9.f35256a = r10
                r7 = 5
                r9.f35258c = r7
                java.lang.Object r2 = r6.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r2 != r0) goto L_0x011f
                return r0
            L_0x011f:
                r8 = r2
                r2 = r10
                r10 = r8
            L_0x0122:
                java.lang.String r10 = (java.lang.String) r10
                if (r10 == 0) goto L_0x0131
                com.sumsub.sns.internal.presentation.screen.error.a r6 = r9.f35260e
                com.sumsub.sns.internal.core.data.source.extensions.a r6 = r6.f35249r
                android.text.Spanned r10 = r6.a(r10)
                goto L_0x0132
            L_0x0131:
                r10 = r5
            L_0x0132:
                com.sumsub.sns.internal.presentation.screen.error.a r6 = r9.f35260e
                r9.f35259d = r1
                r9.f35256a = r2
                r9.f35257b = r10
                r7 = 6
                r9.f35258c = r7
                java.lang.Object r3 = r6.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r3 != r0) goto L_0x0144
                return r0
            L_0x0144:
                r8 = r1
                r1 = r10
                r10 = r3
                r3 = r8
            L_0x0148:
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                goto L_0x01b0
            L_0x014c:
                boolean r10 = r10 instanceof com.sumsub.sns.internal.core.data.model.o.c
                if (r10 == 0) goto L_0x01ac
                com.sumsub.sns.internal.presentation.screen.error.a r10 = r9.f35260e
                r9.f35259d = r1
                r3 = 7
                r9.f35258c = r3
                java.lang.Object r10 = r10.a((java.lang.String) r7, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r10 != r0) goto L_0x015e
                return r0
            L_0x015e:
                java.lang.String r10 = (java.lang.String) r10
                if (r10 == 0) goto L_0x016d
                com.sumsub.sns.internal.presentation.screen.error.a r3 = r9.f35260e
                com.sumsub.sns.internal.core.data.source.extensions.a r3 = r3.f35249r
                android.text.Spanned r10 = r3.a(r10)
                goto L_0x016e
            L_0x016d:
                r10 = r5
            L_0x016e:
                com.sumsub.sns.internal.presentation.screen.error.a r3 = r9.f35260e
                r9.f35259d = r1
                r9.f35256a = r10
                r6 = 8
                r9.f35258c = r6
                java.lang.Object r2 = r3.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r2 != r0) goto L_0x017f
                return r0
            L_0x017f:
                r3 = r1
                r8 = r2
                r2 = r10
                r10 = r8
            L_0x0183:
                java.lang.String r10 = (java.lang.String) r10
                if (r10 == 0) goto L_0x0193
                com.sumsub.sns.internal.presentation.screen.error.a r1 = r9.f35260e
                com.sumsub.sns.internal.core.data.source.extensions.a r1 = r1.f35249r
                android.text.Spanned r10 = r1.a(r10)
                r1 = r10
                goto L_0x0194
            L_0x0193:
                r1 = r5
            L_0x0194:
                com.sumsub.sns.internal.presentation.screen.error.a r10 = r9.f35260e
                r9.f35259d = r3
                r9.f35256a = r2
                r9.f35257b = r1
                r6 = 9
                r9.f35258c = r6
                java.lang.String r6 = "sns_oops_action_goBack"
                java.lang.Object r10 = r10.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r10 != r0) goto L_0x01a9
                return r0
            L_0x01a9:
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                goto L_0x01b0
            L_0x01ac:
                r3 = r1
                r10 = r5
                r1 = r10
                r2 = r1
            L_0x01b0:
                com.sumsub.sns.internal.presentation.screen.error.a r6 = r9.f35260e
                com.sumsub.sns.internal.core.data.model.o r6 = r6.f35248q
                com.sumsub.sns.internal.core.data.model.o$a r6 = r6.a()
                r7 = 0
                if (r6 == 0) goto L_0x01cc
                java.lang.String r6 = r6.f()
                if (r6 == 0) goto L_0x01cc
                boolean r6 = kotlin.text.StringsKt__StringsJVMKt.z(r6)
                r6 = r6 ^ r4
                if (r6 != r4) goto L_0x01cc
                r6 = r4
                goto L_0x01cd
            L_0x01cc:
                r6 = r7
            L_0x01cd:
                if (r6 == 0) goto L_0x01dd
                com.sumsub.sns.internal.presentation.screen.error.a r2 = r9.f35260e
                com.sumsub.sns.internal.core.data.model.o r2 = r2.f35248q
                com.sumsub.sns.internal.core.data.model.o$a r2 = r2.a()
                java.lang.String r2 = r2.f()
            L_0x01dd:
                com.sumsub.sns.internal.presentation.screen.error.a r6 = r9.f35260e
                com.sumsub.sns.internal.core.data.model.o r6 = r6.f35248q
                com.sumsub.sns.internal.core.data.model.o$a r6 = r6.a()
                if (r6 == 0) goto L_0x01f8
                java.lang.String r6 = r6.e()
                if (r6 == 0) goto L_0x01f8
                boolean r6 = kotlin.text.StringsKt__StringsJVMKt.z(r6)
                r6 = r6 ^ r4
                if (r6 != r4) goto L_0x01f8
                r6 = r4
                goto L_0x01f9
            L_0x01f8:
                r6 = r7
            L_0x01f9:
                if (r6 == 0) goto L_0x0209
                com.sumsub.sns.internal.presentation.screen.error.a r1 = r9.f35260e
                com.sumsub.sns.internal.core.data.model.o r1 = r1.f35248q
                com.sumsub.sns.internal.core.data.model.o$a r1 = r1.a()
                java.lang.String r1 = r1.e()
            L_0x0209:
                com.sumsub.sns.internal.presentation.screen.error.a r6 = r9.f35260e
                com.sumsub.sns.internal.core.data.model.o r6 = r6.f35248q
                com.sumsub.sns.internal.core.data.model.o$a r6 = r6.a()
                if (r6 == 0) goto L_0x0223
                java.lang.String r6 = r6.d()
                if (r6 == 0) goto L_0x0223
                boolean r6 = kotlin.text.StringsKt__StringsJVMKt.z(r6)
                r6 = r6 ^ r4
                if (r6 != r4) goto L_0x0223
                goto L_0x0224
            L_0x0223:
                r4 = r7
            L_0x0224:
                if (r4 == 0) goto L_0x0234
                com.sumsub.sns.internal.presentation.screen.error.a r10 = r9.f35260e
                com.sumsub.sns.internal.core.data.model.o r10 = r10.f35248q
                com.sumsub.sns.internal.core.data.model.o$a r10 = r10.a()
                java.lang.String r10 = r10.d()
            L_0x0234:
                if (r2 == 0) goto L_0x0250
                if (r1 == 0) goto L_0x0250
                if (r10 == 0) goto L_0x0250
                com.sumsub.sns.internal.presentation.screen.error.a$b$b r4 = new com.sumsub.sns.internal.presentation.screen.error.a$b$b
                r4.<init>(r2, r1, r10)
                r9.f35259d = r5
                r9.f35256a = r5
                r9.f35257b = r5
                r10 = 10
                r9.f35258c = r10
                java.lang.Object r10 = r3.emit(r4, r9)
                if (r10 != r0) goto L_0x0263
                return r0
            L_0x0250:
                com.sumsub.sns.internal.presentation.screen.error.a$b$c r10 = com.sumsub.sns.internal.presentation.screen.error.a.b.c.f35255a
                r9.f35259d = r5
                r9.f35256a = r5
                r9.f35257b = r5
                r1 = 11
                r9.f35258c = r1
                java.lang.Object r10 = r3.emit(r10, r9)
                if (r10 != r0) goto L_0x0263
                return r0
            L_0x0263:
                kotlin.Unit r10 = kotlin.Unit.f56620a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.error.a.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public a(o oVar, com.sumsub.sns.internal.core.data.source.extensions.a aVar, com.sumsub.sns.internal.core.data.source.common.a aVar2, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        super(aVar2, bVar);
        this.f35248q = oVar;
        this.f35249r = aVar;
    }

    public void b(o oVar) {
    }

    /* renamed from: p */
    public j1<b> j() {
        return this.f35250s;
    }
}
