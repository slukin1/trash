package com.sumsub.sentry;

import com.sumsub.sentry.b;
import com.sumsub.sentry.d;
import com.sumsub.sentry.q0;
import com.sumsub.sentry.s;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b!\u0018\u0000 [2\u00020\u0001:\u0001\u0017B\t\b\u0004¢\u0006\u0004\bU\u0010\u0014B½\u0001\b\u0017\u0012\u0006\u0010W\u001a\u00020V\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0016\u0012\u0016\b\u0001\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e\u0012\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u00100\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u00103\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010;\u001a\u0004\u0018\u000104\u0012\n\b\u0001\u0010>\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010A\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0001\u0010H\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010B\u0012\u0016\b\u0001\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001e\u0012\b\u0010Y\u001a\u0004\u0018\u00010X¢\u0006\u0004\bU\u0010ZJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rR \u0010\u0015\u001a\u00020\u000f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0010\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R*\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\b\u0010\u001bR6\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u001f\u0010 \u0012\u0004\b$\u0010\u0014\u001a\u0004\b!\u0010\"\"\u0004\b\u0017\u0010#R*\u0010,\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u0011\u0010&\u0012\u0004\b+\u0010\u0014\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R*\u00100\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b-\u0010&\u0012\u0004\b/\u0010\u0014\u001a\u0004\b.\u0010(\"\u0004\b\u001f\u0010*R*\u00103\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b)\u0010&\u0012\u0004\b2\u0010\u0014\u001a\u0004\b1\u0010(\"\u0004\b-\u0010*R*\u0010;\u001a\u0004\u0018\u0001048\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b5\u00106\u0012\u0004\b:\u0010\u0014\u001a\u0004\b7\u00108\"\u0004\b\b\u00109R*\u0010>\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b.\u0010&\u0012\u0004\b=\u0010\u0014\u001a\u0004\b<\u0010(\"\u0004\b5\u0010*R*\u0010A\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b?\u0010&\u0012\u0004\b@\u0010\u0014\u001a\u0004\b)\u0010(\"\u0004\b\u0017\u0010*R0\u0010H\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010B8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bC\u0010D\u0012\u0004\bG\u0010\u0014\u001a\u0004\b\u0017\u0010E\"\u0004\b\b\u0010FR6\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001e8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bI\u0010 \u0012\u0004\bJ\u0010\u0014\u001a\u0004\bI\u0010\"\"\u0004\b\b\u0010#R*\u0010R\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bL\u0010M\u0012\u0004\bQ\u0010\u0014\u001a\u0004\bN\u0010O\"\u0004\b\b\u0010PR%\u0010T\u001a\u00020S8&@&X¦\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\bC\u0010(\"\u0004\b\u0011\u0010*\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\\"}, d2 = {"Lcom/sumsub/sentry/u;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "w", "Lcom/sumsub/sentry/b;", "breadcrumb", "", "message", "Lcom/sumsub/sentry/d;", "Lcom/sumsub/sentry/d;", "d", "()Lcom/sumsub/sentry/d;", "getContexts$annotations", "()V", "contexts", "Lcom/sumsub/sentry/s;", "b", "Lcom/sumsub/sentry/s;", "q", "()Lcom/sumsub/sentry/s;", "(Lcom/sumsub/sentry/s;)V", "getSdk$annotations", "sdk", "", "c", "Ljava/util/Map;", "u", "()Ljava/util/Map;", "(Ljava/util/Map;)V", "getTags$annotations", "tags", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "getRelease$annotations", "release", "e", "h", "getEnvironment$annotations", "environment", "m", "getPlatform$annotations", "platform", "Lcom/sumsub/sentry/q0;", "g", "Lcom/sumsub/sentry/q0;", "z", "()Lcom/sumsub/sentry/q0;", "(Lcom/sumsub/sentry/q0;)V", "getUser$annotations", "user", "s", "getServerName$annotations", "serverName", "i", "getDist$annotations", "dist", "", "j", "Ljava/util/List;", "()Ljava/util/List;", "(Ljava/util/List;)V", "getBreadcrumbs$annotations", "breadcrumbs", "k", "getExtra$annotations", "extra", "l", "Ljava/lang/Throwable;", "x", "()Ljava/lang/Throwable;", "(Ljava/lang/Throwable;)V", "getThrowableMechanism$annotations", "throwableMechanism", "Lcom/sumsub/sentry/d0;", "eventId", "<init>", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sentry/d;Lcom/sumsub/sentry/s;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sentry/q0;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public abstract class u {
    public static final b Companion = new b((r) null);

    /* renamed from: m  reason: collision with root package name */
    public static final String f30502m = "java";

    /* renamed from: n  reason: collision with root package name */
    public static final i<kotlinx.serialization.b<Object>> f30503n = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.PUBLICATION, a.f30516a);

    /* renamed from: a  reason: collision with root package name */
    public final d f30504a;

    /* renamed from: b  reason: collision with root package name */
    public s f30505b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f30506c;

    /* renamed from: d  reason: collision with root package name */
    public String f30507d;

    /* renamed from: e  reason: collision with root package name */
    public String f30508e;

    /* renamed from: f  reason: collision with root package name */
    public String f30509f;

    /* renamed from: g  reason: collision with root package name */
    public q0 f30510g;

    /* renamed from: h  reason: collision with root package name */
    public String f30511h;

    /* renamed from: i  reason: collision with root package name */
    public String f30512i;

    /* renamed from: j  reason: collision with root package name */
    public List<b> f30513j;

    /* renamed from: k  reason: collision with root package name */
    public Map<String, Object> f30514k;

    /* renamed from: l  reason: collision with root package name */
    public Throwable f30515l;

    public static final class a extends Lambda implements d10.a<kotlinx.serialization.b<Object>> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30516a = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final kotlinx.serialization.b<Object> invoke() {
            return new PolymorphicSerializer(Reflection.b(u.class), new Annotation[0]);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        private final /* synthetic */ i a() {
            return u.f30503n;
        }

        public final kotlinx.serialization.b<u> serializer() {
            return (kotlinx.serialization.b) a().getValue();
        }

        public b() {
        }
    }

    public u() {
        this.f30504a = new d();
        this.f30506c = new LinkedHashMap();
    }

    public static /* synthetic */ void A() {
    }

    public static /* synthetic */ void c() {
    }

    public static /* synthetic */ void e() {
    }

    public static /* synthetic */ void g() {
    }

    public static /* synthetic */ void i() {
    }

    public static /* synthetic */ void l() {
    }

    public static /* synthetic */ void n() {
    }

    public static /* synthetic */ void p() {
    }

    public static /* synthetic */ void r() {
    }

    public static /* synthetic */ void t() {
    }

    public static /* synthetic */ void v() {
    }

    public static /* synthetic */ void y() {
    }

    public final void b(Map<String, String> map) {
        this.f30506c = map;
    }

    public final void c(String str) {
        this.f30508e = str;
    }

    public final d d() {
        return this.f30504a;
    }

    public abstract void d(String str);

    public final void e(String str) {
        this.f30509f = str;
    }

    public final void f(String str) {
        this.f30507d = str;
    }

    public final void g(String str) {
        this.f30511h = str;
    }

    public final String h() {
        return this.f30508e;
    }

    public abstract String j();

    public final Map<String, Object> k() {
        return this.f30514k;
    }

    public final String m() {
        return this.f30509f;
    }

    public final String o() {
        return this.f30507d;
    }

    public final s q() {
        return this.f30505b;
    }

    public final String s() {
        return this.f30511h;
    }

    public final Map<String, String> u() {
        return this.f30506c;
    }

    public final Throwable w() {
        Throwable c11;
        Throwable th2 = this.f30515l;
        i iVar = th2 instanceof i ? (i) th2 : null;
        return (iVar == null || (c11 = iVar.c()) == null) ? th2 : c11;
    }

    public final Throwable x() {
        return this.f30515l;
    }

    public final q0 z() {
        return this.f30510g;
    }

    public static final void a(u uVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = true;
        if (bVar.q(fVar, 0) || !x.b(uVar.f30504a, new d())) {
            bVar.F(fVar, 0, d.b.f30313a, uVar.f30504a);
        }
        if (bVar.q(fVar, 1) || uVar.f30505b != null) {
            bVar.y(fVar, 1, s.a.f30494a, uVar.f30505b);
        }
        if (bVar.q(fVar, 2) || !x.b(uVar.f30506c, new LinkedHashMap())) {
            v1 v1Var = v1.f57779a;
            bVar.y(fVar, 2, new r0(v1Var, v1Var), uVar.f30506c);
        }
        if (bVar.q(fVar, 3) || uVar.f30507d != null) {
            bVar.y(fVar, 3, v1.f57779a, uVar.f30507d);
        }
        if (bVar.q(fVar, 4) || uVar.f30508e != null) {
            bVar.y(fVar, 4, v1.f57779a, uVar.f30508e);
        }
        if (bVar.q(fVar, 5) || uVar.f30509f != null) {
            bVar.y(fVar, 5, v1.f57779a, uVar.f30509f);
        }
        if (bVar.q(fVar, 6) || uVar.f30510g != null) {
            bVar.y(fVar, 6, q0.a.f30482a, uVar.f30510g);
        }
        if (bVar.q(fVar, 7) || uVar.f30511h != null) {
            bVar.y(fVar, 7, v1.f57779a, uVar.f30511h);
        }
        if (bVar.q(fVar, 8) || uVar.f30512i != null) {
            bVar.y(fVar, 8, v1.f57779a, uVar.f30512i);
        }
        if (bVar.q(fVar, 9) || uVar.f30513j != null) {
            bVar.y(fVar, 9, new e(b.a.f30295a), uVar.f30513j);
        }
        if (!bVar.q(fVar, 10) && uVar.f30514k == null) {
            z11 = false;
        }
        if (z11) {
            bVar.y(fVar, 10, new r0(v1.f57779a, new ContextualSerializer(Reflection.b(Object.class), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])), uVar.f30514k);
        }
    }

    public final void b(String str) {
        this.f30512i = str;
    }

    public final String f() {
        return this.f30512i;
    }

    public final List<b> b() {
        return this.f30513j;
    }

    public /* synthetic */ u(int i11, d dVar, s sVar, Map map, String str, String str2, String str3, q0 q0Var, String str4, String str5, List list, Map map2, q1 q1Var) {
        this.f30504a = (i11 & 1) == 0 ? new d() : dVar;
        if ((i11 & 2) == 0) {
            this.f30505b = null;
        } else {
            this.f30505b = sVar;
        }
        if ((i11 & 4) == 0) {
            this.f30506c = new LinkedHashMap();
        } else {
            this.f30506c = map;
        }
        if ((i11 & 8) == 0) {
            this.f30507d = null;
        } else {
            this.f30507d = str;
        }
        if ((i11 & 16) == 0) {
            this.f30508e = null;
        } else {
            this.f30508e = str2;
        }
        if ((i11 & 32) == 0) {
            this.f30509f = null;
        } else {
            this.f30509f = str3;
        }
        if ((i11 & 64) == 0) {
            this.f30510g = null;
        } else {
            this.f30510g = q0Var;
        }
        if ((i11 & 128) == 0) {
            this.f30511h = null;
        } else {
            this.f30511h = str4;
        }
        if ((i11 & 256) == 0) {
            this.f30512i = null;
        } else {
            this.f30512i = str5;
        }
        if ((i11 & 512) == 0) {
            this.f30513j = null;
        } else {
            this.f30513j = list;
        }
        if ((i11 & 1024) == 0) {
            this.f30514k = null;
        } else {
            this.f30514k = map2;
        }
        this.f30515l = null;
    }

    public final void a(s sVar) {
        this.f30505b = sVar;
    }

    public final void a(q0 q0Var) {
        this.f30510g = q0Var;
    }

    public final void a(List<b> list) {
        this.f30513j = list;
    }

    public final void a(Map<String, Object> map) {
        this.f30514k = map;
    }

    public final void a(Throwable th2) {
        this.f30515l = th2;
    }

    public final void a(b bVar) {
        if (this.f30513j == null) {
            this.f30513j = new ArrayList();
        }
        List<b> list = this.f30513j;
        if (list != null) {
            list.add(bVar);
        }
    }

    public final void a(String str) {
        a(new b((Date) null, str, (String) null, (Map) null, (String) null, (SentryLevel) null, 61, (r) null));
    }
}
