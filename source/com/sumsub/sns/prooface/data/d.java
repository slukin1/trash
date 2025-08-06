package com.sumsub.sns.prooface.data;

import com.sumsub.sns.prooface.data.c;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\b\u0011B\u001f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0016\u0010\u0017B3\b\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0016\u0010\u001cJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\"\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\b\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/sumsub/sns/prooface/data/d;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "getFaceStatus$annotations", "()V", "faceStatus", "Lcom/sumsub/sns/prooface/data/c;", "b", "Lcom/sumsub/sns/prooface/data/c;", "()Lcom/sumsub/sns/prooface/data/c;", "getFaceMesh$annotations", "faceMesh", "<init>", "(Ljava/lang/String;Lcom/sumsub/sns/prooface/data/c;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/sumsub/sns/prooface/data/c;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class d {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f40182a;

    /* renamed from: b  reason: collision with root package name */
    public final c f40183b;

    public static final class a implements d0<d> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f40184a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f40185b;

        static {
            a aVar = new a();
            f40184a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.prooface.data.FilterOutput", aVar, 2);
            pluginGeneratedSerialDescriptor.k("faceStatus", true);
            pluginGeneratedSerialDescriptor.k("faceMesh", true);
            f40185b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public d deserialize(c cVar) {
            int i11;
            Object obj;
            Object obj2;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                obj2 = b11.j(descriptor, 0, v1.f57779a, null);
                obj = b11.j(descriptor, 1, c.a.f40180a, null);
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
                        obj2 = b11.j(descriptor, 0, v1.f57779a, obj2);
                        i12 |= 1;
                    } else if (w11 == 1) {
                        obj3 = b11.j(descriptor, 1, c.a.f40180a, obj3);
                        i12 |= 2;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                obj = obj3;
                i11 = i12;
            }
            b11.c(descriptor);
            return new d(i11, (String) obj2, (c) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{h10.a.u(v1.f57779a), h10.a.u(c.a.f40180a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f40185b;
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
            return a.f40184a;
        }

        public b() {
        }
    }

    public d() {
        this((String) null, (c) null, 3, (r) null);
    }

    public static final void a(d dVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || dVar.f40182a != null) {
            bVar.y(fVar, 0, v1.f57779a, dVar.f40182a);
        }
        if (bVar.q(fVar, 1) || dVar.f40183b != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 1, c.a.f40180a, dVar.f40183b);
        }
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void d() {
    }

    public final String c() {
        return this.f40182a;
    }

    public /* synthetic */ d(int i11, String str, c cVar, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f40184a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f40182a = null;
        } else {
            this.f40182a = str;
        }
        if ((i11 & 2) == 0) {
            this.f40183b = null;
        } else {
            this.f40183b = cVar;
        }
    }

    public final c a() {
        return this.f40183b;
    }

    public d(String str, c cVar) {
        this.f40182a = str;
        this.f40183b = cVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(String str, c cVar, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : cVar);
    }
}
