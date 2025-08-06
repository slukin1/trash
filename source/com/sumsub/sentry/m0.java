package com.sumsub.sentry;

import java.util.ArrayList;
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

@f
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u001a*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\f\u001bB\u0017\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u0013\u0010\u0014B-\b\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0010\b\u0001\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0019J;\u0010\f\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\tHÇ\u0001R&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010\u000e\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/sumsub/sentry/m0;", "T", "", "T0", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "Lkotlinx/serialization/b;", "typeSerial0", "", "a", "", "Ljava/util/List;", "()Ljava/util/List;", "getValues$annotations", "()V", "values", "<init>", "(Ljava/util/List;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class m0<T> {
    public static final b Companion = new b((r) null);

    /* renamed from: b  reason: collision with root package name */
    public static final kotlinx.serialization.descriptors.f f30428b;

    /* renamed from: a  reason: collision with root package name */
    public final List<T> f30429a;

    public static final class a<T> implements d0<m0<T>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlinx.serialization.descriptors.f f30430a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlinx.serialization.b<T> f30431b;

        public a() {
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.SentryValues", this, 1);
            pluginGeneratedSerialDescriptor.k("values", true);
            this.f30430a = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public m0<T> deserialize(c cVar) {
            Object obj;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            int i11 = 1;
            if (b11.k()) {
                obj = b11.p(descriptor, 0, new e(this.f30431b), null);
            } else {
                obj = null;
                int i12 = 0;
                while (i11 != 0) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        i11 = 0;
                    } else if (w11 == 0) {
                        obj = b11.p(descriptor, 0, new e(this.f30431b), obj);
                        i12 |= 1;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                i11 = i12;
            }
            b11.c(descriptor);
            return new m0<>(i11, (List) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{new e(this.f30431b)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return this.f30430a;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: kotlinx.serialization.b<?>[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            /*
                r3 = this;
                r0 = 1
                kotlinx.serialization.b[] r0 = new kotlinx.serialization.b[r0]
                kotlinx.serialization.b<T> r1 = r3.f30431b
                r2 = 0
                r0[r2] = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.m0.a.typeParametersSerializers():kotlinx.serialization.b[]");
        }

        public /* synthetic */ a(kotlinx.serialization.b bVar) {
            this();
            this.f30431b = bVar;
        }

        /* renamed from: a */
        public void serialize(d dVar, m0<T> m0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            m0.a(m0Var, b11, descriptor, this.f30431b);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final <T0> kotlinx.serialization.b<m0<T0>> serializer(kotlinx.serialization.b<T0> bVar) {
            return new a(bVar);
        }

        public b() {
        }
    }

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.SentryValues", (d0<?>) null, 1);
        pluginGeneratedSerialDescriptor.k("values", true);
        f30428b = pluginGeneratedSerialDescriptor;
    }

    public m0() {
        this((List) null, 1, (r) null);
    }

    public static final <T0> void a(m0<T0> m0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar, kotlinx.serialization.b<T0> bVar2) {
        if (bVar.q(fVar, 0) || !x.b(m0Var.f30429a, new ArrayList(0))) {
            bVar.F(fVar, 0, new e(bVar2), m0Var.f30429a);
        }
    }

    public static /* synthetic */ void b() {
    }

    public /* synthetic */ m0(int i11, List list, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, f30428b);
        }
        if ((i11 & 1) == 0) {
            this.f30429a = new ArrayList(0);
        } else {
            this.f30429a = list;
        }
    }

    public final List<T> a() {
        return this.f30429a;
    }

    public m0(List<? extends T> list) {
        this.f30429a = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m0(List list, int i11, r rVar) {
        this((i11 & 1) != 0 ? new ArrayList(0) : list);
    }
}
