package com.sumsub.sns.internal.presentation.screen.questionnary.model;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.m0;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.common.b0;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.o;
import com.sumsub.sns.internal.core.data.source.applicant.remote.u;
import com.sumsub.sns.internal.core.data.source.applicant.remote.w;
import com.sumsub.sns.internal.core.data.source.applicant.remote.y;
import com.sumsub.sns.internal.core.presentation.form.FieldId;
import com.sumsub.sns.internal.core.presentation.form.b;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import com.sumsub.sns.internal.log.LoggerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.k1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v1;

public final class d extends com.sumsub.sns.core.presentation.base.a<C0485d> implements com.sumsub.sns.internal.core.presentation.form.b {
    public static final b H = new b((kotlin.jvm.internal.r) null);
    public static final /* synthetic */ kotlin.reflect.l<Object>[] I;
    public static final String J = "KEY_QUESTIONNAIRE_RESPONSE";
    public static final String K = "KEY_QUESTIONNAIRE_SUBMIT_MODEL";
    public static final String L = "KEY_COUNTRIES_DATA_MODEL";
    public static final String M = "KEY_UPLOADED_FIELDS";
    public static final String N = "KEY_CURRENT_PAGE_NUMBER";
    public static final String O = "QUESTIONNAIRE";
    public static final String P = "QUESTIONNAIRE_SUMMARY";
    public static final String Q = "COUNTRIES_DATA";
    public static final String R = "IDDOCSETTYPE";
    public final com.sumsub.sns.internal.core.presentation.screen.base.a A;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a B;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a C;
    public final b1<b.a> D;
    public d10.l<? super String, String> E;
    public final com.sumsub.sns.internal.core.presentation.form.d F;
    public final Map<FieldId, n1> G;

    /* renamed from: q  reason: collision with root package name */
    public final com.sumsub.sns.internal.domain.i f36241q;

    /* renamed from: r  reason: collision with root package name */
    public final com.sumsub.sns.internal.domain.k f36242r;

    /* renamed from: s  reason: collision with root package name */
    public final com.sumsub.sns.internal.domain.o f36243s;

    /* renamed from: t  reason: collision with root package name */
    public final com.sumsub.sns.internal.domain.d f36244t;

    /* renamed from: u  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.applicant.b f36245u;

    /* renamed from: v  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f36246v;

    /* renamed from: w  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.domain.d f36247w;

    /* renamed from: x  reason: collision with root package name */
    public final String f36248x;

    /* renamed from: y  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f36249y;

    /* renamed from: z  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f36250z;

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.questionnary.model.SNSQuestionnaireViewModel$1", f = "SNSQuestionnaireViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements d10.p<C0485d, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36251a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36252b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f36253c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar, kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
            this.f36253c = dVar;
        }

        /* renamed from: a */
        public final Object invoke(C0485d dVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((a) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f36253c, cVar);
            aVar.f36252b = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36251a == 0) {
                kotlin.k.b(obj);
                C0485d dVar = (C0485d) this.f36252b;
                this.f36253c.D.setValue(new b.a(dVar.f(), dVar.h(), dVar.g(), this.f36253c.p()));
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
            this();
        }

        public b() {
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f36254a;

        /* renamed from: b  reason: collision with root package name */
        public final String f36255b;

        /* renamed from: c  reason: collision with root package name */
        public final String f36256c;

        /* renamed from: d  reason: collision with root package name */
        public final List<FormItem> f36257d;

        public c(int i11, String str, String str2, List<? extends FormItem> list) {
            this.f36254a = i11;
            this.f36255b = str;
            this.f36256c = str2;
            this.f36257d = list;
        }

        public final int a() {
            return this.f36254a;
        }

        public final String b() {
            return this.f36255b;
        }

        public final String c() {
            return this.f36256c;
        }

        public final List<FormItem> d() {
            return this.f36257d;
        }

        public final int e() {
            return this.f36254a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f36254a == cVar.f36254a && x.b(this.f36255b, cVar.f36255b) && x.b(this.f36256c, cVar.f36256c) && x.b(this.f36257d, cVar.f36257d);
        }

        public final List<FormItem> f() {
            return this.f36257d;
        }

        public final String g() {
            return this.f36256c;
        }

        public final String h() {
            return this.f36255b;
        }

        public int hashCode() {
            int i11 = this.f36254a * 31;
            String str = this.f36255b;
            int i12 = 0;
            int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f36256c;
            if (str2 != null) {
                i12 = str2.hashCode();
            }
            return ((hashCode + i12) * 31) + this.f36257d.hashCode();
        }

        public String toString() {
            return "Page(index=" + this.f36254a + ", title=" + this.f36255b + ", subtitle=" + this.f36256c + ", items=" + this.f36257d + ')';
        }

        public final c a(int i11, String str, String str2, List<? extends FormItem> list) {
            return new c(i11, str, str2, list);
        }

        public static /* synthetic */ c a(c cVar, int i11, String str, String str2, List<FormItem> list, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = cVar.f36254a;
            }
            if ((i12 & 2) != 0) {
                str = cVar.f36255b;
            }
            if ((i12 & 4) != 0) {
                str2 = cVar.f36256c;
            }
            if ((i12 & 8) != 0) {
                list = cVar.f36257d;
            }
            return cVar.a(i11, str, str2, list);
        }
    }

    /* renamed from: com.sumsub.sns.internal.presentation.screen.questionnary.model.d$d  reason: collision with other inner class name */
    public static final class C0485d implements a.l {

        /* renamed from: a  reason: collision with root package name */
        public final String f36258a;

        /* renamed from: b  reason: collision with root package name */
        public final int f36259b;

        /* renamed from: c  reason: collision with root package name */
        public final a f36260c;

        /* renamed from: d  reason: collision with root package name */
        public final List<b.C0375b> f36261d;

        /* renamed from: com.sumsub.sns.internal.presentation.screen.questionnary.model.d$d$a */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public final boolean f36262a;

            /* renamed from: b  reason: collision with root package name */
            public final CharSequence f36263b;

            public a(boolean z11, CharSequence charSequence) {
                this.f36262a = z11;
                this.f36263b = charSequence;
            }

            public final boolean a() {
                return this.f36262a;
            }

            public final CharSequence b() {
                return this.f36263b;
            }

            public final boolean c() {
                return this.f36262a;
            }

            public final CharSequence d() {
                return this.f36263b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return this.f36262a == aVar.f36262a && x.b(this.f36263b, aVar.f36263b);
            }

            public int hashCode() {
                boolean z11 = this.f36262a;
                if (z11) {
                    z11 = true;
                }
                int i11 = (z11 ? 1 : 0) * true;
                CharSequence charSequence = this.f36263b;
                return i11 + (charSequence == null ? 0 : charSequence.hashCode());
            }

            public String toString() {
                return "Button(enabled=" + this.f36262a + ", text=" + this.f36263b + ')';
            }

            public final a a(boolean z11, CharSequence charSequence) {
                return new a(z11, charSequence);
            }

            public static /* synthetic */ a a(a aVar, boolean z11, CharSequence charSequence, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    z11 = aVar.f36262a;
                }
                if ((i11 & 2) != 0) {
                    charSequence = aVar.f36263b;
                }
                return aVar.a(z11, charSequence);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ a(boolean z11, CharSequence charSequence, int i11, kotlin.jvm.internal.r rVar) {
                this(z11, (i11 & 2) != 0 ? null : charSequence);
            }
        }

        public C0485d() {
            this((String) null, 0, (a) null, (List) null, 15, (kotlin.jvm.internal.r) null);
        }

        public final String a() {
            return this.f36258a;
        }

        public final int b() {
            return this.f36259b;
        }

        public final a c() {
            return this.f36260c;
        }

        public final List<b.C0375b> d() {
            return this.f36261d;
        }

        public final a e() {
            return this.f36260c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0485d)) {
                return false;
            }
            C0485d dVar = (C0485d) obj;
            return x.b(this.f36258a, dVar.f36258a) && this.f36259b == dVar.f36259b && x.b(this.f36260c, dVar.f36260c) && x.b(this.f36261d, dVar.f36261d);
        }

        public final int f() {
            return this.f36259b;
        }

        public final String g() {
            return this.f36258a;
        }

        public final List<b.C0375b> h() {
            return this.f36261d;
        }

        public int hashCode() {
            String str = this.f36258a;
            int i11 = 0;
            int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.f36259b) * 31;
            a aVar = this.f36260c;
            if (aVar != null) {
                i11 = aVar.hashCode();
            }
            return ((hashCode + i11) * 31) + this.f36261d.hashCode();
        }

        public String toString() {
            return "ViewState(mimeTypes=" + this.f36258a + ", currentPageIndex=" + this.f36259b + ", buttonContinue=" + this.f36260c + ", pages=" + this.f36261d + ')';
        }

        public C0485d(String str, int i11, a aVar, List<b.C0375b> list) {
            this.f36258a = str;
            this.f36259b = i11;
            this.f36260c = aVar;
            this.f36261d = list;
        }

        public final C0485d a(String str, int i11, a aVar, List<b.C0375b> list) {
            return new C0485d(str, i11, aVar, list);
        }

        public static /* synthetic */ C0485d a(C0485d dVar, String str, int i11, a aVar, List<b.C0375b> list, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = dVar.f36258a;
            }
            if ((i12 & 2) != 0) {
                i11 = dVar.f36259b;
            }
            if ((i12 & 4) != 0) {
                aVar = dVar.f36260c;
            }
            if ((i12 & 8) != 0) {
                list = dVar.f36261d;
            }
            return dVar.a(str, i11, aVar, list);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C0485d(String str, int i11, a aVar, List list, int i12, kotlin.jvm.internal.r rVar) {
            this((i12 & 1) != 0 ? null : str, (i12 & 2) != 0 ? 0 : i11, (i12 & 4) != 0 ? null : aVar, (i12 & 8) != 0 ? CollectionsKt__CollectionsKt.k() : list);
        }
    }

    public static final class e extends Lambda implements d10.l<String, String> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f36264a = new e();

        public e() {
            super(1);
        }

        /* renamed from: a */
        public final String invoke(String str) {
            return str;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.questionnary.model.SNSQuestionnaireViewModel", f = "SNSQuestionnaireViewModel.kt", l = {770}, m = "getPickResults")
    public static final class f extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36265a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36266b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36267c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36268d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36269e;

        /* renamed from: f  reason: collision with root package name */
        public /* synthetic */ Object f36270f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f36271g;

        /* renamed from: h  reason: collision with root package name */
        public int f36272h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(d dVar, kotlin.coroutines.c<? super f> cVar) {
            super(cVar);
            this.f36271g = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36270f = obj;
            this.f36272h |= Integer.MIN_VALUE;
            return this.f36271g.a((Context) null, (List<? extends Uri>) null, (String) null, (kotlin.coroutines.c<? super List<com.sumsub.sns.internal.core.data.model.n>>) this);
        }
    }

    public static final class g implements com.sumsub.sns.internal.core.presentation.form.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f36273a;

        public g(d dVar) {
            this.f36273a = dVar;
        }

        public String a(String str, String str2) {
            return c.a(this.f36273a.w(), str, str2);
        }

        public List<String> b(String str, String str2) {
            return c.b(this.f36273a.w(), str, str2);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.questionnary.model.SNSQuestionnaireViewModel", f = "SNSQuestionnaireViewModel.kt", l = {265, 277}, m = "loadCountryData")
    public static final class h extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36274a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36275b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f36276c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f36277d;

        /* renamed from: e  reason: collision with root package name */
        public int f36278e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(d dVar, kotlin.coroutines.c<? super h> cVar) {
            super(cVar);
            this.f36277d = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36276c = obj;
            this.f36278e |= Integer.MIN_VALUE;
            return this.f36277d.e((kotlin.coroutines.c<? super Boolean>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.questionnary.model.SNSQuestionnaireViewModel$loadQuestionnaire$1", f = "SNSQuestionnaireViewModel.kt", l = {213, 217, 225, 232, 243}, m = "invokeSuspend")
    public static final class i extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36279a;

        /* renamed from: b  reason: collision with root package name */
        public int f36280b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f36281c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f36282d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(d dVar, kotlin.coroutines.c<? super i> cVar) {
            super(2, cVar);
            this.f36282d = dVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((i) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            i iVar = new i(this.f36282d, cVar);
            iVar.f36281c = obj;
            return iVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x00a1  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00c9  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00e0  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x010f  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0137  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x015e  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x0199  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x019e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                r0 = r18
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f36280b
                r3 = 0
                java.lang.String r4 = ""
                r5 = 5
                r6 = 4
                r7 = 3
                r8 = 2
                r9 = 0
                r10 = 1
                if (r2 == 0) goto L_0x006d
                if (r2 == r10) goto L_0x0063
                if (r2 == r8) goto L_0x0059
                if (r2 == r7) goto L_0x0048
                if (r2 == r6) goto L_0x0030
                if (r2 != r5) goto L_0x0028
                java.lang.Object r1 = r0.f36279a
                java.lang.Object r2 = r0.f36281c
                kotlin.k.b(r19)
                r4 = r19
                goto L_0x0182
            L_0x0028:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0030:
                java.lang.Object r2 = r0.f36279a
                java.lang.Object r6 = r0.f36281c
                kotlinx.coroutines.h0 r6 = (kotlinx.coroutines.h0) r6
                kotlin.k.b(r19)
                r7 = r19
                kotlin.Result r7 = (kotlin.Result) r7
                java.lang.Object r7 = r7.m3081unboximpl()
                r17 = r7
                r7 = r6
                r6 = r17
                goto L_0x0131
            L_0x0048:
                java.lang.Object r2 = r0.f36281c
                kotlinx.coroutines.h0 r2 = (kotlinx.coroutines.h0) r2
                kotlin.k.b(r19)
                r7 = r19
                kotlin.Result r7 = (kotlin.Result) r7
                java.lang.Object r7 = r7.m3081unboximpl()
                goto L_0x00da
            L_0x0059:
                java.lang.Object r2 = r0.f36281c
                kotlinx.coroutines.h0 r2 = (kotlinx.coroutines.h0) r2
                kotlin.k.b(r19)
                r8 = r19
                goto L_0x009d
            L_0x0063:
                java.lang.Object r2 = r0.f36281c
                kotlinx.coroutines.h0 r2 = (kotlinx.coroutines.h0) r2
                kotlin.k.b(r19)
                r11 = r19
                goto L_0x0081
            L_0x006d:
                kotlin.k.b(r19)
                java.lang.Object r2 = r0.f36281c
                kotlinx.coroutines.h0 r2 = (kotlinx.coroutines.h0) r2
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r11 = r0.f36282d
                r0.f36281c = r2
                r0.f36280b = r10
                java.lang.Object r11 = r11.e((kotlin.coroutines.c<? super java.lang.Boolean>) r0)
                if (r11 != r1) goto L_0x0081
                return r1
            L_0x0081:
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                if (r11 != 0) goto L_0x008c
                kotlin.Unit r1 = kotlin.Unit.f56620a
                return r1
            L_0x008c:
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r11 = r0.f36282d
                com.sumsub.sns.internal.core.data.source.applicant.b r11 = r11.f36245u
                r0.f36281c = r2
                r0.f36280b = r8
                java.lang.Object r8 = r11.c(r0)
                if (r8 != r1) goto L_0x009d
                return r1
            L_0x009d:
                java.lang.String r8 = (java.lang.String) r8
                if (r8 != 0) goto L_0x00c9
                java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
                java.lang.String r1 = "questionnaire id missing"
                r12.<init>(r1)
                com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.String r2 = com.sumsub.sns.internal.log.c.a(r2)
                java.lang.String r3 = r12.getMessage()
                if (r3 != 0) goto L_0x00b5
                goto L_0x00b6
            L_0x00b5:
                r4 = r3
            L_0x00b6:
                r1.e(r2, r4, r12)
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r11 = r0.f36282d
                java.lang.String r13 = r11.f36248x
                r14 = 0
                r15 = 4
                r16 = 0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r11, (java.lang.Throwable) r12, (java.lang.String) r13, (java.lang.Object) r14, (int) r15, (java.lang.Object) r16)
                kotlin.Unit r1 = kotlin.Unit.f56620a
                return r1
            L_0x00c9:
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r11 = r0.f36282d
                com.sumsub.sns.internal.domain.i r11 = r11.f36241q
                r0.f36281c = r2
                r0.f36280b = r7
                java.lang.Object r7 = r11.a(r8, r0)
                if (r7 != r1) goto L_0x00da
                return r1
            L_0x00da:
                boolean r8 = kotlin.Result.m3078isFailureimpl(r7)
                if (r8 == 0) goto L_0x010f
                java.lang.Throwable r12 = kotlin.Result.m3075exceptionOrNullimpl(r7)
                if (r12 == 0) goto L_0x00f5
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r11 = r0.f36282d
                java.lang.String r13 = r11.f36248x
                r14 = 0
                r15 = 4
                r16 = 0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r11, (java.lang.Throwable) r12, (java.lang.String) r13, (java.lang.Object) r14, (int) r15, (java.lang.Object) r16)
                kotlin.Unit r9 = kotlin.Unit.f56620a
            L_0x00f5:
                if (r9 != 0) goto L_0x010c
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r1 = r0.f36282d
                java.lang.Error r2 = new java.lang.Error
                java.lang.String r3 = "Failed loading questionnaire"
                r2.<init>(r3)
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r3 = r0.f36282d
                java.lang.String r3 = r3.f36248x
                r4 = 0
                r5 = 4
                r6 = 0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r1, (java.lang.Throwable) r2, (java.lang.String) r3, (java.lang.Object) r4, (int) r5, (java.lang.Object) r6)
            L_0x010c:
                kotlin.Unit r1 = kotlin.Unit.f56620a
                return r1
            L_0x010f:
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r8 = r0.f36282d
                com.sumsub.sns.internal.core.domain.d r8 = r8.f36247w
                com.sumsub.sns.internal.ff.a r11 = com.sumsub.sns.internal.ff.a.f34215a
                com.sumsub.sns.internal.ff.core.a r11 = r11.n()
                boolean r11 = r11.g()
                r0.f36281c = r2
                r0.f36279a = r7
                r0.f36280b = r6
                java.lang.Object r6 = r8.a(r11, r0)
                if (r6 != r1) goto L_0x012c
                return r1
            L_0x012c:
                r17 = r7
                r7 = r2
                r2 = r17
            L_0x0131:
                boolean r8 = kotlin.Result.m3078isFailureimpl(r6)
                if (r8 == 0) goto L_0x015e
                java.lang.Throwable r1 = kotlin.Result.m3075exceptionOrNullimpl(r2)
                r9 = r1
                java.lang.Exception r9 = (java.lang.Exception) r9
                com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.String r2 = com.sumsub.sns.internal.log.c.a(r7)
                java.lang.String r3 = r9.getMessage()
                if (r3 != 0) goto L_0x014b
                goto L_0x014c
            L_0x014b:
                r4 = r3
            L_0x014c:
                r1.e(r2, r4, r9)
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r8 = r0.f36282d
                java.lang.String r10 = r8.f36248x
                r11 = 0
                r12 = 4
                r13 = 0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r8, (java.lang.Throwable) r9, (java.lang.String) r10, (java.lang.Object) r11, (int) r12, (java.lang.Object) r13)
                kotlin.Unit r1 = kotlin.Unit.f56620a
                return r1
            L_0x015e:
                boolean r4 = kotlin.Result.m3078isFailureimpl(r6)
                if (r4 == 0) goto L_0x0166
                r4 = r9
                goto L_0x0167
            L_0x0166:
                r4 = r6
            L_0x0167:
                com.sumsub.sns.internal.core.domain.e r4 = (com.sumsub.sns.internal.core.domain.e) r4
                if (r4 != 0) goto L_0x016e
                kotlin.Unit r1 = kotlin.Unit.f56620a
                return r1
            L_0x016e:
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r4 = r0.f36282d
                com.sumsub.sns.internal.core.data.source.dynamic.b r4 = r4.f36246v
                r0.f36281c = r2
                r0.f36279a = r6
                r0.f36280b = r5
                java.lang.Object r4 = r4.a((boolean) r3, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.e>) r0)
                if (r4 != r1) goto L_0x0181
                return r1
            L_0x0181:
                r1 = r6
            L_0x0182:
                com.sumsub.sns.internal.core.data.model.e r4 = (com.sumsub.sns.internal.core.data.model.e) r4
                java.util.Map r4 = r4.B()
                kotlin.k.b(r1)
                com.sumsub.sns.internal.core.domain.e r1 = (com.sumsub.sns.internal.core.domain.e) r1
                com.sumsub.sns.internal.core.presentation.form.model.d r5 = new com.sumsub.sns.internal.core.presentation.form.model.d
                r5.<init>(r4, r1)
                boolean r1 = kotlin.Result.m3078isFailureimpl(r2)
                if (r1 == 0) goto L_0x0199
                goto L_0x019a
            L_0x0199:
                r9 = r2
            L_0x019a:
                com.sumsub.sns.internal.domain.i$a r9 = (com.sumsub.sns.internal.domain.i.a) r9
                if (r9 == 0) goto L_0x01b9
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r1 = r0.f36282d
                r1.a((com.sumsub.sns.internal.core.presentation.form.model.d) r5)
                com.sumsub.sns.internal.core.data.source.applicant.remote.y r2 = r9.d()
                if (r2 == 0) goto L_0x01ac
                r1.a((com.sumsub.sns.internal.core.data.source.applicant.remote.y) r2)
            L_0x01ac:
                com.sumsub.sns.internal.core.data.source.applicant.remote.w r2 = r9.c()
                r1.a((com.sumsub.sns.internal.core.data.source.applicant.remote.w) r2)
                r1.b((int) r3)
                r1.c((boolean) r10)
            L_0x01b9:
                kotlin.Unit r1 = kotlin.Unit.f56620a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.questionnary.model.d.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class j extends Lambda implements d10.l<Throwable, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f36283a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(d dVar) {
            super(1);
            this.f36283a = dVar;
        }

        public final void a(Throwable th2) {
            this.f36283a.b(false);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.questionnary.model.SNSQuestionnaireViewModel$onDeleteFile$1", f = "SNSQuestionnaireViewModel.kt", l = {475}, m = "invokeSuspend")
    public static final class k extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36284a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f36285b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FormItem f36286c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f36287d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(d dVar, FormItem formItem, String str, kotlin.coroutines.c<? super k> cVar) {
            super(2, cVar);
            this.f36285b = dVar;
            this.f36286c = formItem;
            this.f36287d = str;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((k) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new k(this.f36285b, this.f36286c, this.f36287d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36284a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                this.f36285b.a(f.a(this.f36286c), this.f36287d, FormItem.ItemState.LOADING);
                com.sumsub.sns.internal.domain.d f11 = this.f36285b.f36244t;
                List e11 = CollectionsKt__CollectionsJVMKt.e(this.f36287d);
                this.f36284a = 1;
                obj2 = f11.a(e11, this);
                if (obj2 == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
                obj2 = ((Result) obj).m3081unboximpl();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (Result.m3078isFailureimpl(obj2)) {
                this.f36285b.a(f.a(this.f36286c), this.f36287d, FormItem.ItemState.DEFAULT);
                this.f36285b.a("Send file error", (Exception) Result.m3075exceptionOrNullimpl(obj2));
                return Unit.f56620a;
            }
            this.f36285b.a(f.a(this.f36286c), this.f36287d, FormItem.ItemState.DEFAULT);
            if (Result.m3078isFailureimpl(obj2)) {
                obj2 = null;
            }
            List list = (List) obj2;
            if (list != null) {
                this.f36285b.b(this.f36286c, (List<String>) list);
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.questionnary.model.SNSQuestionnaireViewModel$onPickedFiles$1", f = "SNSQuestionnaireViewModel.kt", l = {599, 612, 608}, m = "invokeSuspend")
    public static final class l extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36288a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36289b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36290c;

        /* renamed from: d  reason: collision with root package name */
        public int f36291d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f36292e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FieldId f36293f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f36294g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ List<Uri> f36295h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(d dVar, FieldId fieldId, Context context, List<? extends Uri> list, kotlin.coroutines.c<? super l> cVar) {
            super(2, cVar);
            this.f36292e = dVar;
            this.f36293f = fieldId;
            this.f36294g = context;
            this.f36295h = list;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((l) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new l(this.f36292e, this.f36293f, this.f36294g, this.f36295h, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x00e7 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0106  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0112  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r14.f36291d
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L_0x003c
                if (r1 == r4) goto L_0x0032
                if (r1 == r3) goto L_0x001f
                if (r1 != r2) goto L_0x0017
                kotlin.k.b(r15)
                goto L_0x00e8
            L_0x0017:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x001f:
                java.lang.Object r1 = r14.f36290c
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r3 = r14.f36289b
                com.sumsub.sns.internal.core.data.model.Document r3 = (com.sumsub.sns.internal.core.data.model.Document) r3
                java.lang.Object r4 = r14.f36288a
                com.sumsub.sns.internal.domain.o r4 = (com.sumsub.sns.internal.domain.o) r4
                kotlin.k.b(r15)
                r8 = r1
                r7 = r3
                goto L_0x00cb
            L_0x0032:
                kotlin.k.b(r15)
                kotlin.Result r15 = (kotlin.Result) r15
                java.lang.Object r15 = r15.m3081unboximpl()
                goto L_0x004f
            L_0x003c:
                kotlin.k.b(r15)
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r15 = r14.f36292e
                com.sumsub.sns.internal.core.domain.d r15 = r15.f36247w
                r14.f36291d = r4
                r1 = 0
                java.lang.Object r15 = r15.a(r1, r14)
                if (r15 != r0) goto L_0x004f
                return r0
            L_0x004f:
                boolean r1 = kotlin.Result.m3078isFailureimpl(r15)
                if (r1 == 0) goto L_0x0058
                kotlin.Unit r15 = kotlin.Unit.f56620a
                return r15
            L_0x0058:
                boolean r1 = kotlin.Result.m3078isFailureimpl(r15)
                if (r1 == 0) goto L_0x005f
                r15 = r5
            L_0x005f:
                com.sumsub.sns.internal.core.domain.e r15 = (com.sumsub.sns.internal.core.domain.e) r15
                if (r15 != 0) goto L_0x0066
                kotlin.Unit r15 = kotlin.Unit.f56620a
                return r15
            L_0x0066:
                com.sumsub.sns.internal.log.a r6 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r4 = "uploadFiles: "
                r1.append(r4)
                com.sumsub.sns.internal.core.presentation.form.FieldId r4 = r14.f36293f
                r1.append(r4)
                java.lang.String r4 = " ..."
                r1.append(r4)
                java.lang.String r8 = r1.toString()
                r9 = 0
                r10 = 4
                r11 = 0
                java.lang.String r7 = "Questionnaire"
                com.sumsub.log.logger.a.d(r6, r7, r8, r9, r10, r11)
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r1 = r14.f36292e
                java.util.List r4 = r1.v()
                java.util.List r4 = kotlin.collections.CollectionsKt___CollectionsKt.L0(r4)
                com.sumsub.sns.internal.core.presentation.form.FieldId r6 = r14.f36293f
                r4.add(r6)
                r1.a((java.util.List<com.sumsub.sns.internal.core.presentation.form.FieldId>) r4)
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r1 = r14.f36292e
                com.sumsub.sns.internal.domain.o r4 = r1.f36243s
                com.sumsub.sns.internal.core.data.model.Document r1 = new com.sumsub.sns.internal.core.data.model.Document
                com.sumsub.sns.internal.core.data.model.DocumentType r6 = new com.sumsub.sns.internal.core.data.model.DocumentType
                java.lang.String r7 = "QUESTIONNAIRE"
                r6.<init>(r7)
                r1.<init>(r6, r5)
                java.lang.String r6 = r15.i()
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r7 = r14.f36292e
                android.content.Context r8 = r14.f36294g
                java.util.List<android.net.Uri> r9 = r14.f36295h
                java.lang.String r15 = r15.i()
                r14.f36288a = r4
                r14.f36289b = r1
                r14.f36290c = r6
                r14.f36291d = r3
                java.lang.Object r15 = r7.a((android.content.Context) r8, (java.util.List<? extends android.net.Uri>) r9, (java.lang.String) r15, (kotlin.coroutines.c<? super java.util.List<com.sumsub.sns.internal.core.data.model.n>>) r14)
                if (r15 != r0) goto L_0x00c9
                return r0
            L_0x00c9:
                r7 = r1
                r8 = r6
            L_0x00cb:
                r9 = r15
                java.util.List r9 = (java.util.List) r9
                com.sumsub.sns.internal.domain.o$a r15 = new com.sumsub.sns.internal.domain.o$a
                r10 = 0
                r11 = 0
                r12 = 24
                r13 = 0
                r6 = r15
                r6.<init>(r7, r8, r9, r10, r11, r12, r13)
                r14.f36288a = r5
                r14.f36289b = r5
                r14.f36290c = r5
                r14.f36291d = r2
                java.lang.Object r15 = r4.b(r15, r14)
                if (r15 != r0) goto L_0x00e8
                return r0
            L_0x00e8:
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r0 = r14.f36292e
                com.sumsub.sns.internal.core.presentation.form.FieldId r1 = r14.f36293f
                com.sumsub.sns.internal.core.domain.model.a r15 = (com.sumsub.sns.internal.core.domain.model.a) r15
                java.util.List r2 = r0.v()
                java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.L0(r2)
                r2.remove(r1)
                r0.a((java.util.List<com.sumsub.sns.internal.core.presentation.form.FieldId>) r2)
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r0 = r14.f36292e
                com.sumsub.sns.internal.core.presentation.form.FieldId r1 = r14.f36293f
                boolean r2 = r15.b()
                if (r2 == 0) goto L_0x0112
                com.sumsub.sns.internal.core.domain.model.a$b r15 = (com.sumsub.sns.internal.core.domain.model.a.b) r15
                java.lang.Object r15 = r15.d()
                java.util.List r15 = (java.util.List) r15
                r0.a((com.sumsub.sns.internal.core.presentation.form.FieldId) r1, (java.util.List<com.sumsub.sns.internal.core.data.model.remote.k>) r15)
                goto L_0x0138
            L_0x0112:
                boolean r1 = r15.a()
                if (r1 == 0) goto L_0x0138
                com.sumsub.sns.internal.core.domain.model.a$a r15 = (com.sumsub.sns.internal.core.domain.model.a.C0372a) r15
                java.lang.Object r15 = r15.d()
                java.lang.Exception r15 = (java.lang.Exception) r15
                com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.String r2 = "Questionnaire"
                java.lang.String r9 = "Send file error"
                r1.e(r2, r9, r15)
                java.lang.String r5 = r0.f36248x
                r6 = 0
                r7 = 4
                r8 = 0
                r3 = r0
                r4 = r15
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r3, (java.lang.Throwable) r4, (java.lang.String) r5, (java.lang.Object) r6, (int) r7, (java.lang.Object) r8)
                r0.a((java.lang.String) r9, (java.lang.Exception) r15)
            L_0x0138:
                kotlin.Unit r15 = kotlin.Unit.f56620a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.questionnary.model.d.l.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class m extends Lambda implements d10.l<Throwable, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FieldId f36296a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f36297b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(FieldId fieldId, d dVar) {
            super(1);
            this.f36296a = fieldId;
            this.f36297b = dVar;
        }

        public final void a(Throwable th2) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            com.sumsub.log.logger.a.d(aVar, a.f36239b, "stopped job for " + this.f36296a, (Throwable) null, 4, (Object) null);
            this.f36297b.G.remove(this.f36296a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.questionnary.model.SNSQuestionnaireViewModel", f = "SNSQuestionnaireViewModel.kt", l = {162, 174}, m = "onPrepare")
    public static final class n extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36298a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36299b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f36300c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f36301d;

        /* renamed from: e  reason: collision with root package name */
        public int f36302e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(d dVar, kotlin.coroutines.c<? super n> cVar) {
            super(cVar);
            this.f36301d = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36300c = obj;
            this.f36302e |= Integer.MIN_VALUE;
            return this.f36301d.d((kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.questionnary.model.SNSQuestionnaireViewModel$onPrepare$2", f = "SNSQuestionnaireViewModel.kt", l = {166, 169}, m = "invokeSuspend")
    public static final class o extends SuspendLambda implements d10.p<C0485d, kotlin.coroutines.c<? super C0485d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36303a;

        /* renamed from: b  reason: collision with root package name */
        public int f36304b;

        /* renamed from: c  reason: collision with root package name */
        public int f36305c;

        /* renamed from: d  reason: collision with root package name */
        public int f36306d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f36307e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f36308f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(d dVar, kotlin.coroutines.c<? super o> cVar) {
            super(2, cVar);
            this.f36308f = dVar;
        }

        /* renamed from: a */
        public final Object invoke(C0485d dVar, kotlin.coroutines.c<? super C0485d> cVar) {
            return ((o) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            o oVar = new o(this.f36308f, cVar);
            oVar.f36307e = obj;
            return oVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r12.f36306d
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L_0x0032
                if (r1 == r4) goto L_0x0029
                if (r1 != r2) goto L_0x0021
                int r0 = r12.f36305c
                int r1 = r12.f36304b
                java.lang.Object r2 = r12.f36303a
                java.lang.String r2 = (java.lang.String) r2
                java.lang.Object r5 = r12.f36307e
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d$d r5 = (com.sumsub.sns.internal.presentation.screen.questionnary.model.d.C0485d) r5
                kotlin.k.b(r13)
                r7 = r1
                r6 = r2
                goto L_0x0078
            L_0x0021:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x0029:
                java.lang.Object r1 = r12.f36307e
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d$d r1 = (com.sumsub.sns.internal.presentation.screen.questionnary.model.d.C0485d) r1
                kotlin.k.b(r13)
                r5 = r1
                goto L_0x004a
            L_0x0032:
                kotlin.k.b(r13)
                java.lang.Object r13 = r12.f36307e
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d$d r13 = (com.sumsub.sns.internal.presentation.screen.questionnary.model.d.C0485d) r13
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r1 = r12.f36308f
                r12.f36307e = r13
                r12.f36306d = r4
                java.lang.String r5 = "sns_questionnaire_mime_types"
                java.lang.Object r1 = r1.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r12)
                if (r1 != r0) goto L_0x0048
                return r0
            L_0x0048:
                r5 = r13
                r13 = r1
            L_0x004a:
                r1 = r13
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto L_0x0058
                boolean r1 = kotlin.text.StringsKt__StringsJVMKt.z(r1)
                r1 = r1 ^ r4
                if (r1 != r4) goto L_0x0058
                r1 = r4
                goto L_0x0059
            L_0x0058:
                r1 = r3
            L_0x0059:
                if (r1 == 0) goto L_0x005c
                goto L_0x005d
            L_0x005c:
                r13 = 0
            L_0x005d:
                java.lang.String r13 = (java.lang.String) r13
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r1 = r12.f36308f
                r12.f36307e = r5
                r12.f36303a = r13
                r12.f36304b = r3
                r12.f36305c = r4
                r12.f36306d = r2
                java.lang.String r2 = "sns_quiestionnaire_action_continue"
                java.lang.Object r1 = r1.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r12)
                if (r1 != r0) goto L_0x0074
                return r0
            L_0x0074:
                r6 = r13
                r13 = r1
                r7 = r3
                r0 = r4
            L_0x0078:
                java.lang.CharSequence r13 = (java.lang.CharSequence) r13
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d$d$a r8 = new com.sumsub.sns.internal.presentation.screen.questionnary.model.d$d$a
                if (r0 == 0) goto L_0x007f
                r3 = r4
            L_0x007f:
                r8.<init>(r3, r13)
                r9 = 0
                r10 = 10
                r11 = 0
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d$d r13 = com.sumsub.sns.internal.presentation.screen.questionnary.model.d.C0485d.a(r5, r6, r7, r8, r9, r10, r11)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.questionnary.model.d.o.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.questionnary.model.SNSQuestionnaireViewModel$sendLog$1", f = "SNSQuestionnaireViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class p extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36309a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36310b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f36311c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Exception f36312d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(String str, Exception exc, kotlin.coroutines.c<? super p> cVar) {
            super(2, cVar);
            this.f36311c = str;
            this.f36312d = exc;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((p) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            p pVar = new p(this.f36311c, this.f36312d, cVar);
            pVar.f36310b = obj;
            return pVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36309a == 0) {
                kotlin.k.b(obj);
                com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA).e(com.sumsub.sns.internal.log.c.a((h0) this.f36310b), this.f36311c, this.f36312d);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.questionnary.model.SNSQuestionnaireViewModel$showPageWithIndex$2", f = "SNSQuestionnaireViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class q extends SuspendLambda implements d10.p<C0485d, kotlin.coroutines.c<? super C0485d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36313a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36314b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f36315c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List<b.C0375b> f36316d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f36317e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(d dVar, List<b.C0375b> list, boolean z11, kotlin.coroutines.c<? super q> cVar) {
            super(2, cVar);
            this.f36315c = dVar;
            this.f36316d = list;
            this.f36317e = z11;
        }

        /* renamed from: a */
        public final Object invoke(C0485d dVar, kotlin.coroutines.c<? super C0485d> cVar) {
            return ((q) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            q qVar = new q(this.f36315c, this.f36316d, this.f36317e, cVar);
            qVar.f36314b = obj;
            return qVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36313a == 0) {
                kotlin.k.b(obj);
                C0485d dVar = (C0485d) this.f36314b;
                int d11 = this.f36315c.r();
                C0485d.a e11 = dVar.e();
                return C0485d.a(dVar, (String) null, d11, e11 != null ? e11.a(this.f36317e, e11.d()) : null, this.f36316d, 1, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.questionnary.model.SNSQuestionnaireViewModel$submitForm$1", f = "SNSQuestionnaireViewModel.kt", l = {292}, m = "invokeSuspend")
    public static final class r extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36318a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f36319b;

        /* renamed from: c  reason: collision with root package name */
        public int f36320c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f36321d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f36322e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f36323f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f36324g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(d dVar, String str, boolean z11, kotlin.coroutines.c<? super r> cVar) {
            super(2, cVar);
            this.f36322e = dVar;
            this.f36323f = str;
            this.f36324g = z11;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((r) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            r rVar = new r(this.f36322e, this.f36323f, this.f36324g, cVar);
            rVar.f36321d = obj;
            return rVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:50:0x00d4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r11.f36320c
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L_0x002f
                if (r1 != r2) goto L_0x0027
                boolean r0 = r11.f36319b
                java.lang.Object r1 = r11.f36318a
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r1 = (com.sumsub.sns.internal.presentation.screen.questionnary.model.d) r1
                java.lang.Object r2 = r11.f36321d
                kotlinx.coroutines.h0 r2 = (kotlinx.coroutines.h0) r2
                kotlin.k.b(r12)     // Catch:{ Exception -> 0x0021 }
                kotlin.Result r12 = (kotlin.Result) r12     // Catch:{ Exception -> 0x0021 }
                java.lang.Object r12 = r12.m3081unboximpl()     // Catch:{ Exception -> 0x0021 }
                goto L_0x0086
            L_0x0021:
                r12 = move-exception
                r10 = r2
                r2 = r12
                r12 = r10
                goto L_0x00c8
            L_0x0027:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x002f:
                kotlin.k.b(r12)
                java.lang.Object r12 = r11.f36321d
                kotlinx.coroutines.h0 r12 = (kotlinx.coroutines.h0) r12
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r1 = r11.f36322e     // Catch:{ Exception -> 0x00c6 }
                com.sumsub.sns.internal.core.data.source.applicant.remote.y r1 = r1.u()     // Catch:{ Exception -> 0x00c6 }
                if (r1 == 0) goto L_0x00e5
                java.util.List r1 = r1.e()     // Catch:{ Exception -> 0x00c6 }
                if (r1 == 0) goto L_0x00e5
                java.lang.String r4 = r11.f36323f     // Catch:{ Exception -> 0x00c6 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00c6 }
            L_0x004a:
                boolean r5 = r1.hasNext()     // Catch:{ Exception -> 0x00c6 }
                if (r5 == 0) goto L_0x0062
                java.lang.Object r5 = r1.next()     // Catch:{ Exception -> 0x00c6 }
                r6 = r5
                com.sumsub.sns.internal.core.data.source.applicant.remote.u r6 = (com.sumsub.sns.internal.core.data.source.applicant.remote.u) r6     // Catch:{ Exception -> 0x00c6 }
                java.lang.String r6 = r6.c()     // Catch:{ Exception -> 0x00c6 }
                boolean r6 = kotlin.jvm.internal.x.b(r6, r4)     // Catch:{ Exception -> 0x00c6 }
                if (r6 == 0) goto L_0x004a
                goto L_0x0063
            L_0x0062:
                r5 = r3
            L_0x0063:
                com.sumsub.sns.internal.core.data.source.applicant.remote.u r5 = (com.sumsub.sns.internal.core.data.source.applicant.remote.u) r5     // Catch:{ Exception -> 0x00c6 }
                if (r5 == 0) goto L_0x00e5
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r1 = r11.f36322e     // Catch:{ Exception -> 0x00c6 }
                boolean r4 = r11.f36324g     // Catch:{ Exception -> 0x00c6 }
                com.sumsub.sns.internal.domain.k r6 = r1.f36242r     // Catch:{ Exception -> 0x00c6 }
                com.sumsub.sns.internal.core.data.source.applicant.b r7 = r1.f36245u     // Catch:{ Exception -> 0x00c6 }
                r11.f36321d = r12     // Catch:{ Exception -> 0x00c6 }
                r11.f36318a = r1     // Catch:{ Exception -> 0x00c6 }
                r11.f36319b = r4     // Catch:{ Exception -> 0x00c6 }
                r11.f36320c = r2     // Catch:{ Exception -> 0x00c6 }
                java.lang.Object r2 = r6.a(r7, r5, r11)     // Catch:{ Exception -> 0x00c6 }
                if (r2 != r0) goto L_0x0082
                return r0
            L_0x0082:
                r0 = r4
                r10 = r2
                r2 = r12
                r12 = r10
            L_0x0086:
                boolean r4 = kotlin.Result.m3078isFailureimpl(r12)     // Catch:{ Exception -> 0x0021 }
                if (r4 == 0) goto L_0x00b6
                java.lang.Throwable r5 = kotlin.Result.m3075exceptionOrNullimpl(r12)     // Catch:{ Exception -> 0x0021 }
                if (r5 == 0) goto L_0x009f
                java.lang.String r6 = r1.f36248x     // Catch:{ Exception -> 0x0021 }
                r7 = 0
                r8 = 4
                r9 = 0
                r4 = r1
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r4, (java.lang.Throwable) r5, (java.lang.String) r6, (java.lang.Object) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x0021 }
                kotlin.Unit r3 = kotlin.Unit.f56620a     // Catch:{ Exception -> 0x0021 }
            L_0x009f:
                if (r3 != 0) goto L_0x00b3
                java.lang.Error r5 = new java.lang.Error     // Catch:{ Exception -> 0x0021 }
                java.lang.String r12 = "Failed submitting questionnaire"
                r5.<init>(r12)     // Catch:{ Exception -> 0x0021 }
                java.lang.String r6 = r1.f36248x     // Catch:{ Exception -> 0x0021 }
                r7 = 0
                r8 = 4
                r9 = 0
                r4 = r1
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r4, (java.lang.Throwable) r5, (java.lang.String) r6, (java.lang.Object) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x0021 }
            L_0x00b3:
                kotlin.Unit r12 = kotlin.Unit.f56620a     // Catch:{ Exception -> 0x0021 }
                return r12
            L_0x00b6:
                boolean r4 = kotlin.Result.m3078isFailureimpl(r12)     // Catch:{ Exception -> 0x0021 }
                if (r4 == 0) goto L_0x00bd
                goto L_0x00be
            L_0x00bd:
                r3 = r12
            L_0x00be:
                com.sumsub.sns.internal.core.data.source.applicant.remote.w r3 = (com.sumsub.sns.internal.core.data.source.applicant.remote.w) r3     // Catch:{ Exception -> 0x0021 }
                if (r3 == 0) goto L_0x00e5
                r1.d((boolean) r0)     // Catch:{ Exception -> 0x0021 }
                goto L_0x00e5
            L_0x00c6:
                r0 = move-exception
                r2 = r0
            L_0x00c8:
                com.sumsub.sns.internal.log.a r0 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.String r12 = com.sumsub.sns.internal.log.c.a(r12)
                java.lang.String r1 = r2.getMessage()
                if (r1 != 0) goto L_0x00d6
                java.lang.String r1 = ""
            L_0x00d6:
                r0.e(r12, r1, r2)
                com.sumsub.sns.internal.presentation.screen.questionnary.model.d r1 = r11.f36322e
                java.lang.String r3 = r1.f36248x
                r4 = 0
                r5 = 4
                r6 = 0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r1, (java.lang.Throwable) r2, (java.lang.String) r3, (java.lang.Object) r4, (int) r5, (java.lang.Object) r6)
            L_0x00e5:
                kotlin.Unit r12 = kotlin.Unit.f56620a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.questionnary.model.d.r.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.questionnary.model.SNSQuestionnaireViewModel$updateFileAttachmentFieldItemStateWithId$1", f = "SNSQuestionnaireViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class s extends SuspendLambda implements d10.p<C0485d, kotlin.coroutines.c<? super C0485d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36325a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36326b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List<b.C0375b> f36327c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f36328d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(List<b.C0375b> list, boolean z11, kotlin.coroutines.c<? super s> cVar) {
            super(2, cVar);
            this.f36327c = list;
            this.f36328d = z11;
        }

        /* renamed from: a */
        public final Object invoke(C0485d dVar, kotlin.coroutines.c<? super C0485d> cVar) {
            return ((s) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            s sVar = new s(this.f36327c, this.f36328d, cVar);
            sVar.f36326b = obj;
            return sVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36325a == 0) {
                kotlin.k.b(obj);
                C0485d dVar = (C0485d) this.f36326b;
                C0485d.a e11 = dVar.e();
                return C0485d.a(dVar, (String) null, 0, e11 != null ? e11.a(this.f36328d, e11.d()) : null, this.f36327c, 3, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.questionnary.model.SNSQuestionnaireViewModel$updateFileAttachmentFieldStateWithId$1", f = "SNSQuestionnaireViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class t extends SuspendLambda implements d10.p<C0485d, kotlin.coroutines.c<? super C0485d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36329a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36330b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List<b.C0375b> f36331c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f36332d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(List<b.C0375b> list, boolean z11, kotlin.coroutines.c<? super t> cVar) {
            super(2, cVar);
            this.f36331c = list;
            this.f36332d = z11;
        }

        /* renamed from: a */
        public final Object invoke(C0485d dVar, kotlin.coroutines.c<? super C0485d> cVar) {
            return ((t) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            t tVar = new t(this.f36331c, this.f36332d, cVar);
            tVar.f36330b = obj;
            return tVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36329a == 0) {
                kotlin.k.b(obj);
                C0485d dVar = (C0485d) this.f36330b;
                C0485d.a e11 = dVar.e();
                return C0485d.a(dVar, (String) null, 0, e11 != null ? e11.a(this.f36332d, e11.d()) : null, this.f36331c, 3, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Class<d> cls = d.class;
        I = new kotlin.reflect.l[]{Reflection.e(new MutablePropertyReference1Impl(cls, "questionnaireResponseDelegate", "getQuestionnaireResponseDelegate()Lcom/sumsub/sns/internal/core/data/source/applicant/remote/QuestionnaireResponse;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "submitModelDelegate", "getSubmitModelDelegate()Lcom/sumsub/sns/internal/core/data/source/applicant/remote/QuestionnaireSubmitModel;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "countriesDataDelegate", "getCountriesDataDelegate()Lcom/sumsub/sns/internal/core/presentation/form/model/CountriesData;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "currentPageIndex", "getCurrentPageIndex()I", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "uploadingFields", "getUploadingFields()Ljava/util/List;", 0))};
    }

    public d(SavedStateHandle savedStateHandle, com.sumsub.sns.internal.domain.i iVar, com.sumsub.sns.internal.domain.k kVar, com.sumsub.sns.internal.domain.o oVar, com.sumsub.sns.internal.domain.d dVar, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.applicant.b bVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar2, com.sumsub.sns.internal.core.domain.d dVar2, w wVar, y yVar, com.sumsub.sns.internal.core.presentation.form.model.d dVar3) {
        super(aVar, bVar2);
        this.f36241q = iVar;
        this.f36242r = kVar;
        this.f36243s = oVar;
        this.f36244t = dVar;
        this.f36245u = bVar;
        this.f36246v = bVar2;
        this.f36247w = dVar2;
        String str = (String) savedStateHandle.f(R);
        this.f36248x = str == null ? DocumentType.f32355j : str;
        this.f36249y = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, J, wVar);
        this.f36250z = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, K, yVar);
        this.A = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, L, dVar3);
        this.B = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, N, 0);
        this.C = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, M, CollectionsKt__CollectionsKt.k());
        this.D = k1.a(new b.a(0, CollectionsKt__CollectionsKt.k(), (String) null, new b.c((String) null, (String) null, 3, (kotlin.jvm.internal.r) null)));
        this.E = e.f36264a;
        b0.b(j(), m0.a(this), new a(this, (kotlin.coroutines.c<? super a>) null));
        this.F = new g(this);
        this.G = new LinkedHashMap();
    }

    public final void A() {
        b(true);
        e(true);
        b(false);
    }

    public final void B() {
        b(r());
    }

    public final void C() {
        a(r() + 1);
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        com.sumsub.log.logger.a.d(aVar, a.f36239b, "showNextPage: " + r(), (Throwable) null, 4, (Object) null);
        b(r());
        c(true);
    }

    public final void D() {
        a(r() - 1);
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        com.sumsub.log.logger.a.d(aVar, a.f36239b, "showPreviousPage: " + r(), (Throwable) null, 4, (Object) null);
        b(r());
        c(false);
    }

    public final b.c p() {
        return new b.c(h().a(n0.j.f32208h), h().a(n0.j.f32207g));
    }

    public final com.sumsub.sns.internal.core.presentation.form.model.d q() {
        return (com.sumsub.sns.internal.core.presentation.form.model.d) this.A.a(this, I[2]);
    }

    public final int r() {
        return ((Number) this.B.a(this, I[3])).intValue();
    }

    /* renamed from: s */
    public C0485d e() {
        return new C0485d((String) null, 0, (C0485d.a) null, (List) null, 15, (kotlin.jvm.internal.r) null);
    }

    public final w t() {
        return (w) this.f36249y.a(this, I[0]);
    }

    public final y u() {
        return (y) this.f36250z.a(this, I[1]);
    }

    public final List<FieldId> v() {
        return (List) this.C.a(this, I[4]);
    }

    public final u w() {
        List<u> e11;
        T t11;
        w t12 = t();
        String o11 = t12 != null ? t12.o() : null;
        y u11 = u();
        if (!(u11 == null || (e11 = u11.e()) == null)) {
            Iterator<T> it2 = e11.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t11 = null;
                    break;
                }
                t11 = it2.next();
                if (x.b(((u) t11).c(), o11)) {
                    break;
                }
            }
            u uVar = (u) t11;
            if (uVar != null) {
                return uVar;
            }
        }
        return new u(o11, (Map) null, 2, (kotlin.jvm.internal.r) null);
    }

    public final boolean x() {
        boolean z11 = false;
        if (r() == 0) {
            return false;
        }
        if (r() > 0) {
            z11 = true;
        }
        if (z11) {
            D();
            return true;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final List<b.C0375b> y() {
        w t11;
        com.sumsub.sns.internal.core.presentation.form.model.d q11 = q();
        if (q11 == null || (t11 = t()) == null) {
            return null;
        }
        return b.a(t11, q11, u(), h().d(), this.E);
    }

    public final void z() {
        b(true);
        kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new i(this, (kotlin.coroutines.c<? super i>) null), 3, (Object) null).L(new j(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x0100 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(boolean r14) {
        /*
            r13 = this;
            kotlinx.coroutines.flow.f1 r0 = r13.j()
            java.util.List r0 = r0.a()
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r0)
            com.sumsub.sns.internal.presentation.screen.questionnary.model.d$d r0 = (com.sumsub.sns.internal.presentation.screen.questionnary.model.d.C0485d) r0
            if (r0 == 0) goto L_0x0173
            java.util.List r0 = r0.h()
            if (r0 != 0) goto L_0x0018
            goto L_0x0173
        L_0x0018:
            int r1 = r0.size()
            int r2 = r13.r()
            if (r1 > r2) goto L_0x0033
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r14 = "Empty questionnaire"
            r4.<init>(r14)
            java.lang.String r5 = r13.f36248x
            r6 = 0
            r7 = 4
            r8 = 0
            r3 = r13
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r3, (java.lang.Throwable) r4, (java.lang.String) r5, (java.lang.Object) r6, (int) r7, (java.lang.Object) r8)
            return
        L_0x0033:
            int r1 = r13.r()
            java.lang.Object r1 = r0.get(r1)
            com.sumsub.sns.internal.core.presentation.form.b$b r1 = (com.sumsub.sns.internal.core.presentation.form.b.C0375b) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r3 = r0.iterator()
        L_0x0046:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x005a
            java.lang.Object r4 = r3.next()
            com.sumsub.sns.internal.core.presentation.form.b$b r4 = (com.sumsub.sns.internal.core.presentation.form.b.C0375b) r4
            java.util.List r4 = r4.f()
            boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.A(r2, r4)
            goto L_0x0046
        L_0x005a:
            com.sumsub.sns.internal.core.presentation.form.model.b r3 = com.sumsub.sns.internal.core.presentation.form.model.b.f33832a
            com.sumsub.sns.internal.core.presentation.form.d r4 = r13.a()
            com.sumsub.sns.internal.core.presentation.form.model.b$a r2 = r3.a(r2, r4)
            java.util.List r3 = r1.f()
            boolean r4 = r3 instanceof java.util.Collection
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x0076
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0076
            goto L_0x0102
        L_0x0076:
            java.util.Iterator r3 = r3.iterator()
        L_0x007a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0102
            java.lang.Object r4 = r3.next()
            com.sumsub.sns.internal.core.presentation.form.model.FormItem r4 = (com.sumsub.sns.internal.core.presentation.form.model.FormItem) r4
            boolean r7 = r4 instanceof com.sumsub.sns.internal.core.presentation.form.model.FormItem.l
            if (r7 == 0) goto L_0x00b7
            java.util.Set r7 = r2.d()
            boolean r8 = r7 instanceof java.util.Collection
            if (r8 == 0) goto L_0x0099
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L_0x0099
            goto L_0x00fd
        L_0x0099:
            java.util.Iterator r7 = r7.iterator()
        L_0x009d:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00fd
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            r9 = r4
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$l r9 = (com.sumsub.sns.internal.core.presentation.form.model.FormItem.l) r9
            java.lang.String r9 = r9.e()
            boolean r8 = kotlin.jvm.internal.x.b(r8, r9)
            if (r8 == 0) goto L_0x009d
            goto L_0x00fb
        L_0x00b7:
            java.util.Set r7 = r2.c()
            boolean r8 = r7 instanceof java.util.Collection
            if (r8 == 0) goto L_0x00c6
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L_0x00c6
            goto L_0x00fd
        L_0x00c6:
            java.util.Iterator r7 = r7.iterator()
        L_0x00ca:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00fd
            java.lang.Object r8 = r7.next()
            com.sumsub.sns.internal.core.presentation.form.FieldId r8 = (com.sumsub.sns.internal.core.presentation.form.FieldId) r8
            java.lang.String r9 = r8.getSectionId()
            java.lang.String r10 = r4.e()
            boolean r9 = kotlin.jvm.internal.x.b(r9, r10)
            if (r9 == 0) goto L_0x00f8
            java.lang.String r8 = r8.getItemId()
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r9 = r4.d()
            java.lang.String r9 = r9.p()
            boolean r8 = kotlin.jvm.internal.x.b(r8, r9)
            if (r8 == 0) goto L_0x00f8
            r8 = r6
            goto L_0x00f9
        L_0x00f8:
            r8 = r5
        L_0x00f9:
            if (r8 == 0) goto L_0x00ca
        L_0x00fb:
            r4 = r6
            goto L_0x00fe
        L_0x00fd:
            r4 = r5
        L_0x00fe:
            if (r4 != 0) goto L_0x007a
            r2 = r5
            goto L_0x0103
        L_0x0102:
            r2 = r6
        L_0x0103:
            if (r2 != 0) goto L_0x0112
            java.util.List r1 = r1.f()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0110
            goto L_0x0112
        L_0x0110:
            r1 = r5
            goto L_0x0113
        L_0x0112:
            r1 = r6
        L_0x0113:
            if (r1 != 0) goto L_0x0116
            return
        L_0x0116:
            com.sumsub.sns.internal.log.a r7 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r2 = r13.r()
            r1.append(r2)
            java.lang.String r2 = " page is empty"
            r1.append(r2)
            java.lang.String r9 = r1.toString()
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r8 = "Questionnaire"
            com.sumsub.log.logger.a.d(r7, r8, r9, r10, r11, r12)
            int r1 = r13.r()
            int r0 = kotlin.collections.CollectionsKt__CollectionsKt.m(r0)
            if (r1 != r0) goto L_0x0141
            r0 = r6
            goto L_0x0142
        L_0x0141:
            r0 = r5
        L_0x0142:
            int r1 = r13.r()
            if (r1 != 0) goto L_0x0149
            r5 = r6
        L_0x0149:
            if (r0 != 0) goto L_0x0151
            if (r14 == 0) goto L_0x0151
            r13.C()
            goto L_0x0173
        L_0x0151:
            if (r5 == 0) goto L_0x0160
            if (r14 != 0) goto L_0x0160
            com.sumsub.sns.internal.core.common.q$a r8 = com.sumsub.sns.internal.core.common.q.a.f32249b
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            r7 = r13
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r7, (com.sumsub.sns.internal.core.common.q) r8, (java.lang.Object) r9, (java.lang.Long) r10, (int) r11, (java.lang.Object) r12)
            goto L_0x0173
        L_0x0160:
            if (r14 != 0) goto L_0x0166
            r13.D()
            goto L_0x0173
        L_0x0166:
            com.sumsub.sns.internal.core.common.q$b r1 = new com.sumsub.sns.internal.core.common.q$b
            r1.<init>(r6)
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            r0 = r13
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r0, (com.sumsub.sns.internal.core.common.q) r1, (java.lang.Object) r2, (java.lang.Long) r3, (int) r4, (java.lang.Object) r5)
        L_0x0173:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.questionnary.model.d.c(boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object d(kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.sumsub.sns.internal.presentation.screen.questionnary.model.d.n
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.sumsub.sns.internal.presentation.screen.questionnary.model.d$n r0 = (com.sumsub.sns.internal.presentation.screen.questionnary.model.d.n) r0
            int r1 = r0.f36302e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36302e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.questionnary.model.d$n r0 = new com.sumsub.sns.internal.presentation.screen.questionnary.model.d$n
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f36300c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36302e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r1 = r0.f36299b
            com.sumsub.sns.internal.presentation.screen.questionnary.model.d r1 = (com.sumsub.sns.internal.presentation.screen.questionnary.model.d) r1
            java.lang.Object r0 = r0.f36298a
            com.sumsub.sns.internal.presentation.screen.questionnary.model.d r0 = (com.sumsub.sns.internal.presentation.screen.questionnary.model.d) r0
            kotlin.k.b(r8)
            goto L_0x006e
        L_0x0034:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003c:
            java.lang.Object r2 = r0.f36298a
            com.sumsub.sns.internal.presentation.screen.questionnary.model.d r2 = (com.sumsub.sns.internal.presentation.screen.questionnary.model.d) r2
            kotlin.k.b(r8)
            goto L_0x0053
        L_0x0044:
            kotlin.k.b(r8)
            r0.f36298a = r7
            r0.f36302e = r4
            java.lang.Object r8 = super.d((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r8 != r1) goto L_0x0052
            return r1
        L_0x0052:
            r2 = r7
        L_0x0053:
            com.sumsub.sns.internal.presentation.screen.questionnary.model.d$o r8 = new com.sumsub.sns.internal.presentation.screen.questionnary.model.d$o
            r5 = 0
            r8.<init>(r2, r5)
            r6 = 0
            com.sumsub.sns.core.presentation.base.a.a(r2, r6, r8, r4, r5)
            com.sumsub.sns.internal.core.data.source.applicant.b r8 = r2.f36245u
            r0.f36298a = r2
            r0.f36299b = r2
            r0.f36302e = r3
            java.lang.Object r8 = r8.a(r0)
            if (r8 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r0 = r2
            r1 = r0
        L_0x006e:
            d10.l r8 = (d10.l) r8
            r1.E = r8
            com.sumsub.sns.internal.core.data.source.applicant.remote.w r8 = r0.t()
            if (r8 != 0) goto L_0x007c
            r0.z()
            goto L_0x00ac
        L_0x007c:
            java.util.List r8 = r0.v()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x0089:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x00a2
            java.lang.Object r2 = r8.next()
            r3 = r2
            com.sumsub.sns.internal.core.presentation.form.FieldId r3 = (com.sumsub.sns.internal.core.presentation.form.FieldId) r3
            java.util.Map<com.sumsub.sns.internal.core.presentation.form.FieldId, kotlinx.coroutines.n1> r4 = r0.G
            boolean r3 = r4.containsKey(r3)
            if (r3 == 0) goto L_0x0089
            r1.add(r2)
            goto L_0x0089
        L_0x00a2:
            r0.a((java.util.List<com.sumsub.sns.internal.core.presentation.form.FieldId>) r1)
            int r8 = r0.r()
            r0.b((int) r8)
        L_0x00ac:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.questionnary.model.d.d(kotlin.coroutines.c):java.lang.Object");
    }

    public j1<b.a> b() {
        return this.D;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(kotlin.coroutines.c<? super java.lang.Boolean> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.sumsub.sns.internal.presentation.screen.questionnary.model.d.h
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.sumsub.sns.internal.presentation.screen.questionnary.model.d$h r0 = (com.sumsub.sns.internal.presentation.screen.questionnary.model.d.h) r0
            int r1 = r0.f36278e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36278e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.questionnary.model.d$h r0 = new com.sumsub.sns.internal.presentation.screen.questionnary.model.d$h
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f36276c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36278e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004a
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r1 = r0.f36275b
            java.lang.Object r0 = r0.f36274a
            com.sumsub.sns.internal.presentation.screen.questionnary.model.d r0 = (com.sumsub.sns.internal.presentation.screen.questionnary.model.d) r0
            kotlin.k.b(r13)
            goto L_0x00b5
        L_0x0033:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x003b:
            java.lang.Object r2 = r0.f36274a
            com.sumsub.sns.internal.presentation.screen.questionnary.model.d r2 = (com.sumsub.sns.internal.presentation.screen.questionnary.model.d) r2
            kotlin.k.b(r13)
            kotlin.Result r13 = (kotlin.Result) r13
            java.lang.Object r13 = r13.m3081unboximpl()
            r5 = r2
            goto L_0x0065
        L_0x004a:
            kotlin.k.b(r13)
            com.sumsub.sns.internal.core.domain.d r13 = r12.f36247w
            com.sumsub.sns.internal.ff.a r2 = com.sumsub.sns.internal.ff.a.f34215a
            com.sumsub.sns.internal.ff.core.a r2 = r2.n()
            boolean r2 = r2.g()
            r0.f36274a = r12
            r0.f36278e = r4
            java.lang.Object r13 = r13.a(r2, r0)
            if (r13 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r5 = r12
        L_0x0065:
            boolean r2 = kotlin.Result.m3078isFailureimpl(r13)
            r11 = 0
            if (r2 == 0) goto L_0x0091
            java.lang.Throwable r13 = kotlin.Result.m3075exceptionOrNullimpl(r13)
            r6 = r13
            java.lang.Exception r6 = (java.lang.Exception) r6
            com.sumsub.sns.internal.log.a r13 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r0 = com.sumsub.sns.internal.log.c.a(r5)
            java.lang.String r1 = r6.getMessage()
            if (r1 != 0) goto L_0x0081
            java.lang.String r1 = ""
        L_0x0081:
            r13.e(r0, r1, r6)
            java.lang.String r7 = r5.f36248x
            r8 = 0
            r9 = 4
            r10 = 0
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r5, (java.lang.Throwable) r6, (java.lang.String) r7, (java.lang.Object) r8, (int) r9, (java.lang.Object) r10)
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.a.a(r11)
            return r13
        L_0x0091:
            boolean r2 = kotlin.Result.m3078isFailureimpl(r13)
            if (r2 == 0) goto L_0x0099
            r2 = 0
            goto L_0x009a
        L_0x0099:
            r2 = r13
        L_0x009a:
            com.sumsub.sns.internal.core.domain.e r2 = (com.sumsub.sns.internal.core.domain.e) r2
            if (r2 != 0) goto L_0x00a3
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.a.a(r11)
            return r13
        L_0x00a3:
            com.sumsub.sns.internal.core.data.source.dynamic.b r2 = r5.f36246v
            r0.f36274a = r5
            r0.f36275b = r13
            r0.f36278e = r3
            java.lang.Object r0 = r2.a((boolean) r11, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.e>) r0)
            if (r0 != r1) goto L_0x00b2
            return r1
        L_0x00b2:
            r1 = r13
            r13 = r0
            r0 = r5
        L_0x00b5:
            com.sumsub.sns.internal.core.data.model.e r13 = (com.sumsub.sns.internal.core.data.model.e) r13
            java.util.Map r13 = r13.B()
            kotlin.k.b(r1)
            com.sumsub.sns.internal.core.domain.e r1 = (com.sumsub.sns.internal.core.domain.e) r1
            com.sumsub.sns.internal.core.presentation.form.model.d r2 = new com.sumsub.sns.internal.core.presentation.form.model.d
            r2.<init>(r13, r1)
            r0.a((com.sumsub.sns.internal.core.presentation.form.model.d) r2)
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.a.a(r4)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.questionnary.model.d.e(kotlin.coroutines.c):java.lang.Object");
    }

    public final void b(int i11) {
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        com.sumsub.log.logger.a.c(aVar, a.f36239b, "Show page with index " + i11, (Throwable) null, 4, (Object) null);
        a(i11);
        List<b.C0375b> y11 = y();
        if (y11 != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(y11, 10));
            for (b.C0375b bVar : y11) {
                if (bVar.e() == r()) {
                    bVar = a(bVar, v());
                }
                arrayList.add(bVar);
            }
            com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
            com.sumsub.log.logger.a.d(aVar2, a.f36239b, "pages total " + arrayList.size(), (Throwable) null, 4, (Object) null);
            if (arrayList.size() <= r()) {
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (Throwable) new IllegalStateException("Empty questionnaire"), this.f36248x, (Object) null, 4, (Object) null);
                return;
            }
            b.C0375b bVar2 = (b.C0375b) CollectionsKt___CollectionsKt.d0(arrayList, r());
            if (bVar2 != null) {
                a(bVar2);
            }
            com.sumsub.sns.core.presentation.base.a.a(this, false, new q(this, arrayList, f.b((b.C0375b) arrayList.get(r())), (kotlin.coroutines.c<? super q>) null), 1, (Object) null);
        }
    }

    public final void a(w wVar) {
        this.f36249y.a(this, I[0], wVar);
    }

    public final void a(y yVar) {
        this.f36250z.a(this, I[1], yVar);
    }

    public final void a(com.sumsub.sns.internal.core.presentation.form.model.d dVar) {
        this.A.a(this, I[2], dVar);
    }

    public final void a(int i11) {
        this.B.a(this, I[3], Integer.valueOf(i11));
    }

    public final void d(boolean z11) {
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        com.sumsub.log.logger.a.d(aVar, a.f36239b, "handleSubmitSuccess: andContinue=" + z11, (Throwable) null, 4, (Object) null);
        if (z11) {
            C0485d dVar = (C0485d) c();
            if (dVar.f() < CollectionsKt__CollectionsKt.m(dVar.h())) {
                C();
                return;
            }
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (com.sumsub.sns.internal.core.common.q) new q.b(true), (Object) null, (Long) null, 6, (Object) null);
        }
    }

    public final void a(List<FieldId> list) {
        this.C.a(this, I[4], list);
    }

    public void a(com.sumsub.sns.internal.core.data.model.o oVar) {
        if (oVar instanceof o.e) {
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (com.sumsub.sns.internal.core.common.q) null, (Object) null, (Long) null, 7, (Object) null);
        } else {
            super.a(oVar);
        }
    }

    public final void e(boolean z11) {
        w t11;
        String o11;
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        com.sumsub.log.logger.a.d(aVar, a.f36239b, "submitForm: andContinue=" + z11, (Throwable) null, 4, (Object) null);
        if (u() != null && (t11 = t()) != null && (o11 = t11.o()) != null) {
            n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new r(this, o11, z11, (kotlin.coroutines.c<? super r>) null), 3, (Object) null);
        }
    }

    public final void b(FormItem formItem, List<String> list) {
        u uVar;
        if (!list.isEmpty()) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            com.sumsub.log.logger.a.d(aVar, a.f36239b, "handleFilesDeleted: " + formItem, (Throwable) null, 4, (Object) null);
            if (formItem instanceof FormItem.g) {
                uVar = c.a(w(), ((FormItem.g) formItem).e(), formItem.d().p(), (String) null);
            } else if (formItem instanceof FormItem.i) {
                ArrayList arrayList = new ArrayList();
                List<String> b11 = c.b(w(), ((FormItem.i) formItem).e(), formItem.d().p());
                if (b11 != null) {
                    arrayList.addAll(b11);
                }
                arrayList.removeAll(list);
                uVar = c.a(w(), ((FormItem.i) formItem).e(), formItem.d().p(), (List<String>) arrayList);
            } else {
                return;
            }
            a(uVar);
            B();
            e(false);
        }
    }

    public com.sumsub.sns.internal.core.presentation.form.d a() {
        return this.F;
    }

    public final void a(b.C0375b bVar) {
        u w11 = w();
        u uVar = null;
        for (FormItem next : bVar.f()) {
            if (next instanceof FormItem.l) {
                uVar = c.a(w11, ((FormItem.l) next).e());
            }
        }
        if (uVar != null) {
            a(uVar);
        }
    }

    public void a(FormItem formItem, String str) {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new k(this, formItem, str, (kotlin.coroutines.c<? super k>) null), 3, (Object) null);
    }

    public final void a(FieldId fieldId, String str, FormItem.ItemState itemState) {
        String str2;
        String str3;
        b.C0375b bVar = (b.C0375b) CollectionsKt___CollectionsKt.d0(this.D.getValue().h(), this.D.getValue().f());
        if (bVar != null) {
            List<b.C0375b> h11 = this.D.getValue().h();
            int i11 = 10;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(h11, 10));
            for (b.C0375b bVar2 : h11) {
                if (!(bVar2 != bVar)) {
                    bVar2 = null;
                }
                if (bVar2 == null) {
                    List<FormItem> f11 = bVar.f();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.u(f11, i11));
                    for (FormItem formItem : f11) {
                        FormItem formItem2 = x.b(f.a(formItem), fieldId) ^ true ? formItem : null;
                        if (formItem2 == null) {
                            if (formItem instanceof FormItem.g) {
                                formItem2 = FormItem.g.a((FormItem.g) formItem, (com.sumsub.sns.internal.core.data.source.applicant.remote.k) null, (String) null, (String) null, (String) null, (CharSequence) null, itemState, (FormItem.ItemState) null, (String) null, 223, (Object) null);
                                formItem2.a(formItem.a());
                            } else {
                                if (formItem instanceof FormItem.i) {
                                    FormItem.i iVar = (FormItem.i) formItem;
                                    List<FormItem.ItemState> u11 = iVar.u();
                                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.u(u11, i11));
                                    int i12 = 0;
                                    for (T next : u11) {
                                        int i13 = i12 + 1;
                                        if (i12 < 0) {
                                            CollectionsKt__CollectionsKt.t();
                                        }
                                        FormItem.ItemState itemState2 = (FormItem.ItemState) next;
                                        List<String> g11 = formItem.g();
                                        if (g11 != null) {
                                            str3 = (String) CollectionsKt___CollectionsKt.d0(g11, i12);
                                            str2 = str;
                                        } else {
                                            str2 = str;
                                            str3 = null;
                                        }
                                        if (!(!x.b(str3, str2))) {
                                            itemState2 = null;
                                        }
                                        arrayList3.add(itemState2 == null ? itemState : itemState2);
                                        i12 = i13;
                                    }
                                    String str4 = str;
                                    FormItem.i a11 = FormItem.i.a(iVar, (com.sumsub.sns.internal.core.data.source.applicant.remote.k) null, (String) null, (List) null, (String) null, (CharSequence) null, false, arrayList3, (FormItem.ItemState) null, (Map) null, 447, (Object) null);
                                    a11.a(formItem.a());
                                    formItem = a11;
                                } else {
                                    String str5 = str;
                                }
                                arrayList2.add(formItem);
                                i11 = 10;
                            }
                        }
                        formItem = formItem2;
                        arrayList2.add(formItem);
                        i11 = 10;
                    }
                    FieldId fieldId2 = fieldId;
                    bVar2 = b.C0375b.a(bVar, 0, (String) null, (String) null, arrayList2, 7, (Object) null);
                } else {
                    FieldId fieldId3 = fieldId;
                }
                arrayList.add(bVar2);
                i11 = 10;
            }
            com.sumsub.sns.core.presentation.base.a.a(this, false, new s(arrayList, f.b((b.C0375b) arrayList.get(this.D.getValue().f())), (kotlin.coroutines.c<? super s>) null), 1, (Object) null);
        }
    }

    public void b(FormItem formItem, String str) {
        a(c.a(w(), formItem.e(), formItem.d().p(), str));
    }

    public void a(Context context, FieldId fieldId, List<? extends Uri> list) {
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        com.sumsub.log.logger.a.d(aVar, a.f36239b, "onPickedFiles: $" + fieldId, (Throwable) null, 4, (Object) null);
        a(fieldId, FormItem.ItemState.LOADING);
        n1 d11 = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new l(this, fieldId, context, list, (kotlin.coroutines.c<? super l>) null), 3, (Object) null);
        this.G.put(fieldId, d11);
        d11.L(new m(fieldId, this));
    }

    public final void a(FieldId fieldId, FormItem.ItemState itemState) {
        b.C0375b bVar = (b.C0375b) CollectionsKt___CollectionsKt.d0(this.D.getValue().h(), this.D.getValue().f());
        if (bVar != null) {
            List<b.C0375b> h11 = this.D.getValue().h();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(h11, 10));
            Iterator<T> it2 = h11.iterator();
            while (true) {
                boolean z11 = false;
                if (it2.hasNext()) {
                    b.C0375b bVar2 = (b.C0375b) it2.next();
                    if (bVar2 != bVar) {
                        z11 = true;
                    }
                    if (!z11) {
                        bVar2 = null;
                    }
                    if (bVar2 == null) {
                        List<FormItem> f11 = bVar.f();
                        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.u(f11, 10));
                        for (FormItem next : f11) {
                            FormItem formItem = x.b(f.a(next), fieldId) ^ true ? next : null;
                            if (formItem == null) {
                                if (next instanceof FormItem.g) {
                                    formItem = FormItem.g.a((FormItem.g) next, (com.sumsub.sns.internal.core.data.source.applicant.remote.k) null, (String) null, (String) null, (String) null, (CharSequence) null, (FormItem.ItemState) null, itemState, (String) null, 191, (Object) null);
                                    formItem.a(next.a());
                                } else {
                                    if (next instanceof FormItem.i) {
                                        next = FormItem.i.a((FormItem.i) next, (com.sumsub.sns.internal.core.data.source.applicant.remote.k) null, (String) null, (List) null, (String) null, (CharSequence) null, false, (List) null, itemState, (Map) null, 383, (Object) null);
                                    }
                                    arrayList2.add(next);
                                }
                            }
                            next = formItem;
                            arrayList2.add(next);
                        }
                        FieldId fieldId2 = fieldId;
                        bVar2 = b.C0375b.a(bVar, 0, (String) null, (String) null, arrayList2, 7, (Object) null);
                    } else {
                        FieldId fieldId3 = fieldId;
                    }
                    arrayList.add(bVar2);
                } else {
                    com.sumsub.sns.core.presentation.base.a.a(this, false, new t(arrayList, f.b((b.C0375b) arrayList.get(this.D.getValue().f())), (kotlin.coroutines.c<? super t>) null), 1, (Object) null);
                    return;
                }
            }
        }
    }

    public final b.C0375b a(b.C0375b bVar, List<FieldId> list) {
        FormItem a11;
        List<FieldId> list2 = list;
        List<FormItem> f11 = bVar.f();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(f11, 10));
        for (FormItem formItem : f11) {
            FormItem.ItemState itemState = null;
            if (formItem instanceof FormItem.g) {
                FormItem.g gVar = (FormItem.g) formItem;
                FormItem.ItemState itemState2 = FormItem.ItemState.LOADING;
                if (list2.contains(f.a(formItem))) {
                    itemState = itemState2;
                }
                a11 = FormItem.g.a(gVar, (com.sumsub.sns.internal.core.data.source.applicant.remote.k) null, (String) null, (String) null, (String) null, (CharSequence) null, (FormItem.ItemState) null, itemState == null ? FormItem.ItemState.DEFAULT : itemState, (String) null, 191, (Object) null);
                a11.a(formItem.a());
            } else if (formItem instanceof FormItem.i) {
                FormItem.i iVar = (FormItem.i) formItem;
                FormItem.ItemState itemState3 = FormItem.ItemState.LOADING;
                if (list2.contains(f.a(formItem))) {
                    itemState = itemState3;
                }
                a11 = FormItem.i.a(iVar, (com.sumsub.sns.internal.core.data.source.applicant.remote.k) null, (String) null, (List) null, (String) null, (CharSequence) null, false, (List) null, itemState == null ? FormItem.ItemState.DEFAULT : itemState, (Map) null, 383, (Object) null);
                a11.a(formItem.a());
            } else {
                arrayList.add(formItem);
            }
            formItem = a11;
            arrayList.add(formItem);
        }
        return b.C0375b.a(bVar, 0, (String) null, (String) null, arrayList, 7, (Object) null);
    }

    public final void a(FieldId fieldId, List<com.sumsub.sns.internal.core.data.model.remote.k> list) {
        u uVar;
        String q11;
        if (!list.isEmpty()) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            com.sumsub.log.logger.a.d(aVar, a.f36239b, "handleFilesUploaded: " + fieldId, (Throwable) null, 4, (Object) null);
            FormItem a11 = a(fieldId);
            if (a11 != null) {
                if (a11 instanceof FormItem.g) {
                    com.sumsub.sns.internal.core.data.model.remote.k kVar = (com.sumsub.sns.internal.core.data.model.remote.k) CollectionsKt___CollectionsKt.c0(list);
                    if (kVar != null && (q11 = kVar.q()) != null) {
                        uVar = c.a(w(), fieldId.getSectionId(), fieldId.getItemId(), q11);
                    } else {
                        return;
                    }
                } else if (a11 instanceof FormItem.i) {
                    ArrayList arrayList = new ArrayList();
                    for (com.sumsub.sns.internal.core.data.model.remote.k kVar2 : list) {
                        String q12 = kVar2 != null ? kVar2.q() : null;
                        if (q12 != null) {
                            arrayList.add(q12);
                        }
                    }
                    List L0 = CollectionsKt___CollectionsKt.L0(arrayList);
                    List<String> b11 = c.b(w(), fieldId.getSectionId(), fieldId.getItemId());
                    if (b11 != null) {
                        L0.addAll(b11);
                    }
                    uVar = c.a(w(), fieldId.getSectionId(), fieldId.getItemId(), (List<String>) L0);
                } else {
                    return;
                }
                a(uVar);
                e(false);
                B();
            }
        }
    }

    public final FormItem a(FieldId fieldId) {
        FormItem a11 = f.a(((C0485d) c()).h(), fieldId);
        if (a11 != null) {
            return a11;
        }
        if (!((C0485d) c()).h().isEmpty()) {
            return null;
        }
        com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, a.f36239b, "loading page list ...", (Throwable) null, 4, (Object) null);
        List<b.C0375b> y11 = y();
        if (y11 != null) {
            return f.a(y11, fieldId);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r30, java.util.List<? extends android.net.Uri> r31, java.lang.String r32, kotlin.coroutines.c<? super java.util.List<com.sumsub.sns.internal.core.data.model.n>> r33) {
        /*
            r29 = this;
            r0 = r33
            boolean r1 = r0 instanceof com.sumsub.sns.internal.presentation.screen.questionnary.model.d.f
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.sumsub.sns.internal.presentation.screen.questionnary.model.d$f r1 = (com.sumsub.sns.internal.presentation.screen.questionnary.model.d.f) r1
            int r2 = r1.f36272h
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.f36272h = r2
            r2 = r29
            goto L_0x001e
        L_0x0017:
            com.sumsub.sns.internal.presentation.screen.questionnary.model.d$f r1 = new com.sumsub.sns.internal.presentation.screen.questionnary.model.d$f
            r2 = r29
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.f36270f
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r1.f36272h
            r5 = 2
            r6 = 0
            r7 = 0
            r8 = 1
            if (r4 == 0) goto L_0x004f
            if (r4 != r8) goto L_0x0047
            java.lang.Object r4 = r1.f36269e
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Object r9 = r1.f36268d
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r1.f36267c
            java.util.Collection r10 = (java.util.Collection) r10
            java.lang.Object r11 = r1.f36266b
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r1.f36265a
            android.content.Context r12 = (android.content.Context) r12
            kotlin.k.b(r0)
            goto L_0x00da
        L_0x0047:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004f:
            kotlin.k.b(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r4 = r31.iterator()
        L_0x005b:
            boolean r9 = r4.hasNext()
            if (r9 == 0) goto L_0x007f
            java.lang.Object r9 = r4.next()
            r10 = r9
            android.net.Uri r10 = (android.net.Uri) r10
            java.lang.String r10 = r10.getPath()
            if (r10 == 0) goto L_0x0077
            int r10 = r10.length()
            if (r10 != 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r10 = r7
            goto L_0x0078
        L_0x0077:
            r10 = r8
        L_0x0078:
            r10 = r10 ^ r8
            if (r10 == 0) goto L_0x005b
            r0.add(r9)
            goto L_0x005b
        L_0x007f:
            java.util.ArrayList r4 = new java.util.ArrayList
            r9 = 10
            int r9 = kotlin.collections.CollectionsKt__IterablesKt.u(r0, r9)
            r4.<init>(r9)
            java.util.Iterator r0 = r0.iterator()
            r10 = r0
            r9 = r4
            r0 = r30
            r4 = r3
            r3 = r1
            r1 = r32
        L_0x0096:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0151
            java.lang.Object r11 = r10.next()
            android.net.Uri r11 = (android.net.Uri) r11
            java.lang.String r12 = r11.getScheme()
            if (r12 == 0) goto L_0x00b2
            java.lang.String r13 = "file"
            boolean r12 = kotlin.text.StringsKt__StringsJVMKt.M(r12, r13, r7, r5, r6)
            if (r12 != r8) goto L_0x00b2
            r12 = r8
            goto L_0x00b3
        L_0x00b2:
            r12 = r7
        L_0x00b3:
            if (r12 == 0) goto L_0x00bf
            java.lang.String r11 = r11.getEncodedPath()
            r15 = r9
            r21 = r15
            r22 = r10
            goto L_0x00e6
        L_0x00bf:
            r3.f36265a = r0
            r3.f36266b = r1
            r3.f36267c = r9
            r3.f36268d = r10
            r3.f36269e = r9
            r3.f36272h = r8
            java.lang.Object r11 = com.sumsub.sns.internal.core.common.i.b(r11, r0, r3)
            if (r11 != r4) goto L_0x00d2
            return r4
        L_0x00d2:
            r12 = r0
            r0 = r11
            r11 = r1
            r1 = r3
            r3 = r4
            r4 = r9
            r9 = r10
            r10 = r4
        L_0x00da:
            java.lang.String r0 = (java.lang.String) r0
            r15 = r4
            r22 = r9
            r21 = r10
            r4 = r3
            r3 = r1
            r1 = r11
            r11 = r0
            r0 = r12
        L_0x00e6:
            if (r11 == 0) goto L_0x011d
            java.lang.String r9 = "file://"
            boolean r9 = kotlin.text.StringsKt__StringsJVMKt.M(r11, r9, r7, r5, r6)
            if (r9 != 0) goto L_0x00fe
            int r9 = r11.length()
            if (r9 != 0) goto L_0x00f8
            r9 = r8
            goto L_0x00f9
        L_0x00f8:
            r9 = r7
        L_0x00f9:
            if (r9 != 0) goto L_0x00fc
            goto L_0x00fe
        L_0x00fc:
            r9 = r7
            goto L_0x00ff
        L_0x00fe:
            r9 = r8
        L_0x00ff:
            if (r9 == 0) goto L_0x0104
            r23 = r11
            goto L_0x0106
        L_0x0104:
            r23 = r6
        L_0x0106:
            if (r23 == 0) goto L_0x011d
            java.io.File r9 = new java.io.File
            r26 = 0
            r27 = 4
            r28 = 0
            java.lang.String r24 = "file://"
            java.lang.String r25 = ""
            java.lang.String r10 = kotlin.text.StringsKt__StringsJVMKt.G(r23, r24, r25, r26, r27, r28)
            r9.<init>(r10)
            r11 = r9
            goto L_0x011e
        L_0x011d:
            r11 = r6
        L_0x011e:
            com.sumsub.sns.internal.core.data.model.n r14 = new com.sumsub.sns.internal.core.data.model.n
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r23 = 416(0x1a0, float:5.83E-43)
            r24 = 0
            java.lang.String r13 = "FILE_ATTACHMENT"
            r9 = r14
            r10 = r11
            r12 = r1
            r5 = r14
            r14 = r16
            r6 = r15
            r15 = r17
            r16 = r18
            r17 = r19
            r18 = r20
            r19 = r23
            r20 = r24
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r6.add(r5)
            r9 = r21
            r10 = r22
            r5 = 2
            r6 = 0
            goto L_0x0096
        L_0x0151:
            java.util.List r9 = (java.util.List) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.questionnary.model.d.a(android.content.Context, java.util.List, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(String str, Exception exc) {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), v1.f57574b, (CoroutineStart) null, new p(str, exc, (kotlin.coroutines.c<? super p>) null), 2, (Object) null);
    }

    public void a(FormItem formItem, List<String> list) {
        a(c.a(w(), formItem.e(), formItem.d().p(), list));
    }

    public final void a(u uVar) {
        y u11 = u();
        y yVar = null;
        if (u11 != null) {
            yVar = y.a(u11, (String) null, CollectionsKt__CollectionsKt.p(uVar), 1, (Object) null);
        }
        a(yVar);
    }
}
