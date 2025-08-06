package com.sumsub.sns.internal.core.data.source.applicant.remote;

import com.sumsub.sns.internal.core.data.source.applicant.remote.EKycFlowStatus;
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

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\b\u0013B\u0013\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0017\u0010\u0018B'\b\u0017\u0012\u0006\u0010\u0019\u001a\u00020\r\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0017\u0010\u001cJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/d0;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/EKycFlowStatus;", "status", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/EKycFlowStatus;", "b", "()Lcom/sumsub/sns/internal/core/data/source/applicant/remote/EKycFlowStatus;", "getStatus$annotations", "()V", "<init>", "(Lcom/sumsub/sns/internal/core/data/source/applicant/remote/EKycFlowStatus;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/source/applicant/remote/EKycFlowStatus;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class d0 {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final EKycFlowStatus f33131a;

    public static final class a implements kotlinx.serialization.internal.d0<d0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33132a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33133b;

        static {
            a aVar = new a();
            f33132a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.SkipEKycResponse", aVar, 1);
            pluginGeneratedSerialDescriptor.k("status", true);
            f33133b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public d0 deserialize(c cVar) {
            Object obj;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            int i11 = 1;
            if (b11.k()) {
                obj = b11.j(descriptor, 0, EKycFlowStatus.a.f33045a, null);
            } else {
                obj = null;
                int i12 = 0;
                while (i11 != 0) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        i11 = 0;
                    } else if (w11 == 0) {
                        obj = b11.j(descriptor, 0, EKycFlowStatus.a.f33045a, obj);
                        i12 |= 1;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                i11 = i12;
            }
            b11.c(descriptor);
            return new d0(i11, (EKycFlowStatus) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{h10.a.u(EKycFlowStatus.a.f33045a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33133b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, d0 d0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            d0.a(d0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<d0> serializer() {
            return a.f33132a;
        }

        public b() {
        }
    }

    public d0() {
        this((EKycFlowStatus) null, 1, (r) null);
    }

    public static /* synthetic */ void c() {
    }

    public final EKycFlowStatus a() {
        return this.f33131a;
    }

    public final EKycFlowStatus b() {
        return this.f33131a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d0) && this.f33131a == ((d0) obj).f33131a;
    }

    public int hashCode() {
        EKycFlowStatus eKycFlowStatus = this.f33131a;
        if (eKycFlowStatus == null) {
            return 0;
        }
        return eKycFlowStatus.hashCode();
    }

    public String toString() {
        return "SkipEKycResponse(status=" + this.f33131a + ')';
    }

    public /* synthetic */ d0(int i11, EKycFlowStatus eKycFlowStatus, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33132a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33131a = null;
        } else {
            this.f33131a = eKycFlowStatus;
        }
    }

    public final d0 a(EKycFlowStatus eKycFlowStatus) {
        return new d0(eKycFlowStatus);
    }

    public d0(EKycFlowStatus eKycFlowStatus) {
        this.f33131a = eKycFlowStatus;
    }

    public static /* synthetic */ d0 a(d0 d0Var, EKycFlowStatus eKycFlowStatus, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            eKycFlowStatus = d0Var.f33131a;
        }
        return d0Var.a(eKycFlowStatus);
    }

    public static final void a(d0 d0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        if (bVar.q(fVar, 0) || d0Var.f33131a != null) {
            bVar.y(fVar, 0, EKycFlowStatus.a.f33045a, d0Var.f33131a);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d0(EKycFlowStatus eKycFlowStatus, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : eKycFlowStatus);
    }
}
