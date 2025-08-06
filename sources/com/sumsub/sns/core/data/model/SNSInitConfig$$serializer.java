package com.sumsub.sns.core.data.model;

import com.facebook.places.model.PlaceFields;
import h10.a;
import kotlin.Metadata;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0019\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0012\u001a\u00020\u000f8VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"com/sumsub/sns/core/data/model/SNSInitConfig.$serializer", "Lkotlinx/serialization/internal/d0;", "Lcom/sumsub/sns/core/data/model/SNSInitConfig;", "", "Lkotlinx/serialization/b;", "childSerializers", "()[Lkotlinx/serialization/b;", "Lkotlinx/serialization/encoding/c;", "decoder", "deserialize", "Lkotlinx/serialization/encoding/d;", "encoder", "value", "", "serialize", "Lkotlinx/serialization/descriptors/f;", "getDescriptor", "()Lkotlinx/serialization/descriptors/f;", "descriptor", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSInitConfig$$serializer implements d0<SNSInitConfig> {
    public static final SNSInitConfig$$serializer INSTANCE;
    public static final /* synthetic */ f descriptor;

    static {
        SNSInitConfig$$serializer sNSInitConfig$$serializer = new SNSInitConfig$$serializer();
        INSTANCE = sNSInitConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.core.data.model.SNSInitConfig", sNSInitConfig$$serializer, 3);
        pluginGeneratedSerialDescriptor.k("email", true);
        pluginGeneratedSerialDescriptor.k(PlaceFields.PHONE, true);
        pluginGeneratedSerialDescriptor.k("strings", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SNSInitConfig$$serializer() {
    }

    public b<?>[] childSerializers() {
        v1 v1Var = v1.f57779a;
        return new b[]{a.u(v1Var), a.u(v1Var), a.u(new r0(v1Var, v1Var))};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sumsub.sns.core.data.model.SNSInitConfig deserialize(kotlinx.serialization.encoding.c r12) {
        /*
            r11 = this;
            kotlinx.serialization.descriptors.f r0 = r11.getDescriptor()
            kotlinx.serialization.encoding.a r12 = r12.b(r0)
            boolean r1 = r12.k()
            r2 = 0
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0028
            kotlinx.serialization.internal.v1 r1 = kotlinx.serialization.internal.v1.f57779a
            java.lang.Object r4 = r12.j(r0, r4, r1, r2)
            java.lang.Object r5 = r12.j(r0, r5, r1, r2)
            kotlinx.serialization.internal.r0 r6 = new kotlinx.serialization.internal.r0
            r6.<init>(r1, r1)
            java.lang.Object r1 = r12.j(r0, r3, r6, r2)
            r2 = 7
            r3 = r2
            goto L_0x0068
        L_0x0028:
            r1 = r2
            r6 = r1
            r7 = r6
            r2 = r4
            r8 = r5
        L_0x002d:
            if (r8 == 0) goto L_0x0064
            int r9 = r12.w(r0)
            r10 = -1
            if (r9 == r10) goto L_0x0062
            if (r9 == 0) goto L_0x0059
            if (r9 == r5) goto L_0x0050
            if (r9 != r3) goto L_0x004a
            kotlinx.serialization.internal.r0 r9 = new kotlinx.serialization.internal.r0
            kotlinx.serialization.internal.v1 r10 = kotlinx.serialization.internal.v1.f57779a
            r9.<init>(r10, r10)
            java.lang.Object r7 = r12.j(r0, r3, r9, r7)
            r2 = r2 | 4
            goto L_0x002d
        L_0x004a:
            kotlinx.serialization.UnknownFieldException r12 = new kotlinx.serialization.UnknownFieldException
            r12.<init>((int) r9)
            throw r12
        L_0x0050:
            kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
            java.lang.Object r6 = r12.j(r0, r5, r9, r6)
            r2 = r2 | 2
            goto L_0x002d
        L_0x0059:
            kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
            java.lang.Object r1 = r12.j(r0, r4, r9, r1)
            r2 = r2 | 1
            goto L_0x002d
        L_0x0062:
            r8 = r4
            goto L_0x002d
        L_0x0064:
            r4 = r1
            r3 = r2
            r5 = r6
            r1 = r7
        L_0x0068:
            r12.c(r0)
            com.sumsub.sns.core.data.model.SNSInitConfig r12 = new com.sumsub.sns.core.data.model.SNSInitConfig
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = (java.lang.String) r5
            r6 = r1
            java.util.Map r6 = (java.util.Map) r6
            r7 = 0
            r2 = r12
            r2.<init>((int) r3, (java.lang.String) r4, (java.lang.String) r5, (java.util.Map) r6, (kotlinx.serialization.internal.q1) r7)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.model.SNSInitConfig$$serializer.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.core.data.model.SNSInitConfig");
    }

    public f getDescriptor() {
        return descriptor;
    }

    public void serialize(d dVar, SNSInitConfig sNSInitConfig) {
        f descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.b b11 = dVar.b(descriptor2);
        SNSInitConfig.write$Self(sNSInitConfig, b11, descriptor2);
        b11.c(descriptor2);
    }

    public b<?>[] typeParametersSerializers() {
        return d0.a.a(this);
    }
}
