package com.sumsub.sns.prooface.data;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0002\b\u0011B\u0007¢\u0006\u0004\b\t\u0010\nB\u001b\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/prooface/data/c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "<init>", "()V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILkotlinx/serialization/internal/q1;)V", "Companion", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class c {
    public static final b Companion = new b((r) null);

    public static final class a implements d0<c> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f40180a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f40181b;

        static {
            a aVar = new a();
            f40180a = aVar;
            f40181b = new PluginGeneratedSerialDescriptor("com.sumsub.sns.prooface.data.FaceMeshPrediction", aVar, 0);
        }

        /* renamed from: a */
        public c deserialize(kotlinx.serialization.encoding.c cVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (!b11.k()) {
                boolean z11 = true;
                while (z11) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        z11 = false;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
            }
            b11.c(descriptor);
            return new c(0, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[0];
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f40181b;
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
            return a.f40180a;
        }

        public b() {
        }
    }

    public c() {
    }

    public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
    }

    public /* synthetic */ c(int i11, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f40180a.getDescriptor());
        }
    }
}
