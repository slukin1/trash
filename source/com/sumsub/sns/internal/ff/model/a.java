package com.sumsub.sns.internal.ff.model;

import java.util.List;
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
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\b\u0013B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0017\u0010\u0018B-\b\u0017\u0012\u0006\u0010\u0019\u001a\u00020\r\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0017\u0010\u001cJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u0019\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\t\u0010\f\u001a\u00020\nHÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/sumsub/sns/internal/ff/model/a;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "", "requestedFlags", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/List;", "b", "()Ljava/util/List;", "getRequestedFlags$annotations", "()V", "<init>", "(Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class a {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f34254a;

    /* renamed from: com.sumsub.sns.internal.ff.model.a$a  reason: collision with other inner class name */
    public static final class C0387a implements d0<a> {

        /* renamed from: a  reason: collision with root package name */
        public static final C0387a f34255a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f34256b;

        static {
            C0387a aVar = new C0387a();
            f34255a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.ff.model.FeatureFlagsRequest", aVar, 1);
            pluginGeneratedSerialDescriptor.k("requestedFlags", false);
            f34256b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public a deserialize(c cVar) {
            Object obj;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            int i11 = 1;
            if (b11.k()) {
                obj = b11.p(descriptor, 0, new e(v1.f57779a), null);
            } else {
                obj = null;
                int i12 = 0;
                while (i11 != 0) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        i11 = 0;
                    } else if (w11 == 0) {
                        obj = b11.p(descriptor, 0, new e(v1.f57779a), obj);
                        i12 |= 1;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                i11 = i12;
            }
            b11.c(descriptor);
            return new a(i11, (List) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{new e(v1.f57779a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f34256b;
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
            return C0387a.f34255a;
        }

        public b() {
        }
    }

    public /* synthetic */ a(int i11, List list, q1 q1Var) {
        if (1 != (i11 & 1)) {
            h1.a(i11, 1, C0387a.f34255a.getDescriptor());
        }
        this.f34254a = list;
    }

    public static /* synthetic */ void c() {
    }

    public final List<String> a() {
        return this.f34254a;
    }

    public final List<String> b() {
        return this.f34254a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && x.b(this.f34254a, ((a) obj).f34254a);
    }

    public int hashCode() {
        return this.f34254a.hashCode();
    }

    public String toString() {
        return "FeatureFlagsRequest(requestedFlags=" + this.f34254a + ')';
    }

    public a(List<String> list) {
        this.f34254a = list;
    }

    public final a a(List<String> list) {
        return new a(list);
    }

    public static /* synthetic */ a a(a aVar, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = aVar.f34254a;
        }
        return aVar.a(list);
    }

    public static final void a(a aVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        bVar.F(fVar, 0, new e(v1.f57779a), aVar.f34254a);
    }
}
