package com.sumsub.sns.internal.core.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.g;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0002\b\u0012B\u0007¢\u0006\u0004\b\u0018\u0010\u000fB3\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0018\u0010\u001dJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R(\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\b\u0010\n\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\b\u0010\rR*\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\b\u0010\u0014\"\u0004\b\b\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/v;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "getType$annotations", "()V", "type", "Lkotlinx/serialization/json/g;", "b", "Lkotlinx/serialization/json/g;", "()Lkotlinx/serialization/json/g;", "(Lkotlinx/serialization/json/g;)V", "getPayload$annotations", "payload", "<init>", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Lkotlinx/serialization/json/g;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class v {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public String f32933a;

    /* renamed from: b  reason: collision with root package name */
    public g f32934b;

    public static final class a implements d0<v> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32935a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32936b;

        static {
            a aVar = new a();
            f32935a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessageModel", aVar, 2);
            pluginGeneratedSerialDescriptor.k("type", true);
            pluginGeneratedSerialDescriptor.k("payload", true);
            f32936b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public v deserialize(c cVar) {
            int i11;
            Object obj;
            String str;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                str = b11.i(descriptor, 0);
                obj = b11.j(descriptor, 1, JsonElementSerializer.f57821a, null);
                i11 = 3;
            } else {
                str = null;
                Object obj2 = null;
                int i12 = 0;
                boolean z11 = true;
                while (z11) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        z11 = false;
                    } else if (w11 == 0) {
                        str = b11.i(descriptor, 0);
                        i12 |= 1;
                    } else if (w11 == 1) {
                        obj2 = b11.j(descriptor, 1, JsonElementSerializer.f57821a, obj2);
                        i12 |= 2;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                obj = obj2;
                i11 = i12;
            }
            b11.c(descriptor);
            return new v(i11, str, (g) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{v1.f57779a, h10.a.u(JsonElementSerializer.f57821a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32936b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, v vVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            v.a(vVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<v> serializer() {
            return a.f32935a;
        }

        public b() {
        }
    }

    public v() {
        this.f32933a = "";
    }

    public static final void a(v vVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || !x.b(vVar.f32933a, "")) {
            bVar.p(fVar, 0, vVar.f32933a);
        }
        if (bVar.q(fVar, 1) || vVar.f32934b != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 1, JsonElementSerializer.f57821a, vVar.f32934b);
        }
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void d() {
    }

    public final String c() {
        return this.f32933a;
    }

    public /* synthetic */ v(int i11, String str, g gVar, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f32935a.getDescriptor());
        }
        this.f32933a = (i11 & 1) == 0 ? "" : str;
        if ((i11 & 2) == 0) {
            this.f32934b = null;
        } else {
            this.f32934b = gVar;
        }
    }

    public final void a(String str) {
        this.f32933a = str;
    }

    public final g a() {
        return this.f32934b;
    }

    public final void a(g gVar) {
        this.f32934b = gVar;
    }
}
