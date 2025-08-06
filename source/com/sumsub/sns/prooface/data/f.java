package com.sumsub.sns.prooface.data;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\b\u0017B\u0013\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010B'\b\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0015J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\"\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/prooface/data/f;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "()Ljava/lang/String;", "getPayload$annotations", "()V", "payload", "<init>", "(Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@kotlinx.serialization.f
public final class f {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f40194a;

    public static final class a implements d0<f> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f40195a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f40196b;

        static {
            a aVar = new a();
            f40195a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.prooface.data.LivenessFragment", aVar, 1);
            pluginGeneratedSerialDescriptor.k("payload", true);
            f40196b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public f deserialize(c cVar) {
            Object obj;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            int i11 = 1;
            if (b11.k()) {
                obj = b11.j(descriptor, 0, v1.f57779a, null);
            } else {
                obj = null;
                int i12 = 0;
                while (i11 != 0) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        i11 = 0;
                    } else if (w11 == 0) {
                        obj = b11.j(descriptor, 0, v1.f57779a, obj);
                        i12 |= 1;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                i11 = i12;
            }
            b11.c(descriptor);
            return new f(i11, (String) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{h10.a.u(v1.f57779a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f40196b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, f fVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            f.a(fVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<f> serializer() {
            return a.f40195a;
        }

        public b() {
        }
    }

    public f() {
        this((String) null, 1, (r) null);
    }

    public static final void a(f fVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar2) {
        if (bVar.q(fVar2, 0) || fVar.f40194a != null) {
            bVar.y(fVar2, 0, v1.f57779a, fVar.f40194a);
        }
    }

    public static /* synthetic */ void b() {
    }

    public /* synthetic */ f(int i11, String str, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f40195a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f40194a = null;
        } else {
            this.f40194a = str;
        }
    }

    public final String a() {
        return this.f40194a;
    }

    public f(String str) {
        this.f40194a = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(String str, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str);
    }
}
