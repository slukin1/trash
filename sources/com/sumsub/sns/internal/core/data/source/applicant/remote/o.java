package com.sumsub.sns.internal.core.data.source.applicant.remote;

import com.huobi.vulcan.model.VulcanInfo;
import com.sumsub.sns.internal.geo.presentation.c;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.c0;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 %2\u00020\u0001:\u0002\b\nB\u001f\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 B9\b\u0017\u0012\u0006\u0010!\u001a\u00020\u0011\u0012\b\b\u0001\u0010\f\u001a\u00020\t\u0012\b\b\u0001\u0010\r\u001a\u00020\t\u0012\b\b\u0001\u0010\u000e\u001a\u00020\t\u0012\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b\u001f\u0010$J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\b\u001a\u00020\tHÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\tHÆ\u0003J'\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\f\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0016\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R \u0010\r\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0016\u0012\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001b\u0010\u0018R \u0010\u000e\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u0012\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001d\u0010\u0018¨\u0006&"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/o;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "c", "lat", "lon", "accuracy", "", "toString", "", "hashCode", "other", "", "equals", "F", "f", "()F", "getLat$annotations", "()V", "h", "getLon$annotations", "d", "getAccuracy$annotations", "<init>", "(FFF)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(IFFFLkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class o {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final float f33193a;

    /* renamed from: b  reason: collision with root package name */
    public final float f33194b;

    /* renamed from: c  reason: collision with root package name */
    public final float f33195c;

    public static final class a implements d0<o> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33196a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33197b;

        static {
            a aVar = new a();
            f33196a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.Location", aVar, 3);
            pluginGeneratedSerialDescriptor.k(VulcanInfo.LAT, false);
            pluginGeneratedSerialDescriptor.k("lon", false);
            pluginGeneratedSerialDescriptor.k(c.I, false);
            f33197b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public o deserialize(kotlinx.serialization.encoding.c cVar) {
            float f11;
            float f12;
            float f13;
            int i11;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                float z11 = b11.z(descriptor, 0);
                float z12 = b11.z(descriptor, 1);
                f13 = z11;
                f11 = b11.z(descriptor, 2);
                f12 = z12;
                i11 = 7;
            } else {
                float f14 = 0.0f;
                float f15 = 0.0f;
                float f16 = 0.0f;
                int i12 = 0;
                boolean z13 = true;
                while (z13) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        z13 = false;
                    } else if (w11 == 0) {
                        f14 = b11.z(descriptor, 0);
                        i12 |= 1;
                    } else if (w11 == 1) {
                        f16 = b11.z(descriptor, 1);
                        i12 |= 2;
                    } else if (w11 == 2) {
                        f15 = b11.z(descriptor, 2);
                        i12 |= 4;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                f13 = f14;
                f11 = f15;
                f12 = f16;
                i11 = i12;
            }
            b11.c(descriptor);
            return new o(i11, f13, f12, f11, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            c0 c0Var = c0.f57699a;
            return new kotlinx.serialization.b[]{c0Var, c0Var, c0Var};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33197b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, o oVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            o.a(oVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<o> serializer() {
            return a.f33196a;
        }

        public b() {
        }
    }

    public o(float f11, float f12, float f13) {
        this.f33193a = f11;
        this.f33194b = f12;
        this.f33195c = f13;
    }

    public static /* synthetic */ void e() {
    }

    public static /* synthetic */ void g() {
    }

    public static /* synthetic */ void i() {
    }

    public final float a() {
        return this.f33193a;
    }

    public final float b() {
        return this.f33194b;
    }

    public final float c() {
        return this.f33195c;
    }

    public final float d() {
        return this.f33195c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return x.b(Float.valueOf(this.f33193a), Float.valueOf(oVar.f33193a)) && x.b(Float.valueOf(this.f33194b), Float.valueOf(oVar.f33194b)) && x.b(Float.valueOf(this.f33195c), Float.valueOf(oVar.f33195c));
    }

    public final float f() {
        return this.f33193a;
    }

    public final float h() {
        return this.f33194b;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.f33193a) * 31) + Float.floatToIntBits(this.f33194b)) * 31) + Float.floatToIntBits(this.f33195c);
    }

    public String toString() {
        return "Location(lat=" + this.f33193a + ", lon=" + this.f33194b + ", accuracy=" + this.f33195c + ')';
    }

    public final o a(float f11, float f12, float f13) {
        return new o(f11, f12, f13);
    }

    public static /* synthetic */ o a(o oVar, float f11, float f12, float f13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = oVar.f33193a;
        }
        if ((i11 & 2) != 0) {
            f12 = oVar.f33194b;
        }
        if ((i11 & 4) != 0) {
            f13 = oVar.f33195c;
        }
        return oVar.a(f11, f12, f13);
    }

    public static final void a(o oVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        bVar.C(fVar, 0, oVar.f33193a);
        bVar.C(fVar, 1, oVar.f33194b);
        bVar.C(fVar, 2, oVar.f33195c);
    }

    public /* synthetic */ o(int i11, float f11, float f12, float f13, q1 q1Var) {
        if (7 != (i11 & 7)) {
            h1.a(i11, 7, a.f33196a.getDescriptor());
        }
        this.f33193a = f11;
        this.f33194b = f12;
        this.f33195c = f13;
    }
}
