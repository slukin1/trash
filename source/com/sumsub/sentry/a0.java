package com.sumsub.sentry;

import com.sumsub.sentry.i0;
import com.sumsub.sentry.o;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;
import kotlinx.serialization.internal.x0;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 12\u00020\u0001:\u0002\b\u0010BO\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010$¢\u0006\u0004\b*\u0010+Bc\b\u0017\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0001\u0010)\u001a\u0004\u0018\u00010$\u0012\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b*\u00100J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\"\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0011\u0010\fR\"\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0014\u0010\n\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0014\u0010\fR\"\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010 \u0012\u0004\b\"\u0010\u000e\u001a\u0004\b\u001f\u0010!R\"\u0010)\u001a\u0004\u0018\u00010$8\u0006X\u0004¢\u0006\u0012\n\u0004\b%\u0010&\u0012\u0004\b(\u0010\u000e\u001a\u0004\b\b\u0010'¨\u00062"}, d2 = {"Lcom/sumsub/sentry/a0;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "getType$annotations", "()V", "type", "b", "k", "getValue$annotations", "value", "c", "getModule$annotations", "module", "", "d", "Ljava/lang/Long;", "g", "()Ljava/lang/Long;", "getThreadId$annotations", "threadId", "Lcom/sumsub/sentry/i0;", "e", "Lcom/sumsub/sentry/i0;", "()Lcom/sumsub/sentry/i0;", "getStacktrace$annotations", "stacktrace", "Lcom/sumsub/sentry/o;", "f", "Lcom/sumsub/sentry/o;", "()Lcom/sumsub/sentry/o;", "getMechanism$annotations", "mechanism", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/sumsub/sentry/i0;Lcom/sumsub/sentry/o;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/sumsub/sentry/i0;Lcom/sumsub/sentry/o;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class a0 {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f30251a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30252b;

    /* renamed from: c  reason: collision with root package name */
    public final String f30253c;

    /* renamed from: d  reason: collision with root package name */
    public final Long f30254d;

    /* renamed from: e  reason: collision with root package name */
    public final i0 f30255e;

    /* renamed from: f  reason: collision with root package name */
    public final o f30256f;

    public static final class a implements d0<a0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30257a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30258b;

        static {
            a aVar = new a();
            f30257a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.SentryException", aVar, 6);
            pluginGeneratedSerialDescriptor.k("type", true);
            pluginGeneratedSerialDescriptor.k("value", true);
            pluginGeneratedSerialDescriptor.k("module", true);
            pluginGeneratedSerialDescriptor.k("thread_id", true);
            pluginGeneratedSerialDescriptor.k("stacktrace", true);
            pluginGeneratedSerialDescriptor.k("mechanism", true);
            f30258b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x008f, code lost:
            r3 = 5;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.a0 deserialize(kotlinx.serialization.encoding.c r17) {
            /*
                r16 = this;
                kotlinx.serialization.descriptors.f r0 = r16.getDescriptor()
                r1 = r17
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 5
                r4 = 3
                r5 = 4
                r6 = 2
                r7 = 0
                r8 = 1
                r9 = 0
                if (r2 == 0) goto L_0x003d
                kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r7 = r1.j(r0, r7, r2, r9)
                java.lang.Object r8 = r1.j(r0, r8, r2, r9)
                java.lang.Object r2 = r1.j(r0, r6, r2, r9)
                kotlinx.serialization.internal.x0 r6 = kotlinx.serialization.internal.x0.f57786a
                java.lang.Object r4 = r1.j(r0, r4, r6, r9)
                com.sumsub.sentry.i0$a r6 = com.sumsub.sentry.i0.a.f30385a
                java.lang.Object r5 = r1.j(r0, r5, r6, r9)
                com.sumsub.sentry.o$a r6 = com.sumsub.sentry.o.a.f30456a
                java.lang.Object r3 = r1.j(r0, r3, r6, r9)
                r6 = 63
                r9 = r7
                r7 = r6
                goto L_0x0097
            L_0x003d:
                r2 = r7
                r15 = r8
                r10 = r9
                r11 = r10
                r12 = r11
                r13 = r12
                r14 = r13
            L_0x0044:
                if (r15 == 0) goto L_0x0091
                int r7 = r1.w(r0)
                switch(r7) {
                    case -1: goto L_0x008c;
                    case 0: goto L_0x0081;
                    case 1: goto L_0x0077;
                    case 2: goto L_0x006e;
                    case 3: goto L_0x0065;
                    case 4: goto L_0x005c;
                    case 5: goto L_0x0053;
                    default: goto L_0x004d;
                }
            L_0x004d:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r7)
                throw r0
            L_0x0053:
                com.sumsub.sentry.o$a r7 = com.sumsub.sentry.o.a.f30456a
                java.lang.Object r14 = r1.j(r0, r3, r7, r14)
                r2 = r2 | 32
                goto L_0x007f
            L_0x005c:
                com.sumsub.sentry.i0$a r7 = com.sumsub.sentry.i0.a.f30385a
                java.lang.Object r13 = r1.j(r0, r5, r7, r13)
                r2 = r2 | 16
                goto L_0x007f
            L_0x0065:
                kotlinx.serialization.internal.x0 r7 = kotlinx.serialization.internal.x0.f57786a
                java.lang.Object r12 = r1.j(r0, r4, r7, r12)
                r2 = r2 | 8
                goto L_0x007f
            L_0x006e:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r11 = r1.j(r0, r6, r7, r11)
                r2 = r2 | 4
                goto L_0x007f
            L_0x0077:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r10 = r1.j(r0, r8, r7, r10)
                r2 = r2 | 2
            L_0x007f:
                r7 = 0
                goto L_0x0044
            L_0x0081:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                r3 = 0
                java.lang.Object r9 = r1.j(r0, r3, r7, r9)
                r2 = r2 | 1
                r7 = r3
                goto L_0x008f
            L_0x008c:
                r3 = 0
                r7 = r3
                r15 = r7
            L_0x008f:
                r3 = 5
                goto L_0x0044
            L_0x0091:
                r7 = r2
                r8 = r10
                r2 = r11
                r4 = r12
                r5 = r13
                r3 = r14
            L_0x0097:
                r1.c(r0)
                com.sumsub.sentry.a0 r0 = new com.sumsub.sentry.a0
                r1 = r9
                java.lang.String r1 = (java.lang.String) r1
                r9 = r8
                java.lang.String r9 = (java.lang.String) r9
                r10 = r2
                java.lang.String r10 = (java.lang.String) r10
                r11 = r4
                java.lang.Long r11 = (java.lang.Long) r11
                r12 = r5
                com.sumsub.sentry.i0 r12 = (com.sumsub.sentry.i0) r12
                r13 = r3
                com.sumsub.sentry.o r13 = (com.sumsub.sentry.o) r13
                r14 = 0
                r6 = r0
                r8 = r1
                r6.<init>((int) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.Long) r11, (com.sumsub.sentry.i0) r12, (com.sumsub.sentry.o) r13, (kotlinx.serialization.internal.q1) r14)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.a0.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.a0");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(x0.f57786a), h10.a.u(i0.a.f30385a), h10.a.u(o.a.f30456a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30258b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, a0 a0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            a0.a(a0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<a0> serializer() {
            return a.f30257a;
        }

        public b() {
        }
    }

    public a0() {
        this((String) null, (String) null, (String) null, (Long) null, (i0) null, (o) null, 63, (r) null);
    }

    public static final void a(a0 a0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || a0Var.f30251a != null) {
            bVar.y(fVar, 0, v1.f57779a, a0Var.f30251a);
        }
        if (bVar.q(fVar, 1) || a0Var.f30252b != null) {
            bVar.y(fVar, 1, v1.f57779a, a0Var.f30252b);
        }
        if (bVar.q(fVar, 2) || a0Var.f30253c != null) {
            bVar.y(fVar, 2, v1.f57779a, a0Var.f30253c);
        }
        if (bVar.q(fVar, 3) || a0Var.f30254d != null) {
            bVar.y(fVar, 3, x0.f57786a, a0Var.f30254d);
        }
        if (bVar.q(fVar, 4) || a0Var.f30255e != null) {
            bVar.y(fVar, 4, i0.a.f30385a, a0Var.f30255e);
        }
        if (bVar.q(fVar, 5) || a0Var.f30256f != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 5, o.a.f30456a, a0Var.f30256f);
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

    public final String c() {
        return this.f30253c;
    }

    public final i0 e() {
        return this.f30255e;
    }

    public final Long g() {
        return this.f30254d;
    }

    public final String i() {
        return this.f30251a;
    }

    public final String k() {
        return this.f30252b;
    }

    public /* synthetic */ a0(int i11, String str, String str2, String str3, Long l11, i0 i0Var, o oVar, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f30257a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f30251a = null;
        } else {
            this.f30251a = str;
        }
        if ((i11 & 2) == 0) {
            this.f30252b = null;
        } else {
            this.f30252b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f30253c = null;
        } else {
            this.f30253c = str3;
        }
        if ((i11 & 8) == 0) {
            this.f30254d = null;
        } else {
            this.f30254d = l11;
        }
        if ((i11 & 16) == 0) {
            this.f30255e = null;
        } else {
            this.f30255e = i0Var;
        }
        if ((i11 & 32) == 0) {
            this.f30256f = null;
        } else {
            this.f30256f = oVar;
        }
    }

    public final o a() {
        return this.f30256f;
    }

    public a0(String str, String str2, String str3, Long l11, i0 i0Var, o oVar) {
        this.f30251a = str;
        this.f30252b = str2;
        this.f30253c = str3;
        this.f30254d = l11;
        this.f30255e = i0Var;
        this.f30256f = oVar;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a0(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.Long r9, com.sumsub.sentry.i0 r10, com.sumsub.sentry.o r11, int r12, kotlin.jvm.internal.r r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.a0.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Long, com.sumsub.sentry.i0, com.sumsub.sentry.o, int, kotlin.jvm.internal.r):void");
    }
}
