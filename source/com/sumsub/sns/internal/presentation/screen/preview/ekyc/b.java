package com.sumsub.sns.internal.presentation.screen.preview.ekyc;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.m0;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.common.a1;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.u0;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.FieldName;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationStatus;
import com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType;
import com.sumsub.sns.internal.core.data.source.applicant.remote.EKycFlowStatus;
import com.sumsub.sns.internal.core.data.source.applicant.remote.e0;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.core.presentation.form.FieldId;
import com.sumsub.sns.internal.core.presentation.form.b;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import com.sumsub.sns.internal.presentation.screen.preview.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.collections.LongIterator;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.k1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;

public final class b extends com.sumsub.sns.internal.presentation.screen.preview.a<f> implements com.sumsub.sns.internal.core.presentation.form.b {
    public static final C0430b D = new C0430b((kotlin.jvm.internal.r) null);
    public static final /* synthetic */ kotlin.reflect.l<Object>[] E;
    public static final String F = "sns_ekyc_form_title";
    public static final String G = "sns_ekyc_form_subtitle";
    public static final String H = "sns_ekyc_%s_title";
    public static final String I = "sns_ekyc_%s_title";
    public static final String J = "sns_ekyc_action_skip";
    public static final String K = "sns_ekyc_action_continue";
    public static final String L = "sns_ekyc_country_placeholder";
    public static final String M = "name";
    public static final String N = "instructions";
    public static final String O = "sns_ekyc_source_%s::%s";
    public static final String P = "sns_confirmation_code_ekyc_title";
    public static final String Q = "sns_confirmation_code_ekyc_subtitle";
    public static final String R = "sns_confirmation_code_resendCountdown";
    public static final String S = "sns_confirmation_code_action_resend";
    public static final String T = "sns_confirmation_code_isNotValid";
    public static final String U = "sns_ekyc_error_common";
    public static final String V = "sns_confirmation_result_ekyc_failure_title";
    public static final String W = "Unknown error";
    public static final long X = 1000;
    public static final long Y = 60;
    public final com.sumsub.sns.internal.core.data.source.extensions.a Z;

    /* renamed from: a0  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.applicant.e f35377a0;

    /* renamed from: b0  reason: collision with root package name */
    public final a1 f35378b0 = new a1();

    /* renamed from: c0  reason: collision with root package name */
    public com.sumsub.sns.internal.core.data.model.g f35379c0;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f35380d0;

    /* renamed from: e0  reason: collision with root package name */
    public n1 f35381e0;

    /* renamed from: f0  reason: collision with root package name */
    public final h0 f35382f0 = i0.a(f1.b(Executors.newSingleThreadExecutor()));

    /* renamed from: g0  reason: collision with root package name */
    public com.sumsub.sns.internal.domain.c f35383g0;

    /* renamed from: h0  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f35384h0;

    /* renamed from: i0  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f35385i0;

    /* renamed from: j0  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f35386j0;

    /* renamed from: k0  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f35387k0;

    /* renamed from: l0  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.form.d f35388l0;

    /* renamed from: m0  reason: collision with root package name */
    public final b1<b.a> f35389m0;

    /* renamed from: n0  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f35390n0;

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$1", f = "SNSEkycViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements d10.p<f, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35391a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35392b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f35393c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
            this.f35393c = bVar;
        }

        /* renamed from: a */
        public final Object invoke(f fVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((a) create(fVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f35393c, cVar);
            aVar.f35392b = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35391a == 0) {
                kotlin.k.b(obj);
                f fVar = (f) this.f35392b;
                if (fVar instanceof f.a) {
                    b1 k11 = this.f35393c.f35389m0;
                    f.a aVar = (f.a) fVar;
                    CharSequence p11 = aVar.p();
                    String obj2 = p11 != null ? p11.toString() : null;
                    CharSequence o11 = aVar.o();
                    k11.setValue(new b.a(0, CollectionsKt__CollectionsJVMKt.e(new b.C0375b(0, obj2, o11 != null ? o11.toString() : null, aVar.m())), (String) null, new b.c((String) null, (String) null, 3, (kotlin.jvm.internal.r) null)));
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$updateCountry$1", f = "SNSEkycViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class a0 extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35394a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f35395b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f35396c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List<com.sumsub.sns.internal.domain.b> f35397d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a0(b bVar, String str, List<com.sumsub.sns.internal.domain.b> list, kotlin.coroutines.c<? super a0> cVar) {
            super(2, cVar);
            this.f35395b = bVar;
            this.f35396c = str;
            this.f35397d = list;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((a0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new a0(this.f35395b, this.f35396c, this.f35397d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            com.sumsub.sns.internal.core.data.model.j jVar;
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35394a == 0) {
                kotlin.k.b(obj);
                com.sumsub.log.logger.a.c(com.sumsub.sns.internal.log.a.f34862a, a.f35376b, "Update country, oldCountry=" + this.f35395b.s() + ", newCountry=" + this.f35396c + ", errors=" + this.f35397d.size(), (Throwable) null, 4, (Object) null);
                boolean z11 = true;
                boolean b11 = kotlin.jvm.internal.x.b(this.f35395b.s(), this.f35396c) ^ true;
                this.f35395b.b(this.f35396c);
                com.sumsub.sns.internal.core.data.model.e b12 = this.f35395b.d();
                String str = null;
                Map<String, List<com.sumsub.sns.internal.core.data.model.j>> w11 = b12 != null ? b12.w() : null;
                List list = w11 != null ? w11.get(this.f35396c) : null;
                if (!b11) {
                    String e11 = this.f35395b.C();
                    if (e11 != null && !StringsKt__StringsJVMKt.z(e11)) {
                        z11 = false;
                    }
                    if (!z11) {
                        str = this.f35395b.C();
                        n1 unused2 = this.f35395b.b(str, this.f35397d);
                        return Unit.f56620a;
                    }
                }
                if (!(list == null || (jVar = (com.sumsub.sns.internal.core.data.model.j) CollectionsKt___CollectionsKt.d0(list, 0)) == null)) {
                    str = jVar.h();
                }
                n1 unused3 = this.f35395b.b(str, this.f35397d);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$b  reason: collision with other inner class name */
    public static final class C0430b {
        public /* synthetic */ C0430b(kotlin.jvm.internal.r rVar) {
            this();
        }

        public C0430b() {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$updateSource$1", f = "SNSEkycViewModel.kt", l = {216, 224, 243, 248, 258}, m = "invokeSuspend")
    public static final class b0 extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35398a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35399b;

        /* renamed from: c  reason: collision with root package name */
        public Object f35400c;

        /* renamed from: d  reason: collision with root package name */
        public Object f35401d;

        /* renamed from: e  reason: collision with root package name */
        public Object f35402e;

        /* renamed from: f  reason: collision with root package name */
        public Object f35403f;

        /* renamed from: g  reason: collision with root package name */
        public Object f35404g;

        /* renamed from: h  reason: collision with root package name */
        public Object f35405h;

        /* renamed from: i  reason: collision with root package name */
        public Object f35406i;

        /* renamed from: j  reason: collision with root package name */
        public Object f35407j;

        /* renamed from: k  reason: collision with root package name */
        public Object f35408k;

        /* renamed from: l  reason: collision with root package name */
        public int f35409l;

        /* renamed from: m  reason: collision with root package name */
        public int f35410m;

        /* renamed from: n  reason: collision with root package name */
        public final /* synthetic */ String f35411n;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ b f35412o;

        /* renamed from: p  reason: collision with root package name */
        public final /* synthetic */ List<com.sumsub.sns.internal.domain.b> f35413p;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$updateSource$1$11", f = "SNSEkycViewModel.kt", l = {295, 299}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<f, kotlin.coroutines.c<? super f>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f35414a;

            /* renamed from: b  reason: collision with root package name */
            public int f35415b;

            /* renamed from: c  reason: collision with root package name */
            public /* synthetic */ Object f35416c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ b f35417d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f35418e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ ArrayList<FormItem> f35419f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, String str, ArrayList<FormItem> arrayList, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f35417d = bVar;
                this.f35418e = str;
                this.f35419f = arrayList;
            }

            /* renamed from: a */
            public final Object invoke(f fVar, kotlin.coroutines.c<? super f> cVar) {
                return ((a) create(fVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                a aVar = new a(this.f35417d, this.f35418e, this.f35419f, cVar);
                aVar.f35416c = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                String str;
                f.a aVar;
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f35415b;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    b bVar = this.f35417d;
                    this.f35415b = 1;
                    obj = bVar.a((f) this.f35416c, (kotlin.coroutines.c<? super f.a>) this);
                    if (obj == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else if (i11 == 2) {
                    kotlin.k.b(obj);
                    str = (String) this.f35414a;
                    aVar = (f.a) this.f35416c;
                    return f.a.a(aVar, (CharSequence) null, (CharSequence) null, (String) obj, (CharSequence) null, (com.sumsub.sns.internal.domain.c) null, str, this.f35418e, this.f35419f, 27, (Object) null);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.a aVar2 = (f.a) obj;
                String d12 = this.f35417d.s();
                b bVar2 = this.f35417d;
                this.f35416c = aVar2;
                this.f35414a = d12;
                this.f35415b = 2;
                Object a11 = bVar2.a(b.K, (kotlin.coroutines.c<? super String>) this);
                if (a11 == d11) {
                    return d11;
                }
                str = d12;
                aVar = aVar2;
                obj = a11;
                return f.a.a(aVar, (CharSequence) null, (CharSequence) null, (String) obj, (CharSequence) null, (com.sumsub.sns.internal.domain.c) null, str, this.f35418e, this.f35419f, 27, (Object) null);
            }
        }

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$b0$b  reason: collision with other inner class name */
        public static final class C0431b extends Lambda implements d10.l<FieldName, String> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f35420a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0431b(b bVar) {
                super(1);
                this.f35420a = bVar;
            }

            /* renamed from: a */
            public final String invoke(FieldName fieldName) {
                return (String) this.f35420a.E().get(fieldName.getValue());
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b0(String str, b bVar, List<com.sumsub.sns.internal.domain.b> list, kotlin.coroutines.c<? super b0> cVar) {
            super(2, cVar);
            this.f35411n = str;
            this.f35412o = bVar;
            this.f35413p = list;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((b0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b0(this.f35411n, this.f35412o, this.f35413p, cVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:111:0x03bb, code lost:
            r6 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.a(r14, (java.util.List) r13, r6);
         */
        /* JADX WARNING: Removed duplicated region for block: B:101:0x0386  */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x0396  */
        /* JADX WARNING: Removed duplicated region for block: B:128:0x0431  */
        /* JADX WARNING: Removed duplicated region for block: B:131:0x0449  */
        /* JADX WARNING: Removed duplicated region for block: B:136:0x0270 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x01ae  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x01b1  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x01cc  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x025c  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0297  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x02e8  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x02ed A[PHI: r0 
          PHI: (r0v11 java.lang.String) = (r0v8 java.lang.String), (r0v12 java.lang.String) binds: [B:74:0x02e0, B:76:0x02e6] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x0301  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0342 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0343  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x0349  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0364  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r36) {
            /*
                r35 = this;
                r0 = r35
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f35410m
                java.lang.String r4 = "Required value was null."
                java.lang.String r5 = "source_id"
                r6 = 5
                r7 = 4
                r8 = 3
                r9 = 2
                java.lang.String r10 = ""
                r12 = 1
                if (r2 == 0) goto L_0x00cf
                if (r2 == r12) goto L_0x00bf
                if (r2 == r9) goto L_0x009b
                if (r2 == r8) goto L_0x0084
                if (r2 == r7) goto L_0x0040
                if (r2 != r6) goto L_0x0038
                java.lang.Object r1 = r0.f35401d
                java.util.HashMap r1 = (java.util.HashMap) r1
                java.lang.Object r2 = r0.f35400c
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r2 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r2
                java.lang.Object r5 = r0.f35399b
                java.util.ArrayList r5 = (java.util.ArrayList) r5
                java.lang.Object r6 = r0.f35398a
                java.util.List r6 = (java.util.List) r6
                kotlin.k.b(r36)
                r3 = r36
                r15 = r0
                r0 = r5
                goto L_0x0345
            L_0x0038:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0040:
                int r2 = r0.f35409l
                java.lang.Object r8 = r0.f35408k
                java.util.Collection r8 = (java.util.Collection) r8
                java.lang.Object r9 = r0.f35407j
                java.lang.String r9 = (java.lang.String) r9
                java.lang.Object r14 = r0.f35406i
                java.lang.String r14 = (java.lang.String) r14
                java.lang.Object r15 = r0.f35405h
                com.sumsub.sns.internal.core.data.model.j r15 = (com.sumsub.sns.internal.core.data.model.j) r15
                java.lang.Object r6 = r0.f35404g
                java.util.Iterator r6 = (java.util.Iterator) r6
                java.lang.Object r7 = r0.f35403f
                java.util.Collection r7 = (java.util.Collection) r7
                java.lang.Object r3 = r0.f35402e
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b) r3
                java.lang.Object r13 = r0.f35401d
                java.util.HashMap r13 = (java.util.HashMap) r13
                java.lang.Object r11 = r0.f35400c
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r11 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r11
                java.lang.Object r12 = r0.f35399b
                java.util.ArrayList r12 = (java.util.ArrayList) r12
                r19 = r2
                java.lang.Object r2 = r0.f35398a
                java.util.List r2 = (java.util.List) r2
                kotlin.k.b(r36)
                r20 = r15
                r15 = r0
                r0 = r36
                r33 = r7
                r7 = r2
                r2 = r19
                r19 = r10
                r10 = r9
                r9 = r33
                goto L_0x02de
            L_0x0084:
                java.lang.Object r2 = r0.f35401d
                java.util.HashMap r2 = (java.util.HashMap) r2
                java.lang.Object r3 = r0.f35400c
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r3 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r3
                java.lang.Object r6 = r0.f35399b
                java.util.ArrayList r6 = (java.util.ArrayList) r6
                java.lang.Object r7 = r0.f35398a
                java.util.List r7 = (java.util.List) r7
                kotlin.k.b(r36)
                r8 = r36
                goto L_0x024d
            L_0x009b:
                int r2 = r0.f35409l
                java.lang.Object r3 = r0.f35402e
                com.sumsub.sns.internal.core.data.model.FieldName r3 = (com.sumsub.sns.internal.core.data.model.FieldName) r3
                java.lang.Object r6 = r0.f35401d
                java.util.HashMap r6 = (java.util.HashMap) r6
                java.lang.Object r7 = r0.f35400c
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r7 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r7
                java.lang.Object r9 = r0.f35399b
                java.util.ArrayList r9 = (java.util.ArrayList) r9
                java.lang.Object r11 = r0.f35398a
                java.util.List r11 = (java.util.List) r11
                kotlin.k.b(r36)
                r20 = r3
                r3 = r7
                r7 = r11
                r11 = r2
                r2 = r6
                r6 = r9
                r9 = r36
                goto L_0x019a
            L_0x00bf:
                java.lang.Object r2 = r0.f35399b
                java.util.ArrayList r2 = (java.util.ArrayList) r2
                java.lang.Object r3 = r0.f35398a
                java.util.List r3 = (java.util.List) r3
                kotlin.k.b(r36)
                r6 = r3
                r3 = r36
                goto L_0x0165
            L_0x00cf:
                kotlin.k.b(r36)
                com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r6 = "Update source, sourceId="
                r3.append(r6)
                java.lang.String r6 = r0.f35411n
                r3.append(r6)
                java.lang.String r21 = r3.toString()
                r22 = 0
                r23 = 4
                r24 = 0
                java.lang.String r20 = "EKyc"
                r19 = r2
                com.sumsub.log.logger.a.c(r19, r20, r21, r22, r23, r24)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = r0.f35412o
                com.sumsub.sns.internal.core.data.model.e r3 = r3.d()
                if (r3 == 0) goto L_0x0453
                java.util.Map r3 = r3.w()
                if (r3 != 0) goto L_0x0104
                goto L_0x0453
            L_0x0104:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r6 = r0.f35412o
                java.lang.String r6 = r6.s()
                java.lang.Object r6 = r3.get(r6)
                java.util.List r6 = (java.util.List) r6
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r11 = "Update source, country="
                r7.append(r11)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r11 = r0.f35412o
                java.lang.String r11 = r11.s()
                r7.append(r11)
                java.lang.String r11 = ", sources="
                r7.append(r11)
                r7.append(r6)
                java.lang.String r11 = ", ekycConfig="
                r7.append(r11)
                r7.append(r3)
                r3 = 44
                r7.append(r3)
                java.lang.String r21 = r7.toString()
                r22 = 0
                r23 = 4
                r24 = 0
                java.lang.String r20 = "EKyc"
                r19 = r2
                com.sumsub.log.logger.a.c(r19, r20, r21, r22, r23, r24)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r2 = r0.f35412o
                java.lang.String r3 = r0.f35411n
                r2.f((java.lang.String) r3)
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = r0.f35412o
                r0.f35398a = r6
                r0.f35399b = r2
                r7 = 1
                r0.f35410m = r7
                java.lang.Object r3 = r3.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c>) r0)
                if (r3 != r1) goto L_0x0165
                return r1
            L_0x0165:
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r3 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r3
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r11 = r0.f35411n
                if (r11 == 0) goto L_0x0175
                r7.put(r5, r11)
                kotlin.Unit r11 = kotlin.Unit.f56620a
            L_0x0175:
                com.sumsub.sns.internal.core.data.model.FieldName r11 = com.sumsub.sns.internal.core.data.model.FieldName.country
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r12 = r0.f35412o
                r0.f35398a = r6
                r0.f35399b = r2
                r0.f35400c = r3
                r0.f35401d = r7
                r0.f35402e = r11
                r13 = 1
                r0.f35409l = r13
                r0.f35410m = r9
                java.lang.String r9 = "sns_ekyc_country_placeholder"
                java.lang.Object r9 = r12.a((java.lang.String) r9, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r9 != r1) goto L_0x0191
                return r1
            L_0x0191:
                r20 = r11
                r11 = 1
                r33 = r6
                r6 = r2
                r2 = r7
                r7 = r33
            L_0x019a:
                r25 = 0
                r24 = 0
                r23 = 0
                r22 = 0
                r26 = r9
                java.lang.String r26 = (java.lang.String) r26
                r27 = 60
                r28 = 0
                com.sumsub.sns.internal.core.data.model.h$d r9 = new com.sumsub.sns.internal.core.data.model.h$d
                if (r11 == 0) goto L_0x01b1
                r21 = 1
                goto L_0x01b3
            L_0x01b1:
                r21 = 0
            L_0x01b3:
                r19 = r9
                r19.<init>((com.sumsub.sns.internal.core.data.model.FieldName) r20, (boolean) r21, (com.sumsub.sns.internal.core.data.model.FieldType) r22, (java.lang.String) r23, (java.util.List) r24, (com.sumsub.sns.internal.core.data.model.p) r25, (java.lang.String) r26, (int) r27, (kotlin.jvm.internal.r) r28)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r11 = r0.f35412o
                java.lang.String r22 = r11.s()
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r11 = r0.f35412o
                com.sumsub.sns.internal.core.data.model.e r23 = r11.d()
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r11 = r0.f35412o
                com.sumsub.sns.internal.domain.c r24 = r11.f35383g0
                if (r24 == 0) goto L_0x0449
                java.lang.String r11 = r0.f35411n
                if (r11 == 0) goto L_0x01dd
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r12 = r0.f35412o
                java.lang.String r13 = r12.s()
                d10.p r11 = r12.a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r3, (java.lang.String) r13, (java.lang.String) r11)
                r26 = r11
                goto L_0x01df
            L_0x01dd:
                r26 = 0
            L_0x01df:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r11 = r0.f35412o
                java.util.List<com.sumsub.sns.internal.domain.b> r12 = r0.f35413p
                com.sumsub.sns.internal.core.data.model.FieldName r13 = com.sumsub.sns.internal.core.data.model.FieldName.country
                com.sumsub.sns.internal.domain.b r11 = r11.a((java.util.List<com.sumsub.sns.internal.domain.b>) r12, (com.sumsub.sns.internal.core.data.model.FieldName) r13)
                if (r11 == 0) goto L_0x01f2
                java.lang.CharSequence r11 = r11.d()
                r27 = r11
                goto L_0x01f4
            L_0x01f2:
                r27 = 0
            L_0x01f4:
                r28 = 0
                r29 = 0
                r30 = 192(0xc0, float:2.69E-43)
                r31 = 0
                r21 = r9
                r25 = r3
                com.sumsub.sns.internal.core.presentation.form.model.FormItem r9 = com.sumsub.sns.internal.presentation.utils.a.a(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
                java.lang.String r11 = r9.f()
                if (r11 == 0) goto L_0x0218
                com.sumsub.sns.internal.core.data.source.applicant.remote.k r12 = r9.d()
                java.lang.String r12 = r12.p()
                if (r12 != 0) goto L_0x0215
                r12 = r10
            L_0x0215:
                r2.put(r12, r11)
            L_0x0218:
                r6.add(r9)
                if (r7 == 0) goto L_0x0315
                int r9 = r7.size()
                r11 = 1
                if (r9 <= r11) goto L_0x0315
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r9 = r0.f35412o
                kotlin.jvm.internal.d0 r12 = kotlin.jvm.internal.d0.f56774a
                java.lang.Object[] r12 = new java.lang.Object[r11]
                java.lang.String r13 = "source"
                r14 = 0
                r12[r14] = r13
                java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r11)
                java.lang.String r11 = "sns_ekyc_%s_title"
                java.lang.String r11 = java.lang.String.format(r11, r12)
                r0.f35398a = r7
                r0.f35399b = r6
                r0.f35400c = r3
                r0.f35401d = r2
                r12 = 0
                r0.f35402e = r12
                r0.f35410m = r8
                java.lang.Object r8 = r9.a((java.lang.String) r11, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r8 != r1) goto L_0x024d
                return r1
            L_0x024d:
                java.lang.String r8 = (java.lang.String) r8
                java.lang.String r9 = r0.f35411n
                java.util.Iterator r11 = r7.iterator()
                r14 = 0
            L_0x0256:
                boolean r12 = r11.hasNext()
                if (r12 == 0) goto L_0x0270
                java.lang.Object r12 = r11.next()
                com.sumsub.sns.internal.core.data.model.j r12 = (com.sumsub.sns.internal.core.data.model.j) r12
                java.lang.String r12 = r12.h()
                boolean r12 = kotlin.jvm.internal.x.b(r12, r9)
                if (r12 == 0) goto L_0x026d
                goto L_0x0271
            L_0x026d:
                int r14 = r14 + 1
                goto L_0x0256
            L_0x0270:
                r14 = -1
            L_0x0271:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r9 = r0.f35412o
                java.util.ArrayList r11 = new java.util.ArrayList
                r12 = 10
                int r13 = kotlin.collections.CollectionsKt__IterablesKt.u(r7, r12)
                r11.<init>(r13)
                java.util.Iterator r12 = r7.iterator()
                r13 = r2
                r2 = r14
                r14 = r0
                r33 = r11
                r11 = r3
                r3 = r9
                r9 = r8
                r8 = r33
                r34 = r12
                r12 = r6
                r6 = r34
            L_0x0291:
                boolean r15 = r6.hasNext()
                if (r15 == 0) goto L_0x0301
                java.lang.Object r15 = r6.next()
                com.sumsub.sns.internal.core.data.model.j r15 = (com.sumsub.sns.internal.core.data.model.j) r15
                java.lang.String r19 = r15.h()
                if (r19 != 0) goto L_0x02a7
                r0 = r10
                r19 = r0
                goto L_0x02ab
            L_0x02a7:
                r0 = r19
                r19 = r10
            L_0x02ab:
                java.lang.String r10 = r15.h()
                r14.f35398a = r7
                r14.f35399b = r12
                r14.f35400c = r11
                r14.f35401d = r13
                r14.f35402e = r3
                r14.f35403f = r8
                r14.f35404g = r6
                r14.f35405h = r15
                r14.f35406i = r0
                r14.f35407j = r9
                r14.f35408k = r8
                r14.f35409l = r2
                r20 = r0
                r0 = 4
                r14.f35410m = r0
                java.lang.String r0 = "name"
                java.lang.Object r0 = r3.a((java.lang.String) r0, (java.lang.String) r10, (kotlin.coroutines.c<? super java.lang.String>) r14)
                if (r0 != r1) goto L_0x02d5
                return r1
            L_0x02d5:
                r10 = r9
                r9 = r8
                r33 = r15
                r15 = r14
                r14 = r20
                r20 = r33
            L_0x02de:
                java.lang.String r0 = (java.lang.String) r0
                if (r0 != 0) goto L_0x02ed
                java.lang.String r0 = r20.h()
                if (r0 != 0) goto L_0x02ed
                r36 = r1
                r0 = r19
                goto L_0x02ef
            L_0x02ed:
                r36 = r1
            L_0x02ef:
                com.sumsub.sns.internal.core.data.model.h$e$a$a r1 = new com.sumsub.sns.internal.core.data.model.h$e$a$a
                r1.<init>(r14, r0)
                r8.add(r1)
                r0 = r35
                r1 = r36
                r8 = r9
                r9 = r10
                r14 = r15
                r10 = r19
                goto L_0x0291
            L_0x0301:
                java.util.List r8 = (java.util.List) r8
                com.sumsub.sns.internal.core.data.model.h$e$a r0 = new com.sumsub.sns.internal.core.data.model.h$e$a
                r0.<init>(r9, r2, r8)
                com.sumsub.sns.internal.core.presentation.form.model.FormItem r0 = com.sumsub.sns.internal.presentation.utils.c.a(r0, r5)
                r12.add(r0)
                r0 = r1
                r6 = r7
                r2 = r11
                r5 = r12
                r1 = r13
                goto L_0x031c
            L_0x0315:
                r14 = r35
                r0 = r1
                r1 = r2
                r2 = r3
                r5 = r6
                r6 = r7
            L_0x031c:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = r14.f35412o
                java.lang.String r7 = r14.f35411n
                r14.f35398a = r6
                r14.f35399b = r5
                r14.f35400c = r2
                r14.f35401d = r1
                r8 = 0
                r14.f35402e = r8
                r14.f35403f = r8
                r14.f35404g = r8
                r14.f35405h = r8
                r14.f35406i = r8
                r14.f35407j = r8
                r14.f35408k = r8
                r8 = 5
                r14.f35410m = r8
                java.lang.String r8 = "instructions"
                java.lang.Object r3 = r3.a((java.lang.String) r8, (java.lang.String) r7, (kotlin.coroutines.c<? super java.lang.String>) r14)
                if (r3 != r0) goto L_0x0343
                return r0
            L_0x0343:
                r0 = r5
                r15 = r14
            L_0x0345:
                java.lang.String r3 = (java.lang.String) r3
                if (r3 == 0) goto L_0x0362
                boolean r5 = kotlin.text.StringsKt__StringsJVMKt.z(r3)
                r7 = 1
                r5 = r5 ^ r7
                if (r5 == 0) goto L_0x0352
                goto L_0x0353
            L_0x0352:
                r3 = 0
            L_0x0353:
                if (r3 == 0) goto L_0x0362
                com.sumsub.sns.internal.core.data.model.h$e$b r5 = new com.sumsub.sns.internal.core.data.model.h$e$b
                r5.<init>(r3)
                r3 = 0
                com.sumsub.sns.internal.core.presentation.form.model.FormItem r5 = com.sumsub.sns.internal.presentation.utils.c.a(r5, r3, r7, r3)
                r0.add(r5)
            L_0x0362:
                if (r6 == 0) goto L_0x0386
                java.lang.String r3 = r15.f35411n
                java.util.Iterator r5 = r6.iterator()
            L_0x036a:
                boolean r6 = r5.hasNext()
                if (r6 == 0) goto L_0x0382
                java.lang.Object r12 = r5.next()
                r6 = r12
                com.sumsub.sns.internal.core.data.model.j r6 = (com.sumsub.sns.internal.core.data.model.j) r6
                java.lang.String r6 = r6.h()
                boolean r6 = kotlin.jvm.internal.x.b(r6, r3)
                if (r6 == 0) goto L_0x036a
                goto L_0x0383
            L_0x0382:
                r12 = 0
            L_0x0383:
                com.sumsub.sns.internal.core.data.model.j r12 = (com.sumsub.sns.internal.core.data.model.j) r12
                goto L_0x0387
            L_0x0386:
                r12 = 0
            L_0x0387:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$b0$b r3 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$b0$b
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r5 = r15.f35412o
                r3.<init>(r5)
                if (r12 == 0) goto L_0x0431
                java.util.List r5 = r12.g()
                if (r5 == 0) goto L_0x0431
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r14 = r15.f35412o
                java.util.List<com.sumsub.sns.internal.domain.b> r13 = r15.f35413p
                java.util.ArrayList r12 = new java.util.ArrayList
                r6 = 10
                int r6 = kotlin.collections.CollectionsKt__IterablesKt.u(r5, r6)
                r12.<init>(r6)
                java.util.Iterator r16 = r5.iterator()
            L_0x03a9:
                boolean r5 = r16.hasNext()
                if (r5 == 0) goto L_0x0427
                java.lang.Object r5 = r16.next()
                com.sumsub.sns.internal.core.data.model.h$d r5 = (com.sumsub.sns.internal.core.data.model.h.d) r5
                com.sumsub.sns.internal.core.data.model.FieldName r6 = r5.q()
                if (r6 == 0) goto L_0x03c7
                com.sumsub.sns.internal.domain.b r6 = r14.a((java.util.List<com.sumsub.sns.internal.domain.b>) r13, (com.sumsub.sns.internal.core.data.model.FieldName) r6)
                if (r6 == 0) goto L_0x03c7
                java.lang.CharSequence r6 = r6.d()
                r11 = r6
                goto L_0x03c8
            L_0x03c7:
                r11 = 0
            L_0x03c8:
                java.lang.String r6 = r14.s()
                com.sumsub.sns.internal.core.data.model.e r7 = r14.d()
                com.sumsub.sns.internal.domain.c r8 = r14.f35383g0
                if (r8 == 0) goto L_0x041d
                java.lang.String r9 = r14.C()
                if (r9 == 0) goto L_0x03e6
                java.lang.String r10 = r14.s()
                d10.p r9 = r14.a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r2, (java.lang.String) r10, (java.lang.String) r9)
                r10 = r9
                goto L_0x03e7
            L_0x03e6:
                r10 = 0
            L_0x03e7:
                r17 = 0
                r18 = 64
                r19 = 0
                r9 = r2
                r32 = r12
                r12 = r17
                r17 = r13
                r13 = r3
                r20 = r14
                r14 = r18
                r18 = r2
                r2 = r15
                r15 = r19
                com.sumsub.sns.internal.core.presentation.form.model.FormItem r5 = com.sumsub.sns.internal.presentation.utils.a.a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
                java.lang.String r6 = r5.f()
                if (r6 == 0) goto L_0x040f
                java.lang.String r7 = r5.c()
                r1.put(r7, r6)
            L_0x040f:
                r6 = r32
                r6.add(r5)
                r15 = r2
                r12 = r6
                r13 = r17
                r2 = r18
                r14 = r20
                goto L_0x03a9
            L_0x041d:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = r4.toString()
                r0.<init>(r1)
                throw r0
            L_0x0427:
                r6 = r12
                r2 = r15
                boolean r3 = r0.addAll(r6)
                kotlin.coroutines.jvm.internal.a.a(r3)
                goto L_0x0432
            L_0x0431:
                r2 = r15
            L_0x0432:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = r2.f35412o
                r3.d((java.util.Map<java.lang.String, java.lang.String>) r1)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r1 = r2.f35412o
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$b0$a r3 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$b0$a
                java.lang.String r2 = r2.f35411n
                r4 = 0
                r3.<init>(r1, r2, r0, r4)
                r0 = 0
                r2 = 1
                com.sumsub.sns.core.presentation.base.a.a(r1, r0, r3, r2, r4)
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            L_0x0449:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = r4.toString()
                r0.<init>(r1)
                throw r0
            L_0x0453:
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.b0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class c implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final String f35421a;

        /* renamed from: b  reason: collision with root package name */
        public final String f35422b;

        /* renamed from: c  reason: collision with root package name */
        public final String f35423c;

        public c(String str, String str2, String str3) {
            this.f35421a = str;
            this.f35422b = str2;
            this.f35423c = str3;
        }

        public final String a() {
            return this.f35421a;
        }

        public final String b() {
            return this.f35422b;
        }

        public final String c() {
            return this.f35423c;
        }

        public final String d() {
            return this.f35423c;
        }

        public final String e() {
            return this.f35421a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return kotlin.jvm.internal.x.b(this.f35421a, cVar.f35421a) && kotlin.jvm.internal.x.b(this.f35422b, cVar.f35422b) && kotlin.jvm.internal.x.b(this.f35423c, cVar.f35423c);
        }

        public final String f() {
            return this.f35422b;
        }

        public int hashCode() {
            String str = this.f35421a;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f35422b;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f35423c;
            if (str3 != null) {
                i11 = str3.hashCode();
            }
            return hashCode2 + i11;
        }

        public String toString() {
            return "EidConfirmationEvent(mobileToken=" + this.f35421a + ", url=" + this.f35422b + ", hash=" + this.f35423c + ')';
        }

        public final c a(String str, String str2, String str3) {
            return new c(str, str2, str3);
        }

        public static /* synthetic */ c a(c cVar, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = cVar.f35421a;
            }
            if ((i11 & 2) != 0) {
                str2 = cVar.f35422b;
            }
            if ((i11 & 4) != 0) {
                str3 = cVar.f35423c;
            }
            return cVar.a(str, str2, str3);
        }
    }

    public static final class d implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f35424a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f35425b;

        public d(CharSequence charSequence, CharSequence charSequence2) {
            this.f35424a = charSequence;
            this.f35425b = charSequence2;
        }

        public final CharSequence a() {
            return this.f35424a;
        }

        public final CharSequence b() {
            return this.f35425b;
        }

        public final CharSequence c() {
            return this.f35425b;
        }

        public final CharSequence d() {
            return this.f35424a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return kotlin.jvm.internal.x.b(this.f35424a, dVar.f35424a) && kotlin.jvm.internal.x.b(this.f35425b, dVar.f35425b);
        }

        public int hashCode() {
            CharSequence charSequence = this.f35424a;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f35425b;
            if (charSequence2 != null) {
                i11 = charSequence2.hashCode();
            }
            return hashCode + i11;
        }

        public String toString() {
            return "ErrorEvent(errorText=" + this.f35424a + ", buttonText=" + this.f35425b + ')';
        }

        public final d a(CharSequence charSequence, CharSequence charSequence2) {
            return new d(charSequence, charSequence2);
        }

        public static /* synthetic */ d a(d dVar, CharSequence charSequence, CharSequence charSequence2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = dVar.f35424a;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = dVar.f35425b;
            }
            return dVar.a(charSequence, charSequence2);
        }
    }

    public static final class e extends AbstractSavedStateViewModelFactory {

        /* renamed from: a  reason: collision with root package name */
        public final Document f35426a;

        /* renamed from: b  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.a f35427b;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ e(Document document, androidx.savedstate.c cVar, com.sumsub.sns.internal.core.a aVar, Bundle bundle, int i11, kotlin.jvm.internal.r rVar) {
            this(document, cVar, aVar, (i11 & 8) != 0 ? null : bundle);
        }

        public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
            return new b(this.f35426a, this.f35427b.q(), this.f35427b.h(), savedStateHandle, this.f35427b.n(), this.f35427b.p(), new com.sumsub.sns.internal.core.domain.d(this.f35427b.n(), this.f35427b.p()));
        }

        public e(Document document, androidx.savedstate.c cVar, com.sumsub.sns.internal.core.a aVar, Bundle bundle) {
            super(cVar, bundle);
            this.f35426a = document;
            this.f35427b = aVar;
        }
    }

    public static abstract class f extends a.d {

        public static final class a extends f {

            /* renamed from: a  reason: collision with root package name */
            public final CharSequence f35428a;

            /* renamed from: b  reason: collision with root package name */
            public final CharSequence f35429b;

            /* renamed from: c  reason: collision with root package name */
            public final CharSequence f35430c;

            /* renamed from: d  reason: collision with root package name */
            public final CharSequence f35431d;

            /* renamed from: e  reason: collision with root package name */
            public final com.sumsub.sns.internal.domain.c f35432e;

            /* renamed from: f  reason: collision with root package name */
            public final String f35433f;

            /* renamed from: g  reason: collision with root package name */
            public final String f35434g;

            /* renamed from: h  reason: collision with root package name */
            public final List<FormItem> f35435h;

            public a() {
                this((CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, (com.sumsub.sns.internal.domain.c) null, (String) null, (String) null, (List) null, 255, (kotlin.jvm.internal.r) null);
            }

            public final CharSequence a() {
                return this.f35428a;
            }

            public final CharSequence b() {
                return this.f35429b;
            }

            public final CharSequence c() {
                return this.f35430c;
            }

            public final CharSequence d() {
                return this.f35431d;
            }

            public final com.sumsub.sns.internal.domain.c e() {
                return this.f35432e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return kotlin.jvm.internal.x.b(this.f35428a, aVar.f35428a) && kotlin.jvm.internal.x.b(this.f35429b, aVar.f35429b) && kotlin.jvm.internal.x.b(this.f35430c, aVar.f35430c) && kotlin.jvm.internal.x.b(this.f35431d, aVar.f35431d) && kotlin.jvm.internal.x.b(this.f35432e, aVar.f35432e) && kotlin.jvm.internal.x.b(this.f35433f, aVar.f35433f) && kotlin.jvm.internal.x.b(this.f35434g, aVar.f35434g) && kotlin.jvm.internal.x.b(this.f35435h, aVar.f35435h);
            }

            public final String f() {
                return this.f35433f;
            }

            public final String g() {
                return this.f35434g;
            }

            public final List<FormItem> h() {
                return this.f35435h;
            }

            public int hashCode() {
                CharSequence charSequence = this.f35428a;
                int i11 = 0;
                int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
                CharSequence charSequence2 = this.f35429b;
                int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
                CharSequence charSequence3 = this.f35430c;
                int hashCode3 = (hashCode2 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
                CharSequence charSequence4 = this.f35431d;
                int hashCode4 = (((hashCode3 + (charSequence4 == null ? 0 : charSequence4.hashCode())) * 31) + this.f35432e.hashCode()) * 31;
                String str = this.f35433f;
                int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.f35434g;
                if (str2 != null) {
                    i11 = str2.hashCode();
                }
                return ((hashCode5 + i11) * 31) + this.f35435h.hashCode();
            }

            public final CharSequence i() {
                return this.f35430c;
            }

            public final CharSequence j() {
                return this.f35431d;
            }

            public final String k() {
                return this.f35433f;
            }

            public final String l() {
                return this.f35434g;
            }

            public final List<FormItem> m() {
                return this.f35435h;
            }

            public final com.sumsub.sns.internal.domain.c n() {
                return this.f35432e;
            }

            public final CharSequence o() {
                return this.f35429b;
            }

            public final CharSequence p() {
                return this.f35428a;
            }

            public String toString() {
                return "AppData(title=" + this.f35428a + ", subtitle=" + this.f35429b + ", buttonContinue=" + this.f35430c + ", buttonSkip=" + this.f35431d + ", resources=" + this.f35432e + ", currentCountry=" + this.f35433f + ", currentSourceId=" + this.f35434g + ", formItems=" + this.f35435h + ')';
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ a(java.lang.CharSequence r16, java.lang.CharSequence r17, java.lang.CharSequence r18, java.lang.CharSequence r19, com.sumsub.sns.internal.domain.c r20, java.lang.String r21, java.lang.String r22, java.util.List r23, int r24, kotlin.jvm.internal.r r25) {
                /*
                    r15 = this;
                    r0 = r24
                    r1 = r0 & 1
                    r2 = 0
                    if (r1 == 0) goto L_0x0009
                    r1 = r2
                    goto L_0x000b
                L_0x0009:
                    r1 = r16
                L_0x000b:
                    r3 = r0 & 2
                    if (r3 == 0) goto L_0x0011
                    r3 = r2
                    goto L_0x0013
                L_0x0011:
                    r3 = r17
                L_0x0013:
                    r4 = r0 & 4
                    if (r4 == 0) goto L_0x0019
                    r4 = r2
                    goto L_0x001b
                L_0x0019:
                    r4 = r18
                L_0x001b:
                    r5 = r0 & 8
                    if (r5 == 0) goto L_0x0021
                    r5 = r2
                    goto L_0x0023
                L_0x0021:
                    r5 = r19
                L_0x0023:
                    r6 = r0 & 16
                    if (r6 == 0) goto L_0x0036
                    com.sumsub.sns.internal.domain.c r6 = new com.sumsub.sns.internal.domain.c
                    r8 = 0
                    r9 = 0
                    r10 = 0
                    r11 = 0
                    r12 = 0
                    r13 = 31
                    r14 = 0
                    r7 = r6
                    r7.<init>(r8, r9, r10, r11, r12, r13, r14)
                    goto L_0x0038
                L_0x0036:
                    r6 = r20
                L_0x0038:
                    r7 = r0 & 32
                    if (r7 == 0) goto L_0x003e
                    r7 = r2
                    goto L_0x0040
                L_0x003e:
                    r7 = r21
                L_0x0040:
                    r8 = r0 & 64
                    if (r8 == 0) goto L_0x0045
                    goto L_0x0047
                L_0x0045:
                    r2 = r22
                L_0x0047:
                    r0 = r0 & 128(0x80, float:1.794E-43)
                    if (r0 == 0) goto L_0x0050
                    java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.k()
                    goto L_0x0052
                L_0x0050:
                    r0 = r23
                L_0x0052:
                    r16 = r15
                    r17 = r1
                    r18 = r3
                    r19 = r4
                    r20 = r5
                    r21 = r6
                    r22 = r7
                    r23 = r2
                    r24 = r0
                    r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.a.<init>(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, com.sumsub.sns.internal.domain.c, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.r):void");
            }

            public final a a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, com.sumsub.sns.internal.domain.c cVar, String str, String str2, List<? extends FormItem> list) {
                return new a(charSequence, charSequence2, charSequence3, charSequence4, cVar, str, str2, list);
            }

            public static /* synthetic */ a a(a aVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, com.sumsub.sns.internal.domain.c cVar, String str, String str2, List list, int i11, Object obj) {
                a aVar2 = aVar;
                int i12 = i11;
                return aVar.a((i12 & 1) != 0 ? aVar2.f35428a : charSequence, (i12 & 2) != 0 ? aVar2.f35429b : charSequence2, (i12 & 4) != 0 ? aVar2.f35430c : charSequence3, (i12 & 8) != 0 ? aVar2.f35431d : charSequence4, (i12 & 16) != 0 ? aVar2.f35432e : cVar, (i12 & 32) != 0 ? aVar2.f35433f : str, (i12 & 64) != 0 ? aVar2.f35434g : str2, (i12 & 128) != 0 ? aVar2.f35435h : list);
            }

            public a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, com.sumsub.sns.internal.domain.c cVar, String str, String str2, List<? extends FormItem> list) {
                super((kotlin.jvm.internal.r) null);
                this.f35428a = charSequence;
                this.f35429b = charSequence2;
                this.f35430c = charSequence3;
                this.f35431d = charSequence4;
                this.f35432e = cVar;
                this.f35433f = str;
                this.f35434g = str2;
                this.f35435h = list;
            }
        }

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$b  reason: collision with other inner class name */
        public static final class C0432b extends f {

            /* renamed from: a  reason: collision with root package name */
            public static final C0432b f35436a = new C0432b();

            public C0432b() {
                super((kotlin.jvm.internal.r) null);
            }
        }

        public static final class c extends f {

            /* renamed from: a  reason: collision with root package name */
            public static final c f35437a = new c();

            public c() {
                super((kotlin.jvm.internal.r) null);
            }
        }

        public static final class d extends f {

            /* renamed from: a  reason: collision with root package name */
            public final String f35438a;

            /* renamed from: b  reason: collision with root package name */
            public final String f35439b;

            public d(String str, String str2) {
                super((kotlin.jvm.internal.r) null);
                this.f35438a = str;
                this.f35439b = str2;
            }

            public final String a() {
                return this.f35438a;
            }

            public final String b() {
                return this.f35439b;
            }

            public final String c() {
                return this.f35439b;
            }

            public final String d() {
                return this.f35438a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                return kotlin.jvm.internal.x.b(this.f35438a, dVar.f35438a) && kotlin.jvm.internal.x.b(this.f35439b, dVar.f35439b);
            }

            public int hashCode() {
                String str = this.f35438a;
                int i11 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f35439b;
                if (str2 != null) {
                    i11 = str2.hashCode();
                }
                return hashCode + i11;
            }

            public String toString() {
                return "OAuth(url=" + this.f35438a + ", callbackUrl=" + this.f35439b + ')';
            }

            public final d a(String str, String str2) {
                return new d(str, str2);
            }

            public static /* synthetic */ d a(d dVar, String str, String str2, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = dVar.f35438a;
                }
                if ((i11 & 2) != 0) {
                    str2 = dVar.f35439b;
                }
                return dVar.a(str, str2);
            }
        }

        public static final class e extends f {

            /* renamed from: a  reason: collision with root package name */
            public final CharSequence f35440a;

            /* renamed from: b  reason: collision with root package name */
            public final CharSequence f35441b;

            /* renamed from: c  reason: collision with root package name */
            public final CharSequence f35442c;

            /* renamed from: d  reason: collision with root package name */
            public final CharSequence f35443d;

            /* renamed from: e  reason: collision with root package name */
            public final long f35444e;

            /* renamed from: f  reason: collision with root package name */
            public final e0 f35445f;

            public e() {
                this((CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (e0) null, 63, (kotlin.jvm.internal.r) null);
            }

            public final CharSequence a() {
                return this.f35440a;
            }

            public final CharSequence b() {
                return this.f35441b;
            }

            public final CharSequence c() {
                return this.f35442c;
            }

            public final CharSequence d() {
                return this.f35443d;
            }

            public final long e() {
                return this.f35444e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return kotlin.jvm.internal.x.b(this.f35440a, eVar.f35440a) && kotlin.jvm.internal.x.b(this.f35441b, eVar.f35441b) && kotlin.jvm.internal.x.b(this.f35442c, eVar.f35442c) && kotlin.jvm.internal.x.b(this.f35443d, eVar.f35443d) && this.f35444e == eVar.f35444e && kotlin.jvm.internal.x.b(this.f35445f, eVar.f35445f);
            }

            public final e0 f() {
                return this.f35445f;
            }

            public final CharSequence g() {
                return this.f35442c;
            }

            public final CharSequence h() {
                return this.f35443d;
            }

            public int hashCode() {
                CharSequence charSequence = this.f35440a;
                int i11 = 0;
                int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
                CharSequence charSequence2 = this.f35441b;
                int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
                CharSequence charSequence3 = this.f35442c;
                int hashCode3 = (hashCode2 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
                CharSequence charSequence4 = this.f35443d;
                int hashCode4 = (((hashCode3 + (charSequence4 == null ? 0 : charSequence4.hashCode())) * 31) + com.fluttercandies.photo_manager.core.entity.a.a(this.f35444e)) * 31;
                e0 e0Var = this.f35445f;
                if (e0Var != null) {
                    i11 = e0Var.hashCode();
                }
                return hashCode4 + i11;
            }

            public final long i() {
                return this.f35444e;
            }

            public final e0 j() {
                return this.f35445f;
            }

            public final CharSequence k() {
                return this.f35441b;
            }

            public final CharSequence l() {
                return this.f35440a;
            }

            public String toString() {
                return "OtpConfirm(title=" + this.f35440a + ", subtitle=" + this.f35441b + ", buttonResendCode=" + this.f35442c + ", error=" + this.f35443d + ", secondsRemaining=" + this.f35444e + ", submitResponse=" + this.f35445f + ')';
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ e(java.lang.CharSequence r7, java.lang.CharSequence r8, java.lang.CharSequence r9, java.lang.CharSequence r10, long r11, com.sumsub.sns.internal.core.data.source.applicant.remote.e0 r13, int r14, kotlin.jvm.internal.r r15) {
                /*
                    r6 = this;
                    r15 = r14 & 1
                    r0 = 0
                    if (r15 == 0) goto L_0x0007
                    r15 = r0
                    goto L_0x0008
                L_0x0007:
                    r15 = r7
                L_0x0008:
                    r7 = r14 & 2
                    if (r7 == 0) goto L_0x000e
                    r1 = r0
                    goto L_0x000f
                L_0x000e:
                    r1 = r8
                L_0x000f:
                    r7 = r14 & 4
                    if (r7 == 0) goto L_0x0015
                    r2 = r0
                    goto L_0x0016
                L_0x0015:
                    r2 = r9
                L_0x0016:
                    r7 = r14 & 8
                    if (r7 == 0) goto L_0x001c
                    r3 = r0
                    goto L_0x001d
                L_0x001c:
                    r3 = r10
                L_0x001d:
                    r7 = r14 & 16
                    if (r7 == 0) goto L_0x0023
                    r11 = 0
                L_0x0023:
                    r4 = r11
                    r7 = r14 & 32
                    if (r7 == 0) goto L_0x002a
                    r14 = r0
                    goto L_0x002b
                L_0x002a:
                    r14 = r13
                L_0x002b:
                    r7 = r6
                    r8 = r15
                    r9 = r1
                    r10 = r2
                    r11 = r3
                    r12 = r4
                    r7.<init>(r8, r9, r10, r11, r12, r14)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e.<init>(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, long, com.sumsub.sns.internal.core.data.source.applicant.remote.e0, int, kotlin.jvm.internal.r):void");
            }

            public final e a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, long j11, e0 e0Var) {
                return new e(charSequence, charSequence2, charSequence3, charSequence4, j11, e0Var);
            }

            public e(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, long j11, e0 e0Var) {
                super((kotlin.jvm.internal.r) null);
                this.f35440a = charSequence;
                this.f35441b = charSequence2;
                this.f35442c = charSequence3;
                this.f35443d = charSequence4;
                this.f35444e = j11;
                this.f35445f = e0Var;
            }

            public static /* synthetic */ e a(e eVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, long j11, e0 e0Var, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    charSequence = eVar.f35440a;
                }
                if ((i11 & 2) != 0) {
                    charSequence2 = eVar.f35441b;
                }
                CharSequence charSequence5 = charSequence2;
                if ((i11 & 4) != 0) {
                    charSequence3 = eVar.f35442c;
                }
                CharSequence charSequence6 = charSequence3;
                if ((i11 & 8) != 0) {
                    charSequence4 = eVar.f35443d;
                }
                CharSequence charSequence7 = charSequence4;
                if ((i11 & 16) != 0) {
                    j11 = eVar.f35444e;
                }
                long j12 = j11;
                if ((i11 & 32) != 0) {
                    e0Var = eVar.f35445f;
                }
                return eVar.a(charSequence, charSequence5, charSequence6, charSequence7, j12, e0Var);
            }
        }

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$f  reason: collision with other inner class name */
        public static final class C0433f extends f {

            /* renamed from: a  reason: collision with root package name */
            public final CharSequence f35446a;

            /* renamed from: b  reason: collision with root package name */
            public final CharSequence f35447b;

            /* renamed from: c  reason: collision with root package name */
            public final String f35448c;

            /* renamed from: d  reason: collision with root package name */
            public final CharSequence f35449d;

            /* renamed from: e  reason: collision with root package name */
            public final boolean f35450e;

            public C0433f(CharSequence charSequence, CharSequence charSequence2, String str, CharSequence charSequence3, boolean z11) {
                super((kotlin.jvm.internal.r) null);
                this.f35446a = charSequence;
                this.f35447b = charSequence2;
                this.f35448c = str;
                this.f35449d = charSequence3;
                this.f35450e = z11;
            }

            public final String a() {
                return this.f35448c;
            }

            public final CharSequence b() {
                return this.f35449d;
            }

            public final CharSequence c() {
                return this.f35447b;
            }

            public final CharSequence d() {
                return this.f35446a;
            }

            public final boolean e() {
                return this.f35450e;
            }
        }

        public /* synthetic */ f(kotlin.jvm.internal.r rVar) {
            this();
        }

        public f() {
        }
    }

    public /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35451a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f35452b;

        static {
            int[] iArr = new int[ConfirmationType.values().length];
            iArr[ConfirmationType.OTP.ordinal()] = 1;
            iArr[ConfirmationType.OAUTH.ordinal()] = 2;
            iArr[ConfirmationType.EID.ordinal()] = 3;
            f35451a = iArr;
            int[] iArr2 = new int[EKycFlowStatus.values().length];
            iArr2[EKycFlowStatus.COMPLETED.ordinal()] = 1;
            iArr2[EKycFlowStatus.SKIPPED.ordinal()] = 2;
            iArr2[EKycFlowStatus.REJECTED.ordinal()] = 3;
            f35452b = iArr2;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$confirmEid$1", f = "SNSEkycViewModel.kt", l = {617, 619}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements d10.l<kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35453a;

        /* renamed from: b  reason: collision with root package name */
        public int f35454b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f35455c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f35456d;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$confirmEid$1$1", f = "SNSEkycViewModel.kt", l = {627, 629, 631}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<f, kotlin.coroutines.c<? super f>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f35457a;

            /* renamed from: b  reason: collision with root package name */
            public Object f35458b;

            /* renamed from: c  reason: collision with root package name */
            public Object f35459c;

            /* renamed from: d  reason: collision with root package name */
            public int f35460d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f35461e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Exception f35462f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, Exception exc, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f35461e = bVar;
                this.f35462f = exc;
            }

            /* renamed from: a */
            public final Object invoke(f fVar, kotlin.coroutines.c<? super f> cVar) {
                return ((a) create(fVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f35461e, this.f35462f, cVar);
            }

            /* JADX WARNING: Removed duplicated region for block: B:19:0x0087 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0088  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                /*
                    r11 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r1 = r11.f35460d
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L_0x0041
                    if (r1 == r4) goto L_0x003d
                    if (r1 == r3) goto L_0x002d
                    if (r1 != r2) goto L_0x0025
                    java.lang.Object r0 = r11.f35459c
                    java.lang.String r0 = (java.lang.String) r0
                    java.lang.Object r1 = r11.f35458b
                    com.sumsub.sns.internal.core.data.source.applicant.remote.e0 r1 = (com.sumsub.sns.internal.core.data.source.applicant.remote.e0) r1
                    java.lang.Object r2 = r11.f35457a
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$e r2 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e) r2
                    kotlin.k.b(r12)
                    r4 = r0
                    r7 = r1
                    r0 = r2
                    goto L_0x008c
                L_0x0025:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r0)
                    throw r12
                L_0x002d:
                    java.lang.Object r1 = r11.f35459c
                    java.lang.Throwable r1 = (java.lang.Throwable) r1
                    java.lang.Object r3 = r11.f35458b
                    com.sumsub.sns.internal.core.data.source.applicant.remote.e0 r3 = (com.sumsub.sns.internal.core.data.source.applicant.remote.e0) r3
                    java.lang.Object r4 = r11.f35457a
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$e r4 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e) r4
                    kotlin.k.b(r12)
                    goto L_0x006f
                L_0x003d:
                    kotlin.k.b(r12)
                    goto L_0x004f
                L_0x0041:
                    kotlin.k.b(r12)
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r12 = r11.f35461e
                    r11.f35460d = r4
                    java.lang.Object r12 = r12.f((kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e>) r11)
                    if (r12 != r0) goto L_0x004f
                    return r0
                L_0x004f:
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$e r12 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e) r12
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r1 = r11.f35461e
                    com.sumsub.sns.internal.core.data.source.applicant.remote.e0 r1 = r1.G()
                    java.lang.Exception r4 = r11.f35462f
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r5 = r11.f35461e
                    r11.f35457a = r12
                    r11.f35458b = r1
                    r11.f35459c = r4
                    r11.f35460d = r3
                    java.lang.Object r3 = r5.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c>) r11)
                    if (r3 != r0) goto L_0x006a
                    return r0
                L_0x006a:
                    r10 = r4
                    r4 = r12
                    r12 = r3
                    r3 = r1
                    r1 = r10
                L_0x006f:
                    com.sumsub.sns.internal.core.data.source.dynamic.b$c r12 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12
                    java.lang.String r12 = com.sumsub.sns.internal.core.common.o.a((java.lang.Throwable) r1, (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12)
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r1 = r11.f35461e
                    r11.f35457a = r4
                    r11.f35458b = r3
                    r11.f35459c = r12
                    r11.f35460d = r2
                    java.lang.String r2 = "sns_confirmation_code_action_resend"
                    java.lang.Object r1 = r1.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r11)
                    if (r1 != r0) goto L_0x0088
                    return r0
                L_0x0088:
                    r7 = r3
                    r0 = r4
                    r4 = r12
                    r12 = r1
                L_0x008c:
                    r3 = r12
                    java.lang.String r3 = (java.lang.String) r3
                    r1 = 0
                    r2 = 0
                    r5 = 0
                    r8 = 3
                    r9 = 0
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$e r12 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e.a(r0, r1, r2, r3, r4, r5, r7, r8, r9)
                    return r12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.h.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(b bVar, String str, kotlin.coroutines.c<? super h> cVar) {
            super(1, cVar);
            this.f35455c = bVar;
            this.f35456d = str;
        }

        /* renamed from: a */
        public final Object invoke(kotlin.coroutines.c<? super Unit> cVar) {
            return ((h) create(cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(kotlin.coroutines.c<?> cVar) {
            return new h(this.f35455c, this.f35456d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            String B;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35454b;
            if (i11 == 0) {
                kotlin.k.b(obj);
                e0 i12 = this.f35455c.G();
                if (i12 == null || (str = i12.h()) == null) {
                    return Unit.f56620a;
                }
                b bVar = this.f35455c;
                this.f35453a = str;
                this.f35454b = 1;
                obj = bVar.g((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g>) this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                str = (String) this.f35453a;
                kotlin.k.b(obj);
            } else if (i11 == 2) {
                try {
                    kotlin.k.b(obj);
                    this.f35455c.a((e0) obj);
                } catch (Exception e11) {
                    b bVar2 = this.f35455c;
                    com.sumsub.sns.core.presentation.base.a.a(bVar2, false, new a(bVar2, e11, (kotlin.coroutines.c<? super a>) null), 1, (Object) null);
                } catch (Throwable th2) {
                    com.sumsub.sns.internal.presentation.screen.preview.a.a(this.f35455c, th2, (Object) null, 2, (Object) null);
                }
                return Unit.f56620a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.sumsub.sns.internal.core.data.model.g gVar = (com.sumsub.sns.internal.core.data.model.g) obj;
            if (gVar == null || (B = gVar.B()) == null) {
                return Unit.f56620a;
            }
            com.sumsub.sns.internal.core.data.source.applicant.e a11 = this.f35455c.f35377a0;
            com.sumsub.sns.internal.core.data.source.applicant.remote.a aVar = new com.sumsub.sns.internal.core.data.source.applicant.remote.a((com.sumsub.sns.internal.core.data.source.applicant.remote.t) null, (com.sumsub.sns.internal.core.data.source.applicant.remote.q) null, new com.sumsub.sns.internal.core.data.source.applicant.remote.j(this.f35456d), 3, (kotlin.jvm.internal.r) null);
            this.f35453a = null;
            this.f35454b = 2;
            obj = a11.a(B, str, aVar, (kotlin.coroutines.c<? super e0>) this);
            if (obj == d11) {
                return d11;
            }
            this.f35455c.a((e0) obj);
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$confirmOAuthData$1", f = "SNSEkycViewModel.kt", l = {589}, m = "invokeSuspend")
    public static final class i extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35463a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f35464b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f35465c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f35466d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.internal.core.data.source.applicant.remote.a f35467e;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$confirmOAuthData$1$1", f = "SNSEkycViewModel.kt", l = {601, 602, 604}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<f, kotlin.coroutines.c<? super f>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f35468a;

            /* renamed from: b  reason: collision with root package name */
            public Object f35469b;

            /* renamed from: c  reason: collision with root package name */
            public Object f35470c;

            /* renamed from: d  reason: collision with root package name */
            public int f35471d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f35472e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Exception f35473f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, Exception exc, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f35472e = bVar;
                this.f35473f = exc;
            }

            /* renamed from: a */
            public final Object invoke(f fVar, kotlin.coroutines.c<? super f> cVar) {
                return ((a) create(fVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f35472e, this.f35473f, cVar);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x0063 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0064  */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x0085 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x0086  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r1 = r7.f35471d
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L_0x003d
                    if (r1 == r4) goto L_0x0039
                    if (r1 == r3) goto L_0x002d
                    if (r1 != r2) goto L_0x0025
                    java.lang.Object r0 = r7.f35470c
                    java.lang.String r0 = (java.lang.String) r0
                    java.lang.Object r1 = r7.f35469b
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    java.lang.Object r2 = r7.f35468a
                    java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                    kotlin.k.b(r8)
                    r3 = r0
                    r6 = r2
                L_0x0022:
                    r2 = r1
                    r1 = r6
                    goto L_0x008a
                L_0x0025:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L_0x002d:
                    java.lang.Object r1 = r7.f35469b
                    java.lang.Throwable r1 = (java.lang.Throwable) r1
                    java.lang.Object r3 = r7.f35468a
                    java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                    kotlin.k.b(r8)
                    goto L_0x0067
                L_0x0039:
                    kotlin.k.b(r8)
                    goto L_0x004d
                L_0x003d:
                    kotlin.k.b(r8)
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r8 = r7.f35472e
                    r7.f35471d = r4
                    java.lang.String r1 = "sns_confirmation_result_ekyc_failure_title"
                    java.lang.Object r8 = r8.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r7)
                    if (r8 != r0) goto L_0x004d
                    return r0
                L_0x004d:
                    java.lang.String r8 = (java.lang.String) r8
                    if (r8 != 0) goto L_0x0053
                    java.lang.String r8 = "Error"
                L_0x0053:
                    java.lang.Exception r1 = r7.f35473f
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r4 = r7.f35472e
                    r7.f35468a = r8
                    r7.f35469b = r1
                    r7.f35471d = r3
                    java.lang.Object r3 = r4.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c>) r7)
                    if (r3 != r0) goto L_0x0064
                    return r0
                L_0x0064:
                    r6 = r3
                    r3 = r8
                    r8 = r6
                L_0x0067:
                    com.sumsub.sns.internal.core.data.source.dynamic.b$c r8 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r8
                    java.lang.String r1 = com.sumsub.sns.internal.core.common.o.a((java.lang.Throwable) r1, (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r8)
                    com.sumsub.sns.core.data.listener.SNSIconHandler$SNSResultIcons r8 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSResultIcons.FAILURE
                    java.lang.String r8 = r8.getImageName()
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r4 = r7.f35472e
                    r7.f35468a = r3
                    r7.f35469b = r1
                    r7.f35470c = r8
                    r7.f35471d = r2
                    java.lang.String r2 = "sns_confirmation_result_action_tryAgain"
                    java.lang.Object r2 = r4.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r7)
                    if (r2 != r0) goto L_0x0086
                    return r0
                L_0x0086:
                    r6 = r3
                    r3 = r8
                    r8 = r2
                    goto L_0x0022
                L_0x008a:
                    r4 = r8
                    java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$f r8 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$f
                    r5 = 1
                    r0 = r8
                    r0.<init>(r1, r2, r3, r4, r5)
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.i.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(b bVar, String str, String str2, com.sumsub.sns.internal.core.data.source.applicant.remote.a aVar, kotlin.coroutines.c<? super i> cVar) {
            super(2, cVar);
            this.f35464b = bVar;
            this.f35465c = str;
            this.f35466d = str2;
            this.f35467e = aVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((i) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new i(this.f35464b, this.f35465c, this.f35466d, this.f35467e, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35463a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, a.f35376b, "confirmOAuthData ...", (Throwable) null, 4, (Object) null);
                com.sumsub.sns.internal.core.data.source.applicant.e a11 = this.f35464b.f35377a0;
                String str = this.f35465c;
                String str2 = this.f35466d;
                com.sumsub.sns.internal.core.data.source.applicant.remote.a aVar = this.f35467e;
                this.f35463a = 1;
                obj = a11.a(str, str2, aVar, (kotlin.coroutines.c<? super e0>) this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                try {
                    kotlin.k.b(obj);
                } catch (Exception e11) {
                    this.f35464b.b(false);
                    this.f35464b.c(true);
                    b bVar = this.f35464b;
                    com.sumsub.sns.core.presentation.base.a.a(bVar, false, new a(bVar, e11, (kotlin.coroutines.c<? super a>) null), 1, (Object) null);
                } catch (Throwable th2) {
                    com.sumsub.sns.internal.presentation.screen.preview.a.a(this.f35464b, th2, (Object) null, 2, (Object) null);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f35464b.a((e0) obj);
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$confirmOtp$1", f = "SNSEkycViewModel.kt", l = {448, 450}, m = "invokeSuspend")
    public static final class j extends SuspendLambda implements d10.l<kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35474a;

        /* renamed from: b  reason: collision with root package name */
        public int f35475b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f35476c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e0 f35477d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CharSequence f35478e;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$confirmOtp$1$1", f = "SNSEkycViewModel.kt", l = {458, 460, 462}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<f, kotlin.coroutines.c<? super f>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f35479a;

            /* renamed from: b  reason: collision with root package name */
            public Object f35480b;

            /* renamed from: c  reason: collision with root package name */
            public int f35481c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ b f35482d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Exception f35483e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e0 f35484f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, Exception exc, e0 e0Var, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f35482d = bVar;
                this.f35483e = exc;
                this.f35484f = e0Var;
            }

            /* renamed from: a */
            public final Object invoke(f fVar, kotlin.coroutines.c<? super f> cVar) {
                return ((a) create(fVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f35482d, this.f35483e, this.f35484f, cVar);
            }

            /* JADX WARNING: Removed duplicated region for block: B:19:0x0071 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0072  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                /*
                    r11 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r1 = r11.f35481c
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L_0x0037
                    if (r1 == r4) goto L_0x0033
                    if (r1 == r3) goto L_0x0027
                    if (r1 != r2) goto L_0x001f
                    java.lang.Object r0 = r11.f35480b
                    java.lang.String r0 = (java.lang.String) r0
                    java.lang.Object r1 = r11.f35479a
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$e r1 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e) r1
                    kotlin.k.b(r12)
                    r4 = r0
                    r0 = r1
                    goto L_0x0075
                L_0x001f:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r0)
                    throw r12
                L_0x0027:
                    java.lang.Object r1 = r11.f35480b
                    java.lang.Throwable r1 = (java.lang.Throwable) r1
                    java.lang.Object r3 = r11.f35479a
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$e r3 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e) r3
                    kotlin.k.b(r12)
                    goto L_0x005b
                L_0x0033:
                    kotlin.k.b(r12)
                    goto L_0x0045
                L_0x0037:
                    kotlin.k.b(r12)
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r12 = r11.f35482d
                    r11.f35481c = r4
                    java.lang.Object r12 = r12.f((kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e>) r11)
                    if (r12 != r0) goto L_0x0045
                    return r0
                L_0x0045:
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$e r12 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e) r12
                    java.lang.Exception r1 = r11.f35483e
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r4 = r11.f35482d
                    r11.f35479a = r12
                    r11.f35480b = r1
                    r11.f35481c = r3
                    java.lang.Object r3 = r4.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c>) r11)
                    if (r3 != r0) goto L_0x0058
                    return r0
                L_0x0058:
                    r10 = r3
                    r3 = r12
                    r12 = r10
                L_0x005b:
                    com.sumsub.sns.internal.core.data.source.dynamic.b$c r12 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12
                    java.lang.String r12 = com.sumsub.sns.internal.core.common.o.a((java.lang.Throwable) r1, (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12)
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r1 = r11.f35482d
                    r11.f35479a = r3
                    r11.f35480b = r12
                    r11.f35481c = r2
                    java.lang.String r2 = "sns_confirmation_code_action_resend"
                    java.lang.Object r1 = r1.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r11)
                    if (r1 != r0) goto L_0x0072
                    return r0
                L_0x0072:
                    r4 = r12
                    r12 = r1
                    r0 = r3
                L_0x0075:
                    r3 = r12
                    java.lang.String r3 = (java.lang.String) r3
                    com.sumsub.sns.internal.core.data.source.applicant.remote.e0 r7 = r11.f35484f
                    r1 = 0
                    r2 = 0
                    r5 = 0
                    r8 = 3
                    r9 = 0
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$e r12 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e.a(r0, r1, r2, r3, r4, r5, r7, r8, r9)
                    return r12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.j.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(b bVar, e0 e0Var, CharSequence charSequence, kotlin.coroutines.c<? super j> cVar) {
            super(1, cVar);
            this.f35476c = bVar;
            this.f35477d = e0Var;
            this.f35478e = charSequence;
        }

        /* renamed from: a */
        public final Object invoke(kotlin.coroutines.c<? super Unit> cVar) {
            return ((j) create(cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(kotlin.coroutines.c<?> cVar) {
            return new j(this.f35476c, this.f35477d, this.f35478e, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            String B;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35475b;
            if (i11 == 0) {
                kotlin.k.b(obj);
                n1 c11 = this.f35476c.f35381e0;
                if (c11 != null) {
                    n1.a.a(c11, (CancellationException) null, 1, (Object) null);
                }
                e0 e0Var = this.f35477d;
                if (e0Var == null || (str = e0Var.h()) == null) {
                    return Unit.f56620a;
                }
                b bVar = this.f35476c;
                this.f35474a = str;
                this.f35475b = 1;
                obj = bVar.g((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g>) this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                str = (String) this.f35474a;
                kotlin.k.b(obj);
            } else if (i11 == 2) {
                try {
                    kotlin.k.b(obj);
                    this.f35476c.a((e0) obj);
                } catch (Exception e11) {
                    b bVar2 = this.f35476c;
                    com.sumsub.sns.core.presentation.base.a.a(bVar2, false, new a(bVar2, e11, this.f35477d, (kotlin.coroutines.c<? super a>) null), 1, (Object) null);
                } catch (Throwable th2) {
                    com.sumsub.sns.internal.presentation.screen.preview.a.a(this.f35476c, th2, (Object) null, 2, (Object) null);
                }
                return Unit.f56620a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.sumsub.sns.internal.core.data.model.g gVar = (com.sumsub.sns.internal.core.data.model.g) obj;
            if (gVar == null || (B = gVar.B()) == null) {
                return Unit.f56620a;
            }
            com.sumsub.sns.internal.core.data.source.applicant.e a11 = this.f35476c.f35377a0;
            com.sumsub.sns.internal.core.data.source.applicant.remote.a aVar = new com.sumsub.sns.internal.core.data.source.applicant.remote.a(new com.sumsub.sns.internal.core.data.source.applicant.remote.t(this.f35478e.toString()), (com.sumsub.sns.internal.core.data.source.applicant.remote.q) null, (com.sumsub.sns.internal.core.data.source.applicant.remote.j) null, 6, (kotlin.jvm.internal.r) null);
            this.f35474a = null;
            this.f35475b = 2;
            obj = a11.a(B, str, aVar, (kotlin.coroutines.c<? super e0>) this);
            if (obj == d11) {
                return d11;
            }
            this.f35476c.a((e0) obj);
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel", f = "SNSEkycViewModel.kt", l = {762, 763, 765}, m = "defaultAppDataState")
    public static final class k extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35485a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35486b;

        /* renamed from: c  reason: collision with root package name */
        public Object f35487c;

        /* renamed from: d  reason: collision with root package name */
        public Object f35488d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f35489e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f35490f;

        /* renamed from: g  reason: collision with root package name */
        public int f35491g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(b bVar, kotlin.coroutines.c<? super k> cVar) {
            super(cVar);
            this.f35490f = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35489e = obj;
            this.f35491g |= Integer.MIN_VALUE;
            return this.f35490f.e((kotlin.coroutines.c<? super f.a>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel", f = "SNSEkycViewModel.kt", l = {770, 771, 772}, m = "defaultOtpConfirmState")
    public static final class l extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35492a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35493b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f35494c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f35495d;

        /* renamed from: e  reason: collision with root package name */
        public int f35496e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(b bVar, kotlin.coroutines.c<? super l> cVar) {
            super(cVar);
            this.f35495d = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35494c = obj;
            this.f35496e |= Integer.MIN_VALUE;
            return this.f35495d.f((kotlin.coroutines.c<? super f.e>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel", f = "SNSEkycViewModel.kt", l = {804}, m = "formatSourceId")
    public static final class m extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35497a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35498b;

        /* renamed from: c  reason: collision with root package name */
        public Object f35499c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f35500d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f35501e;

        /* renamed from: f  reason: collision with root package name */
        public int f35502f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(b bVar, kotlin.coroutines.c<? super m> cVar) {
            super(cVar);
            this.f35501e = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35500d = obj;
            this.f35502f |= Integer.MIN_VALUE;
            return this.f35501e.a((String) null, (String) null, (kotlin.coroutines.c<? super String>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel", f = "SNSEkycViewModel.kt", l = {199}, m = "getApplicant")
    public static final class n extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f35503a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f35504b;

        /* renamed from: c  reason: collision with root package name */
        public int f35505c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(b bVar, kotlin.coroutines.c<? super n> cVar) {
            super(cVar);
            this.f35504b = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35503a = obj;
            this.f35505c |= Integer.MIN_VALUE;
            return this.f35504b.g((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel", f = "SNSEkycViewModel.kt", l = {782}, m = "getResendCodeText")
    public static final class o extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public long f35506a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35507b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f35508c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f35509d;

        /* renamed from: e  reason: collision with root package name */
        public int f35510e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(b bVar, kotlin.coroutines.c<? super o> cVar) {
            super(cVar);
            this.f35509d = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35508c = obj;
            this.f35510e |= Integer.MIN_VALUE;
            return this.f35509d.a(0, (kotlin.coroutines.c<? super CharSequence>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$handleDefaultConfirmResponse$1", f = "SNSEkycViewModel.kt", l = {663, 666}, m = "invokeSuspend")
    public static final class p extends SuspendLambda implements d10.p<f, kotlin.coroutines.c<? super f>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35511a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35512b;

        /* renamed from: c  reason: collision with root package name */
        public int f35513c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f35514d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(b bVar, kotlin.coroutines.c<? super p> cVar) {
            super(2, cVar);
            this.f35514d = bVar;
        }

        /* renamed from: a */
        public final Object invoke(f fVar, kotlin.coroutines.c<? super f> cVar) {
            return ((p) create(fVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new p(this.f35514d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            CharSequence charSequence;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35513c;
            if (i11 == 0) {
                kotlin.k.b(obj);
                b bVar = this.f35514d;
                this.f35513c = 1;
                obj = bVar.a(b.V, (kotlin.coroutines.c<? super String>) this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else if (i11 == 2) {
                charSequence = (CharSequence) this.f35511a;
                kotlin.k.b(obj);
                str = (String) this.f35512b;
                return new f.C0433f(charSequence, (CharSequence) null, str, (CharSequence) obj, true);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str2 = (String) obj;
            if (str2 == null) {
                str2 = "Error";
            }
            charSequence = str2;
            String imageName = SNSIconHandler.SNSResultIcons.FAILURE.getImageName();
            b bVar2 = this.f35514d;
            this.f35511a = charSequence;
            this.f35512b = imageName;
            this.f35513c = 2;
            Object a11 = bVar2.a(n0.j.f32202b, (kotlin.coroutines.c<? super String>) this);
            if (a11 == d11) {
                return d11;
            }
            str = imageName;
            obj = a11;
            return new f.C0433f(charSequence, (CharSequence) null, str, (CharSequence) obj, true);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$handleOtpConfirmResponse$1", f = "SNSEkycViewModel.kt", l = {679, 681, 683}, m = "invokeSuspend")
    public static final class q extends SuspendLambda implements d10.p<f, kotlin.coroutines.c<? super f>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35515a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35516b;

        /* renamed from: c  reason: collision with root package name */
        public int f35517c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f35518d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e0 f35519e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(b bVar, e0 e0Var, kotlin.coroutines.c<? super q> cVar) {
            super(2, cVar);
            this.f35518d = bVar;
            this.f35519e = e0Var;
        }

        /* renamed from: a */
        public final Object invoke(f fVar, kotlin.coroutines.c<? super f> cVar) {
            return ((q) create(fVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new q(this.f35518d, this.f35519e, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x006b A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x006c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r11.f35517c
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0033
                if (r1 == r4) goto L_0x002f
                if (r1 == r3) goto L_0x0027
                if (r1 != r2) goto L_0x001f
                java.lang.Object r0 = r11.f35516b
                java.lang.String r0 = (java.lang.String) r0
                java.lang.Object r1 = r11.f35515a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$e r1 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e) r1
                kotlin.k.b(r12)
                r4 = r0
                r0 = r1
                goto L_0x006f
            L_0x001f:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x0027:
                java.lang.Object r1 = r11.f35515a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$e r1 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e) r1
                kotlin.k.b(r12)
                goto L_0x0055
            L_0x002f:
                kotlin.k.b(r12)
                goto L_0x0041
            L_0x0033:
                kotlin.k.b(r12)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r12 = r11.f35518d
                r11.f35517c = r4
                java.lang.Object r12 = r12.f((kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e>) r11)
                if (r12 != r0) goto L_0x0041
                return r0
            L_0x0041:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$e r12 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e) r12
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r1 = r11.f35518d
                r11.f35515a = r12
                r11.f35517c = r3
                java.lang.String r3 = "sns_confirmation_code_isNotValid"
                java.lang.Object r1 = r1.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r11)
                if (r1 != r0) goto L_0x0052
                return r0
            L_0x0052:
                r10 = r1
                r1 = r12
                r12 = r10
            L_0x0055:
                java.lang.String r12 = (java.lang.String) r12
                if (r12 != 0) goto L_0x005b
                java.lang.String r12 = "Unknown error"
            L_0x005b:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = r11.f35518d
                r11.f35515a = r1
                r11.f35516b = r12
                r11.f35517c = r2
                java.lang.String r2 = "sns_confirmation_code_action_resend"
                java.lang.Object r2 = r3.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r11)
                if (r2 != r0) goto L_0x006c
                return r0
            L_0x006c:
                r4 = r12
                r0 = r1
                r12 = r2
            L_0x006f:
                r3 = r12
                java.lang.String r3 = (java.lang.String) r3
                com.sumsub.sns.internal.core.data.source.applicant.remote.e0 r7 = r11.f35519e
                r1 = 0
                r2 = 0
                r5 = 0
                r8 = 3
                r9 = 0
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$e r12 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e.a(r0, r1, r2, r3, r4, r5, r7, r8, r9)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.q.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class r implements com.sumsub.sns.internal.core.presentation.form.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f35520a;

        public r(b bVar) {
            this.f35520a = bVar;
        }

        public String a(String str, String str2) {
            return (String) this.f35520a.E().get(str2);
        }

        public /* synthetic */ List b(String str, String str2) {
            return com.sumsub.sns.internal.core.presentation.form.f.a(this, str, str2);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel", f = "SNSEkycViewModel.kt", l = {158}, m = "onDataLoaded")
    public static final class s extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35521a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35522b;

        /* renamed from: c  reason: collision with root package name */
        public Object f35523c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f35524d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f35525e;

        /* renamed from: f  reason: collision with root package name */
        public int f35526f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(b bVar, kotlin.coroutines.c<? super s> cVar) {
            super(cVar);
            this.f35525e = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35524d = obj;
            this.f35526f |= Integer.MIN_VALUE;
            return this.f35525e.a((com.sumsub.sns.internal.core.data.model.g) null, (com.sumsub.sns.internal.core.data.model.e) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$onSubmitAppDataClick$1", f = "SNSEkycViewModel.kt", l = {404, 412, 417, 417}, m = "invokeSuspend")
    public static final class t extends SuspendLambda implements d10.l<kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35527a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35528b;

        /* renamed from: c  reason: collision with root package name */
        public int f35529c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f35530d;

        public static final class a extends Lambda implements d10.l<String, String> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f35531a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar) {
                super(1);
                this.f35531a = bVar;
            }

            /* renamed from: a */
            public final String invoke(String str) {
                String str2 = (String) this.f35531a.E().get(str);
                return str2 == null ? "" : str2;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(b bVar, kotlin.coroutines.c<? super t> cVar) {
            super(1, cVar);
            this.f35530d = bVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlin.coroutines.c<? super Unit> cVar) {
            return ((t) create(cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(kotlin.coroutines.c<?> cVar) {
            return new t(this.f35530d, cVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b4, code lost:
            if (r0 != null) goto L_0x00ba;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                r20 = this;
                r1 = r20
                java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r0 = r1.f35529c
                r3 = 4
                r4 = 3
                r5 = 1
                r6 = 2
                r7 = 0
                if (r0 == 0) goto L_0x0052
                if (r0 == r5) goto L_0x0047
                if (r0 == r6) goto L_0x003a
                if (r0 == r4) goto L_0x002e
                if (r0 != r3) goto L_0x0026
                java.lang.Object r0 = r1.f35528b
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.Object r2 = r1.f35527a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r2 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b) r2
                kotlin.k.b(r21)
                r4 = r21
                goto L_0x021e
            L_0x0026:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x002e:
                java.lang.Object r0 = r1.f35527a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r0 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b) r0
                kotlin.k.b(r21)
                r3 = r0
                r0 = r21
                goto L_0x0209
            L_0x003a:
                kotlin.k.b(r21)     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                r0 = r21
                goto L_0x01c6
            L_0x0041:
                r0 = move-exception
                goto L_0x01ed
            L_0x0044:
                r0 = move-exception
                goto L_0x01f3
            L_0x0047:
                java.lang.Object r0 = r1.f35527a
                java.util.List r0 = (java.util.List) r0
                kotlin.k.b(r21)
                r3 = r21
                goto L_0x014b
            L_0x0052:
                kotlin.k.b(r21)
                com.sumsub.sns.internal.log.a r8 = com.sumsub.sns.internal.log.a.f34862a
                r11 = 0
                r12 = 4
                r13 = 0
                java.lang.String r9 = "EKyc"
                java.lang.String r10 = "onSubmit"
                com.sumsub.log.logger.a.d(r8, r9, r10, r11, r12, r13)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r0 = r1.f35530d
                r0.e((java.lang.String) r7)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r0 = r1.f35530d
                r0.a((com.sumsub.sns.internal.core.data.source.applicant.remote.a) r7)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r0 = r1.f35530d
                com.sumsub.sns.internal.core.data.model.e r0 = r0.d()
                if (r0 == 0) goto L_0x022e
                java.util.Map r0 = r0.w()
                if (r0 != 0) goto L_0x007b
                goto L_0x022e
            L_0x007b:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r8 = r1.f35530d
                java.lang.String r8 = r8.s()
                java.lang.Object r0 = r0.get(r8)
                java.util.List r0 = (java.util.List) r0
                if (r0 == 0) goto L_0x00b6
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r8 = r1.f35530d
                java.util.Iterator r0 = r0.iterator()
            L_0x008f:
                boolean r9 = r0.hasNext()
                if (r9 == 0) goto L_0x00ab
                java.lang.Object r9 = r0.next()
                r10 = r9
                com.sumsub.sns.internal.core.data.model.j r10 = (com.sumsub.sns.internal.core.data.model.j) r10
                java.lang.String r10 = r10.h()
                java.lang.String r11 = r8.C()
                boolean r10 = kotlin.jvm.internal.x.b(r10, r11)
                if (r10 == 0) goto L_0x008f
                goto L_0x00ac
            L_0x00ab:
                r9 = r7
            L_0x00ac:
                com.sumsub.sns.internal.core.data.model.j r9 = (com.sumsub.sns.internal.core.data.model.j) r9
                if (r9 == 0) goto L_0x00b6
                java.util.List r0 = r9.g()
                if (r0 != 0) goto L_0x00ba
            L_0x00b6:
                java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            L_0x00ba:
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
                com.sumsub.sns.internal.core.data.model.h$d r15 = new com.sumsub.sns.internal.core.data.model.h$d
                com.sumsub.sns.internal.core.data.model.FieldName r10 = com.sumsub.sns.internal.core.data.model.FieldName.country
                r11 = 1
                r12 = 0
                r13 = 0
                r14 = 0
                r16 = 0
                r17 = 0
                r18 = 124(0x7c, float:1.74E-43)
                r19 = 0
                r9 = r15
                r3 = r15
                r15 = r16
                r16 = r17
                r17 = r18
                r18 = r19
                r9.<init>((com.sumsub.sns.internal.core.data.model.FieldName) r10, (boolean) r11, (com.sumsub.sns.internal.core.data.model.FieldType) r12, (java.lang.String) r13, (java.util.List) r14, (com.sumsub.sns.internal.core.data.model.p) r15, (java.lang.String) r16, (int) r17, (kotlin.jvm.internal.r) r18)
                r8.add(r3)
                r8.addAll(r0)
                java.util.List r0 = com.sumsub.sns.internal.core.common.i.a(r8)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$t$a r14 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$t$a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = r1.f35530d
                r14.<init>(r3)
                kotlin.sequences.g r8 = kotlin.collections.CollectionsKt___CollectionsKt.P(r0)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = r1.f35530d
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r9 = r3.h()
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = r1.f35530d
                com.sumsub.sns.internal.core.common.a1 r10 = r3.f35378b0
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = r1.f35530d
                com.sumsub.sns.internal.domain.c r11 = r3.f35383g0
                r12 = 0
                r15 = 24
                r16 = 0
                java.util.List r3 = com.sumsub.sns.internal.presentation.utils.b.a(r8, r9, r10, r11, r12, r13, r14, r15, r16)
                if (r3 == 0) goto L_0x013e
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r0 = r1.f35530d
                com.sumsub.sns.internal.log.a r4 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r5 = "onSubmit: "
                r2.append(r5)
                int r5 = r3.size()
                r2.append(r5)
                java.lang.String r5 = " field errors encountered"
                r2.append(r5)
                java.lang.String r6 = r2.toString()
                r7 = 0
                r8 = 4
                r9 = 0
                java.lang.String r5 = "EKyc"
                com.sumsub.log.logger.a.d(r4, r5, r6, r7, r8, r9)
                java.lang.String r2 = r0.s()
                kotlinx.coroutines.n1 unused = r0.a((java.lang.String) r2, (java.util.List<com.sumsub.sns.internal.domain.b>) r3)
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            L_0x013e:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = r1.f35530d
                r1.f35527a = r0
                r1.f35529c = r5
                java.lang.Object r3 = r3.g((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g>) r1)
                if (r3 != r2) goto L_0x014b
                return r2
            L_0x014b:
                com.sumsub.sns.internal.core.data.model.g r3 = (com.sumsub.sns.internal.core.data.model.g) r3
                if (r3 == 0) goto L_0x022b
                java.lang.String r3 = r3.B()
                if (r3 != 0) goto L_0x0157
                goto L_0x022b
            L_0x0157:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r5 = r1.f35530d
                r8 = 10
                int r8 = kotlin.collections.CollectionsKt__IterablesKt.u(r0, r8)
                int r8 = kotlin.collections.MapsKt__MapsJVMKt.d(r8)
                r9 = 16
                int r8 = kotlin.ranges.RangesKt___RangesKt.d(r8, r9)
                java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
                r9.<init>(r8)
                java.util.Iterator r0 = r0.iterator()
            L_0x0172:
                boolean r8 = r0.hasNext()
                if (r8 == 0) goto L_0x01af
                java.lang.Object r8 = r0.next()
                com.sumsub.sns.internal.core.data.model.h$d r8 = (com.sumsub.sns.internal.core.data.model.h.d) r8
                com.sumsub.sns.internal.core.data.model.FieldName r10 = r8.q()
                java.lang.String r11 = ""
                if (r10 == 0) goto L_0x018c
                java.lang.String r10 = r10.getValue()
                if (r10 != 0) goto L_0x018d
            L_0x018c:
                r10 = r11
            L_0x018d:
                java.util.Map r12 = r5.E()
                java.lang.String r8 = r8.b()
                java.lang.Object r8 = r12.get(r8)
                java.lang.String r8 = (java.lang.String) r8
                if (r8 != 0) goto L_0x019e
                goto L_0x019f
            L_0x019e:
                r11 = r8
            L_0x019f:
                kotlin.Pair r8 = kotlin.l.a(r10, r11)
                java.lang.Object r10 = r8.getFirst()
                java.lang.Object r8 = r8.getSecond()
                r9.put(r10, r8)
                goto L_0x0172
            L_0x01af:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r0 = r1.f35530d     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                com.sumsub.sns.internal.core.data.source.applicant.remote.b r0 = r0.c((java.util.Map<java.lang.String, java.lang.String>) r9)     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r5 = r1.f35530d     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                com.sumsub.sns.internal.core.data.source.applicant.e r5 = r5.f35377a0     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                r1.f35527a = r7     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                r1.f35529c = r6     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                java.lang.Object r0 = r5.a((java.lang.String) r3, (com.sumsub.sns.internal.core.data.source.applicant.remote.b) r0, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.e0>) r1)     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                if (r0 != r2) goto L_0x01c6
                return r2
            L_0x01c6:
                com.sumsub.sns.internal.core.data.source.applicant.remote.e0 r0 = (com.sumsub.sns.internal.core.data.source.applicant.remote.e0) r0     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                com.sumsub.sns.internal.log.a r8 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = r1.f35530d     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                java.lang.String r9 = com.sumsub.sns.internal.log.c.a(r3)     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                r3.<init>()     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                java.lang.String r5 = "Submit response: "
                r3.append(r5)     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                r3.append(r0)     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                java.lang.String r10 = r3.toString()     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                r11 = 0
                r12 = 4
                r13 = 0
                com.sumsub.log.logger.a.c(r8, r9, r10, r11, r12, r13)     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = r1.f35530d     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                r3.d((com.sumsub.sns.internal.core.data.source.applicant.remote.e0) r0)     // Catch:{ Api -> 0x0044, all -> 0x0041 }
                goto L_0x0228
            L_0x01ed:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r2 = r1.f35530d
                com.sumsub.sns.internal.presentation.screen.preview.a.a(r2, r0, r7, r6, r7)
                goto L_0x0228
            L_0x01f3:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = r1.f35530d
                java.lang.String r5 = r3.s()
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.a(r3, r5, r7, r6, r7)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = r1.f35530d
                r1.f35527a = r3
                r1.f35529c = r4
                java.lang.Object r0 = r3.a((com.sumsub.sns.core.data.model.SNSException.Api) r0, (kotlin.coroutines.c<? super java.lang.String>) r1)
                if (r0 != r2) goto L_0x0209
                return r2
            L_0x0209:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r4 = r1.f35530d
                r1.f35527a = r3
                r1.f35528b = r0
                r5 = 4
                r1.f35529c = r5
                java.lang.String r5 = "sns_alert_action_dismiss"
                java.lang.Object r4 = r4.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r1)
                if (r4 != r2) goto L_0x021d
                return r2
            L_0x021d:
                r2 = r3
            L_0x021e:
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$d r3 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$d
                r3.<init>(r0, r4)
                r2.a((com.sumsub.sns.core.presentation.base.a.j) r3)
            L_0x0228:
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            L_0x022b:
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            L_0x022e:
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.t.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$requestOAuth$1", f = "SNSEkycViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class u extends SuspendLambda implements d10.p<f, kotlin.coroutines.c<? super f>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35532a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f35533b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f35534c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(String str, String str2, kotlin.coroutines.c<? super u> cVar) {
            super(2, cVar);
            this.f35533b = str;
            this.f35534c = str2;
        }

        /* renamed from: a */
        public final Object invoke(f fVar, kotlin.coroutines.c<? super f> cVar) {
            return ((u) create(fVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new u(this.f35533b, this.f35534c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35532a == 0) {
                kotlin.k.b(obj);
                return new f.d(this.f35533b, this.f35534c);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$requestOtpConfirmation$1", f = "SNSEkycViewModel.kt", l = {722, 723}, m = "invokeSuspend")
    public static final class v extends SuspendLambda implements d10.p<f, kotlin.coroutines.c<? super f>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35535a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35536b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f35537c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e0 f35538d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(b bVar, e0 e0Var, kotlin.coroutines.c<? super v> cVar) {
            super(2, cVar);
            this.f35537c = bVar;
            this.f35538d = e0Var;
        }

        /* renamed from: a */
        public final Object invoke(f fVar, kotlin.coroutines.c<? super f> cVar) {
            return ((v) create(fVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            v vVar = new v(this.f35537c, this.f35538d, cVar);
            vVar.f35536b = obj;
            return vVar;
        }

        public final Object invokeSuspend(Object obj) {
            f.e eVar;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35535a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                b bVar = this.f35537c;
                this.f35535a = 1;
                obj = bVar.b((f) this.f35536b, (kotlin.coroutines.c<? super f.e>) this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else if (i11 == 2) {
                eVar = (f.e) this.f35536b;
                kotlin.k.b(obj);
                return f.e.a(eVar, (CharSequence) null, (CharSequence) null, (CharSequence) obj, (CharSequence) null, 0, this.f35538d, 27, (Object) null);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.e eVar2 = (f.e) obj;
            b bVar2 = this.f35537c;
            this.f35536b = eVar2;
            this.f35535a = 2;
            Object a11 = bVar2.a(60, (kotlin.coroutines.c<? super CharSequence>) this);
            if (a11 == d11) {
                return d11;
            }
            eVar = eVar2;
            obj = a11;
            return f.e.a(eVar, (CharSequence) null, (CharSequence) null, (CharSequence) obj, (CharSequence) null, 0, this.f35538d, 27, (Object) null);
        }
    }

    public static final class w extends Lambda implements d10.p<String, String, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f35539a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f35540b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f35541c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.c f35542d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(String str, b bVar, String str2, b.c cVar) {
            super(2);
            this.f35539a = str;
            this.f35540b = bVar;
            this.f35541c = str2;
            this.f35542d = cVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
            r0 = (r0 = (r1 = (r1 = r1.f()).x()).get(r0)).c();
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String invoke(java.lang.String r10, java.lang.String r11) {
            /*
                r9 = this;
                java.lang.String r0 = r9.f35539a
                r6 = 1
                char[] r1 = new char[r6]
                r2 = 46
                r7 = 0
                r1[r7] = r2
                r2 = 0
                r3 = 0
                r4 = 6
                r5 = 0
                java.util.List r0 = kotlin.text.StringsKt__StringsKt.K0(r0, r1, r2, r3, r4, r5)
                java.lang.String r0 = com.sumsub.sns.internal.core.common.z0.a((java.util.List<java.lang.String>) r0)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r1 = r9.f35540b
                com.sumsub.sns.internal.domain.c r1 = r1.f35383g0
                r2 = 0
                if (r1 == 0) goto L_0x0040
                com.sumsub.sns.internal.core.data.model.e r1 = r1.f()
                if (r1 == 0) goto L_0x0040
                java.util.Map r1 = r1.x()
                if (r1 == 0) goto L_0x0040
                java.lang.Object r0 = r1.get(r0)
                com.sumsub.sns.internal.core.data.model.w r0 = (com.sumsub.sns.internal.core.data.model.w) r0
                if (r0 == 0) goto L_0x0040
                java.util.Map r0 = r0.c()
                if (r0 == 0) goto L_0x0040
                java.lang.Object r0 = r0.get(r11)
                java.lang.String r0 = (java.lang.String) r0
                goto L_0x0041
            L_0x0040:
                r0 = r2
            L_0x0041:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r1 = r9.f35540b
                com.sumsub.sns.internal.domain.c r1 = r1.f35383g0
                java.lang.String r3 = "field"
                if (r1 == 0) goto L_0x0070
                com.sumsub.sns.internal.core.data.model.e r1 = r1.f()
                if (r1 == 0) goto L_0x0070
                java.util.Map r1 = r1.t()
                if (r1 == 0) goto L_0x0070
                java.lang.String r4 = r9.f35541c
                java.lang.Object r1 = r1.get(r4)
                java.util.Map r1 = (java.util.Map) r1
                if (r1 == 0) goto L_0x0070
                java.lang.Object r1 = r1.get(r11)
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto L_0x0070
                boolean r4 = kotlin.jvm.internal.x.b(r10, r3)
                if (r4 == 0) goto L_0x0070
                goto L_0x0071
            L_0x0070:
                r1 = r2
            L_0x0071:
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r4 = r9.f35542d
                kotlin.jvm.internal.d0 r5 = kotlin.jvm.internal.d0.f56774a
                r5 = 2
                java.lang.Object[] r8 = new java.lang.Object[r5]
                r8[r7] = r10
                r8[r6] = r11
                java.lang.Object[] r5 = java.util.Arrays.copyOf(r8, r5)
                java.lang.String r6 = "sns_data_%s_%s"
                java.lang.String r5 = java.lang.String.format(r6, r5)
                java.lang.String r4 = r4.a((java.lang.String) r5)
                if (r0 == 0) goto L_0x0099
                boolean r5 = kotlin.jvm.internal.x.b(r10, r3)
                if (r5 == 0) goto L_0x0093
                goto L_0x0094
            L_0x0093:
                r0 = r2
            L_0x0094:
                if (r0 != 0) goto L_0x0097
                goto L_0x0099
            L_0x0097:
                r11 = r0
                goto L_0x00b5
            L_0x0099:
                if (r1 == 0) goto L_0x00a2
                boolean r0 = kotlin.jvm.internal.x.b(r10, r3)
                if (r0 == 0) goto L_0x00a2
                goto L_0x00a3
            L_0x00a2:
                r1 = r2
            L_0x00a3:
                if (r1 != 0) goto L_0x00b4
                if (r4 != 0) goto L_0x00b2
                if (r11 == 0) goto L_0x00b0
                boolean r10 = kotlin.jvm.internal.x.b(r10, r3)
                if (r10 == 0) goto L_0x00b0
                goto L_0x00b5
            L_0x00b0:
                r11 = r2
                goto L_0x00b5
            L_0x00b2:
                r11 = r4
                goto L_0x00b5
            L_0x00b4:
                r11 = r1
            L_0x00b5:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.w.invoke(java.lang.String, java.lang.String):java.lang.String");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$showContent$1", f = "SNSEkycViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class x extends SuspendLambda implements d10.p<f, kotlin.coroutines.c<? super f>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35543a;

        public x(kotlin.coroutines.c<? super x> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(f fVar, kotlin.coroutines.c<? super f> cVar) {
            return ((x) create(fVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new x(cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35543a == 0) {
                kotlin.k.b(obj);
                return f.c.f35437a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$skipStep$1", f = "SNSEkycViewModel.kt", l = {365, 365, 369, 369}, m = "invokeSuspend")
    public static final class y extends SuspendLambda implements d10.l<kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35544a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35545b;

        /* renamed from: c  reason: collision with root package name */
        public int f35546c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f35547d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y(b bVar, kotlin.coroutines.c<? super y> cVar) {
            super(1, cVar);
            this.f35547d = bVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlin.coroutines.c<? super Unit> cVar) {
            return ((y) create(cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(kotlin.coroutines.c<?> cVar) {
            return new y(this.f35547d, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x006d A[Catch:{ Api -> 0x003c, all -> 0x003a }] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0072 A[Catch:{ Api -> 0x003c, all -> 0x003a }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r7.f35546c
                r2 = 4
                r3 = 3
                r4 = 1
                r5 = 2
                r6 = 0
                if (r1 == 0) goto L_0x003e
                if (r1 == r4) goto L_0x0036
                if (r1 == r5) goto L_0x0032
                if (r1 == r3) goto L_0x002a
                if (r1 != r2) goto L_0x0022
                java.lang.Object r0 = r7.f35545b
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.Object r1 = r7.f35544a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r1 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b) r1
                kotlin.k.b(r8)
                goto L_0x00a8
            L_0x0022:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x002a:
                java.lang.Object r1 = r7.f35544a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r1 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b) r1
                kotlin.k.b(r8)
                goto L_0x0093
            L_0x0032:
                kotlin.k.b(r8)     // Catch:{ Api -> 0x003c, all -> 0x003a }
                goto L_0x0065
            L_0x0036:
                kotlin.k.b(r8)     // Catch:{ Api -> 0x003c, all -> 0x003a }
                goto L_0x004c
            L_0x003a:
                r8 = move-exception
                goto L_0x0077
            L_0x003c:
                r8 = move-exception
                goto L_0x007d
            L_0x003e:
                kotlin.k.b(r8)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r8 = r7.f35547d     // Catch:{ Api -> 0x003c, all -> 0x003a }
                r7.f35546c = r4     // Catch:{ Api -> 0x003c, all -> 0x003a }
                java.lang.Object r8 = r8.g((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g>) r7)     // Catch:{ Api -> 0x003c, all -> 0x003a }
                if (r8 != r0) goto L_0x004c
                return r0
            L_0x004c:
                com.sumsub.sns.internal.core.data.model.g r8 = (com.sumsub.sns.internal.core.data.model.g) r8     // Catch:{ Api -> 0x003c, all -> 0x003a }
                if (r8 == 0) goto L_0x0068
                java.lang.String r8 = r8.B()     // Catch:{ Api -> 0x003c, all -> 0x003a }
                if (r8 == 0) goto L_0x0068
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r1 = r7.f35547d     // Catch:{ Api -> 0x003c, all -> 0x003a }
                com.sumsub.sns.internal.core.data.source.applicant.e r1 = r1.f35377a0     // Catch:{ Api -> 0x003c, all -> 0x003a }
                r7.f35546c = r5     // Catch:{ Api -> 0x003c, all -> 0x003a }
                java.lang.Object r8 = r1.d(r8, r7)     // Catch:{ Api -> 0x003c, all -> 0x003a }
                if (r8 != r0) goto L_0x0065
                return r0
            L_0x0065:
                com.sumsub.sns.internal.core.data.source.applicant.remote.d0 r8 = (com.sumsub.sns.internal.core.data.source.applicant.remote.d0) r8     // Catch:{ Api -> 0x003c, all -> 0x003a }
                goto L_0x0069
            L_0x0068:
                r8 = r6
            L_0x0069:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r1 = r7.f35547d     // Catch:{ Api -> 0x003c, all -> 0x003a }
                if (r8 == 0) goto L_0x0072
                com.sumsub.sns.internal.core.data.source.applicant.remote.EKycFlowStatus r8 = r8.b()     // Catch:{ Api -> 0x003c, all -> 0x003a }
                goto L_0x0073
            L_0x0072:
                r8 = r6
            L_0x0073:
                r1.a((com.sumsub.sns.internal.core.data.source.applicant.remote.EKycFlowStatus) r8)     // Catch:{ Api -> 0x003c, all -> 0x003a }
                goto L_0x00b2
            L_0x0077:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r0 = r7.f35547d
                com.sumsub.sns.internal.presentation.screen.preview.a.a(r0, r8, r6, r5, r6)
                goto L_0x00b2
            L_0x007d:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r1 = r7.f35547d
                java.lang.String r4 = r1.s()
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.a(r1, r4, r6, r5, r6)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r1 = r7.f35547d
                r7.f35544a = r1
                r7.f35546c = r3
                java.lang.Object r8 = r1.a((com.sumsub.sns.core.data.model.SNSException.Api) r8, (kotlin.coroutines.c<? super java.lang.String>) r7)
                if (r8 != r0) goto L_0x0093
                return r0
            L_0x0093:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = r7.f35547d
                r7.f35544a = r1
                r7.f35545b = r8
                r7.f35546c = r2
                java.lang.String r2 = "sns_alert_action_dismiss"
                java.lang.Object r2 = r3.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r7)
                if (r2 != r0) goto L_0x00a6
                return r0
            L_0x00a6:
                r0 = r8
                r8 = r2
            L_0x00a8:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$d r2 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$d
                r2.<init>(r0, r8)
                r1.a((com.sumsub.sns.core.presentation.base.a.j) r2)
            L_0x00b2:
                kotlin.Unit r8 = kotlin.Unit.f56620a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.y.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$startResendCodeTimer$1", f = "SNSEkycViewModel.kt", l = {709}, m = "invokeSuspend")
    public static final class z extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35548a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35549b;

        /* renamed from: c  reason: collision with root package name */
        public int f35550c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f35551d;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$startResendCodeTimer$1$1$1", f = "SNSEkycViewModel.kt", l = {704, 706}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<f, kotlin.coroutines.c<? super f>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f35552a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f35553b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f35554c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f35555d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, long j11, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f35554c = bVar;
                this.f35555d = j11;
            }

            /* renamed from: a */
            public final Object invoke(f fVar, kotlin.coroutines.c<? super f> cVar) {
                return ((a) create(fVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                a aVar = new a(this.f35554c, this.f35555d, cVar);
                aVar.f35553b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                f.e eVar;
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f35552a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    b bVar = this.f35554c;
                    this.f35552a = 1;
                    obj = bVar.b((f) this.f35553b, (kotlin.coroutines.c<? super f.e>) this);
                    if (obj == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else if (i11 == 2) {
                    eVar = (f.e) this.f35553b;
                    kotlin.k.b(obj);
                    return f.e.a(eVar, (CharSequence) null, (CharSequence) null, (CharSequence) obj, (CharSequence) null, this.f35555d, (e0) null, 43, (Object) null);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.e eVar2 = (f.e) obj;
                b bVar2 = this.f35554c;
                long j11 = this.f35555d;
                this.f35553b = eVar2;
                this.f35552a = 2;
                Object a11 = bVar2.a(j11, (kotlin.coroutines.c<? super CharSequence>) this);
                if (a11 == d11) {
                    return d11;
                }
                eVar = eVar2;
                obj = a11;
                return f.e.a(eVar, (CharSequence) null, (CharSequence) null, (CharSequence) obj, (CharSequence) null, this.f35555d, (e0) null, 43, (Object) null);
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.SNSEkycViewModel$startResendCodeTimer$1$2", f = "SNSEkycViewModel.kt", l = {713, 714}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$z$b  reason: collision with other inner class name */
        public static final class C0434b extends SuspendLambda implements d10.p<f, kotlin.coroutines.c<? super f>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f35556a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f35557b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f35558c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0434b(b bVar, kotlin.coroutines.c<? super C0434b> cVar) {
                super(2, cVar);
                this.f35558c = bVar;
            }

            /* renamed from: a */
            public final Object invoke(f fVar, kotlin.coroutines.c<? super f> cVar) {
                return ((C0434b) create(fVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                C0434b bVar = new C0434b(this.f35558c, cVar);
                bVar.f35557b = obj;
                return bVar;
            }

            public final Object invokeSuspend(Object obj) {
                f.e eVar;
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f35556a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    b bVar = this.f35558c;
                    this.f35556a = 1;
                    obj = bVar.b((f) this.f35557b, (kotlin.coroutines.c<? super f.e>) this);
                    if (obj == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else if (i11 == 2) {
                    eVar = (f.e) this.f35557b;
                    kotlin.k.b(obj);
                    return f.e.a(eVar, (CharSequence) null, (CharSequence) null, (CharSequence) obj, (CharSequence) null, 0, (e0) null, 59, (Object) null);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.e eVar2 = (f.e) obj;
                b bVar2 = this.f35558c;
                this.f35557b = eVar2;
                this.f35556a = 2;
                Object a11 = bVar2.a("sns_confirmation_code_action_resend", (kotlin.coroutines.c<? super String>) this);
                if (a11 == d11) {
                    return d11;
                }
                eVar = eVar2;
                obj = a11;
                return f.e.a(eVar, (CharSequence) null, (CharSequence) null, (CharSequence) obj, (CharSequence) null, 0, (e0) null, 59, (Object) null);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z(b bVar, kotlin.coroutines.c<? super z> cVar) {
            super(2, cVar);
            this.f35551d = bVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((z) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new z(this.f35551d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            b bVar;
            Iterator it2;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35550c;
            if (i11 == 0) {
                kotlin.k.b(obj);
                kotlin.ranges.i m11 = RangesKt___RangesKt.m(60, 0);
                bVar = this.f35551d;
                it2 = m11.iterator();
            } else if (i11 == 1) {
                it2 = (Iterator) this.f35549b;
                bVar = (b) this.f35548a;
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (it2.hasNext()) {
                com.sumsub.sns.core.presentation.base.a.a(bVar, false, new a(bVar, ((LongIterator) it2).a(), (kotlin.coroutines.c<? super a>) null), 1, (Object) null);
                this.f35548a = bVar;
                this.f35549b = it2;
                this.f35550c = 1;
                if (DelayKt.b(1000, this) == d11) {
                    return d11;
                }
            }
            b bVar2 = this.f35551d;
            com.sumsub.sns.core.presentation.base.a.a(bVar2, false, new C0434b(bVar2, (kotlin.coroutines.c<? super C0434b>) null), 1, (Object) null);
            return Unit.f56620a;
        }
    }

    static {
        Class<b> cls = b.class;
        E = new kotlin.reflect.l[]{Reflection.e(new MutablePropertyReference1Impl(cls, "currentSourceId", "getCurrentSourceId()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "currentConfirmationId", "getCurrentConfirmationId()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "lastOAuthConfirmModel", "getLastOAuthConfirmModel()Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ApplicantDataConfirmModel;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "submitResponse", "getSubmitResponse()Lcom/sumsub/sns/internal/core/data/source/applicant/remote/SubmitApplicantDataResponse;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "fieldValueCache", "getFieldValueCache()Ljava/util/Map;", 0))};
    }

    public b(Document document, com.sumsub.sns.internal.core.data.source.extensions.a aVar, com.sumsub.sns.internal.core.data.source.applicant.e eVar, SavedStateHandle savedStateHandle, com.sumsub.sns.internal.core.data.source.common.a aVar2, com.sumsub.sns.internal.core.data.source.dynamic.b bVar, com.sumsub.sns.internal.core.domain.d dVar) {
        super(document, savedStateHandle, aVar2, bVar, dVar);
        this.Z = aVar;
        this.f35377a0 = eVar;
        this.f35384h0 = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "currentSourceId", null);
        this.f35385i0 = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "currentConfirmationId", null);
        this.f35386j0 = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "lastOAuthConfirmModel", null);
        this.f35387k0 = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "submitResponse", null);
        this.f35388l0 = new r(this);
        this.f35389m0 = k1.a(new b.a(0, CollectionsKt__CollectionsKt.k(), (String) null, new b.c((String) null, (String) null, 3, (kotlin.jvm.internal.r) null)));
        this.f35390n0 = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "KEY_FIELD_CACHE", MapsKt__MapsKt.h());
        com.sumsub.sns.internal.core.common.b0.b(j(), m0.a(this), new a(this, (kotlin.coroutines.c<? super a>) null));
    }

    public final boolean A() {
        boolean z11;
        n1 n1Var = this.f35381e0;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        f fVar = (f) c();
        if (fVar instanceof f.d) {
            z11 = true;
        } else {
            z11 = fVar instanceof f.e;
        }
        if (!z11) {
            return true;
        }
        L();
        return false;
    }

    public final String B() {
        return (String) this.f35385i0.a(this, E[1]);
    }

    public final String C() {
        return (String) this.f35384h0.a(this, E[0]);
    }

    /* renamed from: D */
    public f.C0432b e() {
        return f.C0432b.f35436a;
    }

    public final Map<String, String> E() {
        return (Map) this.f35390n0.a(this, E[4]);
    }

    public final com.sumsub.sns.internal.core.data.source.applicant.remote.a F() {
        return (com.sumsub.sns.internal.core.data.source.applicant.remote.a) this.f35386j0.a(this, E[2]);
    }

    public final e0 G() {
        return (e0) this.f35387k0.a(this, E[3]);
    }

    public final void H() {
        com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, a.f35376b, "onCloseOAuthClick", (Throwable) null, 4, (Object) null);
        L();
    }

    public final void I() {
        com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, a.f35376b, "E-ID confirm cancelled", (Throwable) null, 4, (Object) null);
        L();
    }

    public final void J() {
        a((d10.l<? super kotlin.coroutines.c<? super Unit>, ? extends Object>) new t(this, (kotlin.coroutines.c<? super t>) null));
    }

    public final void K() {
        com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, a.f35376b, "onTryAgainClick", (Throwable) null, 4, (Object) null);
        L();
    }

    public final n1 L() {
        return a(this, s(), (List) null, 2, (Object) null);
    }

    public final void M() {
        a((d10.l<? super kotlin.coroutines.c<? super Unit>, ? extends Object>) new y(this, (kotlin.coroutines.c<? super y>) null));
    }

    public final void N() {
        n1 n1Var = this.f35381e0;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        this.f35381e0 = kotlinx.coroutines.i.d(this.f35382f0, (CoroutineContext) null, (CoroutineStart) null, new z(this, (kotlin.coroutines.c<? super z>) null), 3, (Object) null);
    }

    public /* synthetic */ void a(Context context, FieldId fieldId, List list) {
        com.sumsub.sns.internal.core.presentation.form.e.a(this, context, fieldId, list);
    }

    public /* synthetic */ void a(FormItem formItem, String str) {
        com.sumsub.sns.internal.core.presentation.form.e.b(this, formItem, str);
    }

    public /* synthetic */ void a(FormItem formItem, List list) {
        com.sumsub.sns.internal.core.presentation.form.e.c(this, formItem, list);
    }

    public void onCleared() {
        super.onCleared();
        i0.f(this.f35382f0, (CancellationException) null, 1, (Object) null);
    }

    public final void f(String str) {
        this.f35384h0.a(this, E[0], str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.n
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$n r0 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.n) r0
            int r1 = r0.f35505c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35505c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$n r0 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$n
            r0.<init>(r7, r8)
        L_0x0018:
            r4 = r0
            java.lang.Object r8 = r4.f35503a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r4.f35505c
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.k.b(r8)
            goto L_0x004a
        L_0x002a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0032:
            kotlin.k.b(r8)
            com.sumsub.sns.internal.core.data.model.g r8 = r7.f35379c0
            if (r8 != 0) goto L_0x0052
            com.sumsub.sns.internal.core.data.source.dynamic.b r1 = r7.t()
            r4.f35505c = r2
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            java.lang.Object r8 = com.sumsub.sns.internal.core.data.source.dynamic.h.g(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L_0x004a
            return r0
        L_0x004a:
            com.sumsub.sns.internal.core.data.source.dynamic.e r8 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r8
            java.lang.Object r8 = r8.d()
            com.sumsub.sns.internal.core.data.model.g r8 = (com.sumsub.sns.internal.core.data.model.g) r8
        L_0x0052:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.g(kotlin.coroutines.c):java.lang.Object");
    }

    public final void h(e0 e0Var) {
        this.f35387k0.a(this, E[3], e0Var);
    }

    public final void d(Map<String, String> map) {
        this.f35390n0.a(this, E[4], map);
    }

    public final void e(String str) {
        this.f35385i0.a(this, E[1], str);
    }

    public final com.sumsub.sns.internal.core.data.source.applicant.remote.b c(Map<String, String> map) {
        Map<String, List<com.sumsub.sns.internal.core.data.model.j>> w11;
        Object obj;
        com.sumsub.sns.internal.core.data.model.e d11 = d();
        if (d11 == null || (w11 = d11.w()) == null) {
            throw new IllegalArgumentException("eKycConfig is null");
        }
        String s11 = s();
        if (s11 != null) {
            List list = w11.get(s11);
            if (list != null) {
                Iterator it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (kotlin.jvm.internal.x.b(((com.sumsub.sns.internal.core.data.model.j) obj).h(), C())) {
                        break;
                    }
                }
                com.sumsub.sns.internal.core.data.model.j jVar = (com.sumsub.sns.internal.core.data.model.j) obj;
                if (jVar != null) {
                    if (kotlin.jvm.internal.x.b(jVar.f(), "TAX_PAYER_NUMBER_DOC")) {
                        return new com.sumsub.sns.internal.core.data.source.applicant.remote.b((Map) null, (Map) map, 1, (kotlin.jvm.internal.r) null);
                    }
                    Map y11 = MapsKt__MapsKt.y(map);
                    String f11 = jVar.f();
                    if (f11 != null) {
                        y11.put("idDocType", f11);
                    }
                    return new com.sumsub.sns.internal.core.data.source.applicant.remote.b(y11, (Map) null, 2, (kotlin.jvm.internal.r) null);
                }
            }
            throw new IllegalArgumentException("ApplicantDataSource is null");
        }
        throw new IllegalArgumentException("country is null");
    }

    public Object d(kotlin.coroutines.c<? super Unit> cVar) {
        m();
        return Unit.f56620a;
    }

    public final void f(e0 e0Var) {
        com.sumsub.sns.internal.core.data.source.applicant.remote.p p11 = e0Var.p();
        String c11 = p11 != null ? p11.c() : null;
        com.sumsub.sns.internal.core.data.source.applicant.remote.p p12 = e0Var.p();
        String e11 = p12 != null ? p12.e() : null;
        if (!(e11 == null || e11.length() == 0)) {
            if (!(c11 == null || c11.length() == 0)) {
                com.sumsub.sns.core.presentation.base.a.a(this, false, new u(e11, c11, (kotlin.coroutines.c<? super u>) null), 1, (Object) null);
                return;
            }
        }
        com.sumsub.sns.internal.presentation.screen.preview.a.a(this, new Exception("url or redirect url is empty"), (Object) null, 2, (Object) null);
    }

    public final void d(e0 e0Var) {
        if (e0Var != null) {
            h(e0Var);
            if (e0Var.t() == EKycFlowStatus.CONFIRMATION_REQUIRED) {
                e(e0Var.h());
                ConfirmationType l11 = e0Var.l();
                int i11 = l11 == null ? -1 : g.f35451a[l11.ordinal()];
                if (i11 == 1) {
                    g(e0Var);
                } else if (i11 == 2) {
                    f(e0Var);
                } else if (i11 != 3) {
                    a(e0Var.t());
                } else {
                    e(e0Var);
                }
            } else {
                a(e0Var.t());
            }
        }
    }

    public final void e(e0 e0Var) {
        com.sumsub.sns.internal.core.data.source.applicant.remote.i n11;
        String f11;
        if (!u0.a()) {
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (Throwable) new Exception("Eid not available"), DocumentType.f32357l, (Object) null, 4, (Object) null);
        } else if (e0Var == null || (n11 = e0Var.n()) == null || (f11 = n11.f()) == null) {
            throw new IllegalStateException("No mobile token".toString());
        } else {
            String d11 = e0Var.n().d();
            if (d11 != null) {
                String h11 = e0Var.n().h();
                if (h11 != null) {
                    b(false);
                    a((a.j) new c(f11, h11, d11));
                    return;
                }
                throw new IllegalStateException("No url".toString());
            }
            throw new IllegalStateException("No hash".toString());
        }
    }

    public final void g(e0 e0Var) {
        com.sumsub.sns.core.presentation.base.a.a(this, false, new v(this, e0Var, (kotlin.coroutines.c<? super v>) null), 1, (Object) null);
        N();
    }

    public j1<b.a> b() {
        return this.f35389m0;
    }

    public void b(FormItem formItem, String str) {
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        com.sumsub.log.logger.a.a(aVar, a.f35376b, "onFieldValueChanged: " + formItem.k() + " -> " + str, (Throwable) null, 4, (Object) null);
        Map<String, String> E2 = E();
        String p11 = formItem.d().p();
        if (p11 == null) {
            p11 = "";
        }
        d(com.sumsub.sns.internal.core.common.i.a(E2, p11, str));
        if (formItem instanceof FormItem.c) {
            a(this, str, (List) null, 2, (Object) null);
        } else if (kotlin.jvm.internal.x.b(formItem.d().p(), c.f35559a)) {
            b(this, str, (List) null, 2, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.l
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$l r0 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.l) r0
            int r1 = r0.f35496e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35496e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$l r0 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$l
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f35494c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f35496e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0054
            if (r2 == r5) goto L_0x004c
            if (r2 == r4) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r1 = r0.f35493b
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.f35492a
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            kotlin.k.b(r12)
            r3 = r0
            goto L_0x008e
        L_0x0038:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0040:
            java.lang.Object r2 = r0.f35493b
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r4 = r0.f35492a
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r4 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b) r4
            kotlin.k.b(r12)
            goto L_0x007a
        L_0x004c:
            java.lang.Object r2 = r0.f35492a
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r2 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b) r2
            kotlin.k.b(r12)
            goto L_0x0065
        L_0x0054:
            kotlin.k.b(r12)
            r0.f35492a = r11
            r0.f35496e = r5
            r5 = 60
            java.lang.Object r12 = r11.a((long) r5, (kotlin.coroutines.c<? super java.lang.CharSequence>) r0)
            if (r12 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r2 = r11
        L_0x0065:
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r0.f35492a = r2
            r0.f35493b = r12
            r0.f35496e = r4
            java.lang.String r4 = "sns_confirmation_code_ekyc_title"
            java.lang.Object r4 = r2.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r4 != r1) goto L_0x0076
            return r1
        L_0x0076:
            r10 = r2
            r2 = r12
            r12 = r4
            r4 = r10
        L_0x007a:
            java.lang.String r12 = (java.lang.String) r12
            r0.f35492a = r2
            r0.f35493b = r12
            r0.f35496e = r3
            java.lang.String r3 = "sns_confirmation_code_ekyc_subtitle"
            java.lang.Object r0 = r4.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r0 != r1) goto L_0x008b
            return r1
        L_0x008b:
            r1 = r12
            r12 = r0
            r3 = r2
        L_0x008e:
            r2 = r12
            java.lang.String r2 = (java.lang.String) r2
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$e r12 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$e
            r4 = 0
            r5 = 60
            r7 = 0
            r8 = 40
            r9 = 0
            r0 = r12
            r0.<init>(r1, r2, r3, r4, r5, r7, r8, r9)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f(kotlin.coroutines.c):java.lang.Object");
    }

    public final void d(String str) {
        a((d10.l<? super kotlin.coroutines.c<? super Unit>, ? extends Object>) new h(this, str, (kotlin.coroutines.c<? super h>) null));
    }

    public static /* synthetic */ n1 b(b bVar, String str, List list, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            list = CollectionsKt__CollectionsKt.k();
        }
        return bVar.b(str, (List<com.sumsub.sns.internal.domain.b>) list);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0096 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.a> r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            boolean r2 = r1 instanceof com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.k
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$k r2 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.k) r2
            int r3 = r2.f35491g
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f35491g = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$k r2 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$k
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f35489e
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f35491g
            r5 = 3
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L_0x006d
            if (r4 == r7) goto L_0x0061
            if (r4 == r6) goto L_0x004c
            if (r4 != r5) goto L_0x0044
            java.lang.Object r3 = r2.f35488d
            com.sumsub.sns.internal.domain.c r3 = (com.sumsub.sns.internal.domain.c) r3
            java.lang.Object r4 = r2.f35487c
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r2.f35486b
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r2 = r2.f35485a
            java.lang.String r2 = (java.lang.String) r2
            kotlin.k.b(r1)
            goto L_0x00d0
        L_0x0044:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004c:
            java.lang.Object r4 = r2.f35487c
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r6 = r2.f35486b
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r2.f35485a
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r7 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b) r7
            kotlin.k.b(r1)
            r20 = r6
            r6 = r4
            r4 = r20
            goto L_0x009c
        L_0x0061:
            java.lang.Object r4 = r2.f35486b
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r7 = r2.f35485a
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r7 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b) r7
            kotlin.k.b(r1)
            goto L_0x0084
        L_0x006d:
            kotlin.k.b(r1)
            java.lang.String r4 = r21.s()
            r2.f35485a = r0
            r2.f35486b = r4
            r2.f35491g = r7
            java.lang.String r1 = "sns_ekyc_form_title"
            java.lang.Object r1 = r0.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r1 != r3) goto L_0x0083
            return r3
        L_0x0083:
            r7 = r0
        L_0x0084:
            java.lang.String r1 = (java.lang.String) r1
            r2.f35485a = r7
            r2.f35486b = r4
            r2.f35487c = r1
            r2.f35491g = r6
            java.lang.String r6 = "sns_ekyc_form_subtitle"
            java.lang.Object r6 = r7.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r6 != r3) goto L_0x0097
            return r3
        L_0x0097:
            r20 = r6
            r6 = r1
            r1 = r20
        L_0x009c:
            java.lang.String r1 = (java.lang.String) r1
            com.sumsub.sns.internal.domain.c r8 = r7.f35383g0
            if (r8 != 0) goto L_0x00b1
            com.sumsub.sns.internal.domain.c r8 = new com.sumsub.sns.internal.domain.c
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 31
            r16 = 0
            r9 = r8
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
        L_0x00b1:
            boolean r9 = r7.f35380d0
            if (r9 == 0) goto L_0x00d8
            r2.f35485a = r4
            r2.f35486b = r6
            r2.f35487c = r1
            r2.f35488d = r8
            r2.f35491g = r5
            java.lang.String r5 = "sns_ekyc_action_skip"
            java.lang.Object r2 = r7.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r2 != r3) goto L_0x00c8
            return r3
        L_0x00c8:
            r5 = r6
            r3 = r8
            r20 = r4
            r4 = r1
            r1 = r2
            r2 = r20
        L_0x00d0:
            java.lang.String r1 = (java.lang.String) r1
            r13 = r1
            r15 = r2
            r14 = r3
            r11 = r4
            r10 = r5
            goto L_0x00de
        L_0x00d8:
            r2 = 0
            r11 = r1
            r13 = r2
            r15 = r4
            r10 = r6
            r14 = r8
        L_0x00de:
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$a r1 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$a
            r12 = 0
            r16 = 0
            r17 = 0
            r18 = 196(0xc4, float:2.75E-43)
            r19 = 0
            r9 = r1
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.e(kotlin.coroutines.c):java.lang.Object");
    }

    public final void c(e0 e0Var) {
        if (e0Var.j() == ConfirmationStatus.RETRY) {
            com.sumsub.sns.core.presentation.base.a.a(this, false, new q(this, e0Var, (kotlin.coroutines.c<? super q>) null), 1, (Object) null);
        } else {
            g(e0Var);
        }
    }

    public final void a(com.sumsub.sns.internal.core.data.source.applicant.remote.a aVar) {
        this.f35386j0.a(this, E[2], aVar);
    }

    public final n1 b(String str, List<com.sumsub.sns.internal.domain.b> list) {
        return kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new b0(str, this, list, (kotlin.coroutines.c<? super b0>) null), 3, (Object) null);
    }

    public final void b(e0 e0Var) {
        if (e0Var.t() == EKycFlowStatus.CONFIRMATION_REQUIRED && e0Var.j() == ConfirmationStatus.RETRY) {
            b(false);
            c(true);
            com.sumsub.sns.core.presentation.base.a.a(this, false, new p(this, (kotlin.coroutines.c<? super p>) null), 1, (Object) null);
            return;
        }
        a(e0Var.t());
    }

    public com.sumsub.sns.internal.core.presentation.form.d a() {
        return this.f35388l0;
    }

    public void c(boolean z11) {
        if (!z11) {
            com.sumsub.sns.core.presentation.base.a.a(this, false, new x((kotlin.coroutines.c<? super x>) null), 1, (Object) null);
        }
    }

    public void a(com.sumsub.sns.internal.core.domain.e eVar) {
        String s11 = s();
        if (s11 == null) {
            s11 = eVar.i();
        }
        b(s11);
        a(eVar.h());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007f, code lost:
        r1 = r1.f();
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(com.sumsub.sns.internal.core.data.model.g r22, com.sumsub.sns.internal.core.data.model.e r23, kotlin.coroutines.c<? super kotlin.Unit> r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            boolean r4 = r3 instanceof com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.s
            if (r4 == 0) goto L_0x001b
            r4 = r3
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$s r4 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.s) r4
            int r5 = r4.f35526f
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001b
            int r5 = r5 - r6
            r4.f35526f = r5
            goto L_0x0020
        L_0x001b:
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$s r4 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$s
            r4.<init>(r0, r3)
        L_0x0020:
            java.lang.Object r3 = r4.f35524d
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r6 = r4.f35526f
            r7 = 0
            r8 = 1
            if (r6 == 0) goto L_0x0048
            if (r6 != r8) goto L_0x0040
            java.lang.Object r1 = r4.f35523c
            com.sumsub.sns.internal.core.data.model.e r1 = (com.sumsub.sns.internal.core.data.model.e) r1
            java.lang.Object r2 = r4.f35522b
            com.sumsub.sns.internal.core.data.model.g r2 = (com.sumsub.sns.internal.core.data.model.g) r2
            java.lang.Object r4 = r4.f35521a
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r4 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b) r4
            kotlin.k.b(r3)
            r11 = r1
            r10 = r2
            goto L_0x0075
        L_0x0040:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0048:
            kotlin.k.b(r3)
            if (r2 != 0) goto L_0x0052
            if (r1 != 0) goto L_0x0052
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x0052:
            if (r2 == 0) goto L_0x005f
            java.util.Map r3 = r23.D()
            if (r3 == 0) goto L_0x005f
            com.sumsub.sns.internal.core.common.a1 r6 = r0.f35378b0
            r6.a(r3)
        L_0x005f:
            com.sumsub.sns.internal.core.data.source.dynamic.b r3 = r21.t()
            r4.f35521a = r0
            r4.f35522b = r1
            r4.f35523c = r2
            r4.f35526f = r8
            java.lang.Object r3 = r3.c((boolean) r7, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.model.t>>) r4)
            if (r3 != r5) goto L_0x0072
            return r5
        L_0x0072:
            r4 = r0
            r10 = r1
            r11 = r2
        L_0x0075:
            com.sumsub.sns.internal.core.data.source.dynamic.e r3 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r3
            java.lang.Object r1 = r3.d()
            com.sumsub.sns.internal.core.data.model.t r1 = (com.sumsub.sns.internal.core.data.model.t) r1
            if (r1 == 0) goto L_0x0092
            com.sumsub.sns.internal.core.data.model.remote.response.h r1 = r1.f()
            if (r1 == 0) goto L_0x0092
            java.lang.Boolean r1 = r1.e()
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.a.a(r8)
            boolean r1 = kotlin.jvm.internal.x.b(r1, r2)
            goto L_0x0093
        L_0x0092:
            r1 = r7
        L_0x0093:
            r4.f35380d0 = r1
            java.util.Map r1 = r4.r()
            if (r1 == 0) goto L_0x0132
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x00a8:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0130
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r5 = r3.getKey()
            java.lang.String r5 = (java.lang.String) r5
            if (r11 == 0) goto L_0x00ca
            java.util.Map r6 = r11.w()
            if (r6 == 0) goto L_0x00ca
            boolean r6 = r6.containsKey(r5)
            if (r6 != r8) goto L_0x00ca
            r6 = r8
            goto L_0x00cb
        L_0x00ca:
            r6 = r7
        L_0x00cb:
            if (r11 == 0) goto L_0x00e4
            java.util.Map r9 = r11.w()
            if (r9 == 0) goto L_0x00e4
            java.lang.Object r9 = r9.get(r5)
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x00e4
            boolean r9 = r9.isEmpty()
            r9 = r9 ^ r8
            if (r9 != r8) goto L_0x00e4
            r9 = r8
            goto L_0x00e5
        L_0x00e4:
            r9 = r7
        L_0x00e5:
            if (r6 == 0) goto L_0x011a
            if (r9 != 0) goto L_0x011a
            com.sumsub.sns.internal.log.a r12 = com.sumsub.sns.internal.log.a.f34862a
            com.sumsub.sns.internal.log.LoggerType[] r13 = new com.sumsub.sns.internal.log.LoggerType[r8]
            com.sumsub.sns.internal.log.LoggerType r14 = com.sumsub.sns.internal.log.LoggerType.KIBANA
            r13[r7] = r14
            com.sumsub.log.logger.Logger r15 = r12.a((com.sumsub.sns.internal.log.LoggerType[]) r13)
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.a r12 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.a.f35375a
            java.lang.String r16 = com.sumsub.sns.internal.log.c.a(r12)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Sources for "
            r12.append(r13)
            r12.append(r5)
            java.lang.String r5 = " are empty"
            r12.append(r5)
            java.lang.String r17 = r12.toString()
            r18 = 0
            r19 = 4
            r20 = 0
            com.sumsub.log.logger.a.b(r15, r16, r17, r18, r19, r20)
        L_0x011a:
            if (r6 == 0) goto L_0x0120
            if (r9 == 0) goto L_0x0120
            r5 = r8
            goto L_0x0121
        L_0x0120:
            r5 = r7
        L_0x0121:
            if (r5 == 0) goto L_0x00a8
            java.lang.Object r5 = r3.getKey()
            java.lang.Object r3 = r3.getValue()
            r2.put(r5, r3)
            goto L_0x00a8
        L_0x0130:
            r13 = r2
            goto L_0x0134
        L_0x0132:
            r1 = 0
            r13 = r1
        L_0x0134:
            if (r13 == 0) goto L_0x013c
            boolean r1 = r13.isEmpty()
            if (r1 == 0) goto L_0x013d
        L_0x013c:
            r7 = r8
        L_0x013d:
            if (r7 == 0) goto L_0x015d
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r1 = "E-KYC init failed: no sources configured"
            r12.<init>(r1)
            com.sumsub.sns.internal.core.data.model.Document r1 = r4.u()
            com.sumsub.sns.internal.core.data.model.DocumentType r1 = r1.getType()
            java.lang.String r13 = r1.c()
            r14 = 0
            r15 = 4
            r16 = 0
            r11 = r4
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r11, (java.lang.Throwable) r12, (java.lang.String) r13, (java.lang.Object) r14, (int) r15, (java.lang.Object) r16)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x015d:
            r4.f35379c0 = r10
            if (r11 == 0) goto L_0x0167
            java.util.Map r1 = com.sumsub.sns.internal.core.data.model.f.k(r11)
            if (r1 != 0) goto L_0x016b
        L_0x0167:
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.h()
        L_0x016b:
            r12 = r1
            com.sumsub.sns.internal.domain.c r1 = new com.sumsub.sns.internal.domain.c
            r14 = 0
            r15 = 16
            r16 = 0
            r9 = r1
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            r4.f35383g0 = r1
            r4.L()
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.a(com.sumsub.sns.internal.core.data.model.g, com.sumsub.sns.internal.core.data.model.e, kotlin.coroutines.c):java.lang.Object");
    }

    public final Object b(f fVar, kotlin.coroutines.c<? super f.e> cVar) {
        f.e eVar = fVar instanceof f.e ? (f.e) fVar : null;
        return eVar == null ? f(cVar) : eVar;
    }

    public final com.sumsub.sns.internal.domain.b a(List<com.sumsub.sns.internal.domain.b> list, FieldName fieldName) {
        T t11;
        boolean z11;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            com.sumsub.sns.internal.core.data.model.h c11 = ((com.sumsub.sns.internal.domain.b) t11).c();
            if (!(c11 instanceof h.d) || ((h.d) c11).q() != fieldName) {
                z11 = false;
                continue;
            } else {
                z11 = true;
                continue;
            }
            if (z11) {
                break;
            }
        }
        return (com.sumsub.sns.internal.domain.b) t11;
    }

    public final d10.p<String, String, String> a(b.c cVar, String str, String str2) {
        return new w(str2, this, str, cVar);
    }

    public static /* synthetic */ n1 a(b bVar, String str, List list, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            list = CollectionsKt__CollectionsKt.k();
        }
        return bVar.a(str, (List<com.sumsub.sns.internal.domain.b>) list);
    }

    public final n1 a(String str, List<com.sumsub.sns.internal.domain.b> list) {
        return kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new a0(this, str, list, (kotlin.coroutines.c<? super a0>) null), 3, (Object) null);
    }

    public final void a(CharSequence charSequence, e0 e0Var) {
        a((d10.l<? super kotlin.coroutines.c<? super Unit>, ? extends Object>) new j(this, e0Var, charSequence, (kotlin.coroutines.c<? super j>) null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.CharSequence r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0003
            return
        L_0x0003:
            com.sumsub.sns.core.presentation.base.a$l r0 = r5.c()
            boolean r1 = r0 instanceof com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e
            r2 = 0
            if (r1 == 0) goto L_0x000f
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$f$e r0 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.f.e) r0
            goto L_0x0010
        L_0x000f:
            r0 = r2
        L_0x0010:
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.remote.e0 r1 = r0.j()
            r3 = 1
            if (r1 == 0) goto L_0x0033
            com.sumsub.sns.internal.core.data.source.applicant.remote.s r1 = r1.r()
            if (r1 == 0) goto L_0x0033
            int r4 = r6.length()
            java.lang.Integer r1 = r1.b()
            if (r1 != 0) goto L_0x002b
            goto L_0x0033
        L_0x002b:
            int r1 = r1.intValue()
            if (r4 != r1) goto L_0x0033
            r1 = r3
            goto L_0x0034
        L_0x0033:
            r1 = 0
        L_0x0034:
            if (r1 == 0) goto L_0x0044
            kotlinx.coroutines.n1 r1 = r5.f35381e0
            if (r1 == 0) goto L_0x003d
            kotlinx.coroutines.n1.a.a(r1, r2, r3, r2)
        L_0x003d:
            com.sumsub.sns.internal.core.data.source.applicant.remote.e0 r0 = r0.j()
            r5.a((java.lang.CharSequence) r6, (com.sumsub.sns.internal.core.data.source.applicant.remote.e0) r0)
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.a(java.lang.CharSequence):void");
    }

    public final boolean a(Uri uri, String str) {
        String B;
        String B2;
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        com.sumsub.log.logger.a.a(aVar, a.f35376b, "onCallbackUrl: " + uri, (Throwable) null, 4, (Object) null);
        if ((str == null || str.length() == 0) || !StringsKt__StringsJVMKt.M(uri.toString(), str, false, 2, (Object) null)) {
            return false;
        }
        b(true);
        c(false);
        com.sumsub.sns.internal.core.data.model.g gVar = this.f35379c0;
        if (gVar == null || (B = gVar.B()) == null || (B2 = B()) == null) {
            return true;
        }
        com.sumsub.sns.internal.core.data.source.applicant.remote.a aVar2 = new com.sumsub.sns.internal.core.data.source.applicant.remote.a((com.sumsub.sns.internal.core.data.source.applicant.remote.t) null, new com.sumsub.sns.internal.core.data.source.applicant.remote.q(uri.toString()), (com.sumsub.sns.internal.core.data.source.applicant.remote.j) null, 5, (kotlin.jvm.internal.r) null);
        a(aVar2);
        a(B, B2, aVar2);
        return true;
    }

    public final void a(String str, String str2, com.sumsub.sns.internal.core.data.source.applicant.remote.a aVar) {
        b(true);
        c(false);
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new i(this, str, str2, aVar, (kotlin.coroutines.c<? super i>) null), 3, (Object) null);
    }

    public final void a(e0 e0Var) {
        if (e0Var != null) {
            if (e0Var.t() == EKycFlowStatus.CONFIRMATION_REQUIRED) {
                ConfirmationType l11 = e0Var.l();
                int i11 = l11 == null ? -1 : g.f35451a[l11.ordinal()];
                if (i11 == 1) {
                    c(e0Var);
                } else if (i11 == 2 || i11 == 3) {
                    b(e0Var);
                } else {
                    a(e0Var.t());
                }
            } else {
                a(e0Var.t());
            }
        }
    }

    public final void a(EKycFlowStatus eKycFlowStatus) {
        int i11 = eKycFlowStatus == null ? -1 : g.f35452b[eKycFlowStatus.ordinal()];
        if (i11 == 1 || i11 == 2) {
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (com.sumsub.sns.internal.core.common.q) new q.b(false, 1, (kotlin.jvm.internal.r) null), (Object) null, (Long) null, 6, (Object) null);
        } else if (i11 != 3) {
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (com.sumsub.sns.internal.core.common.q) new q.b(false), (Object) null, (Long) null, 6, (Object) null);
        } else {
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (com.sumsub.sns.internal.core.common.q) new q.b(false), (Object) null, (Long) null, 6, (Object) null);
        }
    }

    public final Object a(f fVar, kotlin.coroutines.c<? super f.a> cVar) {
        f.a aVar = fVar instanceof f.a ? (f.a) fVar : null;
        return aVar == null ? e(cVar) : aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(long r9, kotlin.coroutines.c<? super java.lang.CharSequence> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.o
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$o r0 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.o) r0
            int r1 = r0.f35510e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35510e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$o r0 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$o
            r0.<init>(r8, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f35508c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f35510e
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            long r9 = r0.f35506a
            java.lang.Object r0 = r0.f35507b
            java.lang.String r0 = (java.lang.String) r0
            kotlin.k.b(r11)
            goto L_0x006d
        L_0x002f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0037:
            kotlin.k.b(r11)
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.SECONDS
            long r4 = r11.toMinutes(r9)
            kotlin.jvm.internal.d0 r11 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MINUTES
            long r6 = r2.toSeconds(r4)
            long r9 = r9 - r6
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.a.d(r9)
            r10 = 0
            r11[r10] = r9
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r11, r3)
            java.lang.String r10 = "%02d"
            java.lang.String r9 = java.lang.String.format(r10, r9)
            r0.f35507b = r9
            r0.f35506a = r4
            r0.f35510e = r3
            java.lang.String r10 = "sns_confirmation_code_resendCountdown"
            java.lang.Object r11 = r8.a((java.lang.String) r10, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r11 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r0 = r9
            r9 = r4
        L_0x006d:
            java.lang.String r1 = java.lang.String.valueOf(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            r9 = 58
            r11.append(r9)
            r11.append(r0)
            java.lang.String r3 = r11.toString()
            r4 = 0
            r5 = 4
            r6 = 0
            java.lang.String r2 = "{time}"
            java.lang.String r9 = kotlin.text.StringsKt__StringsJVMKt.G(r1, r2, r3, r4, r5, r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.a(long, kotlin.coroutines.c):java.lang.Object");
    }

    public final Object a(SNSException.Api api, kotlin.coroutines.c<? super String> cVar) {
        if (api.getErrorCode() != null) {
            String description = api.getDescription();
            if (!(description == null || StringsKt__StringsJVMKt.z(description))) {
                return api.getDescription();
            }
        }
        return a(U, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r17, java.lang.String r18, kotlin.coroutines.c<? super java.lang.String> r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r19
            boolean r3 = r2 instanceof com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.m
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$m r3 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.m) r3
            int r4 = r3.f35502f
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f35502f = r4
            goto L_0x001e
        L_0x0019:
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$m r3 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.b$m
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f35500d
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r5 = r3.f35502f
            r6 = 0
            r7 = 0
            r8 = 1
            if (r5 == 0) goto L_0x004a
            if (r5 != r8) goto L_0x0042
            java.lang.Object r1 = r3.f35499c
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r4 = r3.f35498b
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.f35497a
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.b r3 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b) r3
            kotlin.k.b(r2)
            r15 = r2
            r2 = r1
            r1 = r4
            r4 = r3
            r3 = r15
            goto L_0x008a
        L_0x0042:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004a:
            kotlin.k.b(r2)
            if (r1 == 0) goto L_0x00c3
            if (r18 != 0) goto L_0x0053
            goto L_0x00c3
        L_0x0053:
            char[] r10 = new char[r8]
            r2 = 46
            r10[r6] = r2
            r11 = 0
            r12 = 0
            r13 = 6
            r14 = 0
            r9 = r18
            java.util.List r2 = kotlin.text.StringsKt__StringsKt.K0(r9, r10, r11, r12, r13, r14)
            java.lang.String r2 = com.sumsub.sns.internal.core.common.z0.a((java.util.List<java.lang.String>) r2)
            kotlin.jvm.internal.d0 r5 = kotlin.jvm.internal.d0.f56774a
            r5 = 2
            java.lang.Object[] r9 = new java.lang.Object[r5]
            r9[r6] = r1
            r9[r8] = r2
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r9, r5)
            java.lang.String r9 = "sns_ekyc_source_%s::%s"
            java.lang.String r5 = java.lang.String.format(r9, r5)
            r3.f35497a = r0
            r3.f35498b = r1
            r3.f35499c = r2
            r3.f35502f = r8
            java.lang.Object r3 = r0.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r3 != r4) goto L_0x0089
            return r4
        L_0x0089:
            r4 = r0
        L_0x008a:
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x009e
            int r5 = r3.length()
            if (r5 <= 0) goto L_0x0095
            r6 = r8
        L_0x0095:
            if (r6 == 0) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r3 = r7
        L_0x0099:
            if (r3 != 0) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r7 = r3
            goto L_0x00c3
        L_0x009e:
            com.sumsub.sns.internal.domain.c r3 = r4.f35383g0
            if (r3 == 0) goto L_0x00c3
            com.sumsub.sns.internal.core.data.model.e r3 = r3.f()
            if (r3 == 0) goto L_0x00c3
            java.util.Map r3 = r3.x()
            if (r3 == 0) goto L_0x00c3
            java.lang.Object r2 = r3.get(r2)
            com.sumsub.sns.internal.core.data.model.w r2 = (com.sumsub.sns.internal.core.data.model.w) r2
            if (r2 == 0) goto L_0x00c3
            java.util.Map r2 = r2.e()
            if (r2 == 0) goto L_0x00c3
            java.lang.Object r1 = r2.get(r1)
            r7 = r1
            java.lang.String r7 = (java.lang.String) r7
        L_0x00c3:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.a(java.lang.String, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }
}
