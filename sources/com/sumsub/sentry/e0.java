package com.sumsub.sentry;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001a2\u00020\u0001:\u0002\b\u000fB\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014B3\b\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0019J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R \u0010\u000e\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000bR \u0010\u0012\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/sumsub/sentry/e0;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "()Ljava/lang/String;", "getName$annotations", "()V", "name", "b", "c", "getVersion$annotations", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class e0 {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f30324a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30325b;

    public static final class a implements d0<e0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30326a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30327b;

        static {
            a aVar = new a();
            f30326a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.SentryPackage", aVar, 2);
            pluginGeneratedSerialDescriptor.k("name", false);
            pluginGeneratedSerialDescriptor.k("version", false);
            f30327b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public e0 deserialize(c cVar) {
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
            return new e0(i11, str2, str, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{v1Var, v1Var};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30327b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, e0 e0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            e0.a(e0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<e0> serializer() {
            return a.f30326a;
        }

        public b() {
        }
    }

    public /* synthetic */ e0(int i11, String str, String str2, q1 q1Var) {
        if (3 != (i11 & 3)) {
            h1.a(i11, 3, a.f30326a.getDescriptor());
        }
        this.f30324a = str;
        this.f30325b = str2;
    }

    public static final void a(e0 e0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        bVar.p(fVar, 0, e0Var.f30324a);
        bVar.p(fVar, 1, e0Var.f30325b);
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void d() {
    }

    public final String c() {
        return this.f30325b;
    }

    public e0(String str, String str2) {
        this.f30324a = str;
        this.f30325b = str2;
    }

    public final String a() {
        return this.f30324a;
    }
}
