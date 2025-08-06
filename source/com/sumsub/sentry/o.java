package com.sumsub.sentry;

import com.adjust.sdk.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 82\u00020\u0001:\u0002\b\u0011B\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001e\u0012\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010$\u0012\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010$\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b1\u00102B\u0001\b\u0017\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u001e\u0012\u0016\b\u0001\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010$\u0012\u0016\b\u0001\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010$\u0012\n\b\u0001\u00100\u001a\u0004\u0018\u00010\u001e\u0012\b\u00106\u001a\u0004\u0018\u000105¢\u0006\u0004\b1\u00107J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\"\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u0012\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0017\u0010\u0014R\"\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u0012\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001b\u0010\u0014R\"\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010 \u0012\u0004\b\"\u0010\u000e\u001a\u0004\b\u001f\u0010!R.\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010$8\u0006X\u0004¢\u0006\u0012\n\u0004\b%\u0010&\u0012\u0004\b)\u0010\u000e\u001a\u0004\b'\u0010(R.\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010$8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001b\u0010&\u0012\u0004\b+\u0010\u000e\u001a\u0004\b\b\u0010(R\"\u00100\u001a\u0004\u0018\u00010\u001e8\u0006X\u0004¢\u0006\u0012\n\u0004\b-\u0010 \u0012\u0004\b/\u0010\u000e\u001a\u0004\b.\u0010!¨\u00069"}, d2 = {"Lcom/sumsub/sentry/o;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Ljava/lang/Thread;", "Ljava/lang/Thread;", "m", "()Ljava/lang/Thread;", "getThread$annotations", "()V", "thread", "", "b", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "getType$annotations", "type", "c", "getDescription$annotations", "description", "d", "g", "getHelpLink$annotations", "helpLink", "", "e", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "getHandled$annotations", "handled", "", "f", "Ljava/util/Map;", "i", "()Ljava/util/Map;", "getMeta$annotations", "meta", "getData$annotations", "data", "h", "k", "getSynthetic$annotations", "synthetic", "<init>", "(Ljava/lang/Thread;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class o {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final Thread f30448a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30449b;

    /* renamed from: c  reason: collision with root package name */
    public final String f30450c;

    /* renamed from: d  reason: collision with root package name */
    public final String f30451d;

    /* renamed from: e  reason: collision with root package name */
    public final Boolean f30452e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, Object> f30453f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, Object> f30454g;

    /* renamed from: h  reason: collision with root package name */
    public final Boolean f30455h;

    public static final class a implements d0<o> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30456a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30457b;

        static {
            a aVar = new a();
            f30456a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.Mechanism", aVar, 7);
            pluginGeneratedSerialDescriptor.k("type", true);
            pluginGeneratedSerialDescriptor.k("description", true);
            pluginGeneratedSerialDescriptor.k("help_link", true);
            pluginGeneratedSerialDescriptor.k("handled", true);
            pluginGeneratedSerialDescriptor.k(Constants.REFERRER_API_META, true);
            pluginGeneratedSerialDescriptor.k("data", true);
            pluginGeneratedSerialDescriptor.k("synthetic", true);
            f30457b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x00f2, code lost:
            r8 = r7;
            r5 = r18;
            r7 = r3;
            r3 = 6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0115, code lost:
            r3 = 6;
            r14 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x006c, code lost:
            r14 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x006c, code lost:
            r14 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x006c, code lost:
            r14 = r14;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.o deserialize(kotlinx.serialization.encoding.c r20) {
            /*
                r19 = this;
                java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
                kotlinx.serialization.descriptors.f r1 = r19.getDescriptor()
                r2 = r20
                kotlinx.serialization.encoding.a r2 = r2.b(r1)
                boolean r3 = r2.k()
                r6 = 3
                r7 = 4
                r8 = 2
                r9 = 1
                r10 = 0
                r11 = 0
                if (r3 == 0) goto L_0x0060
                kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r12 = r2.j(r1, r10, r3, r11)
                java.lang.Object r9 = r2.j(r1, r9, r3, r11)
                java.lang.Object r8 = r2.j(r1, r8, r3, r11)
                kotlinx.serialization.internal.h r13 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r6 = r2.j(r1, r6, r13, r11)
                kotlinx.serialization.internal.r0 r14 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.ContextualSerializer r15 = new kotlinx.serialization.ContextualSerializer
                kotlin.reflect.c r4 = kotlin.jvm.internal.Reflection.b(r0)
                kotlinx.serialization.b[] r5 = new kotlinx.serialization.b[r10]
                r15.<init>(r4, r11, r5)
                r14.<init>(r3, r15)
                java.lang.Object r4 = r2.j(r1, r7, r14, r11)
                kotlinx.serialization.internal.r0 r5 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.ContextualSerializer r7 = new kotlinx.serialization.ContextualSerializer
                kotlin.reflect.c r0 = kotlin.jvm.internal.Reflection.b(r0)
                kotlinx.serialization.b[] r10 = new kotlinx.serialization.b[r10]
                r7.<init>(r0, r11, r10)
                r5.<init>(r3, r7)
                r0 = 5
                java.lang.Object r0 = r2.j(r1, r0, r5, r11)
                r3 = 6
                java.lang.Object r3 = r2.j(r1, r3, r13, r11)
                r5 = 127(0x7f, float:1.78E-43)
                r14 = r6
                r6 = r5
                goto L_0x0124
            L_0x0060:
                r3 = 6
                r17 = r9
                r13 = r10
                r4 = r11
                r5 = r4
                r9 = r5
                r12 = r9
                r14 = r12
                r15 = r14
                r16 = r15
            L_0x006c:
                if (r17 == 0) goto L_0x0119
                int r8 = r2.w(r1)
                switch(r8) {
                    case -1: goto L_0x010f;
                    case 0: goto L_0x00f9;
                    case 1: goto L_0x00e5;
                    case 2: goto L_0x00d8;
                    case 3: goto L_0x00c9;
                    case 4: goto L_0x00a7;
                    case 5: goto L_0x0085;
                    case 6: goto L_0x007b;
                    default: goto L_0x0075;
                }
            L_0x0075:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r8)
                throw r0
            L_0x007b:
                kotlinx.serialization.internal.h r8 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r5 = r2.j(r1, r3, r8, r5)
                r13 = r13 | 64
                goto L_0x0116
            L_0x0085:
                kotlinx.serialization.internal.r0 r8 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                kotlinx.serialization.ContextualSerializer r6 = new kotlinx.serialization.ContextualSerializer
                kotlin.reflect.c r7 = kotlin.jvm.internal.Reflection.b(r0)
                r18 = r5
                kotlinx.serialization.b[] r5 = new kotlinx.serialization.b[r10]
                r6.<init>(r7, r11, r5)
                r8.<init>(r3, r6)
                r3 = 5
                java.lang.Object r4 = r2.j(r1, r3, r8, r4)
                r13 = r13 | 32
                r5 = r18
                r3 = 6
                r6 = 3
                r7 = 4
                goto L_0x0116
            L_0x00a7:
                r18 = r5
                r3 = 5
                kotlinx.serialization.internal.r0 r5 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                kotlinx.serialization.ContextualSerializer r7 = new kotlinx.serialization.ContextualSerializer
                kotlin.reflect.c r8 = kotlin.jvm.internal.Reflection.b(r0)
                kotlinx.serialization.b[] r3 = new kotlinx.serialization.b[r10]
                r7.<init>(r8, r11, r3)
                r5.<init>(r6, r7)
                r3 = 4
                java.lang.Object r12 = r2.j(r1, r3, r5, r12)
                r13 = r13 | 16
                r7 = r3
                r5 = r18
                r3 = 6
                r6 = 3
                goto L_0x0116
            L_0x00c9:
                r18 = r5
                r3 = r7
                kotlinx.serialization.internal.h r5 = kotlinx.serialization.internal.h.f57720a
                r6 = 3
                java.lang.Object r14 = r2.j(r1, r6, r5, r14)
                r13 = r13 | 8
                r5 = r18
                goto L_0x0115
            L_0x00d8:
                r18 = r5
                r3 = r7
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r7 = 2
                java.lang.Object r15 = r2.j(r1, r7, r5, r15)
                r13 = r13 | 4
                goto L_0x00f2
            L_0x00e5:
                r18 = r5
                r3 = r7
                r7 = 2
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r8 = 1
                java.lang.Object r9 = r2.j(r1, r8, r5, r9)
                r13 = r13 | 2
            L_0x00f2:
                r8 = r7
                r5 = r18
                r7 = r3
                r3 = 6
                goto L_0x006c
            L_0x00f9:
                r18 = r5
                r3 = r7
                r7 = 2
                r8 = 1
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r3 = r16
                java.lang.Object r16 = r2.j(r1, r10, r5, r3)
                r13 = r13 | 1
                r8 = r7
                r5 = r18
                r3 = 6
                r7 = 4
                goto L_0x006c
            L_0x010f:
                r18 = r5
                r3 = r16
                r17 = r10
            L_0x0115:
                r3 = 6
            L_0x0116:
                r8 = 2
                goto L_0x006c
            L_0x0119:
                r18 = r5
                r3 = r16
                r0 = r4
                r4 = r12
                r6 = r13
                r8 = r15
                r12 = r3
                r3 = r18
            L_0x0124:
                r2.c(r1)
                com.sumsub.sentry.o r1 = new com.sumsub.sentry.o
                r7 = r12
                java.lang.String r7 = (java.lang.String) r7
                r2 = r9
                java.lang.String r2 = (java.lang.String) r2
                r9 = r8
                java.lang.String r9 = (java.lang.String) r9
                r10 = r14
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                r11 = r4
                java.util.Map r11 = (java.util.Map) r11
                r12 = r0
                java.util.Map r12 = (java.util.Map) r12
                r13 = r3
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                r14 = 0
                r5 = r1
                r8 = r2
                r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.o.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.o");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            Class<Object> cls = Object.class;
            v1 v1Var = v1.f57779a;
            h hVar = h.f57720a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(hVar), h10.a.u(new r0(v1Var, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0]))), h10.a.u(new r0(v1Var, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0]))), h10.a.u(hVar)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30457b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, o oVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            o.a(oVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<o> serializer() {
            return a.f30456a;
        }

        public b() {
        }
    }

    public o() {
        this((Thread) null, (String) null, (String) null, (String) null, (Boolean) null, (Map) null, (Map) null, (Boolean) null, 255, (r) null);
    }

    public static final void a(o oVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        Class<Object> cls = Object.class;
        boolean z11 = false;
        if (bVar.q(fVar, 0) || oVar.f30449b != null) {
            bVar.y(fVar, 0, v1.f57779a, oVar.f30449b);
        }
        if (bVar.q(fVar, 1) || oVar.f30450c != null) {
            bVar.y(fVar, 1, v1.f57779a, oVar.f30450c);
        }
        if (bVar.q(fVar, 2) || oVar.f30451d != null) {
            bVar.y(fVar, 2, v1.f57779a, oVar.f30451d);
        }
        if (bVar.q(fVar, 3) || oVar.f30452e != null) {
            bVar.y(fVar, 3, h.f57720a, oVar.f30452e);
        }
        if (bVar.q(fVar, 4) || oVar.f30453f != null) {
            bVar.y(fVar, 4, new r0(v1.f57779a, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])), oVar.f30453f);
        }
        if (bVar.q(fVar, 5) || oVar.f30454g != null) {
            bVar.y(fVar, 5, new r0(v1.f57779a, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])), oVar.f30454g);
        }
        if (bVar.q(fVar, 6) || oVar.f30455h != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 6, h.f57720a, oVar.f30455h);
        }
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public static /* synthetic */ void h() {
    }

    public static /* synthetic */ void j() {
    }

    public static /* synthetic */ void l() {
    }

    public static /* synthetic */ void n() {
    }

    public static /* synthetic */ void p() {
    }

    public final String c() {
        return this.f30450c;
    }

    public final Boolean e() {
        return this.f30452e;
    }

    public final String g() {
        return this.f30451d;
    }

    public final Map<String, Object> i() {
        return this.f30453f;
    }

    public final Boolean k() {
        return this.f30455h;
    }

    public final Thread m() {
        return this.f30448a;
    }

    public final String o() {
        return this.f30449b;
    }

    public /* synthetic */ o(int i11, String str, String str2, String str3, Boolean bool, Map map, Map map2, Boolean bool2, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f30456a.getDescriptor());
        }
        this.f30448a = null;
        if ((i11 & 1) == 0) {
            this.f30449b = null;
        } else {
            this.f30449b = str;
        }
        if ((i11 & 2) == 0) {
            this.f30450c = null;
        } else {
            this.f30450c = str2;
        }
        if ((i11 & 4) == 0) {
            this.f30451d = null;
        } else {
            this.f30451d = str3;
        }
        if ((i11 & 8) == 0) {
            this.f30452e = null;
        } else {
            this.f30452e = bool;
        }
        if ((i11 & 16) == 0) {
            this.f30453f = null;
        } else {
            this.f30453f = map;
        }
        if ((i11 & 32) == 0) {
            this.f30454g = null;
        } else {
            this.f30454g = map2;
        }
        if ((i11 & 64) == 0) {
            this.f30455h = null;
        } else {
            this.f30455h = bool2;
        }
    }

    public final Map<String, Object> a() {
        return this.f30454g;
    }

    public o(Thread thread, String str, String str2, String str3, Boolean bool, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Boolean bool2) {
        this.f30448a = thread;
        this.f30449b = str;
        this.f30450c = str2;
        this.f30451d = str3;
        this.f30452e = bool;
        this.f30453f = map;
        this.f30454g = map2;
        this.f30455h = bool2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ o(java.lang.Thread r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.Boolean r14, java.util.Map r15, java.util.Map r16, java.lang.Boolean r17, int r18, kotlin.jvm.internal.r r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.o.<init>(java.lang.Thread, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.util.Map, java.util.Map, java.lang.Boolean, int, kotlin.jvm.internal.r):void");
    }
}
