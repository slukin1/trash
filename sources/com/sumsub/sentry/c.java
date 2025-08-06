package com.sumsub.sentry;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001c2\u00020\u0001:\u0002\b\u000fB\u001f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0016B3\b\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0013\u0010\u001bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\"\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000bR\"\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/sumsub/sentry/c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "()Ljava/lang/String;", "getName$annotations", "()V", "name", "b", "c", "getVersion$annotations", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "browser", "(Lcom/sumsub/sentry/c;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class c {
    public static final b Companion = new b((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final String f30298c = "browser";

    /* renamed from: a  reason: collision with root package name */
    public final String f30299a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30300b;

    public static final class a implements d0<c> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30301a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30302b;

        static {
            a aVar = new a();
            f30301a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.Browser", aVar, 2);
            pluginGeneratedSerialDescriptor.k("name", true);
            pluginGeneratedSerialDescriptor.k("version", true);
            f30302b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public c deserialize(kotlinx.serialization.encoding.c cVar) {
            int i11;
            Object obj;
            Object obj2;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                v1 v1Var = v1.f57779a;
                obj = b11.j(descriptor, 0, v1Var, null);
                obj2 = b11.j(descriptor, 1, v1Var, null);
                i11 = 3;
            } else {
                obj2 = null;
                Object obj3 = null;
                int i12 = 0;
                boolean z11 = true;
                while (z11) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        z11 = false;
                    } else if (w11 == 0) {
                        obj3 = b11.j(descriptor, 0, v1.f57779a, obj3);
                        i12 |= 1;
                    } else if (w11 == 1) {
                        obj2 = b11.j(descriptor, 1, v1.f57779a, obj2);
                        i12 |= 2;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                obj = obj3;
                i11 = i12;
            }
            b11.c(descriptor);
            return new c(i11, (String) obj, (String) obj2, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30302b;
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
            return a.f30301a;
        }

        public b() {
        }
    }

    public c() {
        this((String) null, (String) null, 3, (r) null);
    }

    public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || cVar.f30299a != null) {
            bVar.y(fVar, 0, v1.f57779a, cVar.f30299a);
        }
        if (bVar.q(fVar, 1) || cVar.f30300b != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 1, v1.f57779a, cVar.f30300b);
        }
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void d() {
    }

    public final String c() {
        return this.f30300b;
    }

    public /* synthetic */ c(int i11, String str, String str2, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f30301a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f30299a = null;
        } else {
            this.f30299a = str;
        }
        if ((i11 & 2) == 0) {
            this.f30300b = null;
        } else {
            this.f30300b = str2;
        }
    }

    public final String a() {
        return this.f30299a;
    }

    public c(String str, String str2) {
        this.f30299a = str;
        this.f30300b = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(String str, String str2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }

    public c(c cVar) {
        this(cVar.f30299a, cVar.f30300b);
    }
}
