package com.sumsub.sns.internal.core.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 32\u00020\u0001:\u0002\b\fBU\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b-\u0010.Bi\b\u0017\u0012\u0006\u0010/\u001a\u00020\u0019\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0001\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\b\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b-\u00102J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000e\u0010\b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0000J\u000b\u0010\b\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0003JW\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\t\u0010\u0018\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001c\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010\u001c\u0012\u0004\b\"\u0010 \u001a\u0004\b!\u0010\u001eR\"\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u001c\u0012\u0004\b$\u0010 \u001a\u0004\b#\u0010\u001eR(\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010%\u0012\u0004\b(\u0010 \u001a\u0004\b&\u0010'R\"\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u001c\u0012\u0004\b*\u0010 \u001a\u0004\b)\u0010\u001eR\"\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u001c\u0012\u0004\b,\u0010 \u001a\u0004\b+\u0010\u001e¨\u00064"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/b;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "other", "", "", "b", "c", "", "d", "e", "f", "content", "createdAt", "source", "targets", "link", "titleKey", "toString", "", "hashCode", "equals", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "getContent$annotations", "()V", "i", "getCreatedAt$annotations", "m", "getSource$annotations", "Ljava/util/List;", "o", "()Ljava/util/List;", "getTargets$annotations", "k", "getLink$annotations", "q", "getTitleKey$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class b {
    public static final C0337b Companion = new C0337b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f32515a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32516b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32517c;

    /* renamed from: d  reason: collision with root package name */
    public final List<String> f32518d;

    /* renamed from: e  reason: collision with root package name */
    public final String f32519e;

    /* renamed from: f  reason: collision with root package name */
    public final String f32520f;

    public static final class a implements d0<b> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32521a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32522b;

        static {
            a aVar = new a();
            f32521a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.Agreement", aVar, 6);
            pluginGeneratedSerialDescriptor.k("content", true);
            pluginGeneratedSerialDescriptor.k("createdAt", true);
            pluginGeneratedSerialDescriptor.k("source", true);
            pluginGeneratedSerialDescriptor.k("targets", true);
            pluginGeneratedSerialDescriptor.k("link", true);
            pluginGeneratedSerialDescriptor.k("titleKey", true);
            f32522b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.model.b deserialize(kotlinx.serialization.encoding.c r17) {
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
                if (r2 == 0) goto L_0x003c
                kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r7 = r1.j(r0, r7, r2, r9)
                java.lang.Object r8 = r1.j(r0, r8, r2, r9)
                java.lang.Object r6 = r1.j(r0, r6, r2, r9)
                kotlinx.serialization.internal.e r10 = new kotlinx.serialization.internal.e
                r10.<init>(r2)
                java.lang.Object r4 = r1.j(r0, r4, r10, r9)
                java.lang.Object r5 = r1.j(r0, r5, r2, r9)
                java.lang.Object r2 = r1.j(r0, r3, r2, r9)
                r3 = 63
                r12 = r4
                r4 = r3
                goto L_0x009a
            L_0x003c:
                r2 = r7
                r15 = r8
                r10 = r9
                r11 = r10
                r12 = r11
                r13 = r12
                r14 = r13
            L_0x0043:
                if (r15 == 0) goto L_0x0094
                int r7 = r1.w(r0)
                switch(r7) {
                    case -1: goto L_0x0091;
                    case 0: goto L_0x0086;
                    case 1: goto L_0x007b;
                    case 2: goto L_0x0072;
                    case 3: goto L_0x0064;
                    case 4: goto L_0x005b;
                    case 5: goto L_0x0052;
                    default: goto L_0x004c;
                }
            L_0x004c:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r7)
                throw r0
            L_0x0052:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r14 = r1.j(r0, r3, r7, r14)
                r2 = r2 | 32
                goto L_0x0084
            L_0x005b:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r13 = r1.j(r0, r5, r7, r13)
                r2 = r2 | 16
                goto L_0x0084
            L_0x0064:
                kotlinx.serialization.internal.e r7 = new kotlinx.serialization.internal.e
                kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                r7.<init>(r3)
                java.lang.Object r12 = r1.j(r0, r4, r7, r12)
                r2 = r2 | 8
                goto L_0x0083
            L_0x0072:
                kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r11 = r1.j(r0, r6, r3, r11)
                r2 = r2 | 4
                goto L_0x0083
            L_0x007b:
                kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r10 = r1.j(r0, r8, r3, r10)
                r2 = r2 | 2
            L_0x0083:
                r3 = 5
            L_0x0084:
                r7 = 0
                goto L_0x0043
            L_0x0086:
                kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                r7 = 0
                java.lang.Object r9 = r1.j(r0, r7, r3, r9)
                r2 = r2 | 1
                r3 = 5
                goto L_0x0043
            L_0x0091:
                r7 = 0
                r15 = r7
                goto L_0x0043
            L_0x0094:
                r4 = r2
                r7 = r9
                r8 = r10
                r6 = r11
                r5 = r13
                r2 = r14
            L_0x009a:
                r1.c(r0)
                com.sumsub.sns.internal.core.data.model.b r0 = new com.sumsub.sns.internal.core.data.model.b
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
                r7 = r8
                java.lang.String r7 = (java.lang.String) r7
                r8 = r6
                java.lang.String r8 = (java.lang.String) r8
                r9 = r12
                java.util.List r9 = (java.util.List) r9
                r10 = r5
                java.lang.String r10 = (java.lang.String) r10
                java.lang.String r2 = (java.lang.String) r2
                r11 = 0
                r3 = r0
                r5 = r1
                r6 = r7
                r7 = r8
                r8 = r9
                r9 = r10
                r10 = r2
                r3.<init>((int) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.util.List) r8, (java.lang.String) r9, (java.lang.String) r10, (kotlinx.serialization.internal.q1) r11)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.b.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.b");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(new e(v1Var)), h10.a.u(v1Var), h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32522b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, b bVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            b.a(bVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    /* renamed from: com.sumsub.sns.internal.core.data.model.b$b  reason: collision with other inner class name */
    public static final class C0337b {
        public /* synthetic */ C0337b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<b> serializer() {
            return a.f32521a;
        }

        public C0337b() {
        }
    }

    public b() {
        this((String) null, (String) null, (String) null, (List) null, (String) null, (String) null, 63, (r) null);
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

    public static /* synthetic */ void r() {
    }

    public final String a() {
        return this.f32515a;
    }

    public final String b() {
        return this.f32516b;
    }

    public final String c() {
        return this.f32517c;
    }

    public final List<String> d() {
        return this.f32518d;
    }

    public final String e() {
        return this.f32519e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return x.b(this.f32515a, bVar.f32515a) && x.b(this.f32516b, bVar.f32516b) && x.b(this.f32517c, bVar.f32517c) && x.b(this.f32518d, bVar.f32518d) && x.b(this.f32519e, bVar.f32519e) && x.b(this.f32520f, bVar.f32520f);
    }

    public final String f() {
        return this.f32520f;
    }

    public final String g() {
        return this.f32515a;
    }

    public int hashCode() {
        String str = this.f32515a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f32516b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f32517c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<String> list = this.f32518d;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.f32519e;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f32520f;
        if (str5 != null) {
            i11 = str5.hashCode();
        }
        return hashCode5 + i11;
    }

    public final String i() {
        return this.f32516b;
    }

    public final String k() {
        return this.f32519e;
    }

    public final String m() {
        return this.f32517c;
    }

    public final List<String> o() {
        return this.f32518d;
    }

    public final String q() {
        return this.f32520f;
    }

    public String toString() {
        return "Agreement(content=" + this.f32515a + ", createdAt=" + this.f32516b + ", source=" + this.f32517c + ", targets=" + this.f32518d + ", link=" + this.f32519e + ", titleKey=" + this.f32520f + ')';
    }

    public /* synthetic */ b(int i11, String str, String str2, String str3, List list, String str4, String str5, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f32521a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f32515a = null;
        } else {
            this.f32515a = str;
        }
        if ((i11 & 2) == 0) {
            this.f32516b = null;
        } else {
            this.f32516b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f32517c = "msdk";
        } else {
            this.f32517c = str3;
        }
        if ((i11 & 8) == 0) {
            this.f32518d = null;
        } else {
            this.f32518d = list;
        }
        if ((i11 & 16) == 0) {
            this.f32519e = null;
        } else {
            this.f32519e = str4;
        }
        if ((i11 & 32) == 0) {
            this.f32520f = null;
        } else {
            this.f32520f = str5;
        }
    }

    public final b a(String str, String str2, String str3, List<String> list, String str4, String str5) {
        return new b(str, str2, str3, list, str4, str5);
    }

    public b(String str, String str2, String str3, List<String> list, String str4, String str5) {
        this.f32515a = str;
        this.f32516b = str2;
        this.f32517c = str3;
        this.f32518d = list;
        this.f32519e = str4;
        this.f32520f = str5;
    }

    public static /* synthetic */ b a(b bVar, String str, String str2, String str3, List<String> list, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = bVar.f32515a;
        }
        if ((i11 & 2) != 0) {
            str2 = bVar.f32516b;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = bVar.f32517c;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            list = bVar.f32518d;
        }
        List<String> list2 = list;
        if ((i11 & 16) != 0) {
            str4 = bVar.f32519e;
        }
        String str8 = str4;
        if ((i11 & 32) != 0) {
            str5 = bVar.f32520f;
        }
        return bVar.a(str, str6, str7, list2, str8, str5);
    }

    public static final void a(b bVar, kotlinx.serialization.encoding.b bVar2, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar2.q(fVar, 0) || bVar.f32515a != null) {
            bVar2.y(fVar, 0, v1.f57779a, bVar.f32515a);
        }
        if (bVar2.q(fVar, 1) || bVar.f32516b != null) {
            bVar2.y(fVar, 1, v1.f57779a, bVar.f32516b);
        }
        if (bVar2.q(fVar, 2) || !x.b(bVar.f32517c, "msdk")) {
            bVar2.y(fVar, 2, v1.f57779a, bVar.f32517c);
        }
        if (bVar2.q(fVar, 3) || bVar.f32518d != null) {
            bVar2.y(fVar, 3, new e(v1.f57779a), bVar.f32518d);
        }
        if (bVar2.q(fVar, 4) || bVar.f32519e != null) {
            bVar2.y(fVar, 4, v1.f57779a, bVar.f32519e);
        }
        if (bVar2.q(fVar, 5) || bVar.f32520f != null) {
            z11 = true;
        }
        if (z11) {
            bVar2.y(fVar, 5, v1.f57779a, bVar.f32520f);
        }
    }

    public final boolean a(b bVar) {
        return x.b(bVar.f32518d, this.f32518d) && x.b(bVar.f32515a, this.f32515a) && x.b(bVar.f32519e, this.f32519e);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.util.List r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.internal.r r13) {
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
            java.lang.String r8 = "msdk"
        L_0x0015:
            r2 = r8
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
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.b.<init>(java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, int, kotlin.jvm.internal.r):void");
    }
}
