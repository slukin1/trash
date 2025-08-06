package com.sumsub.sns.internal.core.data.model.remote;

import com.facebook.appevents.UserDataStore;
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

@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 +2\u00020\u0001:\u0002\b\nB-\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b%\u0010&BQ\b\u0017\u0012\u0006\u0010'\u001a\u00020\u0013\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u0012\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b%\u0010*J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\b\u001a\u00020\tHÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\tHÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\fHÆ\u0003J7\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\fHÆ\u0001J\t\u0010\u0012\u001a\u00020\tHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\u000e\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0018\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR \u0010\u000f\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u0012\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001aR \u0010\u0010\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u0012\u0004\b \u0010\u001c\u001a\u0004\b\u001f\u0010\u001aR&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010!\u0012\u0004\b$\u0010\u001c\u001a\u0004\b\"\u0010#¨\u0006,"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/b;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "c", "", "d", "imageId", "country", "idDocType", "data", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "getImageId$annotations", "()V", "e", "getCountry$annotations", "i", "getIdDocType$annotations", "Ljava/util/List;", "g", "()Ljava/util/List;", "getData$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class b {
    public static final C0345b Companion = new C0345b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f32699a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32700b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32701c;

    /* renamed from: d  reason: collision with root package name */
    public final List<String> f32702d;

    public static final class a implements d0<b> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32703a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32704b;

        static {
            a aVar = new a();
            f32703a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.MRTDData", aVar, 4);
            pluginGeneratedSerialDescriptor.k("imageId", false);
            pluginGeneratedSerialDescriptor.k(UserDataStore.COUNTRY, false);
            pluginGeneratedSerialDescriptor.k("idDocType", false);
            pluginGeneratedSerialDescriptor.k("data", false);
            f32704b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.model.remote.b deserialize(kotlinx.serialization.encoding.c r20) {
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
                if (r2 == 0) goto L_0x0034
                java.lang.String r2 = r1.i(r0, r6)
                java.lang.String r6 = r1.i(r0, r7)
                java.lang.String r4 = r1.i(r0, r4)
                kotlinx.serialization.internal.e r7 = new kotlinx.serialization.internal.e
                kotlinx.serialization.internal.v1 r8 = kotlinx.serialization.internal.v1.f57779a
                r7.<init>(r8)
                java.lang.Object r3 = r1.p(r0, r3, r7, r5)
                r5 = 15
                r14 = r2
                r16 = r4
                r13 = r5
                r15 = r6
                goto L_0x007c
            L_0x0034:
                r2 = r5
                r8 = r2
                r9 = r8
                r10 = r9
                r5 = r6
                r11 = r7
            L_0x003a:
                if (r11 == 0) goto L_0x0076
                int r12 = r1.w(r0)
                r13 = -1
                if (r12 == r13) goto L_0x0074
                if (r12 == 0) goto L_0x006d
                if (r12 == r7) goto L_0x0066
                if (r12 == r4) goto L_0x005f
                if (r12 != r3) goto L_0x0059
                kotlinx.serialization.internal.e r12 = new kotlinx.serialization.internal.e
                kotlinx.serialization.internal.v1 r13 = kotlinx.serialization.internal.v1.f57779a
                r12.<init>(r13)
                java.lang.Object r10 = r1.p(r0, r3, r12, r10)
                r5 = r5 | 8
                goto L_0x003a
            L_0x0059:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r12)
                throw r0
            L_0x005f:
                java.lang.String r9 = r1.i(r0, r4)
                r5 = r5 | 4
                goto L_0x003a
            L_0x0066:
                java.lang.String r8 = r1.i(r0, r7)
                r5 = r5 | 2
                goto L_0x003a
            L_0x006d:
                java.lang.String r2 = r1.i(r0, r6)
                r5 = r5 | 1
                goto L_0x003a
            L_0x0074:
                r11 = r6
                goto L_0x003a
            L_0x0076:
                r14 = r2
                r13 = r5
                r15 = r8
                r16 = r9
                r3 = r10
            L_0x007c:
                r1.c(r0)
                com.sumsub.sns.internal.core.data.model.remote.b r0 = new com.sumsub.sns.internal.core.data.model.remote.b
                r17 = r3
                java.util.List r17 = (java.util.List) r17
                r18 = 0
                r12 = r0
                r12.<init>(r13, r14, r15, r16, r17, r18)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.b.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.b");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{v1Var, v1Var, v1Var, new e(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32704b;
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

    /* renamed from: com.sumsub.sns.internal.core.data.model.remote.b$b  reason: collision with other inner class name */
    public static final class C0345b {
        public /* synthetic */ C0345b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<b> serializer() {
            return a.f32703a;
        }

        public C0345b() {
        }
    }

    public /* synthetic */ b(int i11, String str, String str2, String str3, List list, q1 q1Var) {
        if (15 != (i11 & 15)) {
            h1.a(i11, 15, a.f32703a.getDescriptor());
        }
        this.f32699a = str;
        this.f32700b = str2;
        this.f32701c = str3;
        this.f32702d = list;
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
        return this.f32699a;
    }

    public final String b() {
        return this.f32700b;
    }

    public final String c() {
        return this.f32701c;
    }

    public final List<String> d() {
        return this.f32702d;
    }

    public final String e() {
        return this.f32700b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return x.b(this.f32699a, bVar.f32699a) && x.b(this.f32700b, bVar.f32700b) && x.b(this.f32701c, bVar.f32701c) && x.b(this.f32702d, bVar.f32702d);
    }

    public final List<String> g() {
        return this.f32702d;
    }

    public int hashCode() {
        return (((((this.f32699a.hashCode() * 31) + this.f32700b.hashCode()) * 31) + this.f32701c.hashCode()) * 31) + this.f32702d.hashCode();
    }

    public final String i() {
        return this.f32701c;
    }

    public final String k() {
        return this.f32699a;
    }

    public String toString() {
        return "MRTDData(imageId=" + this.f32699a + ", country=" + this.f32700b + ", idDocType=" + this.f32701c + ", data=" + this.f32702d + ')';
    }

    public b(String str, String str2, String str3, List<String> list) {
        this.f32699a = str;
        this.f32700b = str2;
        this.f32701c = str3;
        this.f32702d = list;
    }

    public final b a(String str, String str2, String str3, List<String> list) {
        return new b(str, str2, str3, list);
    }

    public static /* synthetic */ b a(b bVar, String str, String str2, String str3, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = bVar.f32699a;
        }
        if ((i11 & 2) != 0) {
            str2 = bVar.f32700b;
        }
        if ((i11 & 4) != 0) {
            str3 = bVar.f32701c;
        }
        if ((i11 & 8) != 0) {
            list = bVar.f32702d;
        }
        return bVar.a(str, str2, str3, list);
    }

    public static final void a(b bVar, kotlinx.serialization.encoding.b bVar2, kotlinx.serialization.descriptors.f fVar) {
        bVar2.p(fVar, 0, bVar.f32699a);
        bVar2.p(fVar, 1, bVar.f32700b);
        bVar2.p(fVar, 2, bVar.f32701c);
        bVar2.F(fVar, 3, new e(v1.f57779a), bVar.f32702d);
    }
}
