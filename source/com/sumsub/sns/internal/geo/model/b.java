package com.sumsub.sns.internal.geo.model;

import com.huobi.vulcan.model.VulcanInfo;
import com.sumsub.sns.internal.geo.presentation.c;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.c0;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.x;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000  2\u00020\u0001:\u0002\b\u0010B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u001aB9\b\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0001\u0010\u000f\u001a\u00020\t\u0012\b\b\u0001\u0010\u0013\u001a\u00020\t\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0014\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0019\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R \u0010\u000f\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR \u0010\u0013\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0011\u0010\fR \u0010\u0018\u001a\u00020\u00148\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u0012\u0004\b\u0017\u0010\u000e\u001a\u0004\b\b\u0010\u0016¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/geo/model/b;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "D", "c", "()D", "getLatitude$annotations", "()V", "latitude", "b", "e", "getLongitude$annotations", "longitude", "", "F", "()F", "getAccuracy$annotations", "accuracy", "<init>", "(DDF)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(IDDFLkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class b {
    public static final C0396b Companion = new C0396b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final double f34715a;

    /* renamed from: b  reason: collision with root package name */
    public final double f34716b;

    /* renamed from: c  reason: collision with root package name */
    public final float f34717c;

    public static final class a implements d0<b> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f34718a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f34719b;

        static {
            a aVar = new a();
            f34718a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.geo.model.Location", aVar, 3);
            pluginGeneratedSerialDescriptor.k(VulcanInfo.LAT, false);
            pluginGeneratedSerialDescriptor.k("lon", false);
            pluginGeneratedSerialDescriptor.k(c.I, false);
            f34719b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public b deserialize(kotlinx.serialization.encoding.c cVar) {
            float f11;
            double d11;
            double d12;
            int i11;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                double F = b11.F(descriptor, 0);
                double F2 = b11.F(descriptor, 1);
                f11 = b11.z(descriptor, 2);
                i11 = 7;
                d11 = F2;
                d12 = F;
            } else {
                float f12 = 0.0f;
                boolean z11 = true;
                double d13 = 0.0d;
                double d14 = 0.0d;
                int i12 = 0;
                while (z11) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        z11 = false;
                    } else if (w11 == 0) {
                        d13 = b11.F(descriptor, 0);
                        i12 |= 1;
                    } else if (w11 == 1) {
                        d14 = b11.F(descriptor, 1);
                        i12 |= 2;
                    } else if (w11 == 2) {
                        f12 = b11.z(descriptor, 2);
                        i12 |= 4;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                f11 = f12;
                i11 = i12;
                d11 = d14;
                d12 = d13;
            }
            b11.c(descriptor);
            return new b(i11, d12, d11, f11, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            x xVar = x.f57784a;
            return new kotlinx.serialization.b[]{xVar, xVar, c0.f57699a};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f34719b;
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

    /* renamed from: com.sumsub.sns.internal.geo.model.b$b  reason: collision with other inner class name */
    public static final class C0396b {
        public /* synthetic */ C0396b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<b> serializer() {
            return a.f34718a;
        }

        public C0396b() {
        }
    }

    public b(double d11, double d12, float f11) {
        this.f34715a = d11;
        this.f34716b = d12;
        this.f34717c = f11;
    }

    public static final void a(b bVar, kotlinx.serialization.encoding.b bVar2, kotlinx.serialization.descriptors.f fVar) {
        bVar2.G(fVar, 0, bVar.f34715a);
        bVar2.G(fVar, 1, bVar.f34716b);
        bVar2.C(fVar, 2, bVar.f34717c);
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public final double c() {
        return this.f34715a;
    }

    public final double e() {
        return this.f34716b;
    }

    public final float a() {
        return this.f34717c;
    }

    public /* synthetic */ b(int i11, double d11, double d12, float f11, q1 q1Var) {
        if (7 != (i11 & 7)) {
            h1.a(i11, 7, a.f34718a.getDescriptor());
        }
        this.f34715a = d11;
        this.f34716b = d12;
        this.f34717c = f11;
    }
}
