package com.sumsub.sns.internal.core.data.model.remote.response;

import com.sumsub.sns.internal.core.common.n0;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 '2\u00020\u0001:\u0003\b\n\fB\u001f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\"B?\b\u0017\u0012\u0006\u0010#\u001a\u00020\u0011\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b!\u0010&J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\b\u001a\u00020\tHÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J'\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u000bHÆ\u0001J\t\u0010\u0010\u001a\u00020\tHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\r\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0016\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R \u0010\u000e\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0016\u0012\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001b\u0010\u0018R \u0010\u000f\u001a\u00020\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010\u001d\u0012\u0004\b \u0010\u001a\u001a\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/response/g;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "Lcom/sumsub/sns/internal/core/data/model/remote/response/g$c;", "c", "type", "lang", "conf", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "getType$annotations", "()V", "f", "getLang$annotations", "Lcom/sumsub/sns/internal/core/data/model/remote/response/g$c;", "d", "()Lcom/sumsub/sns/internal/core/data/model/remote/response/g$c;", "getConf$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/remote/response/g$c;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/remote/response/g$c;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class g {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f32901a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32902b;

    /* renamed from: c  reason: collision with root package name */
    public final c f32903c;

    public static final class a implements d0<g> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32904a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32905b;

        static {
            a aVar = new a();
            f32904a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.response.StringResourcesResponse", aVar, 3);
            pluginGeneratedSerialDescriptor.k("type", false);
            pluginGeneratedSerialDescriptor.k("lang", false);
            pluginGeneratedSerialDescriptor.k("conf", false);
            f32905b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.model.remote.response.g deserialize(kotlinx.serialization.encoding.c r17) {
            /*
                r16 = this;
                kotlinx.serialization.descriptors.f r0 = r16.getDescriptor()
                r1 = r17
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 0
                r4 = 2
                r5 = 0
                r6 = 1
                if (r2 == 0) goto L_0x0027
                java.lang.String r2 = r1.i(r0, r5)
                java.lang.String r5 = r1.i(r0, r6)
                com.sumsub.sns.internal.core.data.model.remote.response.g$c$a r6 = com.sumsub.sns.internal.core.data.model.remote.response.g.c.a.f32908a
                java.lang.Object r3 = r1.p(r0, r4, r6, r3)
                r4 = 7
                r12 = r2
                r11 = r4
                r13 = r5
                goto L_0x005d
            L_0x0027:
                r2 = r3
                r7 = r2
                r8 = r5
                r9 = r6
            L_0x002b:
                if (r9 == 0) goto L_0x0059
                int r10 = r1.w(r0)
                r11 = -1
                if (r10 == r11) goto L_0x0057
                if (r10 == 0) goto L_0x0050
                if (r10 == r6) goto L_0x0049
                if (r10 != r4) goto L_0x0043
                com.sumsub.sns.internal.core.data.model.remote.response.g$c$a r10 = com.sumsub.sns.internal.core.data.model.remote.response.g.c.a.f32908a
                java.lang.Object r7 = r1.p(r0, r4, r10, r7)
                r8 = r8 | 4
                goto L_0x002b
            L_0x0043:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r10)
                throw r0
            L_0x0049:
                java.lang.String r2 = r1.i(r0, r6)
                r8 = r8 | 2
                goto L_0x002b
            L_0x0050:
                java.lang.String r3 = r1.i(r0, r5)
                r8 = r8 | 1
                goto L_0x002b
            L_0x0057:
                r9 = r5
                goto L_0x002b
            L_0x0059:
                r13 = r2
                r12 = r3
                r3 = r7
                r11 = r8
            L_0x005d:
                r1.c(r0)
                com.sumsub.sns.internal.core.data.model.remote.response.g r0 = new com.sumsub.sns.internal.core.data.model.remote.response.g
                r14 = r3
                com.sumsub.sns.internal.core.data.model.remote.response.g$c r14 = (com.sumsub.sns.internal.core.data.model.remote.response.g.c) r14
                r15 = 0
                r10 = r0
                r10.<init>(r11, r12, r13, r14, r15)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.g.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.response.g");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{v1Var, v1Var, c.a.f32908a};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32905b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, g gVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            g.a(gVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<g> serializer() {
            return a.f32904a;
        }

        public b() {
        }
    }

    @f
    @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0002\b\nB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bB3\b\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001a\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\b\u001a\u00020\tHÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tHÆ\u0001J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\u000b\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R \u0010\f\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0013\u0012\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0018\u0010\u0015¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/response/g$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "gtc", "pp", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "getGtc$annotations", "()V", "e", "getPp$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class c {
        public static final b Companion = new b((r) null);

        /* renamed from: a  reason: collision with root package name */
        public final String f32906a;

        /* renamed from: b  reason: collision with root package name */
        public final String f32907b;

        public static final class a implements d0<c> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f32908a;

            /* renamed from: b  reason: collision with root package name */
            public static final /* synthetic */ kotlinx.serialization.descriptors.f f32909b;

            static {
                a aVar = new a();
                f32908a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.response.StringResourcesResponse.Conf", aVar, 2);
                pluginGeneratedSerialDescriptor.k(n0.g.f32175b, false);
                pluginGeneratedSerialDescriptor.k(n0.g.f32176c, false);
                f32909b = pluginGeneratedSerialDescriptor;
            }

            /* renamed from: a */
            public c deserialize(kotlinx.serialization.encoding.c cVar) {
                int i11;
                String str;
                String str2;
                kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                if (b11.k()) {
                    str2 = b11.i(descriptor, 0);
                    str = b11.i(descriptor, 1);
                    i11 = 3;
                } else {
                    str2 = null;
                    String str3 = null;
                    int i12 = 0;
                    boolean z11 = true;
                    while (z11) {
                        int w11 = b11.w(descriptor);
                        if (w11 == -1) {
                            z11 = false;
                        } else if (w11 == 0) {
                            str2 = b11.i(descriptor, 0);
                            i12 |= 1;
                        } else if (w11 == 1) {
                            str3 = b11.i(descriptor, 1);
                            i12 |= 2;
                        } else {
                            throw new UnknownFieldException(w11);
                        }
                    }
                    str = str3;
                    i11 = i12;
                }
                b11.c(descriptor);
                return new c(i11, str2, str, (q1) null);
            }

            public kotlinx.serialization.b<?>[] childSerializers() {
                v1 v1Var = v1.f57779a;
                return new kotlinx.serialization.b[]{v1Var, v1Var};
            }

            public kotlinx.serialization.descriptors.f getDescriptor() {
                return f32909b;
            }

            public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }

            /* renamed from: a */
            public void serialize(d dVar, c cVar) {
                kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                c.a(cVar, b11, descriptor);
                b11.c(descriptor);
            }
        }

        public static final class b {
            public /* synthetic */ b(r rVar) {
                this();
            }

            public final kotlinx.serialization.b<c> serializer() {
                return a.f32908a;
            }

            public b() {
            }
        }

        public /* synthetic */ c(int i11, String str, String str2, q1 q1Var) {
            if (3 != (i11 & 3)) {
                h1.a(i11, 3, a.f32908a.getDescriptor());
            }
            this.f32906a = str;
            this.f32907b = str2;
        }

        public static /* synthetic */ void d() {
        }

        public static /* synthetic */ void f() {
        }

        public final String a() {
            return this.f32906a;
        }

        public final String b() {
            return this.f32907b;
        }

        public final String c() {
            return this.f32906a;
        }

        public final String e() {
            return this.f32907b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return x.b(this.f32906a, cVar.f32906a) && x.b(this.f32907b, cVar.f32907b);
        }

        public int hashCode() {
            return (this.f32906a.hashCode() * 31) + this.f32907b.hashCode();
        }

        public String toString() {
            return "Conf(gtc=" + this.f32906a + ", pp=" + this.f32907b + ')';
        }

        public c(String str, String str2) {
            this.f32906a = str;
            this.f32907b = str2;
        }

        public final c a(String str, String str2) {
            return new c(str, str2);
        }

        public static /* synthetic */ c a(c cVar, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = cVar.f32906a;
            }
            if ((i11 & 2) != 0) {
                str2 = cVar.f32907b;
            }
            return cVar.a(str, str2);
        }

        public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
            bVar.p(fVar, 0, cVar.f32906a);
            bVar.p(fVar, 1, cVar.f32907b);
        }
    }

    public /* synthetic */ g(int i11, String str, String str2, c cVar, q1 q1Var) {
        if (7 != (i11 & 7)) {
            h1.a(i11, 7, a.f32904a.getDescriptor());
        }
        this.f32901a = str;
        this.f32902b = str2;
        this.f32903c = cVar;
    }

    public static /* synthetic */ void e() {
    }

    public static /* synthetic */ void g() {
    }

    public static /* synthetic */ void i() {
    }

    public final String a() {
        return this.f32901a;
    }

    public final String b() {
        return this.f32902b;
    }

    public final c c() {
        return this.f32903c;
    }

    public final c d() {
        return this.f32903c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return x.b(this.f32901a, gVar.f32901a) && x.b(this.f32902b, gVar.f32902b) && x.b(this.f32903c, gVar.f32903c);
    }

    public final String f() {
        return this.f32902b;
    }

    public final String h() {
        return this.f32901a;
    }

    public int hashCode() {
        return (((this.f32901a.hashCode() * 31) + this.f32902b.hashCode()) * 31) + this.f32903c.hashCode();
    }

    public String toString() {
        return "StringResourcesResponse(type=" + this.f32901a + ", lang=" + this.f32902b + ", conf=" + this.f32903c + ')';
    }

    public g(String str, String str2, c cVar) {
        this.f32901a = str;
        this.f32902b = str2;
        this.f32903c = cVar;
    }

    public final g a(String str, String str2, c cVar) {
        return new g(str, str2, cVar);
    }

    public static /* synthetic */ g a(g gVar, String str, String str2, c cVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = gVar.f32901a;
        }
        if ((i11 & 2) != 0) {
            str2 = gVar.f32902b;
        }
        if ((i11 & 4) != 0) {
            cVar = gVar.f32903c;
        }
        return gVar.a(str, str2, cVar);
    }

    public static final void a(g gVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        bVar.p(fVar, 0, gVar.f32901a);
        bVar.p(fVar, 1, gVar.f32902b);
        bVar.F(fVar, 2, c.a.f32908a, gVar.f32903c);
    }
}
