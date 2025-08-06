package com.sumsub.sns.internal.core.data.model.remote;

import com.facebook.places.model.PlaceFields;
import com.sumsub.sns.internal.core.data.model.remote.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 ,2\u00020\u0001:\u0002\b\nB7\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b&\u0010'BQ\b\u0017\u0012\u0006\u0010(\u001a\u00020\u0014\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b&\u0010+J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\b\u001a\u00020\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J;\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\t\u0010\u0013\u001a\u00020\tHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\u000f\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0019\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0019\u0012\u0004\b\u001f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001bR\"\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u0012\u0004\b!\u0010\u001d\u001a\u0004\b \u0010\u001bR&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\"\u0012\u0004\b%\u0010\u001d\u001a\u0004\b#\u0010$¨\u0006-"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/d;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "c", "", "Lcom/sumsub/sns/internal/core/data/model/remote/e;", "d", "id", "email", "phone", "metadata", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "getId$annotations", "()V", "e", "getEmail$annotations", "k", "getPhone$annotations", "Ljava/util/List;", "i", "()Ljava/util/List;", "getMetadata$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class d {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f32709a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32710b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32711c;

    /* renamed from: d  reason: collision with root package name */
    public final List<e> f32712d;

    public static final class a implements d0<d> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32713a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32714b;

        static {
            a aVar = new a();
            f32713a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.Metadata", aVar, 4);
            pluginGeneratedSerialDescriptor.k("id", false);
            pluginGeneratedSerialDescriptor.k("email", true);
            pluginGeneratedSerialDescriptor.k(PlaceFields.PHONE, true);
            pluginGeneratedSerialDescriptor.k("metadata", true);
            f32714b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.model.remote.d deserialize(kotlinx.serialization.encoding.c r20) {
            /*
                r19 = this;
                kotlinx.serialization.descriptors.f r0 = r19.getDescriptor()
                r1 = r20
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 3
                r4 = 2
                r5 = 0
                r6 = 0
                r7 = 1
                if (r2 == 0) goto L_0x0033
                java.lang.String r2 = r1.i(r0, r6)
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r7 = r1.j(r0, r7, r6, r5)
                java.lang.Object r4 = r1.j(r0, r4, r6, r5)
                kotlinx.serialization.internal.e r6 = new kotlinx.serialization.internal.e
                com.sumsub.sns.internal.core.data.model.remote.e$a r8 = com.sumsub.sns.internal.core.data.model.remote.e.a.f32717a
                r6.<init>(r8)
                java.lang.Object r3 = r1.p(r0, r3, r6, r5)
                r5 = 15
                r14 = r2
                r13 = r5
                goto L_0x007e
            L_0x0033:
                r2 = r5
                r8 = r2
                r9 = r8
                r10 = r9
                r5 = r6
                r11 = r7
            L_0x0039:
                if (r11 == 0) goto L_0x0079
                int r12 = r1.w(r0)
                r13 = -1
                if (r12 == r13) goto L_0x0077
                if (r12 == 0) goto L_0x0070
                if (r12 == r7) goto L_0x0067
                if (r12 == r4) goto L_0x005e
                if (r12 != r3) goto L_0x0058
                kotlinx.serialization.internal.e r12 = new kotlinx.serialization.internal.e
                com.sumsub.sns.internal.core.data.model.remote.e$a r13 = com.sumsub.sns.internal.core.data.model.remote.e.a.f32717a
                r12.<init>(r13)
                java.lang.Object r10 = r1.p(r0, r3, r12, r10)
                r5 = r5 | 8
                goto L_0x0039
            L_0x0058:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r12)
                throw r0
            L_0x005e:
                kotlinx.serialization.internal.v1 r12 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r9 = r1.j(r0, r4, r12, r9)
                r5 = r5 | 4
                goto L_0x0039
            L_0x0067:
                kotlinx.serialization.internal.v1 r12 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r8 = r1.j(r0, r7, r12, r8)
                r5 = r5 | 2
                goto L_0x0039
            L_0x0070:
                java.lang.String r2 = r1.i(r0, r6)
                r5 = r5 | 1
                goto L_0x0039
            L_0x0077:
                r11 = r6
                goto L_0x0039
            L_0x0079:
                r14 = r2
                r13 = r5
                r7 = r8
                r4 = r9
                r3 = r10
            L_0x007e:
                r1.c(r0)
                com.sumsub.sns.internal.core.data.model.remote.d r0 = new com.sumsub.sns.internal.core.data.model.remote.d
                r15 = r7
                java.lang.String r15 = (java.lang.String) r15
                r16 = r4
                java.lang.String r16 = (java.lang.String) r16
                r17 = r3
                java.util.List r17 = (java.util.List) r17
                r18 = 0
                r12 = r0
                r12.<init>((int) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16, (java.util.List) r17, (kotlinx.serialization.internal.q1) r18)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.d.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.d");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{v1Var, h10.a.u(v1Var), h10.a.u(v1Var), new e(e.a.f32717a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32714b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(kotlinx.serialization.encoding.d dVar, d dVar2) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            d.a(dVar2, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<d> serializer() {
            return a.f32713a;
        }

        public b() {
        }
    }

    public /* synthetic */ d(int i11, String str, String str2, String str3, List list, q1 q1Var) {
        if (1 != (i11 & 1)) {
            h1.a(i11, 1, a.f32713a.getDescriptor());
        }
        this.f32709a = str;
        if ((i11 & 2) == 0) {
            this.f32710b = null;
        } else {
            this.f32710b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f32711c = null;
        } else {
            this.f32711c = str3;
        }
        if ((i11 & 8) == 0) {
            this.f32712d = CollectionsKt__CollectionsKt.k();
        } else {
            this.f32712d = list;
        }
    }

    public static /* synthetic */ void f() {
    }

    public static /* synthetic */ void h() {
    }

    public static /* synthetic */ void j() {
    }

    public static /* synthetic */ void l() {
    }

    public final String a() {
        return this.f32709a;
    }

    public final String b() {
        return this.f32710b;
    }

    public final String c() {
        return this.f32711c;
    }

    public final List<e> d() {
        return this.f32712d;
    }

    public final String e() {
        return this.f32710b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return x.b(this.f32709a, dVar.f32709a) && x.b(this.f32710b, dVar.f32710b) && x.b(this.f32711c, dVar.f32711c) && x.b(this.f32712d, dVar.f32712d);
    }

    public final String g() {
        return this.f32709a;
    }

    public int hashCode() {
        int hashCode = this.f32709a.hashCode() * 31;
        String str = this.f32710b;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f32711c;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return ((hashCode2 + i11) * 31) + this.f32712d.hashCode();
    }

    public final List<e> i() {
        return this.f32712d;
    }

    public final String k() {
        return this.f32711c;
    }

    public String toString() {
        return "Metadata(id=" + this.f32709a + ", email=" + this.f32710b + ", phone=" + this.f32711c + ", metadata=" + this.f32712d + ')';
    }

    public final d a(String str, String str2, String str3, List<e> list) {
        return new d(str, str2, str3, list);
    }

    public static /* synthetic */ d a(d dVar, String str, String str2, String str3, List<e> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = dVar.f32709a;
        }
        if ((i11 & 2) != 0) {
            str2 = dVar.f32710b;
        }
        if ((i11 & 4) != 0) {
            str3 = dVar.f32711c;
        }
        if ((i11 & 8) != 0) {
            list = dVar.f32712d;
        }
        return dVar.a(str, str2, str3, list);
    }

    public d(String str, String str2, String str3, List<e> list) {
        this.f32709a = str;
        this.f32710b = str2;
        this.f32711c = str3;
        this.f32712d = list;
    }

    public static final void a(d dVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        bVar.p(fVar, 0, dVar.f32709a);
        if (bVar.q(fVar, 1) || dVar.f32710b != null) {
            bVar.y(fVar, 1, v1.f57779a, dVar.f32710b);
        }
        if (bVar.q(fVar, 2) || dVar.f32711c != null) {
            bVar.y(fVar, 2, v1.f57779a, dVar.f32711c);
        }
        if (bVar.q(fVar, 3) || !x.b(dVar.f32712d, CollectionsKt__CollectionsKt.k())) {
            z11 = true;
        }
        if (z11) {
            bVar.F(fVar, 3, new kotlinx.serialization.internal.e(e.a.f32717a), dVar.f32712d);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(String str, String str2, String str3, List list, int i11, r rVar) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? CollectionsKt__CollectionsKt.k() : list);
    }
}
