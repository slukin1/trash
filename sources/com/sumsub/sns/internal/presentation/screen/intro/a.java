package com.sumsub.sns.internal.presentation.screen.intro;

import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.data.model.e;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.core.presentation.intro.f;
import d10.p;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;

public final class a extends com.sumsub.sns.core.presentation.base.a<a.l> {
    public static final String A = "sns_param_cancel_on_back";

    /* renamed from: v  reason: collision with root package name */
    public static final C0424a f35263v = new C0424a((r) null);

    /* renamed from: w  reason: collision with root package name */
    public static final String f35264w = "sns_param_step";

    /* renamed from: x  reason: collision with root package name */
    public static final String f35265x = "sns_param_document_type";

    /* renamed from: y  reason: collision with root package name */
    public static final String f35266y = "sns_param_scene";

    /* renamed from: z  reason: collision with root package name */
    public static final String f35267z = "sns_param_country_code";

    /* renamed from: q  reason: collision with root package name */
    public final String f35268q;

    /* renamed from: r  reason: collision with root package name */
    public final String f35269r;

    /* renamed from: s  reason: collision with root package name */
    public final String f35270s;

    /* renamed from: t  reason: collision with root package name */
    public final String f35271t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f35272u;

    /* renamed from: com.sumsub.sns.internal.presentation.screen.intro.a$a  reason: collision with other inner class name */
    public static final class C0424a {
        public /* synthetic */ C0424a(r rVar) {
            this();
        }

        public C0424a() {
        }
    }

    public static final class b implements a.l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f35273a = new b();
    }

    public static final class c implements a.l {

        /* renamed from: a  reason: collision with root package name */
        public final f f35274a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<String, Object> f35275b;

        public c(f fVar, Map<String, ? extends Object> map) {
            this.f35274a = fVar;
            this.f35275b = map;
        }

        public final f a() {
            return this.f35274a;
        }

        public final Map<String, Object> b() {
            return this.f35275b;
        }

        public final Map<String, Object> c() {
            return this.f35275b;
        }

        public final f d() {
            return this.f35274a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return x.b(this.f35274a, cVar.f35274a) && x.b(this.f35275b, cVar.f35275b);
        }

        public int hashCode() {
            return (this.f35274a.hashCode() * 31) + this.f35275b.hashCode();
        }

        public String toString() {
            return "IntroViewState(stepInfo=" + this.f35274a + ", data=" + this.f35275b + ')';
        }

        public final c a(f fVar, Map<String, ? extends Object> map) {
            return new c(fVar, map);
        }

        public static /* synthetic */ c a(c cVar, f fVar, Map<String, Object> map, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                fVar = cVar.f35274a;
            }
            if ((i11 & 2) != 0) {
                map = cVar.f35275b;
            }
            return cVar.a(fVar, map);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.intro.SNSIntroViewModel$onPrepare$2", f = "SNSIntroViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements p<a.l, kotlin.coroutines.c<? super a.l>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35276a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f35277b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f35277b = aVar;
        }

        /* renamed from: a */
        public final Object invoke(a.l lVar, kotlin.coroutines.c<? super a.l> cVar) {
            return ((d) create(lVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d(this.f35277b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35276a == 0) {
                k.b(obj);
                f fVar = new f(this.f35277b.f35268q, this.f35277b.f35270s, this.f35277b.f35269r);
                b.c e11 = this.f35277b.h();
                e a11 = this.f35277b.d();
                return new c(fVar, new com.sumsub.sns.internal.core.presentation.intro.b(e11, a11 != null ? a11.C() : null, this.f35277b.f35268q, this.f35277b.f35269r, this.f35277b.f35270s, false, 32, (r) null).c());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public a(String str, String str2, String str3, String str4, boolean z11, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        super(aVar, bVar);
        this.f35268q = str;
        this.f35269r = str2;
        this.f35270s = str3;
        this.f35271t = str4;
        this.f35272u = z11;
    }

    public final String p() {
        return this.f35271t;
    }

    /* renamed from: q */
    public b e() {
        return b.f35273a;
    }

    public final String r() {
        return this.f35268q;
    }

    public final boolean s() {
        return this.f35272u;
    }

    public Object d(kotlin.coroutines.c<? super Unit> cVar) {
        com.sumsub.sns.core.presentation.base.a.a(this, false, new d(this, (kotlin.coroutines.c<? super d>) null), 1, (Object) null);
        return Unit.f56620a;
    }
}
