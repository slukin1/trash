package com.sumsub.sns.internal.core.data.model.remote;

import com.sumsub.sns.internal.core.data.model.remote.h;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\b\u0015B%\u0012\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\t¢\u0006\u0004\b\u0019\u0010\u001aB9\b\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u000f\u0012\u001c\b\u0001\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\t\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u0019\u0010\u001eJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u001d\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\tHÆ\u0003J'\u0010\b\u001a\u00020\u00002\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\tHÆ\u0001J\t\u0010\u000e\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003R4\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/a;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "", "", "Lcom/sumsub/sns/internal/core/data/model/remote/h;", "supportedSources", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "getSupportedSources$annotations", "()V", "<init>", "(Ljava/util/Map;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/util/Map;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class a {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, List<h>> f32696a;

    /* renamed from: com.sumsub.sns.internal.core.data.model.remote.a$a  reason: collision with other inner class name */
    public static final class C0344a implements d0<a> {

        /* renamed from: a  reason: collision with root package name */
        public static final C0344a f32697a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32698b;

        static {
            C0344a aVar = new C0344a();
            f32697a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.EKycConfig", aVar, 1);
            pluginGeneratedSerialDescriptor.k("supportedSources", true);
            f32698b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public a deserialize(c cVar) {
            Object obj;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            int i11 = 1;
            if (b11.k()) {
                obj = b11.j(descriptor, 0, new r0(v1.f57779a, new e(h.a.f32746a)), null);
            } else {
                obj = null;
                int i12 = 0;
                while (i11 != 0) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        i11 = 0;
                    } else if (w11 == 0) {
                        obj = b11.j(descriptor, 0, new r0(v1.f57779a, new e(h.a.f32746a)), obj);
                        i12 |= 1;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                i11 = i12;
            }
            b11.c(descriptor);
            return new a(i11, (Map) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{h10.a.u(new r0(v1.f57779a, new e(h.a.f32746a)))};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32698b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, a aVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            a.a(aVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<a> serializer() {
            return C0344a.f32697a;
        }

        public b() {
        }
    }

    public a() {
        this((Map) null, 1, (r) null);
    }

    public static /* synthetic */ void c() {
    }

    public final Map<String, List<h>> a() {
        return this.f32696a;
    }

    public final Map<String, List<h>> b() {
        return this.f32696a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && x.b(this.f32696a, ((a) obj).f32696a);
    }

    public int hashCode() {
        Map<String, List<h>> map = this.f32696a;
        if (map == null) {
            return 0;
        }
        return map.hashCode();
    }

    public String toString() {
        return "EKycConfig(supportedSources=" + this.f32696a + ')';
    }

    public /* synthetic */ a(int i11, Map map, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, C0344a.f32697a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f32696a = null;
        } else {
            this.f32696a = map;
        }
    }

    public final a a(Map<String, ? extends List<h>> map) {
        return new a(map);
    }

    public a(Map<String, ? extends List<h>> map) {
        this.f32696a = map;
    }

    public static /* synthetic */ a a(a aVar, Map<String, List<h>> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = aVar.f32696a;
        }
        return aVar.a(map);
    }

    public static final void a(a aVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        if (bVar.q(fVar, 0) || aVar.f32696a != null) {
            bVar.y(fVar, 0, new r0(v1.f57779a, new e(h.a.f32746a)), aVar.f32696a);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Map map, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : map);
    }
}
