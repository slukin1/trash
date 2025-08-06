package com.sumsub.sns.internal.core.data.source.applicant.remote;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 !2\u00020\u0001:\u0002\b\u000bB7\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0004\b\u001b\u0010\u001cBK\b\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u0012\u0016\b\u0001\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\u0016\b\u0001\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001b\u0010 J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0017\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tHÆ\u0003J\u0017\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tHÆ\u0003J9\u0010\b\u001a\u00020\u00002\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tHÆ\u0001J\t\u0010\u000e\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003R.\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R.\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0014\u0012\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u0019\u0010\u0016¨\u0006\""}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/b;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "", "b", "idDoc", "info", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "getIdDoc$annotations", "()V", "e", "getInfo$annotations", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class b {
    public static final C0358b Companion = new C0358b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f33059a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Object> f33060b;

    public static final class a implements d0<b> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33061a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33062b;

        static {
            a aVar = new a();
            f33061a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.ApplicantDataSubmitModel", aVar, 2);
            pluginGeneratedSerialDescriptor.k("idDoc", true);
            pluginGeneratedSerialDescriptor.k("info", true);
            f33062b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public b deserialize(c cVar) {
            int i11;
            Object obj;
            Object obj2;
            Class<Object> cls = Object.class;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                v1 v1Var = v1.f57779a;
                obj = b11.j(descriptor, 0, new r0(v1Var, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])), null);
                obj2 = b11.j(descriptor, 1, new r0(v1Var, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])), null);
                i11 = 3;
            } else {
                boolean z11 = true;
                Object obj3 = null;
                Object obj4 = null;
                int i12 = 0;
                while (z11) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        z11 = false;
                    } else if (w11 == 0) {
                        obj4 = b11.j(descriptor, 0, new r0(v1.f57779a, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])), obj4);
                        i12 |= 1;
                    } else if (w11 == 1) {
                        obj3 = b11.j(descriptor, 1, new r0(v1.f57779a, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])), obj3);
                        i12 |= 2;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                obj2 = obj3;
                obj = obj4;
                i11 = i12;
            }
            b11.c(descriptor);
            return new b(i11, (Map) obj, (Map) obj2, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            Class<Object> cls = Object.class;
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(new r0(v1Var, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0]))), h10.a.u(new r0(v1Var, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])))};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33062b;
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

    /* renamed from: com.sumsub.sns.internal.core.data.source.applicant.remote.b$b  reason: collision with other inner class name */
    public static final class C0358b {
        public /* synthetic */ C0358b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<b> serializer() {
            return a.f33061a;
        }

        public C0358b() {
        }
    }

    public b() {
        this((Map) null, (Map) null, 3, (r) null);
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public final Map<String, Object> a() {
        return this.f33059a;
    }

    public final Map<String, Object> b() {
        return this.f33060b;
    }

    public final Map<String, Object> c() {
        return this.f33059a;
    }

    public final Map<String, Object> e() {
        return this.f33060b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return x.b(this.f33059a, bVar.f33059a) && x.b(this.f33060b, bVar.f33060b);
    }

    public int hashCode() {
        Map<String, Object> map = this.f33059a;
        int i11 = 0;
        int hashCode = (map == null ? 0 : map.hashCode()) * 31;
        Map<String, Object> map2 = this.f33060b;
        if (map2 != null) {
            i11 = map2.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "ApplicantDataSubmitModel(idDoc=" + this.f33059a + ", info=" + this.f33060b + ')';
    }

    public /* synthetic */ b(int i11, Map map, Map map2, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33061a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33059a = null;
        } else {
            this.f33059a = map;
        }
        if ((i11 & 2) == 0) {
            this.f33060b = null;
        } else {
            this.f33060b = map2;
        }
    }

    public final b a(Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
        return new b(map, map2);
    }

    public b(Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
        this.f33059a = map;
        this.f33060b = map2;
    }

    public static /* synthetic */ b a(b bVar, Map<String, Object> map, Map<String, Object> map2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = bVar.f33059a;
        }
        if ((i11 & 2) != 0) {
            map2 = bVar.f33060b;
        }
        return bVar.a(map, map2);
    }

    public static final void a(b bVar, kotlinx.serialization.encoding.b bVar2, kotlinx.serialization.descriptors.f fVar) {
        Class<Object> cls = Object.class;
        if (bVar2.q(fVar, 0) || bVar.f33059a != null) {
            bVar2.y(fVar, 0, new r0(v1.f57779a, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])), bVar.f33059a);
        }
        if (bVar2.q(fVar, 1) || bVar.f33060b != null) {
            bVar2.y(fVar, 1, new r0(v1.f57779a, new ContextualSerializer(Reflection.b(cls), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])), bVar.f33060b);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Map map, Map map2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : map, (i11 & 2) != 0 ? null : map2);
    }
}
